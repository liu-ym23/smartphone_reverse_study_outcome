package kotlin.reflect.jvm.internal;

import com.obric.assistant.interaction.api.service.IInteractionStateService;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Collection;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001)B\u0013\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001a2\u0006\u0010 \u001a\u00020!H\u0016J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0096\u0002J\b\u0010&\u001a\u00020!H\u0016J\b\u0010'\u001a\u00020(H\u0016R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\f\u0012\b\u0012\u00060\nR\u00020\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u00038TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0015¨\u0006*"}, d2 = {"Lkotlin/reflect/jvm/internal/KPackageImpl;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "jClass", "Ljava/lang/Class;", "<init>", "(Ljava/lang/Class;)V", "getJClass", "()Ljava/lang/Class;", "data", "Lkotlin/Lazy;", "Lkotlin/reflect/jvm/internal/KPackageImpl$Data;", "methodOwner", "getMethodOwner", "scope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getScope", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "members", "", "Lkotlin/reflect/KCallable;", "getMembers", "()Ljava/util/Collection;", "constructorDescriptors", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "getProperties", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", DBDefinition.NAME, "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "getLocalProperty", "index", "", "equals", "", IInteractionStateService.WAKE_UP_SOURCE_OTHER, "", "hashCode", "toString", "", "Data", "kotlin-reflection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class KPackageImpl extends KDeclarationContainerImpl {
    private final Lazy<Data> data;
    private final Class<?> jClass;

    public static /* synthetic */ Data accessor$KPackageImpl$lambda0(KPackageImpl r0) {
        return data$lambda$0(r0);
    }

    private final MemberScope getScope() {
        return ((Data) this.data.getValue()).getScope();
    }

    public Collection<KCallable<?>> getMembers() {
        return ((Data) this.data.getValue()).getMembers();
    }

    public Class<?> getMethodOwner() {
        Class<?> r0 = ((Data) this.data.getValue()).getMultifileFacade();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return getJClass();
    }

    public String toString() {
        return "file class " + ReflectClassUtilKt.getClassId(getJClass()).asSingleFqName();
    }

    public Collection<ConstructorDescriptor> getConstructorDescriptors() {
        return CollectionsKt.emptyList();
    }

    public int hashCode() {
        return getJClass().hashCode();
    }

    public Class<?> getJClass() {
        return this.jClass;
    }

    public KPackageImpl(Class<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "jClass");
        this.jClass = r2;
        this.data = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new KPackageImpl$$Lambda$0(this));
    }

    private static final Data data$lambda$0(KPackageImpl r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return new Data(r1);
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof KPackageImpl) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(getJClass(), ((KPackageImpl) r2).getJClass()) == false) goto L7;
        return true;
    }

    public Collection<FunctionDescriptor> getFunctions(Name r3) {
        Intrinsics.checkNotNullParameter(r3, DBDefinition.NAME);
        return getScope().getContributedFunctions(r3, NoLookupLocation.FROM_REFLECTION);
    }

    public PropertyDescriptor getLocalProperty(int r10) {
        Triple r0 = ((Data) this.data.getValue()).getMetadata();
        if (r0 == null) goto L8;
        JvmNameResolver r5 = (JvmNameResolver) r0.component1();
        ProtoBuf$Package r2 = (ProtoBuf$Package) r0.component2();
        JvmMetadataVersion r7 = (JvmMetadataVersion) r0.component3();
        ProtoBuf$Property r4 = (ProtoBuf$Property) ProtoBufUtilKt.getExtensionOrNull(r2, JvmProtoBuf.packageLocalVariable, r10);
        if (r4 != null) goto L7;
        return null;
    L7:
        return (PropertyDescriptor) UtilKt.deserializeToDescriptor(getJClass(), r4, r5, new TypeTable(r2.getTypeTable()), r7, getLocalProperty.1.1.1.INSTANCE);
    L8:
        return null;
    }

    public Collection<PropertyDescriptor> getProperties(Name r3) {
        Intrinsics.checkNotNullParameter(r3, DBDefinition.NAME);
        return getScope().getContributedVariables(r3, NoLookupLocation.FROM_REFLECTION);
    }
}
