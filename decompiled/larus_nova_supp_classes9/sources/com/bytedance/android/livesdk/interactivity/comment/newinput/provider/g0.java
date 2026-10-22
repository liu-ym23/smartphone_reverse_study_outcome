package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g0 implements View.OnClickListener {
    public final /* synthetic */ InterestSectionProvider.InterestPanelController.InterestKpViewBinder.InterestKpViewHolder a;
    public final /* synthetic */ int b;
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.comment.model.a c;

    public g0(InterestSectionProvider.InterestPanelController.InterestKpViewBinder.InterestKpViewHolder r1, int r2, com.bytedance.android.livesdk.interactivity.comment.model.a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        List<Integer> r4 = this.a.b.c.l;
        ArrayList r5 = (ArrayList) r4;
        if (r5.contains(Integer.valueOf(this.b)) == false) goto L8;
        List<Integer> r6 = this.a.b.c.l;
        ArrayList r7 = (ArrayList) r6;
        r7.remove(Integer.valueOf(this.b));
        Set<com.bytedance.android.livesdk.interactivity.comment.model.a> r8 = this.a.b.c.h();
        if (r8 == null) goto L12;
        r8.remove(this.c);
    L12:
        this.a.b.c.r.notifyItemChanged(this.b);
        int r9 = com.bytedance.android.livesdk.interactivity.comment.utils.i.a;
        com.bytedance.android.livesdk.interactivity.comment.model.a r10 = this.c;
        List<Integer> r0 = this.a.b.c.l;
        ArrayList r1 = (ArrayList) r0;
        com.bytedance.android.livesdk.interactivity.comment.utils.i.a(r10, r1.contains(Integer.valueOf(this.b)), true);
        return;
    L8:
        if (((ArrayList) this.a.b.c.l).size() >= this.a.b.c.k.intValue()) goto L14;
        this.a.b.b.invoke(this.c);
        List<Integer> r11 = this.a.b.c.l;
        ArrayList r13 = (ArrayList) r11;
        r13.add(Integer.valueOf(this.b));
        Set<com.bytedance.android.livesdk.interactivity.comment.model.a> r14 = this.a.b.c.h();
        if (r14 == null) goto L12;
        r14.add(this.c);
        goto L12
    }
}
