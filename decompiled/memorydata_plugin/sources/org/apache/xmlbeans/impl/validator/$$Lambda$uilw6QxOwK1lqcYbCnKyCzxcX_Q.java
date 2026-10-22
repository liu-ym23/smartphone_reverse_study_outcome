package org.apache.xmlbeans.impl.validator;

import java.util.function.Function;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.impl.common.QNameHelper;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.validator.-$$Lambda$uilw6QxOwK1lqcYbCnKyCzxcX_Q, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class $$Lambda$uilw6QxOwK1lqcYbCnKyCzxcX_Q implements Function {
    public static final /* synthetic */ $$Lambda$uilw6QxOwK1lqcYbCnKyCzxcX_Q INSTANCE = null;

    static {
        INSTANCE = new $$Lambda$uilw6QxOwK1lqcYbCnKyCzxcX_Q();
    }

    private /* synthetic */ $$Lambda$uilw6QxOwK1lqcYbCnKyCzxcX_Q() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object r1) {
        return QNameHelper.pretty((QName) r1);
    }
}
