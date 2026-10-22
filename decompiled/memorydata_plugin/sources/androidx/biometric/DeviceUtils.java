package androidx.biometric;

import android.content.Context;
import android.os.Build;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class DeviceUtils {
    private DeviceUtils() {
    }

    static boolean canAssumeStrongBiometrics(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 30) goto L7;
        return false;
    L7:
        return isModelInList(r5, r4, ZeusTransformUtils.mapRes(R.array.assume_strong_biometrics_models, "array", "assume_strong_biometrics_models"));
    }

    private static boolean isModelInList(Context r3, String r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return false;
    L5:
        String[] r7 = ZeusTransformUtils.getResources(r6, "com.obric.memorydata.plugin").getStringArray(r5);
        int r8 = r7.length;
        int r1 = 0;
    L6:
        if (r1 >= r8) goto L12;
        if (r4.equals(r7[r1]) == true) goto L9;
        r1 = r1 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    private static boolean isModelInPrefixList(Context r3, String r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return false;
    L5:
        String[] r7 = ZeusTransformUtils.getResources(r6, "com.obric.memorydata.plugin").getStringArray(r5);
        int r8 = r7.length;
        int r1 = 0;
    L6:
        if (r1 >= r8) goto L12;
        if (r4.startsWith(r7[r1]) == true) goto L9;
        r1 = r1 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    private static boolean isVendorInList(Context r3, String r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return false;
    L5:
        String[] r7 = ZeusTransformUtils.getResources(r6, "com.obric.memorydata.plugin").getStringArray(r5);
        int r8 = r7.length;
        int r1 = 0;
    L6:
        if (r1 >= r8) goto L12;
        if (r4.equalsIgnoreCase(r7[r1]) == true) goto L9;
        r1 = r1 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    static boolean shouldDelayShowingPrompt(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT == 29) goto L7;
        return false;
    L7:
        return isModelInList(r5, r4, ZeusTransformUtils.mapRes(R.array.delay_showing_prompt_models, "array", "delay_showing_prompt_models"));
    }

    static boolean shouldHideFingerprintDialog(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT == 28) goto L7;
        return false;
    L7:
        return isModelInPrefixList(r5, r4, ZeusTransformUtils.mapRes(R.array.hide_fingerprint_instantly_prefixes, "array", "hide_fingerprint_instantly_prefixes"));
    }

    static boolean shouldUseFingerprintForCrypto(Context r4, String r5, String r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT == 28) goto L6;
        return false;
    L6:
        if (isVendorInList(r7, r5, ZeusTransformUtils.mapRes(R.array.crypto_fingerprint_fallback_vendors, "array", "crypto_fingerprint_fallback_vendors")) == false) goto L8;
    L9:
        return true;
    L8:
        if (isModelInPrefixList(r7, r6, ZeusTransformUtils.mapRes(R.array.crypto_fingerprint_fallback_prefixes, "array", "crypto_fingerprint_fallback_prefixes")) == true) goto L9;
        return false;
    }

    static boolean shouldUseKeyguardManagerForBiometricAndCredential(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT == 29) goto L7;
        return false;
    L7:
        return !isVendorInList(r5, r4, ZeusTransformUtils.mapRes(R.array.keyguard_biometric_and_credential_exclude_vendors, "array", "keyguard_biometric_and_credential_exclude_vendors"));
    }
}
