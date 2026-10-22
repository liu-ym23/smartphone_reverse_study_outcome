package org.bouncycastle.asn1.x509;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.memory.ui.list.PendingPersonalInfoNotificationTask;
import com.tom_roush.pdfbox.pdmodel.a.d.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1String;
import org.bouncycastle.asn1.ASN1UniversalString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes7.dex */
public class X509Name extends ASN1Object {
    public static final ASN1ObjectIdentifier BUSINESS_CATEGORY = null;
    public static final ASN1ObjectIdentifier C = null;
    public static final ASN1ObjectIdentifier CN = null;
    public static final ASN1ObjectIdentifier COUNTRY_OF_CITIZENSHIP = null;
    public static final ASN1ObjectIdentifier COUNTRY_OF_RESIDENCE = null;
    public static final ASN1ObjectIdentifier DATE_OF_BIRTH = null;
    public static final ASN1ObjectIdentifier DC = null;
    public static final ASN1ObjectIdentifier DMD_NAME = null;
    public static final ASN1ObjectIdentifier DN_QUALIFIER = null;
    public static final Hashtable DefaultLookUp = null;
    public static boolean DefaultReverse;
    public static final Hashtable DefaultSymbols = null;
    public static final ASN1ObjectIdentifier E = null;
    public static final ASN1ObjectIdentifier EmailAddress = null;
    private static final Boolean FALSE = null;
    public static final ASN1ObjectIdentifier GENDER = null;
    public static final ASN1ObjectIdentifier GENERATION = null;
    public static final ASN1ObjectIdentifier GIVENNAME = null;
    public static final ASN1ObjectIdentifier INITIALS = null;
    public static final ASN1ObjectIdentifier L = null;
    public static final ASN1ObjectIdentifier NAME = null;
    public static final ASN1ObjectIdentifier NAME_AT_BIRTH = null;
    public static final ASN1ObjectIdentifier O = null;
    public static final Hashtable OIDLookUp = null;
    public static final ASN1ObjectIdentifier OU = null;
    public static final ASN1ObjectIdentifier PLACE_OF_BIRTH = null;
    public static final ASN1ObjectIdentifier POSTAL_ADDRESS = null;
    public static final ASN1ObjectIdentifier POSTAL_CODE = null;
    public static final ASN1ObjectIdentifier PSEUDONYM = null;
    public static final Hashtable RFC1779Symbols = null;
    public static final Hashtable RFC2253Symbols = null;
    public static final ASN1ObjectIdentifier SERIALNUMBER = null;
    public static final ASN1ObjectIdentifier SN = null;
    public static final ASN1ObjectIdentifier ST = null;
    public static final ASN1ObjectIdentifier STREET = null;
    public static final ASN1ObjectIdentifier SURNAME = null;
    public static final Hashtable SymbolLookUp = null;
    public static final ASN1ObjectIdentifier T = null;
    public static final ASN1ObjectIdentifier TELEPHONE_NUMBER = null;
    private static final Boolean TRUE = null;
    public static final ASN1ObjectIdentifier UID = null;
    public static final ASN1ObjectIdentifier UNIQUE_IDENTIFIER = null;
    public static final ASN1ObjectIdentifier UnstructuredAddress = null;
    public static final ASN1ObjectIdentifier UnstructuredName = null;
    private Vector added;
    private X509NameEntryConverter converter;
    private int hashCodeValue;
    private boolean isHashCodeCalculated;
    private Vector ordering;
    private ASN1Sequence seq;
    private Vector values;

