package org.jsoup.parser;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aikernel.sdk.autotest.AutoTestConstant;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;

/* JADX INFO: loaded from: classes7.dex */
public class f implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, f> f18292a = null;
    private static final String[] k = null;
    private static final String[] l = null;
    private static final String[] m = null;
    private static final String[] n = null;
    private static final String[] o = null;
    private static final String[] p = null;
    private static final String[] q = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f18293b;
    private String c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;

    static {
        f18292a = new HashMap();
        String[] r1 = {"html", "head", "body", "frameset", "script", "noscript", "style", "meta", "link", "title", TypedValues.AttributesType.S_FRAME, "noframes", "section", "nav", "aside", "hgroup", "header", "footer", "p", "h1", "h2", "h3", "h4", "h5", "h6", "ul", "ol", "pre", "div", "blockquote", "hr", MemoryKeyInfoEntity.KEY_ADDRESS, "figure", "figcaption", "form", "fieldset", "ins", "del", "dl", "dt", "dd", "li", "table", "caption", "thead", "tfoot", "tbody", "colgroup", "col", "tr", "th", "td", "video", "audio", "canvas", "details", "menu", "plaintext", "template", "article", "main", "svg", "math", "center", "template", "dir", "applet", "marquee", "listing"};
        k = r1;
        l = new String[]{"object", "base", "font", "tt", "i", "b", "u", "big", "small", "em", "strong", "dfn", "code", "samp", "kbd", "var", "cite", "abbr", OaidModel.KEY_TIME, "acronym", "mark", "ruby", "rt", "rp", "a", "img", "br", "wbr", "map", "q", "sub", "sup", "bdo", "iframe", "embed", "span", "input", "select", "textarea", AnnotatedPrivateKey.LABEL, "button", "optgroup", "option", "legend", "datalist", "keygen", "output", "progress", "meter", "area", AutoTestConstant.PARAM, AILabCheckPermissionTask.KEY_SOURCE, "track", "summary", "command", "device", "area", "basefont", "bgsound", "menuitem", AutoTestConstant.PARAM, AILabCheckPermissionTask.KEY_SOURCE, "track", "data", "bdi", "s", "strike", "nobr"};
        m = new String[]{"meta", "link", "base", TypedValues.AttributesType.S_FRAME, "img", "br", "wbr", "embed", "hr", "input", "keygen", "col", "command", "device", "area", "basefont", "bgsound", "menuitem", AutoTestConstant.PARAM, AILabCheckPermissionTask.KEY_SOURCE, "track"};
        n = new String[]{"title", "a", "p", "h1", "h2", "h3", "h4", "h5", "h6", "pre", MemoryKeyInfoEntity.KEY_ADDRESS, "li", "th", "td", "script", "style", "ins", "del", "s"};
        o = new String[]{"pre", "plaintext", "title", "textarea"};
        p = new String[]{"button", "fieldset", "input", "keygen", "object", "output", "select", "textarea"};
        q = new String[]{"input", "keygen", "object", "select", "textarea"};
        int r2 = r1.length;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L5;
        a(new f(r1[r4]));
        r4 = r4 + 1;
        goto L3
    L5:
        String[] r5 = l;
        int r6 = r5.length;
        int r7 = 0;
    L6:
        if (r7 >= r6) goto L8;
        f r8 = new f(r5[r7]);
        r8.d = false;
        r8.e = false;
        a(r8);
        r7 = r7 + 1;
        goto L6
    L8:
        String[] r9 = m;
        int r10 = r9.length;
        int r11 = 0;
    L10:
        if (r11 >= r10) goto L12;
        f r12 = (f) ZeusTransformUtils.preCheckCast(f18292a.get(r9[r11]), f.class, "com.obric.memorydata.plugin");
        org.jsoup.helper.b.a(r12);
        r12.f = true;
        r11 = r11 + 1;
        goto L10
    L12:
        String[] r13 = n;
        int r14 = r13.length;
        int r15 = 0;
    L13:
        if (r15 >= r14) goto L15;
        f r16 = (f) ZeusTransformUtils.preCheckCast(f18292a.get(r13[r15]), f.class, "com.obric.memorydata.plugin");
        org.jsoup.helper.b.a(r16);
        r16.e = false;
        r15 = r15 + 1;
        goto L13
    L15:
        String[] r17 = o;
        int r18 = r17.length;
        int r19 = 0;
    L16:
        if (r19 >= r18) goto L18;
        f r20 = (f) ZeusTransformUtils.preCheckCast(f18292a.get(r17[r19]), f.class, "com.obric.memorydata.plugin");
        org.jsoup.helper.b.a(r20);
        r20.h = true;
        r19 = r19 + 1;
        goto L16
    L18:
        String[] r21 = p;
        int r22 = r21.length;
        int r23 = 0;
    L19:
        if (r23 >= r22) goto L21;
        f r24 = (f) ZeusTransformUtils.preCheckCast(f18292a.get(r21[r23]), f.class, "com.obric.memorydata.plugin");
        org.jsoup.helper.b.a(r24);
        r24.i = true;
        r23 = r23 + 1;
        goto L19
    L21:
        String[] r25 = q;
        int r26 = r25.length;
    L22:
        if (r3 >= r26) goto L24;
        f r27 = (f) ZeusTransformUtils.preCheckCast(f18292a.get(r25[r3]), f.class, "com.obric.memorydata.plugin");
        org.jsoup.helper.b.a(r27);
        r27.j = true;
        r3 = r3 + 1;
        goto L22
    }

    private f(String r2) {
        this.d = true;
        this.e = true;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = false;
        this.f18293b = r2;
        this.c = org.jsoup.a.a.a(r2);
    }

    public static f a(String r1) {
        return a(r1, d.f18289b);
    }

    public static f a(String r4, d r5) {
        org.jsoup.helper.b.a(r4);
        Map<String, f> r1 = f18292a;
        f r2 = (f) ZeusTransformUtils.preCheckCast(r1.get(r4), f.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L14;
        String r6 = r5.a(r4);
        org.jsoup.helper.b.a(r6);
        String r3 = org.jsoup.a.a.a(r6);
        f r0 = (f) ZeusTransformUtils.preCheckCast(r1.get(r3), f.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L8;
        f r7 = new f(r6);
        r7.d = false;
        return r7;
    L8:
        if (r5.a() == false) goto L13;
        if (r6.equals(r3) == true) goto L13;
        f r8 = r0.l();
        r8.f18293b = r6;
        return r8;
    L13:
        return r0;
    L14:
        return r2;
    }

    private static void a(f r2) {
        f18292a.put(r2.f18293b, r2);
    }

    public static boolean b(String r1) {
        return f18292a.containsKey(r1);
    }

    public String a() {
        return this.f18293b;
    }

    public String b() {
        return this.c;
    }

    public boolean c() {
        return this.d;
    }

    public /* synthetic */ Object clone() {
        return l();
    }

    public boolean d() {
        return this.e;
    }

    public boolean e() {
        return !this.d;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
        return false;
    L8:
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.memorydata.plugin");
        if (this.f18293b.equals(r6.f18293b) == true) goto L12;
        return false;
    L12:
        if (this.f == r6.f) goto L15;
        return false;
    L15:
        if (this.e == r6.e) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.h == r6.h) goto L24;
        return false;
    L24:
        if (this.g == r6.g) goto L27;
        return false;
    L27:
        if (this.i == r6.i) goto L30;
        return false;
    L30:
        if (this.j != r6.j) goto L33;
        return true;
    L33:
        return false;
    }

    public boolean f() {
        return this.f;
    }

    public boolean g() {
        if (this.f == false) goto L5;
    L8:
        return true;
    L5:
        if (this.g == true) goto L8;
        return false;
    }

    public boolean h() {
        return f18292a.containsKey(this.f18293b);
    }

    public int hashCode() {
        return (((((((((((((this.f18293b.hashCode() * 31) + (this.d ? 1 : 0)) * 31) + (this.e ? 1 : 0)) * 31) + (this.f ? 1 : 0)) * 31) + (this.g ? 1 : 0)) * 31) + (this.h ? 1 : 0)) * 31) + (this.i ? 1 : 0)) * 31) + (this.j ? 1 : 0);
    }

    public boolean i() {
        return this.h;
    }

    public boolean j() {
        return this.i;
    }

    f k() {
        this.g = true;
        return this;
    }

    public f l() {
        return (f) ZeusTransformUtils.preCheckCast(super.clone(), f.class, "com.obric.memorydata.plugin");
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public String toString() {
        return this.f18293b;
    }
}
