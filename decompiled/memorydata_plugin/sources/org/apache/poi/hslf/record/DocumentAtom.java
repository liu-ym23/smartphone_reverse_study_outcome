package org.apache.poi.hslf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndianByteArrayInputStream;

/* JADX INFO: loaded from: classes7.dex */
public final class DocumentAtom extends RecordAtom {
    private static final long _type = 0;
    private final byte[] _header;
    private final int firstSlideNum;
    private final long handoutMasterPersist;
    private final long notesMasterPersist;
    private long notesSizeX;
    private long notesSizeY;
    private final byte omitTitlePlace;
    private final byte[] reserved;
    private final byte rightToLeft;
    private byte saveWithFonts;
    private long serverZoomFrom;
    private long serverZoomTo;
    private final byte showComments;
    private int slideSizeType;
    private long slideSizeX;
    private long slideSizeY;

    public static final enum SlideSize extends Enum<SlideSize> {
        private static final /* synthetic */ SlideSize[] $VALUES = null;
        public static final SlideSize A4_SIZED_PAPER = null;
        public static final SlideSize BANNER = null;
        public static final SlideSize CUSTOM = null;
        public static final SlideSize LETTER_SIZED_PAPER = null;
        public static final SlideSize ON_35MM = null;
        public static final SlideSize ON_SCREEN = null;
        public static final SlideSize OVERHEAD = null;

        static {
            SlideSize r0 = new SlideSize("ON_SCREEN", 0);
            ON_SCREEN = r0;
            SlideSize r1 = new SlideSize("LETTER_SIZED_PAPER", 1);
            LETTER_SIZED_PAPER = r1;
            SlideSize r3 = new SlideSize("A4_SIZED_PAPER", 2);
            A4_SIZED_PAPER = r3;
            SlideSize r5 = new SlideSize("ON_35MM", 3);
            ON_35MM = r5;
            SlideSize r7 = new SlideSize("OVERHEAD", 4);
            OVERHEAD = r7;
            SlideSize r9 = new SlideSize("BANNER", 5);
            BANNER = r9;
            SlideSize r11 = new SlideSize("CUSTOM", 6);
            CUSTOM = r11;
            $VALUES = new SlideSize[]{r0, r1, r3, r5, r7, r9, r11};
        }

        private SlideSize(String r1, int r2) {
            super(r1, r2);
        }

        public static SlideSize valueOf(String r2) {
            return (SlideSize) ZeusTransformUtils.preCheckCast(Enum.valueOf(SlideSize.class, r2), SlideSize.class, "com.obric.memorydata.plugin");
        }

