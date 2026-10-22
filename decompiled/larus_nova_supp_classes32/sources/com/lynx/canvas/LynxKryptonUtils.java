package com.lynx.canvas;

import com.lynx.tasm.LynxView;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.krypton.LynxKryptonHelper;
import com.lynx.tasm.behavior.ui.krypton.LynxKryptonModule;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxKryptonUtils {
    private static final String TAG = "LynxKryptonUtils";

    public LynxKryptonUtils() {
    }

    public static LynxKryptonHelper getLynxKryptonHelper(LynxView r3) {
        LynxContext r4 = r3.getLynxContext();
        if (r4 != null) goto L6;
        LLog.e(TAG, "context is null");
        return null;
    L6:
        LynxKryptonModule r5 = (LynxKryptonModule) r4.getExtensionModuleByKey(LynxKryptonModule.TAG);
        if (r5 != null) goto L11;
        LLog.e(TAG, "krypton module is null");
        return null;
    L11:
        return r5.getLynxKryptonHelper();
    }
}
