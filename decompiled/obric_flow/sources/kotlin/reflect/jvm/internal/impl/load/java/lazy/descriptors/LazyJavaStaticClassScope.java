package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.UtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nLazyJavaStaticClassScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyJavaStaticClassScope.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaStaticClassScope\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 5 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,171:1\n1#2:172\n1477#3:173\n1502#3,3:174\n1505#3,3:184\n1549#3:193\n1620#3,3:194\n361#4,7:177\n76#5:187\n96#5,5:188\n*S KotlinDebug\n*F\n+ 1 LazyJavaStaticClassScope.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaStaticClassScope\n*L\n112#1:173\n112#1:174,3\n112#1:184,3\n168#1:193\n168#1:194,3\n112#1:177,7\n114#1:187\n114#1:188,5\n*E\n"})
public final class LazyJavaStaticClassScope extends LazyJavaStaticScope {
    private final JavaClass jClass;
    private final JavaClassDescriptor ownerDescriptor;

    public LazyJavaStaticClassScope(LazyJavaResolverContext r5, JavaClass r10, JavaClassDescriptor r11) {
        Intrinsics.checkNotNullParameter(r5, "c");
        Intrinsics.checkNotNullParameter(r10, "jClass");
        Intrinsics.checkNotNullParameter(r11, "ownerDescriptor");
        super(r5);
        this.jClass = r10;
        this.ownerDescriptor = r11;
    }

    public static /* synthetic */ Iterable accessor$LazyJavaStaticClassScope$lambda0(ClassDescriptor r5) {
        return flatMapJavaStaticSupertypesScopes$lambda$6(r5);
    }

    private final <R> Set<R> flatMapJavaStaticSupertypesScopes(final ClassDescriptor r5, final Set<R> r10, final Function1<? super MemberScope, ? extends Collection<? extends R>> r11) {
        DFS.dfs(CollectionsKt.listOf(r5), LazyJavaStaticClassScope$$Lambda$0.INSTANCE, new AnonymousClass2(r5, r10, r11));
        return r10;
    }

    private static final Iterable flatMapJavaStaticSupertypesScopes$lambda$6(ClassDescriptor r5) {
        return SequencesKt.asIterable(SequencesKt.mapNotNull(CollectionsKt.asSequence(r5.getTypeConstructor().mo1403getSupertypes()), LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1$1.INSTANCE));
    }

    private final PropertyDescriptor getRealOriginal(PropertyDescriptor r5) {
        if (r5.getKind().isReal() == false) goto L5;
        return r5;
    L5:
        Collection<? extends PropertyDescriptor> r10 = r5.getOverriddenDescriptors();
        ArrayList r11 = new ArrayList(CollectionsKt.h(r10));
        Iterator<T> r12 = r10.iterator();
    L7:
        if (r12.hasNext() == false) goto L10;
        r11.add(getRealOriginal((PropertyDescriptor) r12.next()));
        goto L7
    L10:
        return (PropertyDescriptor) CollectionsKt.single(CollectionsKt.distinct(r11));
    }

