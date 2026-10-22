package org.apache.poi.hpsf;

import org.apache.poi.util.HexDump;

/* JADX INFO: loaded from: classes7.dex */
public abstract class UnsupportedVariantTypeException extends VariantTypeException {
    public UnsupportedVariantTypeException(long r3, Object r5) {
        super(r3, r5, "HPSF does not yet support the variant type " + r3 + " (" + Variant.getVariantName(r3) + ", " + HexDump.toHex(r3) + "). If you want support for this variant type in one of the next POI releases please submit a request for enhancement (RFE) to <http://issues.apache.org/bugzilla/>! Thank you!");
    }
}
