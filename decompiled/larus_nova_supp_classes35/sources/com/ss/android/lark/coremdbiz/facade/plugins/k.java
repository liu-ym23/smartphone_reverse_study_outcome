package com.ss.android.lark.coremdbiz.facade.plugins;

import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkCodeBlockExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkCodeBlockThemeData;
import com.ss.android.lark.widget.codeblock.process.CodeBlockV2ProcessParams;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.q {
    public k() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.q
    public final Object a(final com.ss.android.lark.coremd.impl.parse.i r8) {
        Intrinsics.checkNotNullParameter(r8, "it");
        LarkCodeBlockThemeData r0 = (LarkCodeBlockThemeData) LarkThemeExtend.m.b(new LarkCodePlugin$configureSpanFactory$1$themeData$1(r8));
        com.ss.android.lark.coremd.ext.c r1 = r0.l;
        KProperty<Object>[] r2 = LarkCodeBlockThemeData.n;
        final CodeBlockV2ProcessParams r3 = ((com.ss.android.lark.coremdbiz.facade.codeblock.a) r1.getValue(r0, r2[1])).a((v7b.g) r8.d, r8);
        final int r4 = ((Number) r0.k.getValue(r0, r2[0])).intValue();
        final int r5 = UIUtils.dp2px(r8.getContext(), ((Number) r0.m.getValue(r0, r2[2])).floatValue());
        return LarkCodeBlockExtend.f.b(new LarkCodePlugin$configureSpanFactory$1$1(r8, r3, r4, r5));
    }
}
