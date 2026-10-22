package org.apache.poi.hslf.record;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public class SSSlideInfoAtom extends RecordAtom {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int[] EFFECT_MASKS = null;
    private static final String[] EFFECT_NAMES = null;
    private static final long _type = 0;
    private short _effectDirection;
    private short _effectTransitionFlags;
    private short _effectType;
    private final byte[] _header;
    private int _slideTime;
    private int _soundIdRef;
    private short _speed;
    private final byte[] _unused;

    static {
        EFFECT_MASKS = new int[]{1, 4, 16, 64, 256, 1024, 4096};
        EFFECT_NAMES = new String[]{"MANUAL_ADVANCE", "HIDDEN", "SOUND", "LOOP_SOUND", "STOP_SOUND", "AUTO_ADVANCE", "CURSOR_VISIBLE"};
        _type = RecordTypes.SSSlideInfoAtom.typeID;
    }

    public SSSlideInfoAtom() {
        byte[] r0 = new byte[8];
        this._header = r0;
        LittleEndian.putShort(r0, 0, 0);
        LittleEndian.putShort(r0, 2, (short) _type);
        LittleEndian.putShort(r0, 4, 16);
        LittleEndian.putShort(r0, 6, 0);
        this._unused = new byte[3];
    }

    public SSSlideInfoAtom(byte[] r7, int r8, int r9) {
        byte[] r10 = Arrays.copyOfRange(r7, r8, r8 + 8);
        this._header = r10;
        int r11 = r8 + r10.length;
        if (LittleEndian.getShort(r10, 0) == 0) goto L6;
        LOG.atDebug().a("Invalid data for SSSlideInfoAtom at offset 0: " + LittleEndian.getShort(r10, 0));
    L6:
        if (LittleEndian.getShort(r10, 2) == RecordTypes.SSSlideInfoAtom.typeID) goto L9;
        LOG.atDebug().a("Invalid data for SSSlideInfoAtom at offset 2: " + LittleEndian.getShort(r10, 2));
    L9:
        if (LittleEndian.getShort(r10, 4) == 16) goto L12;
        LOG.atDebug().a("Invalid data for SSSlideInfoAtom at offset 4: " + LittleEndian.getShort(r10, 4));
    L12:
        if (LittleEndian.getShort(r10, 6) != 0) goto L14;
        LOG.atDebug().a("Invalid data for SSSlideInfoAtom at offset 6: " + LittleEndian.getShort(r10, 6));
    L14:
        int r12 = LittleEndian.getInt(r7, r11);
        this._slideTime = r12;
        if (r12 >= 0) goto L17;
    L18:
        LOG.atDebug().a("Invalid data for SSSlideInfoAtom - invalid slideTime: " + this._slideTime);
    L19:
        int r13 = r11 + 4;
        this._soundIdRef = LittleEndian.getInt(r7, r13);
        int r14 = r13 + 4;
        this._effectDirection = LittleEndian.getUByte(r7, r14);
        int r15 = r14 + 1;
        this._effectType = LittleEndian.getUByte(r7, r15);
        int r16 = r15 + 1;
        this._effectTransitionFlags = LittleEndian.getShort(r7, r16);
        int r17 = r16 + 2;
        this._speed = LittleEndian.getUByte(r7, r17);
        int r18 = r17 + 1;
        this._unused = Arrays.copyOfRange(r7, r18, r18 + 3);
        return;
    L17:
        if (r12 <= 86399000) goto L19;
        goto L18
    }

    public short getEffectDirection() {
        return this._effectDirection;
    }

    public short getEffectTransitionFlags() {
        return this._effectTransitionFlags;
    }

    public short getEffectType() {
        return this._effectType;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("effectTransitionFlags", GenericRecordUtil.getBitsAsString(new $$Lambda$2z2wNgARFzWlwcNFt4DHpbt8yBo(this), EFFECT_MASKS, EFFECT_NAMES), "slideTime", new $$Lambda$jODbw5207ynRHBCnm1Fno_YptfA(this), "soundIdRef", new $$Lambda$8N2HKmqtFPzbVRIEixX1gz7AXmA(this), "effectDirection", new $$Lambda$NmUApEwlFUU8f_krYlx4tkSWDso(this), "effectType", new $$Lambda$mAhNJICBk_aDwovxhCDjJ0lNyM(this), "speed", new $$Lambda$eQjS6uKmzWUaqdpNNlJbb_dxbVQ(this));
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return _type;
    }

    public int getSlideTime() {
        return this._slideTime;
    }

    public int getSoundIdRef() {
        return this._soundIdRef;
    }

    public short getSpeed() {
        return this._speed;
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r4) {
        r4.write(this._header);
        writeLittleEndian(this._slideTime, r4);
        writeLittleEndian(this._soundIdRef, r4);
        byte[] r0 = new byte[1];
        LittleEndian.putUByte(r0, 0, this._effectDirection);
        r4.write(r0);
        LittleEndian.putUByte(r0, 0, this._effectType);
        r4.write(r0);
        writeLittleEndian(this._effectTransitionFlags, r4);
        LittleEndian.putUByte(r0, 0, this._speed);
        r4.write(r0);
        r4.write(this._unused);
    }
}
