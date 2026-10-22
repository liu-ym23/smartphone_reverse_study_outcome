package org.bouncycastle.crypto.agreement.jpake;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class JPAKEParticipant {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BigInteger f17970b;
    private final Digest digest;
    private final BigInteger g;
    private BigInteger gx1;
    private BigInteger gx2;
    private BigInteger gx3;
    private BigInteger gx4;
    private final BigInteger p;
    private final String participantId;
    private String partnerParticipantId;
    private char[] password;
    private final BigInteger q;
    private final SecureRandom random;
    private int state;
    private BigInteger x1;
    private BigInteger x2;

    public JPAKEParticipant(String r2, char[] r3) {
        this(r2, r3, JPAKEPrimeOrderGroups.NIST_3072);
    }

    public JPAKEParticipant(String r7, char[] r8, JPAKEPrimeOrderGroup r9) {
        this(r7, r8, r9, new SHA256Digest(), CryptoServicesRegistrar.getSecureRandom());
    }

    public JPAKEParticipant(String r3, char[] r4, JPAKEPrimeOrderGroup r5, Digest r6, SecureRandom r7) {
        Digest r8 = (Digest) ZeusTransformUtils.wrapperContextForParams(r6, Digest.class, "com.obric.memorydata.plugin");
        JPAKEUtil.validateNotNull(r3, "participantId");
        JPAKEUtil.validateNotNull(r4, "password");
        JPAKEUtil.validateNotNull(r5, "p");
        JPAKEUtil.validateNotNull(r8, "digest");
        JPAKEUtil.validateNotNull(r7, "random");
        if (r4.length == 0) goto L7;
        this.participantId = r3;
        this.password = Arrays.copyOf(r4, r4.length);
        this.p = r5.getP();
        this.q = r5.getQ();
        this.g = r5.getG();
        this.digest = r8;
        this.random = r7;
        this.state = 0;
        return;
    L7:
        throw new IllegalArgumentException("Password must not be empty.");
    }

    public BigInteger calculateKeyingMaterial() {
        int r0 = this.state;
        if (r0 >= 50) goto L11;
        if (r0 < 40) goto L9;
        BigInteger r6 = JPAKEUtil.calculateS(this.password);
        Arrays.fill(this.password, 0);
        this.password = null;
        BigInteger r2 = JPAKEUtil.calculateKeyingMaterial(this.p, this.q, this.gx4, this.x2, r6, this.f17970b);
        this.x1 = null;
        this.x2 = null;
        this.f17970b = null;
        this.state = 50;
        return r2;
    L9:
        throw new IllegalStateException("Round2 payload must be validated prior to creating key for " + this.participantId);
    L11:
        throw new IllegalStateException("Key already calculated for " + this.participantId);
    }

    public JPAKERound1Payload createRound1PayloadToSend() {
        if (this.state >= 10) goto L7;
        this.x1 = JPAKEUtil.generateX1(this.q, this.random);
        this.x2 = JPAKEUtil.generateX2(this.q, this.random);
        this.gx1 = JPAKEUtil.calculateGx(this.p, this.g, this.x1);
        this.gx2 = JPAKEUtil.calculateGx(this.p, this.g, this.x2);
        BigInteger[] r15 = JPAKEUtil.calculateZeroKnowledgeProof(this.p, this.q, this.g, this.gx1, this.x1, this.participantId, this.digest, this.random);
        BigInteger[] r16 = JPAKEUtil.calculateZeroKnowledgeProof(this.p, this.q, this.g, this.gx2, this.x2, this.participantId, this.digest, this.random);
        this.state = 10;
        return new JPAKERound1Payload(this.participantId, this.gx1, this.gx2, r15, r16);
    L7:
        throw new IllegalStateException("Round1 payload already created for " + this.participantId);
    }

    public JPAKERound2Payload createRound2PayloadToSend() {
        int r0 = this.state;
        if (r0 >= 30) goto L11;
        if (r0 < 20) goto L9;
        BigInteger r7 = JPAKEUtil.calculateGA(this.p, this.gx1, this.gx3, this.gx4);
        BigInteger r9 = JPAKEUtil.calculateX2s(this.q, this.x2, JPAKEUtil.calculateS(this.password));
        BigInteger r1 = JPAKEUtil.calculateA(this.p, this.q, r7, r9);
        BigInteger[] r2 = JPAKEUtil.calculateZeroKnowledgeProof(this.p, this.q, r7, r1, r9, this.participantId, this.digest, this.random);
        this.state = 30;
        return new JPAKERound2Payload(this.participantId, r1, r2);
    L9:
        throw new IllegalStateException("Round1 payload must be validated prior to creating Round2 payload for " + this.participantId);
    L11:
        throw new IllegalStateException("Round2 payload already created for " + this.participantId);
    }

    public void validateRound1PayloadReceived(JPAKERound1Payload r15) {
        if (this.state >= 20) goto L7;
        this.partnerParticipantId = r15.getParticipantId();
        this.gx3 = r15.getGx1();
        this.gx4 = r15.getGx2();
        BigInteger[] r6 = r15.getKnowledgeProofForX1();
        BigInteger[] r11 = r15.getKnowledgeProofForX2();
        JPAKEUtil.validateParticipantIdsDiffer(this.participantId, r15.getParticipantId());
        JPAKEUtil.validateGx4(this.gx4);
        JPAKEUtil.validateZeroKnowledgeProof(this.p, this.q, this.g, this.gx3, r6, r15.getParticipantId(), this.digest);
        JPAKEUtil.validateZeroKnowledgeProof(this.p, this.q, this.g, this.gx4, r11, r15.getParticipantId(), this.digest);
        this.state = 20;
        return;
    L7:
        throw new IllegalStateException("Validation already attempted for round1 payload for" + this.participantId);
    }

    public void validateRound2PayloadReceived(JPAKERound2Payload r13) {
        int r0 = this.state;
        if (r0 >= 40) goto L11;
        if (r0 < 20) goto L9;
        BigInteger r7 = JPAKEUtil.calculateGA(this.p, this.gx3, this.gx1, this.gx2);
        this.f17970b = r13.getA();
        BigInteger[] r9 = r13.getKnowledgeProofForX2s();
        JPAKEUtil.validateParticipantIdsDiffer(this.participantId, r13.getParticipantId());
        JPAKEUtil.validateParticipantIdsEqual(this.partnerParticipantId, r13.getParticipantId());
        JPAKEUtil.validateGa(r7);
        JPAKEUtil.validateZeroKnowledgeProof(this.p, this.q, r7, this.f17970b, r9, r13.getParticipantId(), this.digest);
        this.state = 40;
        return;
    L9:
        throw new IllegalStateException("Round1 payload must be validated prior to validating Round2 payload for " + this.participantId);
    L11:
        throw new IllegalStateException("Validation already attempted for round2 payload for" + this.participantId);
    }
}
