package com.larus.bmhome.taskskill.ui;

import com.larus.bmhome.share.panel.ShareType;
import com.larus.flowskill.impl.databinding.LarusLayoutTaskSkillStateBinding;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class q {
    public static final /* synthetic */ int b = 0;
    public final LarusLayoutTaskSkillStateBinding a;

    public static final class a {
    }

    static {
    }

    public final void a() {
        this.a.a.setVisibility(8);
    }

    public final void c() {
        this.a.c.setImageResource(2131242112);
        this.a.d.setText(2131897941);
        this.a.b.setVisibility(0);
        this.a.a.setVisibility(0);
    }

    public q(LarusLayoutTaskSkillStateBinding r2, final Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        Intrinsics.checkNotNullParameter(r3, "onRetry");
        this.a = r2;
        r2.b.setOnClickListener(new p(r3));
    }

    public final void b(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, ShareType.TEXT);
        this.a.c.setImageResource(r2);
        this.a.d.setText(r3);
        this.a.b.setVisibility(8);
        this.a.a.setVisibility(0);
    }
}
