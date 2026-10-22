package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayDeque;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nAbstractTypeChecker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractTypeChecker.kt\norg/jetbrains/kotlin/types/TypeCheckerState\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,835:1\n1#2:836\n*E\n"})
public class TypeCheckerState {
    private final boolean allowedTypeVariable;
    private int argumentsDepth;
    private final boolean isErrorTypeEqualsToAnything;
    private final boolean isStubTypeEqualsToAnything;
    private final AbstractTypePreparator kotlinTypePreparator;
    private final AbstractTypeRefiner kotlinTypeRefiner;
    private ArrayDeque<SimpleTypeMarker> supertypesDeque;
    private boolean supertypesLocked;
    private Set<SimpleTypeMarker> supertypesSet;
    private final TypeSystemContext typeSystemContext;

    public interface ForkPointContext {

        public static final class Default implements ForkPointContext {
            private boolean result;

            public Default() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.ForkPointContext
            public void fork(Function0<Boolean> r5) {
                Intrinsics.checkNotNullParameter(r5, "block");
                if (this.result == false) goto L5;
                return;
            L5:
                this.result = r5.invoke().booleanValue();
            }

            public final boolean getResult() {
                return this.result;
            }
        }

        void fork(Function0<Boolean> r5);
    }

    public static final enum LowerCapturedTypePolicy extends Enum<LowerCapturedTypePolicy> {
        private static final /* synthetic */ LowerCapturedTypePolicy[] $VALUES = null;
        public static final LowerCapturedTypePolicy CHECK_ONLY_LOWER = null;
        public static final LowerCapturedTypePolicy CHECK_SUBTYPE_AND_LOWER = null;
        public static final LowerCapturedTypePolicy SKIP_LOWER = null;

        private static final /* synthetic */ LowerCapturedTypePolicy[] $values() {
            return new LowerCapturedTypePolicy[]{CHECK_ONLY_LOWER, CHECK_SUBTYPE_AND_LOWER, SKIP_LOWER};
        }

        static {
            CHECK_ONLY_LOWER = new LowerCapturedTypePolicy("CHECK_ONLY_LOWER", 0);
            CHECK_SUBTYPE_AND_LOWER = new LowerCapturedTypePolicy("CHECK_SUBTYPE_AND_LOWER", 1);
            SKIP_LOWER = new LowerCapturedTypePolicy("SKIP_LOWER", 2);
            $VALUES = $values();
        }

        private LowerCapturedTypePolicy(String r5, int r10) {
            super(r5, r10);
        }

        public static LowerCapturedTypePolicy valueOf(String r5) {
            return (LowerCapturedTypePolicy) Enum.valueOf(LowerCapturedTypePolicy.class, r5);
        }

        public static LowerCapturedTypePolicy[] values() {
            return (LowerCapturedTypePolicy[]) $VALUES.clone();
        }
    }

    public static abstract class SupertypesPolicy {

        public static abstract class DoCustomTransform extends SupertypesPolicy {
            public DoCustomTransform() {
                super(null);
            }
        }

        @SourceDebugExtension({"SMAP\nAbstractTypeChecker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractTypeChecker.kt\norg/jetbrains/kotlin/types/TypeCheckerState$SupertypesPolicy$LowerIfFlexible\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,835:1\n1#2:836\n*E\n"})
        public static final class LowerIfFlexible extends SupertypesPolicy {
            public static final LowerIfFlexible INSTANCE = null;

            static {
                INSTANCE = new LowerIfFlexible();
            }

