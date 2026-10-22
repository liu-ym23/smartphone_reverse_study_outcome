package org.apache.xmlbeans.impl.values;

import java.util.function.BiConsumer;
import org.apache.xmlbeans.GDate;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.values.-$$Lambda$brdmH9Oo_8iKR13Vv4VnXh3mcOA, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class $$Lambda$brdmH9Oo_8iKR13Vv4VnXh3mcOA implements BiConsumer {
    public static final /* synthetic */ $$Lambda$brdmH9Oo_8iKR13Vv4VnXh3mcOA INSTANCE = null;

    static {
        INSTANCE = new $$Lambda$brdmH9Oo_8iKR13Vv4VnXh3mcOA();
    }

    private /* synthetic */ $$Lambda$brdmH9Oo_8iKR13Vv4VnXh3mcOA() {
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object r1, Object r2) {
        ((XmlObjectBase) r1).setGDateValue((GDate) r2);
    }
}
