package com.ctc.wstx.shaded.msv_core.verifier;

import com.ctc.wstx.shaded.msv_core.datatype.xsd.StringType;
import com.ctc.wstx.shaded.msv_core.grammar.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.MessageFormat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Set;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.xml.sax.Attributes;
import org.xml.sax.ErrorHandler;

/* JADX INFO: loaded from: classes2.dex */
public class f extends com.ctc.wstx.shaded.msv_core.verifier.a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private StringBuffer f3682b;
    protected b i;
    a j;
    protected ErrorHandler k;
    protected boolean l;
    protected final c m;
    protected int n;
    private boolean o;
    private final com.ctc.wstx.shaded.msv_core.util.c p;
    private int q;
    private final com.ctc.wstx.shaded.msv_core.util.a r;
    private final com.ctc.wstx.shaded.msv_core.util.a s;
    private Set t;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final a f3683a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final b f3684b;
        final int c;
        int d;

        a(a r3, b r4, int r5, int r6) {
            b r7 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.memorydata.plugin");
            this.f3683a = r3;
            this.f3684b = r7;
            this.c = r5;
            this.d = r6;
        }
    }

    public f(c r10, ErrorHandler r11) {
        c r12 = (c) ZeusTransformUtils.wrapperContextForParams(r10, c.class, "com.obric.memorydata.plugin");
        ErrorHandler r13 = (ErrorHandler) ZeusTransformUtils.wrapperContextForParams(r11, ErrorHandler.class, "com.obric.memorydata.plugin");
        this.j = null;
        this.f3681a = 2;
        this.f3682b = new StringBuffer();
        this.p = new com.ctc.wstx.shaded.msv_core.util.c(null, null, null, null, (g) ZeusTransformUtils.preCheckCast(null, g.class, "com.obric.memorydata.plugin"));
        this.n = 0;
        this.q = 3;
        this.r = new com.ctc.wstx.shaded.msv_core.util.a();
        this.s = new com.ctc.wstx.shaded.msv_core.util.a();
        this.m = r12;
        this.k = r13;
    }

    public static String a(String r1, Object[] r2) {
        return MessageFormat.format(ResourceBundle.getBundle("com.ctc.wstx.shaded.msv_core.verifier.Messages").getString(r1), r2);
    }

    public ValidityViolation a(com.ctc.wstx.shaded.msv_core.util.d r2, String r3, d r4) {
        if (r2 != null) goto L6;
        return a(r3, r4);
    L6:
        if (r2.f3643a != null) goto L10;
        return a(r3, r4);
    L10:
        return a(r2.f3643a, r4);
    }

    public ValidityViolation a(String r3, d r4) {
        ValidityViolation r0 = new ValidityViolation(this.c, r3, r4);
        this.l = true;
        ErrorHandler r5 = this.k;
        if (r5 != null) goto L5;
    L7:
        this.n = this.q;
        return r0;
    L5:
        if (this.n != 0) goto L7;
        r5.error(r0);
        goto L7
    }

    public void a(com.ctc.wstx.shaded.msv_core.util.c r1, b r2) {
        b r0 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
    }

    public com.ctc.wstx.shaded.msv.relaxng_datatype.a[] a(b r11, String r12, String r13, String r14, String r15) {
        b r16 = (b) ZeusTransformUtils.wrapperContextForParams(r11, b.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L5;
        r12 = "";
    L5:
        if (r13 != null) goto L7;
    L8:
        r13 = r14;
    L9:
        if (r14 != null) goto L11;
    L12:
        r14 = r13;
    L14:
        if (r14.startsWith("xmlns:") == true) goto L30;
        if (r14.equals("xmlns") == true) goto L30;
        if (com.ctc.wstx.shaded.msv_core.a.a.a.f3552a == false) goto L21;
        System.out.println("-- processing attribute: @" + r14);
    L21:
        this.s.f3638a = null;
        if (r16.a(r12, r13, r14, r15, this, null, this.s) == true) goto L28;
        if (com.ctc.wstx.shaded.msv_core.a.a.a.f3552a == false) goto L26;
        System.out.println("-- bad attribute: error recovery");
    L26:
        com.ctc.wstx.shaded.msv_core.util.d r9 = new com.ctc.wstx.shaded.msv_core.util.d();
        r16.a(r12, r13, r14, r15, this, r9, null);
        a(r9, a("Verifier.Error.UnexpectedAttribute", new Object[]{r14}), new d.a(this.p, r14, r12, r13, r15));
    L28:
        return this.s.f3638a;
    L30:
        return new com.ctc.wstx.shaded.msv.relaxng_datatype.a[0];
    L11:
        if (r14.length() != 0) goto L14;
    L7:
        if (r13.length() != 0) goto L9;
        goto L8
    }

    @Override // com.ctc.wstx.shaded.msv_core.verifier.a
    public void b() {
        super.b();
        this.l = false;
        this.o = false;
        this.f3682b = new StringBuffer();
        this.j = null;
        Set r1 = this.t;
        if (r1 == null) goto L6;
        r1.clear();
        return;
    }

    public void c() {
        this.r.f3638a = null;
        int r0 = this.f3681a;
        if (r0 != 0) goto L5;
        int r1 = this.f3682b.length();
        int r3 = 0;
    L19:
        if (r3 >= r1) goto L31;
        char r4 = this.f3682b.charAt(r3);
        if (r4 == ' ') goto L29;
        if (r4 == '\t') goto L29;
        if (r4 == '\r') goto L29;
        if (r4 == '\n') goto L29;
        a(null, a("Verifier.Error.UnexpectedText", null), new d.c(this.f3682b));
    L29:
        r3 = r3 + 1;
    L31:
        if (this.f3682b.length() == 0) goto L40;
        this.f3682b = new StringBuffer();
        return;
    L40:
        return;
    L5:
        if (r0 == 1) goto L14;
        if (r0 != 2) goto L12;
        String r2 = new String(this.f3682b);
        if (this.i.a(r2, this, null, this.r) == true) goto L31;
        com.ctc.wstx.shaded.msv_core.util.d r5 = new com.ctc.wstx.shaded.msv_core.util.d();
        this.r.f3638a = null;
        this.i.a(r2, this, r5, this.r);
        a(r5, a("Verifier.Error.UnexpectedText", null), new d.c(this.f3682b));
        goto L31
    L12:
        throw new Error();
    L14:
        if (this.f3682b.length() != 0) goto L17;
        return;
    L17:
        throw new Error();
    }

    @Override // com.ctc.wstx.shaded.msv_core.verifier.a
    public void c(String r2) {
        if (this.t != null) goto L5;
        this.t = new HashSet();
    L5:
        this.t.add(r2);
    }

    @Override // org.xml.sax.ContentHandler
    public void characters(char[] r3, int r4, int r5) {
        if (this.f3681a == 1) goto L6;
        this.f3682b.append(r3, r4, r5);
        return;
    }

    @Override // org.xml.sax.ContentHandler
    public void endDocument() {
        if (this.e == true) goto L5;
    L18:
        this.o = true;
        return;
    L5:
        if (this.f.keySet().containsAll(this.g) == true) goto L12;
        this.l = true;
        Iterator r0 = this.g.iterator();
    L8:
        if (r0.hasNext() == false) goto L12;
        Object r4 = r0.next();
        if (this.f.keySet().contains(r4) == true) goto L8;
        a(a("Verifier.Error.UnsoldIDREF", new Object[]{r4}), null);
    L12:
        Set r1 = this.t;
        if (r1 == null) goto L18;
        Iterator r2 = r1.iterator();
    L16:
        if (r2.hasNext() == false) goto L18;
        a(a("Verifier.Error.DuplicateId", new Object[]{r2.next()}), null);
        goto L16
    }

    @Override // com.ctc.wstx.shaded.msv_core.verifier.a, org.xml.sax.ContentHandler
    public void endElement(String r7, String r8, String r9) {
        if (r7 != null) goto L4;
        r7 = "";
    L4:
        if (r8 != null) goto L6;
    L7:
        r8 = r9;
    L8:
        if (r9 != null) goto L10;
    L11:
        r9 = r8;
    L13:
        if (com.ctc.wstx.shaded.msv_core.a.a.a.f3552a == false) goto L15;
        System.out.println("\n-- endElement(" + r9 + ")" + this.c.getLineNumber() + ParameterizedMessage.ERROR_MSG_SEPARATOR + this.c.getColumnNumber());
    L15:
        c();
        if (this.i.a(null) == false) goto L18;
    L20:
        b r0 = this.i;
        this.i = this.j.f3684b;
        this.f3681a = this.j.c;
        this.n = Math.max(this.n, this.j.d);
        this.j = this.j.f3683a;
        if (this.i.a(r0, null) == true) goto L23;
        com.ctc.wstx.shaded.msv_core.util.d r4 = new com.ctc.wstx.shaded.msv_core.util.d();
        this.i.a(r0, r4);
        a(r4, a("Verifier.Error.UnexpectedElement", new Object[]{r9}), null);
    L24:
        super.endElement(r7, r8, r9);
        return;
    L23:
        this.n = Math.max(this.n - 1, 0);
        goto L24
    L18:
        if (this.n != 0) goto L20;
        com.ctc.wstx.shaded.msv_core.util.d r1 = new com.ctc.wstx.shaded.msv_core.util.d();
        this.i.a(r1);
        a(r1, a("Verifier.Error.UncompletedContent", new Object[]{r9}), new d.e(r9, r7, r8));
        goto L20
    L10:
        if (r9.length() != 0) goto L13;
    L6:
        if (r8.length() != 0) goto L8;
        goto L7
    }

    @Override // org.xml.sax.ContentHandler
    public void ignorableWhitespace(char[] r3, int r4, int r5) {
        int r0 = this.f3681a;
        if (r0 == 1) goto L7;
        if (r0 == 0) goto L8;
        this.f3682b.append(r3, r4, r5);
        return;
    L8:
        return;
    }

    @Override // org.xml.sax.ContentHandler
    public void startDocument() {
        b();
        this.i = this.m.a();
    }

    @Override // com.ctc.wstx.shaded.msv_core.verifier.a, org.xml.sax.ContentHandler
    public void startElement(String r11, String r12, String r13, Attributes r14) {
        Attributes r15 = (Attributes) ZeusTransformUtils.wrapperContextForParams(r14, Attributes.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L5;
        r11 = "";
    L5:
        String r1 = r11;
        if (r12 != null) goto L8;
    L11:
        String r2 = r13;
    L12:
        if (r13 != null) goto L14;
    L15:
        r13 = r2;
    L16:
        super.startElement(r1, r2, r13, r15);
        if (com.ctc.wstx.shaded.msv_core.a.a.a.f3552a == false) goto L19;
        System.out.println("\n-- startElement(" + r13 + ")" + this.c.getLineNumber() + ParameterizedMessage.ERROR_MSG_SEPARATOR + this.c.getColumnNumber());
    L19:
        c();
        this.j = new a(this.j, this.i, this.f3681a, this.n);
        this.p.a(r1, r2, r13, r15, this);
        b r16 = this.i.a(this.p, null);
        this.n = Math.max(this.n - 1, 0);
        if (r16 == null) goto L22;
    L32:
        a(this.p, r16);
        int r17 = r15.getLength();
        int r9 = 0;
    L33:
        if (r9 >= r17) goto L36;
        a(r16, r15.getURI(r9), r15.getLocalName(r9), r15.getQName(r9), r15.getValue(r9));
        r9 = r9 + 1;
        goto L33
    L36:
        if (r16.b(this.p, null) == false) goto L38;
    L41:
        this.j.d = this.n;
        int r18 = r16.a();
        this.f3681a = r18;
        if (r18 != 1) goto L44;
        this.r.f3638a = new com.ctc.wstx.shaded.msv.relaxng_datatype.a[]{StringType.theInstance};
    L44:
        this.i = r16;
        return;
    L38:
        if (com.ctc.wstx.shaded.msv_core.a.a.a.f3552a == false) goto L40;
        System.out.println("-- required attributes missing: error recovery");
    L40:
        com.ctc.wstx.shaded.msv_core.util.d r19 = new com.ctc.wstx.shaded.msv_core.util.d();
        r16.b(this.p, r19);
        a(r19, a("Verifier.Error.MissingAttribute", new Object[]{r13}), new d.f(this.p));
        goto L41
    L22:
        if (com.ctc.wstx.shaded.msv_core.a.a.a.f3552a == false) goto L24;
        System.out.println("-- no children accepted: error recovery");
    L24:
        com.ctc.wstx.shaded.msv_core.util.d r110 = new com.ctc.wstx.shaded.msv_core.util.d();
        b r111 = this.i.a(this.p, r110);
        ValidityViolation r112 = a(r110, a("Verifier.Error.UnexpectedStartTag", new Object[]{r13}), new d.b(this.p));
        if (r111 == null) goto L27;
        r16 = r111;
        goto L32
    L27:
        if (com.ctc.wstx.shaded.msv_core.a.a.a.f3552a == false) goto L30;
        System.out.println("-- unable to recover");
    L30:
        throw new ValidationUnrecoverableException(r112);
    L14:
        if (r13.length() != 0) goto L16;
    L8:
        if (r12.length() == 0) goto L11;
        r2 = r12;
        goto L12
    }
}
