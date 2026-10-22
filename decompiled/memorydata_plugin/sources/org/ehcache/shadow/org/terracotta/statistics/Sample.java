package org.ehcache.shadow.org.terracotta.statistics;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public class Sample<T extends Serializable> implements Serializable {
    private static final long serialVersionUID = 1;
    private final T sample;
    private final long timestamp;

    public Sample(long r3, T r5) {
        this.sample = (T) ZeusTransformUtils.wrapperContextForParams(r5, Serializable.class, "com.obric.memorydata.plugin");
        this.timestamp = r3;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, Sample.class) == true) goto L8;
        return false;
    L8:
        Sample r10 = (Sample) ZeusTransformUtils.preCheckCast(r9, Sample.class, "com.obric.memorydata.plugin");
        if (getTimestamp() != r10.getTimestamp()) goto L14;
        if (Objects.equals(getSample(), r10.getSample()) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public T getSample() {
        return this.sample;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Long.valueOf(getTimestamp()), getSample()});
    }

    public String toString() {
        return getSample() + " @ " + getTimestamp();
    }
}
