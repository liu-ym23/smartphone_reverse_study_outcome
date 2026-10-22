package org.apache.xmlbeans.impl.values;

import java.util.function.BiConsumer;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.values.-$$Lambda$WPTGynAKDNXB-ojHkb98Ln0jopE, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class $$Lambda$WPTGynAKDNXBojHkb98Ln0jopE implements BiConsumer {
    public static final /* synthetic */ $$Lambda$WPTGynAKDNXBojHkb98Ln0jopE INSTANCE = null;

    static {
        INSTANCE = new $$Lambda$WPTGynAKDNXBojHkb98Ln0jopE();
    }

    private /* synthetic */ $$Lambda$WPTGynAKDNXBojHkb98Ln0jopE() {
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object r1, Object r2) {
        ((XmlObjectBase) r1).setByteArrayValue((byte[]) r2);
    }
}
