package org.apache.poi.sl.draw.geom;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public final class PolarAdjustHandle implements AdjustHandle {
    private String gdRefAng;
    private String gdRefR;
    private String maxAng;
    private String maxR;
    private String minAng;
    private String minR;
    private AdjustPoint pos;

    public PolarAdjustHandle() {
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, PolarAdjustHandle.class) == true) goto L8;
        return false;
    L8:
        PolarAdjustHandle r6 = (PolarAdjustHandle) ZeusTransformUtils.preCheckCast(r5, PolarAdjustHandle.class, "com.obric.memorydata.plugin");
        if (Objects.equals(this.pos, r6.pos) == false) goto L24;
        if (Objects.equals(this.gdRefR, r6.gdRefR) == false) goto L24;
        if (Objects.equals(this.minR, r6.minR) == false) goto L24;
        if (Objects.equals(this.maxR, r6.maxR) == false) goto L24;
        if (Objects.equals(this.gdRefAng, r6.gdRefAng) == false) goto L24;
        if (Objects.equals(this.minAng, r6.minAng) == false) goto L24;
        if (Objects.equals(this.maxAng, r6.maxAng) == false) goto L24;
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.pos, this.gdRefR, this.minR, this.maxR, this.gdRefAng, this.minAng, this.maxAng});
    }

    public void setGdRefAng(String r1) {
        this.gdRefAng = r1;
    }

    public void setGdRefR(String r1) {
        this.gdRefR = r1;
    }

    public void setMaxAng(String r1) {
        this.maxAng = r1;
    }

    public void setMaxR(String r1) {
        this.maxR = r1;
    }

    public void setMinAng(String r1) {
        this.minAng = r1;
    }

    public void setMinR(String r1) {
        this.minR = r1;
    }

    public void setPos(AdjustPoint r1) {
        this.pos = r1;
    }
}
