package org.apache.poi.hpsf;

import org.apache.poi.util.HexDump;

/* JADX INFO: loaded from: classes7.dex */
public class IllegalVariantTypeException extends VariantTypeException {
    public IllegalVariantTypeException(long r3, Object r5) {
        this(r3, r5, "The variant type " + r3 + " (" + Variant.getVariantName(r3) + ", " + HexDump.toHex(r3) + ") is illegal in this context.");
    }

    public IllegalVariantTypeException(long r1, Object r3, String r4) {
        super(r1, r3, r4);
    }
}
