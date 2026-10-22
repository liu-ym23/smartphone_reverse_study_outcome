package com.ss.android.lark.coremdbiz.facade;

import com.ss.android.lark.coremd.base.parse.t;
import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkCodeBlockExtend;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l<T extends s> implements t {
    public l() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.t
    public final void a(final com.ss.android.lark.coremd.impl.parse.k r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        String r0 = com.ss.android.lark.widget.codeblock.entity.a.a((List) LarkCodeBlockExtend.f.b(new PureTextMarkdownParsePlugin$configureVisitor$1$7$content$1(r3)));
        if (StringsKt.isBlank(r0) == false) goto L5;
        r0 = com.ss.android.lark.widget.codeblock.entity.a.b();
    L5:
        com.ss.android.lark.coremd.impl.parse.n r4 = r3.g.a();
        r4.d(r0);
        r4.a();
    }
}
