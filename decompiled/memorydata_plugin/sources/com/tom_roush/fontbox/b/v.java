package com.tom_roush.fontbox.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class v extends t {
    private float c;
    private float d;
    private int e;
    private final List<Object> f;
    private final int g;

    public v(com.tom_roush.fontbox.type1.a r3, String r4, String r5, int r6, List<Object> r7, int r8, int r9) {
        com.tom_roush.fontbox.type1.a r10 = (com.tom_roush.fontbox.type1.a) ZeusTransformUtils.wrapperContextForParams(r3, com.tom_roush.fontbox.type1.a.class, "com.obric.memorydata.plugin");
        List<Object> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        super(r10, r4, r5);
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = 0;
        this.g = r6;
        this.f = r11;
        this.c = r8;
        this.d = r9;
        a(r11);
    }

    static /* synthetic */ List a(v r2, List r3, p r4) {
        return r2.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    private static <E> List<List<E>> a(List<E> r5, int r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        int r0 = r7.size() / r6;
        ArrayList r1 = new ArrayList(r0);
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        int r3 = r2 * r6;
        r2 = r2 + 1;
        r1.add(r7.subList(r3, r2 * r6));
        goto L3
    L5:
        return r1;
    }

    private List<Number> a(List<Number> r17, p r18) {
        p r1 = r18;
        List<Number> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
        boolean r5 = true;
        this.f15944b++;
        String r4 = (String) ZeusTransformUtils.preCheckCast(p.f15938b.get(r18.a()), String.class, "com.obric.memorydata.plugin");
        boolean r8 = false;
        if ("hstem".equals(r4) == false) goto L9;
        if ((r2.size() % 2) == 0) goto L7;
    L6:
        r8 = true;
    L7:
        b(a(r2, r8), true);
        return null;
    L9:
        if ("vstem".equals(r4) == false) goto L17;
        if ((r2.size() % 2) != 0) goto L14;
    L13:
        r5 = false;
    L14:
        List<Number> r3 = a(r2, r5);
    L15:
        b(r3, false);
        return null;
    L17:
        if ("vmoveto".equals(r4) == false) goto L25;
        if (r2.size() > 1) goto L22;
    L21:
        r5 = false;
    L22:
        r2 = a(r2, r5);
        c();
    L23:
        c(r2, r1);
        return null;
    L25:
        if ("rlineto".equals(r4) == false) goto L29;
        List<List<Number>> r6 = a(r2, 2);
    L27:
        b(r6, r1);
        return null;
    L29:
        if ("hlineto".equals(r4) == false) goto L32;
        c(r2, true);
        return null;
    L32:
        if ("vlineto".equals(r4) == false) goto L35;
        c(r2, false);
        return null;
    L35:
        if ("rrcurveto".equals(r4) == false) goto L37;
        r6 = a(r2, 6);
        goto L27
    L37:
        int r13 = 5;
        if ("endchar".equals(r4) == false) goto L49;
        if (r2.size() != 5) goto L42;
    L45:
        r2 = a(r2, r5);
        d();
        if (r2.size() != 4) goto L23;
        r2.add(0, 0);
        r1 = new p(12, 6);
        goto L23
    L42:
        if (r2.size() == 1) goto L45;
        r5 = false;
        goto L45
    L49:
        if ("rmoveto".equals(r4) == false) goto L54;
        if (r2.size() <= 2) goto L21;
    L54:
        if ("hmoveto".equals(r4) == false) goto L59;
        if (r2.size() <= 1) goto L21;
    L59:
        if ("vhcurveto".equals(r4) == false) goto L62;
        d(r2, false);
        return null;
    L62:
        if ("hvcurveto".equals(r4) == false) goto L65;
        d(r2, true);
        return null;
    L65:
        if ("hflex".equals(r4) == false) goto L70;
        if (r2.size() < 7) goto L141;
        List<List<Number>> r7 = Arrays.asList(new List[]{Arrays.asList(new Number[]{(Number) ZeusTransformUtils.preCheckCast(r2.get(0), Number.class, "com.obric.memorydata.plugin"), 0, (Number) ZeusTransformUtils.preCheckCast(r2.get(1), Number.class, "com.obric.memorydata.plugin"), (Number) ZeusTransformUtils.preCheckCast(r2.get(2), Number.class, "com.obric.memorydata.plugin"), (Number) ZeusTransformUtils.preCheckCast(r2.get(3), Number.class, "com.obric.memorydata.plugin"), 0}), Arrays.asList(new Number[]{(Number) ZeusTransformUtils.preCheckCast(r2.get(4), Number.class, "com.obric.memorydata.plugin"), 0, (Number) ZeusTransformUtils.preCheckCast(r2.get(5), Number.class, "com.obric.memorydata.plugin"), Float.valueOf(-((Number) ZeusTransformUtils.preCheckCast(r2.get(2), Number.class, "com.obric.memorydata.plugin")).floatValue()), (Number) ZeusTransformUtils.preCheckCast(r2.get(6), Number.class, "com.obric.memorydata.plugin"), 0})});
        p r9 = new p(8);
    L72:
        b(r7, r9);
        return null;
    L141:
        return null;
    L70:
        if ("flex".equals(r4) == false) goto L74;
        r7 = Arrays.asList(new List[]{r2.subList(0, 6), r2.subList(6, 12)});
        r9 = new p(8);
        goto L72
    L74:
        if ("hflex1".equals(r4) == false) goto L79;
        if (r2.size() < 9) goto L143;
        r7 = Arrays.asList(new List[]{Arrays.asList(new Number[]{(Number) ZeusTransformUtils.preCheckCast(r2.get(0), Number.class, "com.obric.memorydata.plugin"), (Number) ZeusTransformUtils.preCheckCast(r2.get(1), Number.class, "com.obric.memorydata.plugin"), (Number) ZeusTransformUtils.preCheckCast(r2.get(2), Number.class, "com.obric.memorydata.plugin"), (Number) ZeusTransformUtils.preCheckCast(r2.get(3), Number.class, "com.obric.memorydata.plugin"), (Number) ZeusTransformUtils.preCheckCast(r2.get(4), Number.class, "com.obric.memorydata.plugin"), 0}), Arrays.asList(new Number[]{(Number) ZeusTransformUtils.preCheckCast(r2.get(5), Number.class, "com.obric.memorydata.plugin"), 0, (Number) ZeusTransformUtils.preCheckCast(r2.get(6), Number.class, "com.obric.memorydata.plugin"), (Number) ZeusTransformUtils.preCheckCast(r2.get(7), Number.class, "com.obric.memorydata.plugin"), (Number) ZeusTransformUtils.preCheckCast(r2.get(8), Number.class, "com.obric.memorydata.plugin"), 0})});
        r9 = new p(8);
        goto L72
    L143:
        return null;
    L79:
        if ("flex1".equals(r4) == false) goto L93;
        int r10 = 0;
        int r11 = 0;
        int r12 = 0;
    L81:
        if (r10 >= r13) goto L83;
        int r14 = r10 * 2;
        r11 = r11 + ((Number) ZeusTransformUtils.preCheckCast(r2.get(r14), Number.class, "com.obric.memorydata.plugin")).intValue();
        r12 = r12 + ((Number) ZeusTransformUtils.preCheckCast(r2.get(r14 + 1), Number.class, "com.obric.memorydata.plugin")).intValue();
        r10 = r10 + 1;
        r13 = 5;
        goto L81
    L83:
        List<Number> r15 = r2.subList(0, 6);
        Number[] r16 = new Number[6];
        r16[0] = (Number) ZeusTransformUtils.preCheckCast(r2.get(6), Number.class, "com.obric.memorydata.plugin");
        r16[1] = (Number) ZeusTransformUtils.preCheckCast(r2.get(7), Number.class, "com.obric.memorydata.plugin");
        r16[2] = (Number) ZeusTransformUtils.preCheckCast(r2.get(8), Number.class, "com.obric.memorydata.plugin");
        r16[3] = (Number) ZeusTransformUtils.preCheckCast(r2.get(9), Number.class, "com.obric.memorydata.plugin");
        if (Math.abs(r11) <= Math.abs(r12)) goto L86;
        Number r19 = (Number) ZeusTransformUtils.preCheckCast(r2.get(10), Number.class, "com.obric.memorydata.plugin");
    L87:
        r16[4] = r19;
        if (Math.abs(r11) <= Math.abs(r12)) goto L90;
        Number r20 = Integer.valueOf(-r12);
    L91:
        r16[5] = r20;
        r7 = Arrays.asList(new List[]{r15, Arrays.asList(r16)});
        r9 = new p(8);
        goto L72
    L90:
        r20 = (Number) ZeusTransformUtils.preCheckCast(r2.get(10), Number.class, "com.obric.memorydata.plugin");
        goto L91
    L86:
        r19 = Integer.valueOf(-r11);
        goto L87
    L93:
        if ("hstemhm".equals(r4) == false) goto L98;
        if ((r2.size() % 2) == 0) goto L7;
    L98:
        if ("hintmask".equals(r4) == true) goto L125;
        if ("cntrmask".equals(r4) == true) goto L125;
        if ("vstemhm".equals(r4) == false) goto L108;
        if ((r2.size() % 2) == 0) goto L13;
    L108:
        if ("rcurveline".equals(r4) == false) goto L114;
        if (r2.size() < 2) goto L144;
        b(a(r2.subList(0, r2.size() - 2), 6), new p(8));
        List<Number> r21 = r2.subList(r2.size() - 2, r2.size());
        p r22 = new p(5);
    L112:
        c(r21, r22);
        return null;
    L144:
        return null;
    L114:
        if ("rlinecurve".equals(r4) == false) goto L119;
        if (r2.size() < 6) goto L146;
        b(a(r2.subList(0, r2.size() - 6), 2), new p(5));
        r21 = r2.subList(r2.size() - 6, r2.size());
        r22 = new p(8);
        goto L112
    L146:
        return null;
    L119:
        if ("vvcurveto".equals(r4) == false) goto L122;
        e(r2, false);
        return null;
    L122:
        if ("hhcurveto".equals(r4) == false) goto L23;
        e(r2, true);
        return null;
    L125:
        if ((r2.size() % 2) != 0) goto L128;
        r5 = false;
    L128:
        r3 = a(r2, r5);
        if (r3.isEmpty() == false) goto L15;
        return null;
    }

    private List<Number> a(List<Number> r7, boolean r8) {
        List<Number> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        if (this.f15943a.isEmpty() == true) goto L5;
        return r9;
    L5:
        if (r8 == false) goto L7;
        c(Arrays.asList(new Number[]{Float.valueOf(0.0f), Float.valueOf(((Number) ZeusTransformUtils.preCheckCast(r9.get(0), Number.class, "com.obric.memorydata.plugin")).floatValue() + this.d)}), new p(13));
        return r9.subList(1, r9.size());
    L7:
        c(Arrays.asList(new Number[]{Float.valueOf(0.0f), Float.valueOf(this.c)}), new p(13));
        return r9;
    }

    private void a(List<Object> r3) {
        List<Object> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.f15943a = new ArrayList();
        this.e = 0;
        new AnonymousClass1(this).a(r4);
    }

    private void b(List<List<Number>> r4, p r5) {
        Iterator r6 = ((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        c((List) ZeusTransformUtils.preCheckCast(r6.next(), List.class, "com.obric.memorydata.plugin"), r5);
        goto L4
    }

    private void b(List<Number> r1, boolean r2) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r1, List.class, "com.obric.memorydata.plugin");
    }

    private void c() {
        if (this.e <= 0) goto L5;
        d();
    L5:
        this.e++;
    }

    private void c(List<Number> r3, p r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.f15943a.addAll(r5);
        this.f15943a.add(r4);
    }

    private void c(List<Number> r5, boolean r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
    L4:
        if (r7.isEmpty() == true) goto L10;
        List<Number> r0 = r7.subList(0, 1);
        if (r6 == false) goto L8;
        int r3 = 6;
    L9:
        c(r0, new p(r3));
        r7 = r7.subList(1, r7.size());
        r6 = !r6;
        goto L4
    L8:
        r3 = 7;
        goto L9
    }

    private void d() {
        if (this.e <= 0) goto L5;
        p r0 = (p) ZeusTransformUtils.preCheckCast(this.f15943a.get(this.f15943a.size() - 1), p.class, "com.obric.memorydata.plugin");
    L6:
        p r1 = new p(9);
        if (r0 != null) goto L9;
        return;
    L9:
        if (r1.equals(r0) == true) goto L13;
        c(Collections.emptyList(), r1);
        return;
    L13:
        return;
    L5:
        r0 = null;
        goto L6
    }

    private void d(List<Number> r13, boolean r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
    L3:
        int r2 = 4;
        if (r15.size() < 4) goto L25;
        if (r15.size() != 5) goto L8;
        boolean r0 = true;
    L9:
        Number[] r7 = new Number[6];
        if (r14 == false) goto L16;
        r7[0] = (Number) ZeusTransformUtils.preCheckCast(r15.get(0), Number.class, "com.obric.memorydata.plugin");
        r7[1] = 0;
        r7[2] = (Number) ZeusTransformUtils.preCheckCast(r15.get(1), Number.class, "com.obric.memorydata.plugin");
        r7[3] = (Number) ZeusTransformUtils.preCheckCast(r15.get(2), Number.class, "com.obric.memorydata.plugin");
        if (r0 == false) goto L14;
        Number r4 = (Number) ZeusTransformUtils.preCheckCast(r15.get(4), Number.class, "com.obric.memorydata.plugin");
    L15:
        r7[4] = r4;
        r7[5] = (Number) ZeusTransformUtils.preCheckCast(r15.get(3), Number.class, "com.obric.memorydata.plugin");
        List<Number> r5 = Arrays.asList(r7);
        p r6 = new p(8);
    L21:
        c(r5, r6);
        if (r0 == false) goto L24;
        r2 = 5;
    L24:
        r15 = r15.subList(r2, r15.size());
        r14 = !r14;
        goto L3
    L14:
        r4 = 0;
        goto L15
    L16:
        r7[0] = 0;
        r7[1] = (Number) ZeusTransformUtils.preCheckCast(r15.get(0), Number.class, "com.obric.memorydata.plugin");
        r7[2] = (Number) ZeusTransformUtils.preCheckCast(r15.get(1), Number.class, "com.obric.memorydata.plugin");
        r7[3] = (Number) ZeusTransformUtils.preCheckCast(r15.get(2), Number.class, "com.obric.memorydata.plugin");
        r7[4] = (Number) ZeusTransformUtils.preCheckCast(r15.get(3), Number.class, "com.obric.memorydata.plugin");
        if (r0 == false) goto L19;
        Number r8 = (Number) ZeusTransformUtils.preCheckCast(r15.get(4), Number.class, "com.obric.memorydata.plugin");
    L20:
        r7[5] = r8;
        r5 = Arrays.asList(r7);
        r6 = new p(8);
        goto L21
    L19:
        r8 = 0;
        goto L20
    L8:
        r0 = false;
        goto L9
    }

    private void e(List<Number> r13, boolean r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
    L3:
        int r2 = 4;
        if (r15.size() < 4) goto L42;
        int r3 = 1;
        if ((r15.size() % 4) != 1) goto L8;
        int r0 = 1;
    L9:
        int r8 = 3;
        int r9 = 2;
        Number[] r6 = new Number[6];
        if (r14 == false) goto L25;
        r6[0] = (Number) ZeusTransformUtils.preCheckCast(r15.get(r0), Number.class, "com.obric.memorydata.plugin");
        if (r0 == 0) goto L14;
        Number r10 = (Number) ZeusTransformUtils.preCheckCast(r15.get(0), Number.class, "com.obric.memorydata.plugin");
    L15:
        r6[1] = r10;
        if (r0 == 0) goto L18;
        r3 = 2;
    L18:
        r6[2] = (Number) ZeusTransformUtils.preCheckCast(r15.get(r3), Number.class, "com.obric.memorydata.plugin");
        if (r0 == 0) goto L21;
        r9 = 3;
    L21:
        r6[3] = (Number) ZeusTransformUtils.preCheckCast(r15.get(r9), Number.class, "com.obric.memorydata.plugin");
        if (r0 == 0) goto L24;
        r8 = 4;
    L24:
        r6[4] = (Number) ZeusTransformUtils.preCheckCast(r15.get(r8), Number.class, "com.obric.memorydata.plugin");
        r6[5] = 0;
        List<Number> r4 = Arrays.asList(r6);
        p r5 = new p(8);
    L38:
        c(r4, r5);
        if (r0 == 0) goto L41;
        r2 = 5;
    L41:
        r15 = r15.subList(r2, r15.size());
        goto L3
    L14:
        r10 = 0;
        goto L15
    L25:
        if (r0 == 0) goto L27;
        Number r11 = (Number) ZeusTransformUtils.preCheckCast(r15.get(0), Number.class, "com.obric.memorydata.plugin");
    L28:
        r6[0] = r11;
        r6[1] = (Number) ZeusTransformUtils.preCheckCast(r15.get(r0), Number.class, "com.obric.memorydata.plugin");
        if (r0 == 0) goto L31;
        r3 = 2;
    L31:
        r6[2] = (Number) ZeusTransformUtils.preCheckCast(r15.get(r3), Number.class, "com.obric.memorydata.plugin");
        if (r0 == 0) goto L34;
        r9 = 3;
    L34:
        r6[3] = (Number) ZeusTransformUtils.preCheckCast(r15.get(r9), Number.class, "com.obric.memorydata.plugin");
        r6[4] = 0;
        if (r0 == 0) goto L37;
        r8 = 4;
    L37:
        r6[5] = (Number) ZeusTransformUtils.preCheckCast(r15.get(r8), Number.class, "com.obric.memorydata.plugin");
        r4 = Arrays.asList(r6);
        r5 = new p(8);
        goto L38
    L27:
        r11 = 0;
        goto L28
    L8:
        r0 = 0;
        goto L9
    }
}
