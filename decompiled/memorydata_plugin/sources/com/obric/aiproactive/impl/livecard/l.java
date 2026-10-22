package com.obric.aiproactive.impl.livecard;

import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardAlarmScheduler;", "", "<init>", "()V", "state", "Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardTimeAbilitySchedulerState;", "scheduleDismiss", "", "recommendId", "", "expireAtMs", "", "cancelDismiss", "handleDismiss", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f6475a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final q f6476b = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6477a = null;

        static {
            int[] r0 = new int[ScheduleResult.values().length];
            r0[ScheduleResult.SCHEDULED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ScheduleResult.DISMISSED_IMMEDIATELY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ScheduleResult.FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f6477a = r0;
        }
    }

    static {
        l r0 = new l();
        f6475a = r0;
        f6476b = new q((p) ZeusTransformUtils.preCheckCast(new com.obric.aiproactive.impl.livecard.a(), p.class, "com.obric.memorydata.plugin"), $$Lambda$l$MaRxmpByPEyeYsV3_bC0O95nBrQ.INSTANCE, (Function1) ZeusTransformUtils.preCheckCast(new ProactiveLiveCardAlarmScheduler$state$2(r0), Function1.class, "com.obric.memorydata.plugin"));
    }

    private l() {
    }

    private static final long a() {
        return System.currentTimeMillis();
    }

    public static final /* synthetic */ void a(l r0, String r1) {
        r0.b(r1);
    }

    private final void b(String r12) {
        long r0 = System.currentTimeMillis();
        String r11 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(r0));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveLiveCardAlarmScheduler", "[LiveCardAlarm-TRIGGERED] onDataReceive fired at " + r0 + " (" + r11 + "), recommendId=" + r12, false, 4, null);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveLiveCardAlarmScheduler", "[LiveCardAlarm-DISMISS] Broadcasting destruction for recommendId=" + r12 + " at " + r0 + " (" + r11 + ')', false, 4, null);
        n.f6478a.c(r12, "auto_dismiss");
        n.f6478a.a(r12, "auto_dismiss");
    }

    public static /* synthetic */ long lambda$MaRxmpByPEyeYsV3_bC0O95nBrQ() {
        return a();
    }

    public final void a(String r8) {
        Intrinsics.checkNotNullParameter(r8, "recommendId");
        if (f6476b.a(r8) == false) goto L5;
        IRunLog r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r7 = new StringBuilder().append("[LiveCardAlarm-CANCEL] recommendId=").append(r8);
        String r9 = " source=TimeAbility";
    L6:
        IRunLog.a.a(r1, "ProactiveLiveCardAlarmScheduler", r7.append(r9).toString(), false, 4, null);
        return;
    L5:
        r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r7 = new StringBuilder().append("[LiveCardAlarm-CANCEL] recommendId=").append(r8);
        r9 = " source=TimeAbility skipped=true";
        goto L6
    }

    public final void a(String r21, long r22) {
        Intrinsics.checkNotNullParameter(r21, "recommendId");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r21, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveLiveCardAlarmScheduler", "scheduleDismiss failed: recommendId is blank", null, 4, null);
        return;
    L6:
        long r5 = System.currentTimeMillis();
        ScheduleResult r3 = f6476b.a(r21, r22);
        long r6 = r22 - r5;
        String r7 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(r22));
        int r4 = a.f6477a[r3.ordinal()];
        if (r4 != 1) goto L9;
        IRunLog r14 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder().append("[LiveCardAlarm-SCHEDULE] recommendId=").append(r21).append(" expireAtMs=").append(r22).append(" expireAt=").append(r7).append(" delayMs=").append(r6).append(" source=TimeAbility");
    L17:
        IRunLog.a.a(r14, "ProactiveLiveCardAlarmScheduler", r0.toString(), false, 4, null);
        return;
    L9:
        if (r4 != 2) goto L11;
        r14 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r0 = new StringBuilder().append("[LiveCardAlarm-SCHEDULE] recommendId=").append(r21).append(" expireAtMs=").append(r22).append(" expireAt=").append(r7).append(" delayMs=").append(r6).append(" source=TimeAbility immediate=true");
        goto L17
    L11:
        if (r4 != 3) goto L14;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveLiveCardAlarmScheduler", "[LiveCardAlarm-SCHEDULE] failed recommendId=" + r21 + " expireAtMs=" + r22 + " expireAt=" + r7 + " delayMs=" + r6 + " source=TimeAbility", null, 4, null);
        return;
    L14:
        throw new NoWhenBranchMatchedException();
    }
}
