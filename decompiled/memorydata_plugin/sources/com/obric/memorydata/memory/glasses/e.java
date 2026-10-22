package com.obric.memorydata.memory.glasses;

import android.security.obric.guard.ObricSecurityGuardStub;
import com.obric.aiproactive.api.DoubaoGlassesConnectionSnapshot;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B}\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u001e\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0004\b\u000e\u0010\u000fBM\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0010\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0010\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0004\b\u000e\u0010\u0011J\u000e\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0013J\u0006\u0010\u0019\u001a\u00020\bJ\u0006\u0010\u001a\u001a\u00020\bJ\u0006\u0010\u001b\u001a\u00020\bJ\u0012\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\u0004H\u0002J\u001a\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0015H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/memory/glasses/GlassesObservationSyncLifecycle;", "", "isUserAllowed", "Lkotlin/Function0;", "", "enqueue", "Lkotlin/Function3;", "", "", "scheduleNext", "Lkotlin/Function2;", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "isCellularUploadEnabled", "scheduleDisconnectClear", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "currentSnapshot", "Lcom/obric/aiproactive/api/DoubaoGlassesConnectionSnapshot;", "lastEnqueuedState", "Lkotlin/Triple;", "hasConnectionSnapshot", "onConnectionChanged", "snapshot", "onEligibilityChanged", "onCellularPolicyChanged", "restoreScheduleAfterDebugPull", "reconcile", "forceHotwordsSync", "currentEnqueuedState", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0<Boolean> f10143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function3<Long, Boolean, Boolean, Unit> f10144b;
    private final Function2<Long, Boolean, Unit> c;
    private final Function0<Unit> d;
    private final Function0<Boolean> e;
    private final Function0<Unit> f;
    private DoubaoGlassesConnectionSnapshot g;
    private Triple<Long, Boolean, Boolean> h;
    private boolean i;

    public e(Function0<Boolean> r9, Function3<? super Long, ? super Boolean, ? super Boolean, Unit> r10, Function2<? super Long, ? super Boolean, Unit> r11, Function0<Unit> r12, Function0<Boolean> r13, Function0<Unit> r14) {
        Function0<Boolean> r15 = (Function0) ZeusTransformUtils.wrapperContextForParams(r9, Function0.class, "com.obric.memorydata.plugin");
        Function3<Long, Boolean, Boolean, Unit> r16 = (Function3) ZeusTransformUtils.wrapperContextForParams(r10, Function3.class, "com.obric.memorydata.plugin");
        Function2<Long, Boolean, Unit> r17 = (Function2) ZeusTransformUtils.wrapperContextForParams(r11, Function2.class, "com.obric.memorydata.plugin");
        Function0<Unit> r18 = (Function0) ZeusTransformUtils.wrapperContextForParams(r12, Function0.class, "com.obric.memorydata.plugin");
        Function0<Boolean> r19 = (Function0) ZeusTransformUtils.wrapperContextForParams(r13, Function0.class, "com.obric.memorydata.plugin");
        Function0<Unit> r110 = (Function0) ZeusTransformUtils.wrapperContextForParams(r14, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r15, "isUserAllowed");
        Intrinsics.checkNotNullParameter(r16, "enqueue");
        Intrinsics.checkNotNullParameter(r17, "scheduleNext");
        Intrinsics.checkNotNullParameter(r18, ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL);
        Intrinsics.checkNotNullParameter(r19, "isCellularUploadEnabled");
        Intrinsics.checkNotNullParameter(r110, "scheduleDisconnectClear");
        this.f10143a = r15;
        this.f10144b = r16;
        this.c = r17;
        this.d = r18;
        this.e = r19;
        this.f = r110;
        this.g = new DoubaoGlassesConnectionSnapshot(false, 0, false, 4, null);
    }

    static /* synthetic */ void a(e r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) != 0) goto L5;
    L8:
        r0.a(r1);
        return;
    L5:
        if (r0.h != null) goto L7;
        r1 = true;
        goto L8
    L7:
        r1 = false;
        goto L8
    }

    private final void a(boolean r7) {
        long r0 = this.g.getGeneration();
        if (this.g.getConnected() == true) goto L5;
    L16:
        this.h = null;
        return;
    L5:
        if (r0 <= 0) goto L16;
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.f10143a.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L11;
        this.d.invoke();
        this.h = null;
        return;
    L11:
        Triple<Long, Boolean, Boolean> r2 = c();
        if (Intrinsics.areEqual(this.h, r2) == false) goto L14;
        return;
    L14:
        this.f10144b.invoke(Long.valueOf(r0), Boolean.valueOf(this.g.getWearing()), Boolean.valueOf(r7));
        this.h = r2;
    }

    private final Triple<Long, Boolean, Boolean> c() {
        return new Triple(Long.valueOf(this.g.getGeneration()), Boolean.valueOf(this.g.getWearing()), this.e.invoke());
    }

    public final synchronized void a() {
        monitor-enter(this);
        a(this, false, 1, null);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(DoubaoGlassesConnectionSnapshot r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "snapshot");     // Catch: Throwable -> L26
        if (r5.getGeneration() >= this.g.getGeneration()) goto L8;
        monitor-exit(this);
        return;
    L8:
        boolean r0 = this.i;     // Catch: Throwable -> L26
        boolean r1 = this.g.getConnected();     // Catch: Throwable -> L26
        this.g = r5;     // Catch: Throwable -> L26
        boolean r2 = true;
        this.i = true;     // Catch: Throwable -> L26
        if (r5.getConnected() == true) goto L20;
        if (r0 == true) goto L13;
        this.d.invoke();     // Catch: Throwable -> L26
        this.h = null;     // Catch: Throwable -> L26
    L17:
        monitor-exit(this);
        return;
    L13:
        if (r1 == false) goto L17;
        this.d.invoke();     // Catch: Throwable -> L26
        this.h = null;     // Catch: Throwable -> L26
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.f10143a.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L17;
        this.f.invoke();     // Catch: Throwable -> L26
        goto L17
    L20:
        if (this.h == null) goto L23;
        r2 = false;
    L23:
        a(r2);     // Catch: Throwable -> L26
        monitor-exit(this);
        return;
    L26:
        th = move-exception;
        throw th;
    }

    public final synchronized void b() {
        monitor-enter(this);
        Triple<Long, Boolean, Boolean> r0 = c();     // Catch: Throwable -> L15
        Triple<Long, Boolean, Boolean> r1 = this.h;     // Catch: Throwable -> L15
        if (r1 == null) goto L12;
        if (Intrinsics.areEqual(r1, r0) == true) goto L12;
        this.d.invoke();     // Catch: Throwable -> L15
        this.h = null;     // Catch: Throwable -> L15
        a(false);     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L12:
        a(this, false, 1, null);     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }
}
