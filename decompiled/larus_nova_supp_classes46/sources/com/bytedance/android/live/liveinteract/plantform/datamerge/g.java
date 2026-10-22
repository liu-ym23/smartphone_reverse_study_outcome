package com.bytedance.android.live.liveinteract.plantform.datamerge;

import io.reactivex.subjects.BehaviorSubject;
import java.util.Comparator;
import java.util.Map;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g<T> implements Comparator {
    public final /* synthetic */ f a;

    public g(f r1) {
        this.a = r1;
    }

    @Override // java.util.Comparator
    public final int compare(Object r9, Object r10) {
        ch0.e r11 = (ch0.e) r9;
        ch0.e r12 = (ch0.e) r10;
        if (com.bytedance.android.live.liveinteract.plantform.model.n.i(r11.a) == com.bytedance.android.live.liveinteract.plantform.model.n.i(r12.a)) goto L11;
        if (com.bytedance.android.live.liveinteract.plantform.model.n.i(r11.a) == false) goto L8;
    L83:
        return -1;
    L8:
        if (com.bytedance.android.live.liveinteract.plantform.model.n.i(r12.a) == false) goto L11;
    L85:
        return 1;
    L11:
        if (com.bytedance.android.live.liveinteract.plantform.model.n.i(r11.a) == true) goto L13;
    L81:
        long r3 = r11.a.getJoinChannelTime() - r12.a.getJoinChannelTime();
        if (r3 > 0) goto L83;
        if (r3 < 0) goto L85;
        return 0;
    L13:
        if (com.bytedance.android.live.liveinteract.plantform.model.n.i(r12.a) == false) goto L81;
        int r0 = com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a;
        if (com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a(this.a.n) == false) goto L68;
        ch0.h r1 = r11.b;
        String r4 = "";
        if (r1 == null) goto L20;
        String r2 = r1.a;
        if (r2 == null) goto L20;
    L21:
        ch0.h r5 = r12.b;
        if (r5 == null) goto L27;
        String r6 = r5.a;
        if (r6 == null) goto L27;
        r4 = r6;
    L27:
        d r7 = this.a.l;
        if (r7 == null) goto L33;
        BehaviorSubject<Map<String, Long>> r8 = r7.m1();
        if (r8 == null) goto L33;
        Map r13 = (Map) r8.getValue();
        if (r13 == null) goto L33;
    L34:
        eh0.b r14 = this.a.m;
        if (r14 == null) goto L40;
        BehaviorSubject<Map<String, Long>> r15 = r14.l();
        if (r15 == null) goto L40;
        Map r16 = (Map) r15.getValue();
        if (r16 == null) goto L40;
    L42:
        if (r13.containsKey(r2) == false) goto L47;
        Long r17 = (Long) r13.get(r2);
        if (r17 == null) goto L51;
        long r18 = r17.longValue();
    L53:
        if (r13.containsKey(r4) == false) goto L58;
        Long r19 = (Long) r13.get(r4);
        if (r19 == null) goto L62;
        long r20 = r19.longValue();
    L63:
        long r21 = r18 - r20;
        if (r21 > 0) goto L83;
        if (r21 >= 0) goto L81;
    L62:
        r20 = 0;
        goto L63
    L58:
        if (r16.containsKey(r4) == false) goto L62;
        Long r22 = (Long) r16.get(r4);
        if (r22 == null) goto L62;
        r20 = r22.longValue();
    L51:
        r18 = 0;
        goto L53
    L47:
        if (r16.containsKey(r2) == false) goto L51;
        Long r23 = (Long) r16.get(r2);
        if (r23 == null) goto L51;
        r18 = r23.longValue();
    L40:
        r16 = MapsKt.emptyMap();
    L33:
        r13 = MapsKt.emptyMap();
    L20:
        r2 = "";
        goto L21
    L68:
        ch0.h r24 = r11.b;
        if (r24 == null) goto L71;
        long r25 = r24.f;
    L72:
        ch0.h r26 = r12.b;
        if (r26 == null) goto L75;
        long r27 = r26.f;
    L76:
        long r28 = r25 - r27;
        if (r28 > 0) goto L83;
        if (r28 >= 0) goto L81;
    L75:
        r27 = 0;
        goto L76
    L71:
        r25 = 0;
        goto L72
    }
}
