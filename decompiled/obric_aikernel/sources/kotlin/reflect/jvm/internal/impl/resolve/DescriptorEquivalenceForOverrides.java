package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: loaded from: classes3.dex */
public final class DescriptorEquivalenceForOverrides {
    public static final DescriptorEquivalenceForOverrides INSTANCE = null;

    static {
        INSTANCE = new DescriptorEquivalenceForOverrides();
    }

    private DescriptorEquivalenceForOverrides() {
    }

    public static /* synthetic */ boolean areCallableDescriptorsEquivalent$default(DescriptorEquivalenceForOverrides r10, CallableDescriptor r11, CallableDescriptor r12, boolean r13, boolean r14, boolean r15, KotlinTypeRefiner r16, int r17, Object r18) {
        if ((r17 & 8) == 0) goto L5;
        r14 = true;
    L5:
        boolean r19 = r14;
        if ((r17 & 16) == 0) goto L9;
        r15 = false;
    L9:
        return r10.areCallableDescriptorsEquivalent(r11, r12, r13, r19, r15, r16);
    }

    private final boolean areClassesEquivalent(ClassDescriptor r10, ClassDescriptor r11) {
        return Intrinsics.areEqual(r10.getTypeConstructor(), r11.getTypeConstructor());
    }

    public static /* synthetic */ boolean areEquivalent$default(DescriptorEquivalenceForOverrides r10, DeclarationDescriptor r11, DeclarationDescriptor r12, boolean r13, boolean r14, int r15, Object r16) {
        if ((r15 & 8) == 0) goto L6;
        r14 = true;
    L6:
        return r10.areEquivalent(r11, r12, r13, r14);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean areTypeParametersEquivalent$default(DescriptorEquivalenceForOverrides r10, TypeParameterDescriptor r11, TypeParameterDescriptor r12, boolean r13, Function2 r14, int r15, Object r16) {
        if ((r15 & 8) == 0) goto L6;
        r14 = C04251.INSTANCE;
    L6:
        return r10.areTypeParametersEquivalent(r11, r12, r13, r14);
    }

    private final boolean ownersEquivalent(DeclarationDescriptor r10, DeclarationDescriptor r11, Function2<? super DeclarationDescriptor, ? super DeclarationDescriptor, Boolean> r12, boolean r13) {
        DeclarationDescriptor r14 = r10.getContainingDeclaration();
        DeclarationDescriptor r15 = r11.getContainingDeclaration();
        if ((r14 instanceof CallableMemberDescriptor) == true) goto L9;
        if ((r15 instanceof CallableMemberDescriptor) == true) goto L9;
        return areEquivalent$default(this, r14, r15, r13, false, 8, null);
    L9:
        return r12.invoke(r14, r15).booleanValue();
    }

    private final SourceElement singleSource(CallableDescriptor r10) {
    L3:
        if ((r10 instanceof CallableMemberDescriptor) == false) goto L13;
        CallableMemberDescriptor r11 = (CallableMemberDescriptor) r10;
        if (r11.getKind() != CallableMemberDescriptor.Kind.FAKE_OVERRIDE) goto L13;
        Collection<? extends CallableMemberDescriptor> r12 = r11.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(r12, "overriddenDescriptors");
        r10 = (CallableMemberDescriptor) CollectionsKt.singleOrNull(r12);
        if (r10 != null) goto L3;
        return null;
    L13:
        return r10.getSource();
    }

    public final boolean areCallableDescriptorsEquivalent(final CallableDescriptor r10, final CallableDescriptor r11, final boolean r12, boolean r13, boolean r14, KotlinTypeRefiner r15) {
        Intrinsics.checkNotNullParameter(r10, "a");
        Intrinsics.checkNotNullParameter(r11, "b");
        Intrinsics.checkNotNullParameter(r15, "kotlinTypeRefiner");
        if (Intrinsics.areEqual(r10, r11) == false) goto L6;
        return true;
    L6:
        if (Intrinsics.areEqual(r10.getName(), r11.getName()) == true) goto L8;
        return false;
    L8:
        if (r13 == false) goto L17;
        if ((r10 instanceof MemberDescriptor) == false) goto L17;
        if ((r11 instanceof MemberDescriptor) == false) goto L17;
        if (((MemberDescriptor) r10).isExpect() == ((MemberDescriptor) r11).isExpect()) goto L17;
        return false;
    L17:
        if (Intrinsics.areEqual(r10.getContainingDeclaration(), r11.getContainingDeclaration()) == false) goto L24;
        if (r12 == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(singleSource(r10), singleSource(r11)) == true) goto L24;
        return false;
    L24:
        if (DescriptorUtils.isLocal(r10) == false) goto L26;
    L38:
        return false;
    L26:
        if (DescriptorUtils.isLocal(r11) == true) goto L38;
        if (ownersEquivalent(r10, r11, AnonymousClass1.INSTANCE, r12) == true) goto L31;
        return false;
    L31:
        OverridingUtil r16 = OverridingUtil.create(r15, new DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$overridingUtil$1(r12, r10, r11));
        Intrinsics.checkNotNullExpressionValue(r16, "a: CallableDescriptor,\n …= a && y == b }\n        }");
        OverridingUtil.OverrideCompatibilityInfo.Result r17 = r16.isOverridableBy(r10, r11, null, !r14).getResult();
        OverridingUtil.OverrideCompatibilityInfo.Result r18 = OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE;
        if (r17 != r18) goto L37;
        if (r16.isOverridableBy(r11, r10, null, !r14).getResult() != r18) goto L37;
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
    public final boolean areTypeParametersEquivalent(TypeParameterDescriptor r10, TypeParameterDescriptor r11, boolean r12, Function2<? super DeclarationDescriptor, ? super DeclarationDescriptor, Boolean> r13) {
        Intrinsics.checkNotNullParameter(r10, "a");
        Intrinsics.checkNotNullParameter(r11, "b");
        Intrinsics.checkNotNullParameter(r13, "equivalentCallables");
        if (Intrinsics.areEqual(r10, r11) == false) goto L6;
        return true;
    L6:
        if (Intrinsics.areEqual(r10.getContainingDeclaration(), r11.getContainingDeclaration()) == false) goto L9;
        return false;
    L9:
        if (ownersEquivalent(r10, r11, r13, r12) == true) goto L12;
        return false;
    L12:
        if (r10.getIndex() != r11.getIndex()) goto L15;
        return true;
    L15:
        return false;
    }
}
