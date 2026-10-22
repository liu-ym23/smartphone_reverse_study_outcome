package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
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
import kotlin.reflect.jvm.internal.impl.descriptors.MultiFieldValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ReceiverParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.UtilsKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
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
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: loaded from: classes3.dex */
public final class DeserializedClassDescriptor extends AbstractClassDescriptor implements DeserializedDescriptor {
    private final Annotations annotations;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DeserializationContext f10220c;
    private final ClassId classId;
    private final ProtoBuf.Class classProto;
    private final NullableLazyValue<ClassDescriptor> companionObjectDescriptor;
    private final NotNullLazyValue<Collection<ClassConstructorDescriptor>> constructors;
    private final DeclarationDescriptor containingDeclaration;
    private final EnumEntryClassDescriptors enumEntries;
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

    private final class DeserializedClassMemberScope extends DeserializedMemberScope {
        private final NotNullLazyValue<Collection<DeclarationDescriptor>> allDescriptors;
        private final KotlinTypeRefiner kotlinTypeRefiner;
        private final NotNullLazyValue<Collection<KotlinType>> refinedSupertypes;
        final /* synthetic */ DeserializedClassDescriptor this$0;

        public DeserializedClassMemberScope(DeserializedClassDescriptor r10, KotlinTypeRefiner r11) {
            Intrinsics.checkNotNullParameter(r11, "kotlinTypeRefiner");
            this.this$0 = r10;
            DeserializationContext r12 = r10.getC();
            List<ProtoBuf.Function> r13 = r10.getClassProto().getFunctionList();
            Intrinsics.checkNotNullExpressionValue(r13, "classProto.functionList");
            List<ProtoBuf.Property> r14 = r10.getClassProto().getPropertyList();
            Intrinsics.checkNotNullExpressionValue(r14, "classProto.propertyList");
            List<ProtoBuf.TypeAlias> r15 = r10.getClassProto().getTypeAliasList();
            Intrinsics.checkNotNullExpressionValue(r15, "classProto.typeAliasList");
            List<Integer> r16 = r10.getClassProto().getNestedClassNameList();
            Intrinsics.checkNotNullExpressionValue(r16, "classProto.nestedClassNameList");
            NameResolver r17 = r10.getC().getNameResolver();
            final ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
            Iterator<T> r19 = r16.iterator();
        L4:
            if (r19.hasNext() == false) goto L6;
            r18.add(NameResolverUtilKt.getName(r17, ((Number) r19.next()).intValue()));
            goto L4
        L6:
            super(r12, r13, r14, r15, new DeserializedClassDescriptor$DeserializedClassMemberScope$2$1(r18));
            this.kotlinTypeRefiner = r11;
            this.allDescriptors = getC().getStorageManager().createLazyValue(new DeserializedClassDescriptor$DeserializedClassMemberScope$allDescriptors$1(this));
            this.refinedSupertypes = getC().getStorageManager().createLazyValue(new DeserializedClassDescriptor$DeserializedClassMemberScope$refinedSupertypes$1(this));
        }

        public static final /* synthetic */ DeserializedClassDescriptor access$getClassDescriptor(DeserializedClassMemberScope r10) {
            return r10.getClassDescriptor();
        }

        public static final /* synthetic */ KotlinTypeRefiner access$getKotlinTypeRefiner$p(DeserializedClassMemberScope r10) {
            return r10.kotlinTypeRefiner;
        }

        private final <D extends CallableMemberDescriptor> void generateFakeOverrides(Name r10, Collection<? extends D> r11, final List<D> r12) {
            ArrayList r13 = new ArrayList(r12);
            getC().getComponents().getKotlinTypeChecker().getOverridingUtil().generateOverridesInFunctionGroup(r10, r11, r13, getClassDescriptor(), new DeserializedClassDescriptor$DeserializedClassMemberScope$generateFakeOverrides$1(r12));
        }

