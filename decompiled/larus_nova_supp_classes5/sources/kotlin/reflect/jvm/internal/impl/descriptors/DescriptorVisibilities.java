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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class DescriptorVisibilities {
    public static final ReceiverValue ALWAYS_SUITABLE_RECEIVER = null;
    public static final DescriptorVisibility DEFAULT_VISIBILITY = null;
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

    private static /* synthetic */ void $$$reportNull$$$0(int r8) {
        if (r8 == 16) goto L5;
        String r1 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L7:
        if (r8 == 16) goto L9;
        int r4 = 3;
    L10:
        Object[] r5 = new Object[r4];
        if (r8 == 1) goto L23;
        if (r8 == 3) goto L23;
        if (r8 == 5) goto L23;
        if (r8 == 7) goto L23;
        switch(r8) {
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
        r5[0] = "what";
    L25:
        if (r8 == 16) goto L27;
        r5[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities";
    L28:
        switch(r8) {
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
        r5[2] = "isVisible";
        goto L38
    L30:
        r5[2] = "toDescriptorVisibility";
        goto L38
    L31:
        r5[2] = "isPrivate";
        goto L38
    L32:
        r5[2] = "compare";
        goto L38
    L33:
        r5[2] = "compareLocal";
        goto L38
    L34:
        r5[2] = "findInvisibleMember";
        goto L38
    L35:
        r5[2] = "inSameFile";
        goto L38
    L36:
        r5[2] = "isVisibleWithAnyReceiver";
        goto L38
    L37:
        r5[2] = "isVisibleIgnoringReceiver";
    L38:
        String r2 = String.format(r1, r5);
        if (r8 == 16) goto L42;
        throw new IllegalArgumentException(r2);
    L42:
        throw new IllegalStateException(r2);
    L27:
        r5[1] = "toDescriptorVisibility";
        goto L28
    L19:
        r5[0] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities";
        goto L25
    L20:
        r5[0] = "visibility";
        goto L25
    L21:
        r5[0] = "second";
        goto L25
    L22:
        r5[0] = "first";
    L23:
        r5[0] = "from";
        goto L25
    L9:
        r4 = 2;
        goto L10
    L5:
        r1 = "@NotNull method %s.%s must not return null";
        goto L7
    }

    static {
        final Visibilities.Private r1 = Visibilities.Private.INSTANCE;
        DelegatedDescriptorVisibility r0 = new AnonymousClass1(r1);
        PRIVATE = r0;
        final Visibilities.PrivateToThis r2 = Visibilities.PrivateToThis.INSTANCE;
        DelegatedDescriptorVisibility r3 = new AnonymousClass2(r2);
        PRIVATE_TO_THIS = r3;
        final Visibilities.Protected r4 = Visibilities.Protected.INSTANCE;
        DelegatedDescriptorVisibility r5 = new AnonymousClass3(r4);
        PROTECTED = r5;
        final Visibilities.Internal r6 = Visibilities.Internal.INSTANCE;
        DelegatedDescriptorVisibility r7 = new AnonymousClass4(r6);
        INTERNAL = r7;
        final Visibilities.Public r8 = Visibilities.Public.INSTANCE;
        DelegatedDescriptorVisibility r9 = new AnonymousClass5(r8);
        PUBLIC = r9;
        final Visibilities.Local r10 = Visibilities.Local.INSTANCE;
        DelegatedDescriptorVisibility r11 = new AnonymousClass6(r10);
        LOCAL = r11;
        final Visibilities.Inherited r12 = Visibilities.Inherited.INSTANCE;
        DelegatedDescriptorVisibility r13 = new AnonymousClass7(r12);
        INHERITED = r13;
        final Visibilities.InvisibleFake r14 = Visibilities.InvisibleFake.INSTANCE;
        DelegatedDescriptorVisibility r15 = new AnonymousClass8(r14);
        INVISIBLE_FAKE = r15;
        final Visibilities.Unknown r16 = Visibilities.Unknown.INSTANCE;
        DelegatedDescriptorVisibility r17 = new AnonymousClass9(r16);
        UNKNOWN = r17;
        INVISIBLE_FROM_OTHER_MODULES = Collections.unmodifiableSet(SetsKt.setOf(new DescriptorVisibility[]{r0, r3, r7, r11}));
        HashMap r18 = CollectionsKt.newHashMapWithExpectedSize(4);
        r18.put(r3, 0);
        r18.put(r0, 0);
        r18.put(r7, 1);
        r18.put(r5, 1);
        r18.put(r9, 2);
        ORDERED_VISIBILITIES = Collections.unmodifiableMap(r18);
        DEFAULT_VISIBILITY = r9;
        IRRELEVANT_RECEIVER = new AnonymousClass10();
        ALWAYS_SUITABLE_RECEIVER = new AnonymousClass11();
        FALSE_IF_PROTECTED = new AnonymousClass12();
        Iterator r19 = ServiceLoader.load(ModuleVisibilityHelper.class, ModuleVisibilityHelper.class.getClassLoader()).iterator();
        if (r19.hasNext() == false) goto L5;
        ModuleVisibilityHelper r20 = (ModuleVisibilityHelper) r19.next();
    L6:
        MODULE_VISIBILITY_HELPER = r20;
        visibilitiesMapping = new HashMap();
        recordVisibilityMapping(r0);
        recordVisibilityMapping(r3);
        recordVisibilityMapping(r5);
        recordVisibilityMapping(r7);
        recordVisibilityMapping(r9);
        recordVisibilityMapping(r11);
        recordVisibilityMapping(r13);
        recordVisibilityMapping(r15);
        recordVisibilityMapping(r17);
        return;
    L5:
        r20 = ModuleVisibilityHelper.EMPTY.INSTANCE;
        goto L6
    }

    public static /* synthetic */ ReceiverValue access$000() {
        return IRRELEVANT_RECEIVER;
    }

    public static /* synthetic */ ModuleVisibilityHelper access$100() {
        return MODULE_VISIBILITY_HELPER;
    }

    public static boolean isPrivate(DescriptorVisibility r1) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(14);
    L5:
        if (r1 != PRIVATE) goto L7;
    L10:
        return true;
    L7:
        if (r1 == PRIVATE_TO_THIS) goto L10;
        return false;
    }

    private static void recordVisibilityMapping(DescriptorVisibility r2) {
        visibilitiesMapping.put(r2.getDelegate(), r2);
    }

    public static DescriptorVisibility toDescriptorVisibility(Visibility r3) {
        if (r3 != null) goto L4;
        $$$reportNull$$$0(15);
    L4:
        DescriptorVisibility r0 = visibilitiesMapping.get(r3);
        if (r0 == null) goto L8;
        return r0;
    L8:
        throw new IllegalArgumentException("Inapplicable visibility: " + r3);
    }

    public static Integer compare(DescriptorVisibility r1, DescriptorVisibility r2) {
        if (r1 != null) goto L4;
        $$$reportNull$$$0(12);
    L4:
        if (r2 != null) goto L6;
        $$$reportNull$$$0(13);
    L6:
        Integer r0 = r1.compareTo(r2);
        if (r0 == null) goto L9;
        return r0;
    L9:
        Integer r3 = r2.compareTo(r1);
        if (r3 != null) goto L12;
        return null;
    L12:
        return Integer.valueOf(-r3.intValue());
    }

    public static boolean inSameFile(DeclarationDescriptor r1, DeclarationDescriptor r2) {
        if (r1 != null) goto L4;
        $$$reportNull$$$0(6);
    L4:
        if (r2 != null) goto L6;
        $$$reportNull$$$0(7);
    L6:
        SourceFile r3 = DescriptorUtils.getContainingSourceFile(r2);
        if (r3 != SourceFile.NO_SOURCE_FILE) goto L9;
        return false;
    L9:
        return r3.equals(DescriptorUtils.getContainingSourceFile(r1));
    }

    public static boolean isVisibleIgnoringReceiver(DeclarationDescriptorWithVisibility r1, DeclarationDescriptor r2, boolean r3) {
        if (r1 != null) goto L4;
        $$$reportNull$$$0(2);
    L4:
        if (r2 != null) goto L7;
        $$$reportNull$$$0(3);
    L7:
        if (findInvisibleMember(ALWAYS_SUITABLE_RECEIVER, r1, r2, r3) != null) goto L9;
        return true;
    L9:
        return false;
    }

    public static DeclarationDescriptorWithVisibility findInvisibleMember(ReceiverValue r3, DeclarationDescriptorWithVisibility r4, DeclarationDescriptor r5, boolean r6) {
        if (r4 != null) goto L4;
        $$$reportNull$$$0(8);
    L4:
        if (r5 != null) goto L6;
        $$$reportNull$$$0(9);
    L6:
        DeclarationDescriptorWithVisibility r0 = (DeclarationDescriptorWithVisibility) r4.getOriginal();
    L7:
        if (r0 == null) goto L15;
        if (r0.getVisibility() == LOCAL) goto L15;
        if (r0.getVisibility().isVisible(r3, r0, r5, r6) == false) goto L12;
        r0 = (DeclarationDescriptorWithVisibility) DescriptorUtils.getParentOfType(r0, DeclarationDescriptorWithVisibility.class);
        goto L7
    L12:
        return r0;
    L15:
        if ((r4 instanceof TypeAliasConstructorDescriptor) == false) goto L19;
        DeclarationDescriptorWithVisibility r7 = findInvisibleMember(r3, ((TypeAliasConstructorDescriptor) r4).getUnderlyingConstructorDescriptor(), r5, r6);
        if (r7 == null) goto L24;
        return r7;
    L24:
        return null;
    L19:
        return null;
    }
}
