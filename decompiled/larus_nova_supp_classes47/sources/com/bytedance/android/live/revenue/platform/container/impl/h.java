package com.bytedance.android.live.revenue.platform.container.impl;

import android.view.View;
import com.bytedance.android.live.revenue.platform.container.impl.core.NativeHostServiceImpl;
import com.bytedance.badger.collect.impl.constants.Constants;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ View a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ long f;

    public h(View r1, String r2, String r3, String r4, String r5, long r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final void accept(Object r13) {
        Integer r14 = (Integer) r13;
        cq2.c r0 = vh6.c.b(cq2.c.class);
        View r1 = this.a;
        String r3 = this.b;
        JSONObject r4 = com.bytedance.android.live.revenue.common.q.b(new Pair[]{TuplesKt.to("platform_type", "android")});
        String r5 = this.c;
        if (r5 == null) goto L5;
        r4.put("interface_id", r5);
    L5:
        String r6 = this.d;
        if (r6 == null) goto L8;
        r4.put("method_id", r6);
    L8:
        r4.put("caller", "android");
        r4.put("callee", "lynx");
        NativeHostServiceImpl r7 = (NativeHostServiceImpl) com.bytedance.android.live.revenue.core.util.f.a(NativeHostServiceImpl.class);
        com.bytedance.android.live.revenue.core.b r8 = com.bytedance.android.live.revenue.core.util.j.C0.a();
        if ((r8 instanceof com.bytedance.android.live.revenue.core.a) == true) goto L11;
        r8 = null;
    L11:
        com.bytedance.android.live.revenue.core.a r9 = (com.bytedance.android.live.revenue.core.a) r8;
        if (r9 == null) goto L14;
        cy0.k r10 = r9.getScope();
    L15:
        String r12 = r7.E(r10);
        if (r12 == null) goto L18;
        r4.put("service_version", r12);
    L18:
        Unit r15 = Unit.INSTANCE;
        Iterator r16 = new LinkedHashMap().entrySet().iterator();
    L20:
        if (r16.hasNext() == false) goto L22;
        Map.Entry r17 = (Map.Entry) r16.next();
        r4.put((String) r17.getKey(), r17.getValue());
        goto L20
    L22:
        Unit r18 = Unit.INSTANCE;
        JSONObject r19 = new JSONObject();
        LinkedHashMap r20 = new LinkedHashMap();
        r20.put(Constants.Keys.duration, Long.valueOf(this.f));
        Iterator r22 = r20.entrySet().iterator();
    L24:
        if (r22.hasNext() == false) goto L26;
        Map.Entry r23 = (Map.Entry) r22.next();
        r19.put((String) r23.getKey(), r23.getValue());
        goto L24
    L26:
        Unit r24 = Unit.INSTANCE;
        if (r19.length() <= 0) goto L29;
        boolean r25 = true;
    L30:
        if (r25 == true) goto L33;
        r19 = null;
    L33:
        JSONObject r26 = com.bytedance.android.live.revenue.common.q.b(new Pair[]{TuplesKt.to("url", this.b)});
        String r110 = this.e;
        if (r110 == null) goto L36;
        r26.put("channel_id", r110);
    L36:
        Iterator r111 = new LinkedHashMap().entrySet().iterator();
    L38:
        if (r111.hasNext() == false) goto L40;
        Map.Entry r27 = (Map.Entry) r111.next();
        r26.put((String) r27.getKey(), r27.getValue());
        goto L38
    L40:
        Unit r112 = Unit.INSTANCE;
        r0.Y2(r1, "ttlive_aio_foundation_call_perf", r3, r4, r19, r26, true);
        return;
    L29:
        r25 = false;
        goto L30
    L14:
        r10 = null;
        goto L15
    }
}
