package com.lynx.tasm.behavior.shadow.text;

import android.graphics.PointF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AlignmentSpan;
import android.text.style.StyleSpan;
import android.util.SparseArray;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.mapbuffer.ReadableCompactArrayBuffer;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import com.lynx.tasm.fontface.FontFaceManager;
import com.lynx.tasm.utils.DeviceUtils;
import com.lynx.tasm.utils.i;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import y6a.l;
import z6a.j;
import z6a.m;
import z6a.n;
import z6a.q;
import z6a.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d {
    public final LynxContext a;
    public final SparseArray<Object> b;
    public final SparseArray<Object> c;

    public class a {
        public int a;
        public int b;
        public int[] c;
        public String d;
        public com.lynx.tasm.behavior.ui.utils.e e;

        public a() {
            this.c = new int[4];
        }
    }

    public class b implements g.c {
        public final WeakReference<d> a;

        public b(d r2) {
            this.a = new WeakReference(r2);
        }

        @Override // com.lynx.tasm.behavior.shadow.text.g.c
        public final void a(Typeface r1, int r2) {
            d r3 = this.a.get();
        }
    }

    public d(LynxContext r1) {
        this.a = r1;
        this.b = new SparseArray();
        this.c = new SparseArray();
    }

    public final float[] a(int r13) {
        z6a.b r0 = (z6a.b) this.c.get(r13);
        w r14 = (w) this.b.get(r13);
        int r1 = 0;
        if (r0 == null) goto L38;
        if (r14 == null) goto L38;
        ArrayList r2 = new ArrayList();
        HashMap<Integer, n> r3 = r0.c;
        if (r3 != null) goto L9;
    L12:
        Set<Map.Entry<Integer, n>> r4 = null;
    L13:
        if (r4 == null) goto L15;
        Layout r5 = r14.c;
        HashSet r6 = new HashSet();
        Iterator<Map.Entry<Integer, n>> r7 = r4.iterator();
    L18:
        if (r7.hasNext() == false) goto L32;
        Map.Entry<Integer, n> r8 = r7.next();
        n r9 = r8.getValue();
        if (r9.i >= r5.getText().length()) goto L25;
        int r10 = r5.getLineForOffset(r9.i);
        float r11 = r5.getPrimaryHorizontal(r9.i) + r14.e.x;
        if (r5.isRtlCharAt(r9.i) == false) goto L24;
        r11 = r11 - r9.g;
    L24:
        float r12 = r9.b(r5.getLineTop(r10), r5.getLineBottom(r10), r5.getLineAscent(r10), r5.getLineDescent(r10)) + r14.e.y;
    L27:
        if (r9.i < r5.getText().length()) goto L29;
    L30:
        r6.add(r8.getKey());
    L31:
        r2.add(Float.valueOf(r8.getKey().intValue()));
        r2.add(Float.valueOf(r12));
        r2.add(Float.valueOf(r11));
        goto L18
    L29:
        if (r5.getText().charAt(r9.i) == "I".charAt(0)) goto L31;
    L25:
        r11 = 0.0f;
        r12 = 0.0f;
        goto L27
    L32:
        r14.d = r6;
        float[] r15 = new float[r2.size()];
    L34:
        if (r1 >= r2.size()) goto L36;
        r15[r1] = ((Float) ListProtector.get(r2, r1)).floatValue();
        r1 = r1 + 1;
        goto L34
    L36:
        return r15;
    L15:
        return new float[0];
    L9:
        if (r3.isEmpty() == true) goto L12;
        r4 = r0.c.entrySet();
    L38:
        return new float[0];
    }

    public final com.lynx.tasm.behavior.shadow.text.a d(com.lynx.tasm.behavior.shadow.text.a r3) {
        if (r3 != null) goto L5;
        com.lynx.tasm.behavior.shadow.text.a r4 = new com.lynx.tasm.behavior.shadow.text.a();
        r4.n = Math.round(i.b(14.0f, this.a.getScreenMetrics().density));
        return r4;
    L5:
        return r3;
    }

    public final void c(int r36, ReadableCompactArrayBuffer r37) {
        ArrayList r9 = new ArrayList();
        SpannableStringBuilder r10 = new SpannableStringBuilder();
        Iterator<com.lynx.react.bridge.mapbuffer.a.InterfaceC0048a> r11 = r37.iterator();
        HashMap<Integer, n> r12 = new HashMap();
        ArrayList r13 = new ArrayList();
        int r1 = r36;
        float r4 = Math.round(i.b(14.0f, this.a.getScreenMetrics().density));
        int r0 = -1;
        com.lynx.tasm.behavior.shadow.text.a r2 = null;
        int r3 = 0;
        a r15 = null;
        int r16 = 0;
        boolean r17 = true;
        y6a.n r18 = null;
        boolean r19 = false;
        boolean r20 = false;
    L3:
        float r24 = 0.0f;
        if (r11.hasNext() == false) goto L176;
        int r14 = r11.next().a();
        if (r14 == 99) goto L170;
        switch(r14) {
            case 0: goto L75;
            case 1: goto L47;
            case 2: goto L46;
            case 3: goto L44;
            case 4: goto L43;
            case 5: goto L38;
            case 6: goto L34;
            case 7: goto L32;
            case 8: goto L24;
            case 9: goto L23;
            case 10: goto L14;
            case 11: goto L13;
            default: goto L8;
        };
    L8:
        int r8 = r0;
        float r27 = r4;
        SpannableStringBuilder r26 = r10;
        int r110 = r1;
        com.lynx.tasm.behavior.shadow.text.a r5 = r2;
        switch(r14) {
            case 14: goto L123;
            case 15: goto L119;
            case 16: goto L118;
            case 17: goto L110;
            case 18: goto L94;
            case 19: goto L76;
            default: goto L10;
        };
    L10:
        HashMap<Integer, n> r29 = r12;
        ArrayList r30 = r13;
        switch(r14) {
            case 101: goto L166;
            case 102: goto L165;
            case 103: goto L162;
            case 104: goto L159;
            case 105: goto L155;
            case 106: goto L143;
            case 107: goto L127;
            default: goto L12;
        };
    L155:
        double r6 = r11.next().b();
        int r7 = r11.next().a();
        double r111 = r11.next().b();
        int r21 = r11.next().a();
        double r22 = r11.next().b();
        int r112 = r11.next().a();
        int r23 = r8;
        ArrayList r31 = r9;
        double r25 = r11.next().b();
        int r28 = r3;
        int r32 = r11.next().a();
        if (r15 != null) goto L158;
    L157:
        r1 = r36;
        com.lynx.tasm.behavior.shadow.text.a r33 = r5;
    L173:
        r0 = r23;
        r3 = r28;
        r10 = r26;
        r4 = r27;
        r12 = r29;
        r13 = r30;
        r9 = r31;
        r2 = r33;
        goto L3
    L158:
        com.lynx.tasm.behavior.shadow.text.a r34 = r5;
        com.lynx.tasm.behavior.ui.utils.e r113 = new com.lynx.tasm.behavior.ui.utils.e(this.a);
        JavaOnlyArray r35 = new JavaOnlyArray();
        r35.pushDouble(r6);
        r35.pushInt(r7);
        r35.pushDouble(r6);
        r35.pushInt(r7);
        r35.pushDouble(r111);
        r35.pushInt(r21);
        r35.pushDouble(r111);
        r35.pushInt(r21);
        r35.pushDouble(r22);
        r35.pushInt(r112);
        r35.pushDouble(r22);
        r35.pushInt(r112);
        r35.pushDouble(r25);
        r35.pushInt(r32);
        r35.pushDouble(r25);
        r35.pushInt(r32);
        r113.q(0, r35);
        r15.e = r113;
    L167:
        r2 = r34;
    L168:
        r1 = r36;
        r0 = r23;
    L126:
        boolean r38 = r19;
        r4 = r27;
    L169:
        r19 = r38;
        r3 = r28;
    L175:
        r10 = r26;
        r12 = r29;
        r13 = r30;
        r9 = r31;
        goto L3
    L12:
        r28 = r3;
        r34 = r5;
        r23 = r8;
        r31 = r9;
        goto L167
    L127:
        com.lynx.tasm.behavior.shadow.text.a r39 = d(r5);
        JavaOnlyArray r40 = new JavaOnlyArray();
        JavaOnlyArray r41 = new JavaOnlyArray();
        r41.pushInt(r11.next().a());
        int r42 = r11.next().a();
        r41.pushInt(r42);
        r41.pushInt(r11.next().a());
        r41.pushDouble(r11.next().b());
        r41.pushInt(r11.next().a());
        r41.pushDouble(r11.next().b());
        int r43 = 0;
    L128:
        if (r43 >= 4) goto L130;
        r41.pushInt(0);
        r43 = r43 + 1;
        goto L128
    L130:
        if (r42 != 4) goto L132;
        r41.pushDouble(r11.next().b());
        r41.pushInt(r11.next().a());
        r41.pushDouble(r11.next().b());
        r41.pushInt(r11.next().a());
    L132:
        r40.pushArray(r41);
        int r44 = r11.next().a();
        JavaOnlyArray r45 = new JavaOnlyArray();
        if (r44 <= 0) goto L137;
        int r46 = 0;
    L135:
        if (r46 >= r44) goto L137;
        r45.pushInt(r11.next().a());
        r46 = r46 + 1;
    L137:
        r40.pushArray(r45);
        int r47 = r11.next().a();
        JavaOnlyArray r48 = new JavaOnlyArray();
        if (r47 <= 0) goto L142;
        int r49 = 0;
    L140:
        if (r49 >= r47) goto L142;
        r48.pushDouble(r11.next().b());
        r49 = r49 + 1;
    L142:
        r40.pushArray(r48);
        r39.O = new a7a.i(r40);
    L154:
        r2 = r39;
        r28 = r3;
        r0 = r8;
        r31 = r9;
        r1 = r110;
        goto L126
    L143:
        r39 = d(r5);
        JavaOnlyArray r50 = new JavaOnlyArray();
        r50.pushDouble(r11.next().b());
        int r51 = r11.next().a();
        JavaOnlyArray r52 = new JavaOnlyArray();
        if (r51 <= 0) goto L148;
        int r53 = 0;
    L146:
        if (r53 >= r51) goto L148;
        r52.pushInt(r11.next().a());
        r53 = r53 + 1;
    L148:
        r50.pushArray(r52);
        int r54 = r11.next().a();
        JavaOnlyArray r55 = new JavaOnlyArray();
        if (r54 <= 0) goto L153;
        int r56 = 0;
    L151:
        if (r56 >= r54) goto L153;
        r55.pushDouble(r11.next().b());
        r56 = r56 + 1;
    L153:
        r50.pushArray(r55);
        r50.pushInt(r11.next().a());
        r39.O = new a7a.f(r50);
        goto L154
    L159:
        r28 = r3;
        r34 = r5;
        r23 = r8;
        r31 = r9;
        int[] r57 = {r11.next().a(), r11.next().a(), r11.next().a(), r11.next().a()};
        if (r15 == null) goto L167;
        r15.c = r57;
        goto L167
    L162:
        r28 = r3;
        r34 = r5;
        r23 = r8;
        r31 = r9;
        int r58 = r11.next().a();
        int r59 = r11.next().a();
        if (r15 == null) goto L167;
        r15.a = r58;
        r15.b = r59;
        goto L167
    L165:
        r28 = r3;
        r31 = r9;
        r0 = r11.next().a();
        r1 = r36;
        r2 = r5;
        goto L126
    L166:
        r28 = r3;
        r31 = r9;
        a r60 = new a();
        r60.d = r11.next().getString();
        r1 = r36;
        r15 = r60;
        r38 = r19;
        r0 = r8;
        r4 = r27;
        r2 = r5;
        r20 = true;
        goto L169
    L76:
        int r61 = r11.next().a();
        if (r17 == true) goto L82;
        int r62 = 0;
    L79:
        if (r62 >= r61) goto L81;
        r11.next().a();
        r11.next().a();
        r11.next().b();
        r11.next().b();
        r62 = r62 + 1;
        goto L79
    L81:
        r29 = r12;
        r30 = r13;
    L121:
        r28 = r3;
        r23 = r8;
        r31 = r9;
        goto L157
    L82:
        r2 = d(r5);
        if (r61 > 0) goto L85;
        r2.A = null;
        r29 = r12;
        r30 = r13;
    L93:
        r28 = r3;
        r23 = r8;
        r31 = r9;
        goto L168
    L85:
        ArrayList r63 = new ArrayList(r61);
        int r64 = 0;
    L86:
        if (r64 >= r61) goto L88;
        r63.add(new com.lynx.tasm.behavior.shadow.text.a.C0051a(r11.next().a(), r11.next().a(), (float) r11.next().b(), (float) r11.next().b()));
        r64 = r64 + 1;
        r12 = r12;
        r13 = r13;
        goto L86
    L88:
        r29 = r12;
        r30 = r13;
        if (r63.isEmpty() == false) goto L91;
        ArrayList r65 = null;
    L92:
        r2.A = r65;
        goto L93
    L91:
        r65 = r63;
        goto L92
    L94:
        r29 = r12;
        r30 = r13;
        int r66 = r11.next().a();
        if (r17 == true) goto L100;
        int r67 = 0;
    L97:
        if (r67 >= r66) goto L121;
        r11.next().b();
        r67 = r67 + 1;
        goto L97
    L100:
        com.lynx.tasm.behavior.shadow.text.a r68 = d(r5);
        if (r66 > 0) goto L103;
        r68.z = null;
    L124:
        com.lynx.tasm.behavior.shadow.text.a r69 = r68;
    L125:
        r1 = r36;
        r2 = r69;
        r28 = r3;
        r0 = r8;
        r31 = r9;
        goto L126
    L103:
        float[] r70 = new float[r66];
        int r71 = 0;
    L104:
        if (r71 >= r66) goto L106;
        r70[r71] = (float) r11.next().b();
        r71 = r71 + 1;
        goto L104
    L106:
        if (r66 != 0) goto L108;
        float[] r72 = null;
    L109:
        r68.z = r72;
        goto L124
    L108:
        r72 = r70;
        goto L109
    L110:
        r29 = r12;
        r30 = r13;
        if (r17 == true) goto L113;
        r11.next().a();
        r11.next().b();
        r11.next().b();
        r11.next().b();
        goto L121
    L113:
        r69 = d(r5);
        if (r11.next().a() == 0) goto L116;
        boolean r73 = true;
    L117:
        float r74 = (float) r11.next().b();
        float r75 = (float) r11.next().b();
        float r76 = (float) r11.next().b();
        r69.v = r73;
        r69.x = r74;
        r69.w = r75;
        r69.y = r76;
        goto L125
    L116:
        r73 = false;
        goto L117
    L119:
        r29 = r12;
        r30 = r13;
        int r77 = r11.next().a();
        if (r17 == false) goto L121;
        r68 = d(r5);
        r68.d = r77;
        goto L124
    L118:
        r29 = r12;
        r30 = r13;
        y6a.n r78 = new y6a.n();
        r78.a = r11.next().a();
        r78.b = (float) r11.next().b();
        r1 = r36;
        r18 = r78;
        r28 = r3;
        r2 = r5;
        r0 = r8;
        r31 = r9;
        r4 = r27;
        r38 = true;
        goto L169
    L123:
        r29 = r12;
        r30 = r13;
        int r79 = r11.next().a();
        int r80 = r11.next().a();
        int r81 = r11.next().a();
        com.lynx.tasm.behavior.shadow.text.a r82 = d(r5);
        r82.J = r79;
        r82.K = r80;
        r82.L = r81;
        r68 = r82;
        goto L124
    L14:
        float r83 = (float) r11.next().b();
        if (r17 == true) goto L17;
    L40:
        r8 = r0;
        r27 = r4;
        r26 = r10;
        r29 = r12;
        r30 = r13;
        r5 = r2;
        goto L121
    L17:
        r68 = d(r2);
        if (Float.isNaN(r83) == false) goto L20;
    L21:
        r83 = 1.0E21f;
    L22:
        r68.k = r83;
    L42:
        r8 = r0;
        r27 = r4;
        r26 = r10;
        r29 = r12;
        r30 = r13;
        goto L124
    L20:
        if (r83 >= 0.0f) goto L22;
    L34:
        int r84 = r11.next().a();
        if (r17 == false) goto L40;
        r68 = d(r2);
        r68.j = r84;
        goto L42
    L38:
        int r85 = r11.next().a();
        if (r17 == false) goto L40;
        r68 = d(r2);
        r68.i = r85;
        goto L42
    L13:
        double r86 = r11.next().b();
        com.lynx.tasm.behavior.shadow.text.a r87 = d(r2);
        r87.l = (float) r86;
    L33:
        r8 = r0;
        r69 = r87;
        r27 = r4;
        r26 = r10;
        r29 = r12;
        r30 = r13;
        goto L125
    L23:
        r87 = d(r2);
        r87.u = r11.next().getString();
        goto L33
    L24:
        int r88 = r11.next().a();
        if (r88 != 1) goto L27;
    L30:
        int r89 = 2;
    L31:
        r87 = d(r2);
        r87.h = r89;
        goto L33
    L27:
        if (r88 == 2) goto L30;
        r89 = 0;
        goto L31
    L32:
        r87 = d(r2);
        r87.g = r11.next().a();
        goto L33
    L43:
        com.lynx.tasm.behavior.shadow.text.a r90 = d(r2);
        r90.c = Integer.valueOf(r11.next().a());
    L45:
        r2 = r90;
        r28 = r3;
        r31 = r9;
        r26 = r10;
        r29 = r12;
        r30 = r13;
        r38 = r19;
        r1 = r36;
        goto L169
    L44:
        r90 = d(r2);
        float r91 = (float) r11.next().b();
        r90.n = r91;
        r4 = Math.max(r4, r91);
        goto L45
    L46:
        String r92 = r11.next().getString();
        com.lynx.tasm.behavior.shadow.text.a r114 = d(r2);
        r10.append(r92);
        r26 = r10;
        b(0, r92.length(), r9, r114, new b(this), true);
        r1 = r36;
        r0 = r0;
        r31 = r9;
        r30 = r13;
        r2 = r114;
        r38 = r19;
        r4 = r4;
        r28 = r3;
        r29 = r12;
        goto L169
    L47:
        int r93 = r0;
        int r210 = r3;
        float r211 = r4;
        r26 = r10;
        int r115 = r11.next().a();
        if (r93 == (-1)) goto L54;
        n r94 = new n();
        r94.e = true;
        y6a.n r95 = r18;
        if (r95 == null) goto L52;
        int r96 = r95.a;
        float r97 = r95.b;
        r94.a = r96;
        r94.b = r97;
    L52:
        r13.add(r94);
        r94.i = r210;
        r9.add(new BaseTextShadowNode.a(r210, r115, r94));
        r12.put(Integer.valueOf(r93), r94);
    L53:
        r1 = r1;
    L72:
        int r116 = r1;
        r18 = r95;
    L74:
        r31 = r9;
        r1 = r116;
        r29 = r12;
        r30 = r13;
        r16 = r115;
        r4 = r211;
        r0 = -1;
        r2 = null;
        r3 = 0;
        r15 = null;
        r17 = true;
        goto L175
    L54:
        r95 = r18;
        if (r15 != null) goto L57;
        r116 = r1;
        r18 = r95;
        b(r210, r115, r9, r2, new b(this), false);
        goto L74
    L57:
        if (r15.d == null) goto L53;
        d7a.b r98 = new d7a.b(r15.a, r15.b, r15.c);
        r98.e = true;
        r13.add(r98);
        c r99 = new c(this.a, r98);
        r98.q = r99;
        r99.l(r98.g, r98.f, 0, 0, 0, 0);
        r98.q.F = true;
        r99.v(r15.d);
        if (r95 == null) goto L62;
        int r100 = r95.a;
        float r117 = r95.b;
        r98.a = r100;
        r98.b = r117;
    L62:
        com.lynx.tasm.behavior.ui.utils.e r101 = r15.e;
        if (r101 == null) goto L68;
        BackgroundDrawable r102 = (BackgroundDrawable) r101.b;
        if (r102 == null) goto L68;
        r102.setBounds(0, 0, r15.a, r15.b);
        r98.n = r15.e;
    L68:
        r99.z();
        if (r2 == null) goto L71;
        r98.m = r2.p;
    L71:
        r9.add(new BaseTextShadowNode.a(r210, r115, r98));
        goto L72
    L75:
        r26 = r10;
        r3 = r11.next().a();
        r0 = r0;
        r31 = r9;
        r29 = r12;
        r30 = r13;
        r4 = r4;
        r17 = false;
        r18 = null;
        goto L175
    L170:
        r23 = r0;
        r33 = r2;
        r28 = r3;
        r27 = r4;
        r31 = r9;
        r26 = r10;
        r29 = r12;
        r30 = r13;
        int r118 = r1;
        int r103 = r11.next().a();
        if (r17 == true) goto L174;
        r1 = r118;
        goto L173
    L174:
        r2 = d(r33);
        r2.a = r103;
        r1 = r118;
        r0 = r23;
        r3 = r28;
        r4 = r27;
        goto L175
    L176:
        float r212 = r4;
        ArrayList r310 = r9;
        SpannableStringBuilder r213 = r10;
        HashMap<Integer, n> r214 = r12;
        ArrayList r311 = r13;
        int r119 = r1;
        com.lynx.tasm.behavior.shadow.text.a r104 = r2;
        if (r213.length() != 0) goto L180;
        if (r16 <= 0) goto L180;
        new String(r37.c(((r37.b - 1) * 8) + 8), Charset.defaultCharset());
    L180:
        int r105 = r310.size() - 1;
    L181:
        if (r105 < 0) goto L184;
        ((BaseTextShadowNode.a) ListProtector.get(r310, r105)).a(r213);
        r105 = r105 - 1;
        goto L181
    L184:
        if (r104 != null) goto L186;
        return;
    L186:
        if (r19 == false) goto L195;
        float r106 = ((-r212) * 1.2f) * 0.78f;
        float r107 = r212 * 1.2f;
        float r108 = 0.22f * r107;
        float r109 = r107 * 0.5f;
        float r120 = r104.k;
        if (r120 == 1.0E21f) goto L191;
        r24 = r120;
    L191:
        z6a.c r121 = new z6a.c(Arrays.asList(new Float[]{Float.valueOf(r106), Float.valueOf(r108), Float.valueOf(r109), Float.valueOf(r24)}));
        int r122 = 0;
    L193:
        if (r122 >= r311.size()) goto L195;
        ((z6a.a) ListProtector.get(r311, r122)).d = r121;
        r122 = r122 + 1;
    L195:
        r104.q = r20;
        r104.r = !r214.isEmpty();
        z6a.b r123 = new z6a.b(r213, r104);
        if (r214.isEmpty() == true) goto L198;
        r123.c = r214;
    L198:
        this.c.put(r119, r123);
    }

    public final void b(int r17, int r18, List<BaseTextShadowNode.a> r19, com.lynx.tasm.behavior.shadow.text.a r20, b r21, boolean r22) {
        if (r20 != null) goto L5;
        return;
    L5:
        boolean r4 = false;
        if (r22 == false) goto L20;
        if (l.a(r20.k) == false) goto L10;
    L16:
        boolean r6 = false;
    L17:
        if (r6 == false) goto L20;
        BaseTextShadowNode.a r7 = new BaseTextShadowNode.a(r17, r18, new z6a.f(r20.k, true, 0, false));
        ((ArrayList) r19).add(r7);
        goto L20
    L10:
        if (r20.i == 1) goto L12;
    L15:
        r6 = true;
        goto L17
    L12:
        if (r20.q == true) goto L15;
        if (r20.r == false) goto L16;
    L20:
        if (r20.l == 1.0E21f) goto L23;
        BaseTextShadowNode.a r8 = new BaseTextShadowNode.a(r17, r18, new z6a.e(r20.l));
        ((ArrayList) r19).add(r8);
    L23:
        if (r20.K == 4) goto L25;
    L33:
        int r9 = r20.J;
        if ((r9 & 1) == 0) goto L36;
        boolean r10 = true;
    L38:
        if ((r9 & 2) == 0) goto L40;
        boolean r11 = true;
    L41:
        if (r10 == true) goto L43;
        if (r11 == true) goto L43;
    L45:
        if (r20.O == null) goto L47;
        BaseTextShadowNode.a r12 = new BaseTextShadowNode.a(r17, r18, new m(r20.O));
        ((ArrayList) r19).add(r12);
    L47:
        if (r22 == false) goto L49;
        return;
    L49:
        BaseTextShadowNode.a r13 = new BaseTextShadowNode.a(r17, r18, new AbsoluteSizeSpan(Math.round(r20.n)));
        ArrayList r14 = (ArrayList) r19;
        r14.add(r13);
        if (r20.c == null) goto L53;
        r14.add(new BaseTextShadowNode.a(r17, r18, new j(r20.c.intValue())));
    L53:
        if (TextUtils.isEmpty(r20.u) == true) goto L58;
        Typeface r15 = g.d(this.a, r20.u, 0);
        if (r15 != null) goto L57;
        FontFaceManager.g.a.g(this.a, r20.u, 0, r21);
        r15 = DeviceUtils.b();
    L57:
        r14.add(new BaseTextShadowNode.a(r17, r18, new z6a.i(r15)));
    L58:
        int r16 = r20.g;
        if (r16 != 1) goto L61;
    L64:
        r4 = true;
    L65:
        if (r4 == true) goto L69;
        if (r20.h > 0) goto L69;
    L72:
        int r3 = r20.d;
        if (r3 != 2) goto L75;
        r14.add(new BaseTextShadowNode.a(r17, r18, new AlignmentSpan.Standard(Layout.Alignment.ALIGN_OPPOSITE)));
        return;
    L75:
        if (r3 != 1) goto L79;
        r14.add(new BaseTextShadowNode.a(r17, r18, new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER)));
        return;
    L79:
        return;
    L69:
        if (Build.VERSION.SDK_INT < 28) goto L71;
        r14.add(new BaseTextShadowNode.a(r17, r18, new z6a.g(r20.h, r20.g, r20.u, r20.c(), r20.E, r20.B)));
        goto L72
    L71:
        r14.add(new BaseTextShadowNode.a(r17, r18, new StyleSpan(r20.e())));
        goto L72
    L61:
        if (r16 < 6) goto L65;
        if (r16 > 10) goto L65;
    L43:
        BaseTextShadowNode.a r23 = new BaseTextShadowNode.a(r17, r18, new q(r10, r11, r20.K, r20.L));
        ((ArrayList) r19).add(r23);
        goto L45
    L40:
        r11 = false;
        goto L41
    L36:
        r10 = false;
        goto L38
    L25:
        if (r20.L != 0) goto L33;
        if ((r20.J & 2) == 0) goto L31;
        BaseTextShadowNode.a r24 = new BaseTextShadowNode.a(r17, r18, new LynxStrikethroughSpan());
        ((ArrayList) r19).add(r24);
    L31:
        if ((r20.J & 1) == 0) goto L45;
        BaseTextShadowNode.a r25 = new BaseTextShadowNode.a(r17, r18, new LynxUnderlineSpan());
        ((ArrayList) r19).add(r25);
        goto L45
    }

    public final float[] e(int r19, float r20, int r21, float r22, int r23, float[] r24) {
        z6a.b r3 = (z6a.b) this.c.get(r19);
        if (r3 == null) goto L14;
        int r6 = 0;
    L6:
        if (r6 >= (r24.length / 4)) goto L14;
        int r7 = r6 * 4;
        int r8 = (int) r24[r7];
        HashMap<Integer, n> r9 = r3.c;
        if (r9 != null) goto L10;
        n r10 = null;
    L11:
        if (r10 == null) goto L13;
        int r11 = (int) Math.ceil(r24[r7 + 1]);
        int r12 = (int) Math.ceil(r24[r7 + 2]);
        int r13 = (int) Math.ceil(r24[r7 + 3]);
        r10.g = r11;
        r10.f = r12;
        r10.h = r13;
    L13:
        r6 = r6 + 1;
        goto L6
    L10:
        r10 = r9.get(Integer.valueOf(r8));
    L14:
        MeasureMode r14 = MeasureMode.fromInt(r21);
        MeasureMode r15 = MeasureMode.fromInt(r23);
        new WeakReference(this);
        float[] r4 = new float[3];
        z6a.b r16 = (z6a.b) this.c.get(r19);
        if (r16 == null) goto L36;
        e r17 = new e(this.a, new f(r16.a, r16.b, r14, r15, r20, r22, 0, false, true, true));
        float r5 = r17.i();
        float r18 = r17.g();
        Layout r25 = r17.a;
        int r110 = r25.getLineBaseline(0);
        int r111 = r17.h();
        float[] r112 = new float[(r111 * 3) + 4];
        r112[0] = r18;
        r112[1] = r5;
        r112[2] = r110;
        r112[3] = r111;
        int r26 = 0;
    L18:
        if (r26 >= r111) goto L20;
        int r113 = r25.getLineStart(r26);
        int r114 = r25.getLineEnd(r26);
        int r115 = r25.getEllipsisCount(r26);
        int r116 = (r26 * 3) + 4;
        r112[r116] = r113;
        r112[r116 + 1] = r114;
        r112[r116 + 2] = r115;
        r26 = r26 + 1;
        goto L18
    L20:
        if (r111 <= 0) goto L30;
        int r117 = r16.a.length();
        int r27 = ((r111 - 1) * 3) + 4;
        int r2 = r27 + 1;
        int r28 = r27 + 2;
        int r118 = (int) r112[r2];
        int r119 = (int) r112[r28];
        int r120 = r17.c;
        if (r120 <= 0) goto L25;
        r119 = r120;
    L29:
        r112[r28] = r119;
        r112[r2] = r117;
        goto L30
    L25:
        if (r111 >= r25.getLineCount()) goto L27;
    L28:
        r119 = r117 - r118;
        goto L29
    L27:
        if (r16.b.j != 0) goto L29;
    L30:
        w r29 = new w(r25, r16.b.q, null, false);
        r29.e = new PointF(r17.d, r17.e);
        r29.g = r16.a;
        int r30 = r16.b.j;
        int r31 = r17.h();
        int r32 = r17.c;
        int r33 = r16.a.length();
        float r34 = r17.d();
        r29.j = r30;
        r29.h = r31;
        r29.i = r32;
        r29.k = r33;
        r29.l = r34;
        r29.m = true;
        this.b.put(r19, r29);
        return r112;
    L36:
        return r4;
    }
}
