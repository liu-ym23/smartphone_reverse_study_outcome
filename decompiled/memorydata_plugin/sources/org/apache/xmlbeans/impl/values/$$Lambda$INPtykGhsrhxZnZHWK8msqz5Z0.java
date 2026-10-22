package org.apache.xmlbeans.impl.values;

import java.util.Date;
import java.util.function.BiConsumer;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.values.-$$Lambda$INPtykGhsrhxZnZHWK8-msqz5Z0, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class $$Lambda$INPtykGhsrhxZnZHWK8msqz5Z0 implements BiConsumer {
    public static final /* synthetic */ $$Lambda$INPtykGhsrhxZnZHWK8msqz5Z0 INSTANCE = null;

    static {
        INSTANCE = new $$Lambda$INPtykGhsrhxZnZHWK8msqz5Z0();
    }

    private /* synthetic */ $$Lambda$INPtykGhsrhxZnZHWK8msqz5Z0() {
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object r1, Object r2) {
        ((XmlObjectBase) r1).setDateValue((Date) r2);
    }
}
