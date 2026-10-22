package com.bytedance.android.live.revenue.platform.container.impl;

import android.view.View;
import com.bytedance.android.live.revenue.platform.container.impl.core.NativeHostServiceImpl;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ View a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ long f;

    public f(View r1, String r2, String r3, String r4, String r5, long r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final void accept(Object r15) {
        Integer r16 = (Integer) r15;
        cq2.c r0 = vh6.c.b(cq2.c.class);
        View r1 = this.a;
        String r3 = this.b;
        JSONObject r4 = com.bytedance.android.live.revenue.common.q.b(new Pair[]{TuplesKt.to("platform_type", "android")});
        r4.put("caller", "android");
        r4.put("callee", "lynx");
        NativeHostServiceImpl r5 = (NativeHostServiceImpl) com.bytedance.android.live.revenue.core.util.f.a(NativeHostServiceImpl.class);
        com.bytedance.android.live.revenue.core.b r6 = com.bytedance.android.live.revenue.core.util.j.C0.a();
        if ((r6 instanceof com.bytedance.android.live.revenue.core.a) == true) goto L5;
        r6 = null;
    L5:
        com.bytedance.android.live.revenue.core.a r7 = (com.bytedance.android.live.revenue.core.a) r6;
        if (r7 == null) goto L8;
        cy0.k r8 = r7.getScope();
    L9:
        String r9 = r5.E(r8);
        if (r9 == null) goto L12;
        r4.put("service_version", r9);
    L12:
        Unit r10 = Unit.INSTANCE;
        LinkedHashMap r12 = new LinkedHashMap();
        r12.put("channel_id", this.c);
        r12.put("interface_id", this.d);
        r12.put("method_id", this.e);
        Iterator r13 = r12.entrySet().iterator();
    L14:
        if (r13.hasNext() == false) goto L16;
        Map.Entry r14 = (Map.Entry) r13.next();
        r4.put((String) r14.getKey(), r14.getValue());
        goto L14
    L16:
        Unit r17 = Unit.INSTANCE;
        JSONObject r18 = new JSONObject();
        LinkedHashMap r19 = new LinkedHashMap();
        i97.a r20 = i97.a.a;
        r19.put("lifetime_duration", Long.valueOf(System.currentTimeMillis() - this.f));
        Iterator r22 = r19.entrySet().iterator();
    L18:
        if (r22.hasNext() == false) goto L20;
        Map.Entry r23 = (Map.Entry) r22.next();
        r18.put((String) r23.getKey(), r23.getValue());
        goto L18
    L20:
        Unit r24 = Unit.INSTANCE;
        if (r18.length() <= 0) goto L23;
        boolean r25 = true;
    L24:
        if (r25 == true) goto L27;
        r18 = null;
    L27:
        JSONObject r26 = com.bytedance.android.live.revenue.common.q.b(new Pair[]{TuplesKt.to("url", this.b)});
        Iterator r110 = new LinkedHashMap().entrySet().iterator();
    L29:
        if (r110.hasNext() == false) goto L31;
        Map.Entry r27 = (Map.Entry) r110.next();
        r26.put((String) r27.getKey(), r27.getValue());
        goto L29
    L31:
        Unit r111 = Unit.INSTANCE;
        r0.Y2(r1, "ttlive_aio_foundation_channel_interruption", r3, r4, r18, r26, false);
        return;
    L23:
        r25 = false;
        goto L24
    L8:
        r8 = null;
        goto L9
    }
}
