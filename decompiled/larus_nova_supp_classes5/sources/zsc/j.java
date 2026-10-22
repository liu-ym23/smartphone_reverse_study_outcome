package zsc;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.commonmark.node.Text;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class j implements vvc.a, k {
    public static final Pattern k = null;
    public static final Pattern l = null;
    public static final Pattern m = null;
    public static final Pattern n = null;
    public static final Pattern o = null;
    public final vvc.b a;
    public final boolean b;
    public final BitSet c;
    public final Map<Character, List<i>> d;
    public final Map<Character, xvc.a> e;
    public uvc.b f;
    public String g;
    public int h;
    public org.commonmark.internal.f i;
    public org.commonmark.internal.e j;

    public interface b {
    }

    public static class c implements b {
        public final List<i> a;
        public final List<xvc.a> b;
        public boolean c;

        public c() {
            this.a = new ArrayList(3);
            this.b = new ArrayList(3);
        }

        public final c a(i r2) {
            ((ArrayList) this.a).add(r2);
            return this;
        }

        public final c b(Class r4) {
            int r0 = ((ArrayList) this.a).size();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L8;
            if (r4.equals(((i) ListProtector.get(this.a, r1)).getClass()) == true) goto L6;
            r1 = r1 + 1;
            goto L3
        L6:
            ListProtector.remove(this.a, r1);
        L8:
            return this;
        }
    }

    public static class d implements vvc.c {
        public final boolean a;
        public final List<i> b;
        public final List<xvc.a> c;

        @Override // vvc.c
        public final vvc.a a(org.commonmark.internal.m r5) {
            List<xvc.a> r0 = r5.a;
            if (r0 == null) goto L5;
            int r1 = r0.size();
        L6:
            if (r1 <= 0) goto L8;
            ArrayList r2 = new ArrayList(r1 + this.c.size());
            r2.addAll(this.c);
            r2.addAll(r0);
            List r3 = r2;
        L10:
            return new j(r5, this.a, this.b, r3);
        L8:
            r3 = this.c;
            goto L10
        L5:
            r1 = 0;
            goto L6
        }

        public d(boolean r1, List r2, List r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
        k = PatternProtector.compile("^[!\"#\\$%&'\\(\\)\\*\\+,\\-\\./:;<=>\\?@\\[\\\\\\]\\^_`\\{\\|\\}~\\p{Pc}\\p{Pd}\\p{Pe}\\p{Pf}\\p{Pi}\\p{Po}\\p{Ps}]");
        l = PatternProtector.compile("^ *(?:\n *)?");
        m = PatternProtector.compile("^[\\p{Zs}\t\r\n\f]");
        n = PatternProtector.compile("^[!\"#$%&'()*+,./:;<=>?@\\[\\\\\\]^_`{|}~-]");
        o = PatternProtector.compile("\\s+");
    }

    public final char d() {
        if (this.h < this.g.length()) goto L5;
        return 0;
    L5:
        return this.g.charAt(this.h);
    }

    public final String c(Pattern r4) {
        if (this.h < this.g.length()) goto L5;
        return null;
    L5:
        Matcher r5 = r4.matcher(this.g);
        r5.region(this.h, this.g.length());
        if (r5.find() == false) goto L9;
        this.h = r5.end();
        return r5.group();
    L9:
        return null;
    }

    public final void e(org.commonmark.internal.f r11) {
        HashMap r0 = new HashMap();
        org.commonmark.internal.f r1 = this.i;
    L3:
        if (r1 == null) goto L7;
        org.commonmark.internal.f r2 = r1.e;
        if (r2 == r11) goto L7;
        r1 = r2;
    L7:
        if (r1 == null) goto L48;
        char r3 = r1.b;
        xvc.a r4 = (xvc.a) ((HashMap) this.e).get(Character.valueOf(r3));
        if (r1.d == false) goto L47;
        if (r4 == null) goto L47;
        char r5 = r4.c();
        org.commonmark.internal.f r6 = r1.e;
        boolean r7 = false;
        int r8 = 0;
    L13:
        if (r6 == null) goto L25;
        if (r6 == r11) goto L25;
        if (r6 == r0.get(Character.valueOf(r3))) goto L25;
        if (r6.c == false) goto L24;
        if (r6.b != r5) goto L24;
        r8 = r4.d(r6, r1);
        r7 = true;
        if (r8 <= 0) goto L24;
        boolean r9 = true;
    L26:
        if (r7 == false) goto L27;
        Text r10 = r6.a;
        Text r12 = r1.a;
        r6.g -= r8;
        r1.g -= r8;
        String r13 = r10.h;
        r10.h = r13.substring(0, r13.length() - r8);
        String r14 = r12.h;
        r12.h = r14.substring(0, r14.length() - r8);
        org.commonmark.internal.f r15 = r1.e;
    L33:
        if (r15 == null) goto L36;
        if (r15 == r6) goto L36;
        org.commonmark.internal.f r16 = r15.e;
        f(r15);
        r15 = r16;
    L36:
        if (r10 == r12) goto L41;
        uvc.b r17 = r10.e;
        if (r17 == r12) goto L41;
        h.b(r17, r12.d);
    L41:
        r4.e(r10, r12, r8);
        if (r6.g != 0) goto L45;
        r6.a.g();
        f(r6);
    L45:
        if (r1.g != 0) goto L7;
        org.commonmark.internal.f r18 = r1.f;
        r1.a.g();
        f(r1);
        r1 = r18;
        goto L7
    L27:
        if (r9 == true) goto L31;
        r0.put(Character.valueOf(r3), r1.e);
        if (r1.c == true) goto L31;
        f(r1);
    L31:
        r1 = r1.f;
    L24:
        r6 = r6.e;
    L25:
        r9 = r7;
        r7 = false;
    L47:
        r1 = r1.f;
    L48:
        org.commonmark.internal.f r19 = this.i;
        if (r19 == null) goto L52;
        if (r19 == r11) goto L79;
        f(r19);
        goto L48
    L79:
        return;
    }

    public final void f(org.commonmark.internal.f r3) {
        org.commonmark.internal.f r0 = r3.e;
        if (r0 == null) goto L5;
        r0.f = r3.f;
    L5:
        org.commonmark.internal.f r4 = r3.f;
        if (r4 != null) goto L8;
        this.i = r0;
        return;
    L8:
        r4.e = r0;
    }

    @Override // vvc.a
    public final void a(String r13, uvc.b r14) {
        this.g = r13.trim();
        this.h = 0;
        this.i = null;
        this.j = null;
        this.f = r14;
    L3:
        char r7 = d();
        if (r7 != 0) goto L6;
        uvc.b r3 = null;
    L89:
        if (r3 == null) goto L91;
        r14.b(r3);
        goto L3
    L91:
        e(null);
        uvc.b r15 = r14.b;
        uvc.b r16 = r14.c;
        if (r15 == r16) goto L102;
        h.b(r15, r16);
        return;
    L102:
        return;
    L6:
        List r1 = (List) ((HashMap) this.d).get(Character.valueOf(r7));
        if (r1 == null) goto L15;
        int r2 = this.h;
        Iterator r4 = r1.iterator();
        r3 = null;
    L10:
        if (r4.hasNext() == false) goto L86;
        i r5 = (i) r4.next();
        r5.a = this;
        r5.b = this.f;
        r5.c = this.g;
        r5.d = this.h;
        uvc.b r6 = r5.b();
        this.h = r5.d;
        if (r6 != null) goto L13;
        this.h = r2;
        r3 = r6;
    L13:
        r3 = r6;
    L86:
        if (r3 != null) goto L89;
        this.h++;
        r3 = new Text(String.valueOf(r7));
        goto L89
    L15:
        xvc.a r8 = (xvc.a) ((HashMap) this.e).get(Character.valueOf(r7));
        if (r8 == null) goto L75;
        int r9 = this.h;
        int r10 = 0;
    L19:
        if (d() != r7) goto L22;
        r10 = r10 + 1;
        this.h++;
        goto L19
    L22:
        if (r10 >= r8.a()) goto L24;
        this.h = r9;
        a r11 = null;
    L69:
        if (r11 == null) goto L85;
        int r12 = r11.a;
        int r17 = this.h;
        int r18 = r17 + r12;
        this.h = r18;
        Text r19 = new Text(this.g.substring(r17, r18));
        org.commonmark.internal.f r110 = new org.commonmark.internal.f(r19, r7, r11.c, r11.b, this.i);
        this.i = r110;
        r110.g = r12;
        r110.h = r12;
        org.commonmark.internal.f r20 = r110.e;
        if (r20 == null) goto L74;
        r20.f = r110;
    L74:
        r3 = r19;
    L85:
        r3 = null;
        goto L86
    L24:
        String r21 = "\n";
        if (r9 != 0) goto L27;
        String r22 = "\n";
    L28:
        char r23 = d();
        if (r23 == 0) goto L32;
        r21 = String.valueOf(r23);
    L32:
        Pattern r24 = k;
        boolean r25 = r24.matcher(r22).matches();
        Pattern r111 = m;
        boolean r26 = r111.matcher(r22).matches();
        boolean r27 = r24.matcher(r21).matches();
        boolean r28 = r111.matcher(r21).matches();
        if (r28 == true) goto L38;
        if (r27 == false) goto L37;
        if (r26 == true) goto L37;
        if (r25 == false) goto L38;
    L37:
        boolean r112 = true;
    L39:
        if (r26 == true) goto L44;
        if (r25 == false) goto L43;
        if (r28 == true) goto L43;
        if (r27 == false) goto L44;
    L43:
        boolean r29 = true;
    L46:
        if (r7 != '_') goto L57;
        if (r112 == false) goto L51;
        if (r29 == false) goto L50;
        if (r25 == false) goto L51;
    L50:
        boolean r30 = true;
    L52:
        if (r29 == false) goto L56;
        if (r112 == false) goto L55;
        if (r27 == false) goto L56;
    L55:
        boolean r31 = true;
    L68:
        this.h = r9;
        r11 = new a(r10, r30, r31);
    L56:
        r31 = false;
    L51:
        r30 = false;
        goto L52
    L57:
        if (r112 == true) goto L59;
    L61:
        boolean r32 = false;
    L62:
        if (r29 == true) goto L64;
    L66:
        boolean r33 = false;
    L67:
        r31 = r33;
        r30 = r32;
        goto L68
    L64:
        if (r7 != r8.b()) goto L66;
        r33 = true;
        goto L67
    L59:
        if (r7 != r8.c()) goto L61;
        r32 = true;
    L44:
        r29 = false;
    L38:
        r112 = false;
        goto L39
    L27:
        r22 = this.g.substring(r9 - 1, r9);
        goto L28
    L75:
        int r34 = this.h;
        int r35 = this.g.length();
    L76:
        int r36 = this.h;
        if (r36 == r35) goto L82;
        if (this.c.get(this.g.charAt(r36)) == true) goto L82;
        this.h++;
    L82:
        int r37 = this.h;
        if (r34 == r37) goto L85;
        r6 = new Text(this.g.substring(r34, r37));
        goto L13
    }

    public static void b(char r1, xvc.a r2, Map<Character, xvc.a> r3) {
        if (((xvc.a) ((HashMap) r3).put(Character.valueOf(r1), r2)) != null) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Delimiter processor conflict with delimiter char '" + r1 + "'");
    }

    public j(org.commonmark.internal.m r4, boolean r5, List r6, List r7) {
        this.a = r4;
        this.b = r5;
        HashMap r8 = new HashMap(r6.size());
        Iterator r9 = r6.iterator();
    L4:
        if (r9.hasNext() == false) goto L9;
        i r10 = (i) r9.next();
        char r0 = r10.d();
        List r1 = (List) r8.get(Character.valueOf(r0));
        if (r1 != null) goto L8;
        r1 = new ArrayList(1);
        r8.put(Character.valueOf(r0), r1);
    L8:
        r1.add(r10);
        goto L4
    L9:
        this.d = r8;
        HashMap r11 = new HashMap();
        Iterator r12 = r7.iterator();
    L11:
        if (r12.hasNext() == false) goto L25;
        xvc.a r13 = (xvc.a) r12.next();
        char r14 = r13.c();
        char r2 = r13.b();
        if (r14 == r2) goto L14;
        b(r14, r13, r11);
        b(r2, r13, r11);
        goto L11
    L14:
        o r3 = (xvc.a) r11.get(Character.valueOf(r14));
        if (r3 == null) goto L23;
        if (r3.c() != r3.b()) goto L23;
        if ((r3 instanceof o) == false) goto L21;
        o r15 = r3;
    L22:
        r15.f(r13);
        r11.put(Character.valueOf(r14), r15);
        goto L11
    L21:
        o r16 = new o(r14);
        r16.f(r3);
        r15 = r16;
    L23:
        b(r14, r13, r11);
        goto L11
    L25:
        this.e = r11;
        Set r17 = ((HashMap) this.d).keySet();
        Set r18 = r11.keySet();
        BitSet r19 = new BitSet();
        Iterator r20 = r17.iterator();
    L27:
        if (r20.hasNext() == false) goto L29;
        r19.set(((Character) r20.next()).charValue());
        goto L27
    L29:
        Iterator r21 = r18.iterator();
    L31:
        if (r21.hasNext() == false) goto L33;
        r19.set(((Character) r21.next()).charValue());
        goto L31
    L33:
        this.c = r19;
    }
}