    static {
        ASN1ObjectIdentifier r0 = new ASN1ObjectIdentifier("2.5.4.6");
        C = r0;
        ASN1ObjectIdentifier r1 = new ASN1ObjectIdentifier("2.5.4.10");
        O = r1;
        ASN1ObjectIdentifier r2 = new ASN1ObjectIdentifier("2.5.4.11");
        OU = r2;
        ASN1ObjectIdentifier r3 = new ASN1ObjectIdentifier("2.5.4.12");
        T = r3;
        ASN1ObjectIdentifier r4 = new ASN1ObjectIdentifier("2.5.4.3");
        CN = r4;
        ASN1ObjectIdentifier r5 = new ASN1ObjectIdentifier("2.5.4.5");
        SN = r5;
        ASN1ObjectIdentifier r6 = new ASN1ObjectIdentifier("2.5.4.9");
        STREET = r6;
        SERIALNUMBER = r5;
        ASN1ObjectIdentifier r7 = new ASN1ObjectIdentifier("2.5.4.7");
        L = r7;
        ASN1ObjectIdentifier r8 = new ASN1ObjectIdentifier("2.5.4.8");
        ST = r8;
        ASN1ObjectIdentifier r9 = new ASN1ObjectIdentifier("2.5.4.4");
        SURNAME = r9;
        ASN1ObjectIdentifier r10 = new ASN1ObjectIdentifier("2.5.4.42");
        GIVENNAME = r10;
        ASN1ObjectIdentifier r11 = new ASN1ObjectIdentifier("2.5.4.43");
        INITIALS = r11;
        ASN1ObjectIdentifier r12 = new ASN1ObjectIdentifier("2.5.4.44");
        GENERATION = r12;
        ASN1ObjectIdentifier r13 = new ASN1ObjectIdentifier("2.5.4.45");
        UNIQUE_IDENTIFIER = r13;
        ASN1ObjectIdentifier r14 = new ASN1ObjectIdentifier("2.5.4.15");
        BUSINESS_CATEGORY = r14;
        ASN1ObjectIdentifier r15 = new ASN1ObjectIdentifier("2.5.4.17");
        POSTAL_CODE = r15;
        ASN1ObjectIdentifier r16 = new ASN1ObjectIdentifier("2.5.4.46");
        DN_QUALIFIER = r16;
        ASN1ObjectIdentifier r17 = new ASN1ObjectIdentifier("2.5.4.65");
        PSEUDONYM = r17;
        ASN1ObjectIdentifier r18 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.1");
        DATE_OF_BIRTH = r18;
        ASN1ObjectIdentifier r19 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.2");
        PLACE_OF_BIRTH = r19;
        ASN1ObjectIdentifier r110 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.3");
        GENDER = r110;
        ASN1ObjectIdentifier r111 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.4");
        COUNTRY_OF_CITIZENSHIP = r111;
        ASN1ObjectIdentifier r112 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.5");
        COUNTRY_OF_RESIDENCE = r112;
        ASN1ObjectIdentifier r113 = new ASN1ObjectIdentifier("1.3.36.8.3.14");
        NAME_AT_BIRTH = r113;
        ASN1ObjectIdentifier r114 = new ASN1ObjectIdentifier("2.5.4.16");
        POSTAL_ADDRESS = r114;
        DMD_NAME = new ASN1ObjectIdentifier("2.5.4.54");
        ASN1ObjectIdentifier r115 = X509ObjectIdentifiers.id_at_telephoneNumber;
        TELEPHONE_NUMBER = r115;
        ASN1ObjectIdentifier r116 = X509ObjectIdentifiers.id_at_name;
        NAME = r116;
        ASN1ObjectIdentifier r117 = PKCSObjectIdentifiers.pkcs_9_at_emailAddress;
        EmailAddress = r117;
        ASN1ObjectIdentifier r118 = PKCSObjectIdentifiers.pkcs_9_at_unstructuredName;
        UnstructuredName = r118;
        ASN1ObjectIdentifier r119 = PKCSObjectIdentifiers.pkcs_9_at_unstructuredAddress;
        UnstructuredAddress = r119;
        E = r117;
        ASN1ObjectIdentifier r120 = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.25");
        DC = r120;
        ASN1ObjectIdentifier r121 = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.1");
        UID = r121;
        DefaultReverse = false;
        Hashtable r122 = new Hashtable();
        DefaultSymbols = r122;
        Hashtable r123 = new Hashtable();
        RFC2253Symbols = r123;
        Hashtable r124 = new Hashtable();
        RFC1779Symbols = r124;
        Hashtable r125 = new Hashtable();
        DefaultLookUp = r125;
        OIDLookUp = r122;
        SymbolLookUp = r125;
        TRUE = new Boolean(true);
        FALSE = new Boolean(false);
        r122.put(r0, "C");
        r122.put(r1, "O");
        r122.put(r3, ExifInterface.GPS_DIRECTION_TRUE);
        r122.put(r2, "OU");
        r122.put(r4, "CN");
        r122.put(r7, i.u);
        r122.put(r8, "ST");
        r122.put(r5, "SERIALNUMBER");
        r122.put(r117, ExifInterface.LONGITUDE_EAST);
        r122.put(r120, "DC");
        r122.put(r121, "UID");
        r122.put(r6, "STREET");
        r122.put(r9, "SURNAME");
        r122.put(r10, "GIVENNAME");
        r122.put(r11, "INITIALS");
        r122.put(r12, "GENERATION");
        r122.put(r119, "unstructuredAddress");
        r122.put(r118, "unstructuredName");
        r122.put(r13, "UniqueIdentifier");
        r122.put(r16, "DN");
        r122.put(r17, "Pseudonym");
        r122.put(r114, "PostalAddress");
        r122.put(r113, "NameAtBirth");
        r122.put(r111, "CountryOfCitizenship");
        r122.put(r112, "CountryOfResidence");
        r122.put(r110, "Gender");
        r122.put(r19, "PlaceOfBirth");
        r122.put(r18, "DateOfBirth");
        r122.put(r15, "PostalCode");
        r122.put(r14, "BusinessCategory");
        r122.put(r115, "TelephoneNumber");
        r122.put(r116, "Name");
        r123.put(r0, "C");
        r123.put(r1, "O");
        r123.put(r2, "OU");
        r123.put(r4, "CN");
        r123.put(r7, i.u);
        r123.put(r8, "ST");
        r123.put(r6, "STREET");
        r123.put(r120, "DC");
        r123.put(r121, "UID");
        r124.put(r0, "C");
        r124.put(r1, "O");
        r124.put(r2, "OU");
        r124.put(r4, "CN");
        r124.put(r7, i.u);
        r124.put(r8, "ST");
        r124.put(r6, "STREET");
        r125.put("c", r0);
        r125.put("o", r1);
        r125.put("t", r3);
        r125.put("ou", r2);
        r125.put("cn", r4);
        r125.put("l", r7);
        r125.put("st", r8);
        r125.put("sn", r5);
        r125.put("serialnumber", r5);
        r125.put("street", r6);
        r125.put("emailaddress", r117);
        r125.put("dc", r120);
        r125.put("e", r117);
        r125.put("uid", r121);
        r125.put("surname", r9);
        r125.put("givenname", r10);
        r125.put("initials", r11);
        r125.put(PendingPersonalInfoNotificationTask.KEY_GENERATION, r12);
        r125.put("unstructuredaddress", r119);
        r125.put("unstructuredname", r118);
        r125.put("uniqueidentifier", r13);
        r125.put("dn", r16);
        r125.put("pseudonym", r17);
        r125.put("postaladdress", r114);
        r125.put("nameofbirth", r113);
        r125.put("countryofcitizenship", r111);
        r125.put("countryofresidence", r112);
        r125.put("gender", r110);
        r125.put("placeofbirth", r19);
        r125.put("dateofbirth", r18);
        r125.put("postalcode", r15);
        r125.put("businesscategory", r14);
        r125.put("telephonenumber", r115);
        r125.put(ActivityLifecycle.NAME, r116);
    }

