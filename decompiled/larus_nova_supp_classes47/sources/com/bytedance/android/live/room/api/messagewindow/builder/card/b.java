package com.bytedance.android.live.room.api.messagewindow.builder.card;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public Function0<Unit> a;
    public final int b;
    public final CommonCardBuilder.b c;
    public final CommonCardBuilder.a d;
    public final CommonCardBuilder.d e;
    public final CommonCardBuilder.c f;
    public String g;

    public final void a() {
        Function0<Unit> r0 = this.a;
        if (r0 == null) goto L6;
        Unit r1 = (Unit) r0.invoke();
        return;
    }

    public final int getType() {
        return this.b;
    }

    public b(int r2, CommonCardBuilder.b r3, CommonCardBuilder.a r4, CommonCardBuilder.d r5, CommonCardBuilder.c r6) {
        Intrinsics.checkNotNullParameter(r3, "failCallback");
        Intrinsics.checkNotNullParameter(r4, "animCallback");
        Intrinsics.checkNotNullParameter(r5, "lifeCycleCallback");
        Intrinsics.checkNotNullParameter(r6, "hideReasonCallback");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = null;
    }
}
