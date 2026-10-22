package com.ss.android.lark.coremdbiz.facade.plugins;

import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkContextExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkAtThemeData;
import com.ss.android.lark.widget.light.span.CustomForegroundColorSpan;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.q {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.coremd.base.parse.q
    public final Object a(final com.ss.android.lark.coremd.impl.parse.i r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        String r0 = (String) LarkContextExtend.s.b(new AtPlugin$configureSpanFactory$1$currentUserId$1(r5));
        String r1 = ((eab.a) r5.d).k;
        LarkAtThemeData r2 = (LarkAtThemeData) LarkThemeExtend.m.b(new AtPlugin$configureSpanFactory$1$themeData$1(r5));
        if (Intrinsics.areEqual(r0, r1) == true) goto L5;
    L12:
        int r3 = r2.h();
        return new CustomForegroundColorSpan(UIUtils.getColor(r5.getContext(), r3));
    L5:
        if (r0.length() != 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == true) goto L12;
        if (((Boolean) r2.f.getValue(r2, LarkAtThemeData.k[2])).booleanValue() == false) goto L12;
        this.a.getClass();
        return a.e(r5, r2);
    L7:
        r4 = false;
        goto L8
    }
}
