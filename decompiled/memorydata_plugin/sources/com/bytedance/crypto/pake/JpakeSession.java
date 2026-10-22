package com.bytedance.crypto.pake;

import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.crypto.agreement.jpake.JPAKEParticipant;
import org.bouncycastle.crypto.agreement.jpake.JPAKERound1Payload;
import org.bouncycastle.crypto.agreement.jpake.JPAKERound2Payload;

/* JADX INFO: loaded from: classes2.dex */
public final class JpakeSession {
    private byte[] confirmKey;
    private byte[] dataKey;
    private boolean keyConfirmed;
    private final int keyLen;
    private final JPAKEParticipant participant;
    private final String participantId;
    private final PakeRole role;
    private boolean round1Received;
    private boolean round1Sent;
    private boolean round2Received;
    private boolean round2Sent;
    private byte[] sharedKey;

    public static final class KeyConfirmMsg {
        public final byte[] hmac;
        public final byte[] salt;

        public KeyConfirmMsg(byte[] r1, byte[] r2) {
            this.salt = r1;
            this.hmac = r2;
        }
    }

    public static final class Round1Msg {
        public final JPAKERound1Payload payload;

        public Round1Msg(JPAKERound1Payload r1) {
            this.payload = r1;
        }
    }

    public static final class Round2Msg {
        public final JPAKERound2Payload payload;

        public Round2Msg(JPAKERound2Payload r1) {
            this.payload = r1;
        }
    }

    private JpakeSession(PakeRole r2, String r3, int r4) {
        if (r3.isEmpty() == true) goto L15;
        this.role = r2;
        if (r2 != PakeRole.ALICE) goto L7;
        String r5 = "alice";
    L8:
        this.participantId = r5;
        if (r4 > 0) goto L12;
        r4 = 32;
    L12:
        this.keyLen = r4;
        this.participant = new JPAKEParticipant(r5, r3.toCharArray());
        return;
    L7:
        r5 = "bob";
        goto L8
    L15:
        throw new IllegalArgumentException("password must not be empty");
    }

    private void ensureSharedKeyAvailable() {
        byte[] r1 = this.sharedKey;
        if (r1 == null) goto L8;
        if (r1.length == 0) goto L8;
        return;
    L8:
        throw new IllegalStateException("shared key not available; call deriveSharedKey() first");
    }

    public static JpakeSession newSession(PakeRole r1, String r2, int r3) {
        return new JpakeSession(r1, r2, r3);
    }

