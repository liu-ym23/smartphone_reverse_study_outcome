package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class JvmBuiltInClassDescriptorFactory implements ClassDescriptorFactory {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private static final ClassId CLONEABLE_CLASS_ID = null;
    private static final Name CLONEABLE_NAME = null;
    public static final Companion Companion = null;
    private static final FqName KOTLIN_FQ_NAME = null;
    private final NotNullLazyValue cloneable$delegate;
    private final Function1<ModuleDescriptor, DeclarationDescriptor> computeContainingDeclaration;
    private final ModuleDescriptor moduleDescriptor;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final ClassId getCLONEABLE_CLASS_ID() {
            return JvmBuiltInClassDescriptorFactory.access$getCLONEABLE_CLASS_ID$cp();
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmBuiltInClassDescriptorFactory.class), "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;"))};
        Companion = new Companion(null);
        KOTLIN_FQ_NAME = StandardNames.BUILT_INS_PACKAGE_FQ_NAME;
        FqNameUnsafe r0 = StandardNames.FqNames.cloneable;
        CLONEABLE_NAME = r0.shortName();
        CLONEABLE_CLASS_ID = ClassId.Companion.topLevel(r0.toSafe());
    }

    public static /* synthetic */ ClassDescriptorImpl accessor$JvmBuiltInClassDescriptorFactory$lambda0(JvmBuiltInClassDescriptorFactory r0, StorageManager r1) {
        return cloneable_delegate$lambda$2(r0, r1);
    }

    public static /* synthetic */ BuiltInsPackageFragment accessor$JvmBuiltInClassDescriptorFactory$lambda1(ModuleDescriptor r0) {
        return _init_$lambda$0(r0);
    }

    private final ClassDescriptorImpl getCloneable() {
        return (ClassDescriptorImpl) StorageKt.getValue(this.cloneable$delegate, this, $$delegatedProperties[0]);
    }

    public static final /* synthetic */ ClassId access$getCLONEABLE_CLASS_ID$cp() {
        return CLONEABLE_CLASS_ID;
    }

    private static final BuiltInsPackageFragment _init_$lambda$0(ModuleDescriptor r3) {
        Intrinsics.checkNotNullParameter(r3, "module");
        List<PackageFragmentDescriptor> r4 = r3.getPackage(KOTLIN_FQ_NAME).getFragments();
        ArrayList r0 = new ArrayList();
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        Object r1 = r5.next();
        if ((r1 instanceof BuiltInsPackageFragment) == false) goto L4;
        r0.add(r1);
        goto L4
    L9:
        return (BuiltInsPackageFragment) CollectionsKt.first(r0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public ClassDescriptor createClass(ClassId r2) {
        Intrinsics.checkNotNullParameter(r2, "classId");
        if (Intrinsics.areEqual(r2, CLONEABLE_CLASS_ID) == true) goto L7;
        return null;
    L7:
        return getCloneable();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public Collection<ClassDescriptor> getAllContributedClassesIfPossible(FqName r2) {
        Intrinsics.checkNotNullParameter(r2, "packageFqName");
        if (Intrinsics.areEqual(r2, KOTLIN_FQ_NAME) == false) goto L6;
        return SetsKt.setOf(getCloneable());
    L6:
        return SetsKt.emptySet();
    }

    private static final ClassDescriptorImpl cloneable_delegate$lambda$2(JvmBuiltInClassDescriptorFactory r10, StorageManager r11) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        Intrinsics.checkNotNullParameter(r11, "$storageManager");
        ClassDescriptorImpl r0 = new ClassDescriptorImpl((DeclarationDescriptor) r10.computeContainingDeclaration.invoke(r10.moduleDescriptor), CLONEABLE_NAME, Modality.ABSTRACT, ClassKind.INTERFACE, CollectionsKt.listOf(r10.moduleDescriptor.getBuiltIns().getAnyType()), SourceElement.NO_SOURCE, false, r11);
        r0.initialize(new CloneableClassScope(r11, r0), SetsKt.emptySet(), null);
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public boolean shouldCreateClass(FqName r2, Name r3) {
        Intrinsics.checkNotNullParameter(r2, "packageFqName");
        Intrinsics.checkNotNullParameter(r3, DBDefinition.NAME);
        if (Intrinsics.areEqual(r3, CLONEABLE_NAME) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r2, KOTLIN_FQ_NAME) == false) goto L7;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JvmBuiltInClassDescriptorFactory(final StorageManager r2, ModuleDescriptor r3, Function1<? super ModuleDescriptor, ? extends DeclarationDescriptor> r4) {
        Intrinsics.checkNotNullParameter(r2, "storageManager");
        Intrinsics.checkNotNullParameter(r3, "moduleDescriptor");
        Intrinsics.checkNotNullParameter(r4, "computeContainingDeclaration");
        this.moduleDescriptor = r3;
        this.computeContainingDeclaration = r4;
        this.cloneable$delegate = r2.createLazyValue(new JvmBuiltInClassDescriptorFactory$$Lambda$0(this, r2));
    }

    public /* synthetic */ JvmBuiltInClassDescriptorFactory(StorageManager r1, ModuleDescriptor r2, Function1 r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = JvmBuiltInClassDescriptorFactory$$Lambda$1.INSTANCE;
    L5:
        this(r1, r2, r3);
    }
}
