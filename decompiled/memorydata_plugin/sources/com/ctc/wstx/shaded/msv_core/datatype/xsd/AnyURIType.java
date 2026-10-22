package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
public class AnyURIType extends BuiltinAtomicType implements c {
    private static final boolean[] isUric = null;
    static final com.ctc.wstx.shaded.msv_core.datatype.xsd.a.a regexp = null;
    private static final long serialVersionUID = 1;
    public static final AnyURIType theInstance = null;

    static {
        theInstance = new AnyURIType();
        isUric = createUricMap();
        regexp = createRegExp();
    }

    private AnyURIType() {
        super("anyURI");
    }

    private static void appendByte(StringBuffer r1, int r2) {
        r1.append('%');
        appendHex(r1, r2 / 16);
        appendHex(r1, r2 % 16);
    }

    private static void appendEscaped(StringBuffer r1, char r2) {
        if (r2 >= 127) goto L7;
        appendByte(r1, r2);
        return;
    L7:
        if (r2 >= 2047) goto L11;
        appendByte(r1, (r2 >> 6) + 192);
        appendByte(r1, (r2 % '@') + 128);
        return;
    L11:
        if (r2 >= 65535) goto L14;
        appendByte(r1, (r2 >> '\f') + 224);
        appendByte(r1, ((r2 >> 6) % 64) + 128);
        appendByte(r1, (r2 % '@') + 128);
        return;
    }

    private static void appendEscaped(StringBuffer r0, char r1, char r2) {
        int r3 = ((r1 & 1023) << 10) + (r2 & 1023);
        appendByte(r0, (r3 >> 18) + 240);
        appendByte(r0, ((r3 >> 12) % 64) + 128);
        appendByte(r0, ((r3 >> 6) % 64) + 128);
        appendByte(r0, (r3 % 64) + 128);
    }

    private static void appendHex(StringBuffer r1, int r2) {
        if (r2 >= 10) goto L5;
        int r3 = r2 + 48;
    L6:
        r1.append((char) r3);
        return;
    L5:
        r3 = (r2 - 10) + 65;
        goto L6
    }

    static com.ctc.wstx.shaded.msv_core.datatype.xsd.a.a createRegExp() {
        String r0 = "%[0-9a-fA-F]{2}";
        String r2 = "([0-9a-zA-Z]|[\\-_\\.!~\\*'\\(\\)])";
        String r6 = "([;/\\?:@&=\\+$,\\[\\]]|" + r2 + "|" + r0 + ")";
        String r7 = r6 + "*";
        String r9 = r6 + "*";
        String r8 = ("(" + r2 + "|" + r0 + "|[:@&=\\+$,])") + "*";
        String r10 = "(" + r8 + "(;" + r8 + ")*)";
        String r11 = "[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}";
        String r1 = "[0-9a-fA-F]{1,4}";
        String r3 = r1 + "(:" + r1 + ")*";
        String r4 = "(" + ("[0-9a-zA-Z]([0-9A-Za-z\\-]*[0-9a-zA-Z])?") + "\\.)*" + ("[a-zA-Z]([0-9A-Za-z\\-]*[0-9a-zA-Z])?") + "(\\.)?";
        String r5 = ("((" + r4 + ")|(" + r11 + ")|(" + ("\\[" + ("((" + ("((" + r3 + "(::(" + r3 + ")?)?)|(::(" + r3 + ")?))") + "(:" + r11 + ")?)|(::" + r11 + "))") + "\\]") + "))") + "(:[0-9]*)?";
        String r12 = "((" + ("((" + ("(" + r2 + "|" + r0 + "|[;:&=\\+$,])*") + "@)?" + r5 + ")?") + ")|(" + ("(" + r2 + "|" + r0 + "|[$,;:@&=\\+])+") + "))";
        String r13 = "/" + ("(" + r10 + "(/" + r10 + ")*)");
        String r14 = ("(" + r2 + "|" + r0 + "|[;@&=\\+$,])+") + "(" + r13 + ")?";
        String r15 = "//" + r12 + "(" + r13 + ")?";
        String r16 = ("(" + r2 + "|" + r0 + "|[;\\?:@&=\\+$,])") + "(" + r6 + ")*";
        String r17 = "((" + r15 + ")|(" + r13 + "))(\\?" + r9 + ")?";
        String r18 = ("[a-zA-Z][A-Za-z0-9\\+\\-\\.]*") + ":((" + r17 + ")|(" + r16 + "))";
        return com.ctc.wstx.shaded.msv_core.datatype.xsd.a.b.a().a("(" + r18 + "|" + ("((" + r15 + ")|(" + r13 + ")|(" + r14 + "))(\\?" + r9 + ")?") + ")?(#" + r7 + ")?");
    L6:
        throw new Error();
    }

