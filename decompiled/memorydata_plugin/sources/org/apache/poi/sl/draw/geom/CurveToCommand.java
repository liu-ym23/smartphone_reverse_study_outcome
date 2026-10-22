package org.apache.poi.sl.draw.geom;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public final class CurveToCommand implements CurveToCommandIf {
    private final AdjustPoint pt1;
    private final AdjustPoint pt2;
    private final AdjustPoint pt3;

    public CurveToCommand() {
        this.pt1 = new AdjustPoint();
        this.pt2 = new AdjustPoint();
        this.pt3 = new AdjustPoint();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, CurveToCommand.class) == true) goto L8;
        return false;
    L8:
        CurveToCommand r6 = (CurveToCommand) ZeusTransformUtils.preCheckCast(r5, CurveToCommand.class, "com.obric.memorydata.plugin");
        if (Objects.equals(this.pt1, r6.pt1) == false) goto L16;
        if (Objects.equals(this.pt2, r6.pt2) == false) goto L16;
        if (Objects.equals(this.pt3, r6.pt3) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.pt1, this.pt2, this.pt3});
    }

    public void setPt1(AdjustPointIf r3) {
        AdjustPointIf r4 = (AdjustPointIf) ZeusTransformUtils.wrapperContextForParams(r3, AdjustPointIf.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        this.pt1.setX(r4.getX());
        this.pt1.setY(r4.getY());
        return;
    }

    public void setPt2(AdjustPointIf r3) {
        AdjustPointIf r4 = (AdjustPointIf) ZeusTransformUtils.wrapperContextForParams(r3, AdjustPointIf.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        this.pt2.setX(r4.getX());
        this.pt2.setY(r4.getY());
        return;
    }

    public void setPt3(AdjustPointIf r3) {
        AdjustPointIf r4 = (AdjustPointIf) ZeusTransformUtils.wrapperContextForParams(r3, AdjustPointIf.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        this.pt3.setX(r4.getX());
        this.pt3.setY(r4.getY());
        return;
    }
}
