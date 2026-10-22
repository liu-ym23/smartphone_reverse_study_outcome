package org.apache.commons.compress.archivers.zip;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes6.dex */
public interface ZipEncoding {
    boolean canEncode(String r1);

    String decode(byte[] r1);

    ByteBuffer encode(String r1);
}
