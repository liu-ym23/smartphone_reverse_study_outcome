package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class p implements Runnable {
    public final /* synthetic */ MmAINotePanelAnimator a;

    public p(MmAINotePanelAnimator r1) {
        this.a = r1;
    }

    public final void a() {
        if (this.a.f.isAttachedToWindow() == false) goto L14;
        MmAINotePanelAnimator r0 = this.a;
        if (r0.o == MmAINoteSheetState.CLOSED) goto L16;
        r0.j.requestLayout();
        this.a.a.q.requestLayout();
        MmAINotePanelAnimator r1 = this.a;
        if (r1.o == MmAINoteSheetState.HALF) goto L10;
    L12:
        MmAINotePanelAnimator r2 = this.a;
        r2.g(r2.n(), this.a.g.getTranslationY());
        return;
    L10:
        if (r1.w() == false) goto L12;
        this.a.p(MmAINotePanelAnimator.FullStateSource.INITIAL_SHOW, "content_height_changed");
        return;
    L16:
        return;
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
