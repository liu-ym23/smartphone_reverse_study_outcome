package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class GivenFunctionsMemberScope extends MemberScopeImpl {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private final NotNullLazyValue allDescriptors$delegate;
    private final ClassDescriptor containingClass;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(GivenFunctionsMemberScope.class), "allDescriptors", "getAllDescriptors()Ljava/util/List;"))};
    }

    public GivenFunctionsMemberScope(StorageManager r10, ClassDescriptor r11) {
        Intrinsics.checkNotNullParameter(r10, "storageManager");
        Intrinsics.checkNotNullParameter(r11, "containingClass");
        this.containingClass = r11;
        this.allDescriptors$delegate = r10.createLazyValue(new GivenFunctionsMemberScope$allDescriptors$2(this));
    }

    public static final /* synthetic */ List access$createFakeOverrides(GivenFunctionsMemberScope r10, List r11) {
        return r10.createFakeOverrides(r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<DeclarationDescriptor> createFakeOverrides(List<? extends FunctionDescriptor> r11) {
        final ArrayList r10 = new ArrayList(3);
        Collection<KotlinType> r12 = this.containingClass.getTypeConstructor().mo1324getSupertypes();
        Intrinsics.checkNotNullExpressionValue(r12, "containingClass.typeConstructor.supertypes");
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        CollectionsKt.addAll(r13, ResolutionScope.DefaultImpls.getContributedDescriptors$default(((KotlinType) r14.next()).getMemberScope(), null, null, 3, null));
        goto L4
    L6:
        ArrayList r15 = new ArrayList();
        Iterator r16 = r13.iterator();
    L8:
        if (r16.hasNext() == false) goto L12;
        Object r17 = r16.next();
        if ((r17 instanceof CallableMemberDescriptor) == false) goto L8;
        r15.add(r17);
        goto L8
    L12:
        LinkedHashMap r18 = new LinkedHashMap();
        Iterator r19 = r15.iterator();
    L14:
        if (r19.hasNext() == false) goto L19;
        Object r20 = r19.next();
        Name r21 = ((CallableMemberDescriptor) r20).getName();
        Object r22 = r18.get(r21);
        if (r22 != null) goto L18;
        r22 = new ArrayList();
        r18.put(r21, r22);
    L18:
        ((List) r22).add(r20);
        goto L14
    L19:
        Iterator r23 = r18.entrySet().iterator();
    L21:
        if (r23.hasNext() == false) goto L43;
        Map.Entry r24 = (Map.Entry) r23.next();
        Name r25 = (Name) r24.getKey();
        List r26 = (List) r24.getValue();
        LinkedHashMap r27 = new LinkedHashMap();
        Iterator r28 = r26.iterator();
    L24:
        if (r28.hasNext() == false) goto L29;
        Object r29 = r28.next();
        Boolean r30 = Boolean.valueOf(((CallableMemberDescriptor) r29) instanceof FunctionDescriptor);
        Object r31 = r27.get(r30);
        if (r31 != null) goto L28;
        r31 = new ArrayList();
        r27.put(r30, r31);
    L28:
        ((List) r31).add(r29);
        goto L24
    L29:
        Iterator r32 = r27.entrySet().iterator();
    L31:
        if (r32.hasNext() == false) goto L21;
        Map.Entry r33 = (Map.Entry) r32.next();
        boolean r34 = ((Boolean) r33.getKey()).booleanValue();
        List r35 = (List) r33.getValue();
        OverridingUtil r36 = OverridingUtil.DEFAULT;
        if (r34 == false) goto L40;
        Collection<? extends CallableMemberDescriptor> r37 = new ArrayList();
        Iterator<T> r38 = r11.iterator();
    L36:
        if (r38.hasNext() == false) goto L41;
        Object r39 = r38.next();
        if (Intrinsics.areEqual(((FunctionDescriptor) r39).getName(), r25) == false) goto L36;
        r37.add(r39);
    L41:
        r36.generateOverridesInFunctionGroup(r25, r35, r37, this.containingClass, new AnonymousClass4(r10, this));
        goto L31
    L40:
        r37 = CollectionsKt.emptyList();
        goto L41
    L43:
        return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(r10);
    }

    private final List<DeclarationDescriptor> getAllDescriptors() {
        return (List) StorageKt.getValue(this.allDescriptors$delegate, this, $$delegatedProperties[0]);
    }

    protected abstract List<FunctionDescriptor> computeDeclaredFunctions();

    protected final ClassDescriptor getContainingClass() {
        return this.containingClass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r10, Function1<? super Name, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "kindFilter");
        Intrinsics.checkNotNullParameter(r11, "nameFilter");
        if (r10.acceptsKinds(DescriptorKindFilter.CALLABLES.getKindMask()) == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return getAllDescriptors();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name r10, LookupLocation r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "location");
        List<DeclarationDescriptor> r12 = getAllDescriptors();
        SmartList r13 = new SmartList();
        Iterator<T> r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L10;
        Object r15 = r14.next();
        if ((r15 instanceof SimpleFunctionDescriptor) == false) goto L4;
        if (Intrinsics.areEqual(((SimpleFunctionDescriptor) r15).getName(), r10) == false) goto L4;
        r13.add(r15);
        goto L4
    L10:
        return r13;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name r10, LookupLocation r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "location");
        List<DeclarationDescriptor> r12 = getAllDescriptors();
        SmartList r13 = new SmartList();
        Iterator<T> r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L10;
        Object r15 = r14.next();
        if ((r15 instanceof PropertyDescriptor) == false) goto L4;
        if (Intrinsics.areEqual(((PropertyDescriptor) r15).getName(), r10) == false) goto L4;
        r13.add(r15);
        goto L4
    L10:
        return r13;
    }
}
