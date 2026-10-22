package org.apache.xmlbeans.impl.values;

import java.util.function.BiConsumer;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.values.-$$Lambda$msamclPIidmw3aArtuAXXQfxZnE, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class $$Lambda$msamclPIidmw3aArtuAXXQfxZnE implements BiConsumer {
    public static final /* synthetic */ $$Lambda$msamclPIidmw3aArtuAXXQfxZnE INSTANCE = null;

    static {
        INSTANCE = new $$Lambda$msamclPIidmw3aArtuAXXQfxZnE();
    }

    private /* synthetic */ $$Lambda$msamclPIidmw3aArtuAXXQfxZnE() {
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object r1, Object r2) {
        ((XmlObjectBase) r1).setStringValue((String) r2);
    }
}
