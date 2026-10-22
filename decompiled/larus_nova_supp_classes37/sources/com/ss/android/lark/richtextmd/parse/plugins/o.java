package com.ss.android.lark.richtextmd.parse.plugins;

import com.ss.android.lark.coremd.base.parse.t;
import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkCodeBlockExtend;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class o<T extends s> implements t {
    public final /* synthetic */ a a;

    public o(a r1) {
        this.a = r1;
    }

    public final void a(final com.ss.android.lark.coremd.impl.parse.k r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        if (this.a.a.g.a == false) goto L5;
        String r0 = com.ss.android.lark.widget.codeblock.entity.a.b();
    L7:
        if (this.a.a.b == true) goto L9;
        r3.g.d(r0);
        return;
    L9:
        com.ss.android.lark.coremd.impl.parse.n r4 = r3.g.a();
        r4.d(r0);
        r4.a();
        return;
    L5:
        r0 = com.ss.android.lark.widget.codeblock.entity.a.a((List) LarkCodeBlockExtend.f.b(new RichTextDigestParsePlugin$configureVisitor$8$text$1(r3)));
        goto L7
    }
}
