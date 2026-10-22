package org.bouncycastle.math.ec;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public class FixedPointPreCompInfo implements PreCompInfo {
    protected ECLookupTable lookupTable;
    protected ECPoint offset;
    protected int width;

    public FixedPointPreCompInfo() {
        this.offset = null;
        this.lookupTable = null;
        this.width = -1;
    }

    public ECLookupTable getLookupTable() {
        return this.lookupTable;
    }

    public ECPoint getOffset() {
        return this.offset;
    }

    public int getWidth() {
        return this.width;
    }

    public void setLookupTable(ECLookupTable r3) {
        this.lookupTable = (ECLookupTable) ZeusTransformUtils.wrapperContextForParams(r3, ECLookupTable.class, "com.obric.memorydata.plugin");
    }

    public void setOffset(ECPoint r1) {
        this.offset = r1;
    }

    public void setWidth(int r1) {
        this.width = r1;
    }
}
