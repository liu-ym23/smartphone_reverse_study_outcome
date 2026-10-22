package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.builtins.functions.BuiltInFictitiousFunctionClassFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: loaded from: classes3.dex */
public abstract class KotlinBuiltIns {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final Name BUILTINS_MODULE_NAME = null;
    private final MemoizedFunctionToNotNull<Name, ClassDescriptor> builtInClassesByName;
    private final NotNullLazyValue<Collection<PackageViewDescriptor>> builtInPackagesImportedByDefault;
    private ModuleDescriptorImpl builtInsModule;
    private NotNullLazyValue<ModuleDescriptorImpl> postponedBuiltInsModule;
    private final NotNullLazyValue<Primitives> primitives;
    private final StorageManager storageManager;

    public static class Primitives {
        public final Map<SimpleType, SimpleType> kotlinArrayTypeToPrimitiveKotlinType;
        public final Map<KotlinType, SimpleType> primitiveKotlinTypeToKotlinArrayType;
        public final Map<PrimitiveType, SimpleType> primitiveTypeToArrayKotlinType;

        private static /* synthetic */ void $$$reportNull$$$0(int r5) {
            Object[] r10 = new Object[3];
            if (r5 == 1) goto L7;
            if (r5 == 2) goto L6;
            r10[0] = "primitiveTypeToArrayKotlinType";
        L8:
            r10[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$Primitives";
            r10[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r10));
        L6:
            r10[0] = "kotlinArrayTypeToPrimitiveKotlinType";
            goto L8
        L7:
            r10[0] = "primitiveKotlinTypeToKotlinArrayType";
            goto L8
        }

        public /* synthetic */ Primitives(Map r5, Map r10, Map r11, AnonymousClass1 r12) {
            this(r5, r10, r11);
        }

