package org.apache.xmlbeans.impl.values;

import java.util.function.Function;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.values.-$$Lambda$CzVcobku7lnlM3vSu3ZR1C8POGc, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class $$Lambda$CzVcobku7lnlM3vSu3ZR1C8POGc implements Function {
    public static final /* synthetic */ $$Lambda$CzVcobku7lnlM3vSu3ZR1C8POGc INSTANCE = null;

    static {
        INSTANCE = new $$Lambda$CzVcobku7lnlM3vSu3ZR1C8POGc();
    }

    private /* synthetic */ $$Lambda$CzVcobku7lnlM3vSu3ZR1C8POGc() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object r1) {
        return ((XmlObjectBase) r1).getEnumValue();
    }
}
