package kotlin.jvm.internal;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.List;
import kotlin.SinceKotlin;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVariance;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin(version = "1.4")
@SourceDebugExtension({"SMAP\nTypeParameterReference.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeParameterReference.kt\nkotlin/jvm/internal/TypeParameterReference\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,58:1\n1#2:59\n*E\n"})
public final class TypeParameterReference implements KTypeParameter {
    public static final Companion Companion = null;
    private volatile List<? extends KType> bounds;
    private final Object container;
    private final boolean isReified;
    private final String name;
    private final KVariance variance;

    public static final class Companion {

        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r10 = new int[KVariance.values().length];
                r10[KVariance.INVARIANT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r10[KVariance.IN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r10[KVariance.OUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                $EnumSwitchMapping$0 = r10;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final String toString(KTypeParameter r10) {
            Intrinsics.checkNotNullParameter(r10, "typeParameter");
            StringBuilder r11 = new StringBuilder();
            KVariance r12 = r10.getVariance();
            int r13 = WhenMappings.$EnumSwitchMapping$0[r12.ordinal()];
            if (r13 != 2) goto L5;
            String r14 = "in ";
        L9:
            r11.append(r14);
        L10:
            r11.append(r10.getName());
            String r15 = r11.toString();
            Intrinsics.checkNotNullExpressionValue(r15, "StringBuilder().apply(builderAction).toString()");
            return r15;
        L5:
            if (r13 != 3) goto L10;
            r14 = "out ";
            goto L9
        }
    }

    static {
        Companion = new Companion(null);
    }

    public TypeParameterReference(Object r10, String r11, KVariance r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r12, "variance");
        this.container = r10;
        this.name = r11;
        this.variance = r12;
        this.isReified = r13;
    }

    public static /* synthetic */ void getUpperBounds$annotations() {
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof TypeParameterReference) == false) goto L9;
        TypeParameterReference r11 = (TypeParameterReference) r10;
        if (Intrinsics.areEqual(this.container, r11.container) == false) goto L9;
        if (Intrinsics.areEqual(getName(), r11.getName()) == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // kotlin.reflect.KTypeParameter
    public String getName() {
        return this.name;
    }

    @Override // kotlin.reflect.KTypeParameter
    public List<KType> getUpperBounds() {
        List r10 = this.bounds;
        if (r10 != null) goto L6;
        List<KType> r11 = CollectionsKt.listOf(Reflection.nullableTypeOf(Object.class));
        this.bounds = r11;
        return r11;
    L6:
        return r10;
    }

    @Override // kotlin.reflect.KTypeParameter
    public KVariance getVariance() {
        return this.variance;
    }

    public int hashCode() {
        Object r10 = this.container;
        if (r10 == null) goto L5;
        int r11 = r10.hashCode();
    L7:
        return (r11 * 31) + getName().hashCode();
    L5:
        r11 = 0;
        goto L7
    }

    @Override // kotlin.reflect.KTypeParameter
    public boolean isReified() {
        return this.isReified;
    }

    public final void setUpperBounds(List<? extends KType> r10) {
        Intrinsics.checkNotNullParameter(r10, "upperBounds");
        if (this.bounds != null) goto L7;
        this.bounds = r10;
        return;
    L7:
        throw new IllegalStateException(("Upper bounds of type parameter '" + this + "' have already been initialized.").toString());
    }

    public String toString() {
        return Companion.toString(this);
    }
}
