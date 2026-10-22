package com.ss.android.lark.coremd.facade.plugins;

import android.content.Context;
import android.text.style.ForegroundColorSpan;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.facade.bizext.IMContextExtend;
import com.ss.android.lark.coremd.facade.bizext.IMThemeExtend;
import com.ss.android.lark.coremd.facade.bizext.props.IMAtNodeExtend;
import com.ss.android.lark.coremd.facade.bizext.theme.IMAtThemeData;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkAtThemeData;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class m0<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.q {
    public final /* synthetic */ o0 a;

    public m0(o0 r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.coremd.base.parse.q
    public final Object a(final com.ss.android.lark.coremd.impl.parse.i r11) {
        Intrinsics.checkNotNullParameter(r11, "it");
        IMAtThemeData r0 = (IMAtThemeData) IMThemeExtend.s.b(new IMAtPlugin$configureSpanFactory$1$themeData$1(r11));
        if (r0.i().a == false) goto L11;
        boolean r1 = ((Boolean) IMContextExtend.A.b(new IMAtPlugin$configureSpanFactory$1$applyStyleFromMe$1(r11))).booleanValue();
        Context r12 = r11.getContext();
        if (r1 == false) goto L7;
        int r2 = r0.i().b;
    L8:
        ForegroundColorSpan r3 = new ForegroundColorSpan(UIUtils.getColor(r12, r2));
        if (r0.i().d == true) goto L31;
        return r3;
    L31:
        return com.ss.android.lark.coremd.ext.b.a(r3, new Object[]{new q()});
    L7:
        r2 = r0.i().c;
        goto L8
    L11:
        IMAtNodeExtend.a r4 = IMAtNodeExtend.i;
        boolean r5 = ((Boolean) r4.b(new IMAtPlugin$configureSpanFactory$1$isAnonymous$1(r11))).booleanValue();
        IMContextExtend.a r6 = IMContextExtend.A;
        String r7 = (String) r6.b(new IMAtPlugin$configureSpanFactory$1$anonymousUserId$1(r11));
        String r8 = (String) r6.b(new IMAtPlugin$configureSpanFactory$1$currentUserId$1(r11));
        boolean r9 = ((Boolean) r4.b(new IMAtPlugin$configureSpanFactory$1$isOutChatUser$1(r11))).booleanValue();
        boolean r10 = ((Boolean) r4.b(new IMAtPlugin$configureSpanFactory$1$isHighLight$1(r11))).booleanValue();
        com.ss.android.lark.coremd.ext.c r13 = r0.p;
        KProperty<Object>[] r14 = IMAtThemeData.s;
        boolean r15 = ((Boolean) r13.getValue(r0, r14[4])).booleanValue();
        if (r5 == false) goto L14;
        boolean r16 = Intrinsics.areEqual(r7, ((eab.a) r11.d).k);
    L16:
        if (r16 == true) goto L18;
    L20:
        if (r5 == false) goto L23;
        if (r15 == false) goto L23;
        this.a.getClass();
        return new ForegroundColorSpan(UIUtils.getColor(r11.getContext(), ((Number) r0.o.getValue(r0, r14[3])).intValue()));
    L23:
        if (r9 != true) goto L26;
        if (r10 == false) goto L26;
        return o0.f(this.a, r11);
    L26:
        if (r9 == false) goto L29;
        this.a.getClass();
        return new ForegroundColorSpan(UIUtils.getColor(r11.getContext(), ((Number) r0.n.getValue(r0, r14[2])).intValue()));
    L29:
        return o0.f(this.a, r11);
    L18:
        if (((Boolean) r0.f.getValue(r0, LarkAtThemeData.k[2])).booleanValue() == false) goto L20;
        this.a.getClass();
        return com.ss.android.lark.coremdbiz.facade.plugins.a.e(r11, r0);
    L14:
        r16 = Intrinsics.areEqual(r8, ((eab.a) r11.d).k);
        goto L16
    }
}
