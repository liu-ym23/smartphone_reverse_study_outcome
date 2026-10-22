package kotlin.reflect.jvm.internal.impl.builtins;

import com.bytedance.common.wschannel.WsConstants;
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

    private static class Primitives {
        public final Map<SimpleType, SimpleType> kotlinArrayTypeToPrimitiveKotlinType;
        public final Map<KotlinType, SimpleType> primitiveKotlinTypeToKotlinArrayType;
        public final Map<PrimitiveType, SimpleType> primitiveTypeToArrayKotlinType;

        private static /* synthetic */ void $$$reportNull$$$0(int r10) {
            Object[] r11 = new Object[3];
            if (r10 == 1) goto L7;
            if (r10 == 2) goto L6;
            r11[0] = "primitiveTypeToArrayKotlinType";
        L8:
            r11[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$Primitives";
            r11[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r11));
        L6:
            r11[0] = "kotlinArrayTypeToPrimitiveKotlinType";
            goto L8
        L7:
            r11[0] = "primitiveKotlinTypeToKotlinArrayType";
            goto L8
        }

        private Primitives(Map<PrimitiveType, SimpleType> r10, Map<KotlinType, SimpleType> r11, Map<SimpleType, SimpleType> r12) {
            if (r10 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r11 != null) goto L6;
            $$$reportNull$$$0(1);
        L6:
            if (r12 != null) goto L8;
            $$$reportNull$$$0(2);
        L8:
            this.primitiveTypeToArrayKotlinType = r10;
            this.primitiveKotlinTypeToKotlinArrayType = r11;
            this.kotlinArrayTypeToPrimitiveKotlinType = r12;
        }

        /* synthetic */ Primitives(Map r10, Map r11, Map r12, AnonymousClass1 r13) {
            this(r10, r11, r12);
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
        String r10 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
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
        int r11 = 3;
    L9:
        Object[] r12 = new Object[r11];
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
        r12[0] = "storageManager";
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
        r12[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
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
        r12[2] = "<init>";
        goto L176
    L96:
        r12[2] = "isNotNullOrNullableFunctionSupertype";
        goto L176
    L97:
        r12[2] = "isDeprecated";
        goto L176
    L98:
        r12[2] = "isCloneable";
        goto L176
    L99:
        r12[2] = "isNonPrimitiveArray";
        goto L176
    L100:
        r12[2] = "isKClass";
        goto L176
    L101:
        r12[2] = "isThrowable";
        goto L176
    L102:
        r12[2] = "isThrowableOrNullableThrowable";
        goto L176
    L103:
        r12[2] = "isIterableOrNullableIterable";
        goto L176
    L104:
        r12[2] = "isMapOrNullableMap";
        goto L176
    L105:
        r12[2] = "isSetOrNullableSet";
        goto L176
    L106:
        r12[2] = "isListOrNullableList";
        goto L176
    L107:
        r12[2] = "isCollectionOrNullableCollection";
        goto L176
    L108:
        r12[2] = "isComparable";
        goto L176
    L109:
        r12[2] = "isEnum";
        goto L176
    L110:
        r12[2] = "isMemberOfAny";
        goto L176
    L111:
        r12[2] = "isBooleanOrSubtype";
        goto L176
    L112:
        r12[2] = "isUnitOrNullableUnit";
        goto L176
    L113:
        r12[2] = "mayReturnNonUnitValue";
        goto L176
    L114:
        r12[2] = "isUnit";
        goto L176
    L115:
        r12[2] = "isDefaultBound";
        goto L176
    L116:
        r12[2] = "isNullableAny";
        goto L176
    L117:
        r12[2] = "isAnyOrNullableAny";
        goto L176
    L118:
        r12[2] = "isNothingOrNullableNothing";
        goto L176
    L119:
        r12[2] = "isNullableNothing";
        goto L176
    L120:
        r12[2] = "isNothing";
        goto L176
    L121:
        r12[2] = "isConstructedFromGivenClassAndNotNullable";
        goto L176
    L122:
        r12[2] = "isDoubleOrNullableDouble";
        goto L176
    L123:
        r12[2] = "isUnsignedArrayType";
        goto L176
    L124:
        r12[2] = "isULongArray";
        goto L176
    L125:
        r12[2] = "isUIntArray";
        goto L176
    L126:
        r12[2] = "isUShortArray";
        goto L176
    L127:
        r12[2] = "isUByteArray";
        goto L176
    L128:
        r12[2] = "isULong";
        goto L176
    L129:
        r12[2] = "isUInt";
        goto L176
    L130:
        r12[2] = "isUShort";
        goto L176
    L131:
        r12[2] = "isUByte";
        goto L176
    L132:
        r12[2] = "isDouble";
        goto L176
    L133:
        r12[2] = "isFloatOrNullableFloat";
        goto L176
    L134:
        r12[2] = "isFloat";
        goto L176
    L135:
        r12[2] = "isShort";
        goto L176
    L136:
        r12[2] = "isLongOrNullableLong";
        goto L176
    L137:
        r12[2] = "isLong";
        goto L176
    L138:
        r12[2] = "isByte";
        goto L176
    L139:
        r12[2] = "isInt";
        goto L176
    L140:
        r12[2] = "isCharOrNullableChar";
        goto L176
    L141:
        r12[2] = "isChar";
        goto L176
    L142:
        r12[2] = "isNumber";
        goto L176
    L143:
        r12[2] = "isBooleanOrNullableBoolean";
        goto L176
    L144:
        r12[2] = "isBoolean";
        goto L176
    L145:
        r12[2] = "isAny";
        goto L176
    L146:
        r12[2] = "isSpecialClassWithNoSupertypes";
        goto L176
    L147:
        r12[2] = "isNotNullConstructedFromGivenClass";
        goto L176
    L148:
        r12[2] = "classFqNameEquals";
        goto L176
    L149:
        r12[2] = "isTypeConstructorForGivenClass";
        goto L176
    L150:
        r12[2] = "isConstructedFromGivenClass";
        goto L176
    L151:
        r12[2] = "isPrimitiveClass";
        goto L176
    L152:
        r12[2] = "isPrimitiveTypeOrNullablePrimitiveType";
        goto L176
    L153:
        r12[2] = "isPrimitiveType";
        goto L176
    L154:
        r12[2] = "getPrimitiveArrayElementType";
        goto L176
    L155:
        r12[2] = "isPrimitiveArray";
        goto L176
    L156:
        r12[2] = "isArrayOrPrimitiveArray";
        goto L176
    L157:
        r12[2] = "isArray";
        goto L176
    L158:
        r12[2] = "getEnumType";
        goto L176
    L159:
        r12[2] = "getArrayType";
        goto L176
    L160:
        r12[2] = "getPrimitiveArrayType";
        goto L176
    L161:
        r12[2] = "getPrimitiveType";
        goto L176
    L162:
        r12[2] = "getPrimitiveArrayKotlinTypeByPrimitiveKotlinType";
        goto L176
    L163:
        r12[2] = "getPrimitiveArrayKotlinType";
        goto L176
    L164:
        r12[2] = "getElementTypeForUnsignedArray";
        goto L176
    L165:
        r12[2] = "getArrayElementType";
        goto L176
    L166:
        r12[2] = "getPrimitiveKotlinType";
        goto L176
    L167:
        r12[2] = "getBuiltInTypeByClassName";
        goto L176
    L168:
        r12[2] = "getPrimitiveArrayClassDescriptor";
        goto L176
    L169:
        r12[2] = "getPrimitiveClassDescriptor";
        goto L176
    L170:
        r12[2] = "getBuiltInClassByName";
        goto L176
    L171:
        r12[2] = "getBuiltInClassByFqName";
        goto L176
    L172:
        r12[2] = "isUnderKotlinPackage";
        goto L176
    L173:
        r12[2] = "isBuiltIn";
        goto L176
    L174:
        r12[2] = "setPostponedBuiltinsModuleComputation";
        goto L176
    L175:
        r12[2] = "setBuiltInsModule";
    L176:
        String r14 = String.format(r10, r12);
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
        throw new IllegalArgumentException(r14);
    L180:
        throw new IllegalStateException(r14);
    L33:
        r12[1] = "getAnnotationType";
        goto L94
    L34:
        r12[1] = "getEnumType";
        goto L94
    L35:
        r12[1] = "getArrayType";
        goto L94
    L36:
        r12[1] = "getPrimitiveArrayKotlinType";
        goto L94
    L37:
        r12[1] = "getArrayElementType";
        goto L94
    L38:
        r12[1] = "getIterableType";
        goto L94
    L39:
        r12[1] = "getStringType";
        goto L94
    L40:
        r12[1] = "getUnitType";
        goto L94
    L41:
        r12[1] = "getBooleanType";
        goto L94
    L42:
        r12[1] = "getCharType";
        goto L94
    L43:
        r12[1] = "getDoubleType";
        goto L94
    L44:
        r12[1] = "getFloatType";
        goto L94
    L45:
        r12[1] = "getLongType";
        goto L94
    L46:
        r12[1] = "getIntType";
        goto L94
    L47:
        r12[1] = "getShortType";
        goto L94
    L48:
        r12[1] = "getByteType";
        goto L94
    L49:
        r12[1] = "getNumberType";
        goto L94
    L50:
        r12[1] = "getPrimitiveKotlinType";
        goto L94
    L51:
        r12[1] = "getDefaultBound";
        goto L94
    L52:
        r12[1] = "getNullableAnyType";
        goto L94
    L53:
        r12[1] = "getAnyType";
        goto L94
    L54:
        r12[1] = "getNullableNothingType";
        goto L94
    L55:
        r12[1] = "getNothingType";
        goto L94
    L56:
        r12[1] = "getBuiltInTypeByClassName";
        goto L94
    L57:
        r12[1] = "getMutableListIterator";
        goto L94
    L58:
        r12[1] = "getListIterator";
        goto L94
    L59:
        r12[1] = "getMutableMapEntry";
        goto L94
    L60:
        r12[1] = "getMapEntry";
        goto L94
    L61:
        r12[1] = "getMutableMap";
        goto L94
    L62:
        r12[1] = "getMap";
        goto L94
    L63:
        r12[1] = "getMutableSet";
        goto L94
    L64:
        r12[1] = "getSet";
        goto L94
    L65:
        r12[1] = "getMutableList";
        goto L94
    L66:
        r12[1] = "getList";
        goto L94
    L67:
        r12[1] = "getMutableCollection";
        goto L94
    L68:
        r12[1] = "getCollection";
        goto L94
    L69:
        r12[1] = "getMutableIterator";
        goto L94
    L70:
        r12[1] = "getMutableIterable";
        goto L94
    L71:
        r12[1] = "getIterable";
        goto L94
    L72:
        r12[1] = "getIterator";
        goto L94
    L73:
        r12[1] = "getKMutableProperty2";
        goto L94
    L74:
        r12[1] = "getKMutableProperty1";
        goto L94
    L75:
        r12[1] = "getKMutableProperty0";
        goto L94
    L76:
        r12[1] = "getKProperty2";
        goto L94
    L77:
        r12[1] = "getKProperty1";
        goto L94
    L78:
        r12[1] = "getKProperty0";
        goto L94
    L79:
        r12[1] = "getKProperty";
        goto L94
    L80:
        r12[1] = "getKCallable";
        goto L94
    L81:
        r12[1] = "getKClass";
        goto L94
    L82:
        r12[1] = "getKSuspendFunction";
        goto L94
    L83:
        r12[1] = "getKFunction";
        goto L94
    L84:
        r12[1] = "getSuspendFunction";
        goto L94
    L85:
        r12[1] = "getBuiltInClassByName";
        goto L94
    L86:
        r12[1] = "getBuiltInClassByFqName";
        goto L94
    L87:
        r12[1] = "getBuiltInsPackageScope";
        goto L94
    L88:
        r12[1] = "getBuiltInPackagesImportedByDefault";
        goto L94
    L89:
        r12[1] = "getBuiltInsModule";
        goto L94
    L90:
        r12[1] = "getStorageManager";
        goto L94
    L91:
        r12[1] = "getClassDescriptorFactories";
        goto L94
    L92:
        r12[1] = "getPlatformDependentDeclarationFilter";
        goto L94
    L93:
        r12[1] = "getAdditionalClassPartsProvider";
        goto L94
    L12:
        r12[0] = "declarationDescriptor";
        goto L31
    L13:
        r12[0] = "classDescriptor";
        goto L31
    L14:
        r12[0] = "typeConstructor";
        goto L31
    L15:
        r12[0] = "annotations";
        goto L31
    L16:
        r12[0] = "argument";
        goto L31
    L17:
        r12[0] = "projectionType";
        goto L31
    L18:
        r12[0] = "kotlinType";
        goto L31
    L19:
        r12[0] = "primitiveType";
        goto L31
    L20:
        r12[0] = "notNullArrayType";
        goto L31
    L21:
        r12[0] = "arrayType";
        goto L31
    L22:
        r12[0] = "classSimpleName";
        goto L31
    L23:
        r12[0] = WsConstants.KEY_CONNECTION_TYPE;
        goto L31
    L24:
        r12[0] = "simpleName";
        goto L31
    L25:
        r12[0] = "fqName";
        goto L31
    L26:
        r12[0] = "descriptor";
        goto L31
    L27:
        r12[0] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
        goto L31
    L28:
        r12[0] = "computation";
        goto L31
    L29:
        r12[0] = "module";
        goto L31
    L8:
        r11 = 2;
        goto L9
    L4:
        r10 = "@NotNull method %s.%s must not return null";
        goto L6
    }

    static {
        BUILTINS_MODULE_NAME = Name.special("<built-ins module>");
    }

    protected KotlinBuiltIns(StorageManager r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        this.storageManager = r10;
        this.builtInPackagesImportedByDefault = r10.createLazyValue(new AnonymousClass1(this));
        this.primitives = r10.createLazyValue(new AnonymousClass2(this));
        this.builtInClassesByName = r10.createMemoizedFunction(new AnonymousClass3(this));
    }

    static /* synthetic */ SimpleType access$000(KotlinBuiltIns r10, String r11) {
        return r10.getBuiltInTypeByClassName(r11);
    }

    static /* synthetic */ ModuleDescriptorImpl access$200(KotlinBuiltIns r10) {
        return r10.builtInsModule;
    }

    static /* synthetic */ ModuleDescriptorImpl access$202(KotlinBuiltIns r10, ModuleDescriptorImpl r11) {
        r10.builtInsModule = r11;
        return r11;
    }

    private static boolean classFqNameEquals(ClassifierDescriptor r10, FqNameUnsafe r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(103);
    L4:
        if (r11 != null) goto L7;
        $$$reportNull$$$0(104);
    L7:
        if (r10.getName().equals(r11.shortName()) == true) goto L9;
    L11:
        return false;
    L9:
        if (r11.equals(DescriptorUtils.getFqName(r10)) == false) goto L11;
        return true;
    }

    private ClassDescriptor getBuiltInClassByName(String r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(14);
    L4:
        ClassDescriptor r11 = this.builtInClassesByName.invoke(Name.identifier(r10));
        if (r11 != null) goto L7;
        $$$reportNull$$$0(15);
    L7:
        return r11;
    }

    private SimpleType getBuiltInTypeByClassName(String r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(46);
    L4:
        SimpleType r11 = getBuiltInClassByName(r10).getDefaultType();
        if (r11 != null) goto L7;
        $$$reportNull$$$0(47);
    L7:
        return r11;
    }

    private static KotlinType getElementTypeForUnsignedArray(KotlinType r10, ModuleDescriptor r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(71);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(72);
    L6:
        ClassifierDescriptor r12 = r10.getConstructor().mo1323getDeclarationDescriptor();
        if (r12 != null) goto L9;
        return null;
    L9:
        UnsignedTypes r13 = UnsignedTypes.INSTANCE;
        if (r13.isShortNameOfUnsignedArray(r12.getName()) == true) goto L12;
        return null;
    L12:
        ClassId r14 = DescriptorUtilsKt.getClassId(r12);
        if (r14 != null) goto L15;
        return null;
    L15:
        ClassId r15 = r13.getUnsignedClassIdByArrayClassId(r14);
        if (r15 != null) goto L18;
        return null;
    L18:
        ClassDescriptor r16 = FindClassInModuleKt.findClassAcrossModuleDependencies(r11, r15);
        if (r16 != null) goto L22;
        return null;
    L22:
        return r16.getDefaultType();
    }

    public static PrimitiveType getPrimitiveArrayElementType(KotlinType r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(92);
    L4:
        ClassifierDescriptor r11 = r10.getConstructor().mo1323getDeclarationDescriptor();
        if (r11 != null) goto L8;
        return null;
    L8:
        return getPrimitiveArrayType(r11);
    }

    public static PrimitiveType getPrimitiveArrayType(DeclarationDescriptor r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(77);
    L5:
        if (StandardNames.FqNames.primitiveArrayTypeShortNames.contains(r10.getName()) == true) goto L9;
        return null;
    L9:
        return StandardNames.FqNames.arrayClassFqNameToPrimitiveType.get(DescriptorUtils.getFqName(r10));
    }

    private ClassDescriptor getPrimitiveClassDescriptor(PrimitiveType r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(16);
    L5:
        return getBuiltInClassByName(r10.getTypeName().asString());
    }

    public static PrimitiveType getPrimitiveType(DeclarationDescriptor r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(76);
    L5:
        if (StandardNames.FqNames.primitiveTypeShortNames.contains(r10.getName()) == true) goto L9;
        return null;
    L9:
        return StandardNames.FqNames.fqNameToPrimitiveType.get(DescriptorUtils.getFqName(r10));
    }

    public static boolean isAny(ClassDescriptor r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(108);
    L5:
        return classFqNameEquals(r10, StandardNames.FqNames.any);
    }

    public static boolean isAnyOrNullableAny(KotlinType r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(139);
    L5:
        return isConstructedFromGivenClass(r10, StandardNames.FqNames.any);
    }

    public static boolean isArray(KotlinType r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(88);
    L5:
        return isConstructedFromGivenClass(r10, StandardNames.FqNames.array);
    }

    public static boolean isArrayOrPrimitiveArray(ClassDescriptor r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(89);
    L5:
        if (classFqNameEquals(r10, StandardNames.FqNames.array) == false) goto L7;
    L10:
        return true;
    L7:
        if (getPrimitiveArrayType(r10) != null) goto L10;
        return false;
    }

    public static boolean isArrayOrPrimitiveArray(KotlinType r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(90);
    L5:
        if (isArray(r10) == false) goto L7;
    L10:
        return true;
    L7:
        if (isPrimitiveArray(r10) == true) goto L10;
        return false;
    }

    public static boolean isBuiltIn(DeclarationDescriptor r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(9);
    L5:
        if (DescriptorUtils.getParentOfType(r10, BuiltInsPackageFragment.class, false) == null) goto L8;
        return true;
    L8:
        return false;
    }

    private static boolean isConstructedFromGivenClass(KotlinType r10, FqNameUnsafe r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(97);
    L4:
        if (r11 != null) goto L7;
        $$$reportNull$$$0(98);
    L7:
        return isTypeConstructorForGivenClass(r10.getConstructor(), r11);
    }

    private static boolean isConstructedFromGivenClassAndNotNullable(KotlinType r10, FqNameUnsafe r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(134);
    L4:
        if (r11 != null) goto L7;
        $$$reportNull$$$0(135);
    L7:
        if (isConstructedFromGivenClass(r10, r11) == true) goto L9;
    L11:
        return false;
    L9:
        if (r10.isMarkedNullable() == true) goto L11;
        return true;
    }

    public static boolean isDefaultBound(KotlinType r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(141);
    L5:
        return isNullableAny(r10);
    }

    public static boolean isDeprecated(DeclarationDescriptor r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(161);
    L5:
        if (r10.getOriginal().getAnnotations().hasAnnotation(StandardNames.FqNames.deprecated) == false) goto L8;
        return true;
    L8:
        if ((r10 instanceof PropertyDescriptor) == false) goto L20;
        PropertyDescriptor r11 = (PropertyDescriptor) r10;
        boolean r12 = r11.isVar();
        PropertyGetterDescriptor r13 = r11.getGetter();
        PropertySetterDescriptor r14 = r11.getSetter();
        if (r13 == null) goto L19;
        if (isDeprecated(r13) == false) goto L19;
        if (r12 == false) goto L21;
        if (r14 == null) goto L19;
        if (isDeprecated(r14) == false) goto L19;
        return true;
    L21:
        return true;
    L19:
        return false;
    L20:
        return false;
    }

    public static boolean isKClass(ClassDescriptor r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(158);
    L5:
        return classFqNameEquals(r10, StandardNames.FqNames.kClass);
    }

    private static boolean isNotNullConstructedFromGivenClass(KotlinType r10, FqNameUnsafe r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(105);
    L4:
        if (r11 != null) goto L7;
        $$$reportNull$$$0(106);
    L7:
        if (r10.isMarkedNullable() == false) goto L9;
    L11:
        return false;
    L9:
        if (isConstructedFromGivenClass(r10, r11) == false) goto L11;
        return true;
    }

    public static boolean isNothing(KotlinType r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(136);
    L5:
        if (isNothingOrNullableNothing(r10) == true) goto L7;
    L9:
        return false;
    L7:
        if (TypeUtils.isNullableType(r10) == true) goto L9;
        return true;
    }

    public static boolean isNothingOrNullableNothing(KotlinType r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(138);
    L5:
        return isConstructedFromGivenClass(r10, StandardNames.FqNames.nothing);
    }

    public static boolean isNullableAny(KotlinType r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(140);
    L5:
        if (isAnyOrNullableAny(r10) == true) goto L7;
    L9:
        return false;
    L7:
        if (r10.isMarkedNullable() == false) goto L9;
        return true;
    }

    public static boolean isPrimitiveArray(KotlinType r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(91);
    L4:
        ClassifierDescriptor r11 = r10.getConstructor().mo1323getDeclarationDescriptor();
        if (r11 != null) goto L7;
    L9:
        return false;
    L7:
        if (getPrimitiveArrayType(r11) == null) goto L9;
        return true;
    }

    public static boolean isPrimitiveClass(ClassDescriptor r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(96);
    L5:
        if (getPrimitiveType(r10) == null) goto L7;
        return true;
    L7:
        return false;
    }

    public static boolean isPrimitiveType(KotlinType r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(94);
    L5:
        if (r10.isMarkedNullable() == false) goto L7;
    L9:
        return false;
    L7:
        if (isPrimitiveTypeOrNullablePrimitiveType(r10) == false) goto L9;
        return true;
    }

    public static boolean isPrimitiveTypeOrNullablePrimitiveType(KotlinType r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(95);
    L4:
        ClassifierDescriptor r11 = r10.getConstructor().mo1323getDeclarationDescriptor();
        if ((r11 instanceof ClassDescriptor) == true) goto L7;
    L9:
        return false;
    L7:
        if (isPrimitiveClass((ClassDescriptor) r11) == false) goto L9;
        return true;
    }

    public static boolean isSpecialClassWithNoSupertypes(ClassDescriptor r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(107);
    L5:
        if (classFqNameEquals(r10, StandardNames.FqNames.any) == false) goto L7;
    L10:
        return true;
    L7:
        if (classFqNameEquals(r10, StandardNames.FqNames.nothing) == true) goto L10;
        return false;
    }

    public static boolean isString(KotlinType r10) {
        if (r10 != null) goto L4;
    L6:
        return false;
    L4:
        if (isNotNullConstructedFromGivenClass(r10, StandardNames.FqNames.string) == false) goto L6;
        return true;
    }

    public static boolean isTypeConstructorForGivenClass(TypeConstructor r10, FqNameUnsafe r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(101);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(102);
    L6:
        ClassifierDescriptor r12 = r10.mo1323getDeclarationDescriptor();
        if ((r12 instanceof ClassDescriptor) == true) goto L9;
    L11:
        return false;
    L9:
        if (classFqNameEquals(r12, r11) == false) goto L11;
        return true;
    }

    public static boolean isUByteArray(KotlinType r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(128);
    L5:
        return isConstructedFromGivenClassAndNotNullable(r10, StandardNames.FqNames.uByteArrayFqName.toUnsafe());
    }

    public static boolean isUIntArray(KotlinType r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(130);
    L5:
        return isConstructedFromGivenClassAndNotNullable(r10, StandardNames.FqNames.uIntArrayFqName.toUnsafe());
    }

    public static boolean isULongArray(KotlinType r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(131);
    L5:
        return isConstructedFromGivenClassAndNotNullable(r10, StandardNames.FqNames.uLongArrayFqName.toUnsafe());
    }

    public static boolean isUShortArray(KotlinType r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(129);
    L5:
        return isConstructedFromGivenClassAndNotNullable(r10, StandardNames.FqNames.uShortArrayFqName.toUnsafe());
    }

    public static boolean isUnderKotlinPackage(DeclarationDescriptor r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(10);
    L4:
        if (r10 == null) goto L10;
        if ((r10 instanceof PackageFragmentDescriptor) == true) goto L8;
        r10 = r10.getContainingDeclaration();
        goto L4
    L8:
        return ((PackageFragmentDescriptor) r10).getFqName().startsWith(StandardNames.BUILT_INS_PACKAGE_NAME);
    L10:
        return false;
    }

    public static boolean isUnit(KotlinType r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(142);
    L5:
        return isNotNullConstructedFromGivenClass(r10, StandardNames.FqNames.unit);
    }

    public static boolean isUnsignedArrayType(KotlinType r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(132);
    L5:
        if (isUByteArray(r10) == false) goto L7;
    L14:
        return true;
    L7:
        if (isUShortArray(r10) == true) goto L14;
        if (isUIntArray(r10) == true) goto L14;
        if (isULongArray(r10) == true) goto L14;
        return false;
    }

    protected void createBuiltInsModule(boolean r10) {
        ModuleDescriptorImpl r11 = new ModuleDescriptorImpl(BUILTINS_MODULE_NAME, this.storageManager, this, null);
        this.builtInsModule = r11;
        r11.initialize(BuiltInsLoader.Companion.getInstance().createPackageFragmentProvider(this.storageManager, this.builtInsModule, getClassDescriptorFactories(), getPlatformDependentDeclarationFilter(), getAdditionalClassPartsProvider(), r10));
        ModuleDescriptorImpl r12 = this.builtInsModule;
        r12.setDependencies(new ModuleDescriptorImpl[]{r12});
    }

    protected AdditionalClassPartsProvider getAdditionalClassPartsProvider() {
        AdditionalClassPartsProvider.None r10 = AdditionalClassPartsProvider.None.INSTANCE;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(3);
    L5:
        return r10;
    }

    public ClassDescriptor getAny() {
        return getBuiltInClassByName("Any");
    }

    public SimpleType getAnyType() {
        SimpleType r10 = getAny().getDefaultType();
        if (r10 != null) goto L5;
        $$$reportNull$$$0(50);
    L5:
        return r10;
    }

    public ClassDescriptor getArray() {
        return getBuiltInClassByName("Array");
    }

    public KotlinType getArrayElementType(KotlinType r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(67);
    L5:
        if (isArray(r10) == true) goto L7;
        KotlinType r11 = TypeUtils.makeNotNullable(r10);
        SimpleType r12 = this.primitives.invoke().kotlinArrayTypeToPrimitiveKotlinType.get(r11);
        if (r12 == null) goto L17;
        return r12;
    L17:
        ModuleDescriptor r13 = DescriptorUtils.getContainingModuleOrNull(r11);
        if (r13 == null) goto L23;
        KotlinType r14 = getElementTypeForUnsignedArray(r11, r13);
        if (r14 == null) goto L23;
        return r14;
    L23:
        throw new IllegalStateException("not array: " + r10);
    L7:
        if (r10.getArguments().size() != 1) goto L13;
        KotlinType r15 = r10.getArguments().get(0).getType();
        if (r15 != null) goto L11;
        $$$reportNull$$$0(68);
    L11:
        return r15;
    L13:
        throw new IllegalStateException();
    }

    public SimpleType getArrayType(Variance r10, KotlinType r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(82);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(83);
    L6:
        SimpleType r12 = getArrayType(r10, r11, Annotations.Companion.getEMPTY());
        if (r12 != null) goto L9;
        $$$reportNull$$$0(84);
    L9:
        return r12;
    }

    public SimpleType getArrayType(Variance r10, KotlinType r11, Annotations r12) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(78);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(79);
    L6:
        if (r12 != null) goto L8;
        $$$reportNull$$$0(80);
    L8:
        List r13 = Collections.singletonList(new TypeProjectionImpl(r10, r11));
        SimpleType r14 = KotlinTypeFactory.simpleNotNullType(TypeAttributesKt.toDefaultAttributes(r12), getArray(), r13);
        if (r14 != null) goto L11;
        $$$reportNull$$$0(81);
    L11:
        return r14;
    }

    public SimpleType getBooleanType() {
        SimpleType r10 = getPrimitiveKotlinType(PrimitiveType.BOOLEAN);
        if (r10 != null) goto L5;
        $$$reportNull$$$0(63);
    L5:
        return r10;
    }

    public ClassDescriptor getBuiltInClassByFqName(FqName r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(12);
    L4:
        ClassDescriptor r11 = DescriptorUtilKt.resolveClassByFqName(getBuiltInsModule(), r10, NoLookupLocation.FROM_BUILTINS);
        if (r11 != null) goto L7;
        $$$reportNull$$$0(13);
    L7:
        return r11;
    }

    public ModuleDescriptorImpl getBuiltInsModule() {
        if (this.builtInsModule != null) goto L5;
        this.builtInsModule = this.postponedBuiltInsModule.invoke();
    L5:
        ModuleDescriptorImpl r10 = this.builtInsModule;
        if (r10 != null) goto L8;
        $$$reportNull$$$0(7);
    L8:
        return r10;
    }

    public MemberScope getBuiltInsPackageScope() {
        MemberScope r10 = getBuiltInsModule().getPackage(StandardNames.BUILT_INS_PACKAGE_FQ_NAME).getMemberScope();
        if (r10 != null) goto L5;
        $$$reportNull$$$0(11);
    L5:
        return r10;
    }

    public SimpleType getByteType() {
        SimpleType r10 = getPrimitiveKotlinType(PrimitiveType.BYTE);
        if (r10 != null) goto L5;
        $$$reportNull$$$0(56);
    L5:
        return r10;
    }

    public SimpleType getCharType() {
        SimpleType r10 = getPrimitiveKotlinType(PrimitiveType.CHAR);
        if (r10 != null) goto L5;
        $$$reportNull$$$0(62);
    L5:
        return r10;
    }

    protected Iterable<ClassDescriptorFactory> getClassDescriptorFactories() {
        List r10 = Collections.singletonList(new BuiltInFictitiousFunctionClassFactory(this.storageManager, getBuiltInsModule()));
        if (r10 != null) goto L5;
        $$$reportNull$$$0(5);
    L5:
        return r10;
    }

    public ClassDescriptor getCollection() {
        ClassDescriptor r10 = getBuiltInClassByFqName(StandardNames.FqNames.collection);
        if (r10 != null) goto L5;
        $$$reportNull$$$0(34);
    L5:
        return r10;
    }

    public ClassDescriptor getComparable() {
        return getBuiltInClassByName("Comparable");
    }

    public SimpleType getDefaultBound() {
        SimpleType r10 = getNullableAnyType();
        if (r10 != null) goto L5;
        $$$reportNull$$$0(52);
    L5:
        return r10;
    }

    public SimpleType getDoubleType() {
        SimpleType r10 = getPrimitiveKotlinType(PrimitiveType.DOUBLE);
        if (r10 != null) goto L5;
        $$$reportNull$$$0(61);
    L5:
        return r10;
    }

    public SimpleType getFloatType() {
        SimpleType r10 = getPrimitiveKotlinType(PrimitiveType.FLOAT);
        if (r10 != null) goto L5;
        $$$reportNull$$$0(60);
    L5:
        return r10;
    }

    public ClassDescriptor getFunction(int r10) {
        return getBuiltInClassByName(StandardNames.getFunctionName(r10));
    }

    public SimpleType getIntType() {
        SimpleType r10 = getPrimitiveKotlinType(PrimitiveType.INT);
        if (r10 != null) goto L5;
        $$$reportNull$$$0(58);
    L5:
        return r10;
    }

    public ClassDescriptor getKClass() {
        ClassDescriptor r10 = getBuiltInClassByFqName(StandardNames.FqNames.kClass.toSafe());
        if (r10 != null) goto L5;
        $$$reportNull$$$0(21);
    L5:
        return r10;
    }

    public SimpleType getLongType() {
        SimpleType r10 = getPrimitiveKotlinType(PrimitiveType.LONG);
        if (r10 != null) goto L5;
        $$$reportNull$$$0(59);
    L5:
        return r10;
    }

    public ClassDescriptor getNothing() {
        return getBuiltInClassByName("Nothing");
    }

    public SimpleType getNothingType() {
        SimpleType r10 = getNothing().getDefaultType();
        if (r10 != null) goto L5;
        $$$reportNull$$$0(48);
    L5:
        return r10;
    }

    public SimpleType getNullableAnyType() {
        SimpleType r10 = getAnyType().makeNullableAsSpecified(true);
        if (r10 != null) goto L5;
        $$$reportNull$$$0(51);
    L5:
        return r10;
    }

    public SimpleType getNullableNothingType() {
        SimpleType r10 = getNothingType().makeNullableAsSpecified(true);
        if (r10 != null) goto L5;
        $$$reportNull$$$0(49);
    L5:
        return r10;
    }

    public ClassDescriptor getNumber() {
        return getBuiltInClassByName("Number");
    }

    public SimpleType getNumberType() {
        SimpleType r10 = getNumber().getDefaultType();
        if (r10 != null) goto L5;
        $$$reportNull$$$0(55);
    L5:
        return r10;
    }

    protected PlatformDependentDeclarationFilter getPlatformDependentDeclarationFilter() {
        PlatformDependentDeclarationFilter.NoPlatformDependent r10 = PlatformDependentDeclarationFilter.NoPlatformDependent.INSTANCE;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(4);
    L5:
        return r10;
    }

    public SimpleType getPrimitiveArrayKotlinType(PrimitiveType r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(73);
    L4:
        SimpleType r11 = this.primitives.invoke().primitiveTypeToArrayKotlinType.get(r10);
        if (r11 != null) goto L7;
        $$$reportNull$$$0(74);
    L7:
        return r11;
    }

    public SimpleType getPrimitiveKotlinType(PrimitiveType r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(53);
    L4:
        SimpleType r11 = getPrimitiveClassDescriptor(r10).getDefaultType();
        if (r11 != null) goto L7;
        $$$reportNull$$$0(54);
    L7:
        return r11;
    }

    public SimpleType getShortType() {
        SimpleType r10 = getPrimitiveKotlinType(PrimitiveType.SHORT);
        if (r10 != null) goto L5;
        $$$reportNull$$$0(57);
    L5:
        return r10;
    }

    protected StorageManager getStorageManager() {
        StorageManager r10 = this.storageManager;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(6);
    L5:
        return r10;
    }

    public ClassDescriptor getString() {
        return getBuiltInClassByName("String");
    }

    public SimpleType getStringType() {
        SimpleType r10 = getString().getDefaultType();
        if (r10 != null) goto L5;
        $$$reportNull$$$0(65);
    L5:
        return r10;
    }

    public ClassDescriptor getSuspendFunction(int r10) {
        ClassDescriptor r11 = getBuiltInClassByFqName(StandardNames.COROUTINES_PACKAGE_FQ_NAME.child(Name.identifier(StandardNames.getSuspendFunctionName(r10))));
        if (r11 != null) goto L5;
        $$$reportNull$$$0(18);
    L5:
        return r11;
    }

    public ClassDescriptor getUnit() {
        return getBuiltInClassByName("Unit");
    }

    public SimpleType getUnitType() {
        SimpleType r10 = getUnit().getDefaultType();
        if (r10 != null) goto L5;
        $$$reportNull$$$0(64);
    L5:
        return r10;
    }

    public void setBuiltInsModule(final ModuleDescriptorImpl r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(1);
    L4:
        this.storageManager.compute(new AnonymousClass4(this, r10));
    }
}