    private static boolean[] createUricMap() {
        boolean[] r0 = new boolean[128];
        int r1 = 97;
    L4:
        if (r1 > 122) goto L6;
        r0[r1] = true;
        r1 = r1 + 1;
        goto L4
    L6:
        int r2 = 65;
    L8:
        if (r2 > 90) goto L10;
        r0[r2] = true;
        r2 = r2 + 1;
        goto L8
    L10:
        int r3 = 48;
    L12:
        if (r3 > 57) goto L14;
        r0[r3] = true;
        r3 = r3 + 1;
        goto L12
    L14:
        char[] r4 = {'-', '_', '.', '!', '~', '*', '\'', '(', ')', '#', '%', '[', ']'};
        int r5 = 0;
        int r6 = 0;
    L15:
        if (r6 >= 13) goto L17;
        r0[r4[r6]] = true;
        r6 = r6 + 1;
        goto L15
    L17:
        char[] r7 = {';', '/', '?', ':', '@', Typography.amp, '=', '+', Typography.dollar, ','};
    L18:
        if (r5 >= 10) goto L20;
        r0[r7[r5]] = true;
        r5 = r5 + 1;
        goto L18
    L20:
        return r0;
    }

    public static String escape(String r4) {
        StringBuffer r0 = new StringBuffer(r4.length());
        int r1 = 0;
    L4:
        if (r1 >= r4.length()) goto L18;
        char r2 = r4.charAt(r1);
        if (r2 >= 128) goto L11;
        if (isUric[r2] == false) goto L11;
        r0.append(r2);
    L16:
        r1 = r1 + 1;
    L11:
        if (55296 <= r2) goto L13;
    L15:
        appendEscaped(r0, r2);
        goto L16
    L13:
        if (r2 >= 56320) goto L15;
        r1 = r1 + 1;
        appendEscaped(r0, r2, r4.charAt(r1));
        goto L16
    L18:
        return new String(r0);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public Object _createValue(String r2, com.ctc.wstx.shaded.msv.relaxng_datatype.e r3) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r1 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        if (regexp.a(escape(r2)) == true) goto L6;
        return null;
    L6:
        return r2;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public boolean checkFormat(String r2, com.ctc.wstx.shaded.msv.relaxng_datatype.e r3) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r1 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        return regexp.a(escape(r2));
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public String convertToLexicalValue(Object r2, com.ctc.wstx.shaded.msv_core.datatype.c r3) {
        com.ctc.wstx.shaded.msv_core.datatype.c r1 = (com.ctc.wstx.shaded.msv_core.datatype.c) ZeusTransformUtils.wrapperContextForParams(r3, com.ctc.wstx.shaded.msv_core.datatype.c.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L7;
        return (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin");
    L7:
        throw new IllegalArgumentException();
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.c
    public final int countLength(Object r2) {
        return e.a((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public XSDatatype getBaseType() {
        return SimpleURType.theInstance;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.a
    public Class getJavaObjectType() {
        return String.class;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final int isFacetApplicable(String r1) {
        if (r1.equals(XSDatatype.FACET_LENGTH) == false) goto L5;
        return 0;
    L5:
        if (r1.equals(XSDatatype.FACET_MINLENGTH) == false) goto L7;
        return 0;
    L7:
        if (r1.equals(XSDatatype.FACET_MAXLENGTH) == false) goto L9;
        return 0;
    L9:
        if (r1.equals(XSDatatype.FACET_PATTERN) == false) goto L11;
        return 0;
    L11:
        if (r1.equals(XSDatatype.FACET_WHITESPACE) == false) goto L13;
        return 0;
    L13:
        if (r1.equals(XSDatatype.FACET_ENUMERATION) == true) goto L23;
        return -2;
    L23:
        return 0;
    }
}
