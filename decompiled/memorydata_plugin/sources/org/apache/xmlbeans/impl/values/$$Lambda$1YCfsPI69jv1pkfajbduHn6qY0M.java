package org.apache.xmlbeans.impl.values;

import java.math.BigDecimal;
import java.util.function.BiConsumer;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.values.-$$Lambda$1YCfsPI69jv1pkfajbduHn6qY0M, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class $$Lambda$1YCfsPI69jv1pkfajbduHn6qY0M implements BiConsumer {
    public static final /* synthetic */ $$Lambda$1YCfsPI69jv1pkfajbduHn6qY0M INSTANCE = null;

    static {
        INSTANCE = new $$Lambda$1YCfsPI69jv1pkfajbduHn6qY0M();
    }

    private /* synthetic */ $$Lambda$1YCfsPI69jv1pkfajbduHn6qY0M() {
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object r1, Object r2) {
        ((XmlObjectBase) r1).setBigDecimalValue((BigDecimal) r2);
    }
}
