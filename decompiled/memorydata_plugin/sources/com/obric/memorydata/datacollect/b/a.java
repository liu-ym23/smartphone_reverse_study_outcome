package com.obric.memorydata.datacollect.b;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiproactive.impl.livecard.ProactiveLiveCardDisplayTool;
import com.obric.memorydata.ability.d;
import com.obric.memorydata.ability.data.h;
import com.obric.memorydata.ability.data.p;
import com.obric.memorydata.ability.data.t;
import com.obric.memorydata.ability.k;
import com.obric.memorydata.datacollect.a.c;
import com.obric.memorydata.datacollect.e;
import com.obric.memorydata.datacollect.g;
import com.obric.memorydata.datacollect.i;
import com.obric.memorydata.datacollect.j;
import com.obric.memorydata.datacollect.l;
import com.obric.memorydata.datacollect.m;
import com.obric.memorydata.datacollect.n;
import com.obric.memorydata.datacollect.o;
import com.obric.memorydata.middleware.api.controller.NetworkController;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.tom_roush.pdfbox.pdmodel.a.d.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000*\u0002\u0017\u001a\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0002J\b\u0010 \u001a\u00020\u001dH\u0002J\u0006\u0010!\u001a\u00020\u001dJ\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001b¨\u0006%"}, d2 = {"Lcom/obric/memorydata/datacollect/manager/DataCollectManager;", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "<init>", "()V", "TAG", "", "SCREEN_ON_FREQUENCY_MS", "", "SCREEN_OFF_FREQUENCY_MS", "abilityManager", "Lcom/obric/memorydata/ability/AbilityManager;", "collectList", "", "Lcom/obric/memorydata/datacollect/intf/IBaseCollect;", "frequencyCollectList", "", "Lcom/obric/memorydata/datacollect/intf/IFrequencyCollect;", "screenOnCollectList", "Lcom/obric/memorydata/datacollect/intf/IScreenOnCollect;", "subscribeCollectList", "Lcom/obric/memorydata/datacollect/intf/ISubscribeCollect;", "preTimeStamp", "frequencyTriggerReceiver", "com/obric/memorydata/datacollect/manager/DataCollectManager$frequencyTriggerReceiver$1", "Lcom/obric/memorydata/datacollect/manager/DataCollectManager$frequencyTriggerReceiver$1;", "screenOnTriggerReceiver", "com/obric/memorydata/datacollect/manager/DataCollectManager$screenOnTriggerReceiver$1", "Lcom/obric/memorydata/datacollect/manager/DataCollectManager$screenOnTriggerReceiver$1;", "subscribeNextTimeTrigger", "", "initFrequencyCollect", "initScreenOnCollect", "initSubscribeCollect", "startCollect", "onDataReceive", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "data_collect_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9681a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d f9682b = null;
    private static final List<com.obric.memorydata.datacollect.a.a> c = null;
    private static final List<com.obric.memorydata.datacollect.a.b> d = null;
    private static final List<c> e = null;
    private static final List<com.obric.memorydata.datacollect.a.d> f = null;
    private static long g;
    private static final C0462a h = null;
    private static final b i = null;

    /* JADX INFO: renamed from: com.obric.memorydata.datacollect.b.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/datacollect/manager/DataCollectManager$frequencyTriggerReceiver$1", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "onDataReceive", "", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "data_collect_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0462a implements k {
        C0462a() {
        }

        private static final void b() {
            Iterator r0 = a.c().iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            com.obric.memorydata.datacollect.a.b r1 = (com.obric.memorydata.datacollect.a.b) ZeusTransformUtils.preCheckCast(r0.next(), com.obric.memorydata.datacollect.a.b.class, "com.obric.memorydata.plugin");
            a.d().query(r1.b(), (k) ZeusTransformUtils.preCheckCast(a.f9681a, k.class, "com.obric.memorydata.plugin"));
            goto L4
        L6:
            a.a(a.f9681a);
        }

        /* JADX INFO: renamed from: lambda$bdo3ujc3qmEV7VeuQ_iR8nDNw-U, reason: not valid java name */
        public static /* synthetic */ void m588lambda$bdo3ujc3qmEV7VeuQ_iR8nDNwU() {
            b();
        }

        @Override // com.obric.memorydata.ability.k
        public void a(h r7) {
            h r6 = (h) ZeusTransformUtils.wrapperContextForParams(r7, h.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "data");
            if (ZeusTransformUtils.instanceOf(r6, t.class) == false) goto L5;
            ThreadPoolContainer.Companion.getInstance().execute($$Lambda$a$a$bdo3ujc3qmEV7VeuQ_iR8nDNwU.INSTANCE);
            return;
        L5:
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DataCollectManager", "frequencyCollectReceiver onDataReceive data type error.(" + r6.getDataId() + ')', null, 4, null);
        }

        @Override // com.obric.memorydata.ability.k
        public String g_() {
            return k.a.a(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/datacollect/manager/DataCollectManager$screenOnTriggerReceiver$1", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "onDataReceive", "", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "data_collect_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements k {
        b() {
        }

        private static final void b(h r8) {
            h r9 = (h) ZeusTransformUtils.wrapperContextForParams(r8, h.class, "com.obric.memorydata.plugin");
            long r2 = System.currentTimeMillis();
            if (Intrinsics.areEqual(((p) ZeusTransformUtils.preCheckCast(r9, p.class, "com.obric.memorydata.plugin")).a(), f.f) == true) goto L5;
            return;
        L5:
            if ((r2 - a.e()) <= 300000) goto L12;
            a r10 = a.f9681a;
            a.a(r2);
            Iterator r11 = a.f().iterator();
        L8:
            if (r11.hasNext() == false) goto L13;
            c r0 = (c) ZeusTransformUtils.preCheckCast(r11.next(), c.class, "com.obric.memorydata.plugin");
            a.d().query(r0.a(), (k) ZeusTransformUtils.preCheckCast(a.f9681a, k.class, "com.obric.memorydata.plugin"));
            goto L8
        L13:
            return;
        }

        /* JADX INFO: renamed from: lambda$D2N81fhvHAQPdSijBLh6K6YR-Y0, reason: not valid java name */
        public static /* synthetic */ void m589lambda$D2N81fhvHAQPdSijBLh6K6YRY0(h r0) {
            b(r0);
        }

        @Override // com.obric.memorydata.ability.k
        public void a(h r9) {
            final h r8 = (h) ZeusTransformUtils.wrapperContextForParams(r9, h.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, "data");
            if (ZeusTransformUtils.instanceOf(r8, p.class) == false) goto L5;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DataCollectManager", "receiver screen state data state is (" + ((p) ZeusTransformUtils.preCheckCast(r8, p.class, "com.obric.memorydata.plugin")).a() + ')', false, 4, null);
            ThreadPoolContainer.Companion.getInstance().execute(new $$Lambda$a$b$D2N81fhvHAQPdSijBLh6K6YRY0(r8));
            return;
        L5:
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DataCollectManager", "screenOnTriggerReceiver onDataReceive data type error.(" + r8.getDataId() + ')', null, 4, null);
        }

        @Override // com.obric.memorydata.ability.k
        public String g_() {
            return k.a.a(this);
        }
    }

    static {
        f9681a = new a();
        f9682b = new d();
        List<com.obric.memorydata.datacollect.a.a> r0 = CollectionsKt.listOf(new com.obric.memorydata.datacollect.a.a[]{new o(), new l(), new com.obric.memorydata.datacollect.k(), new com.obric.memorydata.datacollect.h(), new com.obric.memorydata.datacollect.d(), new n(), new i(), new m(), new e(), new com.obric.memorydata.datacollect.f(), new com.obric.memorydata.datacollect.b(), new g(), new com.obric.memorydata.datacollect.a(), new j()});
        c = r0;
        d = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        e = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        f = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        h = new C0462a();
        i = new b();
        Iterator<com.obric.memorydata.datacollect.a.a> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L14;
        com.obric.memorydata.datacollect.a.a r2 = (com.obric.memorydata.datacollect.a.a) ZeusTransformUtils.preCheckCast(r1.next(), com.obric.memorydata.datacollect.a.a.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, com.obric.memorydata.datacollect.a.b.class) == false) goto L9;
        d.add((com.obric.memorydata.datacollect.a.b) r2);
    L9:
        if (ZeusTransformUtils.instanceOf(r2, c.class) == false) goto L12;
        e.add((c) r2);
    L12:
        if (ZeusTransformUtils.instanceOf(r2, com.obric.memorydata.datacollect.a.d.class) == false) goto L4;
        f.add((com.obric.memorydata.datacollect.a.d) r2);
        goto L4
    }

    private a() {
    }

    public static final /* synthetic */ void a(long r0) {
        g = r0;
    }

    public static final /* synthetic */ void a(a r0) {
        r0.g();
    }

    public static final /* synthetic */ List c() {
        return d;
    }

    public static final /* synthetic */ d d() {
        return f9682b;
    }

    public static final /* synthetic */ long e() {
        return g;
    }

    public static final /* synthetic */ List f() {
        return e;
    }

    private final void g() {
        if (NetworkController.INSTANCE.isScreenOn() == false) goto L5;
        long r0 = 600000;
    L6:
        long r2 = System.currentTimeMillis() + r0;
        f9682b.a(new com.obric.memorydata.ability.f(100000006, MapsKt.mapOf(TuplesKt.to(OaidModel.KEY_TIME, Long.valueOf(r2)))), (k) ZeusTransformUtils.preCheckCast(h, k.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        r0 = ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS;
        goto L6
    }

    private final void h() {
        g();
    }

    private final void i() {
        f9682b.a(new com.obric.memorydata.ability.f(100000005, MapsKt.mapOf(TuplesKt.to("mode", f.f))), (k) ZeusTransformUtils.preCheckCast(i, k.class, "com.obric.memorydata.plugin"));
    }

    private final void j() {
        Iterator<com.obric.memorydata.datacollect.a.d> r0 = f.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        com.obric.memorydata.datacollect.a.d r1 = (com.obric.memorydata.datacollect.a.d) ZeusTransformUtils.preCheckCast(r0.next(), com.obric.memorydata.datacollect.a.d.class, "com.obric.memorydata.plugin");
        f9682b.a(r1.a(), (k) ZeusTransformUtils.preCheckCast(this, k.class, "com.obric.memorydata.plugin"));
        goto L4
    }

    @Override // com.obric.memorydata.ability.k
    public void a(h r2) {
        h r1 = (h) ZeusTransformUtils.wrapperContextForParams(r2, h.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "data");
        if (ZeusTransformUtils.instanceOf(r1, com.obric.memorydata.ability.m.class) == false) goto L6;
        ((com.obric.memorydata.ability.m) ZeusTransformUtils.preCheckCast(r1, com.obric.memorydata.ability.m.class, "com.obric.memorydata.plugin")).collectNewData();
    L6:
        if (ZeusTransformUtils.instanceOf(r1, com.obric.memorydata.ability.data.i.class) == false) goto L9;
        ((com.obric.memorydata.ability.data.i) ZeusTransformUtils.preCheckCast(r1, com.obric.memorydata.ability.data.i.class, "com.obric.memorydata.plugin")).a();
        return;
    }

    public final void b() {
        h();
        i();
        j();
    }

    @Override // com.obric.memorydata.ability.k
    public String g_() {
        return k.a.a(this);
    }
}
