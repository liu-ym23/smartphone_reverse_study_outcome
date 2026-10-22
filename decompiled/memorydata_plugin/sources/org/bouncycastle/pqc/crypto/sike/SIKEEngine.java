package org.bouncycastle.pqc.crypto.sike;

/* JADX INFO: loaded from: classes7.dex */
class SIKEEngine {
    protected Fpx fpx;
    private boolean isCompressed;
    protected Isogeny isogeny;
    protected Internal params;
    private SIDH sidh;
    private SIDH_Compressed sidhCompressed;

    public SIKEEngine(int r2, boolean r3) {
        this.isCompressed = r3;
        if (r2 != 434) goto L5;
        Internal r4 = new P434(r3);
    L15:
        this.params = r4;
    L16:
        this.fpx = new Fpx(this);
        this.isogeny = new Isogeny(this);
        if (r3 == false) goto L19;
        this.sidhCompressed = new SIDH_Compressed(this);
    L19:
        this.sidh = new SIDH(this);
        return;
    L5:
        if (r2 != 503) goto L7;
        r4 = new P503(r3);
        goto L15
    L7:
        if (r2 != 610) goto L9;
        r4 = new P610(r3);
        goto L15
    L9:
        if (r2 != 751) goto L16;
        r4 = new P751(r3);
        goto L15
    }
}
