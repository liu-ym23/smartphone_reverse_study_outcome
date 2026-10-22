package org.apache.poi.hslf.record;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class AnimationInfoAtom extends RecordAtom {
    private static final int[] FLAGS_MASKS = null;
    private static final String[] FLAGS_NAMES = null;
    private final byte[] _header;
    private final byte[] _recdata;

    static {
        FLAGS_MASKS = new int[]{1, 4, 16, 64, 256, 1024, 4096, 16384};
        FLAGS_NAMES = new String[]{"REVERSE", "AUTOMATIC", "SOUND", "STOP_SOUND", "PLAY", "SYNCHRONOUS", "HIDE", "ANIMATE_BG"};
    }

    public AnimationInfoAtom() {
        byte[] r0 = new byte[28];
        this._recdata = r0;
        byte[] r1 = new byte[8];
        this._header = r1;
        LittleEndian.putShort(r1, 0, 1);
        LittleEndian.putShort(r1, 2, (short) getRecordType());
        LittleEndian.putInt(r1, 4, r0.length);
    }

    public AnimationInfoAtom(byte[] r2, int r3, int r4) {
        int r0 = r3 + 8;
        this._header = Arrays.copyOfRange(r2, r3, r0);
        this._recdata = IOUtils.safelyClone(r2, r0, r4 - 8, getMaxRecordLength());
    }

    public int getDelayTime() {
        return LittleEndian.getInt(this._recdata, 12);
    }

    public int getDimColor() {
        return LittleEndian.getInt(this._recdata, 0);
    }

    public boolean getFlag(int r1) {
        if ((getMask() & r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("dimColor", new $$Lambda$3eH_3ZSpW6p9qj9E9vRIgnEKncA(this), "flags", GenericRecordUtil.getBitsAsString(new $$Lambda$YMpwJesl6_DWP8R9n015965EAaU(this), FLAGS_MASKS, FLAGS_NAMES), "soundIdRef", new $$Lambda$kOS92BueKJC4YBXYmXnNf4Rz_BY(this), "delayTime", new $$Lambda$IGeZbpaJGN5FG3ySs8HmcZZ40(this), "orderID", new $$Lambda$dh8OFnGo6HyrViWF41BRAZtx1ng(this), "slideCount", new $$Lambda$k0Cr38yzfLUlDwCNxqIHH21NGvI(this));
    }

    public int getMask() {
        return LittleEndian.getInt(this._recdata, 4);
    }

    public int getOrderID() {
        return LittleEndian.getInt(this._recdata, 16);
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return RecordTypes.AnimationInfoAtom.typeID;
    }

    public int getSlideCount() {
        return LittleEndian.getInt(this._recdata, 18);
    }

    public int getSoundIdRef() {
        return LittleEndian.getInt(this._recdata, 8);
    }

    public String toString() {
        int r0 = getMask();
        return "AnimationInfoAtom\n\tDimColor: " + getDimColor() + "\n\tMask: " + r0 + ", 0x" + Integer.toHexString(r0) + "\n\t  Reverse: " + getFlag(1) + "\n\t  Automatic: " + getFlag(4) + "\n\t  Sound: " + getFlag(16) + "\n\t  StopSound: " + getFlag(64) + "\n\t  Play: " + getFlag(256) + "\n\t  Synchronous: " + getFlag(1024) + "\n\t  Hide: " + getFlag(4096) + "\n\t  AnimateBg: " + getFlag(16384) + "\n\tSoundIdRef: " + getSoundIdRef() + "\n\tDelayTime: " + getDelayTime() + "\n\tOrderID: " + getOrderID() + "\n\tSlideCount: " + getSlideCount() + "\n";
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r2) {
        r2.write(this._header);
        r2.write(this._recdata);
    }
}
