package com.ss.android.lark.coremd.facade.plugins;

import android.content.Context;
import android.text.style.ForegroundColorSpan;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.facade.bizext.IMContextExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class r0<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.q {
    public r0() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.q
    public final Object a(final com.ss.android.lark.coremd.impl.parse.i r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        z9b.a r0 = (z9b.a) LarkThemeExtend.m.b(new IMLinkPlugin$configureSpanFactory$1$linkStyleConfig$1(r4));
        if (r0.a == false) goto L10;
        boolean r1 = ((Boolean) IMContextExtend.A.b(new IMLinkPlugin$configureSpanFactory$1$applyStyleFromMe$1(r4))).booleanValue();
        Context r5 = r4.getContext();
        if (r1 == false) goto L7;
        int r2 = r0.b;
    L11:
        return new ForegroundColorSpan(UIUtils.getColor(r5, r2));
    L7:
        r2 = r0.c;
        goto L11
    L10:
        return new ForegroundColorSpan(UIUtils.getColor(r4.getContext(), com.ss.android.lark.coremd.base.parse.k.b.g(r4.getTheme()).h()));
    }
}
