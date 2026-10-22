package com.ss.android.lark.reaction.widget.panel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements com.ss.android.lark.newemoji.emoji_list.adapter.e {
    public final /* synthetic */ ReactionPanelFacade a;

    public b(ReactionPanelFacade r1) {
        this.a = r1;
    }

    public final void a(String r3, s5c.d r4) {
        ReactionPanelFacade r0 = this.a;
        if (r0.b == null) goto L5;
        ReactionPanelFacade.b(r0, r4);
        this.a.b.a(r3, 2);
    L5:
        this.a.c();
    }

    public final void b(String r2, String r3) {
        k2c.a.a().Wc(r2, r3);
    }
}