    public X509Name() {
        this.converter = null;
        this.ordering = new Vector();
        this.values = new Vector();
        this.added = new Vector();
    }

    public X509Name(ASN1Sequence r9) {
        this.converter = null;
        this.ordering = new Vector();
        this.values = new Vector();
        this.added = new Vector();
        this.seq = r9;
        Enumeration r10 = r9.getObjects();
    L4:
        if (r10.hasMoreElements() == false) goto L31;
        ASN1Set r0 = ASN1Set.getInstance(((ASN1Encodable) ZeusTransformUtils.preCheckCast(r10.nextElement(), ASN1Encodable.class, "com.obric.memorydata.plugin")).toASN1Primitive());
        int r3 = 0;
    L7:
        if (r3 >= r0.size()) goto L4;
        ASN1Sequence r4 = ASN1Sequence.getInstance(r0.getObjectAt(r3).toASN1Primitive());
        if (r4.size() != 2) goto L30;
        this.ordering.addElement(ASN1ObjectIdentifier.getInstance(r4.getObjectAt(0)));
        ASN1Encodable r5 = r4.getObjectAt(1);
        if (ZeusTransformUtils.instanceOf(r5, ASN1String.class) == true) goto L13;
    L32:
        this.values.addElement("#" + bytesToString(Hex.encode(r5.toASN1Primitive().getEncoded("DER"))));     // Catch: IOException -> L27
    L22:
        Vector r6 = this.added;
        if (r3 == 0) goto L25;
        Boolean r7 = TRUE;
    L26:
        r6.addElement(r7);
        r3 = r3 + 1;
        goto L7
    L25:
        r7 = FALSE;
    L28:
        throw new IllegalArgumentException("cannot encode value");
    L13:
        if (ZeusTransformUtils.instanceOf(r5, ASN1UniversalString.class) == true) goto L32;
        String r8 = ((ASN1String) ZeusTransformUtils.preCheckCast(r5, ASN1String.class, "com.obric.memorydata.plugin")).getString();
        if (r8.length() > 0) goto L17;
    L19:
        Vector r11 = this.values;
    L20:
        r11.addElement(r8);
        goto L22
    L17:
        if (r8.charAt(0) != '#') goto L19;
        r11 = this.values;
        r8 = "\\" + r8;
        goto L20
    L30:
        throw new IllegalArgumentException("badly sized pair");
    }

