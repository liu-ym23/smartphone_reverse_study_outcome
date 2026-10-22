package com.obric.aikernel.api.base;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
final class PluginExtensions$setActiveStateByProcess$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ boolean $active;
    final /* synthetic */ String $process;
    final /* synthetic */ d this$0;

    PluginExtensions$setActiveStateByProcess$1(d r10, boolean r11, String r12) {
        this.this$0 = r10;
        this.$active = r11;
        this.$process = r12;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        d r10 = this.this$0;
        boolean r11 = this.$active;
        String r12 = this.$process;
        monitor-enter(r10);
        boolean r13 = !d.a(r10).isEmpty();     // Catch: Throwable -> L14
        if (r11 == false) goto L7;
        d.a(r10).add(r12);     // Catch: Throwable -> L14
    L8:
        boolean r14 = !d.a(r10).isEmpty();     // Catch: Throwable -> L14
        if (r13 == r14) goto L11;
        r10.d(r14);     // Catch: Throwable -> L14
    L11:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r10);
        return;
    L7:
        d.a(r10).remove(r12);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }
}
