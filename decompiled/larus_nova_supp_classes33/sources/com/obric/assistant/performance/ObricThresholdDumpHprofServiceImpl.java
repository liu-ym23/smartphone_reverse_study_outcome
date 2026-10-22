package com.obric.assistant.performance;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.ObricThresholdDumpHprofConfig;
import com.obric.assistant.t1;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;
import s17.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0016\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010\u000fJ(\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/performance/ObricThresholdDumpHprofServiceImpl;", "Lcom/obric/assistant/performance/IObricThresholdDumpHprofService;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "dumpJob", "Lkotlinx/coroutines/Job;", "hasDumped", "", "init", "", "loopCheckAndDump", "config", "Lcom/obric/assistant/ObricThresholdDumpHprofConfig;", "(Lcom/obric/assistant/ObricThresholdDumpHprofConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dumpHprof", "usedMemory", "", "maxMemory", "usedPercent", "threshold", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricThresholdDumpHprofServiceImpl implements IObricThresholdDumpHprofService {
    public final CoroutineScope b;
    public Job c;
    public boolean d;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.obric.assistant.performance.ObricThresholdDumpHprofServiceImpl$init$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.performance.ObricThresholdDumpHprofServiceImpl$init$1", f = "ObricThresholdDumpHprofServiceImpl.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ObricThresholdDumpHprofServiceImpl this$0;

        public AnonymousClass1(ObricThresholdDumpHprofServiceImpl r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r13) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L11;
            if (r2 != 1) goto L10;
            ResultKt.throwOnFailure(r13);     // Catch: Exception -> L7 CancellationException -> L20
        L22:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r13);
            ObricThresholdDumpHprofConfig r14 = t1.a.getObricThresholdDumpHprofConfig();     // Catch: Exception -> L7 CancellationException -> L20
            FLogger r3 = FLogger.a;     // Catch: Exception -> L7 CancellationException -> L20
            r3.i("ObricThresholdDumpHprofServiceImpl", "init, config=" + r14 + ", localDefault=" + new ObricThresholdDumpHprofConfig(false, 0, 0, 7, null));     // Catch: Exception -> L7 CancellationException -> L20
            if (r14.getEnableHprofDump() == true) goto L16;
            r3.i("ObricThresholdDumpHprofServiceImpl", "init ignored, hprof dump disabled");     // Catch: Exception -> L7 CancellationException -> L20
            return Unit.INSTANCE;
        L16:
            ObricThresholdDumpHprofServiceImpl r0 = this.this$0;     // Catch: Exception -> L7 CancellationException -> L20
            this.label = 1;     // Catch: Exception -> L7 CancellationException -> L20
            if (ObricThresholdDumpHprofServiceImpl.a(r0, r14, this) != r1) goto L22;
            return r1;
        L20:
            FLogger.a.i("ObricThresholdDumpHprofServiceImpl", "init job cancelled");
        L7:
            e = move-exception;
            FLogger.a.e("ObricThresholdDumpHprofServiceImpl", "init error: " + e);
            goto L22
        }
    }

    static {
    }

    public final void init() {
        Job r0 = this.c;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        Boolean r2 = null;
        if (r1 == false) goto L10;
    L17:
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("init ignored, jobActive=");
        Job r5 = this.c;
        if (r5 == null) goto L20;
        r2 = Boolean.valueOf(r5.isActive());
    L20:
        r4.append(r2);
        r4.append(", hasDumped=");
        r4.append(this.d);
        r3.i("ObricThresholdDumpHprofServiceImpl", r4.toString());
        return;
    L10:
        if (this.d == true) goto L17;
        Job r6 = this.c;
        if (r6 == null) goto L15;
        Job.DefaultImpls.cancel$default(r6, null, 1, null);
    L15:
        this.c = BuildersKt.launch$default(this.b, null, null, new AnonymousClass1(this, null), 3, null);
        return;
    L5:
        if (r0.isActive() != true) goto L7;
        r1 = true;
        goto L7
    }

    public ObricThresholdDumpHprofServiceImpl() {
        this.b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0071 -> B:22:0x0075). Please report as a decompilation issue!!! */
    public static final Object a(ObricThresholdDumpHprofServiceImpl r18, ObricThresholdDumpHprofConfig r19, Continuation r20) {
        r18.getClass();
        if ((r20 instanceof ObricThresholdDumpHprofServiceImpl$loopCheckAndDump$1) == false) goto L7;
        ObricThresholdDumpHprofServiceImpl$loopCheckAndDump$1 r1 = (ObricThresholdDumpHprofServiceImpl$loopCheckAndDump$1) r20;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
        ObricThresholdDumpHprofServiceImpl r3 = r18;
    L8:
        Object r0 = r1.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r1.label;
        int r6 = 100;
        int r7 = 1;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        int r8 = r1.I$0;
        long r9 = r1.J$0;
        ResultKt.throwOnFailure(r0);
    L22:
        Runtime r10 = Runtime.getRuntime();
        long r11 = r10.maxMemory();
        long r12 = r10.totalMemory() - r10.freeMemory();
        if (r11 > 0) goto L25;
        FLogger.a.w("ObricThresholdDumpHprofServiceImpl", "skip check, invalid maxMemory=" + r11);
    L36:
        r1 = r1;
        r4 = r4;
        r9 = r9;
        r6 = 100;
        r7 = 1;
    L16:
        if (JobKt.isActive(r1.getContext()) == false) goto L38;
        if (r3.d == true) goto L38;
        r1.J$0 = r9;
        r1.I$0 = r8;
        r1.label = r7;
        if (DelayKt.delay(r9, r1) != r4) goto L22;
        return r4;
    L38:
        return Unit.INSTANCE;
    L25:
        long r13 = (((long) r6) * r12) / r11;
        FLogger r14 = FLogger.a;
        r14.d("ObricThresholdDumpHprofServiceImpl", "check java heap, used=" + r12 + ", max=" + r11 + ", percent=" + r13 + ", threshold=" + r8);
        if (r13 < r8) goto L36;
        if (r3.d == true) goto L41;
        r3.d = true;
        r14.i("ObricThresholdDumpHprofServiceImpl", "dump hprof start, used=" + r12 + ", max=" + r11 + ", percent=" + r13 + ", threshold=" + r8);     // Catch: Exception -> L33
        d.f().d(System.currentTimeMillis(), 2);     // Catch: Exception -> L33
        r14.i("ObricThresholdDumpHprofServiceImpl", "dump hprof triggered");     // Catch: Exception -> L33
    L33:
        e = move-exception;
        FLogger.a.e("ObricThresholdDumpHprofServiceImpl", "dump hprof error: " + e);
    L41:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        r9 = ((long) RangesKt.coerceAtLeast(r19.getHprofDumpInterval(), 1)) * 1000;
        r8 = RangesKt.coerceIn(r19.getHprofDumpThreshold(), 1, 100);
    L7:
        r3 = r18;
        r1 = new ObricThresholdDumpHprofServiceImpl$loopCheckAndDump$1(r3, r20);
        goto L8
    }
}
