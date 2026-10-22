package org.apache.poi.sl.draw.geom;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public final class LineToCommand implements LineToCommandIf {
    private final AdjustPoint pt;

    public LineToCommand() {
        this.pt = new AdjustPoint();
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, LineToCommand.class) == true) goto L10;
        return false;
    L10:
        LineToCommand r4 = (LineToCommand) ZeusTransformUtils.preCheckCast(r3, LineToCommand.class, "com.obric.memorydata.plugin");
        return Objects.equals(this.pt, r4.pt);
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.pt});
    }

    public void setPt(AdjustPointIf r3) {
        AdjustPointIf r4 = (AdjustPointIf) ZeusTransformUtils.wrapperContextForParams(r3, AdjustPointIf.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        this.pt.setX(r4.getX());
        this.pt.setY(r4.getY());
        return;
    }
}
