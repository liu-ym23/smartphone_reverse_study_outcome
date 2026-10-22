package com.bytedance.badger.collect.impl.helper;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.bytedance.badger.collect.impl.vendor.xiaomi.IMiSafetyDetectCallback;
import com.bytedance.badger.collect.impl.vendor.xiaomi.IMiSafetyDetectServer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MiDetectHelper {
    public static final String DOUYIN_APP_ID = "2882303761517509924";
    public static final String DOUYIN_APP_KEY = "5571750917924";
    private static final long SERVICE_WAIT_TIMEOUT = 8000;
    private static final String TAG = "MiDetectHelper# ";
    private static final Set<Map.Entry<DetectCallback, IMiSafetyDetectCallback.Stub>> mAidlCallbackRef = null;
    private static String mAppId = "";
    private static String mAppKey = "";
    private static Throwable mBindServiceError;
    private static volatile boolean mBinding;
    private static volatile boolean mBound;
    private static Context mContext;
    private static volatile IMiSafetyDetectServer mSafetyDetectServer;
    private static final ServiceConnection mSafetyServiceConn = null;
    private static final Object serviceBindLock = null;

    /* JADX INFO: renamed from: com.bytedance.badger.collect.impl.helper.MiDetectHelper$1, reason: invalid class name */
    public static class AnonymousClass1 implements ServiceConnection {
        public AnonymousClass1() {
        }

        private void handleBinderDied() {
            MiDetectHelper.access$202(false);
            MiDetectHelper.access$302(false);
            MiDetectHelper.access$002(null);
        }

        public static /* synthetic */ void access$100(AnonymousClass1 r0) {
            r0.handleBinderDied();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r2) {
            MiDetectHelper.access$202(false);
            MiDetectHelper.access$302(false);
            MiDetectHelper.access$002(null);
            Object r3 = MiDetectHelper.access$400();
            monitor-enter(r3);
            MiDetectHelper.access$400().notifyAll();     // Catch: Throwable -> L7
            monitor-exit(r3);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r2, final IBinder r3) {
            ThreadMethodProxy.start(new PthreadThreadV2(new RunnableC02241(this, r3), "MiDetectHelper$1"));
        }
    }

    public static class BindServiceException extends RuntimeException {
        public BindServiceException(String r1) {
            super(r1);
        }

        public BindServiceException(String r1, Throwable r2) {
            super(r1, r2);
        }
    }

    public interface DetectCallback {
        void onFailure(Throwable r1);

        void onResult(String r1, int r2);
    }

    public MiDetectHelper() {
    }

    static {
        serviceBindLock = new Object();
        mBinding = false;
        mBound = false;
        mSafetyDetectServer = null;
        mSafetyServiceConn = new AnonymousClass1();
        mAidlCallbackRef = Collections.newSetFromMap(new ConcurrentHashMap());
    }

    private static JSONObject getCommonParamsJson() {
        JSONObject r0 = new JSONObject();
        r0.put("PACKAGE_NAME", mContext.getPackageName());     // Catch: JSONException -> L5
        r0.put("APP_KEY", mAppKey);     // Catch: JSONException -> L5
        r0.put("APP_ID", mAppId);     // Catch: JSONException -> L5
    L4:
        return r0;
    }

    private static String getCommonParams() {
        return getCommonParamsJson().toString();
    }

    public static /* synthetic */ IMiSafetyDetectServer access$000() {
        return mSafetyDetectServer;
    }

    public static /* synthetic */ Object access$400() {
        return serviceBindLock;
    }

    public static /* synthetic */ Set access$500() {
        return mAidlCallbackRef;
    }

    public static /* synthetic */ IMiSafetyDetectServer access$002(IMiSafetyDetectServer r0) {
        mSafetyDetectServer = r0;
        return r0;
    }

    public static /* synthetic */ boolean access$202(boolean r0) {
        mBound = r0;
        return r0;
    }

    public static /* synthetic */ boolean access$302(boolean r0) {
        mBinding = r0;
        return r0;
    }

    public static IMiSafetyDetectCallback.Stub asAidlCallback(final DetectCallback r3) {
        IMiSafetyDetectCallback.Stub r0 = new AnonymousClass2(r3);
        mAidlCallbackRef.add(new AbstractMap.SimpleImmutableEntry(r3, r0));
        return r0;
    }

    private static boolean bindMiSafetyService(Context r3) {
        if (mBound == false) goto L13;
        return true;
    L13:
        mBinding = true;     // Catch: Exception -> L10
        Intent r0 = new Intent("com.xiaomi.security.xsof.SAFETY_DETECT_SERVICE");     // Catch: Exception -> L10
        r0.setPackage("com.miui.securitycenter");     // Catch: Exception -> L10
        mBound = r3.bindService(r0, mSafetyServiceConn, 1);     // Catch: Exception -> L10
        if (mBound == false) goto L9;
        return true;
    L9:
        throw new BindServiceException("bind service failed");     // Catch: Exception -> L10
    L10:
        e = move-exception;
        mBinding = false;
        mBindServiceError = e;
        mBound = false;
        mSafetyDetectServer = null;
        return false;
    }

    public static void getRiskApps(DetectCallback r3) {
        if (mContext != null) goto L6;
        return;
    L6:
        if (waitForBindService(r3) == true) goto L9;
        return;
    L9:
        if (mSafetyDetectServer != null) goto L16;
        r3.onFailure(new BindServiceException("service is null", mBindServiceError));
        return;
    L16:
        mSafetyDetectServer.getRiskAppList(getCommonParams(), asAidlCallback(r3));     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        r3.onFailure(th);
    }

    public static int getSafetyDetectServerVersion(Context r4) {
        Bundle r5 = r4.getPackageManager().getPackageInfo("com.miui.securitycenter", 128).applicationInfo.metaData;     // Catch: Exception -> L10
        if (r5 == null) goto L9;
        if (r5.containsKey("com.xiaomi.security.xsof.service.version") == false) goto L9;
        return r5.getInt("com.xiaomi.security.xsof.service.version");
    L9:
        return 0;
    }

    public static void release(Context r0) {
        unbindMiSafetyService(r0);
    }

    private static void unbindMiSafetyService(Context r1) {
        if (mBound == false) goto L10;
        r1.unbindService(mSafetyServiceConn);     // Catch: Exception -> L7
    L5:
        mBound = false;
        return;
    }

    private static boolean waitForBindService(DetectCallback r5) {
        if (mBinding == false) goto L19;
        Object r0 = serviceBindLock;
        monitor-enter(r0);
        r0.wait(SERVICE_WAIT_TIMEOUT);     // Catch: Throwable -> L10 InterruptedException -> L12
        monitor-exit(r0);     // Catch: Throwable -> L10
        goto L19
    L12:
        e = move-exception;
        ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L10
        r5.onFailure(new BindServiceException("wait for bind service interrupted", e));     // Catch: Throwable -> L10
        return false;
    L10:
        th = move-exception;
        throw th;
    L19:
        if (mBound == true) goto L22;
        r5.onFailure(new BindServiceException("bind service failed after timeout", mBindServiceError));
        return false;
    L22:
        return true;
    }

    public static void getSimulatedTouchDetectResult(long r3, DetectCallback r5) {
        if (waitForBindService(r5) == true) goto L6;
        return;
    L6:
        if (mSafetyDetectServer != null) goto L13;
        r5.onFailure(new BindServiceException("service is null", mBindServiceError));
        return;
    L13:
        mSafetyDetectServer.getSimulatedTouchResult(getCommonParams(), r3, asAidlCallback(r5));     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        r5.onFailure(th);
    }

    public static void getTrustDeviceStatus(String r1, DetectCallback r2) {
        getTrustDeviceStatus(2, r1, r2);
    }

    public static void getTrustDeviceStatus(int r3, String r4, DetectCallback r5) {
        if (mContext != null) goto L6;
        return;
    L6:
        if (waitForBindService(r5) == true) goto L8;
        return;
    L8:
        String r0 = getCommonParams();
        if (mSafetyDetectServer != null) goto L16;
        r5.onFailure(new BindServiceException("service is null", mBindServiceError));
        return;
    L16:
        mSafetyDetectServer.getTrustDeviceStatusInfo(r0, r4, r3, asAidlCallback(r5));     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        r5.onFailure(th);
    }

    public static synchronized boolean init(Context r2, String r3, String r4) {
        monitor-enter(MiDetectHelper.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (mContext != null) goto L8;
        mContext = r2.getApplicationContext();     // Catch: Throwable -> L16
    L8:
        if (TextUtils.isEmpty(mAppId) == false) goto L11;
        mAppId = r3;     // Catch: Throwable -> L16
    L11:
        if (TextUtils.isEmpty(mAppKey) == false) goto L13;
        mAppKey = r4;     // Catch: Throwable -> L16
    L13:
        boolean r5 = bindMiSafetyService(mContext);     // Catch: Throwable -> L16
        monitor-exit(MiDetectHelper.class);
        return r5;
    }
}
