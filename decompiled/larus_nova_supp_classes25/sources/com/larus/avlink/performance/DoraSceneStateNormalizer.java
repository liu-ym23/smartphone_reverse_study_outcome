package com.larus.avlink.performance;

import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class DoraSceneStateNormalizer {
    public static final /* synthetic */ int g = 0;
    public final CoroutineScope a;
    public final Function1<b, Unit> b;
    public final Function0<Unit> c;
    public Job d;
    public b e;
    public final LinkedHashMap<String, b> f;

    public static final class a {
    }

    static {
    }

    public final synchronized void a() {
        monitor-enter(this);
        Job r0 = this.d;     // Catch: Throwable -> L9
        if (r0 == null) goto L6;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);     // Catch: Throwable -> L9
    L6:
        this.d = null;     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized void e() {
        monitor-enter(this);
        FLogger.a.e("DoraSceneStateNormalizer", "reset overlapped dora scene record, reason:overlap timeout, currentScene:" + this.e + ", activeScenes:" + this.f);     // Catch: Throwable -> L10
        Job r0 = this.d;     // Catch: Throwable -> L10
        if (r0 == null) goto L7;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);     // Catch: Throwable -> L10
    L7:
        this.d = null;     // Catch: Throwable -> L10
        this.e = null;     // Catch: Throwable -> L10
        this.f.clear();     // Catch: Throwable -> L10
        this.c.invoke();     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void f() {
        boolean r2 = true;
        if (this.e != null) goto L5;
    L17:
        Job r0 = this.d;
        if (r0 == null) goto L20;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L20:
        this.d = null;
        return;
    L5:
        if (this.f.size() <= 1) goto L17;
        Job r1 = this.d;
        if (r1 != null) goto L10;
    L12:
        r2 = false;
    L13:
        if (r2 == false) goto L15;
        return;
    L15:
        this.d = BuildersKt.launch$default(this.a, null, null, new DoraSceneStateNormalizer$scheduleOverlapTimeout$1(this, null), 3, null);
        return;
    L10:
        if (r1.isActive() != true) goto L12;
        goto L12
    }

    public final void b(b r4) {
        this.f.put(r4.a, r4);
        b r0 = this.e;
        if (r0 != null) goto L7;
        this.e = r4;
        this.b.invoke(r4);
        return;
    L7:
        if (Intrinsics.areEqual(r4.a, r0.a) == false) goto L10;
        FLogger.a.d("DoraSceneStateNormalizer", "skip duplicate enter scene, scene:" + r4.a);
        return;
    L10:
        f();
    }

    public final void c(b r4) {
        if (this.f.remove(r4.a) != null) goto L6;
        FLogger.a.e("DoraSceneStateNormalizer", "skip bad exit scene case, scene:" + r4.a);
        return;
    L6:
        String r0 = r4.a;
        b r1 = this.e;
        if (r1 == null) goto L9;
        String r2 = r1.a;
    L11:
        if (Intrinsics.areEqual(r0, r2) == true) goto L14;
        f();
        return;
    L14:
        this.b.invoke(r4);
        this.e = null;
        Job r5 = this.d;
        if (r5 == null) goto L17;
        Job.DefaultImpls.cancel$default(r5, null, 1, null);
    L17:
        this.d = null;
        b r6 = (b) CollectionsKt.firstOrNull(this.f.values());
        if (r6 == null) goto L22;
        this.e = r6;
        this.b.invoke(r6);
        f();
        return;
    L22:
        return;
    L9:
        r2 = null;
        goto L11
    }

    public final synchronized void d(b r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "event");     // Catch: Throwable -> L18
        int r1 = r5.b;     // Catch: Throwable -> L18
        if (r1 != 1) goto L7;
    L11:
        if (r1 != 1) goto L15;
        b(r5);     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L15:
        c(r5);     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L7:
        if (r1 == 2) goto L11;
        FLogger.a.d("DoraSceneStateNormalizer", "skip unknown scene state record, event:" + r5);     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public DoraSceneStateNormalizer(CoroutineScope r2, c r3, d r4) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "onNormalizedStateChange");
        Intrinsics.checkNotNullParameter(r4, "onBadCaseReset");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.f = new LinkedHashMap();
    }
}
