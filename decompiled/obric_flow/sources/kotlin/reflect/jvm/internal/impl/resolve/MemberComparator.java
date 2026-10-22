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

        public static /* synthetic */ Integer access$000(DeclarationDescriptor r5, DeclarationDescriptor r10) {
            return compareInternal(r5, r10);
        }

        private static Integer compareInternal(DeclarationDescriptor r5, DeclarationDescriptor r10) {
            int r11 = getDeclarationPriority(r10) - getDeclarationPriority(r5);
            if (r11 == 0) goto L7;
            return Integer.valueOf(r11);
        L7:
            if (DescriptorUtils.isEnumEntry(r5) == true) goto L9;
        L12:
            int r12 = r5.getName().compareTo2(r10.getName());
            if (r12 != 0) goto L15;
            return null;
        L15:
            return Integer.valueOf(r12);
        L9:
            if (DescriptorUtils.isEnumEntry(r10) == false) goto L12;
            return 0;
        }

        private static int getDeclarationPriority(DeclarationDescriptor r5) {
            if (DescriptorUtils.isEnumEntry(r5) == false) goto L7;
            return 8;
        L7:
            if ((r5 instanceof ConstructorDescriptor) == false) goto L11;
            return 7;
        L11:
            if ((r5 instanceof PropertyDescriptor) == false) goto L19;
            if (((PropertyDescriptor) r5).getExtensionReceiverParameter() != null) goto L16;
            return 6;
        L16:
            return 5;
        L19:
            if ((r5 instanceof FunctionDescriptor) == false) goto L27;
            if (((FunctionDescriptor) r5).getExtensionReceiverParameter() != null) goto L24;
            return 4;
        L24:
            return 3;
        L27:
            if ((r5 instanceof ClassDescriptor) == false) goto L31;
            return 2;
        L31:
            if ((r5 instanceof TypeAliasDescriptor) == false) goto L34;
            return 1;
        L34:
            return 0;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(DeclarationDescriptor r5, DeclarationDescriptor r10) {
            return compare2(r5, r10);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(DeclarationDescriptor r5, DeclarationDescriptor r10) {
            Integer r11 = compareInternal(r5, r10);
            if (r11 != null) goto L7;
            return 0;
        L7:
            return r11.intValue();
        }
    }

    static {
        INSTANCE = new MemberComparator();
        RENDERER = DescriptorRenderer.Companion.withOptions(new AnonymousClass1());
    }

    private MemberComparator() {
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(DeclarationDescriptor r5, DeclarationDescriptor r10) {
        return compare2(r5, r10);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(DeclarationDescriptor r12, DeclarationDescriptor r13) {
        Integer r11 = NameAndTypeMemberComparator.access$000(r12, r13);
        if (r11 == null) goto L7;
        return r11.intValue();
    L7:
        if ((r12 instanceof TypeAliasDescriptor) == false) goto L14;
        if ((r13 instanceof TypeAliasDescriptor) == false) goto L14;
        DescriptorRenderer r5 = RENDERER;
        int r14 = r5.renderType(((TypeAliasDescriptor) r12).getUnderlyingType()).compareTo(r5.renderType(((TypeAliasDescriptor) r13).getUnderlyingType()));
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
        CallableDescriptor r10 = (CallableDescriptor) r13;
        ReceiverParameterDescriptor r18 = r17.getExtensionReceiverParameter();
        ReceiverParameterDescriptor r19 = r10.getExtensionReceiverParameter();
        if (r18 == null) goto L22;
        DescriptorRenderer r20 = RENDERER;
        int r21 = r20.renderType(r18.getType()).compareTo(r20.renderType(r19.getType()));
        if (r21 == 0) goto L22;
        return r21;
    L22:
        List<ValueParameterDescriptor> r22 = r17.getValueParameters();
        List<ValueParameterDescriptor> r23 = r10.getValueParameters();
        int r24 = 0;
    L24:
        if (r24 >= Math.min(r22.size(), r23.size())) goto L29;
        DescriptorRenderer r25 = RENDERER;
        int r26 = r25.renderType(r22.get(r24).getType()).compareTo(r25.renderType(r23.get(r24).getType()));
        if (r26 != 0) goto L27;
        r24 = r24 + 1;
        goto L24
    L27:
        return r26;
    L29:
        int r27 = r22.size() - r23.size();
        if (r27 == 0) goto L32;
        return r27;
    L32:
        List<TypeParameterDescriptor> r28 = r17.getTypeParameters();
        List<TypeParameterDescriptor> r29 = r10.getTypeParameters();
        int r30 = 0;
    L34:
        if (r30 >= Math.min(r28.size(), r29.size())) goto L46;
        List<KotlinType> r31 = r28.get(r30).getUpperBounds();
        List<KotlinType> r32 = r29.get(r30).getUpperBounds();
        int r33 = r31.size() - r32.size();
        if (r33 != 0) goto L37;
        int r34 = 0;
    L40:
        if (r34 >= r31.size()) goto L45;
        DescriptorRenderer r35 = RENDERER;
        int r36 = r35.renderType(r31.get(r34)).compareTo(r35.renderType(r32.get(r34)));
        if (r36 != 0) goto L43;
        r34 = r34 + 1;
        goto L40
    L43:
        return r36;
    L45:
        r30 = r30 + 1;
        goto L34
    L37:
        return r33;
    L46:
        int r37 = r28.size() - r29.size();
        if (r37 == 0) goto L50;
        return r37;
    L50:
        if ((r17 instanceof CallableMemberDescriptor) == false) goto L71;
        if ((r10 instanceof CallableMemberDescriptor) == false) goto L71;
        int r110 = ((CallableMemberDescriptor) r17).getKind().ordinal() - ((CallableMemberDescriptor) r10).getKind().ordinal();
        if (r110 == 0) goto L71;
        return r110;
    L57:
        if ((r12 instanceof ClassDescriptor) == false) goto L77;
        if ((r13 instanceof ClassDescriptor) == false) goto L77;
        ClassDescriptor r111 = (ClassDescriptor) r12;
        ClassDescriptor r38 = (ClassDescriptor) r13;
        if (r111.getKind().ordinal() == r38.getKind().ordinal()) goto L65;
        return r111.getKind().ordinal() - r38.getKind().ordinal();
    L65:
        if (r111.isCompanionObject() == r38.isCompanionObject()) goto L71;
        if (r111.isCompanionObject() == false) goto L69;
        return 1;
    L69:
        return -1;
    L77:
        throw new AssertionError(String.format("Unsupported pair of descriptors:\n'%s' Class: %s\n%s' Class: %s", new Object[]{r12, r12.getClass(), r13, r13.getClass()}));
    }
}
