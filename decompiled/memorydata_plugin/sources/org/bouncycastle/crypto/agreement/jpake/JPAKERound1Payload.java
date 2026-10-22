package org.bouncycastle.crypto.agreement.jpake;

import java.math.BigInteger;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class JPAKERound1Payload {
    private final BigInteger gx1;
    private final BigInteger gx2;
    private final BigInteger[] knowledgeProofForX1;
    private final BigInteger[] knowledgeProofForX2;
    private final String participantId;

    public JPAKERound1Payload(String r2, BigInteger r3, BigInteger r4, BigInteger[] r5, BigInteger[] r6) {
        JPAKEUtil.validateNotNull(r2, "participantId");
        JPAKEUtil.validateNotNull(r3, "gx1");
        JPAKEUtil.validateNotNull(r4, "gx2");
        JPAKEUtil.validateNotNull(r5, "knowledgeProofForX1");
        JPAKEUtil.validateNotNull(r6, "knowledgeProofForX2");
        this.participantId = r2;
        this.gx1 = r3;
        this.gx2 = r4;
        this.knowledgeProofForX1 = Arrays.copyOf(r5, r5.length);
        this.knowledgeProofForX2 = Arrays.copyOf(r6, r6.length);
    }

    public BigInteger getGx1() {
        return this.gx1;
    }

    public BigInteger getGx2() {
        return this.gx2;
    }

    public BigInteger[] getKnowledgeProofForX1() {
        BigInteger[] r1 = this.knowledgeProofForX1;
        return Arrays.copyOf(r1, r1.length);
    }

    public BigInteger[] getKnowledgeProofForX2() {
        BigInteger[] r1 = this.knowledgeProofForX2;
        return Arrays.copyOf(r1, r1.length);
    }

    public String getParticipantId() {
        return this.participantId;
    }
}
