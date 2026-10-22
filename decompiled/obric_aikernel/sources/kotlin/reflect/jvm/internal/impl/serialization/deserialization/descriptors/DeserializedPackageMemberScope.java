package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.bytedance.crash.tracker.ActivityLifecycle;
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
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;

/* JADX INFO: loaded from: classes3.dex */
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
        ProtoBuf.TypeTable r10 = r18.getTypeTable();
        Intrinsics.checkNotNullExpressionValue(r10, "proto.typeTable");
        TypeTable r11 = new TypeTable(r10);
        VersionRequirementTable.Companion r12 = VersionRequirementTable.Companion;
        ProtoBuf.VersionRequirementTable r13 = r18.getVersionRequirementTable();
        Intrinsics.checkNotNullExpressionValue(r13, "proto.versionRequirementTable");
        DeserializationContext r14 = r22.createContext(r17, r19, r11, r12.create(r13), r20, r21);
        List<ProtoBuf.Function> r15 = r18.getFunctionList();
        Intrinsics.checkNotNullExpressionValue(r15, "proto.functionList");
        List<ProtoBuf.Property> r16 = r18.getPropertyList();
        Intrinsics.checkNotNullExpressionValue(r16, "proto.propertyList");
        List<ProtoBuf.TypeAlias> r25 = r18.getTypeAliasList();
        Intrinsics.checkNotNullExpressionValue(r25, "proto.typeAliasList");
        super(r14, r15, r16, r25, r24);
        this.packageDescriptor = r17;
        this.debugName = r23;
        this.packageFqName = r17.getFqName();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    protected void addEnumEntryDescriptors(Collection<DeclarationDescriptor> r10, Function1<? super Name, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "result");
        Intrinsics.checkNotNullParameter(r11, "nameFilter");
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    protected ClassId createClassId(Name r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        return new ClassId(this.packageFqName, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public ClassifierDescriptor mo1325getContributedClassifier(Name r10, LookupLocation r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "location");
        mo1329recordLookup(r10, r11);
        return super.mo1325getContributedClassifier(r10, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public /* bridge */ /* synthetic */ Collection getContributedDescriptors(DescriptorKindFilter r10, Function1 r11) {
        return getContributedDescriptors(r10, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public List<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r10, Function1<? super Name, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "kindFilter");
        Intrinsics.checkNotNullParameter(r11, "nameFilter");
        Collection<DeclarationDescriptor> r12 = computeDescriptors(r10, r11, NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
        Iterable<ClassDescriptorFactory> r13 = getC().getComponents().getFictitiousClassDescriptorFactories();
        ArrayList r14 = new ArrayList();
        Iterator<ClassDescriptorFactory> r15 = r13.iterator();
    L4:
        if (r15.hasNext() == false) goto L7;
        CollectionsKt.addAll(r14, r15.next().getAllContributedClassesIfPossible(this.packageFqName));
        goto L4
    L7:
        return CollectionsKt.plus(r12, r14);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    protected Set<Name> getNonDeclaredClassifierNames() {
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    protected Set<Name> getNonDeclaredFunctionNames() {
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    protected Set<Name> getNonDeclaredVariableNames() {
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    protected boolean hasClass(Name r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        if (super.hasClass(r10) == true) goto L22;
        Iterable<ClassDescriptorFactory> r11 = getC().getComponents().getFictitiousClassDescriptorFactories();
        if ((r11 instanceof Collection) == true) goto L7;
    L9:
        Iterator<ClassDescriptorFactory> r12 = r11.iterator();
    L11:
        if (r12.hasNext() == false) goto L8;
        if (r12.next().shouldCreateClass(this.packageFqName, r10) == false) goto L11;
        boolean r13 = true;
    L15:
        if (r13 == false) goto L18;
        return true;
    L18:
        return false;
    L8:
        r13 = false;
        goto L15
    L7:
        if (((Collection) r11).isEmpty() == false) goto L9;
    L22:
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: recordLookup */
    public void mo1329recordLookup(Name r10, LookupLocation r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "location");
        UtilsKt.record(getC().getComponents().getLookupTracker(), r11, this.packageDescriptor, r10);
    }

    public String toString() {
        return this.debugName;
    }
}
