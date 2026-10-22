package org.bouncycastle.util.encoders;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes7.dex */
public interface Encoder {
    int decode(String r1, OutputStream r2);

    int encode(byte[] r1, int r2, int r3, OutputStream r4);

    int getEncodedLength(int r1);
}
