package com.obric.memorydata.personalcontext.realcontext;

import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.entity.app.AlarmEntity;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.database.dao.AlarmRawDbDao;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.entity.AlarmSwitchStatus;
import com.obric.memorydata.database.entity.fe;
import com.obric.memorydata.database.index.s;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.poison.g;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010#\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0002J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005J\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u0015J\u0012\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/personalcontext/realcontext/RCAlarmSearchUtils;", "", "<init>", "()V", "TAG", "", "BIZ_NAME", "ALARM_STATE_KEY", "DEFAULT_RING_STATE", "RINGING_STATE", "DEALY_RINGING_STATE", "ringingAlarm", "", "getRingingAlarmEntityId", "", "onAlarmRingStateChanged", "", "entityId", "state", "deleteRingingAlarm", "assistantQueryRingingAlarm", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "searchRingingAlarm", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12258a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f12259b = null;

    static {
        f12258a = new a();
        ConcurrentHashMap.KeySetView r0 = ConcurrentHashMap.newKeySet();
        Intrinsics.checkNotNullExpressionValue(r0, "newKeySet(...)");
        f12259b = (Set) ZeusTransformUtils.preCheckCast(r0, Set.class, "com.obric.memorydata.plugin");
    }

    private a() {
    }

    private static final IntentResult a(AlarmRawDbDao r24) {
        AlarmRawDbDao r0 = (AlarmRawDbDao) ZeusTransformUtils.wrapperContextForParams(r24, AlarmRawDbDao.class, "com.obric.memorydata.plugin");
        List<String> r2 = f12258a.c();
        if (r2.isEmpty() == false) goto L5;
        AppEntity[] r1 = new AppEntity[0];
    L16:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RCAlarmSearchUtils", "assistantQueryRingingAlarm success, result size = " + r1.length, false, 4, null);
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        int r4 = r1.length;
        int r5 = 0;
    L17:
        if (r5 >= r4) goto L23;
        AppEntity r6 = r1[r5];
        if (ZeusTransformUtils.instanceOf(r6, AlarmEntity.class) == false) goto L21;
        r3.add(r6);
    L21:
        r5 = r5 + 1;
        goto L17
    L23:
        return new IntentResult(0, ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new AppEntity[0]), null, null, false, false, 256, null, null, null, 956, null);
    L5:
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r0.queryByEntityIdListAndPackageName(r2, AppInfo.Alarm.getPackageName()), Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r7.iterator();
    L7:
        if (r9.hasNext() == false) goto L15;
        AppEntity r10 = g.f12254a.a((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast((fe) ZeusTransformUtils.preCheckCast(r9.next(), fe.class, "com.obric.memorydata.plugin"), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin"), (IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r0, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        if (ZeusTransformUtils.instanceOf(r10, AlarmEntity.class) == false) goto L11;
        AlarmEntity r11 = (AlarmEntity) ZeusTransformUtils.preCheckCast(r10, AlarmEntity.class, "com.obric.memorydata.plugin");
    L12:
        if (r11 == null) goto L14;
        r11.setRinging(true);
    L14:
        r8.add(r10);
        goto L7
    L11:
        r11 = null;
        goto L12
    L15:
        r1 = (AppEntity[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new AppEntity[0]), AppEntity[].class, "com.obric.memorydata.plugin");
        goto L16
    }

    private final synchronized List<String> c() {
        monitor-enter(this);
        List<String> r0 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(f12259b, Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ IntentResult lambda$rP3MGNGBiAsan4e7z2Lal_q3Yls(AlarmRawDbDao r0) {
        return a(r0);
    }

    public final IntentResult<AppEntity[]> a() {
        if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RCAlarmSearchUtils", "assistantQueryRingingAlarm, user not agree privacy", false, 4, null);
        return new IntentResult(0, new AppEntity[0], null, null, false, false, 256, null, null, null, 956, null);
    L6:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RCAlarmSearchUtils", "assistantQueryRingingAlarm", false, 4, null);
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r0 = s.a().getRawDaoByEntityType(701);
        if (ZeusTransformUtils.instanceOf(r0, AlarmRawDbDao.class) == false) goto L9;
        final AlarmRawDbDao r1 = (AlarmRawDbDao) ZeusTransformUtils.preCheckCast(r0, AlarmRawDbDao.class, "com.obric.memorydata.plugin");
    L10:
        if (r1 != null) goto L13;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RCAlarmSearchUtils", "assistantQueryRingingAlarm is null", null, 4, null);
        return new IntentResult(1, null, null, "assistantQueryRingingAlarm error, alarmEntityDao is null", false, false, 256, null, null, null, 950, null);
    L13:
        IntentResult<AppEntity[]> r2 = (IntentResult) ZeusTransformUtils.preCheckCast(y.a(null, new $$Lambda$a$rP3MGNGBiAsan4e7z2Lal_q3Yls(r1), 1, null), IntentResult.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L16;
        return r2;
    L16:
        return new IntentResult(0, new AppEntity[0], null, null, false, false, 256, null, null, null, 956, null);
    L9:
        r1 = null;
        goto L10
    }

    public final synchronized void a(String r8) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r8, "entityId");     // Catch: Throwable -> L6
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RCAlarmSearchUtils", "deleteRingingAlarm, entityId = " + r8, false, 4, null);     // Catch: Throwable -> L6
        f12259b.remove(r8);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(String r8, String r9) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r8, "entityId");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r9, "state");     // Catch: Throwable -> L12
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RCAlarmSearchUtils", "onAlarmRingStateChanged, entityId = " + r8 + ", state = " + r9, false, 4, null);     // Catch: Throwable -> L12
        if (Intrinsics.areEqual(r9, "ringing") == false) goto L6;
    L9:
        f12259b.add(r8);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L6:
        if (Intrinsics.areEqual(r9, "delayRinging") == true) goto L9;
        f12259b.remove(r8);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public final IntentResult<AppEntity[]> b() {
        if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RCAlarmSearchUtils", "user not agree privacy", false, 4, null);
        return new IntentResult(0, new AppEntity[0], null, null, false, false, 256, null, null, null, 956, null);
    L6:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RCAlarmSearchUtils", "searchRingingAlarm", false, 4, null);
        IntentResult<AppEntity[]> r0 = a();
        Object[] r3 = (Object[]) ZeusTransformUtils.preCheckCast(r0.getEntity(), Object[].class, "com.obric.memorydata.plugin");
        boolean r4 = true;
        if (r3 != null) goto L9;
    L15:
        if (r4 == true) goto L18;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RCAlarmSearchUtils", "search ringing alarm success", false, 4, null);
        return r0;
    L18:
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r1 = s.a().getRawDaoByEntityType(701);
        if (ZeusTransformUtils.instanceOf(r1, AlarmRawDbDao.class) == false) goto L21;
        AlarmRawDbDao r2 = (AlarmRawDbDao) ZeusTransformUtils.preCheckCast(r1, AlarmRawDbDao.class, "com.obric.memorydata.plugin");
    L22:
        if (r2 != null) goto L25;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RCAlarmSearchUtils", "alarmEntityDao is null", null, 4, null);
        return new IntentResult(1, null, null, "searchRingingAlarm error, alarmEntityDao is null", false, false, 256, null, null, null, 950, null);
    L25:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RCAlarmSearchUtils", "search all alarm entities", false, 4, null);
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r2.queryBySwitchStatus(AlarmSwitchStatus.ON, AppInfo.Alarm.getPackageName()), Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r5.iterator();
    L27:
        if (r7.hasNext() == false) goto L32;
        AppEntity r8 = g.f12254a.a((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast((fe) ZeusTransformUtils.preCheckCast(r7.next(), fe.class, "com.obric.memorydata.plugin"), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin"), (IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r2, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        if (r8 == null) goto L27;
        r6.add(r8);
        goto L27
    L32:
        return new IntentResult(0, (AppEntity[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new AppEntity[0]), AppEntity[].class, "com.obric.memorydata.plugin"), null, null, false, false, 256, null, null, null, 956, null);
    L21:
        r2 = null;
        goto L22
    L9:
        if (r3.length != 0) goto L11;
        boolean r9 = true;
    L12:
        if (r9 == true) goto L15;
        r4 = false;
        goto L15
    L11:
        r9 = false;
        goto L12
    }
}
