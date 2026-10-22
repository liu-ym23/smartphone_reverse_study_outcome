package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
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
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.resolve.MemberComparator;
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
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DeserializedMemberScope extends MemberScopeImpl {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DeserializationContext f10221c;
    private final NotNullLazyValue classNames$delegate;
    private final NullableLazyValue classifierNamesLazy$delegate;
    private final Implementation impl;

    private interface Implementation {
        void addFunctionsAndPropertiesTo(Collection<DeclarationDescriptor> r10, DescriptorKindFilter r11, Function1<? super Name, Boolean> r12, LookupLocation r13);

        Collection<SimpleFunctionDescriptor> getContributedFunctions(Name r10, LookupLocation r11);

        Collection<PropertyDescriptor> getContributedVariables(Name r10, LookupLocation r11);

        Set<Name> getFunctionNames();

        TypeAliasDescriptor getTypeAliasByName(Name r10);

        Set<Name> getTypeAliasNames();

        Set<Name> getVariableNames();
    }

    private final class NoReorderImplementation implements Implementation {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
        private final NotNullLazyValue allFunctions$delegate;
        private final NotNullLazyValue allProperties$delegate;
        private final NotNullLazyValue allTypeAliases$delegate;
        private final NotNullLazyValue declaredFunctions$delegate;
        private final NotNullLazyValue declaredProperties$delegate;
        private final List<ProtoBuf.Function> functionList;
        private final NotNullLazyValue functionNames$delegate;
        private final NotNullLazyValue functionsByName$delegate;
        private final NotNullLazyValue propertiesByName$delegate;
        private final List<ProtoBuf.Property> propertyList;
        final /* synthetic */ DeserializedMemberScope this$0;
        private final List<ProtoBuf.TypeAlias> typeAliasList;
        private final NotNullLazyValue typeAliasesByName$delegate;
        private final NotNullLazyValue variableNames$delegate;

        static {
            $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(NoReorderImplementation.class), "declaredFunctions", "getDeclaredFunctions()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(NoReorderImplementation.class), "declaredProperties", "getDeclaredProperties()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(NoReorderImplementation.class), "allTypeAliases", "getAllTypeAliases()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(NoReorderImplementation.class), "allFunctions", "getAllFunctions()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(NoReorderImplementation.class), "allProperties", "getAllProperties()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(NoReorderImplementation.class), "typeAliasesByName", "getTypeAliasesByName()Ljava/util/Map;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(NoReorderImplementation.class), "functionsByName", "getFunctionsByName()Ljava/util/Map;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(NoReorderImplementation.class), "propertiesByName", "getPropertiesByName()Ljava/util/Map;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(NoReorderImplementation.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(NoReorderImplementation.class), "variableNames", "getVariableNames()Ljava/util/Set;"))};
        }

        public NoReorderImplementation(final DeserializedMemberScope r10, List<ProtoBuf.Function> r11, List<ProtoBuf.Property> r12, List<ProtoBuf.TypeAlias> r13) {
            Intrinsics.checkNotNullParameter(r11, "functionList");
            Intrinsics.checkNotNullParameter(r12, "propertyList");
            Intrinsics.checkNotNullParameter(r13, "typeAliasList");
            this.this$0 = r10;
            this.functionList = r11;
            this.propertyList = r12;
            if (r10.getC().getComponents().getConfiguration().getTypeAliasesAllowed() == true) goto L6;
            r13 = CollectionsKt.emptyList();
        L6:
            this.typeAliasList = r13;
            this.declaredFunctions$delegate = r10.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$declaredFunctions$2(this));
            this.declaredProperties$delegate = r10.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$declaredProperties$2(this));
            this.allTypeAliases$delegate = r10.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$allTypeAliases$2(this));
            this.allFunctions$delegate = r10.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$allFunctions$2(this));
            this.allProperties$delegate = r10.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$allProperties$2(this));
            this.typeAliasesByName$delegate = r10.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$typeAliasesByName$2(this));
            this.functionsByName$delegate = r10.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$functionsByName$2(this));
            this.propertiesByName$delegate = r10.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$propertiesByName$2(this));
            this.functionNames$delegate = r10.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$functionNames$2(this, r10));
            this.variableNames$delegate = r10.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$variableNames$2(this, r10));
        }

        public static final /* synthetic */ List access$computeAllNonDeclaredFunctions(NoReorderImplementation r10) {
            return r10.computeAllNonDeclaredFunctions();
        }

        public static final /* synthetic */ List access$computeAllNonDeclaredProperties(NoReorderImplementation r10) {
            return r10.computeAllNonDeclaredProperties();
        }

        public static final /* synthetic */ List access$computeFunctions(NoReorderImplementation r10) {
            return r10.computeFunctions();
        }

        public static final /* synthetic */ List access$computeProperties(NoReorderImplementation r10) {
            return r10.computeProperties();
        }

        public static final /* synthetic */ List access$computeTypeAliases(NoReorderImplementation r10) {
            return r10.computeTypeAliases();
        }

        public static final /* synthetic */ List access$getAllFunctions(NoReorderImplementation r10) {
            return r10.getAllFunctions();
        }

        public static final /* synthetic */ List access$getAllProperties(NoReorderImplementation r10) {
            return r10.getAllProperties();
        }

        public static final /* synthetic */ List access$getAllTypeAliases(NoReorderImplementation r10) {
            return r10.getAllTypeAliases();
        }

        public static final /* synthetic */ List access$getDeclaredFunctions(NoReorderImplementation r10) {
            return r10.getDeclaredFunctions();
        }

        public static final /* synthetic */ List access$getDeclaredProperties(NoReorderImplementation r10) {
            return r10.getDeclaredProperties();
        }

        public static final /* synthetic */ List access$getFunctionList$p(NoReorderImplementation r10) {
            return r10.functionList;
        }

        public static final /* synthetic */ List access$getPropertyList$p(NoReorderImplementation r10) {
            return r10.propertyList;
        }

        private final List<SimpleFunctionDescriptor> computeAllNonDeclaredFunctions() {
            Set<Name> r10 = this.this$0.getNonDeclaredFunctionNames();
            ArrayList r11 = new ArrayList();
            Iterator<T> r12 = r10.iterator();
        L4:
            if (r12.hasNext() == false) goto L6;
            CollectionsKt.addAll(r11, computeNonDeclaredFunctionsForName((Name) r12.next()));
            goto L4
        L6:
            return r11;
        }

        private final List<PropertyDescriptor> computeAllNonDeclaredProperties() {
            Set<Name> r10 = this.this$0.getNonDeclaredVariableNames();
            ArrayList r11 = new ArrayList();
            Iterator<T> r12 = r10.iterator();
        L4:
            if (r12.hasNext() == false) goto L6;
            CollectionsKt.addAll(r11, computeNonDeclaredPropertiesForName((Name) r12.next()));
            goto L4
        L6:
            return r11;
        }

        private final List<SimpleFunctionDescriptor> computeFunctions() {
            List<ProtoBuf.Function> r10 = this.functionList;
            DeserializedMemberScope r11 = this.this$0;
            ArrayList r12 = new ArrayList();
            Iterator<T> r13 = r10.iterator();
        L4:
            if (r13.hasNext() == false) goto L11;
            MessageLite r14 = (MessageLite) r13.next();
            SimpleFunctionDescriptor r15 = r11.getC().getMemberDeserializer().loadFunction((ProtoBuf.Function) r14);
            if (r11.isDeclaredFunctionAvailable(r15) == true) goto L9;
            r15 = null;
        L9:
            if (r15 == null) goto L4;
            r12.add(r15);
            goto L4
        L11:
            return r12;
        }

        private final List<SimpleFunctionDescriptor> computeNonDeclaredFunctionsForName(Name r10) {
            List<SimpleFunctionDescriptor> r11 = getDeclaredFunctions();
            DeserializedMemberScope r12 = this.this$0;
            ArrayList r13 = new ArrayList();
            Iterator<T> r14 = r11.iterator();
        L4:
            if (r14.hasNext() == false) goto L8;
            Object r15 = r14.next();
            if (Intrinsics.areEqual(((DeclarationDescriptor) r15).getName(), r10) == false) goto L4;
            r13.add(r15);
            goto L4
        L8:
            int r16 = r13.size();
            r12.computeNonDeclaredFunctions(r10, r13);
            return r13.subList(r16, r13.size());
        }

        private final List<PropertyDescriptor> computeNonDeclaredPropertiesForName(Name r10) {
            List<PropertyDescriptor> r11 = getDeclaredProperties();
            DeserializedMemberScope r12 = this.this$0;
            ArrayList r13 = new ArrayList();
            Iterator<T> r14 = r11.iterator();
        L4:
            if (r14.hasNext() == false) goto L8;
            Object r15 = r14.next();
            if (Intrinsics.areEqual(((DeclarationDescriptor) r15).getName(), r10) == false) goto L4;
            r13.add(r15);
            goto L4
        L8:
            int r16 = r13.size();
            r12.computeNonDeclaredProperties(r10, r13);
            return r13.subList(r16, r13.size());
        }

        private final List<PropertyDescriptor> computeProperties() {
            List<ProtoBuf.Property> r10 = this.propertyList;
            DeserializedMemberScope r11 = this.this$0;
            ArrayList r12 = new ArrayList();
            Iterator<T> r13 = r10.iterator();
        L4:
            if (r13.hasNext() == false) goto L8;
            MessageLite r14 = (MessageLite) r13.next();
            PropertyDescriptor r15 = r11.getC().getMemberDeserializer().loadProperty((ProtoBuf.Property) r14);
            if (r15 == null) goto L4;
            r12.add(r15);
            goto L4
        L8:
            return r12;
        }

        private final List<TypeAliasDescriptor> computeTypeAliases() {
            List<ProtoBuf.TypeAlias> r10 = this.typeAliasList;
            DeserializedMemberScope r11 = this.this$0;
            ArrayList r12 = new ArrayList();
            Iterator<T> r13 = r10.iterator();
        L4:
            if (r13.hasNext() == false) goto L8;
            MessageLite r14 = (MessageLite) r13.next();
            TypeAliasDescriptor r15 = r11.getC().getMemberDeserializer().loadTypeAlias((ProtoBuf.TypeAlias) r14);
            if (r15 == null) goto L4;
            r12.add(r15);
            goto L4
        L8:
            return r12;
        }

        private final List<SimpleFunctionDescriptor> getAllFunctions() {
            return (List) StorageKt.getValue(this.allFunctions$delegate, this, $$delegatedProperties[3]);
        }

        private final List<PropertyDescriptor> getAllProperties() {
            return (List) StorageKt.getValue(this.allProperties$delegate, this, $$delegatedProperties[4]);
        }

        private final List<TypeAliasDescriptor> getAllTypeAliases() {
            return (List) StorageKt.getValue(this.allTypeAliases$delegate, this, $$delegatedProperties[2]);
        }

        private final List<SimpleFunctionDescriptor> getDeclaredFunctions() {
            return (List) StorageKt.getValue(this.declaredFunctions$delegate, this, $$delegatedProperties[0]);
        }

        private final List<PropertyDescriptor> getDeclaredProperties() {
            return (List) StorageKt.getValue(this.declaredProperties$delegate, this, $$delegatedProperties[1]);
        }

        private final Map<Name, Collection<SimpleFunctionDescriptor>> getFunctionsByName() {
            return (Map) StorageKt.getValue(this.functionsByName$delegate, this, $$delegatedProperties[6]);
        }

        private final Map<Name, Collection<PropertyDescriptor>> getPropertiesByName() {
            return (Map) StorageKt.getValue(this.propertiesByName$delegate, this, $$delegatedProperties[7]);
        }

        private final Map<Name, TypeAliasDescriptor> getTypeAliasesByName() {
            return (Map) StorageKt.getValue(this.typeAliasesByName$delegate, this, $$delegatedProperties[5]);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public void addFunctionsAndPropertiesTo(Collection<DeclarationDescriptor> r10, DescriptorKindFilter r11, Function1<? super Name, Boolean> r12, LookupLocation r13) {
            Intrinsics.checkNotNullParameter(r10, "result");
            Intrinsics.checkNotNullParameter(r11, "kindFilter");
            Intrinsics.checkNotNullParameter(r12, "nameFilter");
            Intrinsics.checkNotNullParameter(r13, "location");
            if (r11.acceptsKinds(DescriptorKindFilter.Companion.getVARIABLES_MASK()) == false) goto L11;
            Iterator<T> r14 = getAllProperties().iterator();
        L6:
            if (r14.hasNext() == false) goto L11;
            Object r15 = r14.next();
            Name r16 = ((PropertyDescriptor) r15).getName();
            Intrinsics.checkNotNullExpressionValue(r16, "it.name");
            if (r12.invoke(r16).booleanValue() == false) goto L6;
            r10.add(r15);
        L11:
            if (r11.acceptsKinds(DescriptorKindFilter.Companion.getFUNCTIONS_MASK()) == false) goto L18;
            Iterator<T> r17 = getAllFunctions().iterator();
        L14:
            if (r17.hasNext() == false) goto L29;
            Object r18 = r17.next();
            Name r19 = ((SimpleFunctionDescriptor) r18).getName();
            Intrinsics.checkNotNullExpressionValue(r19, "it.name");
            if (r12.invoke(r19).booleanValue() == false) goto L14;
            r10.add(r18);
            goto L14
        L29:
            return;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name r10, LookupLocation r11) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r11, "location");
            if (getFunctionNames().contains(r10) == false) goto L5;
            Collection<SimpleFunctionDescriptor> r12 = getFunctionsByName().get(r10);
            if (r12 == null) goto L9;
            return r12;
        L9:
            return CollectionsKt.emptyList();
        L5:
            return CollectionsKt.emptyList();
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Collection<PropertyDescriptor> getContributedVariables(Name r10, LookupLocation r11) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r11, "location");
            if (getVariableNames().contains(r10) == false) goto L5;
            Collection<PropertyDescriptor> r12 = getPropertiesByName().get(r10);
            if (r12 == null) goto L9;
            return r12;
        L9:
            return CollectionsKt.emptyList();
        L5:
            return CollectionsKt.emptyList();
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Set<Name> getFunctionNames() {
            return (Set) StorageKt.getValue(this.functionNames$delegate, this, $$delegatedProperties[8]);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public TypeAliasDescriptor getTypeAliasByName(Name r10) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            return getTypeAliasesByName().get(r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Set<Name> getTypeAliasNames() {
            List<ProtoBuf.TypeAlias> r10 = this.typeAliasList;
            LinkedHashSet r11 = new LinkedHashSet();
            DeserializedMemberScope r12 = this.this$0;
            Iterator<T> r13 = r10.iterator();
        L4:
            if (r13.hasNext() == false) goto L6;
            MessageLite r14 = (MessageLite) r13.next();
            r11.add(NameResolverUtilKt.getName(r12.getC().getNameResolver(), ((ProtoBuf.TypeAlias) r14).getName()));
            goto L4
        L6:
            return r11;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Set<Name> getVariableNames() {
            return (Set) StorageKt.getValue(this.variableNames$delegate, this, $$delegatedProperties[9]);
        }
    }

    private final class OptimizedImplementation implements Implementation {
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

        public OptimizedImplementation(DeserializedMemberScope r10, List<ProtoBuf.Function> r11, List<ProtoBuf.Property> r12, List<ProtoBuf.TypeAlias> r13) {
            Intrinsics.checkNotNullParameter(r11, "functionList");
            Intrinsics.checkNotNullParameter(r12, "propertyList");
            Intrinsics.checkNotNullParameter(r13, "typeAliasList");
            this.this$0 = r10;
            LinkedHashMap r14 = new LinkedHashMap();
            Iterator<T> r15 = r11.iterator();
        L4:
            if (r15.hasNext() == false) goto L9;
            Object r16 = r15.next();
            Name r17 = NameResolverUtilKt.getName(r10.getC().getNameResolver(), ((ProtoBuf.Function) ((MessageLite) r16)).getName());
            Object r18 = r14.get(r17);
            if (r18 != null) goto L8;
            r18 = new ArrayList();
            r14.put(r17, r18);
        L8:
            ((List) r18).add(r16);
            goto L4
        L9:
            this.functionProtosBytes = packToByteArray(r14);
            DeserializedMemberScope r19 = this.this$0;
            LinkedHashMap r20 = new LinkedHashMap();
            Iterator<T> r21 = r12.iterator();
        L11:
            if (r21.hasNext() == false) goto L16;
            Object r22 = r21.next();
            Name r23 = NameResolverUtilKt.getName(r19.getC().getNameResolver(), ((ProtoBuf.Property) ((MessageLite) r22)).getName());
            Object r24 = r20.get(r23);
            if (r24 != null) goto L15;
            r24 = new ArrayList();
            r20.put(r23, r24);
        L15:
            ((List) r24).add(r22);
            goto L11
        L16:
            this.propertyProtosBytes = packToByteArray(r20);
            if (this.this$0.getC().getComponents().getConfiguration().getTypeAliasesAllowed() == false) goto L26;
            DeserializedMemberScope r25 = this.this$0;
            LinkedHashMap r26 = new LinkedHashMap();
            Iterator<T> r27 = r13.iterator();
        L20:
            if (r27.hasNext() == false) goto L25;
            Object r28 = r27.next();
            Name r29 = NameResolverUtilKt.getName(r25.getC().getNameResolver(), ((ProtoBuf.TypeAlias) ((MessageLite) r28)).getName());
            Object r30 = r26.get(r29);
            if (r30 != null) goto L24;
            r30 = new ArrayList();
            r26.put(r29, r30);
        L24:
            ((List) r30).add(r28);
            goto L20
        L25:
            Map<Name, byte[]> r31 = packToByteArray(r26);
        L27:
            this.typeAliasBytes = r31;
            this.functions = this.this$0.getC().getStorageManager().createMemoizedFunction(new DeserializedMemberScope$OptimizedImplementation$functions$1(this));
            this.properties = this.this$0.getC().getStorageManager().createMemoizedFunction(new DeserializedMemberScope$OptimizedImplementation$properties$1(this));
            this.typeAliasByName = this.this$0.getC().getStorageManager().createMemoizedFunctionWithNullableValues(new DeserializedMemberScope$OptimizedImplementation$typeAliasByName$1(this));
            StorageManager r32 = this.this$0.getC().getStorageManager();
            final DeserializedMemberScope r33 = this.this$0;
            this.functionNames$delegate = r32.createLazyValue(new DeserializedMemberScope$OptimizedImplementation$functionNames$2(this, r33));
            StorageManager r34 = this.this$0.getC().getStorageManager();
            final DeserializedMemberScope r35 = this.this$0;
            this.variableNames$delegate = r34.createLazyValue(new DeserializedMemberScope$OptimizedImplementation$variableNames$2(this, r35));
            return;
        L26:
            r31 = MapsKt.emptyMap();
            goto L27
        }

        public static final /* synthetic */ Collection access$computeFunctions(OptimizedImplementation r10, Name r11) {
            return r10.computeFunctions(r11);
        }

        public static final /* synthetic */ Collection access$computeProperties(OptimizedImplementation r10, Name r11) {
            return r10.computeProperties(r11);
        }

        public static final /* synthetic */ TypeAliasDescriptor access$createTypeAlias(OptimizedImplementation r10, Name r11) {
            return r10.createTypeAlias(r11);
        }

        public static final /* synthetic */ Map access$getFunctionProtosBytes$p(OptimizedImplementation r10) {
            return r10.functionProtosBytes;
        }

        public static final /* synthetic */ Map access$getPropertyProtosBytes$p(OptimizedImplementation r10) {
            return r10.propertyProtosBytes;
        }

        private final Collection<SimpleFunctionDescriptor> computeFunctions(Name r10) {
            Map<Name, byte[]> r11 = this.functionProtosBytes;
            Parser<ProtoBuf.Function> r12 = ProtoBuf.Function.PARSER;
            Intrinsics.checkNotNullExpressionValue(r12, "PARSER");
            DeserializedMemberScope r13 = this.this$0;
            byte[] r14 = r11.get(r10);
            if (r14 == null) goto L7;
            DeserializedMemberScope r15 = this.this$0;
            List r16 = SequencesKt.toList(SequencesKt.generateSequence(new DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1(r12, new ByteArrayInputStream(r14), r15)));
            if (r16 == null) goto L7;
        L8:
            ArrayList r17 = new ArrayList(r16.size());
            Iterator r18 = r16.iterator();
        L10:
            if (r18.hasNext() == false) goto L17;
            ProtoBuf.Function r19 = (ProtoBuf.Function) r18.next();
            MemberDeserializer r20 = r13.getC().getMemberDeserializer();
            Intrinsics.checkNotNullExpressionValue(r19, "it");
            SimpleFunctionDescriptor r21 = r20.loadFunction(r19);
            if (r13.isDeclaredFunctionAvailable(r21) == true) goto L15;
            r21 = null;
        L15:
            if (r21 == null) goto L10;
            r17.add(r21);
            goto L10
        L17:
            r13.computeNonDeclaredFunctions(r10, r17);
            return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(r17);
        L7:
            r16 = CollectionsKt.emptyList();
            goto L8
        }

        private final Collection<PropertyDescriptor> computeProperties(Name r10) {
            Map<Name, byte[]> r11 = this.propertyProtosBytes;
            Parser<ProtoBuf.Property> r12 = ProtoBuf.Property.PARSER;
            Intrinsics.checkNotNullExpressionValue(r12, "PARSER");
            DeserializedMemberScope r13 = this.this$0;
            byte[] r14 = r11.get(r10);
            if (r14 == null) goto L7;
            DeserializedMemberScope r15 = this.this$0;
            List r16 = SequencesKt.toList(SequencesKt.generateSequence(new DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1(r12, new ByteArrayInputStream(r14), r15)));
            if (r16 == null) goto L7;
        L8:
            ArrayList r17 = new ArrayList(r16.size());
            Iterator r18 = r16.iterator();
        L10:
            if (r18.hasNext() == false) goto L14;
            ProtoBuf.Property r19 = (ProtoBuf.Property) r18.next();
            MemberDeserializer r20 = r13.getC().getMemberDeserializer();
            Intrinsics.checkNotNullExpressionValue(r19, "it");
            PropertyDescriptor r21 = r20.loadProperty(r19);
            if (r21 == null) goto L10;
            r17.add(r21);
            goto L10
        L14:
            r13.computeNonDeclaredProperties(r10, r17);
            return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(r17);
        L7:
            r16 = CollectionsKt.emptyList();
            goto L8
        }

        private final TypeAliasDescriptor createTypeAlias(Name r10) {
            byte[] r11 = this.typeAliasBytes.get(r10);
            if (r11 != null) goto L5;
            return null;
        L5:
            ProtoBuf.TypeAlias r12 = ProtoBuf.TypeAlias.parseDelimitedFrom(new ByteArrayInputStream(r11), this.this$0.getC().getComponents().getExtensionRegistryLite());
            if (r12 != null) goto L9;
            return null;
        L9:
            return this.this$0.getC().getMemberDeserializer().loadTypeAlias(r12);
        }

        private final Map<Name, byte[]> packToByteArray(Map<Name, ? extends Collection<? extends AbstractMessageLite>> r10) {
            LinkedHashMap r11 = new LinkedHashMap(MapsKt.mapCapacity(r10.size()));
            Iterator<T> r12 = r10.entrySet().iterator();
        L4:
            if (r12.hasNext() == false) goto L10;
            Map.Entry r13 = (Map.Entry) r12.next();
            Object r14 = r13.getKey();
            ByteArrayOutputStream r15 = new ByteArrayOutputStream();
            Iterable r16 = (Iterable) r13.getValue();
            ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
            Iterator r18 = r16.iterator();
        L7:
            if (r18.hasNext() == false) goto L9;
            ((AbstractMessageLite) r18.next()).writeDelimitedTo(r15);
            r17.add(Unit.INSTANCE);
            goto L7
        L9:
            r11.put(r14, r15.toByteArray());
            goto L4
        L10:
            return r11;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public void addFunctionsAndPropertiesTo(Collection<DeclarationDescriptor> r10, DescriptorKindFilter r11, Function1<? super Name, Boolean> r12, LookupLocation r13) {
            Intrinsics.checkNotNullParameter(r10, "result");
            Intrinsics.checkNotNullParameter(r11, "kindFilter");
            Intrinsics.checkNotNullParameter(r12, "nameFilter");
            Intrinsics.checkNotNullParameter(r13, "location");
            if (r11.acceptsKinds(DescriptorKindFilter.Companion.getVARIABLES_MASK()) == false) goto L12;
            Set<Name> r14 = getVariableNames();
            ArrayList r15 = new ArrayList();
            Iterator<Name> r16 = r14.iterator();
        L6:
            if (r16.hasNext() == false) goto L10;
            Name r17 = r16.next();
            if (r12.invoke(r17).booleanValue() == false) goto L6;
            r15.addAll(getContributedVariables(r17, r13));
            goto L6
        L10:
            MemberComparator.NameAndTypeMemberComparator r18 = MemberComparator.NameAndTypeMemberComparator.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(r18, "INSTANCE");
            CollectionsKt.sortWith(r15, r18);
            r10.addAll(r15);
        L12:
            if (r11.acceptsKinds(DescriptorKindFilter.Companion.getFUNCTIONS_MASK()) == false) goto L31;
            Set<Name> r19 = getFunctionNames();
            ArrayList r20 = new ArrayList();
            Iterator<Name> r21 = r19.iterator();
        L15:
            if (r21.hasNext() == false) goto L19;
            Name r22 = r21.next();
            if (r12.invoke(r22).booleanValue() == false) goto L15;
            r20.addAll(getContributedFunctions(r22, r13));
            goto L15
        L19:
            MemberComparator.NameAndTypeMemberComparator r23 = MemberComparator.NameAndTypeMemberComparator.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(r23, "INSTANCE");
            CollectionsKt.sortWith(r20, r23);
            r10.addAll(r20);
            return;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name r10, LookupLocation r11) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r11, "location");
            if (getFunctionNames().contains(r10) == true) goto L7;
            return CollectionsKt.emptyList();
        L7:
            return this.functions.invoke(r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Collection<PropertyDescriptor> getContributedVariables(Name r10, LookupLocation r11) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r11, "location");
            if (getVariableNames().contains(r10) == true) goto L7;
            return CollectionsKt.emptyList();
        L7:
            return this.properties.invoke(r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Set<Name> getFunctionNames() {
            return (Set) StorageKt.getValue(this.functionNames$delegate, this, $$delegatedProperties[0]);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public TypeAliasDescriptor getTypeAliasByName(Name r10) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            return this.typeAliasByName.invoke(r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Set<Name> getTypeAliasNames() {
            return this.typeAliasBytes.keySet();
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Set<Name> getVariableNames() {
            return (Set) StorageKt.getValue(this.variableNames$delegate, this, $$delegatedProperties[1]);
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DeserializedMemberScope.class), "classNames", "getClassNames$deserialization()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DeserializedMemberScope.class), "classifierNamesLazy", "getClassifierNamesLazy()Ljava/util/Set;"))};
    }

    protected DeserializedMemberScope(DeserializationContext r10, List<ProtoBuf.Function> r11, List<ProtoBuf.Property> r12, List<ProtoBuf.TypeAlias> r13, final Function0<? extends Collection<Name>> r14) {
        Intrinsics.checkNotNullParameter(r10, "c");
        Intrinsics.checkNotNullParameter(r11, "functionList");
        Intrinsics.checkNotNullParameter(r12, "propertyList");
        Intrinsics.checkNotNullParameter(r13, "typeAliasList");
        Intrinsics.checkNotNullParameter(r14, "classNames");
        this.f10221c = r10;
        this.impl = createImplementation(r11, r12, r13);
        this.classNames$delegate = r10.getStorageManager().createLazyValue(new DeserializedMemberScope$classNames$2(r14));
        this.classifierNamesLazy$delegate = r10.getStorageManager().createNullableLazyValue(new DeserializedMemberScope$classifierNamesLazy$2(this));
    }

    public static final /* synthetic */ Implementation access$getImpl$p(DeserializedMemberScope r10) {
        return r10.impl;
    }

    private final Implementation createImplementation(List<ProtoBuf.Function> r10, List<ProtoBuf.Property> r11, List<ProtoBuf.TypeAlias> r12) {
        if (this.f10221c.getComponents().getConfiguration().getPreserveDeclarationsOrdering() == false) goto L6;
        return new NoReorderImplementation(this, r10, r11, r12);
    L6:
        return new OptimizedImplementation(this, r10, r11, r12);
    }

    private final ClassDescriptor deserializeClass(Name r10) {
        return this.f10221c.getComponents().deserializeClass(createClassId(r10));
    }

    private final Set<Name> getClassifierNamesLazy() {
        return (Set) StorageKt.getValue(this.classifierNamesLazy$delegate, this, $$delegatedProperties[1]);
    }

    private final TypeAliasDescriptor getTypeAliasByName(Name r10) {
        return this.impl.getTypeAliasByName(r10);
    }

    protected abstract void addEnumEntryDescriptors(Collection<DeclarationDescriptor> r10, Function1<? super Name, Boolean> r11);

    protected final Collection<DeclarationDescriptor> computeDescriptors(DescriptorKindFilter r10, Function1<? super Name, Boolean> r11, LookupLocation r12) {
        Intrinsics.checkNotNullParameter(r10, "kindFilter");
        Intrinsics.checkNotNullParameter(r11, "nameFilter");
        Intrinsics.checkNotNullParameter(r12, "location");
        ArrayList r13 = new ArrayList(0);
        DescriptorKindFilter.Companion r14 = DescriptorKindFilter.Companion;
        if (r10.acceptsKinds(r14.getSINGLETON_CLASSIFIERS_MASK()) == false) goto L5;
        addEnumEntryDescriptors(r13, r11);
    L5:
        this.impl.addFunctionsAndPropertiesTo(r13, r10, r11, r12);
        if (r10.acceptsKinds(r14.getCLASSIFIERS_MASK()) == false) goto L14;
        Iterator<Name> r15 = getClassNames$deserialization().iterator();
    L9:
        if (r15.hasNext() == false) goto L14;
        Name r16 = r15.next();
        if (r11.invoke(r16).booleanValue() == false) goto L9;
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(r13, deserializeClass(r16));
    L14:
        if (r10.acceptsKinds(DescriptorKindFilter.Companion.getTYPE_ALIASES_MASK()) == false) goto L22;
        Iterator<Name> r17 = this.impl.getTypeAliasNames().iterator();
    L17:
        if (r17.hasNext() == false) goto L22;
        Name r18 = r17.next();
        if (r11.invoke(r18).booleanValue() == false) goto L17;
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(r13, this.impl.getTypeAliasByName(r18));
    L22:
        return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(r13);
    }

    protected void computeNonDeclaredFunctions(Name r10, List<SimpleFunctionDescriptor> r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "functions");
    }

    protected void computeNonDeclaredProperties(Name r10, List<PropertyDescriptor> r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "descriptors");
    }

    protected abstract ClassId createClassId(Name r10);

    protected final DeserializationContext getC() {
        return this.f10221c;
    }

    public final Set<Name> getClassNames$deserialization() {
        return (Set) StorageKt.getValue(this.classNames$delegate, this, $$delegatedProperties[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getClassifierNames() {
        return getClassifierNamesLazy();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public ClassifierDescriptor mo1325getContributedClassifier(Name r10, LookupLocation r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "location");
        if (hasClass(r10) == false) goto L6;
        return deserializeClass(r10);
    L6:
        if (this.impl.getTypeAliasNames().contains(r10) == true) goto L11;
        return null;
    L11:
        return getTypeAliasByName(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name r10, LookupLocation r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "location");
        return this.impl.getContributedFunctions(r10, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name r10, LookupLocation r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "location");
        return this.impl.getContributedVariables(r10, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getFunctionNames() {
        return this.impl.getFunctionNames();
    }

    protected abstract Set<Name> getNonDeclaredClassifierNames();

    protected abstract Set<Name> getNonDeclaredFunctionNames();

    protected abstract Set<Name> getNonDeclaredVariableNames();

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getVariableNames() {
        return this.impl.getVariableNames();
    }

    protected boolean hasClass(Name r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        return getClassNames$deserialization().contains(r10);
    }

    protected boolean isDeclaredFunctionAvailable(SimpleFunctionDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "function");
        return true;
    }
}
