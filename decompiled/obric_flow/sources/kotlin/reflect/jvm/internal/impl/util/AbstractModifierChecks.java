package kotlin.reflect.jvm.internal.impl.util;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractModifierChecks {
    public AbstractModifierChecks() {
    }

    public final CheckResult check(FunctionDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "functionDescriptor");
        Iterator<Checks> r10 = getChecks$descriptors().iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        Checks r11 = r10.next();
        if (r11.isApplicable(r5) == false) goto L4;
        return r11.checkAll(r5);
    L10:
        return CheckResult.IllegalFunctionName.INSTANCE;
    }

    public abstract List<Checks> getChecks$descriptors();
}
