package org.apache.poi.sl.draw.geom;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.apache.poi.sl.usermodel.PaintStyle;

/* JADX INFO: loaded from: classes7.dex */
public final class Path implements PathIf {
    private final List<PathCommand> commands;
    private boolean extrusionOk;
    private PaintStyle.PaintModifier fill;
    private long h;
    private boolean stroke;
    private long w;

    public Path() {
        this.commands = new ArrayList();
        this.fill = PaintStyle.PaintModifier.NORM;
        this.stroke = true;
        this.extrusionOk = false;
        this.w = -1;
        this.h = -1;
    }

    public void addCommand(PathCommand r3) {
        PathCommand r4 = (PathCommand) ZeusTransformUtils.wrapperContextForParams(r3, PathCommand.class, "com.obric.memorydata.plugin");
        this.commands.add(r4);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, Path.class) == true) goto L8;
        return false;
    L8:
        Path r8 = (Path) ZeusTransformUtils.preCheckCast(r7, Path.class, "com.obric.memorydata.plugin");
        if (Objects.equals(this.commands, r8.commands) == false) goto L22;
        if (Objects.equals(Long.valueOf(this.w), Long.valueOf(r8.w)) == false) goto L22;
        if (Objects.equals(Long.valueOf(this.h), Long.valueOf(r8.h)) == false) goto L22;
        if (this.fill != r8.fill) goto L22;
        if (Objects.equals(Boolean.valueOf(this.stroke), Boolean.valueOf(r8.stroke)) == false) goto L22;
        if (Objects.equals(Boolean.valueOf(this.extrusionOk), Boolean.valueOf(r8.extrusionOk)) == false) goto L22;
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.commands, Long.valueOf(this.w), Long.valueOf(this.h), Integer.valueOf(this.fill.ordinal()), Boolean.valueOf(this.stroke), Boolean.valueOf(this.extrusionOk)});
    }

    public void setExtrusionOk(boolean r1) {
        this.extrusionOk = r1;
    }

    public void setFill(PaintStyle.PaintModifier r1) {
        this.fill = r1;
    }

    public void setH(long r1) {
        this.h = r1;
    }

    public void setStroke(boolean r1) {
        this.stroke = r1;
    }

    public void setW(long r1) {
        this.w = r1;
    }
}
