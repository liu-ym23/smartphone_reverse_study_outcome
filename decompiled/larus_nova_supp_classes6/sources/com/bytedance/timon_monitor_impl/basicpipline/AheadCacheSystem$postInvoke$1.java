package com.bytedance.timon_monitor_impl.basicpipline;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.ruler.base.models.e;
import com.bytedance.ruler.base.models.f;
import com.bytedance.timon.ruler.adapter.impl.IRulerBusinessService;
import com.bytedance.timonbase.TMInjection;
import com.bytedance.timonbase.pipeline.TimonBasicModeCenter;
import com.bytedance.timonbase.report.TMReportCache;
import dh7.c;
import gh7.j;
import gh7.n;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 16})
public final class AheadCacheSystem$postInvoke$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ c $entity;
    final /* synthetic */ j $params;

    public AheadCacheSystem$postInvoke$1(j r1, c r2) {
        this.$params = r1;
        this.$entity = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m9invoke() {
        Function0 r0 = TimonBasicModeCenter.a;
        Lazy r1 = RuleEngineHardCodeSystem.a;
        f r2 = ((IRulerBusinessService) RuleEngineHardCodeSystem.c.getValue()).b(this.$params.a());
        c r3 = this.$entity;
        j r4 = this.$params;
        e r5 = RuleEngineHardCodeSystem.a(r3, r4.b, false, r2, r4.i);
        if (r5 == null) goto L27;
        Lazy r6 = TMReportCache.a;
        int r7 = this.$params.b;
        TMReportCache.a r8 = (TMReportCache.a) ((LinkedHashMap) TMReportCache.b).get(Integer.valueOf(r7));
        if (r8 == null) goto L7;
        r8.j++;
    L7:
        e.a.postInvoke(this.$entity);
        c r9 = this.$entity;
        ReentrantReadWriteLock.ReadLock r10 = r9.b.readLock();
        r10.lock();
        Object r11 = ((LinkedHashMap) r9.a).get(Reflection.getOrCreateKotlinClass(n.class));     // Catch: Throwable -> L24
        if ((r11 instanceof n) == true) goto L11;
        r11 = null;
    L11:
        n r12 = (n) r11;     // Catch: Throwable -> L24
        r10.unlock();
        if (r12 == null) goto L15;
        r12.h = "SensitiveApiException";
    L15:
        if (r12 == null) goto L19;
        Set<String> r13 = r12.i;
        if (r13 == null) goto L19;
        r13.add(GsonProtectorUtils.toJson(TMInjection.a(), r5));
    L19:
        if (r12 == null) goto L23;
        List<String> r14 = r12.j;
        if (r14 == null) goto L23;
        r14.addAll(r2.e);
    L23:
        c.a r15 = c.b;
        c r16 = this.$entity;
        r15.getClass();
        c.a.b(r16, true);
        return;
    L24:
        th = move-exception;
        r10.unlock();
        throw th;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m9invoke();
        return Unit.INSTANCE;
    }
}
