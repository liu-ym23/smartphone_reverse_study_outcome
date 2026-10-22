package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: loaded from: classes3.dex */
public class EnumEntrySyntheticClassDescriptor extends ClassDescriptorBase {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Annotations annotations;
    private final NotNullLazyValue<Set<Name>> enumMemberNames;
    private final MemberScope scope;
    private final TypeConstructor typeConstructor;

    private class EnumEntryScope extends MemberScopeImpl {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final NotNullLazyValue<Collection<DeclarationDescriptor>> allDescriptors;
        private final MemoizedFunctionToNotNull<Name, Collection<? extends SimpleFunctionDescriptor>> functions;
        private final MemoizedFunctionToNotNull<Name, Collection<? extends PropertyDescriptor>> properties;
        final /* synthetic */ EnumEntrySyntheticClassDescriptor this$0;

        private static /* synthetic */ void $$$reportNull$$$0(int r13) {
            if (r13 == 3) goto L9;
            if (r13 == 7) goto L9;
            if (r13 == 9) goto L9;
            if (r13 == 12) goto L9;
            switch(r13) {
                case 15: goto L9;
                case 16: goto L9;
                case 17: goto L9;
                case 18: goto L9;
                case 19: goto L9;
                default: goto L8;
            };
        L8:
            String r10 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L11:
            if (r13 == 3) goto L17;
            if (r13 == 7) goto L62;
            if (r13 == 9) goto L63;
            if (r13 == 12) goto L64;
            switch(r13) {
                case 15: goto L65;
                case 16: goto L65;
                case 17: goto L65;
                case 18: goto L65;
                case 19: goto L65;
                default: goto L16;
            };
        L16:
            int r11 = 3;
        L18:
            Object[] r12 = new Object[r11];
            switch(r13) {
                case 1: goto L27;
                case 2: goto L26;
                case 3: goto L25;
                case 4: goto L27;
                case 5: goto L27;
                case 6: goto L26;
                case 7: goto L25;
                case 8: goto L27;
                case 9: goto L25;
                case 10: goto L27;
                case 11: goto L24;
                case 12: goto L25;
                case 13: goto L23;
                case 14: goto L22;
                case 15: goto L25;
                case 16: goto L25;
                case 17: goto L25;
                case 18: goto L25;
                case 19: goto L25;
                case 20: goto L21;
                default: goto L20;
            };
        L20:
            r12[0] = "storageManager";
        L29:
            if (r13 == 3) goto L43;
            if (r13 == 7) goto L42;
            if (r13 == 9) goto L41;
            if (r13 == 12) goto L40;
            switch(r13) {
                case 15: goto L39;
                case 16: goto L38;
                case 17: goto L37;
                case 18: goto L36;
                case 19: goto L35;
                default: goto L34;
            };
        L34:
            r12[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope";
        L44:
            switch(r13) {
                case 1: goto L52;
                case 2: goto L52;
                case 3: goto L53;
                case 4: goto L51;
                case 5: goto L50;
                case 6: goto L50;
                case 7: goto L53;
                case 8: goto L49;
                case 9: goto L53;
                case 10: goto L48;
                case 11: goto L48;
                case 12: goto L53;
                case 13: goto L47;
                case 14: goto L47;
                case 15: goto L53;
                case 16: goto L53;
                case 17: goto L53;
                case 18: goto L53;
                case 19: goto L53;
                case 20: goto L46;
                default: goto L45;
            };
        L45:
            r12[2] = "<init>";
            goto L53
        L46:
            r12[2] = "printScopeStructure";
            goto L53
        L47:
            r12[2] = "getContributedDescriptors";
            goto L53
        L48:
            r12[2] = "resolveFakeOverrides";
            goto L53
        L49:
            r12[2] = "computeFunctions";
            goto L53
        L50:
            r12[2] = "getContributedFunctions";
            goto L53
        L51:
            r12[2] = "computeProperties";
            goto L53
        L52:
            r12[2] = "getContributedVariables";
        L53:
            String r14 = String.format(r10, r12);
            if (r13 == 3) goto L61;
            if (r13 == 7) goto L61;
            if (r13 == 9) goto L61;
            if (r13 == 12) goto L61;
            switch(r13) {
                case 15: goto L61;
                case 16: goto L61;
                case 17: goto L61;
                case 18: goto L61;
                case 19: goto L61;
                default: goto L66;
            };
        L66:
            throw new IllegalArgumentException(r14);
        L61:
            throw new IllegalStateException(r14);
        L35:
            r12[1] = "getVariableNames";
            goto L44
        L36:
            r12[1] = "getClassifierNames";
            goto L44
        L37:
            r12[1] = "getFunctionNames";
            goto L44
        L38:
            r12[1] = "computeAllDeclarations";
            goto L44
        L39:
            r12[1] = "getContributedDescriptors";
            goto L44
        L40:
            r12[1] = "resolveFakeOverrides";
            goto L44
        L41:
            r12[1] = "getSupertypeScope";
            goto L44
        L42:
            r12[1] = "getContributedFunctions";
            goto L44
        L43:
            r12[1] = "getContributedVariables";
            goto L44
        L21:
            r12[0] = "p";
            goto L29
        L22:
            r12[0] = "nameFilter";
            goto L29
        L23:
            r12[0] = "kindFilter";
            goto L29
        L24:
            r12[0] = "fromSupertypes";
            goto L29
        L25:
            r12[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope";
            goto L29
        L26:
            r12[0] = "location";
            goto L29
        L27:
            r12[0] = ActivityLifecycle.NAME;
            goto L29
        L65:
            r11 = 2;
            goto L18
        L64:
            r11 = 2;
            goto L18
        L63:
            r11 = 2;
            goto L18
        L62:
            r11 = 2;
            goto L18
        L17:
            r11 = 2;
        L9:
            r10 = "@NotNull method %s.%s must not return null";
            goto L11
        }

        static {
        }

        public EnumEntryScope(final EnumEntrySyntheticClassDescriptor r10, StorageManager r11) {
            if (r11 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            this.this$0 = r10;
            this.functions = r11.createMemoizedFunction(new AnonymousClass1(this, r10));
            this.properties = r11.createMemoizedFunction(new AnonymousClass2(this, r10));
            this.allDescriptors = r11.createLazyValue(new AnonymousClass3(this, r10));
        }

        static /* synthetic */ Collection access$000(EnumEntryScope r10, Name r11) {
            return r10.computeFunctions(r11);
        }

        static /* synthetic */ Collection access$100(EnumEntryScope r10, Name r11) {
            return r10.computeProperties(r11);
        }

        static /* synthetic */ Collection access$200(EnumEntryScope r10) {
            return r10.computeAllDeclarations();
        }

        private Collection<DeclarationDescriptor> computeAllDeclarations() {
            HashSet r10 = new HashSet();
            Iterator r11 = ((Set) EnumEntrySyntheticClassDescriptor.access$300(this.this$0).invoke()).iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            Name r12 = (Name) r11.next();
            NoLookupLocation r13 = NoLookupLocation.FOR_NON_TRACKED_SCOPE;
            r10.addAll(getContributedFunctions(r12, r13));
            r10.addAll(getContributedVariables(r12, r13));
            goto L4
        L6:
            return r10;
        }

        private Collection<? extends SimpleFunctionDescriptor> computeFunctions(Name r10) {
            if (r10 != null) goto L5;
            $$$reportNull$$$0(8);
        L5:
            return resolveFakeOverrides(r10, getSupertypeScope().getContributedFunctions(r10, NoLookupLocation.FOR_NON_TRACKED_SCOPE));
        }

        private Collection<? extends PropertyDescriptor> computeProperties(Name r10) {
            if (r10 != null) goto L5;
            $$$reportNull$$$0(4);
        L5:
            return resolveFakeOverrides(r10, getSupertypeScope().getContributedVariables(r10, NoLookupLocation.FOR_NON_TRACKED_SCOPE));
        }

        private MemberScope getSupertypeScope() {
            MemberScope r10 = this.this$0.getTypeConstructor().mo1324getSupertypes().iterator().next().getMemberScope();
            if (r10 != null) goto L5;
            $$$reportNull$$$0(9);
        L5:
            return r10;
        }

        private <D extends CallableMemberDescriptor> Collection<? extends D> resolveFakeOverrides(Name r10, Collection<? extends D> r11) {
            if (r10 != null) goto L4;
            $$$reportNull$$$0(10);
        L4:
            if (r11 != null) goto L6;
            $$$reportNull$$$0(11);
        L6:
            final LinkedHashSet r12 = new LinkedHashSet();
            OverridingUtil.DEFAULT.generateOverridesInFunctionGroup(r10, r11, Collections.emptySet(), this.this$0, new AnonymousClass4(this, r12));
            return r12;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        public Set<Name> getClassifierNames() {
            Set<Name> r10 = Collections.emptySet();
            if (r10 != null) goto L5;
            $$$reportNull$$$0(18);
        L5:
            return r10;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r10, Function1<? super Name, Boolean> r11) {
            if (r10 != null) goto L4;
            $$$reportNull$$$0(13);
        L4:
            if (r11 != null) goto L6;
            $$$reportNull$$$0(14);
        L6:
            Collection<DeclarationDescriptor> r12 = this.allDescriptors.invoke();
            if (r12 != null) goto L9;
            $$$reportNull$$$0(15);
        L9:
            return r12;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        public Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(Name r10, LookupLocation r11) {
            if (r10 != null) goto L4;
            $$$reportNull$$$0(5);
        L4:
            if (r11 != null) goto L6;
            $$$reportNull$$$0(6);
        L6:
            Collection<? extends SimpleFunctionDescriptor> r12 = this.functions.invoke(r10);
            if (r12 != null) goto L9;
            $$$reportNull$$$0(7);
        L9:
            return r12;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        public Collection<? extends PropertyDescriptor> getContributedVariables(Name r10, LookupLocation r11) {
            if (r10 != null) goto L4;
            $$$reportNull$$$0(1);
        L4:
            if (r11 != null) goto L6;
            $$$reportNull$$$0(2);
        L6:
            Collection<? extends PropertyDescriptor> r12 = this.properties.invoke(r10);
            if (r12 != null) goto L9;
            $$$reportNull$$$0(3);
        L9:
            return r12;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        public Set<Name> getFunctionNames() {
            Set<Name> r10 = (Set) EnumEntrySyntheticClassDescriptor.access$300(this.this$0).invoke();
            if (r10 != null) goto L5;
            $$$reportNull$$$0(17);
        L5:
            return r10;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        public Set<Name> getVariableNames() {
            Set<Name> r10 = (Set) EnumEntrySyntheticClassDescriptor.access$300(this.this$0).invoke();
            if (r10 != null) goto L5;
            $$$reportNull$$$0(19);
        L5:
            return r10;
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        switch(r10) {
            case 14: goto L4;
            case 15: goto L4;
            case 16: goto L4;
            case 17: goto L4;
            case 18: goto L4;
            case 19: goto L4;
            case 20: goto L4;
            case 21: goto L4;
            case 22: goto L4;
            case 23: goto L4;
            default: goto L3;
        };
    L3:
        String r11 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L6:
        switch(r10) {
            case 14: goto L8;
            case 15: goto L8;
            case 16: goto L8;
            case 17: goto L8;
            case 18: goto L8;
            case 19: goto L8;
            case 20: goto L8;
            case 21: goto L8;
            case 22: goto L8;
            case 23: goto L8;
            default: goto L7;
        };
    L7:
        int r12 = 3;
    L9:
        Object[] r13 = new Object[r12];
        switch(r10) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L11;
            case 7: goto L15;
            case 8: goto L14;
            case 9: goto L19;
            case 10: goto L18;
            case 11: goto L17;
            case 12: goto L16;
            case 13: goto L13;
            case 14: goto L12;
            case 15: goto L12;
            case 16: goto L12;
            case 17: goto L12;
            case 18: goto L12;
            case 19: goto L12;
            case 20: goto L12;
            case 21: goto L12;
            case 22: goto L12;
            case 23: goto L12;
            default: goto L11;
        };
    L11:
        r13[0] = "storageManager";
    L22:
        switch(r10) {
            case 14: goto L33;
            case 15: goto L32;
            case 16: goto L31;
            case 17: goto L30;
            case 18: goto L29;
            case 19: goto L28;
            case 20: goto L27;
            case 21: goto L26;
            case 22: goto L25;
            case 23: goto L24;
            default: goto L23;
        };
    L23:
        r13[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
    L34:
        switch(r10) {
            case 6: goto L37;
            case 7: goto L37;
            case 8: goto L37;
            case 9: goto L37;
            case 10: goto L37;
            case 11: goto L37;
            case 12: goto L37;
            case 13: goto L36;
            case 14: goto L38;
            case 15: goto L38;
            case 16: goto L38;
            case 17: goto L38;
            case 18: goto L38;
            case 19: goto L38;
            case 20: goto L38;
            case 21: goto L38;
            case 22: goto L38;
            case 23: goto L38;
            default: goto L35;
        };
    L35:
        r13[2] = "create";
        goto L38
    L36:
        r13[2] = "getUnsubstitutedMemberScope";
        goto L38
    L37:
        r13[2] = "<init>";
    L38:
        String r14 = String.format(r11, r13);
        switch(r10) {
            case 14: goto L42;
            case 15: goto L42;
            case 16: goto L42;
            case 17: goto L42;
            case 18: goto L42;
            case 19: goto L42;
            case 20: goto L42;
            case 21: goto L42;
            case 22: goto L42;
            case 23: goto L42;
            default: goto L43;
        };
    L43:
        throw new IllegalArgumentException(r14);
    L42:
        throw new IllegalStateException(r14);
    L24:
        r13[1] = "getSealedSubclasses";
        goto L34
    L25:
        r13[1] = "getDeclaredTypeParameters";
        goto L34
    L26:
        r13[1] = "getAnnotations";
        goto L34
    L27:
        r13[1] = "getVisibility";
        goto L34
    L28:
        r13[1] = "getModality";
        goto L34
    L29:
        r13[1] = "getKind";
        goto L34
    L30:
        r13[1] = "getTypeConstructor";
        goto L34
    L31:
        r13[1] = "getConstructors";
        goto L34
    L32:
        r13[1] = "getStaticScope";
        goto L34
    L33:
        r13[1] = "getUnsubstitutedMemberScope";
        goto L34
    L12:
        r13[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
        goto L22
    L13:
        r13[0] = "kotlinTypeRefiner";
        goto L22
    L14:
        r13[0] = "supertype";
        goto L22
    L15:
        r13[0] = "containingClass";
        goto L22
    L16:
        r13[0] = "source";
        goto L22
    L17:
        r13[0] = "annotations";
        goto L22
    L18:
        r13[0] = "enumMemberNames";
        goto L22
    L19:
        r13[0] = ActivityLifecycle.NAME;
        goto L22
    L20:
        r13[0] = "enumClass";
        goto L22
    L8:
        r12 = 2;
        goto L9
    L4:
        r11 = "@NotNull method %s.%s must not return null";
        goto L6
    }

    static {
    }

    private EnumEntrySyntheticClassDescriptor(StorageManager r10, ClassDescriptor r11, KotlinType r12, Name r13, NotNullLazyValue<Set<Name>> r14, Annotations r15, SourceElement r16) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(6);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(7);
    L6:
        if (r12 != null) goto L8;
        $$$reportNull$$$0(8);
    L8:
        if (r13 != null) goto L10;
        $$$reportNull$$$0(9);
    L10:
        if (r14 != null) goto L12;
        $$$reportNull$$$0(10);
    L12:
        if (r15 != null) goto L14;
        $$$reportNull$$$0(11);
    L14:
        if (r16 != null) goto L16;
        $$$reportNull$$$0(12);
    L16:
        super(r10, r11, r13, r16, false);
        this.annotations = r15;
        this.typeConstructor = new ClassTypeConstructorImpl(this, Collections.emptyList(), Collections.singleton(r12), r10);
        this.scope = new EnumEntryScope(this, r10);
        this.enumMemberNames = r14;
    }

    static /* synthetic */ NotNullLazyValue access$300(EnumEntrySyntheticClassDescriptor r10) {
        return r10.enumMemberNames;
    }

    public static EnumEntrySyntheticClassDescriptor create(StorageManager r10, ClassDescriptor r11, Name r12, NotNullLazyValue<Set<Name>> r13, Annotations r14, SourceElement r15) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r12 != null) goto L8;
        $$$reportNull$$$0(2);
    L8:
        if (r13 != null) goto L10;
        $$$reportNull$$$0(3);
    L10:
        if (r14 != null) goto L12;
        $$$reportNull$$$0(4);
    L12:
        if (r15 != null) goto L15;
        $$$reportNull$$$0(5);
    L15:
        return new EnumEntrySyntheticClassDescriptor(r10, r11, r11.getDefaultType(), r12, r13, r14, r15);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        Annotations r10 = this.annotations;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(21);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    /* JADX INFO: renamed from: getCompanionObjectDescriptor */
    public ClassDescriptor mo1316getCompanionObjectDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public Collection<ClassConstructorDescriptor> getConstructors() {
        List r10 = Collections.emptyList();
        if (r10 != null) goto L5;
        $$$reportNull$$$0(16);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        List<TypeParameterDescriptor> r10 = Collections.emptyList();
        if (r10 != null) goto L5;
        $$$reportNull$$$0(22);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public ClassKind getKind() {
        ClassKind r10 = ClassKind.ENUM_ENTRY;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(18);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public Modality getModality() {
        Modality r10 = Modality.FINAL;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(19);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public Collection<ClassDescriptor> getSealedSubclasses() {
        List r10 = Collections.emptyList();
        if (r10 != null) goto L5;
        $$$reportNull$$$0(23);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public MemberScope getStaticScope() {
        MemberScope.Empty r10 = MemberScope.Empty.INSTANCE;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(15);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public TypeConstructor getTypeConstructor() {
        TypeConstructor r10 = this.typeConstructor;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(17);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    public MemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(13);
    L4:
        MemberScope r11 = this.scope;
        if (r11 != null) goto L7;
        $$$reportNull$$$0(14);
    L7:
        return r11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    /* JADX INFO: renamed from: getUnsubstitutedPrimaryConstructor */
    public ClassConstructorDescriptor mo1317getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public ValueClassRepresentation<SimpleType> getValueClassRepresentation() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public DescriptorVisibility getVisibility() {
        DescriptorVisibility r10 = DescriptorVisibilities.PUBLIC;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(20);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isCompanionObject() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isData() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isFun() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isValue() {
        return false;
    }

    public String toString() {
        return "enum entry " + getName();
    }
}
