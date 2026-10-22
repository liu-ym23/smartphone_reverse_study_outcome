package org.bouncycastle.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes7.dex */
public class ASN1GeneralizedTime extends ASN1Primitive {
    static final ASN1UniversalType TYPE = null;
    final byte[] contents;

    static {
        final Class<ASN1GeneralizedTime> r1 = ASN1GeneralizedTime.class;
        final int r2 = 24;
        TYPE = new AnonymousClass1(r1, r2);
    }

    public ASN1GeneralizedTime(Date r5) {
        SimpleDateFormat r0 = new SimpleDateFormat("yyyyMMddHHmmss'Z'", DateUtil.EN_Locale);
        r0.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.contents = Strings.toByteArray(r0.format(r5));
    }

    ASN1GeneralizedTime(byte[] r3) {
        if (r3.length < 4) goto L16;
        this.contents = r3;
        if (isDigit(0) == false) goto L14;
        if (isDigit(1) == false) goto L14;
        if (isDigit(2) == false) goto L14;
        if (isDigit(3) == false) goto L14;
        return;
    L14:
        throw new IllegalArgumentException("illegal characters in GeneralizedTime string");
    L16:
        throw new IllegalArgumentException("GeneralizedTime string too short");
    }

    private SimpleDateFormat calculateGMTDateFormat() {
        if (hasFractionalSeconds() == false) goto L6;
        SimpleDateFormat r3 = new SimpleDateFormat("yyyyMMddHHmmss.SSSz");
    L12:
        r3.setTimeZone(new SimpleTimeZone(0, "Z"));
        return r3;
    L6:
        if (hasSeconds() == false) goto L9;
        r3 = new SimpleDateFormat("yyyyMMddHHmmssz");
        goto L12
    L9:
        if (hasMinutes() == false) goto L11;
        r3 = new SimpleDateFormat("yyyyMMddHHmmz");
        goto L12
    L11:
        r3 = new SimpleDateFormat("yyyyMMddHHz");
        goto L12
    }

    private String calculateGMTOffset(String r10) {
        TimeZone r2 = TimeZone.getDefault();
        int r3 = r2.getRawOffset();
        if (r3 >= 0) goto L5;
        r3 = -r3;
        String r5 = "-";
    L6:
        int r6 = r3 / 3600000;
        int r4 = (r3 - (((r6 * 60) * 60) * 1000)) / 60000;
        if (r2.useDaylightTime() == false) goto L20;
        if (hasFractionalSeconds() == false) goto L13;
        r10 = pruneFractionalSeconds(r10);     // Catch: ParseException -> L21
    L13:
        if (r2.inDaylightTime(calculateGMTDateFormat().parse(r10 + "GMT" + r5 + convert(r6) + ParameterizedMessage.ERROR_MSG_SEPARATOR + convert(r4))) == false) goto L20;
        if (r5.equals(Marker.ANY_NON_NULL_MARKER) == false) goto L17;
        int r11 = 1;
    L18:
        r6 = r6 + r11;
        goto L20
    L17:
        r11 = -1;
    L20:
        return "GMT" + r5 + convert(r6) + ParameterizedMessage.ERROR_MSG_SEPARATOR + convert(r4);
    L5:
        r5 = Marker.ANY_NON_NULL_MARKER;
        goto L6
    }

    private String convert(int r2) {
        if (r2 >= 10) goto L7;
        return "0" + r2;
    L7:
        return Integer.toString(r2);
    }

    static ASN1GeneralizedTime createPrimitive(byte[] r1) {
        return new ASN1GeneralizedTime(r1);
    }

