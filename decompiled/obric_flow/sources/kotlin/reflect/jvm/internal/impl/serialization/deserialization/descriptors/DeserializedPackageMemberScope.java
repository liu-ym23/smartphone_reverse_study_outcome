package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.incremental.UtilsKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nDeserializedPackageMemberScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeserializedPackageMemberScope.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedPackageMemberScope\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,81:1\n1360#2:82\n1446#2,5:83\n1747#2,3:88\n*S KotlinDebug\n*F\n+ 1 DeserializedPackageMemberScope.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedPackageMemberScope\n*L\n55#1:82\n55#1:83,5\n58#1:88,3\n*E\n"})
public class DeserializedPackageMemberScope extends DeserializedMemberScope {
    private final String debugName;
    private final PackageFragmentDescriptor packageDescriptor;
    private final FqName packageFqName;

    public DeserializedPackageMemberScope(PackageFragmentDescriptor r17, ProtoBuf.Package r18, NameResolver r19, BinaryVersion r20, DeserializedContainerSource r21, DeserializationComponents r22, String r23, Function0<? extends Collection<Name>> r24) {
        Intrinsics.checkNotNullParameter(r17, "packageDescriptor");
        Intrinsics.checkNotNullParameter(r18, "proto");
        Intrinsics.checkNotNullParameter(r19, "nameResolver");
        Intrinsics.checkNotNullParameter(r20, "metadataVersion");
        Intrinsics.checkNotNullParameter(r22, "components");
        Intrinsics.checkNotNullParameter(r23, "debugName");
        Intrinsics.checkNotNullParameter(r24, "classNames");
        super(r22.createContext(r17, r19, new TypeTable(r18.getTypeTable()), VersionRequirementTable.Companion.create(r18.getVersionRequirementTable()), r20, r21), r18.getFunctionList(), r18.getPropertyList(), r18.getTypeAliasList(), r24);
        this.packageDescriptor = r17;
        this.debugName = r23;
        this.packageFqName = r17.getFqName();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    public void addEnumEntryDescriptors(Collection<DeclarationDescriptor> r5, Function1<? super Name, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r5, "result");
        Intrinsics.checkNotNullParameter(r10, "nameFilter");
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    public ClassId createClassId(Name r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        return new ClassId(this.packageFqName, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public ClassifierDescriptor mo1404getContributedClassifier(Name r5, LookupLocation r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "location");
        mo1408recordLookup(r5, r10);
        return super.mo1404getContributedClassifier(r5, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public /* bridge */ /* synthetic */ Collection getContributedDescriptors(DescriptorKindFilter r5, Function1 r10) {
        return getContributedDescriptors(r5, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    public Set<Name> getNonDeclaredClassifierNames() {
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    public Set<Name> getNonDeclaredFunctionNames() {
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    public Set<Name> getNonDeclaredVariableNames() {
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    public boolean hasClass(Name r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        if (super.hasClass(r5) == true) goto L16;
        Iterable<ClassDescriptorFactory> r10 = getC().getComponents().getFictitiousClassDescriptorFactories();
        if ((r10 instanceof Collection) == true) goto L7;
    L9:
        Iterator<ClassDescriptorFactory> r11 = r10.iterator();
    L11:
        if (r11.hasNext() == false) goto L15;
        if (r11.next().shouldCreateClass(this.packageFqName, r5) == false) goto L11;
    L15:
        return false;
    L7:
        if (((Collection) r10).isEmpty() == false) goto L9;
    L16:
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: recordLookup */
    public void mo1408recordLookup(Name r5, LookupLocation r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "location");
        UtilsKt.record(getC().getComponents().getLookupTracker(), r10, this.packageDescriptor, r5);
    }

    public String toString() {
        return this.debugName;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public List<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r5, Function1<? super Name, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r5, "kindFilter");
        Intrinsics.checkNotNullParameter(r10, "nameFilter");
        Collection<DeclarationDescriptor> r11 = computeDescriptors(r5, r10, NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
        Iterable<ClassDescriptorFactory> r12 = getC().getComponents().getFictitiousClassDescriptorFactories();
        ArrayList r13 = new ArrayList();
        Iterator<ClassDescriptorFactory> r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L7;
        CollectionsKt.a(r13, r14.next().getAllContributedClassesIfPossible(this.packageFqName));
        goto L4
    L7:
        return CollectionsKt.plus(r11, r13);
    }
}
