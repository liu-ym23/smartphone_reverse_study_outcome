package com.bytedance.android.live.manager;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.process.BasicPerfProcess;
import com.bytedance.android.live.room.api.experience.log.ExpOptLog;
import com.bytedance.android.live.room.api.experience.perf.LivePerfBizLevel;
import com.bytedance.android.live.room.api.experience.perf.LivePerfBizType;
import com.bytedance.android.live.room.api.experience.utils.PlatformExpUtils;
import f61.a;
import i61.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import n61.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LivePlatformExpWorkshop implements a {
    public boolean a;
    public k61.a b;
    public final d61.a c;

    public final void start() {
        if (this.a == false) goto L5;
        return;
    L5:
        this.a = true;
        Iterator r0 = this.c.getProducers().iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((b) r0.next()).launch();
        goto L7
    }

    public LivePlatformExpWorkshop(d61.a r2) {
        Intrinsics.checkNotNullParameter(r2, "expCtx");
        this.c = r2;
    }

    public final void handleResult(j61.b<?> r9) {
        Intrinsics.checkNotNullParameter(r9, "result");
        if ((r9.getData() instanceof k61.a) == false) goto L17;
        Object r10 = r9.getData();
        if ((r10 instanceof k61.a) == true) goto L7;
        r10 = null;
    L7:
        final k61.a r11 = (k61.a) r10;
        if (r11 != null) goto L10;
        return;
    L10:
        k61.a r0 = this.b;
        this.b = r11;
        o61.a.b = r11;
        ExpOptLog.c.getClass();
        Intrinsics.checkNotNullParameter(r11, "newPerfInfo");
        StringBuilder r1 = ExpOptLog.c();
        StringBuilder r2 = new StringBuilder("性能等级更新：");
        if (r0 == null) goto L14;
        String r3 = r0.getType().name() + "-" + r0.d.name();
        if (r3 == null) goto L14;
    L15:
        r2.append(r3);
        r2.append(" --> ");
        r2.append(r11.getType().name() + "-" + r11.d.name());
        r2.append('\n');
        r1.append(r2.toString());
        UtilityKotlinExtentionsKt.s(0, false, false, new AnonymousClass1(this, r11), 7);
        return;
    L14:
        r3 = "Normal-Default";
        goto L15
    }

    public final void processSource(c r8) {
        Intrinsics.checkNotNullParameter(r8, "source");
        k61.a r2 = null;
        if (PlatformExpUtils.b() == false) goto L27;
        List<Integer> r1 = com.bytedance.android.live.process.a.a;
        Intrinsics.checkNotNullParameter(r8, "source");
        if ((r8 instanceof n61.a) == false) goto L24;
        n61.a r9 = (n61.a) r8;
        if (PlatformExpUtils.b() == true) goto L9;
    L22:
        if (r2 == null) goto L24;
        r2.b = r9;
        goto L24
    L9:
        if (PlatformExpUtils.c().i() == false) goto L16;
        if (CollectionsKt.contains(com.bytedance.android.live.process.a.a, r9.a) == false) goto L13;
    L14:
        k61.a r0 = new k61.a(LivePerfBizType.Degrade, LivePerfBizLevel.P1);
    L21:
        r2 = r0;
        goto L22
    L13:
        if (CollectionsKt.contains(com.bytedance.android.live.process.a.b, r9.a) == false) goto L22;
    L16:
        if (CollectionsKt.contains(com.bytedance.android.live.process.a.a, r9.a) == false) goto L19;
        r0 = new k61.a(LivePerfBizType.Degrade, LivePerfBizLevel.P0);
        goto L21
    L19:
        if (CollectionsKt.contains(com.bytedance.android.live.process.a.b, r9.a) == false) goto L22;
        r0 = new k61.a(LivePerfBizType.Degrade, LivePerfBizLevel.P1);
    L24:
        if (r2 == null) goto L67;
        handleResult(new j61.a(r2));
        return;
    L67:
        return;
    L27:
        if ((r8 instanceof n61.a) == false) goto L69;
        Lazy r3 = BasicPerfProcess.a;
        n61.a r10 = (n61.a) r8;
        Intrinsics.checkNotNullParameter(r10, "source");
        Integer r4 = r10.a;
        if (r4 == null) goto L53;
        int r5 = r4.intValue();
        List r6 = (List) BasicPerfProcess.a.getValue();
        ArrayList r7 = new ArrayList();
        Iterator r11 = r6.iterator();
    L32:
        if (r11.hasNext() == false) goto L36;
        Object r12 = r11.next();
        if (Intrinsics.areEqual(((BasicPerfProcess.e) r12).getType(), r10.c) == false) goto L32;
        r7.add(r12);
        goto L32
    L36:
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r14 = r7.iterator();
    L38:
        if (r14.hasNext() == false) goto L40;
        r13.add(((BasicPerfProcess.e) r14.next()).a(r5));
        goto L38
    L40:
        Iterator r15 = r13.iterator();
    L42:
        if (r15.hasNext() == false) goto L49;
        Object r16 = r15.next();
        if (((k61.a) r16) == null) goto L46;
        boolean r17 = true;
    L47:
        if (r17 == false) goto L42;
    L50:
        k61.a r18 = (k61.a) r16;
        if (r18 == null) goto L53;
        r18.b = r10;
        r2 = r18;
        goto L53
    L46:
        r17 = false;
        goto L47
    L49:
        r16 = null;
    L53:
        if (r2 == null) goto L70;
        handleResult(new j61.a(r2));
        return;
    L70:
        return;
    }
}
