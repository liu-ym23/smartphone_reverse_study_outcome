package org.apache.poi.sl.draw.geom;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public final class ConnectionSite implements ConnectionSiteIf {
    private String ang;
    private final AdjustPoint pos;

    public ConnectionSite() {
        this.pos = new AdjustPoint();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ConnectionSite.class) == true) goto L8;
        return false;
    L8:
        ConnectionSite r6 = (ConnectionSite) ZeusTransformUtils.preCheckCast(r5, ConnectionSite.class, "com.obric.memorydata.plugin");
        if (Objects.equals(this.pos, r6.pos) == false) goto L14;
        if (Objects.equals(this.ang, r6.ang) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.pos, this.ang});
    }

    public void setAng(String r1) {
        this.ang = r1;
    }

    public void setPos(AdjustPointIf r3) {
        AdjustPointIf r4 = (AdjustPointIf) ZeusTransformUtils.wrapperContextForParams(r3, AdjustPointIf.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        this.pos.setX(r4.getX());
        this.pos.setY(r4.getY());
        return;
    }
}
