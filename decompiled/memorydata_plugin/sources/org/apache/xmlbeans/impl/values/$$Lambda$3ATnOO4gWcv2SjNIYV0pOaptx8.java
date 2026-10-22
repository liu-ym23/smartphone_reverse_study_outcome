package org.apache.xmlbeans.impl.values;

import java.util.Calendar;
import java.util.function.BiConsumer;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.values.-$$Lambda$3ATnOO4gWcv2-SjNIYV0pOaptx8, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class $$Lambda$3ATnOO4gWcv2SjNIYV0pOaptx8 implements BiConsumer {
    public static final /* synthetic */ $$Lambda$3ATnOO4gWcv2SjNIYV0pOaptx8 INSTANCE = null;

    static {
        INSTANCE = new $$Lambda$3ATnOO4gWcv2SjNIYV0pOaptx8();
    }

    private /* synthetic */ $$Lambda$3ATnOO4gWcv2SjNIYV0pOaptx8() {
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object r1, Object r2) {
        ((XmlObjectBase) r1).setCalendarValue((Calendar) r2);
    }
}
