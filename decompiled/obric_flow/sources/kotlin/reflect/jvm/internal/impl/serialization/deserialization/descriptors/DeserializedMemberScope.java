package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

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
import kotlin.jvm.internal.SourceDebugExtension;
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
    private final DeserializationContext f18758c;
    private final NotNullLazyValue classNames$delegate;
    private final NullableLazyValue classifierNamesLazy$delegate;
    private final Implementation impl;

    public interface Implementation {
        void addFunctionsAndPropertiesTo(Collection<DeclarationDescriptor> r5, DescriptorKindFilter r10, Function1<? super Name, Boolean> r11, LookupLocation r12);

        Collection<SimpleFunctionDescriptor> getContributedFunctions(Name r5, LookupLocation r10);

        Collection<PropertyDescriptor> getContributedVariables(Name r5, LookupLocation r10);

        Set<Name> getFunctionNames();

        TypeAliasDescriptor getTypeAliasByName(Name r5);

        Set<Name> getTypeAliasNames();

        Set<Name> getVariableNames();
    }

    @SourceDebugExtension({"SMAP\nDeserializedMemberScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeserializedMemberScope.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedMemberScope$NoReorderImplementation\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,512:1\n502#1:513\n508#1:517\n508#1:532\n508#1:546\n492#1:572\n493#1,5:575\n492#1:580\n493#1,5:583\n1620#2,3:514\n1603#2,9:518\n1855#2:527\n1856#2:530\n1612#2:531\n1603#2,9:533\n1855#2:542\n1856#2:544\n1612#2:545\n1603#2,9:547\n1855#2:556\n1856#2:558\n1612#2:559\n1360#2:560\n1446#2,5:561\n1360#2:566\n1446#2,5:567\n857#2,2:573\n857#2,2:581\n857#2,2:588\n857#2,2:590\n857#2,2:592\n1620#2,3:594\n1603#2,9:597\n1855#2:606\n1856#2:608\n1612#2:609\n1#3:528\n1#3:529\n1#3:543\n1#3:557\n1#3:607\n*S KotlinDebug\n*F\n+ 1 DeserializedMemberScope.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedMemberScope$NoReorderImplementation\n*L\n429#1:513\n432#1:517\n435#1:532\n438#1:546\n447#1:572\n447#1:575,5\n450#1:580\n450#1:583,5\n429#1:514,3\n432#1:518,9\n432#1:527\n432#1:530\n432#1:531\n435#1:533,9\n435#1:542\n435#1:544\n435#1:545\n438#1:547,9\n438#1:556\n438#1:558\n438#1:559\n441#1:560\n441#1:561,5\n444#1:566\n444#1:567,5\n447#1:573,2\n450#1:581,2\n473#1:588,2\n477#1:590,2\n492#1:592,2\n502#1:594,3\n508#1:597,9\n508#1:606\n508#1:608\n508#1:609\n432#1:529\n435#1:543\n438#1:557\n508#1:607\n*E\n"})
    public final class NoReorderImplementation implements Implementation {
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

        public NoReorderImplementation(final DeserializedMemberScope r5, List<ProtoBuf.Function> r10, List<ProtoBuf.Property> r11, List<ProtoBuf.TypeAlias> r12) {
            Intrinsics.checkNotNullParameter(r10, "functionList");
            Intrinsics.checkNotNullParameter(r11, "propertyList");
            Intrinsics.checkNotNullParameter(r12, "typeAliasList");
            this.this$0 = r5;
            this.functionList = r10;
            this.propertyList = r11;
            if (r5.getC().getComponents().getConfiguration().getTypeAliasesAllowed() == true) goto L6;
            r12 = CollectionsKt.emptyList();
        L6:
            this.typeAliasList = r12;
            this.declaredFunctions$delegate = r5.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$declaredFunctions$2(this));
            this.declaredProperties$delegate = r5.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$declaredProperties$2(this));
            this.allTypeAliases$delegate = r5.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$allTypeAliases$2(this));
            this.allFunctions$delegate = r5.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$allFunctions$2(this));
            this.allProperties$delegate = r5.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$allProperties$2(this));
            this.typeAliasesByName$delegate = r5.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$typeAliasesByName$2(this));
            this.functionsByName$delegate = r5.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$functionsByName$2(this));
            this.propertiesByName$delegate = r5.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$propertiesByName$2(this));
            this.functionNames$delegate = r5.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$functionNames$2(this, r5));
            this.variableNames$delegate = r5.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$variableNames$2(this, r5));
        }

        public static final /* synthetic */ List access$computeAllNonDeclaredFunctions(NoReorderImplementation r5) {
            return r5.computeAllNonDeclaredFunctions();
        }

        public static final /* synthetic */ List access$computeAllNonDeclaredProperties(NoReorderImplementation r5) {
            return r5.computeAllNonDeclaredProperties();
        }

        public static final /* synthetic */ List access$computeFunctions(NoReorderImplementation r5) {
            return r5.computeFunctions();
        }

        public static final /* synthetic */ List access$computeProperties(NoReorderImplementation r5) {
            return r5.computeProperties();
        }

        public static final /* synthetic */ List access$computeTypeAliases(NoReorderImplementation r5) {
            return r5.computeTypeAliases();
        }

        public static final /* synthetic */ List access$getAllFunctions(NoReorderImplementation r5) {
            return r5.getAllFunctions();
        }

        public static final /* synthetic */ List access$getAllProperties(NoReorderImplementation r5) {
            return r5.getAllProperties();
        }

        public static final /* synthetic */ List access$getAllTypeAliases(NoReorderImplementation r5) {
            return r5.getAllTypeAliases();
        }

        public static final /* synthetic */ List access$getDeclaredFunctions(NoReorderImplementation r5) {
            return r5.getDeclaredFunctions();
        }

        public static final /* synthetic */ List access$getDeclaredProperties(NoReorderImplementation r5) {
            return r5.getDeclaredProperties();
        }

        public static final /* synthetic */ List access$getFunctionList$p(NoReorderImplementation r5) {
            return r5.functionList;
        }

        public static final /* synthetic */ List access$getPropertyList$p(NoReorderImplementation r5) {
            return r5.propertyList;
        }

        private final List<SimpleFunctionDescriptor> computeAllNonDeclaredFunctions() {
            Set<Name> r5 = this.this$0.getNonDeclaredFunctionNames();
            ArrayList r10 = new ArrayList();
            Iterator<T> r11 = r5.iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            CollectionsKt.a(r10, computeNonDeclaredFunctionsForName((Name) r11.next()));
            goto L4
        L6:
            return r10;
        }

        private final List<PropertyDescriptor> computeAllNonDeclaredProperties() {
            Set<Name> r5 = this.this$0.getNonDeclaredVariableNames();
            ArrayList r10 = new ArrayList();
            Iterator<T> r11 = r5.iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            CollectionsKt.a(r10, computeNonDeclaredPropertiesForName((Name) r11.next()));
            goto L4
        L6:
            return r10;
        }

        private final List<SimpleFunctionDescriptor> computeFunctions() {
            List<ProtoBuf.Function> r5 = this.functionList;
            DeserializedMemberScope r10 = this.this$0;
            ArrayList r11 = new ArrayList();
            Iterator<T> r12 = r5.iterator();
        L4:
            if (r12.hasNext() == false) goto L11;
            MessageLite r13 = (MessageLite) r12.next();
            SimpleFunctionDescriptor r14 = r10.getC().getMemberDeserializer().loadFunction((ProtoBuf.Function) r13);
            if (r10.isDeclaredFunctionAvailable(r14) == true) goto L9;
            r14 = null;
        L9:
            if (r14 == null) goto L4;
            r11.add(r14);
            goto L4
        L11:
            return r11;
        }

        private final List<SimpleFunctionDescriptor> computeNonDeclaredFunctionsForName(Name r5) {
            List<SimpleFunctionDescriptor> r10 = getDeclaredFunctions();
            DeserializedMemberScope r11 = this.this$0;
            ArrayList r12 = new ArrayList();
            Iterator<T> r13 = r10.iterator();
        L4:
            if (r13.hasNext() == false) goto L8;
            Object r14 = r13.next();
            if (Intrinsics.areEqual(((DeclarationDescriptor) r14).getName(), r5) == false) goto L4;
            r12.add(r14);
            goto L4
        L8:
            int r15 = r12.size();
            r11.computeNonDeclaredFunctions(r5, r12);
            return r12.subList(r15, r12.size());
        }

        private final List<PropertyDescriptor> computeNonDeclaredPropertiesForName(Name r5) {
            List<PropertyDescriptor> r10 = getDeclaredProperties();
            DeserializedMemberScope r11 = this.this$0;
            ArrayList r12 = new ArrayList();
            Iterator<T> r13 = r10.iterator();
        L4:
            if (r13.hasNext() == false) goto L8;
            Object r14 = r13.next();
            if (Intrinsics.areEqual(((DeclarationDescriptor) r14).getName(), r5) == false) goto L4;
            r12.add(r14);
            goto L4
        L8:
            int r15 = r12.size();
            r11.computeNonDeclaredProperties(r5, r12);
            return r12.subList(r15, r12.size());
        }

        private final List<PropertyDescriptor> computeProperties() {
            List<ProtoBuf.Property> r5 = this.propertyList;
            DeserializedMemberScope r10 = this.this$0;
            ArrayList r11 = new ArrayList();
            Iterator<T> r12 = r5.iterator();
        L4:
            if (r12.hasNext() == false) goto L8;
            MessageLite r13 = (MessageLite) r12.next();
            PropertyDescriptor r14 = r10.getC().getMemberDeserializer().loadProperty((ProtoBuf.Property) r13);
            if (r14 == null) goto L4;
            r11.add(r14);
            goto L4
        L8:
            return r11;
        }

        private final List<TypeAliasDescriptor> computeTypeAliases() {
            List<ProtoBuf.TypeAlias> r5 = this.typeAliasList;
            DeserializedMemberScope r10 = this.this$0;
            ArrayList r11 = new ArrayList();
            Iterator<T> r12 = r5.iterator();
        L4:
            if (r12.hasNext() == false) goto L8;
            MessageLite r13 = (MessageLite) r12.next();
            TypeAliasDescriptor r14 = r10.getC().getMemberDeserializer().loadTypeAlias((ProtoBuf.TypeAlias) r13);
            if (r14 == null) goto L4;
            r11.add(r14);
            goto L4
        L8:
            return r11;
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
        public void addFunctionsAndPropertiesTo(Collection<DeclarationDescriptor> r5, DescriptorKindFilter r10, Function1<? super Name, Boolean> r11, LookupLocation r12) {
            Intrinsics.checkNotNullParameter(r5, "result");
            Intrinsics.checkNotNullParameter(r10, "kindFilter");
            Intrinsics.checkNotNullParameter(r11, "nameFilter");
            Intrinsics.checkNotNullParameter(r12, "location");
            if (r10.acceptsKinds(DescriptorKindFilter.Companion.getVARIABLES_MASK()) == false) goto L11;
            Iterator<T> r13 = getAllProperties().iterator();
        L6:
            if (r13.hasNext() == false) goto L11;
            Object r14 = r13.next();
            if (r11.invoke(((PropertyDescriptor) r14).getName()).booleanValue() == false) goto L6;
            r5.add(r14);
        L11:
            if (r10.acceptsKinds(DescriptorKindFilter.Companion.getFUNCTIONS_MASK()) == false) goto L18;
            Iterator<T> r15 = getAllFunctions().iterator();
        L14:
            if (r15.hasNext() == false) goto L29;
            Object r16 = r15.next();
            if (r11.invoke(((SimpleFunctionDescriptor) r16).getName()).booleanValue() == false) goto L14;
            r5.add(r16);
            goto L14
        L29:
            return;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name r5, LookupLocation r10) {
            Intrinsics.checkNotNullParameter(r5, "name");
            Intrinsics.checkNotNullParameter(r10, "location");
            if (getFunctionNames().contains(r5) == false) goto L5;
            Collection<SimpleFunctionDescriptor> r11 = getFunctionsByName().get(r5);
            if (r11 == null) goto L9;
            return r11;
        L9:
            return CollectionsKt.emptyList();
        L5:
            return CollectionsKt.emptyList();
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Collection<PropertyDescriptor> getContributedVariables(Name r5, LookupLocation r10) {
            Intrinsics.checkNotNullParameter(r5, "name");
            Intrinsics.checkNotNullParameter(r10, "location");
            if (getVariableNames().contains(r5) == false) goto L5;
            Collection<PropertyDescriptor> r11 = getPropertiesByName().get(r5);
            if (r11 == null) goto L9;
            return r11;
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
        public TypeAliasDescriptor getTypeAliasByName(Name r5) {
            Intrinsics.checkNotNullParameter(r5, "name");
            return getTypeAliasesByName().get(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Set<Name> getTypeAliasNames() {
            List<ProtoBuf.TypeAlias> r5 = this.typeAliasList;
            LinkedHashSet r10 = new LinkedHashSet();
            DeserializedMemberScope r11 = this.this$0;
            Iterator<T> r12 = r5.iterator();
        L4:
            if (r12.hasNext() == false) goto L6;
            MessageLite r13 = (MessageLite) r12.next();
            r10.add(NameResolverUtilKt.getName(r11.getC().getNameResolver(), ((ProtoBuf.TypeAlias) r13).getName()));
            goto L4
        L6:
            return r10;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Set<Name> getVariableNames() {
            return (Set) StorageKt.getValue(this.variableNames$delegate, this, $$delegatedProperties[9]);
        }
    }

    @SourceDebugExtension({"SMAP\nDeserializedMemberScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeserializedMemberScope.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedMemberScope$OptimizedImplementation\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,512:1\n269#1:513\n269#1:528\n269#1:543\n287#1,17:581\n305#1,2:604\n296#1:606\n303#1:607\n305#1,2:613\n287#1,17:620\n305#1,2:642\n296#1:644\n370#1,11:645\n370#1,11:656\n1477#2:514\n1502#2,3:515\n1505#2,3:525\n1477#2:529\n1502#2,3:530\n1505#2,3:540\n1477#2:544\n1502#2,3:545\n1505#2,3:555\n1238#2,2:560\n1549#2:562\n1620#2,3:563\n1241#2:566\n1477#2:567\n1502#2,3:568\n1505#2,3:578\n1611#2:598\n1855#2:599\n1856#2:602\n1612#2:603\n1611#2:608\n1855#2:609\n1856#2:611\n1612#2:612\n1611#2:615\n1855#2:616\n1856#2:618\n1612#2:619\n1611#2:637\n1855#2:638\n1856#2:640\n1612#2:641\n361#3,7:518\n361#3,7:533\n361#3,7:548\n442#3:558\n392#3:559\n361#3,7:571\n1#4:600\n1#4:601\n1#4:610\n1#4:617\n1#4:639\n*S KotlinDebug\n*F\n+ 1 DeserializedMemberScope.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedMemberScope$OptimizedImplementation\n*L\n233#1:513\n235#1:528\n239#1:543\n272#1:581,17\n272#1:604,2\n272#1:606\n287#1:607\n287#1:613,2\n310#1:620,17\n310#1:642,2\n310#1:644\n348#1:645,11\n356#1:656,11\n233#1:514\n233#1:515,3\n233#1:525,3\n235#1:529\n235#1:530,3\n235#1:540,3\n239#1:544\n239#1:545,3\n239#1:555,3\n244#1:560,2\n246#1:562\n246#1:563,3\n244#1:566\n269#1:567\n269#1:568,3\n269#1:578,3\n272#1:598\n272#1:599\n272#1:602\n272#1:603\n287#1:608\n287#1:609\n287#1:611\n287#1:612\n303#1:615\n303#1:616\n303#1:618\n303#1:619\n310#1:637\n310#1:638\n310#1:640\n310#1:641\n233#1:518,7\n235#1:533,7\n239#1:548,7\n244#1:558\n244#1:559\n269#1:571,7\n272#1:601\n287#1:610\n303#1:617\n310#1:639\n*E\n"})
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

        public OptimizedImplementation(DeserializedMemberScope r5, List<ProtoBuf.Function> r10, List<ProtoBuf.Property> r11, List<ProtoBuf.TypeAlias> r12) {
            Intrinsics.checkNotNullParameter(r10, "functionList");
            Intrinsics.checkNotNullParameter(r11, "propertyList");
            Intrinsics.checkNotNullParameter(r12, "typeAliasList");
            this.this$0 = r5;
            LinkedHashMap r13 = new LinkedHashMap();
            Iterator<T> r14 = r10.iterator();
        L4:
            if (r14.hasNext() == false) goto L9;
            Object r15 = r14.next();
            Name r16 = NameResolverUtilKt.getName(r5.getC().getNameResolver(), ((ProtoBuf.Function) ((MessageLite) r15)).getName());
            Object r17 = r13.get(r16);
            if (r17 != null) goto L8;
            r17 = new ArrayList();
            r13.put(r16, r17);
        L8:
            ((List) r17).add(r15);
            goto L4
        L9:
            this.functionProtosBytes = packToByteArray(r13);
            DeserializedMemberScope r18 = this.this$0;
            LinkedHashMap r19 = new LinkedHashMap();
            Iterator<T> r20 = r11.iterator();
        L11:
            if (r20.hasNext() == false) goto L16;
            Object r21 = r20.next();
            Name r22 = NameResolverUtilKt.getName(r18.getC().getNameResolver(), ((ProtoBuf.Property) ((MessageLite) r21)).getName());
            Object r23 = r19.get(r22);
            if (r23 != null) goto L15;
            r23 = new ArrayList();
            r19.put(r22, r23);
        L15:
            ((List) r23).add(r21);
            goto L11
        L16:
            this.propertyProtosBytes = packToByteArray(r19);
            if (this.this$0.getC().getComponents().getConfiguration().getTypeAliasesAllowed() == false) goto L26;
            DeserializedMemberScope r24 = this.this$0;
            LinkedHashMap r25 = new LinkedHashMap();
            Iterator<T> r26 = r12.iterator();
        L20:
            if (r26.hasNext() == false) goto L25;
            Object r27 = r26.next();
            Name r28 = NameResolverUtilKt.getName(r24.getC().getNameResolver(), ((ProtoBuf.TypeAlias) ((MessageLite) r27)).getName());
            Object r29 = r25.get(r28);
            if (r29 != null) goto L24;
            r29 = new ArrayList();
            r25.put(r28, r29);
        L24:
            ((List) r29).add(r27);
            goto L20
        L25:
            Map<Name, byte[]> r30 = packToByteArray(r25);
        L27:
            this.typeAliasBytes = r30;
            this.functions = this.this$0.getC().getStorageManager().createMemoizedFunction(new DeserializedMemberScope$OptimizedImplementation$functions$1(this));
            this.properties = this.this$0.getC().getStorageManager().createMemoizedFunction(new DeserializedMemberScope$OptimizedImplementation$properties$1(this));
            this.typeAliasByName = this.this$0.getC().getStorageManager().createMemoizedFunctionWithNullableValues(new DeserializedMemberScope$OptimizedImplementation$typeAliasByName$1(this));
            StorageManager r31 = this.this$0.getC().getStorageManager();
            final DeserializedMemberScope r32 = this.this$0;
            this.functionNames$delegate = r31.createLazyValue(new DeserializedMemberScope$OptimizedImplementation$functionNames$2(this, r32));
            StorageManager r33 = this.this$0.getC().getStorageManager();
            final DeserializedMemberScope r34 = this.this$0;
            this.variableNames$delegate = r33.createLazyValue(new DeserializedMemberScope$OptimizedImplementation$variableNames$2(this, r34));
            return;
        L26:
            r30 = MapsKt.emptyMap();
            goto L27
        }

        public static final /* synthetic */ Collection access$computeFunctions(OptimizedImplementation r5, Name r10) {
            return r5.computeFunctions(r10);
        }

        public static final /* synthetic */ Collection access$computeProperties(OptimizedImplementation r5, Name r10) {
            return r5.computeProperties(r10);
        }

        public static final /* synthetic */ TypeAliasDescriptor access$createTypeAlias(OptimizedImplementation r5, Name r10) {
            return r5.createTypeAlias(r10);
        }

        public static final /* synthetic */ Map access$getFunctionProtosBytes$p(OptimizedImplementation r5) {
            return r5.functionProtosBytes;
        }

        public static final /* synthetic */ Map access$getPropertyProtosBytes$p(OptimizedImplementation r5) {
            return r5.propertyProtosBytes;
        }

        private final Collection<SimpleFunctionDescriptor> computeFunctions(Name r5) {
            Map<Name, byte[]> r10 = this.functionProtosBytes;
            Parser<ProtoBuf.Function> r11 = ProtoBuf.Function.PARSER;
            DeserializedMemberScope r12 = this.this$0;
            byte[] r13 = r10.get(r5);
            if (r13 == null) goto L7;
            DeserializedMemberScope r14 = this.this$0;
            List r15 = SequencesKt.toList(SequencesKt.a(new DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1(r11, new ByteArrayInputStream(r13), r14)));
            if (r15 == null) goto L7;
        L8:
            ArrayList r16 = new ArrayList(r15.size());
            Iterator r17 = r15.iterator();
        L10:
            if (r17.hasNext() == false) goto L17;
            ProtoBuf.Function r18 = (ProtoBuf.Function) r17.next();
            SimpleFunctionDescriptor r19 = r12.getC().getMemberDeserializer().loadFunction(r18);
            if (r12.isDeclaredFunctionAvailable(r19) == true) goto L15;
            r19 = null;
        L15:
            if (r19 == null) goto L10;
            r16.add(r19);
            goto L10
        L17:
            r12.computeNonDeclaredFunctions(r5, r16);
            return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(r16);
        L7:
            r15 = CollectionsKt.emptyList();
            goto L8
        }

        private final Collection<PropertyDescriptor> computeProperties(Name r5) {
            Map<Name, byte[]> r10 = this.propertyProtosBytes;
            Parser<ProtoBuf.Property> r11 = ProtoBuf.Property.PARSER;
            DeserializedMemberScope r12 = this.this$0;
            byte[] r13 = r10.get(r5);
            if (r13 == null) goto L7;
            DeserializedMemberScope r14 = this.this$0;
            List r15 = SequencesKt.toList(SequencesKt.a(new DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1(r11, new ByteArrayInputStream(r13), r14)));
            if (r15 == null) goto L7;
        L8:
            ArrayList r16 = new ArrayList(r15.size());
            Iterator r17 = r15.iterator();
        L10:
            if (r17.hasNext() == false) goto L14;
            ProtoBuf.Property r18 = (ProtoBuf.Property) r17.next();
            PropertyDescriptor r19 = r12.getC().getMemberDeserializer().loadProperty(r18);
            if (r19 == null) goto L10;
            r16.add(r19);
            goto L10
        L14:
            r12.computeNonDeclaredProperties(r5, r16);
            return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(r16);
        L7:
            r15 = CollectionsKt.emptyList();
            goto L8
        }

        private final TypeAliasDescriptor createTypeAlias(Name r5) {
            byte[] r10 = this.typeAliasBytes.get(r5);
            if (r10 != null) goto L5;
            return null;
        L5:
            ProtoBuf.TypeAlias r11 = ProtoBuf.TypeAlias.parseDelimitedFrom(new ByteArrayInputStream(r10), this.this$0.getC().getComponents().getExtensionRegistryLite());
            if (r11 != null) goto L9;
            return null;
        L9:
            return this.this$0.getC().getMemberDeserializer().loadTypeAlias(r11);
        }

        private final Map<Name, byte[]> packToByteArray(Map<Name, ? extends Collection<? extends AbstractMessageLite>> r10) {
            LinkedHashMap r5 = new LinkedHashMap(MapsKt.mapCapacity(r10.size()));
            Iterator<T> r11 = r10.entrySet().iterator();
        L4:
            if (r11.hasNext() == false) goto L10;
            Map.Entry r12 = (Map.Entry) r11.next();
            Object r13 = r12.getKey();
            ByteArrayOutputStream r14 = new ByteArrayOutputStream();
            Iterable r15 = (Iterable) r12.getValue();
            ArrayList r16 = new ArrayList(CollectionsKt.h(r15));
            Iterator r17 = r15.iterator();
        L7:
            if (r17.hasNext() == false) goto L9;
            ((AbstractMessageLite) r17.next()).writeDelimitedTo(r14);
            r16.add(Unit.INSTANCE);
            goto L7
        L9:
            r5.put(r13, r14.toByteArray());
            goto L4
        L10:
            return r5;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public void addFunctionsAndPropertiesTo(Collection<DeclarationDescriptor> r5, DescriptorKindFilter r10, Function1<? super Name, Boolean> r11, LookupLocation r12) {
            Intrinsics.checkNotNullParameter(r5, "result");
            Intrinsics.checkNotNullParameter(r10, "kindFilter");
            Intrinsics.checkNotNullParameter(r11, "nameFilter");
            Intrinsics.checkNotNullParameter(r12, "location");
            if (r10.acceptsKinds(DescriptorKindFilter.Companion.getVARIABLES_MASK()) == false) goto L12;
            Set<Name> r13 = getVariableNames();
            ArrayList r14 = new ArrayList();
            Iterator<Name> r15 = r13.iterator();
        L6:
            if (r15.hasNext() == false) goto L10;
            Name r16 = r15.next();
            if (r11.invoke(r16).booleanValue() == false) goto L6;
            r14.addAll(getContributedVariables(r16, r12));
            goto L6
        L10:
            CollectionsKt.sortWith(r14, MemberComparator.NameAndTypeMemberComparator.INSTANCE);
            r5.addAll(r14);
        L12:
            if (r10.acceptsKinds(DescriptorKindFilter.Companion.getFUNCTIONS_MASK()) == false) goto L31;
            Set<Name> r17 = getFunctionNames();
            ArrayList r18 = new ArrayList();
            Iterator<Name> r19 = r17.iterator();
        L15:
            if (r19.hasNext() == false) goto L19;
            Name r20 = r19.next();
            if (r11.invoke(r20).booleanValue() == false) goto L15;
            r18.addAll(getContributedFunctions(r20, r12));
            goto L15
        L19:
            CollectionsKt.sortWith(r18, MemberComparator.NameAndTypeMemberComparator.INSTANCE);
            r5.addAll(r18);
            return;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name r5, LookupLocation r10) {
            Intrinsics.checkNotNullParameter(r5, "name");
            Intrinsics.checkNotNullParameter(r10, "location");
            if (getFunctionNames().contains(r5) == true) goto L7;
            return CollectionsKt.emptyList();
        L7:
            return this.functions.invoke(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Collection<PropertyDescriptor> getContributedVariables(Name r5, LookupLocation r10) {
            Intrinsics.checkNotNullParameter(r5, "name");
            Intrinsics.checkNotNullParameter(r10, "location");
            if (getVariableNames().contains(r5) == true) goto L7;
            return CollectionsKt.emptyList();
        L7:
            return this.properties.invoke(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Set<Name> getFunctionNames() {
            return (Set) StorageKt.getValue(this.functionNames$delegate, this, $$delegatedProperties[0]);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public TypeAliasDescriptor getTypeAliasByName(Name r5) {
            Intrinsics.checkNotNullParameter(r5, "name");
            return this.typeAliasByName.invoke(r5);
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

    public DeserializedMemberScope(DeserializationContext r5, List<ProtoBuf.Function> r10, List<ProtoBuf.Property> r11, List<ProtoBuf.TypeAlias> r12, final Function0<? extends Collection<Name>> r13) {
        Intrinsics.checkNotNullParameter(r5, "c");
        Intrinsics.checkNotNullParameter(r10, "functionList");
        Intrinsics.checkNotNullParameter(r11, "propertyList");
        Intrinsics.checkNotNullParameter(r12, "typeAliasList");
        Intrinsics.checkNotNullParameter(r13, "classNames");
        this.f18758c = r5;
        this.impl = createImplementation(r10, r11, r12);
        this.classNames$delegate = r5.getStorageManager().createLazyValue(new DeserializedMemberScope$classNames$2(r13));
        this.classifierNamesLazy$delegate = r5.getStorageManager().createNullableLazyValue(new DeserializedMemberScope$classifierNamesLazy$2(this));
    }

    public static final /* synthetic */ Implementation access$getImpl$p(DeserializedMemberScope r5) {
        return r5.impl;
    }

    private final Implementation createImplementation(List<ProtoBuf.Function> r5, List<ProtoBuf.Property> r10, List<ProtoBuf.TypeAlias> r11) {
        if (this.f18758c.getComponents().getConfiguration().getPreserveDeclarationsOrdering() == false) goto L6;
        return new NoReorderImplementation(this, r5, r10, r11);
    L6:
        return new OptimizedImplementation(this, r5, r10, r11);
    }

    private final ClassDescriptor deserializeClass(Name r5) {
        return this.f18758c.getComponents().deserializeClass(createClassId(r5));
    }

    private final Set<Name> getClassifierNamesLazy() {
        return (Set) StorageKt.getValue(this.classifierNamesLazy$delegate, this, $$delegatedProperties[1]);
    }

    private final TypeAliasDescriptor getTypeAliasByName(Name r5) {
        return this.impl.getTypeAliasByName(r5);
    }

    public abstract void addEnumEntryDescriptors(Collection<DeclarationDescriptor> r5, Function1<? super Name, Boolean> r10);

    public final Collection<DeclarationDescriptor> computeDescriptors(DescriptorKindFilter r5, Function1<? super Name, Boolean> r10, LookupLocation r11) {
        Intrinsics.checkNotNullParameter(r5, "kindFilter");
        Intrinsics.checkNotNullParameter(r10, "nameFilter");
        Intrinsics.checkNotNullParameter(r11, "location");
        ArrayList r12 = new ArrayList(0);
        DescriptorKindFilter.Companion r13 = DescriptorKindFilter.Companion;
        if (r5.acceptsKinds(r13.getSINGLETON_CLASSIFIERS_MASK()) == false) goto L5;
        addEnumEntryDescriptors(r12, r10);
    L5:
        this.impl.addFunctionsAndPropertiesTo(r12, r5, r10, r11);
        if (r5.acceptsKinds(r13.getCLASSIFIERS_MASK()) == false) goto L14;
        Iterator<Name> r14 = getClassNames$deserialization().iterator();
    L9:
        if (r14.hasNext() == false) goto L14;
        Name r15 = r14.next();
        if (r10.invoke(r15).booleanValue() == false) goto L9;
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(r12, deserializeClass(r15));
    L14:
        if (r5.acceptsKinds(DescriptorKindFilter.Companion.getTYPE_ALIASES_MASK()) == false) goto L22;
        Iterator<Name> r16 = this.impl.getTypeAliasNames().iterator();
    L17:
        if (r16.hasNext() == false) goto L22;
        Name r17 = r16.next();
        if (r10.invoke(r17).booleanValue() == false) goto L17;
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(r12, this.impl.getTypeAliasByName(r17));
    L22:
        return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(r12);
    }

    public void computeNonDeclaredFunctions(Name r5, List<SimpleFunctionDescriptor> r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "functions");
    }

    public void computeNonDeclaredProperties(Name r5, List<PropertyDescriptor> r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "descriptors");
    }

    public abstract ClassId createClassId(Name r5);

    public final DeserializationContext getC() {
        return this.f18758c;
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
    public ClassifierDescriptor mo1404getContributedClassifier(Name r5, LookupLocation r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "location");
        if (hasClass(r5) == false) goto L6;
        return deserializeClass(r5);
    L6:
        if (this.impl.getTypeAliasNames().contains(r5) == true) goto L11;
        return null;
    L11:
        return getTypeAliasByName(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name r5, LookupLocation r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "location");
        return this.impl.getContributedFunctions(r5, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name r5, LookupLocation r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "location");
        return this.impl.getContributedVariables(r5, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getFunctionNames() {
        return this.impl.getFunctionNames();
    }

    public abstract Set<Name> getNonDeclaredClassifierNames();

    public abstract Set<Name> getNonDeclaredFunctionNames();

    public abstract Set<Name> getNonDeclaredVariableNames();

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getVariableNames() {
        return this.impl.getVariableNames();
    }

    public boolean hasClass(Name r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        return getClassNames$deserialization().contains(r5);
    }

    public boolean isDeclaredFunctionAvailable(SimpleFunctionDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "function");
        return true;
    }
}
