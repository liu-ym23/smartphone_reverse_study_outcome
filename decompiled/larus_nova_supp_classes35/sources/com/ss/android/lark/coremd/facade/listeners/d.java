package com.ss.android.lark.coremd.facade.listeners;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.facade.bizext.IMContextExtend;
import com.ss.android.lark.coremd.facade.bizext.IMThemeExtend;
import com.ss.android.lark.coremd.impl.parse.k;
import com.ss.android.lark.widget.light.span.p;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements com.ss.android.lark.coremd.base.parse.f {
    public final int c;
    public final Integer d;

    @Override // com.ss.android.lark.coremd.base.parse.f
    public final void d(k r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    @Override // com.ss.android.lark.coremd.base.parse.f
    public final void f(k r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    public d(int r1, Integer r2) {
        this.c = r1;
        this.d = r2;
    }

    @Override // com.ss.android.lark.coremd.base.parse.f
    public final void a(s r1, Spannable r2) {
        com.ss.android.lark.coremd.base.parse.f.a.b(r1, r2);
    }

    @Override // com.ss.android.lark.coremd.base.parse.f
    public final void b(com.ss.android.lark.coremd.impl.parse.d r1, s r2) {
        com.ss.android.lark.coremd.base.parse.f.a.a(r1, r2);
    }

    @Override // com.ss.android.lark.coremd.base.parse.f
    public final void g(final com.ss.android.lark.coremd.impl.parse.d r6, SpannableStringBuilder r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "charSequence");
        if (((Boolean) IMThemeExtend.s.b(new EditMessageTagListener$onParseEnd$1(r6))).booleanValue() == true) goto L6;
        return;
    L6:
        if (((Boolean) IMContextExtend.A.b(new EditMessageTagListener$onParseEnd$2(r6))).booleanValue() == true) goto L8;
        return;
    L8:
        Set<Class<? extends Object>> r0 = f.a;
        f.b(r7, r6.getContext());
        float r1 = zz7.b.g(r6.getContext(), this.c);
        String r2 = r6.getContext().getString(2131891078);
        SpannableStringBuilder r3 = new SpannableStringBuilder(r2);
        Context r8 = r6.getContext();
        Integer r4 = this.d;
        if (r4 == null) goto L11;
        int r5 = r4.intValue();
    L12:
        r3.setSpan(new c(r2, UIUtils.getColor(r8, r5), r1), 0, r2.length(), 33);
        r3.setSpan(new p(r3, r2), 0, r2.length(), 33);
        r7.append(r3);
        return;
    L11:
        r5 = 2131106607;
        goto L12
    }
}
