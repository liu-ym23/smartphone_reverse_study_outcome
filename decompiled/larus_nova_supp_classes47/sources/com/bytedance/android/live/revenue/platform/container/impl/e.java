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
public final class e<T> implements Consumer {
    public final /* synthetic */ View a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ Long h;
    public final /* synthetic */ long i;

    public e(View r1, String r2, String r3, String r4, String r5, Long r6, long r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = "lynx";
        this.f = "android";
        this.g = r5;
        this.h = r6;
        this.i = r7;
    }

    public final void accept(Object r15) {
        Integer r16 = (Integer) r15;
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
        r4.put("caller", this.e);
        r4.put("callee", this.f);
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
        Unit r13 = Unit.INSTANCE;
        Iterator r14 = new LinkedHashMap().entrySet().iterator();
    L20:
        if (r14.hasNext() == false) goto L22;
        Map.Entry r17 = (Map.Entry) r14.next();
        r4.put((String) r17.getKey(), r17.getValue());
        goto L20
    L22:
        Unit r18 = Unit.INSTANCE;
        JSONObject r19 = new JSONObject();
        LinkedHashMap r20 = new LinkedHashMap();
        if (this.h == null) goto L25;
        i97.a r22 = i97.a.a;
        r20.put("lifetime_duration", Long.valueOf(System.currentTimeMillis() - this.h.longValue()));
    L25:
        r20.put("method_autobind_duration", Long.valueOf(this.i));
        Iterator r23 = r20.entrySet().iterator();
    L27:
        if (r23.hasNext() == false) goto L29;
        Map.Entry r24 = (Map.Entry) r23.next();
        r19.put((String) r24.getKey(), r24.getValue());
        goto L27
    L29:
        Unit r25 = Unit.INSTANCE;
        if (r19.length() <= 0) goto L32;
        boolean r26 = true;
    L33:
        if (r26 == true) goto L36;
        r19 = null;
    L36:
        JSONObject r27 = com.bytedance.android.live.revenue.common.q.b(new Pair[]{TuplesKt.to("url", this.b)});
        String r110 = this.g;
        if (r110 == null) goto L39;
        r27.put("channel_id", r110);
    L39:
        Iterator r111 = new LinkedHashMap().entrySet().iterator();
    L41:
        if (r111.hasNext() == false) goto L43;
        Map.Entry r28 = (Map.Entry) r111.next();
        r27.put((String) r28.getKey(), r28.getValue());
        goto L41
    L43:
        Unit r112 = Unit.INSTANCE;
        r0.Y2(r1, "ttlive_aio_foundation_call_success", r3, r4, r19, r27, true);
        return;
    L32:
        r26 = false;
        goto L33
    L14:
        r10 = null;
        goto L15
    }
}
