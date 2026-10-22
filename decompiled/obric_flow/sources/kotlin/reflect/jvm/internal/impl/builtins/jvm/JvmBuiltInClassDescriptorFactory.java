package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.Collection;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: classes3.dex */
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
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final ClassId getCLONEABLE_CLASS_ID() {
            return JvmBuiltInClassDescriptorFactory.access$getCLONEABLE_CLASS_ID$cp();
        }

        private Companion() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmBuiltInClassDescriptorFactory.class), "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;"))};
        Companion = new Companion(null);
        KOTLIN_FQ_NAME = StandardNames.BUILT_INS_PACKAGE_FQ_NAME;
        FqNameUnsafe r5 = StandardNames.FqNames.cloneable;
        CLONEABLE_NAME = r5.shortName();
        CLONEABLE_CLASS_ID = ClassId.topLevel(r5.toSafe());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JvmBuiltInClassDescriptorFactory(final StorageManager r5, ModuleDescriptor r10, Function1<? super ModuleDescriptor, ? extends DeclarationDescriptor> r11) {
        Intrinsics.checkNotNullParameter(r5, "storageManager");
        Intrinsics.checkNotNullParameter(r10, "moduleDescriptor");
        Intrinsics.checkNotNullParameter(r11, "computeContainingDeclaration");
        this.moduleDescriptor = r10;
        this.computeContainingDeclaration = r11;
        this.cloneable$delegate = r5.createLazyValue(new JvmBuiltInClassDescriptorFactory$cloneable$2(this, r5));
    }

    public static final /* synthetic */ ClassId access$getCLONEABLE_CLASS_ID$cp() {
        return CLONEABLE_CLASS_ID;
    }

    public static final /* synthetic */ Name access$getCLONEABLE_NAME$cp() {
        return CLONEABLE_NAME;
    }

    public static final /* synthetic */ Function1 access$getComputeContainingDeclaration$p(JvmBuiltInClassDescriptorFactory r5) {
        return r5.computeContainingDeclaration;
    }

    public static final /* synthetic */ FqName access$getKOTLIN_FQ_NAME$cp() {
        return KOTLIN_FQ_NAME;
    }

    public static final /* synthetic */ ModuleDescriptor access$getModuleDescriptor$p(JvmBuiltInClassDescriptorFactory r5) {
        return r5.moduleDescriptor;
    }

    private final ClassDescriptorImpl getCloneable() {
        return (ClassDescriptorImpl) StorageKt.getValue(this.cloneable$delegate, this, $$delegatedProperties[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public ClassDescriptor createClass(ClassId r5) {
        Intrinsics.checkNotNullParameter(r5, "classId");
        if (Intrinsics.areEqual(r5, CLONEABLE_CLASS_ID) == true) goto L7;
        return null;
    L7:
        return getCloneable();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public Collection<ClassDescriptor> getAllContributedClassesIfPossible(FqName r5) {
        Intrinsics.checkNotNullParameter(r5, "packageFqName");
        if (Intrinsics.areEqual(r5, KOTLIN_FQ_NAME) == false) goto L6;
        return SetsKt.setOf(getCloneable());
    L6:
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public boolean shouldCreateClass(FqName r5, Name r10) {
        Intrinsics.checkNotNullParameter(r5, "packageFqName");
        Intrinsics.checkNotNullParameter(r10, "name");
        if (Intrinsics.areEqual(r10, CLONEABLE_NAME) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r5, KOTLIN_FQ_NAME) == false) goto L7;
        return true;
    }

    public /* synthetic */ JvmBuiltInClassDescriptorFactory(StorageManager r5, ModuleDescriptor r10, Function1 r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 4) == 0) goto L5;
        r11 = AnonymousClass1.INSTANCE;
    L5:
        this(r5, r10, r11);
    }
}
