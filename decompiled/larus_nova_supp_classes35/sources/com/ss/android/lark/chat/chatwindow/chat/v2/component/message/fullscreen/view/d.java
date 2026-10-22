package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view;

import android.content.Context;
import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkCodeBlockExtend;
import com.ss.android.lark.widget.codeblock.process.CodeBlockV2ProcessParams;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements com.ss.android.lark.coremd.base.parse.n.b<v7b.g> {
    public final /* synthetic */ i a;

    public d(i r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.coremd.base.parse.n.b
    public final void a(final com.ss.android.lark.coremd.impl.parse.f r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        List r4 = (List) LarkCodeBlockExtend.f.b(new MessageFullScreenClickPlugin$configureClick$1$3$lineContents$1(r3));
        float r0 = zz7.b.h(this.a.a.getContext(), 14);
        CodeBlockV2ProcessParams.Companion.getClass();
        CodeBlockV2ProcessParams r1 = CodeBlockV2ProcessParams.b.a((int) r0);
        Context r2 = this.a.a.getContext();
        if (r4 != null) goto L5;
        r4 = CollectionsKt.emptyList();
    L5:
        com.ss.android.lark.widget.richtext.codeblockv2.h.a(r2, r4, r1);
    }
}
