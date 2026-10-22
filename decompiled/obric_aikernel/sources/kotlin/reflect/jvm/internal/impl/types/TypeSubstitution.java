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
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
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
        TypeSubstitutor r10 = TypeSubstitutor.create(this);
        Intrinsics.checkNotNullExpressionValue(r10, "create(this)");
        return r10;
    }

    public Annotations filterAnnotations(Annotations r10) {
        Intrinsics.checkNotNullParameter(r10, "annotations");
        return r10;
    }

    /* JADX INFO: renamed from: get */
    public abstract TypeProjection mo1328get(KotlinType r10);

    public boolean isEmpty() {
        return false;
    }

    public KotlinType prepareTopLevelType(KotlinType r10, Variance r11) {
        Intrinsics.checkNotNullParameter(r10, "topLevelType");
        Intrinsics.checkNotNullParameter(r11, "position");
        return r10;
    }

    public final TypeSubstitution replaceWithNonApproximating() {
        return new AnonymousClass1(this);
    }
}
