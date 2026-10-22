package com.lynx.devtool.helper;

import b5a.a;
import com.lynx.tasm.base.LLog;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LepusDebugInfoHelper {
    private static final String TAG = "LepusDebugInfoHelper";
    private String mDebugInfo;
    private AtomicBoolean mIsLoading;

    public LepusDebugInfoHelper() {
        this.mIsLoading = new AtomicBoolean(false);
    }

    public static /* synthetic */ AtomicBoolean access$100(LepusDebugInfoHelper r0) {
        return r0.mIsLoading;
    }

    private void downloadDebugInfo(String r3) {
        new a(r3, new AnonymousClass1(this));
    }

    public String getDebugInfo(String r5) {
        LLog.i(TAG, "lepus debug: debug info url: " + r5);
        this.mIsLoading.set(true);
        downloadDebugInfo(r5);
    L11:
    L7:
        e = move-exception;
        LLog.e(TAG, e.toString());
    L10:
        return this.mDebugInfo;
    L4:
        if (this.mIsLoading.get() == false) goto L10;
        Thread.sleep(10);     // Catch: InterruptedException -> L7
        goto L11
    }

    public static /* synthetic */ String access$002(LepusDebugInfoHelper r0, String r1) {
        r0.mDebugInfo = r1;
        return r1;
    }
}
