package io.noties.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final io.noties.a.e f16383a;

    public interface a {
        String a();

        List<f> b();
    }

    public interface b {
        int a();

        boolean b();
    }

    public interface c {
        Pattern a();

        boolean b();

        boolean c();

        String d();

        a e();
    }

    public interface d extends b {
        String c();

        List<? extends b> d();

        String e();

        boolean f();
    }

    public interface e extends b {
        String c();
    }

    public interface f {
        String a();

        List<c> b();
    }

    public h(io.noties.a.e r3) {
        this.f16383a = (io.noties.a.e) ZeusTransformUtils.wrapperContextForParams(r3, io.noties.a.e.class, "com.obric.memorydata.plugin");
    }

    public static a a(String r2, List<f> r3) {
        return new io.noties.a.d(r2, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    public static a a(String r1, f... r2) {
        return new io.noties.a.d(r1, io.noties.a.b.a(r2));
    }

    public static c a(Pattern r7) {
        return new g(r7, false, false, null, null);
    }

    public static c a(Pattern r7, boolean r8) {
        return new g(r7, r8, false, null, null);
    }

    public static c a(Pattern r7, boolean r8, boolean r9) {
        return new g(r7, r8, r9, null, null);
    }

    public static c a(Pattern r7, boolean r8, boolean r9, String r10) {
        return new g(r7, r8, r9, r10, null);
    }

    public static c a(Pattern r6, boolean r7, boolean r8, String r9, a r10) {
        return new g(r6, r7, r8, r9, (a) ZeusTransformUtils.wrapperContextForParams(r10, a.class, "com.obric.memorydata.plugin"));
    }

    public static f a(String r1, c... r2) {
        return new l(r1, io.noties.a.b.a(r2));
    }

    private void a(String r31, List<b> r32, a r33, int r34, int r35, boolean r36, f r37) {
        List<b> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r32, List.class, "com.obric.memorydata.plugin");
        a r11 = (a) ZeusTransformUtils.wrapperContextForParams(r33, a.class, "com.obric.memorydata.plugin");
        f r38 = (f) ZeusTransformUtils.wrapperContextForParams(r37, f.class, "com.obric.memorydata.plugin");
        int r13 = r31.length();
        if (r13 != 0) goto L5;
        return;
    L5:
        Iterator<f> r14 = r11.b().iterator();
    L7:
        if (r14.hasNext() == false) goto L99;
        f r15 = (f) ZeusTransformUtils.preCheckCast(r14.next(), f.class, "com.obric.memorydata.plugin");
        if (r15 == r38) goto L10;
        Iterator<c> r16 = r15.b().iterator();
    L13:
        if (r16.hasNext() == false) goto L7;
        c r17 = (c) ZeusTransformUtils.preCheckCast(r16.next(), c.class, "com.obric.memorydata.plugin");
        boolean r18 = r17.b();
        boolean r19 = r17.c();
        Pattern r7 = r17.a();
        int r6 = 0;
        int r0 = r34;
        int r1 = r35;
        int r2 = 0;
    L16:
        if (r0 >= r10.size()) goto L97;
        if (r10.size() > r13) goto L96;
        b r3 = (b) ZeusTransformUtils.preCheckCast(r10.get(r0), b.class, "com.obric.memorydata.plugin");
        if (a(r3) == false) goto L23;
        int r20 = r6;
    L94:
        r1 = r1 + ((b) ZeusTransformUtils.preCheckCast(r10.get(r0), b.class, "com.obric.memorydata.plugin")).a();
        r0 = r0 + 1;
        r13 = r13;
        r7 = r7;
        r6 = r20;
        r14 = r14;
        r38 = r38;
        goto L16
    L23:
        String r4 = ((e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.memorydata.plugin")).c();
        if (r19 == true) goto L26;
    L51:
        int r39 = r2;
        String r5 = r4;
        int r8 = 0;
        int r9 = 1;
        Matcher r12 = r7.matcher(r4);
        boolean r21 = false;
    L52:
        if (r21 == true) goto L60;
        if (r12.find() == true) goto L60;
        if (r36 == true) goto L97;
        r2 = r39;
    L58:
        r20 = 0;
    L60:
        if (r18 == false) goto L66;
        String r22 = r12.group(1);
        if (r22 == null) goto L64;
        int r23 = r22.length();
    L65:
        int r110 = r23;
    L67:
        int r24 = (r12.start() + r8) + r110;
        String r25 = r12.group();
        if (r110 <= 0) goto L70;
        r25 = r25.substring(r110);
    L70:
        int r26 = r24 + r25.length();
        int r27 = 0;
    L71:
        if (r27 >= r9) goto L73;
        r10.remove(r0);
        r27 = r27 + 1;
        goto L71
    L73:
        if (r24 == 0) goto L75;
        String r28 = r5.substring(0, r24);
        int r29 = r0 + 1;
        int r30 = r1 + r28.length();
        r10.add(r0, new j(r28));
        int r210 = r30;
        int r40 = r29;
    L76:
        a r41 = r17.e();
        if (r41 == null) goto L79;
        boolean r211 = true;
    L81:
        if (r211 == false) goto L83;
        List<b> r42 = a(r25, r41);
    L84:
        int r43 = r40 + 1;
        int r212 = r110;
        r20 = 0;
        r13 = r13;
        String r213 = r5;
        r14 = r14;
        int r111 = r9;
        r10.add(r40, new i(r15.a(), r42, r17.d(), r25, r19, r211));
        if (r26 >= r213.length()) goto L88;
        r10.add(r43, new j(r213.substring(r26)));
    L88:
        if (r111 == 1) goto L91;
        a(r31, r10, r11, r29, r210, true, r15);
    L91:
        if (r36 == true) goto L98;
        r0 = r29;
        r1 = r210;
        r2 = r212;
    L98:
        r13 = r13;
        r38 = r38;
        r14 = r14;
        goto L13
    L83:
        r42 = Collections.singletonList(new j(r25));
        goto L84
    L79:
        r211 = false;
        goto L81
    L75:
        r40 = r0;
        r29 = r40;
        r210 = r1;
        goto L76
    L64:
        r23 = 0;
        goto L65
    L66:
        r110 = r39;
        goto L67
    L26:
        if (r0 == (r10.size() - 1)) goto L51;
        Matcher r44 = r7.matcher(r31);
        r44.region(r1, r13);
        if (r44.find() == false) goto L97;
        int r45 = r44.start();
        if (r18 == false) goto L33;
        r45 = r45 + r44.group(1).length();
    L33:
        int r46 = r44.start() + r44.group(r6).length();
        int r47 = r10.size();
        r39 = r2;
        int r48 = r1;
        int r49 = r48;
        int r50 = r0;
    L34:
        if (r0 >= r47) goto L48;
        int r214 = r47;
        if (r48 < r46) goto L43;
        if (a((b) ZeusTransformUtils.preCheckCast(r10.get(r0), b.class, "com.obric.memorydata.plugin")) == true) goto L48;
        if (b((b) ZeusTransformUtils.preCheckCast(r10.get(r0 - 1), b.class, "com.obric.memorydata.plugin")) == true) goto L48;
    L43:
        r48 = r48 + ((b) ZeusTransformUtils.preCheckCast(r10.get(r0), b.class, "com.obric.memorydata.plugin")).a();
        if (r45 < r48) goto L46;
        r50 = r50 + 1;
        r49 = r48;
    L46:
        r0 = r0 + 1;
        r47 = r214;
        r46 = r46;
    L48:
        if (a((b) ZeusTransformUtils.preCheckCast(r10.get(r50), b.class, "com.obric.memorydata.plugin")) == false) goto L50;
        r2 = r39;
        r0 = r50;
        r1 = r49;
        goto L58
    L50:
        r8 = -r49;
        r9 = r0 - r50;
        r0 = r50;
        r5 = r31.substring(r49, r48);
        r1 = r49;
        r12 = r44;
        r21 = true;
        goto L52
    L96:
        throw new RuntimeException("Prism4j internal error. Number of entry nodes is greater that the text length.\nNodes: " + r10 + "\nText: " + r31);
    L97:
        r38 = r38;
        r13 = r13;
        r14 = r14;
        goto L98
    L10:
        return;
    }

    private static boolean a(b r2) {
        return ((b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin")).b();
    }

    private static boolean b(b r2) {
        b r3 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
        if (r3.b() == true) goto L5;
    L7:
        return false;
    L5:
        if (((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.memorydata.plugin")).f() == false) goto L7;
        return true;
    }

    public a a(String r2) {
        return this.f16383a.a(this, r2);
    }

    public List<b> a(String r9, a r10) {
        a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r10, a.class, "com.obric.memorydata.plugin");
        ArrayList r11 = new ArrayList(3);
        r11.add(new j(r9));
        a(r9, r11, r3, 0, 0, false, null);
        return r11;
    }
}
