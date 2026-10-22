package com.ttnet.org.chromium.base.compat;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.hardware.biometrics.BiometricManager;
import android.net.NetworkCapabilities;
import android.net.TransportInfo;
import android.net.Uri;
import android.os.FileUtils;
import android.os.PowerManager;
import android.provider.MediaStore;
import android.telephony.CellInfo;
import android.telephony.TelephonyManager;
import android.view.MotionEvent;
import com.ttnet.org.chromium.base.Callback;
import com.ttnet.org.chromium.base.task.AsyncTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes6.dex */
public final class ApiHelperForQ {
    private ApiHelperForQ() {
    }

    public static boolean bindIsolatedService(Context r8, Intent r9, int r10, String r11, Executor r12, ServiceConnection r13) {
        return ((Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin")).bindIsolatedService(r9, r10, r11, (Executor) ZeusTransformUtils.wrapperContextForParams(r12, Executor.class, "com.obric.memorydata.plugin"), (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r13, ServiceConnection.class, "com.obric.memorydata.plugin"));
    }

    public static int canAuthenticate(BiometricManager r0) {
        return r0.canAuthenticate();
    }

    public static long copy(InputStream r0, OutputStream r1) {
        return FileUtils.copy(r0, r1);
    }

    public static BiometricManager getBiometricManagerSystemService(Context r2) {
        return (BiometricManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSystemService(BiometricManager.class), BiometricManager.class, "com.obric.memorydata.plugin");
    }

    public static int getClassification(MotionEvent r0) {
        return r0.getClassification();
    }

    public static int getCurrentThermalStatus(PowerManager r0) {
        return r0.getCurrentThermalStatus();
    }

    public static Set<String> getExternalVolumeNames(Context r2) {
        return MediaStore.getExternalVolumeNames((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    }

    public static TransportInfo getTransportInfo(NetworkCapabilities r0) {
        return r0.getTransportInfo();
    }

    public static void requestCellInfoUpdate(TelephonyManager r2, Callback<List<CellInfo>> r3) {
        final Callback r4 = (Callback) ZeusTransformUtils.wrapperContextForParams(r3, Callback.class, "com.obric.memorydata.plugin");
        r2.requestCellInfoUpdate(AsyncTask.THREAD_POOL_EXECUTOR, new AnonymousClass1(r4));
    }

    public static Uri setIncludePending(Uri r0) {
        return MediaStore.setIncludePending(r0);
    }

    public static void startForeground(Service r2, int r3, Notification r4, int r5) {
        ((Service) ZeusTransformUtils.wrapperContextForParams(r2, Service.class, "com.obric.memorydata.plugin")).startForeground(r3, r4, r5);
    }

    public static void updateServiceGroup(Context r2, ServiceConnection r3, int r4, int r5) {
        ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).updateServiceGroup((ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r3, ServiceConnection.class, "com.obric.memorydata.plugin"), r4, r5);
    }
}
