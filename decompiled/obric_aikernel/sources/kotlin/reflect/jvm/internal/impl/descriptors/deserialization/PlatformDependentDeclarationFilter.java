package kotlin.reflect.jvm.internal.impl.descriptors.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public interface PlatformDependentDeclarationFilter {

    public static final class All implements PlatformDependentDeclarationFilter {
        public static final All INSTANCE = null;

        static {
            INSTANCE = new All();
        }

        private All() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter
        public boolean isFunctionAvailable(ClassDescriptor r10, SimpleFunctionDescriptor r11) {
            Intrinsics.checkNotNullParameter(r10, "classDescriptor");
            Intrinsics.checkNotNullParameter(r11, "functionDescriptor");
            return true;
        }
    }

    public static final class NoPlatformDependent implements PlatformDependentDeclarationFilter {
        public static final NoPlatformDependent INSTANCE = null;

        static {
            INSTANCE = new NoPlatformDependent();
        }

        private NoPlatformDependent() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter
        public boolean isFunctionAvailable(ClassDescriptor r10, SimpleFunctionDescriptor r11) {
            Intrinsics.checkNotNullParameter(r10, "classDescriptor");
            Intrinsics.checkNotNullParameter(r11, "functionDescriptor");
            return !r11.getAnnotations().hasAnnotation(PlatformDependentDeclarationFilterKt.getPLATFORM_DEPENDENT_ANNOTATION_FQ_NAME());
        }
    }

    boolean isFunctionAvailable(ClassDescriptor r10, SimpleFunctionDescriptor r11);
}