    private final Set<SimpleFunctionDescriptor> getStaticFunctionsFromJavaSuperClasses(Name r5, ClassDescriptor r10) {
        LazyJavaStaticClassScope r11 = UtilKt.getParentJavaStaticClassScope(r10);
        if (r11 != null) goto L7;
        return SetsKt.emptySet();
    L7:
        return CollectionsKt.toSet(r11.getContributedFunctions(r5, NoLookupLocation.WHEN_GET_SUPER_MEMBERS));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public Set<Name> computeClassNames(DescriptorKindFilter r5, Function1<? super Name, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r5, "kindFilter");
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public Set<Name> computeFunctionNames(DescriptorKindFilter r5, Function1<? super Name, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r5, "kindFilter");
        Set<Name> r11 = CollectionsKt.toMutableSet(getDeclaredMemberIndex().invoke().getMethodNames());
        LazyJavaStaticClassScope r12 = UtilKt.getParentJavaStaticClassScope(getOwnerDescriptor());
        if (r12 == null) goto L5;
        Set<Name> r13 = r12.getFunctionNames();
    L6:
        if (r13 != null) goto L8;
        r13 = SetsKt.emptySet();
    L8:
        r11.addAll(r13);
        if (this.jClass.isEnum() == false) goto L11;
        r11.addAll(CollectionsKt.listOf(new Name[]{StandardNames.ENUM_VALUE_OF, StandardNames.ENUM_VALUES}));
    L11:
        LazyJavaResolverContext r14 = getC();
        r11.addAll(getC().getComponents().getSyntheticPartsProvider().getStaticFunctionNames(r14, getOwnerDescriptor()));
        return r11;
    L5:
        r13 = null;
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void computeImplicitlyDeclaredFunctions(Collection<SimpleFunctionDescriptor> r5, Name r10) {
        Intrinsics.checkNotNullParameter(r5, "result");
        Intrinsics.checkNotNullParameter(r10, "name");
        LazyJavaResolverContext r11 = getC();
        getC().getComponents().getSyntheticPartsProvider().generateStaticFunctions(r11, getOwnerDescriptor(), r10, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public /* bridge */ /* synthetic */ DeclaredMemberIndex computeMemberIndex() {
        return computeMemberIndex();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void computeNonDeclaredFunctions(Collection<SimpleFunctionDescriptor> r10, Name r11) {
        Intrinsics.checkNotNullParameter(r10, "result");
        Intrinsics.checkNotNullParameter(r11, "name");
        r10.addAll(DescriptorResolverUtils.resolveOverridesForStaticMembers(r11, getStaticFunctionsFromJavaSuperClasses(r11, getOwnerDescriptor()), r10, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil()));
        if (this.jClass.isEnum() == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r11, StandardNames.ENUM_VALUE_OF) == false) goto L8;
        r10.add(DescriptorFactory.createEnumValueOfMethod(getOwnerDescriptor()));
        return;
    L8:
        if (Intrinsics.areEqual(r11, StandardNames.ENUM_VALUES) == false) goto L13;
        r10.add(DescriptorFactory.createEnumValuesMethod(getOwnerDescriptor()));
        return;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticScope, kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void computeNonDeclaredProperties(final Name r10, Collection<PropertyDescriptor> r11) {
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r11, "result");
        Set r5 = flatMapJavaStaticSupertypesScopes(getOwnerDescriptor(), new LinkedHashSet(), new LazyJavaStaticClassScope$computeNonDeclaredProperties$propertiesFromSupertypes$1(r10));
        if (r11.isEmpty() == true) goto L5;
        r11.addAll(DescriptorResolverUtils.resolveOverridesForStaticMembers(r10, r5, r11, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil()));
    L18:
        if (this.jClass.isEnum() == true) goto L20;
        return;
    L20:
        if (Intrinsics.areEqual(r10, StandardNames.ENUM_ENTRIES) == false) goto L28;
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(r11, DescriptorFactory.createEnumEntriesProperty(getOwnerDescriptor()));
        return;
    L28:
        return;
    L5:
        LinkedHashMap r12 = new LinkedHashMap();
        Iterator r13 = r5.iterator();
    L7:
        if (r13.hasNext() == false) goto L12;
        Object r14 = r13.next();
        PropertyDescriptor r15 = getRealOriginal((PropertyDescriptor) r14);
        Object r16 = r12.get(r15);
        if (r16 != null) goto L11;
        r16 = new ArrayList();
        r12.put(r15, r16);
    L11:
        ((List) r16).add(r14);
        goto L7
    L12:
        ArrayList r17 = new ArrayList();
        Iterator r18 = r12.entrySet().iterator();
    L14:
        if (r18.hasNext() == false) goto L16;
        CollectionsKt.a(r17, DescriptorResolverUtils.resolveOverridesForStaticMembers(r10, (Collection) ((Map.Entry) r18.next()).getValue(), r11, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil()));
        goto L14
    L16:
        r11.addAll(r17);
        goto L18
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public Set<Name> computePropertyNames(DescriptorKindFilter r5, Function1<? super Name, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r5, "kindFilter");
        Set<Name> r11 = CollectionsKt.toMutableSet(getDeclaredMemberIndex().invoke().getFieldNames());
        flatMapJavaStaticSupertypesScopes(getOwnerDescriptor(), r11, LazyJavaStaticClassScope$computePropertyNames$1$1.INSTANCE);
        if (this.jClass.isEnum() == false) goto L5;
        r11.add(StandardNames.ENUM_ENTRIES);
    L5:
        return r11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public ClassifierDescriptor mo1404getContributedClassifier(Name r5, LookupLocation r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "location");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOwnerDescriptor() {
        return getOwnerDescriptor();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public ClassDeclaredMemberIndex computeMemberIndex() {
        return new ClassDeclaredMemberIndex(this.jClass, AnonymousClass1.INSTANCE);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public JavaClassDescriptor getOwnerDescriptor() {
        return this.ownerDescriptor;
    }
}
