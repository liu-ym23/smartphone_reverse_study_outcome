package org.apache.poi.sl.image;

import java.util.Arrays;
import org.apache.poi.poifs.filesystem.FileMagic;

/* JADX INFO: loaded from: classes7.dex */
public final class ImageHeaderPNG {
    private final byte[] data;

    public ImageHeaderPNG(byte[] r1) {
        this.data = r1;
    }

    public byte[] extractPNG() {
        byte[] r0 = this.data;
        if (r0.length < 16) goto L8;
        byte[] r1 = Arrays.copyOfRange(r0, 16, r0.length);
        if (FileMagic.valueOf(r1) != FileMagic.PNG) goto L8;
        return r1;
    L8:
        return this.data;
    }
}
