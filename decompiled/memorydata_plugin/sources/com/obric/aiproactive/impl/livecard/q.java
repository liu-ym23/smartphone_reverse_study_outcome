package com.obric.aiproactive.impl.livecard;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0006J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\tJ\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\tH\u0000¢\u0006\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00100\u000fj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0010`\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardTimeAbilitySchedulerState;", "", "driver", "Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardTimeAbilityDriver;", "nowProvider", "Lkotlin/Function0;", "", "onDismiss", "Lkotlin/Function1;", "", "", "<init>", "(Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardTimeAbilityDriver;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "lock", "entries", "Ljava/util/LinkedHashMap;", "Lcom/obric/aiproactive/impl/livecard/ScheduledEntry;", "Lkotlin/collections/LinkedHashMap;", "scheduleDismiss", "Lcom/obric/aiproactive/impl/livecard/ScheduleResult;", "recommendId", "expireAtMs", "cancelDismiss", "", "scheduledExpireAt", "scheduledExpireAt$ai_proactive_impl_obricRelease", "(Ljava/lang/String;)Ljava/lang/Long;", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p f6481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0<Long> f6482b;
    private final Function1<String, Unit> c;
    private final Object d;
    private final LinkedHashMap<String, u> e;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/aiproactive/impl/livecard/ProactiveLiveCardTimeAbilitySchedulerState$scheduleDismiss$receiver$1", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "onDataReceive", "", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements com.obric.memorydata.ability.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ q f6483a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f6484b;
        final /* synthetic */ long c;

        a(q r1, String r2, long r3) {
            this.f6483a = r1;
            this.f6484b = r2;
            this.c = r3;
        }

        @Override // com.obric.memorydata.ability.k
        public void a(com.obric.memorydata.ability.data.h r9) {
            com.obric.memorydata.ability.data.h r10 = (com.obric.memorydata.ability.data.h) ZeusTransformUtils.wrapperContextForParams(r9, com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r10, "data");
            if (ZeusTransformUtils.instanceOf(r10, com.obric.memorydata.ability.data.t.class) == true) goto L5;
            return;
        L5:
            Object r11 = q.a(this.f6483a);
            q r0 = this.f6483a;
            String r1 = this.f6484b;
            long r2 = this.c;
            monitor-enter(r11);
            u r4 = (u) ZeusTransformUtils.preCheckCast(q.c(r0).get(r1), u.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
            boolean r5 = false;
            if (r4 != null) goto L11;
        L15:
            monitor-exit(r11);
            if (r5 == false) goto L24;
            q.b(this.f6483a).invoke(this.f6484b);
            return;
        L24:
            return;
        L11:
            if (r4.a() != r2) goto L15;
            q.c(r0).remove(r1);     // Catch: Throwable -> L19
            r5 = true;
        L19:
            th = move-exception;
            throw th;
        }

        @Override // com.obric.memorydata.ability.k
        public String g_() {
            return com.obric.memorydata.ability.k.a.a(this);
        }
    }

    public q(p r3, Function0<Long> r4, Function1<? super String, Unit> r5) {
        p r6 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.memorydata.plugin");
        Function0<Long> r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Function1<String, Unit> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "driver");
        Intrinsics.checkNotNullParameter(r7, "nowProvider");
        Intrinsics.checkNotNullParameter(r8, "onDismiss");
        this.f6481a = r6;
        this.f6482b = r7;
        this.c = r8;
        this.d = new Object();
        this.e = new LinkedHashMap();
    }

    public static final /* synthetic */ Object a(q r0) {
        return r0.d;
    }

    public static final /* synthetic */ Function1 b(q r0) {
        return r0.c;
    }

    public static final /* synthetic */ LinkedHashMap c(q r0) {
        return r0.e;
    }

    public final ScheduleResult a(String r7, long r8) {
        Intrinsics.checkNotNullParameter(r7, "recommendId");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L7;
        return ScheduleResult.FAILED;
    L7:
        if (r8 > (((Number) ZeusTransformUtils.preCheckCast(this.f6482b.invoke(), Number.class, "com.obric.memorydata.plugin")).longValue() + 2000)) goto L19;
        Object r9 = this.d;
        monitor-enter(r9);
        u r10 = (u) ZeusTransformUtils.preCheckCast(this.e.remove(r7), u.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        if (r10 == null) goto L13;
        Boolean.valueOf(this.f6481a.b(r10.b(), r10.c()));     // Catch: Throwable -> L16
    L13:
        monitor-exit(r9);
        this.c.invoke(r7);
        return ScheduleResult.DISMISSED_IMMEDIATELY;
    L16:
        th = move-exception;
        throw th;
    L19:
        com.obric.memorydata.ability.f r0 = new com.obric.memorydata.ability.f(100000006, MapsKt.mapOf(TuplesKt.to(OaidModel.KEY_TIME, Long.valueOf(r8))));
        a r1 = new a(this, r7, r8);
        Object r2 = this.d;
        monitor-enter(r2);
        u r3 = (u) ZeusTransformUtils.preCheckCast(this.e.remove(r7), u.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
        monitor-exit(r2);
        if (r3 == null) goto L26;
        this.f6481a.b(r3.b(), r3.c());
    L26:
        if (this.f6481a.a(r0, (com.obric.memorydata.ability.k) ZeusTransformUtils.preCheckCast(r1, com.obric.memorydata.ability.k.class, "com.obric.memorydata.plugin")) == false) goto L28;
        Object r4 = this.d;
        monitor-enter(r4);
        ((Map) ZeusTransformUtils.preCheckCast(this.e, Map.class, "com.obric.memorydata.plugin")).put(r7, new u(r8, r0, (com.obric.memorydata.ability.k) ZeusTransformUtils.preCheckCast(r1, com.obric.memorydata.ability.k.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L35
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L35
        monitor-exit(r4);
        return ScheduleResult.SCHEDULED;
    L35:
        th = move-exception;
        throw th;
    L28:
        return ScheduleResult.FAILED;
    L38:
        th = move-exception;
        throw th;
    }

    public final boolean a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "recommendId");
        Object r0 = this.d;
        monitor-enter(r0);
        u r5 = (u) ZeusTransformUtils.preCheckCast(this.e.remove(r4), u.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        monitor-exit(r0);
        if (r5 != null) goto L10;
        return false;
    L10:
        return this.f6481a.b(r5.b(), r5.c());
    L11:
        th = move-exception;
        throw th;
    }
}
