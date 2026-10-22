package com.larus.uaigc.nowatermark;

import com.tencent.open.log.TraceLevel;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.nowatermark.CreationNoWatermarkManager$enqueuePrefetch$2", f = "CreationNoWatermarkManager.kt", i = {}, l = {1609, 1610}, m = "invokeSuspend", n = {}, s = {})
final class CreationNoWatermarkManager$enqueuePrefetch$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CreationNoWatermarkManager.a $accountContext;
    int label;

    public CreationNoWatermarkManager$enqueuePrefetch$2(CreationNoWatermarkManager.a r1, Continuation<? super CreationNoWatermarkManager$enqueuePrefetch$2> r2) {
        this.$accountContext = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationNoWatermarkManager$enqueuePrefetch$2(this.$accountContext, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        ResultKt.throwOnFailure(r20);
    L40:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r20);
    L13:
        CreationNoWatermarkManager r3 = CreationNoWatermarkManager.a;
        CreationNoWatermarkManager.a r4 = this.$accountContext;
        this.label = 2;
        r3.getClass();
        Object r5 = CreationNoWatermarkManager.o;
        monitor-enter(r5);
    L41:
        th = move-exception;
        throw th;
    L16:
        if (CreationNoWatermarkManager.A == r4.b) goto L18;
    L25:
        Pair r6 = null;
    L26:
        monitor-exit(r5);
        if (r6 != null) goto L29;
    L36:
        Object r7 = Unit.INSTANCE;
    L37:
        if (r7 != r0) goto L40;
        return r0;
    L29:
        if (((CreationNoWatermarkManager$f) r6.getFirst()).a() == true) goto L36;
        if (r3.B(r4) == false) goto L36;
        r7 = r3.M((CreationNoWatermarkManager$f) r6.getFirst(), (String) r6.getSecond(), this);
        if (r7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L37;
        r7 = Unit.INSTANCE;
        goto L37
    L18:
        if (Intrinsics.areEqual(CreationNoWatermarkManager.B, r4.a) == false) goto L25;
        LinkedHashSet r8 = CreationNoWatermarkManager.p;     // Catch: Throwable -> L41
        Set r9 = CollectionsKt.toSet(r8);     // Catch: Throwable -> L41
        LinkedHashSet r10 = CreationNoWatermarkManager.q;     // Catch: Throwable -> L41
        CreationNoWatermarkManager$f r11 = new CreationNoWatermarkManager$f(r9, CollectionsKt.toSet(r10));     // Catch: Throwable -> L41
        LinkedHashSet r12 = CreationNoWatermarkManager.r;     // Catch: Throwable -> L41
        String r13 = CollectionsKt.joinToString$default(r12, "+", null, null, 0, null, null, 62, null);     // Catch: Throwable -> L41
        if (StringsKt.isBlank(r13) == false) goto L23;
        r13 = "prefetch_batch";
    L23:
        r8.clear();     // Catch: Throwable -> L41
        r10.clear();     // Catch: Throwable -> L41
        r12.clear();     // Catch: Throwable -> L41
        CreationNoWatermarkManager.z = false;     // Catch: Throwable -> L41
        r6 = TuplesKt.to(r11, r13);     // Catch: Throwable -> L41
        goto L26
    L10:
        ResultKt.throwOnFailure(r20);
        this.label = 1;
        if (DelayKt.delay(80, this) != r0) goto L13;
        return r0;
    }
}
