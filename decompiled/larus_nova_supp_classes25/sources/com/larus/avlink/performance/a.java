package com.larus.avlink.performance;

import com.larus.avlink.model.FlowDoraSceneState;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public final CoroutineScope a;
    public final Function0<Unit> b;
    public final Function1<b, Unit> c;
    public Boolean d;
    public boolean e;
    public final Set<Integer> f;
    public String g;
    public Job h;

    /* JADX INFO: renamed from: com.larus.avlink.performance.a$a, reason: collision with other inner class name */
    public static final class C0019a {
    }

    static {
    }

    public final synchronized void a() {
        monitor-enter(this);
        Boolean r0 = this.d;     // Catch: Throwable -> L23
        Boolean r1 = Boolean.FALSE;     // Catch: Throwable -> L23
        if (Intrinsics.areEqual(r0, r1) == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.e == false) goto L10;
    L16:
        Job r2 = this.h;     // Catch: Throwable -> L23
        if (r2 == null) goto L19;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);     // Catch: Throwable -> L23
    L19:
        this.h = BuildersKt.launch$default(this.a, null, null, new DoraIdleSceneCompat$scheduleDisconnectReset$1(this, null), 3, null);     // Catch: Throwable -> L23
    L20:
        this.d = r1;     // Catch: Throwable -> L23
        c();     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L10:
        if ((!this.f.isEmpty()) == true) goto L16;
        Job r3 = this.h;     // Catch: Throwable -> L23
        if (r3 == null) goto L15;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);     // Catch: Throwable -> L23
    L15:
        this.h = null;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    public final void c() {
        if (this.e == false) goto L5;
    L11:
        String r0 = null;
    L13:
        if (Intrinsics.areEqual(r0, this.g) == false) goto L15;
        return;
    L15:
        String r3 = this.g;
        if (r3 == null) goto L18;
        this.c.invoke(new b(r3, 2, null));
    L18:
        this.g = r0;
        if (r0 == null) goto L22;
        this.c.invoke(new b(r0, 1, null));
        return;
    L22:
        return;
    L5:
        if ((!this.f.isEmpty()) == true) goto L11;
        if (Intrinsics.areEqual(this.d, Boolean.TRUE) == false) goto L10;
        r0 = "998";
        goto L13
    L10:
        r0 = "999";
        goto L13
    }

    public final synchronized void b(int r2, @FlowDoraSceneState int r3) {
        monitor-enter(this);
        if (r3 != 1) goto L6;
        this.f.add(Integer.valueOf(r2));     // Catch: Throwable -> L14
    L11:
        c();     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L6:
        if (r3 == 2) goto L9;
        monitor-exit(this);
        return;
    L9:
        this.f.remove(Integer.valueOf(r2));     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public a(CoroutineScope r2, e r3, f r4) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "onDisconnectReset");
        Intrinsics.checkNotNullParameter(r4, "onIdleSceneStateChange");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.f = new LinkedHashSet();
    }
}
