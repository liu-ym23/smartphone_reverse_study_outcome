package kotlin.reflect.jvm.internal;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.Collection;
import java.util.List;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* JADX INFO: loaded from: classes3.dex */
public final class KPackageImpl extends KDeclarationContainerImpl {
    private final ReflectProperties.LazyVal<Data> data;
    private final Class<?> jClass;
    private final String usageModuleName;

    private final class Data extends KDeclarationContainerImpl.Data {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
        private final ReflectProperties.LazySoftVal kotlinClass$delegate;
        private final ReflectProperties.LazySoftVal members$delegate;
        private final ReflectProperties.LazyVal metadata$delegate;
        private final ReflectProperties.LazyVal multifileFacade$delegate;
        private final ReflectProperties.LazySoftVal scope$delegate;
        final /* synthetic */ KPackageImpl this$0;

        static {
            $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "kotlinClass", "getKotlinClass()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "scope", "getScope()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "multifileFacade", "getMultifileFacade()Ljava/lang/Class;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "metadata", "getMetadata()Lkotlin/Triple;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "members", "getMembers()Ljava/util/Collection;"))};
        }

        public Data(final KPackageImpl r10) {
            this.this$0 = r10;
            super(r10);
            this.kotlinClass$delegate = ReflectProperties.lazySoft(new KPackageImpl$Data$kotlinClass$2(r10));
            this.scope$delegate = ReflectProperties.lazySoft(new KPackageImpl$Data$scope$2(this));
            this.multifileFacade$delegate = ReflectProperties.lazy(new KPackageImpl$Data$multifileFacade$2(this, r10));
            this.metadata$delegate = ReflectProperties.lazy(new KPackageImpl$Data$metadata$2(this));
            this.members$delegate = ReflectProperties.lazySoft(new KPackageImpl$Data$members$2(r10, this));
        }

        public static final /* synthetic */ ReflectKotlinClass access$getKotlinClass(Data r10) {
            return r10.getKotlinClass();
        }

        /* JADX WARN: Multi-variable type inference failed */
        private final ReflectKotlinClass getKotlinClass() {
            return (ReflectKotlinClass) this.kotlinClass$delegate.getValue(this, $$delegatedProperties[0]);
        }

        public final Collection<KCallableImpl<?>> getMembers() {
            T r10 = this.members$delegate.getValue(this, $$delegatedProperties[4]);
            Intrinsics.checkNotNullExpressionValue(r10, "<get-members>(...)");
            return (Collection) r10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Triple<JvmNameResolver, ProtoBuf.Package, JvmMetadataVersion> getMetadata() {
            return (Triple) this.metadata$delegate.getValue(this, $$delegatedProperties[3]);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Class<?> getMultifileFacade() {
            return (Class) this.multifileFacade$delegate.getValue(this, $$delegatedProperties[2]);
        }

        public final MemberScope getScope() {
            T r10 = this.scope$delegate.getValue(this, $$delegatedProperties[1]);
            Intrinsics.checkNotNullExpressionValue(r10, "<get-scope>(...)");
            return (MemberScope) r10;
        }
    }

    public KPackageImpl(Class<?> r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "jClass");
        this.jClass = r10;
        this.usageModuleName = r11;
        ReflectProperties.LazyVal<Data> r12 = ReflectProperties.lazy(new KPackageImpl$data$1(this));
        Intrinsics.checkNotNullExpressionValue(r12, "lazy { Data() }");
        this.data = r12;
    }

    public /* synthetic */ KPackageImpl(Class r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    private final MemberScope getScope() {
        return this.data.invoke().getScope();
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof KPackageImpl) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(getJClass(), ((KPackageImpl) r10).getJClass()) == false) goto L7;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<ConstructorDescriptor> getConstructorDescriptors() {
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<FunctionDescriptor> getFunctions(Name r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        return getScope().getContributedFunctions(r10, NoLookupLocation.FROM_REFLECTION);
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public Class<?> getJClass() {
        return this.jClass;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public PropertyDescriptor getLocalProperty(int r10) {
        Triple<JvmNameResolver, ProtoBuf.Package, JvmMetadataVersion> r11 = this.data.invoke().getMetadata();
        if (r11 == null) goto L8;
        JvmNameResolver r12 = r11.component1();
        ProtoBuf.Package r13 = r11.component2();
        JvmMetadataVersion r14 = r11.component3();
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, List<ProtoBuf.Property>> r15 = JvmProtoBuf.packageLocalVariable;
        Intrinsics.checkNotNullExpressionValue(r15, "packageLocalVariable");
        ProtoBuf.Property r16 = (ProtoBuf.Property) ProtoBufUtilKt.getExtensionOrNull(r13, r15, r10);
        if (r16 == null) goto L9;
        Class<?> r17 = getJClass();
        ProtoBuf.TypeTable r18 = r13.getTypeTable();
        Intrinsics.checkNotNullExpressionValue(r18, "packageProto.typeTable");
        return (PropertyDescriptor) UtilKt.deserializeToDescriptor(r17, r16, r12, new TypeTable(r18), r14, KPackageImpl$getLocalProperty$1$1$1.INSTANCE);
    L9:
        return null;
    L8:
        return null;
    }

    @Override // kotlin.reflect.KDeclarationContainer
    public Collection<KCallable<?>> getMembers() {
        return this.data.invoke().getMembers();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    protected Class<?> getMethodOwner() {
        Class<?> r10 = this.data.invoke().getMultifileFacade();
        if (r10 == null) goto L5;
        return r10;
    L5:
        return getJClass();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<PropertyDescriptor> getProperties(Name r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        return getScope().getContributedVariables(r10, NoLookupLocation.FROM_REFLECTION);
    }

    public int hashCode() {
        return getJClass().hashCode();
    }

    public String toString() {
        return "file class " + ReflectClassUtilKt.getClassId(getJClass()).asSingleFqName();
    }
}
