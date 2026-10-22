package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import androidx.constraintlayout.motion.widget.a;
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
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KDeclarationContainer;
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
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlagsUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;
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

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nDeserializedClassDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeserializedClassDescriptor.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,424:1\n288#2,2:425\n766#2:427\n857#2,2:428\n1549#2:430\n1620#2,3:431\n1549#2:434\n1620#2,3:435\n1603#2,9:438\n1855#2:447\n1856#2:449\n1612#2:450\n661#2,11:452\n1#3:448\n1#3:451\n*S KotlinDebug\n*F\n+ 1 DeserializedClassDescriptor.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor\n*L\n136#1:425,2\n148#1:427\n148#1:428,2\n148#1:430\n148#1:431,3\n154#1:434\n154#1:435,3\n185#1:438,9\n185#1:447\n185#1:449\n185#1:450\n215#1:452,11\n185#1:448\n*E\n"})
public final class DeserializedClassDescriptor extends AbstractClassDescriptor implements DeserializedDescriptor {
    private final Annotations annotations;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DeserializationContext f18757c;
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

    @SourceDebugExtension({"SMAP\nDeserializedClassDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeserializedClassDescriptor.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor$DeserializedClassMemberScope\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 addToStdlib.kt\norg/jetbrains/kotlin/utils/addToStdlib/AddToStdlibKt\n*L\n1#1,424:1\n1549#2:425\n1620#2,3:426\n1446#2,5:430\n1446#2,5:435\n1#3:429\n196#4,5:440\n*S KotlinDebug\n*F\n+ 1 DeserializedClassDescriptor.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor$DeserializedClassMemberScope\n*L\n269#1:425\n269#1:426,3\n349#1:430,5\n355#1:435,5\n361#1:440,5\n*E\n"})
    public final class DeserializedClassMemberScope extends DeserializedMemberScope {
        private final NotNullLazyValue<Collection<DeclarationDescriptor>> allDescriptors;
        private final KotlinTypeRefiner kotlinTypeRefiner;
        private final NotNullLazyValue<Collection<KotlinType>> refinedSupertypes;
        final /* synthetic */ DeserializedClassDescriptor this$0;

        public DeserializedClassMemberScope(DeserializedClassDescriptor r10, KotlinTypeRefiner r11) {
            Intrinsics.checkNotNullParameter(r11, "kotlinTypeRefiner");
            this.this$0 = r10;
            DeserializationContext r5 = r10.getC();
            List<ProtoBuf.Function> r12 = r10.getClassProto().getFunctionList();
            List<ProtoBuf.Property> r13 = r10.getClassProto().getPropertyList();
            List<ProtoBuf.TypeAlias> r14 = r10.getClassProto().getTypeAliasList();
            List<Integer> r15 = r10.getClassProto().getNestedClassNameList();
            NameResolver r16 = r10.getC().getNameResolver();
            final ArrayList r17 = new ArrayList(CollectionsKt.h(r15));
            Iterator<T> r18 = r15.iterator();
        L4:
            if (r18.hasNext() == false) goto L6;
            r17.add(NameResolverUtilKt.getName(r16, ((Number) r18.next()).intValue()));
            goto L4
        L6:
            super(r5, r12, r13, r14, new DeserializedClassDescriptor$DeserializedClassMemberScope$2$1(r17));
            this.kotlinTypeRefiner = r11;
            this.allDescriptors = getC().getStorageManager().createLazyValue(new DeserializedClassDescriptor$DeserializedClassMemberScope$allDescriptors$1(this));
            this.refinedSupertypes = getC().getStorageManager().createLazyValue(new DeserializedClassDescriptor$DeserializedClassMemberScope$refinedSupertypes$1(this));
        }

        public static final /* synthetic */ DeserializedClassDescriptor access$getClassDescriptor(DeserializedClassMemberScope r5) {
            return r5.getClassDescriptor();
        }

        public static final /* synthetic */ KotlinTypeRefiner access$getKotlinTypeRefiner$p(DeserializedClassMemberScope r5) {
            return r5.kotlinTypeRefiner;
        }

