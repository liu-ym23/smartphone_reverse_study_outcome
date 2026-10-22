package com.alibaba.excel.a.c.a.a;

import com.alibaba.excel.c.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/* JADX INFO: loaded from: classes.dex */
public class a extends DefaultHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f132a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private StringBuilder f133b;
    private StringBuilder c;
    private final c d;
    private boolean e;
    private boolean f;

    static {
        f132a = Pattern.compile("_x([0-9A-Fa-f]{4})_");
    }

    public a(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        this.e = false;
        this.f = false;
        this.d = r4;
    }

    static String a(String r5) {
        if (r5 != null) goto L4;
        return r5;
    L4:
        if (r5.contains("_x") == false) goto L21;
        StringBuilder r0 = new StringBuilder();
        Matcher r1 = f132a.matcher(r5);
        int r2 = 0;
    L8:
        if (r1.find() == false) goto L13;
        int r3 = r1.start();
        if (r3 <= r2) goto L12;
        r0.append(r5, r2, r3);
    L12:
        r0.append((char) Integer.decode("0x" + r1.group(1)).intValue());
        r2 = r1.end();
        goto L8
    L13:
        if (r2 != 0) goto L15;
        return r5;
    L15:
        r0.append(r5.substring(r2));
        return r0.toString();
    L21:
        return r5;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] r2, int r3, int r4) {
        if (this.f == true) goto L5;
        return;
    L5:
        if (this.e == false) goto L8;
        return;
    L8:
        if (this.c != null) goto L10;
        this.c = new StringBuilder();
    L10:
        this.c.append(r2, r3, r4);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String r2, String r3, String r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        r4.hashCode();
        byte r5 = -1;
        switch(r4.hashCode()) {
            case -2113441763: goto L40;
            case -1038006813: goto L36;
            case 116: goto L32;
            case 3670: goto L28;
            case 112138: goto L24;
            case 117234: goto L20;
            case 3634328: goto L16;
            case 105063239: goto L12;
            case 112662536: goto L8;
            default: goto L43;
        };
    L43:
        switch(r5) {
            case 0: goto L57;
            case 1: goto L52;
            case 2: goto L46;
            case 3: goto L52;
            case 4: goto L57;
            case 5: goto L46;
            case 6: goto L52;
            case 7: goto L46;
            case 8: goto L57;
            default: goto L61;
        };
    L52:
        StringBuilder r6 = this.f133b;
        c r1 = this.d;
        if (r6 != null) goto L55;
        String r7 = null;
    L56:
        r1.a(r7);
        return;
    L55:
        r7 = a(r6.toString());
        goto L56
    L57:
        this.e = false;
        return;
    L61:
        return;
    L46:
        if (this.c != null) goto L48;
    L51:
        this.f = false;
        return;
    L48:
        if (this.f133b != null) goto L50;
        this.f133b = new StringBuilder();
    L50:
        this.f133b.append(this.c);
        goto L51
    L8:
        if (r4.equals("x:rPh") == false) goto L43;
        r5 = 8;
        goto L43
    L12:
        if (r4.equals("ns2:t") == false) goto L43;
        r5 = 7;
        goto L43
    L16:
        if (r4.equals("x:si") == false) goto L43;
        r5 = 6;
        goto L43
    L20:
        if (r4.equals("x:t") == false) goto L43;
        r5 = 5;
        goto L43
    L24:
        if (r4.equals("rPh") == false) goto L43;
        r5 = 4;
        goto L43
    L28:
        if (r4.equals("si") == false) goto L43;
        r5 = 3;
        goto L43
    L32:
        if (r4.equals("t") == false) goto L43;
        r5 = 2;
        goto L43
    L36:
        if (r4.equals("ns2:si") == false) goto L43;
        r5 = 1;
        goto L43
    L40:
        if (r4.equals("ns2:rPh") == false) goto L43;
        r5 = 0;
        goto L43
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String r1, String r2, String r3, Attributes r4) {
        Attributes r5 = (Attributes) ZeusTransformUtils.wrapperContextForParams(r4, Attributes.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        r3.hashCode();
        byte r6 = -1;
        switch(r3.hashCode()) {
            case -2113441763: goto L41;
            case -1038006813: goto L37;
            case 116: goto L33;
            case 3670: goto L29;
            case 112138: goto L25;
            case 117234: goto L21;
            case 3634328: goto L17;
            case 105063239: goto L13;
            case 112662536: goto L9;
            default: goto L45;
        };
    L9:
        if (r3.equals("x:rPh") == false) goto L45;
        r6 = 8;
        goto L45
    L13:
        if (r3.equals("ns2:t") == false) goto L45;
        r6 = 7;
        goto L45
    L17:
        if (r3.equals("x:si") == false) goto L45;
        r6 = 6;
        goto L45
    L21:
        if (r3.equals("x:t") == false) goto L45;
        r6 = 5;
        goto L45
    L25:
        if (r3.equals("rPh") == false) goto L45;
        r6 = 4;
        goto L45
    L29:
        if (r3.equals("si") == false) goto L45;
        r6 = 3;
        goto L45
    L33:
        if (r3.equals("t") == false) goto L45;
        r6 = 2;
        goto L45
    L37:
        if (r3.equals("ns2:si") == false) goto L45;
        r6 = 1;
        goto L45
    L41:
        if (r3.equals("ns2:rPh") == false) goto L45;
        r6 = 0;
    L45:
        switch(r6) {
            case 0: goto L49;
            case 1: goto L48;
            case 2: goto L47;
            case 3: goto L48;
            case 4: goto L49;
            case 5: goto L47;
            case 6: goto L48;
            case 7: goto L47;
            case 8: goto L49;
            default: goto L53;
        };
    L47:
        this.c = null;
        this.f = true;
        return;
    L48:
        this.f133b = null;
        return;
    L49:
        this.e = true;
        return;
    }
}
