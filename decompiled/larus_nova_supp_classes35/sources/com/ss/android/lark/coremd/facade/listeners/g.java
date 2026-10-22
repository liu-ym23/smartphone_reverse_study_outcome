package com.ss.android.lark.coremd.facade.listeners;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import com.ss.android.lark.coremd.facade.bizext.IMContextExtend;
import com.ss.android.lark.coremd.impl.parse.k;
import com.ss.android.lark.widget.span.d0;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g implements com.ss.android.lark.coremd.base.parse.f {
    public g() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.f
    public final void d(k r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    @Override // com.ss.android.lark.coremd.base.parse.f
    public final void f(k r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
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
    public final void g(final com.ss.android.lark.coremd.impl.parse.d r4, SpannableStringBuilder r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "charSequence");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "charSequence");
        if (((Boolean) IMContextExtend.A.b(new MyAICursorLoadingListener$onParseEnd$showCursorLoading$1(r4))).booleanValue() == true) goto L5;
        return;
    L5:
        Set<Class<? extends Object>> r0 = f.a;
        f.b(r5, r4.getContext());
        d0 r6 = new d0();
        int r1 = r5.length();
        r5.append("|");
        r5.setSpan(r6, r1, r5.length(), 17);
    }
}
