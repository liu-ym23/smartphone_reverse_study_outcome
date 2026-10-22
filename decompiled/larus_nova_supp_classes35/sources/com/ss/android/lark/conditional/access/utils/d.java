package com.ss.android.lark.conditional.access.utils;

import android.content.Context;
import android.text.TextPaint;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements u8b.c.a {
    public final /* synthetic */ View.OnClickListener a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ String c;

    @Override // u8b.c.a
    public final void Vg(TextPaint r2) {
        Intrinsics.checkNotNullParameter(r2, "ds");
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        View.OnClickListener r0 = this.a;
        if (r0 == null) goto L5;
        r0.onClick(r2);
    L5:
        int r3 = g.a;
        g.a(this.b, this.c);
    }

    public d(PrivacyPolicyUtils$mustache$provider$1.a r1, Context r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
