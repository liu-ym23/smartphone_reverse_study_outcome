package com.bytedance.ai.debugscene;

import com.bytedance.ai.model.objects.Applet;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class x implements Function1<Throwable, Unit> {
    public final /* synthetic */ kotlinx.coroutines.i<Applet> a;

    public x(kotlinx.coroutines.j r1) {
        this.a = r1;
    }

    public final Object invoke(Object r10) {
        Intrinsics.checkNotNullParameter((Throwable) r10, "it");
        this.a.resumeWith(Result.constructor-impl(null));
        return Unit.INSTANCE;
    }
}
