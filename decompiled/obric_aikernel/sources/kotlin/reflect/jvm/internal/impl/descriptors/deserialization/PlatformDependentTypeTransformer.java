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
        public SimpleType transformPlatformType(ClassId r10, SimpleType r11) {
            Intrinsics.checkNotNullParameter(r10, "classId");
            Intrinsics.checkNotNullParameter(r11, "computedType");
            return r11;
        }
    }

    SimpleType transformPlatformType(ClassId r10, SimpleType r11);
}
