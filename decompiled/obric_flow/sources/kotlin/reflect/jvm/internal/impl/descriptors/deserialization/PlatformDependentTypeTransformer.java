package kotlin.reflect.jvm.internal.impl.descriptors.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* JADX INFO: loaded from: classes3.dex */
public interface PlatformDependentTypeTransformer {

    public static final class None implements PlatformDependentTypeTransformer {
        public static final None INSTANCE = null;

        static {
            INSTANCE = new None();
        }

        private None() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentTypeTransformer
        public SimpleType transformPlatformType(ClassId r5, SimpleType r10) {
            Intrinsics.checkNotNullParameter(r5, "classId");
            Intrinsics.checkNotNullParameter(r10, "computedType");
            return r10;
        }
    }

    SimpleType transformPlatformType(ClassId r5, SimpleType r10);
}
