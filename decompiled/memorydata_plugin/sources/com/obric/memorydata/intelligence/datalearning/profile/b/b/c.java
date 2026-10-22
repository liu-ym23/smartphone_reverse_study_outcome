package com.obric.memorydata.intelligence.datalearning.profile.b.b;

import androidx.exifinterface.media.ExifInterface;
import com.obric.cae.userAware.WifiScanStateMachine;
import com.obric.memorydata.database.entity.aw;
import com.obric.memorydata.database.entity.ay;
import com.obric.memorydata.database.entity.ic;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.intelligence.api.ProfileLabel;
import com.obric.memorydata.intelligence.datalearning.service.UserProfileLabelQuery;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.Format;
import com.obric.memorydata.utils.r;
import com.tom_roush.pdfbox.pdmodel.a.d.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J \u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tH\u0002J\u0016\u0010\u0016\u001a\u00020\u000e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013H\u0002J\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013H\u0002J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00132\u0006\u0010\u001a\u001a\u00020\tH\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0002R\u0010\u0010\u0006\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/intelligence/datalearning/profile/time/sleepwakeup/SleepWakeupMidTask;", "Lcom/obric/memorydata/intelligence/datalearning/profile/task/BaseProfileTask;", "profileTaskInfo", "Lcom/obric/memorydata/intelligence/datalearning/profile/task/ProfileTaskInfo;", "<init>", "(Lcom/obric/memorydata/intelligence/datalearning/profile/task/ProfileTaskInfo;)V", "dateFormat", "Ljava/text/SimpleDateFormat;", "computeLongTermProfile", "", "startTimestamp", "endTimestamp", "computeMidTermProfile", "computeSleepWakeupMomentByScreenState", "Lcom/obric/memorydata/intelligence/datalearning/profile/data/TimeDuration;", "curDayStartTime", "adjustWakeupTime", "timeDuration", "getAlarmTime", "", "beginTime", "endTime", "selectFromCandidateDuration", "durationList", "mergeScreenOffDuration", "findAllScreenOffDuration", "startTime", "generateMidProfile", "", "Companion", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c extends com.obric.memorydata.intelligence.datalearning.profile.task.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9958a = null;
    private static final Integer[] d = null;
    private final SimpleDateFormat c;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/intelligence/datalearning/profile/time/sleepwakeup/SleepWakeupMidTask$Companion;", "", "<init>", "()V", "INVALID_INTERVAL_SECONDS_OF_SPECIFIED_HOUR", "", "", "[Ljava/lang/Integer;", "VALID_SLEEP_MIN_INTERVAL_TIME", "", "VALID_SLEEP_MAX_INTERVAL_TIME", "BASE_TIMELINE_OF_DAYS", "TAG", "", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((ic) ZeusTransformUtils.preCheckCast(r2, ic.class, "com.obric.memorydata.plugin")).c()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((ic) ZeusTransformUtils.preCheckCast(r3, ic.class, "com.obric.memorydata.plugin")).c()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f9958a = new a(null);
        d = new Integer[]{11, 29, 93, 303, 93, 29, 11, 5, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5};
    }

    public c(com.obric.memorydata.intelligence.datalearning.profile.task.b r2) {
        Intrinsics.checkNotNullParameter(r2, "profileTaskInfo");
        super(r2);
        this.c = new SimpleDateFormat(Format.FULL.getValue());
    }

    private final com.obric.memorydata.intelligence.datalearning.profile.data.d a(long r14) {
        RunLog.INSTANCE.debug("SleepWakeupMidTask", "computeSleepWakeupMomentByScreenState " + this.c.format(Long.valueOf(r14)));
        List<com.obric.memorydata.intelligence.datalearning.profile.data.d> r0 = b(r14);
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        com.obric.memorydata.intelligence.datalearning.profile.data.d r4 = (com.obric.memorydata.intelligence.datalearning.profile.data.d) ZeusTransformUtils.preCheckCast(r1.next(), com.obric.memorydata.intelligence.datalearning.profile.data.d.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.debug("SleepWakeupMidTask", "origScreenOffDuration " + this.c.format(Long.valueOf(r4.a())) + " time " + this.c.format(Long.valueOf(r4.b())));
        goto L4
    L6:
        List<com.obric.memorydata.intelligence.datalearning.profile.data.d> r2 = b(r0);
        ArrayList r3 = new ArrayList();
        Iterator<com.obric.memorydata.intelligence.datalearning.profile.data.d> r5 = r2.iterator();
    L7:
        boolean r6 = true;
        if (r5.hasNext() == false) goto L19;
        com.obric.memorydata.intelligence.datalearning.profile.data.d r7 = (com.obric.memorydata.intelligence.datalearning.profile.data.d) ZeusTransformUtils.preCheckCast(r5.next(), com.obric.memorydata.intelligence.datalearning.profile.data.d.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.debug("SleepWakeupMidTask", "mergeDuration " + this.c.format(Long.valueOf(r7.a())) + " time " + this.c.format(Long.valueOf(r7.b())));
        long r8 = r7.b() - r7.a();
        if (14400000 <= r8) goto L12;
    L14:
        r6 = false;
    L15:
        if (r6 == false) goto L7;
        if (r7.b() <= r14) goto L7;
        r3.add(r7);
        goto L7
    L12:
        if (r8 >= 57600001) goto L14;
    L19:
        long r15 = r14 - TimeUnit.DAYS.toMillis(2);
        if (r3.isEmpty() == false) goto L23;
        return null;
    L23:
        if (r3.size() != 1) goto L26;
        Object r9 = r3.get(0);
        Intrinsics.checkNotNullExpressionValue(r9, "get(...)");
        com.obric.memorydata.intelligence.datalearning.profile.data.d r13 = a((com.obric.memorydata.intelligence.datalearning.profile.data.d) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.intelligence.datalearning.profile.data.d.class, "com.obric.memorydata.plugin"));
        return new com.obric.memorydata.intelligence.datalearning.profile.data.d(r13.a() - r15, r13.b() - r15);
    L26:
        com.obric.memorydata.intelligence.datalearning.profile.data.d r16 = a(a((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin")));
        return new com.obric.memorydata.intelligence.datalearning.profile.data.d(r16.a() - r15, r16.b() - r15);
    }

    private final com.obric.memorydata.intelligence.datalearning.profile.data.d a(com.obric.memorydata.intelligence.datalearning.profile.data.d r9) {
        List<Long> r8 = c(r9.a(), r9.b());
        if (r8 == null) goto L12;
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r10.hasNext() == false) goto L12;
        long r2 = ((Number) ZeusTransformUtils.preCheckCast(r10.next(), Number.class, "com.obric.memorydata.plugin")).longValue();
        if (r2 >= r9.b()) goto L6;
        if ((r9.b() - r2) >= TimeUnit.MINUTES.toMillis(90)) goto L6;
        r9.a(r2);
    L12:
        return r9;
    }

    private final com.obric.memorydata.intelligence.datalearning.profile.data.d a(List<com.obric.memorydata.intelligence.datalearning.profile.data.d> r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.intelligence.datalearning.profile.data.d r0 = new com.obric.memorydata.intelligence.datalearning.profile.data.d(0, 0);
        com.obric.memorydata.intelligence.datalearning.profile.data.d r4 = new com.obric.memorydata.intelligence.datalearning.profile.data.d(0, 0);
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r12.hasNext() == false) goto L14;
        com.obric.memorydata.intelligence.datalearning.profile.data.d r2 = (com.obric.memorydata.intelligence.datalearning.profile.data.d) ZeusTransformUtils.preCheckCast(r12.next(), com.obric.memorydata.intelligence.datalearning.profile.data.d.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.debug("SleepWakeupMidTask", "selectFromCandidateDuration " + this.c.format(Long.valueOf(r2.a())) + " time " + this.c.format(Long.valueOf(r2.b())));
        if (com.obric.memorydata.intelligence.datalearning.profile.b.b.a.f9956a.a(r2.a(), r2.b()) == true) goto L8;
        if (r4.c() >= r2.c()) goto L4;
        r4 = r2;
        goto L4
    L8:
        if (r0.c() >= r2.c()) goto L4;
        r0 = r2;
        goto L4
    L14:
        if ((r0.c() + ((double) 2)) < r4.c()) goto L17;
        return r0;
    L17:
        return r4;
    }

    private final void a(com.obric.memorydata.intelligence.datalearning.profile.data.d r10, long r11) {
        HashMap r0 = new HashMap(2);
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin")).put(ProfileLabel.SLEEP_MOMENT, UserProfileLabelQuery.INSTANCE.assembleMidUriVal(ProfileLabel.SLEEP_MOMENT, CollectionsKt.listOf(com.obric.memorydata.intelligence.datalearning.profile.b.b.a.f9956a.a(r10.a()))));
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin")).put(ProfileLabel.WAKEUP_MOMENT, UserProfileLabelQuery.INSTANCE.assembleMidUriVal(ProfileLabel.WAKEUP_MOMENT, CollectionsKt.listOf(com.obric.memorydata.intelligence.datalearning.profile.b.b.a.f9956a.a(r10.b()))));
        a(new com.obric.memorydata.intelligence.datalearning.profile.data.b((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin"), r11));
    }

    private final List<com.obric.memorydata.intelligence.datalearning.profile.data.d> b(long r20) {
        long r2 = (r20 - WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS) - 1;
        long r0 = (r20 + WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS) - 1;
        ArrayList r4 = new ArrayList();
        r4.addAll((Collection) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getScreenStateDao().queryOnAndOffEvents(r2, r0), Collection.class, "com.obric.memorydata.plugin"));
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getDeviceShutdownDao().queryRecords(r2, r0), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r4.add(new ic(100000005, 1, ((ay) ZeusTransformUtils.preCheckCast(r1.next(), ay.class, "com.obric.memorydata.plugin")).c(), "shutdown", "known", 0, 32, null));
        goto L4
    L6:
        List r3 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
        if (r3.size() <= 1) goto L9;
        CollectionsKt.sortWith(r3, (Comparator) ZeusTransformUtils.preCheckCast(new b(), Comparator.class, "com.obric.memorydata.plugin"));
    L9:
        ArrayList r5 = new ArrayList();
        Iterator r6 = r4.iterator();
        Intrinsics.checkNotNullExpressionValue(r6, "iterator(...)");
        long r7 = -1;
        long r8 = -1;
    L11:
        if (r6.hasNext() == false) goto L30;
        Object r9 = r6.next();
        Intrinsics.checkNotNullExpressionValue(r9, "next(...)");
        ic r10 = (ic) ZeusTransformUtils.preCheckCast(r9, ic.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SleepWakeupMidTask", "screen state " + r10.d() + " time " + this.c.format(Long.valueOf(r10.c())), false, 4, null);
        if (Intrinsics.areEqual(r10.d(), "shutdown") == true) goto L14;
        if (r7 == (-1)) goto L20;
        r5.add(new com.obric.memorydata.intelligence.datalearning.profile.data.d(r7, r10.c()));
        r7 = -1;
    L20:
        if (Intrinsics.areEqual(r10.d(), f.g) == false) goto L25;
        if (r8 != (-1)) goto L25;
        r8 = r10.c();
    L25:
        if (Intrinsics.areEqual(r10.d(), "unlock") == false) goto L11;
        if (r8 == (-1)) goto L11;
        r5.add(new com.obric.memorydata.intelligence.datalearning.profile.data.d(r8, r10.c()));
    L15:
        r8 = -1;
        goto L11
    L14:
        r7 = r10.c();
        goto L15
    L30:
        return (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
    }

    private final List<com.obric.memorydata.intelligence.datalearning.profile.data.d> b(List<com.obric.memorydata.intelligence.datalearning.profile.data.d> r11) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        ArrayList r12 = new ArrayList();
        Calendar r1 = Calendar.getInstance();
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L12;
        com.obric.memorydata.intelligence.datalearning.profile.data.d r2 = new com.obric.memorydata.intelligence.datalearning.profile.data.d(0, 0);
        Iterator r13 = r10.iterator();
    L6:
        if (r13.hasNext() == false) goto L12;
        com.obric.memorydata.intelligence.datalearning.profile.data.d r3 = (com.obric.memorydata.intelligence.datalearning.profile.data.d) ZeusTransformUtils.preCheckCast(r13.next(), com.obric.memorydata.intelligence.datalearning.profile.data.d.class, "com.obric.memorydata.plugin");
        r1.setTimeInMillis(r3.a());
        if ((r3.a() - r2.b()) <= TimeUnit.SECONDS.toMillis(d[r1.get(11)].intValue())) goto L9;
        r12.add(r3);
        r2 = r3;
        goto L6
    L9:
        r2.a(r3.b());
    L12:
        return (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin");
    }

    private final List<Long> c(long r1, long r3) {
        List<aw> r0 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAlarmDao().queryRecords(r1, r3);
        if (r0.isEmpty() == false) goto L5;
        return null;
    L5:
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r5 = r2.iterator();
    L7:
        if (r5.hasNext() == false) goto L10;
        r4.add(Long.valueOf(((aw) ZeusTransformUtils.preCheckCast(r5.next(), aw.class, "com.obric.memorydata.plugin")).c()));
        goto L7
    L10:
        return (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.intelligence.datalearning.profile.task.a
    public long a(long r1, long r3) {
        return -1;
    }

    @Override // com.obric.memorydata.intelligence.datalearning.profile.task.a
    public long b(long r10, long r12) {
        RunLog.INSTANCE.debug("SleepWakeupMidTask", "computeMidTermProfile begin " + this.c.format(Long.valueOf(r10)) + " end " + this.c.format(Long.valueOf(r12)));
        long r0 = r.a(r12);
        long r11 = r.a(r10);
    L4:
        if (r11 >= r0) goto L9;
        com.obric.memorydata.intelligence.datalearning.profile.data.d r3 = a(r11);
        if (r3 == null) goto L8;
        RunLog.INSTANCE.debug("SleepWakeupMidTask", "day " + r.e(r11) + " sleep time " + com.obric.memorydata.intelligence.datalearning.profile.b.b.a.f9956a.a(r3.a()) + " wakeup time " + com.obric.memorydata.intelligence.datalearning.profile.b.b.a.f9956a.a(r3.b()));
        a(r3, r11);
    L8:
        r11 = r11 + TimeUnit.DAYS.toMillis(1);
        goto L4
    L9:
        return r12;
    }
}
