package com.larus.canvas.core.impl.sse;

import com.larus.im.internal.delegate.c0;
import cy8.c;
import cy8.u;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "pkg", "Lcom/larus/canvas/core/impl/sse/CanvasChunkPackage;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.core.impl.sse.CanvasStreamPullHandler$readStream$2$1", f = "CanvasStreamPullHandler.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, s = {})
final class CanvasStreamPullHandler$readStream$2$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<u, Continuation<? super Unit>, Object> $emitEvent;
    final /* synthetic */ String $logId;
    final /* synthetic */ a $merger;
    final /* synthetic */ Ref.ObjectRef<m$b> $result;
    final /* synthetic */ m $this_runCatching;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public CanvasStreamPullHandler$readStream$2$1(m r1, a r2, String r3, Function2<? super u, ? super Continuation<? super Unit>, ? extends Object> r4, Ref.ObjectRef<m$b> r5, Continuation<? super CanvasStreamPullHandler$readStream$2$1> r6) {
        this.$this_runCatching = r1;
        this.$merger = r2;
        this.$logId = r3;
        this.$emitEvent = r4;
        this.$result = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        CanvasStreamPullHandler$readStream$2$1 r7 = new CanvasStreamPullHandler$readStream$2$1(this.$this_runCatching, this.$merger, this.$logId, this.$emitEvent, this.$result, r10);
        r7.L$0 = r9;
        return r7;
    }

    public final Object invoke(b r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((b) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L101:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        b r14 = (b) this.L$0;
        c r2 = this.$this_runCatching.a;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r14, "chunkPackage");
        String r3 = r14.a;
        int r4 = r3.hashCode();
        if (r4 == 3089282) goto L84;
        Long r7 = null;
        String r8 = null;
        if (r4 == 3271912) goto L39;
        if (r4 == 96784904) goto L16;
    L86:
        Object r15 = l.d.a;
    L88:
        if ((r15 instanceof l.a) == false) goto L93;
        l.a r16 = (l.a) r15;
        c r17 = this.$merger.b(r16.b, r16.a, false, this.$logId);
        Function2<u, Continuation<? super Unit>, Object> r5 = this.$emitEvent;
        u.a r6 = new u.a(r17);
        this.label = 1;
        if (r5.invoke(r6, this) != r0) goto L101;
        return r0;
    L93:
        if ((r15 instanceof l.c) == false) goto L96;
        l.c r18 = (l.c) r15;
        this.$result.element = new m$b.b(r18.a, r18.b);
        goto L101
    L96:
        if (Intrinsics.areEqual(r15, l.b.a) == false) goto L99;
        this.$result.element = m$b.a.a;
        goto L101
    L99:
        if (Intrinsics.areEqual(r15, l.d.a) == true) goto L101;
        throw new NoWhenBranchMatchedException();
    L16:
        if (r3.equals("error") == false) goto L86;
        String r19 = r14.b;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L21
        Object r10 = Result.constructor-impl((g) r2.a.c(g.Companion.serializer(), r19));     // Catch: Throwable -> L21
    L23:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L27;
        c0.b.e("SSE_KMP", "parseError failed type=" + Reflection.getOrCreateKotlinClass(r11.getClass()).getSimpleName() + " msg=" + r11.getMessage() + " dataPrefix=" + StringsKt.take(r19, 200));
    L27:
        if (Result.isFailure-impl(r10) == false) goto L29;
        r10 = null;
    L29:
        g r12 = (g) r10;
        if (r12 == null) goto L34;
        Integer r20 = r12.a;
        if (r20 == null) goto L34;
        int r21 = r20.intValue();
    L35:
        if (r12 == null) goto L37;
        r8 = r12.b;
    L37:
        r15 = new l.c(r21, r8);
    L34:
        r21 = -1;
    L21:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    L39:
        if (r3.equals("json") == false) goto L86;
        String r110 = r14.b;
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L44
        Object r24 = Result.constructor-impl((f) r2.a.c(f.Companion.serializer(), r110));     // Catch: Throwable -> L44
    L46:
        Throwable r25 = Result.exceptionOrNull-impl(r24);
        if (r25 == null) goto L50;
        c0.b.e("SSE_KMP", "parseJson failed type=" + Reflection.getOrCreateKotlinClass(r25.getClass()).getSimpleName() + " msg=" + r25.getMessage() + " dataPrefix=" + StringsKt.take(r110, 200));
    L50:
        if (Result.isFailure-impl(r24) == false) goto L52;
        r24 = null;
    L52:
        f r26 = (f) r24;
        if (r26 != null) goto L55;
        r15 = l.d.a;
        goto L88
    L55:
        String r111 = r26.b;
        if (r111 != null) goto L58;
    L73:
        List r27 = null;
    L74:
        if (r27 != null) goto L77;
        r27 = CollectionsKt.emptyList();
    L77:
        if (r27.isEmpty() == false) goto L79;
        r15 = l.d.a;
        goto L88
    L79:
        String r28 = r26.a;
        if (r28 == null) goto L82;
        r7 = StringsKt.toLongOrNull(r28);
    L82:
        r15 = new l.a(r7, r27);
        goto L88
    L58:
        if ((!StringsKt.isBlank(r111)) == true) goto L61;
        r111 = null;
    L61:
        if (r111 == null) goto L73;
        k.a.getClass();     // Catch: Throwable -> L64
        Object r29 = Result.constructor-impl(k.g(r111));     // Catch: Throwable -> L64
    L66:
        Throwable r30 = Result.exceptionOrNull-impl(r29);
        if (r30 == null) goto L70;
        c0.b.e("SSE_KMP", "parseBlocks failed type=" + Reflection.getOrCreateKotlinClass(r30.getClass()).getSimpleName() + " msg=" + r30.getMessage() + " contentPrefix=" + StringsKt.take(r111, 200));
    L70:
        if (Result.isFailure-impl(r29) == false) goto L72;
        r29 = null;
    L72:
        r27 = (List) r29;
    L64:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r29 = Result.constructor-impl(ResultKt.createFailure(th));
    L44:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        r24 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L46
    L84:
        if (r3.equals("done") == false) goto L86;
        r15 = l.b.a;
        goto L88
    }
}
