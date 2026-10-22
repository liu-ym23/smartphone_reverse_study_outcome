package com.ss.android.lark.flow.chat.message.block;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.utils.k;
import com.ss.android.lark.dto.chat.ProfileSource;
import com.ss.android.lark.inv.export.router.InvRouter$InviteExternalPage$Param$From;
import com.ss.android.lark.reaction.widget.flowlayout.ReactionFlowLayout;
import w4b.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements ReactionFlowLayout.a {
    public final /* synthetic */ FlowReactionBlock a;
    public final /* synthetic */ y6b.c<?> b;

    public e(FlowReactionBlock r1, y6b.c<?> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(String r5) {
        if (r5 == null) goto L5;
        FlowReactionBlock.h(this.a, this.b, "none", InvRouter$InviteExternalPage$Param$From.PROFILE);
        b0 r0 = ChatCoreModule.a().getProfileDependency();
        FragmentActivity r1 = ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this.a).c.getContext();
        ProfileSource.a r2 = new ProfileSource.a();
        r2.e = r5;
        r2.b = 4;
        r2.c = k.a(((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this.a).c.getChat());
        r0.e(r1, r2.a());
        return;
    }
}
