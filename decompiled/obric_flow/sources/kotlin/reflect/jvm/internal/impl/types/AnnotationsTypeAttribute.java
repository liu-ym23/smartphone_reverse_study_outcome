package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class AnnotationsTypeAttribute extends TypeAttribute<AnnotationsTypeAttribute> {
    private final Annotations annotations;

    public AnnotationsTypeAttribute(Annotations r5) {
        Intrinsics.checkNotNullParameter(r5, "annotations");
        this.annotations = r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeAttribute
    public /* bridge */ /* synthetic */ TypeAttribute add(TypeAttribute r5) {
        return add((AnnotationsTypeAttribute) r5);
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof AnnotationsTypeAttribute) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(((AnnotationsTypeAttribute) r5).annotations, this.annotations);
    }

    public final Annotations getAnnotations() {
        return this.annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeAttribute
    public KClass<? extends AnnotationsTypeAttribute> getKey() {
        return Reflection.getOrCreateKotlinClass(AnnotationsTypeAttribute.class);
    }

    public int hashCode() {
        return this.annotations.hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeAttribute
    public /* bridge */ /* synthetic */ TypeAttribute intersect(TypeAttribute r5) {
        return intersect((AnnotationsTypeAttribute) r5);
    }

    public AnnotationsTypeAttribute add(AnnotationsTypeAttribute r5) {
        if (r5 != null) goto L5;
        return this;
    L5:
        return new AnnotationsTypeAttribute(AnnotationsKt.composeAnnotations(this.annotations, r5.annotations));
    }

    public AnnotationsTypeAttribute intersect(AnnotationsTypeAttribute r5) {
        if (Intrinsics.areEqual(r5, this) == true) goto L7;
        return null;
    L7:
        return this;
    }
}
