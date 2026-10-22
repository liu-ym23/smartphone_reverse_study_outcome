package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.FilteredAnnotations;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;

/* JADX INFO: loaded from: classes3.dex */
public final class TypeSubstitutionKt {
    public static final SimpleType asSimpleType(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        UnwrappedType r10 = r5.unwrap();
        if ((r10 instanceof SimpleType) == false) goto L5;
        SimpleType r11 = (SimpleType) r10;
    L6:
        if (r11 == null) goto L9;
        return r11;
    L9:
        throw new IllegalStateException(("This is should be simple type: " + r5).toString());
    L5:
        r11 = null;
        goto L6
    }

    @JvmOverloads
    public static final KotlinType replace(KotlinType r10, List<? extends TypeProjection> r11, Annotations r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "newArguments");
        Intrinsics.checkNotNullParameter(r12, "newAnnotations");
        return replace$default(r10, r11, r12, null, 4, null);
    }

    public static /* synthetic */ KotlinType replace$default(KotlinType r5, List r10, Annotations r11, List r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = r5.getArguments();
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = r5.getAnnotations();
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = r10;
    L12:
        return replace(r5, r10, r11, r12);
    }

    @JvmOverloads
    public static final KotlinType replace(KotlinType r5, List<? extends TypeProjection> r10, Annotations r11, List<? extends TypeProjection> r12) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "newArguments");
        Intrinsics.checkNotNullParameter(r11, "newAnnotations");
        Intrinsics.checkNotNullParameter(r12, "newArgumentsForUpperBound");
        if (r10.isEmpty() == true) goto L7;
        if (r10 == r5.getArguments()) goto L7;
    L9:
        TypeAttributes r13 = r5.getAttributes();
        if ((r11 instanceof FilteredAnnotations) == true) goto L12;
    L14:
        TypeAttributes r14 = TypeAttributesKt.replaceAnnotations(r13, r11);
        UnwrappedType r15 = r5.unwrap();
        if ((r15 instanceof FlexibleType) == false) goto L18;
        FlexibleType r16 = (FlexibleType) r15;
        return KotlinTypeFactory.flexibleType(replace(r16.getLowerBound(), r10, r14), replace(r16.getUpperBound(), r12, r14));
    L18:
        if ((r15 instanceof SimpleType) == false) goto L22;
        return replace((SimpleType) r15, r10, r14);
    L22:
        throw new NoWhenBranchMatchedException();
    L12:
        if (r11.isEmpty() == false) goto L14;
        r11 = Annotations.Companion.getEMPTY();
    L7:
        if (r11 != r5.getAnnotations()) goto L9;
        return r5;
    }

    public static /* synthetic */ SimpleType replace$default(SimpleType r5, List r10, TypeAttributes r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = r5.getArguments();
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = r5.getAttributes();
    L9:
        return replace(r5, r10, r11);
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
        if ((r10 instanceof ErrorType) == false) goto L16;
        return ((ErrorType) r10).replaceArguments(r11);
    L16:
        return KotlinTypeFactory.simpleType$default(r12, r10.getConstructor(), r11, r10.isMarkedNullable(), null, 16, null);
    }
}
