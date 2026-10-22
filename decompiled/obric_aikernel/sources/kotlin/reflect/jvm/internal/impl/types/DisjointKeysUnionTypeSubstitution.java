package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* JADX INFO: loaded from: classes3.dex */
public final class DisjointKeysUnionTypeSubstitution extends TypeSubstitution {
    public static final Companion Companion = null;
    private final TypeSubstitution first;
    private final TypeSubstitution second;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        @JvmStatic
        public final TypeSubstitution create(TypeSubstitution r10, TypeSubstitution r11) {
            Intrinsics.checkNotNullParameter(r10, "first");
            Intrinsics.checkNotNullParameter(r11, "second");
            if (r10.isEmpty() == false) goto L6;
            return r11;
        L6:
            if (r11.isEmpty() == false) goto L9;
            return r10;
        L9:
            return new DisjointKeysUnionTypeSubstitution(r10, r11, null);
        }
    }

    static {
        Companion = new Companion(null);
    }

    private DisjointKeysUnionTypeSubstitution(TypeSubstitution r10, TypeSubstitution r11) {
        this.first = r10;
        this.second = r11;
    }

    public /* synthetic */ DisjointKeysUnionTypeSubstitution(TypeSubstitution r10, TypeSubstitution r11, DefaultConstructorMarker r12) {
        this(r10, r11);
    }

    @JvmStatic
    public static final TypeSubstitution create(TypeSubstitution r10, TypeSubstitution r11) {
        return Companion.create(r10, r11);
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
    public Annotations filterAnnotations(Annotations r10) {
        Intrinsics.checkNotNullParameter(r10, "annotations");
        return this.second.filterAnnotations(this.first.filterAnnotations(r10));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    /* JADX INFO: renamed from: get */
    public TypeProjection mo1328get(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        TypeProjection r11 = this.first.mo1328get(r10);
        if (r11 == null) goto L5;
        return r11;
    L5:
        return this.second.mo1328get(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean isEmpty() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public KotlinType prepareTopLevelType(KotlinType r10, Variance r11) {
        Intrinsics.checkNotNullParameter(r10, "topLevelType");
        Intrinsics.checkNotNullParameter(r11, "position");
        return this.second.prepareTopLevelType(this.first.prepareTopLevelType(r10, r11), r11);
    }
}
