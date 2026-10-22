package com.ss.android.lark.coremdbiz.facade.plugins;

import android.text.style.ForegroundColorSpan;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class w<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.q {
    public w() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.q
    public final Object a(final com.ss.android.lark.coremd.impl.parse.i r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        int r0 = ((Number) LarkThemeExtend.m.b(new PhoneNumberPlugin$configureSpanFactory$1$colorRes$1(r3))).intValue();
        return new ForegroundColorSpan(UIUtils.getColor(r3.getContext(), r0));
    }
}
