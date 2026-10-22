package com.ss.android.lark.commonmark.internal;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import v7b.b0;
import v7b.w;
import v7b.x;
import v7b.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class n implements x7b.c {
    public final w7b.a a;
    public final List<x7b.b> b;
    public final Map<Character, z7b.a> c;
    public final BitSet d;
    public Map<Character, List<x7b.a>> e;
    public x7b.e f;
    public boolean g;
    public int h;
    public f i;
    public e j;

    public static class a {
        public final List<b0> a;
        public final boolean b;
        public final boolean c;

        public a(List<b0> r1, boolean r2, boolean r3) {
            this.a = r1;
            this.c = r2;
            this.b = r3;
        }
    }

    public final b0 f() {
        x7b.d r0 = this.f.k();
        this.f.g();
    L3:
        char r1 = this.f.j();
        if (r1 == 0) goto L9;
        if (this.d.get(r1) == true) goto L9;
        this.f.g();
    L9:
        x7b.e r2 = this.f;
        w7b.g r3 = r2.c(r0, r2.k());
        String r4 = r3.a();
        int r5 = -1;
        if (r1 != '\n') goto L18;
        int r6 = r4.length() - 1;
    L12:
        if (r6 < 0) goto L17;
        if (r4.charAt(r6) != ' ') goto L15;
        r6 = r6 - 1;
        goto L12
    L15:
        r5 = r6;
    L17:
        int r7 = r5 + 1;
        this.h = r4.length() - r7;
        r4 = r4.substring(0, r7);
    L27:
        b0 r8 = new b0(r4);
        r8.n(r3.b());
        return r8;
    L18:
        if (r1 != 0) goto L27;
        int r9 = r4.length() - 1;
    L20:
        if (r9 < 0) goto L26;
        char r10 = r4.charAt(r9);
        if (r10 == '\t') goto L25;
        if (r10 == ' ') goto L25;
        r5 = r9;
    L25:
        r9 = r9 - 1;
    L26:
        r4 = r4.substring(0, r5 + 1);
        goto L27
    }

    public n(m r7) {
        this.a = r7;
        ArrayList r1 = new ArrayList(r7.a);
        r1.add(new t7b.c.a());
        r1.add(new t7b.d.a());
        r1.add(new t7b.f.a());
        r1.add(new t7b.b.a());
        r1.add(new t7b.g.a());
        this.b = r1;
        List<z7b.a> r8 = r7.b;
        HashMap r0 = new HashMap();
        int r5 = 0;
        Object[] r4 = {new t7b.a(), new t7b.i()};
        ArrayList r2 = new ArrayList(2);
    L3:
        if (r5 >= 2) goto L5;
        Object r3 = r4[r5];
        Objects.requireNonNull(r3);
        r2.add(r3);
        r5 = r5 + 1;
        goto L3
    L5:
        b(Collections.unmodifiableList(r2), r0);
        b(r8, r0);
        this.c = r0;
        Set r9 = r0.keySet();
        List<x7b.b> r6 = this.b;
        BitSet r10 = new BitSet();
        Iterator r11 = r9.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        r10.set(((Character) r11.next()).charValue());
        goto L7
    L9:
        Iterator r12 = ((ArrayList) r6).iterator();
    L11:
        if (r12.hasNext() == false) goto L16;
        Iterator<Character> r13 = ((x7b.b) r12.next()).a().iterator();
    L14:
        if (r13.hasNext() == false) goto L11;
        r10.set(r13.next().charValue());
        goto L14
    L16:
        r10.set(91);
        r10.set(93);
        r10.set(33);
        r10.set(10);
        this.d = r10;
    }

    public static b0 i(w7b.g r2) {
        b0 r0 = new b0(r2.a());
        r0.n(r2.b());
        return r0;
    }

    public final void c(v7b.s r8) {
        v7b.s r0 = r8.e;
        if (r0 != null) goto L5;
        return;
    L5:
        v7b.s r9 = r8.f;
        b0 r3 = null;
        b0 r4 = null;
        int r5 = 0;
    L6:
        if (r0 == null) goto L17;
        if ((r0 instanceof b0) == false) goto L13;
        r4 = (b0) r0;
        if (r3 != null) goto L12;
        r3 = r4;
    L12:
        r5 = r5 + r4.j.length();
    L14:
        if (r0 == r9) goto L17;
        r0 = r0.h;
        goto L6
    L13:
        d(r3, r4, r5);
        c(r0);
        r3 = null;
        r4 = null;
        r5 = 0;
    L17:
        d(r3, r4, r5);
    }

    public final void g(f r12) {
        HashMap r0 = new HashMap();
        f r1 = this.i;
    L3:
        if (r1 == null) goto L7;
        f r2 = r1.f;
        if (r2 == r12) goto L7;
        r1 = r2;
    L7:
        if (r1 == null) goto L51;
        char r3 = r1.b;
        Map<Character, z7b.a> r4 = this.c;
        HashMap r5 = (HashMap) r4;
        z7b.a r6 = (z7b.a) r5.get(Character.valueOf(r3));
        if (r1.e == false) goto L50;
        if (r6 == null) goto L50;
        char r7 = r6.c();
        f r8 = r1.f;
        int r9 = 0;
        boolean r10 = false;
    L14:
        if (r8 == null) goto L27;
        if (r8 == r12) goto L27;
        if (r8 == r0.get(Character.valueOf(r3))) goto L27;
        if (r8.d == false) goto L26;
        if (r8.b != r7) goto L26;
        r9 = r6.d(r8, r1);
        if (r9 > 0) goto L24;
        r10 = true;
        goto L26
    L24:
        boolean r11 = true;
        r10 = true;
    L28:
        if (r11 == false) goto L29;
        int r13 = 0;
    L35:
        if (r13 >= r9) goto L37;
        List<b0> r14 = r8.a;
        ((b0) ListProtector.remove(r14, r14.size() - 1)).p();
        r13 = r13 + 1;
        goto L35
    L37:
        int r15 = 0;
    L38:
        if (r15 >= r9) goto L40;
        ((b0) ListProtector.remove(r1.a, 0)).p();
        r15 = r15 + 1;
        goto L38
    L40:
        f r16 = r1.f;
    L41:
        if (r16 == null) goto L45;
        if (r16 == r8) goto L45;
        f r17 = r16.f;
        h(r16);
        r16 = r17;
    L45:
        if (r8.c() != 0) goto L48;
        h(r8);
    L48:
        if (r1.c() != 0) goto L7;
        f r18 = r1.g;
        h(r1);
        r1 = r18;
        goto L7
    L29:
        if (r10 == true) goto L33;
        r0.put(Character.valueOf(r3), r1.f);
        if (r1.d == true) goto L33;
        h(r1);
    L33:
        r1 = r1.g;
    L26:
        r8 = r8.f;
    L27:
        r11 = false;
    L50:
        r1 = r1.g;
    L51:
        f r19 = this.i;
        if (r19 == null) goto L55;
        if (r19 == r12) goto L84;
        h(r19);
        goto L51
    L84:
        return;
    }

    public final void h(f r3) {
        f r0 = r3.f;
        if (r0 == null) goto L5;
        r0.g = r3.g;
    L5:
        f r4 = r3.g;
        if (r4 != null) goto L8;
        this.i = r0;
        return;
    L8:
        r4.f = r0;
    }

    public static void b(Iterable<z7b.a> r6, Map<Character, z7b.a> r7) {
        Iterator<z7b.a> r8 = r6.iterator();
    L4:
        if (r8.hasNext() == false) goto L18;
        z7b.a r0 = r8.next();
        char r1 = r0.c();
        char r2 = r0.b();
        if (r1 == r2) goto L7;
        a(r1, r0, r7);
        a(r2, r0, r7);
        goto L4
    L7:
        HashMap r3 = (HashMap) r7;
        z7b.a r4 = (z7b.a) r3.get(Character.valueOf(r1));
        if (r4 == null) goto L16;
        if (r4.c() != r4.b()) goto L16;
        if ((r4 instanceof s) == false) goto L14;
        s r5 = (s) r4;
    L15:
        r5.e(r0);
        r3.put(Character.valueOf(r1), r5);
        goto L4
    L14:
        s r9 = new s(r1);
        r9.e(r4);
        r5 = r9;
    L16:
        a(r1, r0, r7);
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(w7b.g r17, v7b.a r18) {
        this.f = new x7b.e(r17.a);
        this.g = !((ArrayList) r17.b()).isEmpty();
        this.h = 0;
        String r4 = null;
        this.i = null;
        this.j = null;
        HashMap r5 = new HashMap();
        Iterator r6 = ((ArrayList) this.b).iterator();
    L4:
        if (r6.hasNext() == false) goto L12;
        x7b.b r7 = (x7b.b) r6.next();
        x7b.a r8 = r7.create();
        Iterator<Character> r9 = r7.a().iterator();
    L7:
        if (r9.hasNext() == false) goto L4;
        Character r10 = r9.next();
        if (r5.containsKey(r10) == true) goto L11;
        r5.put(r10, new ArrayList());
    L11:
        ((List) r5.get(r10)).add(r8);
        goto L7
    L12:
        this.e = r5;
    L13:
        char r11 = this.f.j();
        if (r11 == 0) goto L249;
        int r12 = 10;
        if (r11 != '\n') goto L18;
        this.f.g();
        if (this.h < 2) goto L247;
        Object r13 = new v7b.h();
    L248:
        Object[] r14 = {r13};
        ArrayList r15 = new ArrayList(1);
        Object r16 = r14[0];
        Objects.requireNonNull(r16);
        r15.add(r16);
        List r19 = Collections.unmodifiableList(r15);
    L250:
        if (r19 == 0) goto L251;
        r4 = null;
        Iterator r20 = r19.iterator();
    L255:
        if (r20.hasNext() == false) goto L13;
        r18.e((v7b.s) r20.next());
        goto L255
    L251:
        g(null);
        c(r18);
        return;
    L247:
        r13 = new w();
        goto L248
    L18:
        if (r11 == '!') goto L236;
        if (r11 != '[') goto L21;
        x7b.d r21 = this.f.k();
        this.f.g();
        x7b.d r22 = this.f.k();
        b0 r23 = i(this.f.c(r21, r22));
        e r110 = this.j;
        e r111 = new e(r23, r21, r22, r110, this.i, false);
        if (r110 == null) goto L235;
        r110.h = true;
    L235:
        this.j = r111;
        Object[] r24 = {r23};
        ArrayList r25 = new ArrayList(1);
        Object r26 = r24[0];
        Objects.requireNonNull(r26);
        r25.add(r26);
        r19 = Collections.unmodifiableList(r25);
        goto L250
    L21:
        if (r11 != ']') goto L23;
        x7b.d r27 = this.f.k();
        this.f.g();
        x7b.d r28 = this.f.k();
        e r29 = this.j;
        if (r29 != null) goto L145;
        v7b.s r30 = i(this.f.c(r27, r28));
    L231:
        Object[] r31 = {r30};
        ArrayList r32 = new ArrayList(1);
        Object r33 = r31[0];
        Objects.requireNonNull(r33);
        r32.add(r33);
        r19 = Collections.unmodifiableList(r32);
        goto L250
    L145:
        if (r29.g == true) goto L148;
        this.j = r29.e;
        r30 = i(this.f.c(r27, r28));
        goto L231
    L148:
        if (this.f.h('(') == false) goto L186;
        this.f.m();
        x7b.e r112 = this.f;
        char r113 = r112.j();
        x7b.d r114 = r112.k();
        if (u7b.c.b(r112) == true) goto L153;
        String r115 = r4;
    L157:
        if (r115 != null) goto L160;
        this.f.l(r28);
    L187:
        if (r115 != null) goto L212;
        x7b.e r116 = this.f;
        if (r116.h('[') == false) goto L199;
        x7b.d r34 = r116.k();
        if (u7b.c.c(r116) == false) goto L199;
        x7b.d r117 = r116.k();
        if (r116.h(']') == false) goto L199;
        String r35 = r116.c(r34, r117).a();
        if (r35.length() > 999) goto L199;
    L200:
        if (r35 != null) goto L202;
        this.f.l(r28);
    L202:
        if (r35 == null) goto L206;
        if (r35.isEmpty() == true) goto L206;
    L208:
        if (r35 == null) goto L212;
        o r36 = ((m) this.a).c;
        r36.getClass();
        v7b.o r37 = (v7b.o) ((LinkedHashMap) r36.a).get(u7b.a.a(r35));
        if (r37 == null) goto L212;
        r115 = r37.k;
        r4 = r37.l;
    L206:
        if (r29.h == true) goto L208;
        r35 = this.f.c(r29.c, r27).a();
    L199:
        r35 = null;
    L212:
        if (r115 != null) goto L214;
        this.j = this.j.e;
        this.f.l(r28);
        r30 = i(this.f.c(r27, r28));
        goto L231
    L214:
        if (r29.d == false) goto L216;
        r30 = new v7b.l(r115, r4);
    L217:
        v7b.s r38 = r29.a.h;
    L218:
        if (r38 == null) goto L221;
        v7b.s r39 = r38.h;
        r30.e(r38);
        r38 = r39;
        goto L218
    L221:
        if (this.g == false) goto L223;
        x7b.e r40 = this.f;
        r30.n(r40.c(r29.b, r40.k()).b());
    L223:
        g(r29.f);
        c(r30);
        r29.a.p();
        e r41 = this.j.e;
        this.j = r41;
        if (r29.d == true) goto L231;
    L225:
        if (r41 == null) goto L231;
        if (r41.d == true) goto L229;
        r41.g = false;
    L229:
        r41 = r41.e;
        goto L225
    L216:
        r30 = new v7b.n(r115, r4);
        goto L217
    L160:
        if (this.f.m() < 1) goto L182;
        x7b.e r118 = this.f;
        x7b.d r119 = r118.k();
        if (r118.d() == false) goto L176;
        char r120 = r118.j();
        char r42 = '\"';
        if (r120 == '\"') goto L171;
        r42 = '\'';
        if (r120 == '\'') goto L171;
        if (r120 != '(') goto L176;
        r42 = ')';
    L171:
        r118.g();
        if (u7b.c.d(r118, r42) == false) goto L176;
        if (r118.d() == false) goto L176;
        r118.g();
        boolean r43 = true;
    L178:
        if (r43 == true) goto L180;
        r4 = null;
    L181:
        this.f.m();
    L184:
        if (this.f.h(')') == true) goto L187;
        this.f.l(r28);
        goto L186
    L180:
        String r44 = r118.c(r119, r118.k()).a();
        r4 = u7b.a.b(r44.substring(1, r44.length() - 1));
    L176:
        r43 = false;
        goto L178
    L182:
        r4 = null;
        goto L184
    L153:
        if (r113 != '<') goto L155;
        String r121 = r112.c(r114, r112.k()).a();
        String r122 = r121.substring(1, r121.length() - 1);
    L156:
        r115 = u7b.a.b(r122);
        goto L157
    L155:
        r122 = r112.c(r114, r112.k()).a();
    L186:
        r4 = null;
        r115 = null;
        goto L187
    L23:
        if (this.d.get(r11) == true) goto L25;
        Object[] r45 = {f()};
        ArrayList r46 = new ArrayList(1);
        Object r47 = r45[0];
        Objects.requireNonNull(r47);
        r46.add(r47);
        r19 = Collections.unmodifiableList(r46);
        goto L250
    L25:
        List r48 = (List) ((HashMap) this.e).get(Character.valueOf(r11));
        if (r48 == null) goto L39;
        x7b.d r49 = this.f.k();
        Iterator r50 = r48.iterator();
    L29:
        if (r50.hasNext() == false) goto L39;
        t7b.h r51 = ((x7b.a) r50.next()).a(this);
        if ((r51 instanceof t7b.h) == true) goto L32;
        this.f.l(r49);
        goto L29
    L32:
        v7b.s r52 = r51.a;
        this.f.l(r51.b);
        if (this.g == true) goto L35;
    L37:
        Object[] r53 = {r52};
        ArrayList r54 = new ArrayList(1);
        Object r55 = r53[0];
        Objects.requireNonNull(r55);
        r54.add(r55);
        r19 = Collections.unmodifiableList(r54);
        goto L250
    L35:
        if (r52.j().isEmpty() == false) goto L37;
        x7b.e r56 = this.f;
        r52.n(r56.c(r49, r56.k()).b());
    L39:
        z7b.a r57 = (z7b.a) ((HashMap) this.c).get(Character.valueOf(r11));
        if (r57 == null) goto L140;
        x7b.e r58 = this.f;
        int r59 = r58.c;
        if (r59 <= 0) goto L50;
        int r60 = r59 - 1;
        char r123 = r58.d.a.charAt(r60);
        boolean r124 = Character.isLowSurrogate(r123);
        int r125 = r123;
        r125 = r123;
        if (r124 == false) goto L53;
        if (r60 <= 0) goto L53;
        char r61 = r58.d.a.charAt(r60 - 1);
        r125 = r123;
        if (Character.isHighSurrogate(r61) == false) goto L53;
        r125 = Character.toCodePoint(r61, r123);
    L53:
        x7b.d r62 = this.f.k();
        if (this.f.f(r11) >= r57.a()) goto L56;
        this.f.l(r62);
        a r63 = r4;
    L133:
        if (r63 != 0) goto L135;
        r19 = r4;
    L138:
        if (r19 == 0) goto L140;
    L135:
        List<b0> r64 = r63.a;
        f r126 = new f(r64, r11, r63.c, r63.b, this.i);
        this.i = r126;
        f r65 = r126.f;
        r19 = r64;
        if (r65 == null) goto L138;
        r65.g = r126;
        r19 = r64;
        goto L138
    L56:
        ArrayList r66 = new ArrayList();
        this.f.l(r62);
    L58:
        if (this.f.h(r11) == false) goto L60;
        x7b.e r127 = this.f;
        r66.add(i(r127.c(r62, r127.k())));
        r62 = this.f.k();
        goto L58
    L60:
        x7b.e r67 = this.f;
        int r128 = r67.c;
        if (r128 >= r67.e) goto L70;
        char r68 = r67.d.a.charAt(r128);
        boolean r129 = Character.isHighSurrogate(r68);
        r12 = r68;
        if (r129 == false) goto L73;
        int r130 = r67.c + 1;
        r12 = r68;
        if (r130 >= r67.e) goto L73;
        char r69 = r67.d.a.charAt(r130);
        r12 = r68;
        if (Character.isLowSurrogate(r69) == false) goto L73;
        r12 = Character.toCodePoint(r68, r69);
    L73:
        if (r125 != 0) goto L75;
    L78:
        boolean r70 = true;
    L79:
        if (r125 != 0) goto L81;
    L84:
        boolean r131 = true;
    L85:
        if (r12 != 0) goto L87;
    L90:
        boolean r132 = true;
    L91:
        if (r12 != 0) goto L93;
    L96:
        boolean r71 = true;
    L97:
        if (r71 == true) goto L102;
        if (r132 == false) goto L101;
        if (r131 == true) goto L101;
        if (r70 == false) goto L102;
    L101:
        boolean r133 = true;
    L103:
        if (r131 == true) goto L108;
        if (r70 == false) goto L107;
        if (r71 == true) goto L107;
        if (r132 == false) goto L108;
    L107:
        boolean r72 = true;
    L110:
        if (r11 != '_') goto L121;
        if (r133 == false) goto L115;
        if (r72 == false) goto L114;
        if (r70 == false) goto L115;
    L114:
        boolean r73 = true;
    L116:
        if (r72 == false) goto L120;
        if (r133 == false) goto L119;
        if (r132 == false) goto L120;
    L119:
        boolean r74 = true;
    L132:
        r63 = new a(r66, r73, r74);
    L120:
        r74 = false;
    L115:
        r73 = false;
        goto L116
    L121:
        if (r133 == true) goto L123;
    L125:
        boolean r75 = false;
    L126:
        if (r72 == true) goto L128;
    L130:
        r74 = false;
    L131:
        r73 = r75;
        goto L132
    L128:
        if (r11 != r57.b()) goto L130;
        r74 = true;
        goto L131
    L123:
        if (r11 != r57.c()) goto L125;
        r75 = true;
    L108:
        r72 = false;
    L102:
        r133 = false;
        goto L103
    L93:
        if (a8b.b.b(r12) == true) goto L96;
        r71 = false;
        goto L97
    L87:
        if (a8b.b.a(r12) == true) goto L90;
        r132 = false;
        goto L91
    L81:
        if (a8b.b.b(r125) == true) goto L84;
        r131 = false;
        goto L85
    L75:
        if (a8b.b.a(r125) == true) goto L78;
        r70 = false;
        goto L79
    L70:
        if (r67.b < (r67.a.size() - 1)) goto L73;
        r12 = 0;
        goto L73
    L50:
        if (r58.b <= 0) goto L52;
        r125 = 10;
        goto L53
    L52:
        r125 = 0;
    L140:
        Object[] r76 = {f()};
        ArrayList r77 = new ArrayList(1);
        Object r78 = r76[0];
        Objects.requireNonNull(r78);
        r77.add(r78);
        r19 = Collections.unmodifiableList(r77);
        goto L250
    L236:
        x7b.d r134 = this.f.k();
        this.f.g();
        if (this.f.h('[') == false) goto L242;
        x7b.d r135 = this.f.k();
        b0 r79 = i(this.f.c(r134, r135));
        e r80 = this.j;
        e r81 = new e(r79, r134, r135, r80, this.i, true);
        if (r80 == null) goto L241;
        r80.h = true;
    L241:
        this.j = r81;
    L243:
        Object[] r82 = {r79};
        ArrayList r83 = new ArrayList(1);
        Object r84 = r82[0];
        Objects.requireNonNull(r84);
        r83.add(r84);
        r19 = Collections.unmodifiableList(r83);
        goto L250
    L242:
        x7b.e r85 = this.f;
        r79 = i(r85.c(r134, r85.k()));
        goto L243
    L249:
        r19 = 0;
        goto L250
    }

    public static void a(char r1, z7b.a r2, Map<Character, z7b.a> r3) {
        if (((z7b.a) ((HashMap) r3).put(Character.valueOf(r1), r2)) != null) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Delimiter processor conflict with delimiter char '" + r1 + "'");
    }

    public final void d(b0 r4, b0 r5, int r6) {
        if (r4 == null) goto L26;
        if (r5 == null) goto L27;
        if (r4 == r5) goto L28;
        StringBuilder r0 = new StringBuilder(r6);
        r0.append(r4.j);
        if (this.g == false) goto L8;
        y r7 = new y();
        r7.a(r4.j());
    L9:
        v7b.s r1 = r4.h;
        v7b.s r8 = r5.h;
    L10:
        if (r1 == r8) goto L15;
        r0.append(((b0) r1).j);
        if (r7 == null) goto L14;
        r7.a(r1.j());
    L14:
        v7b.s r2 = r1.h;
        r1.p();
        r1 = r2;
        goto L10
    L15:
        r4.j = r0.toString();
        if (r7 == null) goto L29;
        List<x> r9 = r7.a;
        if (r9 != null) goto L21;
        r9 = Collections.emptyList();
    L21:
        r4.n(r9);
        return;
    L29:
        return;
    L8:
        r7 = null;
        goto L9
    L28:
        return;
    L27:
        return;
    }
}
