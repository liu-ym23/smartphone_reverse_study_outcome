package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class JavaFlexibleTypeDeserializer implements FlexibleTypeDeserializer {
    public static final JavaFlexibleTypeDeserializer INSTANCE = null;

    static {
        INSTANCE = new JavaFlexibleTypeDeserializer();
    }

    private JavaFlexibleTypeDeserializer() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer
    public KotlinType create(ProtoBuf$Type r3, String r4, SimpleType r5, SimpleType r6) {
        Intrinsics.checkNotNullParameter(r3, "proto");
        Intrinsics.checkNotNullParameter(r4, "flexibleId");
        Intrinsics.checkNotNullParameter(r5, "lowerBound");
        Intrinsics.checkNotNullParameter(r6, "upperBound");
        if (Intrinsics.areEqual(r4, "kotlin.jvm.PlatformType") == true) goto L7;
        return ErrorUtils.createErrorType(ErrorTypeKind.ERROR_FLEXIBLE_TYPE, new String[]{r4, r5.toString(), r6.toString()});
    L7:
        if (r3.hasExtension(JvmProtoBuf.isRaw) == false) goto L11;
        return new RawTypeImpl(r5, r6);
    L11:
        return KotlinTypeFactory.flexibleType(r5, r6);
    }
}
