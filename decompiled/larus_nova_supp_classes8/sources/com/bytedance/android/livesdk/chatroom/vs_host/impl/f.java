package com.bytedance.android.livesdk.chatroom.vs_host.impl;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f implements vr1.f {
    public final com.bytedance.android.livesdk.interactivity.api.expression.b a;

    public final View b() {
        return this.a.getView();
    }

    public f(com.bytedance.android.livesdk.interactivity.api.expression.b r2) {
        Intrinsics.checkNotNullParameter(r2, "realExpressionBoard");
        this.a = r2;
    }

    @Override // vr1.f
    public final void a(boolean r4) {
        com.bytedance.android.livesdk.widget.newboard.f r0 = this.a;
        r0.getClass();
        if (r4 == false) goto L5;
        float r1 = 1.0f;
    L6:
        ImageView r2 = (ImageView) r0.a(2131371524);
        if (r2 == null) goto L9;
        r2.setEnabled(r4);
        r2.setAlpha(r1);
    L9:
        TextView r3 = (TextView) r0.a(2131371547);
        if (r3 == null) goto L13;
        r3.setEnabled(r4);
        r3.setAlpha(r1);
        return;
    L13:
        return;
    L5:
        r1 = 0.34f;
        goto L6
    }
}
