package com.larus.asr.task;

import android.os.SystemClock;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.asr.session.clicktalk.g;
import com.larus.audio.audiov3.task.asr.AsrState;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.report.h;
import com.larus.utils.logger.FLogger;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class SamiCallAsrTask implements h68.e {
    public final String a;
    public final RealtimeCallParam b;
    public final Function0<com.larus.audio.call.a> c;
    public final Function1<byte[], Unit> d;
    public final Function1<Integer, Unit> e;
    public final Function1<String, Unit> f;
    public final Function0<Unit> g;
    public final Function0<Unit> h;
    public final Function1<String, Unit> i;
    public y58.a j;
    public h68.d k;
    public volatile AsrState l;
    public long m;
    public com.larus.audio.call.a n;
    public CompletableJob o;
    public CoroutineScope p;
    public Job q;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.asr.task.SamiCallAsrTask$start$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larus.asr.task.SamiCallAsrTask$start$1", f = "SamiCallAsrTask.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SamiCallAsrTask this$0;

        /* JADX INFO: renamed from: com.larus.asr.task.SamiCallAsrTask$start$1$5, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        @DebugMetadata(c = "com.larus.asr.task.SamiCallAsrTask$start$1$5", f = "SamiCallAsrTask.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ com.larus.audio.call.a $service;
            int label;
            final /* synthetic */ SamiCallAsrTask this$0;

            /* JADX INFO: renamed from: com.larus.asr.task.SamiCallAsrTask$start$1$5$a */
            public static final class a<T> implements FlowCollector {
                public final /* synthetic */ SamiCallAsrTask a;

                public a(SamiCallAsrTask r1) {
                    this.a = r1;
                }

                public final Object emit(Object r3, Continuation r4) {
                    int r5 = ((Number) r3).intValue();
                    FLogger.a.i("SamiCallAsrTask", "callState changed: " + r5 + ", taskId=" + this.a.a);
                    this.a.e.invoke(Boxing.boxInt(r5));
                    return Unit.INSTANCE;
                }
            }

            public AnonymousClass5(com.larus.audio.call.a r1, SamiCallAsrTask r2, Continuation<? super AnonymousClass5> r3) {
                this.$service = r1;
                this.this$0 = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new AnonymousClass5(this.$service, this.this$0, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r5) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L6;
                ResultKt.throwOnFailure(r5);
            L12:
                throw new KotlinNothingValueException();
            L6:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r5);
                MutableSharedFlow r6 = this.$service.k;
                a r2 = new a(this.this$0);
                this.label = 1;
                if (r6.collect(r2, this) != r0) goto L12;
                return r0;
            }
        }

        public AnonymousClass1(SamiCallAsrTask r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r9);
            Object r10 = this.this$0.c.invoke();
            final SamiCallAsrTask r0 = this.this$0;
            com.larus.audio.call.a r11 = (com.larus.audio.call.a) r10;
            r0.n = r11;
            r11.h = new c(r0);
            r11.g = new d(r0);
            r11.a = new e(r0);
            r11.b = new f(r0);
            Job r1 = r0.q;
            if (r1 == null) goto L7;
            Job.DefaultImpls.cancel$default(r1, null, 1, null);
        L7:
            SamiCallAsrTask r2 = this.this$0;
            r2.q = BuildersKt.launch$default(r2.p, null, null, new AnonymousClass5(r11, r2, null), 3, null);
            r11.d(this.this$0.b);
            this.this$0.h.invoke();
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    @Override // h68.e
    public final int a(byte[] r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "buffer");
        return 0;
    }

    @Override // h68.e
    public final boolean b() {
        return false;
    }

    @Override // h68.e
    public final void g(h r1) {
    }

    @Override // h68.e
    public final void cancel() {
        FLogger.a.i("SamiCallAsrTask", "cancel sami call asr, taskId=" + this.a);
        com.larus.audio.call.a r0 = this.n;
        if (r0 == null) goto L5;
        r0.e(this.b);
    L5:
        this.l = AsrState.ASR_STOP;
    }

    @Override // h68.e
    public final long e() {
        if (this.m != 0) goto L6;
        return 0;
    L6:
        return SystemClock.elapsedRealtime() - this.m;
    }

    @Override // h68.e
    public final void release() {
        FLogger.a.i("SamiCallAsrTask", "release sami call asr, taskId=" + this.a);
        com.larus.audio.call.a r0 = this.n;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        this.n = null;
        Job r1 = this.q;
        if (r1 == null) goto L8;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L8:
        this.q = null;
        Job.DefaultImpls.cancel$default(this.o, null, 1, null);
        this.l = AsrState.ASR_IDLE;
    }

    @Override // h68.e
    public final void start() {
        AsrState r0 = this.l;
        AsrState r1 = AsrState.ASR_STARTED;
        if (r0 != r1) goto L7;
        FLogger.a.w("SamiCallAsrTask", "start ignored, already started, taskId=" + this.a);
        return;
    L7:
        if (this.o.isActive() == true) goto L9;
        this.o = SupervisorKt.SupervisorJob$default(null, 1, null);
        this.p = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(this.o));
    L9:
        this.m = SystemClock.elapsedRealtime();
        FLogger.a.i("SamiCallAsrTask", "start sami call asr, taskId=" + this.a);
        this.l = r1;
        h68.d r2 = this.k;
        if (r2 == null) goto L12;
        r2.e(r1);
    L12:
        BuildersKt.launch$default(this.p, null, null, new AnonymousClass1(this, null), 3, null);
    }

    @Override // h68.e
    public final void stop() {
        if (this.l == AsrState.ASR_STARTED) goto L6;
        FLogger.a.w("SamiCallAsrTask", "stop ignored, not started, taskId=" + this.a);
        return;
    L6:
        FLogger.a.i("SamiCallAsrTask", "stop sami call asr (interrupt), taskId=" + this.a);
        com.larus.audio.call.a r0 = this.n;
        if (r0 == null) goto L9;
        r0.a(this.b);
    L9:
        AsrState r1 = AsrState.ASR_STOP;
        this.l = r1;
        h68.d r2 = this.k;
        if (r2 == null) goto L13;
        r2.e(r1);
        return;
    }

    @Override // h68.e
    public final AsrState d() {
        return this.l;
    }

    @Override // h68.e
    public final y58.a getConfig() {
        return this.j;
    }

    @Override // h68.e
    public final String getTaskId() {
        return this.a;
    }

    @Override // h68.e
    public final void f(h68.d r1) {
        this.k = r1;
    }

    @Override // h68.e
    public final void c(String r1, Object r2, Object r3, Object r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
        com.larus.audio.call.a r5 = this.n;
        if (r5 == null) goto L6;
        r5.g(r1);
        return;
    }

    public SamiCallAsrTask(String r2, RealtimeCallParam r3, Function0 r4, com.larus.asr.session.clicktalk.c r5, com.larus.asr.session.clicktalk.d r6, com.larus.asr.session.clicktalk.e r7, com.larus.asr.session.clicktalk.f r8, g r9, com.larus.asr.session.clicktalk.h r10) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "callParam");
        Intrinsics.checkNotNullParameter(r4, "serviceFactory");
        Intrinsics.checkNotNullParameter(r5, "onAudioData");
        Intrinsics.checkNotNullParameter(r6, "onCallStateChange");
        Intrinsics.checkNotNullParameter(r7, "onConversationIdUpdated");
        Intrinsics.checkNotNullParameter(r8, "onServerQuotaError");
        Intrinsics.checkNotNullParameter(r9, "onCallStarted");
        Intrinsics.checkNotNullParameter(r10, "onFinishCall");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.l = AsrState.ASR_IDLE;
        this.o = SupervisorKt.SupervisorJob$default(null, 1, null);
        this.p = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(this.o));
    }
}