        private final DeserializedClassDescriptor getClassDescriptor() {
            return this.this$0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        protected void addEnumEntryDescriptors(Collection<DeclarationDescriptor> r10, Function1<? super Name, Boolean> r11) {
            Intrinsics.checkNotNullParameter(r10, "result");
            Intrinsics.checkNotNullParameter(r11, "nameFilter");
            EnumEntryClassDescriptors r12 = DeserializedClassDescriptor.access$getEnumEntries$p(getClassDescriptor());
            if (r12 == null) goto L5;
            Collection<ClassDescriptor> r13 = r12.all();
        L6:
            if (r13 != null) goto L8;
            r13 = CollectionsKt.emptyList();
        L8:
            r10.addAll(r13);
            return;
        L5:
            r13 = null;
            goto L6
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        protected void computeNonDeclaredFunctions(Name r10, List<SimpleFunctionDescriptor> r11) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r11, "functions");
            ArrayList r12 = new ArrayList();
            Iterator<KotlinType> r13 = this.refinedSupertypes.invoke().iterator();
        L4:
            if (r13.hasNext() == false) goto L6;
            r12.addAll(r13.next().getMemberScope().getContributedFunctions(r10, NoLookupLocation.FOR_ALREADY_TRACKED));
            goto L4
        L6:
            r11.addAll(getC().getComponents().getAdditionalClassPartsProvider().getFunctions(r10, this.this$0));
            generateFakeOverrides(r10, r12, r11);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        protected void computeNonDeclaredProperties(Name r10, List<PropertyDescriptor> r11) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r11, "descriptors");
            ArrayList r12 = new ArrayList();
            Iterator<KotlinType> r13 = this.refinedSupertypes.invoke().iterator();
        L4:
            if (r13.hasNext() == false) goto L6;
            r12.addAll(r13.next().getMemberScope().getContributedVariables(r10, NoLookupLocation.FOR_ALREADY_TRACKED));
            goto L4
        L6:
            generateFakeOverrides(r10, r12, r11);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        protected ClassId createClassId(Name r10) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            ClassId r11 = DeserializedClassDescriptor.access$getClassId$p(this.this$0).createNestedClassId(r10);
            Intrinsics.checkNotNullExpressionValue(r11, "classId.createNestedClassId(name)");
            return r11;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        /* JADX INFO: renamed from: getContributedClassifier */
        public ClassifierDescriptor mo1325getContributedClassifier(Name r10, LookupLocation r11) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r11, "location");
            mo1329recordLookup(r10, r11);
            EnumEntryClassDescriptors r12 = DeserializedClassDescriptor.access$getEnumEntries$p(getClassDescriptor());
            if (r12 == null) goto L8;
            ClassDescriptor r13 = r12.findEnumEntry(r10);
            if (r13 == null) goto L8;
            return r13;
        L8:
            return super.mo1325getContributedClassifier(r10, r11);
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r10, Function1<? super Name, Boolean> r11) {
            Intrinsics.checkNotNullParameter(r10, "kindFilter");
            Intrinsics.checkNotNullParameter(r11, "nameFilter");
            return this.allDescriptors.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name r10, LookupLocation r11) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r11, "location");
            mo1329recordLookup(r10, r11);
            return super.getContributedFunctions(r10, r11);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        public Collection<PropertyDescriptor> getContributedVariables(Name r10, LookupLocation r11) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r11, "location");
            mo1329recordLookup(r10, r11);
            return super.getContributedVariables(r10, r11);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        protected Set<Name> getNonDeclaredClassifierNames() {
            List<KotlinType> r10 = DeserializedClassDescriptor.access$getTypeConstructor$p(getClassDescriptor()).mo1324getSupertypes();
            LinkedHashSet r11 = new LinkedHashSet();
            Iterator<T> r12 = r10.iterator();
        L4:
            if (r12.hasNext() == false) goto L12;
            Set<Name> r13 = ((KotlinType) r12.next()).getMemberScope().getClassifierNames();
            if (r13 == null) goto L7;
            CollectionsKt.addAll(r11, r13);
            goto L4
        L7:
            return null;
        L12:
            return r11;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        protected Set<Name> getNonDeclaredFunctionNames() {
            List<KotlinType> r10 = DeserializedClassDescriptor.access$getTypeConstructor$p(getClassDescriptor()).mo1324getSupertypes();
            LinkedHashSet r11 = new LinkedHashSet();
            Iterator<T> r12 = r10.iterator();
        L4:
            if (r12.hasNext() == false) goto L6;
            CollectionsKt.addAll(r11, ((KotlinType) r12.next()).getMemberScope().getFunctionNames());
            goto L4
        L6:
            DeserializedClassDescriptor r13 = this.this$0;
            r11.addAll(getC().getComponents().getAdditionalClassPartsProvider().getFunctionsNames(r13));
            return r11;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        protected Set<Name> getNonDeclaredVariableNames() {
            List<KotlinType> r10 = DeserializedClassDescriptor.access$getTypeConstructor$p(getClassDescriptor()).mo1324getSupertypes();
            LinkedHashSet r11 = new LinkedHashSet();
            Iterator<T> r12 = r10.iterator();
        L4:
            if (r12.hasNext() == false) goto L6;
            CollectionsKt.addAll(r11, ((KotlinType) r12.next()).getMemberScope().getVariableNames());
            goto L4
        L6:
            return r11;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        protected boolean isDeclaredFunctionAvailable(SimpleFunctionDescriptor r10) {
            Intrinsics.checkNotNullParameter(r10, "function");
            return getC().getComponents().getPlatformDependentDeclarationFilter().isFunctionAvailable(this.this$0, r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        /* JADX INFO: renamed from: recordLookup */
        public void mo1329recordLookup(Name r10, LookupLocation r11) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r11, "location");
            UtilsKt.record(getC().getComponents().getLookupTracker(), r11, getClassDescriptor(), r10);
        }
    }

    private final class DeserializedClassTypeConstructor extends AbstractClassTypeConstructor {
        private final NotNullLazyValue<List<TypeParameterDescriptor>> parameters;
        final /* synthetic */ DeserializedClassDescriptor this$0;

        public DeserializedClassTypeConstructor(final DeserializedClassDescriptor r10) {
            this.this$0 = r10;
            super(r10.getC().getStorageManager());
            this.parameters = r10.getC().getStorageManager().createLazyValue(new DeserializedClassDescriptor$DeserializedClassTypeConstructor$parameters$1(r10));
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        protected Collection<KotlinType> computeSupertypes() {
            List<ProtoBuf.Type> r10 = ProtoTypeTableUtilKt.supertypes(this.this$0.getClassProto(), this.this$0.getC().getTypeTable());
            DeserializedClassDescriptor r11 = this.this$0;
            ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
            Iterator<T> r13 = r10.iterator();
        L4:
            if (r13.hasNext() == false) goto L6;
            r12.add(r11.getC().getTypeDeserializer().type((ProtoBuf.Type) r13.next()));
            goto L4
        L6:
            List r14 = CollectionsKt.plus(r12, this.this$0.getC().getComponents().getAdditionalClassPartsProvider().getSupertypes(this.this$0));
            ArrayList r15 = new ArrayList();
            Iterator r16 = r14.iterator();
        L8:
            if (r16.hasNext() == false) goto L16;
            ClassifierDescriptor r17 = ((KotlinType) r16.next()).getConstructor().mo1323getDeclarationDescriptor();
            if ((r17 instanceof NotFoundClasses.MockClassDescriptor) == false) goto L12;
            NotFoundClasses.MockClassDescriptor r18 = (NotFoundClasses.MockClassDescriptor) r17;
        L13:
            if (r18 == null) goto L8;
            r15.add(r18);
            goto L8
        L12:
            r18 = null;
            goto L13
        L16:
            if ((!r15.isEmpty()) == false) goto L30;
            ErrorReporter r19 = this.this$0.getC().getComponents().getErrorReporter();
            DeserializedClassDescriptor r20 = this.this$0;
            ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
            Iterator r22 = r15.iterator();
        L19:
            if (r22.hasNext() == false) goto L28;
            NotFoundClasses.MockClassDescriptor r23 = (NotFoundClasses.MockClassDescriptor) r22.next();
            ClassId r24 = DescriptorUtilsKt.getClassId(r23);
            if (r24 == null) goto L26;
            FqName r25 = r24.asSingleFqName();
            if (r25 == null) goto L26;
            String r26 = r25.asString();
            if (r26 == null) goto L26;
        L27:
            r21.add(r26);
        L26:
            r26 = r23.getName().asString();
            goto L27
        L28:
            r19.reportIncompleteHierarchy(r20, r21);
        L30:
            return CollectionsKt.toList(r14);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor, kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* JADX INFO: renamed from: getDeclarationDescriptor */
        public /* bridge */ /* synthetic */ ClassDescriptor mo1323getDeclarationDescriptor() {
            return mo1323getDeclarationDescriptor();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor, kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* JADX INFO: renamed from: getDeclarationDescriptor */
        public /* bridge */ /* synthetic */ ClassifierDescriptor mo1323getDeclarationDescriptor() {
            return mo1323getDeclarationDescriptor();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor, kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* JADX INFO: renamed from: getDeclarationDescriptor */
        public DeserializedClassDescriptor mo1323getDeclarationDescriptor() {
            return this.this$0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public List<TypeParameterDescriptor> getParameters() {
            return this.parameters.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        protected SupertypeLoopChecker getSupertypeLoopChecker() {
            return SupertypeLoopChecker.EMPTY.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return true;
        }

        public String toString() {
            String r10 = this.this$0.getName().toString();
            Intrinsics.checkNotNullExpressionValue(r10, "name.toString()");
            return r10;
        }
    }

    private final class EnumEntryClassDescriptors {
        private final MemoizedFunctionToNullable<Name, ClassDescriptor> enumEntryByName;
        private final Map<Name, ProtoBuf.EnumEntry> enumEntryProtos;
        private final NotNullLazyValue<Set<Name>> enumMemberNames;
        final /* synthetic */ DeserializedClassDescriptor this$0;

        public EnumEntryClassDescriptors(DeserializedClassDescriptor r10) {
            this.this$0 = r10;
            List<ProtoBuf.EnumEntry> r11 = r10.getClassProto().getEnumEntryList();
            Intrinsics.checkNotNullExpressionValue(r11, "classProto.enumEntryList");
            LinkedHashMap r12 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r11, 10)), 16));
            Iterator<T> r13 = r11.iterator();
        L4:
            if (r13.hasNext() == false) goto L6;
            Object r14 = r13.next();
            r12.put(NameResolverUtilKt.getName(r10.getC().getNameResolver(), ((ProtoBuf.EnumEntry) r14).getName()), r14);
            goto L4
        L6:
            this.enumEntryProtos = r12;
            StorageManager r15 = this.this$0.getC().getStorageManager();
            final DeserializedClassDescriptor r16 = this.this$0;
            this.enumEntryByName = r15.createMemoizedFunctionWithNullableValues(new DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1(this, r16));
            this.enumMemberNames = this.this$0.getC().getStorageManager().createLazyValue(new DeserializedClassDescriptor$EnumEntryClassDescriptors$enumMemberNames$1(this));
        }

        public static final /* synthetic */ Set access$computeEnumMemberNames(EnumEntryClassDescriptors r10) {
            return r10.computeEnumMemberNames();
        }

        public static final /* synthetic */ Map access$getEnumEntryProtos$p(EnumEntryClassDescriptors r10) {
            return r10.enumEntryProtos;
        }

        public static final /* synthetic */ NotNullLazyValue access$getEnumMemberNames$p(EnumEntryClassDescriptors r10) {
            return r10.enumMemberNames;
        }

        private final Set<Name> computeEnumMemberNames() {
            HashSet r10 = new HashSet();
            Iterator<KotlinType> r11 = this.this$0.getTypeConstructor().mo1324getSupertypes().iterator();
        L4:
            if (r11.hasNext() == false) goto L13;
            Iterator r12 = ResolutionScope.DefaultImpls.getContributedDescriptors$default(r11.next().getMemberScope(), null, null, 3, null).iterator();
        L7:
            if (r12.hasNext() == false) goto L4;
            DeclarationDescriptor r13 = (DeclarationDescriptor) r12.next();
            if ((r13 instanceof SimpleFunctionDescriptor) == true) goto L12;
            if ((r13 instanceof PropertyDescriptor) == false) goto L7;
        L12:
            r10.add(r13.getName());
            goto L7
        L13:
            List<ProtoBuf.Function> r14 = this.this$0.getClassProto().getFunctionList();
            Intrinsics.checkNotNullExpressionValue(r14, "classProto.functionList");
            DeserializedClassDescriptor r15 = this.this$0;
            Iterator<T> r16 = r14.iterator();
        L15:
            if (r16.hasNext() == false) goto L17;
            ProtoBuf.Function r17 = (ProtoBuf.Function) r16.next();
            r10.add(NameResolverUtilKt.getName(r15.getC().getNameResolver(), r17.getName()));
            goto L15
        L17:
            List<ProtoBuf.Property> r18 = this.this$0.getClassProto().getPropertyList();
            Intrinsics.checkNotNullExpressionValue(r18, "classProto.propertyList");
            DeserializedClassDescriptor r19 = this.this$0;
            Iterator<T> r20 = r18.iterator();
        L19:
            if (r20.hasNext() == false) goto L22;
            ProtoBuf.Property r21 = (ProtoBuf.Property) r20.next();
            r10.add(NameResolverUtilKt.getName(r19.getC().getNameResolver(), r21.getName()));
            goto L19
        L22:
            return SetsKt.plus(r10, r10);
        }

        public final Collection<ClassDescriptor> all() {
            Set<Name> r10 = this.enumEntryProtos.keySet();
            ArrayList r11 = new ArrayList();
            Iterator<T> r12 = r10.iterator();
        L4:
            if (r12.hasNext() == false) goto L8;
            ClassDescriptor r13 = findEnumEntry((Name) r12.next());
            if (r13 == null) goto L4;
            r11.add(r13);
            goto L4
        L8:
            return r11;
        }

        public final ClassDescriptor findEnumEntry(Name r10) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            return this.enumEntryByName.invoke(r10);
        }
    }

    public DeserializedClassDescriptor(DeserializationContext r10, ProtoBuf.Class r11, NameResolver r12, BinaryVersion r13, SourceElement r14) {
        Intrinsics.checkNotNullParameter(r10, "outerContext");
        Intrinsics.checkNotNullParameter(r11, "classProto");
        Intrinsics.checkNotNullParameter(r12, "nameResolver");
        Intrinsics.checkNotNullParameter(r13, "metadataVersion");
        Intrinsics.checkNotNullParameter(r14, "sourceElement");
        super(r10.getStorageManager(), NameResolverUtilKt.getClassId(r12, r11.getFqName()).getShortClassName());
        this.classProto = r11;
        this.metadataVersion = r13;
        this.sourceElement = r14;
        this.classId = NameResolverUtilKt.getClassId(r12, r11.getFqName());
        ProtoEnumFlags r15 = ProtoEnumFlags.INSTANCE;
        this.modality = r15.modality(Flags.MODALITY.get(r11.getFlags()));
        this.visibility = ProtoEnumFlagsUtilsKt.descriptorVisibility(r15, Flags.VISIBILITY.get(r11.getFlags()));
        ClassKind r16 = r15.classKind(Flags.CLASS_KIND.get(r11.getFlags()));
        this.kind = r16;
        List<ProtoBuf.TypeParameter> r17 = r11.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(r17, "classProto.typeParameterList");
        ProtoBuf.TypeTable r18 = r11.getTypeTable();
        Intrinsics.checkNotNullExpressionValue(r18, "classProto.typeTable");
        TypeTable r19 = new TypeTable(r18);
        VersionRequirementTable.Companion r20 = VersionRequirementTable.Companion;
        ProtoBuf.VersionRequirementTable r21 = r11.getVersionRequirementTable();
        Intrinsics.checkNotNullExpressionValue(r21, "classProto.versionRequirementTable");
        DeserializationContext r110 = r10.childContext(this, r17, r12, r19, r20.create(r21), r13);
        this.f10220c = r110;
        ClassKind r111 = ClassKind.ENUM_CLASS;
        if (r16 != r111) goto L5;
        MemberScopeImpl r22 = new StaticScopeForKotlinEnum(r110.getStorageManager(), this);
    L6:
        this.staticScope = r22;
        this.typeConstructor = new DeserializedClassTypeConstructor(this);
        this.memberScopeHolder = ScopesHolderForClass.Companion.create(this, r110.getStorageManager(), r110.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner(), new DeserializedClassDescriptor$memberScopeHolder$1(this));
        ProtoContainer.Class r23 = null;
        if (r16 != r111) goto L9;
        EnumEntryClassDescriptors r112 = new EnumEntryClassDescriptors(this);
    L10:
        this.enumEntries = r112;
        DeclarationDescriptor r24 = r10.getContainingDeclaration();
        this.containingDeclaration = r24;
        this.primaryConstructor = r110.getStorageManager().createNullableLazyValue(new DeserializedClassDescriptor$primaryConstructor$1(this));
        this.constructors = r110.getStorageManager().createLazyValue(new DeserializedClassDescriptor$constructors$1(this));
        this.companionObjectDescriptor = r110.getStorageManager().createNullableLazyValue(new DeserializedClassDescriptor$companionObjectDescriptor$1(this));
        this.sealedSubclasses = r110.getStorageManager().createLazyValue(new DeserializedClassDescriptor$sealedSubclasses$1(this));
        this.valueClassRepresentation = r110.getStorageManager().createNullableLazyValue(new DeserializedClassDescriptor$valueClassRepresentation$1(this));
        NameResolver r25 = r110.getNameResolver();
        TypeTable r26 = r110.getTypeTable();
        if ((r24 instanceof DeserializedClassDescriptor) == false) goto L13;
        DeserializedClassDescriptor r27 = (DeserializedClassDescriptor) r24;
    L14:
        if (r27 == null) goto L16;
        r23 = r27.thisAsProtoContainer;
    L16:
        this.thisAsProtoContainer = new ProtoContainer.Class(r11, r25, r26, r14, r23);
        if (Flags.HAS_ANNOTATIONS.get(r11.getFlags()).booleanValue() == true) goto L19;
        Annotations r28 = Annotations.Companion.getEMPTY();
    L20:
        this.annotations = r28;
        return;
    L19:
        r28 = new NonEmptyDeserializedAnnotations(r110.getStorageManager(), new DeserializedClassDescriptor$annotations$1(this));
        goto L20
    L13:
        r27 = null;
        goto L14
    L9:
        r112 = null;
        goto L10
    L5:
        r22 = MemberScope.Empty.INSTANCE;
        goto L6
    }

    public static final /* synthetic */ ClassDescriptor access$computeCompanionObjectDescriptor(DeserializedClassDescriptor r10) {
        return r10.computeCompanionObjectDescriptor();
    }

    public static final /* synthetic */ Collection access$computeConstructors(DeserializedClassDescriptor r10) {
        return r10.computeConstructors();
    }

    public static final /* synthetic */ ClassConstructorDescriptor access$computePrimaryConstructor(DeserializedClassDescriptor r10) {
        return r10.computePrimaryConstructor();
    }

    public static final /* synthetic */ Collection access$computeSubclassesForSealedClass(DeserializedClassDescriptor r10) {
        return r10.computeSubclassesForSealedClass();
    }

    public static final /* synthetic */ ValueClassRepresentation access$computeValueClassRepresentation(DeserializedClassDescriptor r10) {
        return r10.computeValueClassRepresentation();
    }

    public static final /* synthetic */ ClassId access$getClassId$p(DeserializedClassDescriptor r10) {
        return r10.classId;
    }

    public static final /* synthetic */ EnumEntryClassDescriptors access$getEnumEntries$p(DeserializedClassDescriptor r10) {
        return r10.enumEntries;
    }

    public static final /* synthetic */ DeserializedClassTypeConstructor access$getTypeConstructor$p(DeserializedClassDescriptor r10) {
        return r10.typeConstructor;
    }

    private final ClassDescriptor computeCompanionObjectDescriptor() {
        if (this.classProto.hasCompanionObjectName() == true) goto L5;
        return null;
    L5:
        Name r10 = NameResolverUtilKt.getName(this.f10220c.getNameResolver(), this.classProto.getCompanionObjectName());
        ClassifierDescriptor r11 = getMemberScope().mo1325getContributedClassifier(r10, NoLookupLocation.FROM_DESERIALIZATION);
        if ((r11 instanceof ClassDescriptor) == true) goto L8;
        return null;
    L8:
        return (ClassDescriptor) r11;
    }

    private final Collection<ClassConstructorDescriptor> computeConstructors() {
        return CollectionsKt.plus(CollectionsKt.plus(computeSecondaryConstructors(), CollectionsKt.listOfNotNull(mo1317getUnsubstitutedPrimaryConstructor())), this.f10220c.getComponents().getAdditionalClassPartsProvider().getConstructors(this));
    }

    private final InlineClassRepresentation<SimpleType> computeInlineClassRepresentation() {
        Object r10 = null;
        if (isInline() == true) goto L8;
        if (isValue() == true) goto L8;
        return null;
    L8:
        if (isValue() == false) goto L19;
        if (this.classProto.hasInlineClassUnderlyingPropertyName() == true) goto L19;
        if (this.classProto.hasInlineClassUnderlyingType() == true) goto L19;
        if (this.classProto.hasInlineClassUnderlyingTypeId() == true) goto L19;
        if (this.classProto.getMultiFieldValueClassUnderlyingNameCount() <= 0) goto L19;
        return null;
    L19:
        if (this.classProto.hasInlineClassUnderlyingPropertyName() == false) goto L22;
        Name r11 = NameResolverUtilKt.getName(this.f10220c.getNameResolver(), this.classProto.getInlineClassUnderlyingPropertyName());
    L26:
        ProtoBuf.Type r12 = ProtoTypeTableUtilKt.inlineClassUnderlyingType(this.classProto, this.f10220c.getTypeTable());
        if (r12 == null) goto L30;
        SimpleType r13 = TypeDeserializer.simpleType$default(this.f10220c.getTypeDeserializer(), r12, false, 2, null);
        if (r13 == null) goto L30;
    L48:
        return new InlineClassRepresentation(r11, r13);
    L30:
        Iterator<T> r14 = getMemberScope().getContributedVariables(r11, NoLookupLocation.FROM_DESERIALIZATION).iterator();
        Object r15 = null;
        boolean r16 = false;
    L32:
        if (r14.hasNext() == false) goto L41;
        Object r17 = r14.next();
        if (((PropertyDescriptor) r17).getExtensionReceiverParameter() != null) goto L36;
        boolean r18 = true;
    L37:
        if (r18 == false) goto L32;
        if (r16 == true) goto L44;
        r16 = true;
        r15 = r17;
    L44:
        PropertyDescriptor r19 = (PropertyDescriptor) r10;
        if (r19 == null) goto L50;
        KotlinType r20 = r19.getType();
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        r13 = (SimpleType) r20;
        goto L48
    L50:
        throw new IllegalStateException(("Value class has no underlying property: " + this).toString());
    L36:
        r18 = false;
        goto L37
    L41:
        if (r16 == false) goto L44;
        r10 = r15;
        goto L44
    L22:
        if (this.metadataVersion.isAtLeast(1, 5, 1) == true) goto L54;
        ClassConstructorDescriptor r21 = mo1317getUnsubstitutedPrimaryConstructor();
        if (r21 == null) goto L52;
        List<ValueParameterDescriptor> r22 = r21.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r22, "constructor.valueParameters");
        r11 = ((ValueParameterDescriptor) CollectionsKt.first(r22)).getName();
        Intrinsics.checkNotNullExpressionValue(r11, "{\n                // Bef…irst().name\n            }");
        goto L26
    L52:
        throw new IllegalStateException(("Inline class has no primary constructor: " + this).toString());
    L54:
        throw new IllegalStateException(("Inline class has no underlying property name in metadata: " + this).toString());
    }

    private final MultiFieldValueClassRepresentation<SimpleType> computeMultiFieldValueClassRepresentation() {
        List<Integer> r10 = this.classProto.getMultiFieldValueClassUnderlyingNameList();
        Intrinsics.checkNotNullExpressionValue(r10, "classProto.multiFieldValueClassUnderlyingNameList");
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L7;
        Integer r13 = (Integer) r12.next();
        NameResolver r14 = this.f10220c.getNameResolver();
        Intrinsics.checkNotNullExpressionValue(r13, "it");
        r11.add(NameResolverUtilKt.getName(r14, r13.intValue()));
        goto L4
    L7:
        if ((!r11.isEmpty()) == true) goto L10;
        r11 = null;
    L10:
        if (r11 != null) goto L13;
        return null;
    L13:
        if (isValue() == false) goto L32;
        Pair r15 = TuplesKt.to(Integer.valueOf(this.classProto.getMultiFieldValueClassUnderlyingTypeIdCount()), Integer.valueOf(this.classProto.getMultiFieldValueClassUnderlyingTypeCount()));
        if (Intrinsics.areEqual(r15, TuplesKt.to(Integer.valueOf(r11.size()), 0)) == false) goto L21;
        List<Integer> r16 = this.classProto.getMultiFieldValueClassUnderlyingTypeIdList();
        Intrinsics.checkNotNullExpressionValue(r16, "classProto.multiFieldVal…ClassUnderlyingTypeIdList");
        List<ProtoBuf.Type> r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator<T> r18 = r16.iterator();
    L18:
        if (r18.hasNext() == false) goto L23;
        Integer r19 = (Integer) r18.next();
        TypeTable r20 = this.f10220c.getTypeTable();
        Intrinsics.checkNotNullExpressionValue(r19, "it");
        r17.add(r20.get(r19.intValue()));
    L23:
        Intrinsics.checkNotNullExpressionValue(r17, "when (typeIdCount to typ…tation: $this\")\n        }");
        ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator<T> r22 = r17.iterator();
    L25:
        if (r22.hasNext() == false) goto L28;
        ProtoBuf.Type r23 = (ProtoBuf.Type) r22.next();
        TypeDeserializer r24 = this.f10220c.getTypeDeserializer();
        Intrinsics.checkNotNullExpressionValue(r23, "it");
        r21.add(TypeDeserializer.simpleType$default(r24, r23, false, 2, null));
        goto L25
    L28:
        return new MultiFieldValueClassRepresentation(CollectionsKt.zip(r11, r21));
    L21:
        if (Intrinsics.areEqual(r15, TuplesKt.to(0, Integer.valueOf(r11.size()))) == false) goto L30;
        r17 = this.classProto.getMultiFieldValueClassUnderlyingTypeList();
        goto L23
    L30:
        throw new IllegalStateException(("Illegal multi-field value class representation: " + this).toString());
    L32:
        throw new IllegalArgumentException(("Not a value class: " + this).toString());
    }

    private final ClassConstructorDescriptor computePrimaryConstructor() {
        if (this.kind.isSingleton() == false) goto L6;
        ClassConstructorDescriptorImpl r10 = DescriptorFactory.createPrimaryConstructorForObject(this, SourceElement.NO_SOURCE);
        r10.setReturnType(getDefaultType());
        return r10;
    L6:
        List<ProtoBuf.Constructor> r11 = this.classProto.getConstructorList();
        Intrinsics.checkNotNullExpressionValue(r11, "classProto.constructorList");
        Iterator<T> r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L12;
        Object r13 = r12.next();
        if ((!Flags.IS_SECONDARY.get(((ProtoBuf.Constructor) r13).getFlags()).booleanValue()) == false) goto L8;
    L13:
        ProtoBuf.Constructor r14 = (ProtoBuf.Constructor) r13;
        if (r14 != null) goto L16;
        return null;
    L16:
        return this.f10220c.getMemberDeserializer().loadConstructor(r14, true);
    L12:
        r13 = null;
        goto L13
    }

    private final List<ClassConstructorDescriptor> computeSecondaryConstructors() {
        List<ProtoBuf.Constructor> r10 = this.classProto.getConstructorList();
        Intrinsics.checkNotNullExpressionValue(r10, "classProto.constructorList");
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Object r13 = r12.next();
        Boolean r14 = Flags.IS_SECONDARY.get(((ProtoBuf.Constructor) r13).getFlags());
        Intrinsics.checkNotNullExpressionValue(r14, "IS_SECONDARY.get(it.flags)");
        if (r14.booleanValue() == false) goto L4;
        r11.add(r13);
        goto L4
    L8:
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator r16 = r11.iterator();
    L10:
        if (r16.hasNext() == false) goto L12;
        ProtoBuf.Constructor r17 = (ProtoBuf.Constructor) r16.next();
        MemberDeserializer r18 = this.f10220c.getMemberDeserializer();
        Intrinsics.checkNotNullExpressionValue(r17, "it");
        r15.add(r18.loadConstructor(r17, false));
        goto L10
    L12:
        return r15;
    }

    private final Collection<ClassDescriptor> computeSubclassesForSealedClass() {
        if (this.modality != Modality.SEALED) goto L5;
        List<Integer> r10 = this.classProto.getSealedSubclassFqNameList();
        Intrinsics.checkNotNullExpressionValue(r10, "fqNames");
        if ((!r10.isEmpty()) == false) goto L16;
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L10:
        if (r12.hasNext() == false) goto L14;
        Integer r13 = (Integer) r12.next();
        DeserializationComponents r14 = this.f10220c.getComponents();
        NameResolver r15 = this.f10220c.getNameResolver();
        Intrinsics.checkNotNullExpressionValue(r13, "index");
        ClassDescriptor r16 = r14.deserializeClass(NameResolverUtilKt.getClassId(r15, r13.intValue()));
        if (r16 == null) goto L10;
        r11.add(r16);
        goto L10
    L14:
        return r11;
    L16:
        return CliSealedClassInheritorsProvider.INSTANCE.computeSealedSubclasses(this, false);
    L5:
        return CollectionsKt.emptyList();
    }

    private final ValueClassRepresentation<SimpleType> computeValueClassRepresentation() {
        InlineClassRepresentation<SimpleType> r10 = computeInlineClassRepresentation();
        MultiFieldValueClassRepresentation<SimpleType> r11 = computeMultiFieldValueClassRepresentation();
        if (r10 == null) goto L9;
        if (r11 == null) goto L9;
        throw new IllegalArgumentException("Class cannot have both inline class representation and multi field class representation: " + this);
    L9:
        if (isValue() == false) goto L11;
    L12:
        if (r10 != null) goto L17;
        if (r11 != null) goto L17;
        throw new IllegalArgumentException("Value class has no value class representation: " + this);
    L17:
        if (r10 == null) goto L20;
        return r10;
    L20:
        return r11;
    L11:
        if (isInline() == false) goto L17;
        goto L12
    }

    private final DeserializedClassMemberScope getMemberScope() {
        return (DeserializedClassMemberScope) this.memberScopeHolder.getScope(this.f10220c.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        return this.annotations;
    }

    public final DeserializationContext getC() {
        return this.f10220c;
    }

    public final ProtoBuf.Class getClassProto() {
        return this.classProto;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    /* JADX INFO: renamed from: getCompanionObjectDescriptor */
    public ClassDescriptor mo1316getCompanionObjectDescriptor() {
        return this.companionObjectDescriptor.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public Collection<ClassConstructorDescriptor> getConstructors() {
        return this.constructors.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public DeclarationDescriptor getContainingDeclaration() {
        return this.containingDeclaration;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public List<ReceiverParameterDescriptor> getContextReceivers() {
        List<ProtoBuf.Type> r10 = ProtoTypeTableUtilKt.contextReceiverTypes(this.classProto, this.f10220c.getTypeTable());
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        ProtoBuf.Type r13 = (ProtoBuf.Type) r12.next();
        KotlinType r14 = this.f10220c.getTypeDeserializer().type(r13);
        r11.add(new ReceiverParameterDescriptorImpl(getThisAsReceiverParameter(), new ContextClassReceiver(this, r14, null), Annotations.Companion.getEMPTY()));
        goto L4
    L6:
        return r11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        return this.f10220c.getTypeDeserializer().getOwnTypeParameters();
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

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public Collection<ClassDescriptor> getSealedSubclasses() {
        return this.sealedSubclasses.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    public SourceElement getSource() {
        return this.sourceElement;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public /* bridge */ /* synthetic */ MemberScope getStaticScope() {
        return getStaticScope();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public MemberScopeImpl getStaticScope() {
        return this.staticScope;
    }

    public final ProtoContainer.Class getThisAsProtoContainer$deserialization() {
        return this.thisAsProtoContainer;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public TypeConstructor getTypeConstructor() {
        return this.typeConstructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    protected MemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner r10) {
        Intrinsics.checkNotNullParameter(r10, "kotlinTypeRefiner");
        return this.memberScopeHolder.getScope(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    /* JADX INFO: renamed from: getUnsubstitutedPrimaryConstructor */
    public ClassConstructorDescriptor mo1317getUnsubstitutedPrimaryConstructor() {
        return this.primaryConstructor.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public ValueClassRepresentation<SimpleType> getValueClassRepresentation() {
        return this.valueClassRepresentation.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public DescriptorVisibility getVisibility() {
        return this.visibility;
    }

    public final boolean hasNestedClass$deserialization(Name r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        return getMemberScope().getClassNames$deserialization().contains(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isCompanionObject() {
        if (Flags.CLASS_KIND.get(this.classProto.getFlags()) != ProtoBuf.Class.Kind.COMPANION_OBJECT) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isData() {
        Boolean r10 = Flags.IS_DATA.get(this.classProto.getFlags());
        Intrinsics.checkNotNullExpressionValue(r10, "IS_DATA.get(classProto.flags)");
        return r10.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        Boolean r10 = Flags.IS_EXPECT_CLASS.get(this.classProto.getFlags());
        Intrinsics.checkNotNullExpressionValue(r10, "IS_EXPECT_CLASS.get(classProto.flags)");
        return r10.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        Boolean r10 = Flags.IS_EXTERNAL_CLASS.get(this.classProto.getFlags());
        Intrinsics.checkNotNullExpressionValue(r10, "IS_EXTERNAL_CLASS.get(classProto.flags)");
        return r10.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isFun() {
        Boolean r10 = Flags.IS_FUN_INTERFACE.get(this.classProto.getFlags());
        Intrinsics.checkNotNullExpressionValue(r10, "IS_FUN_INTERFACE.get(classProto.flags)");
        return r10.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isInline() {
        Boolean r10 = Flags.IS_VALUE_CLASS.get(this.classProto.getFlags());
        Intrinsics.checkNotNullExpressionValue(r10, "IS_VALUE_CLASS.get(classProto.flags)");
        if (r10.booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.metadataVersion.isAtMost(1, 4, 1) == false) goto L7;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        Boolean r10 = Flags.IS_INNER.get(this.classProto.getFlags());
        Intrinsics.checkNotNullExpressionValue(r10, "IS_INNER.get(classProto.flags)");
        return r10.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isValue() {
        Boolean r10 = Flags.IS_VALUE_CLASS.get(this.classProto.getFlags());
        Intrinsics.checkNotNullExpressionValue(r10, "IS_VALUE_CLASS.get(classProto.flags)");
        if (r10.booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.metadataVersion.isAtLeast(1, 4, 2) == false) goto L7;
        return true;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append("deserialized ");
        if (isExpect() == false) goto L5;
        String r11 = "expect ";
    L6:
        r10.append(r11);
        r10.append("class ");
        r10.append(getName());
        return r10.toString();
    L5:
        r11 = "";
        goto L6
    }
}
