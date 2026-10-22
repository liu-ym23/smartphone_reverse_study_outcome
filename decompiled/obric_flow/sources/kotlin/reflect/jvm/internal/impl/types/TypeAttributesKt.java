package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nTypeAttributes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeAttributes.kt\norg/jetbrains/kotlin/types/TypeAttributesKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,133:1\n1#2:134\n*E\n"})
public final class TypeAttributesKt {
    public static final TypeAttributes replaceAnnotations(TypeAttributes r5, Annotations r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "newAnnotations");
        if (AnnotationsTypeAttributeKt.getAnnotations(r5) != r10) goto L5;
        return r5;
    L5:
        AnnotationsTypeAttribute r11 = AnnotationsTypeAttributeKt.getAnnotationsAttribute(r5);
        if (r11 == null) goto L12;
        TypeAttributes r12 = r5.remove(r11);
        if (r12 == null) goto L12;
        r5 = r12;
    L12:
        if (r10.iterator().hasNext() == true) goto L17;
        if (r10.isEmpty() == false) goto L17;
        return r5;
    L17:
        return r5.plus(new AnnotationsTypeAttribute(r10));
    }

    public static final TypeAttributes toDefaultAttributes(Annotations r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return TypeAttributeTranslator.DefaultImpls.toAttributes$default(DefaultTypeAttributeTranslator.INSTANCE, r10, null, null, 6, null);
    }
}
