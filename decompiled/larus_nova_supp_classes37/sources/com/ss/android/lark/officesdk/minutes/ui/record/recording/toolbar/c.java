package com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import kotlin.jvm.internal.Intrinsics;
import mwb.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c implements Runnable {
    public final /* synthetic */ MmRecordingTopBarView a;

    public c(MmRecordingTopBarView r1) {
        this.a = r1;
    }

    public final void a() {
        h r0 = this.a.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        r0.c.setVisibility(8);
        int r1 = bwb.b.a;
        MmUiLogScene r2 = MmUiLogScene.TOOLBAR;
        StringBuilder r4 = new StringBuilder("end, visibility=");
        h r5 = this.a.a;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L8:
        r4.append(r5.c.getVisibility());
        r4.append(", alpha=");
        h r6 = this.a.a;
        if (r6 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L11:
        r4.append(r6.c.getAlpha());
        r4.append(", title=");
        h r7 = this.a.a;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L14:
        r4.append(r7.c.getText());
        bwb.b.b(r2, "hideTitleInBar", r4.toString(), null, 8);
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
