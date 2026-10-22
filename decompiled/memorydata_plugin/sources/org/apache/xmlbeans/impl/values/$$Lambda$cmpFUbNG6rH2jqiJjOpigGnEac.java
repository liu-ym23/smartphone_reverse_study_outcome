package org.apache.xmlbeans.impl.values;

import java.util.function.ToLongFunction;
import org.apache.xmlbeans.SimpleValue;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.values.-$$Lambda$cmpFUbNG6rH2jq-iJjOpigGnEac, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class $$Lambda$cmpFUbNG6rH2jqiJjOpigGnEac implements ToLongFunction {
    public static final /* synthetic */ $$Lambda$cmpFUbNG6rH2jqiJjOpigGnEac INSTANCE = null;

    static {
        INSTANCE = new $$Lambda$cmpFUbNG6rH2jqiJjOpigGnEac();
    }

    private /* synthetic */ $$Lambda$cmpFUbNG6rH2jqiJjOpigGnEac() {
    }

    @Override // java.util.function.ToLongFunction
    public final long applyAsLong(Object r1) {
        return ((SimpleValue) r1).getLongValue();
    }
}
