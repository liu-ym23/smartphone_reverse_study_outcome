package org.bouncycastle.pqc.crypto.ntru;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.pqc.math.ntru.parameters.NTRUHPS2048509;
import org.bouncycastle.pqc.math.ntru.parameters.NTRUHPS2048677;
import org.bouncycastle.pqc.math.ntru.parameters.NTRUHPS4096821;
import org.bouncycastle.pqc.math.ntru.parameters.NTRUHRSS701;
import org.bouncycastle.pqc.math.ntru.parameters.NTRUParameterSet;

/* JADX INFO: loaded from: classes7.dex */
public class NTRUParameters implements CipherParameters {
    public static final NTRUParameters ntruhps2048509 = null;
    public static final NTRUParameters ntruhps2048677 = null;
    public static final NTRUParameters ntruhps4096821 = null;
    public static final NTRUParameters ntruhrss701 = null;
    private final String name;
    final NTRUParameterSet parameterSet;

    static {
        ntruhps2048509 = new NTRUParameters("ntruhps2048509", new NTRUHPS2048509());
        ntruhps2048677 = new NTRUParameters("ntruhps2048677", new NTRUHPS2048677());
        ntruhps4096821 = new NTRUParameters("ntruhps4096821", new NTRUHPS4096821());
        ntruhrss701 = new NTRUParameters("ntruhrss701", new NTRUHRSS701());
    }

    private NTRUParameters(String r1, NTRUParameterSet r2) {
        this.name = r1;
        this.parameterSet = r2;
    }

    public String getName() {
        return this.name;
    }
}
