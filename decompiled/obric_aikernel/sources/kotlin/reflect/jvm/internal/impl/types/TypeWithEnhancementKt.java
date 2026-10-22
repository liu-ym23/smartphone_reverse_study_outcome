package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class TypeWithEnhancementKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final KotlinType getEnhancement(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof TypeWithEnhancement) == true) goto L7;
        return null;
    L7:
        return ((TypeWithEnhancement) r10).getEnhancement();
    }

    public static final UnwrappedType inheritEnhancement(UnwrappedType r10, KotlinType r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "origin");
        return wrapEnhancement(r10, getEnhancement(r11));
    }

    public static final UnwrappedType inheritEnhancement(UnwrappedType r10, KotlinType r11, Function1<? super KotlinType, ? extends KotlinType> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "origin");
        Intrinsics.checkNotNullParameter(r12, "transform");
        KotlinType r13 = getEnhancement(r11);
        if (r13 == null) goto L5;
        KotlinType r14 = r12.invoke(r13);
    L7:
        return wrapEnhancement(r10, r14);
    L5:
        r14 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final UnwrappedType wrapEnhancement(UnwrappedType r10, KotlinType r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof TypeWithEnhancement) == true) goto L5;
        if (r11 != null) goto L8;
    L19:
        return r10;
    L8:
        if (Intrinsics.areEqual(r11, r10) == true) goto L19;
        if ((r10 instanceof SimpleType) == false) goto L14;
        return new SimpleTypeWithEnhancement((SimpleType) r10, r11);
    L14:
        if ((r10 instanceof FlexibleType) == false) goto L18;
        return new FlexibleTypeWithEnhancement((FlexibleType) r10, r11);
    L18:
        throw new NoWhenBranchMatchedException();
    L5:
        return wrapEnhancement(((TypeWithEnhancement) r10).getOrigin(), r11);
    }
}
