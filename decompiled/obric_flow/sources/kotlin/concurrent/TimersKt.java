package kotlin.concurrent;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001aM\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001aO\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001a\u001a\u0010\u0010\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001\u001aM\u0010\u0010\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001aO\u0010\u0010\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001a'\u0010\u0011\u001a\u00020\f2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001a3\u0010\u0012\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00072\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001a;\u0010\u0012\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001a3\u0010\u0012\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001a;\u0010\u0012\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001a;\u0010\u0015\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001a;\u0010\u0015\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0016"}, d2 = {"fixedRateTimer", "Ljava/util/Timer;", "name", "", "daemon", "", "startAt", "Ljava/util/Date;", "period", "", "action", "Lkotlin/Function1;", "Ljava/util/TimerTask;", "", "Lkotlin/ExtensionFunctionType;", "initialDelay", "timer", "timerTask", "schedule", "time", "delay", "scheduleAtFixedRate", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
@JvmName(name = "TimersKt")
public final class TimersKt {

    /* JADX INFO: renamed from: kotlin.concurrent.TimersKt$timerTask$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"kotlin/concurrent/TimersKt$timerTask$1", "Ljava/util/TimerTask;", "run", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 176)
    public static final class AnonymousClass1 extends TimerTask {
        final /* synthetic */ Function1<TimerTask, Unit> $action;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function1<? super TimerTask, Unit> r5) {
            this.$action = r5;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.$action.invoke(this);
        }
    }

    @InlineOnly
    private static final Timer fixedRateTimer(String r10, boolean r11, long r12, long r13, Function1<? super TimerTask, Unit> r14) {
        Intrinsics.checkNotNullParameter(r14, "action");
        Timer r15 = timer(r10, r11);
        r15.scheduleAtFixedRate(new AnonymousClass1(r14), r12, r13);
        return r15;
    }

    public static /* synthetic */ Timer fixedRateTimer$default(String r10, boolean r11, long r12, long r13, Function1 r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r11 = false;
    L9:
        if ((r15 & 4) == 0) goto L11;
        r12 = 0;
    L11:
        Intrinsics.checkNotNullParameter(r14, "action");
        Timer r17 = timer(r10, r11);
        AnonymousClass1 r5 = new AnonymousClass1(r14);
        r17.scheduleAtFixedRate(r5, r12, r13);
        return r17;
    }

    @InlineOnly
    private static final TimerTask schedule(Timer r5, long r10, Function1<? super TimerTask, Unit> r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        AnonymousClass1 r12 = new AnonymousClass1(r11);
        r5.schedule(r12, r10);
        return r12;
    }

    @InlineOnly
    private static final TimerTask scheduleAtFixedRate(Timer r10, long r11, long r12, Function1<? super TimerTask, Unit> r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r13, "action");
        AnonymousClass1 r5 = new AnonymousClass1(r13);
        r10.scheduleAtFixedRate(r5, r11, r12);
        return r5;
    }

    @PublishedApi
    public static final Timer timer(String r5, boolean r10) {
        if (r5 != null) goto L5;
        return new Timer(r10);
    L5:
        return new Timer(r5, r10);
    }

    public static /* synthetic */ Timer timer$default(String r10, boolean r11, long r12, long r13, Function1 r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r11 = false;
    L9:
        if ((r15 & 4) == 0) goto L11;
        r12 = 0;
    L11:
        Intrinsics.checkNotNullParameter(r14, "action");
        Timer r17 = timer(r10, r11);
        AnonymousClass1 r5 = new AnonymousClass1(r14);
        r17.schedule(r5, r12, r13);
        return r17;
    }

    @InlineOnly
    private static final TimerTask timerTask(Function1<? super TimerTask, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "action");
        return new AnonymousClass1(r5);
    }

    @InlineOnly
    private static final Timer timer(String r10, boolean r11, long r12, long r13, Function1<? super TimerTask, Unit> r14) {
        Intrinsics.checkNotNullParameter(r14, "action");
        Timer r15 = timer(r10, r11);
        r15.schedule(new AnonymousClass1(r14), r12, r13);
        return r15;
    }

    @InlineOnly
    private static final Timer fixedRateTimer(String r5, boolean r10, Date r11, long r12, Function1<? super TimerTask, Unit> r13) {
        Intrinsics.checkNotNullParameter(r11, "startAt");
        Intrinsics.checkNotNullParameter(r13, "action");
        Timer r14 = timer(r5, r10);
        r14.scheduleAtFixedRate(new AnonymousClass1(r13), r11, r12);
        return r14;
    }

    @InlineOnly
    private static final TimerTask schedule(Timer r5, Date r10, Function1<? super TimerTask, Unit> r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "time");
        Intrinsics.checkNotNullParameter(r11, "action");
        AnonymousClass1 r12 = new AnonymousClass1(r11);
        r5.schedule(r12, r10);
        return r12;
    }

    @InlineOnly
    private static final TimerTask scheduleAtFixedRate(Timer r5, Date r10, long r11, Function1<? super TimerTask, Unit> r12) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "time");
        Intrinsics.checkNotNullParameter(r12, "action");
        AnonymousClass1 r13 = new AnonymousClass1(r12);
        r5.scheduleAtFixedRate(r13, r10, r11);
        return r13;
    }

    public static /* synthetic */ Timer fixedRateTimer$default(String r5, boolean r10, Date r11, long r12, Function1 r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r5 = null;
    L6:
        if ((r14 & 2) == 0) goto L8;
        r10 = false;
    L8:
        Intrinsics.checkNotNullParameter(r11, "startAt");
        Intrinsics.checkNotNullParameter(r13, "action");
        Timer r16 = timer(r5, r10);
        r16.scheduleAtFixedRate(new AnonymousClass1(r13), r11, r12);
        return r16;
    }

    @InlineOnly
    private static final Timer timer(String r5, boolean r10, Date r11, long r12, Function1<? super TimerTask, Unit> r13) {
        Intrinsics.checkNotNullParameter(r11, "startAt");
        Intrinsics.checkNotNullParameter(r13, "action");
        Timer r14 = timer(r5, r10);
        r14.schedule(new AnonymousClass1(r13), r11, r12);
        return r14;
    }

    public static /* synthetic */ Timer timer$default(String r5, boolean r10, Date r11, long r12, Function1 r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r5 = null;
    L6:
        if ((r14 & 2) == 0) goto L8;
        r10 = false;
    L8:
        Intrinsics.checkNotNullParameter(r11, "startAt");
        Intrinsics.checkNotNullParameter(r13, "action");
        Timer r16 = timer(r5, r10);
        r16.schedule(new AnonymousClass1(r13), r11, r12);
        return r16;
    }

    @InlineOnly
    private static final TimerTask schedule(Timer r10, long r11, long r12, Function1<? super TimerTask, Unit> r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r13, "action");
        AnonymousClass1 r5 = new AnonymousClass1(r13);
        r10.schedule(r5, r11, r12);
        return r5;
    }

    @InlineOnly
    private static final TimerTask schedule(Timer r5, Date r10, long r11, Function1<? super TimerTask, Unit> r12) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "time");
        Intrinsics.checkNotNullParameter(r12, "action");
        AnonymousClass1 r13 = new AnonymousClass1(r12);
        r5.schedule(r13, r10, r11);
        return r13;
    }
}
