package org.apache.xmlbeans.impl.common;

import com.bytedance.rpc.internal.RpcUtils;
import com.ctc.wstx.shaded.msv_core.grammar.xmlschema.XMLSchemaSchema;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.xml.namespace.QName;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaType;

/* JADX INFO: loaded from: classes7.dex */
public class QNameHelper {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Map<String, String> WELL_KNOWN_PREFIXES = null;
    private static final char[] hexdigits = null;

    static {
        WELL_KNOWN_PREFIXES = buildWKP();
        hexdigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public QNameHelper() {
    }

    private static Map<String, String> buildWKP() {
        HashMap r0 = new HashMap();
        r0.put("http://www.w3.org/XML/1998/namespace", "xml");
        r0.put("http://www.w3.org/2001/XMLSchema", "xs");
        r0.put(XMLSchemaSchema.XMLSchemaInstanceNamespace, "xsi");
        r0.put("http://schemas.xmlsoap.org/wsdl/", "wsdl");
        r0.put("http://schemas.xmlsoap.org/soap/encoding/", "soapenc");
        r0.put("http://schemas.xmlsoap.org/soap/envelope/", "soapenv");
        return Collections.unmodifiableMap(r0);
    }

    public static QName forLNS(String r1, String r2) {
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        return new QName(r2, r1);
    }

    public static QName forPretty(String r3, int r4) {
        int r0 = r3.indexOf(64, r4);
        if (r0 >= 0) goto L7;
        return new QName("", r3.substring(r4));
    L7:
        return new QName(r3.substring(r0 + 1), r3.substring(r4, r0));
    }

    public static String hexsafe(String r7) {
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r2 >= r7.length()) goto L17;
        char r3 = r7.charAt(r2);
        if (isSafe(r3) == false) goto L36;
        r0.append(r3);
    L15:
        r2 = r2 + 1;
        goto L4
    L36:
        byte[] r4 = r7.substring(r2, r2 + 1).getBytes(RpcUtils.CHARSET_UTF8);     // Catch: UnsupportedEncodingException -> L14
        int r5 = 0;
    L11:
        if (r5 >= r4.length) goto L15;
        r0.append('_');     // Catch: UnsupportedEncodingException -> L14
        char[] r6 = hexdigits;     // Catch: UnsupportedEncodingException -> L14
        r0.append(r6[(r4[r5] >> 4) & 15]);     // Catch: UnsupportedEncodingException -> L14
        r0.append(r6[r4[r5] & 15]);     // Catch: UnsupportedEncodingException -> L14
        r5 = r5 + 1;
    L14:
        r0.append("_BAD_UTF8_CHAR");
        goto L15
    L17:
        if (r0.length() <= 64) goto L19;
        MessageDigest r8 = MessageDigest.getInstance("SHA");     // Catch: NoSuchAlgorithmException -> L30
        byte[] r9 = r7.getBytes(RpcUtils.CHARSET_UTF8);     // Catch: UnsupportedEncodingException -> L23 NoSuchAlgorithmException -> L30
    L24:
        byte[] r10 = r8.digest(r9);     // Catch: NoSuchAlgorithmException -> L30
        StringBuilder r11 = new StringBuilder("URI_SHA_1_");     // Catch: NoSuchAlgorithmException -> L30
    L26:
        if (r1 >= r10.length) goto L28;
        char[] r12 = hexdigits;     // Catch: NoSuchAlgorithmException -> L30
        r11.append(r12[(r10[r1] >> 4) & 15]);     // Catch: NoSuchAlgorithmException -> L30
        r11.append(r12[r10[r1] & 15]);     // Catch: NoSuchAlgorithmException -> L30
        r1 = r1 + 1;     // Catch: NoSuchAlgorithmException -> L30
        goto L26
    L28:
        return r11.toString();
    L23:
        r9 = new byte[0];     // Catch: NoSuchAlgorithmException -> L30
    L31:
        throw new IllegalStateException("Using in a JDK without an SHA implementation");
    L19:
        return r0.toString();
    }

    public static String hexsafedir(QName r2) {
        if (r2.getNamespaceURI() != null) goto L5;
    L10:
        StringBuilder r0 = new StringBuilder();
        String r1 = "_nons/";
    L9:
        return r0.append(r1).append(hexsafe(r2.getLocalPart())).toString();
    L5:
        if (r2.getNamespaceURI().length() == 0) goto L10;
        r0 = new StringBuilder().append(hexsafe(r2.getNamespaceURI()));
        r1 = "/";
        goto L9
    }

    private static boolean isSafe(int r2) {
        if (r2 < 97) goto L8;
        if (r2 > 122) goto L8;
        return true;
    L8:
        if (r2 < 65) goto L13;
        if (r2 > 90) goto L13;
        return true;
    L13:
        if (r2 >= 48) goto L15;
        return false;
    L15:
        if (r2 > 57) goto L19;
        return true;
    L19:
        return false;
    }

    private static boolean isVowel(char r1) {
        if (r1 != 'A') goto L5;
        return true;
    L5:
        if (r1 != 'E') goto L7;
        return true;
    L7:
        if (r1 != 'I') goto L9;
        return true;
    L9:
        if (r1 != 'O') goto L11;
        return true;
    L11:
        if (r1 != 'U') goto L13;
        return true;
    L13:
        if (r1 != 'a') goto L15;
        return true;
    L15:
        if (r1 != 'e') goto L17;
        return true;
    L17:
        if (r1 != 'i') goto L19;
        return true;
    L19:
        if (r1 != 'o') goto L21;
        return true;
    L21:
        if (r1 == 'u') goto L34;
        return false;
    L34:
        return true;
    }

