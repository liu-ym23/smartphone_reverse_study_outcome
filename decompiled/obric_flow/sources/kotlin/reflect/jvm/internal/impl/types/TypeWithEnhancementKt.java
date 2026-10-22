package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nTypeWithEnhancement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeWithEnhancement.kt\norg/jetbrains/kotlin/types/TypeWithEnhancementKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,169:1\n1549#2:170\n1620#2,3:171\n1726#2,3:174\n*S KotlinDebug\n*F\n+ 1 TypeWithEnhancement.kt\norg/jetbrains/kotlin/types/TypeWithEnhancementKt\n*L\n97#1:170\n97#1:171,3\n112#1:174,3\n*E\n"})
public final class TypeWithEnhancementKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final KotlinType getEnhancement(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof TypeWithEnhancement) == true) goto L7;
        return null;
    L7:
        return ((TypeWithEnhancement) r5).getEnhancement();
    }

    public static final UnwrappedType inheritEnhancement(UnwrappedType r5, KotlinType r10, Function1<? super KotlinType, ? extends KotlinType> r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "origin");
        Intrinsics.checkNotNullParameter(r11, "transform");
        KotlinType r12 = getEnhancement(r10);
        if (r12 == null) goto L5;
        KotlinType r13 = r11.invoke(r12);
    L7:
        return wrapEnhancement(r5, r13);
    L5:
        r13 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final UnwrappedType wrapEnhancement(UnwrappedType r5, KotlinType r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof TypeWithEnhancement) == true) goto L5;
        if (r10 != null) goto L8;
    L19:
        return r5;
    L8:
        if (Intrinsics.areEqual(r10, r5) == true) goto L19;
        if ((r5 instanceof SimpleType) == false) goto L14;
        return new SimpleTypeWithEnhancement((SimpleType) r5, r10);
    L14:
        if ((r5 instanceof FlexibleType) == false) goto L18;
        return new FlexibleTypeWithEnhancement((FlexibleType) r5, r10);
    L18:
        throw new NoWhenBranchMatchedException();
    L5:
        return wrapEnhancement(((TypeWithEnhancement) r5).getOrigin(), r10);
    }

    public static final UnwrappedType inheritEnhancement(UnwrappedType r5, KotlinType r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "origin");
        return wrapEnhancement(r5, getEnhancement(r10));
    }
}
