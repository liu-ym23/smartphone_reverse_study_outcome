package kotlin.reflect.jvm.internal.impl.resolve.scopes;

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
import kotlin.jvm.internal.SourceDebugExtension;
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
@SourceDebugExtension({"SMAP\nGivenFunctionsMemberScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GivenFunctionsMemberScope.kt\norg/jetbrains/kotlin/resolve/scopes/GivenFunctionsMemberScope\n+ 2 scopeUtils.kt\norg/jetbrains/kotlin/util/collectionUtils/ScopeUtilsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,91:1\n109#2,5:92\n109#2,5:97\n1360#3:102\n1446#3,5:103\n800#3,11:108\n1477#3:119\n1502#3,3:120\n1505#3,3:130\n1477#3:133\n1502#3,3:134\n1505#3,3:144\n766#3:147\n857#3,2:148\n361#4,7:123\n361#4,7:137\n*S KotlinDebug\n*F\n+ 1 GivenFunctionsMemberScope.kt\norg/jetbrains/kotlin/resolve/scopes/GivenFunctionsMemberScope\n*L\n51#1:92,5\n55#1:97,5\n61#1:102\n61#1:103,5\n62#1:108,11\n63#1:119\n63#1:120,3\n63#1:130,3\n64#1:133\n64#1:134,3\n64#1:144,3\n68#1:147\n68#1:148,2\n63#1:123,7\n64#1:137,7\n*E\n"})
public abstract class GivenFunctionsMemberScope extends MemberScopeImpl {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private final NotNullLazyValue allDescriptors$delegate;
    private final ClassDescriptor containingClass;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(GivenFunctionsMemberScope.class), "allDescriptors", "getAllDescriptors()Ljava/util/List;"))};
    }

    public GivenFunctionsMemberScope(StorageManager r5, ClassDescriptor r10) {
        Intrinsics.checkNotNullParameter(r5, "storageManager");
        Intrinsics.checkNotNullParameter(r10, "containingClass");
        this.containingClass = r10;
        this.allDescriptors$delegate = r5.createLazyValue(new GivenFunctionsMemberScope$allDescriptors$2(this));
    }

    public static final /* synthetic */ List access$createFakeOverrides(GivenFunctionsMemberScope r5, List r10) {
        return r5.createFakeOverrides(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6, types: [kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.util.Collection] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final List<DeclarationDescriptor> createFakeOverrides(List<? extends FunctionDescriptor> r11) {
        final ArrayList r5 = new ArrayList(3);
        Collection<KotlinType> r10 = this.containingClass.getTypeConstructor().mo1403getSupertypes();
        ArrayList r12 = new ArrayList();
        Iterator r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        CollectionsKt.a(r12, ResolutionScope.DefaultImpls.getContributedDescriptors$default(((KotlinType) r13.next()).getMemberScope(), null, null, 3, null));
        goto L4
    L6:
        ArrayList r14 = new ArrayList();
        Iterator r15 = r12.iterator();
    L8:
        if (r15.hasNext() == false) goto L12;
        Object r16 = r15.next();
        if ((r16 instanceof CallableMemberDescriptor) == false) goto L8;
        r14.add(r16);
        goto L8
    L12:
        LinkedHashMap r17 = new LinkedHashMap();
        Iterator r18 = r14.iterator();
    L14:
        if (r18.hasNext() == false) goto L19;
        Object r19 = r18.next();
        Name r20 = ((CallableMemberDescriptor) r19).getName();
        Object r21 = r17.get(r20);
        if (r21 != null) goto L18;
        r21 = new ArrayList();
        r17.put(r20, r21);
    L18:
        ((List) r21).add(r19);
        goto L14
    L19:
        Iterator r22 = r17.entrySet().iterator();
    L21:
        if (r22.hasNext() == false) goto L44;
        Map.Entry r23 = (Map.Entry) r22.next();
        Name r24 = (Name) r23.getKey();
        List r25 = (List) r23.getValue();
        LinkedHashMap r26 = new LinkedHashMap();
        Iterator r27 = r25.iterator();
    L24:
        if (r27.hasNext() == false) goto L29;
        Object r28 = r27.next();
        Boolean r29 = Boolean.valueOf(((CallableMemberDescriptor) r28) instanceof FunctionDescriptor);
        Object r30 = r26.get(r29);
        if (r30 != null) goto L28;
        r30 = new ArrayList();
        r26.put(r29, r30);
    L28:
        ((List) r30).add(r28);
        goto L24
    L29:
        Iterator r31 = r26.entrySet().iterator();
    L31:
        if (r31.hasNext() == false) goto L21;
        Map.Entry r32 = (Map.Entry) r31.next();
        boolean r33 = ((Boolean) r32.getKey()).booleanValue();
        List r34 = (List) r32.getValue();
        ?? r35 = OverridingUtil.DEFAULT;
        if (r33 == false) goto L41;
        ?? r36 = new ArrayList();
        Iterator r37 = r11.iterator();
    L36:
        if (r37.hasNext() == false) goto L40;
        Object r38 = r37.next();
        if (Intrinsics.areEqual(((FunctionDescriptor) r38).getName(), r24) == false) goto L36;
        r36.add(r38);
    L40:
        ?? r39 = r36;
        r35.generateOverridesInFunctionGroup(r24, r34, r39, this.containingClass, new AnonymousClass4(r5, this));
        goto L31
    L41:
        r36 = CollectionsKt.emptyList();
        goto L40
    L44:
        return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(r5);
    }

    private final List<DeclarationDescriptor> getAllDescriptors() {
        return (List) StorageKt.getValue(this.allDescriptors$delegate, this, $$delegatedProperties[0]);
    }

    public abstract List<FunctionDescriptor> computeDeclaredFunctions();

    public final ClassDescriptor getContainingClass() {
        return this.containingClass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r5, Function1<? super Name, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r5, "kindFilter");
        Intrinsics.checkNotNullParameter(r10, "nameFilter");
        if (r5.acceptsKinds(DescriptorKindFilter.CALLABLES.getKindMask()) == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return getAllDescriptors();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name r5, LookupLocation r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "location");
        List<DeclarationDescriptor> r11 = getAllDescriptors();
        SmartList r12 = new SmartList();
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L10;
        Object r14 = r13.next();
        if ((r14 instanceof SimpleFunctionDescriptor) == false) goto L4;
        if (Intrinsics.areEqual(((SimpleFunctionDescriptor) r14).getName(), r5) == false) goto L4;
        r12.add(r14);
        goto L4
    L10:
        return r12;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name r5, LookupLocation r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "location");
        List<DeclarationDescriptor> r11 = getAllDescriptors();
        SmartList r12 = new SmartList();
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L10;
        Object r14 = r13.next();
        if ((r14 instanceof PropertyDescriptor) == false) goto L4;
        if (Intrinsics.areEqual(((PropertyDescriptor) r14).getName(), r5) == false) goto L4;
        r12.add(r14);
        goto L4
    L10:
        return r12;
    }
}
