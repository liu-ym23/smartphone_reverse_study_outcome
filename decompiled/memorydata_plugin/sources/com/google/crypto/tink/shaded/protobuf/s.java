package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class s extends r<GeneratedMessageLite.d> {

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.s$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5036a = null;

        static {
            int[] r0 = new int[WireFormat.FieldType.values().length];
            f5036a = r0;
            r0[WireFormat.FieldType.DOUBLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L62:
            f5036a[WireFormat.FieldType.FLOAT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L46:
            f5036a[WireFormat.FieldType.INT64.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L58:
            f5036a[WireFormat.FieldType.UINT64.ordinal()] = 4;     // Catch: NoSuchFieldError -> L25
        L64:
            f5036a[WireFormat.FieldType.INT32.ordinal()] = 5;     // Catch: NoSuchFieldError -> L26
        L48:
            f5036a[WireFormat.FieldType.FIXED64.ordinal()] = 6;     // Catch: NoSuchFieldError -> L27
        L52:
            f5036a[WireFormat.FieldType.FIXED32.ordinal()] = 7;     // Catch: NoSuchFieldError -> L28
        L74:
            f5036a[WireFormat.FieldType.BOOL.ordinal()] = 8;     // Catch: NoSuchFieldError -> L29
        L42:
            f5036a[WireFormat.FieldType.UINT32.ordinal()] = 9;     // Catch: NoSuchFieldError -> L30
        L68:
            f5036a[WireFormat.FieldType.SFIXED32.ordinal()] = 10;     // Catch: NoSuchFieldError -> L31
        L70:
            f5036a[WireFormat.FieldType.SFIXED64.ordinal()] = 11;     // Catch: NoSuchFieldError -> L32
        L54:
            f5036a[WireFormat.FieldType.SINT32.ordinal()] = 12;     // Catch: NoSuchFieldError -> L33
        L60:
            f5036a[WireFormat.FieldType.SINT64.ordinal()] = 13;     // Catch: NoSuchFieldError -> L34
        L44:
            f5036a[WireFormat.FieldType.ENUM.ordinal()] = 14;     // Catch: NoSuchFieldError -> L35
        L50:
            f5036a[WireFormat.FieldType.BYTES.ordinal()] = 15;     // Catch: NoSuchFieldError -> L36
        L72:
            f5036a[WireFormat.FieldType.STRING.ordinal()] = 16;     // Catch: NoSuchFieldError -> L37
        L40:
            f5036a[WireFormat.FieldType.GROUP.ordinal()] = 17;     // Catch: NoSuchFieldError -> L38
        L66:
            f5036a[WireFormat.FieldType.MESSAGE.ordinal()] = 18;     // Catch: NoSuchFieldError -> L39
            return;
        }
    }

    s() {
    }

    @Override // com.google.crypto.tink.shaded.protobuf.r
    int a(Map.Entry<?, ?> r2) {
        return ((GeneratedMessageLite.d) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), GeneratedMessageLite.d.class, "com.obric.memorydata.plugin")).a();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.r
    w<GeneratedMessageLite.d> a(Object r2) {
        return ((GeneratedMessageLite.c) ZeusTransformUtils.preCheckCast(r2, GeneratedMessageLite.c.class, "com.obric.memorydata.plugin")).extensions;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.r
    Object a(q r2, at r3, int r4) {
        return r2.a((at) ZeusTransformUtils.wrapperContextForParams(r3, at.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.r
    <UT, UB> UB a(Object r8, bk r9, Object r10, q r11, w<GeneratedMessageLite.d> r12, UB r13, bt<UT, UB> r14) {
        bk r7 = (bk) ZeusTransformUtils.wrapperContextForParams(r9, bk.class, "com.obric.memorydata.plugin");
        GeneratedMessageLite.e r15 = (GeneratedMessageLite.e) ZeusTransformUtils.preCheckCast(r10, GeneratedMessageLite.e.class, "com.obric.memorydata.plugin");
        int r2 = r15.b();
        if (r15.d.d() == true) goto L5;
    L25:
        Object r16 = null;
        if (r15.d() != WireFormat.FieldType.ENUM) goto L32;
        int r17 = r7.h();
        if (r15.d.f().b(r17) == null) goto L30;
    L67:
        r16 = Integer.valueOf(r17);
    L74:
        if (r15.e() == false) goto L76;
        r12.b(r15.d, r16);
    L84:
        return r13;
    L76:
        int r18 = AnonymousClass1.f5036a[r15.d().ordinal()];
        if (r18 == 17) goto L81;
        Object r19 = r16;
        if (r18 == 18) goto L81;
    L24:
        r12.a(r15.d, r19);
    L81:
        Object r20 = r12.a(r15.d);
        r19 = r16;
        if (r20 == null) goto L24;
        r19 = ab.a(r20, r16);
        goto L24
    L30:
        return (UB) bn.a(r8, r2, r17, r13, r14);
    L32:
        switch(AnonymousClass1.f5036a[r15.d().ordinal()]) {
            case 1: goto L72;
            case 2: goto L71;
            case 3: goto L69;
            case 4: goto L68;
            case 5: goto L66;
            case 6: goto L65;
            case 7: goto L64;
            case 8: goto L63;
            case 9: goto L62;
            case 10: goto L61;
            case 11: goto L60;
            case 12: goto L59;
            case 13: goto L58;
            case 14: goto L57;
            case 15: goto L55;
            case 16: goto L54;
            case 17: goto L45;
            case 18: goto L35;
            default: goto L74;
        };
    L54:
        r16 = r7.l();
        goto L74
    L55:
        r16 = r7.n();
        goto L74
    L58:
        long r21 = r7.t();
    L70:
        r16 = Long.valueOf(r21);
        goto L74
    L59:
        r17 = r7.s();
        goto L67
    L60:
        r21 = r7.r();
        goto L70
    L61:
        r17 = r7.q();
        goto L67
    L62:
        r17 = r7.o();
        goto L67
    L63:
        r16 = Boolean.valueOf(r7.k());
        goto L74
    L64:
        r17 = r7.j();
        goto L67
    L65:
        r21 = r7.i();
        goto L70
    L66:
        r17 = r7.h();
        goto L67
    L68:
        r21 = r7.f();
        goto L70
    L69:
        r21 = r7.g();
        goto L70
    L71:
        r16 = Float.valueOf(r7.e());
        goto L74
    L72:
        r16 = Double.valueOf(r7.d());
        goto L74
    L35:
        if (r15.e() == true) goto L43;
        Object r22 = r12.a(r15.d);
        if (ZeusTransformUtils.instanceOf(r22, GeneratedMessageLite.class) == false) goto L43;
        bl r110 = bg.a().a(r22);
        if (((GeneratedMessageLite) ZeusTransformUtils.preCheckCast(r22, GeneratedMessageLite.class, "com.obric.memorydata.plugin")).isMutable() == true) goto L41;
        Object r111 = r110.a();
        r110.b(r111, r22);
        r12.a(r15.d, r111);
        r22 = r111;
    L41:
        r7.a(r22, r110, r11);
        return r13;
    L43:
        r16 = r7.a(r15.c().getClass(), r11);
        goto L74
    L45:
        if (r15.e() == true) goto L53;
        Object r23 = r12.a(r15.d);
        if (ZeusTransformUtils.instanceOf(r23, GeneratedMessageLite.class) == false) goto L53;
        bl r112 = bg.a().a(r23);
        if (((GeneratedMessageLite) ZeusTransformUtils.preCheckCast(r23, GeneratedMessageLite.class, "com.obric.memorydata.plugin")).isMutable() == true) goto L51;
        Object r113 = r112.a();
        r112.b(r113, r23);
        r12.a(r15.d, r113);
        r23 = r113;
    L51:
        r7.b(r23, r112, r11);
        return r13;
    L53:
        r16 = r7.b(r15.c().getClass(), r11);
        goto L74
    L57:
        throw new IllegalStateException("Shouldn't reach here.");
    L5:
        if (r15.d.e() == false) goto L25;
        switch(AnonymousClass1.f5036a[r15.d().ordinal()]) {
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            case 7: goto L17;
            case 8: goto L16;
            case 9: goto L15;
            case 10: goto L14;
            case 11: goto L13;
            case 12: goto L12;
            case 13: goto L11;
            case 14: goto L10;
            default: goto L9;
        };
    L10:
        ArrayList r114 = new ArrayList();
        r7.m(r114);
        r13 = (UB) bn.a(r8, r2, r114, r15.d.f(), r13, r14);
        r19 = r114;
        goto L24
    L11:
        ArrayList r115 = new ArrayList();
        r7.q(r115);
        r19 = r115;
        goto L24
    L12:
        ArrayList r116 = new ArrayList();
        r7.p(r116);
        r19 = r116;
        goto L24
    L13:
        ArrayList r117 = new ArrayList();
        r7.o(r117);
        r19 = r117;
        goto L24
    L14:
        ArrayList r118 = new ArrayList();
        r7.n(r118);
        r19 = r118;
        goto L24
    L15:
        ArrayList r119 = new ArrayList();
        r7.l(r119);
        r19 = r119;
        goto L24
    L16:
        ArrayList r120 = new ArrayList();
        r7.h(r120);
        r19 = r120;
        goto L24
    L17:
        ArrayList r121 = new ArrayList();
        r7.g(r121);
        r19 = r121;
        goto L24
    L18:
        ArrayList r122 = new ArrayList();
        r7.f(r122);
        r19 = r122;
        goto L24
    L19:
        ArrayList r123 = new ArrayList();
        r7.e(r123);
        r19 = r123;
        goto L24
    L20:
        ArrayList r124 = new ArrayList();
        r7.c(r124);
        r19 = r124;
        goto L24
    L21:
        ArrayList r125 = new ArrayList();
        r7.d(r125);
        r19 = r125;
        goto L24
    L22:
        ArrayList r126 = new ArrayList();
        r7.b(r126);
        r19 = r126;
        goto L24
    L23:
        ArrayList r127 = new ArrayList();
        r7.a(r127);
        r19 = r127;
        goto L24
    L9:
        throw new IllegalStateException("Type cannot be packed: " + r15.d.b());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.r
    void a(ByteString r2, Object r3, q r4, w<GeneratedMessageLite.d> r5) {
        GeneratedMessageLite.e r1 = (GeneratedMessageLite.e) ZeusTransformUtils.preCheckCast(r3, GeneratedMessageLite.e.class, "com.obric.memorydata.plugin");
        at.a r6 = r1.c().newBuilderForType();
        k r7 = r2.newCodedInput();
        r6.b(r7, r4);
        r5.a(r1.d, r6.b());
        r7.a(0);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.r
    void a(Writer r5, Map.Entry<?, ?> r6) {
        Writer r4 = (Writer) ZeusTransformUtils.wrapperContextForParams(r5, Writer.class, "com.obric.memorydata.plugin");
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r6, Map.Entry.class, "com.obric.memorydata.plugin");
        GeneratedMessageLite.d r8 = (GeneratedMessageLite.d) ZeusTransformUtils.preCheckCast(r7.getKey(), GeneratedMessageLite.d.class, "com.obric.memorydata.plugin");
        if (r8.d() == false) goto L33;
        switch(AnonymousClass1.f5036a[r8.b().ordinal()]) {
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L29;
            case 4: goto L28;
            case 5: goto L27;
            case 6: goto L26;
            case 7: goto L25;
            case 8: goto L24;
            case 9: goto L23;
            case 10: goto L22;
            case 11: goto L21;
            case 12: goto L20;
            case 13: goto L19;
            case 14: goto L27;
            case 15: goto L18;
            case 16: goto L17;
            case 17: goto L12;
            case 18: goto L7;
            default: goto L90;
        };
    L7:
        List r1 = (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L10;
        return;
    L10:
        if (r1.isEmpty() == true) goto L54;
        bn.a(r8.a(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.memorydata.plugin"), r4, bg.a().a(r1.get(0).getClass()));
        return;
    L54:
        return;
    L12:
        List r2 = (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L15;
        return;
    L15:
        if (r2.isEmpty() == true) goto L57;
        bn.b(r8.a(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.memorydata.plugin"), r4, bg.a().a(r2.get(0).getClass()));
        return;
    L57:
        return;
    L17:
        bn.a(r8.a(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.memorydata.plugin"), r4);
        return;
    L18:
        bn.b(r8.a(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.memorydata.plugin"), r4);
        return;
    L19:
        bn.e(r8.a(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.memorydata.plugin"), r4, r8.e());
        return;
    L20:
        bn.j(r8.a(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.memorydata.plugin"), r4, r8.e());
        return;
    L21:
        bn.g(r8.a(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.memorydata.plugin"), r4, r8.e());
        return;
    L22:
        bn.l(r8.a(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.memorydata.plugin"), r4, r8.e());
        return;
    L23:
        bn.i(r8.a(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.memorydata.plugin"), r4, r8.e());
        return;
    L24:
        bn.n(r8.a(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.memorydata.plugin"), r4, r8.e());
        return;
    L25:
        bn.k(r8.a(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.memorydata.plugin"), r4, r8.e());
        return;
    L26:
        bn.f(r8.a(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.memorydata.plugin"), r4, r8.e());
        return;
    L27:
        bn.h(r8.a(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.memorydata.plugin"), r4, r8.e());
        return;
    L28:
        bn.d(r8.a(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.memorydata.plugin"), r4, r8.e());
        return;
    L29:
        bn.c(r8.a(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.memorydata.plugin"), r4, r8.e());
        return;
    L30:
        bn.b(r8.a(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.memorydata.plugin"), r4, r8.e());
        return;
    L31:
        bn.a(r8.a(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.memorydata.plugin"), r4, r8.e());
        return;
    L90:
        return;
    L33:
        switch(AnonymousClass1.f5036a[r8.b().ordinal()]) {
            case 1: goto L51;
            case 2: goto L50;
            case 3: goto L49;
            case 4: goto L48;
            case 5: goto L47;
            case 6: goto L46;
            case 7: goto L45;
            case 8: goto L44;
            case 9: goto L43;
            case 10: goto L42;
            case 11: goto L41;
            case 12: goto L40;
            case 13: goto L39;
            case 14: goto L47;
            case 15: goto L38;
            case 16: goto L37;
            case 17: goto L36;
            case 18: goto L35;
            default: goto L91;
        };
    L35:
        r4.a(r8.a(), r7.getValue(), bg.a().a(r7.getValue().getClass()));
        return;
    L36:
        r4.b(r8.a(), r7.getValue(), bg.a().a(r7.getValue().getClass()));
        return;
    L37:
        r4.a(r8.a(), (String) ZeusTransformUtils.preCheckCast(r7.getValue(), String.class, "com.obric.memorydata.plugin"));
        return;
    L38:
        r4.a(r8.a(), (ByteString) ZeusTransformUtils.preCheckCast(r7.getValue(), ByteString.class, "com.obric.memorydata.plugin"));
        return;
    L39:
        r4.e(r8.a(), ((Long) ZeusTransformUtils.preCheckCast(r7.getValue(), Long.class, "com.obric.memorydata.plugin")).longValue());
        return;
    L40:
        r4.f(r8.a(), ((Integer) ZeusTransformUtils.preCheckCast(r7.getValue(), Integer.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L41:
        r4.b(r8.a(), ((Long) ZeusTransformUtils.preCheckCast(r7.getValue(), Long.class, "com.obric.memorydata.plugin")).longValue());
        return;
    L42:
        r4.a(r8.a(), ((Integer) ZeusTransformUtils.preCheckCast(r7.getValue(), Integer.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L43:
        r4.e(r8.a(), ((Integer) ZeusTransformUtils.preCheckCast(r7.getValue(), Integer.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L44:
        r4.a(r8.a(), ((Boolean) ZeusTransformUtils.preCheckCast(r7.getValue(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        return;
    L45:
        r4.d(r8.a(), ((Integer) ZeusTransformUtils.preCheckCast(r7.getValue(), Integer.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L46:
        r4.d(r8.a(), ((Long) ZeusTransformUtils.preCheckCast(r7.getValue(), Long.class, "com.obric.memorydata.plugin")).longValue());
        return;
    L47:
        r4.c(r8.a(), ((Integer) ZeusTransformUtils.preCheckCast(r7.getValue(), Integer.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L48:
        r4.c(r8.a(), ((Long) ZeusTransformUtils.preCheckCast(r7.getValue(), Long.class, "com.obric.memorydata.plugin")).longValue());
        return;
    L49:
        r4.a(r8.a(), ((Long) ZeusTransformUtils.preCheckCast(r7.getValue(), Long.class, "com.obric.memorydata.plugin")).longValue());
        return;
    L50:
        r4.a(r8.a(), ((Float) ZeusTransformUtils.preCheckCast(r7.getValue(), Float.class, "com.obric.memorydata.plugin")).floatValue());
        return;
    L51:
        r4.a(r8.a(), ((Double) ZeusTransformUtils.preCheckCast(r7.getValue(), Double.class, "com.obric.memorydata.plugin")).doubleValue());
        return;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.r
    void a(bk r2, Object r3, q r4, w<GeneratedMessageLite.d> r5) {
        bk r1 = (bk) ZeusTransformUtils.wrapperContextForParams(r2, bk.class, "com.obric.memorydata.plugin");
        GeneratedMessageLite.e r6 = (GeneratedMessageLite.e) ZeusTransformUtils.preCheckCast(r3, GeneratedMessageLite.e.class, "com.obric.memorydata.plugin");
        Object r7 = r1.a(r6.c().getClass(), r4);
        r5.a(r6.d, r7);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.r
    boolean a(at r2) {
        return ZeusTransformUtils.instanceOf((at) ZeusTransformUtils.wrapperContextForParams(r2, at.class, "com.obric.memorydata.plugin"), GeneratedMessageLite.c.class);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.r
    w<GeneratedMessageLite.d> b(Object r2) {
        return ((GeneratedMessageLite.c) ZeusTransformUtils.preCheckCast(r2, GeneratedMessageLite.c.class, "com.obric.memorydata.plugin")).a();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.r
    void c(Object r1) {
        a(r1).d();
    }
}
