package com.bytedance.android.livesdk.chatroom.ui;

import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class y3 implements Function1<com.bytedance.android.livesdk.widget.schedule.c, Unit> {
    public final /* synthetic */ AbsInteractionFragment a;

    public y3(AbsInteractionFragment r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        com.bytedance.android.livesdk.widget.schedule.c r4 = (com.bytedance.android.livesdk.widget.schedule.c) r3;
        rv2.a r0 = this.a.u3;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r0, "actual");
        r4.a = new WeakReference(r0);
        return null;
    }
}
