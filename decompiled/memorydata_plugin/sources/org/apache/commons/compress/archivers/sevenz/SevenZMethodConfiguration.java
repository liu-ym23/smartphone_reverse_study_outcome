package org.apache.commons.compress.archivers.sevenz;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class SevenZMethodConfiguration {
    private final SevenZMethod method;
    private final Object options;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L17;
        SevenZMethodConfiguration r6 = (SevenZMethodConfiguration) ZeusTransformUtils.preCheckCast(r5, SevenZMethodConfiguration.class, "com.obric.memorydata.plugin");
        if (Objects.equals(this.method, r6.method) == false) goto L16;
        if (Objects.equals(this.options, r6.options) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public SevenZMethod getMethod() {
        return this.method;
    }

    public Object getOptions() {
        return this.options;
    }

    public int hashCode() {
        SevenZMethod r0 = this.method;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }
}
