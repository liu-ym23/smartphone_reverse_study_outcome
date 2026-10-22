package org.bouncycastle.pqc.crypto.frodo;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.crypto.Xof;

/* JADX INFO: loaded from: classes7.dex */
class FrodoEngine {
    private final int B;
    private final int D;
    private final short[] T_chi;
    private final Xof digest;

    /* JADX INFO: renamed from: gen, reason: collision with root package name */
    private final FrodoMatrixGenerator f17981gen;
    private final int len_ct_bytes;
    private final int len_k;
    private final int len_k_bytes;
    private final int len_mu;
    private final int len_mu_bytes;
    private final int len_pk_bytes;
    private final int len_pkh;
    private final int len_pkh_bytes;
    private final int len_s;
    private final int len_s_bytes;
    private final int len_seedSE;
    private final int len_seedSE_bytes;
    private final int len_sk_bytes;
    private final int len_ss;
    private final int len_ss_bytes;
    private final int n;
    private final int q;

    public FrodoEngine(int r3, int r4, int r5, short[] r6, Xof r7, FrodoMatrixGenerator r8) {
        Xof r9 = (Xof) ZeusTransformUtils.wrapperContextForParams(r7, Xof.class, "com.obric.memorydata.plugin");
        this.n = r3;
        this.D = r4;
        this.q = 1 << r4;
        this.B = r5;
        int r10 = (r5 * 8) * 8;
        this.len_mu = r10;
        this.len_seedSE = r10;
        this.len_s = r10;
        this.len_k = r10;
        this.len_pkh = r10;
        this.len_ss = r10;
        this.len_mu_bytes = r10 / 8;
        this.len_seedSE_bytes = r10 / 8;
        int r0 = r10 / 8;
        this.len_s_bytes = r0;
        this.len_k_bytes = r10 / 8;
        int r1 = r10 / 8;
        this.len_pkh_bytes = r1;
        this.len_ss_bytes = r10 / 8;
        int r11 = ((r4 * r3) * 8) / 8;
        this.len_ct_bytes = (((r4 * 8) * 8) / 8) + r11;
        int r12 = r11 + 16;
        this.len_pk_bytes = r12;
        this.len_sk_bytes = (r0 + r12) + (((r3 * 2) * 8) + r1);
        this.T_chi = r6;
        this.digest = r9;
        this.f17981gen = r8;
    }
}
