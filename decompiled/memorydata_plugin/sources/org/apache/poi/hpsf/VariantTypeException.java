package org.apache.poi.hpsf;

/* JADX INFO: loaded from: classes7.dex */
public abstract class VariantTypeException extends HPSFException {
    private Object value;
    private long variantType;

    public VariantTypeException(long r1, Object r3, String r4) {
        super(r4);
        this.variantType = r1;
        this.value = r3;
    }

    public Object getValue() {
        return this.value;
    }

    public long getVariantType() {
        return this.variantType;
    }
}
