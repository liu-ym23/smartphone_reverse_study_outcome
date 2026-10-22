package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.chat.constant.ChatFromType;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.dto.chat.ProfileSource;
import com.ss.android.lark.reaction.widget.flowlayout.ReactionFlowLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h0 implements ReactionFlowLayout.a {
    public final /* synthetic */ ReactionBlock a;
    public final /* synthetic */ y6b.c<?> b;

    public h0(ReactionBlock r1, y6b.c<?> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(String r5) {
        if (r5 == null) goto L5;
        ReactionBlock.h(this.a, this.b, "none", ChatFromType.PROFILE);
        w4b.b0 r0 = ChatCoreModule.a().getProfileDependency();
        FragmentActivity r1 = this.a.c.getContext();
        ProfileSource.a r2 = new ProfileSource.a();
        r2.e = r5;
        r2.b = 4;
        r2.c = com.ss.android.lark.chat.utils.k.a(this.a.c.getChat());
        r0.e(r1, r2.a());
        return;
    }
}
