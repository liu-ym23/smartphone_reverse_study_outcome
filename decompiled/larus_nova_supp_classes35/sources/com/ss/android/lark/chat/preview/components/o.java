package com.ss.android.lark.chat.preview.components;

import android.content.Context;
import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkLinkExtend;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class o implements com.ss.android.lark.coremd.base.parse.n.b<v7b.n> {
    public final /* synthetic */ n a;
    public final /* synthetic */ Context b;

    @Override // com.ss.android.lark.coremd.base.parse.n.b
    public final void a(final com.ss.android.lark.coremd.impl.parse.f r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        n.k(this.a, this.b, ((v7b.n) r6.d).j, (String) LarkLinkExtend.f.b(new RichTextComponent$parseRichTextToCharSequenceV2$clickPlugin$1$configureClick$1$1(r6)));
    }

    public o(n r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }
}
