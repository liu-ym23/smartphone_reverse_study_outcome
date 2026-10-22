package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
public interface TypeMappingConfiguration<T> {

    public static final class DefaultImpls {
        public static <T> String getPredefinedFullInternalNameForClass(TypeMappingConfiguration<? extends T> r10, ClassDescriptor r11) {
            Intrinsics.checkNotNullParameter(r11, "classDescriptor");
            return null;
        }

        public static <T> KotlinType preprocessType(TypeMappingConfiguration<? extends T> r10, KotlinType r11) {
            Intrinsics.checkNotNullParameter(r11, "kotlinType");
            return null;
        }
    }

    KotlinType commonSupertype(Collection<KotlinType> r10);

    String getPredefinedFullInternalNameForClass(ClassDescriptor r10);

    String getPredefinedInternalNameForClass(ClassDescriptor r10);

    T getPredefinedTypeForClass(ClassDescriptor r10);

    KotlinType preprocessType(KotlinType r10);

    void processErrorType(KotlinType r10, ClassDescriptor r11);
}
