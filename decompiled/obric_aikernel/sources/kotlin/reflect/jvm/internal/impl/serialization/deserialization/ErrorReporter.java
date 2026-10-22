package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public interface ErrorReporter {
    public static final ErrorReporter DO_NOTHING = null;

    static {
        DO_NOTHING = new AnonymousClass1();
    }

    void reportCannotInferVisibility(CallableMemberDescriptor r10);

    void reportIncompleteHierarchy(ClassDescriptor r10, List<String> r11);
}
