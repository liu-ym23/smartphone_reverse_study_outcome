package com.bytedance.android.live.broadcastgame.xplay.floatwindow;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.broadcastgame.api.xplay.LittleWindowPos;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public View e;
    public boolean f;
    public Pair<? extends LittleWindowPos, Integer> g;
    public int h;

    public final void a() {
        View r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L17;
        FrameLayout.LayoutParams r2 = (FrameLayout.LayoutParams) r1;
        int r3 = this.b;
        r2.leftMargin = r3;
        r2.rightMargin = r3;
        if (this.f == false) goto L10;
        r2.topMargin = r3;
        r2.bottomMargin = r3;
    L14:
        r0.setLayoutParams(r2);
        return;
    L10:
        r2.bottomMargin = (this.h + this.d) + this.a;
        if (((LittleWindowPos) this.g.getFirst()) != LittleWindowPos.TOP) goto L13;
        r2.topMargin = Math.max(this.c, ((Number) this.g.getSecond()).intValue()) + this.a;
        goto L14
    L13:
        r2.topMargin = this.c + this.a;
        goto L14
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    public c(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        i16.c r0 = i16.c.a;
        this.a = MathKt.roundToInt(i16.c.e(r3, 8.0f));
        this.b = MathKt.roundToInt(i16.c.e(r3, 12.0f));
        int r1 = MathKt.roundToInt(i16.c.e(r3, 22.0f));
        this.c = MathKt.roundToInt(i16.c.e(r3, 124.0f));
        this.d = r1;
        this.g = TuplesKt.to(LittleWindowPos.TOP, 0);
    }
}
