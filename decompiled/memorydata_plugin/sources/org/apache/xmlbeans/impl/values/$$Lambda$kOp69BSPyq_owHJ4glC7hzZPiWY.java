package org.apache.xmlbeans.impl.values;

import java.util.function.BiConsumer;
import javax.xml.namespace.QName;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.values.-$$Lambda$kOp69BSPyq_owHJ4glC7hzZPiWY, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class $$Lambda$kOp69BSPyq_owHJ4glC7hzZPiWY implements BiConsumer {
    public static final /* synthetic */ $$Lambda$kOp69BSPyq_owHJ4glC7hzZPiWY INSTANCE = null;

    static {
        INSTANCE = new $$Lambda$kOp69BSPyq_owHJ4glC7hzZPiWY();
    }

    private /* synthetic */ $$Lambda$kOp69BSPyq_owHJ4glC7hzZPiWY() {
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object r1, Object r2) {
        ((XmlObjectBase) r1).setQNameValue((QName) r2);
    }
}
