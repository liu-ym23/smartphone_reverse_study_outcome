package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.resolve.MemberComparator$NameAndTypeMemberComparator;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class DeserializedMemberScope extends MemberScopeImpl {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private final DeserializationContext c;
    private final NotNullLazyValue classNames$delegate;
    private final NullableLazyValue classifierNamesLazy$delegate;
    private final Implementation impl;

    public interface Implementation {
        void addFunctionsAndPropertiesTo(Collection<DeclarationDescriptor> r1, DescriptorKindFilter r2, Function1<? super Name, Boolean> r3, LookupLocation r4);

        Collection<SimpleFunctionDescriptor> getContributedFunctions(Name r1, LookupLocation r2);

        Collection<PropertyDescriptor> getContributedVariables(Name r1, LookupLocation r2);

        Set<Name> getFunctionNames();

        TypeAliasDescriptor getTypeAliasByName(Name r1);

        Set<Name> getTypeAliasNames();

        Set<Name> getVariableNames();
    }

    public final class OptimizedImplementation implements Implementation {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
        private final NotNullLazyValue functionNames$delegate;
        private final Map<Name, byte[]> functionProtosBytes;
        private final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> functions;
        private final MemoizedFunctionToNotNull<Name, Collection<PropertyDescriptor>> properties;
        private final Map<Name, byte[]> propertyProtosBytes;
        final /* synthetic */ DeserializedMemberScope this$0;
        private final MemoizedFunctionToNullable<Name, TypeAliasDescriptor> typeAliasByName;
        private final Map<Name, byte[]> typeAliasBytes;
        private final NotNullLazyValue variableNames$delegate;

        static {
            $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(OptimizedImplementation.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(OptimizedImplementation.class), "variableNames", "getVariableNames()Ljava/util/Set;"))};
        }

        public static /* synthetic */ Collection accessor$DeserializedMemberScope$OptimizedImplementation$lambda0(OptimizedImplementation r0, Name r1) {
            return functions$lambda$5(r0, r1);
        }

        public static /* synthetic */ Collection accessor$DeserializedMemberScope$OptimizedImplementation$lambda1(OptimizedImplementation r0, Name r1) {
            return properties$lambda$6(r0, r1);
        }

        public static /* synthetic */ TypeAliasDescriptor accessor$DeserializedMemberScope$OptimizedImplementation$lambda2(OptimizedImplementation r0, Name r1) {
            return typeAliasByName$lambda$7(r0, r1);
        }

        public static /* synthetic */ Set accessor$DeserializedMemberScope$OptimizedImplementation$lambda3(OptimizedImplementation r0, DeserializedMemberScope r1) {
            return functionNames_delegate$lambda$8(r0, r1);
        }

        public static /* synthetic */ Set accessor$DeserializedMemberScope$OptimizedImplementation$lambda4(OptimizedImplementation r0, DeserializedMemberScope r1) {
            return variableNames_delegate$lambda$9(r0, r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Set<Name> getFunctionNames() {
            return (Set) StorageKt.getValue(this.functionNames$delegate, this, $$delegatedProperties[0]);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Set<Name> getTypeAliasNames() {
            return this.typeAliasBytes.keySet();
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Set<Name> getVariableNames() {
            return (Set) StorageKt.getValue(this.variableNames$delegate, this, $$delegatedProperties[1]);
        }

        private final Collection<SimpleFunctionDescriptor> computeFunctions(Name r6) {
            Map<Name, byte[]> r0 = this.functionProtosBytes;
            Parser<ProtoBuf$Function> r1 = ProtoBuf$Function.PARSER;
            DeserializedMemberScope r2 = this.this$0;
            byte[] r3 = r0.get(r6);
            if (r3 == null) goto L7;
            DeserializedMemberScope r4 = this.this$0;
            List r5 = SequencesKt.toList(SequencesKt.generateSequence(new DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1(r1, new ByteArrayInputStream(r3), r4)));
            if (r5 == null) goto L7;
            List r7 = r5;
        L8:
            List r8 = r7;
            ArrayList r9 = new ArrayList(r7.size());
            Iterator r10 = r8.iterator();
        L10:
            if (r10.hasNext() == false) goto L17;
            ProtoBuf$Function r11 = (ProtoBuf$Function) r10.next();
            MemberDeserializer r12 = r2.getC().getMemberDeserializer();
            Intrinsics.checkNotNull(r11);
            SimpleFunctionDescriptor r13 = r12.loadFunction(r11);
            if (r2.isDeclaredFunctionAvailable(r13) == true) goto L15;
            r13 = null;
        L15:
            if (r13 == null) goto L10;
            r9.add(r13);
            goto L10
        L17:
            r2.computeNonDeclaredFunctions(r6, r9);
            return CollectionsKt.compact(r9);
        L7:
            r7 = kotlin.collections.CollectionsKt.emptyList();
            goto L8
        }

        private final Collection<PropertyDescriptor> computeProperties(Name r6) {
            Map<Name, byte[]> r0 = this.propertyProtosBytes;
            Parser<ProtoBuf$Property> r1 = ProtoBuf$Property.PARSER;
            DeserializedMemberScope r2 = this.this$0;
            byte[] r3 = r0.get(r6);
            if (r3 == null) goto L7;
            DeserializedMemberScope r4 = this.this$0;
            List r5 = SequencesKt.toList(SequencesKt.generateSequence(new DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1(r1, new ByteArrayInputStream(r3), r4)));
            if (r5 == null) goto L7;
            List r7 = r5;
        L8:
            List r8 = r7;
            ArrayList r9 = new ArrayList(r7.size());
            Iterator r10 = r8.iterator();
        L10:
            if (r10.hasNext() == false) goto L14;
            ProtoBuf$Property r11 = (ProtoBuf$Property) r10.next();
            MemberDeserializer r12 = r2.getC().getMemberDeserializer();
            Intrinsics.checkNotNull(r11);
            PropertyDescriptor r13 = r12.loadProperty(r11);
            if (r13 == null) goto L10;
            r9.add(r13);
            goto L10
        L14:
            r2.computeNonDeclaredProperties(r6, r9);
            return CollectionsKt.compact(r9);
        L7:
            r7 = kotlin.collections.CollectionsKt.emptyList();
            goto L8
        }

        private final TypeAliasDescriptor createTypeAlias(Name r3) {
            byte[] r4 = this.typeAliasBytes.get(r3);
            if (r4 != null) goto L5;
            return null;
        L5:
            ProtoBuf$TypeAlias r5 = ProtoBuf$TypeAlias.parseDelimitedFrom(new ByteArrayInputStream(r4), this.this$0.getC().getComponents().getExtensionRegistryLite());
            if (r5 != null) goto L9;
            return null;
        L9:
            return this.this$0.getC().getMemberDeserializer().loadTypeAlias(r5);
        }

        private final Map<Name, byte[]> packToByteArray(Map<Name, ? extends Collection<? extends AbstractMessageLite>> r7) {
            LinkedHashMap r0 = new LinkedHashMap(MapsKt.mapCapacity(r7.size()));
            Iterator<T> r8 = r7.entrySet().iterator();
        L4:
            if (r8.hasNext() == false) goto L10;
            Map.Entry r1 = (Map.Entry) r8.next();
            Object r2 = r1.getKey();
            ByteArrayOutputStream r3 = new ByteArrayOutputStream();
            Iterable r4 = (Iterable) r1.getValue();
            ArrayList r5 = new ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(r4, 10));
            Iterator r6 = r4.iterator();
        L7:
            if (r6.hasNext() == false) goto L9;
            ((AbstractMessageLite) r6.next()).writeDelimitedTo(r3);
            r5.add(Unit.INSTANCE);
            goto L7
        L9:
            r0.put(r2, r3.toByteArray());
            goto L4
        L10:
            return r0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public TypeAliasDescriptor getTypeAliasByName(Name r2) {
            Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
            return (TypeAliasDescriptor) this.typeAliasByName.invoke(r2);
        }

        private static final Set functionNames_delegate$lambda$8(OptimizedImplementation r1, DeserializedMemberScope r2) {
            Intrinsics.checkNotNullParameter(r1, "this$0");
            Intrinsics.checkNotNullParameter(r2, "this$1");
            return SetsKt.plus(r1.functionProtosBytes.keySet(), r2.getNonDeclaredFunctionNames());
        }

        private static final Collection functions$lambda$5(OptimizedImplementation r1, Name r2) {
            Intrinsics.checkNotNullParameter(r1, "this$0");
            Intrinsics.checkNotNullParameter(r2, "it");
            return r1.computeFunctions(r2);
        }

        private static final Collection properties$lambda$6(OptimizedImplementation r1, Name r2) {
            Intrinsics.checkNotNullParameter(r1, "this$0");
            Intrinsics.checkNotNullParameter(r2, "it");
            return r1.computeProperties(r2);
        }

        private static final TypeAliasDescriptor typeAliasByName$lambda$7(OptimizedImplementation r1, Name r2) {
            Intrinsics.checkNotNullParameter(r1, "this$0");
            Intrinsics.checkNotNullParameter(r2, "it");
            return r1.createTypeAlias(r2);
        }

        private static final Set variableNames_delegate$lambda$9(OptimizedImplementation r1, DeserializedMemberScope r2) {
            Intrinsics.checkNotNullParameter(r1, "this$0");
            Intrinsics.checkNotNullParameter(r2, "this$1");
            return SetsKt.plus(r1.propertyProtosBytes.keySet(), r2.getNonDeclaredVariableNames());
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name r2, LookupLocation r3) {
            Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
            Intrinsics.checkNotNullParameter(r3, "location");
            if (getFunctionNames().contains(r2) == true) goto L7;
            return kotlin.collections.CollectionsKt.emptyList();
        L7:
            return (Collection) this.functions.invoke(r2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Collection<PropertyDescriptor> getContributedVariables(Name r2, LookupLocation r3) {
            Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
            Intrinsics.checkNotNullParameter(r3, "location");
            if (getVariableNames().contains(r2) == true) goto L7;
            return kotlin.collections.CollectionsKt.emptyList();
        L7:
            return (Collection) this.properties.invoke(r2);
        }

        public OptimizedImplementation(DeserializedMemberScope r5, List<ProtoBuf$Function> r6, List<ProtoBuf$Property> r7, List<ProtoBuf$TypeAlias> r8) {
            Intrinsics.checkNotNullParameter(r6, "functionList");
            Intrinsics.checkNotNullParameter(r7, "propertyList");
            Intrinsics.checkNotNullParameter(r8, "typeAliasList");
            this.this$0 = r5;
            LinkedHashMap r0 = new LinkedHashMap();
            Iterator<T> r9 = r6.iterator();
        L4:
            if (r9.hasNext() == false) goto L9;
            Object r1 = r9.next();
            Name r2 = NameResolverUtilKt.getName(r5.getC().getNameResolver(), ((ProtoBuf$Function) ((MessageLite) r1)).getName());
            Object r3 = r0.get(r2);
            if (r3 != null) goto L8;
            r3 = new ArrayList();
            r0.put(r2, r3);
        L8:
            ((List) r3).add(r1);
            goto L4
        L9:
            this.functionProtosBytes = packToByteArray(r0);
            DeserializedMemberScope r10 = this.this$0;
            LinkedHashMap r11 = new LinkedHashMap();
            Iterator<T> r12 = r7.iterator();
        L11:
            if (r12.hasNext() == false) goto L16;
            Object r4 = r12.next();
            Name r13 = NameResolverUtilKt.getName(r10.getC().getNameResolver(), ((ProtoBuf$Property) ((MessageLite) r4)).getName());
            Object r14 = r11.get(r13);
            if (r14 != null) goto L15;
            r14 = new ArrayList();
            r11.put(r13, r14);
        L15:
            ((List) r14).add(r4);
            goto L11
        L16:
            this.propertyProtosBytes = packToByteArray(r11);
            if (this.this$0.getC().getComponents().getConfiguration().getTypeAliasesAllowed() == false) goto L26;
            DeserializedMemberScope r15 = this.this$0;
            LinkedHashMap r16 = new LinkedHashMap();
            Iterator<T> r17 = r8.iterator();
        L20:
            if (r17.hasNext() == false) goto L25;
            Object r18 = r17.next();
            Name r19 = NameResolverUtilKt.getName(r15.getC().getNameResolver(), ((ProtoBuf$TypeAlias) ((MessageLite) r18)).getName());
            Object r20 = r16.get(r19);
            if (r20 != null) goto L24;
            r20 = new ArrayList();
            r16.put(r19, r20);
        L24:
            ((List) r20).add(r18);
            goto L20
        L25:
            Map<Name, byte[]> r21 = packToByteArray(r16);
        L27:
            this.typeAliasBytes = r21;
            this.functions = this.this$0.getC().getStorageManager().createMemoizedFunction(new DeserializedMemberScope$OptimizedImplementation$$Lambda$0(this));
            this.properties = this.this$0.getC().getStorageManager().createMemoizedFunction(new DeserializedMemberScope$OptimizedImplementation$$Lambda$1(this));
            this.typeAliasByName = this.this$0.getC().getStorageManager().createMemoizedFunctionWithNullableValues(new DeserializedMemberScope$OptimizedImplementation$$Lambda$2(this));
            StorageManager r22 = this.this$0.getC().getStorageManager();
            final DeserializedMemberScope r23 = this.this$0;
            this.functionNames$delegate = r22.createLazyValue(new DeserializedMemberScope$OptimizedImplementation$$Lambda$3(this, r23));
            StorageManager r24 = this.this$0.getC().getStorageManager();
            final DeserializedMemberScope r25 = this.this$0;
            this.variableNames$delegate = r24.createLazyValue(new DeserializedMemberScope$OptimizedImplementation$$Lambda$4(this, r25));
            return;
        L26:
            r21 = MapsKt.emptyMap();
            goto L27
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public void addFunctionsAndPropertiesTo(Collection<DeclarationDescriptor> r5, DescriptorKindFilter r6, Function1<? super Name, Boolean> r7, LookupLocation r8) {
            Intrinsics.checkNotNullParameter(r5, "result");
            Intrinsics.checkNotNullParameter(r6, "kindFilter");
            Intrinsics.checkNotNullParameter(r7, "nameFilter");
            Intrinsics.checkNotNullParameter(r8, "location");
            if (r6.acceptsKinds(DescriptorKindFilter.Companion.getVARIABLES_MASK()) == false) goto L12;
            Set<Name> r0 = getVariableNames();
            ArrayList r1 = new ArrayList();
            Iterator<Name> r2 = r0.iterator();
        L6:
            if (r2.hasNext() == false) goto L10;
            Name r3 = r2.next();
            if (((Boolean) r7.invoke(r3)).booleanValue() == false) goto L6;
            r1.addAll(getContributedVariables(r3, r8));
            goto L6
        L10:
            kotlin.collections.CollectionsKt.sortWith(r1, MemberComparator$NameAndTypeMemberComparator.INSTANCE);
            r5.addAll(r1);
        L12:
            if (r6.acceptsKinds(DescriptorKindFilter.Companion.getFUNCTIONS_MASK()) == false) goto L31;
            Set<Name> r9 = getFunctionNames();
            ArrayList r4 = new ArrayList();
            Iterator<Name> r10 = r9.iterator();
        L15:
            if (r10.hasNext() == false) goto L19;
            Name r11 = r10.next();
            if (((Boolean) r7.invoke(r11)).booleanValue() == false) goto L15;
            r4.addAll(getContributedFunctions(r11, r8));
            goto L15
        L19:
            kotlin.collections.CollectionsKt.sortWith(r4, MemberComparator$NameAndTypeMemberComparator.INSTANCE);
            r5.addAll(r4);
            return;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DeserializedMemberScope.class), "classNames", "getClassNames$deserialization()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DeserializedMemberScope.class), "classifierNamesLazy", "getClassifierNamesLazy()Ljava/util/Set;"))};
    }

    public static /* synthetic */ Set accessor$DeserializedMemberScope$lambda0(Function0 r0) {
        return classNames_delegate$lambda$0(r0);
    }

    public static /* synthetic */ Set accessor$DeserializedMemberScope$lambda1(DeserializedMemberScope r0) {
        return classifierNamesLazy_delegate$lambda$1(r0);
    }

    public abstract void addEnumEntryDescriptors(Collection<DeclarationDescriptor> r1, Function1<? super Name, Boolean> r2);

    public void computeNonDeclaredFunctions(Name r2, List<SimpleFunctionDescriptor> r3) {
        Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
        Intrinsics.checkNotNullParameter(r3, "functions");
    }

    public void computeNonDeclaredProperties(Name r2, List<PropertyDescriptor> r3) {
        Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
        Intrinsics.checkNotNullParameter(r3, "descriptors");
    }

    public abstract ClassId createClassId(Name r1);

    public abstract Set<Name> getNonDeclaredClassifierNames();

    public abstract Set<Name> getNonDeclaredFunctionNames();

    public abstract Set<Name> getNonDeclaredVariableNames();

    public boolean isDeclaredFunctionAvailable(SimpleFunctionDescriptor r2) {
        Intrinsics.checkNotNullParameter(r2, "function");
        return true;
    }

    private final Set<Name> getClassifierNamesLazy() {
        return (Set) StorageKt.getValue(this.classifierNamesLazy$delegate, this, $$delegatedProperties[1]);
    }

    public final Set<Name> getClassNames$deserialization() {
        return (Set) StorageKt.getValue(this.classNames$delegate, this, $$delegatedProperties[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getFunctionNames() {
        return this.impl.getFunctionNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getVariableNames() {
        return this.impl.getVariableNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getClassifierNames() {
        return getClassifierNamesLazy();
    }

    public final DeserializationContext getC() {
        return this.c;
    }

    private static final Set classNames_delegate$lambda$0(Function0 r1) {
        Intrinsics.checkNotNullParameter(r1, "$classNames");
        return kotlin.collections.CollectionsKt.toSet((Iterable) r1.invoke());
    }

    private static final Set classifierNamesLazy_delegate$lambda$1(DeserializedMemberScope r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Set<Name> r0 = r2.getNonDeclaredClassifierNames();
        if (r0 != null) goto L7;
        return null;
    L7:
        return SetsKt.plus(SetsKt.plus(r2.getClassNames$deserialization(), r2.impl.getTypeAliasNames()), r0);
    }

    private final ClassDescriptor deserializeClass(Name r2) {
        return this.c.getComponents().deserializeClass(createClassId(r2));
    }

    private final TypeAliasDescriptor getTypeAliasByName(Name r2) {
        return this.impl.getTypeAliasByName(r2);
    }

    public boolean hasClass(Name r2) {
        Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
        return getClassNames$deserialization().contains(r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public ClassifierDescriptor mo383getContributedClassifier(Name r2, LookupLocation r3) {
        Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
        Intrinsics.checkNotNullParameter(r3, "location");
        if (hasClass(r2) == false) goto L6;
        return deserializeClass(r2);
    L6:
        if (this.impl.getTypeAliasNames().contains(r2) == true) goto L11;
        return null;
    L11:
        return getTypeAliasByName(r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name r2, LookupLocation r3) {
        Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
        Intrinsics.checkNotNullParameter(r3, "location");
        return this.impl.getContributedFunctions(r2, r3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name r2, LookupLocation r3) {
        Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
        Intrinsics.checkNotNullParameter(r3, "location");
        return this.impl.getContributedVariables(r2, r3);
    }

    private final Implementation createImplementation(List<ProtoBuf$Function> r2, List<ProtoBuf$Property> r3, List<ProtoBuf$TypeAlias> r4) {
        if (this.c.getComponents().getConfiguration().getPreserveDeclarationsOrdering() == false) goto L6;
        return new NoReorderImplementation(this, r2, r3, r4);
    L6:
        return new OptimizedImplementation(this, r2, r3, r4);
    }

    public final Collection<DeclarationDescriptor> computeDescriptors(DescriptorKindFilter r4, Function1<? super Name, Boolean> r5, LookupLocation r6) {
        Intrinsics.checkNotNullParameter(r4, "kindFilter");
        Intrinsics.checkNotNullParameter(r5, "nameFilter");
        Intrinsics.checkNotNullParameter(r6, "location");
        ArrayList r0 = new ArrayList(0);
        DescriptorKindFilter.Companion r1 = DescriptorKindFilter.Companion;
        if (r4.acceptsKinds(r1.getSINGLETON_CLASSIFIERS_MASK()) == false) goto L5;
        addEnumEntryDescriptors(r0, r5);
    L5:
        this.impl.addFunctionsAndPropertiesTo(r0, r4, r5, r6);
        if (r4.acceptsKinds(r1.getCLASSIFIERS_MASK()) == false) goto L14;
        Iterator<Name> r7 = getClassNames$deserialization().iterator();
    L9:
        if (r7.hasNext() == false) goto L14;
        Name r2 = r7.next();
        if (((Boolean) r5.invoke(r2)).booleanValue() == false) goto L9;
        CollectionsKt.addIfNotNull(r0, deserializeClass(r2));
    L14:
        if (r4.acceptsKinds(DescriptorKindFilter.Companion.getTYPE_ALIASES_MASK()) == false) goto L22;
        Iterator<Name> r8 = this.impl.getTypeAliasNames().iterator();
    L17:
        if (r8.hasNext() == false) goto L22;
        Name r9 = r8.next();
        if (((Boolean) r5.invoke(r9)).booleanValue() == false) goto L17;
        CollectionsKt.addIfNotNull(r0, this.impl.getTypeAliasByName(r9));
    L22:
        return CollectionsKt.compact(r0);
    }

    public DeserializedMemberScope(DeserializationContext r2, List<ProtoBuf$Function> r3, List<ProtoBuf$Property> r4, List<ProtoBuf$TypeAlias> r5, final Function0<? extends Collection<Name>> r6) {
        Intrinsics.checkNotNullParameter(r2, "c");
        Intrinsics.checkNotNullParameter(r3, "functionList");
        Intrinsics.checkNotNullParameter(r4, "propertyList");
        Intrinsics.checkNotNullParameter(r5, "typeAliasList");
        Intrinsics.checkNotNullParameter(r6, "classNames");
        this.c = r2;
        this.impl = createImplementation(r3, r4, r5);
        this.classNames$delegate = r2.getStorageManager().createLazyValue(new DeserializedMemberScope$$Lambda$0(r6));
        this.classifierNamesLazy$delegate = r2.getStorageManager().createNullableLazyValue(new DeserializedMemberScope$$Lambda$1(this));
    }
}
