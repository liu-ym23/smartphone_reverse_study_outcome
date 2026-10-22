package org.bouncycastle.asn1.x500.style;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1String;
import org.bouncycastle.asn1.ASN1UniversalString;
import org.bouncycastle.asn1.x500.AttributeTypeAndValue;
import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes7.dex */
public class IETFUtils {
    public static void appendRDN(StringBuffer r4, RDN r5, Hashtable r6) {
        if (r5.isMultiValued() == false) goto L12;
        AttributeTypeAndValue[] r7 = r5.getTypesAndValues();
        boolean r1 = true;
        int r2 = 0;
    L6:
        if (r2 == r7.length) goto L19;
        if (r1 == false) goto L9;
        r1 = false;
    L10:
        appendTypeAndValue(r4, r7[r2], r6);
        r2 = r2 + 1;
        goto L6
    L9:
        r4.append('+');
        goto L10
    L19:
        return;
    L12:
        if (r5.getFirst() == null) goto L18;
        appendTypeAndValue(r4, r5.getFirst(), r6);
        return;
    }

    public static void appendTypeAndValue(StringBuffer r2, AttributeTypeAndValue r3, Hashtable r4) {
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.get(r3.getType()), String.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L6;
        r5 = r3.getType().getId();
    L6:
        r2.append(r5);
        r2.append('=');
        r2.append(valueToString(r3.getValue()));
    }

    private static boolean atvAreEqual(AttributeTypeAndValue r4, AttributeTypeAndValue r5) {
        if (r4 != r5) goto L6;
        return true;
    L6:
        if (r4 == null) goto L16;
        if (r5 == null) goto L16;
        if (r4.getType().equals(r5.getType()) == true) goto L13;
        return false;
    L13:
        if (canonicalString(r4.getValue()).equals(canonicalString(r5.getValue())) == true) goto L15;
        return false;
    L15:
        return true;
    L16:
        return false;
    }

    public static String canonicalString(ASN1Encodable r2) {
        return canonicalize(valueToString((ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r2, ASN1Encodable.class, "com.obric.memorydata.plugin")));
    }

    public static String canonicalize(String r7) {
        int r1 = 0;
        if (r7.length() > 0) goto L5;
    L9:
        String r8 = Strings.toLowerCase(r7);
        int r0 = r8.length();
        if (r0 >= 2) goto L12;
        return r8;
    L12:
        int r2 = r0 - 1;
    L14:
        if (r1 >= r2) goto L20;
        if (r8.charAt(r1) != '\\') goto L20;
        if (r8.charAt(r1 + 1) != ' ') goto L20;
        r1 = r1 + 2;
    L20:
        int r4 = r1 + 1;
        int r5 = r2;
    L21:
        if (r5 <= r4) goto L27;
        if (r8.charAt(r5 - 1) != '\\') goto L27;
        if (r8.charAt(r5) != ' ') goto L27;
        r5 = r5 - 2;
    L27:
        if (r1 > 0) goto L29;
        if (r5 < r2) goto L29;
    L31:
        return stripInternalSpaces(r8);
    L29:
        r8 = r8.substring(r1, r5 + 1);
        goto L31
    L5:
        if (r7.charAt(0) != '#') goto L9;
        ASN1Primitive r3 = decodeObject(r7);
        if (ZeusTransformUtils.instanceOf(r3, ASN1String.class) == false) goto L9;
        r7 = ((ASN1String) ZeusTransformUtils.preCheckCast(r3, ASN1String.class, "com.obric.memorydata.plugin")).getString();
        goto L9
    }

    private static ASN1Primitive decodeObject(String r3) {
        return ASN1Primitive.fromByteArray(Hex.decodeStrict(r3, 1, r3.length() - 1));
    L4:
        e = move-exception;
        throw new IllegalStateException("unknown encoding in name: " + e);
    }

    public static boolean rDNAreEqual(RDN r4, RDN r5) {
        if (r4.size() == r5.size()) goto L5;
        return false;
    L5:
        AttributeTypeAndValue[] r6 = r4.getTypesAndValues();
        AttributeTypeAndValue[] r7 = r5.getTypesAndValues();
        if (r6.length == r7.length) goto L8;
        return false;
    L8:
        int r0 = 0;
    L10:
        if (r0 == r6.length) goto L15;
        if (atvAreEqual(r6[r0], r7[r0]) == false) goto L13;
        r0 = r0 + 1;
        goto L10
    L13:
        return false;
    L15:
        return true;
    }

    public static String stripInternalSpaces(String r5) {
        if (r5.indexOf("  ") >= 0) goto L5;
        return r5;
    L5:
        StringBuffer r0 = new StringBuffer();
        char r1 = r5.charAt(0);
        r0.append(r1);
        int r2 = 1;
    L7:
        if (r2 >= r5.length()) goto L14;
        char r3 = r5.charAt(r2);
        if (r1 != ' ') goto L11;
        if (r3 != ' ') goto L11;
    L12:
        r2 = r2 + 1;
    L11:
        r0.append(r3);
        r1 = r3;
        goto L12
    L14:
        return r0.toString();
    }

    public static String valueToString(ASN1Encodable r8) {
        ASN1Encodable r9 = (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r8, ASN1Encodable.class, "com.obric.memorydata.plugin");
        StringBuffer r0 = new StringBuffer();
        int r5 = 0;
        if (ZeusTransformUtils.instanceOf(r9, ASN1String.class) == true) goto L5;
    L49:
        r0.append('#');     // Catch: IOException -> L47
        r0.append(Hex.toHexString(r9.toASN1Primitive().getEncoded("DER")));     // Catch: IOException -> L47
    L13:
        int r10 = r0.length();
        int r6 = 2;
        if (r0.length() >= 2) goto L16;
    L20:
        r6 = 0;
    L22:
        if (r6 == r10) goto L34;
        char r3 = r0.charAt(r6);
        if (r3 == '\"') goto L32;
        if (r3 == '\\') goto L32;
        if (r3 == '+') goto L32;
        if (r3 == ',') goto L32;
        switch(r3) {
            case 59: goto L32;
            case 60: goto L32;
            case 61: goto L32;
            case 62: goto L32;
            default: goto L31;
        };
    L31:
        r6 = r6 + 1;
    L32:
        r0.insert(r6, "\\");
        r6 = r6 + 2;
        r10 = r10 + 1;
        goto L22
    L34:
        if (r0.length() > 0) goto L36;
    L40:
        int r11 = r0.length() - 1;
    L41:
        if (r11 < r5) goto L46;
        if (r0.charAt(r11) != ' ') goto L46;
        r0.insert(r11, '\\');
        r11 = r11 - 1;
    L46:
        return r0.toString();
    L36:
        if (r0.length() <= r5) goto L40;
        if (r0.charAt(r5) != ' ') goto L40;
        r0.insert(r5, "\\");
        r5 = r5 + 2;
        goto L36
    L16:
        if (r0.charAt(0) != '\\') goto L20;
        if (r0.charAt(1) != '#') goto L20;
    L48:
        throw new IllegalArgumentException("Other value has no encoded form");
    L5:
        if (ZeusTransformUtils.instanceOf(r9, ASN1UniversalString.class) == true) goto L49;
        String r12 = ((ASN1String) ZeusTransformUtils.preCheckCast(r9, ASN1String.class, "com.obric.memorydata.plugin")).getString();
        if (r12.length() > 0) goto L9;
    L11:
        r0.append(r12);
        goto L13
    L9:
        if (r12.charAt(0) != '#') goto L11;
        r0.append('\\');
        goto L11
    }
}