        private Primitives(Map<PrimitiveType, SimpleType> r5, Map<KotlinType, SimpleType> r10, Map<SimpleType, SimpleType> r11) {
            if (r5 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r10 != null) goto L6;
            $$$reportNull$$$0(1);
        L6:
            if (r11 != null) goto L8;
            $$$reportNull$$$0(2);
        L8:
            this.primitiveTypeToArrayKotlinType = r5;
            this.primitiveKotlinTypeToKotlinArrayType = r10;
            this.kotlinArrayTypeToPrimitiveKotlinType = r11;
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int r13) {
        switch(r13) {
            case 3: goto L4;
            case 4: goto L4;
            case 5: goto L4;
            case 6: goto L4;
            case 7: goto L4;
            case 8: goto L4;
            case 9: goto L3;
            case 10: goto L3;
            case 11: goto L4;
            case 12: goto L3;
            case 13: goto L4;
            case 14: goto L3;
            case 15: goto L4;
            case 16: goto L3;
            case 17: goto L3;
            case 18: goto L4;
            case 19: goto L4;
            case 20: goto L4;
            case 21: goto L4;
            case 22: goto L4;
            case 23: goto L4;
            case 24: goto L4;
            case 25: goto L4;
            case 26: goto L4;
            case 27: goto L4;
            case 28: goto L4;
            case 29: goto L4;
            case 30: goto L4;
            case 31: goto L4;
            case 32: goto L4;
            case 33: goto L4;
            case 34: goto L4;
            case 35: goto L4;
            case 36: goto L4;
            case 37: goto L4;
            case 38: goto L4;
            case 39: goto L4;
            case 40: goto L4;
            case 41: goto L4;
            case 42: goto L4;
            case 43: goto L4;
            case 44: goto L4;
            case 45: goto L4;
            case 46: goto L3;
            case 47: goto L4;
            case 48: goto L4;
            case 49: goto L4;
            case 50: goto L4;
            case 51: goto L4;
            case 52: goto L4;
            case 53: goto L3;
            case 54: goto L4;
            case 55: goto L4;
            case 56: goto L4;
            case 57: goto L4;
            case 58: goto L4;
            case 59: goto L4;
            case 60: goto L4;
            case 61: goto L4;
            case 62: goto L4;
            case 63: goto L4;
            case 64: goto L4;
            case 65: goto L4;
            case 66: goto L4;
            case 67: goto L3;
            case 68: goto L4;
            case 69: goto L4;
            case 70: goto L4;
            case 71: goto L3;
            case 72: goto L3;
            case 73: goto L3;
            case 74: goto L4;
            case 75: goto L3;
            case 76: goto L3;
            case 77: goto L3;
            case 78: goto L3;
            case 79: goto L3;
            case 80: goto L3;
            case 81: goto L4;
            case 82: goto L3;
            case 83: goto L3;
            case 84: goto L4;
            case 85: goto L3;
            case 86: goto L4;
            case 87: goto L4;
            default: goto L3;
        };
    L3:
        String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L6:
        switch(r13) {
            case 3: goto L8;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L8;
            case 7: goto L8;
            case 8: goto L8;
            case 9: goto L7;
            case 10: goto L7;
            case 11: goto L8;
            case 12: goto L7;
            case 13: goto L8;
            case 14: goto L7;
            case 15: goto L8;
            case 16: goto L7;
            case 17: goto L7;
            case 18: goto L8;
            case 19: goto L8;
            case 20: goto L8;
            case 21: goto L8;
            case 22: goto L8;
            case 23: goto L8;
            case 24: goto L8;
            case 25: goto L8;
            case 26: goto L8;
            case 27: goto L8;
            case 28: goto L8;
            case 29: goto L8;
            case 30: goto L8;
            case 31: goto L8;
            case 32: goto L8;
            case 33: goto L8;
            case 34: goto L8;
            case 35: goto L8;
            case 36: goto L8;
            case 37: goto L8;
            case 38: goto L8;
            case 39: goto L8;
            case 40: goto L8;
            case 41: goto L8;
            case 42: goto L8;
            case 43: goto L8;
            case 44: goto L8;
            case 45: goto L8;
            case 46: goto L7;
            case 47: goto L8;
            case 48: goto L8;
            case 49: goto L8;
            case 50: goto L8;
            case 51: goto L8;
            case 52: goto L8;
            case 53: goto L7;
            case 54: goto L8;
            case 55: goto L8;
            case 56: goto L8;
            case 57: goto L8;
            case 58: goto L8;
            case 59: goto L8;
            case 60: goto L8;
            case 61: goto L8;
            case 62: goto L8;
            case 63: goto L8;
            case 64: goto L8;
            case 65: goto L8;
            case 66: goto L8;
            case 67: goto L7;
            case 68: goto L8;
            case 69: goto L8;
            case 70: goto L8;
            case 71: goto L7;
            case 72: goto L7;
            case 73: goto L7;
            case 74: goto L8;
            case 75: goto L7;
            case 76: goto L7;
            case 77: goto L7;
            case 78: goto L7;
            case 79: goto L7;
            case 80: goto L7;
            case 81: goto L8;
            case 82: goto L7;
            case 83: goto L7;
            case 84: goto L8;
            case 85: goto L7;
            case 86: goto L8;
            case 87: goto L8;
            default: goto L7;
        };
    L7:
        int r10 = 3;
    L9:
        Object[] r11 = new Object[r10];
        switch(r13) {
            case 1: goto L29;
            case 2: goto L28;
            case 3: goto L27;
            case 4: goto L27;
            case 5: goto L27;
            case 6: goto L27;
            case 7: goto L27;
            case 8: goto L27;
            case 9: goto L26;
            case 10: goto L26;
            case 11: goto L27;
            case 12: goto L25;
            case 13: goto L27;
            case 14: goto L24;
            case 15: goto L27;
            case 16: goto L23;
            case 17: goto L23;
            case 18: goto L27;
            case 19: goto L27;
            case 20: goto L27;
            case 21: goto L27;
            case 22: goto L27;
            case 23: goto L27;
            case 24: goto L27;
            case 25: goto L27;
            case 26: goto L27;
            case 27: goto L27;
            case 28: goto L27;
            case 29: goto L27;
            case 30: goto L27;
            case 31: goto L27;
            case 32: goto L27;
            case 33: goto L27;
            case 34: goto L27;
            case 35: goto L27;
            case 36: goto L27;
            case 37: goto L27;
            case 38: goto L27;
            case 39: goto L27;
            case 40: goto L27;
            case 41: goto L27;
            case 42: goto L27;
            case 43: goto L27;
            case 44: goto L27;
            case 45: goto L27;
            case 46: goto L22;
            case 47: goto L27;
            case 48: goto L27;
            case 49: goto L27;
            case 50: goto L27;
            case 51: goto L27;
            case 52: goto L27;
            case 53: goto L23;
            case 54: goto L27;
            case 55: goto L27;
            case 56: goto L27;
            case 57: goto L27;
            case 58: goto L27;
            case 59: goto L27;
            case 60: goto L27;
            case 61: goto L27;
            case 62: goto L27;
            case 63: goto L27;
            case 64: goto L27;
            case 65: goto L27;
            case 66: goto L27;
            case 67: goto L21;
            case 68: goto L27;
            case 69: goto L27;
            case 70: goto L27;
            case 71: goto L20;
            case 72: goto L29;
            case 73: goto L19;
            case 74: goto L27;
            case 75: goto L18;
            case 76: goto L26;
            case 77: goto L26;
            case 78: goto L17;
            case 79: goto L16;
            case 80: goto L15;
            case 81: goto L27;
            case 82: goto L17;
            case 83: goto L16;
            case 84: goto L27;
            case 85: goto L16;
            case 86: goto L27;
            case 87: goto L27;
            case 88: goto L23;
            case 89: goto L26;
            case 90: goto L23;
            case 91: goto L23;
            case 92: goto L23;
            case 93: goto L23;
            case 94: goto L23;
            case 95: goto L23;
            case 96: goto L26;
            case 97: goto L23;
            case 98: goto L25;
            case 99: goto L23;
            case 100: goto L25;
            case 101: goto L14;
            case 102: goto L25;
            case 103: goto L26;
            case 104: goto L25;
            case 105: goto L23;
            case 106: goto L25;
            case 107: goto L26;
            case 108: goto L26;
            case 109: goto L23;
            case 110: goto L23;
            case 111: goto L23;
            case 112: goto L13;
            case 113: goto L23;
            case 114: goto L23;
            case 115: goto L23;
            case 116: goto L23;
            case 117: goto L23;
            case 118: goto L23;
            case 119: goto L23;
            case 120: goto L23;
            case 121: goto L23;
            case 122: goto L23;
            case 123: goto L23;
            case 124: goto L23;
            case 125: goto L23;
            case 126: goto L23;
            case 127: goto L23;
            case 128: goto L23;
            case 129: goto L23;
            case 130: goto L23;
            case 131: goto L23;
            case 132: goto L23;
            case 133: goto L23;
            case 134: goto L23;
            case 135: goto L25;
            case 136: goto L23;
            case 137: goto L23;
            case 138: goto L23;
            case 139: goto L23;
            case 140: goto L23;
            case 141: goto L23;
            case 142: goto L23;
            case 143: goto L26;
            case 144: goto L23;
            case 145: goto L23;
            case 146: goto L26;
            case 147: goto L26;
            case 148: goto L23;
            case 149: goto L26;
            case 150: goto L23;
            case 151: goto L23;
            case 152: goto L23;
            case 153: goto L23;
            case 154: goto L23;
            case 155: goto L23;
            case 156: goto L23;
            case 157: goto L26;
            case 158: goto L26;
            case 159: goto L26;
            case 160: goto L26;
            case 161: goto L12;
            case 162: goto L23;
            default: goto L11;
        };
    L11:
        r11[0] = "storageManager";
    L31:
        switch(r13) {
            case 3: goto L93;
            case 4: goto L92;
            case 5: goto L91;
            case 6: goto L90;
            case 7: goto L89;
            case 8: goto L88;
            case 9: goto L32;
            case 10: goto L32;
            case 11: goto L87;
            case 12: goto L32;
            case 13: goto L86;
            case 14: goto L32;
            case 15: goto L85;
            case 16: goto L32;
            case 17: goto L32;
            case 18: goto L84;
            case 19: goto L83;
            case 20: goto L82;
            case 21: goto L81;
            case 22: goto L80;
            case 23: goto L79;
            case 24: goto L78;
            case 25: goto L77;
            case 26: goto L76;
            case 27: goto L75;
            case 28: goto L74;
            case 29: goto L73;
            case 30: goto L72;
            case 31: goto L71;
            case 32: goto L70;
            case 33: goto L69;
            case 34: goto L68;
            case 35: goto L67;
            case 36: goto L66;
            case 37: goto L65;
            case 38: goto L64;
            case 39: goto L63;
            case 40: goto L62;
            case 41: goto L61;
            case 42: goto L60;
            case 43: goto L59;
            case 44: goto L58;
            case 45: goto L57;
            case 46: goto L32;
            case 47: goto L56;
            case 48: goto L55;
            case 49: goto L54;
            case 50: goto L53;
            case 51: goto L52;
            case 52: goto L51;
            case 53: goto L32;
            case 54: goto L50;
            case 55: goto L49;
            case 56: goto L48;
            case 57: goto L47;
            case 58: goto L46;
            case 59: goto L45;
            case 60: goto L44;
            case 61: goto L43;
            case 62: goto L42;
            case 63: goto L41;
            case 64: goto L40;
            case 65: goto L39;
            case 66: goto L38;
            case 67: goto L32;
            case 68: goto L37;
            case 69: goto L37;
            case 70: goto L37;
            case 71: goto L32;
            case 72: goto L32;
            case 73: goto L32;
            case 74: goto L36;
            case 75: goto L32;
            case 76: goto L32;
            case 77: goto L32;
            case 78: goto L32;
            case 79: goto L32;
            case 80: goto L32;
            case 81: goto L35;
            case 82: goto L32;
            case 83: goto L32;
            case 84: goto L35;
            case 85: goto L32;
            case 86: goto L34;
            case 87: goto L33;
            default: goto L32;
        };
    L32:
        r11[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
    L94:
        switch(r13) {
            case 1: goto L175;
            case 2: goto L174;
            case 3: goto L176;
            case 4: goto L176;
            case 5: goto L176;
            case 6: goto L176;
            case 7: goto L176;
            case 8: goto L176;
            case 9: goto L173;
            case 10: goto L172;
            case 11: goto L176;
            case 12: goto L171;
            case 13: goto L176;
            case 14: goto L170;
            case 15: goto L176;
            case 16: goto L169;
            case 17: goto L168;
            case 18: goto L176;
            case 19: goto L176;
            case 20: goto L176;
            case 21: goto L176;
            case 22: goto L176;
            case 23: goto L176;
            case 24: goto L176;
            case 25: goto L176;
            case 26: goto L176;
            case 27: goto L176;
            case 28: goto L176;
            case 29: goto L176;
            case 30: goto L176;
            case 31: goto L176;
            case 32: goto L176;
            case 33: goto L176;
            case 34: goto L176;
            case 35: goto L176;
            case 36: goto L176;
            case 37: goto L176;
            case 38: goto L176;
            case 39: goto L176;
            case 40: goto L176;
            case 41: goto L176;
            case 42: goto L176;
            case 43: goto L176;
            case 44: goto L176;
            case 45: goto L176;
            case 46: goto L167;
            case 47: goto L176;
            case 48: goto L176;
            case 49: goto L176;
            case 50: goto L176;
            case 51: goto L176;
            case 52: goto L176;
            case 53: goto L166;
            case 54: goto L176;
            case 55: goto L176;
            case 56: goto L176;
            case 57: goto L176;
            case 58: goto L176;
            case 59: goto L176;
            case 60: goto L176;
            case 61: goto L176;
            case 62: goto L176;
            case 63: goto L176;
            case 64: goto L176;
            case 65: goto L176;
            case 66: goto L176;
            case 67: goto L165;
            case 68: goto L176;
            case 69: goto L176;
            case 70: goto L176;
            case 71: goto L164;
            case 72: goto L164;
            case 73: goto L163;
            case 74: goto L176;
            case 75: goto L162;
            case 76: goto L161;
            case 77: goto L160;
            case 78: goto L159;
            case 79: goto L159;
            case 80: goto L159;
            case 81: goto L176;
            case 82: goto L159;
            case 83: goto L159;
            case 84: goto L176;
            case 85: goto L158;
            case 86: goto L176;
            case 87: goto L176;
            case 88: goto L157;
            case 89: goto L156;
            case 90: goto L156;
            case 91: goto L155;
            case 92: goto L154;
            case 93: goto L161;
            case 94: goto L153;
            case 95: goto L152;
            case 96: goto L151;
            case 97: goto L150;
            case 98: goto L150;
            case 99: goto L150;
            case 100: goto L150;
            case 101: goto L149;
            case 102: goto L149;
            case 103: goto L148;
            case 104: goto L148;
            case 105: goto L147;
            case 106: goto L147;
            case 107: goto L146;
            case 108: goto L145;
            case 109: goto L145;
            case 110: goto L144;
            case 111: goto L143;
            case 112: goto L144;
            case 113: goto L142;
            case 114: goto L141;
            case 115: goto L140;
            case 116: goto L139;
            case 117: goto L138;
            case 118: goto L137;
            case 119: goto L136;
            case 120: goto L135;
            case 121: goto L134;
            case 122: goto L133;
            case 123: goto L132;
            case 124: goto L131;
            case 125: goto L130;
            case 126: goto L129;
            case 127: goto L128;
            case 128: goto L127;
            case 129: goto L126;
            case 130: goto L125;
            case 131: goto L124;
            case 132: goto L123;
            case 133: goto L122;
            case 134: goto L121;
            case 135: goto L121;
            case 136: goto L120;
            case 137: goto L119;
            case 138: goto L118;
            case 139: goto L117;
            case 140: goto L116;
            case 141: goto L115;
            case 142: goto L114;
            case 143: goto L113;
            case 144: goto L112;
            case 145: goto L111;
            case 146: goto L110;
            case 147: goto L109;
            case 148: goto L109;
            case 149: goto L108;
            case 150: goto L108;
            case 151: goto L107;
            case 152: goto L106;
            case 153: goto L105;
            case 154: goto L104;
            case 155: goto L103;
            case 156: goto L102;
            case 157: goto L101;
            case 158: goto L100;
            case 159: goto L99;
            case 160: goto L98;
            case 161: goto L97;
            case 162: goto L96;
            default: goto L95;
        };
    L95:
        r11[2] = "<init>";
        goto L176
    L96:
        r11[2] = "isNotNullOrNullableFunctionSupertype";
        goto L176
    L97:
        r11[2] = "isDeprecated";
        goto L176
    L98:
        r11[2] = "isCloneable";
        goto L176
    L99:
        r11[2] = "isNonPrimitiveArray";
        goto L176
    L100:
        r11[2] = "isKClass";
        goto L176
    L101:
        r11[2] = "isThrowable";
        goto L176
    L102:
        r11[2] = "isThrowableOrNullableThrowable";
        goto L176
    L103:
        r11[2] = "isIterableOrNullableIterable";
        goto L176
    L104:
        r11[2] = "isMapOrNullableMap";
        goto L176
    L105:
        r11[2] = "isSetOrNullableSet";
        goto L176
    L106:
        r11[2] = "isListOrNullableList";
        goto L176
    L107:
        r11[2] = "isCollectionOrNullableCollection";
        goto L176
    L108:
        r11[2] = "isComparable";
        goto L176
    L109:
        r11[2] = "isEnum";
        goto L176
    L110:
        r11[2] = "isMemberOfAny";
        goto L176
    L111:
        r11[2] = "isBooleanOrSubtype";
        goto L176
    L112:
        r11[2] = "isUnitOrNullableUnit";
        goto L176
    L113:
        r11[2] = "mayReturnNonUnitValue";
        goto L176
    L114:
        r11[2] = "isUnit";
        goto L176
    L115:
        r11[2] = "isDefaultBound";
        goto L176
    L116:
        r11[2] = "isNullableAny";
        goto L176
    L117:
        r11[2] = "isAnyOrNullableAny";
        goto L176
    L118:
        r11[2] = "isNothingOrNullableNothing";
        goto L176
    L119:
        r11[2] = "isNullableNothing";
        goto L176
    L120:
        r11[2] = "isNothing";
        goto L176
    L121:
        r11[2] = "isConstructedFromGivenClassAndNotNullable";
        goto L176
    L122:
        r11[2] = "isDoubleOrNullableDouble";
        goto L176
    L123:
        r11[2] = "isUnsignedArrayType";
        goto L176
    L124:
        r11[2] = "isULongArray";
        goto L176
    L125:
        r11[2] = "isUIntArray";
        goto L176
    L126:
        r11[2] = "isUShortArray";
        goto L176
    L127:
        r11[2] = "isUByteArray";
        goto L176
    L128:
        r11[2] = "isULong";
        goto L176
    L129:
        r11[2] = "isUInt";
        goto L176
    L130:
        r11[2] = "isUShort";
        goto L176
    L131:
        r11[2] = "isUByte";
        goto L176
    L132:
        r11[2] = "isDouble";
        goto L176
    L133:
        r11[2] = "isFloatOrNullableFloat";
        goto L176
    L134:
        r11[2] = "isFloat";
        goto L176
    L135:
        r11[2] = "isShort";
        goto L176
    L136:
        r11[2] = "isLongOrNullableLong";
        goto L176
    L137:
        r11[2] = "isLong";
        goto L176
    L138:
        r11[2] = "isByte";
        goto L176
    L139:
        r11[2] = "isInt";
        goto L176
    L140:
        r11[2] = "isCharOrNullableChar";
        goto L176
    L141:
        r11[2] = "isChar";
        goto L176
    L142:
        r11[2] = "isNumber";
        goto L176
    L143:
        r11[2] = "isBooleanOrNullableBoolean";
        goto L176
    L144:
        r11[2] = "isBoolean";
        goto L176
    L145:
        r11[2] = "isAny";
        goto L176
    L146:
        r11[2] = "isSpecialClassWithNoSupertypes";
        goto L176
    L147:
        r11[2] = "isNotNullConstructedFromGivenClass";
        goto L176
    L148:
        r11[2] = "classFqNameEquals";
        goto L176
    L149:
        r11[2] = "isTypeConstructorForGivenClass";
        goto L176
    L150:
        r11[2] = "isConstructedFromGivenClass";
        goto L176
    L151:
        r11[2] = "isPrimitiveClass";
        goto L176
    L152:
        r11[2] = "isPrimitiveTypeOrNullablePrimitiveType";
        goto L176
    L153:
        r11[2] = "isPrimitiveType";
        goto L176
    L154:
        r11[2] = "getPrimitiveArrayElementType";
        goto L176
    L155:
        r11[2] = "isPrimitiveArray";
        goto L176
    L156:
        r11[2] = "isArrayOrPrimitiveArray";
        goto L176
    L157:
        r11[2] = "isArray";
        goto L176
    L158:
        r11[2] = "getEnumType";
        goto L176
    L159:
        r11[2] = "getArrayType";
        goto L176
    L160:
        r11[2] = "getPrimitiveArrayType";
        goto L176
    L161:
        r11[2] = "getPrimitiveType";
        goto L176
    L162:
        r11[2] = "getPrimitiveArrayKotlinTypeByPrimitiveKotlinType";
        goto L176
    L163:
        r11[2] = "getPrimitiveArrayKotlinType";
        goto L176
    L164:
        r11[2] = "getElementTypeForUnsignedArray";
        goto L176
    L165:
        r11[2] = "getArrayElementType";
        goto L176
    L166:
        r11[2] = "getPrimitiveKotlinType";
        goto L176
    L167:
        r11[2] = "getBuiltInTypeByClassName";
        goto L176
    L168:
        r11[2] = "getPrimitiveArrayClassDescriptor";
        goto L176
    L169:
        r11[2] = "getPrimitiveClassDescriptor";
        goto L176
    L170:
        r11[2] = "getBuiltInClassByName";
        goto L176
    L171:
        r11[2] = "getBuiltInClassByFqName";
        goto L176
    L172:
        r11[2] = "isUnderKotlinPackage";
        goto L176
    L173:
        r11[2] = "isBuiltIn";
        goto L176
    L174:
        r11[2] = "setPostponedBuiltinsModuleComputation";
        goto L176
    L175:
        r11[2] = "setBuiltInsModule";
    L176:
        String r12 = String.format(r5, r11);
        switch(r13) {
            case 3: goto L180;
            case 4: goto L180;
            case 5: goto L180;
            case 6: goto L180;
            case 7: goto L180;
            case 8: goto L180;
            case 9: goto L181;
            case 10: goto L181;
            case 11: goto L180;
            case 12: goto L181;
            case 13: goto L180;
            case 14: goto L181;
            case 15: goto L180;
            case 16: goto L181;
            case 17: goto L181;
            case 18: goto L180;
            case 19: goto L180;
            case 20: goto L180;
            case 21: goto L180;
            case 22: goto L180;
            case 23: goto L180;
            case 24: goto L180;
            case 25: goto L180;
            case 26: goto L180;
            case 27: goto L180;
            case 28: goto L180;
            case 29: goto L180;
            case 30: goto L180;
            case 31: goto L180;
            case 32: goto L180;
            case 33: goto L180;
            case 34: goto L180;
            case 35: goto L180;
            case 36: goto L180;
            case 37: goto L180;
            case 38: goto L180;
            case 39: goto L180;
            case 40: goto L180;
            case 41: goto L180;
            case 42: goto L180;
            case 43: goto L180;
            case 44: goto L180;
            case 45: goto L180;
            case 46: goto L181;
            case 47: goto L180;
            case 48: goto L180;
            case 49: goto L180;
            case 50: goto L180;
            case 51: goto L180;
            case 52: goto L180;
            case 53: goto L181;
            case 54: goto L180;
            case 55: goto L180;
            case 56: goto L180;
            case 57: goto L180;
            case 58: goto L180;
            case 59: goto L180;
            case 60: goto L180;
            case 61: goto L180;
            case 62: goto L180;
            case 63: goto L180;
            case 64: goto L180;
            case 65: goto L180;
            case 66: goto L180;
            case 67: goto L181;
            case 68: goto L180;
            case 69: goto L180;
            case 70: goto L180;
            case 71: goto L181;
            case 72: goto L181;
            case 73: goto L181;
            case 74: goto L180;
            case 75: goto L181;
            case 76: goto L181;
            case 77: goto L181;
            case 78: goto L181;
            case 79: goto L181;
            case 80: goto L181;
            case 81: goto L180;
            case 82: goto L181;
            case 83: goto L181;
            case 84: goto L180;
            case 85: goto L181;
            case 86: goto L180;
            case 87: goto L180;
            default: goto L181;
        };
    L181:
        throw new IllegalArgumentException(r12);
    L180:
        throw new IllegalStateException(r12);
    L33:
        r11[1] = "getAnnotationType";
        goto L94
    L34:
        r11[1] = "getEnumType";
        goto L94
    L35:
        r11[1] = "getArrayType";
        goto L94
    L36:
        r11[1] = "getPrimitiveArrayKotlinType";
        goto L94
    L37:
        r11[1] = "getArrayElementType";
        goto L94
    L38:
        r11[1] = "getIterableType";
        goto L94
    L39:
        r11[1] = "getStringType";
        goto L94
    L40:
        r11[1] = "getUnitType";
        goto L94
    L41:
        r11[1] = "getBooleanType";
        goto L94
    L42:
        r11[1] = "getCharType";
        goto L94
    L43:
        r11[1] = "getDoubleType";
        goto L94
    L44:
        r11[1] = "getFloatType";
        goto L94
    L45:
        r11[1] = "getLongType";
        goto L94
    L46:
        r11[1] = "getIntType";
        goto L94
    L47:
        r11[1] = "getShortType";
        goto L94
    L48:
        r11[1] = "getByteType";
        goto L94
    L49:
        r11[1] = "getNumberType";
        goto L94
    L50:
        r11[1] = "getPrimitiveKotlinType";
        goto L94
    L51:
        r11[1] = "getDefaultBound";
        goto L94
    L52:
        r11[1] = "getNullableAnyType";
        goto L94
    L53:
        r11[1] = "getAnyType";
        goto L94
    L54:
        r11[1] = "getNullableNothingType";
        goto L94
    L55:
        r11[1] = "getNothingType";
        goto L94
    L56:
        r11[1] = "getBuiltInTypeByClassName";
        goto L94
    L57:
        r11[1] = "getMutableListIterator";
        goto L94
    L58:
        r11[1] = "getListIterator";
        goto L94
    L59:
        r11[1] = "getMutableMapEntry";
        goto L94
    L60:
        r11[1] = "getMapEntry";
        goto L94
    L61:
        r11[1] = "getMutableMap";
        goto L94
    L62:
        r11[1] = "getMap";
        goto L94
    L63:
        r11[1] = "getMutableSet";
        goto L94
    L64:
        r11[1] = "getSet";
        goto L94
    L65:
        r11[1] = "getMutableList";
        goto L94
    L66:
        r11[1] = "getList";
        goto L94
    L67:
        r11[1] = "getMutableCollection";
        goto L94
    L68:
        r11[1] = "getCollection";
        goto L94
    L69:
        r11[1] = "getMutableIterator";
        goto L94
    L70:
        r11[1] = "getMutableIterable";
        goto L94
    L71:
        r11[1] = "getIterable";
        goto L94
    L72:
        r11[1] = "getIterator";
        goto L94
    L73:
        r11[1] = "getKMutableProperty2";
        goto L94
    L74:
        r11[1] = "getKMutableProperty1";
        goto L94
    L75:
        r11[1] = "getKMutableProperty0";
        goto L94
    L76:
        r11[1] = "getKProperty2";
        goto L94
    L77:
        r11[1] = "getKProperty1";
        goto L94
    L78:
        r11[1] = "getKProperty0";
        goto L94
    L79:
        r11[1] = "getKProperty";
        goto L94
    L80:
        r11[1] = "getKCallable";
        goto L94
    L81:
        r11[1] = "getKClass";
        goto L94
    L82:
        r11[1] = "getKSuspendFunction";
        goto L94
    L83:
        r11[1] = "getKFunction";
        goto L94
    L84:
        r11[1] = "getSuspendFunction";
        goto L94
    L85:
        r11[1] = "getBuiltInClassByName";
        goto L94
    L86:
        r11[1] = "getBuiltInClassByFqName";
        goto L94
    L87:
        r11[1] = "getBuiltInsPackageScope";
        goto L94
    L88:
        r11[1] = "getBuiltInPackagesImportedByDefault";
        goto L94
    L89:
        r11[1] = "getBuiltInsModule";
        goto L94
    L90:
        r11[1] = "getStorageManager";
        goto L94
    L91:
        r11[1] = "getClassDescriptorFactories";
        goto L94
    L92:
        r11[1] = "getPlatformDependentDeclarationFilter";
        goto L94
    L93:
        r11[1] = "getAdditionalClassPartsProvider";
        goto L94
    L12:
        r11[0] = "declarationDescriptor";
        goto L31
    L13:
        r11[0] = "classDescriptor";
        goto L31
    L14:
        r11[0] = "typeConstructor";
        goto L31
    L15:
        r11[0] = "annotations";
        goto L31
    L16:
        r11[0] = "argument";
        goto L31
    L17:
        r11[0] = "projectionType";
        goto L31
    L18:
        r11[0] = "kotlinType";
        goto L31
    L19:
        r11[0] = "primitiveType";
        goto L31
    L20:
        r11[0] = "notNullArrayType";
        goto L31
    L21:
        r11[0] = "arrayType";
        goto L31
    L22:
        r11[0] = "classSimpleName";
        goto L31
    L23:
        r11[0] = "type";
        goto L31
    L24:
        r11[0] = "simpleName";
        goto L31
    L25:
        r11[0] = "fqName";
        goto L31
    L26:
        r11[0] = "descriptor";
        goto L31
    L27:
        r11[0] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
        goto L31
    L28:
        r11[0] = "computation";
        goto L31
    L29:
        r11[0] = "module";
        goto L31
    L8:
        r10 = 2;
        goto L9
    L4:
        r5 = "@NotNull method %s.%s must not return null";
        goto L6
    }

    static {
        BUILTINS_MODULE_NAME = Name.special("<built-ins module>");
    }

    public KotlinBuiltIns(StorageManager r5) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        this.storageManager = r5;
        this.builtInPackagesImportedByDefault = r5.createLazyValue(new AnonymousClass1(this));
        this.primitives = r5.createLazyValue(new AnonymousClass2(this));
        this.builtInClassesByName = r5.createMemoizedFunction(new AnonymousClass3(this));
    }

