package com.obric.aikernel.api;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<Class<?>, ? extends Function0<? extends d>> f4430a;

    public a() {
        this.f4430a = MapsKt.emptyMap();
    }

    protected final synchronized void a(Function1<? super Map<Class<?>, Function0<d>>, Unit> r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "block");     // Catch: Throwable -> L6
        LinkedHashMap r11 = new LinkedHashMap();     // Catch: Throwable -> L6
        r11.putAll(this.f4430a);     // Catch: Throwable -> L6
        r10.invoke(r11);     // Catch: Throwable -> L6
        this.f4430a = r11;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final d b(Class<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "cls");
        Function0<? extends d> r11 = this.f4430a.get(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.invoke();
    }
}
