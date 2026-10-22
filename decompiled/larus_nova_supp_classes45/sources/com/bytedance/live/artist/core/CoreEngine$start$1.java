package com.bytedance.live.artist.core;

import com.bytedance.android.live.base.api.ActivityType;
import com.bytedance.live.artist.render.RenderRequest;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.sync.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, ActivityType.LIVE_BROADCAST_BEFORE_ACTIVITY_CLASS})
@DebugMetadata(c = "com.bytedance.live.artist.core.CoreEngine$start$1", f = "CoreEngine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CoreEngine$start$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    private CoroutineScope p$;
    final /* synthetic */ CoreEngine this$0;

    /* JADX INFO: renamed from: com.bytedance.live.artist.core.CoreEngine$start$1$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, ActivityType.LIVE_BROADCAST_BEFORE_ACTIVITY_CLASS})
    @DebugMetadata(c = "com.bytedance.live.artist.core.CoreEngine$start$1$1", f = "CoreEngine.kt", i = {0, 0}, l = {169}, m = "invokeSuspend", n = {"$this$launch", "channel"}, s = {"L$0", "L$1"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ CoreEngine$start$1 this$0;

        public AnonymousClass1(CoreEngine$start$1 r1, Continuation r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.p$ = (CoroutineScope) r3;
            return r0;
        }

        public final Object invoke(Object r1, Object r2) {
            return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x003e -> B:15:0x0043). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            Channel r2 = (Channel) this.L$1;
            CoroutineScope r3 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r8);
            CoroutineScope r4 = r3;
            Object r5 = r0;
            AnonymousClass1 r6 = this;
        L23:
            ((Runnable) r8).run();     // Catch: Throwable -> L18
        L20:
            AnonymousClass1 r9 = r6;
            r0 = r5;
            CoroutineScope r7 = r4;
        L9:
            Channel<Runnable> r11 = r9.this$0.this$0.h;
            if (r11 == null) goto L22;
            r9.L$0 = r7;
            r9.L$1 = r11;
            r9.label = 1;
            Object r12 = r11.receive(r9);
            if (r12 != r0) goto L14;
            return r0;
        L14:
            Object r13 = r0;
            r6 = r9;
            r8 = r12;
            r4 = r7;
            r5 = r13;
            goto L23
        L22:
            return Unit.INSTANCE;
        L18:
            th = move-exception;
            r6.this$0.this$0.s.error("task exception", th);
            goto L20
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            r7 = this.p$;
            r9 = this;
            goto L9
        }
    }

    /* JADX INFO: renamed from: com.bytedance.live.artist.core.CoreEngine$start$1$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, ActivityType.LIVE_BROADCAST_BEFORE_ACTIVITY_CLASS})
    @DebugMetadata(c = "com.bytedance.live.artist.core.CoreEngine$start$1$2", f = "CoreEngine.kt", i = {0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3}, l = {180, 249, 194, 199}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "deltaTimeInMs", "$this$withPermit$iv", "action$iv", "$this$launch", "deltaTimeInMs", "renderRequest", "$this$launch", "deltaTimeInMs", "renderRequest"}, s = {"L$0", "L$0", "F$0", "L$1", "L$2", "L$0", "F$0", "L$1", "L$0", "F$0", "L$1"})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        float F$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ CoreEngine$start$1 this$0;

        public AnonymousClass2(CoreEngine$start$1 r1, Continuation r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass2 r0 = new AnonymousClass2(this.this$0, r4);
            r0.p$ = (CoroutineScope) r3;
            return r0;
        }

        public final Object invoke(Object r1, Object r2) {
            return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0109 -> B:43:0x010c). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L13;
            if (r1 == 2) goto L12;
            if (r1 == 3) goto L11;
            if (r1 != 4) goto L10;
            final RenderRequest r2 = (RenderRequest) this.L$1;
            CoroutineScope r6 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r13);
            CoroutineScope r14 = r6;
            AnonymousClass2 r7 = this;
        L43:
            r2.a(r2.d);
            CoreEngine r8 = r7.this$0.this$0;
            int r9 = CoreEngine.u;
            r8.getClass();
            CoreEngine.b(r7.this$0.this$0, r2.b);
            AnonymousClass2 r3 = r7;
        L15:
            Channel<Float> r11 = r3.this$0.this$0.j;
            r3.L$0 = r14;
            r3.label = 1;
            Object r12 = r11.receive(r3);
            if (r12 != r0) goto L18;
            return r0;
        L18:
            CoroutineScope r15 = r14;
            r13 = r12;
        L19:
            float r16 = ((Number) r13).floatValue();
            CoreEngine r17 = r3.this$0.this$0;
            c r18 = r17.n;
            Function0<Unit> r19 = r17.o;
            r3.L$0 = r15;
            r3.F$0 = r16;
            r3.L$1 = r18;
            r3.L$2 = r19;
            r3.label = 2;
            if (r18.c(r3) != r0) goto L22;
            return r0;
        L22:
            final float r21 = r16;
            AnonymousClass2 r110 = r3;
            Function0<Unit> r4 = r19;
            c r22 = r18;
        L47:
            r4.invoke();     // Catch: Throwable -> L44
            r22.release();
            Iterator r5 = ((ArrayList) r110.this$0.this$0.m).iterator();
        L26:
            if (r5.hasNext() == false) goto L32;
            ((Runnable) r5.next()).run();     // Catch: Throwable -> L30
        L30:
            th = move-exception;
            r110.this$0.this$0.s.error("post runnable exception", th);
            goto L26
        L32:
            r2 = new RenderRequest();
            final CoreEngine r23 = r110.this$0.this$0;
            r110.L$0 = r15;
            r110.F$0 = r21;
            r110.L$1 = r2;
            r110.label = 3;
            if (r23.f == true) goto L35;
            Unit r24 = Unit.INSTANCE;
        L36:
            if (r24 != r0) goto L38;
            return r0;
        L38:
            CoroutineScope r25 = r15;
        L39:
            r2.a(r2.c);
            com.bytedance.live.artist.render.c r26 = r110.this$0.this$0.t;
            r110.L$0 = r25;
            r110.F$0 = r21;
            r110.L$1 = r2;
            r110.label = 4;
            if (r26.a(r2, r110) != r0) goto L42;
            return r0;
        L42:
            CoroutineScope r111 = r25;
            r7 = r110;
            r14 = r111;
            goto L43
        L35:
            r23.r.a(new CoreEngine$process$2(r23, r2, r21));
            r24 = Unit.INSTANCE;
        L44:
            th = move-exception;
            r22.release();
            throw th;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            r2 = (RenderRequest) this.L$1;
            float r27 = this.F$0;
            CoroutineScope r28 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r13);
            r110 = this;
            r21 = r27;
            r25 = r28;
            goto L39
        L12:
            r4 = (Function0) this.L$2;
            r22 = (c) this.L$1;
            r21 = this.F$0;
            r15 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r13);
            r110 = this;
            goto L47
        L13:
            CoroutineScope r29 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r13);
            r15 = r29;
            r3 = this;
            goto L19
        L14:
            ResultKt.throwOnFailure(r13);
            r14 = this.p$;
            r3 = this;
            goto L15
        }
    }

    public CoreEngine$start$1(CoreEngine r1, Continuation r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        CoreEngine$start$1 r0 = new CoreEngine$start$1(this.this$0, r4);
        r0.p$ = (CoroutineScope) r3;
        return r0;
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r8);
        CoreEngine r9 = this.this$0;
        if (r9.f == true) goto L12;
        if (r9.g == true) goto L12;
        r9.f = true;
        r9.r.a(CoreEngine$preparePipelines$1.INSTANCE);
        this.this$0.t.c();
        CoreEngine r11 = this.this$0;
        r11.h = ChannelKt.Channel(Integer.MAX_VALUE);
        CoreEngine r12 = this.this$0;
        r12.i = BuildersKt.launch$default(r12.d, null, null, new AnonymousClass1(this, null), 3, null);
        CoreEngine r13 = this.this$0;
        r13.k = BuildersKt.launch$default(r13.d, null, null, new AnonymousClass2(this, null), 3, null);
        CoreEngine.b(this.this$0, 0.0f);
        return Unit.INSTANCE;
    L12:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
