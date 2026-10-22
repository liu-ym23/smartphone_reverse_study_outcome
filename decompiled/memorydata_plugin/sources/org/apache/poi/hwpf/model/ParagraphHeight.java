package org.apache.poi.hwpf.model;

import androidx.core.view.MotionEventCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class ParagraphHeight {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final BitField clMac = null;
    private static final BitField fDiffLines = null;
    private static final BitField fSpare = null;
    private static final BitField fUnk = null;
    private int dxaCol;
    private int dymLineOrHeight;
    private short infoField;
    private short reserved;

    static {
        fSpare = BitFieldFactory.getInstance(1);
        fUnk = BitFieldFactory.getInstance(2);
        fDiffLines = BitFieldFactory.getInstance(4);
        clMac = BitFieldFactory.getInstance(MotionEventCompat.ACTION_POINTER_INDEX_MASK);
    }

    public ParagraphHeight() {
    }

    public ParagraphHeight(byte[] r2, int r3) {
        this.infoField = LittleEndian.getShort(r2, r3);
        int r4 = r3 + 2;
        this.reserved = LittleEndian.getShort(r2, r4);
        int r5 = r4 + 2;
        this.dxaCol = LittleEndian.getInt(r2, r5);
        this.dymLineOrHeight = LittleEndian.getInt(r2, r5 + 4);
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, ParagraphHeight.class) == true) goto L5;
        return false;
    L5:
        ParagraphHeight r5 = (ParagraphHeight) ZeusTransformUtils.preCheckCast(r4, ParagraphHeight.class, "com.obric.memorydata.plugin");
        if (this.infoField == r5.infoField) goto L8;
        return false;
    L8:
        if (this.reserved == r5.reserved) goto L10;
        return false;
    L10:
        if (this.dxaCol == r5.dxaCol) goto L12;
        return false;
    L12:
        if (this.dymLineOrHeight != r5.dymLineOrHeight) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        return 42;
    }
}
