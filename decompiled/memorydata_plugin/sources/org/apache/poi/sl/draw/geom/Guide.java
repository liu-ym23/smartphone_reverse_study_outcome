package org.apache.poi.sl.draw.geom;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public class Guide implements GuideIf {
    private String fmla;
    private String name;

    public Guide() {
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L17;
        Guide r6 = (Guide) ZeusTransformUtils.preCheckCast(r5, Guide.class, "com.obric.memorydata.plugin");
        if (Objects.equals(this.name, r6.name) == false) goto L16;
        if (Objects.equals(this.fmla, r6.fmla) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.name, this.fmla});
    }

    public void setFmla(String r1) {
        this.fmla = r1;
    }

    public void setName(String r1) {
        this.name = r1;
    }
}
