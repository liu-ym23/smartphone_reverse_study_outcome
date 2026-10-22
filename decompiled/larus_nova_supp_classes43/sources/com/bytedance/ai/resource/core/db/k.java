package com.bytedance.ai.resource.core.db;

import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k implements Callable<Unit> {
    public final /* synthetic */ List a;
    public final /* synthetic */ j b;

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public Unit call2() throws Exception {
        this.b.b.beginTransaction();
        this.b.f.handleMultiple(this.a);     // Catch: Throwable -> L6
        this.b.b.setTransactionSuccessful();     // Catch: Throwable -> L6
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L6
        this.b.b.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.b.b.endTransaction();
        throw th;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Unit call() throws Exception {
        return call2();
    }

    public k(j r1, List r10) {
        this.b = r1;
        this.a = r10;
    }
}
