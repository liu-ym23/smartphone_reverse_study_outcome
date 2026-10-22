package org.apache.xmlbeans.impl.values;

import java.util.function.ToDoubleFunction;
import org.apache.xmlbeans.SimpleValue;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.values.-$$Lambda$bHXxkBhplptAM71rhkCVNLbHUHc, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class $$Lambda$bHXxkBhplptAM71rhkCVNLbHUHc implements ToDoubleFunction {
    public static final /* synthetic */ $$Lambda$bHXxkBhplptAM71rhkCVNLbHUHc INSTANCE = null;

    static {
        INSTANCE = new $$Lambda$bHXxkBhplptAM71rhkCVNLbHUHc();
    }

    private /* synthetic */ $$Lambda$bHXxkBhplptAM71rhkCVNLbHUHc() {
    }

    @Override // java.util.function.ToDoubleFunction
    public final double applyAsDouble(Object r1) {
        return ((SimpleValue) r1).getDoubleValue();
    }
}
