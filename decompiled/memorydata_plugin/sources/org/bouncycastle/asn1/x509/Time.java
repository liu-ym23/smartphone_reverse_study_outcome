package org.bouncycastle.asn1.x509;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Date;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1UTCTime;

/* JADX INFO: loaded from: classes7.dex */
public class Time extends ASN1Object implements ASN1Choice {
    ASN1Primitive time;

    public Time(ASN1Primitive r2) {
        if (ZeusTransformUtils.instanceOf(r2, ASN1UTCTime.class) == false) goto L5;
    L9:
        this.time = r2;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r2, ASN1GeneralizedTime.class) == true) goto L9;
        throw new IllegalArgumentException("unknown object passed to Time");
    }

    public static Time getInstance(Object r3) {
        if (r3 == null) goto L18;
        if (ZeusTransformUtils.instanceOf(r3, Time.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r3, ASN1UTCTime.class) == false) goto L12;
        return new Time((ASN1UTCTime) ZeusTransformUtils.preCheckCast(r3, ASN1UTCTime.class, "com.obric.memorydata.plugin"));
    L12:
        if (ZeusTransformUtils.instanceOf(r3, ASN1GeneralizedTime.class) == false) goto L16;
        return new Time((ASN1GeneralizedTime) ZeusTransformUtils.preCheckCast(r3, ASN1GeneralizedTime.class, "com.obric.memorydata.plugin"));
    L16:
        throw new IllegalArgumentException("unknown object in factory: " + r3.getClass().getName());
    L18:
        return (Time) ZeusTransformUtils.preCheckCast(r3, Time.class, "com.obric.memorydata.plugin");
    }

    public Date getDate() {
    L9:
        e = move-exception;
        throw new IllegalStateException("invalid date string: " + e.getMessage());
    L4:
        if (ZeusTransformUtils.instanceOf(this.time, ASN1UTCTime.class) == false) goto L8;
        return ((ASN1UTCTime) ZeusTransformUtils.preCheckCast(this.time, ASN1UTCTime.class, "com.obric.memorydata.plugin")).getAdjustedDate();
    L8:
        return ((ASN1GeneralizedTime) ZeusTransformUtils.preCheckCast(this.time, ASN1GeneralizedTime.class, "com.obric.memorydata.plugin")).getDate();
    }

    public String getTime() {
        boolean r0 = ZeusTransformUtils.instanceOf(this.time, ASN1UTCTime.class);
        ASN1Primitive r2 = this.time;
        if (r0 == false) goto L7;
        return ((ASN1UTCTime) ZeusTransformUtils.preCheckCast(r2, ASN1UTCTime.class, "com.obric.memorydata.plugin")).getAdjustedTime();
    L7:
        return ((ASN1GeneralizedTime) ZeusTransformUtils.preCheckCast(r2, ASN1GeneralizedTime.class, "com.obric.memorydata.plugin")).getTime();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.time;
    }

    public String toString() {
        return getTime();
    }
}
