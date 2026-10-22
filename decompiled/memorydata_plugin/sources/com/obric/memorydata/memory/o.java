package com.obric.memorydata.memory;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003J\u0016\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003J\u0006\u0010\u000e\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/memory/InAppSignalRegistrationController;", "", "isDebug", "", "register", "Lkotlin/Function0;", "unregister", "isDebugCollectionEnabled", "<init>", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "registered", "refresh", "reviewEnabled", "traceCollectEnabled", "isRegistered", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f10334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0<Boolean> f10335b;
    private final Function0<Boolean> c;
    private final Function0<Boolean> d;
    private boolean e;

    public o(boolean r3, Function0<Boolean> r4, Function0<Boolean> r5, Function0<Boolean> r6) {
        Function0<Boolean> r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Function0<Boolean> r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Function0<Boolean> r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "register");
        Intrinsics.checkNotNullParameter(r8, "unregister");
        Intrinsics.checkNotNullParameter(r9, "isDebugCollectionEnabled");
        this.f10334a = r3;
        this.f10335b = r7;
        this.c = r8;
        this.d = r9;
    }

    public final synchronized boolean a() {
        monitor-enter(this);
        boolean r0 = this.e;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean a(boolean r4, boolean r5) {
        monitor-enter(this);
        boolean r0 = true;
        if (r5 == false) goto L11;
        if (r4 == false) goto L28;
    L10:
        boolean r6 = true;
    L12:
        boolean r7 = this.e;     // Catch: Throwable -> L25
        if (r6 != r7) goto L16;
        monitor-exit(this);
        return r7;
    L16:
        if (r6 == false) goto L19;
        r0 = ((Boolean) ZeusTransformUtils.preCheckCast(this.f10335b.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();     // Catch: Throwable -> L25
    L22:
        this.e = r0;     // Catch: Throwable -> L25
        monitor-exit(this);
        return r0;
    L25:
        th = move-exception;
        throw th;
    L19:
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.c.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L22;
        r0 = false;
        goto L22
    L28:
        if (this.f10334a == false) goto L11;
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.d.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L10;
    L11:
        r6 = false;
        goto L12
    }
}
