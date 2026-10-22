package com.squareup.kotlinpoet;

import ai.j0;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f15137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f15138c;
    public final Map d;
    public n e;
    public int f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f15139h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f15140i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList f15141j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LinkedHashSet f15142k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final LinkedHashMap f15143l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LinkedHashMap f15144m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final LinkedHashSet f15145n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f15146o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f15147p;

    public f(Appendable r5, String r10, LinkedHashMap r11, LinkedHashMap r12, LinkedHashMap r13, int r14, int r15) {
        if ((r15 & 2) == 0) goto L5;
        r10 = "  ";
    L5:
        Map r16 = r11;
        if ((r15 & 4) == 0) goto L8;
        r16 = MapsKt.emptyMap();
    L8:
        Map r17 = r12;
        if ((r15 & 8) == 0) goto L11;
        r17 = MapsKt.emptyMap();
    L11:
        Map r18 = r13;
        if ((r15 & 16) == 0) goto L15;
        r18 = MapsKt.emptyMap();
    L15:
        if ((r15 & 32) == 0) goto L17;
        r14 = 100;
    L17:
        Intrinsics.checkNotNullParameter(r5, "out");
        Intrinsics.checkNotNullParameter(r10, "indent");
        Intrinsics.checkNotNullParameter(r16, "memberImports");
        Intrinsics.checkNotNullParameter(r17, "importedTypes");
        Intrinsics.checkNotNullParameter(r18, "importedMembers");
        this.f15136a = r10;
        this.f15137b = r16;
        this.f15138c = r17;
        this.d = r18;
        this.e = new n(r5, r10, r14);
        this.f15140i = g.f15151a;
        this.f15141j = new ArrayList();
        this.f15142k = new LinkedHashSet();
        this.f15143l = new LinkedHashMap();
        this.f15144m = new LinkedHashMap();
        this.f15145n = new LinkedHashSet();
        this.f15147p = -1;
        Iterator r19 = r16.entrySet().iterator();
    L19:
        if (r19.hasNext() == false) goto L23;
        String r20 = (String) ((Map.Entry) r19.next()).getKey();
        int r21 = StringsKt.t(r20, '.', 0, 6);
        if (r21 < 0) goto L19;
        this.f15142k.add(r20.substring(0, r21));
        goto L19
    }

    public static f g(f r18, e r19, boolean r20, boolean r21, int r22) {
        if ((r22 & 2) == 0) goto L5;
        boolean r5 = false;
    L7:
        if ((r22 & 4) == 0) goto L9;
        boolean r10 = false;
    L10:
        r18.getClass();
        Intrinsics.checkNotNullParameter(r19, "codeBlock");
        ListIterator r11 = r19.f15131a.listIterator();
        int r12 = 0;
        c r13 = null;
    L12:
        if (r11.hasNext() == false) goto L182;
        String r14 = (String) r11.next();
        int r15 = r14.hashCode();
        List r16 = r19.f15131a;
        List r17 = r19.f15132b;
        if (r15 == 171) goto L143;
        if (r15 == 187) goto L128;
        if (r15 == 1184) goto L124;
        String r110 = "null";
        if (r15 != 1227) goto L22;
        char r111 = 4;
        if (r14.equals("%P") == false) goto L30;
        int r23 = r12 + 1;
        Object r24 = r17.get(r12);
        if (r24 != null) goto L108;
        String r25 = null;
    L121:
        if (r25 == null) goto L123;
        r110 = f0.h(r25, false, r5);
    L123:
        r18.b(r110, true);
    L61:
        r12 = r23;
        goto L12
    L108:
        if ((r24 instanceof e) == false) goto L119;
        final e r26 = (e) r24;
        Intrinsics.checkNotNullParameter(r18, "codeWriter");
        Function1<f, Unit> r112 = new CodeBlock$toString$2(r26);
        String r27 = g.f15151a;
        Intrinsics.checkNotNullParameter(r18, "codeWriter");
        Intrinsics.checkNotNullParameter(r112, "builderAction");
        StringBuilder r28 = new StringBuilder();
        n r29 = new n(r28, "  ", Integer.MAX_VALUE);
        n r113 = r18.e;     // Catch: Throwable -> L113
        r18.e = r29;     // Catch: Throwable -> L113
        r112.invoke(r18);     // Catch: Throwable -> L113
        r18.e = r113;     // Catch: Throwable -> L113
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L113
        CloseableKt.closeFinally(r29, null);
        String r30 = r28.toString();
    L112:
        r25 = r30;
    L113:
        th = move-exception;
        throw th;     // Catch: Throwable -> L116
    L116:
        th = move-exception;
        CloseableKt.closeFinally(r29, th);
        throw th;
    L119:
        r30 = (String) r24;
    L30:
        c r115 = null;
    L145:
        if (r13 != null) goto L147;
    L172:
        r18.b(r14, false);
        goto L12
    L147:
        if (StringsKt.P(r14, ".") == false) goto L171;
        String r31 = r14.substring(1);
        if (r31.length() == 0) goto L171;
        if (Character.isJavaIdentifierStart(r31.charAt(0)) == false) goto L171;
        StringBuilder r32 = new StringBuilder();
        r32.append(r13.f);
        r32.append('.');
        String r33 = g.f15151a;
        if (Character.isJavaIdentifierStart(r31.charAt(0)) == false) goto L170;
        int r34 = r31.length();
        if (1 > r34) goto L164;
        int r116 = 1;
    L159:
        String r117 = r31.substring(0, r116);
        Regex r118 = f0.f15148a;
        Intrinsics.checkNotNullParameter(r117, "<this>");
        if (f0.f15148a.matches(r117) == false) goto L161;
        if (r116 == r34) goto L164;
        r116 = r116 + 1;
        goto L159
    L161:
        r31 = r31.substring(0, r116 - 1);
    L164:
        r32.append(r31);
        if (r18.f15137b.get(r32.toString()) == null) goto L171;
        throw new ClassCastException();
    L170:
        throw new IllegalArgumentException("not an identifier: ".concat(r31).toString());
    L171:
        Intrinsics.checkNotNull(r13);
        r13.c(r18);
        r13 = r115;
        goto L172
    L22:
        if (r15 != 1230) goto L24;
        r111 = 4;
        if (r14.equals("%S") == false) goto L30;
        r23 = r12 + 1;
        String r35 = (String) r17.get(r12);
        if (r35 == null) goto L101;
        r110 = f0.h(r35, true, r5);
    L101:
        r18.b(r110, true);
        goto L61
    L24:
        if (r15 != 1231) goto L26;
        r111 = 4;
        if (r14.equals("%T") == false) goto L30;
        r23 = r12 + 1;
        Object r36 = r17.get(r12);
        Intrinsics.checkNotNull(r36, "null cannot be cast to non-null type com.squareup.kotlinpoet.TypeName");
        a0 r37 = (a0) r36;
        if (r37.f15077c.isEmpty() == true) goto L78;
        r37.d(r18);
        r37 = a0.b(r37, false, CollectionsKt.emptyList(), 1);
    L78:
        if ((r37 instanceof c) == true) goto L80;
    L89:
        boolean r38 = false;
    L90:
        if (r38 == true) goto L92;
        r37.c(r18);
    L92:
        r37.getClass();
        Intrinsics.checkNotNullParameter(r18, "out");
        if (r37.f15075a == false) goto L61;
        r18.b("?", false);
        goto L61
    L80:
        if (r11.hasNext() == false) goto L89;
        if (StringsKt.P((String) r16.get(r11.nextIndex()), "%") == true) goto L89;
        c r119 = (c) r37;
        if (r18.f15142k.contains(r119.f) == false) goto L89;
        if (r13 != null) goto L88;
        r38 = true;
        r13 = r119;
        goto L90
    L88:
        throw new IllegalStateException("pending type for static import?!");
    L26:
        if (r15 == 8676) goto L68;
        if (r15 == 8677) goto L63;
        switch(r15) {
            case 1223: goto L42;
            case 1224: goto L37;
            case 1225: goto L32;
            default: goto L30;
        };
    L42:
        if (r14.equals("%L") == false) goto L30;
        r23 = r12 + 1;
        Object r39 = r17.get(r12);
        if ((r39 instanceof d0) == false) goto L49;
        d0.c((d0) r39, r18, null);
    L47:
        r111 = 4;
        goto L61
    L49:
        if ((r39 instanceof b) == false) goto L52;
        ((b) r39).a(r18, true, r5);
        goto L47
    L52:
        if ((r39 instanceof w) == false) goto L55;
        w.b((w) r39, r18, SetsKt.emptySet(), false, 60);
        goto L47
    L55:
        if ((r39 instanceof k) == false) goto L58;
        ((k) r39).c(r18, null, SetsKt.setOf(KModifier.PUBLIC), true);
        goto L47
    L58:
        if ((r39 instanceof e) == false) goto L60;
        r111 = 4;
        g(r18, (e) r39, r5, false, 4);
        goto L61
    L60:
        r111 = 4;
        r18.b(String.valueOf(r39), false);
        goto L61
    L32:
        if (r14.equals("%N") == false) goto L30;
        Object r40 = r17.get(r12);
        Intrinsics.checkNotNull(r40, "null cannot be cast to non-null type kotlin.String");
        r18.b((String) r40, false);
        r12 = r12 + 1;
        goto L12
    L37:
        if (r14.equals("%M") == false) goto L30;
        Object r41 = r17.get(r12);
        Intrinsics.checkNotNull(r41, "null cannot be cast to non-null type com.squareup.kotlinpoet.MemberName");
        r41.getClass();
        throw new ClassCastException();
    L63:
        if (r14.equals("⇥") == false) goto L30;
        r18.f++;
        goto L12
    L68:
        if (r14.equals("⇤") == false) goto L30;
        r18.K(1);
        goto L12
    L124:
        r115 = null;
        if (r14.equals("%%") == false) goto L145;
        r18.b("%", false);
        goto L12
    L128:
        r115 = null;
        if (r14.equals("»") == false) goto L145;
        int r120 = r18.f15147p;
        if (r120 == (-1)) goto L137;
        if (r120 <= 0) goto L136;
        r18.K(2);
    L136:
        r18.f15147p = -1;
        goto L12
    L137:
        StringBuilder r42 = new StringBuilder("\n            |Can't close a statement that hasn't been opened (closing » is not preceded by an\n            |opening «).\n            |Current code block:\n            |- Format parts: ");
        ArrayList r43 = new ArrayList(CollectionsKt.h(r16));
        Iterator r44 = r16.iterator();
    L139:
        if (r44.hasNext() == false) goto L141;
        r43.add(f0.e((String) r44.next()));
        goto L139
    L141:
        r42.append(r43);
        r42.append("\n            |- Arguments: ");
        r42.append(r17);
        r42.append("\n            |\n            ");
        throw new IllegalStateException(StringsKt.f0(r42.toString()).toString());
    L143:
        r115 = null;
        if (r14.equals("«") == false) goto L145;
        if (r18.f15147p != (-1)) goto L176;
        r18.f15147p = 0;
        goto L12
    L176:
        StringBuilder r45 = new StringBuilder("\n            |Can't open a new statement until the current statement is closed (opening « followed\n            |by another « without a closing »).\n            |Current code block:\n            |- Format parts: ");
        ArrayList r46 = new ArrayList(CollectionsKt.h(r16));
        Iterator r47 = r16.iterator();
    L178:
        if (r47.hasNext() == false) goto L180;
        r46.add(f0.e((String) r47.next()));
        goto L178
    L180:
        r45.append(r46);
        r45.append("\n            |- Arguments: ");
        r45.append(r17);
        r45.append("\n            |\n            ");
        throw new IllegalStateException(StringsKt.f0(r45.toString()).toString());
    L182:
        if (r10 == false) goto L188;
        List r48 = r18.e.e;
        if (r48.size() == 1) goto L186;
    L187:
        r18.b("\n", false);
        goto L188
    L186:
        if (((CharSequence) r48.get(0)).length() > 0) goto L187;
    L188:
        return r18;
    L9:
        r10 = r21;
        goto L10
    L5:
        r5 = r20;
        goto L7
    }

    public final void J(List r10) {
        Intrinsics.checkNotNullParameter(r10, "typeVariables");
        if (r10.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator r11 = r10.iterator();
        boolean r5 = true;
    L7:
        if (r11.hasNext() == false) goto L19;
        e0 r12 = (e0) r11.next();
        if (r12.f.size() <= 1) goto L7;
        Iterator r13 = r12.f.iterator();
    L12:
        if (r13.hasNext() == false) goto L7;
        a0 r14 = (a0) r13.next();
        if (r5 == true) goto L17;
        String r15 = ", ";
    L16:
        f(r15);
        e("%L : %T", new Object[]{r12.e, r14});
        r5 = false;
        goto L12
    L17:
        r15 = " where ";
        goto L16
    }

    public final void K(int r5) {
        int r10 = this.f - r5;
        if (r10 < 0) goto L6;
        this.f = r10;
        return;
    L6:
        StringBuilder r11 = j0.s(r5, "cannot unindent ", " from ");
        r11.append(this.f);
        throw new IllegalArgumentException(r11.toString().toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4, types: [int] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4, types: [int] */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r5v19, types: [int] */
    /* JADX WARN: Type inference failed for: r5v6, types: [com.squareup.kotlinpoet.n] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [int] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void b(String r18, boolean r19) {
        Intrinsics.checkNotNullParameter(r18, "s");
        char r5 = '\n';
        ?? r10 = 1;
        boolean r11 = false;
        Iterator r12 = StringsKt.J(r18, new char[]{'\n'}, 0, 6).iterator();
        boolean r13 = true;
    L4:
        if (r12.hasNext() == false) goto L82;
        ?? r14 = (String) r12.next();
        String r15 = this.f15136a;
        if (r13 == true) goto L31;
        if (this.g == true) goto L12;
        if (this.f15139h == true) goto L12;
    L21:
        n r16 = this.e;
        if (r16.d == true) goto L29;
        r16.d();
        r16.f15187a.append("\n");
        r16.f = -1;
        this.f15146o = r10;
        int r17 = this.f15147p;
        if (r17 == (-1)) goto L31;
        if (r17 != 0) goto L27;
        this.f += 2;
    L27:
        this.f15147p = r17 + r10;
        goto L31
    L29:
        throw new IllegalStateException("closed");
    L12:
        if (this.f15146o == false) goto L21;
        int r20 = this.f;
        ?? r110 = r11;
    L14:
        if (r110 >= r20) goto L16;
        this.e.b(r15);
        r110 = r110 + r10;
        goto L14
    L16:
        n r21 = this.e;
        if (this.g == false) goto L19;
        String r111 = " *";
    L20:
        r21.b(r111);
        goto L21
    L19:
        r111 = "//";
    L31:
        if (r14.length() != 0) goto L33;
        boolean r22 = r11;
    L79:
        r13 = r22;
        r11 = r13;
        r5 = '\n';
        r10 = 1;
        goto L4
    L33:
        String r112 = " * ";
        if (this.f15146o == false) goto L44;
        int r23 = this.f;
        ?? r113 = r11;
    L36:
        if (r113 >= r23) goto L39;
        this.e.b(r15);
        r113 = r113 + r10;
        goto L36
    L39:
        if (this.g == false) goto L42;
        this.e.b(" * ");
        goto L44
    L42:
        if (this.f15139h == false) goto L44;
        this.e.b("// ");
    L44:
        if (r19 == false) goto L47;
        this.e.b(r14);
    L46:
        r22 = r11;
        this.f15146o = r22;
        goto L79
    L47:
        n r24 = this.e;
        boolean r25 = this.g;
        int r114 = this.f;
        if (r25 == true) goto L52;
        r114 = r114 + 2;
    L52:
        if (r25 == true) goto L55;
        r112 = "";
    L55:
        r24.getClass();
        Intrinsics.checkNotNullParameter(r14, "s");
        Intrinsics.checkNotNullParameter(r112, "linePrefix");
        if (r24.d == true) goto L81;
        ?? r26 = r11;
        ?? r27 = r10;
    L59:
        if (r26 >= r14.length()) goto L46;
        char r115 = r14.charAt(r26);
        List r116 = r24.e;
        if (r115 != ' ') goto L65;
        r24.f = r114;
        r24.g = r112;
        r116.add("");
    L63:
        int r28 = r26 + (r27 == true ? 1 : 0);
    L64:
        r11 = false;
        r27 = r27;
        r26 = r28;
        goto L59
    L65:
        if (r115 != r5) goto L72;
        if (r24.d == true) goto L70;
        r24.d();
        r24.f15187a.append("\n");
        r24.f = -1;
        goto L63
    L70:
        throw new IllegalStateException("closed");
    L72:
        if (r115 != 183) goto L74;
        int r29 = r116.size() - (r27 == true ? 1 : 0);
        r116.set(r29, ((String) r116.get(r29)) + ' ');
        r28 = r26 + 1;
        r27 = 1;
        r5 = '\n';
        goto L64
    L74:
        boolean r30 = r27 == true ? 1 : 0;
        int r31 = StringsKt.s(r14, n.f15186i, r26);
        if (r31 != (-1)) goto L77;
        r31 = r14.length();
    L77:
        int r117 = r116.size() - (r30 ? 1 : 0);
        r116.set(r117, ((String) r116.get(r117)) + r14.substring(r26, r31));
        r28 = r31;
        r5 = '\n';
        r27 = 1;
        goto L64
    L81:
        throw new IllegalStateException("closed");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.e.close();
    }

    public final void d(List r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "annotations");
        Iterator r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        ((b) r11.next()).a(this, r10, false);
        if (r10 == false) goto L8;
        String r12 = " ";
    L9:
        b(r12, false);
        goto L4
    L8:
        r12 = "\n";
        goto L9
    }

    public final f e(String r5, Object... r10) {
        Intrinsics.checkNotNullParameter(r5, "format");
        Intrinsics.checkNotNullParameter(r10, "args");
        Set r11 = e.f15130c;
        g(this, com.bytedance.apm.util.a.p(r5, Arrays.copyOf(r10, r10.length)), false, false, 6);
        return this;
    }

    public final void f(String r5) {
        Intrinsics.checkNotNullParameter(r5, "s");
        Set r10 = e.f15130c;
        g(this, com.bytedance.apm.util.a.p(r5, new Object[0]), false, false, 6);
    }

    public final void m(List r10) {
        Intrinsics.checkNotNullParameter(r10, "contextReceivers");
        Intrinsics.checkNotNullParameter("\n", "suffix");
        if (r10.isEmpty() == true) goto L11;
        ArrayList r5 = new ArrayList(CollectionsKt.h(r10));
        Iterator r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        a0 r12 = (a0) r11.next();
        Set r13 = e.f15130c;
        r5.add(com.bytedance.apm.util.a.p("%T", new Object[]{r12}));
        goto L6
    L8:
        g(this, com.bytedance.ies.bullet.base.utils.b.q(r5, null, "context(", ")", 1), false, false, 6);
        b("\n", false);
        return;
    }

    public final void n(e r5) {
        Intrinsics.checkNotNullParameter(r5, "kdocCodeBlock");
        if (r5.f15131a.isEmpty() == false) goto L5;
        return;
    L5:
        b("/**\n", false);
        this.g = true;
        g(this, r5, false, true, 2);     // Catch: Throwable -> L9
        this.g = false;
        b(" */\n", false);
        return;
    L9:
        th = move-exception;
        this.g = false;
        throw th;
    }

    public final void p(Set r10, Set r11) {
        Intrinsics.checkNotNullParameter(r10, "modifiers");
        Intrinsics.checkNotNullParameter(r11, "implicitModifiers");
        KModifier r5 = KModifier.PUBLIC;
        boolean r12 = true;
        if (r10.contains(r5) == true) goto L10;
        if (r11.contains(r5) == true) goto L8;
        r12 = false;
        goto L10
    L8:
        r12 = true ^ f0.c(r10, new KModifier[]{KModifier.PRIVATE, KModifier.INTERNAL, KModifier.PROTECTED});
    L10:
        if (r12 == false) goto L12;
        b(r5.getKeyword$kotlinpoet(), false);
        b(" ", false);
    L12:
        Set r13 = r10;
        KModifier[] r14 = KModifier.values();
        LinkedHashSet r15 = new LinkedHashSet();
        int r16 = r14.length;
        int r17 = 0;
    L13:
        if (r17 >= r16) goto L18;
        KModifier r18 = r14[r17];
        if (r13.contains(r18) == false) goto L17;
        r15.add(r18);
    L17:
        r17 = r17 + 1;
        goto L13
    L18:
        Iterator r19 = r15.iterator();
    L20:
        if (r19.hasNext() == false) goto L24;
        KModifier r20 = (KModifier) r19.next();
        if (r11.contains(r20) == true) goto L20;
        b(r20.getKeyword$kotlinpoet(), false);
        b(" ", false);
        goto L20
    }

    public final void q(List r10) {
        Intrinsics.checkNotNullParameter(r10, "typeVariables");
        if (r10.isEmpty() == false) goto L5;
        return;
    L5:
        b("<", false);
        Iterator r11 = r10.iterator();
        int r5 = 0;
    L7:
        if (r11.hasNext() == false) goto L26;
        Object r12 = r11.next();
        int r13 = r5 + 1;
        if (r5 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        e0 r14 = (e0) r12;
        if (r5 <= 0) goto L15;
        b(", ", false);
    L15:
        if (r14.g == null) goto L18;
        b(r14.g.getKeyword$kotlinpoet() + ' ', false);
    L18:
        if (r14.f15135h == false) goto L20;
        b("reified ", false);
    L20:
        e("%L", new Object[]{r14.e});
        List r15 = r14.f;
        if (r15.size() != 1) goto L25;
        if (Intrinsics.areEqual(r15.get(0), g.f15152b) == true) goto L25;
        e(" : %T", new Object[]{r15.get(0)});
    L25:
        r5 = r13;
        goto L7
    L26:
        b(">", false);
    }
}
