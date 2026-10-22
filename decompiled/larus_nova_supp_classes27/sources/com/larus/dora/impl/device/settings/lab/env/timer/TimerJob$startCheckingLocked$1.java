package com.larus.dora.impl.device.settings.lab.env.timer;

import com.larus.dora.api.annotation.EnvObserveChangeReason;
import com.larus.dora.impl.device.settings.lab.env.DoraEnvObserveManager;
import java.util.Arrays;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.env.timer.TimerJob$startCheckingLocked$1", f = "TimerJob.kt", i = {0}, l = {133}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class TimerJob$startCheckingLocked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $generation;
    final /* synthetic */ boolean $skipInitialReport;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TimerJob this$0;

    public TimerJob$startCheckingLocked$1(TimerJob r1, int r2, boolean r3, Continuation<? super TimerJob$startCheckingLocked$1> r4) {
        this.this$0 = r1;
        this.$generation = r2;
        this.$skipInitialReport = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        TimerJob$startCheckingLocked$1 r0 = new TimerJob$startCheckingLocked$1(this.this$0, this.$generation, this.$skipInitialReport, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r11);
    L10:
        if (CoroutineScopeKt.isActive(r2) == false) goto L59;
        TimerJob r12 = this.this$0;
        int r3 = this.$generation;
        Object r4 = r12.c;
        monitor-enter(r4);
        if (r12.f != r3) goto L17;
        boolean r13 = true;
    L18:
        monitor-exit(r4);
        if (r13 == false) goto L59;
        Calendar r14 = Calendar.getInstance();
        TimerJob r5 = this.this$0;
        Intrinsics.checkNotNull(r14);
        boolean r6 = r5.e(r14);
        j r7 = TimerJob.b(this.this$0, this.$generation, r6, this.$skipInitialReport);
        if (r7 == null) goto L23;
        if (r7.c == true) goto L27;
        g49.d.d(this.this$0.a, "init timer state without report, cur state: " + r6);
    L34:
        TimerJob r8 = this.this$0;
        Calendar r9 = r8.h();
        Calendar r10 = r8.c();
        if (r10.get(5) <= r9.get(5)) goto L37;
        boolean r15 = true;
    L39:
        if (r15 == false) goto L46;
        Object r16 = r10.clone();
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type java.util.Calendar");
        Calendar r17 = (Calendar) r16;
        r17.add(5, -1);
        if (r14.before(r17) == false) goto L44;
    L42:
        r9 = r17;
    L52:
        g49.d.d(this.this$0.a, "下一次边界时间: hour: " + r9.getTime());
        long r18 = Math.min(Math.abs(r9.getTimeInMillis() - r14.getTimeInMillis()), TimeUnit.MINUTES.toMillis(this.this$0.b));
        g49.d.d(this.this$0.a, String.format("下一次检查时间: 约 %.2f 分钟后", Arrays.copyOf(new Object[]{Boxing.boxDouble((((double) r18) / 1000.0d) / 60.0d)}, 1)));
        this.L$0 = r2;
        this.label = 1;
        if (DelayKt.delay(r18, this) != r0) goto L10;
        return r0;
    L44:
        if (r14.before(r9) == true) goto L52;
    L51:
        r9 = r10;
        goto L52
    L46:
        Object r20 = r9.clone();
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type java.util.Calendar");
        r17 = (Calendar) r20;
        r17.add(5, 1);
        if (r14.before(r9) == true) goto L52;
        if (r14.before(r10) == false) goto L42;
    L37:
        r15 = false;
        goto L39
    L27:
        Boolean r21 = r7.a;
        if (r21 != null) goto L31;
        g49.d.d(this.this$0.a, "last state: null, cur state: " + r6);
        TimerJob r22 = this.this$0;
        int r23 = r7.b;
        r22.getClass();
        EnvObserveChangeReason r24 = EnvObserveChangeReason.TIMER_CHANGE;
        Intrinsics.checkNotNullParameter(r24, "reason");
        DoraEnvObserveManager.a.getClass();
        DoraEnvObserveManager.h(r24, r23);
        goto L34
    L31:
        if (Intrinsics.areEqual(r21, Boxing.boxBoolean(r6)) == true) goto L33;
        g49.d.d(this.this$0.a, "last state:" + r7.a + ", cur state: " + r6 + ' ');
        TimerJob r25 = this.this$0;
        int r26 = r7.b;
        r25.getClass();
        EnvObserveChangeReason r27 = EnvObserveChangeReason.TIMER_CHANGE;
        Intrinsics.checkNotNullParameter(r27, "reason");
        DoraEnvObserveManager.a.getClass();
        DoraEnvObserveManager.h(r27, r26);
        goto L34
    L33:
        TimerJob r28 = this.this$0;
        int r30 = r7.b;
        r28.getClass();
        EnvObserveChangeReason r31 = EnvObserveChangeReason.TIMER_CHANGE;
        Intrinsics.checkNotNullParameter(r31, "reason");
        DoraEnvObserveManager.a.getClass();
        DoraEnvObserveManager.h(r31, r30);
        goto L34
    L23:
        return Unit.INSTANCE;
    L17:
        r13 = false;
    L55:
        th = move-exception;
        throw th;
    L59:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        r2 = (CoroutineScope) this.L$0;
        goto L10
    }
}
