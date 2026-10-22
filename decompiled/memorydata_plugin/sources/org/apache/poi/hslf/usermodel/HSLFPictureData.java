package org.apache.poi.hslf.usermodel;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.ddf.EscherBSERecord;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.hslf.blip.DIB;
import org.apache.poi.hslf.blip.EMF;
import org.apache.poi.hslf.blip.JPEG;
import org.apache.poi.hslf.blip.PICT;
import org.apache.poi.hslf.blip.PNG;
import org.apache.poi.hslf.blip.WMF;
import org.apache.poi.sl.usermodel.PictureData;

/* JADX INFO: loaded from: classes7.dex */
public abstract class HSLFPictureData implements GenericRecord, PictureData {
    private static final c LOGGER = null;
    final EscherContainerRecord bStore;
    final EscherBSERecord bse;
    private byte[] formattedData;
    private int index;
    private int uidInstanceCount;

    /* JADX INFO: renamed from: org.apache.poi.hslf.usermodel.HSLFPictureData$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$PictureData$PictureType = null;

        static {
            int[] r0 = new int[PictureData.PictureType.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$PictureData$PictureType = r0;
            r0[PictureData.PictureType.EMF.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$org$apache$poi$sl$usermodel$PictureData$PictureType[PictureData.PictureType.WMF.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$org$apache$poi$sl$usermodel$PictureData$PictureType[PictureData.PictureType.PICT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$org$apache$poi$sl$usermodel$PictureData$PictureType[PictureData.PictureType.JPEG.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$org$apache$poi$sl$usermodel$PictureData$PictureType[PictureData.PictureType.PNG.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$org$apache$poi$sl$usermodel$PictureData$PictureType[PictureData.PictureType.DIB.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    static {
        LOGGER = b.a(HSLFPictureData.class);
    }

    @Deprecated
    public HSLFPictureData() {
        this(new EscherContainerRecord(), new EscherBSERecord());
        LOGGER.atWarn().a("The no-arg constructor is deprecated. Some functionality such as updating pictures won't work.");
    }

    public HSLFPictureData(EscherContainerRecord r3, EscherBSERecord r4) {
        this.uidInstanceCount = 1;
        this.index = -1;
        this.bStore = (EscherContainerRecord) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r3), EscherContainerRecord.class, "com.obric.memorydata.plugin");
        this.bse = (EscherBSERecord) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r4), EscherBSERecord.class, "com.obric.memorydata.plugin");
    }

    static HSLFPictureData createFromSlideshowData(PictureData.PictureType r0, EscherContainerRecord r1, EscherBSERecord r2, byte[] r3, int r4) {
        HSLFPictureData r5 = newInstance(r0, r1, r2);
        r5.setSignature(r4);
        r5.formattedData = r3;
        return r5;
    }

    private static HSLFPictureData newInstance(PictureData.PictureType r2, EscherContainerRecord r3, EscherBSERecord r4) {
        switch(AnonymousClass1.$SwitchMap$org$apache$poi$sl$usermodel$PictureData$PictureType[r2.ordinal()]) {
            case 1: goto L17;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L7;
            default: goto L5;
        };
    L5:
        throw new IllegalArgumentException("Unsupported picture type: " + r2);
    L7:
        return new DIB(r3, r4);
    L9:
        return new PNG(r3, r4);
    L11:
        return new JPEG(r3, r4);
    L13:
        return new PICT(r3, r4);
    L15:
        return new WMF(r3, r4);
    L17:
        return new EMF(r3, r4);
    }

    public byte[] getChecksum() {
        return getUID();
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("type", new $$Lambda$tet5bELoh_2HJ9a3SSH1ZUloOQ(this));
        r0.put("imageDimension", new $$Lambda$W6UOkgDmrv113nKRWKGiXddCXs8(this));
        r0.put("signature", new $$Lambda$q0sN7dSeXtDSel9a0EDIPh1kAw(this));
        r0.put("uidInstanceCount", new $$Lambda$cfSubzWg9273vJWwgb8Gyo3pY7s(this));
        r0.put(TypedValues.CycleType.S_WAVE_OFFSET, new $$Lambda$N8IpuSuXsdxr4V3J2FO4PuyQhQw(this));
        r0.put("uid", new $$Lambda$YOuTvcG6ct5wiVbV5fSZnDaGMT8(this));
        r0.put("checksum", new $$Lambda$QvbU9s8SUiJUpCcLqR7OyBXU0(this));
        r0.put("index", new $$Lambda$ijWgyWPPeTxKdx6ZxF7Fge35010(this));
        r0.put("rawData", new $$Lambda$ftYt5PwRVQ9xEkmk6UxbaEYQ(this));
        return Collections.unmodifiableMap(r0);
    }

    public int getIndex() {
        return this.index;
    }

    public int getOffset() {
        return this.bse.getOffset();
    }

    public byte[] getRawData() {
        return this.formattedData;
    }

    public abstract int getSignature();

    public byte[] getUID() {
        return Arrays.copyOf(this.formattedData, 16);
    }

    public int getUIDInstanceCount() {
        return this.uidInstanceCount;
    }

    public void setIndex(int r1) {
        this.index = r1;
    }

    public abstract void setSignature(int r1);

    public void setUIDInstanceCount(int r1) {
        this.uidInstanceCount = r1;
    }
}
