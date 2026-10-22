package com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements Runnable {
    public final /* synthetic */ MmRecordingAINoteToolBarView a;

    public a(MmRecordingAINoteToolBarView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MmRecordingAINoteToolBarView r0 = this.a;     // Catch: Throwable -> L7
        mwb.c r1 = r0.a;     // Catch: Throwable -> L7
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");     // Catch: Throwable -> L7
        r1 = null;
    L5:
        r0.Z5(r1.f.getWidth());     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
