package org.apache.poi.sl.draw.geom;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public class ClosePathCommand implements ClosePathCommandIf {
    public ClosePathCommand() {
    }

    public boolean equals(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, ClosePathCommand.class);
    }

    public int hashCode() {
        return 790622;
    }
}
