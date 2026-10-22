package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.FilteredAnnotations;

/* JADX INFO: loaded from: classes3.dex */
public final class TypeSubstitutionKt {
    public static final SimpleType asSimpleType(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        UnwrappedType r11 = r10.unwrap();
        if ((r11 instanceof SimpleType) == false) goto L5;
        SimpleType r12 = (SimpleType) r11;
    L6:
        if (r12 == null) goto L9;
        return r12;
    L9:
        throw new IllegalStateException(("This is should be simple type: " + r10).toString());
    L5:
        r12 = null;
        goto L6
    }

    @JvmOverloads
    public static final KotlinType replace(KotlinType r10, List<? extends TypeProjection> r11, Annotations r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "newArguments");
        Intrinsics.checkNotNullParameter(r12, "newAnnotations");
        return replace$default(r10, r11, r12, null, 4, null);
    }

    @JvmOverloads
    public static final KotlinType replace(KotlinType r10, List<? extends TypeProjection> r11, Annotations r12, List<? extends TypeProjection> r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "newArguments");
        Intrinsics.checkNotNullParameter(r12, "newAnnotations");
        Intrinsics.checkNotNullParameter(r13, "newArgumentsForUpperBound");
        if (r11.isEmpty() == true) goto L7;
        if (r11 == r10.getArguments()) goto L7;
    L9:
        TypeAttributes r14 = r10.getAttributes();
        if ((r12 instanceof FilteredAnnotations) == true) goto L12;
    L14:
        TypeAttributes r15 = TypeAttributesKt.replaceAnnotations(r14, r12);
        UnwrappedType r16 = r10.unwrap();
        if ((r16 instanceof FlexibleType) == false) goto L18;
        FlexibleType r17 = (FlexibleType) r16;
        return KotlinTypeFactory.flexibleType(replace(r17.getLowerBound(), r11, r15), replace(r17.getUpperBound(), r13, r15));
    L18:
        if ((r16 instanceof SimpleType) == false) goto L22;
        return replace((SimpleType) r16, r11, r15);
    L22:
        throw new NoWhenBranchMatchedException();
    L12:
        if (r12.isEmpty() == false) goto L14;
        r12 = Annotations.Companion.getEMPTY();
    L7:
        if (r12 != r10.getAnnotations()) goto L9;
        return r10;
    }

    @JvmOverloads
    public static final SimpleType replace(SimpleType r10, List<? extends TypeProjection> r11, TypeAttributes r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "newArguments");
        Intrinsics.checkNotNullParameter(r12, "newAttributes");
        if (r11.isEmpty() == false) goto L8;
        if (r12 != r10.getAttributes()) goto L8;
        return r10;
    L8:
        if (r11.isEmpty() == false) goto L12;
        return r10.replaceAttributes(r12);
    L12:
        return KotlinTypeFactory.simpleType$default(r12, r10.getConstructor(), r11, r10.isMarkedNullable(), null, 16, null);
    }

    public static /* synthetic */ KotlinType replace$default(KotlinType r10, List r11, Annotations r12, List r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = r10.getArguments();
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.getAnnotations();
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = r11;
    L12:
        return replace(r10, r11, r12, r13);
    }

    public static /* synthetic */ SimpleType replace$default(SimpleType r10, List r11, TypeAttributes r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.getArguments();
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.getAttributes();
    L9:
        return replace(r10, r11, r12);
    }
}
