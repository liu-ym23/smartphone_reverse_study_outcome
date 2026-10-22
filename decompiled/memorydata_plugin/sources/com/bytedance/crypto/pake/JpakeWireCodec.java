package com.bytedance.crypto.pake;

import android.util.Base64;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.crypto.agreement.jpake.JPAKERound1Payload;
import org.bouncycastle.crypto.agreement.jpake.JPAKERound2Payload;

/* JADX INFO: loaded from: classes2.dex */
public final class JpakeWireCodec {
    private static final Gson GSON = null;

    public static final class KeyConfirmDto {

        @SerializedName("hmacBase64")
        public final String hmacBase64;

        @SerializedName("saltBase64")
        public final String saltBase64;

        public KeyConfirmDto(String r1, String r2) {
            this.saltBase64 = r1;
            this.hmacBase64 = r2;
        }
    }

    public static final class Round1Dto {

        @SerializedName("gx1Hex")
        public final String gx1Hex;

        @SerializedName("gx2Hex")
        public final String gx2Hex;

        @SerializedName("participantId")
        public final String participantId;

        @SerializedName("zkpX1")
        public final ZkpDto zkpX1;

        @SerializedName("zkpX2")
        public final ZkpDto zkpX2;

        public Round1Dto(String r1, String r2, String r3, ZkpDto r4, ZkpDto r5) {
            this.participantId = r1;
            this.gx1Hex = r2;
            this.gx2Hex = r3;
            this.zkpX1 = r4;
            this.zkpX2 = r5;
        }
    }

    public static final class Round2Dto {

        @SerializedName("aHex")
        public final String aHex;

        @SerializedName("participantId")
        public final String participantId;

        @SerializedName("zkpX2s")
        public final ZkpDto zkpX2s;

        public Round2Dto(String r1, String r2, ZkpDto r3) {
            this.participantId = r1;
            this.aHex = r2;
            this.zkpX2s = r3;
        }
    }

    public static final class ZkpDto {

        @SerializedName("bHex")
        public final String bHex;

        @SerializedName("grHex")
        public final String grHex;

        public ZkpDto(String r1, String r2) {
            this.grHex = r1;
            this.bHex = r2;
        }
    }

    static {
        GSON = new Gson();
    }

    private JpakeWireCodec() {
    }

    public static JpakeSession.KeyConfirmMsg decodeKeyConfirm(String r2) {
        KeyConfirmDto r3 = (KeyConfirmDto) ZeusTransformUtils.preCheckCast(GSON.fromJson(r2, KeyConfirmDto.class), KeyConfirmDto.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L7;
        return new JpakeSession.KeyConfirmMsg(Base64.decode(r3.saltBase64, 2), Base64.decode(r3.hmacBase64, 2));
    L7:
        throw new IllegalArgumentException("KeyConfirm json decode failed");
    }

    public static JpakeSession.Round1Msg decodeRound1(String r7) {
        Round1Dto r8 = (Round1Dto) ZeusTransformUtils.preCheckCast(GSON.fromJson(r7, Round1Dto.class), Round1Dto.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L7;
        BigInteger r2 = new BigInteger(r8.gx1Hex, 16);
        BigInteger r3 = new BigInteger(r8.gx2Hex, 16);
        BigInteger[] r4 = toBigIntArray(r8.zkpX1);
        BigInteger[] r5 = toBigIntArray(r8.zkpX2);
        return new JpakeSession.Round1Msg(new JPAKERound1Payload(r8.participantId, r2, r3, r4, r5));
    L7:
        throw new IllegalArgumentException("Round1 json decode failed");
    }

    public static JpakeSession.Round2Msg decodeRound2(String r3) {
        Round2Dto r4 = (Round2Dto) ZeusTransformUtils.preCheckCast(GSON.fromJson(r3, Round2Dto.class), Round2Dto.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L7;
        BigInteger r0 = new BigInteger(r4.aHex, 16);
        BigInteger[] r1 = toBigIntArray(r4.zkpX2s);
        return new JpakeSession.Round2Msg(new JPAKERound2Payload(r4.participantId, r0, r1));
    L7:
        throw new IllegalArgumentException("Round2 json decode failed");
    }

    public static String encodeKeyConfirm(JpakeSession.KeyConfirmMsg r3) {
        if (r3 == null) goto L6;
        KeyConfirmDto r0 = new KeyConfirmDto(Base64.encodeToString(r3.salt, 2), Base64.encodeToString(r3.hmac, 2));
        return GSON.toJson(r0);
    L6:
        throw new IllegalArgumentException("KeyConfirmMsg is null");
    }

    public static String encodeRound1(JpakeSession.Round1Msg r7) {
        if (r7 == null) goto L8;
        JPAKERound1Payload r8 = r7.payload;
        if (r8 == null) goto L8;
        Round1Dto r6 = new Round1Dto(r8.getParticipantId(), r8.getGx1().toString(16), r8.getGx2().toString(16), toZkpDto(r8.getKnowledgeProofForX1()), toZkpDto(r8.getKnowledgeProofForX2()));
        return GSON.toJson(r6);
    L8:
        throw new IllegalArgumentException("Round1Msg or payload is null");
    }

    public static String encodeRound2(JpakeSession.Round2Msg r4) {
        if (r4 == null) goto L8;
        JPAKERound2Payload r5 = r4.payload;
        if (r5 == null) goto L8;
        Round2Dto r0 = new Round2Dto(r5.getParticipantId(), r5.getA().toString(16), toZkpDto(r5.getKnowledgeProofForX2s()));
        return GSON.toJson(r0);
    L8:
        throw new IllegalArgumentException("Round2Msg or payload is null");
    }

    private static BigInteger[] toBigIntArray(ZkpDto r4) {
        if (r4 == null) goto L6;
        return new BigInteger[]{new BigInteger(r4.grHex, 16), new BigInteger(r4.bHex, 16)};
    L6:
        throw new IllegalArgumentException("ZkpDto is null");
    }

    private static ZkpDto toZkpDto(BigInteger[] r4) {
        int r0 = 0;
        if (r4 != null) goto L5;
    L9:
        StringBuilder r2 = new StringBuilder().append("invalid zkp array size=");
        if (r4 == null) goto L14;
        r0 = r4.length;
    L14:
        throw new IllegalStateException(r2.append(r0).toString());
    L5:
        if (r4.length < 2) goto L9;
        return new ZkpDto(r4[0].toString(16), r4[1].toString(16));
    }
}
