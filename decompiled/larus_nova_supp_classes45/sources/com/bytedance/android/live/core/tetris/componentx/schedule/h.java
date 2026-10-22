package com.bytedance.android.live.core.tetris.componentx.schedule;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.ComponentManagerABHelper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h implements BatchTogetherConditionManager.b {
    public final /* synthetic */ i a;

    public h(i r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.schedule.BatchTogetherConditionManager.b
    public final void a(int r9) {
        ALogger.i("ComponentX_Batch_Condition", "onConditionsMet " + r9);
        i r11 = this.a;
        r11.getClass();
        String r2 = "";
        if (ComponentManagerABHelper.INSTANCE.enableSchedulerRoomEnterCondition() == false) goto L14;
        f r1 = r11.k;
        if (r1 == null) goto L8;
        String r3 = r1.a(r11.d, true);
        if (r3 == null) goto L8;
    L10:
        if (TextUtils.isEmpty(r3) == true) goto L14;
        q r4 = r11.i;
        if (r4 == null) goto L14;
        r4.d(null, r3);
    L8:
        r3 = "";
    L14:
        StringBuilder r5 = new StringBuilder("getLoadingBatchKey = ");
        r5.append(r11.d);
        r5.append(" size is ");
        LinkedHashMap<Integer, m> r6 = r11.h;
        int r7 = 0;
        if (r6 == null) goto L21;
        m r8 = r6.get(Integer.valueOf(r11.d));
        if (r8 == null) goto L21;
        LayerDescriptorList r12 = r8.b;
        if (r12 == null) goto L21;
        int r13 = r12.size();
    L22:
        r5.append(r13);
        ALogger.i("ComponentX_Batch_Condition", r5.toString());
        if (v.a() == false) goto L34;
        LinkedHashMap<Integer, m> r14 = r11.h;
        if (r14 == null) goto L34;
        m r15 = r14.get(Integer.valueOf(r11.d));
        if (r15 == null) goto L34;
        LayerDescriptorList r16 = r15.b;
        if (r16 == null) goto L34;
        Iterator<j70.h<? extends h70.b>> r17 = r16.iterator();
    L32:
        if (r17.hasNext() == false) goto L34;
        ALogger.i(r11.b, r17.next().toString());
    L34:
        ComponentSchedulingManager.a r18 = r11.j;
        int r19 = r11.d;
        LinkedHashMap<Integer, m> r21 = r11.h;
        if (r21 == null) goto L37;
        m r22 = r21.get(Integer.valueOf(r19));
    L38:
        r18.a(null, r19, r22);
        f r23 = r11.k;
        if (r23 == null) goto L44;
        String r24 = r23.a(r11.d, false);
        if (r24 == null) goto L44;
        r2 = r24;
    L44:
        ALogger.d("ComponentX_Batch_Condition", "localLoadingBatch = " + r11.d);
        if (TextUtils.isEmpty(r2) == true) goto L49;
        ALogger.d("ComponentX_Batch_Condition", "endLoadBatch priorityMapping = ".concat(r2));
        q r0 = r11.i;
        if (r0 == null) goto L49;
        r0.l(null, r2);
    L49:
        LinkedHashMap<Integer, m> r25 = r11.h;
        if (r25 == null) goto L52;
        m r26 = r25.get(Integer.valueOf(r11.d));
    L53:
        if (r26 == null) goto L56;
        r11.c.put(Integer.valueOf(r11.d), r26);
    L56:
        if (r11.c.isEmpty() == false) goto L58;
        Integer r27 = null;
    L60:
        if (r27 != null) goto L63;
    L68:
        r11.d = r7;
        ALogger.i(r11.b, "localLoadingBatch = " + r11.d);
        if (Integer.MAX_VALUE != r11.d) goto L71;
        StateMachine<ComponentBatchBaseLoadState.c, ComponentBatchBaseLoadState.a, ComponentBatchBaseLoadState.b> r28 = r11.e;
        ComponentBatchBaseLoadState.a.b r29 = new ComponentBatchBaseLoadState.a.b();
        StateMachine.a r31 = StateMachine.c;
        r28.d(r29, null);
        return;
    L71:
        StateMachine<ComponentBatchBaseLoadState.c, ComponentBatchBaseLoadState.a, ComponentBatchBaseLoadState.b> r32 = r11.e;
        ComponentBatchBaseLoadState.a.c r33 = new ComponentBatchBaseLoadState.a.c();
        StateMachine.a r34 = StateMachine.c;
        r32.d(r33, null);
        return;
    L63:
        if (Intrinsics.compare(r27.intValue(), ((Number) CollectionsKt.last(r11.h.keySet())).intValue()) >= 0) goto L67;
        int r35 = d80.a.a;
        Integer r36 = (Integer) d80.a.a(r11.h, r27);
        if (r36 == null) goto L67;
        r7 = r36.intValue();
    L67:
        r7 = Integer.MAX_VALUE;
        goto L68
    L58:
        r27 = (Integer) CollectionsKt.last(r11.c.keySet());
        goto L60
    L52:
        r26 = null;
        goto L53
    L37:
        r22 = null;
    L21:
        r13 = 0;
        goto L22
    }
}
