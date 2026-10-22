package com.bytedance.ies.bullet.lynx;

import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Lambda f5635b;

    /* JADX WARN: Multi-variable type inference failed */
    public g(int r5, Function0 r10) {
        this.f5634a = r5;
        switch(r5) {
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        this.f5635b = (Lambda) r10;
        return;
    L6:
        this.f5635b = (Lambda) r10;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r1v3, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch(this.f5634a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        this.f5635b.invoke();
        return Unit.INSTANCE;
    L6:
        this.f5635b.invoke();
        return Unit.INSTANCE;
    }
}
