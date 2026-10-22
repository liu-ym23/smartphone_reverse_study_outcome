package org.apache.poi.hwmf.record;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;

/* JADX INFO: loaded from: classes7.dex */
public class HwmfBitmap16 implements GenericRecord {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private byte[] bitmap;
    private int bitsPixel;
    private int height;
    private final boolean isPartial;
    private int planes;
    private int type;
    private int width;
    private int widthBytes;

    static {
    }

    public HwmfBitmap16() {
        this(false);
    }

    public HwmfBitmap16(boolean r1) {
        this.isPartial = r1;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("isPartial", new $$Lambda$HwmfBitmap16$1NlsqANNpZo9gCXstur4voueOXI(this));
        r0.put("type", new $$Lambda$HwmfBitmap16$ONdH_zf2N3cNeimYmwvcmrD5GJk(this));
        r0.put("width", new $$Lambda$HwmfBitmap16$s8Wp0sXGSGe4ob2zNaGikhO8eVk(this));
        r0.put("height", new $$Lambda$HwmfBitmap16$ssZeHidQamnW98uYxWhfsUNw0E(this));
        r0.put("widthBytes", new $$Lambda$HwmfBitmap16$as_p73tQxZBkFkL3bhE5ylXqENs(this));
        r0.put("planes", new $$Lambda$HwmfBitmap16$03mon4C2_pX3WjY749dLmVSoLo(this));
        r0.put("bitsPixel", new $$Lambda$HwmfBitmap16$Y8rOrXO5yhFpFxHlRZeIE5ONb6o(this));
        r0.put("bitmap", new $$Lambda$HwmfBitmap16$9jCdiCcITahZfJRQbMZi0zQJoTM(this));
        return Collections.unmodifiableMap(r0);
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$HwmfBitmap16() {
        return Boolean.valueOf(this.isPartial);
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$HwmfBitmap16() {
        return Integer.valueOf(this.type);
    }

    public /* synthetic */ Object lambda$getGenericProperties$2$HwmfBitmap16() {
        return Integer.valueOf(this.width);
    }

    public /* synthetic */ Object lambda$getGenericProperties$3$HwmfBitmap16() {
        return Integer.valueOf(this.height);
    }

    public /* synthetic */ Object lambda$getGenericProperties$4$HwmfBitmap16() {
        return Integer.valueOf(this.widthBytes);
    }

    public /* synthetic */ Object lambda$getGenericProperties$5$HwmfBitmap16() {
        return Integer.valueOf(this.planes);
    }

    public /* synthetic */ Object lambda$getGenericProperties$6$HwmfBitmap16() {
        return Integer.valueOf(this.bitsPixel);
    }

    public /* synthetic */ Object lambda$getGenericProperties$7$HwmfBitmap16() {
        return this.bitmap;
    }
}
