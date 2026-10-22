package kotlin.reflect.jvm.internal.impl.builtins;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
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
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class KotlinBuiltIns {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final Name BUILTINS_MODULE_NAME = null;
    private final MemoizedFunctionToNotNull<Name, ClassDescriptor> builtInClassesByName;
    private final NotNullLazyValue<Collection<PackageViewDescriptor>> builtInPackagesImportedByDefault;
    private ModuleDescriptorImpl builtInsModule;
    private NotNullLazyValue<ModuleDescriptorImpl> postponedBuiltInsModule;
    private final NotNullLazyValue<Primitives> primitives;
    private final StorageManager storageManager;

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
            case 46: goto L4;
            case 47: goto L3;
            case 48: goto L4;
            case 49: goto L4;
            case 50: goto L4;
            case 51: goto L4;
            case 52: goto L4;
            case 53: goto L4;
            case 54: goto L3;
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
            case 67: goto L4;
            case 68: goto L3;
            case 69: goto L4;
            case 70: goto L4;
            case 71: goto L4;
            case 72: goto L3;
            case 73: goto L3;
            case 74: goto L3;
            case 75: goto L4;
            case 76: goto L3;
            case 77: goto L3;
            case 78: goto L3;
            case 79: goto L3;
            case 80: goto L3;
            case 81: goto L3;
            case 82: goto L4;
            case 83: goto L3;
            case 84: goto L3;
            case 85: goto L4;
            case 86: goto L3;
            case 87: goto L4;
            case 88: goto L4;
            default: goto L3;
        };
    L3:
        String r0 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
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
            case 46: goto L8;
            case 47: goto L7;
            case 48: goto L8;
            case 49: goto L8;
            case 50: goto L8;
            case 51: goto L8;
            case 52: goto L8;
            case 53: goto L8;
            case 54: goto L7;
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
            case 67: goto L8;
            case 68: goto L7;
            case 69: goto L8;
            case 70: goto L8;
            case 71: goto L8;
            case 72: goto L7;
            case 73: goto L7;
            case 74: goto L7;
            case 75: goto L8;
            case 76: goto L7;
            case 77: goto L7;
            case 78: goto L7;
            case 79: goto L7;
            case 80: goto L7;
            case 81: goto L7;
            case 82: goto L8;
            case 83: goto L7;
            case 84: goto L7;
            case 85: goto L8;
            case 86: goto L7;
            case 87: goto L8;
            case 88: goto L8;
            default: goto L7;
        };
    L7:
        int r2 = 3;
    L9:
        Object[] r3 = new Object[r2];
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
            case 46: goto L27;
            case 47: goto L22;
            case 48: goto L27;
            case 49: goto L27;
            case 50: goto L27;
            case 51: goto L27;
            case 52: goto L27;
            case 53: goto L27;
            case 54: goto L23;
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
            case 67: goto L27;
            case 68: goto L21;
            case 69: goto L27;
            case 70: goto L27;
            case 71: goto L27;
            case 72: goto L20;
            case 73: goto L29;
            case 74: goto L19;
            case 75: goto L27;
            case 76: goto L18;
            case 77: goto L26;
            case 78: goto L26;
            case 79: goto L17;
            case 80: goto L16;
            case 81: goto L15;
            case 82: goto L27;
            case 83: goto L17;
            case 84: goto L16;
            case 85: goto L27;
            case 86: goto L16;
            case 87: goto L27;
            case 88: goto L27;
            case 89: goto L23;
            case 90: goto L26;
            case 91: goto L23;
            case 92: goto L23;
            case 93: goto L23;
            case 94: goto L23;
            case 95: goto L23;
            case 96: goto L23;
            case 97: goto L26;
            case 98: goto L23;
            case 99: goto L25;
            case 100: goto L23;
            case 101: goto L25;
            case 102: goto L14;
            case 103: goto L25;
            case 104: goto L26;
            case 105: goto L25;
            case 106: goto L23;
            case 107: goto L25;
            case 108: goto L26;
            case 109: goto L26;
            case 110: goto L23;
            case 111: goto L23;
            case 112: goto L23;
            case 113: goto L13;
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
            case 135: goto L23;
            case 136: goto L25;
            case 137: goto L23;
            case 138: goto L23;
            case 139: goto L23;
            case 140: goto L23;
            case 141: goto L23;
            case 142: goto L23;
            case 143: goto L23;
            case 144: goto L26;
            case 145: goto L23;
            case 146: goto L23;
            case 147: goto L26;
            case 148: goto L26;
            case 149: goto L23;
            case 150: goto L26;
            case 151: goto L23;
            case 152: goto L23;
            case 153: goto L23;
            case 154: goto L23;
            case 155: goto L23;
            case 156: goto L23;
            case 157: goto L23;
            case 158: goto L26;
            case 159: goto L26;
            case 160: goto L26;
            case 161: goto L26;
            case 162: goto L12;
            case 163: goto L23;
            default: goto L11;
        };
    L11:
        r3[0] = "storageManager";
    L31:
        switch(r13) {
            case 3: goto L94;
            case 4: goto L93;
            case 5: goto L92;
            case 6: goto L91;
            case 7: goto L90;
            case 8: goto L89;
            case 9: goto L32;
            case 10: goto L32;
            case 11: goto L88;
            case 12: goto L32;
            case 13: goto L87;
            case 14: goto L32;
            case 15: goto L86;
            case 16: goto L32;
            case 17: goto L32;
            case 18: goto L85;
            case 19: goto L84;
            case 20: goto L83;
            case 21: goto L82;
            case 22: goto L81;
            case 23: goto L80;
            case 24: goto L79;
            case 25: goto L78;
            case 26: goto L77;
            case 27: goto L76;
            case 28: goto L75;
            case 29: goto L74;
            case 30: goto L73;
            case 31: goto L72;
            case 32: goto L71;
            case 33: goto L70;
            case 34: goto L69;
            case 35: goto L68;
            case 36: goto L67;
            case 37: goto L66;
            case 38: goto L65;
            case 39: goto L64;
            case 40: goto L63;
            case 41: goto L62;
            case 42: goto L61;
            case 43: goto L60;
            case 44: goto L59;
            case 45: goto L58;
            case 46: goto L57;
            case 47: goto L32;
            case 48: goto L56;
            case 49: goto L55;
            case 50: goto L54;
            case 51: goto L53;
            case 52: goto L52;
            case 53: goto L51;
            case 54: goto L32;
            case 55: goto L50;
            case 56: goto L49;
            case 57: goto L48;
            case 58: goto L47;
            case 59: goto L46;
            case 60: goto L45;
            case 61: goto L44;
            case 62: goto L43;
            case 63: goto L42;
            case 64: goto L41;
            case 65: goto L40;
            case 66: goto L39;
            case 67: goto L38;
            case 68: goto L32;
            case 69: goto L37;
            case 70: goto L37;
            case 71: goto L37;
            case 72: goto L32;
            case 73: goto L32;
            case 74: goto L32;
            case 75: goto L36;
            case 76: goto L32;
            case 77: goto L32;
            case 78: goto L32;
            case 79: goto L32;
            case 80: goto L32;
            case 81: goto L32;
            case 82: goto L35;
            case 83: goto L32;
            case 84: goto L32;
            case 85: goto L35;
            case 86: goto L32;
            case 87: goto L34;
            case 88: goto L33;
            default: goto L32;
        };
    L32:
        r3[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
    L95:
        switch(r13) {
            case 1: goto L176;
            case 2: goto L175;
            case 3: goto L177;
            case 4: goto L177;
            case 5: goto L177;
            case 6: goto L177;
            case 7: goto L177;
            case 8: goto L177;
            case 9: goto L174;
            case 10: goto L173;
            case 11: goto L177;
            case 12: goto L172;
            case 13: goto L177;
            case 14: goto L171;
            case 15: goto L177;
            case 16: goto L170;
            case 17: goto L169;
            case 18: goto L177;
            case 19: goto L177;
            case 20: goto L177;
            case 21: goto L177;
            case 22: goto L177;
            case 23: goto L177;
            case 24: goto L177;
            case 25: goto L177;
            case 26: goto L177;
            case 27: goto L177;
            case 28: goto L177;
            case 29: goto L177;
            case 30: goto L177;
            case 31: goto L177;
            case 32: goto L177;
            case 33: goto L177;
            case 34: goto L177;
            case 35: goto L177;
            case 36: goto L177;
            case 37: goto L177;
            case 38: goto L177;
            case 39: goto L177;
            case 40: goto L177;
            case 41: goto L177;
            case 42: goto L177;
            case 43: goto L177;
            case 44: goto L177;
            case 45: goto L177;
            case 46: goto L177;
            case 47: goto L168;
            case 48: goto L177;
            case 49: goto L177;
            case 50: goto L177;
            case 51: goto L177;
            case 52: goto L177;
            case 53: goto L177;
            case 54: goto L167;
            case 55: goto L177;
            case 56: goto L177;
            case 57: goto L177;
            case 58: goto L177;
            case 59: goto L177;
            case 60: goto L177;
            case 61: goto L177;
            case 62: goto L177;
            case 63: goto L177;
            case 64: goto L177;
            case 65: goto L177;
            case 66: goto L177;
            case 67: goto L177;
            case 68: goto L166;
            case 69: goto L177;
            case 70: goto L177;
            case 71: goto L177;
            case 72: goto L165;
            case 73: goto L165;
            case 74: goto L164;
            case 75: goto L177;
            case 76: goto L163;
            case 77: goto L162;
            case 78: goto L161;
            case 79: goto L160;
            case 80: goto L160;
            case 81: goto L160;
            case 82: goto L177;
            case 83: goto L160;
            case 84: goto L160;
            case 85: goto L177;
            case 86: goto L159;
            case 87: goto L177;
            case 88: goto L177;
            case 89: goto L158;
            case 90: goto L157;
            case 91: goto L157;
            case 92: goto L156;
            case 93: goto L155;
            case 94: goto L162;
            case 95: goto L154;
            case 96: goto L153;
            case 97: goto L152;
            case 98: goto L151;
            case 99: goto L151;
            case 100: goto L151;
            case 101: goto L151;
            case 102: goto L150;
            case 103: goto L150;
            case 104: goto L149;
            case 105: goto L149;
            case 106: goto L148;
            case 107: goto L148;
            case 108: goto L147;
            case 109: goto L146;
            case 110: goto L146;
            case 111: goto L145;
            case 112: goto L144;
            case 113: goto L145;
            case 114: goto L143;
            case 115: goto L142;
            case 116: goto L141;
            case 117: goto L140;
            case 118: goto L139;
            case 119: goto L138;
            case 120: goto L137;
            case 121: goto L136;
            case 122: goto L135;
            case 123: goto L134;
            case 124: goto L133;
            case 125: goto L132;
            case 126: goto L131;
            case 127: goto L130;
            case 128: goto L129;
            case 129: goto L128;
            case 130: goto L127;
            case 131: goto L126;
            case 132: goto L125;
            case 133: goto L124;
            case 134: goto L123;
            case 135: goto L122;
            case 136: goto L122;
            case 137: goto L121;
            case 138: goto L120;
            case 139: goto L119;
            case 140: goto L118;
            case 141: goto L117;
            case 142: goto L116;
            case 143: goto L115;
            case 144: goto L114;
            case 145: goto L113;
            case 146: goto L112;
            case 147: goto L111;
            case 148: goto L110;
            case 149: goto L110;
            case 150: goto L109;
            case 151: goto L109;
            case 152: goto L108;
            case 153: goto L107;
            case 154: goto L106;
            case 155: goto L105;
            case 156: goto L104;
            case 157: goto L103;
            case 158: goto L102;
            case 159: goto L101;
            case 160: goto L100;
            case 161: goto L99;
            case 162: goto L98;
            case 163: goto L97;
            default: goto L96;
        };
    L96:
        r3[2] = "<init>";
        goto L177
    L97:
        r3[2] = "isNotNullOrNullableFunctionSupertype";
        goto L177
    L98:
        r3[2] = "isDeprecated";
        goto L177
    L99:
        r3[2] = "isCloneable";
        goto L177
    L100:
        r3[2] = "isNonPrimitiveArray";
        goto L177
    L101:
        r3[2] = "isKClass";
        goto L177
    L102:
        r3[2] = "isThrowable";
        goto L177
    L103:
        r3[2] = "isThrowableOrNullableThrowable";
        goto L177
    L104:
        r3[2] = "isIterableOrNullableIterable";
        goto L177
    L105:
        r3[2] = "isMapOrNullableMap";
        goto L177
    L106:
        r3[2] = "isSetOrNullableSet";
        goto L177
    L107:
        r3[2] = "isListOrNullableList";
        goto L177
    L108:
        r3[2] = "isCollectionOrNullableCollection";
        goto L177
    L109:
        r3[2] = "isComparable";
        goto L177
    L110:
        r3[2] = "isEnum";
        goto L177
    L111:
        r3[2] = "isMemberOfAny";
        goto L177
    L112:
        r3[2] = "isBooleanOrSubtype";
        goto L177
    L113:
        r3[2] = "isUnitOrNullableUnit";
        goto L177
    L114:
        r3[2] = "mayReturnNonUnitValue";
        goto L177
    L115:
        r3[2] = "isUnit";
        goto L177
    L116:
        r3[2] = "isDefaultBound";
        goto L177
    L117:
        r3[2] = "isNullableAny";
        goto L177
    L118:
        r3[2] = "isAnyOrNullableAny";
        goto L177
    L119:
        r3[2] = "isNothingOrNullableNothing";
        goto L177
    L120:
        r3[2] = "isNullableNothing";
        goto L177
    L121:
        r3[2] = "isNothing";
        goto L177
    L122:
        r3[2] = "isConstructedFromGivenClassAndNotNullable";
        goto L177
    L123:
        r3[2] = "isDoubleOrNullableDouble";
        goto L177
    L124:
        r3[2] = "isUnsignedArrayType";
        goto L177
    L125:
        r3[2] = "isULongArray";
        goto L177
    L126:
        r3[2] = "isUIntArray";
        goto L177
    L127:
        r3[2] = "isUShortArray";
        goto L177
    L128:
        r3[2] = "isUByteArray";
        goto L177
    L129:
        r3[2] = "isULong";
        goto L177
    L130:
        r3[2] = "isUInt";
        goto L177
    L131:
        r3[2] = "isUShort";
        goto L177
    L132:
        r3[2] = "isUByte";
        goto L177
    L133:
        r3[2] = "isDouble";
        goto L177
    L134:
        r3[2] = "isFloatOrNullableFloat";
        goto L177
    L135:
        r3[2] = "isFloat";
        goto L177
    L136:
        r3[2] = "isShort";
        goto L177
    L137:
        r3[2] = "isLongOrNullableLong";
        goto L177
    L138:
        r3[2] = "isLong";
        goto L177
    L139:
        r3[2] = "isByte";
        goto L177
    L140:
        r3[2] = "isInt";
        goto L177
    L141:
        r3[2] = "isCharOrNullableChar";
        goto L177
    L142:
        r3[2] = "isChar";
        goto L177
    L143:
        r3[2] = "isNumber";
        goto L177
    L144:
        r3[2] = "isBooleanOrNullableBoolean";
        goto L177
    L145:
        r3[2] = "isBoolean";
        goto L177
    L146:
        r3[2] = "isAny";
        goto L177
    L147:
        r3[2] = "isSpecialClassWithNoSupertypes";
        goto L177
    L148:
        r3[2] = "isNotNullConstructedFromGivenClass";
        goto L177
    L149:
        r3[2] = "classFqNameEquals";
        goto L177
    L150:
        r3[2] = "isTypeConstructorForGivenClass";
        goto L177
    L151:
        r3[2] = "isConstructedFromGivenClass";
        goto L177
    L152:
        r3[2] = "isPrimitiveClass";
        goto L177
    L153:
        r3[2] = "isPrimitiveTypeOrNullablePrimitiveType";
        goto L177
    L154:
        r3[2] = "isPrimitiveType";
        goto L177
    L155:
        r3[2] = "getPrimitiveArrayElementType";
        goto L177
    L156:
        r3[2] = "isPrimitiveArray";
        goto L177
    L157:
        r3[2] = "isArrayOrPrimitiveArray";
        goto L177
    L158:
        r3[2] = "isArray";
        goto L177
    L159:
        r3[2] = "getEnumType";
        goto L177
    L160:
        r3[2] = "getArrayType";
        goto L177
    L161:
        r3[2] = "getPrimitiveArrayType";
        goto L177
    L162:
        r3[2] = "getPrimitiveType";
        goto L177
    L163:
        r3[2] = "getPrimitiveArrayKotlinTypeByPrimitiveKotlinType";
        goto L177
    L164:
        r3[2] = "getPrimitiveArrayKotlinType";
        goto L177
    L165:
        r3[2] = "getElementTypeForUnsignedArray";
        goto L177
    L166:
        r3[2] = "getArrayElementType";
        goto L177
    L167:
        r3[2] = "getPrimitiveKotlinType";
        goto L177
    L168:
        r3[2] = "getBuiltInTypeByClassName";
        goto L177
    L169:
        r3[2] = "getPrimitiveArrayClassDescriptor";
        goto L177
    L170:
        r3[2] = "getPrimitiveClassDescriptor";
        goto L177
    L171:
        r3[2] = "getBuiltInClassByName";
        goto L177
    L172:
        r3[2] = "getBuiltInClassByFqName";
        goto L177
    L173:
        r3[2] = "isUnderKotlinPackage";
        goto L177
    L174:
        r3[2] = "isBuiltIn";
        goto L177
    L175:
        r3[2] = "setPostponedBuiltinsModuleComputation";
        goto L177
    L176:
        r3[2] = "setBuiltInsModule";
    L177:
        String r1 = String.format(r0, r3);
        switch(r13) {
            case 3: goto L181;
            case 4: goto L181;
            case 5: goto L181;
            case 6: goto L181;
            case 7: goto L181;
            case 8: goto L181;
            case 9: goto L182;
            case 10: goto L182;
            case 11: goto L181;
            case 12: goto L182;
            case 13: goto L181;
            case 14: goto L182;
            case 15: goto L181;
            case 16: goto L182;
            case 17: goto L182;
            case 18: goto L181;
            case 19: goto L181;
            case 20: goto L181;
            case 21: goto L181;
            case 22: goto L181;
            case 23: goto L181;
            case 24: goto L181;
            case 25: goto L181;
            case 26: goto L181;
            case 27: goto L181;
            case 28: goto L181;
            case 29: goto L181;
            case 30: goto L181;
            case 31: goto L181;
            case 32: goto L181;
            case 33: goto L181;
            case 34: goto L181;
            case 35: goto L181;
            case 36: goto L181;
            case 37: goto L181;
            case 38: goto L181;
            case 39: goto L181;
            case 40: goto L181;
            case 41: goto L181;
            case 42: goto L181;
            case 43: goto L181;
            case 44: goto L181;
            case 45: goto L181;
            case 46: goto L181;
            case 47: goto L182;
            case 48: goto L181;
            case 49: goto L181;
            case 50: goto L181;
            case 51: goto L181;
            case 52: goto L181;
            case 53: goto L181;
            case 54: goto L182;
            case 55: goto L181;
            case 56: goto L181;
            case 57: goto L181;
            case 58: goto L181;
            case 59: goto L181;
            case 60: goto L181;
            case 61: goto L181;
            case 62: goto L181;
            case 63: goto L181;
            case 64: goto L181;
            case 65: goto L181;
            case 66: goto L181;
            case 67: goto L181;
            case 68: goto L182;
            case 69: goto L181;
            case 70: goto L181;
            case 71: goto L181;
            case 72: goto L182;
            case 73: goto L182;
            case 74: goto L182;
            case 75: goto L181;
            case 76: goto L182;
            case 77: goto L182;
            case 78: goto L182;
            case 79: goto L182;
            case 80: goto L182;
            case 81: goto L182;
            case 82: goto L181;
            case 83: goto L182;
            case 84: goto L182;
            case 85: goto L181;
            case 86: goto L182;
            case 87: goto L181;
            case 88: goto L181;
            default: goto L182;
        };
    L182:
        throw new IllegalArgumentException(r1);
    L181:
        throw new IllegalStateException(r1);
    L33:
        r3[1] = "getAnnotationType";
        goto L95
    L34:
        r3[1] = "getEnumType";
        goto L95
    L35:
        r3[1] = "getArrayType";
        goto L95
    L36:
        r3[1] = "getPrimitiveArrayKotlinType";
        goto L95
    L37:
        r3[1] = "getArrayElementType";
        goto L95
    L38:
        r3[1] = "getIterableType";
        goto L95
    L39:
        r3[1] = "getStringType";
        goto L95
    L40:
        r3[1] = "getUnitType";
        goto L95
    L41:
        r3[1] = "getBooleanType";
        goto L95
    L42:
        r3[1] = "getCharType";
        goto L95
    L43:
        r3[1] = "getDoubleType";
        goto L95
    L44:
        r3[1] = "getFloatType";
        goto L95
    L45:
        r3[1] = "getLongType";
        goto L95
    L46:
        r3[1] = "getIntType";
        goto L95
    L47:
        r3[1] = "getShortType";
        goto L95
    L48:
        r3[1] = "getByteType";
        goto L95
    L49:
        r3[1] = "getNumberType";
        goto L95
    L50:
        r3[1] = "getPrimitiveKotlinType";
        goto L95
    L51:
        r3[1] = "getDefaultBound";
        goto L95
    L52:
        r3[1] = "getNullableAnyType";
        goto L95
    L53:
        r3[1] = "getAnyType";
        goto L95
    L54:
        r3[1] = "getNullableNothingType";
        goto L95
    L55:
        r3[1] = "getNothingType";
        goto L95
    L56:
        r3[1] = "getBuiltInTypeByClassName";
        goto L95
    L57:
        r3[1] = "getMutableListIterator";
        goto L95
    L58:
        r3[1] = "getListIterator";
        goto L95
    L59:
        r3[1] = "getMutableMapEntry";
        goto L95
    L60:
        r3[1] = "getMapEntry";
        goto L95
    L61:
        r3[1] = "getMutableMap";
        goto L95
    L62:
        r3[1] = "getMap";
        goto L95
    L63:
        r3[1] = "getMutableSet";
        goto L95
    L64:
        r3[1] = "getSet";
        goto L95
    L65:
        r3[1] = "getMutableList";
        goto L95
    L66:
        r3[1] = "getList";
        goto L95
    L67:
        r3[1] = "getMutableCollection";
        goto L95
    L68:
        r3[1] = "getCollection";
        goto L95
    L69:
        r3[1] = "getMutableIterator";
        goto L95
    L70:
        r3[1] = "getMutableIterable";
        goto L95
    L71:
        r3[1] = "getIterable";
        goto L95
    L72:
        r3[1] = "getIterator";
        goto L95
    L73:
        r3[1] = "getKMutableProperty2";
        goto L95
    L74:
        r3[1] = "getKMutableProperty1";
        goto L95
    L75:
        r3[1] = "getKMutableProperty0";
        goto L95
    L76:
        r3[1] = "getKProperty2";
        goto L95
    L77:
        r3[1] = "getKProperty1";
        goto L95
    L78:
        r3[1] = "getKProperty0";
        goto L95
    L79:
        r3[1] = "getKProperty";
        goto L95
    L80:
        r3[1] = "getKCallable";
        goto L95
    L81:
        r3[1] = "getKType";
        goto L95
    L82:
        r3[1] = "getKClass";
        goto L95
    L83:
        r3[1] = "getKSuspendFunction";
        goto L95
    L84:
        r3[1] = "getKFunction";
        goto L95
    L85:
        r3[1] = "getSuspendFunction";
        goto L95
    L86:
        r3[1] = "getBuiltInClassByName";
        goto L95
    L87:
        r3[1] = "getBuiltInClassByFqName";
        goto L95
    L88:
        r3[1] = "getBuiltInsPackageScope";
        goto L95
    L89:
        r3[1] = "getBuiltInPackagesImportedByDefault";
        goto L95
    L90:
        r3[1] = "getBuiltInsModule";
        goto L95
    L91:
        r3[1] = "getStorageManager";
        goto L95
    L92:
        r3[1] = "getClassDescriptorFactories";
        goto L95
    L93:
        r3[1] = "getPlatformDependentDeclarationFilter";
        goto L95
    L94:
        r3[1] = "getAdditionalClassPartsProvider";
        goto L95
    L12:
        r3[0] = "declarationDescriptor";
        goto L31
    L13:
        r3[0] = "classDescriptor";
        goto L31
    L14:
        r3[0] = "typeConstructor";
        goto L31
    L15:
        r3[0] = "annotations";
        goto L31
    L16:
        r3[0] = "argument";
        goto L31
    L17:
        r3[0] = "projectionType";
        goto L31
    L18:
        r3[0] = "kotlinType";
        goto L31
    L19:
        r3[0] = "primitiveType";
        goto L31
    L20:
        r3[0] = "notNullArrayType";
        goto L31
    L21:
        r3[0] = "arrayType";
        goto L31
    L22:
        r3[0] = "classSimpleName";
        goto L31
    L23:
        r3[0] = EffectConfiguration.KEY_TYPE;
        goto L31
    L24:
        r3[0] = "simpleName";
        goto L31
    L25:
        r3[0] = "fqName";
        goto L31
    L26:
        r3[0] = "descriptor";
        goto L31
    L27:
        r3[0] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
        goto L31
    L28:
        r3[0] = "computation";
        goto L31
    L29:
        r3[0] = "module";
        goto L31
    L8:
        r2 = 2;
        goto L9
    L4:
        r0 = "@NotNull method %s.%s must not return null";
        goto L6
    }

    static {
        BUILTINS_MODULE_NAME = Name.special("<built-ins module>");
    }

    public AdditionalClassPartsProvider getAdditionalClassPartsProvider() {
        AdditionalClassPartsProvider.None r0 = AdditionalClassPartsProvider.None.INSTANCE;
        if (r0 != null) goto L5;
        $$$reportNull$$$0(3);
    L5:
        return r0;
    }

    public ClassDescriptor getAny() {
        return getBuiltInClassByName("Any");
    }

    public ClassDescriptor getArray() {
        return getBuiltInClassByName("Array");
    }

    public SimpleType getBooleanType() {
        SimpleType r0 = getPrimitiveKotlinType(PrimitiveType.BOOLEAN);
        if (r0 != null) goto L5;
        $$$reportNull$$$0(64);
    L5:
        return r0;
    }

    public ModuleDescriptorImpl getBuiltInsModule() {
        if (this.builtInsModule != null) goto L5;
        this.builtInsModule = (ModuleDescriptorImpl) this.postponedBuiltInsModule.invoke();
    L5:
        ModuleDescriptorImpl r0 = this.builtInsModule;
        if (r0 != null) goto L8;
        $$$reportNull$$$0(7);
    L8:
        return r0;
    }

    public SimpleType getByteType() {
        SimpleType r0 = getPrimitiveKotlinType(PrimitiveType.BYTE);
        if (r0 != null) goto L5;
        $$$reportNull$$$0(57);
    L5:
        return r0;
    }

    public SimpleType getCharType() {
        SimpleType r0 = getPrimitiveKotlinType(PrimitiveType.CHAR);
        if (r0 != null) goto L5;
        $$$reportNull$$$0(63);
    L5:
        return r0;
    }

    public Iterable<ClassDescriptorFactory> getClassDescriptorFactories() {
        List r0 = Collections.singletonList(new BuiltInFictitiousFunctionClassFactory(this.storageManager, getBuiltInsModule()));
        if (r0 != null) goto L5;
        $$$reportNull$$$0(5);
    L5:
        return r0;
    }

    public ClassDescriptor getCollection() {
        ClassDescriptor r0 = getBuiltInClassByFqName(StandardNames.FqNames.collection);
        if (r0 != null) goto L5;
        $$$reportNull$$$0(35);
    L5:
        return r0;
    }

    public ClassDescriptor getComparable() {
        return getBuiltInClassByName("Comparable");
    }

    public SimpleType getDoubleType() {
        SimpleType r0 = getPrimitiveKotlinType(PrimitiveType.DOUBLE);
        if (r0 != null) goto L5;
        $$$reportNull$$$0(62);
    L5:
        return r0;
    }

    public SimpleType getFloatType() {
        SimpleType r0 = getPrimitiveKotlinType(PrimitiveType.FLOAT);
        if (r0 != null) goto L5;
        $$$reportNull$$$0(61);
    L5:
        return r0;
    }

    public SimpleType getIntType() {
        SimpleType r0 = getPrimitiveKotlinType(PrimitiveType.INT);
        if (r0 != null) goto L5;
        $$$reportNull$$$0(59);
    L5:
        return r0;
    }

    public ClassDescriptor getKClass() {
        ClassDescriptor r0 = getBuiltInClassByFqName(StandardNames.FqNames.kClass.toSafe());
        if (r0 != null) goto L5;
        $$$reportNull$$$0(21);
    L5:
        return r0;
    }

    public SimpleType getLongType() {
        SimpleType r0 = getPrimitiveKotlinType(PrimitiveType.LONG);
        if (r0 != null) goto L5;
        $$$reportNull$$$0(60);
    L5:
        return r0;
    }

    public ClassDescriptor getNothing() {
        return getBuiltInClassByName("Nothing");
    }

    public ClassDescriptor getNumber() {
        return getBuiltInClassByName("Number");
    }

    public PlatformDependentDeclarationFilter getPlatformDependentDeclarationFilter() {
        PlatformDependentDeclarationFilter.NoPlatformDependent r0 = PlatformDependentDeclarationFilter.NoPlatformDependent.INSTANCE;
        if (r0 != null) goto L5;
        $$$reportNull$$$0(4);
    L5:
        return r0;
    }

    public SimpleType getShortType() {
        SimpleType r0 = getPrimitiveKotlinType(PrimitiveType.SHORT);
        if (r0 != null) goto L5;
        $$$reportNull$$$0(58);
    L5:
        return r0;
    }

    public StorageManager getStorageManager() {
        StorageManager r0 = this.storageManager;
        if (r0 != null) goto L5;
        $$$reportNull$$$0(6);
    L5:
        return r0;
    }

    public ClassDescriptor getString() {
        return getBuiltInClassByName("String");
    }

    public ClassDescriptor getUnit() {
        return getBuiltInClassByName("Unit");
    }

    public SimpleType getAnyType() {
        SimpleType r0 = getAny().getDefaultType();
        if (r0 != null) goto L5;
        $$$reportNull$$$0(51);
    L5:
        return r0;
    }

    public MemberScope getBuiltInsPackageScope() {
        MemberScope r0 = getBuiltInsModule().getPackage(StandardNames.BUILT_INS_PACKAGE_FQ_NAME).getMemberScope();
        if (r0 != null) goto L5;
        $$$reportNull$$$0(11);
    L5:
        return r0;
    }

    public SimpleType getDefaultBound() {
        SimpleType r0 = getNullableAnyType();
        if (r0 != null) goto L5;
        $$$reportNull$$$0(53);
    L5:
        return r0;
    }

    public SimpleType getNothingType() {
        SimpleType r0 = getNothing().getDefaultType();
        if (r0 != null) goto L5;
        $$$reportNull$$$0(49);
    L5:
        return r0;
    }

    public SimpleType getNullableAnyType() {
        SimpleType r0 = getAnyType().makeNullableAsSpecified(true);
        if (r0 != null) goto L5;
        $$$reportNull$$$0(52);
    L5:
        return r0;
    }

    public SimpleType getNullableNothingType() {
        SimpleType r0 = getNothingType().makeNullableAsSpecified(true);
        if (r0 != null) goto L5;
        $$$reportNull$$$0(50);
    L5:
        return r0;
    }

    public SimpleType getNumberType() {
        SimpleType r0 = getNumber().getDefaultType();
        if (r0 != null) goto L5;
        $$$reportNull$$$0(56);
    L5:
        return r0;
    }

    public SimpleType getStringType() {
        SimpleType r0 = getString().getDefaultType();
        if (r0 != null) goto L5;
        $$$reportNull$$$0(66);
    L5:
        return r0;
    }

    public SimpleType getUnitType() {
        SimpleType r0 = getUnit().getDefaultType();
        if (r0 != null) goto L5;
        $$$reportNull$$$0(65);
    L5:
        return r0;
    }

    public KotlinBuiltIns(StorageManager r2) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        this.storageManager = r2;
        this.builtInPackagesImportedByDefault = r2.createLazyValue(new AnonymousClass1(this));
        this.primitives = r2.createLazyValue(new AnonymousClass2(this));
        this.builtInClassesByName = r2.createMemoizedFunction(new AnonymousClass3(this));
    }

    public static /* synthetic */ ModuleDescriptorImpl access$200(KotlinBuiltIns r0) {
        return r0.builtInsModule;
    }

    private ClassDescriptor getBuiltInClassByName(String r2) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(14);
    L4:
        ClassDescriptor r3 = (ClassDescriptor) this.builtInClassesByName.invoke(Name.identifier(r2));
        if (r3 != null) goto L7;
        $$$reportNull$$$0(15);
    L7:
        return r3;
    }

    private SimpleType getBuiltInTypeByClassName(String r2) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(47);
    L4:
        SimpleType r3 = getBuiltInClassByName(r2).getDefaultType();
        if (r3 != null) goto L7;
        $$$reportNull$$$0(48);
    L7:
        return r3;
    }

    public static PrimitiveType getPrimitiveArrayElementType(KotlinType r1) {
        if (r1 != null) goto L4;
        $$$reportNull$$$0(93);
    L4:
        ClassifierDescriptor r2 = r1.getConstructor().getDeclarationDescriptor();
        if (r2 != null) goto L8;
        return null;
    L8:
        return getPrimitiveArrayType(r2);
    }

    public static PrimitiveType getPrimitiveArrayType(DeclarationDescriptor r2) {
        if (r2 != null) goto L5;
        $$$reportNull$$$0(78);
    L5:
        if (StandardNames.FqNames.primitiveArrayTypeShortNames.contains(r2.getName()) == true) goto L9;
        return null;
    L9:
        return StandardNames.FqNames.arrayClassFqNameToPrimitiveType.get(DescriptorUtils.getFqName(r2));
    }

    private ClassDescriptor getPrimitiveClassDescriptor(PrimitiveType r2) {
        if (r2 != null) goto L5;
        $$$reportNull$$$0(16);
    L5:
        return getBuiltInClassByName(r2.getTypeName().asString());
    }

    public static PrimitiveType getPrimitiveType(DeclarationDescriptor r2) {
        if (r2 != null) goto L5;
        $$$reportNull$$$0(77);
    L5:
        if (StandardNames.FqNames.primitiveTypeShortNames.contains(r2.getName()) == true) goto L9;
        return null;
    L9:
        return StandardNames.FqNames.fqNameToPrimitiveType.get(DescriptorUtils.getFqName(r2));
    }

    public static boolean isAny(ClassDescriptor r1) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(109);
    L5:
        return classFqNameEquals(r1, StandardNames.FqNames.any);
    }

    public static boolean isAnyOrNullableAny(KotlinType r1) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(140);
    L5:
        return isConstructedFromGivenClass(r1, StandardNames.FqNames.any);
    }

    public static boolean isArray(KotlinType r1) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(89);
    L5:
        return isConstructedFromGivenClass(r1, StandardNames.FqNames.array);
    }

    public static boolean isArrayOrPrimitiveArray(ClassDescriptor r1) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(90);
    L5:
        if (classFqNameEquals(r1, StandardNames.FqNames.array) == false) goto L7;
    L10:
        return true;
    L7:
        if (getPrimitiveArrayType(r1) != null) goto L10;
        return false;
    }

    public static boolean isBoolean(KotlinType r1) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(111);
    L5:
        return isConstructedFromGivenClassAndNotNullable(r1, StandardNames.FqNames._boolean);
    }

    public static boolean isBuiltIn(DeclarationDescriptor r2) {
        if (r2 != null) goto L5;
        $$$reportNull$$$0(9);
    L5:
        if (DescriptorUtils.getParentOfType(r2, BuiltInsPackageFragment.class, false) == null) goto L8;
        return true;
    L8:
        return false;
    }

    public static boolean isDefaultBound(KotlinType r1) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(142);
    L5:
        return isNullableAny(r1);
    }

    public static boolean isDeprecated(DeclarationDescriptor r4) {
        if (r4 != null) goto L5;
        $$$reportNull$$$0(162);
    L5:
        if (r4.getOriginal().getAnnotations().hasAnnotation(StandardNames.FqNames.deprecated) == false) goto L8;
        return true;
    L8:
        if ((r4 instanceof PropertyDescriptor) == false) goto L20;
        PropertyDescriptor r5 = (PropertyDescriptor) r4;
        boolean r0 = r5.isVar();
        PropertyGetterDescriptor r3 = r5.getGetter();
        PropertySetterDescriptor r6 = r5.getSetter();
        if (r3 != null) goto L12;
    L18:
        return false;
    L12:
        if (isDeprecated(r3) == false) goto L18;
        if (r0 == false) goto L21;
        if (r6 == null) goto L18;
        if (isDeprecated(r6) == false) goto L18;
        return true;
    L21:
        return true;
    L20:
        return false;
    }

    public static boolean isKClass(ClassDescriptor r1) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(159);
    L5:
        return classFqNameEquals(r1, StandardNames.FqNames.kClass);
    }

    public static boolean isNothing(KotlinType r1) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(137);
    L5:
        if (isNothingOrNullableNothing(r1) == true) goto L7;
    L9:
        return false;
    L7:
        if (TypeUtils.isNullableType(r1) == true) goto L9;
        return true;
    }

    public static boolean isNothingOrNullableNothing(KotlinType r1) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(139);
    L5:
        return isConstructedFromGivenClass(r1, StandardNames.FqNames.nothing);
    }

    public static boolean isNullableAny(KotlinType r1) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(141);
    L5:
        if (isAnyOrNullableAny(r1) == true) goto L7;
    L9:
        return false;
    L7:
        if (r1.isMarkedNullable() == false) goto L9;
        return true;
    }

    public static boolean isPrimitiveArray(KotlinType r1) {
        if (r1 != null) goto L4;
        $$$reportNull$$$0(92);
    L4:
        ClassifierDescriptor r2 = r1.getConstructor().getDeclarationDescriptor();
        if (r2 != null) goto L7;
    L9:
        return false;
    L7:
        if (getPrimitiveArrayType(r2) == null) goto L9;
        return true;
    }

    public static boolean isPrimitiveClass(ClassDescriptor r1) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(97);
    L5:
        if (getPrimitiveType(r1) == null) goto L7;
        return true;
    L7:
        return false;
    }

    public static boolean isPrimitiveType(KotlinType r1) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(95);
    L5:
        if (r1.isMarkedNullable() == false) goto L7;
    L9:
        return false;
    L7:
        if (isPrimitiveTypeOrNullablePrimitiveType(r1) == false) goto L9;
        return true;
    }

    public static boolean isPrimitiveTypeOrNullablePrimitiveType(KotlinType r1) {
        if (r1 != null) goto L4;
        $$$reportNull$$$0(96);
    L4:
        ClassifierDescriptor r2 = r1.getConstructor().getDeclarationDescriptor();
        if ((r2 instanceof ClassDescriptor) == true) goto L7;
    L9:
        return false;
    L7:
        if (isPrimitiveClass((ClassDescriptor) r2) == false) goto L9;
        return true;
    }

    public static boolean isSpecialClassWithNoSupertypes(ClassDescriptor r1) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(108);
    L5:
        if (classFqNameEquals(r1, StandardNames.FqNames.any) == false) goto L7;
    L10:
        return true;
    L7:
        if (classFqNameEquals(r1, StandardNames.FqNames.nothing) == true) goto L10;
        return false;
    }

    public static boolean isString(KotlinType r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (isNotNullConstructedFromGivenClass(r1, StandardNames.FqNames.string) == false) goto L6;
        return true;
    }

    public static boolean isUByteArray(KotlinType r1) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(129);
    L5:
        return isConstructedFromGivenClassAndNotNullable(r1, StandardNames.FqNames.uByteArrayFqName.toUnsafe());
    }

    public static boolean isUIntArray(KotlinType r1) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(131);
    L5:
        return isConstructedFromGivenClassAndNotNullable(r1, StandardNames.FqNames.uIntArrayFqName.toUnsafe());
    }

    public static boolean isULongArray(KotlinType r1) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(132);
    L5:
        return isConstructedFromGivenClassAndNotNullable(r1, StandardNames.FqNames.uLongArrayFqName.toUnsafe());
    }

    public static boolean isUShortArray(KotlinType r1) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(130);
    L5:
        return isConstructedFromGivenClassAndNotNullable(r1, StandardNames.FqNames.uShortArrayFqName.toUnsafe());
    }

    public static boolean isUnderKotlinPackage(DeclarationDescriptor r1) {
        if (r1 != null) goto L4;
        $$$reportNull$$$0(10);
    L4:
        if (r1 == null) goto L10;
        if ((r1 instanceof PackageFragmentDescriptor) == true) goto L8;
        r1 = r1.getContainingDeclaration();
        goto L4
    L8:
        return ((PackageFragmentDescriptor) r1).getFqName().startsWith(StandardNames.BUILT_INS_PACKAGE_NAME);
    L10:
        return false;
    }

    public static boolean isUnit(KotlinType r1) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(143);
    L5:
        return isNotNullConstructedFromGivenClass(r1, StandardNames.FqNames.unit);
    }

    public static boolean isUnsignedArrayType(KotlinType r1) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(133);
    L5:
        if (isUByteArray(r1) == false) goto L7;
    L14:
        return true;
    L7:
        if (isUShortArray(r1) == true) goto L14;
        if (isUIntArray(r1) == true) goto L14;
        if (isULongArray(r1) == true) goto L14;
        return false;
    }

    public void createBuiltInsModule(boolean r10) {
        ModuleDescriptorImpl r0 = new ModuleDescriptorImpl(BUILTINS_MODULE_NAME, this.storageManager, this, null);
        this.builtInsModule = r0;
        r0.initialize(BuiltInsLoader.Companion.getInstance().createPackageFragmentProvider(this.storageManager, this.builtInsModule, getClassDescriptorFactories(), getPlatformDependentDeclarationFilter(), getAdditionalClassPartsProvider(), r10));
        ModuleDescriptorImpl r11 = this.builtInsModule;
        r11.setDependencies(new ModuleDescriptorImpl[]{r11});
    }

    public KotlinType getArrayElementType(KotlinType r4) {
        if (r4 != null) goto L5;
        $$$reportNull$$$0(68);
    L5:
        if (isArray(r4) == true) goto L7;
        KotlinType r0 = TypeUtils.makeNotNullable(r4);
        KotlinType r1 = (KotlinType) ((Primitives) this.primitives.invoke()).kotlinArrayTypeToPrimitiveKotlinType.get(r0);
        if (r1 == null) goto L17;
        return r1;
    L17:
        ModuleDescriptor r2 = DescriptorUtils.getContainingModuleOrNull(r0);
        if (r2 == null) goto L23;
        KotlinType r3 = getElementTypeForUnsignedArray(r0, r2);
        if (r3 == null) goto L23;
        return r3;
    L23:
        throw new IllegalStateException("not array: " + r4);
    L7:
        if (r4.getArguments().size() != 1) goto L13;
        KotlinType r5 = ((TypeProjection) ListProtector.get(r4.getArguments(), 0)).getType();
        if (r5 != null) goto L11;
        $$$reportNull$$$0(69);
    L11:
        return r5;
    L13:
        throw new IllegalStateException();
    }

    public ClassDescriptor getBuiltInClassByFqName(FqName r3) {
        if (r3 != null) goto L4;
        $$$reportNull$$$0(12);
    L4:
        ClassDescriptor r4 = DescriptorUtilKt.resolveClassByFqName(getBuiltInsModule(), r3, NoLookupLocation.FROM_BUILTINS);
        if (r4 != null) goto L7;
        $$$reportNull$$$0(13);
    L7:
        return r4;
    }

    public ClassDescriptor getFunction(int r1) {
        return getBuiltInClassByName(StandardNames.getFunctionName(r1));
    }

    public SimpleType getPrimitiveArrayKotlinType(PrimitiveType r2) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(74);
    L4:
        SimpleType r3 = (SimpleType) ((Primitives) this.primitives.invoke()).primitiveTypeToArrayKotlinType.get(r2);
        if (r3 != null) goto L7;
        $$$reportNull$$$0(75);
    L7:
        return r3;
    }

    public SimpleType getPrimitiveKotlinType(PrimitiveType r2) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(54);
    L4:
        SimpleType r3 = getPrimitiveClassDescriptor(r2).getDefaultType();
        if (r3 != null) goto L7;
        $$$reportNull$$$0(55);
    L7:
        return r3;
    }

    public ClassDescriptor getSuspendFunction(int r2) {
        ClassDescriptor r3 = getBuiltInClassByFqName(StandardNames.COROUTINES_PACKAGE_FQ_NAME.child(Name.identifier(StandardNames.getSuspendFunctionName(r2))));
        if (r3 != null) goto L5;
        $$$reportNull$$$0(18);
    L5:
        return r3;
    }

    public void setBuiltInsModule(final ModuleDescriptorImpl r3) {
        if (r3 != null) goto L4;
        $$$reportNull$$$0(1);
    L4:
        this.storageManager.compute(new AnonymousClass4(this, r3));
    }

    public static boolean isArrayOrPrimitiveArray(KotlinType r1) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(91);
    L5:
        if (isArray(r1) == false) goto L7;
    L10:
        return true;
    L7:
        if (isPrimitiveArray(r1) == true) goto L10;
        return false;
    }

    public static /* synthetic */ SimpleType access$000(KotlinBuiltIns r0, String r1) {
        return r0.getBuiltInTypeByClassName(r1);
    }

    public static /* synthetic */ ModuleDescriptorImpl access$202(KotlinBuiltIns r0, ModuleDescriptorImpl r1) {
        r0.builtInsModule = r1;
        return r1;
    }

    private static boolean classFqNameEquals(ClassifierDescriptor r2, FqNameUnsafe r3) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(104);
    L4:
        if (r3 != null) goto L7;
        $$$reportNull$$$0(105);
    L7:
        if (r2.getName().equals(r3.shortName()) == true) goto L9;
    L11:
        return false;
    L9:
        if (r3.equals(DescriptorUtils.getFqName(r2)) == false) goto L11;
        return true;
    }

    private static KotlinType getElementTypeForUnsignedArray(KotlinType r3, ModuleDescriptor r4) {
        if (r3 != null) goto L4;
        $$$reportNull$$$0(72);
    L4:
        if (r4 != null) goto L6;
        $$$reportNull$$$0(73);
    L6:
        ClassifierDescriptor r5 = r3.getConstructor().getDeclarationDescriptor();
        if (r5 != null) goto L9;
        return null;
    L9:
        UnsignedTypes r1 = UnsignedTypes.INSTANCE;
        if (r1.isShortNameOfUnsignedArray(r5.getName()) == true) goto L12;
        return null;
    L12:
        ClassId r6 = DescriptorUtilsKt.getClassId(r5);
        if (r6 != null) goto L15;
        return null;
    L15:
        ClassId r7 = r1.getUnsignedClassIdByArrayClassId(r6);
        if (r7 != null) goto L18;
        return null;
    L18:
        ClassDescriptor r8 = FindClassInModuleKt.findClassAcrossModuleDependencies(r4, r7);
        if (r8 != null) goto L22;
        return null;
    L22:
        return r8.getDefaultType();
    }

    private static boolean isConstructedFromGivenClass(KotlinType r1, FqNameUnsafe r2) {
        if (r1 != null) goto L4;
        $$$reportNull$$$0(98);
    L4:
        if (r2 != null) goto L7;
        $$$reportNull$$$0(99);
    L7:
        return isTypeConstructorForGivenClass(r1.getConstructor(), r2);
    }

    private static boolean isConstructedFromGivenClassAndNotNullable(KotlinType r1, FqNameUnsafe r2) {
        if (r1 != null) goto L4;
        $$$reportNull$$$0(135);
    L4:
        if (r2 != null) goto L7;
        $$$reportNull$$$0(136);
    L7:
        if (isConstructedFromGivenClass(r1, r2) == true) goto L9;
    L11:
        return false;
    L9:
        if (r1.isMarkedNullable() == true) goto L11;
        return true;
    }

    private static boolean isNotNullConstructedFromGivenClass(KotlinType r1, FqNameUnsafe r2) {
        if (r1 != null) goto L4;
        $$$reportNull$$$0(106);
    L4:
        if (r2 != null) goto L7;
        $$$reportNull$$$0(107);
    L7:
        if (r1.isMarkedNullable() == false) goto L9;
    L11:
        return false;
    L9:
        if (isConstructedFromGivenClass(r1, r2) == false) goto L11;
        return true;
    }

    public static boolean isTypeConstructorForGivenClass(TypeConstructor r1, FqNameUnsafe r2) {
        if (r1 != null) goto L4;
        $$$reportNull$$$0(102);
    L4:
        if (r2 != null) goto L6;
        $$$reportNull$$$0(103);
    L6:
        ClassifierDescriptor r3 = r1.getDeclarationDescriptor();
        if ((r3 instanceof ClassDescriptor) == true) goto L9;
    L11:
        return false;
    L9:
        if (classFqNameEquals(r3, r2) == false) goto L11;
        return true;
    }

    public SimpleType getArrayType(Variance r2, KotlinType r3) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(83);
    L4:
        if (r3 != null) goto L6;
        $$$reportNull$$$0(84);
    L6:
        SimpleType r4 = getArrayType(r2, r3, Annotations.Companion.getEMPTY());
        if (r4 != null) goto L9;
        $$$reportNull$$$0(85);
    L9:
        return r4;
    }

    public SimpleType getArrayType(Variance r2, KotlinType r3, Annotations r4) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(79);
    L4:
        if (r3 != null) goto L6;
        $$$reportNull$$$0(80);
    L6:
        if (r4 != null) goto L8;
        $$$reportNull$$$0(81);
    L8:
        List r5 = Collections.singletonList(new TypeProjectionImpl(r2, r3));
        SimpleType r6 = KotlinTypeFactory.simpleNotNullType(TypeAttributesKt.toDefaultAttributes(r4), getArray(), r5);
        if (r6 != null) goto L11;
        $$$reportNull$$$0(82);
    L11:
        return r6;
    }
}
