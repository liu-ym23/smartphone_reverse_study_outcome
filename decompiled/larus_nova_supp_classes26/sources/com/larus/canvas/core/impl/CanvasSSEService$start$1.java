package com.larus.canvas.core.impl;

import com.larus.canvas.core.impl.sse.CanvasGetInfoCompensator;
import com.larus.im.internal.delegate.c0;
import com.larus.im.internal.delegate.d1;
import cy8.c;
import cy8.u;
import cy8.w;
import java.util.LinkedHashMap;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$;
import ouc.d0;
import ouc.e0;
import ouc.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/larus/canvas/core/api/model/CanvasSSEEvent;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.core.impl.CanvasSSEService$start$1", f = "CanvasSSEService.kt", i = {0, 0, 0, 0, 1}, l = {82, 136}, m = "invokeSuspend", n = {"$this$flow", "mobEndLock", "mobEndReported", "cancelSignal", "cancelSignal"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0"})
public final class CanvasSSEService$start$1 extends SuspendLambda implements Function2<FlowCollector<? super u>, Continuation<? super Unit>, Object> {
    final /* synthetic */ a $mob;
    final /* synthetic */ w $params;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ CanvasSSEService this$0;

    /* JADX INFO: renamed from: com.larus.canvas.core.impl.CanvasSSEService$start$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/canvas/core/api/model/CanvasSSEEvent;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.canvas.core.impl.CanvasSSEService$start$1$1", f = "CanvasSSEService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<u, Continuation<? super Boolean>, Object> {
        final /* synthetic */ CompletableDeferred<Unit> $cancelSignal;
        int label;

