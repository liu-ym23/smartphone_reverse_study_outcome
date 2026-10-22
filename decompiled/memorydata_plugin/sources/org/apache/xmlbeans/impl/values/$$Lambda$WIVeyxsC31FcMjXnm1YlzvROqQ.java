package org.apache.xmlbeans.impl.values;

import java.util.function.BiConsumer;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.values.-$$Lambda$WIVeyxsC31FcM-jXnm1YlzvROqQ, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class $$Lambda$WIVeyxsC31FcMjXnm1YlzvROqQ implements BiConsumer {
    public static final /* synthetic */ $$Lambda$WIVeyxsC31FcMjXnm1YlzvROqQ INSTANCE = null;

    static {
        INSTANCE = new $$Lambda$WIVeyxsC31FcMjXnm1YlzvROqQ();
    }

    private /* synthetic */ $$Lambda$WIVeyxsC31FcMjXnm1YlzvROqQ() {
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object r1, Object r2) {
        ((XmlObjectBase) r1).setObjectValue(r2);
    }
}
