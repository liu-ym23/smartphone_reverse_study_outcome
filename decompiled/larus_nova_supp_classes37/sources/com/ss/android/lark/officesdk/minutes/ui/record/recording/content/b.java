package com.ss.android.lark.officesdk.minutes.ui.record.recording.content;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.l;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements Runnable {
    public final /* synthetic */ MmRecordingContentController a;
    public final /* synthetic */ l b;
    public final /* synthetic */ int c;

    public b(MmRecordingContentController r1, l r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        if (this.a.a.b().isAttachedToWindow() == true) goto L7;
        int r0 = bwb.b.a;
        bwb.b.f(MmUiLogScene.CONTENT, "goToSubtitle", "skip detached pager, request=" + this.b, this.a.c());
        return;
    L7:
        if (this.a.a.b().getCurrentItem() == this.c) goto L9;
        int r1 = bwb.b.a;
        bwb.b.f(MmUiLogScene.CONTENT, "goToSubtitle", "force sync tab, currentItem=" + this.a.a.b().getCurrentItem() + ", subtitlePosition=" + this.c, this.a.c());
        this.a.a.b().setCurrentItem(this.c, false);
    L9:
        this.a.e(this.c, "goToSubtitle_post", true);
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
