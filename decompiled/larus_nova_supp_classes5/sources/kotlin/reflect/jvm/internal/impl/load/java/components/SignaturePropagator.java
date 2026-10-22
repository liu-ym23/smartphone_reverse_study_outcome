package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface SignaturePropagator {
    public static final SignaturePropagator DO_NOTHING = null;

    void reportSignatureErrors(CallableMemberDescriptor r1, List<String> r2);

    PropagatedSignature resolvePropagatedSignature(JavaMethod r1, ClassDescriptor r2, KotlinType r3, KotlinType r4, List<ValueParameterDescriptor> r5, List<TypeParameterDescriptor> r6);

    static {
        DO_NOTHING = new AnonymousClass1();
    }
}
