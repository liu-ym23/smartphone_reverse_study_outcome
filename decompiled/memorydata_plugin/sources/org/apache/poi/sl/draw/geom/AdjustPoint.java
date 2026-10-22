package org.apache.poi.sl.draw.geom;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public class AdjustPoint implements AdjustPointIf {
    private String x;
    private String y;

    public AdjustPoint() {
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AdjustPoint.class) == true) goto L8;
        return false;
    L8:
        AdjustPoint r6 = (AdjustPoint) ZeusTransformUtils.preCheckCast(r5, AdjustPoint.class, "com.obric.memorydata.plugin");
        if (Objects.equals(this.x, r6.x) == false) goto L14;
        if (Objects.equals(this.y, r6.y) == false) goto L14;
        return true;
    L14:
        return false;
    }

    @Override // org.apache.poi.sl.draw.geom.AdjustPointIf
    public String getX() {
        return this.x;
    }

    @Override // org.apache.poi.sl.draw.geom.AdjustPointIf
    public String getY() {
        return this.y;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.x, this.y});
    }

    public void setX(String r1) {
        this.x = r1;
    }

    public void setY(String r1) {
        this.y = r1;
    }
}
