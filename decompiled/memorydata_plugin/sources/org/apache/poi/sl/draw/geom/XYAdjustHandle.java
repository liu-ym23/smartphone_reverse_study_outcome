package org.apache.poi.sl.draw.geom;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public final class XYAdjustHandle implements AdjustHandle {
    private String gdRefX;
    private String gdRefY;
    private String maxX;
    private String maxY;
    private String minX;
    private String minY;
    private AdjustPoint pos;

    public XYAdjustHandle() {
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, XYAdjustHandle.class) == true) goto L8;
        return false;
    L8:
        XYAdjustHandle r6 = (XYAdjustHandle) ZeusTransformUtils.preCheckCast(r5, XYAdjustHandle.class, "com.obric.memorydata.plugin");
        if (Objects.equals(this.pos, r6.pos) == false) goto L24;
        if (Objects.equals(this.gdRefX, r6.gdRefX) == false) goto L24;
        if (Objects.equals(this.minX, r6.minX) == false) goto L24;
        if (Objects.equals(this.maxX, r6.maxX) == false) goto L24;
        if (Objects.equals(this.gdRefY, r6.gdRefY) == false) goto L24;
        if (Objects.equals(this.minY, r6.minY) == false) goto L24;
        if (Objects.equals(this.maxY, r6.maxY) == false) goto L24;
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.pos, this.gdRefX, this.minX, this.maxX, this.gdRefY, this.minY, this.maxY});
    }

    public void setGdRefX(String r1) {
        this.gdRefX = r1;
    }

    public void setGdRefY(String r1) {
        this.gdRefY = r1;
    }

    public void setMaxX(String r1) {
        this.maxX = r1;
    }

    public void setMaxY(String r1) {
        this.maxY = r1;
    }

    public void setMinX(String r1) {
        this.minX = r1;
    }

    public void setMinY(String r1) {
        this.minY = r1;
    }

    public void setPos(AdjustPoint r1) {
        this.pos = r1;
    }
}
