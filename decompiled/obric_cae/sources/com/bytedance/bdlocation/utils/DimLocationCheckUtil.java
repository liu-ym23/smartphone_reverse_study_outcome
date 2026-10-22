package com.bytedance.bdlocation.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Parcel;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.qualcomm.qti.qesdk.QesdkUtils;
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
            public boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
                if (r8 != 1) goto L11;
                r10.enforceInterface("com.android.internal.app.IMessenger");     // Catch: Exception -> L14
                if (r10.readInt() == 0) goto L7;
                Message r13 = (Message) Message.CREATOR.createFromParcel(r10);     // Catch: Exception -> L14
            L8:
                handleMessage(r13);     // Catch: Exception -> L14
                return true;
            L7:
                r13 = null;
                goto L8
            L11:
                if (r8 != 1598968902) goto L13;
                r11.writeString("com.android.internal.app.IMessenger");     // Catch: Exception -> L14
            L19:
                return true;
            L13:
                return super.onTransact(r8, r10, r11, r12);
            L14:
                e = move-exception;
                Logger.e("onTransact error:" + e.toString());
                goto L19
            }
        }

        void handleMessage(Message r8);
    }

    public DimLocationCheckUtil() {
    }

    public static /* synthetic */ int access$000() {
        return sDimLocationState;
    }

    public static void dimLocationCheckMonitorUpload(String r8, int r10, long r11, Throwable r12) {
        LocationMonitor.dimLocationCheckMonitor(r8, r10, System.currentTimeMillis() - r11, r12);
    }

    public static int getDimLocationState() {
        return sDimLocationState;
    }

    public static void setDimLocationState(int r8) {
        sDimLocationState = r8;
    }

    public static void startGetVivoDimLocation(Context r12) {
        if (r12 != null) goto L6;
        Logger.i("startGetVivoDimLocation context = null");
        return;
    L6:
        if (LocationUtil.isTargetBrand(VIVO) == true) goto L9;
        Logger.i("startGetVivoDimLocation isTargetBrand:false");
        return;
    L9:
        long r8 = System.currentTimeMillis();
        Cursor r13 = r12.getContentResolver().query(Uri.parse("content://com.vivo.permissionmanager.provider.permission/fuzzy_location_apps"), new String[]{"package_name", "selected_fuzzy"}, "package_name=?", new String[]{r12.getPackageName()}, null);     // Catch: Exception -> L24
        if (r13 != null) goto L15;
        Logger.i("startGetVivoDimLocation cursor = null");     // Catch: Exception -> L24
        setDimLocationState(-1);     // Catch: Exception -> L24
        dimLocationCheckMonitorUpload(VIVO, -1, r8, null);     // Catch: Exception -> L24
        return;
    L15:
        if (r13.moveToNext() == false) goto L22;
        if (r13.getString(0) == null) goto L15;
        if (r13.getInt(1) != 1) goto L15;
        Logger.i("startGetVivoDimLocation true");     // Catch: Exception -> L24
        setDimLocationState(1);     // Catch: Exception -> L24
        dimLocationCheckMonitorUpload(VIVO, 1, r8, null);     // Catch: Exception -> L24
        return;
    L22:
        Logger.i("startGetVivoDimLocation false");
        setDimLocationState(0);
        dimLocationCheckMonitorUpload(VIVO, 0, r8, null);
        return;
    L24:
        e = move-exception;
        Logger.e("startGetVivoDimLocation error:" + e.toString());
        setDimLocationState(-1);
        dimLocationCheckMonitorUpload(VIVO, -1, r8, e);
    }

    public static void startGetXiaomiDimLocation(Context r12) {
        if (r12 != null) goto L8;
        String r13 = "startGetXiaomiDimLocation context = null";
    L5:
        Logger.i(r13);
        return;
    L8:
        if (LocationUtil.isTargetBrand(XIAOMI) == true) goto L10;
        r13 = "startGetXiaomiDimLocation isTargetBrand:false";
        goto L5
    L10:
        final long r8 = System.currentTimeMillis();
        Class<?> r10 = Class.forName("android.os.SystemProperties");     // Catch: Exception -> L21
        if (((Integer) r10.getDeclaredMethod("getInt", new Class[]{String.class, Integer.TYPE}).invoke(r10, new Object[]{"ro.miui.ui.version.code", 0})).intValue() >= 11) goto L15;
        setDimLocationState(-4);     // Catch: Exception -> L21
        dimLocationCheckMonitorUpload(XIAOMI, -4, r8, null);     // Catch: Exception -> L21
        return;
    L15:
        ContentResolver r14 = r12.getContentResolver();     // Catch: Exception -> L21
        Uri r11 = Uri.parse("content://com.lbe.security.miui.autostartmgr");     // Catch: Exception -> L21
        Bundle r15 = new Bundle();     // Catch: Exception -> L21
        final CountDownLatch r16 = new CountDownLatch(1);     // Catch: Exception -> L21
        r15.putBinder(QesdkUtils.TAGS.JSON_TAG_CALLBACK, new AnonymousClass1(r16, r8).asBinder());     // Catch: Exception -> L21
        r14.call(r11, "queryLocationState", null, r15);     // Catch: Exception -> L21
        r16.await(2000, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L18 Exception -> L21
    L27:
        return;
    L18:
        e = move-exception;
        Logger.e("startGetXiaomiDimLocation InterruptedException:" + e.toString());     // Catch: Exception -> L21
        setDimLocationState(-1);     // Catch: Exception -> L21
        dimLocationCheckMonitorUpload(XIAOMI, -1, r8, e);     // Catch: Exception -> L21
        return;
    L21:
        e = move-exception;
        Logger.e("startGetXiaomiDimLocation Exception:" + e.toString());
        setDimLocationState(-1);
        dimLocationCheckMonitorUpload(XIAOMI, -1, r8, e);
    }
}
