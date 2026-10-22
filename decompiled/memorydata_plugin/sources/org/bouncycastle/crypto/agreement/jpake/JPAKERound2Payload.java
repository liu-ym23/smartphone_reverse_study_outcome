package org.bouncycastle.crypto.agreement.jpake;

import java.math.BigInteger;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class JPAKERound2Payload {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BigInteger f17971a;
    private final BigInteger[] knowledgeProofForX2s;
    private final String participantId;

    public JPAKERound2Payload(String r2, BigInteger r3, BigInteger[] r4) {
        JPAKEUtil.validateNotNull(r2, "participantId");
        JPAKEUtil.validateNotNull(r3, "a");
        JPAKEUtil.validateNotNull(r4, "knowledgeProofForX2s");
        this.participantId = r2;
        this.f17971a = r3;
        this.knowledgeProofForX2s = Arrays.copyOf(r4, r4.length);
    }

    public BigInteger getA() {
        return this.f17971a;
    }

    public BigInteger[] getKnowledgeProofForX2s() {
        BigInteger[] r1 = this.knowledgeProofForX2s;
        return Arrays.copyOf(r1, r1.length);
    }

    public String getParticipantId() {
        return this.participantId;
    }
}
