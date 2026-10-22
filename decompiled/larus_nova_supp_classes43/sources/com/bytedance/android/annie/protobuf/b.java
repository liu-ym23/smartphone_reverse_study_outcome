package com.bytedance.android.annie.protobuf;

import am3.g;
import am3.h;
import android.util.SparseArray;
import com.bytedance.android.annie.Annie;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import k9.e;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import o8.f;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements t9.b {
    public static final /* synthetic */ int c = 0;
    public final ExternalProtobufMessageDefinitions a;
    public final ExternalProtobufShrinkConfigs b;

    public static final class a {
    }

    static {
    }

    public b(ExternalProtobufMessageDefinitions r10, ExternalProtobufShrinkConfigs r11) {
        Intrinsics.checkNotNullParameter(r10, "definitions");
        Intrinsics.checkNotNullParameter(r11, "shrinkConfigs");
        this.a = r10;
        this.b = r11;
    }

    @Override // t9.b
    public final JSONObject a(byte[] r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "body");
        Intrinsics.checkNotNullParameter(r11, "messageName");
        g r0 = new g();
        r0.k(new am3.b(r10));
        ExternalProtobufMessageDefinitions.Message r12 = this.a.a(r11);
        if (r12 == null) goto L7;
        return e(r12, r0, null, false);
    L7:
        throw new IllegalArgumentException(("data message [" + r11 + "] definition not found").toString());
    }

    @Override // t9.b
    public final boolean b(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "dataMessageName");
        if (this.a.a(r10) == null) goto L11;
        if (r11 != null) goto L7;
    L8:
        return true;
    L7:
        if (this.a.a(r11) != null) goto L8;
        return false;
    L11:
        return false;
    }

    public final JSONObject e(ExternalProtobufMessageDefinitions.Message r11, g r12, ExternalProtobufShrinkConfigs.Config r13, boolean r14) {
        JSONObject r0 = new JSONObject();
        long r1 = r12.c();
    L3:
        int r10 = r12.f();
        boolean r15 = false;
        ExternalProtobufShrinkConfigs.Config r16 = null;
        if (r10 == (-1)) goto L5;
        ExternalProtobufMessageDefinitions.a r17 = r11.a.get(r10);
        if (r17 == null) goto L93;
        if (r13 == null) goto L53;
        Set<String> r18 = r13.b;
        if (r18 == null) goto L53;
        if (r18.contains(r17.a) == true) goto L53;
        boolean r19 = true;
    L54:
        if (r19 == true) goto L93;
        if (r17.d == false) goto L77;
        JSONArray r20 = r0.optJSONArray(r17.a);
        if (r20 != null) goto L61;
        r20 = new JSONArray();
        r0.put(r17.a, r20);
    L61:
        if (r13 == null) goto L67;
        Map<String, ExternalProtobufShrinkConfigs.Config> r21 = r13.c;
        if (r21 == null) goto L67;
        ExternalProtobufShrinkConfigs.Config r22 = r21.get(r17.a);
        if (r22 == null) goto L67;
        ExternalProtobufShrinkConfigs.a.b r23 = (ExternalProtobufShrinkConfigs.a.b) r22.d.get(ExternalProtobufShrinkConfigs.a.b.class);
    L68:
        if (r23 != null) goto L70;
    L72:
        if (r13 == null) goto L76;
        Map<String, ExternalProtobufShrinkConfigs.Config> r24 = r13.c;
        if (r24 == null) goto L76;
        r16 = r24.get(r17.a);
    L76:
        r20.put(d(this, r17, r12, r16, r14));
    L92:
        r15 = true;
        goto L93
    L70:
        if (r20.length() < r23.b) goto L72;
    L67:
        r23 = null;
        goto L68
    L77:
        if (r13 == null) goto L81;
        Map<String, ExternalProtobufShrinkConfigs.Config> r25 = r13.c;
        if (r25 == null) goto L81;
        r16 = r25.get(r17.a);
    L81:
        Object r26 = d(this, r17, r12, r16, r14);
        if ((r26 instanceof Pair) == false) goto L91;
        JSONObject r27 = r0.optJSONObject(r17.a);
        if (r27 != null) goto L86;
        r27 = new JSONObject();
        r0.put(r17.a, r27);
    L86:
        Pair r28 = (Pair) r26;
        String r29 = String.valueOf(r28.getFirst());
        Object r30 = r28.getSecond();
        if (r30 == null) goto L90;
        r27.put(r29, r30);
        goto L92
    L90:
        throw new IllegalArgumentException(("decodedFieldData has null value: " + r26).toString());
    L91:
        r0.put(r17.a, r26);
    L53:
        r19 = false;
    L93:
        if (r15 == true) goto L3;
        h.e(r12);
        goto L3
    L5:
        r12.d(r1);
        if (r14 == false) goto L44;
        SparseArray<ExternalProtobufMessageDefinitions.a> r110 = r11.a;
        int r111 = 0;
    L9:
        if (r111 >= r110.size()) goto L44;
        ExternalProtobufMessageDefinitions.a r112 = r110.valueAt(r111);
        if (r112 == null) goto L43;
        if (r0.has(r112.a) == true) goto L21;
        if (r13 == null) goto L18;
        Set<String> r31 = r13.b;
        if (r31 == null) goto L18;
        boolean r32 = r31.contains(r110.valueAt(r111).a);
    L19:
        if (r32 == false) goto L21;
        boolean r33 = true;
    L22:
        if (r33 == true) goto L25;
        r112 = null;
    L25:
        if (r112 == null) goto L43;
        if (r112.d == false) goto L29;
        r0.put(r112.a, new JSONArray());
        goto L43
    L29:
        int r34 = r112.getType();
        if (r34 == 21) goto L36;
        switch(r34) {
            case 0: goto L35;
            case 1: goto L34;
            case 2: goto L33;
            case 3: goto L33;
            case 4: goto L33;
            case 5: goto L33;
            case 6: goto L34;
            case 7: goto L33;
            case 8: goto L33;
            default: goto L32;
        };
    L32:
        Object r35 = -1;
    L38:
        if ((!Intrinsics.areEqual(r35, -1)) == true) goto L41;
        r35 = null;
    L41:
        if (r35 == null) goto L43;
        r0.put(r112.a, r35);
        goto L43
    L33:
        r35 = 0;
        goto L38
    L34:
        r35 = "";
        goto L38
    L35:
        r35 = Boolean.FALSE;
        goto L38
    L36:
        r35 = new JSONObject();
    L18:
        r32 = true;
    L21:
        r33 = false;
    L43:
        r111 = r111 + 1;
    L44:
        return r0;
    }

    public static final Object d(b r10, ExternalProtobufMessageDefinitions.a r11, g r12, ExternalProtobufShrinkConfigs.Config r13, boolean r14) {
        r10.getClass();
        int r0 = r11.getType();
        boolean r1 = false;
        if (r0 != 20) goto L5;
        String r15 = r11.e;
        if (r15 == null) goto L60;
        boolean r16 = true;
    L61:
        if (r16 == false) goto L71;
        ExternalProtobufMessageDefinitions.Message r17 = r10.a.a(r15);
        if (r17 == null) goto L65;
        r1 = true;
    L65:
        if (r1 == false) goto L69;
        return r10.e(r17, r12, r13, r14);
    L69:
        throw new IllegalStateException(("message with fqName [" + r11.e + "] not found").toString());
    L71:
        throw new IllegalStateException(("field [" + r11.a + "] is pointing to fqName but not found in def").toString());
    L60:
        r16 = false;
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
        throw new IllegalStateException(("field type [" + r11.getType() + "] is not supported").toString());
    L79:
        return h.c(r12);
    L80:
        return Long.valueOf(r12.j());
    L81:
        return Integer.valueOf(r12.i());
    L82:
        return Float.valueOf(Float.intBitsToFloat(r12.g()));
    L83:
        return Double.valueOf(Double.longBitsToDouble(r12.h()));
    L84:
        return h.b(r12);
    L85:
        return Boolean.valueOf(h.a(r12));
    L16:
        Pair<ExternalProtobufMessageDefinitions.a.b, ExternalProtobufMessageDefinitions.a.c> r18 = r11.f;
        if (r18 == null) goto L19;
        boolean r19 = true;
    L20:
        if (r19 == false) goto L56;
        ExternalProtobufMessageDefinitions.a.b r20 = (ExternalProtobufMessageDefinitions.a.b) r18.getFirst();
        ExternalProtobufMessageDefinitions.a.c r21 = (ExternalProtobufMessageDefinitions.a.c) r11.f.getSecond();
        long r22 = r12.c();
        Object r110 = null;
        Object r23 = null;
    L22:
        int r24 = r12.f();
        if (r24 == (-1)) goto L24;
        if (r24 != 1) goto L40;
        if (r13 == null) goto L53;
        ExternalProtobufShrinkConfigs.a.c r111 = (ExternalProtobufShrinkConfigs.a.c) r13.d.get(ExternalProtobufShrinkConfigs.a.c.class);
        if (r111 == null) goto L53;
        ExternalProtobufShrinkConfigs.Config r112 = r111.b;
    L54:
        r110 = d(r10, r20, r12, r112, r14);
    L53:
        r112 = null;
        goto L54
    L40:
        if (r24 != 2) goto L48;
        if (r13 == null) goto L45;
        ExternalProtobufShrinkConfigs.a.d r25 = (ExternalProtobufShrinkConfigs.a.d) r13.d.get(ExternalProtobufShrinkConfigs.a.d.class);
        if (r25 == null) goto L45;
        ExternalProtobufShrinkConfigs.Config r26 = r25.b;
    L46:
        r23 = d(r10, r21, r12, r26, r14);
    L45:
        r26 = null;
        goto L46
    L48:
        throw new IllegalStateException(("unknown tag [" + r24 + "] for map").toString());
    L24:
        r12.d(r22);
        if (r110 == null) goto L27;
        boolean r113 = true;
    L29:
        if (r113 == false) goto L37;
        if (r23 == null) goto L32;
        r1 = true;
    L32:
        if (r1 == false) goto L35;
        return new Pair(r110, r23);
    L35:
        throw new IllegalStateException(("malformed data: value of type [" + r21 + "] in map is null").toString());
    L37:
        throw new IllegalStateException(("malformed data: key of type [" + r20 + "] in map is null").toString());
    L27:
        r113 = false;
        goto L29
    L56:
        throw new IllegalStateException(("type of [" + r11.a + "] is map but lacks mapInfo").toString());
    L19:
        r19 = false;
        goto L20
    }

    @Override // t9.b
    public final JSONObject c(byte[] r29, String r30, String r31, String r32, String r33, boolean r34, boolean r35, String r36) {
        Intrinsics.checkNotNullParameter(r29, "body");
        Intrinsics.checkNotNullParameter(r30, "dataMessageName");
        JSONObject r10 = new JSONObject();
        g r11 = new g();
        r11.k(new am3.b(r29));
        r8.b r1 = new r8.b();
        long r12 = r11.c();
    L3:
        int r13 = r11.f();
        int r14 = -1;
        int r15 = 1;
        if (r13 == (-1)) goto L31;
        if (r13 != 1) goto L6;
        r8.a r16 = new r8.a();
        long r17 = r11.c();
    L10:
        int r18 = r11.f();
        if (r18 == r14) goto L22;
        switch(r18) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            default: goto L13;
        };
    L14:
        r16.f = h.c(r11);
        goto L10
    L13:
        h.e(r11);
    L21:
        r14 = -1;
        goto L10
    L15:
        r16.e = r11.j();
    L20:
        r17 = r17;
        goto L21
    L16:
        r16.d = h.c(r11);
        goto L21
    L17:
        r16.c = h.c(r11);
        goto L21
    L18:
        r16.b = h.c(r11);
        goto L21
    L19:
        r16.a = (int) r11.j();
        goto L20
    L22:
        r11.d(r17);
        if (r16.a == (-1)) goto L30;
        if (r16.e == (-1)) goto L28;
        r1.header = r16;
        goto L3
    L28:
        throw new IOException("Invalid protobuf data: missing header.now!");
    L30:
        throw new IOException("Invalid protobuf data: missing header.statusCode!");
    L6:
        if (r13 != 2) goto L7;
        r1.body = h.b(r11);
        goto L3
    L7:
        h.e(r11);
        goto L3
    L31:
        r11.d(r12);
        r8.a r19 = r1.header;
        if (r19 == null) goto L109;
        r10.put("status_code", r19.a);
        if (r1.header.a != 0) goto L90;
        ExternalProtobufMessageDefinitions.Message r20 = this.a.a(r30);
        if (r20 == null) goto L89;
        JSONObject r110 = new JSONObject();
        r110.put("now", r1.header.e);
        r10.put("extra", r110);
        if (r35 == false) goto L40;
        JSONArray r21 = new JSONArray();
    L41:
        byte[] r22 = r1.body;
        if (r22 == null) goto L107;
        r11.k(new am3.b(r22));
        long r111 = r11.c();
    L44:
        int r23 = r11.f();
        if (r23 == (-1)) goto L46;
        if (r23 != r15) goto L51;
        long r112 = System.currentTimeMillis();
        ExternalProtobufShrinkConfigs r24 = this.b;
        if (r32 == null) goto L70;
        ExternalProtobufShrinkConfigs.Config r25 = (ExternalProtobufShrinkConfigs.Config) ((LinkedHashMap) r24.a).get(r32);
    L71:
        JSONObject r26 = e(r20, r11, r25, r34);
        if (r35 == false) goto L75;
        if (r21 == null) goto L76;
        r21.put(r26);
    L76:
        long r113 = System.currentTimeMillis() - r112;
        j9.b r114 = ((e) Annie.getService$default(e.class, null, 2, null)).H0();
        JSONObject r27 = new JSONObject();
        r27.put("data_message_name", r30);
        r27.put("complete_idl_fields", r34);
        Unit r28 = Unit.INSTANCE;
        JSONObject r37 = new JSONObject();
        r37.put(com.bytedance.android.ec.core.event.a.KEY_DURATION, r113);
        JSONObject r38 = new JSONObject();
        com.bytedance.android.annie.ng.a r115 = com.bytedance.android.annie.ng.g.c.get("host");
        if (r115 == null) goto L82;
        f r116 = r115.b;
        if (r116 == null) goto L82;
        String r117 = r116.a;
        if (r117 == null) goto L82;
    L83:
        r38.put("virtual_aid", r117);
        j9.b.a.a(r114, null, "latch_pb_decode_time", r36, r27, r37, null, r38, 1, 256);
    L84:
        boolean r39 = true;
    L85:
        if (r39 == true) goto L87;
        h.e(r11);
    L87:
        r21 = r21;
        r15 = 1;
    L82:
        r117 = "88888";
        goto L83
    L75:
        r10.put("data", r26);
        goto L76
    L70:
        r24.getClass();
        r25 = null;
        goto L71
    L51:
        if (r23 != 2) goto L66;
        if (r31 == null) goto L55;
        ExternalProtobufMessageDefinitions.Message r40 = this.a.a(r31);
    L56:
        if (r40 == null) goto L66;
        ExternalProtobufShrinkConfigs r118 = this.b;
        if (r33 == null) goto L60;
        ExternalProtobufShrinkConfigs.Config r119 = (ExternalProtobufShrinkConfigs.Config) ((LinkedHashMap) r118.a).get(r33);
    L61:
        JSONObject r41 = e(r40, r11, r119, r34);
        Iterator<String> r120 = r41.keys();
    L63:
        if (r120.hasNext() == false) goto L84;
        String r121 = r120.next();
        r110.put(r121, r41.get(r121));
        goto L63
    L60:
        r118.getClass();
        r119 = null;
        goto L61
    L55:
        r40 = null;
    L66:
        r21 = r21;
        r39 = false;
        goto L85
    L46:
        r11.d(r111);
        if (r35 == false) goto L107;
        r10.put("data", r21);
    L107:
        return r10;
    L40:
        r21 = null;
        goto L41
    L89:
        throw new IllegalArgumentException(("data message [" + r30 + "] definition not found").toString());
    L90:
        JSONObject r42 = new JSONObject();
        r42.put(com.bytedance.android.ec.core.event.a.KEY_MSG, r1.header.b);
        r42.put("prompts", r1.header.c);
        r42.put("alert", r1.header.d);
        Unit r43 = Unit.INSTANCE;
        r10.put("data", r42);
        JSONObject r44 = new JSONObject();
        r44.put("now", r1.header.e);
        r10.put("extra", r44);
        if (r31 == null) goto L93;
        ExternalProtobufMessageDefinitions.Message r122 = this.a.a(r31);
    L94:
        String r45 = r1.header.f;
        if (r122 == null) goto L107;
        if (r45 != null) goto L98;
    L101:
        boolean r123 = true;
    L102:
        if (r123 == true) goto L107;
        JSONObject r46 = new JSONObject(r45);
        Iterator<String> r47 = r46.keys();
    L105:
        if (r47.hasNext() == false) goto L107;
        String r48 = r47.next();
        r44.put(r48, r46.get(r48));
        goto L105
    L98:
        if (r45.length() == 0) goto L101;
        r123 = false;
        goto L102
    L93:
        r122 = null;
        goto L94
    L109:
        throw new IOException("Invalid protobuf data: response.header is null!");
    }
}
