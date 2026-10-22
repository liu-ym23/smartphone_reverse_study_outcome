package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class StaticScopeForKotlinEnum extends MemberScopeImpl {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private final ClassDescriptor containingClass;
    private final boolean enumEntriesCanBeUsed;
    private final NotNullLazyValue functions$delegate;
    private final NotNullLazyValue properties$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(StaticScopeForKotlinEnum.class), "functions", "getFunctions()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(StaticScopeForKotlinEnum.class), "properties", "getProperties()Ljava/util/List;"))};
    }

    public static /* synthetic */ List accessor$StaticScopeForKotlinEnum$lambda0(StaticScopeForKotlinEnum r0) {
        return functions_delegate$lambda$1(r0);
    }

    public static /* synthetic */ List accessor$StaticScopeForKotlinEnum$lambda1(StaticScopeForKotlinEnum r0) {
        return properties_delegate$lambda$2(r0);
    }

    public Void getContributedClassifier(Name r2, LookupLocation r3) {
        Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
        Intrinsics.checkNotNullParameter(r3, "location");
        return null;
    }

    private final List<SimpleFunctionDescriptor> getFunctions() {
        return (List) StorageKt.getValue(this.functions$delegate, this, $$delegatedProperties[0]);
    }

    private final List<PropertyDescriptor> getProperties() {
        return (List) StorageKt.getValue(this.properties$delegate, this, $$delegatedProperties[1]);
    }

    private static final List functions_delegate$lambda$1(StaticScopeForKotlinEnum r3) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        return CollectionsKt.listOf(new SimpleFunctionDescriptor[]{DescriptorFactory.createEnumValueOfMethod(r3.containingClass), DescriptorFactory.createEnumValuesMethod(r3.containingClass)});
    }

    private static final List properties_delegate$lambda$2(StaticScopeForKotlinEnum r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        if (r1.enumEntriesCanBeUsed == false) goto L6;
        return CollectionsKt.listOfNotNull(DescriptorFactory.createEnumEntriesProperty(r1.containingClass));
    L6:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ ClassifierDescriptor mo383getContributedClassifier(Name r1, LookupLocation r2) {
        return (ClassifierDescriptor) getContributedClassifier(r1, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public List<CallableMemberDescriptor> getContributedDescriptors(DescriptorKindFilter r2, Function1<? super Name, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "kindFilter");
        Intrinsics.checkNotNullParameter(r3, "nameFilter");
        return CollectionsKt.plus(getFunctions(), getProperties());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public SmartList<SimpleFunctionDescriptor> getContributedFunctions(Name r4, LookupLocation r5) {
        Intrinsics.checkNotNullParameter(r4, DBDefinition.NAME);
        Intrinsics.checkNotNullParameter(r5, "location");
        List<SimpleFunctionDescriptor> r6 = getFunctions();
        SmartList<SimpleFunctionDescriptor> r0 = new SmartList();
        Iterator<T> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L8;
        Object r1 = r7.next();
        if (Intrinsics.areEqual(((SimpleFunctionDescriptor) r1).getName(), r4) == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name r4, LookupLocation r5) {
        Intrinsics.checkNotNullParameter(r4, DBDefinition.NAME);
        Intrinsics.checkNotNullParameter(r5, "location");
        List<PropertyDescriptor> r6 = getProperties();
        SmartList r0 = new SmartList();
        Iterator<T> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L8;
        Object r1 = r7.next();
        if (Intrinsics.areEqual(((PropertyDescriptor) r1).getName(), r4) == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public /* bridge */ /* synthetic */ Collection getContributedDescriptors(DescriptorKindFilter r1, Function1 r2) {
        return getContributedDescriptors(r1, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public /* bridge */ /* synthetic */ Collection getContributedFunctions(Name r1, LookupLocation r2) {
        return getContributedFunctions(r1, r2);
    }

    public StaticScopeForKotlinEnum(StorageManager r2, ClassDescriptor r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "storageManager");
        Intrinsics.checkNotNullParameter(r3, "containingClass");
        this.containingClass = r3;
        this.enumEntriesCanBeUsed = r4;
        r3.getKind();
        ClassKind r5 = ClassKind.CLASS;
        this.functions$delegate = r2.createLazyValue(new StaticScopeForKotlinEnum$$Lambda$0(this));
        this.properties$delegate = r2.createLazyValue(new StaticScopeForKotlinEnum$$Lambda$1(this));
    }
}
