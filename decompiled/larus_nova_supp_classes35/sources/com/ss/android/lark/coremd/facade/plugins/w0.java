package com.ss.android.lark.coremd.facade.plugins;

import android.text.style.ForegroundColorSpan;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.facade.bizext.IMContextExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class w0<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.q {
    public w0() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.q
    public final Object a(final com.ss.android.lark.coremd.impl.parse.i r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        LarkThemeExtend.a r0 = LarkThemeExtend.m;
        z9b.b r1 = (z9b.b) r0.b(new IMPhoneNumberPlugin$configureSpanFactory$1$phoneStyleConfig$1(r4));
        if (r1.a == true) goto L5;
        int r2 = ((Number) r0.b(new IMPhoneNumberPlugin$configureSpanFactory$1$colorRes$1(r4))).intValue();
    L10:
        return new ForegroundColorSpan(UIUtils.getColor(r4.getContext(), r2));
    L5:
        if (((Boolean) IMContextExtend.A.b(new IMPhoneNumberPlugin$configureSpanFactory$1$colorRes$applyStyleFromMe$1(r4))).booleanValue() == false) goto L7;
        r2 = r1.b;
        goto L10
    L7:
        r2 = r1.c;
        goto L10
    }
}
