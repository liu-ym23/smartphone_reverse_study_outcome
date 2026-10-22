package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: loaded from: classes3.dex */
public final class DescriptorEquivalenceForOverrides {
    public static final DescriptorEquivalenceForOverrides INSTANCE = null;

    static {
        INSTANCE = new DescriptorEquivalenceForOverrides();
    }

    private DescriptorEquivalenceForOverrides() {
    }

    public static /* synthetic */ boolean accessor$DescriptorEquivalenceForOverrides$lambda0(boolean r5, CallableDescriptor r10, CallableDescriptor r11, TypeConstructor r12, TypeConstructor r13) {
        return areCallableDescriptorsEquivalent$lambda$0(r5, r10, r11, r12, r13);
    }

    public static /* synthetic */ boolean areCallableDescriptorsEquivalent$default(DescriptorEquivalenceForOverrides r10, CallableDescriptor r11, CallableDescriptor r12, boolean r13, boolean r14, boolean r15, KotlinTypeRefiner r16, int r17, Object r18) {
        if ((r17 & 8) == 0) goto L5;
        r14 = true;
    L5:
        boolean r5 = r14;
        if ((r17 & 16) == 0) goto L9;
        r15 = false;
    L9:
        return r10.areCallableDescriptorsEquivalent(r11, r12, r13, r5, r15, r16);
    }

    private static final boolean areCallableDescriptorsEquivalent$lambda$0(boolean r5, final CallableDescriptor r10, final CallableDescriptor r11, TypeConstructor r12, TypeConstructor r13) {
        Intrinsics.checkNotNullParameter(r10, "$a");
        Intrinsics.checkNotNullParameter(r11, "$b");
        Intrinsics.checkNotNullParameter(r12, "c1");
        Intrinsics.checkNotNullParameter(r13, "c2");
        if (Intrinsics.areEqual(r12, r13) == false) goto L6;
        return true;
    L6:
        ClassifierDescriptor r14 = r12.mo1402getDeclarationDescriptor();
        ClassifierDescriptor r15 = r13.mo1402getDeclarationDescriptor();
        if ((r14 instanceof TypeParameterDescriptor) == true) goto L9;
        return false;
    L9:
        if ((r15 instanceof TypeParameterDescriptor) == true) goto L12;
        return false;
    L12:
        return INSTANCE.areTypeParametersEquivalent((TypeParameterDescriptor) r14, (TypeParameterDescriptor) r15, r5, new DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$overridingUtil$1$1(r10, r11));
    }

    private final boolean areClassesEquivalent(ClassDescriptor r5, ClassDescriptor r10) {
        return Intrinsics.areEqual(r5.getTypeConstructor(), r10.getTypeConstructor());
    }

