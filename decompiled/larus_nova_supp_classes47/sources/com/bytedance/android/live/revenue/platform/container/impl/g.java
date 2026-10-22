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
public final class g<T> implements Consumer {
    public final /* synthetic */ View a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ String h;
    public final /* synthetic */ String i;
    public final /* synthetic */ Map j;

    public g(View r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, Map r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = "";
        this.j = r9;
    }

    public final void accept(Object r12) {
        Integer r13 = (Integer) r12;
        cq2.c r0 = vh6.c.b(cq2.c.class);
        View r1 = this.a;
        String r2 = this.b;
        String r3 = this.c;
        JSONObject r4 = com.bytedance.android.live.revenue.common.q.b(new Pair[]{TuplesKt.to("platform_type", "android")});
        String r5 = this.d;
        if (r5 == null) goto L5;
        r4.put("interface_id", r5);
    L5:
        String r6 = this.e;
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
        String r14 = r7.E(r10);
        if (r14 == null) goto L18;
        r4.put("service_version", r14);
    L18:
        Unit r15 = Unit.INSTANCE;
        LinkedHashMap r16 = new LinkedHashMap();
        r16.put("reason", this.g);
        r16.put("message", this.h);
        r16.put("releaseVersion", this.i);
        Iterator r17 = r16.entrySet().iterator();
    L20:
        if (r17.hasNext() == false) goto L22;
        Map.Entry r18 = (Map.Entry) r17.next();
        r4.put((String) r18.getKey(), r18.getValue());
        goto L20
    L22:
        Unit r19 = Unit.INSTANCE;
        JSONObject r20 = new JSONObject();
        Iterator r22 = new LinkedHashMap().entrySet().iterator();
    L24:
        if (r22.hasNext() == false) goto L26;
        Map.Entry r23 = (Map.Entry) r22.next();
        r20.put((String) r23.getKey(), r23.getValue());
        goto L24
    L26:
        Unit r24 = Unit.INSTANCE;
        if (r20.length() <= 0) goto L29;
        boolean r25 = true;
    L30:
        if (r25 == true) goto L33;
        r20 = null;
    L33:
        JSONObject r26 = com.bytedance.android.live.revenue.common.q.b(new Pair[]{TuplesKt.to("url", this.c)});
        String r110 = this.f;
        if (r110 == null) goto L36;
        r26.put("channel_id", r110);
    L36:
        LinkedHashMap r111 = new LinkedHashMap();
        Iterator r27 = this.j.entrySet().iterator();
    L38:
        if (r27.hasNext() == false) goto L40;
        Map.Entry r28 = (Map.Entry) r27.next();
        r111.put(r28.getKey(), r28.getValue());
        goto L38
    L40:
        Iterator r112 = r111.entrySet().iterator();
    L42:
        if (r112.hasNext() == false) goto L44;
        Map.Entry r29 = (Map.Entry) r112.next();
        r26.put((String) r29.getKey(), r29.getValue());
        goto L42
    L44:
        Unit r113 = Unit.INSTANCE;
        r0.Y2(r1, r2, r3, r4, r20, r26, false);
        return;
    L29:
        r25 = false;
        goto L30
    L14:
        r10 = null;
        goto L15
    }
}
