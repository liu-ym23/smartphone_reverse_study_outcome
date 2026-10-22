package com.ttnet.org.chromium.net;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes6.dex */
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
        void OnCheckSystemAvailableResult(long r1, TTSocketAccelerate r3, int r4);

        @NativeClassQualifiedName("TTSocketAccelerateDelegateAndroid")
        void OnNotifyAccelerateResult(long r1, TTSocketAccelerate r3, int r4, int r5);
    }

    public TTSocketAccelerate() {
        this.nativeDelegate = 0;
    }

    public static TTSocketAccelerate init() {
        return new TTSocketAccelerate();
    }

    public void checkSystemAvailable() {
        if (this.nativeDelegate != 0) goto L6;
        return;
    L6:
        if (Build.MANUFACTURER.toLowerCase().contains("honor") == true) goto L13;
        if (Build.BRAND.toLowerCase().contains("honor") == true) goto L13;
        Natives r0 = TTSocketAccelerateJni.get();
        long r1 = this.nativeDelegate;
        int r3 = -1002;
    L10:
        r0.OnCheckSystemAvailableResult(r1, this, r3);
        return;
    L13:
        if (Build.VERSION.SDK_INT >= 29) goto L15;
        r0 = TTSocketAccelerateJni.get();
        r1 = this.nativeDelegate;
        r3 = -1003;
        goto L10
    L15:
        r0 = TTSocketAccelerateJni.get();
        r1 = this.nativeDelegate;
        r3 = 0;
        goto L10
    }

    public void notifyAccelerate(int r13, int r14, int r15) {
        Method r0 = ZeusTransformUtils.forName(sEmcomManagerExClass, "com.obric.memorydata.plugin").getMethod(sNotifyAppInfoMethod, new Class[]{Bundle.class});     // Catch: Throwable -> L4
        Log.e("SA", "notify scene:" + r13 + " value: " + r14 + " fd:" + r15);     // Catch: Throwable -> L4
        Bundle r1 = new Bundle();     // Catch: Throwable -> L4
        r1.putInt("msgType", 49);     // Catch: Throwable -> L4
        r1.putInt(MemoryInfoSectionEditActivity.KIND_SCENE, 16);     // Catch: Throwable -> L4
        r1.putInt("subscene", r14);     // Catch: Throwable -> L4
        r1.putInt("status", 1);     // Catch: Throwable -> L4
        r1.putInt("accStatus", 3);     // Catch: Throwable -> L4
        r1.putString("KFD", "" + r15);     // Catch: Throwable -> L4
        r0.invoke(null, new Object[]{r1});     // Catch: Throwable -> L4
        TTSocketAccelerateJni.get().OnNotifyAccelerateResult(this.nativeDelegate, this, r13, 0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
        TTSocketAccelerateJni.get().OnNotifyAccelerateResult(this.nativeDelegate, this, r13, -1000);
    }

    public void setNativeDelegate(long r1) {
        this.nativeDelegate = r1;
    }
}
