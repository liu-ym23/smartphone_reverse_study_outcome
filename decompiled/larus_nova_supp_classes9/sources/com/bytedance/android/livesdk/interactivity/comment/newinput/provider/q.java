package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.view.View;
import com.bytedance.android.live.core.widget.HSImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q implements View.OnClickListener {
    public final /* synthetic */ e.c a;

    public q(e.c r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        e.c r4 = this.a;
        if (r4.j == false) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.interactivity.api.monitor.b.b(r4.m(), "landscape", -2);
        if (e.c.g(this.a) == false) goto L10;
        e.c r5 = this.a;
        if (r5.q == false) goto L10;
        r5.h();
        return;
    L10:
        e.c r6 = this.a;
        if (r6.q == false) goto L15;
        HSImageView r7 = r6.c;
        if (r7 == null) goto L15;
        r7.setActualImageResource(2131251924);
    L15:
        com.bytedance.android.live.profit.privilege.a r8 = this.a.i;
        if (r8 == null) goto L18;
        r8.jl();
    L18:
        this.a.j = true;
    }
}
