package com.obric.memorydata.database.c;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J>\u0010\r\u001a\u00020\f26\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\f0\u000bJ\u0006\u0010\u0013\u001a\u00020\u0006J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0006H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR&\u0010\t\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/database/review/MemoryReviewEntryGate;", "", "<init>", "()V", "enabledChecker", "Lkotlin/Function0;", "", "lastEnabled", "Ljava/lang/Boolean;", "enabledChangeListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Function2;", "", "registerEnabledChangeListener", "listener", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "oldEnabled", "newEnabled", "isEnabled", "notifyEnabledChangedIfNeeded", "enabled", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8850a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Function0<Boolean> f8851b = null;
    private static volatile Boolean c;
    private static final CopyOnWriteArrayList<Function2<Boolean, Boolean, Unit>> d = null;

    static {
        f8850a = new b();
        f8851b = $$Lambda$b$63l8pophSZFalbfB01UzMxUAuAw.INSTANCE;
        d = new CopyOnWriteArrayList();
        c.f8852a.a();
    }

    private b() {
    }

    private final void a(boolean r5) {
        monitor-enter(this);
        Boolean r0 = c;     // Catch: Throwable -> L24
        boolean r2 = false;
        if (Intrinsics.areEqual(r0, Boolean.valueOf(r5)) == false) goto L6;
    L5:
        boolean r1 = false;
    L12:
        monitor-exit(this);
        if (r1 == true) goto L15;
        return;
    L15:
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(d, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L17:
        if (r4.hasNext() == false) goto L23;
        Function2 r3 = (Function2) ZeusTransformUtils.preCheckCast(r4.next(), Function2.class, "com.obric.memorydata.plugin");
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L21
        r3.invoke(Boolean.valueOf(r2), Boolean.valueOf(r5));     // Catch: Throwable -> L21
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L17
    L23:
        return;
    L6:
        if (r0 != null) goto L9;
        if (r5 == true) goto L9;
        c = Boolean.valueOf(r5);     // Catch: Throwable -> L24
    L9:
        c = Boolean.valueOf(r5);     // Catch: Throwable -> L24
        r1 = true;
        if (r0 == null) goto L12;
        r2 = r0.booleanValue();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    private static final boolean b() {
        return c.f8852a.b();
    }

    public static /* synthetic */ boolean lambda$63l8pophSZFalbfB01UzMxUAuAw() {
        return b();
    }

    public final void a(Function2<? super Boolean, ? super Boolean, Unit> r2) {
        Function2<Boolean, Boolean, Unit> r1 = (Function2) ZeusTransformUtils.wrapperContextForParams(r2, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "listener");
        d.add(r1);
    }

    public final boolean a() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        b r2 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r3 = Result.m1421constructorimpl(Boolean.valueOf(((Boolean) ZeusTransformUtils.preCheckCast(f8851b.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue()));     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r3) == false) goto L10;
        r3 = false;
    L10:
        boolean r0 = ((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        a(r0);
        return r0;
    L5:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
