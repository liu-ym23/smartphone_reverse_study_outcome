package kotlin.reflect.jvm.internal.impl.builtins.functions;

import ai.j0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nFunctionClassDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FunctionClassDescriptor.kt\norg/jetbrains/kotlin/builtins/functions/FunctionClassDescriptor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,139:1\n1549#2:140\n1620#2,3:141\n*S KotlinDebug\n*F\n+ 1 FunctionClassDescriptor.kt\norg/jetbrains/kotlin/builtins/functions/FunctionClassDescriptor\n*L\n51#1:140\n51#1:141,3\n*E\n"})
public final class FunctionClassDescriptor extends AbstractClassDescriptor {
    public static final Companion Companion = null;
    private static final ClassId functionClassId = null;
    private static final ClassId kFunctionClassId = null;
    private final int arity;
    private final PackageFragmentDescriptor containingDeclaration;
    private final FunctionClassKind functionKind;
    private final FunctionClassScope memberScope;
    private final List<TypeParameterDescriptor> parameters;
    private final StorageManager storageManager;
    private final FunctionTypeConstructor typeConstructor;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    @SourceDebugExtension({"SMAP\nFunctionClassDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FunctionClassDescriptor.kt\norg/jetbrains/kotlin/builtins/functions/FunctionClassDescriptor$FunctionTypeConstructor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,139:1\n1549#2:140\n1620#2,2:141\n1549#2:143\n1620#2,3:144\n1622#2:147\n*S KotlinDebug\n*F\n+ 1 FunctionClassDescriptor.kt\norg/jetbrains/kotlin/builtins/functions/FunctionClassDescriptor$FunctionTypeConstructor\n*L\n109#1:140\n109#1:141,2\n113#1:143\n113#1:144,3\n109#1:147\n*E\n"})
    public final class FunctionTypeConstructor extends AbstractClassTypeConstructor {
        final /* synthetic */ FunctionClassDescriptor this$0;

        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r5 = new int[FunctionClassKind.values().length];
                r5[FunctionClassKind.Function.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r5[FunctionClassKind.KFunction.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r5[FunctionClassKind.SuspendFunction.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r5[FunctionClassKind.KSuspendFunction.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                $EnumSwitchMapping$0 = r5;
            }
        }

        public FunctionTypeConstructor(FunctionClassDescriptor r5) {
            this.this$0 = r5;
            super(FunctionClassDescriptor.access$getStorageManager$p(r5));
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        public Collection<KotlinType> computeSupertypes() {
            int r5 = WhenMappings.$EnumSwitchMapping$0[this.this$0.getFunctionKind().ordinal()];
            if (r5 != 1) goto L5;
            List r10 = CollectionsKt.listOf(FunctionClassDescriptor.access$getFunctionClassId$cp());
        L16:
            ModuleDescriptor r11 = FunctionClassDescriptor.access$getContainingDeclaration$p(this.this$0).getContainingDeclaration();
            ArrayList r12 = new ArrayList(CollectionsKt.h(r10));
            Iterator r13 = r10.iterator();
        L18:
            if (r13.hasNext() == false) goto L29;
            ClassId r14 = (ClassId) r13.next();
            ClassDescriptor r15 = FindClassInModuleKt.findClassAcrossModuleDependencies(r11, r14);
            if (r15 == null) goto L27;
            List r16 = CollectionsKt.takeLast(getParameters(), r15.getTypeConstructor().getParameters().size());
            ArrayList r17 = new ArrayList(CollectionsKt.h(r16));
            Iterator r18 = r16.iterator();
        L23:
            if (r18.hasNext() == false) goto L25;
            r17.add(new TypeProjectionImpl(((TypeParameterDescriptor) r18.next()).getDefaultType()));
            goto L23
        L25:
            r12.add(KotlinTypeFactory.simpleNotNullType(TypeAttributes.Companion.getEmpty(), r15, r17));
            goto L18
        L27:
            throw new IllegalStateException(("Built-in class " + r14 + " not found").toString());
        L29:
            return CollectionsKt.toList(r12);
        L5:
            if (r5 != 2) goto L7;
            r10 = CollectionsKt.listOf(new ClassId[]{FunctionClassDescriptor.access$getKFunctionClassId$cp(), new ClassId(StandardNames.BUILT_INS_PACKAGE_FQ_NAME, FunctionClassKind.Function.numberedClassName(this.this$0.getArity()))});
            goto L16
        L7:
            if (r5 != 3) goto L9;
            r10 = CollectionsKt.listOf(FunctionClassDescriptor.access$getFunctionClassId$cp());
            goto L16
        L9:
            if (r5 != 4) goto L12;
            r10 = CollectionsKt.listOf(new ClassId[]{FunctionClassDescriptor.access$getKFunctionClassId$cp(), new ClassId(StandardNames.COROUTINES_PACKAGE_FQ_NAME, FunctionClassKind.SuspendFunction.numberedClassName(this.this$0.getArity()))});
            goto L16
        L12:
            throw new NoWhenBranchMatchedException();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor, kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* JADX INFO: renamed from: getDeclarationDescriptor */
        public /* bridge */ /* synthetic */ ClassDescriptor mo1402getDeclarationDescriptor() {
            return mo1402getDeclarationDescriptor();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public List<TypeParameterDescriptor> getParameters() {
            return FunctionClassDescriptor.access$getParameters$p(this.this$0);
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
            return mo1402getDeclarationDescriptor().toString();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor, kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* JADX INFO: renamed from: getDeclarationDescriptor */
        public /* bridge */ /* synthetic */ ClassifierDescriptor mo1402getDeclarationDescriptor() {
            return mo1402getDeclarationDescriptor();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor, kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* JADX INFO: renamed from: getDeclarationDescriptor */
        public FunctionClassDescriptor mo1402getDeclarationDescriptor() {
            return this.this$0;
        }
    }

    static {
        Companion = new Companion(null);
        functionClassId = new ClassId(StandardNames.BUILT_INS_PACKAGE_FQ_NAME, Name.identifier("Function"));
        kFunctionClassId = new ClassId(StandardNames.KOTLIN_REFLECT_FQ_NAME, Name.identifier("KFunction"));
    }

    public FunctionClassDescriptor(StorageManager r5, PackageFragmentDescriptor r10, FunctionClassKind r11, int r12) {
        Intrinsics.checkNotNullParameter(r5, "storageManager");
        Intrinsics.checkNotNullParameter(r10, "containingDeclaration");
        Intrinsics.checkNotNullParameter(r11, "functionKind");
        super(r5, r11.numberedClassName(r12));
        this.storageManager = r5;
        this.containingDeclaration = r10;
        this.functionKind = r11;
        this.arity = r12;
        this.typeConstructor = new FunctionTypeConstructor(this);
        this.memberScope = new FunctionClassScope(r5, this);
        ArrayList r13 = new ArrayList();
        IntRange r14 = new IntRange(1, r12);
        ArrayList r15 = new ArrayList(CollectionsKt.h(r14));
        Iterator<Integer> r16 = r14.iterator();
    L4:
        if (r16.hasNext() == false) goto L6;
        int r17 = ((IntIterator) r16).nextInt();
        _init_$typeParameter(r13, this, Variance.IN_VARIANCE, j0.g(r17, "P"));
        r15.add(Unit.INSTANCE);
        goto L4
    L6:
        _init_$typeParameter(r13, this, Variance.OUT_VARIANCE, "R");
        this.parameters = CollectionsKt.toList(r13);
    }

    private static final void _init_$typeParameter(ArrayList<TypeParameterDescriptor> r10, FunctionClassDescriptor r11, Variance r12, String r13) {
        r10.add(TypeParameterDescriptorImpl.createWithDefaultBound(r11, Annotations.Companion.getEMPTY(), false, r12, Name.identifier(r13), r10.size(), r11.storageManager));
    }

    public static final /* synthetic */ PackageFragmentDescriptor access$getContainingDeclaration$p(FunctionClassDescriptor r5) {
        return r5.containingDeclaration;
    }

    public static final /* synthetic */ ClassId access$getFunctionClassId$cp() {
        return functionClassId;
    }

    public static final /* synthetic */ ClassId access$getKFunctionClassId$cp() {
        return kFunctionClassId;
    }

    public static final /* synthetic */ List access$getParameters$p(FunctionClassDescriptor r5) {
        return r5.parameters;
    }

    public static final /* synthetic */ StorageManager access$getStorageManager$p(FunctionClassDescriptor r5) {
        return r5.storageManager;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        return Annotations.Companion.getEMPTY();
    }

    public final int getArity() {
        return this.arity;
    }

    public Void getCompanionObjectDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public /* bridge */ /* synthetic */ Collection getConstructors() {
        return getConstructors();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getContainingDeclaration() {
        return getContainingDeclaration();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        return this.parameters;
    }

    public final FunctionClassKind getFunctionKind() {
        return this.functionKind;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public ClassKind getKind() {
        return ClassKind.INTERFACE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public Modality getModality() {
        return Modality.ABSTRACT;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public /* bridge */ /* synthetic */ Collection getSealedSubclasses() {
        return getSealedSubclasses();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    public SourceElement getSource() {
        return SourceElement.NO_SOURCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public /* bridge */ /* synthetic */ MemberScope getStaticScope() {
        return getStaticScope();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public TypeConstructor getTypeConstructor() {
        return this.typeConstructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    public /* bridge */ /* synthetic */ MemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner r5) {
        return getUnsubstitutedMemberScope(r5);
    }

    public Void getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public ValueClassRepresentation<SimpleType> getValueClassRepresentation() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public DescriptorVisibility getVisibility() {
        return DescriptorVisibilities.PUBLIC;
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

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
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
        return getName().asString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    /* JADX INFO: renamed from: getCompanionObjectDescriptor, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ ClassDescriptor mo1395getCompanionObjectDescriptor() {
        return (ClassDescriptor) getCompanionObjectDescriptor();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public List<ClassConstructorDescriptor> getConstructors() {
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public PackageFragmentDescriptor getContainingDeclaration() {
        return this.containingDeclaration;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public List<ClassDescriptor> getSealedSubclasses() {
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public MemberScope.Empty getStaticScope() {
        return MemberScope.Empty.INSTANCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    public FunctionClassScope getUnsubstitutedMemberScope(KotlinTypeRefiner r5) {
        Intrinsics.checkNotNullParameter(r5, "kotlinTypeRefiner");
        return this.memberScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    /* JADX INFO: renamed from: getUnsubstitutedPrimaryConstructor, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ ClassConstructorDescriptor mo1396getUnsubstitutedPrimaryConstructor() {
        return (ClassConstructorDescriptor) getUnsubstitutedPrimaryConstructor();
    }
}
