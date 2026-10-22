package com.ss.android.lark.coremd.clickcompat;

import com.ss.android.lark.coremd.facade.bizext.props.IMAtNodeExtend;
import com.ss.android.lark.flow.chat.page.flow.plugin.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatAtClickHandler {
    public final m2b.a a;
    public final c.b b;

    public ChatAtClickHandler(m2b.a r2, g.b r3) {
        Intrinsics.checkNotNullParameter(r2, "chatContext");
        Intrinsics.checkNotNullParameter(r3, "messageProvider");
        this.a = r2;
        this.b = r3;
    }

    public final void a(final eab.a r3, final String r4) {
        Intrinsics.checkNotNullParameter(r3, "atNode");
        Intrinsics.checkNotNullParameter(r4, "messageId");
        IMAtNodeExtend.i.b(new ChatAtClickHandler$handleAtClick$1(this, r4, r3));
    }
}
