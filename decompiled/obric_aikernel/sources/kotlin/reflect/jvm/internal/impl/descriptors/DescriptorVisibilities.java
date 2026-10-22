package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import kotlin.reflect.jvm.internal.impl.util.ModuleVisibilityHelper;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public class DescriptorVisibilities {
    public static final ReceiverValue ALWAYS_SUITABLE_RECEIVER = null;
    public static final DescriptorVisibility DEFAULT_VISIBILITY = null;

    @Deprecated
    public static final ReceiverValue FALSE_IF_PROTECTED = null;
    public static final DescriptorVisibility INHERITED = null;
    public static final DescriptorVisibility INTERNAL = null;
    public static final DescriptorVisibility INVISIBLE_FAKE = null;
    public static final Set<DescriptorVisibility> INVISIBLE_FROM_OTHER_MODULES = null;
    private static final ReceiverValue IRRELEVANT_RECEIVER = null;
    public static final DescriptorVisibility LOCAL = null;
    private static final ModuleVisibilityHelper MODULE_VISIBILITY_HELPER = null;
    private static final Map<DescriptorVisibility, Integer> ORDERED_VISIBILITIES = null;
    public static final DescriptorVisibility PRIVATE = null;
    public static final DescriptorVisibility PRIVATE_TO_THIS = null;
    public static final DescriptorVisibility PROTECTED = null;
    public static final DescriptorVisibility PUBLIC = null;
    public static final DescriptorVisibility UNKNOWN = null;
    private static final Map<Visibility, DescriptorVisibility> visibilitiesMapping = null;

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        if (r10 == 16) goto L5;
        String r11 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L7:
        if (r10 == 16) goto L9;
        int r12 = 3;
    L10:
        Object[] r13 = new Object[r12];
        if (r10 == 1) goto L23;
        if (r10 == 3) goto L23;
        if (r10 == 5) goto L23;
        if (r10 == 7) goto L23;
        switch(r10) {
            case 9: goto L23;
            case 10: goto L22;
            case 11: goto L21;
            case 12: goto L22;
            case 13: goto L21;
            case 14: goto L20;
            case 15: goto L20;
            case 16: goto L19;
            default: goto L18;
        };
    L18:
        r13[0] = "what";
    L25:
        if (r10 == 16) goto L27;
        r13[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities";
    L28:
        switch(r10) {
            case 2: goto L37;
            case 3: goto L37;
            case 4: goto L36;
            case 5: goto L36;
            case 6: goto L35;
            case 7: goto L35;
            case 8: goto L34;
            case 9: goto L34;
            case 10: goto L33;
            case 11: goto L33;
            case 12: goto L32;
            case 13: goto L32;
            case 14: goto L31;
            case 15: goto L30;
            case 16: goto L38;
            default: goto L29;
        };
    L29:
        r13[2] = "isVisible";
        goto L38
    L30:
        r13[2] = "toDescriptorVisibility";
        goto L38
    L31:
        r13[2] = "isPrivate";
        goto L38
    L32:
        r13[2] = "compare";
        goto L38
    L33:
        r13[2] = "compareLocal";
        goto L38
    L34:
        r13[2] = "findInvisibleMember";
        goto L38
    L35:
        r13[2] = "inSameFile";
        goto L38
    L36:
        r13[2] = "isVisibleWithAnyReceiver";
        goto L38
    L37:
        r13[2] = "isVisibleIgnoringReceiver";
    L38:
        String r14 = String.format(r11, r13);
        if (r10 == 16) goto L42;
        throw new IllegalArgumentException(r14);
    L42:
        throw new IllegalStateException(r14);
    L27:
        r13[1] = "toDescriptorVisibility";
        goto L28
    L19:
        r13[0] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities";
        goto L25
    L20:
        r13[0] = "visibility";
        goto L25
    L21:
        r13[0] = "second";
        goto L25
    L22:
        r13[0] = "first";
    L23:
        r13[0] = "from";
        goto L25
    L9:
        r12 = 2;
        goto L10
    L5:
        r11 = "@NotNull method %s.%s must not return null";
        goto L7
    }

    static {
        final Visibilities.Private r10 = Visibilities.Private.INSTANCE;
        DelegatedDescriptorVisibility r11 = new AnonymousClass1(r10);
        PRIVATE = r11;
        final Visibilities.PrivateToThis r12 = Visibilities.PrivateToThis.INSTANCE;
        DelegatedDescriptorVisibility r13 = new AnonymousClass2(r12);
        PRIVATE_TO_THIS = r13;
        final Visibilities.Protected r14 = Visibilities.Protected.INSTANCE;
        DelegatedDescriptorVisibility r15 = new AnonymousClass3(r14);
        PROTECTED = r15;
        final Visibilities.Internal r16 = Visibilities.Internal.INSTANCE;
        DelegatedDescriptorVisibility r17 = new AnonymousClass4(r16);
        INTERNAL = r17;
        final Visibilities.Public r18 = Visibilities.Public.INSTANCE;
        DelegatedDescriptorVisibility r19 = new AnonymousClass5(r18);
        PUBLIC = r19;
        final Visibilities.Local r20 = Visibilities.Local.INSTANCE;
        DelegatedDescriptorVisibility r21 = new AnonymousClass6(r20);
        LOCAL = r21;
        final Visibilities.Inherited r22 = Visibilities.Inherited.INSTANCE;
        DelegatedDescriptorVisibility r23 = new AnonymousClass7(r22);
        INHERITED = r23;
        final Visibilities.InvisibleFake r24 = Visibilities.InvisibleFake.INSTANCE;
        DelegatedDescriptorVisibility r25 = new AnonymousClass8(r24);
        INVISIBLE_FAKE = r25;
        final Visibilities.Unknown r110 = Visibilities.Unknown.INSTANCE;
        DelegatedDescriptorVisibility r26 = new AnonymousClass9(r110);
        UNKNOWN = r26;
        INVISIBLE_FROM_OTHER_MODULES = Collections.unmodifiableSet(SetsKt.setOf(new DescriptorVisibility[]{r11, r13, r17, r21}));
        HashMap r111 = CollectionsKt.newHashMapWithExpectedSize(4);
        r111.put(r13, 0);
        r111.put(r11, 0);
        r111.put(r17, 1);
        r111.put(r15, 1);
        r111.put(r19, 2);
        ORDERED_VISIBILITIES = Collections.unmodifiableMap(r111);
        DEFAULT_VISIBILITY = r19;
        IRRELEVANT_RECEIVER = new AnonymousClass10();
        ALWAYS_SUITABLE_RECEIVER = new AnonymousClass11();
        FALSE_IF_PROTECTED = new AnonymousClass12();
        Iterator r27 = ServiceLoader.load(ModuleVisibilityHelper.class, ModuleVisibilityHelper.class.getClassLoader()).iterator();
        if (r27.hasNext() == false) goto L5;
        ModuleVisibilityHelper r28 = (ModuleVisibilityHelper) r27.next();
    L6:
        MODULE_VISIBILITY_HELPER = r28;
        visibilitiesMapping = new HashMap();
        recordVisibilityMapping(r11);
        recordVisibilityMapping(r13);
        recordVisibilityMapping(r15);
        recordVisibilityMapping(r17);
        recordVisibilityMapping(r19);
        recordVisibilityMapping(r21);
        recordVisibilityMapping(r23);
        recordVisibilityMapping(r25);
        recordVisibilityMapping(r26);
        return;
    L5:
        r28 = ModuleVisibilityHelper.EMPTY.INSTANCE;
        goto L6
    }

    static /* synthetic */ ReceiverValue access$000() {
        return IRRELEVANT_RECEIVER;
    }

    static /* synthetic */ ModuleVisibilityHelper access$100() {
        return MODULE_VISIBILITY_HELPER;
    }

    public static Integer compare(DescriptorVisibility r10, DescriptorVisibility r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(12);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(13);
    L6:
        Integer r12 = r10.compareTo(r11);
        if (r12 == null) goto L9;
        return r12;
    L9:
        Integer r13 = r11.compareTo(r10);
        if (r13 != null) goto L12;
        return null;
    L12:
        return Integer.valueOf(-r13.intValue());
    }

    public static DeclarationDescriptorWithVisibility findInvisibleMember(ReceiverValue r10, DeclarationDescriptorWithVisibility r11, DeclarationDescriptor r12, boolean r13) {
        if (r11 != null) goto L4;
        $$$reportNull$$$0(8);
    L4:
        if (r12 != null) goto L6;
        $$$reportNull$$$0(9);
    L6:
        DeclarationDescriptor r14 = r11.getOriginal();
    L7:
        DeclarationDescriptorWithVisibility r15 = (DeclarationDescriptorWithVisibility) r14;
        if (r15 == null) goto L16;
        if (r15.getVisibility() == LOCAL) goto L16;
        if (r15.getVisibility().isVisible(r10, r15, r12, r13) == false) goto L13;
        r14 = DescriptorUtils.getParentOfType(r15, DeclarationDescriptorWithVisibility.class);
        goto L7
    L13:
        return r15;
    L16:
        if ((r11 instanceof TypeAliasConstructorDescriptor) == false) goto L20;
        DeclarationDescriptorWithVisibility r16 = findInvisibleMember(r10, ((TypeAliasConstructorDescriptor) r11).getUnderlyingConstructorDescriptor(), r12, r13);
        if (r16 == null) goto L25;
        return r16;
    L25:
        return null;
    L20:
        return null;
    }

    public static boolean inSameFile(DeclarationDescriptor r10, DeclarationDescriptor r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(6);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(7);
    L6:
        SourceFile r12 = DescriptorUtils.getContainingSourceFile(r11);
        if (r12 != SourceFile.NO_SOURCE_FILE) goto L9;
        return false;
    L9:
        return r12.equals(DescriptorUtils.getContainingSourceFile(r10));
    }

    public static boolean isPrivate(DescriptorVisibility r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(14);
    L5:
        if (r10 != PRIVATE) goto L7;
    L10:
        return true;
    L7:
        if (r10 == PRIVATE_TO_THIS) goto L10;
        return false;
    }

    public static boolean isVisibleIgnoringReceiver(DeclarationDescriptorWithVisibility r10, DeclarationDescriptor r11, boolean r12) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(2);
    L4:
        if (r11 != null) goto L7;
        $$$reportNull$$$0(3);
    L7:
        if (findInvisibleMember(ALWAYS_SUITABLE_RECEIVER, r10, r11, r12) != null) goto L9;
        return true;
    L9:
        return false;
    }

    private static void recordVisibilityMapping(DescriptorVisibility r10) {
        visibilitiesMapping.put(r10.getDelegate(), r10);
    }

    public static DescriptorVisibility toDescriptorVisibility(Visibility r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(15);
    L4:
        DescriptorVisibility r11 = visibilitiesMapping.get(r10);
        if (r11 == null) goto L8;
        return r11;
    L8:
        throw new IllegalArgumentException("Inapplicable visibility: " + r10);
    }
}
