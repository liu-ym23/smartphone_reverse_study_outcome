package rbb;

import android.text.TextUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class b {
    public static int g() {
        boolean r0 = mbb.c.a;
        return kac.a.b(2131254694);
    }

    public static int b(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return 2131108712;
    L5:
        String[] r0 = e.a;
        int r2 = r0.length;
        int r3 = 0;
        int r4 = 0;
    L6:
        if (r4 >= r2) goto L12;
        if (TextUtils.equals(r0[r4], r10) == true) goto L9;
        r4 = r4 + 1;
        goto L6
    L9:
        return 2131108869;
    L12:
        String[] r1 = e.b;
        int r5 = r1.length;
        int r6 = 0;
    L14:
        if (r6 >= r5) goto L22;
        if (TextUtils.equals(r1[r6], r10) == true) goto L18;
        r6 = r6 + 1;
        goto L14
    L18:
        if (kac.a.a() == false) goto L20;
        return 2131108852;
    L20:
        return 2131108618;
    L22:
        String[] r7 = e.c;
        int r8 = r7.length;
        int r9 = 0;
    L24:
        if (r9 >= r8) goto L33;
        if (TextUtils.equals(r7[r9], r10) == true) goto L28;
        r9 = r9 + 1;
        goto L24
    L28:
        if (kac.a.a() == false) goto L30;
        return 2131108852;
    L30:
        return 2131108655;
    L33:
        if (TextUtils.equals("pdf", r10) == false) goto L36;
        return 2131108784;
    L36:
        String[] r11 = e.d;
        int r12 = r11.length;
        int r13 = 0;
    L37:
        if (r13 >= r12) goto L42;
        if (TextUtils.equals(r11[r13], r10) == true) goto L40;
        r13 = r13 + 1;
        goto L37
    L40:
        return 2131108618;
    L42:
        String[] r14 = e.e;
        int r15 = r14.length;
        int r16 = 0;
    L43:
        if (r16 >= r15) goto L51;
        if (TextUtils.equals(r14[r16], r10) == true) goto L47;
        r16 = r16 + 1;
        goto L43
    L47:
        if (kac.a.a() == false) goto L49;
        return 2131108655;
    L49:
        return 2131108618;
    L51:
        String[] r17 = e.f;
        int r18 = r17.length;
        int r19 = 0;
    L52:
        if (r19 >= r18) goto L57;
        if (TextUtils.equals(r17[r19], r10) == true) goto L55;
        r19 = r19 + 1;
        goto L52
    L55:
        return 2131108618;
    L57:
        String[] r20 = e.g;
        int r21 = r20.length;
        int r22 = 0;
    L58:
        if (r22 >= r21) goto L63;
        if (TextUtils.equals(r20[r22], r10) == true) goto L61;
        r22 = r22 + 1;
        goto L58
    L61:
        return 2131108655;
    L63:
        String[] r23 = e.h;
        int r24 = r23.length;
        int r25 = 0;
    L65:
        if (r25 >= r24) goto L71;
        if (TextUtils.equals(r23[r25], r10) == true) goto L68;
        r25 = r25 + 1;
        goto L65
    L68:
        return 2131108755;
    L71:
        if (TextUtils.equals("pages", r10) == false) goto L74;
        return 2131108755;
    L74:
        if (TextUtils.equals("numbers", r10) == false) goto L76;
        return 2131108655;
    L76:
        String[] r26 = e.i;
        int r27 = r26.length;
        int r28 = 0;
    L77:
        if (r28 >= r27) goto L82;
        if (TextUtils.equals(r26[r28], r10) == true) goto L80;
        r28 = r28 + 1;
        goto L77
    L80:
        return 2131108618;
    L82:
        String[] r29 = e.j;
        int r30 = r29.length;
        int r31 = 0;
    L83:
        if (r31 >= r30) goto L91;
        if (TextUtils.equals(r29[r31], r10) == true) goto L87;
        r31 = r31 + 1;
        goto L83
    L87:
        if (kac.a.a() == false) goto L89;
        return 2131108852;
    L89:
        return 2131108618;
    L91:
        String[] r32 = e.k;
        int r33 = r32.length;
        int r34 = 0;
    L92:
        if (r34 >= r33) goto L97;
        if (TextUtils.equals(r32[r34], r10) == true) goto L95;
        r34 = r34 + 1;
        goto L92
    L95:
        return 2131108618;
    L97:
        String[] r35 = e.l;
        int r36 = r35.length;
    L98:
        if (r3 >= r36) goto L104;
        if (TextUtils.equals(r35[r3], r10) == true) goto L101;
        r3 = r3 + 1;
        goto L98
    L101:
        return 2131108618;
    L104:
        if (TextUtils.equals("ipa", r10) == false) goto L107;
        return 2131108618;
    L107:
        if (TextUtils.equals("apk", r10) == false) goto L110;
        return 2131108655;
    L110:
        if (TextUtils.equals("aep", r10) == false) goto L114;
        return 2131108767;
    L114:
        if (TextUtils.equals("ai", r10) == false) goto L117;
        return 2131108755;
    L117:
        if (TextUtils.equals("sketch", r10) == false) goto L120;
        return 2131108755;
    L120:
        if (TextUtils.equals("csv", r10) == false) goto L123;
        return 2131108655;
    L123:
        if (TextUtils.equals("eml", r10) == false) goto L126;
        return 2131108618;
    L126:
        if (TextUtils.equals("msg", r10) == false) goto L128;
        return 2131108618;
    L128:
        return 2131108712;
    }

    public static int d(int r1) {
        if (r1 != sbb.e.g.b) goto L7;
        return kac.a.b(2131256227);
    L7:
        if (r1 != sbb.e.h.b) goto L11;
        return kac.a.b(2131256254);
    L11:
        if (r1 != sbb.e.i.b) goto L15;
        return kac.a.b(2131254753);
    L15:
        if (r1 != sbb.e.k.b) goto L19;
        return 2131256241;
    L19:
        if (r1 != sbb.e.m.b) goto L23;
        return kac.a.b(2131254534);
    L23:
        if (r1 != sbb.e.o.b) goto L27;
        return kac.a.b(2131254503);
    L27:
        if (r1 == sbb.e.t.b) goto L34;
        if (r1 == sbb.e.u.b) goto L34;
        return kac.a.b(2131254539);
    L34:
        return kac.a.b(2131254517);
    }

    public static int e(String r6) {
        if (r6 == null) goto L4;
        r6 = r6.toLowerCase();
    L4:
        mbb.f r0 = mbb.c.b;
        if (r0 == null) goto L9;
        Integer r1 = r0.a(r6);
        if (r1 == null) goto L9;
        Integer r2 = Integer.valueOf(kac.a.b(r1.intValue()));
    L10:
        if (r2 != null) goto L12;
    L15:
        String[] r3 = e.a;
        int r4 = r3.length;
        int r5 = 0;
        int r7 = 0;
    L16:
        if (r7 >= r4) goto L22;
        if (TextUtils.equals(r3[r7], r6) == true) goto L20;
        r7 = r7 + 1;
        goto L16
    L20:
        return kac.a.b(2131254464);
    L22:
        String[] r8 = e.b;
        int r9 = r8.length;
        int r10 = 0;
    L23:
        if (r10 >= r9) goto L29;
        if (TextUtils.equals(r8[r10], r6) == true) goto L27;
        r10 = r10 + 1;
        goto L23
    L27:
        return kac.a.b(2131254735);
    L29:
        String[] r11 = e.c;
        int r12 = r11.length;
        int r13 = 0;
    L30:
        if (r13 >= r12) goto L37;
        if (TextUtils.equals(r11[r13], r6) == true) goto L34;
        r13 = r13 + 1;
        goto L30
    L34:
        return kac.a.b(2131254394);
    L37:
        if (TextUtils.equals("pdf", r6) == true) goto L39;
        String[] r14 = e.d;
        int r15 = r14.length;
        int r16 = 0;
    L41:
        if (r16 >= r15) goto L47;
        if (TextUtils.equals(r14[r16], r6) == true) goto L45;
        r16 = r16 + 1;
        goto L41
    L45:
        return kac.a.b(2131254717);
    L47:
        String[] r17 = e.e;
        int r18 = r17.length;
        int r19 = 0;
    L49:
        if (r19 >= r18) goto L55;
        if (TextUtils.equals(r17[r19], r6) == true) goto L53;
        r19 = r19 + 1;
        goto L49
    L53:
        return kac.a.b(2131254415);
    L55:
        String[] r20 = e.f;
        int r21 = r20.length;
        int r22 = 0;
    L56:
        if (r22 >= r21) goto L62;
        if (TextUtils.equals(r20[r22], r6) == true) goto L60;
        r22 = r22 + 1;
        goto L56
    L60:
        return kac.a.b(2131254746);
    L62:
        String[] r23 = e.g;
        int r24 = r23.length;
        int r25 = 0;
    L63:
        if (r25 >= r24) goto L69;
        if (TextUtils.equals(r23[r25], r6) == true) goto L67;
        r25 = r25 + 1;
        goto L63
    L67:
        return kac.a.b(2131254443);
    L69:
        String[] r26 = e.h;
        int r27 = r26.length;
        int r28 = 0;
    L70:
        if (r28 >= r27) goto L77;
        if (TextUtils.equals(r26[r28], r6) == true) goto L74;
        r28 = r28 + 1;
        goto L70
    L74:
        return kac.a.b(2131254599);
    L77:
        if (TextUtils.equals("pages", r6) == false) goto L81;
        return kac.a.b(2131254588);
    L81:
        if (TextUtils.equals("numbers", r6) == true) goto L83;
        String[] r29 = e.i;
        int r30 = r29.length;
        int r31 = 0;
    L85:
        if (r31 >= r30) goto L91;
        if (TextUtils.equals(r29[r31], r6) == true) goto L89;
        r31 = r31 + 1;
        goto L85
    L89:
        return kac.a.b(2131254474);
    L91:
        String[] r32 = e.j;
        int r33 = r32.length;
        int r34 = 0;
    L92:
        if (r34 >= r33) goto L98;
        if (TextUtils.equals(r32[r34], r6) == true) goto L96;
        r34 = r34 + 1;
        goto L92
    L96:
        return kac.a.b(2131254749);
    L98:
        String[] r35 = e.k;
        int r36 = r35.length;
        int r37 = 0;
    L99:
        if (r37 >= r36) goto L107;
        if (TextUtils.equals(r35[r37], r6) == true) goto L103;
        r37 = r37 + 1;
        goto L99
    L103:
        if (kac.a.a() == false) goto L172;
        return 2131254555;
    L172:
        return 2131254415;
    L107:
        String[] r38 = e.l;
        int r39 = r38.length;
    L108:
        if (r5 >= r39) goto L115;
        if (TextUtils.equals(r38[r5], r6) == true) goto L112;
        r5 = r5 + 1;
        goto L108
    L112:
        return kac.a.b(2131254603);
    L115:
        if (TextUtils.equals("ipa", r6) == false) goto L119;
        return kac.a.b(2131254467);
    L119:
        if (TextUtils.equals("apk", r6) == false) goto L123;
        return kac.a.b(2131254387);
    L123:
        if (TextUtils.equals("aep", r6) == false) goto L127;
        return kac.a.b(2131254375);
    L127:
        if (TextUtils.equals("ai", r6) == false) goto L131;
        return kac.a.b(2131254381);
    L131:
        if (TextUtils.equals("sketch", r6) == false) goto L135;
        return kac.a.b(2131254701);
    L135:
        if (TextUtils.equals("csv", r6) == false) goto L139;
        return kac.a.b(2131254423);
    L139:
        if (TextUtils.equals("eml", r6) == false) goto L143;
        return kac.a.b(2131254437);
    L143:
        if (TextUtils.equals("msg", r6) == false) goto L147;
        return kac.a.b(2131254566);
    L147:
        return kac.a.b(2131256243);
    L83:
        return kac.a.b(2131254581);
    L39:
        return kac.a.b(2131254594);
    L12:
        if (r2.intValue() == 0) goto L15;
        return r2.intValue();
    L9:
        r2 = null;
        goto L10
    }

    public static int f(String r6) {
        if (r6 == null) goto L4;
        r6 = r6.toLowerCase();
    L4:
        mbb.g r0 = mbb.c.c;
        if (r0 == null) goto L9;
        Integer r1 = r0.a(r6);
        if (r1 == null) goto L9;
        Integer r2 = Integer.valueOf(kac.a.b(r1.intValue()));
    L10:
        if (r2 != null) goto L12;
    L15:
        String[] r3 = e.a;
        int r4 = r3.length;
        int r5 = 0;
        int r7 = 0;
    L16:
        if (r7 >= r4) goto L22;
        if (TextUtils.equals(r3[r7], r6) == true) goto L20;
        r7 = r7 + 1;
        goto L16
    L20:
        return kac.a.b(2131254509);
    L22:
        String[] r8 = e.b;
        int r9 = r8.length;
        int r10 = 0;
    L23:
        if (r10 >= r9) goto L29;
        if (TextUtils.equals(r8[r10], r6) == true) goto L27;
        r10 = r10 + 1;
        goto L23
    L27:
        return kac.a.b(2131254543);
    L29:
        String[] r11 = e.c;
        int r12 = r11.length;
        int r13 = 0;
    L30:
        if (r13 >= r12) goto L37;
        if (TextUtils.equals(r11[r13], r6) == true) goto L34;
        r13 = r13 + 1;
        goto L30
    L34:
        return kac.a.b(2131254487);
    L37:
        if (TextUtils.equals("pdf", r6) == true) goto L39;
        String[] r14 = e.d;
        int r15 = r14.length;
        int r16 = 0;
    L41:
        if (r16 >= r15) goto L47;
        if (TextUtils.equals(r14[r16], r6) == true) goto L45;
        r16 = r16 + 1;
        goto L41
    L45:
        return kac.a.b(2131254536);
    L47:
        String[] r17 = e.e;
        int r18 = r17.length;
        int r19 = 0;
    L49:
        if (r19 >= r18) goto L55;
        if (TextUtils.equals(r17[r19], r6) == true) goto L53;
        r19 = r19 + 1;
        goto L49
    L53:
        return kac.a.b(2131254416);
    L55:
        String[] r20 = e.f;
        int r21 = r20.length;
        int r22 = 0;
    L56:
        if (r22 >= r21) goto L62;
        if (TextUtils.equals(r20[r22], r6) == true) goto L60;
        r22 = r22 + 1;
        goto L56
    L60:
        return kac.a.b(2131254548);
    L62:
        String[] r23 = e.g;
        int r24 = r23.length;
        int r25 = 0;
    L63:
        if (r25 >= r24) goto L69;
        if (TextUtils.equals(r23[r25], r6) == true) goto L67;
        r25 = r25 + 1;
        goto L63
    L67:
        return kac.a.b(2131254505);
    L69:
        String[] r26 = e.h;
        int r27 = r26.length;
        int r28 = 0;
    L70:
        if (r28 >= r27) goto L77;
        if (TextUtils.equals(r26[r28], r6) == true) goto L74;
        r28 = r28 + 1;
        goto L70
    L74:
        return kac.a.b(2131254524);
    L77:
        if (TextUtils.equals("pages", r6) == false) goto L81;
        return kac.a.b(2131254589);
    L81:
        if (TextUtils.equals("numbers", r6) == true) goto L83;
        String[] r29 = e.i;
        int r30 = r29.length;
        int r31 = 0;
    L85:
        if (r31 >= r30) goto L91;
        if (TextUtils.equals(r29[r31], r6) == true) goto L89;
        r31 = r31 + 1;
        goto L85
    L89:
        return kac.a.b(2131254475);
    L91:
        String[] r32 = e.j;
        int r33 = r32.length;
        int r34 = 0;
    L92:
        if (r34 >= r33) goto L98;
        if (TextUtils.equals(r32[r34], r6) == true) goto L96;
        r34 = r34 + 1;
        goto L92
    L96:
        return kac.a.b(2131254552);
    L98:
        String[] r35 = e.k;
        int r36 = r35.length;
        int r37 = 0;
    L99:
        if (r37 >= r36) goto L107;
        if (TextUtils.equals(r35[r37], r6) == true) goto L103;
        r37 = r37 + 1;
        goto L99
    L103:
        if (kac.a.a() == false) goto L172;
        return 2131254556;
    L172:
        return 2131254416;
    L107:
        String[] r38 = e.l;
        int r39 = r38.length;
    L108:
        if (r5 >= r39) goto L115;
        if (TextUtils.equals(r38[r5], r6) == true) goto L112;
        r5 = r5 + 1;
        goto L108
    L112:
        return kac.a.b(2131254604);
    L115:
        if (TextUtils.equals("ipa", r6) == false) goto L119;
        return kac.a.b(2131254468);
    L119:
        if (TextUtils.equals("apk", r6) == false) goto L123;
        return kac.a.b(2131254388);
    L123:
        if (TextUtils.equals("aep", r6) == false) goto L127;
        return kac.a.b(2131254376);
    L127:
        if (TextUtils.equals("ai", r6) == false) goto L131;
        return kac.a.b(2131254382);
    L131:
        if (TextUtils.equals("sketch", r6) == false) goto L135;
        return kac.a.b(2131254702);
    L135:
        if (TextUtils.equals("csv", r6) == false) goto L139;
        return kac.a.b(2131254424);
    L139:
        if (TextUtils.equals("eml", r6) == false) goto L143;
        return kac.a.b(2131254438);
    L143:
        if (TextUtils.equals("msg", r6) == false) goto L147;
        return kac.a.b(2131254567);
    L147:
        return kac.a.b(2131254516);
    L83:
        return kac.a.b(2131254582);
    L39:
        return kac.a.b(2131254521);
    L12:
        if (r2.intValue() == 0) goto L15;
        return r2.intValue();
    L9:
        r2 = null;
        goto L10
    }

    public static int a(int r6, Long r7) {
        if (r6 != sbb.e.g.b) goto L5;
    L38:
        return 2131108618;
    L5:
        if (r6 == sbb.e.o.b) goto L38;
        if (r6 == sbb.e.y.b) goto L38;
        if (r6 != sbb.e.h.b) goto L14;
        return 2131108655;
    L14:
        if (r6 != sbb.e.i.b) goto L20;
        if (kac.a.a() == false) goto L39;
        return 2131108767;
    L39:
        return 2131108712;
    L20:
        if (r6 != sbb.e.k.b) goto L23;
        return 2131108852;
    L23:
        if (r6 != sbb.e.m.b) goto L27;
        return 2131108755;
    L27:
        if (r6 != sbb.e.t.b) goto L35;
        if (r7 != null) goto L30;
    L32:
        return 2131108852;
    L30:
        if (r7.longValue() != 147) goto L32;
        return 2131108618;
    L35:
        if (r6 != sbb.e.u.b) goto L37;
        return 2131108852;
    L37:
        return 2131108712;
    }

    public static int c(int r4, Long r5) {
        mbb.d r0 = mbb.c.d;
        if (r0 == null) goto L7;
        Integer r1 = r0.a(r4, r5);
        if (r1 == null) goto L7;
        Integer r2 = Integer.valueOf(kac.a.b(r1.intValue()));
    L8:
        if (r2 == null) goto L14;
        if (r2.intValue() == 0) goto L14;
        return kac.a.b(r2.intValue());
    L14:
        if (r4 != sbb.e.g.b) goto L18;
        return kac.a.b(2131254431);
    L18:
        if (r4 != sbb.e.h.b) goto L22;
        return kac.a.b(2131256252);
    L22:
        if (r4 != sbb.e.i.b) goto L30;
        if (idb.f.a().isEnable("ccm.bitable.use_new_gradation_logo_enable") == false) goto L27;
        return 2131255049;
    L27:
        return 2131247421;
    L30:
        if (r4 != sbb.e.k.b) goto L34;
        return kac.a.b(2131254561);
    L34:
        if (r4 != sbb.e.m.b) goto L38;
        return kac.a.b(2131256261);
    L38:
        if (r4 != sbb.e.o.b) goto L42;
        return kac.a.b(2131254436);
    L42:
        if (r4 != sbb.e.y.b) goto L46;
        return kac.a.b(2131255874);
    L46:
        if (r4 != sbb.e.t.b) goto L55;
        if (r5 == null) goto L53;
        if (r5.longValue() != 147) goto L53;
        return kac.a.b(2131254740);
    L53:
        return kac.a.b(2131254557);
    L55:
        if (r4 != sbb.e.u.b) goto L59;
        return kac.a.b(2131254557);
    L59:
        return kac.a.b(2131256242);
    L7:
        r2 = null;
        goto L8
    }
}
