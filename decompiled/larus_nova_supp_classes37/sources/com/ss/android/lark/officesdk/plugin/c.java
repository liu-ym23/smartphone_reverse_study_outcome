package com.ss.android.lark.officesdk.plugin;

import io.reactivex.Completable;
import io.reactivex.functions.Action;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c implements Action {
    public final /* synthetic */ ConcurrentHashMap<String, Completable> a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Ref.ObjectRef<Completable> c;

    public c(ConcurrentHashMap<String, Completable> r1, String r2, Ref.ObjectRef<Completable> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void run() {
        ConcurrentHashMap<String, Completable> r0 = this.a;
        String r1 = this.b;
        Ref.ObjectRef<Completable> r2 = this.c;
        monitor-enter(r0);
        Completable r3 = r0.get(r1);     // Catch: Throwable -> L13
        Object r4 = r2.element;     // Catch: Throwable -> L13
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("task");     // Catch: Throwable -> L13
        Completable r5 = null;
    L8:
        if (r3 != r5) goto L10;
        r0.remove(r1);     // Catch: Throwable -> L13
    L10:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r0);
        return;
    L7:
        r5 = (Completable) r4;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }
}
