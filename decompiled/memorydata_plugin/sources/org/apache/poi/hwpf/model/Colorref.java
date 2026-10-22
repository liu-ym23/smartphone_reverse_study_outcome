package org.apache.poi.hwpf.model;

import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public class Colorref {
    private int value;

    public Colorref() {
        this.value = -1;
    }

    public Colorref(int r1) {
        this.value = r1;
    }

    public Colorref(Colorref r1) {
        this.value = r1.value;
    }

    public Colorref(byte[] r1, int r2) {
        this.value = LittleEndian.getInt(r1, r2);
    }

    public static Colorref valueOfIco(int r1) {
        switch(r1) {
            case 1: goto L37;
            case 2: goto L35;
            case 3: goto L33;
            case 4: goto L31;
            case 5: goto L29;
            case 6: goto L27;
            case 7: goto L25;
            case 8: goto L23;
            case 9: goto L21;
            case 10: goto L19;
            case 11: goto L17;
            case 12: goto L15;
            case 13: goto L13;
            case 14: goto L11;
            case 15: goto L9;
            case 16: goto L7;
            default: goto L5;
        };
    L5:
        return new Colorref(0);
    L7:
        return new Colorref(12632256);
    L9:
        return new Colorref(11119017);
    L11:
        return new Colorref(52479);
    L13:
        return new Colorref(139);
    L15:
        return new Colorref(9109643);
    L17:
        return new Colorref(25600);
    L19:
        return new Colorref(9145088);
    L21:
        return new Colorref(9109504);
    L23:
        return new Colorref(ViewCompat.MEASURED_SIZE_MASK);
    L25:
        return new Colorref(65535);
    L27:
        return new Colorref(255);
    L29:
        return new Colorref(16711935);
    L31:
        return new Colorref(MotionEventCompat.ACTION_POINTER_INDEX_MASK);
    L33:
        return new Colorref(16776960);
    L35:
        return new Colorref(16711680);
    L37:
        return new Colorref(0);
    }

    public Colorref copy() {
        return new Colorref(this);
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
        Colorref r6 = (Colorref) ZeusTransformUtils.preCheckCast(r5, Colorref.class, "com.obric.memorydata.plugin");
        if (this.value == r6.value) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return this.value;
    }

    public boolean isEmpty() {
        if (this.value != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        if (isEmpty() == false) goto L7;
        return "[COLORREF] EMPTY";
    L7:
        return "[COLORREF] 0x" + Integer.toHexString(this.value);
    }
}
