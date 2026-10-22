package androidx.biometric;

import android.content.Context;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class ErrorUtils {
    private ErrorUtils() {
    }

    static String getFingerprintErrorString(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L7;
        return "";
    L7:
        if (r4 != 1) goto L9;
        int r6 = R.string.fingerprint_error_hw_not_available;
        String r0 = "fingerprint_error_hw_not_available";
    L13:
        return r5.getString(ZeusTransformUtils.mapRes(r6, TypedValues.Custom.S_STRING, r0));
    L9:
        if (r4 == 7) goto L17;
        switch(r4) {
            case 9: goto L17;
            case 10: goto L16;
            case 11: goto L15;
            case 12: goto L14;
            default: goto L11;
        };
    L11:
        Log.e("BiometricUtils", "Unknown error code: " + r4);
        r6 = R.string.default_error_msg;
        r0 = "default_error_msg";
        goto L13
    L14:
        r6 = R.string.fingerprint_error_hw_not_present;
        r0 = "fingerprint_error_hw_not_present";
        goto L13
    L15:
        r6 = R.string.fingerprint_error_no_fingerprints;
        r0 = "fingerprint_error_no_fingerprints";
        goto L13
    L16:
        r6 = R.string.fingerprint_error_user_canceled;
        r0 = "fingerprint_error_user_canceled";
    L17:
        r6 = R.string.fingerprint_error_lockout;
        r0 = "fingerprint_error_lockout";
        goto L13
    }

    static boolean isKnownError(int r0) {
        switch(r0) {
            case 1: goto L5;
            case 2: goto L5;
            case 3: goto L5;
            case 4: goto L5;
            case 5: goto L5;
            case 6: goto L3;
            case 7: goto L5;
            case 8: goto L5;
            case 9: goto L5;
            case 10: goto L5;
            case 11: goto L5;
            case 12: goto L5;
            case 13: goto L5;
            case 14: goto L5;
            case 15: goto L5;
            default: goto L3;
        };
    L3:
        return false;
    L5:
        return true;
    }

    static boolean isLockoutError(int r1) {
        if (r1 != 7) goto L5;
    L8:
        return true;
    L5:
        if (r1 == 9) goto L8;
        return false;
    }
}
