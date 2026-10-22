package org.apache.commons.compress.archivers.dump;

import org.apache.commons.compress.utils.ByteUtils;

/* JADX INFO: loaded from: classes6.dex */
class DumpArchiveUtil {
    public static final int convert32(byte[] r1, int r2) {
        return (int) ByteUtils.fromLittleEndian(r1, r2, 4);
    }
}
