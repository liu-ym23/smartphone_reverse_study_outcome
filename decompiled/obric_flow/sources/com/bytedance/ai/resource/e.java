package com.bytedance.ai.resource;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f2710a;

    public e(AtomicReference r5) {
        this.f2710a = r5;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r5) {
        Throwable r10 = (Throwable) r5;
        this.f2710a.set(null);
        return Unit.INSTANCE;
    }
}
