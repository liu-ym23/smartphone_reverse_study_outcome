package org.bouncycastle.jcajce.io;

import java.io.OutputStream;
import java.security.Signature;

/* JADX INFO: loaded from: classes7.dex */
public class OutputStreamFactory {
    public static OutputStream createStream(Signature r1) {
        return new SignatureUpdatingOutputStream(r1);
    }
}
