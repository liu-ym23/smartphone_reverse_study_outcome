package kotlin.reflect.jvm.internal.impl.types;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* JADX INFO: loaded from: classes3.dex */
public class DelegatedTypeSubstitution extends TypeSubstitution {
    private final TypeSubstitution substitution;

    public DelegatedTypeSubstitution(TypeSubstitution r5) {
        Intrinsics.checkNotNullParameter(r5, "substitution");
        this.substitution = r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean approximateCapturedTypes() {
        return this.substitution.approximateCapturedTypes();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean approximateContravariantCapturedTypes() {
        return this.substitution.approximateContravariantCapturedTypes();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public Annotations filterAnnotations(Annotations r5) {
        Intrinsics.checkNotNullParameter(r5, "annotations");
        return this.substitution.filterAnnotations(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    /* JADX INFO: renamed from: get */
    public TypeProjection mo1407get(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        return this.substitution.mo1407get(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean isEmpty() {
        return this.substitution.isEmpty();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public KotlinType prepareTopLevelType(KotlinType r5, Variance r10) {
        Intrinsics.checkNotNullParameter(r5, "topLevelType");
        Intrinsics.checkNotNullParameter(r10, "position");
        return this.substitution.prepareTopLevelType(r5, r10);
    }
}
