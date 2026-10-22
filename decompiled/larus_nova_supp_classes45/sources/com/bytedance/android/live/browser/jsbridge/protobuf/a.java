package com.bytedance.android.live.browser.jsbridge.protobuf;

import am3.g;
import am3.h;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static final /* synthetic */ int c = 0;
    public final ExternalProtobufMessageDefinitions a;
    public final ExternalProtobufShrinkConfigs b;

    /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.protobuf.a$a, reason: collision with other inner class name */
    public static final class C0123a {
    }

    static {
    }

    public a(ExternalProtobufMessageDefinitions r2, ExternalProtobufShrinkConfigs r3) {
        Intrinsics.checkNotNullParameter(r2, "definitions");
        Intrinsics.checkNotNullParameter(r3, "shrinkConfigs");
        this.a = r2;
        this.b = r3;
    }

    public final JSONObject b(ExternalProtobufMessageDefinitions.Message r9, g r11, ExternalProtobufShrinkConfigs.Config r12) {
        JSONObject r0 = new JSONObject();
        long r1 = r11.c();
    L3:
        int r3 = r11.f();
        if (r3 == (-1)) goto L5;
        ExternalProtobufMessageDefinitions.a r4 = r9.a.get(r3);
        if (r4 == null) goto L52;
        if (r12 == null) goto L15;
        Set<String> r5 = r12.c;
        if (r5 == null) goto L15;
        if (r5.contains(r4.a) == false) goto L52;
    L15:
        ExternalProtobufShrinkConfigs.Config r6 = null;
        if (r4.d == false) goto L36;
        JSONArray r7 = r0.optJSONArray(r4.a);
        if (r7 != null) goto L20;
        r7 = new JSONArray();
        r0.put(r4.a, r7);
    L20:
        if (r12 == null) goto L26;
        Map<String, ExternalProtobufShrinkConfigs.Config> r8 = r12.d;
        if (r8 == null) goto L26;
        ExternalProtobufShrinkConfigs.Config r13 = r8.get(r4.a);
        if (r13 == null) goto L26;
        ExternalProtobufShrinkConfigs.a.b r14 = (ExternalProtobufShrinkConfigs.a.b) r13.a.get(ExternalProtobufShrinkConfigs.a.b.class);
    L27:
        if (r14 != null) goto L29;
    L31:
        if (r12 == null) goto L35;
        Map<String, ExternalProtobufShrinkConfigs.Config> r15 = r12.d;
        if (r15 == null) goto L35;
        r6 = r15.get(r4.a);
    L35:
        r7.put(a(this, r4, r11, r6));
    L51:
        boolean r16 = true;
    L53:
        if (r16 == true) goto L3;
        h.e(r11);
        goto L3
    L29:
        if (r7.length() < r14.b) goto L31;
    L26:
        r14 = null;
        goto L27
    L36:
        if (r12 == null) goto L40;
        Map<String, ExternalProtobufShrinkConfigs.Config> r17 = r12.d;
        if (r17 == null) goto L40;
        r6 = r17.get(r4.a);
    L40:
        Object r18 = a(this, r4, r11, r6);
        if ((r18 instanceof Pair) == false) goto L50;
        JSONObject r19 = r0.optJSONObject(r4.a);
        if (r19 != null) goto L45;
        r19 = new JSONObject();
        r0.put(r4.a, r19);
    L45:
        Pair r21 = (Pair) r18;
        String r22 = String.valueOf(r21.getFirst());
        Object r23 = r21.getSecond();
        if (r23 == null) goto L49;
        r19.put(r22, r23);
        goto L51
    L49:
        throw new IllegalArgumentException(("decodedFieldData has null value: " + r18).toString());
    L50:
        r0.put(r4.a, r18);
    L52:
        r16 = false;
        goto L53
    L5:
        r11.d(r1);
        return r0;
    }

    public static final Object a(a r11, ExternalProtobufMessageDefinitions.a r12, g r13, ExternalProtobufShrinkConfigs.Config r14) {
        r11.getClass();
        int r0 = r12.getType();
        boolean r1 = false;
        if (r0 != 20) goto L5;
        String r2 = r12.e;
        if (r2 == null) goto L60;
        boolean r3 = true;
    L61:
        if (r3 == false) goto L71;
        ExternalProtobufMessageDefinitions.Message r4 = r11.a.a(r2);
        if (r4 == null) goto L65;
        r1 = true;
    L65:
        if (r1 == false) goto L69;
        return r11.b(r4, r13, r14);
    L69:
        throw new IllegalStateException(("message with fqName [" + r12.e + "] not found").toString());
    L71:
        throw new IllegalStateException(("field [" + r12.a + "] is pointing to fqName but not found in def").toString());
    L60:
        r3 = false;
        goto L61
    L5:
        if (r0 == 21) goto L16;
        switch(r0) {
            case 0: goto L85;
            case 1: goto L84;
            case 2: goto L83;
            case 3: goto L82;
            case 4: goto L81;
            case 5: goto L80;
            case 6: goto L79;
            case 7: goto L81;
            case 8: goto L80;
            default: goto L8;
        };
    L8:
        throw new IllegalStateException(("field type [" + r12.getType() + "] is not supported").toString());
    L79:
        return h.c(r13);
    L80:
        return Long.valueOf(r13.j());
    L81:
        return Integer.valueOf(r13.i());
    L82:
        return Float.valueOf(Float.intBitsToFloat(r13.g()));
    L83:
        return Double.valueOf(Double.longBitsToDouble(r13.h()));
    L84:
        return h.b(r13);
    L85:
        return Boolean.valueOf(h.a(r13));
    L16:
        Pair<ExternalProtobufMessageDefinitions.a.b, ExternalProtobufMessageDefinitions.a.c> r5 = r12.f;
        if (r5 == null) goto L19;
        boolean r6 = true;
    L20:
        if (r6 == false) goto L56;
        ExternalProtobufMessageDefinitions.a.b r7 = (ExternalProtobufMessageDefinitions.a.b) r5.getFirst();
        ExternalProtobufMessageDefinitions.a.c r8 = (ExternalProtobufMessageDefinitions.a.c) r12.f.getSecond();
        long r9 = r13.c();
        Object r15 = null;
        Object r16 = null;
    L22:
        int r17 = r13.f();
        if (r17 == (-1)) goto L24;
        if (r17 != 1) goto L40;
        if (r14 == null) goto L53;
        ExternalProtobufShrinkConfigs.a.c r18 = (ExternalProtobufShrinkConfigs.a.c) r14.a.get(ExternalProtobufShrinkConfigs.a.c.class);
        if (r18 == null) goto L53;
        ExternalProtobufShrinkConfigs.Config r19 = r18.b;
    L54:
        r15 = a(r11, r7, r13, r19);
    L53:
        r19 = null;
        goto L54
    L40:
        if (r17 != 2) goto L48;
        if (r14 == null) goto L45;
        ExternalProtobufShrinkConfigs.a.d r21 = (ExternalProtobufShrinkConfigs.a.d) r14.a.get(ExternalProtobufShrinkConfigs.a.d.class);
        if (r21 == null) goto L45;
        ExternalProtobufShrinkConfigs.Config r22 = r21.b;
    L46:
        r16 = a(r11, r8, r13, r22);
    L45:
        r22 = null;
        goto L46
    L48:
        throw new IllegalStateException(("unknown tag [" + r17 + "] for map").toString());
    L24:
        r13.d(r9);
        if (r15 == null) goto L27;
        boolean r110 = true;
    L29:
        if (r110 == false) goto L37;
        if (r16 == null) goto L32;
        r1 = true;
    L32:
        if (r1 == false) goto L35;
        return new Pair(r15, r16);
    L35:
        throw new IllegalStateException(("malformed data: value of type [" + r8 + "] in map is null").toString());
    L37:
        throw new IllegalStateException(("malformed data: key of type [" + r7 + "] in map is null").toString());
    L27:
        r110 = false;
        goto L29
    L56:
        throw new IllegalStateException(("type of [" + r12.a + "] is map but lacks mapInfo").toString());
    L19:
        r6 = false;
        goto L20
    }
}