        private final <D extends CallableMemberDescriptor> void generateFakeOverrides(Name r10, Collection<? extends D> r11, final List<D> r12) {
            ArrayList r5 = new ArrayList(r12);
            getC().getComponents().getKotlinTypeChecker().getOverridingUtil().generateOverridesInFunctionGroup(r10, r11, r5, getClassDescriptor(), new DeserializedClassDescriptor$DeserializedClassMemberScope$generateFakeOverrides$1(r12));
        }

        private final DeserializedClassDescriptor getClassDescriptor() {
            return this.this$0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        public void addEnumEntryDescriptors(Collection<DeclarationDescriptor> r5, Function1<? super Name, Boolean> r10) {
            Intrinsics.checkNotNullParameter(r5, "result");
            Intrinsics.checkNotNullParameter(r10, "nameFilter");
            EnumEntryClassDescriptors r11 = DeserializedClassDescriptor.access$getEnumEntries$p(getClassDescriptor());
            if (r11 == null) goto L5;
            Collection<ClassDescriptor> r12 = r11.all();
        L6:
            if (r12 != null) goto L8;
            r12 = CollectionsKt.emptyList();
        L8:
            r5.addAll(r12);
            return;
        L5:
            r12 = null;
            goto L6
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        public void computeNonDeclaredFunctions(Name r5, List<SimpleFunctionDescriptor> r10) {
            Intrinsics.checkNotNullParameter(r5, "name");
            Intrinsics.checkNotNullParameter(r10, "functions");
            ArrayList r11 = new ArrayList();
            Iterator<KotlinType> r12 = this.refinedSupertypes.invoke().iterator();
        L4:
            if (r12.hasNext() == false) goto L6;
            r11.addAll(r12.next().getMemberScope().getContributedFunctions(r5, NoLookupLocation.FOR_ALREADY_TRACKED));
            goto L4
        L6:
            r10.addAll(getC().getComponents().getAdditionalClassPartsProvider().getFunctions(r5, this.this$0));
            generateFakeOverrides(r5, r11, r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        public void computeNonDeclaredProperties(Name r5, List<PropertyDescriptor> r10) {
            Intrinsics.checkNotNullParameter(r5, "name");
            Intrinsics.checkNotNullParameter(r10, "descriptors");
            ArrayList r11 = new ArrayList();
            Iterator<KotlinType> r12 = this.refinedSupertypes.invoke().iterator();
        L4:
            if (r12.hasNext() == false) goto L6;
            r11.addAll(r12.next().getMemberScope().getContributedVariables(r5, NoLookupLocation.FOR_ALREADY_TRACKED));
            goto L4
        L6:
            generateFakeOverrides(r5, r11, r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        public ClassId createClassId(Name r5) {
            Intrinsics.checkNotNullParameter(r5, "name");
            return DeserializedClassDescriptor.access$getClassId$p(this.this$0).createNestedClassId(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        /* JADX INFO: renamed from: getContributedClassifier */
        public ClassifierDescriptor mo1404getContributedClassifier(Name r5, LookupLocation r10) {
            Intrinsics.checkNotNullParameter(r5, "name");
            Intrinsics.checkNotNullParameter(r10, "location");
            mo1408recordLookup(r5, r10);
            EnumEntryClassDescriptors r11 = DeserializedClassDescriptor.access$getEnumEntries$p(getClassDescriptor());
            if (r11 == null) goto L8;
            ClassDescriptor r12 = r11.findEnumEntry(r5);
            if (r12 == null) goto L8;
            return r12;
        L8:
            return super.mo1404getContributedClassifier(r5, r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r5, Function1<? super Name, Boolean> r10) {
            Intrinsics.checkNotNullParameter(r5, "kindFilter");
            Intrinsics.checkNotNullParameter(r10, "nameFilter");
            return this.allDescriptors.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name r5, LookupLocation r10) {
            Intrinsics.checkNotNullParameter(r5, "name");
            Intrinsics.checkNotNullParameter(r10, "location");
            mo1408recordLookup(r5, r10);
            return super.getContributedFunctions(r5, r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        public Collection<PropertyDescriptor> getContributedVariables(Name r5, LookupLocation r10) {
            Intrinsics.checkNotNullParameter(r5, "name");
            Intrinsics.checkNotNullParameter(r10, "location");
            mo1408recordLookup(r5, r10);
            return super.getContributedVariables(r5, r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        public Set<Name> getNonDeclaredClassifierNames() {
            List<KotlinType> r5 = DeserializedClassDescriptor.access$getTypeConstructor$p(getClassDescriptor()).mo1403getSupertypes();
            LinkedHashSet r10 = new LinkedHashSet();
            Iterator<T> r11 = r5.iterator();
        L4:
            if (r11.hasNext() == false) goto L12;
            Set<Name> r12 = ((KotlinType) r11.next()).getMemberScope().getClassifierNames();
            if (r12 == null) goto L7;
            CollectionsKt.a(r10, r12);
            goto L4
        L7:
            return null;
        L12:
            return r10;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        public Set<Name> getNonDeclaredFunctionNames() {
            List<KotlinType> r5 = DeserializedClassDescriptor.access$getTypeConstructor$p(getClassDescriptor()).mo1403getSupertypes();
            LinkedHashSet r10 = new LinkedHashSet();
            Iterator<T> r11 = r5.iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            CollectionsKt.a(r10, ((KotlinType) r11.next()).getMemberScope().getFunctionNames());
            goto L4
        L6:
            DeserializedClassDescriptor r12 = this.this$0;
            r10.addAll(getC().getComponents().getAdditionalClassPartsProvider().getFunctionsNames(r12));
            return r10;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        public Set<Name> getNonDeclaredVariableNames() {
            List<KotlinType> r5 = DeserializedClassDescriptor.access$getTypeConstructor$p(getClassDescriptor()).mo1403getSupertypes();
            LinkedHashSet r10 = new LinkedHashSet();
            Iterator<T> r11 = r5.iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            CollectionsKt.a(r10, ((KotlinType) r11.next()).getMemberScope().getVariableNames());
            goto L4
        L6:
            return r10;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        public boolean isDeclaredFunctionAvailable(SimpleFunctionDescriptor r5) {
            Intrinsics.checkNotNullParameter(r5, "function");
            return getC().getComponents().getPlatformDependentDeclarationFilter().isFunctionAvailable(this.this$0, r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        /* JADX INFO: renamed from: recordLookup */
        public void mo1408recordLookup(Name r5, LookupLocation r10) {
            Intrinsics.checkNotNullParameter(r5, "name");
            Intrinsics.checkNotNullParameter(r10, "location");
            UtilsKt.record(getC().getComponents().getLookupTracker(), r10, getClassDescriptor(), r5);
        }
    }

    @SourceDebugExtension({"SMAP\nDeserializedClassDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeserializedClassDescriptor.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor$DeserializedClassTypeConstructor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,424:1\n1549#2:425\n1620#2,3:426\n1603#2,9:429\n1855#2:438\n1856#2:440\n1612#2:441\n1549#2:442\n1620#2,3:443\n1#3:439\n*S KotlinDebug\n*F\n+ 1 DeserializedClassDescriptor.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor$DeserializedClassTypeConstructor\n*L\n236#1:425\n236#1:426,3\n240#1:429,9\n240#1:438\n240#1:440\n240#1:441\n247#1:442\n247#1:443,3\n240#1:439\n*E\n"})
    public final class DeserializedClassTypeConstructor extends AbstractClassTypeConstructor {
        private final NotNullLazyValue<List<TypeParameterDescriptor>> parameters;
        final /* synthetic */ DeserializedClassDescriptor this$0;

        public DeserializedClassTypeConstructor(final DeserializedClassDescriptor r5) {
            this.this$0 = r5;
            super(r5.getC().getStorageManager());
            this.parameters = r5.getC().getStorageManager().createLazyValue(new DeserializedClassDescriptor$DeserializedClassTypeConstructor$parameters$1(r5));
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        public Collection<KotlinType> computeSupertypes() {
            List<ProtoBuf.Type> r5 = ProtoTypeTableUtilKt.supertypes(this.this$0.getClassProto(), this.this$0.getC().getTypeTable());
            DeserializedClassDescriptor r10 = this.this$0;
            ArrayList r11 = new ArrayList(CollectionsKt.h(r5));
            Iterator<T> r12 = r5.iterator();
        L4:
            if (r12.hasNext() == false) goto L6;
            ProtoBuf.Type r13 = (ProtoBuf.Type) r12.next();
            r11.add(r10.getC().getTypeDeserializer().type(r13));
            goto L4
        L6:
            List r14 = CollectionsKt.plus(r11, this.this$0.getC().getComponents().getAdditionalClassPartsProvider().getSupertypes(this.this$0));
            ArrayList r15 = new ArrayList();
            Iterator r16 = r14.iterator();
        L8:
            if (r16.hasNext() == false) goto L16;
            ClassifierDescriptor r17 = ((KotlinType) r16.next()).getConstructor().mo1402getDeclarationDescriptor();
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
            if (r15.isEmpty() == true) goto L30;
            ErrorReporter r19 = this.this$0.getC().getComponents().getErrorReporter();
            DeserializedClassDescriptor r20 = this.this$0;
            ArrayList r21 = new ArrayList(CollectionsKt.h(r15));
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
        public /* bridge */ /* synthetic */ ClassDescriptor mo1402getDeclarationDescriptor() {
            return mo1402getDeclarationDescriptor();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public List<TypeParameterDescriptor> getParameters() {
            return this.parameters.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        public SupertypeLoopChecker getSupertypeLoopChecker() {
            return SupertypeLoopChecker.EMPTY.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return true;
        }

        public String toString() {
            return this.this$0.getName().toString();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor, kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* JADX INFO: renamed from: getDeclarationDescriptor */
        public /* bridge */ /* synthetic */ ClassifierDescriptor mo1402getDeclarationDescriptor() {
            return mo1402getDeclarationDescriptor();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor, kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* JADX INFO: renamed from: getDeclarationDescriptor */
        public DeserializedClassDescriptor mo1402getDeclarationDescriptor() {
            return this.this$0;
        }
    }

    @SourceDebugExtension({"SMAP\nDeserializedClassDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeserializedClassDescriptor.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor$EnumEntryClassDescriptors\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,424:1\n1194#2,2:425\n1222#2,4:427\n1620#2,3:431\n1620#2,3:434\n1603#2,9:437\n1855#2:446\n1856#2:448\n1612#2:449\n1#3:447\n*S KotlinDebug\n*F\n+ 1 DeserializedClassDescriptor.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor$EnumEntryClassDescriptors\n*L\n384#1:425,2\n384#1:427,4\n416#1:431,3\n417#1:434,3\n421#1:437,9\n421#1:446\n421#1:448\n421#1:449\n421#1:447\n*E\n"})
    public final class EnumEntryClassDescriptors {
        private final MemoizedFunctionToNullable<Name, ClassDescriptor> enumEntryByName;
        private final Map<Name, ProtoBuf.EnumEntry> enumEntryProtos;
        private final NotNullLazyValue<Set<Name>> enumMemberNames;
        final /* synthetic */ DeserializedClassDescriptor this$0;

        public EnumEntryClassDescriptors(DeserializedClassDescriptor r10) {
            this.this$0 = r10;
            List<ProtoBuf.EnumEntry> r5 = r10.getClassProto().getEnumEntryList();
            LinkedHashMap r11 = new LinkedHashMap(a.e(r5, 16));
            Iterator<T> r12 = r5.iterator();
        L4:
            if (r12.hasNext() == false) goto L6;
            Object r13 = r12.next();
            r11.put(NameResolverUtilKt.getName(r10.getC().getNameResolver(), ((ProtoBuf.EnumEntry) r13).getName()), r13);
            goto L4
        L6:
            this.enumEntryProtos = r11;
            StorageManager r14 = this.this$0.getC().getStorageManager();
            final DeserializedClassDescriptor r15 = this.this$0;
            this.enumEntryByName = r14.createMemoizedFunctionWithNullableValues(new DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1(this, r15));
            this.enumMemberNames = this.this$0.getC().getStorageManager().createLazyValue(new DeserializedClassDescriptor$EnumEntryClassDescriptors$enumMemberNames$1(this));
        }

        public static final /* synthetic */ Set access$computeEnumMemberNames(EnumEntryClassDescriptors r5) {
            return r5.computeEnumMemberNames();
        }

        public static final /* synthetic */ Map access$getEnumEntryProtos$p(EnumEntryClassDescriptors r5) {
            return r5.enumEntryProtos;
        }

        public static final /* synthetic */ NotNullLazyValue access$getEnumMemberNames$p(EnumEntryClassDescriptors r5) {
            return r5.enumMemberNames;
        }

        private final Set<Name> computeEnumMemberNames() {
            HashSet r5 = new HashSet();
            Iterator<KotlinType> r10 = this.this$0.getTypeConstructor().mo1403getSupertypes().iterator();
        L4:
            if (r10.hasNext() == false) goto L13;
            Iterator r11 = ResolutionScope.DefaultImpls.getContributedDescriptors$default(r10.next().getMemberScope(), null, null, 3, null).iterator();
        L7:
            if (r11.hasNext() == false) goto L4;
            DeclarationDescriptor r12 = (DeclarationDescriptor) r11.next();
            if ((r12 instanceof SimpleFunctionDescriptor) == true) goto L12;
            if ((r12 instanceof PropertyDescriptor) == false) goto L7;
        L12:
            r5.add(r12.getName());
            goto L7
        L13:
            List<ProtoBuf.Function> r13 = this.this$0.getClassProto().getFunctionList();
            DeserializedClassDescriptor r14 = this.this$0;
            Iterator<T> r15 = r13.iterator();
        L15:
            if (r15.hasNext() == false) goto L17;
            ProtoBuf.Function r16 = (ProtoBuf.Function) r15.next();
            r5.add(NameResolverUtilKt.getName(r14.getC().getNameResolver(), r16.getName()));
            goto L15
        L17:
            List<ProtoBuf.Property> r17 = this.this$0.getClassProto().getPropertyList();
            DeserializedClassDescriptor r18 = this.this$0;
            Iterator<T> r19 = r17.iterator();
        L19:
            if (r19.hasNext() == false) goto L22;
            ProtoBuf.Property r20 = (ProtoBuf.Property) r19.next();
            r5.add(NameResolverUtilKt.getName(r18.getC().getNameResolver(), r20.getName()));
            goto L19
        L22:
            return SetsKt.plus(r5, r5);
        }

        public final Collection<ClassDescriptor> all() {
            Set<Name> r5 = this.enumEntryProtos.keySet();
            ArrayList r10 = new ArrayList();
            Iterator<T> r11 = r5.iterator();
        L4:
            if (r11.hasNext() == false) goto L8;
            ClassDescriptor r12 = findEnumEntry((Name) r11.next());
            if (r12 == null) goto L4;
            r10.add(r12);
            goto L4
        L8:
            return r10;
        }

        public final ClassDescriptor findEnumEntry(Name r5) {
            Intrinsics.checkNotNullParameter(r5, "name");
            return this.enumEntryByName.invoke(r5);
        }
    }

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$computeValueClassRepresentation$1, reason: invalid class name */
    public /* synthetic */ class AnonymousClass1 extends FunctionReference implements Function1<ProtoBuf.Type, SimpleType> {
        public AnonymousClass1(Object r5) {
            super(1, r5);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "simpleType";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(Intrinsics.Kotlin.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final String getSignature() {
            return "computeValueClassRepresentation$simpleType(Lorg/jetbrains/kotlin/serialization/deserialization/TypeDeserializer;Lorg/jetbrains/kotlin/metadata/ProtoBuf$Type;)Lorg/jetbrains/kotlin/types/SimpleType;";
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ SimpleType invoke(ProtoBuf.Type r5) {
            return invoke2(r5);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final SimpleType invoke2(ProtoBuf.Type r5) {
            Intrinsics.checkNotNullParameter(r5, "p0");
            return TypeDeserializer.simpleType$default((TypeDeserializer) this.receiver, r5, false, 2, null);
        }
    }

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$computeValueClassRepresentation$2, reason: invalid class name */
    public /* synthetic */ class AnonymousClass2 extends FunctionReference implements Function1<Name, SimpleType> {
        public AnonymousClass2(Object r5) {
            super(1, r5);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "getValueClassPropertyType";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(DeserializedClassDescriptor.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final String getSignature() {
            return "getValueClassPropertyType(Lorg/jetbrains/kotlin/name/Name;)Lorg/jetbrains/kotlin/types/SimpleType;";
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ SimpleType invoke(Name r5) {
            return invoke2(r5);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final SimpleType invoke2(Name r5) {
            Intrinsics.checkNotNullParameter(r5, "p0");
            return DeserializedClassDescriptor.access$getValueClassPropertyType((DeserializedClassDescriptor) this.receiver, r5);
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
        ProtoEnumFlags r5 = ProtoEnumFlags.INSTANCE;
        this.modality = r5.modality(Flags.MODALITY.get(r11.getFlags()));
        this.visibility = ProtoEnumFlagsUtilsKt.descriptorVisibility(r5, Flags.VISIBILITY.get(r11.getFlags()));
        ClassKind r15 = r5.classKind(Flags.CLASS_KIND.get(r11.getFlags()));
        this.kind = r15;
        DeserializationContext r16 = r10.childContext(this, r11.getTypeParameterList(), r12, new TypeTable(r11.getTypeTable()), VersionRequirementTable.Companion.create(r11.getVersionRequirementTable()), r13);
        this.f18757c = r16;
        ClassKind r17 = ClassKind.ENUM_CLASS;
        if (r15 != r17) goto L5;
        MemberScopeImpl r18 = new StaticScopeForKotlinEnum(r16.getStorageManager(), this);
    L6:
        this.staticScope = r18;
        this.typeConstructor = new DeserializedClassTypeConstructor(this);
        this.memberScopeHolder = ScopesHolderForClass.Companion.create(this, r16.getStorageManager(), r16.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner(), new DeserializedClassDescriptor$memberScopeHolder$1(this));
        ProtoContainer.Class r19 = null;
        if (r15 != r17) goto L9;
        EnumEntryClassDescriptors r110 = new EnumEntryClassDescriptors(this);
    L10:
        this.enumEntries = r110;
        DeclarationDescriptor r20 = r10.getContainingDeclaration();
        this.containingDeclaration = r20;
        this.primaryConstructor = r16.getStorageManager().createNullableLazyValue(new DeserializedClassDescriptor$primaryConstructor$1(this));
        this.constructors = r16.getStorageManager().createLazyValue(new DeserializedClassDescriptor$constructors$1(this));
        this.companionObjectDescriptor = r16.getStorageManager().createNullableLazyValue(new DeserializedClassDescriptor$companionObjectDescriptor$1(this));
        this.sealedSubclasses = r16.getStorageManager().createLazyValue(new DeserializedClassDescriptor$sealedSubclasses$1(this));
        this.valueClassRepresentation = r16.getStorageManager().createNullableLazyValue(new DeserializedClassDescriptor$valueClassRepresentation$1(this));
        NameResolver r21 = r16.getNameResolver();
        TypeTable r22 = r16.getTypeTable();
        if ((r20 instanceof DeserializedClassDescriptor) == false) goto L13;
        DeserializedClassDescriptor r23 = (DeserializedClassDescriptor) r20;
    L14:
        if (r23 == null) goto L16;
        r19 = r23.thisAsProtoContainer;
    L16:
        this.thisAsProtoContainer = new ProtoContainer.Class(r11, r21, r22, r14, r19);
        if (Flags.HAS_ANNOTATIONS.get(r11.getFlags()).booleanValue() == true) goto L19;
        Annotations r24 = Annotations.Companion.getEMPTY();
    L20:
        this.annotations = r24;
        return;
    L19:
        r24 = new NonEmptyDeserializedAnnotations(r16.getStorageManager(), new DeserializedClassDescriptor$annotations$1(this));
        goto L20
    L13:
        r23 = null;
        goto L14
    L9:
        r110 = null;
        goto L10
    L5:
        r18 = MemberScope.Empty.INSTANCE;
        goto L6
    }

    public static final /* synthetic */ ClassDescriptor access$computeCompanionObjectDescriptor(DeserializedClassDescriptor r5) {
        return r5.computeCompanionObjectDescriptor();
    }

    public static final /* synthetic */ Collection access$computeConstructors(DeserializedClassDescriptor r5) {
        return r5.computeConstructors();
    }

    public static final /* synthetic */ ClassConstructorDescriptor access$computePrimaryConstructor(DeserializedClassDescriptor r5) {
        return r5.computePrimaryConstructor();
    }

    public static final /* synthetic */ Collection access$computeSubclassesForSealedClass(DeserializedClassDescriptor r5) {
        return r5.computeSubclassesForSealedClass();
    }

    public static final /* synthetic */ ValueClassRepresentation access$computeValueClassRepresentation(DeserializedClassDescriptor r5) {
        return r5.computeValueClassRepresentation();
    }

    public static final /* synthetic */ ClassId access$getClassId$p(DeserializedClassDescriptor r5) {
        return r5.classId;
    }

    public static final /* synthetic */ EnumEntryClassDescriptors access$getEnumEntries$p(DeserializedClassDescriptor r5) {
        return r5.enumEntries;
    }

    public static final /* synthetic */ DeserializedClassTypeConstructor access$getTypeConstructor$p(DeserializedClassDescriptor r5) {
        return r5.typeConstructor;
    }

    public static final /* synthetic */ SimpleType access$getValueClassPropertyType(DeserializedClassDescriptor r5, Name r10) {
        return r5.getValueClassPropertyType(r10);
    }

    private final ClassDescriptor computeCompanionObjectDescriptor() {
        if (this.classProto.hasCompanionObjectName() == true) goto L5;
        return null;
    L5:
        Name r5 = NameResolverUtilKt.getName(this.f18757c.getNameResolver(), this.classProto.getCompanionObjectName());
        ClassifierDescriptor r10 = getMemberScope().mo1404getContributedClassifier(r5, NoLookupLocation.FROM_DESERIALIZATION);
        if ((r10 instanceof ClassDescriptor) == true) goto L8;
        return null;
    L8:
        return (ClassDescriptor) r10;
    }

    private final Collection<ClassConstructorDescriptor> computeConstructors() {
        return CollectionsKt.plus(CollectionsKt.plus(computeSecondaryConstructors(), CollectionsKt.listOfNotNull(mo1396getUnsubstitutedPrimaryConstructor())), this.f18757c.getComponents().getAdditionalClassPartsProvider().getConstructors(this));
    }

    private final ClassConstructorDescriptor computePrimaryConstructor() {
        if (this.kind.isSingleton() == false) goto L6;
        ClassConstructorDescriptorImpl r5 = DescriptorFactory.createPrimaryConstructorForObject(this, SourceElement.NO_SOURCE);
        r5.setReturnType(getDefaultType());
        return r5;
    L6:
        Iterator<T> r10 = this.classProto.getConstructorList().iterator();
    L8:
        if (r10.hasNext() == false) goto L12;
        Object r11 = r10.next();
        if (Flags.IS_SECONDARY.get(((ProtoBuf.Constructor) r11).getFlags()).booleanValue() == true) goto L8;
    L13:
        ProtoBuf.Constructor r12 = (ProtoBuf.Constructor) r11;
        if (r12 != null) goto L16;
        return null;
    L16:
        return this.f18757c.getMemberDeserializer().loadConstructor(r12, true);
    L12:
        r11 = null;
        goto L13
    }

    private final List<ClassConstructorDescriptor> computeSecondaryConstructors() {
        List<ProtoBuf.Constructor> r5 = this.classProto.getConstructorList();
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Object r12 = r11.next();
        if (Flags.IS_SECONDARY.get(((ProtoBuf.Constructor) r12).getFlags()).booleanValue() == false) goto L4;
        r10.add(r12);
        goto L4
    L8:
        ArrayList r13 = new ArrayList(CollectionsKt.h(r10));
        Iterator r14 = r10.iterator();
    L10:
        if (r14.hasNext() == false) goto L12;
        ProtoBuf.Constructor r15 = (ProtoBuf.Constructor) r14.next();
        r13.add(this.f18757c.getMemberDeserializer().loadConstructor(r15, false));
        goto L10
    L12:
        return r13;
    }

    private final Collection<ClassDescriptor> computeSubclassesForSealedClass() {
        if (this.modality != Modality.SEALED) goto L5;
        List<Integer> r5 = this.classProto.getSealedSubclassFqNameList();
        if (r5.isEmpty() == true) goto L16;
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = r5.iterator();
    L10:
        if (r11.hasNext() == false) goto L14;
        Integer r12 = (Integer) r11.next();
        ClassDescriptor r13 = this.f18757c.getComponents().deserializeClass(NameResolverUtilKt.getClassId(this.f18757c.getNameResolver(), r12.intValue()));
        if (r13 == null) goto L10;
        r10.add(r13);
        goto L10
    L14:
        return r10;
    L16:
        return CliSealedClassInheritorsProvider.INSTANCE.computeSealedSubclasses(this, false);
    L5:
        return CollectionsKt.emptyList();
    }

    private final ValueClassRepresentation<SimpleType> computeValueClassRepresentation() {
        if (isInline() == false) goto L5;
    L7:
        ValueClassRepresentation<SimpleType> r5 = ValueClassUtilKt.loadValueClassRepresentation(this.classProto, this.f18757c.getNameResolver(), this.f18757c.getTypeTable(), new AnonymousClass1(this.f18757c.getTypeDeserializer()), new AnonymousClass2(this));
        if (r5 == null) goto L11;
        return r5;
    L11:
        if (this.metadataVersion.isAtLeast(1, 5, 1) == true) goto L22;
        ClassConstructorDescriptor r10 = mo1396getUnsubstitutedPrimaryConstructor();
        if (r10 == null) goto L21;
        Name r11 = ((ValueParameterDescriptor) CollectionsKt.first(r10.getValueParameters())).getName();
        SimpleType r12 = getValueClassPropertyType(r11);
        if (r12 == null) goto L19;
        return new InlineClassRepresentation(r11, r12);
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

    private final DeserializedClassMemberScope getMemberScope() {
        return (DeserializedClassMemberScope) this.memberScopeHolder.getScope(this.f18757c.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner());
    }

    private final SimpleType getValueClassPropertyType(Name r5) {
        Iterator<T> r10 = getMemberScope().getContributedVariables(r5, NoLookupLocation.FROM_DESERIALIZATION).iterator();
        KotlinType r11 = null;
        boolean r12 = false;
        Object r13 = null;
    L4:
        if (r10.hasNext() == false) goto L10;
        Object r14 = r10.next();
        if (((PropertyDescriptor) r14).getExtensionReceiverParameter() != null) goto L4;
        if (r12 == true) goto L8;
        r12 = true;
        r13 = r14;
    L8:
        r13 = null;
    L12:
        PropertyDescriptor r15 = (PropertyDescriptor) r13;
        if (r15 == null) goto L16;
        r11 = r15.getType();
    L16:
        return (SimpleType) r11;
    L10:
        if (r12 == true) goto L12;
        goto L12
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        return this.annotations;
    }

    public final DeserializationContext getC() {
        return this.f18757c;
    }

    public final ProtoBuf.Class getClassProto() {
        return this.classProto;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    /* JADX INFO: renamed from: getCompanionObjectDescriptor */
    public ClassDescriptor mo1395getCompanionObjectDescriptor() {
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
        List<ProtoBuf.Type> r5 = ProtoTypeTableUtilKt.contextReceiverTypes(this.classProto, this.f18757c.getTypeTable());
        ArrayList r10 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ProtoBuf.Type r12 = (ProtoBuf.Type) r11.next();
        KotlinType r13 = this.f18757c.getTypeDeserializer().type(r12);
        r10.add(new ReceiverParameterDescriptorImpl(getThisAsReceiverParameter(), new ContextClassReceiver(this, r13, null, null), Annotations.Companion.getEMPTY()));
        goto L4
    L6:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        return this.f18757c.getTypeDeserializer().getOwnTypeParameters();
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

    public final ProtoContainer.Class getThisAsProtoContainer$deserialization() {
        return this.thisAsProtoContainer;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public TypeConstructor getTypeConstructor() {
        return this.typeConstructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    public MemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner r5) {
        Intrinsics.checkNotNullParameter(r5, "kotlinTypeRefiner");
        return this.memberScopeHolder.getScope(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    /* JADX INFO: renamed from: getUnsubstitutedPrimaryConstructor */
    public ClassConstructorDescriptor mo1396getUnsubstitutedPrimaryConstructor() {
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

    public final boolean hasNestedClass$deserialization(Name r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        return getMemberScope().getClassNames$deserialization().contains(r5);
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
        StringBuilder r5 = new StringBuilder("deserialized ");
        if (isExpect() == false) goto L5;
        String r10 = "expect ";
    L6:
        r5.append(r10);
        r5.append("class ");
        r5.append(getName());
        return r5.toString();
    L5:
        r10 = "";
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public MemberScopeImpl getStaticScope() {
        return this.staticScope;
    }
}
