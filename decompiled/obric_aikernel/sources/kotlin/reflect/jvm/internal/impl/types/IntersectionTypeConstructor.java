package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.IntersectionTypeConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class IntersectionTypeConstructor implements TypeConstructor, IntersectionTypeConstructorMarker {
    private KotlinType alternative;
    private final int hashCode;
    private final LinkedHashSet<KotlinType> intersectedTypes;

    public IntersectionTypeConstructor(Collection<? extends KotlinType> r10) {
        Intrinsics.checkNotNullParameter(r10, "typesToIntersect");
        r10.isEmpty();
        LinkedHashSet<KotlinType> r11 = new LinkedHashSet(r10);
        this.intersectedTypes = r11;
        this.hashCode = r11.hashCode();
    }

    private IntersectionTypeConstructor(Collection<? extends KotlinType> r10, KotlinType r11) {
        this(r10);
        this.alternative = r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String makeDebugNameForIntersectionType$default(IntersectionTypeConstructor r10, Function1 r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = C04311.INSTANCE;
    L6:
        return r10.makeDebugNameForIntersectionType(r11);
    }

    public final MemberScope createScopeForKotlinType() {
        return TypeIntersectionScope.Companion.create("member scope for intersection type", this.intersectedTypes);
    }

    public final SimpleType createType() {
        return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(TypeAttributes.Companion.getEmpty(), this, CollectionsKt.emptyList(), false, createScopeForKotlinType(), new AnonymousClass1(this));
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof IntersectionTypeConstructor) == true) goto L10;
        return false;
    L10:
        return Intrinsics.areEqual(this.intersectedTypes, ((IntersectionTypeConstructor) r10).intersectedTypes);
    }

    public final KotlinType getAlternativeType() {
        return this.alternative;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public KotlinBuiltIns getBuiltIns() {
        KotlinBuiltIns r10 = this.intersectedTypes.iterator().next().getConstructor().getBuiltIns();
        Intrinsics.checkNotNullExpressionValue(r10, "intersectedTypes.iterato…xt().constructor.builtIns");
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getDeclarationDescriptor */
    public ClassifierDescriptor mo1323getDeclarationDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public List<TypeParameterDescriptor> getParameters() {
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getSupertypes */
    public Collection<KotlinType> mo1324getSupertypes() {
        return this.intersectedTypes;
    }

    public int hashCode() {
        return this.hashCode;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    public final String makeDebugNameForIntersectionType(final Function1<? super KotlinType, ? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r11, "getProperTypeRelatedToStringify");
        return CollectionsKt.joinToString$default(CollectionsKt.sortedWith(this.intersectedTypes, new IntersectionTypeConstructor$makeDebugNameForIntersectionType$$inlined$sortedBy$1(r11)), " & ", "{", "}", 0, null, new AnonymousClass3(r11), 24, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public IntersectionTypeConstructor refine(KotlinTypeRefiner r10) {
        Intrinsics.checkNotNullParameter(r10, "kotlinTypeRefiner");
        Collection<KotlinType> r11 = mo1324getSupertypes();
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<T> r13 = r11.iterator();
        boolean r14 = false;
    L4:
        if (r13.hasNext() == false) goto L6;
        r12.add(((KotlinType) r13.next()).refine(r10));
        r14 = true;
        goto L4
    L6:
        IntersectionTypeConstructor r15 = null;
        KotlinType r16 = null;
        if (r14 == false) goto L13;
        KotlinType r17 = getAlternativeType();
        if (r17 == null) goto L12;
        r16 = r17.refine(r10);
    L12:
        r15 = new IntersectionTypeConstructor(r12).setAlternative(r16);
    L13:
        if (r15 != null) goto L16;
        return this;
    L16:
        return r15;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public /* bridge */ /* synthetic */ TypeConstructor refine(KotlinTypeRefiner r10) {
        return refine(r10);
    }

    public final IntersectionTypeConstructor setAlternative(KotlinType r10) {
        return new IntersectionTypeConstructor(this.intersectedTypes, r10);
    }

    public String toString() {
        return makeDebugNameForIntersectionType$default(this, null, 1, null);
    }
}
