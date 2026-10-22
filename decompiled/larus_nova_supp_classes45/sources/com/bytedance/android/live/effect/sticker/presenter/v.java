package com.bytedance.android.live.effect.sticker.presenter;

import com.bytedance.android.live.effect.sticker.api.AigcBackgroundImageGenerateTask;
import com.bytedance.android.live.effect.sticker.api.AigcBackgroundImageGenerateTaskMap;
import com.bytedance.android.live.effect.sticker.api.CheckAigcBackgroundImageGenerateTaskListByEffectIDResponse;
import com.bytedance.android.live.effect.sticker.api.LiveEffectApi;
import com.bytedance.android.live.network.response.BaseResponse;
import io.reactivex.functions.Consumer;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class v<T> implements Consumer {
    public final /* synthetic */ s a;
    public final /* synthetic */ List b;
    public final /* synthetic */ m c;

    public v(s r1, List r2, s.d.a.RunnableC0192a.C0193a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r11) {
        Map<Long, AigcBackgroundImageGenerateTaskMap> r12 = ((CheckAigcBackgroundImageGenerateTaskListByEffectIDResponse) ((BaseResponse) r11).data).getTaskMap();
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r1 = this.b.iterator();
    L4:
        if (r1.hasNext() == false) goto L34;
        long r2 = ((Number) r1.next()).longValue();
        if (r12.containsKey(Long.valueOf(r2)) == false) goto L13;
        Map<Long, g> r4 = this.a.b;
        Long r5 = Long.valueOf(r2);
        AigcBackgroundImageGenerateTaskMap r7 = r12.get(Long.valueOf(r2));
        if (r7 == null) goto L11;
        Map<Long, AigcBackgroundImageGenerateTask> r8 = r7.getTaskMap();
        if (r8 == null) goto L11;
    L12:
        r4.put(r5, new g(r8));
    L11:
        r8 = MapsKt.emptyMap();
    L13:
        Long r6 = Long.valueOf(r2);
        Map<Long, g> r9 = this.a.b;
        LinkedHashMap r13 = (LinkedHashMap) r9;
        g r14 = (g) r13.get(Long.valueOf(r2));
        if (r14 == null) goto L17;
        Map<Long, AigcBackgroundImageGenerateTask> r15 = r14.a;
        if (r15 == null) goto L17;
    L18:
        r0.put(r6, r15);
        Map r3 = (Map) r0.get(Long.valueOf(r2));
        if (r3 == null) goto L24;
        Collection r16 = r3.values();
        if (r16 == null) goto L24;
        List r17 = CollectionsKt.toList(r16);
        if (r17 == null) goto L24;
    L25:
        Iterator r18 = r17.iterator();
    L27:
        if (r18.hasNext() == false) goto L4;
        AigcBackgroundImageGenerateTask r19 = (AigcBackgroundImageGenerateTask) r18.next();
        if (r19.getStatus() == LiveEffectApi.AigcTaskStatus.FINISH.getValue()) goto L30;
        if (r19.getStatus() != LiveEffectApi.AigcTaskStatus.RUNNING.getValue()) goto L27;
        s.a(this.a, r19.getEffectID(), r19.getTaskID());
        goto L27
    L30:
        s.b(this.a, r19);
    L24:
        r17 = CollectionsKt.emptyList();
    L17:
        r15 = MapsKt.emptyMap();
        goto L18
    L34:
        m r110 = this.c;
        if (r110 == null) goto L47;
        r110.onSuccess(r0);
        return;
    }
}
