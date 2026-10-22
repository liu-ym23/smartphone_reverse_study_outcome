package com.obric.memorydata.intelligence.datalearning.profile.b.b;

import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.database.dao.MiddleUserProfileDao;
import com.obric.memorydata.database.entity.Cdo;
import com.obric.memorydata.database.entity.dn;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.intelligence.api.ProfileLabel;
import com.obric.memorydata.utils.r;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0002J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0016\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0016\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014H\u0002J\u0016\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0014H\u0002¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/intelligence/datalearning/profile/time/sleepwakeup/SleepWakeupLongTask;", "Lcom/obric/memorydata/intelligence/datalearning/profile/task/BaseProfileTask;", "profileTaskInfo", "Lcom/obric/memorydata/intelligence/datalearning/profile/task/ProfileTaskInfo;", "<init>", "(Lcom/obric/memorydata/intelligence/datalearning/profile/task/ProfileTaskInfo;)V", "computeLongTermProfile", "", "startTimestamp", "endTimestamp", "genLongTermMoment", "", "isSleep", "", CommonConsts.APM_INNER_EVENT_COST_START, "end", "computeMidTermProfile", "computeLongTermMoment", "Lcom/obric/memorydata/intelligence/datalearning/profile/data/LabelValue;", "midProfiles", "", "Lcom/obric/memorydata/database/entity/MiddleUserProfileEntity;", "computeTimeList", "", "timeList", "computeMedian", "", Constants.KEY_LIST, "Companion", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b extends com.obric.memorydata.intelligence.datalearning.profile.task.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9957a = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/intelligence/datalearning/profile/time/sleepwakeup/SleepWakeupLongTask$Companion;", "", "<init>", "()V", "LONG_DAYS", "", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f9957a = new a(null);
    }

    public b(com.obric.memorydata.intelligence.datalearning.profile.task.b r2) {
        Intrinsics.checkNotNullParameter(r2, "profileTaskInfo");
        super(r2);
    }

    private final com.obric.memorydata.intelligence.datalearning.profile.data.a a(List<dn> r18) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        ArrayList r3 = new ArrayList();
        Iterator r2 = r1.iterator();
    L3:
        int r6 = 0;
        if (r2.hasNext() == false) goto L9;
        dn r4 = (dn) ZeusTransformUtils.preCheckCast(r2.next(), dn.class, "com.obric.memorydata.plugin");
        List<String> r5 = Cdo.a(r4.c(), r4.b());
        if (r5.size() != 1) goto L3;
        r3.add(Long.valueOf(com.obric.memorydata.intelligence.datalearning.profile.b.b.a.f9956a.a((String) ZeusTransformUtils.preCheckCast(r5.get(0), String.class, "com.obric.memorydata.plugin"))));
        goto L3
    L9:
        CollectionsKt.sort((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"));
        long r7 = 0;
        int r8 = 0;
        int r9 = 0;
    L11:
        if (r8 >= (r3.size() - 1)) goto L16;
        int r10 = r8 + 1;
        long r11 = ((Number) ZeusTransformUtils.preCheckCast(r3.get(r10), Number.class, "com.obric.memorydata.plugin")).longValue();
        Object r13 = r3.get(r8);
        Intrinsics.checkNotNullExpressionValue(r13, "get(...)");
        if ((r11 - ((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.memorydata.plugin")).longValue()) <= r7) goto L15;
        long r12 = ((Number) ZeusTransformUtils.preCheckCast(r3.get(r10), Number.class, "com.obric.memorydata.plugin")).longValue();
        Object r14 = r3.get(r8);
        Intrinsics.checkNotNullExpressionValue(r14, "get(...)");
        r7 = r12 - ((Number) ZeusTransformUtils.preCheckCast(r14, Number.class, "com.obric.memorydata.plugin")).longValue();
        r9 = r8;
    L15:
        r8 = r10;
        goto L11
    L16:
        com.obric.memorydata.intelligence.datalearning.profile.data.a r15 = new com.obric.memorydata.intelligence.datalearning.profile.data.a();
        long r16 = ((Number) ZeusTransformUtils.preCheckCast(r3.get(0), Number.class, "com.obric.memorydata.plugin")).longValue() + TimeUnit.DAYS.toMillis(1);
        Object r17 = r3.get(r3.size() - 1);
        Intrinsics.checkNotNullExpressionValue(r17, "get(...)");
        if (r7 >= (r16 - ((Number) ZeusTransformUtils.preCheckCast(r17, Number.class, "com.obric.memorydata.plugin")).longValue())) goto L19;
    L18:
        r15.a(CollectionsKt.listOf(b((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"))), 1.0d);
        return r15;
    L19:
        if (r6 > r9) goto L21;
        r3.set(r6, Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r3.get(r6), Number.class, "com.obric.memorydata.plugin")).longValue() + TimeUnit.DAYS.toMillis(1)));
        r6 = r6 + 1;
        goto L19
    L21:
        CollectionsKt.sort((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"));
        goto L18
    }

    private static final Double a(Long r2) {
        return Double.valueOf(r2.longValue());
    }

    private static final Double a(Function1 r2, Object r3) {
        return (Double) ZeusTransformUtils.preCheckCast(((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(r3), Double.class, "com.obric.memorydata.plugin");
    }

    private final void a(boolean r8, long r9, long r11) {
        MiddleUserProfileDao r1 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMiddleUserProfileDao();
        if (r8 == false) goto L5;
        ProfileLabel r0 = ProfileLabel.SLEEP_MOMENT;
    L6:
        List<dn> r10 = r1.queryRecords(r0.toString(), r9, r11);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L14;
        com.obric.memorydata.intelligence.datalearning.profile.data.a r12 = a(r10);
        if (r8 == false) goto L11;
        ProfileLabel r13 = ProfileLabel.SLEEP_MOMENT;
    L12:
        String r14 = r13.toString();
        a(r14, r12.a(r14), System.currentTimeMillis());
        return;
    L11:
        r13 = ProfileLabel.WAKEUP_MOMENT;
        goto L12
    L14:
        return;
    L5:
        r0 = ProfileLabel.WAKEUP_MOMENT;
        goto L6
    }

    private final String b(List<Long> r6) {
        Stream r7 = ((List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin")).stream();
        final $$Lambda$b$jn94vzvDFUaRkaH7wgnyyNGuMDo r0 = $$Lambda$b$jn94vzvDFUaRkaH7wgnyyNGuMDo.INSTANCE;
        List<Double> r8 = (List) ZeusTransformUtils.preCheckCast(r7.map(new $$Lambda$b$qMDoHLHEnQW5kpNOKyoyrWobh14(r0)).collect(Collectors.toList()), List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r8);
        long r5 = (long) c(r8);
        if (r5 <= TimeUnit.DAYS.toMillis(1)) goto L5;
        com.obric.memorydata.intelligence.datalearning.profile.b.b.a r1 = com.obric.memorydata.intelligence.datalearning.profile.b.b.a.f9956a;
        r5 = r5 - TimeUnit.DAYS.toMillis(1);
    L7:
        return r1.a(r5);
    L5:
        r1 = com.obric.memorydata.intelligence.datalearning.profile.b.b.a.f9956a;
        goto L7
    }

    private final double c(List<Double> r4) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if ((r3.size() % 2) == 0) goto L6;
        return ((Number) ZeusTransformUtils.preCheckCast(r3.get(r3.size() / 2), Number.class, "com.obric.memorydata.plugin")).doubleValue();
    L6:
        return (((Number) ZeusTransformUtils.preCheckCast(r3.get(r3.size() / 2), Number.class, "com.obric.memorydata.plugin")).doubleValue() + ((Number) ZeusTransformUtils.preCheckCast(r3.get((r3.size() / 2) - 1), Number.class, "com.obric.memorydata.plugin")).doubleValue()) / 2.0d;
    }

    public static /* synthetic */ Double lambda$jn94vzvDFUaRkaH7wgnyyNGuMDo(Long r0) {
        return a(r0);
    }

    public static /* synthetic */ Double lambda$qMDoHLHEnQW5kpNOKyoyrWobh14(Function1 r0, Object r1) {
        return a(r0, r1);
    }

    @Override // com.obric.memorydata.intelligence.datalearning.profile.task.a
    public long a(long r9, long r11) {
        long r10 = r.a(r11);
        long r6 = (r10 - TimeUnit.DAYS.toMillis(90)) - 1;
        a(true, r6, r10);
        a(false, r6, r10);
        return r11;
    }

    @Override // com.obric.memorydata.intelligence.datalearning.profile.task.a
    public long b(long r1, long r3) {
        return -1;
    }
}
