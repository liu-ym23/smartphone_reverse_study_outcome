package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;

/* JADX INFO: loaded from: classes3.dex */
public final class RuntimeErrorReporter implements ErrorReporter {
    public static final RuntimeErrorReporter INSTANCE = null;

    static {
        INSTANCE = new RuntimeErrorReporter();
    }

    private RuntimeErrorReporter() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter
    public void reportCannotInferVisibility(CallableMemberDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "descriptor");
        throw new IllegalStateException("Cannot infer visibility for " + r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter
    public void reportIncompleteHierarchy(ClassDescriptor r10, List<String> r11) {
        Intrinsics.checkNotNullParameter(r10, "descriptor");
        Intrinsics.checkNotNullParameter(r11, "unresolvedSuperClasses");
        throw new IllegalStateException("Incomplete hierarchy for class " + r10.getName() + ", unresolved classes " + r11);
    }
}
