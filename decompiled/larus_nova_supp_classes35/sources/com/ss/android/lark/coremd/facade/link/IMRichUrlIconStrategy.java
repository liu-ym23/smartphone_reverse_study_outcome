package com.ss.android.lark.coremd.facade.link;

import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.base.parse.r;
import com.ss.android.lark.coremd.facade.bizext.IMContextExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import com.ss.android.lark.coremdbiz.facade.link.parser.BaseRichUrlIconStrategy;
import dab.c;
import kotlin.jvm.internal.Intrinsics;
import v7b.n;
import z9b.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class IMRichUrlIconStrategy extends BaseRichUrlIconStrategy {
    public static final IMRichUrlIconStrategy b = null;

    static {
        b = new IMRichUrlIconStrategy();
    }

    public IMRichUrlIconStrategy() {
    }

    @Override // com.ss.android.lark.coremdbiz.facade.link.parser.BaseRichUrlIconStrategy
    public final int c(final r<n> r3, c r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "info");
        a r0 = (a) LarkThemeExtend.m.b(new IMRichUrlIconStrategy$getColor$linkStyleConfig$1(r3));
        if (r0.a == false) goto L17;
        if (r4.d == true) goto L15;
        if (r4.b != 0) goto L15;
        if (((Boolean) IMContextExtend.A.b(new IMRichUrlIconStrategy$getColor$applyStyleFromMe$1(r3))).booleanValue() == false) goto L13;
        return UIUtils.getColor(r3.getContext(), r0.b);
    L13:
        return UIUtils.getColor(r3.getContext(), r0.c);
    L15:
        return r4.b;
    L17:
        return BaseRichUrlIconStrategy.b(r3, r4);
    }
}