    public static String pretty(QName r2) {
        if (r2 != null) goto L6;
        return "null";
    L6:
        if (r2.getNamespaceURI() == null) goto L13;
        if (r2.getNamespaceURI().length() == 0) goto L13;
        return r2.getLocalPart() + "@" + r2.getNamespaceURI();
    L13:
        return r2.getLocalPart();
    }

    public static String readable(QName r2, Map<String, String> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        if (r2.getNamespaceURI().length() == 0) goto L5;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.get(r2.getNamespaceURI()), String.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L11;
        StringBuilder r6 = new StringBuilder().append(r5).append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        String r7 = r2.getLocalPart();
    L10:
        return r6.append(r7).toString();
    L11:
        r6 = new StringBuilder().append(r2.getLocalPart()).append(" in namespace ");
        r7 = r2.getNamespaceURI();
        goto L10
    L5:
        return r2.getLocalPart();
    }

    public static String readable(SchemaType r2) {
        return readable((SchemaType) ZeusTransformUtils.wrapperContextForParams(r2, SchemaType.class, "com.obric.memorydata.plugin"), WELL_KNOWN_PREFIXES);
    }

    public static String readable(SchemaType r3, Map<String, String> r4) {
        SchemaType r5 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin");
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if (r5.getName() == null) goto L7;
        return readable(r5.getName(), r6);
    L7:
        if (r5.isAttributeType() == false) goto L11;
        return "attribute type " + readable(r5.getAttributeTypeAttributeName(), r6);
    L11:
        if (r5.isDocumentType() == false) goto L15;
        return "document type " + readable(r5.getDocumentElementName(), r6);
    L15:
        if (r5.isNoType() == false) goto L17;
        return "invalid type";
    L17:
        if (r5.getOuterType() == null) goto L50;
        SchemaType r0 = r5.getOuterType();
        SchemaField r1 = r5.getContainerField();
        if (r0.isAttributeType() == false) goto L24;
        return "type of attribute " + readable(r1.getName(), r6);
    L24:
        if (r0.isDocumentType() == true) goto L26;
        if (r1 == null) goto L35;
        if (r1.isAttribute() == false) goto L33;
        return "type of " + r1.getName().getLocalPart() + " attribute in " + readable(r0, r6);
    L33:
        return "type of " + r1.getName().getLocalPart() + " element in " + readable(r0, r6);
    L35:
        if (r0.getBaseType() != r5) goto L39;
        return "base type of " + readable(r0, r6);
    L39:
        if (r0.getSimpleVariety() != 3) goto L43;
        return "item type of " + readable(r0, r6);
    L43:
        if (r0.getSimpleVariety() != 2) goto L47;
        return "member type " + r5.getAnonymousUnionMemberOrdinal() + " of " + readable(r0, r6);
    L47:
        return "inner type in " + readable(r0, r6);
    L26:
        return "type of element " + readable(r1.getName(), r6);
    L50:
        return "invalid type";
    }

    private static boolean startsWithXml(String r4, int r5) {
        if (r4.length() >= (r5 + 3)) goto L6;
        return false;
    L6:
        if (r4.charAt(r5) != 'X') goto L8;
    L10:
        int r0 = r5 + 1;
        if (r4.charAt(r0) != 'M') goto L13;
    L15:
        int r6 = r5 + 2;
        if (r4.charAt(r6) != 'L') goto L18;
        return true;
    L18:
        if (r4.charAt(r6) == 'l') goto L22;
        return false;
    L22:
        return true;
    L13:
        if (r4.charAt(r0) == 'm') goto L15;
        return false;
    L8:
        if (r4.charAt(r5) == 'x') goto L10;
        return false;
    }

    public static String suggestPrefix(String r7) {
        String r0 = (String) ZeusTransformUtils.preCheckCast(WELL_KNOWN_PREFIXES.get(r7), String.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        return r0;
    L5:
        int r1 = r7.length();
        int r2 = r7.lastIndexOf(47);
        if (r2 > 0) goto L8;
    L10:
        int r3 = r2 + 1;
        if (r7.startsWith("www.", r3) == false) goto L13;
        r3 = r3 + 4;
    L13:
        if (r3 >= r1) goto L18;
        if (XMLChar.isNCNameStart(r7.charAt(r3)) == true) goto L18;
        r3 = r3 + 1;
    L18:
        int r4 = r3 + 1;
    L19:
        if (r4 >= r1) goto L27;
        if (XMLChar.isNCName(r7.charAt(r4)) == false) goto L26;
        if (Character.isLetterOrDigit(r7.charAt(r4)) == false) goto L26;
        r4 = r4 + 1;
    L26:
        r1 = r4;
    L27:
        int r5 = r3 + 3;
        if (r7.length() < r5) goto L37;
        if (startsWithXml(r7, r3) == false) goto L37;
        if (r7.length() >= (r3 + 4)) goto L34;
        return "ns";
    L34:
        return "x" + Character.toLowerCase(r7.charAt(r5));
    L37:
        if ((r1 - r3) <= 4) goto L45;
        if (isVowel(r7.charAt(r3 + 2)) == true) goto L41;
    L43:
        r1 = r5;
        goto L45
    L41:
        if (isVowel(r7.charAt(r5)) == true) goto L43;
        r1 = r3 + 4;
    L45:
        if ((r1 - r3) != 0) goto L48;
        return "ns";
    L48:
        return r7.substring(r3, r1).toLowerCase(Locale.ROOT);
    L8:
        if (r2 != (r7.length() - 1)) goto L10;
        r2 = r7.lastIndexOf(47, r2 - 1);
        r1 = r2;
        goto L10
    }
}
