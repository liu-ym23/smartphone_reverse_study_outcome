package com.bytedance.android.livesdk.chatroom.ui;

import android.view.MotionEvent;
import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u3 implements Function1<MotionEvent, Unit> {
    public final /* synthetic */ AbsInteractionFragment.d a;

    public u3(AbsInteractionFragment.d r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        AbsInteractionFragment r0 = this.a.a;
        AbsInteractionFragment.j r1 = r0.m4;
        View r2 = r0.F3;
        r1.onTouch(r2, (MotionEvent) r3);
        return Unit.INSTANCE;
    }
}
