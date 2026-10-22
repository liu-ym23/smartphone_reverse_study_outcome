package com.bytedance.bmmt.video;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class EglBaseCheckerHelper {
    protected static WeakReference<EglBase.EglContextChecker> eglContextChecker;

    public EglBaseCheckerHelper() {
    }

    public static void EglContextDestoryEnd() {
        WeakReference<EglBase.EglContextChecker> r0 = eglContextChecker;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.get() == null) goto L9;
        eglContextChecker.get().EglContextDestoryEnd();
        return;
    }

    public static void EglContextDestoryStart() {
        WeakReference<EglBase.EglContextChecker> r0 = eglContextChecker;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.get() == null) goto L9;
        eglContextChecker.get().EglContextDestoryStart();
        return;
    }

    public static void setEglContextChecker(EglBase.EglContextChecker r1) {
        eglContextChecker = new WeakReference(r1);
    }
}
