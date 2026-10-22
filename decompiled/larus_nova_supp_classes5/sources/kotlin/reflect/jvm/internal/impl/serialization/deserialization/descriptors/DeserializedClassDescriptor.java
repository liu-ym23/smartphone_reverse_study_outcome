package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.DeserializedDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ReceiverParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.UtilsKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.CliSealedClassInheritorsProvider;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.StaticScopeForKotlinEnum;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ContextClassReceiver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlagsUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ValueClassUtilKt;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class DeserializedClassDescriptor extends AbstractClassDescriptor implements DeserializedDescriptor {
    private final Annotations annotations;
    private final DeserializationContext c;
    private final ClassId classId;
    private final ProtoBuf$Class classProto;
    private final NullableLazyValue<ClassDescriptor> companionObjectDescriptor;
    private final NotNullLazyValue<Collection<ClassConstructorDescriptor>> constructors;
    private final DeclarationDescriptor containingDeclaration;
    private final EnumEntryClassDescriptors enumEntries;
    private final boolean hasEnumEntriesMetadataFlag;
    private final ClassKind kind;
    private final ScopesHolderForClass<DeserializedClassMemberScope> memberScopeHolder;
    private final BinaryVersion metadataVersion;
    private final Modality modality;
    private final NullableLazyValue<ClassConstructorDescriptor> primaryConstructor;
    private final NotNullLazyValue<Collection<ClassDescriptor>> sealedSubclasses;
    private final SourceElement sourceElement;
    private final MemberScopeImpl staticScope;
    private final ProtoContainer.Class thisAsProtoContainer;
    private final DeserializedClassTypeConstructor typeConstructor;
    private final NullableLazyValue<ValueClassRepresentation<SimpleType>> valueClassRepresentation;
    private final DescriptorVisibility visibility;

    public final class DeserializedClassMemberScope extends DeserializedMemberScope {
        private final NotNullLazyValue<Collection<DeclarationDescriptor>> allDescriptors;
        private final KotlinTypeRefiner kotlinTypeRefiner;
        private final NotNullLazyValue<Collection<KotlinType>> refinedSupertypes;
        final /* synthetic */ DeserializedClassDescriptor this$0;

        private static final List _init_$lambda$1$lambda$0(List r1) {
            Intrinsics.checkNotNullParameter(r1, "$it");
            return r1;
        }

        public static /* synthetic */ List accessor$DeserializedClassDescriptor$DeserializedClassMemberScope$lambda0(List r0) {
            return _init_$lambda$1$lambda$0(r0);
        }

        public static /* synthetic */ Collection accessor$DeserializedClassDescriptor$DeserializedClassMemberScope$lambda1(DeserializedClassMemberScope r0) {
            return allDescriptors$lambda$2(r0);
        }

        public static /* synthetic */ Collection accessor$DeserializedClassDescriptor$DeserializedClassMemberScope$lambda2(DeserializedClassMemberScope r0) {
            return refinedSupertypes$lambda$3(r0);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        public Set<Name> getNonDeclaredClassifierNames() {
            List<KotlinType> r0 = DeserializedClassDescriptor.access$getTypeConstructor$p(getClassDescriptor()).getSupertypes();
            LinkedHashSet r1 = new LinkedHashSet();
            Iterator<T> r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L12;
            Set<Name> r3 = ((KotlinType) r2.next()).getMemberScope().getClassifierNames();
            if (r3 == null) goto L7;
            CollectionsKt.addAll(r1, r3);
            goto L4
        L7:
            return null;
        L12:
            return r1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        public Set<Name> getNonDeclaredFunctionNames() {
            List<KotlinType> r0 = DeserializedClassDescriptor.access$getTypeConstructor$p(getClassDescriptor()).getSupertypes();
            LinkedHashSet r1 = new LinkedHashSet();
            Iterator<T> r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L6;
            CollectionsKt.addAll(r1, ((KotlinType) r2.next()).getMemberScope().getFunctionNames());
            goto L4
        L6:
            DeserializedClassDescriptor r3 = this.this$0;
            r1.addAll(getC().getComponents().getAdditionalClassPartsProvider().getFunctionsNames(r3));
            return r1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        public Set<Name> getNonDeclaredVariableNames() {
            List<KotlinType> r0 = DeserializedClassDescriptor.access$getTypeConstructor$p(getClassDescriptor()).getSupertypes();
            LinkedHashSet r1 = new LinkedHashSet();
            Iterator<T> r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L6;
            CollectionsKt.addAll(r1, ((KotlinType) r2.next()).getMemberScope().getVariableNames());
            goto L4
        L6:
            return r1;
        }

        private final DeserializedClassDescriptor getClassDescriptor() {
            return this.this$0;
        }

        private static final Collection allDescriptors$lambda$2(DeserializedClassMemberScope r3) {
            Intrinsics.checkNotNullParameter(r3, "this$0");
            return r3.computeDescriptors(DescriptorKindFilter.ALL, MemberScope.Companion.getALL_NAME_FILTER(), NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
        }

        private static final Collection refinedSupertypes$lambda$3(DeserializedClassMemberScope r1) {
            Intrinsics.checkNotNullParameter(r1, "this$0");
            return r1.kotlinTypeRefiner.refineSupertypes(r1.getClassDescriptor());
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        public ClassId createClassId(Name r2) {
            Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
            return DeserializedClassDescriptor.access$getClassId$p(this.this$0).createNestedClassId(r2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        public boolean isDeclaredFunctionAvailable(SimpleFunctionDescriptor r3) {
            Intrinsics.checkNotNullParameter(r3, "function");
            return getC().getComponents().getPlatformDependentDeclarationFilter().isFunctionAvailable(this.this$0, r3);
        }

        public DeserializedClassMemberScope(DeserializedClassDescriptor r8, KotlinTypeRefiner r9) {
            Intrinsics.checkNotNullParameter(r9, "kotlinTypeRefiner");
            this.this$0 = r8;
            DeserializationContext r2 = r8.getC();
            List<ProtoBuf$Function> r3 = r8.getClassProto().getFunctionList();
            List<ProtoBuf$Property> r4 = r8.getClassProto().getPropertyList();
            List<ProtoBuf$TypeAlias> r5 = r8.getClassProto().getTypeAliasList();
            List<Integer> r0 = r8.getClassProto().getNestedClassNameList();
            NameResolver r10 = r8.getC().getNameResolver();
            final ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
            Iterator<T> r6 = r0.iterator();
        L4:
            if (r6.hasNext() == false) goto L6;
            r1.add(NameResolverUtilKt.getName(r10, ((Number) r6.next()).intValue()));
            goto L4
        L6:
            super(r2, r3, r4, r5, new DeserializedClassDescriptor$DeserializedClassMemberScope$$Lambda$0(r1));
            this.kotlinTypeRefiner = r9;
            this.allDescriptors = getC().getStorageManager().createLazyValue(new DeserializedClassDescriptor$DeserializedClassMemberScope$$Lambda$1(this));
            this.refinedSupertypes = getC().getStorageManager().createLazyValue(new DeserializedClassDescriptor$DeserializedClassMemberScope$$Lambda$2(this));
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        public void addEnumEntryDescriptors(Collection<DeclarationDescriptor> r2, Function1<? super Name, Boolean> r3) {
            Intrinsics.checkNotNullParameter(r2, "result");
            Intrinsics.checkNotNullParameter(r3, "nameFilter");
            EnumEntryClassDescriptors r4 = DeserializedClassDescriptor.access$getEnumEntries$p(getClassDescriptor());
            if (r4 == null) goto L5;
            List r5 = r4.all();
        L6:
            if (r5 != null) goto L8;
            r5 = CollectionsKt.emptyList();
        L8:
            r2.addAll(r5);
            return;
        L5:
            r5 = null;
            goto L6
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        public void computeNonDeclaredFunctions(Name r5, List<SimpleFunctionDescriptor> r6) {
            Intrinsics.checkNotNullParameter(r5, DBDefinition.NAME);
            Intrinsics.checkNotNullParameter(r6, "functions");
            ArrayList r0 = new ArrayList();
            Iterator r1 = ((Collection) this.refinedSupertypes.invoke()).iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            r0.addAll(((KotlinType) r1.next()).getMemberScope().getContributedFunctions(r5, NoLookupLocation.FOR_ALREADY_TRACKED));
            goto L4
        L6:
            r6.addAll(getC().getComponents().getAdditionalClassPartsProvider().getFunctions(r5, this.this$0));
            generateFakeOverrides(r5, r0, r6);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        public void computeNonDeclaredProperties(Name r5, List<PropertyDescriptor> r6) {
            Intrinsics.checkNotNullParameter(r5, DBDefinition.NAME);
            Intrinsics.checkNotNullParameter(r6, "descriptors");
            ArrayList r0 = new ArrayList();
            Iterator r1 = ((Collection) this.refinedSupertypes.invoke()).iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            r0.addAll(((KotlinType) r1.next()).getMemberScope().getContributedVariables(r5, NoLookupLocation.FOR_ALREADY_TRACKED));
            goto L4
        L6:
            generateFakeOverrides(r5, r0, r6);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        /* JADX INFO: renamed from: getContributedClassifier */
        public ClassifierDescriptor mo383getContributedClassifier(Name r2, LookupLocation r3) {
            Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
            Intrinsics.checkNotNullParameter(r3, "location");
            recordLookup(r2, r3);
            EnumEntryClassDescriptors r0 = DeserializedClassDescriptor.access$getEnumEntries$p(getClassDescriptor());
            if (r0 == null) goto L8;
            ClassDescriptor r1 = r0.findEnumEntry(r2);
            if (r1 == null) goto L8;
            return r1;
        L8:
            return super.mo383getContributedClassifier(r2, r3);
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r2, Function1<? super Name, Boolean> r3) {
            Intrinsics.checkNotNullParameter(r2, "kindFilter");
            Intrinsics.checkNotNullParameter(r3, "nameFilter");
            return (Collection) this.allDescriptors.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name r2, LookupLocation r3) {
            Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
            Intrinsics.checkNotNullParameter(r3, "location");
            recordLookup(r2, r3);
            return super.getContributedFunctions(r2, r3);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        public Collection<PropertyDescriptor> getContributedVariables(Name r2, LookupLocation r3) {
            Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
            Intrinsics.checkNotNullParameter(r3, "location");
            recordLookup(r2, r3);
            return super.getContributedVariables(r2, r3);
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        public void recordLookup(Name r3, LookupLocation r4) {
            Intrinsics.checkNotNullParameter(r3, DBDefinition.NAME);
            Intrinsics.checkNotNullParameter(r4, "location");
            UtilsKt.record(getC().getComponents().getLookupTracker(), r4, getClassDescriptor(), r3);
        }

        private final <D extends CallableMemberDescriptor> void generateFakeOverrides(Name r7, Collection<? extends D> r8, final List<D> r9) {
            ArrayList r3 = new ArrayList(r9);
            getC().getComponents().getKotlinTypeChecker().getOverridingUtil().generateOverridesInFunctionGroup(r7, r8, r3, getClassDescriptor(), new DeserializedClassDescriptor$DeserializedClassMemberScope$generateFakeOverrides$1(r9));
        }
    }

    public final class DeserializedClassTypeConstructor extends AbstractClassTypeConstructor {
        private final NotNullLazyValue<List<TypeParameterDescriptor>> parameters;
        final /* synthetic */ DeserializedClassDescriptor this$0;

        public static /* synthetic */ List accessor$DeserializedClassDescriptor$DeserializedClassTypeConstructor$lambda0(DeserializedClassDescriptor r0) {
            return parameters$lambda$0(r0);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        public Collection<KotlinType> computeSupertypes() {
            List<ProtoBuf$Type> r0 = ProtoTypeTableUtilKt.supertypes(this.this$0.getClassProto(), this.this$0.getC().getTypeTable());
            DeserializedClassDescriptor r1 = this.this$0;
            ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
            Iterator<T> r3 = r0.iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            r2.add(r1.getC().getTypeDeserializer().type((ProtoBuf$Type) r3.next()));
            goto L4
        L6:
            List r4 = CollectionsKt.plus(r2, this.this$0.getC().getComponents().getAdditionalClassPartsProvider().getSupertypes(this.this$0));
            ArrayList r5 = new ArrayList();
            Iterator r6 = r4.iterator();
        L8:
            if (r6.hasNext() == false) goto L16;
            ClassifierDescriptor r7 = ((KotlinType) r6.next()).getConstructor().getDeclarationDescriptor();
            if ((r7 instanceof NotFoundClasses.MockClassDescriptor) == false) goto L12;
            NotFoundClasses.MockClassDescriptor r8 = (NotFoundClasses.MockClassDescriptor) r7;
        L13:
            if (r8 == null) goto L8;
            r5.add(r8);
            goto L8
        L12:
            r8 = null;
            goto L13
        L16:
            if ((!r5.isEmpty()) == false) goto L30;
            ErrorReporter r9 = this.this$0.getC().getComponents().getErrorReporter();
            DeserializedClassDescriptor r10 = this.this$0;
            ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
            Iterator r12 = r5.iterator();
        L19:
            if (r12.hasNext() == false) goto L28;
            NotFoundClasses.MockClassDescriptor r13 = (NotFoundClasses.MockClassDescriptor) r12.next();
            ClassId r14 = DescriptorUtilsKt.getClassId(r13);
            if (r14 == null) goto L26;
            FqName r15 = r14.asSingleFqName();
            if (r15 == null) goto L26;
            String r16 = r15.asString();
            if (r16 == null) goto L26;
        L27:
            r11.add(r16);
        L26:
            r16 = r13.getName().asString();
            goto L27
        L28:
            r9.reportIncompleteHierarchy(r10, r11);
        L30:
            return CollectionsKt.toList(r4);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public List<TypeParameterDescriptor> getParameters() {
            return (List) this.parameters.invoke();
        }

        public String toString() {
            return this.this$0.getName().toString();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor, kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public /* bridge */ /* synthetic */ ClassDescriptor getDeclarationDescriptor() {
            return getDeclarationDescriptor();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        public SupertypeLoopChecker getSupertypeLoopChecker() {
            return SupertypeLoopChecker.EMPTY.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor, kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public /* bridge */ /* synthetic */ ClassifierDescriptor getDeclarationDescriptor() {
            return getDeclarationDescriptor();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor, kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public DeserializedClassDescriptor getDeclarationDescriptor() {
            return this.this$0;
        }

        public DeserializedClassTypeConstructor(final DeserializedClassDescriptor r3) {
            this.this$0 = r3;
            super(r3.getC().getStorageManager());
            this.parameters = r3.getC().getStorageManager().createLazyValue(new DeserializedClassDescriptor$DeserializedClassTypeConstructor$$Lambda$0(r3));
        }

        private static final List parameters$lambda$0(DeserializedClassDescriptor r1) {
            Intrinsics.checkNotNullParameter(r1, "this$0");
            return TypeParameterUtilsKt.computeConstructorTypeParameters(r1);
        }
    }

    public final class EnumEntryClassDescriptors {
        private final MemoizedFunctionToNullable<Name, ClassDescriptor> enumEntryByName;
        private final Map<Name, ProtoBuf$EnumEntry> enumEntryProtos;
        private final NotNullLazyValue<Set<Name>> enumMemberNames;
        final /* synthetic */ DeserializedClassDescriptor this$0;

        public static /* synthetic */ ClassDescriptor accessor$DeserializedClassDescriptor$EnumEntryClassDescriptors$lambda0(EnumEntryClassDescriptors r0, DeserializedClassDescriptor r1, Name r2) {
            return enumEntryByName$lambda$3(r0, r1, r2);
        }

        public static /* synthetic */ Set accessor$DeserializedClassDescriptor$EnumEntryClassDescriptors$lambda1(EnumEntryClassDescriptors r0) {
            return enumMemberNames$lambda$4(r0);
        }

        public static /* synthetic */ List accessor$DeserializedClassDescriptor$EnumEntryClassDescriptors$lambda2(DeserializedClassDescriptor r0, ProtoBuf$EnumEntry r1) {
            return enumEntryByName$lambda$3$lambda$2$lambda$1(r0, r1);
        }

        private final Set<Name> computeEnumMemberNames() {
            HashSet r0 = new HashSet();
            Iterator<KotlinType> r1 = this.this$0.getTypeConstructor().getSupertypes().iterator();
        L4:
            if (r1.hasNext() == false) goto L13;
            Iterator r2 = ResolutionScope.DefaultImpls.getContributedDescriptors$default(r1.next().getMemberScope(), null, null, 3, null).iterator();
        L7:
            if (r2.hasNext() == false) goto L4;
            DeclarationDescriptor r3 = (DeclarationDescriptor) r2.next();
            if ((r3 instanceof SimpleFunctionDescriptor) == true) goto L12;
            if ((r3 instanceof PropertyDescriptor) == false) goto L7;
        L12:
            r0.add(((CallableMemberDescriptor) r3).getName());
            goto L7
        L13:
            List<ProtoBuf$Function> r4 = this.this$0.getClassProto().getFunctionList();
            DeserializedClassDescriptor r5 = this.this$0;
            Iterator<T> r6 = r4.iterator();
        L15:
            if (r6.hasNext() == false) goto L17;
            ProtoBuf$Function r7 = (ProtoBuf$Function) r6.next();
            r0.add(NameResolverUtilKt.getName(r5.getC().getNameResolver(), r7.getName()));
            goto L15
        L17:
            List<ProtoBuf$Property> r8 = this.this$0.getClassProto().getPropertyList();
            DeserializedClassDescriptor r9 = this.this$0;
            Iterator<T> r10 = r8.iterator();
        L19:
            if (r10.hasNext() == false) goto L22;
            ProtoBuf$Property r11 = (ProtoBuf$Property) r10.next();
            r0.add(NameResolverUtilKt.getName(r9.getC().getNameResolver(), r11.getName()));
            goto L19
        L22:
            return SetsKt.plus(r0, r0);
        }

        public final Collection<ClassDescriptor> all() {
            Set<Name> r0 = this.enumEntryProtos.keySet();
            ArrayList r1 = new ArrayList();
            Iterator<T> r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L8;
            ClassDescriptor r3 = findEnumEntry((Name) r2.next());
            if (r3 == null) goto L4;
            r1.add(r3);
            goto L4
        L8:
            return r1;
        }

        public EnumEntryClassDescriptors(DeserializedClassDescriptor r6) {
            this.this$0 = r6;
            List<ProtoBuf$EnumEntry> r0 = r6.getClassProto().getEnumEntryList();
            LinkedHashMap r2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16));
            Iterator<T> r1 = r0.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            Object r3 = r1.next();
            r2.put(NameResolverUtilKt.getName(r6.getC().getNameResolver(), ((ProtoBuf$EnumEntry) r3).getName()), r3);
            goto L4
        L6:
            this.enumEntryProtos = r2;
            StorageManager r7 = this.this$0.getC().getStorageManager();
            final DeserializedClassDescriptor r4 = this.this$0;
            this.enumEntryByName = r7.createMemoizedFunctionWithNullableValues(new DeserializedClassDescriptor$EnumEntryClassDescriptors$$Lambda$0(this, r4));
            this.enumMemberNames = this.this$0.getC().getStorageManager().createLazyValue(new DeserializedClassDescriptor$EnumEntryClassDescriptors$$Lambda$1(this));
        }

        private static final Set enumMemberNames$lambda$4(EnumEntryClassDescriptors r1) {
            Intrinsics.checkNotNullParameter(r1, "this$0");
            return r1.computeEnumMemberNames();
        }

        public final ClassDescriptor findEnumEntry(Name r2) {
            Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
            return (ClassDescriptor) this.enumEntryByName.invoke(r2);
        }

        private static final List enumEntryByName$lambda$3$lambda$2$lambda$1(DeserializedClassDescriptor r1, ProtoBuf$EnumEntry r2) {
            Intrinsics.checkNotNullParameter(r1, "this$0");
            Intrinsics.checkNotNullParameter(r2, "$proto");
            return CollectionsKt.toList(r1.getC().getComponents().getAnnotationAndConstantLoader().loadEnumEntryAnnotations(r1.getThisAsProtoContainer$deserialization(), r2));
        }

        private static final ClassDescriptor enumEntryByName$lambda$3(EnumEntryClassDescriptors r8, DeserializedClassDescriptor r9, Name r10) {
            Intrinsics.checkNotNullParameter(r8, "this$0");
            Intrinsics.checkNotNullParameter(r9, "this$1");
            Intrinsics.checkNotNullParameter(r10, DBDefinition.NAME);
            ProtoBuf$EnumEntry r0 = r8.enumEntryProtos.get(r10);
            if (r0 != null) goto L7;
            return null;
        L7:
            return EnumEntrySyntheticClassDescriptor.create(r9.getC().getStorageManager(), r9, r10, r8.enumMemberNames, new DeserializedAnnotations(r9.getC().getStorageManager(), new DeserializedClassDescriptor$EnumEntryClassDescriptors$.Lambda.2(r9, r0)), SourceElement.NO_SOURCE);
        }
    }

    public static /* synthetic */ ClassConstructorDescriptor accessor$DeserializedClassDescriptor$lambda0(DeserializedClassDescriptor r0) {
        return primaryConstructor$lambda$0(r0);
    }

    public static /* synthetic */ Collection accessor$DeserializedClassDescriptor$lambda1(DeserializedClassDescriptor r0) {
        return constructors$lambda$1(r0);
    }

    public static /* synthetic */ ClassDescriptor accessor$DeserializedClassDescriptor$lambda2(DeserializedClassDescriptor r0) {
        return companionObjectDescriptor$lambda$2(r0);
    }

    public static /* synthetic */ Collection accessor$DeserializedClassDescriptor$lambda3(DeserializedClassDescriptor r0) {
        return sealedSubclasses$lambda$3(r0);
    }

    public static /* synthetic */ ValueClassRepresentation accessor$DeserializedClassDescriptor$lambda4(DeserializedClassDescriptor r0) {
        return valueClassRepresentation$lambda$4(r0);
    }

    public static /* synthetic */ List accessor$DeserializedClassDescriptor$lambda5(DeserializedClassDescriptor r0) {
        return annotations$lambda$5(r0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return false;
    }

    private final ClassDescriptor computeCompanionObjectDescriptor() {
        if (this.classProto.hasCompanionObjectName() == true) goto L5;
        return null;
    L5:
        Name r0 = NameResolverUtilKt.getName(this.c.getNameResolver(), this.classProto.getCompanionObjectName());
        ClassifierDescriptor r1 = getMemberScope().mo383getContributedClassifier(r0, NoLookupLocation.FROM_DESERIALIZATION);
        if ((r1 instanceof ClassDescriptor) == true) goto L8;
        return null;
    L8:
        return (ClassDescriptor) r1;
    }

    private final ClassConstructorDescriptor computePrimaryConstructor() {
        if (this.kind.isSingleton() == false) goto L6;
        ClassConstructorDescriptorImpl r0 = DescriptorFactory.createPrimaryConstructorForObject(this, SourceElement.NO_SOURCE);
        r0.setReturnType(getDefaultType());
        return r0;
    L6:
        Iterator<T> r1 = this.classProto.getConstructorList().iterator();
    L8:
        if (r1.hasNext() == false) goto L12;
        Object r2 = r1.next();
        if ((!Flags.IS_SECONDARY.get(((ProtoBuf$Constructor) r2).getFlags()).booleanValue()) == false) goto L8;
    L13:
        ProtoBuf$Constructor r3 = (ProtoBuf$Constructor) r2;
        if (r3 != null) goto L16;
        return null;
    L16:
        return this.c.getMemberDeserializer().loadConstructor(r3, true);
    L12:
        r2 = null;
        goto L13
    }

    private final List<ClassConstructorDescriptor> computeSecondaryConstructors() {
        List<ProtoBuf$Constructor> r0 = this.classProto.getConstructorList();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if (Flags.IS_SECONDARY.get(((ProtoBuf$Constructor) r3).getFlags()).booleanValue() == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r5 = r1.iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        ProtoBuf$Constructor r6 = (ProtoBuf$Constructor) r5.next();
        MemberDeserializer r7 = this.c.getMemberDeserializer();
        Intrinsics.checkNotNull(r6);
        r4.add(r7.loadConstructor(r6, false));
        goto L10
    L12:
        return r4;
    }

    private final Collection<ClassDescriptor> computeSubclassesForSealedClass() {
        if (this.modality != Modality.SEALED) goto L5;
        List<Integer> r0 = this.classProto.getSealedSubclassFqNameList();
        Intrinsics.checkNotNull(r0);
        if ((!r0.isEmpty()) == false) goto L16;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L10:
        if (r2.hasNext() == false) goto L14;
        Integer r3 = (Integer) r2.next();
        DeserializationComponents r4 = this.c.getComponents();
        NameResolver r5 = this.c.getNameResolver();
        Intrinsics.checkNotNull(r3);
        ClassDescriptor r6 = r4.deserializeClass(NameResolverUtilKt.getClassId(r5, r3.intValue()));
        if (r6 == null) goto L10;
        r1.add(r6);
        goto L10
    L14:
        return r1;
    L16:
        return CliSealedClassInheritorsProvider.INSTANCE.computeSealedSubclasses(this, false);
    L5:
        return CollectionsKt.emptyList();
    }

    private final DeserializedClassMemberScope getMemberScope() {
        return (DeserializedClassMemberScope) this.memberScopeHolder.getScope(this.c.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public ClassDescriptor getCompanionObjectDescriptor() {
        return (ClassDescriptor) this.companionObjectDescriptor.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public Collection<ClassConstructorDescriptor> getConstructors() {
        return (Collection) this.constructors.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public List<ReceiverParameterDescriptor> getContextReceivers() {
        List<ProtoBuf$Type> r0 = ProtoTypeTableUtilKt.contextReceiverTypes(this.classProto, this.c.getTypeTable());
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        ProtoBuf$Type r3 = (ProtoBuf$Type) r2.next();
        KotlinType r4 = this.c.getTypeDeserializer().type(r3);
        r1.add(new ReceiverParameterDescriptorImpl(getThisAsReceiverParameter(), new ContextClassReceiver(this, r4, null, null), Annotations.Companion.getEMPTY()));
        goto L4
    L6:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        return this.c.getTypeDeserializer().getOwnTypeParameters();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public Collection<ClassDescriptor> getSealedSubclasses() {
        return (Collection) this.sealedSubclasses.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return (ClassConstructorDescriptor) this.primaryConstructor.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public ValueClassRepresentation<SimpleType> getValueClassRepresentation() {
        return (ValueClassRepresentation) this.valueClassRepresentation.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isCompanionObject() {
        if (Flags.CLASS_KIND.get(this.classProto.getFlags()) != ProtoBuf$Class.Kind.COMPANION_OBJECT) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isData() {
        return Flags.IS_DATA.get(this.classProto.getFlags()).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        return Flags.IS_EXPECT_CLASS.get(this.classProto.getFlags()).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        return Flags.IS_EXTERNAL_CLASS.get(this.classProto.getFlags()).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isFun() {
        return Flags.IS_FUN_INTERFACE.get(this.classProto.getFlags()).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isInline() {
        if (Flags.IS_VALUE_CLASS.get(this.classProto.getFlags()).booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.metadataVersion.isAtMost(1, 4, 1) == false) goto L7;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        return Flags.IS_INNER.get(this.classProto.getFlags()).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isValue() {
        if (Flags.IS_VALUE_CLASS.get(this.classProto.getFlags()).booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.metadataVersion.isAtLeast(1, 4, 2) == false) goto L7;
        return true;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("deserialized ");
        if (isExpect() == false) goto L5;
        String r1 = "expect ";
    L6:
        r0.append(r1);
        r0.append("class ");
        r0.append(getName());
        return r0.toString();
    L5:
        r1 = "";
        goto L6
    }

    private final Collection<ClassConstructorDescriptor> computeConstructors() {
        return CollectionsKt.plus(CollectionsKt.plus(computeSecondaryConstructors(), CollectionsKt.listOfNotNull(getUnsubstitutedPrimaryConstructor())), this.c.getComponents().getAdditionalClassPartsProvider().getConstructors(this));
    }

    private final ValueClassRepresentation<SimpleType> computeValueClassRepresentation() {
        if (isInline() == false) goto L5;
    L7:
        ValueClassRepresentation<SimpleType> r0 = ValueClassUtilKt.loadValueClassRepresentation(this.classProto, this.c.getNameResolver(), this.c.getTypeTable(), new computeValueClassRepresentation.1(this.c.getTypeDeserializer()), new computeValueClassRepresentation.2(this));
        if (r0 == null) goto L11;
        return r0;
    L11:
        if (this.metadataVersion.isAtLeast(1, 5, 1) == true) goto L22;
        ClassConstructorDescriptor r1 = getUnsubstitutedPrimaryConstructor();
        if (r1 == null) goto L21;
        Name r2 = ((ValueParameterDescriptor) CollectionsKt.first(r1.getValueParameters())).getName();
        SimpleType r3 = getValueClassPropertyType(r2);
        if (r3 == null) goto L19;
        return new InlineClassRepresentation(r2, r3);
    L19:
        throw new IllegalStateException(("Value class has no underlying property: " + this).toString());
    L21:
        throw new IllegalStateException(("Inline class has no primary constructor: " + this).toString());
    L22:
        return null;
    L5:
        if (isValue() == true) goto L7;
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public /* bridge */ /* synthetic */ MemberScope getStaticScope() {
        return getStaticScope();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        return this.annotations;
    }

    public final DeserializationContext getC() {
        return this.c;
    }

    public final ProtoBuf$Class getClassProto() {
        return this.classProto;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public DeclarationDescriptor getContainingDeclaration() {
        return this.containingDeclaration;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public ClassKind getKind() {
        return this.kind;
    }

    public final BinaryVersion getMetadataVersion() {
        return this.metadataVersion;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public Modality getModality() {
        return this.modality;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    public SourceElement getSource() {
        return this.sourceElement;
    }

    public final ProtoContainer.Class getThisAsProtoContainer$deserialization() {
        return this.thisAsProtoContainer;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public TypeConstructor getTypeConstructor() {
        return this.typeConstructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility
    public DescriptorVisibility getVisibility() {
        return this.visibility;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public MemberScopeImpl getStaticScope() {
        return this.staticScope;
    }

    public static final /* synthetic */ ClassId access$getClassId$p(DeserializedClassDescriptor r0) {
        return r0.classId;
    }

    public static final /* synthetic */ EnumEntryClassDescriptors access$getEnumEntries$p(DeserializedClassDescriptor r0) {
        return r0.enumEntries;
    }

    public static final /* synthetic */ DeserializedClassTypeConstructor access$getTypeConstructor$p(DeserializedClassDescriptor r0) {
        return r0.typeConstructor;
    }

    private static final List annotations$lambda$5(DeserializedClassDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return CollectionsKt.toList(r1.c.getComponents().getAnnotationAndConstantLoader().loadClassAnnotations(r1.thisAsProtoContainer));
    }

    private static final ClassDescriptor companionObjectDescriptor$lambda$2(DeserializedClassDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return r1.computeCompanionObjectDescriptor();
    }

    private static final Collection constructors$lambda$1(DeserializedClassDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return r1.computeConstructors();
    }

    private final SimpleType getValueClassPropertyType(Name r8) {
        Iterator<T> r9 = getMemberScope().getContributedVariables(r8, NoLookupLocation.FROM_DESERIALIZATION).iterator();
        KotlinType r0 = null;
        Object r3 = null;
        boolean r2 = false;
    L4:
        if (r9.hasNext() == false) goto L13;
        Object r4 = r9.next();
        if (((PropertyDescriptor) r4).getExtensionReceiverParameter() != null) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == false) goto L4;
        if (r2 == true) goto L14;
        r3 = r4;
        r2 = true;
    L14:
        r3 = null;
    L15:
        PropertyDescriptor r6 = (PropertyDescriptor) r3;
        if (r6 == null) goto L19;
        r0 = r6.getType();
    L19:
        return (SimpleType) r0;
    L8:
        r5 = false;
        goto L9
    L13:
        if (r2 == true) goto L15;
        goto L14
    }

    private static final ClassConstructorDescriptor primaryConstructor$lambda$0(DeserializedClassDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return r1.computePrimaryConstructor();
    }

    private static final Collection sealedSubclasses$lambda$3(DeserializedClassDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return r1.computeSubclassesForSealedClass();
    }

    private static final ValueClassRepresentation valueClassRepresentation$lambda$4(DeserializedClassDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return r1.computeValueClassRepresentation();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    public MemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner r2) {
        Intrinsics.checkNotNullParameter(r2, "kotlinTypeRefiner");
        return this.memberScopeHolder.getScope(r2);
    }

    public final boolean hasNestedClass$deserialization(Name r2) {
        Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
        return getMemberScope().getClassNames$deserialization().contains(r2);
    }

    public static final /* synthetic */ SimpleType access$getValueClassPropertyType(DeserializedClassDescriptor r0, Name r1) {
        return r0.getValueClassPropertyType(r1);
    }

    public DeserializedClassDescriptor(DeserializationContext r9, ProtoBuf$Class r10, NameResolver r11, BinaryVersion r12, SourceElement r13) {
        Intrinsics.checkNotNullParameter(r9, "outerContext");
        Intrinsics.checkNotNullParameter(r10, "classProto");
        Intrinsics.checkNotNullParameter(r11, "nameResolver");
        Intrinsics.checkNotNullParameter(r12, "metadataVersion");
        Intrinsics.checkNotNullParameter(r13, "sourceElement");
        super(r9.getStorageManager(), NameResolverUtilKt.getClassId(r11, r10.getFqName()).getShortClassName());
        this.classProto = r10;
        this.metadataVersion = r12;
        this.sourceElement = r13;
        this.classId = NameResolverUtilKt.getClassId(r11, r10.getFqName());
        ProtoEnumFlags r0 = ProtoEnumFlags.INSTANCE;
        this.modality = r0.modality(Flags.MODALITY.get(r10.getFlags()));
        this.visibility = ProtoEnumFlagsUtilsKt.descriptorVisibility(r0, Flags.VISIBILITY.get(r10.getFlags()));
        ClassKind r1 = r0.classKind(Flags.CLASS_KIND.get(r10.getFlags()));
        this.kind = r1;
        DeserializationContext r14 = r9.childContext(this, r10.getTypeParameterList(), r11, new TypeTable(r10.getTypeTable()), VersionRequirementTable.Companion.create(r10.getVersionRequirementTable()), r12);
        this.c = r14;
        boolean r15 = Flags.HAS_ENUM_ENTRIES.get(r10.getFlags()).booleanValue();
        this.hasEnumEntriesMetadataFlag = r15;
        ClassKind r2 = ClassKind.ENUM_CLASS;
        if (r1 != r2) goto L11;
        if (r15 == false) goto L6;
    L9:
        boolean r16 = true;
    L10:
        MemberScopeImpl r3 = new StaticScopeForKotlinEnum(r14.getStorageManager(), this, r16);
    L12:
        this.staticScope = r3;
        this.typeConstructor = new DeserializedClassTypeConstructor(this);
        this.memberScopeHolder = ScopesHolderForClass.Companion.create(this, r14.getStorageManager(), r14.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner(), new DeserializedClassDescriptor$memberScopeHolder$1(this));
        ProtoContainer.Class r17 = null;
        if (r1 != r2) goto L15;
        EnumEntryClassDescriptors r4 = new EnumEntryClassDescriptors(this);
    L16:
        this.enumEntries = r4;
        DeclarationDescriptor r18 = r9.getContainingDeclaration();
        this.containingDeclaration = r18;
        this.primaryConstructor = r14.getStorageManager().createNullableLazyValue(new DeserializedClassDescriptor$$Lambda$0(this));
        this.constructors = r14.getStorageManager().createLazyValue(new DeserializedClassDescriptor$$Lambda$1(this));
        this.companionObjectDescriptor = r14.getStorageManager().createNullableLazyValue(new DeserializedClassDescriptor$$Lambda$2(this));
        this.sealedSubclasses = r14.getStorageManager().createLazyValue(new DeserializedClassDescriptor$$Lambda$3(this));
        this.valueClassRepresentation = r14.getStorageManager().createNullableLazyValue(new DeserializedClassDescriptor$$Lambda$4(this));
        NameResolver r5 = r14.getNameResolver();
        TypeTable r6 = r14.getTypeTable();
        if ((r18 instanceof DeserializedClassDescriptor) == false) goto L19;
        DeserializedClassDescriptor r19 = (DeserializedClassDescriptor) r18;
    L20:
        if (r19 == null) goto L22;
        r17 = r19.thisAsProtoContainer;
    L22:
        this.thisAsProtoContainer = new ProtoContainer.Class(r10, r5, r6, r13, r17);
        if (Flags.HAS_ANNOTATIONS.get(r10.getFlags()).booleanValue() == true) goto L25;
        Annotations r20 = Annotations.Companion.getEMPTY();
    L26:
        this.annotations = r20;
        return;
    L25:
        r20 = new NonEmptyDeserializedAnnotations(r14.getStorageManager(), new DeserializedClassDescriptor$.Lambda.5(this));
        goto L26
    L19:
        r19 = null;
        goto L20
    L15:
        r4 = null;
        goto L16
    L6:
        if (Intrinsics.areEqual(r14.getComponents().getEnumEntriesDeserializationSupport().canSynthesizeEnumEntries(), Boolean.TRUE) == true) goto L9;
        r16 = false;
        goto L10
    L11:
        r3 = MemberScope.Empty.INSTANCE;
        goto L12
    }
}
