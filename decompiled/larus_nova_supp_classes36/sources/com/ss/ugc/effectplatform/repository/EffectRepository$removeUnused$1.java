package com.ss.ugc.effectplatform.repository;

import com.ss.ugc.effectplatform.task.StrategyCacheClearTask;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "count", "", "size", "", "invoke"}, k = 3, mv = {1, 1, 16})
public final class EffectRepository$removeUnused$1 extends Lambda implements Function2<Integer, Long, Unit> {
    final /* synthetic */ EffectRepository this$0;

    public EffectRepository$removeUnused$1(EffectRepository r1) {
        this.this$0 = r1;
        super(2);
    }

    public final void invoke(int r5, long r6) {
        klc.a r0 = (klc.a) this.this$0.d.v.a;
        if (r0 == null) goto L6;
        HashMap r1 = new HashMap();
        r1.put("clean_type", StrategyCacheClearTask.RequestResourceInfo.TYPE_EFFECT);
        float r7 = 1024;
        r1.put("clean_size", Float.valueOf(((r6 * 1.0f) / r7) / r7));
        r1.put("clean_num", Integer.valueOf(r5));
        r1.put("clean_category", StrategyCacheClearTask.RequestResourceInfo.TYPE_EFFECT);
        r0.monitorStatusRate("tool_performance_clean_cache", 0, r1);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4) {
        invoke(((Number) r3).intValue(), ((Number) r4).longValue());
        return Unit.INSTANCE;
    }
}
