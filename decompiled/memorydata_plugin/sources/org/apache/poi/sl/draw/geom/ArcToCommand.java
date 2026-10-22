package org.apache.poi.sl.draw.geom;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public class ArcToCommand implements ArcToCommandIf {
    private String hr;
    private String stAng;
    private String swAng;
    private String wr;

    public ArcToCommand() {
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ArcToCommand.class) == true) goto L8;
        return false;
    L8:
        ArcToCommand r6 = (ArcToCommand) ZeusTransformUtils.preCheckCast(r5, ArcToCommand.class, "com.obric.memorydata.plugin");
        if (Objects.equals(this.wr, r6.wr) == false) goto L18;
        if (Objects.equals(this.hr, r6.hr) == false) goto L18;
        if (Objects.equals(this.stAng, r6.stAng) == false) goto L18;
        if (Objects.equals(this.swAng, r6.swAng) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.wr, this.hr, this.stAng, this.swAng});
    }

    public void setHR(String r1) {
        this.hr = r1;
    }

    public void setStAng(String r1) {
        this.stAng = r1;
    }

    public void setSwAng(String r1) {
        this.swAng = r1;
    }

    public void setWR(String r1) {
        this.wr = r1;
    }
}
