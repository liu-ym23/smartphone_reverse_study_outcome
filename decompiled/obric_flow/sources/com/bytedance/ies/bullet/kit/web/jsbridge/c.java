package com.bytedance.ies.bullet.kit.web.jsbridge;

import com.bytedance.ies.web.jsbridge2.TimeLineEvent;
import com.bytedance.ies.web.jsbridge2.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import zm.z;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f5547a;

    public c(d r5) {
        this.f5547a = r5;
    }

    @Override // com.bytedance.ies.web.jsbridge2.i
    public final void a(int r5, String r10) {
    }

    @Override // com.bytedance.ies.web.jsbridge2.i
    public final void c(String r10, z r11) {
        d r12 = this.f5547a;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L9
        CopyOnWriteArrayList r13 = (CopyOnWriteArrayList) r11.f23549a;     // Catch: Throwable -> L9
        Unit r14 = null;
        if (r13 == null) goto L58;
        LinkedHashMap r15 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.h(r13)), 16));     // Catch: Throwable -> L9
        Iterator r16 = r13.iterator();     // Catch: Throwable -> L9
    L7:
        if (r16.hasNext() == false) goto L11;
        Object r17 = r16.next();     // Catch: Throwable -> L9
        r15.put(((TimeLineEvent) r17).getLabel(), r17);     // Catch: Throwable -> L9
        goto L7
    L11:
        TimeLineEvent r18 = (TimeLineEvent) r15.get("label_create_java_call");     // Catch: Throwable -> L9
        if (r18 == null) goto L23;
        HashMap<String, Object> r19 = r18.getExtra();     // Catch: Throwable -> L9
        if (r19 == null) goto L16;
        Object r110 = r19.get("callbackId");     // Catch: Throwable -> L9
    L18:
        if ((r110 instanceof String) == false) goto L20;
        String r111 = (String) r110;     // Catch: Throwable -> L9
    L21:
        if (r111 == null) goto L23;
    L24:
        if (r111 == null) goto L58;
        com.bytedance.ies.bullet.core.kit.bridge.c r20 = (com.bytedance.ies.bullet.core.kit.bridge.c) r12.f5557n.get(r111);     // Catch: Throwable -> L9
        LinkedHashMap r21 = r12.f5557n;
        if (r20 != null) goto L29;
        r20 = new com.bytedance.ies.bullet.core.kit.bridge.c();     // Catch: Throwable -> L9
        r21.put(r111, r20);     // Catch: Throwable -> L9
    L29:
        TimeLineEvent r22 = (TimeLineEvent) r15.get("label_pre_call_origin_url");     // Catch: Throwable -> L9
        if (r22 == null) goto L36;
        long r23 = r22.getTimeInMillis();     // Catch: Throwable -> L9
        if (r23 > 0) goto L35;
        r23 = System.currentTimeMillis();     // Catch: Throwable -> L9
    L35:
        r20.f5336a = r23;     // Catch: Throwable -> L9
        r20.f5337b = r23;     // Catch: Throwable -> L9
    L36:
        TimeLineEvent r24 = (TimeLineEvent) r15.get("label_call_origin_url");     // Catch: Throwable -> L9
        if (r24 == null) goto L43;
        long r25 = r24.getTimeInMillis();     // Catch: Throwable -> L9
        if (r25 > 0) goto L42;
        r25 = System.currentTimeMillis();     // Catch: Throwable -> L9
    L42:
        r20.f5338c = r25;     // Catch: Throwable -> L9
    L43:
        TimeLineEvent r26 = (TimeLineEvent) r15.get("label_pre_handle_origin_url");     // Catch: Throwable -> L9
        if (r26 == null) goto L51;
        long r27 = r26.getTimeInMillis();     // Catch: Throwable -> L9
        if (r27 > 0) goto L49;
        r27 = System.currentTimeMillis();     // Catch: Throwable -> L9
    L49:
        r20.d = r27;     // Catch: Throwable -> L9
    L51:
        if (r20.a() == false) goto L57;
        r21.remove(r111);     // Catch: Throwable -> L9
        Function2 r28 = r12.f5556m;     // Catch: Throwable -> L9
        if (r28 == null) goto L57;
        if (r10 != null) goto L56;
        r10 = "";
    L56:
        r28.mo2invoke(r10, r20);     // Catch: Throwable -> L9
    L57:
        r14 = Unit.INSTANCE;     // Catch: Throwable -> L9
        goto L58
    L20:
        r111 = null;
        goto L21
    L16:
        r110 = null;
    L23:
        r111 = null;
    L58:
        Result.m124constructorimpl(r14);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
    }
}
