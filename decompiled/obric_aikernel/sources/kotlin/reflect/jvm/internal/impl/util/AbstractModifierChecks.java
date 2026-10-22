package kotlin.reflect.jvm.internal.impl.util;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractModifierChecks {
    public AbstractModifierChecks() {
    }

    public final CheckResult check(FunctionDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "functionDescriptor");
        Iterator<Checks> r11 = getChecks$descriptors().iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        Checks r12 = r11.next();
        if (r12.isApplicable(r10) == false) goto L4;
        return r12.checkAll(r10);
    L10:
        return CheckResult.IllegalFunctionName.INSTANCE;
    }

    public abstract List<Checks> getChecks$descriptors();
}
