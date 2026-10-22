package org.apache.xmlbeans.impl.values;

import java.util.function.BiConsumer;
import org.apache.xmlbeans.GDuration;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.values.-$$Lambda$kMUH74KQcswES-RvHd0RfN5uZMQ, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class $$Lambda$kMUH74KQcswESRvHd0RfN5uZMQ implements BiConsumer {
    public static final /* synthetic */ $$Lambda$kMUH74KQcswESRvHd0RfN5uZMQ INSTANCE = null;

    static {
        INSTANCE = new $$Lambda$kMUH74KQcswESRvHd0RfN5uZMQ();
    }

    private /* synthetic */ $$Lambda$kMUH74KQcswESRvHd0RfN5uZMQ() {
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object r1, Object r2) {
        ((XmlObjectBase) r1).setGDurationValue((GDuration) r2);
    }
}
