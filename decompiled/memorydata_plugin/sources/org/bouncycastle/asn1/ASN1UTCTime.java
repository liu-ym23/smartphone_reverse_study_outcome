package org.bouncycastle.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class ASN1UTCTime extends ASN1Primitive {
    static final ASN1UniversalType TYPE = null;
    final byte[] contents;

    static {
        final Class<ASN1UTCTime> r1 = ASN1UTCTime.class;
        final int r2 = 23;
        TYPE = new AnonymousClass1(r1, r2);
    }

    ASN1UTCTime(byte[] r3) {
        if (r3.length < 2) goto L12;
        this.contents = r3;
        if (isDigit(0) == false) goto L10;
        if (isDigit(1) == false) goto L10;
        return;
    L10:
        throw new IllegalArgumentException("illegal characters in UTCTime string");
    L12:
        throw new IllegalArgumentException("UTCTime string too short");
    }

    static ASN1UTCTime createPrimitive(byte[] r1) {
        return new ASN1UTCTime(r1);
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

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean asn1Equals(ASN1Primitive r3) {
        if (ZeusTransformUtils.instanceOf(r3, ASN1UTCTime.class) == true) goto L7;
        return false;
    L7:
        return Arrays.areEqual(this.contents, ((ASN1UTCTime) ZeusTransformUtils.preCheckCast(r3, ASN1UTCTime.class, "com.obric.memorydata.plugin")).contents);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    void encode(ASN1OutputStream r2, boolean r3) {
        r2.writeEncodingDL(r3, 23, this.contents);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    final boolean encodeConstructed() {
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    int encodedLength(boolean r1) {
        return ASN1OutputStream.getLengthOfEncodingDL(r1, this.contents.length);
    }

    public Date getAdjustedDate() {
        SimpleDateFormat r0 = new SimpleDateFormat("yyyyMMddHHmmssz");
        r0.setTimeZone(new SimpleTimeZone(0, "Z"));
        return DateUtil.epochAdjust(r0.parse(getAdjustedTime()));
    }

    public String getAdjustedTime() {
        String r2 = getTime();
        if (r2.charAt(0) >= '5') goto L7;
        StringBuilder r0 = new StringBuilder();
        String r1 = "20";
    L6:
        return r0.append(r1).append(r2).toString();
    L7:
        r0 = new StringBuilder();
        r1 = "19";
        goto L6
    }

    public String getTime() {
        String r6 = Strings.fromByteArray(this.contents);
        if (r6.indexOf(45) < 0) goto L5;
    L13:
        int r0 = r6.indexOf(45);
        if (r0 >= 0) goto L17;
        r0 = r6.indexOf(43);
    L17:
        if (r0 != (r6.length() - 3)) goto L20;
        r6 = r6 + "00";
    L20:
        if (r0 != 10) goto L23;
        StringBuilder r1 = new StringBuilder().append(r6.substring(0, 10)).append("00GMT").append(r6.substring(10, 13)).append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        String r7 = r6.substring(13, 15);
    L22:
        StringBuilder r8 = r1.append(r7);
    L11:
        return r8.toString();
    L23:
        r1 = new StringBuilder().append(r6.substring(0, 12)).append("GMT").append(r6.substring(12, 15)).append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        r7 = r6.substring(15, 17);
        goto L22
    L5:
        if (r6.indexOf(43) >= 0) goto L13;
        if (r6.length() != 11) goto L12;
        StringBuilder r9 = new StringBuilder().append(r6.substring(0, 10));
        String r2 = "00GMT+00:00";
    L9:
        r8 = r9.append(r2);
        goto L11
    L12:
        r9 = new StringBuilder().append(r6.substring(0, 12));
        r2 = "GMT+00:00";
        goto L9
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return Arrays.hashCode(this.contents);
    }

    public String toString() {
        return Strings.fromByteArray(this.contents);
    }
}
