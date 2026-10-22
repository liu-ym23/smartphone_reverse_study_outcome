package com.ss.android.lark.coremd.facade.plugins;

import com.ss.android.lark.coremd.facade.bizext.IMContextExtend;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class t implements com.ss.android.lark.coremd.base.parse.n.b<v7b.l> {
    public t() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.n.b
    public final void a(final com.ss.android.lark.coremd.impl.parse.f r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        IMContextExtend.A.b(new ChatMessageClickPlugin$configureClick$3$1(r3));
    }
}
