package com.zte.miboard.recommend.nubiapush;

import ai.j0;
import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Debug;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import cn.nubia.neopush.sdk.NeoPushClient;
import m.h;

/* JADX INFO: loaded from: classes3.dex */
public class PushUtils {
    private static final String TAG = "Mi_R_PushUtils";
    private static String mRegId = "";
    private static String mTempMiboardStr = "";

    public PushUtils() {
    }

    @SuppressLint({"HardwareIds"})
    public static String getDevId() {
        String r5 = Settings.Secure.getString(h.a().getContentResolver(), "android_id");
        androidx.constraintlayout.motion.widget.a.A("getDevId ", r5, TAG);
        return r5;
    }

    public static String getPhoneId() {
        String r5 = TAG;
        StringBuilder r10 = new StringBuilder("getPhoneId ");
        String r11 = Build.PRODUCT;
        androidx.constraintlayout.motion.widget.a.B(r10, r11, r5);
        return r11;
    }

    public static String getRegAgainMiboardCache() {
        String r5 = Settings.Global.getString(h.a().getContentResolver(), "floatassist_veryzhun_miboard");
        androidx.constraintlayout.motion.widget.a.A("getRegAgainMiboardCache. ret=", r5, TAG);
        return r5;
    }

    public static String getRegId() {
        if (TextUtils.isEmpty(mRegId) == false) goto L5;
        mRegId = NeoPushClient.getRegId(h.a());
    L5:
        String r5 = TAG;
        androidx.constraintlayout.motion.widget.a.B(new StringBuilder("getRegId "), mRegId, r5);
        return mRegId;
    }

    public static boolean isRegisteredState() {
        if (Settings.Global.getInt(h.a().getContentResolver(), "floatassist_veryzhun_state", 0) != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public static void setMiboardPersist(String r5, boolean r10) {
        String r11 = TAG;
        StringBuilder r12 = new StringBuilder("setMiboardPersist. s=");
        r12.append(r5);
        r12.append(" persist=");
        r12.append(r10);
        r12.append(" temp=");
        androidx.constraintlayout.motion.widget.a.B(r12, mTempMiboardStr, r11);
        mTempMiboardStr = r5;
        if (r10 == false) goto L6;
        Settings.Global.putString(h.a().getContentResolver(), "floatassist_veryzhun_state_miboard", mTempMiboardStr);
        return;
    }

    public static void setRegAgainMiboardCache(String r5) {
        Log.d(TAG, "setRegAgainMiboardCache. cache=" + r5);
        Settings.Global.putString(h.a().getContentResolver(), "floatassist_veryzhun_miboard", r5);
    }

    public static void setRegId(String r5) {
        String r10 = TAG;
        androidx.constraintlayout.motion.widget.a.B(j0.x("setRegId id=", r5, " "), Debug.getCallers(15), r10);
        mRegId = r5;
    }

    public static void setRegisteredState(boolean r5) {
        Log.d(TAG, "setRegisteredState. state=" + r5 + " mTempMiboardStr=" + mTempMiboardStr);
        Settings.Global.putInt(h.a().getContentResolver(), "floatassist_veryzhun_state", r5 ? 1 : 0);
        if (r5 == false) goto L7;
        String r10 = mTempMiboardStr;
        if (TextUtils.isEmpty(r10) == false) goto L8;
        r10 = getRegAgainMiboardCache();
    L8:
        setMiboardPersist(r10, true);
        return;
    L7:
        r10 = "";
        goto L8
    }
}
