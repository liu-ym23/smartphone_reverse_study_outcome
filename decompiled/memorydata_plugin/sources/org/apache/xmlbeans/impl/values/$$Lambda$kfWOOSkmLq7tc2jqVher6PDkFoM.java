package org.apache.xmlbeans.impl.values;

import java.math.BigInteger;
import java.util.function.BiConsumer;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.values.-$$Lambda$kfWOOSkmLq7tc2jqVher6PDkFoM, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class $$Lambda$kfWOOSkmLq7tc2jqVher6PDkFoM implements BiConsumer {
    public static final /* synthetic */ $$Lambda$kfWOOSkmLq7tc2jqVher6PDkFoM INSTANCE = null;

    static {
        INSTANCE = new $$Lambda$kfWOOSkmLq7tc2jqVher6PDkFoM();
    }

    private /* synthetic */ $$Lambda$kfWOOSkmLq7tc2jqVher6PDkFoM() {
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object r1, Object r2) {
        ((XmlObjectBase) r1).setBigIntegerValue((BigInteger) r2);
    }
}
