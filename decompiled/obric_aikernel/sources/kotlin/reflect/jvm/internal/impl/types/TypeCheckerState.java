package kotlin.reflect.jvm.internal.impl.types;

import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayDeque;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

/* JADX INFO: loaded from: classes3.dex */
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
            public void fork(Function0<Boolean> r10) {
                Intrinsics.checkNotNullParameter(r10, "block");
                if (this.result == false) goto L5;
                return;
            L5:
                this.result = r10.invoke().booleanValue();
            }

            public final boolean getResult() {
                return this.result;
            }
        }

        void fork(Function0<Boolean> r10);
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

        private LowerCapturedTypePolicy(String r10, int r11) {
            super(r10, r11);
        }

        public static LowerCapturedTypePolicy valueOf(String r10) {
            return (LowerCapturedTypePolicy) Enum.valueOf(LowerCapturedTypePolicy.class, r10);
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
            public SimpleTypeMarker mo1327transformType(TypeCheckerState r10, KotlinTypeMarker r11) {
                Intrinsics.checkNotNullParameter(r10, "state");
                Intrinsics.checkNotNullParameter(r11, WsConstants.KEY_CONNECTION_TYPE);
                return r10.getTypeSystemContext().lowerBoundIfFlexible(r11);
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

            public Void transformType(TypeCheckerState r10, KotlinTypeMarker r11) {
                Intrinsics.checkNotNullParameter(r10, "state");
                Intrinsics.checkNotNullParameter(r11, WsConstants.KEY_CONNECTION_TYPE);
                throw new UnsupportedOperationException("Should not be called");
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy
            /* JADX INFO: renamed from: transformType, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ SimpleTypeMarker mo1327transformType(TypeCheckerState r10, KotlinTypeMarker r11) {
                return (SimpleTypeMarker) transformType(r10, r11);
            }
        }

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
            public SimpleTypeMarker mo1327transformType(TypeCheckerState r10, KotlinTypeMarker r11) {
                Intrinsics.checkNotNullParameter(r10, "state");
                Intrinsics.checkNotNullParameter(r11, WsConstants.KEY_CONNECTION_TYPE);
                return r10.getTypeSystemContext().upperBoundIfFlexible(r11);
            }
        }

        private SupertypesPolicy() {
        }

        public /* synthetic */ SupertypesPolicy(DefaultConstructorMarker r10) {
            this();
        }

        /* JADX INFO: renamed from: transformType */
        public abstract SimpleTypeMarker mo1327transformType(TypeCheckerState r10, KotlinTypeMarker r11);
    }

    public TypeCheckerState(boolean r10, boolean r11, boolean r12, TypeSystemContext r13, AbstractTypePreparator r14, AbstractTypeRefiner r15) {
        Intrinsics.checkNotNullParameter(r13, "typeSystemContext");
        Intrinsics.checkNotNullParameter(r14, "kotlinTypePreparator");
        Intrinsics.checkNotNullParameter(r15, "kotlinTypeRefiner");
        this.isErrorTypeEqualsToAnything = r10;
        this.isStubTypeEqualsToAnything = r11;
        this.allowedTypeVariable = r12;
        this.typeSystemContext = r13;
        this.kotlinTypePreparator = r14;
        this.kotlinTypeRefiner = r15;
    }

    public static final /* synthetic */ int access$getArgumentsDepth(TypeCheckerState r10) {
        return r10.argumentsDepth;
    }

    public static final /* synthetic */ void access$setArgumentsDepth(TypeCheckerState r10, int r11) {
        r10.argumentsDepth = r11;
    }

    public static /* synthetic */ Boolean addSubtypeConstraint$default(TypeCheckerState r10, KotlinTypeMarker r11, KotlinTypeMarker r12, boolean r13, int r14, Object r15) {
        if (r15 != null) goto L9;
        if ((r14 & 4) == 0) goto L7;
        r13 = false;
    L7:
        return r10.addSubtypeConstraint(r11, r12, r13);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addSubtypeConstraint");
    }

    public Boolean addSubtypeConstraint(KotlinTypeMarker r10, KotlinTypeMarker r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "subType");
        Intrinsics.checkNotNullParameter(r11, "superType");
        return null;
    }

    public final void clear() {
        ArrayDeque<SimpleTypeMarker> r10 = this.supertypesDeque;
        Intrinsics.checkNotNull(r10);
        r10.clear();
        Set<SimpleTypeMarker> r11 = this.supertypesSet;
        Intrinsics.checkNotNull(r11);
        r11.clear();
        this.supertypesLocked = false;
    }

    public boolean customIsSubtypeOf(KotlinTypeMarker r10, KotlinTypeMarker r11) {
        Intrinsics.checkNotNullParameter(r10, "subType");
        Intrinsics.checkNotNullParameter(r11, "superType");
        return true;
    }

    public LowerCapturedTypePolicy getLowerCapturedTypePolicy(SimpleTypeMarker r10, CapturedTypeMarker r11) {
        Intrinsics.checkNotNullParameter(r10, "subType");
        Intrinsics.checkNotNullParameter(r11, "superType");
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

    public final boolean isAllowedTypeVariable(KotlinTypeMarker r10) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
        if (this.allowedTypeVariable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.typeSystemContext.isTypeVariableType(r10) == false) goto L7;
        return true;
    }

    public final boolean isErrorTypeEqualsToAnything() {
        return this.isErrorTypeEqualsToAnything;
    }

    public final boolean isStubTypeEqualsToAnything() {
        return this.isStubTypeEqualsToAnything;
    }

    public final KotlinTypeMarker prepareType(KotlinTypeMarker r10) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
        return this.kotlinTypePreparator.prepareType(r10);
    }

    public final KotlinTypeMarker refineType(KotlinTypeMarker r10) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
        return this.kotlinTypeRefiner.refineType(r10);
    }

    public boolean runForkingPoint(Function1<? super ForkPointContext, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "block");
        ForkPointContext.Default r11 = new ForkPointContext.Default();
        r10.invoke(r11);
        return r11.getResult();
    }
}
