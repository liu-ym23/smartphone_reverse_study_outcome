package org.bouncycastle.util.test;

import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes7.dex */
public class TestRandomData extends FixedSecureRandom {
    public TestRandomData(String r3) {
        super(new FixedSecureRandom.Source[]{new FixedSecureRandom.Data(Hex.decode(r3))});
    }

    public TestRandomData(byte[] r3) {
        super(new FixedSecureRandom.Source[]{new FixedSecureRandom.Data(r3)});
    }
}
