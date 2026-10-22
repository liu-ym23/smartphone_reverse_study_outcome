package org.apache.xmlbeans.impl.values;

import java.util.function.ToIntFunction;
import org.apache.xmlbeans.SimpleValue;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.values.-$$Lambda$h8stMdw2fDKsVkCYKzrouvz2Qg0, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class $$Lambda$h8stMdw2fDKsVkCYKzrouvz2Qg0 implements ToIntFunction {
    public static final /* synthetic */ $$Lambda$h8stMdw2fDKsVkCYKzrouvz2Qg0 INSTANCE = null;

    static {
        INSTANCE = new $$Lambda$h8stMdw2fDKsVkCYKzrouvz2Qg0();
    }

    private /* synthetic */ $$Lambda$h8stMdw2fDKsVkCYKzrouvz2Qg0() {
    }

    @Override // java.util.function.ToIntFunction
    public final int applyAsInt(Object r1) {
        return ((SimpleValue) r1).getIntValue();
    }
}
