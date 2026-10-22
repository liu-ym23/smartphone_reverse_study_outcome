package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* JADX INFO: loaded from: classes3.dex */
public interface FlexibleTypeDeserializer {

    public static final class ThrowException implements FlexibleTypeDeserializer {
        public static final ThrowException INSTANCE = null;

        static {
            INSTANCE = new ThrowException();
        }

        private ThrowException() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer
        public KotlinType create(ProtoBuf.Type r5, String r10, SimpleType r11, SimpleType r12) {
            Intrinsics.checkNotNullParameter(r5, "proto");
            Intrinsics.checkNotNullParameter(r10, "flexibleId");
            Intrinsics.checkNotNullParameter(r11, "lowerBound");
            Intrinsics.checkNotNullParameter(r12, "upperBound");
            throw new IllegalArgumentException("This method should not be used.");
        }
    }

    KotlinType create(ProtoBuf.Type r5, String r10, SimpleType r11, SimpleType r12);
}
