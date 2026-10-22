package com.bytedance.ai.applet.moa;

import android.content.Context;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h {
    public final g a;
    public final String b;
    public final boolean c;
    public WeakReference<Context> d;
    public Function0<Unit> e;
    public n f;
    public Job g;

    public final o a() {
        g r1 = this.a;
        return new o(r1.c, r1.b, this.b, this.d);
    }

    public final g getContext() {
        return this.a;
    }

    public h(g r10, String r11, boolean r12, WeakReference<Context> r13, Function0<Unit> r14) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "attemptID");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
    }
}
