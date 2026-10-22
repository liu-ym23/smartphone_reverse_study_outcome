package com.ss.android.lark.officesdk.minutes.ui.record.bubble;

import android.app.Activity;
import android.view.View;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements View.OnAttachStateChangeListener {
    public final /* synthetic */ Ref.BooleanRef a;
    public final /* synthetic */ Ref.BooleanRef b;
    public final /* synthetic */ Ref.ObjectRef<qub.a> c;
    public final /* synthetic */ qub.b d;
    public final /* synthetic */ Activity e;
    public final /* synthetic */ rub.a f;
    public final /* synthetic */ Ref.BooleanRef g;
    public final /* synthetic */ Ref.ObjectRef<View.OnAttachStateChangeListener> h;
    public final /* synthetic */ View i;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r14) {
        Intrinsics.checkNotNullParameter(r14, "v");
        int r15 = bwb.b.a;
        bwb.b.g(MmUiLogScene.OVERLAY, "showBubble", "anchor attached, show pending bubble", null, 8);
        c.d(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r12) {
        Intrinsics.checkNotNullParameter(r12, "v");
        int r13 = bwb.b.a;
        bwb.b.g(MmUiLogScene.OVERLAY, "showBubble", "anchor detached", null, 8);
        c.a(this.a, this.b, this.c, this.g, this.h, this.i, "anchorDetached");
    }

    public a(Ref.BooleanRef r1, Ref.BooleanRef r2, Ref.ObjectRef<qub.a> r3, qub.b r4, Activity r5, rub.a r6, Ref.BooleanRef r7, Ref.ObjectRef<View.OnAttachStateChangeListener> r8, View r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }
}