    public static ASN1GeneralizedTime getInstance(Object r5) {
        if (r5 != null) goto L5;
    L23:
        Object r6 = ZeusTransformUtils.preCheckCast(r5, ASN1GeneralizedTime.class, "com.obric.memorydata.plugin");
    L13:
        return (ASN1GeneralizedTime) r6;
    L5:
        if (ZeusTransformUtils.instanceOf(r5, ASN1GeneralizedTime.class) == true) goto L23;
        if (ZeusTransformUtils.instanceOf(r5, ASN1Encodable.class) == false) goto L15;
        ASN1Primitive r3 = ((ASN1Encodable) ZeusTransformUtils.preCheckCast(r5, ASN1Encodable.class, "com.obric.memorydata.plugin")).toASN1Primitive();
        if (ZeusTransformUtils.instanceOf(r3, ASN1GeneralizedTime.class) == false) goto L15;
        r6 = ZeusTransformUtils.preCheckCast(r3, ASN1GeneralizedTime.class, "com.obric.memorydata.plugin");
    L15:
        if ((r5 instanceof byte[]) == false) goto L22;
        return (ASN1GeneralizedTime) ZeusTransformUtils.preCheckCast(TYPE.fromByteArray((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r5, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin")), ASN1GeneralizedTime.class, "com.obric.memorydata.plugin");
    L18:
        e = move-exception;
        throw new IllegalArgumentException("encoding error in getInstance: " + e.toString());
    L22:
        throw new IllegalArgumentException("illegal object in getInstance: " + r5.getClass().getName());
    }

    private boolean isDigit(int r3) {
        byte[] r2 = this.contents;
        if (r2.length > r3) goto L5;
    L9:
        return false;
    L5:
        if (r2[r3] < 48) goto L9;
        if (r2[r3] > 57) goto L9;
        return true;
    }

    private String pruneFractionalSeconds(String r7) {
        String r0 = r7.substring(14);
        int r2 = 1;
    L4:
        if (r2 >= r0.length()) goto L11;
        char r3 = r0.charAt(r2);
        if ('0' > r3) goto L11;
        if (r3 > '9') goto L11;
        r2 = r2 + 1;
    L11:
        int r4 = r2 - 1;
        if (r4 <= 3) goto L15;
        String r1 = r0.substring(0, 4) + r0.substring(r2);
        StringBuilder r5 = new StringBuilder();
    L20:
        return r5.append(r7.substring(0, 14)).append(r1).toString();
    L15:
        if (r4 != 1) goto L18;
        r1 = r0.substring(0, r2) + "00" + r0.substring(r2);
        r5 = new StringBuilder();
        goto L20
    L18:
        if (r4 != 2) goto L24;
        r1 = r0.substring(0, r2) + "0" + r0.substring(r2);
        r5 = new StringBuilder();
        goto L20
    L24:
        return r7;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean asn1Equals(ASN1Primitive r3) {
        if (ZeusTransformUtils.instanceOf(r3, ASN1GeneralizedTime.class) == true) goto L7;
        return false;
    L7:
        return Arrays.areEqual(this.contents, ((ASN1GeneralizedTime) ZeusTransformUtils.preCheckCast(r3, ASN1GeneralizedTime.class, "com.obric.memorydata.plugin")).contents);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    void encode(ASN1OutputStream r2, boolean r3) {
        r2.writeEncodingDL(r3, 24, this.contents);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    final boolean encodeConstructed() {
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    int encodedLength(boolean r1) {
        return ASN1OutputStream.getLengthOfEncodingDL(r1, this.contents.length);
    }

    public Date getDate() {
        String r0 = Strings.fromByteArray(this.contents);
        if (r0.endsWith("Z") == false) goto L16;
        if (hasFractionalSeconds() == false) goto L8;
        SimpleDateFormat r2 = new SimpleDateFormat("yyyyMMddHHmmss.SSS'Z'");
    L14:
        r2.setTimeZone(new SimpleTimeZone(0, "Z"));
    L34:
        if (hasFractionalSeconds() == false) goto L37;
        r0 = pruneFractionalSeconds(r0);
    L37:
        return DateUtil.epochAdjust(r2.parse(r0));
    L8:
        if (hasSeconds() == false) goto L11;
        r2 = new SimpleDateFormat("yyyyMMddHHmmss'Z'");
        goto L14
    L11:
        if (hasMinutes() == false) goto L13;
        r2 = new SimpleDateFormat("yyyyMMddHHmm'Z'");
        goto L14
    L13:
        r2 = new SimpleDateFormat("yyyyMMddHH'Z'");
        goto L14
    L16:
        if (r0.indexOf(45) <= 0) goto L18;
    L32:
        r0 = getTime();
        r2 = calculateGMTDateFormat();
        goto L34
    L18:
        if (r0.indexOf(43) > 0) goto L32;
        if (hasFractionalSeconds() == false) goto L25;
        SimpleDateFormat r1 = new SimpleDateFormat("yyyyMMddHHmmss.SSS");
    L23:
        r2 = r1;
        r2.setTimeZone(new SimpleTimeZone(0, TimeZone.getDefault().getID()));
        goto L34
    L25:
        if (hasSeconds() == false) goto L28;
        r1 = new SimpleDateFormat("yyyyMMddHHmmss");
        goto L23
    L28:
        if (hasMinutes() == false) goto L30;
        r1 = new SimpleDateFormat("yyyyMMddHHmm");
        goto L23
    L30:
        r1 = new SimpleDateFormat("yyyyMMddHH");
        goto L23
    }

    public String getTime() {
        String r0 = Strings.fromByteArray(this.contents);
        if (r0.charAt(r0.length() - 1) != 'Z') goto L8;
        StringBuilder r7 = new StringBuilder().append(r0.substring(0, r0.length() - 1));
        String r1 = "GMT+00:00";
    L5:
        StringBuilder r8 = r7.append(r1);
    L7:
        return r8.toString();
    L8:
        int r2 = r0.length() - 6;
        char r3 = r0.charAt(r2);
        if (r3 == '-') goto L12;
        if (r3 == '+') goto L12;
    L14:
        int r4 = r0.length() - 5;
        char r5 = r0.charAt(r4);
        if (r5 == '-') goto L24;
        if (r5 == '+') goto L24;
        int r6 = r0.length() - 3;
        char r9 = r0.charAt(r6);
        if (r9 == '-') goto L23;
        if (r9 == '+') goto L23;
        r8 = new StringBuilder().append(r0).append(calculateGMTOffset(r0));
    L23:
        r7 = new StringBuilder().append(r0.substring(0, r6)).append("GMT").append(r0.substring(r6));
        r1 = ":00";
    L24:
        int r10 = r4 + 3;
        r7 = new StringBuilder().append(r0.substring(0, r4)).append("GMT").append(r0.substring(r4, r10)).append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        r1 = r0.substring(r10);
    L12:
        if (r0.indexOf("GMT") != (r2 - 3)) goto L14;
        return r0;
    }

    public boolean hasFractionalSeconds() {
        int r1 = 0;
    L3:
        byte[] r2 = this.contents;
        if (r1 == r2.length) goto L12;
        if (r2[r1] != 46) goto L11;
        if (r1 != 14) goto L11;
        return true;
    L11:
        r1 = r1 + 1;
        goto L3
    L12:
        return false;
    }

    public boolean hasMinutes() {
        if (isDigit(10) == true) goto L5;
    L7:
        return false;
    L5:
        if (isDigit(11) == false) goto L7;
        return true;
    }

    public boolean hasSeconds() {
        if (isDigit(12) == true) goto L5;
    L7:
        return false;
    L5:
        if (isDigit(13) == false) goto L7;
        return true;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return Arrays.hashCode(this.contents);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDERObject() {
        return new DERGeneralizedTime(this.contents);
    }
}
