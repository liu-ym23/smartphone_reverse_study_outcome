package org.apache.poi.hwpf.usermodel;

import androidx.core.view.MotionEventCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class BorderCode {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final BitField _brcType = null;
    private static final BitField _dptLineWidth = null;
    private static final BitField _dptSpace = null;
    private static final BitField _fFrame = null;
    private static final BitField _fShadow = null;
    private static final BitField _ico = null;
    private short _info;
    private short _info2;

    static {
        _dptLineWidth = BitFieldFactory.getInstance(255);
        _brcType = BitFieldFactory.getInstance(MotionEventCompat.ACTION_POINTER_INDEX_MASK);
        _ico = BitFieldFactory.getInstance(255);
        _dptSpace = BitFieldFactory.getInstance(7936);
        _fShadow = BitFieldFactory.getInstance(8192);
        _fFrame = BitFieldFactory.getInstance(16384);
    }

    public BorderCode() {
    }

    public BorderCode(BorderCode r2) {
        this._info = r2._info;
        this._info2 = r2._info2;
    }

    public BorderCode(byte[] r2, int r3) {
        this._info = LittleEndian.getShort(r2, r3);
        this._info2 = LittleEndian.getShort(r2, r3 + 2);
    }

    public BorderCode copy() {
        return new BorderCode(this);
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, BorderCode.class) == true) goto L5;
        return false;
    L5:
        BorderCode r5 = (BorderCode) ZeusTransformUtils.preCheckCast(r4, BorderCode.class, "com.obric.memorydata.plugin");
        if (this._info == r5._info) goto L8;
        return false;
    L8:
        if (this._info2 != r5._info2) goto L12;
        return true;
    L12:
        return false;
    }

    public int getBorderType() {
        return _brcType.getShortValue(this._info);
    }

    public short getColor() {
        return _ico.getShortValue(this._info2);
    }

    public int getLineWidth() {
        return _dptLineWidth.getShortValue(this._info);
    }

    public int getSpace() {
        return _dptSpace.getShortValue(this._info2);
    }

    public int hashCode() {
        return 42;
    }

    public boolean isEmpty() {
        short r0 = this._info;
        if (r0 != 0) goto L7;
        if (this._info2 != 0) goto L7;
    L8:
        return true;
    L7:
        if (r0 == (-1)) goto L8;
        return false;
    }

    public boolean isFrame() {
        if (_fFrame.getValue(this._info2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isShadow() {
        if (_fShadow.getValue(this._info2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        if (isEmpty() == false) goto L6;
        return "[BRC] EMPTY";
    L6:
        return "[BRC]\n        .dptLineWidth         =  (" + getLineWidth() + " )\n        .brcType              =  (" + getBorderType() + " )\n        .ico                  =  (" + getColor() + " )\n        .dptSpace             =  (" + getSpace() + " )\n        .fShadow              =  (" + isShadow() + " )\n        .fFrame               =  (" + isFrame() + " )\n";
    }
}
