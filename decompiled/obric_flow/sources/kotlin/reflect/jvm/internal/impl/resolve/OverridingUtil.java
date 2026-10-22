package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyAccessorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

/* JADX INFO: loaded from: classes3.dex */
public class OverridingUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final OverridingUtil DEFAULT = null;
    private static final KotlinTypeChecker.TypeConstructorEquality DEFAULT_TYPE_CONSTRUCTOR_EQUALITY = null;
    private static final List<ExternalOverridabilityCondition> EXTERNAL_CONDITIONS = null;
    private final Function2<KotlinType, KotlinType, Boolean> customSubtype;
    private final KotlinTypeChecker.TypeConstructorEquality equalityAxioms;
    private final KotlinTypePreparator kotlinTypePreparator;
    private final KotlinTypeRefiner kotlinTypeRefiner;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$8, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass8 {
        static final /* synthetic */ int[] $SwitchMap$org$jetbrains$kotlin$descriptors$Modality = null;
        static final /* synthetic */ int[] $SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result = null;
        static final /* synthetic */ int[] $SwitchMap$org$jetbrains$kotlin$resolve$OverridingUtil$OverrideCompatibilityInfo$Result = null;

        static {
            int[] r5 = new int[Modality.values().length];
            $SwitchMap$org$jetbrains$kotlin$descriptors$Modality = r5;
            r5[Modality.FINAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L33:
            $SwitchMap$org$jetbrains$kotlin$descriptors$Modality[Modality.SEALED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L39:
            $SwitchMap$org$jetbrains$kotlin$descriptors$Modality[Modality.OPEN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L51:
            $SwitchMap$org$jetbrains$kotlin$descriptors$Modality[Modality.ABSTRACT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L10:
            int[] r10 = new int[OverrideCompatibilityInfo.Result.values().length];
            $SwitchMap$org$jetbrains$kotlin$resolve$OverridingUtil$OverrideCompatibilityInfo$Result = r10;
            r10[OverrideCompatibilityInfo.Result.OVERRIDABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L35:
            $SwitchMap$org$jetbrains$kotlin$resolve$OverridingUtil$OverrideCompatibilityInfo$Result[OverrideCompatibilityInfo.Result.CONFLICT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L37:
            $SwitchMap$org$jetbrains$kotlin$resolve$OverridingUtil$OverrideCompatibilityInfo$Result[OverrideCompatibilityInfo.Result.INCOMPATIBLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L14:
            int[] r11 = new int[ExternalOverridabilityCondition.Result.values().length];
            $SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result = r11;
            r11[ExternalOverridabilityCondition.Result.OVERRIDABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L49:
            $SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result[ExternalOverridabilityCondition.Result.CONFLICT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L31:
            $SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result[ExternalOverridabilityCondition.Result.INCOMPATIBLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L29
        L45:
            $SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result[ExternalOverridabilityCondition.Result.UNKNOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L30
            return;
        }
    }

    public static class OverrideCompatibilityInfo {
        private static final OverrideCompatibilityInfo SUCCESS = null;
        private final String debugMessage;
        private final Result overridable;

        public static final enum Result extends Enum<Result> {
            private static final /* synthetic */ Result[] $VALUES = null;
            public static final Result CONFLICT = null;
            public static final Result INCOMPATIBLE = null;
            public static final Result OVERRIDABLE = null;

            static {
                Result r5 = new Result("OVERRIDABLE", 0);
                OVERRIDABLE = r5;
                Result r10 = new Result("INCOMPATIBLE", 1);
                INCOMPATIBLE = r10;
                Result r11 = new Result("CONFLICT", 2);
                CONFLICT = r11;
                $VALUES = new Result[]{r5, r10, r11};
            }

            private Result(String r5, int r10) {
                super(r5, r10);
            }

            public static Result valueOf(String r5) {
                return (Result) Enum.valueOf(Result.class, r5);
            }

            public static Result[] values() {
                return (Result[]) $VALUES.clone();
            }
        }

        private static /* synthetic */ void $$$reportNull$$$0(int r10) {
            if (r10 == 1) goto L8;
            if (r10 == 2) goto L8;
            if (r10 == 3) goto L8;
            if (r10 == 4) goto L8;
            String r5 = "@NotNull method %s.%s must not return null";
        L9:
            if (r10 == 1) goto L14;
            if (r10 == 2) goto L14;
            if (r10 == 3) goto L14;
            if (r10 == 4) goto L14;
            int r11 = 2;
        L15:
            Object[] r12 = new Object[r11];
            if (r10 == 1) goto L22;
            if (r10 == 2) goto L22;
            if (r10 == 3) goto L21;
            if (r10 == 4) goto L22;
            r12[0] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
        L23:
            switch(r10) {
                case 1: goto L27;
                case 2: goto L27;
                case 3: goto L27;
                case 4: goto L27;
                case 5: goto L26;
                case 6: goto L25;
                default: goto L24;
            };
        L24:
            r12[1] = "success";
        L28:
            if (r10 == 1) goto L35;
            if (r10 == 2) goto L34;
            if (r10 == 3) goto L33;
            if (r10 == 4) goto L33;
        L36:
            String r13 = String.format(r5, r12);
            if (r10 == 1) goto L43;
            if (r10 == 2) goto L43;
            if (r10 == 3) goto L43;
            if (r10 == 4) goto L43;
            throw new IllegalStateException(r13);
        L43:
            throw new IllegalArgumentException(r13);
        L33:
            r12[2] = "<init>";
            goto L36
        L34:
            r12[2] = "conflict";
            goto L36
        L35:
            r12[2] = "incompatible";
            goto L36
        L25:
            r12[1] = "getDebugMessage";
            goto L28
        L26:
            r12[1] = "getResult";
            goto L28
        L27:
            r12[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
            goto L28
        L21:
            r12[0] = "success";
        L22:
            r12[0] = "debugMessage";
        L14:
            r11 = 3;
        L8:
            r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            goto L9
        }

        static {
            SUCCESS = new OverrideCompatibilityInfo(Result.OVERRIDABLE, "SUCCESS");
        }

        public OverrideCompatibilityInfo(Result r5, String r10) {
            if (r5 != null) goto L4;
            $$$reportNull$$$0(3);
        L4:
            if (r10 != null) goto L6;
            $$$reportNull$$$0(4);
        L6:
            this.overridable = r5;
            this.debugMessage = r10;
        }

        public static OverrideCompatibilityInfo conflict(String r5) {
            if (r5 != null) goto L5;
            $$$reportNull$$$0(2);
        L5:
            return new OverrideCompatibilityInfo(Result.CONFLICT, r5);
        }

        public static OverrideCompatibilityInfo incompatible(String r5) {
            if (r5 != null) goto L5;
            $$$reportNull$$$0(1);
        L5:
            return new OverrideCompatibilityInfo(Result.INCOMPATIBLE, r5);
        }

        public static OverrideCompatibilityInfo success() {
            OverrideCompatibilityInfo r5 = SUCCESS;
            if (r5 != null) goto L5;
            $$$reportNull$$$0(0);
        L5:
            return r5;
        }

        public Result getResult() {
            Result r5 = this.overridable;
            if (r5 != null) goto L5;
            $$$reportNull$$$0(5);
        L5:
            return r5;
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int r24) {
        if (r24 == 11) goto L17;
        if (r24 == 12) goto L17;
        if (r24 == 16) goto L17;
        if (r24 == 21) goto L17;
        if (r24 == 95) goto L17;
        if (r24 == 98) goto L17;
        if (r24 == 103) goto L17;
        if (r24 == 44) goto L17;
        if (r24 == 45) goto L17;
        switch(r24) {
            case 24: goto L17;
            case 25: goto L17;
            case 26: goto L17;
            case 27: goto L17;
            case 28: goto L17;
            case 29: goto L17;
            default: goto L13;
        };
    L13:
        switch(r24) {
            case 32: goto L17;
            case 33: goto L17;
            case 34: goto L17;
            case 35: goto L17;
            case 36: goto L17;
            case 37: goto L17;
            case 38: goto L17;
            case 39: goto L17;
            default: goto L14;
        };
    L14:
        switch(r24) {
            case 80: goto L17;
            case 81: goto L17;
            case 82: goto L17;
            case 83: goto L17;
            case 84: goto L17;
            default: goto L15;
        };
    L15:
        switch(r24) {
            case 90: goto L17;
            case 91: goto L17;
            case 92: goto L17;
            default: goto L16;
        };
    L16:
        String r10 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L19:
        if (r24 == 11) goto L33;
        if (r24 == 12) goto L157;
        if (r24 == 16) goto L158;
        if (r24 == 21) goto L159;
        if (r24 == 95) goto L160;
        if (r24 == 98) goto L161;
        if (r24 == 103) goto L162;
        if (r24 == 44) goto L163;
        if (r24 == 45) goto L164;
        switch(r24) {
            case 24: goto L165;
            case 25: goto L165;
            case 26: goto L165;
            case 27: goto L165;
            case 28: goto L165;
            case 29: goto L165;
            default: goto L29;
        };
    L29:
        switch(r24) {
            case 32: goto L166;
            case 33: goto L166;
            case 34: goto L166;
            case 35: goto L166;
            case 36: goto L166;
            case 37: goto L166;
            case 38: goto L166;
            case 39: goto L166;
            default: goto L30;
        };
    L30:
        switch(r24) {
            case 80: goto L167;
            case 81: goto L167;
            case 82: goto L167;
            case 83: goto L167;
            case 84: goto L167;
            default: goto L31;
        };
    L31:
        switch(r24) {
            case 90: goto L168;
            case 91: goto L168;
            case 92: goto L168;
            default: goto L32;
        };
    L32:
        int r12 = 3;
    L34:
        Object[] r13 = new Object[r12];
        switch(r24) {
            case 1: goto L80;
            case 2: goto L79;
            case 3: goto L36;
            case 4: goto L78;
            case 5: goto L77;
            case 6: goto L36;
            case 7: goto L80;
            case 8: goto L76;
            case 9: goto L76;
            case 10: goto L75;
            case 11: goto L74;
            case 12: goto L74;
            case 13: goto L73;
            case 14: goto L72;
            case 15: goto L71;
            case 16: goto L74;
            case 17: goto L71;
            case 18: goto L70;
            case 19: goto L69;
            case 20: goto L68;
            case 21: goto L74;
            case 22: goto L69;
            case 23: goto L68;
            case 24: goto L74;
            case 25: goto L74;
            case 26: goto L74;
            case 27: goto L74;
            case 28: goto L74;
            case 29: goto L74;
            case 30: goto L69;
            case 31: goto L68;
            case 32: goto L74;
            case 33: goto L74;
            case 34: goto L74;
            case 35: goto L74;
            case 36: goto L74;
            case 37: goto L74;
            case 38: goto L74;
            case 39: goto L74;
            case 40: goto L69;
            case 41: goto L68;
            case 42: goto L67;
            case 43: goto L66;
            case 44: goto L74;
            case 45: goto L74;
            case 46: goto L65;
            case 47: goto L64;
            case 48: goto L63;
            case 49: goto L62;
            case 50: goto L61;
            case 51: goto L63;
            case 52: goto L60;
            case 53: goto L59;
            case 54: goto L58;
            case 55: goto L57;
            case 56: goto L56;
            case 57: goto L55;
            case 58: goto L54;
            case 59: goto L53;
            case 60: goto L52;
            case 61: goto L57;
            case 62: goto L56;
            case 63: goto L51;
            case 64: goto L57;
            case 65: goto L51;
            case 66: goto L56;
            case 67: goto L50;
            case 68: goto L49;
            case 69: goto L50;
            case 70: goto L49;
            case 71: goto L48;
            case 72: goto L47;
            case 73: goto L50;
            case 74: goto L46;
            case 75: goto L49;
            case 76: goto L45;
            case 77: goto L63;
            case 78: goto L44;
            case 79: goto L43;
            case 80: goto L74;
            case 81: goto L74;
            case 82: goto L74;
            case 83: goto L74;
            case 84: goto L74;
            case 85: goto L44;
            case 86: goto L57;
            case 87: goto L56;
            case 88: goto L47;
            case 89: goto L57;
            case 90: goto L74;
            case 91: goto L74;
            case 92: goto L74;
            case 93: goto L47;
            case 94: goto L42;
            case 95: goto L74;
            case 96: goto L57;
            case 97: goto L41;
            case 98: goto L74;
            case 99: goto L40;
            case 100: goto L39;
            case 101: goto L43;
            case 102: goto L38;
            case 103: goto L74;
            case 104: goto L40;
            case 105: goto L39;
            case 106: goto L56;
            case 107: goto L37;
            case 108: goto L37;
            case 109: goto L47;
            default: goto L36;
        };
    L36:
        r13[0] = "kotlinTypeRefiner";
    L82:
        if (r24 == 11) goto L105;
        if (r24 == 12) goto L105;
        if (r24 == 16) goto L104;
        if (r24 == 21) goto L103;
        if (r24 == 95) goto L102;
        if (r24 == 98) goto L101;
        if (r24 == 103) goto L100;
        if (r24 == 44) goto L99;
        if (r24 == 45) goto L99;
        switch(r24) {
            case 24: goto L103;
            case 25: goto L103;
            case 26: goto L103;
            case 27: goto L103;
            case 28: goto L103;
            case 29: goto L103;
            default: goto L92;
        };
    L92:
        switch(r24) {
            case 32: goto L98;
            case 33: goto L98;
            case 34: goto L98;
            case 35: goto L98;
            case 36: goto L98;
            case 37: goto L98;
            case 38: goto L98;
            case 39: goto L98;
            default: goto L93;
        };
    L93:
        switch(r24) {
            case 80: goto L97;
            case 81: goto L97;
            case 82: goto L97;
            case 83: goto L97;
            case 84: goto L97;
            default: goto L94;
        };
    L94:
        switch(r24) {
            case 90: goto L96;
            case 91: goto L96;
            case 92: goto L96;
            default: goto L95;
        };
    L95:
        r13[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
    L106:
        switch(r24) {
            case 1: goto L139;
            case 2: goto L139;
            case 3: goto L138;
            case 4: goto L138;
            case 5: goto L137;
            case 6: goto L137;
            case 7: goto L137;
            case 8: goto L136;
            case 9: goto L135;
            case 10: goto L135;
            case 11: goto L140;
            case 12: goto L140;
            case 13: goto L134;
            case 14: goto L134;
            case 15: goto L133;
            case 16: goto L140;
            case 17: goto L132;
            case 18: goto L132;
            case 19: goto L131;
            case 20: goto L131;
            case 21: goto L140;
            case 22: goto L131;
            case 23: goto L131;
            case 24: goto L140;
            case 25: goto L140;
            case 26: goto L140;
            case 27: goto L140;
            case 28: goto L140;
            case 29: goto L140;
            case 30: goto L130;
            case 31: goto L130;
            case 32: goto L140;
            case 33: goto L140;
            case 34: goto L140;
            case 35: goto L140;
            case 36: goto L140;
            case 37: goto L140;
            case 38: goto L140;
            case 39: goto L140;
            case 40: goto L129;
            case 41: goto L129;
            case 42: goto L128;
            case 43: goto L128;
            case 44: goto L140;
            case 45: goto L140;
            case 46: goto L127;
            case 47: goto L127;
            case 48: goto L127;
            case 49: goto L126;
            case 50: goto L126;
            case 51: goto L126;
            case 52: goto L125;
            case 53: goto L125;
            case 54: goto L125;
            case 55: goto L125;
            case 56: goto L125;
            case 57: goto L124;
            case 58: goto L124;
            case 59: goto L123;
            case 60: goto L123;
            case 61: goto L123;
            case 62: goto L123;
            case 63: goto L122;
            case 64: goto L121;
            case 65: goto L121;
            case 66: goto L121;
            case 67: goto L120;
            case 68: goto L120;
            case 69: goto L119;
            case 70: goto L119;
            case 71: goto L118;
            case 72: goto L118;
            case 73: goto L117;
            case 74: goto L117;
            case 75: goto L117;
            case 76: goto L117;
            case 77: goto L117;
            case 78: goto L116;
            case 79: goto L116;
            case 80: goto L140;
            case 81: goto L140;
            case 82: goto L140;
            case 83: goto L140;
            case 84: goto L140;
            case 85: goto L115;
            case 86: goto L115;
            case 87: goto L115;
            case 88: goto L114;
            case 89: goto L114;
            case 90: goto L140;
            case 91: goto L140;
            case 92: goto L140;
            case 93: goto L113;
            case 94: goto L113;
            case 95: goto L140;
            case 96: goto L112;
            case 97: goto L112;
            case 98: goto L140;
            case 99: goto L111;
            case 100: goto L111;
            case 101: goto L111;
            case 102: goto L111;
            case 103: goto L140;
            case 104: goto L111;
            case 105: goto L111;
            case 106: goto L111;
            case 107: goto L110;
            case 108: goto L109;
            case 109: goto L108;
            default: goto L107;
        };
    L107:
        r13[2] = "createWithTypeRefiner";
        goto L140
    L108:
        r13[2] = "findMaxVisibility";
        goto L140
    L109:
        r13[2] = "computeVisibilityToInherit";
        goto L140
    L110:
        r13[2] = "resolveUnknownVisibilityForMember";
        goto L140
    L111:
        r13[2] = "extractMembersOverridableInBothWays";
        goto L140
    L112:
        r13[2] = "filterVisibleFakeOverrides";
        goto L140
    L113:
        r13[2] = "getMinimalModality";
        goto L140
    L114:
        r13[2] = "determineModalityForFakeOverride";
        goto L140
    L115:
        r13[2] = "createAndBindFakeOverride";
        goto L140
    L116:
        r13[2] = "selectMostSpecificMember";
        goto L140
    L117:
        r13[2] = "isReturnTypeMoreSpecific";
        goto L140
    L118:
        r13[2] = "isMoreSpecificThenAllOf";
        goto L140
    L119:
        r13[2] = "isVisibilityMoreSpecific";
        goto L140
    L120:
        r13[2] = "isMoreSpecific";
        goto L140
    L121:
        r13[2] = "createAndBindFakeOverrides";
        goto L140
    L122:
        r13[2] = "allHasSameContainingDeclaration";
        goto L140
    L123:
        r13[2] = "extractAndBindOverridesForMember";
        goto L140
    L124:
        r13[2] = "isVisibleForOverride";
        goto L140
    L125:
        r13[2] = "generateOverridesInFunctionGroup";
        goto L140
    L126:
        r13[2] = "areTypeParametersEquivalent";
        goto L140
    L127:
        r13[2] = "areTypesEquivalent";
        goto L140
    L128:
        r13[2] = "createTypeCheckerState";
        goto L140
    L129:
        r13[2] = "getBasicOverridabilityProblem";
        goto L140
    L130:
        r13[2] = "isOverridableByWithoutExternalConditions";
        goto L140
    L131:
        r13[2] = "isOverridableBy";
        goto L140
    L132:
        r13[2] = "collectOverriddenDeclarations";
        goto L140
    L133:
        r13[2] = "getOverriddenDeclarations";
        goto L140
    L134:
        r13[2] = "overrides";
        goto L140
    L135:
        r13[2] = "filterOverrides";
        goto L140
    L136:
        r13[2] = "filterOutOverridden";
        goto L140
    L137:
        r13[2] = "<init>";
        goto L140
    L138:
        r13[2] = "create";
        goto L140
    L139:
        r13[2] = "createWithTypePreparatorAndCustomSubtype";
    L140:
        String r11 = String.format(r10, r13);
        if (r24 == 11) goto L156;
        if (r24 == 12) goto L156;
        if (r24 == 16) goto L156;
        if (r24 == 21) goto L156;
        if (r24 == 95) goto L156;
        if (r24 == 98) goto L156;
        if (r24 == 103) goto L156;
        if (r24 == 44) goto L156;
        if (r24 == 45) goto L156;
        switch(r24) {
            case 24: goto L156;
            case 25: goto L156;
            case 26: goto L156;
            case 27: goto L156;
            case 28: goto L156;
            case 29: goto L156;
            default: goto L151;
        };
    L151:
        switch(r24) {
            case 32: goto L156;
            case 33: goto L156;
            case 34: goto L156;
            case 35: goto L156;
            case 36: goto L156;
            case 37: goto L156;
            case 38: goto L156;
            case 39: goto L156;
            default: goto L152;
        };
    L152:
        switch(r24) {
            case 80: goto L156;
            case 81: goto L156;
            case 82: goto L156;
            case 83: goto L156;
            case 84: goto L156;
            default: goto L153;
        };
    L153:
        switch(r24) {
            case 90: goto L156;
            case 91: goto L156;
            case 92: goto L156;
            default: goto L169;
        };
    L169:
        throw new IllegalArgumentException(r11);
    L156:
        throw new IllegalStateException(r11);
    L96:
        r13[1] = "determineModalityForFakeOverride";
        goto L106
    L97:
        r13[1] = "selectMostSpecificMember";
        goto L106
    L98:
        r13[1] = "isOverridableByWithoutExternalConditions";
    L99:
        r13[1] = "createTypeCheckerState";
        goto L106
    L100:
        r13[1] = "extractMembersOverridableInBothWays";
        goto L106
    L101:
        r13[1] = "filterVisibleFakeOverrides";
        goto L106
    L102:
        r13[1] = "getMinimalModality";
    L103:
        r13[1] = "isOverridableBy";
        goto L106
    L104:
        r13[1] = "getOverriddenDeclarations";
    L105:
        r13[1] = "filterOverrides";
        goto L106
    L37:
        r13[0] = "memberDescriptor";
        goto L82
    L38:
        r13[0] = "onConflict";
        goto L82
    L39:
        r13[0] = "extractFrom";
        goto L82
    L40:
        r13[0] = "overrider";
        goto L82
    L41:
        r13[0] = "toFilter";
        goto L82
    L42:
        r13[0] = "classModality";
        goto L82
    L43:
        r13[0] = "descriptorByHandle";
        goto L82
    L44:
        r13[0] = "overridables";
        goto L82
    L45:
        r13[0] = "bReturnType";
        goto L82
    L46:
        r13[0] = "aReturnType";
        goto L82
    L47:
        r13[0] = "descriptors";
        goto L82
    L48:
        r13[0] = "candidate";
        goto L82
    L49:
        r13[0] = "b";
        goto L82
    L50:
        r13[0] = "a";
        goto L82
    L51:
        r13[0] = "notOverridden";
        goto L82
    L52:
        r13[0] = "descriptorsFromSuper";
        goto L82
    L53:
        r13[0] = "fromCurrent";
        goto L82
    L54:
        r13[0] = "fromSuper";
        goto L82
    L55:
        r13[0] = "overriding";
        goto L82
    L56:
        r13[0] = "strategy";
        goto L82
    L57:
        r13[0] = "current";
        goto L82
    L58:
        r13[0] = "membersFromCurrent";
        goto L82
    L59:
        r13[0] = "membersFromSupertypes";
        goto L82
    L60:
        r13[0] = "name";
        goto L82
    L61:
        r13[0] = "subTypeParameter";
        goto L82
    L62:
        r13[0] = "superTypeParameter";
        goto L82
    L63:
        r13[0] = "typeCheckerState";
        goto L82
    L64:
        r13[0] = "typeInSub";
        goto L82
    L65:
        r13[0] = "typeInSuper";
        goto L82
    L66:
        r13[0] = "secondParameters";
        goto L82
    L67:
        r13[0] = "firstParameters";
        goto L82
    L68:
        r13[0] = "subDescriptor";
        goto L82
    L69:
        r13[0] = "superDescriptor";
        goto L82
    L70:
        r13[0] = "result";
        goto L82
    L71:
        r13[0] = "descriptor";
        goto L82
    L72:
        r13[0] = "g";
        goto L82
    L73:
        r13[0] = "f";
        goto L82
    L74:
        r13[0] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
        goto L82
    L75:
        r13[0] = "transformFirst";
        goto L82
    L76:
        r13[0] = "candidateSet";
        goto L82
    L77:
        r13[0] = "axioms";
        goto L82
    L78:
        r13[0] = "equalityAxioms";
        goto L82
    L79:
        r13[0] = "customSubtype";
        goto L82
    L80:
        r13[0] = "kotlinTypePreparator";
        goto L82
    L168:
        r12 = 2;
        goto L34
    L167:
        r12 = 2;
        goto L34
    L166:
        r12 = 2;
        goto L34
    L165:
        r12 = 2;
        goto L34
    L164:
        r12 = 2;
        goto L34
    L163:
        r12 = 2;
        goto L34
    L162:
        r12 = 2;
        goto L34
    L161:
        r12 = 2;
        goto L34
    L160:
        r12 = 2;
        goto L34
    L159:
        r12 = 2;
        goto L34
    L158:
        r12 = 2;
        goto L34
    L157:
        r12 = 2;
        goto L34
    L33:
        r12 = 2;
    L17:
        r10 = "@NotNull method %s.%s must not return null";
        goto L19
    }

    static {
        EXTERNAL_CONDITIONS = CollectionsKt.toList(ServiceLoader.load(ExternalOverridabilityCondition.class, ExternalOverridabilityCondition.class.getClassLoader()));
        KotlinTypeChecker.TypeConstructorEquality r5 = new AnonymousClass1();
        DEFAULT_TYPE_CONSTRUCTOR_EQUALITY = r5;
        DEFAULT = new OverridingUtil(r5, KotlinTypeRefiner.Default.INSTANCE, KotlinTypePreparator.Default.INSTANCE, null);
    }

    private OverridingUtil(KotlinTypeChecker.TypeConstructorEquality r5, KotlinTypeRefiner r10, KotlinTypePreparator r11, Function2<KotlinType, KotlinType, Boolean> r12) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(5);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(6);
    L6:
        if (r11 != null) goto L8;
        $$$reportNull$$$0(7);
    L8:
        this.equalityAxioms = r5;
        this.kotlinTypeRefiner = r10;
        this.kotlinTypePreparator = r11;
        this.customSubtype = r12;
    }

    private static boolean allHasSameContainingDeclaration(Collection<CallableMemberDescriptor> r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(63);
    L5:
        if (r5.size() >= 2) goto L8;
        return true;
    L8:
        final DeclarationDescriptor r10 = r5.iterator().next().getContainingDeclaration();
        Collection<CallableMemberDescriptor> r11 = r5;
        return CollectionsKt.d(r11, new AnonymousClass3(r10));
    }

    private static boolean areTypeParametersEquivalent(TypeParameterDescriptor r5, TypeParameterDescriptor r10, TypeCheckerState r11) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(49);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(50);
    L6:
        if (r11 != null) goto L8;
        $$$reportNull$$$0(51);
    L8:
        List<KotlinType> r12 = r5.getUpperBounds();
        ArrayList r13 = new ArrayList(r10.getUpperBounds());
        if (r12.size() == r13.size()) goto L11;
        return false;
    L11:
        Iterator<KotlinType> r14 = r12.iterator();
    L13:
        if (r14.hasNext() == false) goto L21;
        KotlinType r15 = r14.next();
        ListIterator r16 = r13.listIterator();
    L16:
        if (r16.hasNext() == false) goto L20;
        if (areTypesEquivalent(r15, (KotlinType) r16.next(), r11) == false) goto L16;
        r16.remove();
        goto L13
    L20:
        return false;
    L21:
        return true;
    }

    private static boolean areTypesEquivalent(KotlinType r5, KotlinType r10, TypeCheckerState r11) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(46);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(47);
    L6:
        if (r11 != null) goto L9;
        $$$reportNull$$$0(48);
    L9:
        if (KotlinTypeKt.isError(r5) == false) goto L15;
        if (KotlinTypeKt.isError(r10) == false) goto L15;
        return true;
    L15:
        return AbstractTypeChecker.INSTANCE.equalTypes(r11, r5.unwrap(), r10.unwrap());
    }

    private static OverrideCompatibilityInfo checkReceiverAndParameterCount(CallableDescriptor r5, CallableDescriptor r10) {
        boolean r11 = false;
        if (r5.getExtensionReceiverParameter() != null) goto L5;
        boolean r12 = true;
    L7:
        if (r10.getExtensionReceiverParameter() != null) goto L9;
        r11 = true;
    L9:
        if (r12 == r11) goto L13;
        return OverrideCompatibilityInfo.incompatible("Receiver presence mismatch");
    L13:
        if (r5.getValueParameters().size() != r10.getValueParameters().size()) goto L15;
        return null;
    L15:
        return OverrideCompatibilityInfo.incompatible("Value parameter number mismatch");
    L5:
        r12 = false;
        goto L7
    }

    private static void collectOverriddenDeclarations(CallableMemberDescriptor r5, Set<CallableMemberDescriptor> r10) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(17);
    L4:
        if (r10 != null) goto L7;
        $$$reportNull$$$0(18);
    L7:
        if (r5.getKind().isReal() == false) goto L10;
        r10.add(r5);
        return;
    L10:
        if (r5.getOverriddenDescriptors().isEmpty() == true) goto L17;
        Iterator<? extends CallableMemberDescriptor> r11 = r5.getOverriddenDescriptors().iterator();
    L13:
        if (r11.hasNext() == false) goto L19;
        collectOverriddenDeclarations(r11.next(), r10);
        goto L13
    L19:
        return;
    L17:
        throw new IllegalStateException("No overridden descriptors found for (fake override) " + r5);
    }

    private static List<KotlinType> compiledValueParameters(CallableDescriptor r5) {
        ReceiverParameterDescriptor r10 = r5.getExtensionReceiverParameter();
        ArrayList r11 = new ArrayList();
        if (r10 == null) goto L5;
        r11.add(r10.getType());
    L5:
        Iterator<ValueParameterDescriptor> r12 = r5.getValueParameters().iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        r11.add(r12.next().getType());
        goto L7
    L9:
        return r11;
    }

    private static DescriptorVisibility computeVisibilityToInherit(CallableMemberDescriptor r5) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(108);
    L4:
        Collection<? extends CallableMemberDescriptor> r10 = r5.getOverriddenDescriptors();
        DescriptorVisibility r11 = findMaxVisibility(r10);
        if (r11 != null) goto L8;
        return null;
    L8:
        if (r5.getKind() != CallableMemberDescriptor.Kind.FAKE_OVERRIDE) goto L19;
        Iterator<? extends CallableMemberDescriptor> r12 = r10.iterator();
    L11:
        if (r12.hasNext() == false) goto L17;
        CallableMemberDescriptor r13 = r12.next();
        if (r13.getModality() == Modality.ABSTRACT) goto L11;
        if (r13.getVisibility().equals(r11) == true) goto L11;
        return null;
    L17:
        return r11;
    L19:
        return r11.normalize();
    }

    public static OverridingUtil create(KotlinTypeRefiner r5, KotlinTypeChecker.TypeConstructorEquality r10) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(3);
    L4:
        if (r10 != null) goto L7;
        $$$reportNull$$$0(4);
    L7:
        return new OverridingUtil(r10, r5, KotlinTypePreparator.Default.INSTANCE, null);
    }

    private static void createAndBindFakeOverride(Collection<CallableMemberDescriptor> r10, ClassDescriptor r11, OverridingStrategy r12) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(85);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(86);
    L6:
        if (r12 != null) goto L8;
        $$$reportNull$$$0(87);
    L8:
        Collection<CallableMemberDescriptor> r5 = filterVisibleFakeOverrides(r11, r10);
        boolean r13 = r5.isEmpty();
        if (r13 == true) goto L12;
        r10 = r5;
    L12:
        Modality r14 = determineModalityForFakeOverride(r10, r11);
        if (r13 == false) goto L16;
        DescriptorVisibility r15 = DescriptorVisibilities.INVISIBLE_FAKE;
    L15:
        DescriptorVisibility r16 = r15;
        CallableMemberDescriptor r17 = ((CallableMemberDescriptor) selectMostSpecificMember(r10, new AnonymousClass4())).copy(r11, r14, r16, CallableMemberDescriptor.Kind.FAKE_OVERRIDE, false);
        r12.setOverriddenDescriptors(r17, r10);
        r12.addFakeOverride(r17);
        return;
    L16:
        r15 = DescriptorVisibilities.INHERITED;
        goto L15
    }

    private static void createAndBindFakeOverrides(ClassDescriptor r5, Collection<CallableMemberDescriptor> r10, OverridingStrategy r11) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(64);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(65);
    L6:
        if (r11 != null) goto L9;
        $$$reportNull$$$0(66);
    L9:
        if (allHasSameContainingDeclaration(r10) == false) goto L15;
        Iterator<CallableMemberDescriptor> r12 = r10.iterator();
    L12:
        if (r12.hasNext() == false) goto L14;
        createAndBindFakeOverride(Collections.singleton(r12.next()), r5, r11);
        goto L12
    L14:
        return;
    L15:
        LinkedList r13 = new LinkedList(r10);
    L17:
        if (r13.isEmpty() == true) goto L19;
        createAndBindFakeOverride(extractMembersOverridableInBothWays(VisibilityUtilKt.findMemberWithMaxVisibility(r13), r13, r11), r5, r11);
        goto L17
    }

    private TypeCheckerState createTypeCheckerState(List<TypeParameterDescriptor> r10, List<TypeParameterDescriptor> r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(42);
    L4:
        if (r11 != null) goto L7;
        $$$reportNull$$$0(43);
    L7:
        if (r10.isEmpty() == false) goto L12;
        TypeCheckerState r12 = new OverridingUtilTypeSystemContext(null, this.equalityAxioms, this.kotlinTypeRefiner, this.kotlinTypePreparator, this.customSubtype).newTypeCheckerState(true, true);
        if (r12 != null) goto L11;
        $$$reportNull$$$0(44);
    L11:
        return r12;
    L12:
        HashMap r5 = new HashMap();
        int r13 = 0;
    L14:
        if (r13 >= r10.size()) goto L16;
        r5.put(r10.get(r13).getTypeConstructor(), r11.get(r13).getTypeConstructor());
        r13 = r13 + 1;
        goto L14
    L16:
        TypeCheckerState r14 = new OverridingUtilTypeSystemContext(r5, this.equalityAxioms, this.kotlinTypeRefiner, this.kotlinTypePreparator, this.customSubtype).newTypeCheckerState(true, true);
        if (r14 != null) goto L19;
        $$$reportNull$$$0(45);
    L19:
        return r14;
    }

    public static OverridingUtil createWithTypeRefiner(KotlinTypeRefiner r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(0);
    L5:
        return new OverridingUtil(DEFAULT_TYPE_CONSTRUCTOR_EQUALITY, r5, KotlinTypePreparator.Default.INSTANCE, null);
    }

    private static Modality determineModalityForFakeOverride(Collection<CallableMemberDescriptor> r10, ClassDescriptor r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(88);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(89);
    L6:
        Iterator<CallableMemberDescriptor> r5 = r10.iterator();
        boolean r12 = false;
        boolean r13 = false;
        boolean r14 = false;
    L8:
        if (r5.hasNext() == false) goto L27;
        CallableMemberDescriptor r15 = r5.next();
        int r16 = AnonymousClass8.$SwitchMap$org$jetbrains$kotlin$descriptors$Modality[r15.getModality().ordinal()];
        if (r16 == 1) goto L22;
        if (r16 == 2) goto L21;
        if (r16 != 3) goto L16;
        r13 = true;
        goto L8
    L16:
        if (r16 != 4) goto L8;
        r14 = true;
        goto L8
    L21:
        throw new IllegalStateException("Member cannot have SEALED modality: " + r15);
    L22:
        Modality r17 = Modality.FINAL;
        if (r17 != null) goto L25;
        $$$reportNull$$$0(90);
    L25:
        return r17;
    L27:
        if (r11.isExpect() == true) goto L29;
    L33:
        if (r13 == false) goto L39;
        if (r14 == true) goto L39;
        Modality r18 = Modality.OPEN;
        if (r18 != null) goto L38;
        $$$reportNull$$$0(91);
    L38:
        return r18;
    L39:
        if (r13 == true) goto L47;
        if (r14 == false) goto L47;
        if (r12 == false) goto L43;
        Modality r19 = r11.getModality();
    L44:
        if (r19 != null) goto L46;
        $$$reportNull$$$0(92);
    L46:
        return r19;
    L43:
        r19 = Modality.ABSTRACT;
    L47:
        HashSet r20 = new HashSet();
        Iterator<CallableMemberDescriptor> r21 = r10.iterator();
    L49:
        if (r21.hasNext() == false) goto L52;
        r20.addAll(getOverriddenDeclarations(r21.next()));
        goto L49
    L52:
        return getMinimalModality(filterOutOverridden(r20), r12, r11.getModality());
    L29:
        if (r11.getModality() == Modality.ABSTRACT) goto L33;
        if (r11.getModality() == Modality.SEALED) goto L33;
        r12 = true;
        goto L33
    }

    private Collection<CallableMemberDescriptor> extractAndBindOverridesForMember(CallableMemberDescriptor r10, Collection<? extends CallableMemberDescriptor> r11, ClassDescriptor r12, OverridingStrategy r13) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(59);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(60);
    L6:
        if (r12 != null) goto L8;
        $$$reportNull$$$0(61);
    L8:
        if (r13 != null) goto L10;
        $$$reportNull$$$0(62);
    L10:
        ArrayList r5 = new ArrayList(r11.size());
        SmartSet r14 = SmartSet.create();
        Iterator<? extends CallableMemberDescriptor> r15 = r11.iterator();
    L12:
        if (r15.hasNext() == false) goto L24;
        CallableMemberDescriptor r16 = r15.next();
        OverrideCompatibilityInfo.Result r17 = isOverridableBy(r16, r10, r12).getResult();
        boolean r18 = isVisibleForOverride(r10, r16, false);
        int r19 = AnonymousClass8.$SwitchMap$org$jetbrains$kotlin$resolve$OverridingUtil$OverrideCompatibilityInfo$Result[r17.ordinal()];
        if (r19 != 1) goto L16;
        if (r18 == false) goto L23;
        r14.add(r16);
    L23:
        r5.add(r16);
        goto L12
    L16:
        if (r19 != 2) goto L12;
        if (r18 == false) goto L20;
        r13.overrideConflict(r16, r10);
    L20:
        r5.add(r16);
        goto L12
    L24:
        r13.setOverriddenDescriptors(r10, r14);
        return r5;
    }

    public static <H> Collection<H> extractMembersOverridableInBothWays(H r5, Collection<H> r10, Function1<H, CallableDescriptor> r11, Function1<H, Unit> r12) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(99);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(100);
    L6:
        if (r11 != null) goto L8;
        $$$reportNull$$$0(101);
    L8:
        if (r12 != null) goto L10;
        $$$reportNull$$$0(102);
    L10:
        ArrayList r13 = new ArrayList();
        r13.add(r5);
        CallableDescriptor r14 = r11.invoke(r5);
        Iterator<H> r15 = r10.iterator();
    L12:
        if (r15.hasNext() == false) goto L22;
        H r16 = r15.next();
        CallableDescriptor r17 = r11.invoke(r16);
        if (r5 == r16) goto L15;
        OverrideCompatibilityInfo.Result r18 = getBothWaysOverridability(r14, r17);
        if (r18 == OverrideCompatibilityInfo.Result.OVERRIDABLE) goto L18;
        if (r18 != OverrideCompatibilityInfo.Result.CONFLICT) goto L12;
        r12.invoke(r16);
        r15.remove();
        goto L12
    L18:
        r13.add(r16);
        r15.remove();
        goto L12
    L15:
        r15.remove();
        goto L12
    L22:
        return r13;
    }

    public static <D extends CallableDescriptor> Set<D> filterOutOverridden(Set<D> r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(8);
    L5:
        if (r5.isEmpty() == false) goto L7;
    L9:
        boolean r10 = false;
    L11:
        return filterOverrides(r5, r10, null, new AnonymousClass2());
    L7:
        if (DescriptorUtilsKt.isTypeRefinementEnabled(DescriptorUtilsKt.getModule(r5.iterator().next())) == false) goto L9;
        r10 = true;
        goto L11
    }

    public static <D> Set<D> filterOverrides(Set<D> r10, boolean r11, Function0<?> r12, Function2<? super D, ? super D, Pair<CallableDescriptor, CallableDescriptor>> r13) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(9);
    L4:
        if (r13 != null) goto L7;
        $$$reportNull$$$0(10);
    L7:
        if (r10.size() > 1) goto L9;
        return r10;
    L9:
        LinkedHashSet r5 = new LinkedHashSet();
        Iterator<D> r14 = r10.iterator();
    L11:
        if (r14.hasNext() == false) goto L25;
        Object r15 = r14.next();
        if (r12 == null) goto L15;
        r12.invoke();
    L15:
        Iterator r16 = r5.iterator();
    L17:
        if (r16.hasNext() == false) goto L24;
        Pair<CallableDescriptor, CallableDescriptor> r17 = r13.mo2invoke(r15, (Object) r16.next());
        CallableDescriptor r18 = r17.component1();
        CallableDescriptor r19 = r17.component2();
        if (overrides(r18, r19, r11, true) == true) goto L20;
        if (overrides(r19, r18, r11, true) == false) goto L17;
    L20:
        r16.remove();
        goto L17
    L24:
        r5.add(r15);
        goto L11
    L25:
        return r5;
    }

    private static Collection<CallableMemberDescriptor> filterVisibleFakeOverrides(final ClassDescriptor r5, Collection<CallableMemberDescriptor> r10) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(96);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(97);
    L6:
        List r11 = CollectionsKt.filter(r10, new AnonymousClass5(r5));
        if (r11 != null) goto L9;
        $$$reportNull$$$0(98);
    L9:
        return r11;
    }

    public static DescriptorVisibility findMaxVisibility(Collection<? extends CallableMemberDescriptor> r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(109);
    L5:
        if (r5.isEmpty() == true) goto L7;
        Iterator<? extends CallableMemberDescriptor> r10 = r5.iterator();
    L9:
        DescriptorVisibility r11 = null;
    L11:
        if (r10.hasNext() == false) goto L21;
        DescriptorVisibility r12 = r10.next().getVisibility();
        if (r11 == null) goto L14;
        Integer r13 = DescriptorVisibilities.compare(r12, r11);
        if (r13 == null) goto L9;
        if (r13.intValue() <= 0) goto L11;
    L14:
        r11 = r12;
        goto L11
    L21:
        if (r11 != null) goto L23;
        return null;
    L23:
        Iterator<? extends CallableMemberDescriptor> r14 = r5.iterator();
    L25:
        if (r14.hasNext() == false) goto L31;
        Integer r15 = DescriptorVisibilities.compare(r11, r14.next().getVisibility());
        if (r15 == null) goto L30;
        if (r15.intValue() >= 0) goto L25;
    L30:
        return null;
    L31:
        return r11;
    L7:
        return DescriptorVisibilities.DEFAULT_VISIBILITY;
    }

    public static OverrideCompatibilityInfo getBasicOverridabilityProblem(CallableDescriptor r5, CallableDescriptor r10) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(40);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(41);
    L6:
        boolean r11 = r5 instanceof FunctionDescriptor;
        if (r11 == true) goto L9;
    L10:
        boolean r12 = r5 instanceof PropertyDescriptor;
        if (r12 == true) goto L13;
    L16:
        if (r11 == true) goto L22;
        if (r12 == true) goto L22;
        throw new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: " + r5);
    L22:
        if (r5.getName().equals(r10.getName()) == false) goto L24;
        OverrideCompatibilityInfo r13 = checkReceiverAndParameterCount(r5, r10);
        if (r13 == null) goto L28;
        return r13;
    L28:
        return null;
    L24:
        return OverrideCompatibilityInfo.incompatible("Name mismatch");
    L13:
        if ((r10 instanceof PropertyDescriptor) == true) goto L16;
    L15:
        return OverrideCompatibilityInfo.incompatible("Member kind mismatch");
    L9:
        if ((r10 instanceof FunctionDescriptor) == false) goto L15;
        goto L10
    }

    public static OverrideCompatibilityInfo.Result getBothWaysOverridability(CallableDescriptor r5, CallableDescriptor r10) {
        OverridingUtil r11 = DEFAULT;
        OverrideCompatibilityInfo.Result r12 = r11.isOverridableBy(r10, r5, null).getResult();
        OverrideCompatibilityInfo.Result r13 = r11.isOverridableBy(r5, r10, null).getResult();
        OverrideCompatibilityInfo.Result r14 = OverrideCompatibilityInfo.Result.OVERRIDABLE;
        if (r12 != r14) goto L6;
        if (r13 != r14) goto L6;
        return r14;
    L6:
        OverrideCompatibilityInfo.Result r15 = OverrideCompatibilityInfo.Result.CONFLICT;
        if (r12 == r15) goto L12;
        if (r13 != r15) goto L11;
        return r15;
    L11:
        return OverrideCompatibilityInfo.Result.INCOMPATIBLE;
    L12:
        return r15;
    }

    private static Modality getMinimalModality(Collection<CallableMemberDescriptor> r5, boolean r10, Modality r11) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(93);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(94);
    L6:
        Modality r12 = Modality.ABSTRACT;
        Iterator<CallableMemberDescriptor> r13 = r5.iterator();
    L8:
        if (r13.hasNext() == false) goto L18;
        CallableMemberDescriptor r14 = r13.next();
        if (r10 == true) goto L12;
    L14:
        Modality r15 = r14.getModality();
    L16:
        if (r15.compareTo(r12) >= 0) goto L8;
        r12 = r15;
        goto L8
    L12:
        if (r14.getModality() != Modality.ABSTRACT) goto L14;
        r15 = r11;
        goto L16
    L18:
        if (r12 != null) goto L20;
        $$$reportNull$$$0(95);
    L20:
        return r12;
    }

    public static Set<CallableMemberDescriptor> getOverriddenDeclarations(CallableMemberDescriptor r5) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(15);
    L4:
        LinkedHashSet r10 = new LinkedHashSet();
        collectOverriddenDeclarations(r5, r10);
        return r10;
    }

    private static boolean isAccessorMoreSpecific(PropertyAccessorDescriptor r5, PropertyAccessorDescriptor r10) {
        if (r5 == null) goto L7;
        if (r10 != null) goto L6;
        return true;
    L6:
        return isVisibilityMoreSpecific(r5, r10);
    L7:
        return true;
    }

    public static boolean isMoreSpecific(CallableDescriptor r10, CallableDescriptor r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(67);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(68);
    L6:
        KotlinType r5 = r10.getReturnType();
        KotlinType r12 = r11.getReturnType();
        if (isVisibilityMoreSpecific(r10, r11) == true) goto L9;
        return false;
    L9:
        TypeCheckerState r13 = DEFAULT.createTypeCheckerState(r10.getTypeParameters(), r11.getTypeParameters());
        if ((r10 instanceof FunctionDescriptor) == false) goto L14;
        return isReturnTypeMoreSpecific(r10, r5, r11, r12, r13);
    L14:
        if ((r10 instanceof PropertyDescriptor) == false) goto L33;
        PropertyDescriptor r14 = (PropertyDescriptor) r10;
        PropertyDescriptor r15 = (PropertyDescriptor) r11;
        if (isAccessorMoreSpecific(r14.getSetter(), r15.getSetter()) == true) goto L19;
        return false;
    L19:
        if (r14.isVar() == false) goto L25;
        if (r15.isVar() == false) goto L25;
        return AbstractTypeChecker.INSTANCE.equalTypes(r13, r5.unwrap(), r12.unwrap());
    L25:
        if (r14.isVar() == true) goto L29;
        if (r15.isVar() == false) goto L29;
        return false;
    L29:
        if (isReturnTypeMoreSpecific(r10, r5, r11, r12, r13) == false) goto L35;
        return true;
    L35:
        return false;
    L33:
        throw new IllegalArgumentException("Unexpected callable: " + r10.getClass());
    }

    private static boolean isMoreSpecificThenAllOf(CallableDescriptor r5, Collection<CallableDescriptor> r10) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(71);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(72);
    L6:
        Iterator<CallableDescriptor> r11 = r10.iterator();
    L8:
        if (r11.hasNext() == false) goto L13;
        if (isMoreSpecific(r5, r11.next()) == true) goto L8;
        return false;
    L13:
        return true;
    }

    private static boolean isReturnTypeMoreSpecific(CallableDescriptor r5, KotlinType r10, CallableDescriptor r11, KotlinType r12, TypeCheckerState r13) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(73);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(74);
    L6:
        if (r11 != null) goto L8;
        $$$reportNull$$$0(75);
    L8:
        if (r12 != null) goto L10;
        $$$reportNull$$$0(76);
    L10:
        if (r13 != null) goto L13;
        $$$reportNull$$$0(77);
    L13:
        return AbstractTypeChecker.INSTANCE.isSubtypeOf(r13, r10.unwrap(), r12.unwrap());
    }

    private static boolean isVisibilityMoreSpecific(DeclarationDescriptorWithVisibility r5, DeclarationDescriptorWithVisibility r10) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(69);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(70);
    L6:
        Integer r11 = DescriptorVisibilities.compare(r5.getVisibility(), r10.getVisibility());
        if (r11 != null) goto L9;
    L12:
        return true;
    L9:
        if (r11.intValue() >= 0) goto L12;
        return false;
    }

    public static boolean isVisibleForOverride(MemberDescriptor r5, MemberDescriptor r10, boolean r11) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(57);
    L4:
        if (r10 != null) goto L7;
        $$$reportNull$$$0(58);
    L7:
        if (DescriptorVisibilities.isPrivate(r10.getVisibility()) == false) goto L9;
    L11:
        return false;
    L9:
        if (DescriptorVisibilities.isVisibleIgnoringReceiver(r10, r5, r11) == false) goto L11;
        return true;
    }

    public static <D extends CallableDescriptor> boolean overrides(D r5, D r10, boolean r11, boolean r12) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(13);
    L4:
        if (r10 != null) goto L7;
        $$$reportNull$$$0(14);
    L7:
        if (r5.equals(r10) == false) goto L9;
    L11:
        CallableDescriptor r13 = r10.getOriginal();
        Iterator r14 = DescriptorUtils.getAllOverriddenDescriptors(r5).iterator();
    L13:
        if (r14.hasNext() == false) goto L17;
        CallableDescriptor r15 = (CallableDescriptor) r14.next();
        if (DescriptorEquivalenceForOverrides.INSTANCE.areEquivalent(r13, r15, r11, r12) == false) goto L13;
        return true;
    L17:
        return false;
    L9:
        if (DescriptorEquivalenceForOverrides.INSTANCE.areEquivalent(r5.getOriginal(), r10.getOriginal(), r11, r12) == false) goto L11;
        return true;
    }

    public static void resolveUnknownVisibilityForMember(CallableMemberDescriptor r5, Function1<CallableMemberDescriptor, Unit> r10) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(107);
    L4:
        Iterator<? extends CallableMemberDescriptor> r11 = r5.getOverriddenDescriptors().iterator();
    L6:
        if (r11.hasNext() == false) goto L11;
        CallableMemberDescriptor r12 = r11.next();
        if (r12.getVisibility() != DescriptorVisibilities.INHERITED) goto L6;
        resolveUnknownVisibilityForMember(r12, r10);
        goto L6
    L11:
        if (r5.getVisibility() == DescriptorVisibilities.INHERITED) goto L13;
        return;
    L13:
        DescriptorVisibility r13 = computeVisibilityToInherit(r5);
        if (r13 != null) goto L18;
        if (r10 == null) goto L17;
        r10.invoke(r5);
    L17:
        DescriptorVisibility r14 = DescriptorVisibilities.PUBLIC;
    L20:
        if ((r5 instanceof PropertyDescriptorImpl) == false) goto L30;
        ((PropertyDescriptorImpl) r5).setVisibility(r14);
        Iterator<PropertyAccessorDescriptor> r15 = ((PropertyDescriptor) r5).getAccessors().iterator();
    L23:
        if (r15.hasNext() == false) goto L46;
        PropertyAccessorDescriptor r16 = r15.next();
        if (r13 != null) goto L27;
        Function1<CallableMemberDescriptor, Unit> r17 = null;
    L28:
        resolveUnknownVisibilityForMember(r16, r17);
        goto L23
    L27:
        r17 = r10;
        goto L28
    L46:
        return;
    L30:
        if ((r5 instanceof FunctionDescriptorImpl) == false) goto L32;
        ((FunctionDescriptorImpl) r5).setVisibility(r14);
        return;
    L32:
        PropertyAccessorDescriptorImpl r18 = (PropertyAccessorDescriptorImpl) r5;
        r18.setVisibility(r14);
        if (r14 == r18.getCorrespondingProperty().getVisibility()) goto L45;
        r18.setDefault(false);
        return;
    L45:
        return;
    L18:
        r14 = r13;
        goto L20
    }

    public static <H> H selectMostSpecificMember(Collection<H> r10, Function1<H, CallableDescriptor> r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(78);
    L4:
        if (r11 != null) goto L7;
        $$$reportNull$$$0(79);
    L7:
        if (r10.size() != 1) goto L12;
        H r12 = (H) CollectionsKt.n(r10);
        if (r12 != null) goto L11;
        $$$reportNull$$$0(80);
    L11:
        return r12;
    L12:
        ArrayList r5 = new ArrayList(2);
        Collection<H> r13 = r10;
        List r14 = CollectionsKt.r(r13, r11);
        H r15 = (H) CollectionsKt.n(r13);
        CallableDescriptor r16 = r11.invoke(r15);
        Iterator<H> r17 = r10.iterator();
    L14:
        if (r17.hasNext() == false) goto L24;
        H r18 = r17.next();
        CallableDescriptor r19 = r11.invoke(r18);
        if (isMoreSpecificThenAllOf(r19, r14) == false) goto L19;
        r5.add(r18);
    L19:
        if (isMoreSpecific(r19, r16) == false) goto L14;
        if (isMoreSpecific(r16, r19) == true) goto L14;
        r15 = r18;
        goto L14
    L24:
        if (r5.isEmpty() == false) goto L29;
        if (r15 != null) goto L27;
        $$$reportNull$$$0(81);
    L27:
        return r15;
    L29:
        if (r5.size() != 1) goto L34;
        H r20 = (H) CollectionsKt.n(r5);
        if (r20 != null) goto L33;
        $$$reportNull$$$0(82);
    L33:
        return r20;
    L34:
        Iterator r21 = r5.iterator();
    L36:
        if (r21.hasNext() == false) goto L40;
        H r22 = (H) r21.next();
        if (FlexibleTypesKt.isFlexible(r11.invoke(r22).getReturnType()) == true) goto L36;
    L41:
        if (r22 == null) goto L43;
        return r22;
    L43:
        H r23 = (H) CollectionsKt.n(r5);
        if (r23 != null) goto L46;
        $$$reportNull$$$0(84);
    L46:
        return r23;
    L40:
        r22 = null;
        goto L41
    }

    public void generateOverridesInFunctionGroup(Name r5, Collection<? extends CallableMemberDescriptor> r10, Collection<? extends CallableMemberDescriptor> r11, ClassDescriptor r12, OverridingStrategy r13) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(52);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(53);
    L6:
        if (r11 != null) goto L8;
        $$$reportNull$$$0(54);
    L8:
        if (r12 != null) goto L10;
        $$$reportNull$$$0(55);
    L10:
        if (r13 != null) goto L12;
        $$$reportNull$$$0(56);
    L12:
        LinkedHashSet r14 = new LinkedHashSet(r10);
        Iterator<? extends CallableMemberDescriptor> r15 = r11.iterator();
    L14:
        if (r15.hasNext() == false) goto L16;
        r14.removeAll(extractAndBindOverridesForMember(r15.next(), r10, r12, r13));
        goto L14
    L16:
        createAndBindFakeOverrides(r12, r14, r13);
    }

    public OverrideCompatibilityInfo isOverridableBy(CallableDescriptor r5, CallableDescriptor r10, ClassDescriptor r11) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(19);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(20);
    L6:
        OverrideCompatibilityInfo r12 = isOverridableBy(r5, r10, r11, false);
        if (r12 != null) goto L9;
        $$$reportNull$$$0(21);
    L9:
        return r12;
    }

    public OverrideCompatibilityInfo isOverridableByWithoutExternalConditions(CallableDescriptor r10, CallableDescriptor r11, boolean r12) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(30);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(31);
    L6:
        OverrideCompatibilityInfo r5 = getBasicOverridabilityProblem(r10, r11);
        if (r5 == null) goto L9;
        return r5;
    L9:
        List<KotlinType> r13 = compiledValueParameters(r10);
        List<KotlinType> r14 = compiledValueParameters(r11);
        List<TypeParameterDescriptor> r15 = r10.getTypeParameters();
        List<TypeParameterDescriptor> r16 = r11.getTypeParameters();
        int r17 = 0;
        if (r15.size() != r16.size()) goto L12;
        TypeCheckerState r18 = createTypeCheckerState(r15, r16);
        int r19 = 0;
    L26:
        if (r19 >= r15.size()) goto L35;
        if (areTypeParametersEquivalent(r15.get(r19), r16.get(r19), r18) == false) goto L29;
        r19 = r19 + 1;
        goto L26
    L29:
        OverrideCompatibilityInfo r20 = OverrideCompatibilityInfo.incompatible("Type parameter bounds mismatch");
        if (r20 != null) goto L32;
        $$$reportNull$$$0(35);
    L32:
        return r20;
    L35:
        if (r17 >= r13.size()) goto L44;
        if (areTypesEquivalent(r13.get(r17), r14.get(r17), r18) == false) goto L38;
        r17 = r17 + 1;
        goto L35
    L38:
        OverrideCompatibilityInfo r21 = OverrideCompatibilityInfo.incompatible("Value parameter type mismatch");
        if (r21 != null) goto L41;
        $$$reportNull$$$0(36);
    L41:
        return r21;
    L44:
        if ((r10 instanceof FunctionDescriptor) == true) goto L46;
    L53:
        if (r12 == false) goto L68;
        KotlinType r22 = r10.getReturnType();
        KotlinType r110 = r11.getReturnType();
        if (r22 == null) goto L68;
        if (r110 == null) goto L68;
        if (KotlinTypeKt.isError(r110) == false) goto L63;
        if (KotlinTypeKt.isError(r22) == true) goto L68;
    L63:
        if (AbstractTypeChecker.INSTANCE.isSubtypeOf(r18, r110.unwrap(), r22.unwrap()) == true) goto L68;
        OverrideCompatibilityInfo r23 = OverrideCompatibilityInfo.conflict("Return type mismatch");
        if (r23 != null) goto L67;
        $$$reportNull$$$0(38);
    L67:
        return r23;
    L68:
        OverrideCompatibilityInfo r24 = OverrideCompatibilityInfo.success();
        if (r24 != null) goto L71;
        $$$reportNull$$$0(39);
    L71:
        return r24;
    L46:
        if ((r11 instanceof FunctionDescriptor) == false) goto L53;
        if (((FunctionDescriptor) r10).isSuspend() == ((FunctionDescriptor) r11).isSuspend()) goto L53;
        OverrideCompatibilityInfo r25 = OverrideCompatibilityInfo.conflict("Incompatible suspendability");
        if (r25 != null) goto L52;
        $$$reportNull$$$0(37);
    L52:
        return r25;
    L12:
        if (r17 >= r13.size()) goto L20;
        if (KotlinTypeChecker.DEFAULT.equalTypes(r13.get(r17), r14.get(r17)) == false) goto L15;
        r17 = r17 + 1;
        goto L12
    L15:
        OverrideCompatibilityInfo r26 = OverrideCompatibilityInfo.incompatible("Type parameter number mismatch");
        if (r26 != null) goto L18;
        $$$reportNull$$$0(33);
    L18:
        return r26;
    L20:
        OverrideCompatibilityInfo r27 = OverrideCompatibilityInfo.conflict("Type parameter number mismatch");
        if (r27 != null) goto L23;
        $$$reportNull$$$0(34);
    L23:
        return r27;
    }

    public OverrideCompatibilityInfo isOverridableBy(CallableDescriptor r10, CallableDescriptor r11, ClassDescriptor r12, boolean r13) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(22);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(23);
    L6:
        OverrideCompatibilityInfo r14 = isOverridableByWithoutExternalConditions(r10, r11, r13);
        if (r14.getResult() != OverrideCompatibilityInfo.Result.OVERRIDABLE) goto L9;
        boolean r15 = true;
    L10:
        Iterator<ExternalOverridabilityCondition> r5 = EXTERNAL_CONDITIONS.iterator();
    L12:
        if (r5.hasNext() == false) goto L34;
        ExternalOverridabilityCondition r16 = r5.next();
        if (r16.getContract() == ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY) goto L12;
        if (r15 == false) goto L20;
        if (r16.getContract() == ExternalOverridabilityCondition.Contract.SUCCESS_ONLY) goto L12;
    L20:
        int r17 = AnonymousClass8.$SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result[r16.isOverridable(r10, r11, r12).ordinal()];
        if (r17 != 1) goto L22;
        r15 = true;
        goto L12
    L22:
        if (r17 == 2) goto L29;
        if (r17 != 3) goto L12;
        OverrideCompatibilityInfo r18 = OverrideCompatibilityInfo.incompatible("External condition");
        if (r18 != null) goto L28;
        $$$reportNull$$$0(25);
    L28:
        return r18;
    L29:
        OverrideCompatibilityInfo r19 = OverrideCompatibilityInfo.conflict("External condition failed");
        if (r19 != null) goto L32;
        $$$reportNull$$$0(24);
    L32:
        return r19;
    L34:
        if (r15 == true) goto L36;
        return r14;
    L36:
        Iterator<ExternalOverridabilityCondition> r20 = EXTERNAL_CONDITIONS.iterator();
    L38:
        if (r20.hasNext() == false) goto L57;
        ExternalOverridabilityCondition r110 = r20.next();
        if (r110.getContract() != ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY) goto L38;
        int r21 = AnonymousClass8.$SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result[r110.isOverridable(r10, r11, r12).ordinal()];
        if (r21 == 1) goto L56;
        if (r21 == 2) goto L51;
        if (r21 != 3) goto L38;
        OverrideCompatibilityInfo r22 = OverrideCompatibilityInfo.incompatible("External condition");
        if (r22 != null) goto L50;
        $$$reportNull$$$0(28);
    L50:
        return r22;
    L51:
        OverrideCompatibilityInfo r23 = OverrideCompatibilityInfo.conflict("External condition failed");
        if (r23 != null) goto L54;
        $$$reportNull$$$0(27);
    L54:
        return r23;
    L56:
        throw new IllegalStateException("Contract violation in " + r110.getClass().getName() + " condition. It's not supposed to end with success");
    L57:
        OverrideCompatibilityInfo r24 = OverrideCompatibilityInfo.success();
        if (r24 != null) goto L60;
        $$$reportNull$$$0(29);
    L60:
        return r24;
    L9:
        r15 = false;
        goto L10
    }

    private static Collection<CallableMemberDescriptor> extractMembersOverridableInBothWays(final CallableMemberDescriptor r5, Queue<CallableMemberDescriptor> r10, final OverridingStrategy r11) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(104);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(105);
    L6:
        if (r11 != null) goto L9;
        $$$reportNull$$$0(106);
    L9:
        return extractMembersOverridableInBothWays(r5, r10, new AnonymousClass6(), new AnonymousClass7(r11, r5));
    }
}
