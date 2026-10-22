package com.obric.memorydata.memory.ui.settings;

import android.app.Activity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.settings.MemorySettingsStore$initializeProactiveShortcutOnHome$2", f = "MemorySettingsStore.kt", i = {0, 1}, l = {1120, 376}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
final class MemorySettingsStore$initializeProactiveShortcutOnHome$2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ String $uid;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ l this$0;

    MemorySettingsStore$initializeProactiveShortcutOnHome$2(l r3, Activity r4, String r5, Continuation<? super MemorySettingsStore$initializeProactiveShortcutOnHome$2> r6) {
        Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$activity = ZeusTransformUtils.wrapperContext2Activity(r7, "com.obric.memorydata.plugin");
        this.$uid = r5;
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new MemorySettingsStore$initializeProactiveShortcutOnHome$2(this.this$0, this.$activity, this.$uid, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((MemorySettingsStore$initializeProactiveShortcutOnHome$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MemorySettingsStore$initializeProactiveShortcutOnHome$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L13;
        if (r1 != 2) goto L12;
        String r2 = (String) ZeusTransformUtils.preCheckCast(this.L$3, String.class, "com.obric.memorydata.plugin");
        Activity r3 = (Activity) ZeusTransformUtils.preCheckCast(this.L$2, Activity.class, "com.obric.memorydata.plugin");
        l r4 = (l) ZeusTransformUtils.preCheckCast(this.L$1, l.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.sync.a r11 = (kotlinx.coroutines.sync.a) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.sync.a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L9
    L25:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r12, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L27;
    L30:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L9
        r11.b(null);
        return Unit.INSTANCE;
    L27:
        if (l.a(r4, r3, r2) == false) goto L30;
        l.a(r4, r3);     // Catch: Throwable -> L9
    L9:
        Throwable th = th;
    L35:
        r11.b(null);
        throw th;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        String r5 = (String) ZeusTransformUtils.preCheckCast(this.L$3, String.class, "com.obric.memorydata.plugin");
        Activity r6 = (Activity) ZeusTransformUtils.preCheckCast(this.L$2, Activity.class, "com.obric.memorydata.plugin");
        l r7 = (l) ZeusTransformUtils.preCheckCast(this.L$1, l.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.sync.a r8 = (kotlinx.coroutines.sync.a) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.sync.a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r12);
        kotlinx.coroutines.sync.a r14 = r8;
    L37:
    L33:
        th = move-exception;
        kotlinx.coroutines.sync.a r10 = r14;
        th = th;
        r11 = r10;
        goto L35
    L19:
        if (l.a(r7, r6, r5) == false) goto L29;
        CoroutineContext r9 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        Function2 r15 = (Function2) ZeusTransformUtils.preCheckCast(new MemorySettingsStore$initializeProactiveShortcutOnHome$2$1$approved$1(r5, r6, null), Function2.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        this.L$0 = r14;     // Catch: Throwable -> L33
        this.L$1 = r7;     // Catch: Throwable -> L33
        this.L$2 = r6;     // Catch: Throwable -> L33
        this.L$3 = r5;     // Catch: Throwable -> L33
        this.label = 2;     // Catch: Throwable -> L33
        Object r16 = kotlinx.coroutines.i.a(r9, r15, this);     // Catch: Throwable -> L33
        if (r16 != r0) goto L23;
        return r0;
    L23:
        r2 = r5;
        r3 = r6;
        r4 = r7;
        kotlinx.coroutines.sync.a r17 = r14;
        r12 = r16;
        r11 = r17;
        goto L25
    L29:
        r11 = r14;
        goto L30
    L14:
        ResultKt.throwOnFailure(r12);
        r14 = l.b(this.this$0);
        l r18 = this.this$0;
        Activity r19 = this.$activity;
        String r20 = this.$uid;
        Continuation<? super Unit> r21 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r14;
        this.L$1 = r18;
        this.L$2 = r19;
        this.L$3 = r20;
        this.label = 1;
        if (r14.a(null, r21) != r0) goto L17;
        return r0;
    L17:
        r6 = r19;
        r7 = r18;
        r5 = r20;
        goto L37
    }
}
