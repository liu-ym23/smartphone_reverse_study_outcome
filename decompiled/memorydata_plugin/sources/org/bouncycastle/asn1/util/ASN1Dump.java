package org.bouncycastle.asn1.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1ApplicationSpecific;
import org.bouncycastle.asn1.ASN1BMPString;
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Boolean;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Enumerated;
import org.bouncycastle.asn1.ASN1External;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1GraphicString;
import org.bouncycastle.asn1.ASN1IA5String;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Null;
import org.bouncycastle.asn1.ASN1NumericString;
import org.bouncycastle.asn1.ASN1ObjectDescriptor;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1PrintableString;
import org.bouncycastle.asn1.ASN1RelativeOID;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1T61String;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.ASN1UTCTime;
import org.bouncycastle.asn1.ASN1UTF8String;
import org.bouncycastle.asn1.ASN1Util;
import org.bouncycastle.asn1.ASN1VideotexString;
import org.bouncycastle.asn1.ASN1VisibleString;
import org.bouncycastle.asn1.BEROctetString;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.BERSet;
import org.bouncycastle.asn1.BERTaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.DLBitString;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes7.dex */
public class ASN1Dump {
    static void _dumpAsString(String r6, boolean r7, ASN1Primitive r8, StringBuffer r9) {
        String r0 = Strings.lineSeparator();
        if (ZeusTransformUtils.instanceOf(r8, ASN1Null.class) == false) goto L6;
        r9.append(r6);
        r9.append("NULL");
    L5:
        r9.append(r0);
        return;
    L6:
        int r2 = 0;
        if (ZeusTransformUtils.instanceOf(r8, ASN1Sequence.class) == false) goto L20;
        r9.append(r6);
        if (ZeusTransformUtils.instanceOf(r8, BERSequence.class) == false) goto L13;
        String r1 = "BER Sequence";
    L11:
        r9.append(r1);
        r9.append(r0);
        ASN1Sequence r10 = (ASN1Sequence) ZeusTransformUtils.preCheckCast(r8, ASN1Sequence.class, "com.obric.memorydata.plugin");
        String r11 = r6 + "    ";
        int r3 = r10.size();
    L17:
        if (r2 >= r3) goto L147;
        _dumpAsString(r11, r7, r10.getObjectAt(r2).toASN1Primitive(), r9);
        r2 = r2 + 1;
        goto L17
    L147:
        return;
    L13:
        if (ZeusTransformUtils.instanceOf(r8, DERSequence.class) == false) goto L15;
        r1 = "DER Sequence";
        goto L11
    L15:
        r1 = "Sequence";
        goto L11
    L20:
        if (ZeusTransformUtils.instanceOf(r8, ASN1Set.class) == false) goto L33;
        r9.append(r6);
        if (ZeusTransformUtils.instanceOf(r8, BERSet.class) == false) goto L26;
        String r4 = "BER Set";
    L24:
        r9.append(r4);
        r9.append(r0);
        ASN1Set r12 = (ASN1Set) ZeusTransformUtils.preCheckCast(r8, ASN1Set.class, "com.obric.memorydata.plugin");
        String r13 = r6 + "    ";
        int r5 = r12.size();
    L30:
        if (r2 >= r5) goto L148;
        _dumpAsString(r13, r7, r12.getObjectAt(r2).toASN1Primitive(), r9);
        r2 = r2 + 1;
        goto L30
    L148:
        return;
    L26:
        if (ZeusTransformUtils.instanceOf(r8, DERSet.class) == false) goto L28;
        r4 = "DER Set";
        goto L24
    L28:
        r4 = "Set";
        goto L24
    L33:
        if (ZeusTransformUtils.instanceOf(r8, ASN1ApplicationSpecific.class) == false) goto L37;
        ASN1Primitive r14 = ((ASN1ApplicationSpecific) ZeusTransformUtils.preCheckCast(r8, ASN1ApplicationSpecific.class, "com.obric.memorydata.plugin")).getTaggedObject();
    L35:
        _dumpAsString(r6, r7, r14, r9);
        return;
    L37:
        if (ZeusTransformUtils.instanceOf(r8, ASN1TaggedObject.class) == false) goto L51;
        r9.append(r6);
        if (ZeusTransformUtils.instanceOf(r8, BERTaggedObject.class) == false) goto L43;
        String r15 = "BER Tagged ";
    L41:
        r9.append(r15);
        ASN1TaggedObject r16 = (ASN1TaggedObject) ZeusTransformUtils.preCheckCast(r8, ASN1TaggedObject.class, "com.obric.memorydata.plugin");
        r9.append(ASN1Util.getTagText(r16));
        if (r16.isExplicit() == true) goto L49;
        r9.append(" IMPLICIT ");
    L49:
        r9.append(r0);
        r6 = r6 + "    ";
        r14 = r16.getBaseObject().toASN1Primitive();
        goto L35
    L43:
        if (ZeusTransformUtils.instanceOf(r8, DERTaggedObject.class) == false) goto L45;
        r15 = "DER Tagged ";
        goto L41
    L45:
        r15 = "Tagged ";
        goto L41
    L51:
        if (ZeusTransformUtils.instanceOf(r8, ASN1OctetString.class) == false) goto L60;
        ASN1OctetString r17 = (ASN1OctetString) ZeusTransformUtils.preCheckCast(r8, ASN1OctetString.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, BEROctetString.class) == false) goto L55;
        StringBuilder r18 = new StringBuilder().append(r6).append("BER Constructed Octet String[");
        int r19 = r17.getOctets().length;
    L56:
        r9.append(r18.append(r19).append("] ").toString());
        if (r7 == false) goto L5;
        String r20 = dumpBinaryDataAsString(r6, r17.getOctets());
    L65:
        r9.append(r20);
        return;
    L55:
        r18 = new StringBuilder().append(r6).append("DER Octet String[");
        r19 = r17.getOctets().length;
        goto L56
    L60:
        if (ZeusTransformUtils.instanceOf(r8, ASN1ObjectIdentifier.class) == false) goto L67;
        StringBuilder r21 = new StringBuilder().append(r6).append("ObjectIdentifier(");
        String r22 = ((ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(r8, ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin")).getId();
    L62:
        StringBuilder r23 = r21.append(r22);
    L63:
        StringBuilder r24 = r23.append(")");
    L64:
        r20 = r24.append(r0).toString();
        goto L65
    L67:
        if (ZeusTransformUtils.instanceOf(r8, ASN1RelativeOID.class) == false) goto L70;
        r21 = new StringBuilder().append(r6).append("RelativeOID(");
        r22 = ((ASN1RelativeOID) ZeusTransformUtils.preCheckCast(r8, ASN1RelativeOID.class, "com.obric.memorydata.plugin")).getId();
        goto L62
    L70:
        if (ZeusTransformUtils.instanceOf(r8, ASN1Boolean.class) == false) goto L73;
        r23 = new StringBuilder().append(r6).append("Boolean(").append(((ASN1Boolean) ZeusTransformUtils.preCheckCast(r8, ASN1Boolean.class, "com.obric.memorydata.plugin")).isTrue());
        goto L63
    L73:
        if (ZeusTransformUtils.instanceOf(r8, ASN1Integer.class) == false) goto L77;
        StringBuilder r25 = new StringBuilder().append(r6).append("Integer(");
        BigInteger r26 = ((ASN1Integer) ZeusTransformUtils.preCheckCast(r8, ASN1Integer.class, "com.obric.memorydata.plugin")).getValue();
    L75:
        r23 = r25.append(r26);
        goto L63
    L77:
        if (ZeusTransformUtils.instanceOf(r8, ASN1BitString.class) == false) goto L89;
        ASN1BitString r27 = (ASN1BitString) ZeusTransformUtils.preCheckCast(r8, ASN1BitString.class, "com.obric.memorydata.plugin");
        byte[] r28 = r27.getBytes();
        int r29 = r27.getPadBits();
        if (ZeusTransformUtils.instanceOf(r27, DERBitString.class) == false) goto L83;
        StringBuilder r30 = new StringBuilder().append(r6);
        String r31 = "DER Bit String[";
    L81:
        r9.append(r30.append(r31).append(r28.length).append(", ").append(r29).append("] ").toString());
        if (r7 == false) goto L5;
        r20 = dumpBinaryDataAsString(r6, r28);
        goto L65
    L83:
        if (ZeusTransformUtils.instanceOf(r27, DLBitString.class) == false) goto L85;
        r30 = new StringBuilder().append(r6);
        r31 = "DL Bit String[";
        goto L81
    L85:
        r30 = new StringBuilder().append(r6);
        r31 = "BER Bit String[";
        goto L81
    L89:
        if (ZeusTransformUtils.instanceOf(r8, ASN1IA5String.class) == false) goto L93;
        StringBuilder r32 = new StringBuilder().append(r6).append("IA5String(");
        String r33 = ((ASN1IA5String) ZeusTransformUtils.preCheckCast(r8, ASN1IA5String.class, "com.obric.memorydata.plugin")).getString();
    L91:
        r24 = r32.append(r33).append(") ");
        goto L64
    L93:
        if (ZeusTransformUtils.instanceOf(r8, ASN1UTF8String.class) == false) goto L96;
        r32 = new StringBuilder().append(r6).append("UTF8String(");
        r33 = ((ASN1UTF8String) ZeusTransformUtils.preCheckCast(r8, ASN1UTF8String.class, "com.obric.memorydata.plugin")).getString();
        goto L91
    L96:
        if (ZeusTransformUtils.instanceOf(r8, ASN1NumericString.class) == false) goto L99;
        r32 = new StringBuilder().append(r6).append("NumericString(");
        r33 = ((ASN1NumericString) ZeusTransformUtils.preCheckCast(r8, ASN1NumericString.class, "com.obric.memorydata.plugin")).getString();
        goto L91
    L99:
        if (ZeusTransformUtils.instanceOf(r8, ASN1PrintableString.class) == false) goto L102;
        r32 = new StringBuilder().append(r6).append("PrintableString(");
        r33 = ((ASN1PrintableString) ZeusTransformUtils.preCheckCast(r8, ASN1PrintableString.class, "com.obric.memorydata.plugin")).getString();
        goto L91
    L102:
        if (ZeusTransformUtils.instanceOf(r8, ASN1VisibleString.class) == false) goto L105;
        r32 = new StringBuilder().append(r6).append("VisibleString(");
        r33 = ((ASN1VisibleString) ZeusTransformUtils.preCheckCast(r8, ASN1VisibleString.class, "com.obric.memorydata.plugin")).getString();
        goto L91
    L105:
        if (ZeusTransformUtils.instanceOf(r8, ASN1BMPString.class) == false) goto L108;
        r32 = new StringBuilder().append(r6).append("BMPString(");
        r33 = ((ASN1BMPString) ZeusTransformUtils.preCheckCast(r8, ASN1BMPString.class, "com.obric.memorydata.plugin")).getString();
        goto L91
    L108:
        if (ZeusTransformUtils.instanceOf(r8, ASN1T61String.class) == false) goto L111;
        r32 = new StringBuilder().append(r6).append("T61String(");
        r33 = ((ASN1T61String) ZeusTransformUtils.preCheckCast(r8, ASN1T61String.class, "com.obric.memorydata.plugin")).getString();
        goto L91
    L111:
        if (ZeusTransformUtils.instanceOf(r8, ASN1GraphicString.class) == false) goto L115;
        r32 = new StringBuilder().append(r6).append("GraphicString(");
        ASN1GraphicString r34 = (ASN1GraphicString) ZeusTransformUtils.preCheckCast(r8, ASN1GraphicString.class, "com.obric.memorydata.plugin");
    L113:
        r33 = r34.getString();
        goto L91
    L115:
        if (ZeusTransformUtils.instanceOf(r8, ASN1VideotexString.class) == false) goto L118;
        r32 = new StringBuilder().append(r6).append("VideotexString(");
        r33 = ((ASN1VideotexString) ZeusTransformUtils.preCheckCast(r8, ASN1VideotexString.class, "com.obric.memorydata.plugin")).getString();
        goto L91
    L118:
        if (ZeusTransformUtils.instanceOf(r8, ASN1UTCTime.class) == false) goto L121;
        r32 = new StringBuilder().append(r6).append("UTCTime(");
        r33 = ((ASN1UTCTime) ZeusTransformUtils.preCheckCast(r8, ASN1UTCTime.class, "com.obric.memorydata.plugin")).getTime();
        goto L91
    L121:
        if (ZeusTransformUtils.instanceOf(r8, ASN1GeneralizedTime.class) == false) goto L124;
        r32 = new StringBuilder().append(r6).append("GeneralizedTime(");
        r33 = ((ASN1GeneralizedTime) ZeusTransformUtils.preCheckCast(r8, ASN1GeneralizedTime.class, "com.obric.memorydata.plugin")).getTime();
        goto L91
    L124:
        if (ZeusTransformUtils.instanceOf(r8, ASN1Enumerated.class) == false) goto L127;
        ASN1Enumerated r35 = (ASN1Enumerated) ZeusTransformUtils.preCheckCast(r8, ASN1Enumerated.class, "com.obric.memorydata.plugin");
        r25 = new StringBuilder().append(r6).append("DER Enumerated(");
        r26 = r35.getValue();
        goto L75
    L127:
        if (ZeusTransformUtils.instanceOf(r8, ASN1ObjectDescriptor.class) == false) goto L130;
        ASN1ObjectDescriptor r36 = (ASN1ObjectDescriptor) ZeusTransformUtils.preCheckCast(r8, ASN1ObjectDescriptor.class, "com.obric.memorydata.plugin");
        r32 = new StringBuilder().append(r6).append("ObjectDescriptor(");
        r34 = r36.getBaseGraphicString();
        goto L113
    L130:
        if (ZeusTransformUtils.instanceOf(r8, ASN1External.class) == false) goto L141;
        ASN1External r37 = (ASN1External) ZeusTransformUtils.preCheckCast(r8, ASN1External.class, "com.obric.memorydata.plugin");
        r9.append(r6 + "External " + r0);
        r6 = r6 + "    ";
        if (r37.getDirectReference() == null) goto L135;
        r9.append(r6 + "Direct Reference: " + r37.getDirectReference().getId() + r0);
    L135:
        if (r37.getIndirectReference() == null) goto L138;
        r9.append(r6 + "Indirect Reference: " + r37.getIndirectReference().toString() + r0);
    L138:
        if (r37.getDataValueDescriptor() == null) goto L140;
        _dumpAsString(r6, r7, r37.getDataValueDescriptor(), r9);
    L140:
        r9.append(r6 + "Encoding: " + r37.getEncoding() + r0);
        r14 = r37.getExternalContent();
        goto L35
    L141:
        r24 = new StringBuilder().append(r6).append(r8.toString());
        goto L64
    }

    private static String calculateAscString(byte[] r4, int r5, int r6) {
        StringBuffer r0 = new StringBuffer();
        int r1 = r5;
    L4:
        if (r1 == (r5 + r6)) goto L12;
        if (r4[r1] < 32) goto L10;
        if (r4[r1] > 126) goto L10;
        r0.append((char) r4[r1]);
    L10:
        r1 = r1 + 1;
        goto L4
    L12:
        return r0.toString();
    }

    public static String dumpAsString(Object r1) {
        return dumpAsString(r1, false);
    }

    public static String dumpAsString(Object r2, boolean r3) {
        if (ZeusTransformUtils.instanceOf(r2, ASN1Primitive.class) == false) goto L6;
        ASN1Primitive r4 = (ASN1Primitive) ZeusTransformUtils.preCheckCast(r2, ASN1Primitive.class, "com.obric.memorydata.plugin");
    L8:
        StringBuffer r0 = new StringBuffer();
        _dumpAsString("", r3, r4, r0);
        return r0.toString();
    L6:
        if (ZeusTransformUtils.instanceOf(r2, ASN1Encodable.class) == false) goto L11;
        r4 = ((ASN1Encodable) ZeusTransformUtils.preCheckCast(r2, ASN1Encodable.class, "com.obric.memorydata.plugin")).toASN1Primitive();
        goto L8
    L11:
        return "unknown object type " + r2.toString();
    }

    private static String dumpBinaryDataAsString(String r7, byte[] r8) {
        String r0 = Strings.lineSeparator();
        StringBuffer r1 = new StringBuffer();
        String r9 = r7 + "    ";
        r1.append(r0);
        int r3 = 0;
    L4:
        if (r3 >= r8.length) goto L15;
        int r4 = r8.length - r3;
        r1.append(r9);
        if (r4 <= 32) goto L9;
        r1.append(Strings.fromByteArray(Hex.encode(r8, r3, 32)));
        r1.append("    ");
        String r5 = calculateAscString(r8, r3, 32);
    L8:
        r1.append(r5);
        r1.append(r0);
        r3 = r3 + 32;
        goto L4
    L9:
        r1.append(Strings.fromByteArray(Hex.encode(r8, r3, r8.length - r3)));
        int r6 = r8.length - r3;
    L10:
        if (r6 == 32) goto L12;
        r1.append("  ");
        r6 = r6 + 1;
        goto L10
    L12:
        r1.append("    ");
        r5 = calculateAscString(r8, r3, r8.length - r3);
        goto L8
    L15:
        return r1.toString();
    }
}