    public static /* synthetic */ boolean areEquivalent$default(DescriptorEquivalenceForOverrides r5, DeclarationDescriptor r10, DeclarationDescriptor r11, boolean r12, boolean r13, int r14, Object r15) {
        if ((r14 & 8) == 0) goto L6;
        r13 = true;
    L6:
        return r5.areEquivalent(r10, r11, r12, r13);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean areTypeParametersEquivalent$default(DescriptorEquivalenceForOverrides r5, TypeParameterDescriptor r10, TypeParameterDescriptor r11, boolean r12, Function2 r13, int r14, Object r15) {
        if ((r14 & 8) == 0) goto L6;
        r13 = C02351.INSTANCE;
    L6:
        return r5.areTypeParametersEquivalent(r10, r11, r12, r13);
    }

    private final boolean ownersEquivalent(DeclarationDescriptor r10, DeclarationDescriptor r11, Function2<? super DeclarationDescriptor, ? super DeclarationDescriptor, Boolean> r12, boolean r13) {
        DeclarationDescriptor r5 = r10.getContainingDeclaration();
        DeclarationDescriptor r14 = r11.getContainingDeclaration();
        if ((r5 instanceof CallableMemberDescriptor) == true) goto L9;
        if ((r14 instanceof CallableMemberDescriptor) == true) goto L9;
        return areEquivalent$default(this, r5, r14, r13, false, 8, null);
    L9:
        return r12.mo2invoke(r5, r14).booleanValue();
    }

    private final SourceElement singleSource(CallableDescriptor r5) {
    L3:
        if ((r5 instanceof CallableMemberDescriptor) == false) goto L13;
        CallableMemberDescriptor r10 = (CallableMemberDescriptor) r5;
        if (r10.getKind() != CallableMemberDescriptor.Kind.FAKE_OVERRIDE) goto L13;
        r5 = (CallableMemberDescriptor) CollectionsKt.singleOrNull(r10.getOverriddenDescriptors());
        if (r5 != null) goto L3;
        return null;
    L13:
        return r5.getSource();
    }

    public final boolean areCallableDescriptorsEquivalent(final CallableDescriptor r5, final CallableDescriptor r10, final boolean r11, boolean r12, boolean r13, KotlinTypeRefiner r14) {
        Intrinsics.checkNotNullParameter(r5, "a");
        Intrinsics.checkNotNullParameter(r10, "b");
        Intrinsics.checkNotNullParameter(r14, "kotlinTypeRefiner");
        if (Intrinsics.areEqual(r5, r10) == false) goto L6;
        return true;
    L6:
        if (Intrinsics.areEqual(r5.getName(), r10.getName()) == true) goto L8;
        return false;
    L8:
        if (r12 == false) goto L17;
        if ((r5 instanceof MemberDescriptor) == false) goto L17;
        if ((r10 instanceof MemberDescriptor) == false) goto L17;
        if (((MemberDescriptor) r5).isExpect() == ((MemberDescriptor) r10).isExpect()) goto L17;
        return false;
    L17:
        if (Intrinsics.areEqual(r5.getContainingDeclaration(), r10.getContainingDeclaration()) == false) goto L24;
        if (r11 == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(singleSource(r5), singleSource(r10)) == true) goto L24;
        return false;
    L24:
        if (DescriptorUtils.isLocal(r5) == false) goto L26;
    L38:
        return false;
    L26:
        if (DescriptorUtils.isLocal(r10) == true) goto L38;
        if (ownersEquivalent(r5, r10, AnonymousClass1.INSTANCE, r11) == true) goto L31;
        return false;
    L31:
        OverridingUtil r15 = OverridingUtil.create(r14, new DescriptorEquivalenceForOverrides$$Lambda$0(r11, r5, r10));
        OverridingUtil.OverrideCompatibilityInfo.Result r16 = r15.isOverridableBy(r5, r10, null, !r13).getResult();
        OverridingUtil.OverrideCompatibilityInfo.Result r17 = OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE;
        if (r16 != r17) goto L37;
        if (r15.isOverridableBy(r10, r5, null, !r13).getResult() != r17) goto L37;
        return true;
    L37:
        return false;
    }

    public final boolean areEquivalent(DeclarationDescriptor r11, DeclarationDescriptor r12, boolean r13, boolean r14) {
        if ((r11 instanceof ClassDescriptor) == false) goto L8;
        if ((r12 instanceof ClassDescriptor) == false) goto L8;
        return areClassesEquivalent((ClassDescriptor) r11, (ClassDescriptor) r12);
    L8:
        if ((r11 instanceof TypeParameterDescriptor) == false) goto L13;
        if ((r12 instanceof TypeParameterDescriptor) == false) goto L13;
        return areTypeParametersEquivalent$default(this, (TypeParameterDescriptor) r11, (TypeParameterDescriptor) r12, r13, null, 8, null);
    L13:
        if ((r11 instanceof CallableDescriptor) == false) goto L18;
        if ((r12 instanceof CallableDescriptor) == false) goto L18;
        return areCallableDescriptorsEquivalent$default(this, (CallableDescriptor) r11, (CallableDescriptor) r12, r13, r14, false, KotlinTypeRefiner.Default.INSTANCE, 16, null);
    L18:
        if ((r11 instanceof PackageFragmentDescriptor) == false) goto L23;
        if ((r12 instanceof PackageFragmentDescriptor) == false) goto L23;
        return Intrinsics.areEqual(((PackageFragmentDescriptor) r11).getFqName(), ((PackageFragmentDescriptor) r12).getFqName());
    L23:
        return Intrinsics.areEqual(r11, r12);
    }

    @JvmOverloads
    public final boolean areTypeParametersEquivalent(TypeParameterDescriptor r10, TypeParameterDescriptor r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "a");
        Intrinsics.checkNotNullParameter(r11, "b");
        return areTypeParametersEquivalent$default(this, r10, r11, r12, null, 8, null);
    }

    @JvmOverloads
    public final boolean areTypeParametersEquivalent(TypeParameterDescriptor r5, TypeParameterDescriptor r10, boolean r11, Function2<? super DeclarationDescriptor, ? super DeclarationDescriptor, Boolean> r12) {
        Intrinsics.checkNotNullParameter(r5, "a");
        Intrinsics.checkNotNullParameter(r10, "b");
        Intrinsics.checkNotNullParameter(r12, "equivalentCallables");
        if (Intrinsics.areEqual(r5, r10) == false) goto L6;
        return true;
    L6:
        if (Intrinsics.areEqual(r5.getContainingDeclaration(), r10.getContainingDeclaration()) == false) goto L9;
        return false;
    L9:
        if (ownersEquivalent(r5, r10, r12, r11) == true) goto L12;
        return false;
    L12:
        if (r5.getIndex() != r10.getIndex()) goto L15;
        return true;
    L15:
        return false;
    }
}
