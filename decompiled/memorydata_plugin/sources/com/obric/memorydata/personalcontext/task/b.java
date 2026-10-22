package com.obric.memorydata.personalcontext.task;

import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0004R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/personalcontext/task/EntityConsistencyRecoveryState;", "", "load", "Lkotlin/Function0;", "Lcom/obric/memorydata/personalcontext/task/EntityConsistencyRecoveryDemand;", "persist", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", Ext.KEY_REQUEST, "syncDonateApp", "", "snapshot", "complete", "expected", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0<a> f12355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1<a, Unit> f12356b;

    public b(Function0<a> r3, Function1<? super a, Unit> r4) {
        Function0<a> r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Function1<a, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "load");
        Intrinsics.checkNotNullParameter(r6, "persist");
        this.f12355a = r5;
        this.f12356b = r6;
    }

    public final synchronized a a() {
        monitor-enter(this);
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.f12355a.invoke(), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized a a(boolean r4) {
        monitor-enter(this);
        a r5 = ((a) ZeusTransformUtils.preCheckCast(this.f12355a.invoke(), a.class, "com.obric.memorydata.plugin")).a(r4);     // Catch: Throwable -> L6
        this.f12356b.invoke(r5);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(a r4) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r4, "expected");     // Catch: Throwable -> L8
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.f12355a.invoke(), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        a r5 = r0.a(r4);     // Catch: Throwable -> L8
        if (Intrinsics.areEqual(r5, r0) == true) goto L6;
        this.f12356b.invoke(r5);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
