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
import androidx.annotation.RequiresApi;
import com.ttnet.org.chromium.base.Callback;
import com.ttnet.org.chromium.base.task.AsyncTask;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(29)
public final class ApiHelperForQ {
    private ApiHelperForQ() {
    }

    public static boolean bindIsolatedService(Context r10, Intent r11, int r12, String r13, Executor r14, ServiceConnection r15) {
        return r10.bindIsolatedService(r11, r12, r13, r14, r15);
    }

    public static int canAuthenticate(BiometricManager r10) {
        return r10.canAuthenticate();
    }

    public static long copy(InputStream r10, OutputStream r11) {
        return FileUtils.copy(r10, r11);
    }

    public static BiometricManager getBiometricManagerSystemService(Context r10) {
        return (BiometricManager) r10.getSystemService(BiometricManager.class);
    }

    public static int getClassification(MotionEvent r10) {
        return r10.getClassification();
    }

    public static int getCurrentThermalStatus(PowerManager r10) {
        return r10.getCurrentThermalStatus();
    }

    public static Set<String> getExternalVolumeNames(Context r10) {
        return MediaStore.getExternalVolumeNames(r10);
    }

    public static TransportInfo getTransportInfo(NetworkCapabilities r10) {
        return r10.getTransportInfo();
    }

    public static void requestCellInfoUpdate(TelephonyManager r10, final Callback<List<CellInfo>> r11) {
        r10.requestCellInfoUpdate(AsyncTask.THREAD_POOL_EXECUTOR, new AnonymousClass1(r11));
    }

    public static Uri setIncludePending(Uri r10) {
        return MediaStore.setIncludePending(r10);
    }

    public static void startForeground(Service r10, int r11, Notification r12, int r13) {
        r10.startForeground(r11, r12, r13);
    }

    public static void updateServiceGroup(Context r10, ServiceConnection r11, int r12, int r13) {
        r10.updateServiceGroup(r11, r12, r13);
    }
}
