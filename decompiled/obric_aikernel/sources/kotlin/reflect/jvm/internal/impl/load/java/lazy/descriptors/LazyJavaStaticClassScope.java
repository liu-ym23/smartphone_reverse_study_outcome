package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.UtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

/* JADX INFO: loaded from: classes3.dex */
public final class LazyJavaStaticClassScope extends LazyJavaStaticScope {
    private final JavaClass jClass;
    private final LazyJavaClassDescriptor ownerDescriptor;

    public LazyJavaStaticClassScope(LazyJavaResolverContext r10, JavaClass r11, LazyJavaClassDescriptor r12) {
        Intrinsics.checkNotNullParameter(r10, "c");
        Intrinsics.checkNotNullParameter(r11, "jClass");
        Intrinsics.checkNotNullParameter(r12, "ownerDescriptor");
        super(r10);
        this.jClass = r11;
        this.ownerDescriptor = r12;
    }

    private final <R> Set<R> flatMapJavaStaticSupertypesScopes(final ClassDescriptor r10, final Set<R> r11, final Function1<? super MemberScope, ? extends Collection<? extends R>> r12) {
        DFS.dfs(CollectionsKt.listOf(r10), C04181.INSTANCE, new AnonymousClass2(r10, r11, r12));
        return r11;
    }

    private final PropertyDescriptor getRealOriginal(PropertyDescriptor r10) {
        if (r10.getKind().isReal() == false) goto L5;
        return r10;
    L5:
        Collection<? extends PropertyDescriptor> r11 = r10.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(r11, "this.overriddenDescriptors");
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<T> r13 = r11.iterator();
    L7:
        if (r13.hasNext() == false) goto L10;
        PropertyDescriptor r14 = (PropertyDescriptor) r13.next();
        Intrinsics.checkNotNullExpressionValue(r14, "it");
        r12.add(getRealOriginal(r14));
        goto L7
    L10:
        return (PropertyDescriptor) CollectionsKt.single(CollectionsKt.distinct(r12));
    }

