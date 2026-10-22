package com.obric.cae.location.cloud;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import com.obric.cae.libs.cloud.ICloud;
import com.obric.cae.libs.cloud.ICloudEventCallback;
import com.obric.cae.location.util.LocationUtil;
import com.obric.cae.location.zpp.StarZppManager;
import com.obric.cae.log.CaeLog;
import defpackage.b;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class StarLocationCloudBinderClient {
    private static final int BIND_RETRY_INTERVAL_MS = 2000;
    private static final String TAG = "StarLocation-cloud";
    private static ICloud sService;
    private CaeCloudEventCallbackWrapper mCallbackWrapper;
    private final ServiceConnection mConnection;
    private final Context mContext;
    private final ServiceDeathRecipient mDeathRecipient;
    private final Handler mHandler;
    private final ReentrantReadWriteLock mServiceLock;

    public class CaeCloudEventCallbackWrapper extends ICloudEventCallback.Stub {
        final /* synthetic */ StarLocationCloudBinderClient this$0;

        private CaeCloudEventCallbackWrapper(StarLocationCloudBinderClient r8) {
            this.this$0 = r8;
        }

        public void addRegistration() {
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (StarLocationCloudBinderClient.access$200() != null) goto L15;
        L10:
            monitor-exit(this);     // Catch: Throwable -> L12
            return;
        L15:
            StarLocationCloudBinderClient.access$200().registerCallbackWithType(5, this);     // Catch: RemoteException -> L8 Throwable -> L12
        L8:
            e = move-exception;
            CaeLog.e(StarLocationCloudBinderClient.TAG, "addRegistration failed: 5" + e);     // Catch: Throwable -> L12
            goto L10
        }

        @Override // com.obric.cae.libs.cloud.ICloudEventCallback
        public void onCloudDataChange(String r8) {
            b.o("onCloudDataChange: ", r8, StarLocationCloudBinderClient.TAG);
            StarLocationCloudBinderClient.access$600(this.this$0, r8);
        }

        @Override // com.obric.cae.libs.cloud.ICloudEventCallback
        public void onPostStateChange(int r8, String r10, String r11) {
        }

        public void removeRegistration() {
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (StarLocationCloudBinderClient.access$200() != null) goto L15;
        L10:
            monitor-exit(this);     // Catch: Throwable -> L12
            return;
        L15:
            StarLocationCloudBinderClient.access$200().unregisterCallback(this);     // Catch: RemoteException -> L8 Throwable -> L12
        L8:
            e = move-exception;
            CaeLog.e(StarLocationCloudBinderClient.TAG, "" + e);     // Catch: Throwable -> L12
            goto L10
        }

        public /* synthetic */ CaeCloudEventCallbackWrapper(StarLocationCloudBinderClient r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public class ServiceDeathRecipient implements IBinder.DeathRecipient {
        final /* synthetic */ StarLocationCloudBinderClient this$0;

        private ServiceDeathRecipient(StarLocationCloudBinderClient r8) {
            this.this$0 = r8;
        }

        public static /* synthetic */ void a(StarLocationCloudBinderClient r8) {
            lambda$binderDied$0(r8);
        }

        private static /* synthetic */ void lambda$binderDied$0(StarLocationCloudBinderClient r8) {
            StarLocationCloudBinderClient.access$800(r8);
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            CaeLog.e(StarLocationCloudBinderClient.TAG, "cae cloud service is dead !!!");
            StarLocationCloudBinderClient.access$100(this.this$0).writeLock().lock();
            StarLocationCloudBinderClient.access$202(null);
            Handler r8 = StarLocationCloudBinderClient.access$700(this.this$0);
            final StarLocationCloudBinderClient r10 = this.this$0;
            r8.postDelayed(new a(r10), 2000);
            StarLocationCloudBinderClient.access$100(this.this$0).writeLock().unlock();
        }

        public /* synthetic */ ServiceDeathRecipient(StarLocationCloudBinderClient r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public StarLocationCloudBinderClient(Context r8) {
        this.mServiceLock = new ReentrantReadWriteLock();
        this.mConnection = new AnonymousClass1(this);
        this.mContext = r8;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mDeathRecipient = new ServiceDeathRecipient(this, null);
        doBind();
    }

    public static /* synthetic */ ReentrantReadWriteLock access$100(StarLocationCloudBinderClient r8) {
        return r8.mServiceLock;
    }

    public static /* synthetic */ ICloud access$200() {
        return sService;
    }

    public static /* synthetic */ ICloud access$202(ICloud r8) {
        sService = r8;
        return r8;
    }

    public static /* synthetic */ ServiceDeathRecipient access$300(StarLocationCloudBinderClient r8) {
        return r8.mDeathRecipient;
    }

    public static /* synthetic */ CaeCloudEventCallbackWrapper access$400(StarLocationCloudBinderClient r8) {
        return r8.mCallbackWrapper;
    }

    public static /* synthetic */ CaeCloudEventCallbackWrapper access$402(StarLocationCloudBinderClient r8, CaeCloudEventCallbackWrapper r10) {
        r8.mCallbackWrapper = r10;
        return r10;
    }

    public static /* synthetic */ void access$600(StarLocationCloudBinderClient r8, String r10) {
        r8.handleDataChange(r10);
    }

    public static /* synthetic */ Handler access$700(StarLocationCloudBinderClient r8) {
        return r8.mHandler;
    }

    public static /* synthetic */ void access$800(StarLocationCloudBinderClient r8) {
        r8.attemptDeadServiceRecovery();
    }

    private void attemptDeadServiceRecovery() {
        CaeLog.d(TAG, "Attempting to recover dead cloud service...");
        doBind();
    }

    @SuppressLint({"QueryPermissionsNeeded"})
    private void doBind() {
        ServiceConnection r8 = this.mConnection;
        monitor-enter(r8);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (sService != null) goto L16;
        CaeLog.d(TAG, "Binding cae cloud service...");     // Catch: Throwable -> L18
        Intent r10 = new Intent(ICloud.class.getName());     // Catch: Throwable -> L18
        ResolveInfo r11 = this.mContext.getPackageManager().resolveService(r10, 0);     // Catch: Throwable -> L18
        if (r11 == null) goto L9;
        ServiceInfo r12 = r11.serviceInfo;     // Catch: Throwable -> L18
        ComponentName r13 = new ComponentName(r12.packageName, r12.name);     // Catch: Throwable -> L18
    L10:
        r10.setComponent(r13);     // Catch: Throwable -> L18
        if (r13 != null) goto L13;
    L14:
        CaeLog.e(TAG, "Fail to bind to: " + r10);     // Catch: Throwable -> L18
    L15:
        CaeLog.i(TAG, "Bind cae cloud service success");     // Catch: Throwable -> L18
        goto L16
    L13:
        if (this.mContext.bindService(r10, this.mConnection, 65) == true) goto L15;
    L9:
        r13 = null;
    L16:
        monitor-exit(r8);     // Catch: Throwable -> L18
    }

    private void doUnbind() {
        ServiceConnection r8 = this.mConnection;
        monitor-enter(r8);
        CaeLog.d(TAG, "Unbinding cae cloud service...");     // Catch: Throwable -> L13
        if (sService == null) goto L7;
        this.mContext.unbindService(this.mConnection);     // Catch: Throwable -> L13
    L7:
        CaeCloudEventCallbackWrapper r10 = this.mCallbackWrapper;     // Catch: Throwable -> L13
        if (r10 == null) goto L10;
        r10.removeRegistration();     // Catch: Throwable -> L13
        this.mCallbackWrapper = null;     // Catch: Throwable -> L13
    L10:
        this.mServiceLock.writeLock().lock();     // Catch: Throwable -> L13
        this.mServiceLock.writeLock().unlock();     // Catch: Throwable -> L13
        monitor-exit(r8);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private void handleDataChange(String r8) {
        JSONObject r10 = new JSONObject(r8);     // Catch: JSONException -> L23
        if (r10.has(StarZppManager.ZPP_CLOUD_ENABLE) == false) goto L9;
        String r11 = r10.optString(StarZppManager.ZPP_CLOUD_ENABLE);     // Catch: JSONException -> L23
        if (TextUtils.isEmpty(r11) == true) goto L9;
        Settings.Global.putString(this.mContext.getContentResolver(), StarZppManager.ZPP_CLOUD_ENABLE, r11);     // Catch: JSONException -> L23
    L9:
        if (r10.has(StarZppManager.ZPP_MODEL_INFER_STRATEGY) == false) goto L16;
        String r12 = r10.optString(StarZppManager.ZPP_MODEL_INFER_STRATEGY);     // Catch: JSONException -> L23
        if (TextUtils.isEmpty(r12) == true) goto L16;
        Settings.Global.putInt(this.mContext.getContentResolver(), StarZppManager.ZPP_MODEL_INFER_STRATEGY, Integer.parseInt(r12));     // Catch: NumberFormatException -> L14 JSONException -> L23
    L14:
        CaeLog.e(TAG, "ZPP_MODEL_INFER_STRATEGY  format error");     // Catch: JSONException -> L23
    L16:
        if (r10.has(LocationUtil.DISABLE_NLP_WIFI_CACHE_ALWAYS) == false) goto L32;
        String r13 = r10.optString(LocationUtil.DISABLE_NLP_WIFI_CACHE_ALWAYS);     // Catch: JSONException -> L23
        if (TextUtils.isEmpty(r13) == true) goto L33;
        Settings.Global.putInt(this.mContext.getContentResolver(), LocationUtil.DISABLE_NLP_WIFI_CACHE_ALWAYS, Integer.parseInt(r13));     // Catch: NumberFormatException -> L21 JSONException -> L23
    L34:
        return;
    L21:
        CaeLog.e(TAG, "disable_nlp_wifi_cache_always format error");     // Catch: JSONException -> L23
        return;
    L33:
        return;
    L32:
        return;
    L23:
        e = move-exception;
        CaeLog.e(TAG, "handleDataChange: " + e);
    }

    public void close() {
        CaeLog.d(TAG, "close");
        CaeCloudEventCallbackWrapper r8 = this.mCallbackWrapper;
        if (r8 == null) goto L5;
        r8.removeRegistration();
        this.mCallbackWrapper = null;
    L5:
        doUnbind();
    }
}
