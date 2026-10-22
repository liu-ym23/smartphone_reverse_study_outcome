package com.ss.android.lark.reaction.widget.panel;

import android.text.TextUtils;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d implements com.ss.android.lark.newemoji.emoji_list.adapter.e {
    public final /* synthetic */ ReactionPanelFacade a;

    public final void b(String r1, String r2) {
    }

    public d(ReactionPanelFacade r1) {
        this.a = r1;
    }

    public final void a(String r3, s5c.d r4) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        Log.e("ReactionPanelFacade", "reaction ===> reaction key is null");
        return;
    L6:
        ReactionPanelFacade.b r0 = this.a.b;
        if (r0 == null) goto L9;
        r0.a(r3, 0);
    L9:
        ReactionPanelFacade.b(this.a, r4);
        this.a.c();
    }
}
