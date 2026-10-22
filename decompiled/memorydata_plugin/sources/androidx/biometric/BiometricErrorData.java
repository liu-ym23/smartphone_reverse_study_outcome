package androidx.biometric;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
class BiometricErrorData {
    private final int mErrorCode;
    private final CharSequence mErrorMessage;

    BiometricErrorData(int r3, CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        this.mErrorCode = r3;
        this.mErrorMessage = r5;
    }

    private static String convertToString(CharSequence r2) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.toString();
    }

    private boolean isErrorMessageEqualTo(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        String r2 = convertToString(this.mErrorMessage);
        String r5 = convertToString(r4);
        if (r2 != null) goto L5;
        if (r5 != null) goto L5;
    L8:
        return true;
    L5:
        if (r2 != null) goto L7;
    L9:
        return false;
    L7:
        if (r2.equals(r5) == false) goto L9;
        goto L8
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, BiometricErrorData.class) == false) goto L10;
        BiometricErrorData r5 = (BiometricErrorData) ZeusTransformUtils.preCheckCast(r4, BiometricErrorData.class, "com.obric.memorydata.plugin");
        if (this.mErrorCode == r5.mErrorCode) goto L7;
        return false;
    L7:
        if (isErrorMessageEqualTo(r5.mErrorMessage) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    int getErrorCode() {
        return this.mErrorCode;
    }

    CharSequence getErrorMessage() {
        return this.mErrorMessage;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.mErrorCode), convertToString(this.mErrorMessage)});
    }
}
