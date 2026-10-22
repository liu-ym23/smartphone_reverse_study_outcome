package com.ttnet.org.chromium.base.metrics;

import com.ttnet.org.chromium.base.ThreadUtils;
import com.ttnet.org.chromium.base.VisibleForTesting;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base::android")
public class RecordUserAction {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static Throwable sDisabledBy;
    private static long sNativeActionCallback;

    public interface UserActionCallback {
        @CalledByNative("UserActionCallback")
        void onActionRecorded(String r8);
    }

    public RecordUserAction() {
    }

    public static /* synthetic */ void access$000(String r8) {
        nativeRecordUserAction(r8);
    }

    private static native long nativeAddActionCallbackForTesting(UserActionCallback r8);

    private static native void nativeRecordUserAction(String r8);

    private static native void nativeRemoveActionCallbackForTesting(long r8);

    public static void record(final String r8) {
        if (sDisabledBy == null) goto L6;
        return;
    L6:
        if (ThreadUtils.runningOnUiThread() == false) goto L9;
        nativeRecordUserAction(r8);
        return;
    L9:
        ThreadUtils.runOnUiThread(new AnonymousClass1(r8));
    }

    public static void removeActionCallbackForTesting() {
        nativeRemoveActionCallbackForTesting(sNativeActionCallback);
        sNativeActionCallback = 0;
    }

    public static void setActionCallbackForTesting(UserActionCallback r8) {
        sNativeActionCallback = nativeAddActionCallbackForTesting(r8);
    }

    @VisibleForTesting
    public static void setDisabledForTests(boolean r8) {
        if (r8 == true) goto L4;
    L8:
        if (r8 == false) goto L10;
        Throwable r10 = new Throwable();
    L11:
        sDisabledBy = r10;
        return;
    L10:
        r10 = null;
        goto L11
    L4:
        if (sDisabledBy == null) goto L8;
        throw new IllegalStateException("UserActions are already disabled.", sDisabledBy);
    }
}
