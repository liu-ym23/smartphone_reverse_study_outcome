package com.bytedance.android.livesdk.chatroom.ui;

import android.view.View;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c7 implements View.OnClickListener {
    public final /* synthetic */ LandscapeVideoQualityViewHolder a;
    public final /* synthetic */ l5 b;
    public final /* synthetic */ Function1 c;

    public c7(LandscapeVideoQualityViewHolder r1, l5 r2, Function1 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.T3(this.b);
        this.c.invoke(this.b.b);
    }
}
