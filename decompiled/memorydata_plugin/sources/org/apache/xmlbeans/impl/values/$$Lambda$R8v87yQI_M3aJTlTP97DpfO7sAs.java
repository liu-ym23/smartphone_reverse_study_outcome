package org.apache.xmlbeans.impl.values;

import java.util.List;
import java.util.function.BiConsumer;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.values.-$$Lambda$R8v87yQI_M3aJTlTP97DpfO7sAs, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class $$Lambda$R8v87yQI_M3aJTlTP97DpfO7sAs implements BiConsumer {
    public static final /* synthetic */ $$Lambda$R8v87yQI_M3aJTlTP97DpfO7sAs INSTANCE = null;

    static {
        INSTANCE = new $$Lambda$R8v87yQI_M3aJTlTP97DpfO7sAs();
    }

    private /* synthetic */ $$Lambda$R8v87yQI_M3aJTlTP97DpfO7sAs() {
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object r1, Object r2) {
        ((XmlObjectBase) r1).setListValue((List) r2);
    }
}
