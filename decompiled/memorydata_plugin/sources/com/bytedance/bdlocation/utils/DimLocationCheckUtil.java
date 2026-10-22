package com.bytedance.bdlocation.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Parcel;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class DimLocationCheckUtil {
    public static final int STATE_INIT = -5;
    public static final int STATE_NOT_ALLOWED_NETWORK = -3;
    public static final int STATE_OFF = 0;
    public static final int STATE_ON = 1;
    public static final int STATE_TYPE_FAILED = -1;
    public static final int STATE_TYPE_NO_NETWORK = -2;
    public static final int STATE_UNSUPPORTED = -4;
    public static final String VIVO = "vivo";
    public static final String XIAOMI = "xiaomi";
    private static volatile int sDimLocationState = -5;

    public interface IMessenger extends IInterface {

        public static abstract class Stub extends Binder implements IMessenger {
            public Stub() {
                attachInterface(this, "com.android.internal.app.IMessenger");
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this;
            }

            @Override // android.os.Binder
            public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
                if (r4 != 1) goto L11;
                r5.enforceInterface("com.android.internal.app.IMessenger");     // Catch: Exception -> L14
                if (r5.readInt() == 0) goto L7;
                Message r8 = (Message) ZeusTransformUtils.preCheckCast(Message.CREATOR.createFromParcel(r5), Message.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L14
            L8:
                handleMessage(r8);     // Catch: Exception -> L14
                return true;
            L7:
                r8 = null;
                goto L8
            L11:
                if (r4 != 1598968902) goto L13;
                r6.writeString("com.android.internal.app.IMessenger");     // Catch: Exception -> L14
            L19:
                return true;
            L13:
                return super.onTransact(r4, r5, r6, r7);
            L14:
                e = move-exception;
                Logger.e("onTransact error:" + e.toString());
                goto L19
            }
        }

        void handleMessage(Message r1);
    }

    static {
    }

    public DimLocationCheckUtil() {
    }

    static /* synthetic */ int access$000() {
        return sDimLocationState;
    }

    public static void dimLocationCheckMonitorUpload(String r2, int r3, long r4, Throwable r6) {
        LocationMonitor.dimLocationCheckMonitor(r2, r3, System.currentTimeMillis() - r4, r6);
    }

    public static int getDimLocationState() {
        return sDimLocationState;
    }

    public static void setDimLocationState(int r0) {
        sDimLocationState = r0;
    }

    public static void startGetVivoDimLocation(Context r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.memorydata.plugin");
        if (r14 != null) goto L7;
        Logger.i("startGetVivoDimLocation context = null");
        return;
    L7:
        if (LocationUtil.isTargetBrand(VIVO) == true) goto L10;
        Logger.i("startGetVivoDimLocation isTargetBrand:false");
        return;
    L10:
        long r1 = System.currentTimeMillis();
        Cursor r15 = ZeusProviderTransform.query(r14.getContentResolver(), Uri.parse("content://com.vivo.permissionmanager.provider.permission/fuzzy_location_apps"), new String[]{"package_name", "selected_fuzzy"}, "package_name=?", new String[]{r14.getPackageName()}, null, "com.obric.memorydata.plugin");     // Catch: Exception -> L25
        if (r15 != null) goto L16;
        Logger.i("startGetVivoDimLocation cursor = null");     // Catch: Exception -> L25
        setDimLocationState(-1);     // Catch: Exception -> L25
        dimLocationCheckMonitorUpload(VIVO, -1, r1, null);     // Catch: Exception -> L25
        return;
    L16:
        if (r15.moveToNext() == false) goto L23;
        if (r15.getString(0) == null) goto L16;
        if (r15.getInt(1) != 1) goto L16;
        Logger.i("startGetVivoDimLocation true");     // Catch: Exception -> L25
        setDimLocationState(1);     // Catch: Exception -> L25
        dimLocationCheckMonitorUpload(VIVO, 1, r1, null);     // Catch: Exception -> L25
        return;
    L23:
        Logger.i("startGetVivoDimLocation false");
        setDimLocationState(0);
        dimLocationCheckMonitorUpload(VIVO, 0, r1, null);
        return;
    L25:
        e = move-exception;
        Logger.e("startGetVivoDimLocation error:" + e.toString());
        setDimLocationState(-1);
        dimLocationCheckMonitorUpload(VIVO, -1, r1, e);
    }

    public static void startGetXiaomiDimLocation(Context r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L8;
        String r14 = "startGetXiaomiDimLocation context = null";
    L5:
        Logger.i(r14);
        return;
    L8:
        if (LocationUtil.isTargetBrand(XIAOMI) == true) goto L10;
        r14 = "startGetXiaomiDimLocation isTargetBrand:false";
        goto L5
    L10:
        final long r2 = System.currentTimeMillis();
        Class r5 = ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.memorydata.plugin");     // Catch: Exception -> L24
        if (((Integer) ZeusTransformUtils.preCheckCast(r5.getDeclaredMethod("getInt", new Class[]{String.class, Integer.TYPE}).invoke(r5, new Object[]{"ro.miui.ui.version.code", 0}), Integer.class, "com.obric.memorydata.plugin")).intValue() >= 11) goto L15;
        setDimLocationState(-4);     // Catch: Exception -> L24
        dimLocationCheckMonitorUpload(XIAOMI, -4, r2, null);     // Catch: Exception -> L24
        return;
    L15:
        ContentResolver r6 = r13.getContentResolver();     // Catch: Exception -> L24
        Uri r7 = Uri.parse("content://com.lbe.security.miui.autostartmgr");     // Catch: Exception -> L24
        Bundle r9 = new Bundle();     // Catch: Exception -> L24
        if (Build.VERSION.SDK_INT < 18) goto L30;
        final CountDownLatch r15 = new CountDownLatch(1);     // Catch: Exception -> L24
        r9.putBinder("callback", new AnonymousClass1(r15, r2).asBinder());     // Catch: Exception -> L24
        ZeusProviderTransform.call(r6, r7, "queryLocationState", (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin"), r9, "com.obric.memorydata.plugin");     // Catch: Exception -> L24
        r15.await(2000, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L21 Exception -> L24
    L31:
        return;
    L21:
        e = move-exception;
        Logger.e("startGetXiaomiDimLocation InterruptedException:" + e.toString());     // Catch: Exception -> L24
        setDimLocationState(-1);     // Catch: Exception -> L24
        dimLocationCheckMonitorUpload(XIAOMI, -1, r2, e);     // Catch: Exception -> L24
        return;
    L30:
        return;
    L24:
        e = move-exception;
        Logger.e("startGetXiaomiDimLocation Exception:" + e.toString());
        setDimLocationState(-1);
        dimLocationCheckMonitorUpload(XIAOMI, -1, r2, e);
    }
}
