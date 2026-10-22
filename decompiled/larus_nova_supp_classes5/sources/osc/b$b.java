package osc;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.internal.h;
import org.commonmark.internal.p;
import org.commonmark.node.Block;
import org.commonmark.node.BulletList;
import org.commonmark.node.ListBlock;
import org.commonmark.node.OrderedList;
import wvc.b;
import wvc.d;
import wvc.f;
import wvc.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b$b extends b {
    public b$b() {
    }

    @Override // wvc.e
    public final f a(g r17, h.a r18) {
        Intrinsics.checkNotNullParameter(r17, "state");
        Intrinsics.checkNotNullParameter(r18, "matchedBlockParser");
        d r2 = r18.a;
        h r0 = (h) r17;
        int r3 = r0.e;
        int r4 = r0.c + r0.g;
        if (r18.a() == null) goto L5;
        boolean r1 = true;
    L6:
        int r7 = b.e;
        CharSequence r8 = r0.a;
        int r9 = r0.g;
        char r10 = r8.charAt(r3);
        if (r10 != '-') goto L10;
    L11:
        boolean r11 = true;
    L13:
        if (r11 == false) goto L16;
    L17:
        boolean r12 = true;
    L20:
        if (r12 == false) goto L24;
        int r13 = r3 + 1;
        if (b.a.a(r8, r13) == false) goto L98;
        BulletList r14 = new BulletList();
        r14.i = r10;
        a.b(r14, r9);
        b.d r15 = new b.d(r14, r13);
    L99:
        if (r15 == null) goto L115;
        ListBlock r16 = r15.a;
        int r19 = r15.b;
        int r5 = r4 + (r19 - r3);
        int r6 = r8.length();
        int r110 = r5;
    L103:
        if (r19 >= r6) goto L112;
        char r111 = r8.charAt(r19);
        if (r111 != '\t') goto L108;
        r110 = r110 + (4 - (r110 % 4));
    L110:
        r19 = r19 + 1;
        goto L103
    L108:
        if (r111 != ' ') goto L111;
        r110 = r110 + 1;
        goto L110
    L111:
        boolean r20 = true;
    L113:
        if (r1 == false) goto L116;
        if (r20 == false) goto L115;
    L116:
        if (r20 == true) goto L118;
    L119:
        r110 = r5 + 1;
    L120:
        b.c r21 = new b.c(r16, r110);
    L121:
        if (r21 != null) goto L123;
        return null;
    L123:
        int r22 = r21.b;
        d r23 = new p(r22 - r0.c);
        if ((r2 instanceof b) == false) goto L147;
        int r24 = b.e;
        Block r25 = r2.a();
        Intrinsics.checkNotNull(r25, "null cannot be cast to non-null type org.commonmark.node.ListBlock");
        ListBlock r26 = (ListBlock) r25;
        ListBlock r27 = r21.a;
        if ((r26 instanceof BulletList) == false) goto L135;
        if ((r27 instanceof BulletList) == false) goto L135;
        Character r28 = Character.valueOf(((BulletList) r26).i);
        Character r29 = Character.valueOf(((BulletList) r27).i);
        if (r28 != null) goto L133;
        if (r29 != null) goto L143;
    L132:
        boolean r30 = true;
    L144:
        if (r30 == false) goto L147;
        org.commonmark.internal.d r31 = new org.commonmark.internal.d(new d[]{r23});
        r31.c = r22;
        return r31;
    L143:
        r30 = false;
        goto L144
    L133:
        r30 = Intrinsics.areEqual(r28, r29);
    L135:
        if ((r26 instanceof OrderedList) == false) goto L143;
        if ((r27 instanceof OrderedList) == false) goto L143;
        Character r32 = Character.valueOf(((OrderedList) r26).k);
        Character r33 = Character.valueOf(((OrderedList) r27).k);
        if (r32 != null) goto L142;
        if (r33 != null) goto L143;
    L142:
        r30 = Intrinsics.areEqual(r32, r33);
    L147:
        d r34 = new b(r21.a);
        r21.a.h = true;
        org.commonmark.internal.d r35 = new org.commonmark.internal.d(new d[]{r34, r23});
        r35.c = r22;
        return r35;
    L118:
        if ((r110 - r5) <= 4) goto L120;
    L112:
        r20 = false;
    L115:
        r21 = null;
    L98:
        r15 = null;
        goto L99
    L24:
        int r36 = r8.length();
        int r112 = r3;
        int r113 = 0;
    L25:
        if (r112 >= r36) goto L98;
        char r114 = r8.charAt(r112);
        if (r114 != '0') goto L30;
    L31:
        boolean r115 = true;
    L33:
        if (r115 == false) goto L36;
    L37:
        boolean r116 = true;
    L39:
        if (r116 == false) goto L42;
    L43:
        boolean r117 = true;
    L45:
        if (r117 == false) goto L48;
    L49:
        boolean r118 = true;
    L51:
        if (r118 == false) goto L54;
    L55:
        boolean r119 = true;
    L57:
        if (r119 == false) goto L60;
    L61:
        boolean r120 = true;
    L63:
        if (r120 == false) goto L66;
    L67:
        boolean r121 = true;
    L69:
        if (r121 == false) goto L72;
    L73:
        boolean r122 = true;
    L75:
        if (r122 == false) goto L78;
    L79:
        boolean r123 = true;
    L81:
        if (r123 == false) goto L87;
        r113 = r113 + 1;
        if (r113 > 9) goto L98;
        r112 = r112 + 1;
        goto L25
    L87:
        if (r114 != '.') goto L90;
    L91:
        boolean r37 = true;
    L93:
        if (r37 == false) goto L98;
        if (r113 < 1) goto L98;
        int r38 = r112 + 1;
        if (b.a.a(r8, r38) == false) goto L98;
        String r124 = r8.subSequence(r3, r112).toString();
        OrderedList r125 = new OrderedList();
        r125.i = CastIntegerProtector.parseInt(r124);
        r125.k = r114;
        a.b(r125, r9);
        r15 = new b.d(r125, r38);
        goto L99
    L90:
        if (r114 == ')') goto L91;
        r37 = false;
        goto L93
    L78:
        if (r114 == '9') goto L79;
        r123 = false;
        goto L81
    L72:
        if (r114 == '8') goto L73;
        r122 = false;
        goto L75
    L66:
        if (r114 == '7') goto L67;
        r121 = false;
        goto L69
    L60:
        if (r114 == '6') goto L61;
        r120 = false;
        goto L63
    L54:
        if (r114 == '5') goto L55;
        r119 = false;
        goto L57
    L48:
        if (r114 == '4') goto L49;
        r118 = false;
        goto L51
    L42:
        if (r114 == '3') goto L43;
        r117 = false;
        goto L45
    L36:
        if (r114 == '2') goto L37;
        r116 = false;
        goto L39
    L30:
        if (r114 == '1') goto L31;
        r115 = false;
        goto L33
    L16:
        if (r10 == '*') goto L17;
        r12 = false;
        goto L20
    L10:
        if (r10 == '+') goto L11;
        r11 = false;
        goto L13
    L5:
        r1 = false;
        goto L6
    }
}
