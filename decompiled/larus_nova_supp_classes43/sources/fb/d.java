package fb;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.google.gson.Gson;
import com.lynx.react.bridge.JavaOnlyMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public final bb.b a;
    public final String b;
    public final fb.a c;

    public static final class a {
        public final String a;
        public final String b;
        public final String c;
        public final Object d;

        public a(Map<String, ? extends Object> r10) {
            Intrinsics.checkNotNullParameter(r10, "field");
            Object r0 = r10.get("$t");
            String r11 = null;
            if ((r0 instanceof String) == false) goto L5;
            String r1 = (String) r0;
        L6:
            this.a = r1;
            Object r12 = r10.get("n");
            if ((r12 instanceof String) == false) goto L9;
            String r13 = (String) r12;
        L10:
            this.b = r13;
            Object r14 = r10.get("p");
            if ((r14 instanceof String) == false) goto L13;
            r11 = (String) r14;
        L13:
            this.c = r11;
            this.d = r10.get("d");
            return;
        L9:
            r13 = null;
            goto L10
        L5:
            r1 = null;
            goto L6
        }
    }

    public d(bb.b r10) {
        Intrinsics.checkNotNullParameter(r10, "airSolutionContext");
        this.a = r10;
        this.b = "AirSolution_ParamExecutor";
        this.c = new fb.a();
    }

    public final Object b(String r10, Map<String, ? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r10, "optionStr");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Gson r1 = hb.a.a;     // Catch: Throwable -> L5
        Object r12 = Result.constructor-impl((gb.d) hb.a.a(r10, gb.d.class));     // Catch: Throwable -> L5
    L8:
        if (Result.exceptionOrNull-impl(r12) == null) goto L11;
        HybridLogger r13 = HybridLogger.a;
        HybridLogger.i(this.b, "optionStr parse failed: optionStr: " + r10, null, 12);
    L11:
        if (Result.isFailure-impl(r12) == false) goto L13;
        r12 = null;
    L13:
        gb.d r14 = (gb.d) r12;
        if (r14 != null) goto L18;
        return new Object();
    L18:
        if (r14.c() == null) goto L20;
        ArrayList r15 = new ArrayList();
        Iterator<Object> r16 = r14.c().iterator();
    L23:
        if (r16.hasNext() == false) goto L32;
        Object r17 = r16.next();
        boolean r18 = r17 instanceof Map;
        if (r18 == true) goto L26;
        r15.add(r17);
        goto L23
    L26:
        if (r18 == false) goto L28;
        Map<String, ? extends Object> r19 = (Map) r17;
    L29:
        if (r19 == null) goto L23;
        r15.add(a(new a(r19), r19, r11));
        goto L23
    L28:
        r19 = null;
        goto L29
    L32:
        gb.d r20 = gb.d.a(r14, r15);
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L35
        this.c.getClass();     // Catch: Throwable -> L35
        Object r22 = fb.a.a(r20);     // Catch: Throwable -> L35
        HybridLogger r23 = HybridLogger.a;     // Catch: Throwable -> L35
        HybridLogger.m(this.b, "CalcExecutor calc result: finalOption: " + r20 + ", result: " + r22, null, null, 12);     // Catch: Throwable -> L35
        Object r24 = Result.constructor-impl(r22);     // Catch: Throwable -> L35
    L38:
        if (Result.exceptionOrNull-impl(r24) == null) goto L41;
        HybridLogger r25 = HybridLogger.a;
        HybridLogger.i(this.b, "CalcExecutor calc failure... option is " + r20, null, 12);
    L41:
        if (Result.isFailure-impl(r24) == false) goto L44;
        return null;
    L44:
        return r24;
    L35:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r24 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L38
    L20:
        return new Object();
    L5:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public final JavaOnlyMap c(Map<String, ? extends Object> r10, Map<String, ? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r10, "fields");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<Map.Entry<String, ? extends Object>> r12 = r10.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L18;
        Map.Entry<String, ? extends Object> r1 = r12.next();
        Object r13 = r1.getValue();
        Unit r14 = null;
        if ((r13 instanceof Map) == false) goto L8;
        Map<String, ? extends Object> r15 = (Map) r13;
    L9:
        if (r15 != null) goto L11;
    L15:
        if (r14 != null) goto L4;
        r0.put(r1.getKey(), r1.getValue());
        goto L4
    L11:
        if (r15.containsKey("$t") == false) goto L13;
        r0.put(r1.getKey(), a(new a(r15), r15, r11));
    L14:
        r14 = Unit.INSTANCE;
        goto L15
    L13:
        r0.put(r1.getKey(), c(r15, r11));
        goto L14
    L8:
        r15 = null;
        goto L9
    L18:
        return com.bytedance.sdk.xbridge.cn.platform.lynx.d.h(r0, 0);
    }

    public final Object a(a r10, Map<String, ? extends Object> r11, Map<String, ? extends Object> r12) {
        if (r12 == null) goto L16;
        String r13 = r10.c;
        if (r13 != null) goto L7;
    L10:
        String r14 = r10.b;
        if (r14 == null) goto L16;
        if (r12.containsKey(r14) == false) goto L16;
        return r12.get(r14);
    L7:
        if (StringsKt.startsWith$default(r13, "$.this", false, 2, null) == false) goto L10;
        int r15 = db.a.d;
        return db.a.C0152a.a(r13.substring(7), r12);
    L16:
        Object r16 = r10.d;
        if ((r16 instanceof Map) == false) goto L19;
        Map r17 = (Map) r16;
    L20:
        if (r17 == null) goto L23;
        Object r18 = c(MapsKt.mapOf(TuplesKt.to("d", r17)), r12).get("d");
        if (r18 == null) goto L23;
    L24:
        String r19 = r10.a;
        if (r19 == null) goto L64;
        int r20 = r19.hashCode();
        if (r20 == 109) goto L50;
        if (r20 == 112) goto L40;
        if (r20 != 3553) goto L64;
        if (r19.equals("op") == false) goto L64;
        Object r21 = b(new JSONObject(r11).toString(), r12);
        if (r21 != null) goto L63;
        return r18;
    L63:
        return r21;
    L40:
        if (r19.equals("p") == false) goto L64;
        String r22 = r10.b;
        if (r22 != null) goto L45;
        return null;
    L45:
        r21 = this.a.c.c.get(r22);
        if (r21 != null) goto L63;
        return r18;
    L50:
        if (r19.equals("m") == false) goto L64;
        String r23 = r10.c;
        if (r23 != null) goto L55;
        return null;
    L55:
        db.a r110 = this.a.c;
        r110.getClass();
        Intrinsics.checkNotNullParameter(r23, "key");
        boolean r111 = StringsKt.startsWith$default(r23, "$.data", false, 2, null);
        int r24 = db.a.d;
        if (r111 == false) goto L59;
        r21 = db.a.C0152a.a(r23.substring(7), r110.a);
    L62:
        if (r21 != null) goto L63;
        return r18;
    L59:
        if (StringsKt.startsWith$default(r23, "$.globalProps", false, 2, null) == false) goto L61;
        r21 = db.a.C0152a.a(r23.substring(14), r110.b);
        goto L62
    L61:
        r21 = db.a.C0152a.a(r23, r110.c);
    L64:
        return null;
    L23:
        r18 = r10.d;
        goto L24
    L19:
        r17 = null;
        goto L20
    }
}