    private final Set<SimpleFunctionDescriptor> getStaticFunctionsFromJavaSuperClasses(Name r10, ClassDescriptor r11) {
        LazyJavaStaticClassScope r12 = UtilKt.getParentJavaStaticClassScope(r11);
        if (r12 != null) goto L7;
        return SetsKt.emptySet();
    L7:
        return CollectionsKt.toSet(r12.getContributedFunctions(r10, NoLookupLocation.WHEN_GET_SUPER_MEMBERS));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected Set<Name> computeClassNames(DescriptorKindFilter r10, Function1<? super Name, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "kindFilter");
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected Set<Name> computeFunctionNames(DescriptorKindFilter r10, Function1<? super Name, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "kindFilter");
        Set<Name> r12 = CollectionsKt.toMutableSet(getDeclaredMemberIndex().invoke().getMethodNames());
        LazyJavaStaticClassScope r13 = UtilKt.getParentJavaStaticClassScope(getOwnerDescriptor());
        if (r13 == null) goto L5;
        Set<Name> r14 = r13.getFunctionNames();
    L6:
        if (r14 != null) goto L8;
        r14 = SetsKt.emptySet();
    L8:
        r12.addAll(r14);
        if (this.jClass.isEnum() == false) goto L11;
        r12.addAll(CollectionsKt.listOf(new Name[]{StandardNames.ENUM_VALUE_OF, StandardNames.ENUM_VALUES}));
    L11:
        r12.addAll(getC().getComponents().getSyntheticPartsProvider().getStaticFunctionNames(getOwnerDescriptor()));
        return r12;
    L5:
        r14 = null;
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected void computeImplicitlyDeclaredFunctions(Collection<SimpleFunctionDescriptor> r10, Name r11) {
        Intrinsics.checkNotNullParameter(r10, "result");
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        getC().getComponents().getSyntheticPartsProvider().generateStaticFunctions(getOwnerDescriptor(), r11, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected ClassDeclaredMemberIndex computeMemberIndex() {
        return new ClassDeclaredMemberIndex(this.jClass, AnonymousClass1.INSTANCE);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public /* bridge */ /* synthetic */ DeclaredMemberIndex computeMemberIndex() {
        return computeMemberIndex();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected void computeNonDeclaredFunctions(Collection<SimpleFunctionDescriptor> r10, Name r11) {
        Intrinsics.checkNotNullParameter(r10, "result");
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        Collection<? extends SimpleFunctionDescriptor> r12 = DescriptorResolverUtils.resolveOverridesForStaticMembers(r11, getStaticFunctionsFromJavaSuperClasses(r11, getOwnerDescriptor()), r10, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
        Intrinsics.checkNotNullExpressionValue(r12, "resolveOverridesForStati….overridingUtil\n        )");
        r10.addAll(r12);
        if (this.jClass.isEnum() == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r11, StandardNames.ENUM_VALUE_OF) == false) goto L9;
        SimpleFunctionDescriptor r13 = DescriptorFactory.createEnumValueOfMethod(getOwnerDescriptor());
        String r14 = "createEnumValueOfMethod(ownerDescriptor)";
    L7:
        Intrinsics.checkNotNullExpressionValue(r13, r14);
        r10.add(r13);
        return;
    L9:
        if (Intrinsics.areEqual(r11, StandardNames.ENUM_VALUES) == false) goto L13;
        r13 = DescriptorFactory.createEnumValuesMethod(getOwnerDescriptor());
        r14 = "createEnumValuesMethod(ownerDescriptor)";
        goto L7
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticScope, kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected void computeNonDeclaredProperties(final Name r11, Collection<PropertyDescriptor> r12) {
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r12, "result");
        Set r10 = flatMapJavaStaticSupertypesScopes(getOwnerDescriptor(), new LinkedHashSet(), new LazyJavaStaticClassScope$computeNonDeclaredProperties$propertiesFromSupertypes$1(r11));
        if ((!r12.isEmpty()) == false) goto L5;
        Collection<? extends PropertyDescriptor> r13 = DescriptorResolverUtils.resolveOverridesForStaticMembers(r11, r10, r12, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
        Intrinsics.checkNotNullExpressionValue(r13, "resolveOverridesForStati…ingUtil\n                )");
        r12.addAll(r13);
        return;
    L5:
        LinkedHashMap r14 = new LinkedHashMap();
        Iterator r15 = r10.iterator();
    L7:
        if (r15.hasNext() == false) goto L12;
        Object r16 = r15.next();
        PropertyDescriptor r17 = getRealOriginal((PropertyDescriptor) r16);
        Object r18 = r14.get(r17);
        if (r18 != null) goto L11;
        r18 = new ArrayList();
        r14.put(r17, r18);
    L11:
        ((List) r18).add(r16);
        goto L7
    L12:
        ArrayList r19 = new ArrayList();
        Iterator r20 = r14.entrySet().iterator();
    L14:
        if (r20.hasNext() == false) goto L16;
        Collection r21 = DescriptorResolverUtils.resolveOverridesForStaticMembers(r11, (Collection) ((Map.Entry) r20.next()).getValue(), r12, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
        Intrinsics.checkNotNullExpressionValue(r21, "resolveOverridesForStati…ingUtil\n                )");
        CollectionsKt.addAll(r19, r21);
        goto L14
    L16:
        r12.addAll(r19);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected Set<Name> computePropertyNames(DescriptorKindFilter r10, Function1<? super Name, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "kindFilter");
        Set<Name> r12 = CollectionsKt.toMutableSet(getDeclaredMemberIndex().invoke().getFieldNames());
        flatMapJavaStaticSupertypesScopes(getOwnerDescriptor(), r12, LazyJavaStaticClassScope$computePropertyNames$1$1.INSTANCE);
        return r12;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public ClassifierDescriptor mo1325getContributedClassifier(Name r10, LookupLocation r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "location");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOwnerDescriptor() {
        return getOwnerDescriptor();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected LazyJavaClassDescriptor getOwnerDescriptor() {
        return this.ownerDescriptor;
    }
}
