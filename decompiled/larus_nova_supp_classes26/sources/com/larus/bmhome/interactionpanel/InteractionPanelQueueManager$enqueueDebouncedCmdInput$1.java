package com.larus.bmhome.interactionpanel;

import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.interactionpanel.InteractionPanelQueueManager$enqueueDebouncedCmdInput$1", f = "InteractionPanelQueueManager.kt", i = {}, l = {267}, m = "invokeSuspend", n = {}, s = {})
public final class InteractionPanelQueueManager$enqueueDebouncedCmdInput$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ InteractionPanelQueueManager$b $debounceKey;
    final /* synthetic */ long $version;
    int label;
    final /* synthetic */ InteractionPanelQueueManager this$0;

    public InteractionPanelQueueManager$enqueueDebouncedCmdInput$1(InteractionPanelQueueManager r1, InteractionPanelQueueManager$b r2, long r3, Continuation<? super InteractionPanelQueueManager$enqueueDebouncedCmdInput$1> r5) {
        this.this$0 = r1;
        this.$debounceKey = r2;
        this.$version = r3;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new InteractionPanelQueueManager$enqueueDebouncedCmdInput$1(this.this$0, this.$debounceKey, this.$version, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        InteractionPanelQueueManager r8 = this.this$0;
        InteractionPanelQueueManager$b r2 = this.$debounceKey;
        long r3 = this.$version;
        int r4 = InteractionPanelQueueManager.l;
        monitor-enter(r8);
        Long r5 = (Long) ((LinkedHashMap) r8.j).get(r2);     // Catch: Throwable -> L37
        if (r5 != null) goto L18;
    L19:
        monitor-exit(r8);
    L34:
        return Unit.INSTANCE;
    L18:
        if (r5.longValue() != r3) goto L19;
        r8.i.remove(r2);     // Catch: Throwable -> L37
        r8.j.remove(r2);     // Catch: Throwable -> L37
        InteractionPanelQueueManager$c r6 = (InteractionPanelQueueManager$c) r8.h.remove(r2);     // Catch: Throwable -> L37
        if (r6 != null) goto L25;
        monitor-exit(r8);
        goto L34
    L25:
        long r9 = ((Number) r8.a.invoke()).longValue();     // Catch: Throwable -> L37
        r8.e.b(r9);     // Catch: Throwable -> L37
        if ((r6 instanceof InteractionPanelQueueManager$c.b) == false) goto L29;
        r8.e.k(((InteractionPanelQueueManager$c.b) r6).a, r9);     // Catch: Throwable -> L37
    L31:
        r8.s();     // Catch: Throwable -> L37
        monitor-exit(r8);
        goto L34
    L29:
        if ((r6 instanceof InteractionPanelQueueManager$c.a) == false) goto L36;
        r8.e.f(((InteractionPanelQueueManager$c.a) r6).a);     // Catch: Throwable -> L37
        goto L31
    L36:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        this.label = 1;
        if (DelayKt.delay(500, this) != r0) goto L11;
        return r0;
    }
}
