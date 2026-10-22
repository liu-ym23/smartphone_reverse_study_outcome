package org.threeten.bp.jdk8;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalUnit;

/* JADX INFO: loaded from: classes8.dex */
public abstract class DefaultInterfaceTemporal extends DefaultInterfaceTemporalAccessor implements Temporal {
    public DefaultInterfaceTemporal() {
    }

    public Temporal minus(long r3, TemporalUnit r5) {
        TemporalUnit r6 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.memorydata.plugin");
        if (r3 != Long.MIN_VALUE) goto L6;
        return plus(Long.MAX_VALUE, r6).plus(1, r6);
    L6:
        return plus(-r3, r6);
    }

    public Temporal minus(TemporalAmount r3) {
        return ((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.memorydata.plugin")).subtractFrom(this);
    }

    public Temporal plus(TemporalAmount r3) {
        return ((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.memorydata.plugin")).addTo(this);
    }

    public Temporal with(TemporalAdjuster r3) {
        return ((TemporalAdjuster) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAdjuster.class, "com.obric.memorydata.plugin")).adjustInto(this);
    }
}
