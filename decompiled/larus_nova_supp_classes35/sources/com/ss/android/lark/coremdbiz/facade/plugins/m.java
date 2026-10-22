package com.ss.android.lark.coremdbiz.facade.plugins;

import android.content.Context;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.base.theme.InlineCodeThemeData;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import com.ss.android.lark.widget.span.InlineCodeCenterSpan;
import com.ss.android.lark.widget.span.InlineCodeInfo;
import com.ss.android.lark.widget.span.TextStyleInfo;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class m<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.t {
    public m() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.t
    public final void a(final com.ss.android.lark.coremd.impl.parse.k r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
        InlineCodeThemeData r0 = (InlineCodeThemeData) LarkThemeExtend.m.b(new LarkCodePlugin$configureVisitor$2$themeData$1(r10));
        v7b.s r1 = r10.d;
        String r2 = ((v7b.d) r1).j;
        boolean r3 = false;
        if (((v7b.d) r1).e == null) goto L5;
        boolean r4 = true;
    L6:
        if (r2 != null) goto L8;
    L9:
        r3 = true;
    L10:
        if (r3 == false) goto L13;
        if (r4 == true) goto L13;
        return;
    L13:
        InlineCodeInfo r5 = new InlineCodeInfo();
        Context r6 = r10.getContext();
        com.ss.android.lark.coremd.ext.c r7 = r0.f;
        KProperty<Object>[] r8 = InlineCodeThemeData.h;
        r5.setBackgroundColorValue(UIUtils.getColor(r6, ((Number) r7.getValue(r0, r8[2])).intValue()));
        ((TextStyleInfo) r5).textColor = UIUtils.getColor(r10.getContext(), ((Number) r0.e.getValue(r0, r8[1])).intValue());
        ((TextStyleInfo) r5).textSize = UIUtils.dp2px(r10.getContext(), ((Number) r0.g.getValue(r0, r8[3])).intValue());
        int r9 = r10.g.length();
        r10.g.d("`");
        com.ss.android.lark.widget.span.p r11 = new com.ss.android.lark.widget.span.p(r10.getContext(), r5);
        com.ss.android.lark.coremd.base.parse.s r12 = r10.g;
        r12.setSpan(r11, r9, r12.length(), 33);
        int r13 = r10.g.length();
        if (r4 == false) goto L16;
        r10.f.c(r10.d);
    L17:
        r10.g.setSpan(new InlineCodeCenterSpan(r10.getContext(), r5), r13, r10.g.length(), 33);
        int r14 = r10.g.length();
        r10.g.d("`");
        com.ss.android.lark.widget.span.o r15 = new com.ss.android.lark.widget.span.o(r10.getContext(), r5);
        com.ss.android.lark.coremd.base.parse.s r16 = r10.g;
        r16.setSpan(r15, r14, r16.length(), 33);
        return;
    L16:
        com.ss.android.lark.coremd.base.parse.s r17 = r10.g;
        Intrinsics.checkNotNull(r2);
        r17.d(r2);
        goto L17
    L8:
        if (r2.length() != 0) goto L10;
    L5:
        r4 = false;
        goto L6
    }
}
