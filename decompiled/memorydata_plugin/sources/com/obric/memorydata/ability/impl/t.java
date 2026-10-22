package com.obric.memorydata.ability.impl;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0006H\u0016J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u00020\u0018H\u0016J\b\u0010!\u001a\u00020\u0018H\u0002J\u0010\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u000eH\u0002J\b\u0010$\u001a\u00020\u0018H\u0002J\b\u0010%\u001a\u00020\u0018H\u0002J\u0010\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u000eH\u0002J\u001c\u0010'\u001a\u00020\u00182\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR&\u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/obric/memorydata/ability/impl/TimeAbility;", "Landroid/content/BroadcastReceiver;", "Lcom/obric/memorydata/ability/impl/IMetaAbility;", "<init>", "()V", "abilityContext", "Lcom/obric/memorydata/ability/IAbilityContext;", "context", "Landroid/content/Context;", "alarmManager", "Landroid/app/AlarmManager;", "pendingIntent", "Landroid/app/PendingIntent;", "firstTriggerTime", "", "Ljava/lang/Long;", "timeReceiverMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "", "", "timeList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "onCreate", "", "iAbilityContext", "onVerify", TrackerImpl.PARAMS, "Lcom/obric/memorydata/ability/AbilityParams;", "onSubscribe", "key", "onUnsubscribe", "onDestroy", "registerReceiver", "getPendingIntent", OaidModel.KEY_TIME, "resetTimeAlarm", "triggerPassedTime", "now", "onReceive", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "Companion", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class t extends PluginBroadcastReceiver implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8416a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.memorydata.ability.j f8417b;
    private Context c;
    private AlarmManager d;
    private PendingIntent e;
    private Long f;
    private final ConcurrentHashMap<Long, ConcurrentHashMap.KeySetView<String, Boolean>> g;
    private final CopyOnWriteArrayList<Long> h;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/ability/impl/TimeAbility$Companion;", "", "<init>", "()V", "TAG", "", "ALARM_ACTION", "PARAMS_INTERVAL_INVALID_SECONDS", "", "INVALID_SHORT_INTERVAL_SECONDS", "KEY_TIME", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8416a = new a(null);
    }

    public t() {
        this.g = new ConcurrentHashMap();
        this.h = new CopyOnWriteArrayList();
    }

    private final PendingIntent a(long r4) {
        Context r0 = this.c;
        Intrinsics.checkNotNull(r0);
        Intent r1 = new Intent("com.obric.memorydata.alarm.action.notice");
        Context r3 = this.c;
        Intrinsics.checkNotNull(r3);
        PendingIntent r5 = PendingIntent.getBroadcast(r0, 100000006, r1.setPackage(r3.getPackageName()).putExtra(OaidModel.KEY_TIME, r4), 335544320);
        Intrinsics.checkNotNullExpressionValue(r5, "getBroadcast(...)");
        return r5;
    }

    private static final void a(t r12, Intent r13) {
        if (r12.h.isEmpty() == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TimeAbility", "not time registered, ignore publish", null, 4, null);
        return;
    L6:
        if (Intrinsics.areEqual("com.obric.memorydata.alarm.action.notice", r13.getAction()) == false) goto L8;
        long r2 = r13.getLongExtra(OaidModel.KEY_TIME, 0);
        long r4 = System.currentTimeMillis();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TimeAbility", "onReceive alarm time: " + r2 + " and curTime: " + r4, false, 4, null);
        r12.b(Math.max(r2, r4));
        return;
    L8:
        r12.c();
    }

    private final void b() {
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.h, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L5;
    L8:
        PendingIntent r0 = this.e;
        if (r0 == null) goto L12;
        AlarmManager r3 = this.d;
        Intrinsics.checkNotNull(r3);
        r3.cancel(r0);
    L12:
        if (this.h.isEmpty() == false) goto L15;
        this.f = Long.MIN_VALUE;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TimeAbility", "timeList is empty", false, 4, null);
        return;
    L15:
        Long r1 = (Long) ZeusTransformUtils.preCheckCast(this.h.get(0), Long.class, "com.obric.memorydata.plugin");
        this.f = r1;
        Intrinsics.checkNotNull(r1);
        this.e = a(r1.longValue());
        RunLog.INSTANCE.debug("TimeAbility", "reset next time to: " + this.f + " and current: " + System.currentTimeMillis());
        AlarmManager r2 = this.d;
        Intrinsics.checkNotNull(r2);
        Long r4 = this.f;
        Intrinsics.checkNotNull(r4);
        long r5 = r4.longValue();
        PendingIntent r6 = this.e;
        Intrinsics.checkNotNull(r6);
        r2.setExact(0, r5, r6);
        return;
    L5:
        if (Intrinsics.areEqual(this.f, this.h.get(0)) == false) goto L8;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TimeAbility", "first trigger time is the same, ignore reset", false, 4, null);
    }

    private final void b(long r11) {
        HashSet r0 = new HashSet();
        Iterator<Long> r1 = this.h.iterator();
        Intrinsics.checkNotNullExpressionValue(r1, "iterator(...)");
    L4:
        if (r1.hasNext() == false) goto L22;
        Long r2 = (Long) ZeusTransformUtils.preCheckCast(r1.next(), Long.class, "com.obric.memorydata.plugin");
        if (r2.longValue() >= (TimeUnit.SECONDS.toMillis(1) + r11)) goto L22;
        if (r0.contains(r2) == true) goto L4;
        r0.add(r2);
        ConcurrentHashMap.KeySetView r4 = (ConcurrentHashMap.KeySetView) ZeusTransformUtils.preCheckCast(this.g.get(r2), ConcurrentHashMap.KeySetView.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L14;
        Set r5 = (Set) ZeusTransformUtils.preCheckCast(r4, Set.class, "com.obric.memorydata.plugin");
    L15:
        Iterator r6 = r5.iterator();
    L17:
        if (r6.hasNext() == false) goto L21;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.ability.j r8 = this.f8417b;
        if (r8 == null) goto L17;
        Intrinsics.checkNotNull(r7);
        Intrinsics.checkNotNull(r2);
        r8.a(r7, (com.obric.memorydata.ability.data.h) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.ability.data.t(r2.longValue()), com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin"));
        goto L17
    L21:
        this.g.remove(r2);
        goto L4
    L14:
        r5 = SetsKt.emptySet();
    L22:
        this.h.removeAll((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin"));
        b();
    }

    private final void c() {
        if (this.h.isEmpty() == false) goto L6;
        RunLog.INSTANCE.debug("TimeAbility", "timeList is empty when trigger passed");
        return;
    L6:
        long r2 = System.currentTimeMillis();
        long r4 = TimeUnit.SECONDS.toMillis(1) + r2;
        Long r0 = this.f;
        Intrinsics.checkNotNull(r0);
        if (r4 >= r0.longValue()) goto L9;
        RunLog.INSTANCE.debug("TimeAbility", "first trigger time is not passed");
        return;
    L9:
        b(r2);
    }

    public static /* synthetic */ void lambda$BBYmYqJfKeS3hi4IClpxEqGzEEI(t r0, Intent r1) {
        a(r0, r1);
    }

    private final void registerReceiver() {
        IntentFilter r0 = new IntentFilter();
        r0.addAction("com.obric.memorydata.alarm.action.notice");
        Context r1 = this.c;
        Intrinsics.checkNotNull(r1);
        ZeusTransformUtils.registerReceiver(r1, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), r0, 2, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.ability.impl.i
    public void a() {
        Context r0 = this.c;
        Intrinsics.checkNotNull(r0);
        ZeusTransformUtils.unregisterReceiver(r0, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.f = Long.MIN_VALUE;
        this.g.clear();
        this.h.clear();
        this.e = null;
        this.d = null;
    }

    @Override // com.obric.memorydata.ability.impl.i
    public void a(com.obric.memorydata.ability.j r3) {
        com.obric.memorydata.ability.j r4 = (com.obric.memorydata.ability.j) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.ability.j.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "iAbilityContext");
        this.f8417b = r4;
        Context r5 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.c = r5;
        Intrinsics.checkNotNull(r5);
        Object r6 = r5.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.app.AlarmManager");
        this.d = (AlarmManager) ZeusTransformUtils.preCheckCast(r6, AlarmManager.class, "com.obric.memorydata.plugin");
        Long r7 = Long.MIN_VALUE;
        this.f = r7;
        Intrinsics.checkNotNull(r7);
        this.e = a(r7.longValue());
        registerReceiver();
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean a(com.obric.memorydata.ability.f r8) {
        Intrinsics.checkNotNullParameter(r8, TrackerImpl.PARAMS);
        Object r7 = r8.b().getOrDefault(OaidModel.KEY_TIME, Long.MIN_VALUE);
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type kotlin.Long");
        long r9 = ((Long) ZeusTransformUtils.preCheckCast(r7, Long.class, "com.obric.memorydata.plugin")).longValue();
        if (r9 > (System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(2))) goto L5;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TimeAbility", "time " + r9 + " is too near current time: " + System.currentTimeMillis(), null, 4, null);
        return false;
    L5:
        return true;
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean a(String r11, com.obric.memorydata.ability.f r12) {
        Intrinsics.checkNotNullParameter(r11, "key");
        Intrinsics.checkNotNullParameter(r12, TrackerImpl.PARAMS);
        Object r13 = r12.b().getOrDefault(OaidModel.KEY_TIME, Long.MIN_VALUE);
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.Long");
        long r2 = ((Long) ZeusTransformUtils.preCheckCast(r13, Long.class, "com.obric.memorydata.plugin")).longValue();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TimeAbility", "onSubscribe time " + r2, false, 4, null);
        if (this.g.containsKey(Long.valueOf(r2)) == true) goto L5;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TimeAbility", "new trigger time", false, 4, null);
        this.h.add(Long.valueOf(r2));
        CollectionsKt.sort((List) ZeusTransformUtils.preCheckCast(this.h, List.class, "com.obric.memorydata.plugin"));
        ((Map) ZeusTransformUtils.preCheckCast(this.g, Map.class, "com.obric.memorydata.plugin")).put(Long.valueOf(r2), ConcurrentHashMap.newKeySet());
        b();
    L5:
        ConcurrentHashMap.KeySetView<String, Boolean> r14 = this.g.get(Long.valueOf(r2));
        Intrinsics.checkNotNull(r14);
        ((ConcurrentHashMap.KeySetView) ZeusTransformUtils.preCheckCast(r14, ConcurrentHashMap.KeySetView.class, "com.obric.memorydata.plugin")).add(r11);
        c();
        return true;
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean b(String r11, com.obric.memorydata.ability.f r12) {
        Intrinsics.checkNotNullParameter(r11, "key");
        Intrinsics.checkNotNullParameter(r12, TrackerImpl.PARAMS);
        Object r13 = r12.b().getOrDefault(OaidModel.KEY_TIME, Long.MIN_VALUE);
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.Long");
        long r2 = ((Long) ZeusTransformUtils.preCheckCast(r13, Long.class, "com.obric.memorydata.plugin")).longValue();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TimeAbility", "onUnsubscribe time " + r2, false, 4, null);
        if (this.g.containsKey(Long.valueOf(r2)) == true) goto L5;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TimeAbility", "triggerTime not registered or already cancelled", null, 4, null);
    L10:
        c();
        return true;
    L5:
        ConcurrentHashMap.KeySetView r14 = (ConcurrentHashMap.KeySetView) ZeusTransformUtils.preCheckCast(this.g.get(Long.valueOf(r2)), ConcurrentHashMap.KeySetView.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r14);
        if (r14.remove(r11) == false) goto L10;
        if (r14.isEmpty() == false) goto L10;
        this.g.remove(Long.valueOf(r2));
        this.h.remove(Long.valueOf(r2));
        b();
        goto L10
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean c(String r1, com.obric.memorydata.ability.f r2) {
        return i.a.a(this, r1, r2);
    }

    public void onReceive(Context r7, final Intent r8) {
        if (((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin")) == null) goto L8;
        if (r8 == null) goto L8;
        ThreadPoolContainer.Companion.getInstance().execute(new $$Lambda$t$BBYmYqJfKeS3hi4IClpxEqGzEEI(this, r8));
        return;
    L8:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TimeAbility", "onReceive param is invalid", null, 4, null);
    }
}
