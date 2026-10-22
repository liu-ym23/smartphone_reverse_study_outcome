package org.bouncycastle.operator;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes7.dex */
public interface ContentVerifier {
    OutputStream getOutputStream();

    boolean verify(byte[] r1);
}
