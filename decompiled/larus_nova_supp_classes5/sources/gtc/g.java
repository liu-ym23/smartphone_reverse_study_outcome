package gtc;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class g {
    public final d a;

    public interface a {
        List<f> a();

        String name();
    }

    public g(etc.a r1) {
        this.a = r1;
    }

    public static f d(Pattern r7) {
        return new f(r7, false, false, null, null);
    }

    public static f h(Pattern r7) {
        return new f(r7, true, false, null, null);
    }

    public final a b(String r2) {
        return this.a.a(this, r2);
    }

    public static c a(String r3, f... r4) {
        int r1 = r4.length;
        ArrayList r2 = new ArrayList(r1);
        if (r1 <= 0) goto L6;
        Collections.addAll(r2, r4);
    L6:
        return new c(r3, r2);
    }

    public static f e(Pattern r7, boolean r8) {
        return new f(r7, r8, true, null, null);
    }

    public static k i(String r3, c... r4) {
        int r1 = r4.length;
        ArrayList r2 = new ArrayList(r1);
        if (r1 <= 0) goto L6;
        Collections.addAll(r2, r4);
    L6:
        return new k(r3, r2);
    }

    public static List j(String r8, a r9) {
        ArrayList r7 = new ArrayList(3);
        r7.add(new i(r8));
        c(r8, r7, r9, 0, 0, false, null);
        return r7;
    }

    public static f f(Pattern r7, boolean r8, boolean r9, String r10) {
        return new f(r7, r8, r9, r10, null);
    }

    public static f g(Pattern r7, boolean r8, boolean r9, String r10, a r11) {
        return new f(r7, r8, r9, r10, r11);
    }

    public static void c(String r30, List r31, a r32, int r33, int r34, boolean r35, f r36) {
        int r9 = r30.length();
        if (r9 != 0) goto L5;
        return;
    L5:
        Iterator<f> r10 = r32.a().iterator();
    L7:
        if (r10.hasNext() == false) goto L100;
        f r11 = r10.next();
        if (r11 == r36) goto L10;
        Iterator r13 = r11.a().iterator();
    L13:
        if (r13.hasNext() == false) goto L7;
        c r14 = (c) r13.next();
        boolean r15 = r14.c();
        boolean r16 = r14.a();
        Pattern r6 = r14.b();
        int r0 = r33;
        int r2 = r34;
        int r1 = 0;
    L15:
        ArrayList r3 = (ArrayList) r31;
        if (r0 >= r3.size()) goto L97;
        if (r3.size() > r9) goto L96;
        e r4 = (b) ListProtector.get(r31, r0);
        if (r4.d() == false) goto L22;
        int r19 = r1;
        int r21 = r9;
    L61:
        r10 = r10;
        Iterator r24 = r13;
        r1 = r19;
        int r17 = 1;
    L94:
        r2 = r2 + ((b) ListProtector.get(r31, r0)).c();
        r0 = r0 + r17;
        r10 = r10;
        r9 = r21;
        r14 = r14;
        r13 = r24;
        r6 = r6;
        goto L15
    L22:
        String r5 = r4.b();
        if (r16 == false) goto L54;
        r19 = r1;
        if (r0 == (r3.size() - 1)) goto L55;
        Matcher r7 = r6.matcher(r30);
        r7.region(r2, r9);
        if (r7.find() == false) goto L97;
        int r8 = r7.start();
        if (r15 == false) goto L32;
        r8 = r8 + r7.group(1).length();
    L32:
        int r12 = r7.start() + r7.group(0).length();
        int r18 = r3.size();
        int r20 = r2;
        r21 = r9;
        int r22 = r20;
        int r23 = r0;
    L33:
        if (r0 >= r18) goto L51;
        if (r20 < r12) goto L46;
        if (((b) ListProtector.get(r31, r0)).d() == true) goto L51;
        d r25 = (b) ListProtector.get(r31, r0 - 1);
        if (r25.d() == true) goto L40;
    L42:
        boolean r26 = false;
    L43:
        if (r26 == true) goto L51;
    L40:
        if (r25.a() == false) goto L42;
        r26 = true;
    L46:
        r20 = r20 + ((b) ListProtector.get(r31, r0)).c();
        if (r8 < r20) goto L49;
        r23 = r23 + 1;
        r22 = r20;
    L49:
        r0 = r0 + 1;
        r18 = r18;
    L51:
        if (((b) ListProtector.get(r31, r23)).d() == false) goto L53;
        r0 = r23;
        r2 = r22;
        goto L61
    L53:
        String r27 = r30.substring(r22, r20);
        int r28 = -r22;
        Matcher r29 = r7;
        boolean r37 = true;
        int r210 = r22;
        int r38 = r0 - r23;
        r0 = r23;
        r2 = r210;
        String r39 = r27;
        int r40 = r28;
    L56:
        if (r37 == false) goto L58;
    L62:
        if (r15 == false) goto L68;
        String r110 = r29.group(1);
        if (r110 == null) goto L66;
        int r111 = r110.length();
    L67:
        int r112 = r111;
    L69:
        int r41 = (r29.start() + r40) + r112;
        if (r112 <= 0) goto L72;
        String r42 = r29.group().substring(r112);
    L73:
        int r211 = r112;
        int r113 = r41 + r42.length();
        int r43 = 0;
    L74:
        if (r43 >= r38) goto L76;
        ListProtector.remove(r31, r0);
        r43 = r43 + 1;
        goto L74
    L76:
        if (r41 == 0) goto L78;
        String r44 = r39.substring(0, r41);
        r2 = r2 + r44.length();
        ListProtector.add(r31, r0, new i(r44));
        int r45 = r0 + 1;
    L79:
        int r114 = r2;
        a r46 = r14.d();
        if (r46 == null) goto L82;
        boolean r212 = true;
    L83:
        if (r212 == false) goto L85;
        List r47 = j(r42, r46);
    L86:
        int r48 = r45 + 1;
        r24 = r13;
        int r115 = r45;
        String r213 = r39;
        r17 = 1;
        ListProtector.add(r31, r115, new h(r11.name(), r47, r14.alias(), r42, r16, r212));
        if (r113 >= r213.length()) goto L89;
        ListProtector.add(r31, r48, new i(r213.substring(r113)));
    L89:
        if (r38 == 1) goto L91;
        c(r30, r31, r32, r115, r114, true, r11);
    L91:
        if (r35 == true) goto L99;
        r0 = r115;
        r2 = r114;
        r1 = r211;
    L99:
        r10 = r10;
        r9 = r21;
        r13 = r24;
        goto L13
    L85:
        r47 = Collections.singletonList(new i(r42));
        goto L86
    L82:
        r212 = false;
        goto L83
    L78:
        r45 = r0;
        goto L79
    L72:
        r42 = r29.group();
        goto L73
    L66:
        r111 = 0;
        goto L67
    L68:
        r112 = r19;
        goto L69
    L58:
        if (r29.find() == true) goto L62;
        if (r35 == false) goto L61;
    L98:
        r10 = r10;
        r24 = r13;
    L55:
        r21 = r9;
        r29 = r6.matcher(r5);
        r39 = r5;
        r37 = false;
        r40 = 0;
        r38 = 1;
        goto L56
    L54:
        r19 = r1;
        goto L55
    L96:
        throw new RuntimeException("Prism4j internal error. Number of entry nodes is greater that the text length.\nNodes: " + r31 + "\nText: " + r30);
    L97:
        r21 = r9;
        goto L98
    L10:
        return;
    }
}
