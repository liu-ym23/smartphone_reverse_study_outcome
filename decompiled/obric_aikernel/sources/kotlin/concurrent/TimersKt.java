package kotlin.concurrent;

import com.bytedance.bdinstall.oaid.OaidModel;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@JvmName(name = "TimersKt")
public final class TimersKt {

    /* JADX INFO: renamed from: kotlin.concurrent.TimersKt$timerTask$1, reason: invalid class name */
    @SourceDebugExtension({"SMAP\nTimer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Timer.kt\nkotlin/concurrent/TimersKt$timerTask$1\n*L\n1#1,148:1\n*E\n"})
    public static final class AnonymousClass1 extends TimerTask {
        final /* synthetic */ Function1<TimerTask, Unit> $action;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function1<? super TimerTask, Unit> r10) {
            this.$action = r10;
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

    @InlineOnly
    private static final Timer fixedRateTimer(String r10, boolean r11, Date r12, long r13, Function1<? super TimerTask, Unit> r14) {
        Intrinsics.checkNotNullParameter(r12, "startAt");
        Intrinsics.checkNotNullParameter(r14, "action");
        Timer r15 = timer(r10, r11);
        r15.scheduleAtFixedRate(new AnonymousClass1(r14), r12, r13);
        return r15;
    }

    static /* synthetic */ Timer fixedRateTimer$default(String r10, boolean r11, long r12, long r13, Function1 r14, int r15, Object r16) {
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
        AnonymousClass1 r18 = new AnonymousClass1(r14);
        r17.scheduleAtFixedRate(r18, r12, r13);
        return r17;
    }

    static /* synthetic */ Timer fixedRateTimer$default(String r10, boolean r11, Date r12, long r13, Function1 r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r15 & 2) == 0) goto L8;
        r11 = false;
    L8:
        Intrinsics.checkNotNullParameter(r12, "startAt");
        Intrinsics.checkNotNullParameter(r14, "action");
        Timer r17 = timer(r10, r11);
        r17.scheduleAtFixedRate(new AnonymousClass1(r14), r12, r13);
        return r17;
    }

    @InlineOnly
    private static final TimerTask schedule(Timer r10, long r11, long r12, Function1<? super TimerTask, Unit> r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r13, "action");
        AnonymousClass1 r14 = new AnonymousClass1(r13);
        r10.schedule(r14, r11, r12);
        return r14;
    }

    @InlineOnly
    private static final TimerTask schedule(Timer r10, long r11, Function1<? super TimerTask, Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "action");
        AnonymousClass1 r13 = new AnonymousClass1(r12);
        r10.schedule(r13, r11);
        return r13;
    }

    @InlineOnly
    private static final TimerTask schedule(Timer r10, Date r11, long r12, Function1<? super TimerTask, Unit> r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, OaidModel.KEY_TIME);
        Intrinsics.checkNotNullParameter(r13, "action");
        AnonymousClass1 r14 = new AnonymousClass1(r13);
        r10.schedule(r14, r11, r12);
        return r14;
    }

    @InlineOnly
    private static final TimerTask schedule(Timer r10, Date r11, Function1<? super TimerTask, Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, OaidModel.KEY_TIME);
        Intrinsics.checkNotNullParameter(r12, "action");
        AnonymousClass1 r13 = new AnonymousClass1(r12);
        r10.schedule(r13, r11);
        return r13;
    }

    @InlineOnly
    private static final TimerTask scheduleAtFixedRate(Timer r10, long r11, long r12, Function1<? super TimerTask, Unit> r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r13, "action");
        AnonymousClass1 r14 = new AnonymousClass1(r13);
        r10.scheduleAtFixedRate(r14, r11, r12);
        return r14;
    }

    @InlineOnly
    private static final TimerTask scheduleAtFixedRate(Timer r10, Date r11, long r12, Function1<? super TimerTask, Unit> r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, OaidModel.KEY_TIME);
        Intrinsics.checkNotNullParameter(r13, "action");
        AnonymousClass1 r14 = new AnonymousClass1(r13);
        r10.scheduleAtFixedRate(r14, r11, r12);
        return r14;
    }

    @PublishedApi
    public static final Timer timer(String r10, boolean r11) {
        if (r10 != null) goto L5;
        return new Timer(r11);
    L5:
        return new Timer(r10, r11);
    }

    @InlineOnly
    private static final Timer timer(String r10, boolean r11, long r12, long r13, Function1<? super TimerTask, Unit> r14) {
        Intrinsics.checkNotNullParameter(r14, "action");
        Timer r15 = timer(r10, r11);
        r15.schedule(new AnonymousClass1(r14), r12, r13);
        return r15;
    }

    @InlineOnly
    private static final Timer timer(String r10, boolean r11, Date r12, long r13, Function1<? super TimerTask, Unit> r14) {
        Intrinsics.checkNotNullParameter(r12, "startAt");
        Intrinsics.checkNotNullParameter(r14, "action");
        Timer r15 = timer(r10, r11);
        r15.schedule(new AnonymousClass1(r14), r12, r13);
        return r15;
    }

    static /* synthetic */ Timer timer$default(String r10, boolean r11, long r12, long r13, Function1 r14, int r15, Object r16) {
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
        AnonymousClass1 r18 = new AnonymousClass1(r14);
        r17.schedule(r18, r12, r13);
        return r17;
    }

    static /* synthetic */ Timer timer$default(String r10, boolean r11, Date r12, long r13, Function1 r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r15 & 2) == 0) goto L8;
        r11 = false;
    L8:
        Intrinsics.checkNotNullParameter(r12, "startAt");
        Intrinsics.checkNotNullParameter(r14, "action");
        Timer r17 = timer(r10, r11);
        r17.schedule(new AnonymousClass1(r14), r12, r13);
        return r17;
    }

    @InlineOnly
    private static final TimerTask timerTask(Function1<? super TimerTask, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "action");
        return new AnonymousClass1(r10);
    }
}
