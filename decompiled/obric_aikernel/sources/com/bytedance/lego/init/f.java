package com.bytedance.lego.init;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
final class f implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ Function0 f2084c;

    f(Function0 r10) {
        this.f2084c = r10;
    }

    @Override // java.lang.Runnable
    public final /* synthetic */ void run() {
        Intrinsics.checkExpressionValueIsNotNull(this.f2084c.invoke(), "invoke(...)");
    }
}