        public AnonymousClass1(CompletableDeferred<Unit> r1, Continuation<? super AnonymousClass1> r2) {
            this.$cancelSignal = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.$cancelSignal, r3);
        }

        public final Object invoke(u r1, Continuation<? super Boolean> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((u) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            return Boxing.boxBoolean(!this.$cancelSignal.isCompleted());
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.canvas.core.impl.CanvasSSEService$start$1$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements FlowCollector {
        public final /* synthetic */ CompletableDeferred<Unit> a;
        public final /* synthetic */ a b;
        public final /* synthetic */ CanvasSSEService c;
        public final /* synthetic */ w d;
        public final /* synthetic */ FlowCollector<u> e;
        public final /* synthetic */ Object f;
        public final /* synthetic */ Ref.BooleanRef g;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(CompletableDeferred<Unit> r1, a r2, CanvasSSEService r3, w r4, FlowCollector<? super u> r5, Object r6, Ref.BooleanRef r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }

        public final Object a(u r23, Continuation<? super Unit> r24) {
            if ((r24 instanceof CanvasSSEService$start$1$2$emit$1) == false) goto L7;
            CanvasSSEService$start$1$2$emit$1 r3 = (CanvasSSEService$start$1$2$emit$1) r24;
            int r4 = r3.label;
            if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
            r3.label = r4 - Integer.MIN_VALUE;
        L8:
            Object r2 = r3.result;
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r6 = r3.label;
            String r9 = null;
            if (r6 == 0) goto L18;
            if (r6 == 1) goto L17;
            if (r6 == 2) goto L16;
            if (r6 != 3) goto L15;
            ResultKt.throwOnFailure(r2);
        L31:
            return Unit.INSTANCE;
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L16:
            ResultKt.throwOnFailure(r2);
        L68:
            return Unit.INSTANCE;
        L17:
            ResultKt.throwOnFailure(r2);
        L48:
            u r7 = (u) r2;
            Object r1 = this.f;
            a r8 = this.b;
            Ref.BooleanRef r10 = this.g;
            CanvasSSEService r11 = this.c;
            w r12 = this.d;
            int r13 = CanvasSSEService.f;
            r11.getClass();
            if ((r7 instanceof u.c) == false) goto L55;
            c r14 = ((u.c) r7).a;
            if (r14 == null) goto L53;
            r9 = r14.c;
        L53:
            a.C0086a r15 = new a.C0086a(0, "", 0, r9, r12.c);
        L64:
            CanvasSSEService$start$1.access$invokeSuspend$reportMobEndOnce(r1, r8, r10, r15);
            FlowCollector<u> r16 = this.e;
            r3.label = 2;
            if (r16.emit(r7, r3) != r5) goto L68;
            return r5;
        L55:
            if ((r7 instanceof u.d) == false) goto L63;
            u.d r17 = (u.d) r7;
            String r18 = r17.b;
            if (r18 != null) goto L59;
            r18 = "";
        L59:
            int r19 = r17.a;
            c r110 = r17.c;
            if (r110 == null) goto L62;
            r9 = r110.c;
        L62:
            r15 = new a.C0086a(1, r18, r19, r9, r12.c);
            goto L64
        L63:
            r15 = new a.C0086a(1, "", 1, null, r12.c);
            goto L64
        L18:
            ResultKt.throwOnFailure(r2);
            if (this.a.isCompleted() == true) goto L21;
            this.b.a++;
            boolean r20 = r23 instanceof u.c;
            if (r20 == false) goto L25;
        L32:
            if (r20 == false) goto L34;
            u.c r21 = (u.c) r23;
        L35:
            if (r21 == null) goto L39;
            c r22 = r21.a;
            if (r22 == null) goto L39;
        L45:
            CanvasGetInfoCompensator r25 = this.c.c;
            w r26 = this.d;
            r3.label = 1;
            r2 = r25.a(r26, r23, r22, r3);
            if (r2 != r5) goto L48;
            return r5;
        L39:
            if ((r23 instanceof u.d) == false) goto L41;
            u.d r27 = (u.d) r23;
        L42:
            if (r27 == null) goto L44;
            r22 = r27.c;
            goto L45
        L44:
            r22 = null;
            goto L45
        L41:
            r27 = null;
            goto L42
        L34:
            r21 = null;
            goto L35
        L25:
            if ((r23 instanceof u.d) == true) goto L32;
            FlowCollector<u> r28 = this.e;
            r3.label = 3;
            if (r28.emit(r23, r3) != r5) goto L31;
            return r5;
        L21:
            return Unit.INSTANCE;
        L7:
            r3 = new CanvasSSEService$start$1$2$emit$1(this, r24);
            goto L8
        }

        public final /* bridge */ /* synthetic */ Object emit(Object r1, Continuation r2) {
            return a((u) r1, r2);
        }
    }

    public CanvasSSEService$start$1(CanvasSSEService r1, a r2, w r3, Continuation<? super CanvasSSEService$start$1> r4) {
        this.this$0 = r1;
        this.$mob = r2;
        this.$params = r3;
        super(2, r4);
    }

    public static final /* synthetic */ void access$invokeSuspend$reportMobEndOnce(Object r0, a r1, Ref.BooleanRef r2, a.C0086a r3) {
        a(r0, r1, r2, r3);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        CanvasSSEService$start$1 r0 = new CanvasSSEService$start$1(this.this$0, this.$mob, this.$params, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((FlowCollector) r1, (Continuation) r2);
    }

    public final Object invoke(FlowCollector<? super u> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r24) {
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L20;
        if (r0 == 1) goto L13;
        if (r0 != 2) goto L12;
        CompletableDeferred r2 = (CompletableDeferred) this.L$0;
        ResultKt.throwOnFailure(r24);     // Catch: Throwable -> L9
    L68:
        CanvasSSEService r1 = this.this$0;
        Object r4 = r1.e;
        w r5 = this.$params;
        monitor-enter(r4);
    L77:
        th = move-exception;
        throw th;
    L71:
        if (((LinkedHashMap) r1.d).get(r5.a) != r2) goto L73;
        r1.d.remove(r5.a);     // Catch: Throwable -> L77
    L73:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L77
        monitor-exit(r4);
    L76:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        CompletableDeferred r7 = (CompletableDeferred) this.L$3;
        Ref.BooleanRef r8 = (Ref.BooleanRef) this.L$2;
        Object r9 = this.L$1;
        FlowCollector r10 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r24);     // Catch: Throwable -> L16 CancellationException -> L18
    L35:
        if (r7.isCompleted() == false) goto L37;
        a(r9, this.$mob, r8, new a.C0086a(2, "", 0, null, this.$params.c));     // Catch: Throwable -> L16 CancellationException -> L18
    L37:
        CanvasSSEService r11 = this.this$0;
        Object r12 = r11.e;
        w r13 = this.$params;
        monitor-enter(r12);
    L45:
        th = move-exception;
        throw th;
    L40:
        if (((LinkedHashMap) r11.d).get(r13.a) != r7) goto L42;
        r11.d.remove(r13.a);     // Catch: Throwable -> L45
    L42:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L45
        monitor-exit(r12);
    L18:
        e = e;
        Ref.BooleanRef r15 = r8;
        Object r16 = r9;
    L85:
        a r17 = this.$mob;     // Catch: Throwable -> L9
        String r18 = e.getMessage();     // Catch: Throwable -> L9
        if (r18 != null) goto L88;
        r18 = "";
    L88:
        a(r16, r17, r15, new a.C0086a(2, r18, 0, null, this.$params.c));     // Catch: Throwable -> L9
        throw e;     // Catch: Throwable -> L9
    L16:
        th = th;
        CompletableDeferred r19 = r7;
        Ref.BooleanRef r110 = r8;
        Object r111 = r9;
        FlowCollector r112 = r10;
    L109:
        c0.b.e("SSE_KMP", "start error sessionId=" + this.$params.a + " type=" + Reflection.getOrCreateKotlinClass(th.getClass()).getSimpleName() + " msg=" + th.getMessage());     // Catch: Throwable -> L80
        a r20 = this.$mob;     // Catch: Throwable -> L80
        String r21 = th.getMessage();     // Catch: Throwable -> L80
        if (r21 != null) goto L64;
        r21 = "";
    L64:
        a(r111, r20, r110, new a.C0086a(1, r21, 1, null, this.$params.c));     // Catch: Throwable -> L80
        u.d r22 = new u.d(1, th.getMessage(), null);     // Catch: Throwable -> L80
        this.L$0 = r19;     // Catch: Throwable -> L80
        this.L$1 = null;     // Catch: Throwable -> L80
        this.L$2 = null;     // Catch: Throwable -> L80
        this.L$3 = null;     // Catch: Throwable -> L80
        this.label = 2;     // Catch: Throwable -> L80
        if (r112.emit(r22, this) != r3) goto L67;
        return r3;
    L67:
        r2 = r19;
    L80:
        th = th;
    L91:
        CanvasSSEService r23 = this.this$0;
        Object r25 = r23.e;
        w r26 = this.$params;
        monitor-enter(r25);
    L99:
        th = move-exception;
        throw th;
    L94:
        if (((LinkedHashMap) r23.d).get(r26.a) != r19) goto L96;
        r23.d.remove(r26.a);     // Catch: Throwable -> L99
    L96:
        Unit r27 = Unit.INSTANCE;     // Catch: Throwable -> L99
        monitor-exit(r25);
        throw th;
    L20:
        ResultKt.throwOnFailure(r24);
        r112 = (FlowCollector) this.L$0;
        Object r113 = new Object();
        Ref.BooleanRef r114 = new Ref.BooleanRef();
        CompletableDeferred r115 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        CanvasSSEService r28 = this.this$0;
        Object r29 = r28.e;
        w r30 = this.$params;
        monitor-enter(r29);
        CompletableDeferred r31 = (CompletableDeferred) r28.d.put(r30.a, r115);     // Catch: Throwable -> L102
        monitor-exit(r29);
        if (r31 == null) goto L120;
        Boxing.boxBoolean(r31.complete(Unit.INSTANCE));
    L120:
        this.$mob.a(this.$params);     // Catch: Throwable -> L58 CancellationException -> L82
        FlowKt__LimitKt$takeWhile$.inlined.unsafeFlow.1 r116 = new FlowKt__LimitKt$takeWhile$.inlined.unsafeFlow.1(this.this$0.b.c(this.$params), new AnonymousClass1(r115, null));     // Catch: Throwable -> L58 CancellationException -> L82
        r19 = r115;
        Object r32 = r113;
        AnonymousClass2 r33 = new AnonymousClass2(r115, this.$mob, this.this$0, this.$params, r112, r113, r114);     // Catch: Throwable -> L54 CancellationException -> L56
        this.L$0 = r112;     // Catch: Throwable -> L54 CancellationException -> L56
        this.L$1 = r32;     // Catch: Throwable -> L54 CancellationException -> L56
        Ref.BooleanRef r34 = r114;
        this.L$2 = r34;     // Catch: Throwable -> L50 CancellationException -> L52
        this.L$3 = r19;     // Catch: Throwable -> L50 CancellationException -> L52
        this.label = 1;     // Catch: Throwable -> L50 CancellationException -> L52
        if (r116.collect(r33, this) != r3) goto L33;
        return r3;
    L33:
        r9 = r32;
        r8 = r34;
        r10 = r112;
        r7 = r19;
        goto L35
    L52:
        e = e;
    L84:
        r16 = r32;
        r15 = r34;
    L50:
        th = th;
    L60:
        r111 = r32;
        r110 = r34;
        goto L109
    L56:
        e = e;
        r34 = r114;
    L54:
        th = th;
        r34 = r114;
        goto L60
    L82:
        e = e;
        r19 = r115;
        r34 = r114;
        r32 = r113;
    L58:
        th = th;
        r19 = r115;
        r34 = r114;
        r32 = r113;
    L102:
        th = move-exception;
        throw th;
    L9:
        th = th;
        r19 = "start error sessionId=";
        goto L91
    }

    public static final void a(Object r2, a r3, Ref.BooleanRef r4, a.C0086a r5) {
        monitor-enter(r2);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (r4.element == false) goto L6;
        boolean r6 = false;
    L8:
        monitor-exit(r2);
        if (r6 == false) goto L23;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r5, "info");
        e0 r7 = new e0();
        r7.b("status", k.b(Integer.valueOf(r5.a)));
        r7.b("count", k.b(Integer.valueOf(r3.a)));
        r7.b("duration", k.b(Long.valueOf(com.larus.im.internal.delegate.c.a.currentTimeMillis() - r3.b)));
        b.a(r7, "error_description", r5.b);
        r7.b("error_code", k.b(Integer.valueOf(r5.c)));
        b.a(r7, "binary_type", "json");
        b.a(r7, "log_id", r5.d);
        b.a(r7, "request_path", r5.e);
        b.a(r7, "scene", "end");
        d0 r8 = r7.a();
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L13
        d1.b.a("flow_canvas_chunk_request", r8);     // Catch: Throwable -> L13
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L23:
        return;
    L6:
        r4.element = true;     // Catch: Throwable -> L16
        r6 = true;
        goto L8
    }
}