    public synchronized byte[] deriveSharedKey() {
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (this.round2Received == false) goto L20;
        byte[] r1 = this.sharedKey;     // Catch: Throwable -> L21
        if (r1 != null) goto L9;
    L25:
        BigInteger r2 = this.participant.calculateKeyingMaterial();     // Catch: Exception -> L16 Throwable -> L21
        MessageDigest r3 = MessageDigest.getInstance(CryptoConst.ALGORITHM_SHA256);     // Catch: Exception -> L16 Throwable -> L21
        r3.update(r2.toByteArray());     // Catch: Exception -> L16 Throwable -> L21
        byte[] r4 = r3.digest();     // Catch: Exception -> L16 Throwable -> L21
        int r5 = Math.min(this.keyLen, r4.length);     // Catch: Exception -> L16 Throwable -> L21
        byte[] r6 = new byte[r5];     // Catch: Exception -> L16 Throwable -> L21
        this.sharedKey = r6;     // Catch: Exception -> L16 Throwable -> L21
        System.arraycopy(r4, 0, r6, 0, r5);     // Catch: Exception -> L16 Throwable -> L21
        Mac r7 = Mac.getInstance("HmacSHA256");     // Catch: Exception -> L16 Throwable -> L21
        r7.init(new SecretKeySpec(this.sharedKey, "HmacSHA256"));     // Catch: Exception -> L16 Throwable -> L21
        byte[] r8 = r7.doFinal("CONFIRM".getBytes(RpcUtils.CHARSET_UTF8));     // Catch: Exception -> L16 Throwable -> L21
        Mac r9 = Mac.getInstance("HmacSHA256");     // Catch: Exception -> L16 Throwable -> L21
        r9.init(new SecretKeySpec(this.sharedKey, "HmacSHA256"));     // Catch: Exception -> L16 Throwable -> L21
        byte[] r10 = r9.doFinal("DATA_KEY".getBytes(RpcUtils.CHARSET_UTF8));     // Catch: Exception -> L16 Throwable -> L21
        this.confirmKey = r8;     // Catch: Exception -> L16 Throwable -> L21
        this.dataKey = r10;     // Catch: Exception -> L16 Throwable -> L21
        byte[] r0 = (byte[]) ZeusTransformUtils.preCheckCast(this.sharedKey.clone(), byte[].class, "com.obric.memorydata.plugin");     // Catch: Exception -> L16 Throwable -> L21
        monitor-exit(this);
        return r0;
    L16:
        e = move-exception;
        throw new IllegalStateException("Failed to derive shared key", e);     // Catch: Throwable -> L21
    L9:
        if (r1.length <= 0) goto L25;
        byte[] r11 = (byte[]) ZeusTransformUtils.preCheckCast(r1.clone(), byte[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        monitor-exit(this);
        return r11;
    L20:
        throw new IllegalStateException("receiveRound2Payload() must be called before deriveSharedKey()");     // Catch: Throwable -> L21
    }

    public synchronized KeyConfirmMsg generateKeyConfirmMsg() {
        monitor-enter(this);
        ensureSharedKeyAvailable();     // Catch: Throwable -> L11
        byte[] r0 = new byte[16];     // Catch: Exception -> L8 Throwable -> L11
        new SecureRandom().nextBytes(r0);     // Catch: Exception -> L8 Throwable -> L11
        Mac r1 = Mac.getInstance("HmacSHA256");     // Catch: Exception -> L8 Throwable -> L11
        r1.init(new SecretKeySpec(this.confirmKey, "HmacSHA256"));     // Catch: Exception -> L8 Throwable -> L11
        KeyConfirmMsg r2 = new KeyConfirmMsg(r0, r1.doFinal(r0));     // Catch: Exception -> L8 Throwable -> L11
        monitor-exit(this);
        return r2;
    L8:
        e = move-exception;
        throw new IllegalStateException("Failed to generate key confirm message", e);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public synchronized Round1Msg generateRound1Payload() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.round1Sent == true) goto L9;
        JPAKERound1Payload r0 = this.participant.createRound1PayloadToSend();     // Catch: Throwable -> L10
        this.round1Sent = true;     // Catch: Throwable -> L10
        Round1Msg r1 = new Round1Msg(r0);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r1;
    L9:
        throw new IllegalStateException("Round1 payload already generated");     // Catch: Throwable -> L10
    }

    public synchronized Round2Msg generateRound2Payload() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.round1Received == false) goto L13;
        if (this.round2Sent == true) goto L11;
        JPAKERound2Payload r0 = this.participant.createRound2PayloadToSend();     // Catch: Throwable -> L14
        this.round2Sent = true;     // Catch: Throwable -> L14
        Round2Msg r1 = new Round2Msg(r0);     // Catch: Throwable -> L14
        monitor-exit(this);
        return r1;
    L11:
        throw new IllegalStateException("Round2 payload already generated");     // Catch: Throwable -> L14
    L13:
        throw new IllegalStateException("receiveRound1Payload() must be called before generateRound2Payload()");     // Catch: Throwable -> L14
    }

    public synchronized byte[] getDataKey() {
        monitor-enter(this);
        ensureSharedKeyAvailable();     // Catch: Throwable -> L10
        if (this.keyConfirmed == false) goto L9;
        byte[] r0 = (byte[]) ZeusTransformUtils.preCheckCast(this.dataKey.clone(), byte[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        monitor-exit(this);
        return r0;
    L9:
        throw new IllegalStateException("data key not confirmed; call verifyKeyConfirmMsg() successfully on this side before getDataKey()");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public PakeRole getRole() {
        return this.role;
    }

    public synchronized boolean isKeyConfirmed() {
        monitor-enter(this);
        boolean r0 = this.keyConfirmed;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void receiveRound1Payload(Round1Msg r3) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.round1Sent == false) goto L16;
        if (this.round1Received == true) goto L14;
        this.participant.validateRound1PayloadReceived(r3.payload);     // Catch: Exception -> L10 Throwable -> L17
        this.round1Received = true;     // Catch: Exception -> L10 Throwable -> L17
        monitor-exit(this);
        return;
    L10:
        e = move-exception;
        throw new IllegalStateException("Failed to validate round1 payload", e);     // Catch: Throwable -> L17
    L14:
        throw new IllegalStateException("Round1 payload already received");     // Catch: Throwable -> L17
    L16:
        throw new IllegalStateException("generateRound1Payload() must be called before receiveRound1Payload()");     // Catch: Throwable -> L17
    }

    public synchronized void receiveRound2Payload(Round2Msg r3) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.round2Sent == false) goto L16;
        if (this.round2Received == true) goto L14;
        this.participant.validateRound2PayloadReceived(r3.payload);     // Catch: Exception -> L10 Throwable -> L17
        this.round2Received = true;     // Catch: Exception -> L10 Throwable -> L17
        monitor-exit(this);
        return;
    L10:
        e = move-exception;
        throw new IllegalStateException("Failed to validate round2 payload", e);     // Catch: Throwable -> L17
    L14:
        throw new IllegalStateException("Round2 payload already received");     // Catch: Throwable -> L17
    L16:
        throw new IllegalStateException("generateRound2Payload() must be called before receiveRound2Payload()");     // Catch: Throwable -> L17
    }

    public synchronized boolean verifyKeyConfirmMsg(KeyConfirmMsg r5) {
        monitor-enter(this);
        ensureSharedKeyAvailable();     // Catch: Throwable -> L10
        Mac r0 = Mac.getInstance("HmacSHA256");     // Catch: Exception -> L7 Throwable -> L10
        r0.init(new SecretKeySpec(this.confirmKey, "HmacSHA256"));     // Catch: Exception -> L7 Throwable -> L10
        boolean r6 = Arrays.equals(r0.doFinal(r5.salt), r5.hmac);     // Catch: Exception -> L7 Throwable -> L10
        this.keyConfirmed = r6;     // Catch: Exception -> L7 Throwable -> L10
        monitor-exit(this);
        return r6;
    L7:
        e = move-exception;
        throw new IllegalStateException("Failed to verify key confirm message", e);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }
}
