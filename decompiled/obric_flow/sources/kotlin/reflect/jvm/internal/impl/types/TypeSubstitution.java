package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TypeSubstitution {
    public static final Companion Companion = null;

    @JvmField
    public static final TypeSubstitution EMPTY = null;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        EMPTY = new TypeSubstitution$Companion$EMPTY$1();
    }

    public TypeSubstitution() {
    }

    public boolean approximateCapturedTypes() {
        return false;
    }

    public boolean approximateContravariantCapturedTypes() {
        return false;
    }

    public final TypeSubstitutor buildSubstitutor() {
        return TypeSubstitutor.create(this);
    }

    public Annotations filterAnnotations(Annotations r5) {
        Intrinsics.checkNotNullParameter(r5, "annotations");
        return r5;
    }

    /* JADX INFO: renamed from: get */
    public abstract TypeProjection mo1407get(KotlinType r5);

    public boolean isEmpty() {
        return false;
    }

    public KotlinType prepareTopLevelType(KotlinType r5, Variance r10) {
        Intrinsics.checkNotNullParameter(r5, "topLevelType");
        Intrinsics.checkNotNullParameter(r10, "position");
        return r5;
    }

    public final TypeSubstitution replaceWithNonApproximating() {
        return new AnonymousClass1(this);
    }
}
