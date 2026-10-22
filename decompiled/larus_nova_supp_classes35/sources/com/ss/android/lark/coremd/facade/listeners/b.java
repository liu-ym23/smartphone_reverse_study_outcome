package com.ss.android.lark.coremd.facade.listeners;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.impl.parse.k;
import com.ss.android.lark.widget.light.span.p;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements com.ss.android.lark.coremd.base.parse.f {
    public b() {
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
    public final void g(com.ss.android.lark.coremd.impl.parse.d r6, SpannableStringBuilder r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "charSequence");
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "charSequence");
        if (DevEnvUtil.isDebugMode(r6.getContext()) == false) goto L6;
        Set<Class<? extends Object>> r0 = f.a;
        f.b(r7, r6.getContext());
        float r1 = zz7.b.g(r6.getContext(), 12);
        SpannableStringBuilder r2 = new SpannableStringBuilder("(new text)");
        r2.setSpan(new a(r1, UIUtils.getColor(r6.getContext(), 2131106607)), 0, 10, 33);
        r2.setSpan(new p(r2, "(new text)"), 0, 10, 33);
        int r8 = com.ss.android.lark.coremd.utils.b.a;
        r7.append("\u2060");
        r7.append(r2);
        return;
    }
}
