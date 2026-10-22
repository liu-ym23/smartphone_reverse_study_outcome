package com.obric.memorydata.init.tasks;

import com.bytedance.lego.init.model.IInitTask;
import com.obric.memorydata.ability.data.h;
import com.obric.memorydata.ability.data.p;
import com.obric.memorydata.ability.k;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.tom_roush.pdfbox.pdmodel.a.d.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/init/tasks/DataCollectInitTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "<init>", "()V", "abilityManager", "Lcom/obric/memorydata/ability/AbilityManager;", "dailyReportSubscribed", "", "run", "", "collectData", "ensureDailyReportSubscription", "data_collect_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DataCollectInitTask extends IInitTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.memorydata.ability.d f9889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f9890b;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/init/tasks/DataCollectInitTask$ensureDailyReportSubscription$1", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "onDataReceive", "", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "data_collect_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements k {
        a() {
        }

        @Override // com.obric.memorydata.ability.k
        public void a(h r2) {
            h r1 = (h) ZeusTransformUtils.wrapperContextForParams(r2, h.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "data");
            if (ZeusTransformUtils.instanceOf(r1, p.class) == true) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(((p) ZeusTransformUtils.preCheckCast(r1, p.class, "com.obric.memorydata.plugin")).a(), f.g) == false) goto L9;
            Tracker.INSTANCE.startDailyReport();
            return;
        }

        @Override // com.obric.memorydata.ability.k
        public String g_() {
            return k.a.a(this);
        }
    }

    public DataCollectInitTask() {
        this.f9889a = new com.obric.memorydata.ability.d();
    }

    private final void a() {
        RunLog.INSTANCE.debug("DataCollectInitTask", "collectData");
        com.obric.memorydata.datacollect.b.a.f9681a.b();
        com.obric.memorydata.datacollect.c.f9683a.b();
    }

    private final void b() {
        if (this.f9890b == false) goto L5;
        return;
    L5:
        this.f9889a.a(new com.obric.memorydata.ability.f(100000005, MapsKt.emptyMap()), (k) ZeusTransformUtils.preCheckCast(new a(), k.class, "com.obric.memorydata.plugin"));
        this.f9890b = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        b();
        a();
    }
}
