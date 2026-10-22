package io.noties.markwon.syntax;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.a.a.i;
import io.noties.a.a.j;
import io.noties.a.a.k;
import io.noties.a.a.l;
import io.noties.a.a.m;
import io.noties.a.a.n;
import io.noties.a.a.o;
import io.noties.a.a.p;
import io.noties.a.a.q;
import io.noties.a.a.r;
import io.noties.a.a.s;
import io.noties.a.a.t;
import io.noties.a.a.u;
import io.noties.a.a.v;
import io.noties.a.a.w;
import io.noties.a.a.x;
import io.noties.a.a.y;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class a implements io.noties.a.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final io.noties.a.h.a f16683a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, io.noties.a.h.a> f16684b;

    static {
        f16683a = new AnonymousClass1();
    }

    public a() {
        this.f16684b = new HashMap(3);
    }

    @Override // io.noties.a.e
    public io.noties.a.h.a a(io.noties.a.h r4, String r5) {
        String r6 = a(r5);
        io.noties.a.h.a r0 = (io.noties.a.h.a) ZeusTransformUtils.preCheckCast(this.f16684b.get(r6), io.noties.a.h.a.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        io.noties.a.h.a r1 = b(r4, r6);
        if (r1 != null) goto L11;
        this.f16684b.put(r6, f16683a);
    L12:
        return r1;
    L11:
        this.f16684b.put(r6, r1);
        c(r4, r6);
        goto L12
    L5:
        if (f16683a != r0) goto L13;
        return null;
    L13:
        return r0;
    }

    public String a(String r2) {
        r2.hashCode();
        byte r0 = -1;
        switch(r2.hashCode()) {
            case -1325976652: goto L30;
            case -1081249113: goto L26;
            case 3401: goto L22;
            case 114276: goto L18;
            case 118807: goto L14;
            case 3213227: goto L10;
            case 101429384: goto L6;
            default: goto L33;
        };
    L33:
        switch(r0) {
            case 0: goto L38;
            case 1: goto L37;
            case 2: goto L36;
            case 3: goto L37;
            case 4: goto L37;
            case 5: goto L37;
            case 6: goto L35;
            default: goto L43;
        };
    L35:
        return "json";
    L36:
        return "javascript";
    L37:
        return "markup";
    L38:
        return "csharp";
    L43:
        return r2;
    L6:
        if (r2.equals("jsonp") == false) goto L33;
        r0 = 6;
        goto L33
    L10:
        if (r2.equals("html") == false) goto L33;
        r0 = 5;
        goto L33
    L14:
        if (r2.equals("xml") == false) goto L33;
        r0 = 4;
        goto L33
    L18:
        if (r2.equals("svg") == false) goto L33;
        r0 = 3;
        goto L33
    L22:
        if (r2.equals("js") == false) goto L33;
        r0 = 2;
        goto L33
    L26:
        if (r2.equals("mathml") == false) goto L33;
        r0 = 1;
        goto L33
    L30:
        if (r2.equals("dotnet") == false) goto L33;
        r0 = 0;
        goto L33
    }

    public io.noties.a.h.a b(io.noties.a.h r2, String r3) {
        r3.hashCode();
        byte r0 = -1;
        switch(r3.hashCode()) {
            case -1351281305: goto L102;
            case -1237466098: goto L98;
            case -1125574399: goto L94;
            case -1125180051: goto L90;
            case -1081305560: goto L86;
            case -973197092: goto L82;
            case -920649363: goto L78;
            case 99: goto L74;
            case 3304: goto L70;
            case 98723: goto L66;
            case 98819: goto L62;
            case 102354: goto L58;
            case 114126: goto L54;
            case 3075967: goto L50;
            case 3254818: goto L46;
            case 3271912: goto L42;
            case 3701415: goto L38;
            case 41047146: goto L34;
            case 94750330: goto L30;
            case 102744722: goto L26;
            case 109250886: goto L22;
            case 109854227: goto L18;
            case 188995949: goto L14;
            case 246938863: goto L10;
            case 866284260: goto L6;
            default: goto L105;
        };
    L105:
        switch(r0) {
            case 0: goto L132;
            case 1: goto L157;
            case 2: goto L156;
            case 3: goto L155;
            case 4: goto L154;
            case 5: goto L153;
            case 6: goto L152;
            case 7: goto L151;
            case 8: goto L150;
            case 9: goto L149;
            case 10: goto L148;
            case 11: goto L147;
            case 12: goto L146;
            case 13: goto L145;
            case 14: goto L144;
            case 15: goto L143;
            case 16: goto L142;
            case 17: goto L141;
            case 18: goto L140;
            case 19: goto L139;
            case 20: goto L138;
            case 21: goto L137;
            case 22: goto L136;
            case 23: goto L135;
            case 24: goto L134;
            default: goto L106;
        };
    L106:
        return null;
    L134:
        return io.noties.a.a.d.a(r2);
    L135:
        return s.a(r2);
    L136:
        return n.a(r2);
    L137:
        return x.a(r2);
    L138:
        return v.a(r2);
    L139:
        return q.a(r2);
    L140:
        return io.noties.a.a.c.a(r2);
    L141:
        return r.a(r2);
    L142:
        return y.a(r2);
    L143:
        return o.a(r2);
    L144:
        return m.a(r2);
    L145:
        return i.a(r2);
    L146:
        return w.a(r2);
    L147:
        return j.a(r2);
    L148:
        return io.noties.a.a.g.a(r2);
    L149:
        return io.noties.a.a.e.a(r2);
    L150:
        return k.a(r2);
    L151:
        return io.noties.a.a.b.a(r2);
    L152:
        return io.noties.a.a.a.a(r2);
    L153:
        return u.a(r2);
    L154:
        return t.a(r2);
    L155:
        return io.noties.a.a.h.a(r2);
    L156:
        return p.a(r2);
    L157:
        return l.a(r2);
    L132:
        return io.noties.a.a.f.a(r2);
    L6:
        if (r3.equals("clojure") == false) goto L105;
        r0 = 24;
        goto L105
    L10:
        if (r3.equals("markdown") == false) goto L105;
        r0 = 23;
        goto L105
    L14:
        if (r3.equals("javascript") == false) goto L105;
        r0 = 22;
        goto L105
    L18:
        if (r3.equals("swift") == false) goto L105;
        r0 = 21;
        goto L105
    L22:
        if (r3.equals("scala") == false) goto L105;
        r0 = 20;
        goto L105
    L26:
        if (r3.equals("latex") == false) goto L105;
        r0 = 19;
        goto L105
    L30:
        if (r3.equals("clike") == false) goto L105;
        r0 = 18;
        goto L105
    L34:
        if (r3.equals("makefile") == false) goto L105;
        r0 = 17;
        goto L105
    L38:
        if (r3.equals("yaml") == false) goto L105;
        r0 = 16;
        goto L105
    L42:
        if (r3.equals("json") == false) goto L105;
        r0 = 15;
        goto L105
    L46:
        if (r3.equals("java") == false) goto L105;
        r0 = 14;
        goto L105
    L50:
        if (r3.equals("dart") == false) goto L105;
        r0 = 13;
        goto L105
    L54:
        if (r3.equals("sql") == false) goto L105;
        r0 = 12;
        goto L105
    L58:
        if (r3.equals("git") == false) goto L105;
        r0 = 11;
        goto L105
    L62:
        if (r3.equals("css") == false) goto L105;
        r0 = 10;
        goto L105
    L66:
        if (r3.equals("cpp") == false) goto L105;
        r0 = 9;
        goto L105
    L70:
        if (r3.equals("go") == false) goto L105;
        r0 = 8;
        goto L105
    L74:
        if (r3.equals("c") == false) goto L105;
        r0 = 7;
        goto L105
    L78:
        if (r3.equals("brainfuck") == false) goto L105;
        r0 = 6;
        goto L105
    L82:
        if (r3.equals("python") == false) goto L105;
        r0 = 5;
        goto L105
    L86:
        if (r3.equals("markup") == false) goto L105;
        r0 = 4;
        goto L105
    L90:
        if (r3.equals("css-extras") == false) goto L105;
        r0 = 3;
        goto L105
    L94:
        if (r3.equals("kotlin") == false) goto L105;
        r0 = 2;
        goto L105
    L98:
        if (r3.equals("groovy") == false) goto L105;
        r0 = 1;
        goto L105
    L102:
        if (r3.equals("csharp") == false) goto L105;
        r0 = 0;
        goto L105
    }

    public void c(io.noties.a.h r2, String r3) {
        r3.hashCode();
        if (r3.equals("markup") == false) goto L5;
        r2.a("css");
        String r1 = "javascript";
    L9:
        r2.a(r1);
        return;
    L5:
        if (r3.equals("css") == false) goto L11;
        r1 = "css-extras";
        goto L9
    }
}
