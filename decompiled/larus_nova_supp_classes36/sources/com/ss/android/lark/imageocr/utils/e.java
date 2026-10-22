package com.ss.android.lark.imageocr.utils;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.vesdk.algorithm.VEBachSceneRecognitionResult;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements Runnable {
    public final /* synthetic */ llb.b a;
    public final /* synthetic */ VEBachSceneRecognitionResult b;
    public final /* synthetic */ float c;

    public e(llb.b r1, VEBachSceneRecognitionResult r2, float r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a(true, false, this.b.getProb(), this.c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