            private LowerIfFlexible() {
                super(null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy
            /* JADX INFO: renamed from: transformType */
            public SimpleTypeMarker mo1406transformType(TypeCheckerState r5, KotlinTypeMarker r10) {
                Intrinsics.checkNotNullParameter(r5, "state");
                Intrinsics.checkNotNullParameter(r10, "type");
                return r5.getTypeSystemContext().lowerBoundIfFlexible(r10);
            }
        }

        public static final class None extends SupertypesPolicy {
            public static final None INSTANCE = null;

            static {
                INSTANCE = new None();
            }

            private None() {
                super(null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy
            /* JADX INFO: renamed from: transformType, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ SimpleTypeMarker mo1406transformType(TypeCheckerState r5, KotlinTypeMarker r10) {
                return (SimpleTypeMarker) transformType(r5, r10);
            }

            public Void transformType(TypeCheckerState r5, KotlinTypeMarker r10) {
                Intrinsics.checkNotNullParameter(r5, "state");
                Intrinsics.checkNotNullParameter(r10, "type");
                throw new UnsupportedOperationException("Should not be called");
            }
        }

        @SourceDebugExtension({"SMAP\nAbstractTypeChecker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractTypeChecker.kt\norg/jetbrains/kotlin/types/TypeCheckerState$SupertypesPolicy$UpperIfFlexible\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,835:1\n1#2:836\n*E\n"})
        public static final class UpperIfFlexible extends SupertypesPolicy {
            public static final UpperIfFlexible INSTANCE = null;

            static {
                INSTANCE = new UpperIfFlexible();
            }

            private UpperIfFlexible() {
                super(null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy
            /* JADX INFO: renamed from: transformType */
            public SimpleTypeMarker mo1406transformType(TypeCheckerState r5, KotlinTypeMarker r10) {
                Intrinsics.checkNotNullParameter(r5, "state");
                Intrinsics.checkNotNullParameter(r10, "type");
                return r5.getTypeSystemContext().upperBoundIfFlexible(r10);
            }
        }

        public /* synthetic */ SupertypesPolicy(DefaultConstructorMarker r5) {
            this();
        }

        /* JADX INFO: renamed from: transformType */
        public abstract SimpleTypeMarker mo1406transformType(TypeCheckerState r5, KotlinTypeMarker r10);

        private SupertypesPolicy() {
        }
    }

    public TypeCheckerState(boolean r5, boolean r10, boolean r11, TypeSystemContext r12, AbstractTypePreparator r13, AbstractTypeRefiner r14) {
        Intrinsics.checkNotNullParameter(r12, "typeSystemContext");
        Intrinsics.checkNotNullParameter(r13, "kotlinTypePreparator");
        Intrinsics.checkNotNullParameter(r14, "kotlinTypeRefiner");
        this.isErrorTypeEqualsToAnything = r5;
        this.isStubTypeEqualsToAnything = r10;
        this.allowedTypeVariable = r11;
        this.typeSystemContext = r12;
        this.kotlinTypePreparator = r13;
        this.kotlinTypeRefiner = r14;
    }

    public static final /* synthetic */ int access$getArgumentsDepth(TypeCheckerState r5) {
        return r5.argumentsDepth;
    }

    public static final /* synthetic */ void access$setArgumentsDepth(TypeCheckerState r5, int r10) {
        r5.argumentsDepth = r10;
    }

    public static /* synthetic */ Boolean addSubtypeConstraint$default(TypeCheckerState r5, KotlinTypeMarker r10, KotlinTypeMarker r11, boolean r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 4) == 0) goto L7;
        r12 = false;
    L7:
        return r5.addSubtypeConstraint(r10, r11, r12);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addSubtypeConstraint");
    }

    public Boolean addSubtypeConstraint(KotlinTypeMarker r5, KotlinTypeMarker r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r5, "subType");
        Intrinsics.checkNotNullParameter(r10, "superType");
        return null;
    }

    public final void clear() {
        ArrayDeque<SimpleTypeMarker> r5 = this.supertypesDeque;
        Intrinsics.checkNotNull(r5);
        r5.clear();
        Set<SimpleTypeMarker> r10 = this.supertypesSet;
        Intrinsics.checkNotNull(r10);
        r10.clear();
        this.supertypesLocked = false;
    }

    public boolean customIsSubtypeOf(KotlinTypeMarker r5, KotlinTypeMarker r10) {
        Intrinsics.checkNotNullParameter(r5, "subType");
        Intrinsics.checkNotNullParameter(r10, "superType");
        return true;
    }

    public LowerCapturedTypePolicy getLowerCapturedTypePolicy(SimpleTypeMarker r5, CapturedTypeMarker r10) {
        Intrinsics.checkNotNullParameter(r5, "subType");
        Intrinsics.checkNotNullParameter(r10, "superType");
        return LowerCapturedTypePolicy.CHECK_SUBTYPE_AND_LOWER;
    }

    public final ArrayDeque<SimpleTypeMarker> getSupertypesDeque() {
        return this.supertypesDeque;
    }

    public final Set<SimpleTypeMarker> getSupertypesSet() {
        return this.supertypesSet;
    }

    public final TypeSystemContext getTypeSystemContext() {
        return this.typeSystemContext;
    }

    public final void initialize() {
        this.supertypesLocked = true;
        if (this.supertypesDeque != null) goto L6;
        this.supertypesDeque = new ArrayDeque(4);
    L6:
        if (this.supertypesSet != null) goto L9;
        this.supertypesSet = SmartSet.Companion.create();
        return;
    }

    public final boolean isAllowedTypeVariable(KotlinTypeMarker r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        if (this.allowedTypeVariable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.typeSystemContext.isTypeVariableType(r5) == false) goto L7;
        return true;
    }

    public final boolean isErrorTypeEqualsToAnything() {
        return this.isErrorTypeEqualsToAnything;
    }

    public final boolean isStubTypeEqualsToAnything() {
        return this.isStubTypeEqualsToAnything;
    }

    public final KotlinTypeMarker prepareType(KotlinTypeMarker r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        return this.kotlinTypePreparator.prepareType(r5);
    }

    public final KotlinTypeMarker refineType(KotlinTypeMarker r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        return this.kotlinTypeRefiner.refineType(r5);
    }

    public boolean runForkingPoint(Function1<? super ForkPointContext, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "block");
        ForkPointContext.Default r10 = new ForkPointContext.Default();
        r5.invoke(r10);
        return r10.getResult();
    }
}
