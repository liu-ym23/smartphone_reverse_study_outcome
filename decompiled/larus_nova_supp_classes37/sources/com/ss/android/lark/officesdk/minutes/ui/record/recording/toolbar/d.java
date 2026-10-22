package com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import kotlin.jvm.internal.Intrinsics;
import mwb.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d implements Runnable {
    public final /* synthetic */ MmRecordingTopBarView a;

    public d(MmRecordingTopBarView r1) {
        this.a = r1;
    }

    public final void a() {
        int r0 = bwb.b.a;
        MmUiLogScene r1 = MmUiLogScene.TOOLBAR;
        StringBuilder r2 = new StringBuilder("end, visibility=");
        h r3 = this.a.a;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L5:
        r2.append(r3.c.getVisibility());
        r2.append(", alpha=");
        h r4 = this.a.a;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L8:
        r2.append(r4.c.getAlpha());
        r2.append(", title=");
        h r5 = this.a.a;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L11:
        r2.append(r5.c.getText());
        bwb.b.b(r1, "showTitleInBar", r2.toString(), null, 8);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
