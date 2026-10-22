package org.apache.poi.sl.draw.geom;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Spliterator;

/* JADX INFO: loaded from: classes7.dex */
public final class CustomGeometry implements Iterable<PathIf> {
    final List<AdjustValueIf> adjusts;
    final List<ConnectionSiteIf> connections;
    final List<GuideIf> guides;
    final List<AdjustHandle> handles;
    final List<PathIf> paths;
    Path textBounds;

    public CustomGeometry() {
        this.adjusts = new ArrayList();
        this.guides = new ArrayList();
        this.paths = new ArrayList();
        this.handles = new ArrayList();
        this.connections = new ArrayList();
    }

    private static LineToCommand lineTo(String r1, String r2) {
        AdjustPoint r0 = new AdjustPoint();
        r0.setX(r1);
        r0.setY(r2);
        LineToCommand r3 = new LineToCommand();
        r3.setPt(r0);
        return r3;
    }

    private static MoveToCommand moveTo(String r1, String r2) {
        AdjustPoint r0 = new AdjustPoint();
        r0.setX(r1);
        r0.setY(r2);
        MoveToCommand r3 = new MoveToCommand();
        r3.setPt(r0);
        return r3;
    }

    public void addAdjustGuide(AdjustValueIf r3) {
        AdjustValueIf r4 = (AdjustValueIf) ZeusTransformUtils.wrapperContextForParams(r3, AdjustValueIf.class, "com.obric.memorydata.plugin");
        this.adjusts.add(r4);
    }

    public void addAdjustHandle(AdjustHandle r3) {
        AdjustHandle r4 = (AdjustHandle) ZeusTransformUtils.wrapperContextForParams(r3, AdjustHandle.class, "com.obric.memorydata.plugin");
        this.handles.add(r4);
    }

    public void addConnectionSite(ConnectionSiteIf r3) {
        ConnectionSiteIf r4 = (ConnectionSiteIf) ZeusTransformUtils.wrapperContextForParams(r3, ConnectionSiteIf.class, "com.obric.memorydata.plugin");
        this.connections.add(r4);
    }

    public void addGeomGuide(GuideIf r3) {
        GuideIf r4 = (GuideIf) ZeusTransformUtils.wrapperContextForParams(r3, GuideIf.class, "com.obric.memorydata.plugin");
        this.guides.add(r4);
    }

    public void addPath(PathIf r3) {
        PathIf r4 = (PathIf) ZeusTransformUtils.wrapperContextForParams(r3, PathIf.class, "com.obric.memorydata.plugin");
        this.paths.add(r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, CustomGeometry.class) == true) goto L8;
        return false;
    L8:
        CustomGeometry r6 = (CustomGeometry) ZeusTransformUtils.preCheckCast(r5, CustomGeometry.class, "com.obric.memorydata.plugin");
        if (Objects.equals(this.adjusts, r6.adjusts) == false) goto L22;
        if (Objects.equals(this.guides, r6.guides) == false) goto L22;
        if (Objects.equals(this.handles, r6.handles) == false) goto L22;
        if (Objects.equals(this.connections, r6.connections) == false) goto L22;
        if (Objects.equals(this.textBounds, r6.textBounds) == false) goto L22;
        if (Objects.equals(this.paths, r6.paths) == false) goto L22;
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.adjusts, this.guides, this.handles, this.connections, this.textBounds, this.paths});
    }

    @Override // java.lang.Iterable
    public Iterator<PathIf> iterator() {
        return this.paths.iterator();
    }

    public void setTextBounds(String r3, String r4, String r5, String r6) {
        Path r0 = new Path();
        this.textBounds = r0;
        r0.addCommand(moveTo(r3, r4));
        this.textBounds.addCommand(lineTo(r5, r4));
        this.textBounds.addCommand(lineTo(r5, r6));
        this.textBounds.addCommand(lineTo(r3, r6));
        this.textBounds.addCommand(new ClosePathCommand());
    }

    @Override // java.lang.Iterable
    public Spliterator<PathIf> spliterator() {
        return this.paths.spliterator();
    }
}
