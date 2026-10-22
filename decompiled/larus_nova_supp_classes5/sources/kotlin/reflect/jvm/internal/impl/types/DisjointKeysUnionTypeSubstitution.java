package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class DisjointKeysUnionTypeSubstitution extends TypeSubstitution {
    public static final Companion Companion = null;
    private final TypeSubstitution first;
    private final TypeSubstitution second;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final TypeSubstitution create(TypeSubstitution r3, TypeSubstitution r4) {
            Intrinsics.checkNotNullParameter(r3, "first");
            Intrinsics.checkNotNullParameter(r4, "second");
            if (r3.isEmpty() == false) goto L6;
            return r4;
        L6:
            if (r4.isEmpty() == false) goto L9;
            return r3;
        L9:
            return new DisjointKeysUnionTypeSubstitution(r3, r4, null);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ DisjointKeysUnionTypeSubstitution(TypeSubstitution r1, TypeSubstitution r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    @JvmStatic
    public static final TypeSubstitution create(TypeSubstitution r1, TypeSubstitution r2) {
        return Companion.create(r1, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean isEmpty() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean approximateCapturedTypes() {
        if (this.first.approximateCapturedTypes() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.second.approximateCapturedTypes() == true) goto L8;
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean approximateContravariantCapturedTypes() {
        if (this.first.approximateContravariantCapturedTypes() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.second.approximateContravariantCapturedTypes() == true) goto L8;
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public Annotations filterAnnotations(Annotations r3) {
        Intrinsics.checkNotNullParameter(r3, "annotations");
        return this.second.filterAnnotations(this.first.filterAnnotations(r3));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    /* JADX INFO: renamed from: get */
    public TypeProjection mo385get(KotlinType r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        TypeProjection r0 = this.first.mo385get(r2);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.second.mo385get(r2);
    }

    private DisjointKeysUnionTypeSubstitution(TypeSubstitution r1, TypeSubstitution r2) {
        this.first = r1;
        this.second = r2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public KotlinType prepareTopLevelType(KotlinType r3, Variance r4) {
        Intrinsics.checkNotNullParameter(r3, "topLevelType");
        Intrinsics.checkNotNullParameter(r4, "position");
        return this.second.prepareTopLevelType(this.first.prepareTopLevelType(r3, r4), r4);
    }
}
