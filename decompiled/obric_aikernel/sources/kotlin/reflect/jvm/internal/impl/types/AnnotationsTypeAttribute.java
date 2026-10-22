package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class AnnotationsTypeAttribute extends TypeAttribute<AnnotationsTypeAttribute> {
    private final Annotations annotations;

    public AnnotationsTypeAttribute(Annotations r10) {
        Intrinsics.checkNotNullParameter(r10, "annotations");
        this.annotations = r10;
    }

    public AnnotationsTypeAttribute add(AnnotationsTypeAttribute r10) {
        if (r10 != null) goto L5;
        return this;
    L5:
        return new AnnotationsTypeAttribute(AnnotationsKt.composeAnnotations(this.annotations, r10.annotations));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeAttribute
    public /* bridge */ /* synthetic */ TypeAttribute add(TypeAttribute r10) {
        return add((AnnotationsTypeAttribute) r10);
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof AnnotationsTypeAttribute) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(((AnnotationsTypeAttribute) r10).annotations, this.annotations);
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

    public AnnotationsTypeAttribute intersect(AnnotationsTypeAttribute r10) {
        if (Intrinsics.areEqual(r10, this) == true) goto L7;
        return null;
    L7:
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeAttribute
    public /* bridge */ /* synthetic */ TypeAttribute intersect(TypeAttribute r10) {
        return intersect((AnnotationsTypeAttribute) r10);
    }
}
