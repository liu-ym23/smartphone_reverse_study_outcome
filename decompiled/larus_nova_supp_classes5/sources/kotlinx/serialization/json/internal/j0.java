package kotlinx.serialization.json.internal;

import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.SerializationException;
import luc.o;
import muc.e;
import ouc.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class j0 extends muc.a implements ouc.h {
    public final ouc.a a;
    public final WriteMode b;
    public final kotlinx.serialization.json.internal.a c;
    public final kotlinx.serialization.modules.d d;
    public int e;
    public a f;
    public final f g;
    public final JsonElementMarker h;

    public static final class a {
        public String a;

        public a(String r1) {
            this.a = r1;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[WriteMode.values().length];
            r0[WriteMode.LIST.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[WriteMode.MAP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[WriteMode.POLY_OBJ.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[WriteMode.OBJ.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    @Override // muc.a, muc.e
    public final Void decodeNull() {
        return null;
    }

    @Override // ouc.h
    public final ouc.i a() {
        return new g0(this.a.a, this.c).b();
    }

    @Override // muc.a, muc.e
    public final boolean decodeBoolean() {
        kotlinx.serialization.json.internal.a r0 = this.c;
        int r1 = r0.u();
        if (r1 != r0.p().length()) goto L5;
        kotlinx.serialization.json.internal.a.m(r0, "EOF", 0, null, 6);
        throw null;
    L5:
        if (r0.p().charAt(r1) != '\"') goto L7;
        r1 = r1 + 1;
        boolean r2 = true;
    L8:
        int r3 = r0.t(r1);
        if (r3 < r0.p().length()) goto L11;
    L31:
        kotlinx.serialization.json.internal.a.m(r0, "EOF", 0, null, 6);
        throw null;
    L11:
        if (r3 == (-1)) goto L31;
        int r10 = r3 + 1;
        int r4 = r0.p().charAt(r3) | ' ';
        if (r4 != 102) goto L15;
        r0.c("alse", r10);
        boolean r5 = false;
    L20:
        if (r2 == true) goto L22;
    L30:
        return r5;
    L22:
        if (r0.a != r0.p().length()) goto L24;
        kotlinx.serialization.json.internal.a.m(r0, "EOF", 0, null, 6);
        throw null;
    L24:
        if (r0.p().charAt(r0.a) != '\"') goto L26;
        r0.a++;
        goto L30
    L26:
        kotlinx.serialization.json.internal.a.m(r0, "Expected closing quotation mark", 0, null, 6);
        throw null;
    L15:
        if (r4 != 116) goto L17;
        r0.c("rue", r10);
        r5 = true;
        goto L20
    L17:
        kotlinx.serialization.json.internal.a.m(r0, "Expected valid boolean literal prefix, but had '" + r0.j() + '\'', 0, null, 6);
        throw null;
    L7:
        r2 = false;
        goto L8
    }

    @Override // muc.a, muc.e
    public final byte decodeByte() {
        long r0 = this.c.h();
        byte r2 = (byte) r0;
        if (r0 != r2) goto L5;
        return r2;
    L5:
        kotlinx.serialization.json.internal.a.m(this.c, "Failed to parse byte for input '" + r0 + '\'', 0, null, 6);
        throw null;
    }

    @Override // muc.a, muc.e
    public final char decodeChar() {
        String r0 = this.c.j();
        if (r0.length() == 1) goto L5;
        kotlinx.serialization.json.internal.a.m(this.c, "Expected single char, but got '" + r0 + '\'', 0, null, 6);
        throw null;
    L5:
        return r0.charAt(0);
    }

    @Override // muc.a, muc.e
    public final double decodeDouble() {
        kotlinx.serialization.json.internal.a r0 = this.c;
        String r1 = r0.j();
        boolean r2 = false;
        double r3 = CastDoubleProtector.parseDouble(r1);     // Catch: IllegalArgumentException -> L16
        if (this.a.a.k == false) goto L7;
    L15:
        return r3;
    L7:
        if (Double.isInfinite(r3) == false) goto L9;
    L11:
        if (r2 == true) goto L15;
        s.g(this.c, Double.valueOf(r3));
        throw null;
    L9:
        if (Double.isNaN(r3) == true) goto L11;
        r2 = true;
    L16:
        kotlinx.serialization.json.internal.a.m(r0, "Failed to parse type 'double' for input '" + r1 + '\'', 0, null, 6);
        throw null;
    }

    @Override // muc.a, muc.e
    public final float decodeFloat() {
        kotlinx.serialization.json.internal.a r0 = this.c;
        String r1 = r0.j();
        boolean r2 = false;
        float r3 = CastFloatProtector.parseFloat(r1);     // Catch: IllegalArgumentException -> L16
        if (this.a.a.k == false) goto L7;
    L15:
        return r3;
    L7:
        if (Float.isInfinite(r3) == false) goto L9;
    L11:
        if (r2 == true) goto L15;
        s.g(this.c, Float.valueOf(r3));
        throw null;
    L9:
        if (Float.isNaN(r3) == true) goto L11;
        r2 = true;
    L16:
        kotlinx.serialization.json.internal.a.m(r0, "Failed to parse type 'float' for input '" + r1 + '\'', 0, null, 6);
        throw null;
    }

    @Override // muc.a, muc.e
    public final int decodeInt() {
        long r0 = this.c.h();
        int r2 = (int) r0;
        if (r0 != r2) goto L5;
        return r2;
    L5:
        kotlinx.serialization.json.internal.a.m(this.c, "Failed to parse int for input '" + r0 + '\'', 0, null, 6);
        throw null;
    }

    @Override // muc.a, muc.e
    public final long decodeLong() {
        return this.c.h();
    }

    @Override // muc.a, muc.e
    public final boolean decodeNotNullMark() {
        JsonElementMarker r0 = this.h;
        if (r0 == null) goto L5;
        boolean r1 = r0.b;
    L6:
        if (r1 == false) goto L8;
        return false;
    L8:
        if (this.c.w(true) == true) goto L12;
        return true;
    L12:
        return false;
    L5:
        r1 = false;
        goto L6
    }

    @Override // muc.a, muc.e
    public final short decodeShort() {
        long r0 = this.c.h();
        short r2 = (short) r0;
        if (r0 != r2) goto L5;
        return r2;
    L5:
        kotlinx.serialization.json.internal.a.m(this.c, "Failed to parse short for input '" + r0 + '\'', 0, null, 6);
        throw null;
    }

    @Override // muc.a, muc.e
    public final String decodeString() {
        if (this.g.c == false) goto L6;
        return this.c.k();
    L6:
        return this.c.i();
    }

    @Override // ouc.h
    public final ouc.a getJson() {
        return this.a;
    }

    @Override // muc.e, muc.c
    public final kotlinx.serialization.modules.d getSerializersModule() {
        return this.d;
    }

    @Override // muc.a, muc.e
    public final muc.c beginStructure(luc.f r8) {
        Intrinsics.checkNotNullParameter(r8, "descriptor");
        WriteMode r3 = s0.b(this.a, r8);
        v r0 = this.c.b;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r8, "sd");
        int r1 = r0.c + 1;
        r0.c = r1;
        Object[] r4 = r0.a;
        if (r1 != r4.length) goto L5;
        int r5 = r1 * 2;
        r0.a = Arrays.copyOf(r4, r5);
        r0.b = Arrays.copyOf(r0.b, r5);
    L5:
        r0.a[r1] = r8;
        this.c.g(r3.begin);
        if (this.c.r() == 4) goto L21;
        int r2 = b.a[r3.ordinal()];
        if (r2 == 1) goto L20;
        if (r2 == 2) goto L20;
        if (r2 == 3) goto L20;
        if (this.b != r3) goto L24;
        if (this.a.a.f == false) goto L24;
        return this;
    L24:
        return new j0(this.a, r3, this.c, r8, this.f);
    L20:
        return new j0(this.a, r3, this.c, r8, this.f);
    L21:
        kotlinx.serialization.json.internal.a.m(this.c, "Unexpected leading comma", 0, null, 6);
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // muc.c
    public final int decodeElementIndex(luc.f r21) {
        Intrinsics.checkNotNullParameter(r21, "descriptor");
        int r2 = b.a[this.b.ordinal()];
        char r4 = ':';
        boolean r6 = true;
        int r8 = -1;
        boolean r9 = 0;
        int r10 = 0;
        r9 = 0;
        if (r2 != 2) goto L5;
        int r1 = this.e;
        if ((r1 % 2) == 0) goto L153;
        boolean r3 = true;
    L154:
        if (r3 == false) goto L157;
        if (r1 == (-1)) goto L159;
        r9 = this.c.v();
    L159:
        if (this.c.b() == false) goto L174;
        if (r3 == true) goto L162;
    L173:
        r8 = this.e + 1;
        this.e = r8;
    L181:
        if (this.b == WriteMode.MAP) goto L183;
        v r5 = this.c.b;
        r5.b[r5.c] = r8;
    L183:
        return r8;
    L162:
        if (this.e != (-1)) goto L168;
        kotlinx.serialization.json.internal.a r7 = this.c;
        boolean r11 = !r9;
        int r12 = r7.a;
        if (r11 != 0) goto L173;
        kotlinx.serialization.json.internal.a.m(r7, "Unexpected leading comma", r12, null, 4);
        throw null;
    L168:
        kotlinx.serialization.json.internal.a r13 = this.c;
        int r14 = r13.a;
        if (r9 != 0) goto L173;
        kotlinx.serialization.json.internal.a.m(r13, "Expected comma after the key-value pair", r14, null, 4);
        throw null;
    L174:
        if (r9 == 0) goto L181;
        if (this.a.a.n == true) goto L181;
        s.e(this.c, "object");
        throw null;
    L157:
        this.c.g(':');
        goto L159
    L153:
        r3 = false;
        goto L154
    L5:
        if (r2 == 4) goto L21;
        boolean r15 = this.c.v();
        if (this.c.b() == false) goto L15;
        int r16 = this.e;
        if (r16 == (-1)) goto L14;
        if (r15 == true) goto L14;
        kotlinx.serialization.json.internal.a.m(this.c, "Expected end of the array or comma", 0, null, 6);
        throw null;
    L14:
        r8 = r16 + 1;
        this.e = r8;
        goto L181
    L15:
        if (r15 == false) goto L181;
        if (this.a.a.n == true) goto L181;
        s.e(this.c, "array");
        throw null;
    L21:
        boolean r17 = this.c.v();
    L23:
        if (this.c.b() == false) goto L125;
        if (this.g.c == false) goto L27;
        String r18 = this.c.k();
    L28:
        this.c.g(r4);
        int r19 = u.c(r21, this.a, r18);
        if (r19 != (-3)) goto L31;
        boolean r20 = false;
        boolean r22 = true;
    L71:
        if (r22 == true) goto L73;
        r17 = r20;
    L124:
        r4 = ':';
        r6 = true;
        goto L23
    L73:
        if (this.g.b == true) goto L85;
        a r23 = this.f;
        if (r23 != null) goto L78;
    L80:
        boolean r24 = false;
    L81:
        if (r24 == true) goto L85;
        kotlinx.serialization.json.internal.a r25 = this.c;
        r25.getClass();
        Intrinsics.checkNotNullParameter(r18, "key");
        r25.l("Encountered an unknown key '" + r18 + '\'', StringsKt.lastIndexOf$default(r25.p().subSequence(0, r25.a).toString(), r18, 0, false, 6, null), "Use 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.");
        throw null;
    L78:
        if (Intrinsics.areEqual(r23.a, r18) == false) goto L80;
        r23.a = null;
        r24 = true;
    L85:
        kotlinx.serialization.json.internal.a r26 = this.c;
        boolean r27 = this.g.c;
        r26.getClass();
        ArrayList r28 = new ArrayList();
        byte r29 = r26.r();
        if (r29 == 8) goto L90;
        if (r29 == 6) goto L90;
        r26.j();
    L122:
        r17 = this.c.v();
    L90:
        byte r30 = r26.r();
        if (r30 == 1) goto L92;
        if (r30 != 8) goto L97;
    L119:
        r28.add(Byte.valueOf(r30));
    L120:
        r26.e();
        if (r28.size() != 0) goto L90;
    L97:
        if (r30 == 6) goto L119;
        if (r30 != 9) goto L108;
        if (((Number) CollectionsKt.last(r28)).byteValue() != 8) goto L106;
        CollectionsKt.removeLast(r28);
        goto L120
    L106:
        throw s.d(r26.a, "found ] instead of } at path: " + r26.b, r26.p());
    L108:
        if (r30 != 7) goto L115;
        if (((Number) CollectionsKt.last(r28)).byteValue() != 6) goto L113;
        CollectionsKt.removeLast(r28);
        goto L120
    L113:
        throw s.d(r26.a, "found } instead of ] at path: " + r26.b, r26.p());
    L115:
        if (r30 != 10) goto L120;
        kotlinx.serialization.json.internal.a.m(r26, "Unexpected end of input due to malformed JSON during ignoring unknown keys", 0, null, 6);
        throw null;
    L92:
        if (r27 == true) goto L93;
        r26.d();
        goto L90
    L93:
        r26.j();
        goto L90
    L31:
        if (this.g.h == false) goto L63;
        ouc.a r110 = this.a;
        boolean r111 = r21.i(r19);
        luc.f r31 = r21.h(r19);
        if (r111 == false) goto L40;
        if (r31.a() == true) goto L40;
        if (this.c.w(r6) == false) goto L40;
    L59:
        boolean r32 = true;
    L61:
        if (r32 == false) goto L63;
        r20 = this.c.v();
        r22 = false;
    L40:
        if (Intrinsics.areEqual(r31.getKind(), o.b.a) == true) goto L42;
    L60:
        r32 = false;
        goto L61
    L42:
        if (r31.a() == true) goto L44;
    L46:
        String r33 = this.c.s(this.g.c);
        if (r33 == null) goto L60;
        int r34 = u.c(r31, r110, r33);
        if (r110.a.f == false) goto L52;
    L54:
        boolean r35 = false;
    L55:
        if (r34 != (-3)) goto L60;
        if (r111 == true) goto L58;
        if (r35 == false) goto L60;
    L58:
        this.c.i();
        goto L59
    L52:
        if (r31.a() == false) goto L54;
        r35 = true;
        goto L55
    L44:
        if (this.c.w(false) == false) goto L46;
    L63:
        JsonElementMarker r36 = this.h;
        if (r36 == null) goto L69;
        nuc.d0 r37 = r36.a;
        if (r19 >= 64) goto L68;
        r37.c |= 1 << r19;
        goto L69
    L68:
        int r38 = (r19 >>> 6) - 1;
        long[] r39 = r37.d;
        r39[r38] = (1 << (r19 & 63)) | r39[r38];
    L69:
        r8 = r19;
        goto L181
    L27:
        r18 = this.c.d();
        goto L28
    L125:
        if (r17 == true) goto L127;
    L131:
        JsonElementMarker r40 = this.h;
        if (r40 == null) goto L181;
        nuc.d0 r41 = r40.a;
        int r42 = r41.a.d();
    L134:
        long r43 = r41.c;
        long r44 = -1;
        if (r43 == (-1)) goto L139;
        int r45 = Long.numberOfTrailingZeros(~r43);
        r41.c |= 1 << r45;
        if (((Boolean) r41.b.invoke(r41.a, Integer.valueOf(r45))).booleanValue() == false) goto L134;
        r8 = r45;
        goto L181
    L139:
        if (r42 <= 64) goto L181;
        int r46 = r41.d.length;
    L141:
        if (r10 >= r46) goto L181;
        int r47 = r10 + 1;
        int r48 = r47 * 64;
        long r112 = r41.d[r10];
    L144:
        if (r112 == r44) goto L149;
        int r49 = Long.numberOfTrailingZeros(~r112);
        r112 = r112 | (1 << r49);
        int r50 = r49 + r48;
        if (((Boolean) r41.b.invoke(r41.a, Integer.valueOf(r50))).booleanValue() == true) goto L147;
        r44 = -1;
        goto L144
    L147:
        r41.d[r10] = r112;
        r8 = r50;
        goto L181
    L149:
        r41.d[r10] = r112;
        r10 = r47;
        r44 = -1;
        goto L141
    L127:
        if (this.a.a.n == true) goto L131;
        s.e(this.c, "object");
        throw null;
    }

    @Override // muc.a, muc.e
    public final int decodeEnum(luc.f r5) {
        Intrinsics.checkNotNullParameter(r5, "enumDescriptor");
        return u.d(r5, this.a, decodeString(), " at path " + this.c.b.a());
    }

    @Override // muc.a, muc.e
    public final e decodeInline(luc.f r3) {
        Intrinsics.checkNotNullParameter(r3, "descriptor");
        if (l0.a(r3) == false) goto L6;
        return new r(this.c, this.a);
    L6:
        return super.decodeInline(r3);
    }

    @Override // muc.a, muc.e
    public final <T> T decodeSerializableValue(juc.c<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "deserializer");
    L39:
        e = move-exception;
        String r0 = e.getMessage();
        Intrinsics.checkNotNull(r0);
        if (StringsKt.contains$default(r0, "at path", false, 2, null) == false) goto L44;
        throw e;
    L44:
        throw new MissingFieldException(e.getMissingFields(), e.getMessage() + " at path: " + this.c.b.a(), e);
    L4:
        if ((r10 instanceof nuc.b) == false) goto L38;
        if (this.a.a.i == true) goto L38;
        String r4 = h0.c(((nuc.b) r10).getDescriptor(), this.a);     // Catch: MissingFieldException -> L39
        String r5 = this.c.q(r4, this.g.c);     // Catch: MissingFieldException -> L39
        if (r5 == null) goto L11;
        juc.c r11 = juc.h.a((nuc.b) r10, this, r5);     // Catch: SerializationException -> L34
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlinx.serialization.DeserializationStrategy<T of kotlinx.serialization.json.internal.StreamingJsonDecoder.decodeSerializableValue>");     // Catch: MissingFieldException -> L39
        this.f = new a(r4);     // Catch: MissingFieldException -> L39
        return (T) r11.deserialize(this);
    L34:
        e = move-exception;
        String r1 = e.getMessage();     // Catch: MissingFieldException -> L39
        Intrinsics.checkNotNull(r1);     // Catch: MissingFieldException -> L39
        String r2 = StringsKt.removeSuffix(StringsKt.substringBefore$default(r1, '\n', null, 2, null), ".");     // Catch: MissingFieldException -> L39
        String r12 = e.getMessage();     // Catch: MissingFieldException -> L39
        Intrinsics.checkNotNull(r12);     // Catch: MissingFieldException -> L39
        kotlinx.serialization.json.internal.a.m(this.c, r2, 0, StringsKt.substringAfter(r12, '\n', ""), 2);     // Catch: MissingFieldException -> L39
        throw null;     // Catch: MissingFieldException -> L39
    L11:
        if ((r10 instanceof nuc.b) == false) goto L30;
        if (this.a.a.i == true) goto L30;
        String r6 = h0.c(((nuc.b) r10).getDescriptor(), this.a);     // Catch: MissingFieldException -> L39
        ouc.d0 r7 = a();     // Catch: MissingFieldException -> L39
        String r8 = ((nuc.b) r10).getDescriptor().f();     // Catch: MissingFieldException -> L39
        if ((r7 instanceof ouc.d0) == false) goto L28;
        ouc.d0 r9 = r7;     // Catch: MissingFieldException -> L39
        ouc.i r3 = (ouc.i) r9.get(r6);     // Catch: MissingFieldException -> L39
        if (r3 == null) goto L21;
        String r13 = ouc.k.g(ouc.k.o(r3));     // Catch: MissingFieldException -> L39
    L47:
        juc.c r14 = juc.h.a((nuc.b) r10, this, r13);     // Catch: SerializationException -> L24
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type kotlinx.serialization.DeserializationStrategy<T of kotlinx.serialization.json.internal.PolymorphicKt.decodeSerializableValuePolymorphic>");     // Catch: MissingFieldException -> L39
        return (T) p0.a(this.a, r6, r9, r14);
    L24:
        e = move-exception;
        String r15 = e.getMessage();     // Catch: MissingFieldException -> L39
        Intrinsics.checkNotNull(r15);     // Catch: MissingFieldException -> L39
        throw s.d(-1, r15, r9.toString());     // Catch: MissingFieldException -> L39
    L21:
        r13 = null;
        goto L47
    L28:
        throw s.d(-1, "Expected " + Reflection.getOrCreateKotlinClass(ouc.d0.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(r7.getClass()).getSimpleName() + " as the serialized body of " + r8 + " at element: " + this.c.b.a(), r7.toString());     // Catch: MissingFieldException -> L39
    L30:
        return r10.deserialize(this);
    L38:
        return r10.deserialize(this);
    }

    @Override // muc.a, muc.c
    public final void endStructure(luc.f r6) {
        Intrinsics.checkNotNullParameter(r6, "descriptor");
        if (this.a.a.b == false) goto L9;
        if (r6.d() != 0) goto L9;
    L7:
        if (decodeElementIndex(r6) != (-1)) goto L7;
    L9:
        if (this.c.v() == true) goto L11;
    L15:
        this.c.g(this.b.end);
        v r7 = this.c.b;
        int r0 = r7.c;
        int[] r2 = r7.b;
        if (r2[r0] != (-2)) goto L18;
        r2[r0] = -1;
        r7.c = r0 - 1;
    L18:
        int r1 = r7.c;
        if (r1 == (-1)) goto L24;
        r7.c = r1 - 1;
        return;
    L24:
        return;
    L11:
        if (this.a.a.n == true) goto L15;
        s.e(this.c, "");
        throw null;
    }

    @Override // muc.a, muc.c
    public final <T> T decodeSerializableElement(luc.f r7, int r8, juc.c<? extends T> r9, T r10) {
        Intrinsics.checkNotNullParameter(r7, "descriptor");
        Intrinsics.checkNotNullParameter(r9, "deserializer");
        if (this.b == WriteMode.MAP) goto L5;
    L7:
        boolean r0 = false;
    L9:
        if (r0 == false) goto L13;
        v r3 = this.c.b;
        int[] r4 = r3.b;
        int r5 = r3.c;
        if (r4[r5] != (-2)) goto L13;
        r3.a[r5] = v.a.a;
    L13:
        T r11 = (T) super.decodeSerializableElement(r7, r8, r9, r10);
        if (r0 == false) goto L21;
        v r12 = this.c.b;
        int[] r13 = r12.b;
        int r14 = r12.c;
        if (r13[r14] == (-2)) goto L20;
        int r15 = r14 + 1;
        r12.c = r15;
        Object[] r16 = r12.a;
        if (r15 != r16.length) goto L20;
        int r17 = r15 * 2;
        r12.a = Arrays.copyOf(r16, r17);
        r12.b = Arrays.copyOf(r12.b, r17);
    L20:
        Object[] r18 = r12.a;
        int r19 = r12.c;
        r18[r19] = r11;
        r12.b[r19] = -2;
    L21:
        return r11;
    L5:
        if ((r8 & 1) != 0) goto L7;
        r0 = true;
        goto L9
    }

    public j0(ouc.a r2, WriteMode r3, kotlinx.serialization.json.internal.a r4, luc.f r5, a r6) {
        Intrinsics.checkNotNullParameter(r2, "json");
        Intrinsics.checkNotNullParameter(r3, "mode");
        Intrinsics.checkNotNullParameter(r4, "lexer");
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r2.b;
        this.e = -1;
        this.f = r6;
        f r7 = r2.a;
        this.g = r7;
        if (r7.f == false) goto L5;
        JsonElementMarker r8 = null;
    L6:
        this.h = r8;
        return;
    L5:
        r8 = new JsonElementMarker(r5);
        goto L6
    }
}
