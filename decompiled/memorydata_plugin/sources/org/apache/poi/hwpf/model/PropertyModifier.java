package org.apache.poi.hwpf.model;

import androidx.core.view.MotionEventCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import org.apache.poi.util.BitField;

/* JADX INFO: loaded from: classes7.dex */
public final class PropertyModifier {
    private static final BitField _fComplex = null;
    private static final BitField _figrpprl = null;
    private static final BitField _fisprm = null;
    private static final BitField _fval = null;
    private short value;

    static {
        _fComplex = new BitField(1);
        _figrpprl = new BitField(65534);
        _fisprm = new BitField(254);
        _fval = new BitField(MotionEventCompat.ACTION_POINTER_INDEX_MASK);
    }

    public PropertyModifier(short r1) {
        this.value = r1;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (getClass() == r5.getClass()) goto L11;
        return false;
    L11:
        PropertyModifier r6 = (PropertyModifier) ZeusTransformUtils.preCheckCast(r5, PropertyModifier.class, "com.obric.memorydata.plugin");
        if (this.value == r6.value) goto L14;
        return false;
    L14:
        return true;
    }

    public short getIgrpprl() {
        if (isComplex() == false) goto L7;
        return _figrpprl.getShortValue(this.value);
    L7:
        throw new IllegalStateException("Not complex");
    }

    public short getIsprm() {
        if (isComplex() == true) goto L7;
        return _fisprm.getShortValue(this.value);
    L7:
        throw new IllegalStateException("Not simple");
    }

    public short getVal() {
        if (isComplex() == true) goto L7;
        return _fval.getShortValue(this.value);
    L7:
        throw new IllegalStateException("Not simple");
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Short.valueOf(this.value)});
    }

    public boolean isComplex() {
        return _fComplex.isSet(this.value);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("[PRM] (complex: ");
        r0.append(isComplex());
        r0.append("; ");
        if (isComplex() == false) goto L5;
        r0.append("igrpprl: ");
        short r3 = getIgrpprl();
    L6:
        r0.append(r3);
        r0.append("; ");
        r0.append(")");
        return r0.toString();
    L5:
        r0.append("isprm: ");
        r0.append(getIsprm());
        r0.append("; ");
        r0.append("val: ");
        r3 = getVal();
        goto L6
    }
}
