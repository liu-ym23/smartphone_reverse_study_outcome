package com.ss.ugc.live.sdk.msg.unify.business;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c extends Handler {
    public final /* synthetic */ UnifyLiveMessageDispatcher a;

    @Override // android.os.Handler
    public final void handleMessage(Message r13) {
        Intrinsics.checkNotNullParameter(r13, "msg");
        UnifyLiveMessageDispatcher r0 = this.a;
        r0.getClass();
        int r2 = 1;
        switch(r13.what) {
            case 201: goto L71;
            case 202: goto L12;
            case 203: goto L5;
            default: goto L131;
        };
    L5:
        Object r14 = r13.obj;
        if (r14 == null) goto L11;
        tlc.d r15 = (tlc.d) r14;
        r15.setEnqueueDispatchTime(System.currentTimeMillis());
        ((ArrayList) r0.a).add(r15);
        if (((ArrayList) r0.a).size() <= 0) goto L98;
        r0.n(true, 0);
        return;
    L98:
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.ugc.live.sdk.message.data.IMessage");
    L12:
        int r1 = ((ArrayList) r0.a).size();
        com.ss.ugc.live.sdk.msg.utils.a.a(r0.t, "before dispatch, message queue size is " + ((ArrayList) r0.a).size());
        Object r16 = r13.obj;
        if (r16 == null) goto L70;
        int r17 = ((Integer) r16).intValue();
        if (r17 > 0) goto L18;
        r17 = r0.h;
    L18:
        if (r1 <= r17) goto L21;
        r1 = r17;
    L21:
        ArrayList r18 = new ArrayList(((ArrayList) r0.a).subList(0, r1));
        int r3 = Math.min(r0.m.a(r18, r0), r18.size());
        ((ArrayList) r0.a).subList(0, r3).clear();
        com.ss.ugc.live.sdk.msg.utils.a.a(r0.t, "expect dispatch size: " + r18.size() + ", actual dispatch size: " + r3);
        int r4 = r18.size() - r3;
        if (r4 <= 0) goto L24;
        com.ss.ugc.live.sdk.msg.utils.a.a(r0.t, "schedule next dispatch immediately due to dispatch not enough");
        r0.n(false, r4);
        return;
    L24:
        boolean r5 = !r0.i.isEmpty();
        if (r5 == false) goto L66;
        if (r5 == false) goto L42;
        LinkedHashMap r6 = new LinkedHashMap();
        Iterator r19 = r18.iterator();
    L29:
        if (r19.hasNext() == false) goto L38;
        Object r7 = r19.next();
        String r8 = ((tlc.d) r7).getMessageMethod();
        if (r8 != null) goto L34;
        r8 = "unknow";
    L34:
        Object r9 = r6.get(r8);
        if (r9 != null) goto L37;
        r9 = new ArrayList();
        r6.put(r8, r9);
    L37:
        ((List) r9).add(r7);
        goto L29
    L38:
        Map r110 = new LinkedHashMap(MapsKt.mapCapacity(r6.size()));
        Iterator r10 = r6.entrySet().iterator();
    L40:
        if (r10.hasNext() == false) goto L43;
        Map.Entry r11 = (Map.Entry) r10.next();
        r110.put(r11.getKey(), Integer.valueOf(((List) r11.getValue()).size()));
    L43:
        Iterator<T> r12 = r0.i.iterator();
    L45:
        if (r12.hasNext() == false) goto L66;
        com.ss.ugc.live.sdk.msg.dispatch.a r20 = (com.ss.ugc.live.sdk.msg.dispatch.a) r12.next();
        Integer r21 = (Integer) r110.get(r20.a);
        if (r21 == null) goto L49;
        int r22 = r21.intValue();
    L50:
        int r23 = r20.b;
        if (r22 < r23) goto L52;
        com.ss.ugc.live.sdk.msg.utils.a.a(r0.t, "no need to dispatch ensure, method: " + r20.a + ", expect count per dispatch: " + r20.b + ", current dispatch count: " + r22);
        goto L45
    L52:
        int r24 = r23 - r22;
        ArrayList r25 = new ArrayList();
        Iterator r26 = ((ArrayList) r0.a).iterator();
    L54:
        if (r26.hasNext() == false) goto L59;
        tlc.d r27 = (tlc.d) r26.next();
        if (TextUtils.equals(r20.a, r27.getMessageMethod()) == false) goto L54;
        r25.add(r27);
        r26.remove();
        if (r25.size() < r24) goto L54;
    L59:
        com.ss.ugc.live.sdk.msg.utils.a.a(r0.t, "trigger dispatch ensure, method: " + r20.a + ", expect count per dispatch: " + r20.b + ", find in queue: " + r25.size());
        if ((!r25.isEmpty()) == false) goto L45;
        Iterator r28 = r25.iterator();
    L63:
        if (r28.hasNext() == false) goto L45;
        r0.onMessage((tlc.d) r28.next());
        goto L63
    L49:
        r22 = 0;
        goto L50
    L42:
        r110 = MapsKt.emptyMap();
    L66:
        com.ss.ugc.live.sdk.msg.utils.a.a(r0.t, "after dispatch, message queue size is " + ((ArrayList) r0.a).size());
        if (((ArrayList) r0.a).size() <= 0) goto L128;
        r0.n(true, 0);
        return;
    L128:
        return;
    L70:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L71:
        Object r111 = r13.obj;
        if (r111 == null) goto L97;
        List r112 = (List) r111;
        r0.n.a += (long) r112.size();
        com.ss.ugc.live.sdk.msg.utils.a.a(r0.t, "main thread receive message list, size is " + r112.size());
        com.ss.ugc.live.sdk.msg.utils.a.a(r0.t, "add message list to message queue, size is " + r112.size());
        Iterator r113 = r112.iterator();
    L75:
        if (r113.hasNext() == false) goto L89;
        tlc.d r29 = (tlc.d) r113.next();
        long r30 = r29.getDelayDispatchMs();
        if (r30 > 0) goto L78;
        bmc.a r31 = r0.q.get(r29.getMessageMethod());
        if (r31 == null) goto L83;
        r31.x40();
    L84:
        boolean r32 = true;
    L86:
        if (r32 == true) goto L87;
        r29.setEnqueueDispatchTime(System.currentTimeMillis());
        ((ArrayList) r0.a).add(r29);
        goto L75
    L87:
        r0.onMessage(r29);
        goto L75
    L83:
        if (com.ss.ugc.live.sdk.msg.utils.a.b(r29) == true) goto L84;
        r32 = false;
        goto L86
    L78:
        com.ss.ugc.live.sdk.msg.utils.a.a(r0.t, "delay dispatch message: " + r29.getMessageMethod() + ", delay time: " + r30);
        r0.p.sendMessageDelayed(r0.p.obtainMessage(203, r29), r30);
        goto L75
    L89:
        int r114 = ((ArrayList) r0.a).size();
        long r33 = Math.min(1200, r0.l);
        long r34 = r0.k;
        if (r33 >= r34) goto L92;
        r33 = r34;
    L92:
        com.ss.ugc.live.sdk.msg.utils.a.a(r0.t, "message queue size: " + ((ArrayList) r0.a).size() + ", total dispatch time: " + r33);
        int r35 = (int) ((r33 + ((long) 100)) / r0.k);
        com.ss.ugc.live.sdk.msg.utils.a.a(r0.t, "expect dispatch count: " + r35);
        if ((r114 / r35) < 1) goto L95;
        r2 = (r114 + (r35 / 2)) / r35;
    L95:
        r0.h = r2;
        com.ss.ugc.live.sdk.msg.utils.a.a(r0.t, "next time dispatch size: " + r0.h);
        r0.n(false, 0);
        return;
    L97:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.ss.ugc.live.sdk.message.data.IMessage>");
    }

    public c(UnifyLiveMessageDispatcher r1, Looper r2) {
        this.a = r1;
        super(r2);
    }
}
