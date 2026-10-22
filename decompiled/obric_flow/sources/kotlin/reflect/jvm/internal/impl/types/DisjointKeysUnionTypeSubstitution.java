package kotlin.reflect.jvm.internal.impl.types;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
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
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        @JvmStatic
        public final TypeSubstitution create(TypeSubstitution r5, TypeSubstitution r10) {
            Intrinsics.checkNotNullParameter(r5, "first");
            Intrinsics.checkNotNullParameter(r10, "second");
            if (r5.isEmpty() == false) goto L6;
            return r10;
        L6:
            if (r10.isEmpty() == false) goto L9;
            return r5;
        L9:
            return new DisjointKeysUnionTypeSubstitution(r5, r10, null);
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ DisjointKeysUnionTypeSubstitution(TypeSubstitution r5, TypeSubstitution r10, DefaultConstructorMarker r11) {
        this(r5, r10);
    }

    @JvmStatic
    public static final TypeSubstitution create(TypeSubstitution r5, TypeSubstitution r10) {
        return Companion.create(r5, r10);
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
    public Annotations filterAnnotations(Annotations r5) {
        Intrinsics.checkNotNullParameter(r5, "annotations");
        return this.second.filterAnnotations(this.first.filterAnnotations(r5));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    /* JADX INFO: renamed from: get */
    public TypeProjection mo1407get(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        TypeProjection r10 = this.first.mo1407get(r5);
        if (r10 == null) goto L5;
        return r10;
    L5:
        return this.second.mo1407get(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean isEmpty() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public KotlinType prepareTopLevelType(KotlinType r5, Variance r10) {
        Intrinsics.checkNotNullParameter(r5, "topLevelType");
        Intrinsics.checkNotNullParameter(r10, "position");
        return this.second.prepareTopLevelType(this.first.prepareTopLevelType(r5, r10), r10);
    }

    private DisjointKeysUnionTypeSubstitution(TypeSubstitution r5, TypeSubstitution r10) {
        this.first = r5;
        this.second = r10;
    }
}
