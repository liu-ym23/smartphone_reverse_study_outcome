package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* JADX INFO: loaded from: classes3.dex */
public final class TypeAttributesKt {
    public static final TypeAttributes replaceAnnotations(TypeAttributes r10, Annotations r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "newAnnotations");
        if (AnnotationsTypeAttributeKt.getAnnotations(r10) != r11) goto L5;
        return r10;
    L5:
        AnnotationsTypeAttribute r12 = AnnotationsTypeAttributeKt.getAnnotationsAttribute(r10);
        if (r12 == null) goto L12;
        TypeAttributes r13 = r10.remove(r12);
        if (r13 == null) goto L12;
        r10 = r13;
    L12:
        if (r11.iterator().hasNext() == true) goto L17;
        if (r11.isEmpty() == false) goto L17;
        return r10;
    L17:
        return r10.plus(new AnnotationsTypeAttribute(r11));
    }

    public static final TypeAttributes toDefaultAttributes(Annotations r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return TypeAttributeTranslator.DefaultImpls.toAttributes$default(DefaultTypeAttributeTranslator.INSTANCE, r10, null, null, 6, null);
    }
}
