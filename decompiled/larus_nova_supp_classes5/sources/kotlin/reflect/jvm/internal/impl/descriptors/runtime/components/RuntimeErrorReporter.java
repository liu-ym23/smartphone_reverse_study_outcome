package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class RuntimeErrorReporter implements ErrorReporter {
    public static final RuntimeErrorReporter INSTANCE = null;

    static {
        INSTANCE = new RuntimeErrorReporter();
    }

    private RuntimeErrorReporter() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter
    public void reportCannotInferVisibility(CallableMemberDescriptor r4) {
        Intrinsics.checkNotNullParameter(r4, "descriptor");
        throw new IllegalStateException("Cannot infer visibility for " + r4);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter
    public void reportIncompleteHierarchy(ClassDescriptor r4, List<String> r5) {
        Intrinsics.checkNotNullParameter(r4, "descriptor");
        Intrinsics.checkNotNullParameter(r5, "unresolvedSuperClasses");
        throw new IllegalStateException("Incomplete hierarchy for class " + r4.getName() + ", unresolved classes " + r5);
    }
}
