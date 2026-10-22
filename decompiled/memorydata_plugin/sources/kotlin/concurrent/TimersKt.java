package kotlin.concurrent;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001aM\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001aO\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001a\u001a\u0010\u0010\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001\u001aM\u0010\u0010\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001aO\u0010\u0010\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001a'\u0010\u0011\u001a\u00020\f2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001a3\u0010\u0012\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00072\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001a;\u0010\u0012\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001a3\u0010\u0012\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001a;\u0010\u0012\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001a;\u0010\u0015\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001a;\u0010\u0015\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0016"}, d2 = {"fixedRateTimer", "Ljava/util/Timer;", ActivityLifecycle.NAME, "", "daemon", "", "startAt", "Ljava/util/Date;", TypedValues.CycleType.S_WAVE_PERIOD, "", "action", "Lkotlin/Function1;", "Ljava/util/TimerTask;", "", "Lkotlin/ExtensionFunctionType;", "initialDelay", CommonConsts.TIMER_TYPE, "timerTask", "schedule", OaidModel.KEY_TIME, "delay", "scheduleAtFixedRate", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class TimersKt {

    /* JADX INFO: renamed from: kotlin.concurrent.TimersKt$timerTask$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"kotlin/concurrent/TimersKt$timerTask$1", "Ljava/util/TimerTask;", "run", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 176)
    public static final class AnonymousClass1 extends TimerTask {
        final /* synthetic */ Function1<TimerTask, Unit> $action;

        public AnonymousClass1(Function1<? super TimerTask, Unit> r3) {
            this.$action = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.$action.invoke(this);
        }
    }

    private static final Timer fixedRateTimer(String r8, boolean r9, long r10, long r12, Function1<? super TimerTask, Unit> r14) {
        Function1 r15 = (Function1) ZeusTransformUtils.wrapperContextForParams(r14, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r15, "action");
        Timer r11 = timer(r8, r9);
        r11.scheduleAtFixedRate((TimerTask) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r15), TimerTask.class, "com.obric.memorydata.plugin"), r10, r12);
        return r11;
    }

    private static final Timer fixedRateTimer(String r2, boolean r3, Date r4, long r5, Function1<? super TimerTask, Unit> r7) {
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "startAt");
        Intrinsics.checkNotNullParameter(r8, "action");
        Timer r6 = timer(r2, r3);
        r6.scheduleAtFixedRate((TimerTask) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r8), TimerTask.class, "com.obric.memorydata.plugin"), r4, r5);
        return r6;
    }

    static /* synthetic */ Timer fixedRateTimer$default(String r7, boolean r8, long r9, long r11, Function1 r13, int r14, Object r15) {
        Function1 r16 = (Function1) ZeusTransformUtils.wrapperContextForParams(r13, Function1.class, "com.obric.memorydata.plugin");
        if ((r14 & 1) == 0) goto L6;
        r7 = null;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r8 = false;
    L9:
        if ((r14 & 4) == 0) goto L11;
        r9 = 0;
    L11:
        Intrinsics.checkNotNullParameter(r16, "action");
        Timer r10 = timer(r7, r8);
        TimerTask r2 = (TimerTask) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r16), TimerTask.class, "com.obric.memorydata.plugin");
        r10.scheduleAtFixedRate(r2, r9, r11);
        return r10;
    }

    static /* synthetic */ Timer fixedRateTimer$default(String r1, boolean r2, Date r3, long r4, Function1 r6, int r7, Object r8) {
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        if ((r7 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r7 & 2) == 0) goto L8;
        r2 = false;
    L8:
        Intrinsics.checkNotNullParameter(r3, "startAt");
        Intrinsics.checkNotNullParameter(r9, "action");
        Timer r5 = timer(r1, r2);
        r5.scheduleAtFixedRate((TimerTask) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r9), TimerTask.class, "com.obric.memorydata.plugin"), r3, r4);
        return r5;
    }

    private static final TimerTask schedule(Timer r6, long r7, long r9, Function1<? super TimerTask, Unit> r11) {
        Function1 r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r11, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r12, "action");
        TimerTask r13 = (TimerTask) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r12), TimerTask.class, "com.obric.memorydata.plugin");
        r6.schedule(r13, r7, r9);
        return r13;
    }

    private static final TimerTask schedule(Timer r2, long r3, Function1<? super TimerTask, Unit> r5) {
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r6, "action");
        TimerTask r7 = (TimerTask) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r6), TimerTask.class, "com.obric.memorydata.plugin");
        r2.schedule(r7, r3);
        return r7;
    }

    private static final TimerTask schedule(Timer r2, Date r3, long r4, Function1<? super TimerTask, Unit> r6) {
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, OaidModel.KEY_TIME);
        Intrinsics.checkNotNullParameter(r7, "action");
        TimerTask r8 = (TimerTask) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r7), TimerTask.class, "com.obric.memorydata.plugin");
        r2.schedule(r8, r3, r4);
        return r8;
    }

    private static final TimerTask schedule(Timer r2, Date r3, Function1<? super TimerTask, Unit> r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, OaidModel.KEY_TIME);
        Intrinsics.checkNotNullParameter(r5, "action");
        TimerTask r6 = (TimerTask) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), TimerTask.class, "com.obric.memorydata.plugin");
        r2.schedule(r6, r3);
        return r6;
    }

    private static final TimerTask scheduleAtFixedRate(Timer r6, long r7, long r9, Function1<? super TimerTask, Unit> r11) {
        Function1 r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r11, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r12, "action");
        TimerTask r13 = (TimerTask) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r12), TimerTask.class, "com.obric.memorydata.plugin");
        r6.scheduleAtFixedRate(r13, r7, r9);
        return r13;
    }

    private static final TimerTask scheduleAtFixedRate(Timer r2, Date r3, long r4, Function1<? super TimerTask, Unit> r6) {
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, OaidModel.KEY_TIME);
        Intrinsics.checkNotNullParameter(r7, "action");
        TimerTask r8 = (TimerTask) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r7), TimerTask.class, "com.obric.memorydata.plugin");
        r2.scheduleAtFixedRate(r8, r3, r4);
        return r8;
    }

    public static final Timer timer(String r1, boolean r2) {
        if (r1 != null) goto L5;
        return new Timer(r2);
    L5:
        return new Timer(r1, r2);
    }

    private static final Timer timer(String r8, boolean r9, long r10, long r12, Function1<? super TimerTask, Unit> r14) {
        Function1 r15 = (Function1) ZeusTransformUtils.wrapperContextForParams(r14, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r15, "action");
        Timer r11 = timer(r8, r9);
        r11.schedule((TimerTask) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r15), TimerTask.class, "com.obric.memorydata.plugin"), r10, r12);
        return r11;
    }

    private static final Timer timer(String r2, boolean r3, Date r4, long r5, Function1<? super TimerTask, Unit> r7) {
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "startAt");
        Intrinsics.checkNotNullParameter(r8, "action");
        Timer r6 = timer(r2, r3);
        r6.schedule((TimerTask) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r8), TimerTask.class, "com.obric.memorydata.plugin"), r4, r5);
        return r6;
    }

    static /* synthetic */ Timer timer$default(String r7, boolean r8, long r9, long r11, Function1 r13, int r14, Object r15) {
        Function1 r16 = (Function1) ZeusTransformUtils.wrapperContextForParams(r13, Function1.class, "com.obric.memorydata.plugin");
        if ((r14 & 1) == 0) goto L6;
        r7 = null;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r8 = false;
    L9:
        if ((r14 & 4) == 0) goto L11;
        r9 = 0;
    L11:
        Intrinsics.checkNotNullParameter(r16, "action");
        Timer r10 = timer(r7, r8);
        TimerTask r2 = (TimerTask) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r16), TimerTask.class, "com.obric.memorydata.plugin");
        r10.schedule(r2, r9, r11);
        return r10;
    }

    static /* synthetic */ Timer timer$default(String r1, boolean r2, Date r3, long r4, Function1 r6, int r7, Object r8) {
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        if ((r7 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r7 & 2) == 0) goto L8;
        r2 = false;
    L8:
        Intrinsics.checkNotNullParameter(r3, "startAt");
        Intrinsics.checkNotNullParameter(r9, "action");
        Timer r5 = timer(r1, r2);
        r5.schedule((TimerTask) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r9), TimerTask.class, "com.obric.memorydata.plugin"), r3, r4);
        return r5;
    }

    private static final TimerTask timerTask(Function1<? super TimerTask, Unit> r2) {
        Function1 r3 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "action");
        return (TimerTask) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), TimerTask.class, "com.obric.memorydata.plugin");
    }
}