    private void appendValue(StringBuffer r3, Hashtable r4, ASN1ObjectIdentifier r5, String r6) {
        String r2 = (String) ZeusTransformUtils.preCheckCast(r4.get(r5), String.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L6;
        r2 = r5.getId();
    L6:
        r3.append(r2);
        r3.append('=');
        int r7 = r3.length();
        r3.append(r6);
        int r8 = r3.length();
        if (r6.length() < 2) goto L14;
        if (r6.charAt(0) != '\\') goto L14;
        if (r6.charAt(1) != '#') goto L14;
        r7 = r7 + 2;
    L14:
        if (r7 >= r8) goto L18;
        if (r3.charAt(r7) != ' ') goto L18;
        r3.insert(r7, "\\");
        r7 = r7 + 2;
        r8 = r8 + 1;
    L18:
        r8 = r8 - 1;
        if (r8 <= r7) goto L23;
        if (r3.charAt(r8) != ' ') goto L23;
        r3.insert(r8, '\\');
    L23:
        if (r7 > r8) goto L34;
        char r9 = r3.charAt(r7);
        if (r9 == '\"') goto L33;
        if (r9 == '\\') goto L33;
        if (r9 == '+') goto L33;
        if (r9 == ',') goto L33;
        switch(r9) {
            case 59: goto L33;
            case 60: goto L33;
            case 61: goto L33;
            case 62: goto L33;
            default: goto L32;
        };
    L32:
        r7 = r7 + 1;
    L33:
        r3.insert(r7, "\\");
        r7 = r7 + 2;
        r8 = r8 + 1;
        goto L23
    }

    private String bytesToString(byte[] r4) {
        int r3 = r4.length;
        char[] r0 = new char[r3];
        int r1 = 0;
    L3:
        if (r1 == r3) goto L6;
        r0[r1] = (char) (r4[r1] & 255);
        r1 = r1 + 1;
        goto L3
    L6:
        return new String(r0);
    }

    private String canonicalize(String r3) {
        String r4 = Strings.toLowerCase(r3.trim());
        if (r4.length() > 0) goto L5;
        return r4;
    L5:
        if (r4.charAt(0) != '#') goto L11;
        ASN1Primitive r2 = decodeObject(r4);
        if (ZeusTransformUtils.instanceOf(r2, ASN1String.class) == true) goto L9;
        return r4;
    L9:
        return Strings.toLowerCase(((ASN1String) ZeusTransformUtils.preCheckCast(r2, ASN1String.class, "com.obric.memorydata.plugin")).getString().trim());
    L11:
        return r4;
    }

    private ASN1Primitive decodeObject(String r3) {
        return ASN1Primitive.fromByteArray(Hex.decodeStrict(r3, 1, r3.length() - 1));
    L4:
        e = move-exception;
        throw new IllegalStateException("unknown encoding in name: " + e);
    }

    private boolean equivalentStrings(String r2, String r3) {
        String r4 = canonicalize(r2);
        String r5 = canonicalize(r3);
        if (r4.equals(r5) == false) goto L5;
        return true;
    L5:
        if (stripInternalSpaces(r4).equals(stripInternalSpaces(r5)) == true) goto L10;
        return false;
    L10:
        return true;
    }

    public static X509Name getInstance(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, X509Name.class) == false) goto L7;
        return (X509Name) ZeusTransformUtils.preCheckCast(r3, X509Name.class, "com.obric.memorydata.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r3, X500Name.class) == true) goto L9;
        if (r3 != null) goto L12;
        return null;
    L12:
        return new X509Name(ASN1Sequence.getInstance(r3));
    L9:
        return new X509Name(ASN1Sequence.getInstance(((X500Name) ZeusTransformUtils.preCheckCast(r3, X500Name.class, "com.obric.memorydata.plugin")).toASN1Primitive()));
    }

