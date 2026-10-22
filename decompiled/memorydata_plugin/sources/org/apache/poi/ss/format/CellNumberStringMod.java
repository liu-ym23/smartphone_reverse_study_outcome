package org.apache.poi.ss.format;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public class CellNumberStringMod implements Comparable<CellNumberStringMod> {
    private CellNumberFormatter.Special end;
    private boolean endInclusive;
    private final int op;
    private final CellNumberFormatter.Special special;
    private boolean startInclusive;
    private CharSequence toAdd;

    public CellNumberStringMod(CellNumberFormatter.Special r3, CharSequence r4, int r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        this.special = r3;
        this.toAdd = r6;
        this.op = r5;
    }

    public CellNumberStringMod(CellNumberFormatter.Special r1, boolean r2, CellNumberFormatter.Special r3, boolean r4) {
        this.special = r1;
        this.startInclusive = r2;
        this.end = r3;
        this.endInclusive = r4;
        this.op = 3;
        this.toAdd = "";
    }

    public CellNumberStringMod(CellNumberFormatter.Special r1, boolean r2, CellNumberFormatter.Special r3, boolean r4, char r5) {
        this(r1, r2, r3, r4);
        this.toAdd = r5 + "";
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(CellNumberStringMod r3) {
        return compareTo2((CellNumberStringMod) ZeusTransformUtils.preCheckCast(r3, CellNumberStringMod.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(CellNumberStringMod r3) {
        int r0 = this.special.pos - r3.special.pos;
        if (r0 == 0) goto L6;
        return r0;
    L6:
        return this.op - r3.op;
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, CellNumberStringMod.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (compareTo2((CellNumberStringMod) ZeusTransformUtils.preCheckCast(r3, CellNumberStringMod.class, "com.obric.memorydata.plugin")) != 0) goto L7;
        return true;
    }

    public CellNumberFormatter.Special getEnd() {
        return this.end;
    }

    public int getOp() {
        return this.op;
    }

    public CellNumberFormatter.Special getSpecial() {
        return this.special;
    }

    public CharSequence getToAdd() {
        return this.toAdd;
    }

    public int hashCode() {
        return this.special.hashCode() + this.op;
    }

    public boolean isEndInclusive() {
        return this.endInclusive;
    }

    public boolean isStartInclusive() {
        return this.startInclusive;
    }
}
