package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Comparator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
public class MemberComparator implements Comparator<DeclarationDescriptor> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final MemberComparator INSTANCE = null;
    private static final DescriptorRenderer RENDERER = null;

    public static class NameAndTypeMemberComparator implements Comparator<DeclarationDescriptor> {
        public static final NameAndTypeMemberComparator INSTANCE = null;

        static {
            INSTANCE = new NameAndTypeMemberComparator();
        }

        private NameAndTypeMemberComparator() {
        }

        static /* synthetic */ Integer access$000(DeclarationDescriptor r10, DeclarationDescriptor r11) {
            return compareInternal(r10, r11);
        }

        private static Integer compareInternal(DeclarationDescriptor r10, DeclarationDescriptor r11) {
            int r12 = getDeclarationPriority(r11) - getDeclarationPriority(r10);
            if (r12 == 0) goto L7;
            return Integer.valueOf(r12);
        L7:
            if (DescriptorUtils.isEnumEntry(r10) == true) goto L9;
        L12:
            int r13 = r10.getName().compareTo2(r11.getName());
            if (r13 != 0) goto L15;
            return null;
        L15:
            return Integer.valueOf(r13);
        L9:
            if (DescriptorUtils.isEnumEntry(r11) == false) goto L12;
            return 0;
        }

        private static int getDeclarationPriority(DeclarationDescriptor r10) {
            if (DescriptorUtils.isEnumEntry(r10) == false) goto L7;
            return 8;
        L7:
            if ((r10 instanceof ConstructorDescriptor) == false) goto L11;
            return 7;
        L11:
            if ((r10 instanceof PropertyDescriptor) == false) goto L19;
            if (((PropertyDescriptor) r10).getExtensionReceiverParameter() != null) goto L16;
            return 6;
        L16:
            return 5;
        L19:
            if ((r10 instanceof FunctionDescriptor) == false) goto L27;
            if (((FunctionDescriptor) r10).getExtensionReceiverParameter() != null) goto L24;
            return 4;
        L24:
            return 3;
        L27:
            if ((r10 instanceof ClassDescriptor) == false) goto L31;
            return 2;
        L31:
            if ((r10 instanceof TypeAliasDescriptor) == false) goto L34;
            return 1;
        L34:
            return 0;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(DeclarationDescriptor r10, DeclarationDescriptor r11) {
            return compare2(r10, r11);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(DeclarationDescriptor r10, DeclarationDescriptor r11) {
            Integer r12 = compareInternal(r10, r11);
            if (r12 != null) goto L7;
            return 0;
        L7:
            return r12.intValue();
        }
    }

    static {
        INSTANCE = new MemberComparator();
        RENDERER = DescriptorRenderer.Companion.withOptions(new AnonymousClass1());
    }

    private MemberComparator() {
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(DeclarationDescriptor r10, DeclarationDescriptor r11) {
        return compare2(r10, r11);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(DeclarationDescriptor r12, DeclarationDescriptor r13) {
        Integer r11 = NameAndTypeMemberComparator.access$000(r12, r13);
        if (r11 == null) goto L7;
        return r11.intValue();
    L7:
        if ((r12 instanceof TypeAliasDescriptor) == false) goto L14;
        if ((r13 instanceof TypeAliasDescriptor) == false) goto L14;
        DescriptorRenderer r10 = RENDERER;
        int r14 = r10.renderType(((TypeAliasDescriptor) r12).getUnderlyingType()).compareTo(r10.renderType(((TypeAliasDescriptor) r13).getUnderlyingType()));
        if (r14 == 0) goto L71;
        return r14;
    L71:
        DescriptorRenderer r15 = RENDERER;
        int r16 = r15.render(r12).compareTo(r15.render(r13));
        if (r16 == 0) goto L75;
        return r16;
    L75:
        return DescriptorUtils.getContainingModule(r12).getName().compareTo2(DescriptorUtils.getContainingModule(r13).getName());
    L14:
        if ((r12 instanceof CallableDescriptor) == false) goto L57;
        if ((r13 instanceof CallableDescriptor) == false) goto L57;
        CallableDescriptor r17 = (CallableDescriptor) r12;
        CallableDescriptor r18 = (CallableDescriptor) r13;
        ReceiverParameterDescriptor r19 = r17.getExtensionReceiverParameter();
        ReceiverParameterDescriptor r20 = r18.getExtensionReceiverParameter();
        if (r19 == null) goto L22;
        DescriptorRenderer r21 = RENDERER;
        int r22 = r21.renderType(r19.getType()).compareTo(r21.renderType(r20.getType()));
        if (r22 == 0) goto L22;
        return r22;
    L22:
        List<ValueParameterDescriptor> r23 = r17.getValueParameters();
        List<ValueParameterDescriptor> r24 = r18.getValueParameters();
        int r25 = 0;
    L24:
        if (r25 >= Math.min(r23.size(), r24.size())) goto L29;
        DescriptorRenderer r26 = RENDERER;
        int r27 = r26.renderType(r23.get(r25).getType()).compareTo(r26.renderType(r24.get(r25).getType()));
        if (r27 != 0) goto L27;
        r25 = r25 + 1;
        goto L24
    L27:
        return r27;
    L29:
        int r28 = r23.size() - r24.size();
        if (r28 == 0) goto L32;
        return r28;
    L32:
        List<TypeParameterDescriptor> r29 = r17.getTypeParameters();
        List<TypeParameterDescriptor> r30 = r18.getTypeParameters();
        int r31 = 0;
    L34:
        if (r31 >= Math.min(r29.size(), r30.size())) goto L46;
        List<KotlinType> r32 = r29.get(r31).getUpperBounds();
        List<KotlinType> r33 = r30.get(r31).getUpperBounds();
        int r34 = r32.size() - r33.size();
        if (r34 != 0) goto L37;
        int r35 = 0;
    L40:
        if (r35 >= r32.size()) goto L45;
        DescriptorRenderer r36 = RENDERER;
        int r37 = r36.renderType(r32.get(r35)).compareTo(r36.renderType(r33.get(r35)));
        if (r37 != 0) goto L43;
        r35 = r35 + 1;
        goto L40
    L43:
        return r37;
    L45:
        r31 = r31 + 1;
        goto L34
    L37:
        return r34;
    L46:
        int r38 = r29.size() - r30.size();
        if (r38 == 0) goto L50;
        return r38;
    L50:
        if ((r17 instanceof CallableMemberDescriptor) == false) goto L71;
        if ((r18 instanceof CallableMemberDescriptor) == false) goto L71;
        int r110 = ((CallableMemberDescriptor) r17).getKind().ordinal() - ((CallableMemberDescriptor) r18).getKind().ordinal();
        if (r110 == 0) goto L71;
        return r110;
    L57:
        if ((r12 instanceof ClassDescriptor) == false) goto L77;
        if ((r13 instanceof ClassDescriptor) == false) goto L77;
        ClassDescriptor r111 = (ClassDescriptor) r12;
        ClassDescriptor r39 = (ClassDescriptor) r13;
        if (r111.getKind().ordinal() == r39.getKind().ordinal()) goto L65;
        return r111.getKind().ordinal() - r39.getKind().ordinal();
    L65:
        if (r111.isCompanionObject() == r39.isCompanionObject()) goto L71;
        if (r111.isCompanionObject() == true) goto L84;
        return -1;
    L84:
        return 1;
    L77:
        throw new AssertionError(String.format("Unsupported pair of descriptors:\n'%s' Class: %s\n%s' Class: %s", new Object[]{r12, r12.getClass(), r13, r13.getClass()}));
    }
}
