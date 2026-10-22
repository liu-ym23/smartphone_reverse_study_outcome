package org.bouncycastle.pqc.crypto.picnic;

import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes7.dex */
public class PicnicParameters implements CipherParameters {
    public static final PicnicParameters picnic3l1 = null;
    public static final PicnicParameters picnic3l3 = null;
    public static final PicnicParameters picnic3l5 = null;
    public static final PicnicParameters picnicl1fs = null;
    public static final PicnicParameters picnicl1full = null;
    public static final PicnicParameters picnicl1ur = null;
    public static final PicnicParameters picnicl3fs = null;
    public static final PicnicParameters picnicl3full = null;
    public static final PicnicParameters picnicl3ur = null;
    public static final PicnicParameters picnicl5fs = null;
    public static final PicnicParameters picnicl5full = null;
    public static final PicnicParameters picnicl5ur = null;
    private final String name;
    private final int param;

    static {
        picnicl1fs = new PicnicParameters("picnicl1fs", 1);
        picnicl1ur = new PicnicParameters("picnicl1ur", 2);
        picnicl3fs = new PicnicParameters("picnicl3fs", 3);
        picnicl3ur = new PicnicParameters("picnicl3ur", 4);
        picnicl5fs = new PicnicParameters("picnicl5fs", 5);
        picnicl5ur = new PicnicParameters("picnicl5ur", 6);
        picnic3l1 = new PicnicParameters("picnic3l1", 7);
        picnic3l3 = new PicnicParameters("picnic3l3", 8);
        picnic3l5 = new PicnicParameters("picnic3l5", 9);
        picnicl1full = new PicnicParameters("picnicl1full", 10);
        picnicl3full = new PicnicParameters("picnicl3full", 11);
        picnicl5full = new PicnicParameters("picnicl5full", 12);
    }

    private PicnicParameters(String r1, int r2) {
        this.name = r1;
        this.param = r2;
    }

    public String getName() {
        return this.name;
    }
}
