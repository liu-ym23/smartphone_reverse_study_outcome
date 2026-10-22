package com.ss.android.lark.coremd.facade.plugins;

import android.content.Context;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.base.theme.BlockQuoteThemeData;
import com.ss.android.lark.coremd.span.BlockQuoteSpan;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class n<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.q {
    public n() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.q
    public final Object a(com.ss.android.lark.coremd.impl.parse.i r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        Context r0 = r6.getContext();
        BlockQuoteThemeData r1 = com.ss.android.lark.coremd.base.parse.k.b.b(r6.getTheme());
        return new BlockQuoteSpan(r6.getTheme(), r6.getContext(), UIUtils.dp2px(r0, ((Number) r1.f.getValue(r1, BlockQuoteThemeData.j[2])).intValue()));
    }
}
