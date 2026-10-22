package com.bytedance.android.live.effect.sticker.presenter;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.effect.sticker.api.AigcBackgroundImageGenerateTask;
import com.bytedance.android.live.effect.sticker.api.LiveEffectApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g {
    public final Map<Long, AigcBackgroundImageGenerateTask> a;
    public final List<Long> b;
    public final List<Long> c;

    public static final class a {
    }

    static {
    }

    public g(Map<Long, AigcBackgroundImageGenerateTask> r4) {
        Intrinsics.checkNotNullParameter(r4, "initTaskMap");
        LinkedHashMap r0 = new LinkedHashMap();
        this.a = r0;
        ArrayList r1 = new ArrayList();
        this.b = r1;
        ArrayList r2 = new ArrayList();
        this.c = r2;
        r0.clear();
        r1.clear();
        r2.clear();
        Iterator<Map.Entry<Long, AigcBackgroundImageGenerateTask>> r5 = r4.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Map.Entry<Long, AigcBackgroundImageGenerateTask> r3 = r5.next();
        a(r3.getKey().longValue(), r3.getValue());
        goto L4
    }

    public final void a(long r3, AigcBackgroundImageGenerateTask r5) {
        Intrinsics.checkNotNullParameter(r5, "task");
        this.a.put(Long.valueOf(r3), r5);
        int r0 = r5.getStatus();
        if (r0 != LiveEffectApi.AigcTaskStatus.RUNNING.getValue()) goto L6;
        this.b.add(Long.valueOf(r3));
        return;
    L6:
        if (r0 != LiveEffectApi.AigcTaskStatus.FINISH.getValue()) goto L8;
        this.c.add(Long.valueOf(r3));
        return;
    L8:
        ALogger.e("ttlive_anchor_effect_LiveEffectAigcTaskManager", "illegal task status: " + r5.getStatus());
    }
}
