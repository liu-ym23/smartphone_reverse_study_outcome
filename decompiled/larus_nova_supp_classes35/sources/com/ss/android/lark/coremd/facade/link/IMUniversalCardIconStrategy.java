package com.ss.android.lark.coremd.facade.link;

import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.base.parse.r;
import com.ss.android.lark.coremd.facade.bizext.IMContextExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import com.ss.android.lark.coremdbiz.facade.link.parser.BaseUniversalCardIconStrategy;
import dab.d;
import kotlin.jvm.internal.Intrinsics;
import v7b.n;
import z9b.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class IMUniversalCardIconStrategy extends BaseUniversalCardIconStrategy {
    public static final IMUniversalCardIconStrategy b = null;

    static {
        b = new IMUniversalCardIconStrategy();
    }

    public IMUniversalCardIconStrategy() {
    }

    @Override // com.ss.android.lark.coremdbiz.facade.link.parser.BaseUniversalCardIconStrategy
    public final int c(final r<n> r3, d r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "info");
        a r0 = (a) LarkThemeExtend.m.b(new IMUniversalCardIconStrategy$getColor$linkStyleConfig$1(r3));
        if (r0.a == false) goto L10;
        if (((Boolean) IMContextExtend.A.b(new IMUniversalCardIconStrategy$getColor$applyStyleFromMe$1(r3))).booleanValue() == false) goto L8;
        return UIUtils.getColor(r3.getContext(), r0.b);
    L8:
        return UIUtils.getColor(r3.getContext(), r0.c);
    L10:
        return BaseUniversalCardIconStrategy.b(r3, r4);
    }
}
