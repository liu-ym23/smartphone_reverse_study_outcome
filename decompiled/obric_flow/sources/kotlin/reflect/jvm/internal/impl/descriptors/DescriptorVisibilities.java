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
        String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L7:
        if (r10 == 16) goto L9;
        int r11 = 3;
    L10:
        Object[] r12 = new Object[r11];
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
        r12[0] = "what";
    L25:
        if (r10 == 16) goto L27;
        r12[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities";
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
        r12[2] = "isVisible";
        goto L38
    L30:
        r12[2] = "toDescriptorVisibility";
        goto L38
    L31:
        r12[2] = "isPrivate";
        goto L38
    L32:
        r12[2] = "compare";
        goto L38
    L33:
        r12[2] = "compareLocal";
        goto L38
    L34:
        r12[2] = "findInvisibleMember";
        goto L38
    L35:
        r12[2] = "inSameFile";
        goto L38
    L36:
        r12[2] = "isVisibleWithAnyReceiver";
        goto L38
    L37:
        r12[2] = "isVisibleIgnoringReceiver";
    L38:
        String r13 = String.format(r5, r12);
        if (r10 == 16) goto L42;
        throw new IllegalArgumentException(r13);
    L42:
        throw new IllegalStateException(r13);
    L27:
        r12[1] = "toDescriptorVisibility";
        goto L28
    L19:
        r12[0] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities";
        goto L25
    L20:
        r12[0] = "visibility";
        goto L25
    L21:
        r12[0] = "second";
        goto L25
    L22:
        r12[0] = "first";
    L23:
        r12[0] = "from";
        goto L25
    L9:
        r11 = 2;
        goto L10
    L5:
        r5 = "@NotNull method %s.%s must not return null";
        goto L7
    }

    static {
        final Visibilities.Private r5 = Visibilities.Private.INSTANCE;
        DelegatedDescriptorVisibility r10 = new AnonymousClass1(r5);
        PRIVATE = r10;
        final Visibilities.PrivateToThis r11 = Visibilities.PrivateToThis.INSTANCE;
        DelegatedDescriptorVisibility r12 = new AnonymousClass2(r11);
        PRIVATE_TO_THIS = r12;
        final Visibilities.Protected r13 = Visibilities.Protected.INSTANCE;
        DelegatedDescriptorVisibility r14 = new AnonymousClass3(r13);
        PROTECTED = r14;
        final Visibilities.Internal r15 = Visibilities.Internal.INSTANCE;
        DelegatedDescriptorVisibility r16 = new AnonymousClass4(r15);
        INTERNAL = r16;
        final Visibilities.Public r17 = Visibilities.Public.INSTANCE;
        DelegatedDescriptorVisibility r18 = new AnonymousClass5(r17);
        PUBLIC = r18;
        final Visibilities.Local r19 = Visibilities.Local.INSTANCE;
        DelegatedDescriptorVisibility r20 = new AnonymousClass6(r19);
        LOCAL = r20;
        final Visibilities.Inherited r21 = Visibilities.Inherited.INSTANCE;
        DelegatedDescriptorVisibility r22 = new AnonymousClass7(r21);
        INHERITED = r22;
        final Visibilities.InvisibleFake r23 = Visibilities.InvisibleFake.INSTANCE;
        DelegatedDescriptorVisibility r24 = new AnonymousClass8(r23);
        INVISIBLE_FAKE = r24;
        final Visibilities.Unknown r25 = Visibilities.Unknown.INSTANCE;
        DelegatedDescriptorVisibility r26 = new AnonymousClass9(r25);
        UNKNOWN = r26;
        INVISIBLE_FROM_OTHER_MODULES = Collections.unmodifiableSet(SetsKt.setOf(new DescriptorVisibility[]{r10, r12, r16, r20}));
        HashMap r27 = CollectionsKt.newHashMapWithExpectedSize(4);
        r27.put(r12, 0);
        r27.put(r10, 0);
        r27.put(r16, 1);
        r27.put(r14, 1);
        r27.put(r18, 2);
        ORDERED_VISIBILITIES = Collections.unmodifiableMap(r27);
        DEFAULT_VISIBILITY = r18;
        IRRELEVANT_RECEIVER = new AnonymousClass10();
        ALWAYS_SUITABLE_RECEIVER = new AnonymousClass11();
        FALSE_IF_PROTECTED = new AnonymousClass12();
        Iterator r28 = ServiceLoader.load(ModuleVisibilityHelper.class, ModuleVisibilityHelper.class.getClassLoader()).iterator();
        if (r28.hasNext() == false) goto L5;
        ModuleVisibilityHelper r29 = (ModuleVisibilityHelper) r28.next();
    L6:
        MODULE_VISIBILITY_HELPER = r29;
        visibilitiesMapping = new HashMap();
        recordVisibilityMapping(r10);
        recordVisibilityMapping(r12);
        recordVisibilityMapping(r14);
        recordVisibilityMapping(r16);
        recordVisibilityMapping(r18);
        recordVisibilityMapping(r20);
        recordVisibilityMapping(r22);
        recordVisibilityMapping(r24);
        recordVisibilityMapping(r26);
        return;
    L5:
        r29 = ModuleVisibilityHelper.EMPTY.INSTANCE;
        goto L6
    }

    public static /* synthetic */ ReceiverValue access$000() {
        return IRRELEVANT_RECEIVER;
    }

    public static /* synthetic */ ModuleVisibilityHelper access$100() {
        return MODULE_VISIBILITY_HELPER;
    }

    public static Integer compare(DescriptorVisibility r5, DescriptorVisibility r10) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(12);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(13);
    L6:
        Integer r11 = r5.compareTo(r10);
        if (r11 == null) goto L9;
        return r11;
    L9:
        Integer r12 = r10.compareTo(r5);
        if (r12 != null) goto L12;
        return null;
    L12:
        return Integer.valueOf(-r12.intValue());
    }

    public static DeclarationDescriptorWithVisibility findInvisibleMember(ReceiverValue r5, DeclarationDescriptorWithVisibility r10, DeclarationDescriptor r11, boolean r12) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(8);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(9);
    L6:
        DeclarationDescriptorWithVisibility r13 = (DeclarationDescriptorWithVisibility) r10.getOriginal();
    L7:
        if (r13 == null) goto L15;
        if (r13.getVisibility() == LOCAL) goto L15;
        if (r13.getVisibility().isVisible(r5, r13, r11, r12) == false) goto L12;
        r13 = (DeclarationDescriptorWithVisibility) DescriptorUtils.getParentOfType(r13, DeclarationDescriptorWithVisibility.class);
        goto L7
    L12:
        return r13;
    L15:
        if ((r10 instanceof TypeAliasConstructorDescriptor) == false) goto L19;
        DeclarationDescriptorWithVisibility r14 = findInvisibleMember(r5, ((TypeAliasConstructorDescriptor) r10).getUnderlyingConstructorDescriptor(), r11, r12);
        if (r14 == null) goto L24;
        return r14;
    L24:
        return null;
    L19:
        return null;
    }

    public static boolean inSameFile(DeclarationDescriptor r5, DeclarationDescriptor r10) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(6);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(7);
    L6:
        SourceFile r11 = DescriptorUtils.getContainingSourceFile(r10);
        if (r11 != SourceFile.NO_SOURCE_FILE) goto L9;
        return false;
    L9:
        return r11.equals(DescriptorUtils.getContainingSourceFile(r5));
    }

    public static boolean isPrivate(DescriptorVisibility r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(14);
    L5:
        if (r5 != PRIVATE) goto L7;
    L10:
        return true;
    L7:
        if (r5 == PRIVATE_TO_THIS) goto L10;
        return false;
    }

    public static boolean isVisibleIgnoringReceiver(DeclarationDescriptorWithVisibility r5, DeclarationDescriptor r10, boolean r11) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(2);
    L4:
        if (r10 != null) goto L7;
        $$$reportNull$$$0(3);
    L7:
        if (findInvisibleMember(ALWAYS_SUITABLE_RECEIVER, r5, r10, r11) != null) goto L9;
        return true;
    L9:
        return false;
    }

    private static void recordVisibilityMapping(DescriptorVisibility r5) {
        visibilitiesMapping.put(r5.getDelegate(), r5);
    }

    public static DescriptorVisibility toDescriptorVisibility(Visibility r5) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(15);
    L4:
        DescriptorVisibility r10 = visibilitiesMapping.get(r5);
        if (r10 == null) goto L8;
        return r10;
    L8:
        throw new IllegalArgumentException("Inapplicable visibility: " + r5);
    }
}