    public static /* synthetic */ SimpleType access$000(KotlinBuiltIns r5, String r10) {
        return r5.getBuiltInTypeByClassName(r10);
    }

    public static /* synthetic */ ModuleDescriptorImpl access$200(KotlinBuiltIns r5) {
        return r5.builtInsModule;
    }

    public static /* synthetic */ ModuleDescriptorImpl access$202(KotlinBuiltIns r5, ModuleDescriptorImpl r10) {
        r5.builtInsModule = r10;
        return r10;
    }

    private static boolean classFqNameEquals(ClassifierDescriptor r5, FqNameUnsafe r10) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(103);
    L4:
        if (r10 != null) goto L7;
        $$$reportNull$$$0(104);
    L7:
        if (r5.getName().equals(r10.shortName()) == true) goto L9;
    L11:
        return false;
    L9:
        if (r10.equals(DescriptorUtils.getFqName(r5)) == false) goto L11;
        return true;
    }

    private ClassDescriptor getBuiltInClassByName(String r5) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(14);
    L4:
        ClassDescriptor r10 = this.builtInClassesByName.invoke(Name.identifier(r5));
        if (r10 != null) goto L7;
        $$$reportNull$$$0(15);
    L7:
        return r10;
    }

    private SimpleType getBuiltInTypeByClassName(String r5) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(46);
    L4:
        SimpleType r10 = getBuiltInClassByName(r5).getDefaultType();
        if (r10 != null) goto L7;
        $$$reportNull$$$0(47);
    L7:
        return r10;
    }

    private static KotlinType getElementTypeForUnsignedArray(KotlinType r5, ModuleDescriptor r10) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(71);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(72);
    L6:
        ClassifierDescriptor r11 = r5.getConstructor().mo1402getDeclarationDescriptor();
        if (r11 != null) goto L9;
        return null;
    L9:
        UnsignedTypes r12 = UnsignedTypes.INSTANCE;
        if (r12.isShortNameOfUnsignedArray(r11.getName()) == true) goto L12;
        return null;
    L12:
        ClassId r13 = DescriptorUtilsKt.getClassId(r11);
        if (r13 != null) goto L15;
        return null;
    L15:
        ClassId r14 = r12.getUnsignedClassIdByArrayClassId(r13);
        if (r14 != null) goto L18;
        return null;
    L18:
        ClassDescriptor r15 = FindClassInModuleKt.findClassAcrossModuleDependencies(r10, r14);
        if (r15 != null) goto L22;
        return null;
    L22:
        return r15.getDefaultType();
    }

    public static PrimitiveType getPrimitiveArrayElementType(KotlinType r5) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(92);
    L4:
        ClassifierDescriptor r10 = r5.getConstructor().mo1402getDeclarationDescriptor();
        if (r10 != null) goto L8;
        return null;
    L8:
        return getPrimitiveArrayType(r10);
    }

    public static PrimitiveType getPrimitiveArrayType(DeclarationDescriptor r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(77);
    L5:
        if (StandardNames.FqNames.primitiveArrayTypeShortNames.contains(r5.getName()) == true) goto L9;
        return null;
    L9:
        return StandardNames.FqNames.arrayClassFqNameToPrimitiveType.get(DescriptorUtils.getFqName(r5));
    }

    private ClassDescriptor getPrimitiveClassDescriptor(PrimitiveType r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(16);
    L5:
        return getBuiltInClassByName(r5.getTypeName().asString());
    }

    public static PrimitiveType getPrimitiveType(DeclarationDescriptor r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(76);
    L5:
        if (StandardNames.FqNames.primitiveTypeShortNames.contains(r5.getName()) == true) goto L9;
        return null;
    L9:
        return StandardNames.FqNames.fqNameToPrimitiveType.get(DescriptorUtils.getFqName(r5));
    }

    public static boolean isAny(ClassDescriptor r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(108);
    L5:
        return classFqNameEquals(r5, StandardNames.FqNames.any);
    }

    public static boolean isAnyOrNullableAny(KotlinType r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(139);
    L5:
        return isConstructedFromGivenClass(r5, StandardNames.FqNames.any);
    }

    public static boolean isArray(KotlinType r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(88);
    L5:
        return isConstructedFromGivenClass(r5, StandardNames.FqNames.array);
    }

    public static boolean isArrayOrPrimitiveArray(ClassDescriptor r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(89);
    L5:
        if (classFqNameEquals(r5, StandardNames.FqNames.array) == false) goto L7;
    L10:
        return true;
    L7:
        if (getPrimitiveArrayType(r5) != null) goto L10;
        return false;
    }

    public static boolean isBoolean(KotlinType r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(110);
    L5:
        return isConstructedFromGivenClassAndNotNullable(r5, StandardNames.FqNames._boolean);
    }

    public static boolean isBuiltIn(DeclarationDescriptor r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(9);
    L5:
        if (DescriptorUtils.getParentOfType(r5, BuiltInsPackageFragment.class, false) == null) goto L8;
        return true;
    L8:
        return false;
    }

    private static boolean isConstructedFromGivenClass(KotlinType r5, FqNameUnsafe r10) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(97);
    L4:
        if (r10 != null) goto L7;
        $$$reportNull$$$0(98);
    L7:
        return isTypeConstructorForGivenClass(r5.getConstructor(), r10);
    }

    private static boolean isConstructedFromGivenClassAndNotNullable(KotlinType r5, FqNameUnsafe r10) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(134);
    L4:
        if (r10 != null) goto L7;
        $$$reportNull$$$0(135);
    L7:
        if (isConstructedFromGivenClass(r5, r10) == true) goto L9;
    L11:
        return false;
    L9:
        if (r5.isMarkedNullable() == true) goto L11;
        return true;
    }

    public static boolean isDefaultBound(KotlinType r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(141);
    L5:
        return isNullableAny(r5);
    }

    public static boolean isDeprecated(DeclarationDescriptor r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(161);
    L5:
        if (r5.getOriginal().getAnnotations().hasAnnotation(StandardNames.FqNames.deprecated) == false) goto L8;
        return true;
    L8:
        if ((r5 instanceof PropertyDescriptor) == false) goto L20;
        PropertyDescriptor r10 = (PropertyDescriptor) r5;
        boolean r11 = r10.isVar();
        PropertyGetterDescriptor r12 = r10.getGetter();
        PropertySetterDescriptor r13 = r10.getSetter();
        if (r12 == null) goto L19;
        if (isDeprecated(r12) == false) goto L19;
        if (r11 == false) goto L21;
        if (r13 == null) goto L19;
        if (isDeprecated(r13) == false) goto L19;
        return true;
    L21:
        return true;
    L19:
        return false;
    L20:
        return false;
    }

    public static boolean isKClass(ClassDescriptor r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(158);
    L5:
        return classFqNameEquals(r5, StandardNames.FqNames.kClass);
    }

    private static boolean isNotNullConstructedFromGivenClass(KotlinType r5, FqNameUnsafe r10) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(105);
    L4:
        if (r10 != null) goto L7;
        $$$reportNull$$$0(106);
    L7:
        if (r5.isMarkedNullable() == false) goto L9;
    L11:
        return false;
    L9:
        if (isConstructedFromGivenClass(r5, r10) == false) goto L11;
        return true;
    }

    public static boolean isNothing(KotlinType r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(136);
    L5:
        if (isNothingOrNullableNothing(r5) == true) goto L7;
    L9:
        return false;
    L7:
        if (TypeUtils.isNullableType(r5) == true) goto L9;
        return true;
    }

    public static boolean isNothingOrNullableNothing(KotlinType r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(138);
    L5:
        return isConstructedFromGivenClass(r5, StandardNames.FqNames.nothing);
    }

    public static boolean isNullableAny(KotlinType r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(140);
    L5:
        if (isAnyOrNullableAny(r5) == true) goto L7;
    L9:
        return false;
    L7:
        if (r5.isMarkedNullable() == false) goto L9;
        return true;
    }

    public static boolean isPrimitiveArray(KotlinType r5) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(91);
    L4:
        ClassifierDescriptor r10 = r5.getConstructor().mo1402getDeclarationDescriptor();
        if (r10 != null) goto L7;
    L9:
        return false;
    L7:
        if (getPrimitiveArrayType(r10) == null) goto L9;
        return true;
    }

    public static boolean isPrimitiveClass(ClassDescriptor r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(96);
    L5:
        if (getPrimitiveType(r5) == null) goto L7;
        return true;
    L7:
        return false;
    }

    public static boolean isPrimitiveType(KotlinType r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(94);
    L5:
        if (r5.isMarkedNullable() == false) goto L7;
    L9:
        return false;
    L7:
        if (isPrimitiveTypeOrNullablePrimitiveType(r5) == false) goto L9;
        return true;
    }

    public static boolean isPrimitiveTypeOrNullablePrimitiveType(KotlinType r5) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(95);
    L4:
        ClassifierDescriptor r10 = r5.getConstructor().mo1402getDeclarationDescriptor();
        if ((r10 instanceof ClassDescriptor) == true) goto L7;
    L9:
        return false;
    L7:
        if (isPrimitiveClass((ClassDescriptor) r10) == false) goto L9;
        return true;
    }

    public static boolean isSpecialClassWithNoSupertypes(ClassDescriptor r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(107);
    L5:
        if (classFqNameEquals(r5, StandardNames.FqNames.any) == false) goto L7;
    L10:
        return true;
    L7:
        if (classFqNameEquals(r5, StandardNames.FqNames.nothing) == true) goto L10;
        return false;
    }

    public static boolean isString(KotlinType r5) {
        if (r5 != null) goto L4;
    L6:
        return false;
    L4:
        if (isNotNullConstructedFromGivenClass(r5, StandardNames.FqNames.string) == false) goto L6;
        return true;
    }

    public static boolean isTypeConstructorForGivenClass(TypeConstructor r5, FqNameUnsafe r10) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(101);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(102);
    L6:
        ClassifierDescriptor r11 = r5.mo1402getDeclarationDescriptor();
        if ((r11 instanceof ClassDescriptor) == true) goto L9;
    L11:
        return false;
    L9:
        if (classFqNameEquals(r11, r10) == false) goto L11;
        return true;
    }

    public static boolean isUByteArray(KotlinType r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(128);
    L5:
        return isConstructedFromGivenClassAndNotNullable(r5, StandardNames.FqNames.uByteArrayFqName.toUnsafe());
    }

    public static boolean isUIntArray(KotlinType r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(130);
    L5:
        return isConstructedFromGivenClassAndNotNullable(r5, StandardNames.FqNames.uIntArrayFqName.toUnsafe());
    }

    public static boolean isULongArray(KotlinType r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(131);
    L5:
        return isConstructedFromGivenClassAndNotNullable(r5, StandardNames.FqNames.uLongArrayFqName.toUnsafe());
    }

    public static boolean isUShortArray(KotlinType r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(129);
    L5:
        return isConstructedFromGivenClassAndNotNullable(r5, StandardNames.FqNames.uShortArrayFqName.toUnsafe());
    }

    public static boolean isUnderKotlinPackage(DeclarationDescriptor r5) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(10);
    L4:
        if (r5 == null) goto L10;
        if ((r5 instanceof PackageFragmentDescriptor) == true) goto L8;
        r5 = r5.getContainingDeclaration();
        goto L4
    L8:
        return ((PackageFragmentDescriptor) r5).getFqName().startsWith(StandardNames.BUILT_INS_PACKAGE_NAME);
    L10:
        return false;
    }

    public static boolean isUnit(KotlinType r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(142);
    L5:
        return isNotNullConstructedFromGivenClass(r5, StandardNames.FqNames.unit);
    }

    public static boolean isUnsignedArrayType(KotlinType r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(132);
    L5:
        if (isUByteArray(r5) == false) goto L7;
    L14:
        return true;
    L7:
        if (isUShortArray(r5) == true) goto L14;
        if (isUIntArray(r5) == true) goto L14;
        if (isULongArray(r5) == true) goto L14;
        return false;
    }

    public void createBuiltInsModule(boolean r10) {
        ModuleDescriptorImpl r5 = new ModuleDescriptorImpl(BUILTINS_MODULE_NAME, this.storageManager, this, null);
        this.builtInsModule = r5;
        r5.initialize(BuiltInsLoader.Companion.getInstance().createPackageFragmentProvider(this.storageManager, this.builtInsModule, getClassDescriptorFactories(), getPlatformDependentDeclarationFilter(), getAdditionalClassPartsProvider(), r10));
        ModuleDescriptorImpl r11 = this.builtInsModule;
        r11.setDependencies(new ModuleDescriptorImpl[]{r11});
    }

    public AdditionalClassPartsProvider getAdditionalClassPartsProvider() {
        AdditionalClassPartsProvider.None r5 = AdditionalClassPartsProvider.None.INSTANCE;
        if (r5 != null) goto L5;
        $$$reportNull$$$0(3);
    L5:
        return r5;
    }

    public ClassDescriptor getAny() {
        return getBuiltInClassByName("Any");
    }

    public SimpleType getAnyType() {
        SimpleType r5 = getAny().getDefaultType();
        if (r5 != null) goto L5;
        $$$reportNull$$$0(50);
    L5:
        return r5;
    }

    public ClassDescriptor getArray() {
        return getBuiltInClassByName("Array");
    }

    public KotlinType getArrayElementType(KotlinType r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(67);
    L5:
        if (isArray(r5) == true) goto L7;
        KotlinType r10 = TypeUtils.makeNotNullable(r5);
        SimpleType r11 = this.primitives.invoke().kotlinArrayTypeToPrimitiveKotlinType.get(r10);
        if (r11 == null) goto L17;
        return r11;
    L17:
        ModuleDescriptor r12 = DescriptorUtils.getContainingModuleOrNull(r10);
        if (r12 == null) goto L23;
        KotlinType r13 = getElementTypeForUnsignedArray(r10, r12);
        if (r13 == null) goto L23;
        return r13;
    L23:
        throw new IllegalStateException("not array: " + r5);
    L7:
        if (r5.getArguments().size() != 1) goto L13;
        KotlinType r14 = r5.getArguments().get(0).getType();
        if (r14 != null) goto L11;
        $$$reportNull$$$0(68);
    L11:
        return r14;
    L13:
        throw new IllegalStateException();
    }

    public SimpleType getArrayType(Variance r5, KotlinType r10, Annotations r11) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(78);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(79);
    L6:
        if (r11 != null) goto L8;
        $$$reportNull$$$0(80);
    L8:
        List r12 = Collections.singletonList(new TypeProjectionImpl(r5, r10));
        SimpleType r13 = KotlinTypeFactory.simpleNotNullType(TypeAttributesKt.toDefaultAttributes(r11), getArray(), r12);
        if (r13 != null) goto L11;
        $$$reportNull$$$0(81);
    L11:
        return r13;
    }

    public SimpleType getBooleanType() {
        SimpleType r5 = getPrimitiveKotlinType(PrimitiveType.BOOLEAN);
        if (r5 != null) goto L5;
        $$$reportNull$$$0(63);
    L5:
        return r5;
    }

    public ClassDescriptor getBuiltInClassByFqName(FqName r5) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(12);
    L4:
        ClassDescriptor r10 = DescriptorUtilKt.resolveClassByFqName(getBuiltInsModule(), r5, NoLookupLocation.FROM_BUILTINS);
        if (r10 != null) goto L7;
        $$$reportNull$$$0(13);
    L7:
        return r10;
    }

    public ModuleDescriptorImpl getBuiltInsModule() {
        if (this.builtInsModule != null) goto L5;
        this.builtInsModule = this.postponedBuiltInsModule.invoke();
    L5:
        ModuleDescriptorImpl r5 = this.builtInsModule;
        if (r5 != null) goto L8;
        $$$reportNull$$$0(7);
    L8:
        return r5;
    }

    public MemberScope getBuiltInsPackageScope() {
        MemberScope r5 = getBuiltInsModule().getPackage(StandardNames.BUILT_INS_PACKAGE_FQ_NAME).getMemberScope();
        if (r5 != null) goto L5;
        $$$reportNull$$$0(11);
    L5:
        return r5;
    }

    public SimpleType getByteType() {
        SimpleType r5 = getPrimitiveKotlinType(PrimitiveType.BYTE);
        if (r5 != null) goto L5;
        $$$reportNull$$$0(56);
    L5:
        return r5;
    }

    public SimpleType getCharType() {
        SimpleType r5 = getPrimitiveKotlinType(PrimitiveType.CHAR);
        if (r5 != null) goto L5;
        $$$reportNull$$$0(62);
    L5:
        return r5;
    }

    public Iterable<ClassDescriptorFactory> getClassDescriptorFactories() {
        List r5 = Collections.singletonList(new BuiltInFictitiousFunctionClassFactory(this.storageManager, getBuiltInsModule()));
        if (r5 != null) goto L5;
        $$$reportNull$$$0(5);
    L5:
        return r5;
    }

    public ClassDescriptor getCollection() {
        ClassDescriptor r5 = getBuiltInClassByFqName(StandardNames.FqNames.collection);
        if (r5 != null) goto L5;
        $$$reportNull$$$0(34);
    L5:
        return r5;
    }

    public ClassDescriptor getComparable() {
        return getBuiltInClassByName("Comparable");
    }

    public SimpleType getDefaultBound() {
        SimpleType r5 = getNullableAnyType();
        if (r5 != null) goto L5;
        $$$reportNull$$$0(52);
    L5:
        return r5;
    }

    public SimpleType getDoubleType() {
        SimpleType r5 = getPrimitiveKotlinType(PrimitiveType.DOUBLE);
        if (r5 != null) goto L5;
        $$$reportNull$$$0(61);
    L5:
        return r5;
    }

    public SimpleType getFloatType() {
        SimpleType r5 = getPrimitiveKotlinType(PrimitiveType.FLOAT);
        if (r5 != null) goto L5;
        $$$reportNull$$$0(60);
    L5:
        return r5;
    }

    public ClassDescriptor getFunction(int r5) {
        return getBuiltInClassByName(StandardNames.getFunctionName(r5));
    }

    public SimpleType getIntType() {
        SimpleType r5 = getPrimitiveKotlinType(PrimitiveType.INT);
        if (r5 != null) goto L5;
        $$$reportNull$$$0(58);
    L5:
        return r5;
    }

    public ClassDescriptor getKClass() {
        ClassDescriptor r5 = getBuiltInClassByFqName(StandardNames.FqNames.kClass.toSafe());
        if (r5 != null) goto L5;
        $$$reportNull$$$0(21);
    L5:
        return r5;
    }

    public SimpleType getLongType() {
        SimpleType r5 = getPrimitiveKotlinType(PrimitiveType.LONG);
        if (r5 != null) goto L5;
        $$$reportNull$$$0(59);
    L5:
        return r5;
    }

    public ClassDescriptor getNothing() {
        return getBuiltInClassByName("Nothing");
    }

    public SimpleType getNothingType() {
        SimpleType r5 = getNothing().getDefaultType();
        if (r5 != null) goto L5;
        $$$reportNull$$$0(48);
    L5:
        return r5;
    }

    public SimpleType getNullableAnyType() {
        SimpleType r5 = getAnyType().makeNullableAsSpecified(true);
        if (r5 != null) goto L5;
        $$$reportNull$$$0(51);
    L5:
        return r5;
    }

    public SimpleType getNullableNothingType() {
        SimpleType r5 = getNothingType().makeNullableAsSpecified(true);
        if (r5 != null) goto L5;
        $$$reportNull$$$0(49);
    L5:
        return r5;
    }

    public ClassDescriptor getNumber() {
        return getBuiltInClassByName("Number");
    }

    public SimpleType getNumberType() {
        SimpleType r5 = getNumber().getDefaultType();
        if (r5 != null) goto L5;
        $$$reportNull$$$0(55);
    L5:
        return r5;
    }

    public PlatformDependentDeclarationFilter getPlatformDependentDeclarationFilter() {
        PlatformDependentDeclarationFilter.NoPlatformDependent r5 = PlatformDependentDeclarationFilter.NoPlatformDependent.INSTANCE;
        if (r5 != null) goto L5;
        $$$reportNull$$$0(4);
    L5:
        return r5;
    }

    public SimpleType getPrimitiveArrayKotlinType(PrimitiveType r5) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(73);
    L4:
        SimpleType r10 = this.primitives.invoke().primitiveTypeToArrayKotlinType.get(r5);
        if (r10 != null) goto L7;
        $$$reportNull$$$0(74);
    L7:
        return r10;
    }

    public SimpleType getPrimitiveKotlinType(PrimitiveType r5) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(53);
    L4:
        SimpleType r10 = getPrimitiveClassDescriptor(r5).getDefaultType();
        if (r10 != null) goto L7;
        $$$reportNull$$$0(54);
    L7:
        return r10;
    }

    public SimpleType getShortType() {
        SimpleType r5 = getPrimitiveKotlinType(PrimitiveType.SHORT);
        if (r5 != null) goto L5;
        $$$reportNull$$$0(57);
    L5:
        return r5;
    }

    public StorageManager getStorageManager() {
        StorageManager r5 = this.storageManager;
        if (r5 != null) goto L5;
        $$$reportNull$$$0(6);
    L5:
        return r5;
    }

    public ClassDescriptor getString() {
        return getBuiltInClassByName("String");
    }

    public SimpleType getStringType() {
        SimpleType r5 = getString().getDefaultType();
        if (r5 != null) goto L5;
        $$$reportNull$$$0(65);
    L5:
        return r5;
    }

    public ClassDescriptor getSuspendFunction(int r5) {
        ClassDescriptor r10 = getBuiltInClassByFqName(StandardNames.COROUTINES_PACKAGE_FQ_NAME.child(Name.identifier(StandardNames.getSuspendFunctionName(r5))));
        if (r10 != null) goto L5;
        $$$reportNull$$$0(18);
    L5:
        return r10;
    }

    public ClassDescriptor getUnit() {
        return getBuiltInClassByName("Unit");
    }

    public SimpleType getUnitType() {
        SimpleType r5 = getUnit().getDefaultType();
        if (r5 != null) goto L5;
        $$$reportNull$$$0(64);
    L5:
        return r5;
    }

    public void setBuiltInsModule(final ModuleDescriptorImpl r5) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(1);
    L4:
        this.storageManager.compute(new AnonymousClass4(this, r5));
    }

    public static boolean isArrayOrPrimitiveArray(KotlinType r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(90);
    L5:
        if (isArray(r5) == false) goto L7;
    L10:
        return true;
    L7:
        if (isPrimitiveArray(r5) == true) goto L10;
        return false;
    }

    public SimpleType getArrayType(Variance r5, KotlinType r10) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(82);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(83);
    L6:
        SimpleType r11 = getArrayType(r5, r10, Annotations.Companion.getEMPTY());
        if (r11 != null) goto L9;
        $$$reportNull$$$0(84);
    L9:
        return r11;
    }
}
