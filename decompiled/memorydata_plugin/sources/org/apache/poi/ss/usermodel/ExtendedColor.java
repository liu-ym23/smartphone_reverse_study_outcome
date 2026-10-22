package org.apache.poi.ss.usermodel;

/* JADX INFO: loaded from: classes7.dex */
public abstract class ExtendedColor {
    public ExtendedColor() {
    }

    public abstract short getIndex();

    public abstract byte[] getIndexedRGB();

    public byte[] getRGBOrARGB() {
        if (isIndexed() == false) goto L10;
        if (getIndex() <= 0) goto L10;
        byte[] r0 = getIndexedRGB();
        if (r0 == null) goto L10;
        return r0;
    L10:
        return getStoredRBG();
    }

    public abstract byte[] getStoredRBG();

    public abstract boolean isIndexed();
}
