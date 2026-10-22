package com.tom_roush.pdfbox.pdfparser;

import android.util.Log;
import com.tom_roush.pdfbox.a.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class g extends a {
    private final List<Object> d;
    private final byte[] e;

    public g(com.tom_roush.pdfbox.contentstream.a r3) {
        super(new d(((com.tom_roush.pdfbox.contentstream.a) ZeusTransformUtils.wrapperContextForParams(r3, com.tom_roush.pdfbox.contentstream.a.class, "com.obric.memorydata.plugin")).a()));
        this.d = new ArrayList(100);
        this.e = new byte[10];
    }

    private boolean a(j r13) {
        j r14 = (j) ZeusTransformUtils.wrapperContextForParams(r13, j.class, "com.obric.memorydata.plugin");
        int r2 = 10;
        int r0 = r14.a(this.e, 0, 10);
        boolean r3 = true;
        if (r0 <= 0) goto L50;
        int r5 = 0;
        int r6 = -1;
        int r7 = -1;
    L5:
        if (r5 >= r0) goto L30;
        byte r8 = this.e[r5];
        if (r8 == 0) goto L10;
        if (r8 >= 9) goto L10;
    L13:
        r3 = false;
    L10:
        if (r8 <= 10) goto L14;
        if (r8 >= 32) goto L14;
        if (r8 != 13) goto L13;
    L14:
        if (r6 != (-1)) goto L21;
        if (r8 == 0) goto L21;
        if (r8 == 9) goto L21;
        if (r8 == 32) goto L21;
        if (r8 == 10) goto L21;
        if (r8 == 13) goto L21;
        r6 = r5;
    L29:
        r5 = r5 + 1;
    L21:
        if (r6 == (-1)) goto L29;
        if (r7 != (-1)) goto L29;
        if (r8 == 0) goto L28;
        if (r8 == 9) goto L28;
        if (r8 == 32) goto L28;
        if (r8 == 10) goto L28;
        if (r8 != 13) goto L29;
    L28:
        r7 = r5;
    L30:
        if (r7 == (-1)) goto L39;
        if (r6 == (-1)) goto L39;
        String r9 = new String(this.e, r6, r7 - r6);
        if ("Q".equals(r9) == true) goto L39;
        if ("EMC".equals(r9) == true) goto L39;
        if ("S".equals(r9) == true) goto L39;
        r3 = false;
    L39:
        if (r0 != 10) goto L49;
        if (r6 == (-1)) goto L43;
        if (r7 != (-1)) goto L43;
    L44:
        if (r2 == (-1)) goto L49;
        if (r6 == (-1)) goto L49;
        if ((r2 - r6) <= 3) goto L49;
        r3 = false;
    L43:
        r2 = r7;
    L49:
        r14.b(this.e, 0, r0);
    L50:
        if (r3 == true) goto L52;
        Log.w("PdfBox-Android", "ignoring 'EI' assumed to be in the middle of inline image at stream offset " + r14.b());
    L52:
        return r3;
    }

    private boolean g(int r1) {
        if (r1 != 10) goto L5;
    L10:
        return true;
    L5:
        if (r1 == 13) goto L10;
        if (r1 == 32) goto L10;
        return false;
    }

    private boolean t() {
        return g(this.f16131b.c());
    }

    public Object r() {
        l();
        if (this.f16131b.d() == false) goto L5;
        return null;
    L5:
        char r0 = (char) this.f16131b.c();
        if (r0 == '(') goto L120;
        if (r0 != '+') goto L10;
    L97:
        StringBuilder r1 = new StringBuilder();
        r1.append(r0);
        this.f16131b.a();
        if (r0 != '-') goto L103;
        if (this.f16131b.c() != r0) goto L103;
        this.f16131b.a();
    L103:
        if (r0 == '.') goto L118;
        boolean r2 = true;
    L105:
        char r5 = (char) this.f16131b.c();
        if (Character.isDigit(r5) == true) goto L113;
        if (r2 == false) goto L109;
        if (r5 == '.') goto L113;
    L109:
        if (r5 == '-') goto L113;
        return k.a(r1.toString());
    L113:
        if (r5 == '-') goto L115;
        r1.append(r5);
    L115:
        this.f16131b.a();
        if (r2 == false) goto L105;
        if (r5 != '.') goto L105;
    L118:
        r2 = false;
        goto L105
    L121:
        r2 = false;
        goto L105
    L10:
        if (r0 != '<') goto L12;
        int r3 = this.f16131b.a();
        char r4 = (char) this.f16131b.c();
        this.f16131b.a(r3);
        if (r4 != '<') goto L96;
        return a();
    L96:
        return c();
    L12:
        if (r0 != 'B') goto L14;
        String r6 = g();
        com.tom_roush.pdfbox.contentstream.operator.b r7 = com.tom_roush.pdfbox.contentstream.operator.b.a(r6);
        if (r6.equals("BI") == false) goto L90;
        com.tom_roush.pdfbox.a.d r8 = new com.tom_roush.pdfbox.a.d();
        r7.a(r8);
    L76:
        Object r9 = r();
        if (ZeusTransformUtils.instanceOf(r9, com.tom_roush.pdfbox.a.i.class) == false) goto L83;
        Object r10 = r();
        if (ZeusTransformUtils.instanceOf(r10, com.tom_roush.pdfbox.a.b.class) == false) goto L80;
        r8.a((com.tom_roush.pdfbox.a.i) ZeusTransformUtils.preCheckCast(r9, com.tom_roush.pdfbox.a.i.class, "com.obric.memorydata.plugin"), (com.tom_roush.pdfbox.a.b) ZeusTransformUtils.preCheckCast(r10, com.tom_roush.pdfbox.a.b.class, "com.obric.memorydata.plugin"));
        goto L76
    L80:
        Log.w("PdfBox-Android", "Unexpected token in inline image dictionary at offset " + this.f16131b.b());
    L83:
        if (ZeusTransformUtils.instanceOf(r9, com.tom_roush.pdfbox.contentstream.operator.b.class) == false) goto L90;
        com.tom_roush.pdfbox.contentstream.operator.b r11 = (com.tom_roush.pdfbox.contentstream.operator.b) ZeusTransformUtils.preCheckCast(r9, com.tom_roush.pdfbox.contentstream.operator.b.class, "com.obric.memorydata.plugin");
        if (r11.b() != null) goto L87;
    L88:
        Log.w("PdfBox-Android", "empty inline image at stream offset " + this.f16131b.b());
    L89:
        r7.a(r11.b());
        goto L90
    L87:
        if (r11.b().length != 0) goto L89;
    L90:
        return r7;
    L14:
        if (r0 != 'I') goto L16;
        String r12 = Character.toString((char) this.f16131b.a()) + ((char) this.f16131b.a());
        if (r12.equals("ID") == false) goto L72;
        ByteArrayOutputStream r13 = new ByteArrayOutputStream();
        if (i() == false) goto L58;
        this.f16131b.a();
    L58:
        int r14 = this.f16131b.a();
        int r15 = this.f16131b.a();
    L60:
        if (r14 != 69) goto L67;
        if (r15 != 73) goto L67;
        if (t() == false) goto L67;
        if (a(this.f16131b) == false) goto L67;
    L69:
        com.tom_roush.pdfbox.contentstream.operator.b r16 = com.tom_roush.pdfbox.contentstream.operator.b.a("ID");
        r16.a(r13.toByteArray());
        return r16;
    L67:
        if (this.f16131b.d() == true) goto L69;
        r13.write(r14);
        int r17 = r15;
        r15 = this.f16131b.a();
        r14 = r17;
        goto L60
    L72:
        throw new IOException("Error: Expected operator 'ID' actual='" + r12 + "' at stream offset " + this.f16131b.b());
    L16:
        if (r0 == '[') goto L52;
        if (r0 != ']') goto L20;
        this.f16131b.a();
        return com.tom_roush.pdfbox.a.j.f16062b;
    L20:
        if (r0 != 'f') goto L22;
    L39:
        String r18 = g();
        if (r18.equals("true") == false) goto L44;
        return com.tom_roush.pdfbox.a.c.c;
    L44:
        if (r18.equals("false") == false) goto L48;
        return com.tom_roush.pdfbox.a.c.d;
    L48:
        return com.tom_roush.pdfbox.contentstream.operator.b.a(r18);
    L22:
        if (r0 != 'n') goto L24;
        String r19 = g();
        if (r19.equals("null") == false) goto L38;
        return com.tom_roush.pdfbox.a.j.f16062b;
    L38:
        return com.tom_roush.pdfbox.contentstream.operator.b.a(r19);
    L24:
        if (r0 == 't') goto L39;
        switch(r0) {
            case 45: goto L97;
            case 46: goto L97;
            case 47: goto L32;
            case 48: goto L97;
            case 49: goto L97;
            case 50: goto L97;
            case 51: goto L97;
            case 52: goto L97;
            case 53: goto L97;
            case 54: goto L97;
            case 55: goto L97;
            case 56: goto L97;
            case 57: goto L97;
            default: goto L26;
        };
    L26:
        String r20 = s().trim();
        if (r20.length() > 0) goto L29;
        return null;
    L29:
        return com.tom_roush.pdfbox.contentstream.operator.b.a(r20);
    L32:
        return e();
    L52:
        return d();
    L120:
        return c();
    }

    public String s() {
        l();
        StringBuilder r0 = new StringBuilder(4);
    L3:
        int r1 = this.f16131b.c();
    L5:
        if (r1 == (-1)) goto L30;
        if (d(r1) == true) goto L30;
        if (b(r1) == true) goto L30;
        if (r1 == 91) goto L30;
        if (r1 == 60) goto L30;
        if (r1 == 40) goto L30;
        if (r1 == 47) goto L30;
        if (r1 >= 48) goto L21;
    L22:
        char r2 = (char) this.f16131b.a();
        int r3 = this.f16131b.c();
        r0.append(r2);
        if (r2 != 'd') goto L28;
        if (r3 == 48) goto L27;
        if (r3 != 49) goto L28;
    L27:
        r0.append((char) this.f16131b.a());
    L28:
        r1 = r3;
        goto L5
    L21:
        if (r1 > 57) goto L22;
    L30:
        return r0.toString();
    }
}
