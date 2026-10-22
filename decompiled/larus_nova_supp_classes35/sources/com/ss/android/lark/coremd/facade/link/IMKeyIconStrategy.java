package com.ss.android.lark.coremd.facade.link;

import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.base.parse.r;
import com.ss.android.lark.coremd.facade.bizext.IMContextExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import com.ss.android.lark.coremdbiz.facade.link.parser.BaseKeyIconStrategy;
import dab.b;
import kotlin.jvm.internal.Intrinsics;
import v7b.n;
import z9b.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class IMKeyIconStrategy extends BaseKeyIconStrategy {
    public static final IMKeyIconStrategy b = null;

    static {
        b = new IMKeyIconStrategy();
    }

    public IMKeyIconStrategy() {
    }

    @Override // com.ss.android.lark.coremdbiz.facade.link.parser.BaseKeyIconStrategy
    public final int c(final r<n> r3, b r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "info");
        a r0 = (a) LarkThemeExtend.m.b(new IMKeyIconStrategy$getColor$linkStyleConfig$1(r3));
        if (r0.a == false) goto L17;
        if (r4.e == true) goto L15;
        if (r4.d != 0) goto L15;
        if (((Boolean) IMContextExtend.A.b(new IMKeyIconStrategy$getColor$applyStyleFromMe$1(r3))).booleanValue() == false) goto L13;
        return UIUtils.getColor(r3.getContext(), r0.b);
    L13:
        return UIUtils.getColor(r3.getContext(), r0.c);
    L15:
        return r4.d;
    L17:
        return BaseKeyIconStrategy.b(r3, r4);
    }
}
