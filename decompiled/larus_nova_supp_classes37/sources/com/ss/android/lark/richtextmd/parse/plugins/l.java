package com.ss.android.lark.richtextmd.parse.plugins;

import com.ss.android.lark.coremd.base.parse.t;
import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkLinkExtend;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class l<T extends s> implements t {
    public final /* synthetic */ a a;

    public l(a r1) {
        this.a = r1;
    }

    public final void a(final com.ss.android.lark.coremd.impl.parse.k r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        final iec.a r0 = this.a.a.e;
        LarkLinkExtend.f.b(new RichTextDigestParsePlugin$configureVisitor$5$1(r0, r4));
    }
}
