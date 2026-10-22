package k01;

import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.scope.o;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.revenue.platform.api.core.JsonOrBytesJvm;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import j01.b;
import j01.c;
import j01.d;
import j01.e;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements j01.a, b, o {
    public final bs2.a a;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public a(bs2.a r2) {
        Intrinsics.checkNotNullParameter(r2, "traceService");
        this.a = r2;
    }

    @Override // j01.a
    public final void monitor(c r15) {
        Intrinsics.checkNotNullParameter(r15, "request");
        j01.a.InterfaceC0254a r0 = r15.getMeta();
        if (r0 == null) goto L88;
        String r1 = r0.getEventName();
        if (r1 != null) goto L7;
        r1 = "";
    L7:
        String r2 = r0.getBusinessType();
        if (r2 != null) goto L10;
        r2 = "revenue";
    L10:
        e r3 = new e(r1, r2);
        JSONObject r4 = new JSONObject();
        JSONObject r5 = new JSONObject();
        JSONObject r6 = new JSONObject();
        Intrinsics.checkNotNullParameter(r3, "metaBuilder");
        Intrinsics.checkNotNullParameter(r5, "category");
        Intrinsics.checkNotNullParameter(r6, "metric");
        Intrinsics.checkNotNullParameter(r4, "extra");
        String r7 = r0.getTraceId();
        if (r7 == null) goto L13;
        r3.h(r7);
    L13:
        String r8 = r0.getLogId();
        if (r8 == null) goto L16;
        r3.c(r8);
    L16:
        String r9 = r0.getProductId();
        if (r9 == null) goto L19;
        Intrinsics.checkNotNullParameter(r9, "idString");
        r3.a.e = r9;
    L19:
        String r10 = r0.getStep();
        if (r10 == null) goto L22;
        r3.g(r10);
    L22:
        String r12 = r0.getRoomId();
        if (r12 == null) goto L25;
        r3.e(r12);
    L25:
        String r13 = r0.getAnchorId();
        if (r13 == null) goto L28;
        r3.a(r13);
    L28:
        String r14 = r0.getUserId();
        if (r14 == null) goto L31;
        r3.i(r14);
    L31:
        r3.f(r0.getStatusCode());
        String r16 = r0.k6();
        if (r16 == null) goto L34;
        Intrinsics.checkNotNullParameter(r16, Constants.OperatorKey.MSG);
        r3.a.k = r16;
    L34:
        Iterator<Map.Entry<String, String>> r17 = r0.getIndex().entrySet().iterator();
    L36:
        if (r17.hasNext() == false) goto L43;
        Map.Entry<String, String> r18 = r17.next();
        String r19 = r18.getKey();
        String r20 = r18.getValue();
        Intrinsics.checkNotNullParameter(r19, "key");
        o97.a r22 = r3.a;
        if (r22.l != null) goto L40;
        r22.l = new LinkedHashMap();
        Unit r23 = Unit.INSTANCE;
    L40:
        Map r24 = r3.a.l;
        if (r24 == null) goto L36;
        r24.put(r19, r20);
        goto L36
    L43:
        JsonOrBytesJvm r25 = r15.getCategory();
        boolean r26 = false;
        if (r25 != null) goto L46;
    L48:
        boolean r27 = false;
    L49:
        JsonOrBytesJvm r28 = null;
        if (r27 == true) goto L54;
        r25 = null;
    L54:
        if (r25 == null) goto L59;
        Intrinsics.checkNotNullParameter(r5, "json");
        JsonObject r29 = r25.b().getAsJsonObject();
        Iterator r110 = r29.keySet().iterator();
    L57:
        if (r110.hasNext() == false) goto L59;
        String r111 = (String) r110.next();
        JsonElement r112 = r29.get(r111);
        Intrinsics.checkNotNullParameter(r111, "key");
        Intrinsics.checkNotNullParameter(r112, "value");
        d.b(r5, r111, r112);
    L59:
        JsonOrBytesJvm r30 = r15.y6();
        if (r30 != null) goto L62;
    L64:
        boolean r113 = false;
    L65:
        if (r113 == true) goto L68;
        r30 = null;
    L68:
        if (r30 == null) goto L73;
        Intrinsics.checkNotNullParameter(r6, "json");
        JsonObject r32 = r30.b().getAsJsonObject();
        Iterator r114 = r32.keySet().iterator();
    L71:
        if (r114.hasNext() == false) goto L73;
        String r115 = (String) r114.next();
        JsonElement r116 = r32.get(r115);
        Intrinsics.checkNotNullParameter(r115, "key");
        Intrinsics.checkNotNullParameter(r116, "value");
        d.b(r6, r115, r116);
    L73:
        JsonOrBytesJvm r117 = r15.getExtra();
        if (r117 != null) goto L76;
    L78:
        if (r26 == false) goto L80;
        r28 = r117;
    L80:
        if (r28 == null) goto L85;
        Intrinsics.checkNotNullParameter(r4, "json");
        JsonObject r118 = r28.b().getAsJsonObject();
        Iterator r33 = r118.keySet().iterator();
    L83:
        if (r33.hasNext() == false) goto L85;
        String r34 = (String) r33.next();
        JsonElement r35 = r118.get(r34);
        Intrinsics.checkNotNullParameter(r34, "key");
        Intrinsics.checkNotNullParameter(r35, "value");
        d.b(r4, r34, r35);
    L85:
        ((b) f.a(b.class)).R4(r3.a, r5, r6, r4);
        return;
    L76:
        if (r117.a() != true) goto L78;
        r26 = true;
        goto L78
    L62:
        if (r30.a() != true) goto L64;
        r113 = true;
        goto L65
    L46:
        if (r25.a() != true) goto L48;
        r27 = true;
        goto L49
    L88:
        throw new IllegalStateException("meta is null".toString());
    }

    @Override // j01.b
    public final void R4(o97.a r4, JSONObject r5, JSONObject r6, JSONObject r7) {
        Intrinsics.checkNotNullParameter(r4, "traceMeta");
        int r0 = com.bytedance.android.live.core.monitor.trace.e.m;
        com.bytedance.android.live.core.monitor.trace.e.a r1 = com.bytedance.android.live.core.monitor.trace.e.b.a(r4.a, r4.b);
        String r2 = r4.c;
        if (r2 == null) goto L5;
        r1.a = r2;
    L5:
        String r3 = r4.d;
        if (r3 == null) goto L8;
        r1.b = r3;
    L8:
        String r8 = r4.e;
        if (r8 == null) goto L11;
        r1.c = r8;
    L11:
        String r9 = r4.f;
        if (r9 == null) goto L14;
        r1.d = r9;
    L14:
        String r10 = r4.g;
        if (r10 == null) goto L17;
        r1.e = r10;
    L17:
        String r12 = r4.h;
        if (r12 == null) goto L20;
        r1.f = r12;
    L20:
        String r13 = r4.i;
        if (r13 == null) goto L23;
        r1.g = r13;
    L23:
        Integer r14 = r4.j;
        if (r14 == null) goto L26;
        r1.h = r14;
    L26:
        String r15 = r4.k;
        if (r15 == null) goto L29;
        r1.i = r15;
    L29:
        Map r16 = r4.l;
        if (r16 == null) goto L35;
        Iterator r17 = r16.entrySet().iterator();
    L33:
        if (r17.hasNext() == false) goto L35;
        Map.Entry r18 = (Map.Entry) r17.next();
        r1.b((String) r18.getKey(), r18.getValue());
    L35:
        this.a.t2(r1.a(), r5, r6, r7);
    }
}
