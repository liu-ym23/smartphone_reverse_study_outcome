package kotlin.reflect.jvm.internal.impl.resolve;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* JADX INFO: loaded from: classes3.dex */
public class DescriptorUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final FqName JVM_NAME = null;

    private static /* synthetic */ void $$$reportNull$$$0(int r23) {
        switch(r23) {
            case 4: goto L4;
            case 7: goto L4;
            case 9: goto L4;
            case 10: goto L4;
            case 12: goto L4;
            case 22: goto L4;
            case 40: goto L4;
            case 42: goto L4;
            case 43: goto L4;
            case 47: goto L4;
            case 49: goto L4;
            case 50: goto L4;
            case 51: goto L4;
            case 52: goto L4;
            case 53: goto L4;
            case 60: goto L4;
            case 62: goto L4;
            case 69: goto L4;
            case 73: goto L4;
            case 80: goto L4;
            case 81: goto L4;
            case 83: goto L4;
            case 86: goto L4;
            case 91: goto L4;
            case 93: goto L4;
            default: goto L3;
        };
    L3:
        String r10 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L6:
        switch(r23) {
            case 4: goto L8;
            case 7: goto L8;
            case 9: goto L8;
            case 10: goto L8;
            case 12: goto L8;
            case 22: goto L8;
            case 40: goto L8;
            case 42: goto L8;
            case 43: goto L8;
            case 47: goto L8;
            case 49: goto L8;
            case 50: goto L8;
            case 51: goto L8;
            case 52: goto L8;
            case 53: goto L8;
            case 60: goto L8;
            case 62: goto L8;
            case 69: goto L8;
            case 73: goto L8;
            case 80: goto L8;
            case 81: goto L8;
            case 83: goto L8;
            case 86: goto L8;
            case 91: goto L8;
            case 93: goto L8;
            default: goto L7;
        };
    L7:
        int r11 = 3;
    L9:
        Object[] r12 = new Object[r11];
        switch(r23) {
            case 1: goto L35;
            case 2: goto L35;
            case 3: goto L35;
            case 4: goto L34;
            case 5: goto L35;
            case 6: goto L35;
            case 7: goto L34;
            case 8: goto L35;
            case 9: goto L34;
            case 10: goto L34;
            case 11: goto L35;
            case 12: goto L34;
            case 13: goto L35;
            case 14: goto L35;
            case 15: goto L35;
            case 16: goto L33;
            case 17: goto L32;
            case 18: goto L31;
            case 19: goto L31;
            case 20: goto L30;
            case 21: goto L35;
            case 22: goto L34;
            case 23: goto L35;
            case 24: goto L35;
            case 25: goto L29;
            case 26: goto L28;
            case 27: goto L27;
            case 28: goto L28;
            case 29: goto L27;
            case 30: goto L26;
            case 31: goto L25;
            case 32: goto L26;
            case 33: goto L27;
            case 34: goto L35;
            case 35: goto L35;
            case 36: goto L35;
            case 37: goto L24;
            case 38: goto L23;
            case 39: goto L23;
            case 40: goto L34;
            case 41: goto L23;
            case 42: goto L34;
            case 43: goto L34;
            case 44: goto L23;
            case 45: goto L26;
            case 46: goto L22;
            case 47: goto L34;
            case 48: goto L23;
            case 49: goto L34;
            case 50: goto L34;
            case 51: goto L34;
            case 52: goto L34;
            case 53: goto L34;
            case 54: goto L23;
            case 55: goto L21;
            case 56: goto L20;
            case 57: goto L35;
            case 58: goto L35;
            case 59: goto L35;
            case 60: goto L34;
            case 61: goto L35;
            case 62: goto L34;
            case 63: goto L19;
            case 64: goto L26;
            case 65: goto L23;
            case 66: goto L23;
            case 67: goto L23;
            case 68: goto L18;
            case 69: goto L34;
            case 70: goto L17;
            case 71: goto L16;
            case 72: goto L15;
            case 73: goto L34;
            case 74: goto L23;
            case 75: goto L23;
            case 76: goto L14;
            case 77: goto L14;
            case 78: goto L14;
            case 79: goto L35;
            case 80: goto L34;
            case 81: goto L34;
            case 82: goto L13;
            case 83: goto L34;
            case 84: goto L13;
            case 85: goto L12;
            case 86: goto L34;
            case 87: goto L13;
            case 88: goto L12;
            case 89: goto L13;
            case 90: goto L12;
            case 91: goto L34;
            case 92: goto L35;
            case 93: goto L34;
            case 94: goto L35;
            default: goto L11;
        };
    L11:
        r12[0] = "containingDeclaration";
    L37:
        switch(r23) {
            case 4: goto L56;
            case 7: goto L55;
            case 9: goto L54;
            case 10: goto L54;
            case 12: goto L53;
            case 22: goto L52;
            case 40: goto L51;
            case 42: goto L50;
            case 43: goto L50;
            case 47: goto L49;
            case 49: goto L48;
            case 50: goto L48;
            case 51: goto L48;
            case 52: goto L48;
            case 53: goto L48;
            case 60: goto L47;
            case 62: goto L46;
            case 69: goto L45;
            case 73: goto L44;
            case 80: goto L43;
            case 81: goto L43;
            case 83: goto L42;
            case 86: goto L41;
            case 91: goto L40;
            case 93: goto L39;
            default: goto L38;
        };
    L38:
        r12[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
    L57:
        switch(r23) {
            case 1: goto L113;
            case 2: goto L112;
            case 3: goto L111;
            case 4: goto L114;
            case 5: goto L110;
            case 6: goto L109;
            case 7: goto L114;
            case 8: goto L108;
            case 9: goto L114;
            case 10: goto L114;
            case 11: goto L107;
            case 12: goto L114;
            case 13: goto L106;
            case 14: goto L105;
            case 15: goto L104;
            case 16: goto L103;
            case 17: goto L103;
            case 18: goto L102;
            case 19: goto L102;
            case 20: goto L101;
            case 21: goto L100;
            case 22: goto L114;
            case 23: goto L101;
            case 24: goto L99;
            case 25: goto L98;
            case 26: goto L97;
            case 27: goto L97;
            case 28: goto L96;
            case 29: goto L96;
            case 30: goto L95;
            case 31: goto L95;
            case 32: goto L94;
            case 33: goto L94;
            case 34: goto L93;
            case 35: goto L92;
            case 36: goto L91;
            case 37: goto L90;
            case 38: goto L89;
            case 39: goto L88;
            case 40: goto L114;
            case 41: goto L87;
            case 42: goto L114;
            case 43: goto L114;
            case 44: goto L86;
            case 45: goto L85;
            case 46: goto L84;
            case 47: goto L114;
            case 48: goto L83;
            case 49: goto L114;
            case 50: goto L114;
            case 51: goto L114;
            case 52: goto L114;
            case 53: goto L114;
            case 54: goto L82;
            case 55: goto L82;
            case 56: goto L82;
            case 57: goto L81;
            case 58: goto L80;
            case 59: goto L79;
            case 60: goto L114;
            case 61: goto L78;
            case 62: goto L114;
            case 63: goto L77;
            case 64: goto L77;
            case 65: goto L76;
            case 66: goto L75;
            case 67: goto L74;
            case 68: goto L73;
            case 69: goto L114;
            case 70: goto L72;
            case 71: goto L72;
            case 72: goto L71;
            case 73: goto L114;
            case 74: goto L70;
            case 75: goto L69;
            case 76: goto L68;
            case 77: goto L67;
            case 78: goto L66;
            case 79: goto L65;
            case 80: goto L114;
            case 81: goto L114;
            case 82: goto L64;
            case 83: goto L114;
            case 84: goto L63;
            case 85: goto L63;
            case 86: goto L114;
            case 87: goto L62;
            case 88: goto L62;
            case 89: goto L61;
            case 90: goto L61;
            case 91: goto L114;
            case 92: goto L60;
            case 93: goto L114;
            case 94: goto L59;
            default: goto L58;
        };
    L58:
        r12[2] = "getDispatchReceiverParameterIfNeeded";
        goto L114
    L59:
        r12[2] = "isMethodOfAny";
        goto L114
    L60:
        r12[2] = "getDirectMember";
        goto L114
    L61:
        r12[2] = "getPropertyByName";
        goto L114
    L62:
        r12[2] = "getFunctionByNameOrNull";
        goto L114
    L63:
        r12[2] = "getFunctionByName";
        goto L114
    L64:
        r12[2] = "getAllDescriptors";
        goto L114
    L65:
        r12[2] = "getContainingSourceFile";
        goto L114
    L66:
        r12[2] = "hasJvmNameAnnotation";
        goto L114
    L67:
        r12[2] = "findJvmNameAnnotation";
        goto L114
    L68:
        r12[2] = "getJvmName";
        goto L114
    L69:
        r12[2] = "canHaveDeclaredConstructors";
        goto L114
    L70:
        r12[2] = "isSingletonOrAnonymousObject";
        goto L114
    L71:
        r12[2] = "getAllOverriddenDeclarations";
        goto L114
    L72:
        r12[2] = "collectAllOverriddenDescriptors";
        goto L114
    L73:
        r12[2] = "getAllOverriddenDescriptors";
        goto L114
    L74:
        r12[2] = "classCanHaveOpenMembers";
        goto L114
    L75:
        r12[2] = "classCanHaveAbstractDeclaration";
        goto L114
    L76:
        r12[2] = "classCanHaveAbstractFakeOverride";
        goto L114
    L77:
        r12[2] = "shouldRecordInitializerForProperty";
        goto L114
    L78:
        r12[2] = "unwrapFakeOverrideToAnyDeclaration";
        goto L114
    L79:
        r12[2] = "unwrapFakeOverride";
        goto L114
    L80:
        r12[2] = "isTopLevelOrInnerClass";
        goto L114
    L81:
        r12[2] = "isStaticNestedClass";
        goto L114
    L82:
        r12[2] = "getInnerClassByName";
        goto L114
    L83:
        r12[2] = "getDefaultConstructorVisibility";
        goto L114
    L84:
        r12[2] = "getClassDescriptorForTypeConstructor";
        goto L114
    L85:
        r12[2] = "getClassDescriptorForType";
        goto L114
    L86:
        r12[2] = "getSuperClassDescriptor";
        goto L114
    L87:
        r12[2] = "getSuperClassType";
        goto L114
    L88:
        r12[2] = "getSuperclassDescriptors";
        goto L114
    L89:
        r12[2] = "hasAbstractMembers";
        goto L114
    L90:
        r12[2] = "isKindOf";
        goto L114
    L91:
        r12[2] = "isEnumEntry";
        goto L114
    L92:
        r12[2] = "isAnonymousFunction";
        goto L114
    L93:
        r12[2] = "isAnonymousObject";
        goto L114
    L94:
        r12[2] = "isSubtypeOfClass";
        goto L114
    L95:
        r12[2] = "isSameClass";
        goto L114
    L96:
        r12[2] = "isSubclass";
        goto L114
    L97:
        r12[2] = "isDirectSubclass";
        goto L114
    L98:
        r12[2] = "isAncestor";
        goto L114
    L99:
        r12[2] = "getContainingClass";
        goto L114
    L100:
        r12[2] = "getContainingModule";
        goto L114
    L101:
        r12[2] = "getContainingModuleOrNull";
        goto L114
    L102:
        r12[2] = "getParentOfType";
        goto L114
    L103:
        r12[2] = "areInSameModule";
        goto L114
    L104:
        r12[2] = "isStaticDeclaration";
        goto L114
    L105:
        r12[2] = "isOverride";
        goto L114
    L106:
        r12[2] = "isExtension";
        goto L114
    L107:
        r12[2] = "getClassIdForNonLocalClass";
        goto L114
    L108:
        r12[2] = "getFqNameFromTopLevelClass";
        goto L114
    L109:
        r12[2] = "getFqNameUnsafe";
        goto L114
    L110:
        r12[2] = "getFqNameSafeIfPossible";
        goto L114
    L111:
        r12[2] = "getFqNameSafe";
        goto L114
    L112:
        r12[2] = "getFqName";
        goto L114
    L113:
        r12[2] = "isLocal";
    L114:
        String r13 = String.format(r10, r12);
        switch(r23) {
            case 4: goto L118;
            case 7: goto L118;
            case 9: goto L118;
            case 10: goto L118;
            case 12: goto L118;
            case 22: goto L118;
            case 40: goto L118;
            case 42: goto L118;
            case 43: goto L118;
            case 47: goto L118;
            case 49: goto L118;
            case 50: goto L118;
            case 51: goto L118;
            case 52: goto L118;
            case 53: goto L118;
            case 60: goto L118;
            case 62: goto L118;
            case 69: goto L118;
            case 73: goto L118;
            case 80: goto L118;
            case 81: goto L118;
            case 83: goto L118;
            case 86: goto L118;
            case 91: goto L118;
            case 93: goto L118;
            default: goto L119;
        };
    L119:
        throw new IllegalArgumentException(r13);
    L118:
        throw new IllegalStateException(r13);
    L39:
        r12[1] = "getDirectMember";
        goto L57
    L40:
        r12[1] = "getPropertyByName";
        goto L57
    L41:
        r12[1] = "getFunctionByName";
        goto L57
    L42:
        r12[1] = "getAllDescriptors";
        goto L57
    L43:
        r12[1] = "getContainingSourceFile";
        goto L57
    L44:
        r12[1] = "getAllOverriddenDeclarations";
        goto L57
    L45:
        r12[1] = "getAllOverriddenDescriptors";
        goto L57
    L46:
        r12[1] = "unwrapFakeOverrideToAnyDeclaration";
        goto L57
    L47:
        r12[1] = "unwrapFakeOverride";
        goto L57
    L48:
        r12[1] = "getDefaultConstructorVisibility";
        goto L57
    L49:
        r12[1] = "getClassDescriptorForTypeConstructor";
        goto L57
    L50:
        r12[1] = "getSuperClassType";
        goto L57
    L51:
        r12[1] = "getSuperclassDescriptors";
        goto L57
    L52:
        r12[1] = "getContainingModule";
        goto L57
    L53:
        r12[1] = "getClassIdForNonLocalClass";
        goto L57
    L54:
        r12[1] = "getFqNameFromTopLevelClass";
        goto L57
    L55:
        r12[1] = "getFqNameUnsafe";
        goto L57
    L56:
        r12[1] = "getFqNameSafe";
        goto L57
    L12:
        r12[0] = ActivityLifecycle.NAME;
        goto L37
    L13:
        r12[0] = "scope";
        goto L37
    L14:
        r12[0] = "annotated";
        goto L37
    L15:
        r12[0] = "memberDescriptor";
        goto L37
    L16:
        r12[0] = "result";
        goto L37
    L17:
        r12[0] = "current";
        goto L37
    L18:
        r12[0] = "f";
        goto L37
    L19:
        r12[0] = "variable";
        goto L37
    L20:
        r12[0] = "location";
        goto L37
    L21:
        r12[0] = "innerClassName";
        goto L37
    L22:
        r12[0] = "typeConstructor";
        goto L37
    L23:
        r12[0] = "classDescriptor";
        goto L37
    L24:
        r12[0] = "classKind";
        goto L37
    L25:
        r12[0] = "other";
        goto L37
    L26:
        r12[0] = WsConstants.KEY_CONNECTION_TYPE;
        goto L37
    L27:
        r12[0] = "superClass";
        goto L37
    L28:
        r12[0] = "subClass";
        goto L37
    L29:
        r12[0] = "declarationDescriptor";
        goto L37
    L30:
        r12[0] = "kotlinType";
        goto L37
    L31:
        r12[0] = "aClass";
        goto L37
    L32:
        r12[0] = "second";
        goto L37
    L33:
        r12[0] = "first";
        goto L37
    L34:
        r12[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
        goto L37
    L35:
        r12[0] = "descriptor";
        goto L37
    L8:
        r11 = 2;
        goto L9
    L4:
        r10 = "@NotNull method %s.%s must not return null";
        goto L6
    }

    static {
        JVM_NAME = new FqName("kotlin.jvm.JvmName");
    }

    private DescriptorUtils() {
    }

    public static boolean areInSameModule(DeclarationDescriptor r10, DeclarationDescriptor r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(16);
    L4:
        if (r11 != null) goto L7;
        $$$reportNull$$$0(17);
    L7:
        return getContainingModule(r10).equals(getContainingModule(r11));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <D extends CallableDescriptor> void collectAllOverriddenDescriptors(D r10, Set<D> r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(70);
    L4:
        if (r11 != 0) goto L7;
        $$$reportNull$$$0(71);
    L7:
        if (r11.contains(r10) == false) goto L9;
        return;
    L9:
        Iterator<? extends CallableDescriptor> r12 = r10.getOriginal().getOverriddenDescriptors().iterator();
    L11:
        if (r12.hasNext() == false) goto L13;
        CallableDescriptor r13 = r12.next().getOriginal();
        collectAllOverriddenDescriptors(r13, r11);
        r11.add(r13);
        goto L11
    }

    public static <D extends CallableDescriptor> Set<D> getAllOverriddenDescriptors(D r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(68);
    L4:
        LinkedHashSet r11 = new LinkedHashSet();
        collectAllOverriddenDescriptors(r10.getOriginal(), r11);
        return r11;
    }

    public static ClassDescriptor getClassDescriptorForType(KotlinType r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(45);
    L5:
        return getClassDescriptorForTypeConstructor(r10.getConstructor());
    }

    public static ClassDescriptor getClassDescriptorForTypeConstructor(TypeConstructor r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(46);
    L4:
        ClassDescriptor r11 = (ClassDescriptor) r10.mo1323getDeclarationDescriptor();
        if (r11 != null) goto L7;
        $$$reportNull$$$0(47);
    L7:
        return r11;
    }

    public static ModuleDescriptor getContainingModule(DeclarationDescriptor r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(21);
    L4:
        ModuleDescriptor r11 = getContainingModuleOrNull(r10);
        if (r11 != null) goto L7;
        $$$reportNull$$$0(22);
    L7:
        return r11;
    }

    public static ModuleDescriptor getContainingModuleOrNull(DeclarationDescriptor r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(23);
    L4:
        if (r10 == null) goto L14;
        if ((r10 instanceof ModuleDescriptor) == true) goto L8;
        if ((r10 instanceof PackageViewDescriptor) == true) goto L12;
        r10 = r10.getContainingDeclaration();
        goto L4
    L12:
        return ((PackageViewDescriptor) r10).getModule();
    L8:
        return (ModuleDescriptor) r10;
    L14:
        return null;
    }

    public static ModuleDescriptor getContainingModuleOrNull(KotlinType r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(20);
    L4:
        ClassifierDescriptor r11 = r10.getConstructor().mo1323getDeclarationDescriptor();
        if (r11 != null) goto L9;
        return null;
    L9:
        return getContainingModuleOrNull(r11);
    }

    public static SourceFile getContainingSourceFile(DeclarationDescriptor r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(79);
    L5:
        if ((r10 instanceof PropertySetterDescriptor) == false) goto L8;
        r10 = ((PropertySetterDescriptor) r10).getCorrespondingProperty();
    L8:
        if ((r10 instanceof DeclarationDescriptorWithSource) == false) goto L13;
        SourceFile r11 = ((DeclarationDescriptorWithSource) r10).getSource().getContainingFile();
        if (r11 != null) goto L12;
        $$$reportNull$$$0(80);
    L12:
        return r11;
    L13:
        SourceFile r12 = SourceFile.NO_SOURCE_FILE;
        if (r12 != null) goto L16;
        $$$reportNull$$$0(81);
    L16:
        return r12;
    }

    public static DescriptorVisibility getDefaultConstructorVisibility(ClassDescriptor r10, boolean r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(48);
    L4:
        ClassKind r12 = r10.getKind();
        if (r12 != ClassKind.ENUM_CLASS) goto L7;
    L30:
        DescriptorVisibility r13 = DescriptorVisibilities.PRIVATE;
        if (r13 != null) goto L33;
        $$$reportNull$$$0(49);
    L33:
        return r13;
    L7:
        if (r12.isSingleton() == true) goto L30;
        if (isSealedClass(r10) == false) goto L21;
        if (r11 == false) goto L16;
        DescriptorVisibility r14 = DescriptorVisibilities.PROTECTED;
        if (r14 != null) goto L15;
        $$$reportNull$$$0(50);
    L15:
        return r14;
    L16:
        DescriptorVisibility r15 = DescriptorVisibilities.PRIVATE;
        if (r15 != null) goto L19;
        $$$reportNull$$$0(51);
    L19:
        return r15;
    L21:
        if (isAnonymousObject(r10) == false) goto L26;
        DescriptorVisibility r16 = DescriptorVisibilities.DEFAULT_VISIBILITY;
        if (r16 != null) goto L25;
        $$$reportNull$$$0(52);
    L25:
        return r16;
    L26:
        DescriptorVisibility r17 = DescriptorVisibilities.PUBLIC;
        if (r17 != null) goto L29;
        $$$reportNull$$$0(53);
    L29:
        return r17;
    }

    public static ReceiverParameterDescriptor getDispatchReceiverParameterIfNeeded(DeclarationDescriptor r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(0);
    L5:
        if ((r10 instanceof ClassDescriptor) == true) goto L7;
        return null;
    L7:
        return ((ClassDescriptor) r10).getThisAsReceiverParameter();
    }

    public static FqNameUnsafe getFqName(DeclarationDescriptor r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(2);
    L4:
        FqName r11 = getFqNameSafeIfPossible(r10);
        if (r11 == null) goto L8;
        return r11.toUnsafe();
    L8:
        return getFqNameUnsafe(r10);
    }

    public static FqName getFqNameSafe(DeclarationDescriptor r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(3);
    L4:
        FqName r11 = getFqNameSafeIfPossible(r10);
        if (r11 != null) goto L8;
        r11 = getFqNameUnsafe(r10).toSafe();
    L8:
        if (r11 != null) goto L10;
        $$$reportNull$$$0(4);
    L10:
        return r11;
    }

    private static FqName getFqNameSafeIfPossible(DeclarationDescriptor r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(5);
    L5:
        if ((r10 instanceof ModuleDescriptor) == true) goto L20;
        if (ErrorUtils.isError(r10) == true) goto L20;
        if ((r10 instanceof PackageViewDescriptor) == false) goto L14;
        return ((PackageViewDescriptor) r10).getFqName();
    L14:
        if ((r10 instanceof PackageFragmentDescriptor) == true) goto L16;
        return null;
    L16:
        return ((PackageFragmentDescriptor) r10).getFqName();
    L20:
        return FqName.ROOT;
    }

    private static FqNameUnsafe getFqNameUnsafe(DeclarationDescriptor r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(6);
    L4:
        FqNameUnsafe r11 = getFqName(r10.getContainingDeclaration()).child(r10.getName());
        if (r11 != null) goto L7;
        $$$reportNull$$$0(7);
    L7:
        return r11;
    }

    public static <D extends DeclarationDescriptor> D getParentOfType(DeclarationDescriptor r10, Class<D> r11) {
        if (r11 != null) goto L5;
        $$$reportNull$$$0(18);
    L5:
        return (D) getParentOfType(r10, r11, true);
    }

    public static <D extends DeclarationDescriptor> D getParentOfType(DeclarationDescriptor r10, Class<D> r11, boolean r12) {
        if (r11 != null) goto L5;
        $$$reportNull$$$0(19);
    L5:
        if (r10 != null) goto L7;
        return null;
    L7:
        if (r12 == false) goto L9;
        r10 = (D) r10.getContainingDeclaration();
    L9:
        if (r10 == null) goto L13;
        if (r11.isInstance(r10) == true) goto L12;
        r10 = (D) r10.getContainingDeclaration();
        goto L9
    L12:
        return (D) r10;
    L13:
        return null;
    }

    public static ClassDescriptor getSuperClassDescriptor(ClassDescriptor r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(44);
    L4:
        Iterator<KotlinType> r11 = r10.getTypeConstructor().mo1324getSupertypes().iterator();
    L6:
        if (r11.hasNext() == false) goto L10;
        ClassDescriptor r12 = getClassDescriptorForType(r11.next());
        if (r12.getKind() == ClassKind.INTERFACE) goto L6;
        return r12;
    L10:
        return null;
    }

    public static boolean isAnnotationClass(DeclarationDescriptor r10) {
        return isKindOf(r10, ClassKind.ANNOTATION_CLASS);
    }

    public static boolean isAnonymousObject(DeclarationDescriptor r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(34);
    L5:
        if (isClass(r10) == true) goto L7;
    L9:
        return false;
    L7:
        if (r10.getName().equals(SpecialNames.NO_NAME_PROVIDED) == false) goto L9;
        return true;
    }

    public static boolean isClass(DeclarationDescriptor r10) {
        return isKindOf(r10, ClassKind.CLASS);
    }

    public static boolean isClassOrEnumClass(DeclarationDescriptor r10) {
        if (isClass(r10) == false) goto L5;
    L8:
        return true;
    L5:
        if (isEnumClass(r10) == true) goto L8;
        return false;
    }

    public static boolean isCompanionObject(DeclarationDescriptor r10) {
        if (isKindOf(r10, ClassKind.OBJECT) == true) goto L5;
    L7:
        return false;
    L5:
        if (((ClassDescriptor) r10).isCompanionObject() == false) goto L7;
        return true;
    }

    public static boolean isDescriptorWithLocalVisibility(DeclarationDescriptor r10) {
        if ((r10 instanceof DeclarationDescriptorWithVisibility) == true) goto L5;
    L7:
        return false;
    L5:
        if (((DeclarationDescriptorWithVisibility) r10).getVisibility() != DescriptorVisibilities.LOCAL) goto L7;
        return true;
    }

    public static boolean isDirectSubclass(ClassDescriptor r10, ClassDescriptor r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(26);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(27);
    L6:
        Iterator<KotlinType> r12 = r10.getTypeConstructor().mo1324getSupertypes().iterator();
    L8:
        if (r12.hasNext() == false) goto L13;
        if (isSameClass(r12.next(), r11.getOriginal()) == false) goto L8;
        return true;
    L13:
        return false;
    }

    public static boolean isEnumClass(DeclarationDescriptor r10) {
        return isKindOf(r10, ClassKind.ENUM_CLASS);
    }

    public static boolean isEnumEntry(DeclarationDescriptor r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(36);
    L5:
        return isKindOf(r10, ClassKind.ENUM_ENTRY);
    }

    public static boolean isInterface(DeclarationDescriptor r10) {
        return isKindOf(r10, ClassKind.INTERFACE);
    }

    private static boolean isKindOf(DeclarationDescriptor r10, ClassKind r11) {
        if (r11 != null) goto L5;
        $$$reportNull$$$0(37);
    L5:
        if ((r10 instanceof ClassDescriptor) == true) goto L7;
    L9:
        return false;
    L7:
        if (((ClassDescriptor) r10).getKind() != r11) goto L9;
        return true;
    }

    public static boolean isLocal(DeclarationDescriptor r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(1);
    L5:
        if (r10 == null) goto L13;
        if (isAnonymousObject(r10) == true) goto L12;
        if (isDescriptorWithLocalVisibility(r10) == true) goto L12;
        r10 = r10.getContainingDeclaration();
    L12:
        return true;
    L13:
        return false;
    }

    private static boolean isSameClass(KotlinType r10, DeclarationDescriptor r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(30);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(31);
    L6:
        ClassifierDescriptor r12 = r10.getConstructor().mo1323getDeclarationDescriptor();
        if (r12 == null) goto L16;
        DeclarationDescriptor r13 = r12.getOriginal();
        if ((r13 instanceof ClassifierDescriptor) == true) goto L11;
        return false;
    L11:
        if ((r11 instanceof ClassifierDescriptor) == true) goto L13;
        return false;
    L13:
        if (((ClassifierDescriptor) r11).getTypeConstructor().equals(((ClassifierDescriptor) r13).getTypeConstructor()) == false) goto L20;
        return true;
    L20:
        return false;
    L16:
        return false;
    }

    public static boolean isSealedClass(DeclarationDescriptor r10) {
        if (isKindOf(r10, ClassKind.CLASS) == true) goto L7;
        if (isKindOf(r10, ClassKind.INTERFACE) == true) goto L7;
    L9:
        return false;
    L7:
        if (((ClassDescriptor) r10).getModality() != Modality.SEALED) goto L9;
        return true;
    }

    public static boolean isSubclass(ClassDescriptor r10, ClassDescriptor r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(28);
    L4:
        if (r11 != null) goto L7;
        $$$reportNull$$$0(29);
    L7:
        return isSubtypeOfClass(r10.getDefaultType(), r11.getOriginal());
    }

    public static boolean isSubtypeOfClass(KotlinType r10, DeclarationDescriptor r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(32);
    L4:
        if (r11 != null) goto L7;
        $$$reportNull$$$0(33);
    L7:
        if (isSameClass(r10, r11) == false) goto L9;
        return true;
    L9:
        Iterator<KotlinType> r12 = r10.getConstructor().mo1324getSupertypes().iterator();
    L11:
        if (r12.hasNext() == false) goto L15;
        if (isSubtypeOfClass(r12.next(), r11) == false) goto L11;
        return true;
    L15:
        return false;
    }

    public static boolean isTopLevelDeclaration(DeclarationDescriptor r10) {
        if (r10 != null) goto L4;
    L6:
        return false;
    L4:
        if ((r10.getContainingDeclaration() instanceof PackageFragmentDescriptor) == false) goto L6;
        return true;
    }

    public static boolean shouldRecordInitializerForProperty(VariableDescriptor r10, KotlinType r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(63);
    L4:
        if (r11 != null) goto L7;
        $$$reportNull$$$0(64);
    L7:
        if (r10.isVar() == false) goto L9;
        return false;
    L9:
        if (KotlinTypeKt.isError(r11) == false) goto L12;
        return false;
    L12:
        if (TypeUtils.acceptsNullable(r11) == false) goto L14;
        return true;
    L14:
        KotlinBuiltIns r12 = DescriptorUtilsKt.getBuiltIns(r10);
        if (KotlinBuiltIns.isPrimitiveType(r11) == true) goto L25;
        KotlinTypeChecker r13 = KotlinTypeChecker.DEFAULT;
        if (r13.equalTypes(r12.getStringType(), r11) == true) goto L25;
        if (r13.equalTypes(r12.getNumber().getDefaultType(), r11) == true) goto L25;
        if (r13.equalTypes(r12.getAnyType(), r11) == true) goto L25;
        UnsignedTypes r14 = UnsignedTypes.INSTANCE;
        if (UnsignedTypes.isUnsignedType(r11) == true) goto L25;
        return false;
    L25:
        return true;
    }

    public static <D extends CallableMemberDescriptor> D unwrapFakeOverride(D r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(59);
    L5:
        if (r10.getKind() != CallableMemberDescriptor.Kind.FAKE_OVERRIDE) goto L11;
        Collection<? extends CallableMemberDescriptor> r11 = r10.getOverriddenDescriptors();
        if (r11.isEmpty() == true) goto L10;
        r10 = (D) r11.iterator().next();
        goto L5
    L10:
        throw new IllegalStateException("Fake override should have at least one overridden descriptor: " + r10);
    L11:
        return r10;
    }

    public static <D extends DeclarationDescriptorWithVisibility> D unwrapFakeOverrideToAnyDeclaration(D r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(61);
    L5:
        if ((r10 instanceof CallableMemberDescriptor) == true) goto L7;
        if (r10 != null) goto L10;
        $$$reportNull$$$0(62);
    L10:
        return r10;
    L7:
        return unwrapFakeOverride((CallableMemberDescriptor) r10);
    }
}
