package com.bytedance.android.livesdk.interactivity.like.controller;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.config.e2;
import kotlin.jvm.internal.Intrinsics;
import u32.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends h {
    public static final /* synthetic */ int b = 0;
    public State a;

    public static final class a {
    }

    static {
        s1.f(40.800003f);
        s1.f(35.7f);
        s1.f(4.6f);
        s1.f(6.65f);
        s1.f(50.0f);
        s1.f(50.0f);
        s1.f(46.0f);
        s1.f(42.0f);
        s1.f(18.0f);
        s1.f(66.0f);
        s1.f(6.0f);
        s1.f(24.0f);
        s1.f(22.0f);
    }

    public final void d(int r3) {
        if (this.a.compareTo(State.ENDING) < 0) goto L6;
        return;
    L6:
        if (r3 >= ((Integer) e2.a.getValue()).intValue()) goto L15;
        State r4 = this.a;
        if (r4 != State.SHOWING) goto L10;
    L13:
        Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        throw null;
    L10:
        if (r4 == State.PROGRESS) goto L13;
        throw null;
    L15:
        State r5 = this.a;
        if (r5 != State.TURNING_LARGE) goto L18;
        return;
    L18:
        if (r5 == State.LARGE) goto L22;
        throw null;
    }
}
