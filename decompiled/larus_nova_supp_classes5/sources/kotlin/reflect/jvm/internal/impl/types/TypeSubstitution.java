package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class TypeSubstitution {
    public static final Companion Companion = null;
    public static final TypeSubstitution EMPTY = null;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    public TypeSubstitution() {
    }

    public boolean approximateCapturedTypes() {
        return false;
    }

    public boolean approximateContravariantCapturedTypes() {
        return false;
    }

    public Annotations filterAnnotations(Annotations r2) {
        Intrinsics.checkNotNullParameter(r2, "annotations");
        return r2;
    }

    /* JADX INFO: renamed from: get */
    public abstract TypeProjection mo385get(KotlinType r1);

    public boolean isEmpty() {
        return false;
    }

    public KotlinType prepareTopLevelType(KotlinType r2, Variance r3) {
        Intrinsics.checkNotNullParameter(r2, "topLevelType");
        Intrinsics.checkNotNullParameter(r3, "position");
        return r2;
    }

    static {
        Companion = new Companion(null);
        EMPTY = new TypeSubstitution$Companion$EMPTY$1();
    }

    public final TypeSubstitution replaceWithNonApproximating() {
        return new AnonymousClass1(this);
    }

    public final TypeSubstitutor buildSubstitutor() {
        return TypeSubstitutor.create(this);
    }
}