        public static SlideSize[] values() {
            return (SlideSize[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SlideSize[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        _type = RecordTypes.DocumentAtom.typeID;
    }

    DocumentAtom(byte[] r5, int r6, int r7) {
        byte[] r0 = new byte[8];
        this._header = r0;
        int r8 = Math.max(r7, 48);
        LittleEndianByteArrayInputStream r1 = new LittleEndianByteArrayInputStream(r5, r6, r8);
        r1.readFully(r0);
        this.slideSizeX = r1.readInt();
        this.slideSizeY = r1.readInt();
        this.notesSizeX = r1.readInt();
        this.notesSizeY = r1.readInt();
        this.serverZoomFrom = r1.readInt();
        this.serverZoomTo = r1.readInt();
        this.notesMasterPersist = r1.readInt();
        this.handoutMasterPersist = r1.readInt();
        this.firstSlideNum = r1.readShort();
        this.slideSizeType = r1.readShort();
        this.saveWithFonts = r1.readByte();
        this.omitTitlePlace = r1.readByte();
        this.rightToLeft = r1.readByte();
        this.showComments = r1.readByte();
        byte[] r9 = IOUtils.safelyAllocate(((long) r8) - 48, getMaxRecordLength());
        this.reserved = r9;
        r1.readFully(r9);
    }

    public int getFirstSlideNum() {
        return this.firstSlideNum;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("slideSizeX", new $$Lambda$KeGNotugTV_UpysEVUw2fAfZbg(this));
        r0.put("slideSizeY", new $$Lambda$wdiph4z27IdrE8ghvkEtM6ckOM(this));
        r0.put("notesSizeX", new $$Lambda$EPwPnFAJsEBLfrnbKAcv36GjEn4(this));
        r0.put("notesSizeY", new $$Lambda$ejaiAewfZdkCt84WjH46bUVy9Tk(this));
        r0.put("serverZoomFrom", new $$Lambda$6RiOgr0Vxx7enqZBuGGX9qQTCUE(this));
        r0.put("serverZoomTo", new $$Lambda$cCllRxvVRGI0Ydb0Bd0qL2RVWU(this));
        r0.put("notesMasterPersist", new $$Lambda$bIS2QGo5_llsMlSqdJ7BbG4Ic(this));
        r0.put("handoutMasterPersist", new $$Lambda$WbJWMPlYOGKo39rji6AYMqTR3O8(this));
        r0.put("firstSlideNum", new $$Lambda$nfnIndiGrACFf5gS6cfpLUbR9o(this));
        r0.put("slideSize", new $$Lambda$D3VMu31bkv9Vyh0TIItkvGGZBPM(this));
        r0.put("saveWithFonts", new $$Lambda$vBlksAXaHm2C4KdtlB5C1yI4Y(this));
        r0.put("omitTitlePlace", new $$Lambda$Xq7bWB53HDa6drQtTwRKnAtKkI(this));
        r0.put("rightToLeft", new $$Lambda$81rZ6vZC_fYmoN6eI5r3QMJqutM(this));
        r0.put("showComments", new $$Lambda$h6HuPmBQ_MQx3k8EvUUEnQQeqRU(this));
        return Collections.unmodifiableMap(r0);
    }

    public long getHandoutMasterPersist() {
        return this.handoutMasterPersist;
    }

    public long getNotesMasterPersist() {
        return this.notesMasterPersist;
    }

    public long getNotesSizeX() {
        return this.notesSizeX;
    }

    public long getNotesSizeY() {
        return this.notesSizeY;
    }

    public boolean getOmitTitlePlace() {
        if (this.omitTitlePlace == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return _type;
    }

    public boolean getRightToLeft() {
        if (this.rightToLeft == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean getSaveWithFonts() {
        if (this.saveWithFonts == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public long getServerZoomFrom() {
        return this.serverZoomFrom;
    }

    public long getServerZoomTo() {
        return this.serverZoomTo;
    }

    public boolean getShowComments() {
        if (this.showComments == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Deprecated
    public SlideSize getSlideSizeTypeEnum() {
        return SlideSize.values()[this.slideSizeType];
    }

    public long getSlideSizeX() {
        return this.slideSizeX;
    }

    public long getSlideSizeY() {
        return this.slideSizeY;
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r3) {
        r3.write(this._header);
        writeLittleEndian((int) this.slideSizeX, r3);
        writeLittleEndian((int) this.slideSizeY, r3);
        writeLittleEndian((int) this.notesSizeX, r3);
        writeLittleEndian((int) this.notesSizeY, r3);
        writeLittleEndian((int) this.serverZoomFrom, r3);
        writeLittleEndian((int) this.serverZoomTo, r3);
        writeLittleEndian((int) this.notesMasterPersist, r3);
        writeLittleEndian((int) this.handoutMasterPersist, r3);
        writeLittleEndian((short) this.firstSlideNum, r3);
        writeLittleEndian((short) this.slideSizeType, r3);
        r3.write(this.saveWithFonts);
        r3.write(this.omitTitlePlace);
        r3.write(this.rightToLeft);
        r3.write(this.showComments);
        r3.write(this.reserved);
    }
}
