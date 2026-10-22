package com.ss.android.lark.coremd.clickcompat;

import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkLinkExtend;
import com.ss.android.lark.flow.chat.page.flow.plugin.g;
import kotlin.jvm.internal.Intrinsics;
import v7b.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatLinkClickHandler {
    public final m2b.a a;
    public final c.b b;
    public final c.a c;

    public final void a(final n r3, final String r4) {
        Intrinsics.checkNotNullParameter(r3, "link");
        Intrinsics.checkNotNullParameter(r4, "messageId");
        LarkLinkExtend.f.b(new ChatLinkClickHandler$handleLinkClick$1(this, r4, r3));
    }

    public ChatLinkClickHandler(m2b.a r2, g.b r3, c.a r4) {
        Intrinsics.checkNotNullParameter(r2, "chatContext");
        Intrinsics.checkNotNullParameter(r3, "messageProvider");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
