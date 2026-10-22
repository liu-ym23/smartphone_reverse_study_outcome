package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class JavaFlexibleTypeDeserializer implements FlexibleTypeDeserializer {
    public static final JavaFlexibleTypeDeserializer INSTANCE = null;

    static {
        INSTANCE = new JavaFlexibleTypeDeserializer();
    }

    private JavaFlexibleTypeDeserializer() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer
    public KotlinType create(ProtoBuf.Type r5, String r10, SimpleType r11, SimpleType r12) {
        Intrinsics.checkNotNullParameter(r5, "proto");
        Intrinsics.checkNotNullParameter(r10, "flexibleId");
        Intrinsics.checkNotNullParameter(r11, "lowerBound");
        Intrinsics.checkNotNullParameter(r12, "upperBound");
        if (Intrinsics.areEqual(r10, "kotlin.jvm.PlatformType") == true) goto L7;
        return ErrorUtils.createErrorType(ErrorTypeKind.ERROR_FLEXIBLE_TYPE, new String[]{r10, r11.toString(), r12.toString()});
    L7:
        if (r5.hasExtension(JvmProtoBuf.isRaw) == false) goto L11;
        return new RawTypeImpl(r11, r12);
    L11:
        return KotlinTypeFactory.flexibleType(r11, r12);
    }
}
