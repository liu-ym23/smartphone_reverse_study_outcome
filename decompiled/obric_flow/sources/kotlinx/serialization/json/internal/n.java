package kotlinx.serialization.json.internal;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.salamander.anniex.b0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.internal.w;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends dn.a implements kotlinx.serialization.json.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kotlinx.serialization.json.b f19435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WriteMode f19436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bi.e f19437c;
    public final jk.a d;
    public int e;
    public ai.k f;
    public final kotlinx.serialization.json.i g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final e f19438h;

    public n(kotlinx.serialization.json.b r5, WriteMode r10, bi.e r11, kotlinx.serialization.descriptors.g r12, ai.k r13) {
        Intrinsics.checkNotNullParameter(r5, "json");
        Intrinsics.checkNotNullParameter(r10, "mode");
        Intrinsics.checkNotNullParameter(r11, "lexer");
        Intrinsics.checkNotNullParameter(r12, "descriptor");
        this.f19435a = r5;
        this.f19436b = r10;
        this.f19437c = r11;
        this.d = r5.f19385b;
        this.e = -1;
        this.f = r13;
        kotlinx.serialization.json.i r14 = r5.f19384a;
        this.g = r14;
        if (r14.f == false) goto L5;
        e r15 = null;
    L6:
        this.f19438h = r15;
        return;
    L5:
        r15 = new e(r12);
        goto L6
    }

    @Override // dn.a, eu.b
    public final boolean B() {
        e r5 = this.f19438h;
        if (r5 == null) goto L5;
        boolean r10 = r5.f19422b;
    L6:
        if (r10 == false) goto L8;
        return false;
    L8:
        if (this.f19437c.D(true) == false) goto L10;
        return false;
    L10:
        return true;
    L5:
        r10 = false;
        goto L6
    }

    @Override // kotlinx.serialization.json.j
    public final kotlinx.serialization.json.b C() {
        return this.f19435a;
    }

    @Override // dn.a, eu.b
    public final byte E() {
        bi.e r5 = this.f19437c;
        long r10 = r5.l();
        byte r11 = (byte) r10;
        if (r10 != r11) goto L5;
        return r11;
    L5:
        bi.e.q(r5, "Failed to parse byte for input '" + r10 + '\'', 0, null, 6);
        throw null;
    }

    @Override // dn.a, eu.b
    public final int c(kotlinx.serialization.descriptors.g r5) {
        Intrinsics.checkNotNullParameter(r5, "enumDescriptor");
        return f.l(r5, this.f19435a, z(), " at path " + ((b0) this.f19437c.d).b());
    }

    @Override // kotlinx.serialization.json.j
    public final kotlinx.serialization.json.l f() {
        return new l(this.f19435a.f19384a, this.f19437c).b();
    }

    @Override // dn.a, eu.b
    public final int g() {
        bi.e r5 = this.f19437c;
        long r10 = r5.l();
        int r11 = (int) r10;
        if (r10 != r11) goto L5;
        return r11;
    L5:
        bi.e.q(r5, "Failed to parse int for input '" + r10 + '\'', 0, null, 6);
        throw null;
    }

    @Override // dn.a, eu.b
    public final eu.a i(kotlinx.serialization.descriptors.g r11) {
        Intrinsics.checkNotNullParameter(r11, "descriptor");
        kotlinx.serialization.json.b r5 = this.f19435a;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r11, "desc");
        kotlinx.serialization.descriptors.k r10 = r11.getKind();
        if ((r10 instanceof kotlinx.serialization.descriptors.d) == false) goto L7;
        WriteMode r12 = WriteMode.POLY_OBJ;
    L5:
        WriteMode r13 = r12;
        bi.e r14 = this.f19437c;
        b0 r15 = (b0) r14.d;
        Intrinsics.checkNotNullParameter(r11, "sd");
        int r16 = r15.f7246b + 1;
        r15.f7246b = r16;
        Object[] r17 = (Object[]) r15.f7247c;
        if (r16 != r17.length) goto L26;
        int r18 = r16 * 2;
        r15.f7247c = Arrays.copyOf(r17, r18);
        r15.d = Arrays.copyOf((int[]) r15.d, r18);
    L26:
        ((Object[]) r15.f7247c)[r16] = r11;
        r14.k(r13.begin);
        if (r14.y() == 4) goto L43;
        int r19 = m.f19434a[r13.ordinal()];
        if (r19 != 1) goto L31;
    L40:
        ai.k r20 = this.f;
        n r21 = new n(this.f19435a, r13, r14, r11, r20);
    L42:
        return r21;
    L31:
        if (r19 == 2) goto L40;
        if (r19 == 3) goto L40;
        if (this.f19436b == r13) goto L37;
    L39:
        ai.k r22 = this.f;
        r21 = new n(this.f19435a, r13, r14, r11, r22);
        goto L42
    L37:
        if (r5.f19384a.f == false) goto L39;
        return this;
    L43:
        bi.e.q(r14, "Unexpected leading comma", 0, null, 6);
        throw null;
    L7:
        if (Intrinsics.areEqual(r10, kotlinx.serialization.descriptors.n.f19244c) == false) goto L10;
        r12 = WriteMode.LIST;
        goto L5
    L10:
        if (Intrinsics.areEqual(r10, kotlinx.serialization.descriptors.n.d) == false) goto L22;
        kotlinx.serialization.descriptors.g r23 = f.f(r11.g(0), r5.f19385b);
        kotlinx.serialization.descriptors.k r24 = r23.getKind();
        if ((r24 instanceof kotlinx.serialization.descriptors.f) == false) goto L14;
    L21:
        r12 = WriteMode.MAP;
        goto L5
    L14:
        if (Intrinsics.areEqual(r24, kotlinx.serialization.descriptors.m.f19242b) == true) goto L21;
        if (r5.f19384a.d == false) goto L20;
        r12 = WriteMode.LIST;
        goto L5
    L20:
        throw f.b(r23);
    L22:
        r12 = WriteMode.OBJ;
        goto L5
    }

    @Override // dn.a, eu.b
    public final long j() {
        return this.f19437c.l();
    }

    @Override // eu.a
    public final int l(kotlinx.serialization.descriptors.g r20) {
        Intrinsics.checkNotNullParameter(r20, "descriptor");
        int[] r5 = m.f19434a;
        WriteMode r10 = this.f19436b;
        int r11 = r5[r10.ordinal()];
        bi.e r12 = this.f19437c;
        boolean r13 = true;
        int r14 = 0;
        char r15 = ':';
        int r16 = -1;
        b0 r17 = (b0) r12.d;
        if (r11 == 2) goto L127;
        if (r11 == 4) goto L18;
        boolean r18 = r12.C();
        if (r12.e() == false) goto L14;
        int r19 = this.e;
        if (r19 == (-1)) goto L13;
        if (r18 == true) goto L13;
        bi.e.q(r12, "Expected end of the array or comma", 0, null, 6);
        throw null;
    L13:
        r16 = r19 + 1;
        this.e = r16;
    L156:
        if (r10 == WriteMode.MAP) goto L158;
        ((int[]) r17.d)[r17.f7246b] = r16;
    L158:
        return r16;
    L14:
        if (r18 == false) goto L156;
        bi.e.q(r12, "Unexpected trailing comma", 0, null, 6);
        throw null;
    L18:
        boolean r21 = r12.C();
    L19:
        boolean r22 = r12.e();
        e r110 = this.f19438h;
        if (r22 == false) goto L104;
        kotlinx.serialization.json.i r23 = this.g;
        boolean r24 = r23.f19407c;
        if (r24 == false) goto L25;
        String r111 = r12.o();
    L24:
        String r112 = r111;
        r12.k(r15);
        kotlinx.serialization.json.b r113 = this.f19435a;
        int r114 = f.k(r20, r113, r112);
        if (r114 != (-3)) goto L29;
        boolean r25 = false;
        boolean r26 = true;
    L56:
        if (r26 == false) goto L103;
        boolean r27 = r23.f19406b;
        String r28 = (String) r12.f;
        if (r27 == true) goto L66;
        ai.k r29 = this.f;
        if (r29 == null) goto L64;
        if (Intrinsics.areEqual(r29.f239a, r112) == false) goto L64;
        r29.f239a = null;
    L64:
        Intrinsics.checkNotNullParameter(r112, STGroup.DICT_KEY);
        r12.p(StringsKt.u(r28.subSequence(0, r12.f930b).toString(), r112), androidx.room.jarjarred.org.antlr.runtime.a.p("Encountered an unknown key '", '\'', r112), "Use 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.");
        throw null;
    L66:
        ArrayList r30 = new ArrayList();
        byte r31 = r12.y();
        if (r31 == 8) goto L71;
        if (r31 == 6) goto L71;
        r12.n();
    L99:
        r21 = r12.C();
    L100:
        r13 = true;
        r15 = ':';
    L71:
        byte r32 = r12.y();
        if (r32 == 1) goto L73;
        if (r32 != 8) goto L79;
    L80:
        r30.add(Byte.valueOf(r32));
    L97:
        r12.i();
        if (r30.size() != 0) goto L71;
    L79:
        if (r32 == 6) goto L80;
        if (r32 != 9) goto L89;
        if (((Number) CollectionsKt.last(r30)).byteValue() != 8) goto L87;
        CollectionsKt.removeLast(r30);
        goto L97
    L87:
        throw f.c(r12.f930b, r28, "found ] instead of } at path: " + r17);
    L89:
        if (r32 != 7) goto L96;
        if (((Number) CollectionsKt.last(r30)).byteValue() != 6) goto L94;
        CollectionsKt.removeLast(r30);
        goto L97
    L94:
        throw f.c(r12.f930b, r28, "found } instead of ] at path: " + r17);
    L96:
        if (r32 != 10) goto L97;
        bi.e.q(r12, "Unexpected end of input due to malformed JSON during ignoring unknown keys", 0, null, 6);
        throw null;
    L73:
        if (r24 == true) goto L74;
        r12.h();
        goto L71
    L74:
        r12.n();
        goto L71
    L103:
        r21 = r25;
        goto L100
    L29:
        if (r23.f19408h == false) goto L49;
        kotlinx.serialization.descriptors.g r33 = r20.g(r114);
        if (r33.b() == true) goto L36;
        if (r12.D(r13) == false) goto L36;
    L48:
        r25 = r12.C();
        r26 = false;
    L36:
        if (Intrinsics.areEqual(r33.getKind(), kotlinx.serialization.descriptors.m.f19242b) == false) goto L49;
        if (r33.b() == true) goto L40;
    L42:
        String r34 = r12.z(r24);
        if (r34 == null) goto L49;
        if (f.k(r33, r113, r34) != (-3)) goto L49;
        r12.m();
        goto L48
    L40:
        if (r12.D(false) == false) goto L42;
    L49:
        if (r110 == null) goto L54;
        w r35 = r110.f19421a;
        if (r114 >= 64) goto L53;
        r35.f19362c |= 1 << r114;
        goto L54
    L53:
        int r36 = (r114 >>> 6) - 1;
        long[] r37 = r35.d;
        r37[r36] = (1 << (r114 & 63)) | r37[r36];
    L54:
        r16 = r114;
        goto L156
    L25:
        r111 = r12.h();
        goto L24
    L104:
        if (r21 == true) goto L125;
        if (r110 == null) goto L124;
        w r38 = r110.f19421a;
        kotlinx.serialization.descriptors.g r39 = r38.f19360a;
        int r40 = r39.d();
    L107:
        long r41 = r38.f19362c;
        long r42 = -1;
        Function2 r115 = r38.f19361b;
        if (r41 == (-1)) goto L113;
        int r43 = Long.numberOfTrailingZeros(~r41);
        r38.f19362c |= 1 << r43;
        if (((Boolean) r115.mo2invoke(r39, Integer.valueOf(r43))).booleanValue() == false) goto L107;
        r16 = r43;
        goto L156
    L113:
        if (r40 <= 64) goto L124;
        long[] r44 = r38.d;
        int r45 = r44.length;
    L115:
        if (r14 >= r45) goto L124;
        int r46 = r14 + 1;
        int r47 = r46 * 64;
        long r116 = r44[r14];
    L118:
        if (r116 == r42) goto L123;
        int r48 = Long.numberOfTrailingZeros(~r116);
        r116 = r116 | (1 << r48);
        int r49 = r48 + r47;
        if (((Boolean) r115.mo2invoke(r39, Integer.valueOf(r49))).booleanValue() == true) goto L121;
        r42 = -1;
        goto L118
    L121:
        r44[r14] = r116;
        r16 = r49;
        goto L156
    L123:
        r44[r14] = r116;
        r14 = r46;
        r42 = -1;
    L124:
        r16 = -1;
        goto L156
    L125:
        bi.e.q(r12, "Unexpected trailing comma", 0, null, 6);
        throw null;
    L127:
        int r50 = this.e;
        if ((r50 % 2) == 0) goto L130;
        boolean r51 = true;
    L131:
        if (r51 == false) goto L135;
        int r52 = -1;
        if (r50 == (-1)) goto L136;
        boolean r53 = r12.C();
    L138:
        if (r12.e() == false) goto L153;
        if (r51 == true) goto L141;
    L152:
        r16 = this.e + 1;
        this.e = r16;
        goto L156
    L141:
        if (this.e != r52) goto L147;
        int r54 = r12.f930b;
        if (r53 == false) goto L152;
        bi.e.q(r12, "Unexpected trailing comma", r54, null, 4);
        throw null;
    L147:
        int r55 = r12.f930b;
        if (r53 == true) goto L152;
        bi.e.q(r12, "Expected comma after the key-value pair", r55, null, 4);
        throw null;
    L153:
        if (r53 == true) goto L159;
        r16 = r52;
        goto L156
    L159:
        bi.e.q(r12, "Expected '}', but had ',' instead", 0, null, 6);
        throw null;
    L136:
        r53 = false;
        goto L138
    L135:
        r52 = -1;
        r12.k(':');
        goto L136
    L130:
        r51 = false;
        goto L131
    }

    @Override // dn.a, eu.b
    public final eu.b m(kotlinx.serialization.descriptors.g r5) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        Set r10 = o.f19439a;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.isInline() == true) goto L5;
    L7:
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        return this;
    L5:
        if (o.f19439a.contains(r5) == false) goto L7;
        return new d(this.f19437c, this.f19435a);
    }

    @Override // dn.a, eu.b
    public final short o() {
        bi.e r5 = this.f19437c;
        long r10 = r5.l();
        short r11 = (short) r10;
        if (r10 != r11) goto L5;
        return r11;
    L5:
        bi.e.q(r5, "Failed to parse short for input '" + r10 + '\'', 0, null, 6);
        throw null;
    }

    @Override // dn.a, eu.b
    public final float p() {
        bi.e r5 = this.f19437c;
        String r10 = r5.n();
        float r11 = Float.parseFloat(r10);     // Catch: IllegalArgumentException -> L14
        if (this.f19435a.f19384a.f19411k == false) goto L7;
    L13:
        return r11;
    L7:
        if (Float.isInfinite(r11) == false) goto L9;
    L11:
        f.o(r5, Float.valueOf(r11));
        throw null;
    L9:
        if (Float.isNaN(r11) == true) goto L11;
    L14:
        bi.e.q(r5, androidx.room.jarjarred.org.antlr.runtime.a.p("Failed to parse type 'float' for input '", '\'', r10), 0, null, 6);
        throw null;
    }

    @Override // dn.a, eu.b
    public final double q() {
        bi.e r5 = this.f19437c;
        String r10 = r5.n();
        double r11 = Double.parseDouble(r10);     // Catch: IllegalArgumentException -> L14
        if (this.f19435a.f19384a.f19411k == false) goto L7;
    L13:
        return r11;
    L7:
        if (Double.isInfinite(r11) == false) goto L9;
    L11:
        f.o(r5, Double.valueOf(r11));
        throw null;
    L9:
        if (Double.isNaN(r11) == true) goto L11;
    L14:
        bi.e.q(r5, androidx.room.jarjarred.org.antlr.runtime.a.p("Failed to parse type 'double' for input '", '\'', r10), 0, null, 6);
        throw null;
    }

    @Override // dn.a, eu.b
    public final boolean s() {
        kotlinx.serialization.json.i r5 = this.g;
        bi.e r10 = this.f19437c;
        if (r5.f19407c == false) goto L24;
        int r11 = r10.B();
        String r12 = (String) r10.f;
        if (r11 != r12.length()) goto L7;
        bi.e.q(r10, "EOF", 0, null, 6);
        throw null;
    L7:
        if (r12.charAt(r11) != '\"') goto L9;
        r11 = r11 + 1;
        boolean r13 = true;
    L10:
        boolean r14 = r10.f(r11);
        if (r13 == true) goto L13;
        return r14;
    L13:
        if (r10.f930b != r12.length()) goto L15;
        bi.e.q(r10, "EOF", 0, null, 6);
        throw null;
    L15:
        if (r12.charAt(r10.f930b) != '\"') goto L17;
        r10.f930b++;
        return r14;
    L17:
        bi.e.q(r10, "Expected closing quotation mark", 0, null, 6);
        throw null;
    L9:
        r13 = false;
        goto L10
    L24:
        return r10.f(r10.B());
    }

    @Override // dn.a, eu.b
    public final char t() {
        bi.e r5 = this.f19437c;
        String r10 = r5.n();
        if (r10.length() == 1) goto L5;
        bi.e.q(r5, androidx.room.jarjarred.org.antlr.runtime.a.p("Expected single char, but got '", '\'', r10), 0, null, 6);
        throw null;
    L5:
        return r10.charAt(0);
    }

    @Override // dn.a, eu.a
    public final void u(kotlinx.serialization.descriptors.g r5) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        if (this.f19435a.f19384a.f19406b == true) goto L5;
    L8:
        char r10 = this.f19436b.end;
        bi.e r11 = this.f19437c;
        r11.k(r10);
        b0 r12 = (b0) r11.d;
        int r13 = r12.f7246b;
        int[] r14 = (int[]) r12.d;
        if (r14[r13] != (-2)) goto L11;
        r14[r13] = -1;
        r12.f7246b = r13 - 1;
    L11:
        int r15 = r12.f7246b;
        if (r15 == (-1)) goto L17;
        r12.f7246b = r15 - 1;
        return;
    L17:
        return;
    L5:
        if (r5.d() != 0) goto L8;
    L7:
        if (l(r5) != (-1)) goto L7;
        goto L8
    }

    @Override // dn.a, eu.b
    public final Object w(kotlinx.serialization.b r5) {
        bi.e r10 = this.f19437c;
        kotlinx.serialization.json.b r11 = this.f19435a;
        Intrinsics.checkNotNullParameter(r5, "deserializer");
    L11:
        e = move-exception;
        String r12 = e.getMessage();
        Intrinsics.checkNotNull(r12);
        if (StringsKt.g(r12, "at path") == false) goto L25;
        throw e;
    L25:
        throw new MissingFieldException(e.getMissingFields(), e.getMessage() + " at path: " + ((b0) r10.d).b(), e);
    L4:
        if ((r5 instanceof kotlinx.serialization.internal.b) == false) goto L20;
        if (r11.f19384a.f19409i == true) goto L20;
        String r13 = f.h(((kotlinx.serialization.e) r5).getDescriptor(), r11);     // Catch: MissingFieldException -> L11
        String r14 = r10.x(r13, this.g.f19407c);     // Catch: MissingFieldException -> L11
        if (r14 == null) goto L13;
        kotlinx.serialization.b r15 = ((kotlinx.serialization.internal.b) r5).b(this, r14);     // Catch: MissingFieldException -> L11
    L14:
        if (r15 == null) goto L16;
        ai.k r16 = new ai.k();     // Catch: MissingFieldException -> L11
        r16.f239a = r13;     // Catch: MissingFieldException -> L11
        this.f = r16;     // Catch: MissingFieldException -> L11
        return r15.a(this);
    L16:
        return f.i(this, r5);
    L13:
        r15 = null;
    L20:
        return r5.a(this);
    }

    @Override // eu.a
    public final jk.a x() {
        return this.d;
    }

    @Override // dn.a, eu.a
    public final Object y(kotlinx.serialization.descriptors.g r10, int r11, kotlinx.serialization.b r12, Object r13) {
        Intrinsics.checkNotNullParameter(r10, "descriptor");
        Intrinsics.checkNotNullParameter(r12, "deserializer");
        if (this.f19436b == WriteMode.MAP) goto L5;
    L7:
        boolean r5 = false;
    L8:
        b0 r14 = (b0) this.f19437c.d;
        if (r5 == false) goto L13;
        int[] r15 = (int[]) r14.d;
        int r16 = r14.f7246b;
        if (r15[r16] != (-2)) goto L13;
        ((Object[]) r14.f7247c)[r16] = g.f19424a;
    L13:
        Object r17 = super.y(r10, r11, r12, r13);
        if (r5 == false) goto L21;
        int[] r18 = (int[]) r14.d;
        int r19 = r14.f7246b;
        if (r18[r19] == (-2)) goto L20;
        int r20 = r19 + 1;
        r14.f7246b = r20;
        Object[] r21 = (Object[]) r14.f7247c;
        if (r20 != r21.length) goto L20;
        int r22 = r20 * 2;
        r14.f7247c = Arrays.copyOf(r21, r22);
        r14.d = Arrays.copyOf((int[]) r14.d, r22);
    L20:
        Object[] r23 = (Object[]) r14.f7247c;
        int r24 = r14.f7246b;
        r23[r24] = r17;
        ((int[]) r14.d)[r24] = -2;
    L21:
        return r17;
    L5:
        if ((r11 & 1) != 0) goto L7;
        r5 = true;
        goto L8
    }

    @Override // dn.a, eu.b
    public final String z() {
        boolean r5 = this.g.f19407c;
        bi.e r10 = this.f19437c;
        if (r5 == false) goto L6;
        return r10.o();
    L6:
        return r10.m();
    }
}
