package com.ttnet.org.chromium.net;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("net")
public class TTSocketAccelerate {
    private static final int ACCELERATE_ERROR_CALLBACK_EXCEPTION = -1001;
    private static final int ACCELERATE_ERROR_RESULT_CODE_ERROR = -1002;
    private static final int ACCELERATE_ERROR_TIMEOUT = -1003;
    private static final int ACCELERATE_NOTIFY_EXCEPTION = -1000;
    private static final int ACCELERATE_NOTIFY_SUCC = 0;
    private static final int ACC_DEFAULT = 3;
    private static final int MSG_TYPE_ACC_INFO = 16;
    private static final int MSG_TYPE_SCENE_INFO = 1;
    private static final int MSG_TYPE_SUB_SCENE_INFO = 32;
    private static final int REGIST_ANDROID_VERSION_ERROR = -1003;
    private static final int REGIST_BRAND_ERROR = -1002;
    private static final int REGIST_EXCEPTION = -1001;
    private static final int REGIST_SUCC = 0;
    private static final int REGIST_UNKNOWN = -1000;
    private static final int SCENE_SHORT_VIDEO = 16;
    private static final int STATUS_SCENE_ENTER = 1;
    private static final int SUB_SCENE_HTTP_DNS = 1;
    private static final String TAG = "TTSocketAccelerate";
    private static final String sEmcomManagerExClass = "com.hihonor.android.emcom.EmcomManagerEx";
    private static final String sNotifyAppInfoMethod = "notifyAppInfo";
    private long nativeDelegate;

    interface Natives {
        @NativeClassQualifiedName("TTSocketAccelerateDelegateAndroid")
        void OnCheckSystemAvailableResult(long r10, TTSocketAccelerate r11, int r12);

        @NativeClassQualifiedName("TTSocketAccelerateDelegateAndroid")
        void OnNotifyAccelerateResult(long r10, TTSocketAccelerate r11, int r12, int r13);
    }

    protected TTSocketAccelerate() {
        this.nativeDelegate = 0;
    }

    @CalledByNative
    public static TTSocketAccelerate init() {
        return new TTSocketAccelerate();
    }

    @CalledByNative
    public void checkSystemAvailable() {
        if (this.nativeDelegate != 0) goto L6;
        return;
    L6:
        if (Build.MANUFACTURER.toLowerCase().contains("honor") == true) goto L13;
        if (Build.BRAND.toLowerCase().contains("honor") == true) goto L13;
        Natives r10 = TTSocketAccelerateJni.get();
        long r11 = this.nativeDelegate;
        int r12 = -1002;
    L10:
        r10.OnCheckSystemAvailableResult(r11, this, r12);
        return;
    L13:
        if (Build.VERSION.SDK_INT >= 29) goto L15;
        r10 = TTSocketAccelerateJni.get();
        r11 = this.nativeDelegate;
        r12 = -1003;
        goto L10
    L15:
        r10 = TTSocketAccelerateJni.get();
        r11 = this.nativeDelegate;
        r12 = 0;
        goto L10
    }

    @CalledByNative
    public void notifyAccelerate(int r13, int r14, int r15) {
        Method r10 = Class.forName(sEmcomManagerExClass).getMethod(sNotifyAppInfoMethod, new Class[]{Bundle.class});     // Catch: Throwable -> L4
        Log.e("SA", "notify scene:" + r13 + " value: " + r14 + " fd:" + r15);     // Catch: Throwable -> L4
        Bundle r11 = new Bundle();     // Catch: Throwable -> L4
        r11.putInt("msgType", 49);     // Catch: Throwable -> L4
        r11.putInt("scene", 16);     // Catch: Throwable -> L4
        r11.putInt("subscene", r14);     // Catch: Throwable -> L4
        r11.putInt("status", 1);     // Catch: Throwable -> L4
        r11.putInt("accStatus", 3);     // Catch: Throwable -> L4
        r11.putString("KFD", "" + r15);     // Catch: Throwable -> L4
        r10.invoke(null, new Object[]{r11});     // Catch: Throwable -> L4
        TTSocketAccelerateJni.get().OnNotifyAccelerateResult(this.nativeDelegate, this, r13, 0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
        TTSocketAccelerateJni.get().OnNotifyAccelerateResult(this.nativeDelegate, this, r13, -1000);
    }

    @CalledByNative
    public void setNativeDelegate(long r10) {
        this.nativeDelegate = r10;
    }
}
