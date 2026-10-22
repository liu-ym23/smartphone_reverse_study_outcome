package org.apache.xmlbeans.impl.values;

import java.util.function.BiConsumer;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.values.-$$Lambda$onRKkzO3s-G852oV8TQJWYD_uD4, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class $$Lambda$onRKkzO3sG852oV8TQJWYD_uD4 implements BiConsumer {
    public static final /* synthetic */ $$Lambda$onRKkzO3sG852oV8TQJWYD_uD4 INSTANCE = null;

    static {
        INSTANCE = new $$Lambda$onRKkzO3sG852oV8TQJWYD_uD4();
    }

    private /* synthetic */ $$Lambda$onRKkzO3sG852oV8TQJWYD_uD4() {
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object r1, Object r2) {
        ((XmlObjectBase) r1).setEnumValue((StringEnumAbstractBase) r2);
    }
}
