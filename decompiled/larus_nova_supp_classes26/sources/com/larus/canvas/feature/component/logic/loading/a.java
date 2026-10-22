package com.larus.canvas.feature.component.logic.loading;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final CoroutineScope a;
    public final int b;
    public final double c;
    public final float d;
    public final StateFlowImpl e;
    public final b1 f;
    public Job g;

    /* JADX INFO: renamed from: com.larus.canvas.feature.component.logic.loading.a$a, reason: collision with other inner class name */
    public static final class C0093a {
    }

    static {
    }

    public a(CoroutineScope r3) {
        Intrinsics.checkNotNullParameter(r3, "scope");
        this.a = r3;
        this.b = 99;
        this.c = 3.0d;
        this.d = 0.0f;
        StateFlowImpl r4 = j1.a(0);
        this.e = r4;
        this.f = e.b(r4);
    }
}