    private String stripInternalSpaces(String r5) {
        StringBuffer r4 = new StringBuffer();
        if (r5.length() == 0) goto L13;
        char r0 = r5.charAt(0);
        r4.append(r0);
        int r1 = 1;
    L6:
        if (r1 >= r5.length()) goto L13;
        char r2 = r5.charAt(r1);
        if (r0 != ' ') goto L10;
        if (r2 != ' ') goto L10;
    L11:
        r1 = r1 + 1;
        r0 = r2;
    L10:
        r4.append(r2);
    L13:
        return r4.toString();
    }

    @Override // org.bouncycastle.asn1.ASN1Object
    public boolean equals(Object r14) {
        if (r14 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r14, X509Name.class) == true) goto L11;
        if (ZeusTransformUtils.instanceOf(r14, ASN1Sequence.class) == true) goto L11;
        return false;
    L11:
        if (toASN1Primitive().equals(((ASN1Encodable) ZeusTransformUtils.preCheckCast(r14, ASN1Encodable.class, "com.obric.memorydata.plugin")).toASN1Primitive()) == false) goto L39;
        return true;
    L39:
        X509Name r15 = getInstance(r14);     // Catch: IllegalArgumentException -> L38
        int r1 = this.ordering.size();
        if (r1 == r15.ordering.size()) goto L17;
        return false;
    L17:
        boolean[] r4 = new boolean[r1];
        int r6 = -1;
        if (this.ordering.elementAt(0).equals(r15.ordering.elementAt(0)) == false) goto L20;
        int r7 = 1;
        r6 = r1;
        int r5 = 0;
    L21:
        if (r5 == r6) goto L37;
        ASN1ObjectIdentifier r8 = (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(this.ordering.elementAt(r5), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
        String r9 = (String) ZeusTransformUtils.preCheckCast(this.values.elementAt(r5), String.class, "com.obric.memorydata.plugin");
        int r10 = 0;
    L23:
        if (r10 >= r1) goto L33;
        if (r4[r10] == true) goto L32;
        if (r8.equals((ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(r15.ordering.elementAt(r10), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin")) == false) goto L32;
        if (equivalentStrings(r9, (String) ZeusTransformUtils.preCheckCast(r15.values.elementAt(r10), String.class, "com.obric.memorydata.plugin")) == false) goto L32;
        r4[r10] = true;
        boolean r11 = true;
    L34:
        if (r11 == false) goto L35;
        r5 = r5 + r7;
        goto L21
    L35:
        return false;
    L32:
        r10 = r10 + 1;
        goto L23
    L33:
        r11 = false;
        goto L34
    L37:
        return true;
    L20:
        r5 = r1 - 1;
        r7 = -1;
    L38:
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        if (this.isHashCodeCalculated == true) goto L5;
        this.isHashCodeCalculated = true;
        int r0 = 0;
    L8:
        if (r0 == this.ordering.size()) goto L11;
        String r1 = stripInternalSpaces(canonicalize((String) ZeusTransformUtils.preCheckCast(this.values.elementAt(r0), String.class, "com.obric.memorydata.plugin")));
        int r2 = this.hashCodeValue ^ this.ordering.elementAt(r0).hashCode();
        this.hashCodeValue = r2;
        this.hashCodeValue = r1.hashCode() ^ r2;
        r0 = r0 + 1;
        goto L8
    L11:
        return this.hashCodeValue;
    L5:
        return this.hashCodeValue;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        if (this.seq != null) goto L17;
        ASN1EncodableVector r0 = new ASN1EncodableVector();
        ASN1EncodableVector r1 = new ASN1EncodableVector();
        ASN1ObjectIdentifier r2 = null;
        int r3 = 0;
    L6:
        if (r3 == this.ordering.size()) goto L15;
        ASN1EncodableVector r4 = new ASN1EncodableVector(2);
        ASN1ObjectIdentifier r5 = (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(this.ordering.elementAt(r3), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
        r4.add(r5);
        String r6 = (String) ZeusTransformUtils.preCheckCast(this.values.elementAt(r3), String.class, "com.obric.memorydata.plugin");
        r4.add(this.converter.getConvertedValue(r5, r6));
        if (r2 != null) goto L10;
    L13:
        DERSequence r7 = new DERSequence(r4);
    L14:
        r1.add(r7);
        r3 = r3 + 1;
        r2 = r5;
        goto L6
    L10:
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.added.elementAt(r3), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L13;
        r0.add(new DERSet(r1));
        r1 = new ASN1EncodableVector();
        r7 = new DERSequence(r4);
        goto L14
    L15:
        r0.add(new DERSet(r1));
        this.seq = new DERSequence(r0);
    L17:
        return this.seq;
    }

    public String toString() {
        return toString(DefaultReverse, DefaultSymbols);
    }

    public String toString(boolean r10, Hashtable r11) {
        StringBuffer r0 = new StringBuffer();
        Vector r1 = new Vector();
        StringBuffer r3 = null;
        int r4 = 0;
    L4:
        if (r4 >= this.ordering.size()) goto L10;
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.added.elementAt(r4), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L8;
        r3.append('+');
        appendValue(r3, r11, (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(this.ordering.elementAt(r4), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(this.values.elementAt(r4), String.class, "com.obric.memorydata.plugin"));
    L9:
        r4 = r4 + 1;
        goto L4
    L8:
        r3 = new StringBuffer();
        appendValue(r3, r11, (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(this.ordering.elementAt(r4), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(this.values.elementAt(r4), String.class, "com.obric.memorydata.plugin"));
        r1.addElement(r3);
        goto L9
    L10:
        boolean r12 = true;
        if (r10 == false) goto L18;
        int r13 = r1.size() - 1;
    L13:
        if (r13 < 0) goto L26;
        if (r12 == false) goto L16;
        r12 = false;
    L17:
        r0.append(r1.elementAt(r13).toString());
        r13 = r13 - 1;
        goto L13
    L16:
        r0.append(',');
    L26:
        return r0.toString();
    L18:
        int r14 = 0;
    L20:
        if (r14 >= r1.size()) goto L26;
        if (r12 == false) goto L23;
        r12 = false;
    L24:
        r0.append(r1.elementAt(r14).toString());
        r14 = r14 + 1;
        goto L20
    L23:
        r0.append(',');
        goto L24
    }
}
