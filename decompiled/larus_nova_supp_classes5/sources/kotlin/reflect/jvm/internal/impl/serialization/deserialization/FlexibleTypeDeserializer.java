package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface FlexibleTypeDeserializer {

    public static final class ThrowException implements FlexibleTypeDeserializer {
        public static final ThrowException INSTANCE = null;

        static {
            INSTANCE = new ThrowException();
        }

        private ThrowException() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer
        public KotlinType create(ProtoBuf$Type r2, String r3, SimpleType r4, SimpleType r5) {
            Intrinsics.checkNotNullParameter(r2, "proto");
            Intrinsics.checkNotNullParameter(r3, "flexibleId");
            Intrinsics.checkNotNullParameter(r4, "lowerBound");
            Intrinsics.checkNotNullParameter(r5, "upperBound");
            throw new IllegalArgumentException("This method should not be used.");
        }
    }

    KotlinType create(ProtoBuf$Type r1, String r2, SimpleType r3, SimpleType r4);
}
