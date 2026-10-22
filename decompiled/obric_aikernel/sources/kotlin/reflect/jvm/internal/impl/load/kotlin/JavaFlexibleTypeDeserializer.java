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
    public KotlinType create(ProtoBuf.Type r10, String r11, SimpleType r12, SimpleType r13) {
        Intrinsics.checkNotNullParameter(r10, "proto");
        Intrinsics.checkNotNullParameter(r11, "flexibleId");
        Intrinsics.checkNotNullParameter(r12, "lowerBound");
        Intrinsics.checkNotNullParameter(r13, "upperBound");
        if (Intrinsics.areEqual(r11, "kotlin.jvm.PlatformType") == true) goto L7;
        return ErrorUtils.createErrorType(ErrorTypeKind.ERROR_FLEXIBLE_TYPE, new String[]{r11, r12.toString(), r13.toString()});
    L7:
        if (r10.hasExtension(JvmProtoBuf.isRaw) == false) goto L11;
        return new RawTypeImpl(r12, r13);
    L11:
        return KotlinTypeFactory.flexibleType(r12, r13);
    }
}
