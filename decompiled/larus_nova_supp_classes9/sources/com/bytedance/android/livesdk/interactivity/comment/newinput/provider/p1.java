package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p1 implements View.OnClickListener {
    public final /* synthetic */ TruthSectionProvider.TruthPanelController.TruthQuestionViewBinder.TruthQuestionViewHolder a;
    public final /* synthetic */ TruthSectionProvider.TruthPanelController.a b;
    public final /* synthetic */ int c;

    public p1(TruthSectionProvider.TruthPanelController.TruthQuestionViewBinder.TruthQuestionViewHolder r1, TruthSectionProvider.TruthPanelController.a r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        TruthSectionProvider.TruthPanelController.a r8 = this.a.b.c.h;
        if (r8 == null) goto L17;
        com.bytedance.android.livesdk.interactivity.comment.model.c r9 = r8.a;
        if (r9 == null) goto L17;
        if (r9.b() != this.b.a.b()) goto L17;
        TruthSectionProvider.TruthPanelController.TruthQuestionViewBinder.TruthQuestionViewHolder r10 = this.a;
        TruthSectionProvider.TruthPanelController.a r2 = r10.b.c.h;
        if (r2 == null) goto L11;
        r2.b = false;
    L11:
        r10.a.setSelected(false);
        TruthSectionProvider.TruthPanelController r11 = this.a.b.c;
        r11.h = null;
        r11.l.notifyItemChanged(this.c);
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r13 = this.a.b.c.b.V();
        if (r13 == null) goto L16;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r14 = r13.g;
        if (r14 == null) goto L16;
        r14.z = null;
    L16:
        int r15 = com.bytedance.android.livesdk.interactivity.comment.utils.i.a;
        com.bytedance.android.livesdk.interactivity.comment.utils.i.b(this.b.a, false, true);
        return;
    L17:
        TruthSectionProvider.TruthPanelController.TruthQuestionViewBinder.TruthQuestionViewHolder r16 = this.a;
        TruthSectionProvider.TruthPanelController.a r3 = r16.b.c.h;
        if (r3 == null) goto L20;
        r3.b = false;
    L20:
        r16.a.setSelected(true);
        TruthSectionProvider.TruthPanelController.a r17 = this.b;
        r17.b = true;
        TruthSectionProvider.TruthPanelController.TruthQuestionViewBinder r0 = this.a.b;
        r0.c.h = r17;
        r0.b.invoke(r17.a);
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r18 = this.a.b.c.b.V();
        if (r18 == null) goto L25;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r19 = r18.g;
        if (r19 == null) goto L25;
        r19.z = this.b.a;
    L25:
        this.a.b.c.l.notifyDataSetChanged();
        int r20 = com.bytedance.android.livesdk.interactivity.comment.utils.i.a;
        com.bytedance.android.livesdk.interactivity.comment.utils.i.b(this.b.a, true, true);
    }
}
