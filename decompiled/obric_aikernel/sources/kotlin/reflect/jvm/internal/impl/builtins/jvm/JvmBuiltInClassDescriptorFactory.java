package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import com.bytedance.crash.tracker.ActivityLifecycle;
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
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
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
        FqNameUnsafe r10 = StandardNames.FqNames.cloneable;
        Name r11 = r10.shortName();
        Intrinsics.checkNotNullExpressionValue(r11, "cloneable.shortName()");
        CLONEABLE_NAME = r11;
        ClassId r12 = ClassId.topLevel(r10.toSafe());
        Intrinsics.checkNotNullExpressionValue(r12, "topLevel(StandardNames.FqNames.cloneable.toSafe())");
        CLONEABLE_CLASS_ID = r12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JvmBuiltInClassDescriptorFactory(final StorageManager r10, ModuleDescriptor r11, Function1<? super ModuleDescriptor, ? extends DeclarationDescriptor> r12) {
        Intrinsics.checkNotNullParameter(r10, "storageManager");
        Intrinsics.checkNotNullParameter(r11, "moduleDescriptor");
        Intrinsics.checkNotNullParameter(r12, "computeContainingDeclaration");
        this.moduleDescriptor = r11;
        this.computeContainingDeclaration = r12;
        this.cloneable$delegate = r10.createLazyValue(new JvmBuiltInClassDescriptorFactory$cloneable$2(this, r10));
    }

    public /* synthetic */ JvmBuiltInClassDescriptorFactory(StorageManager r10, ModuleDescriptor r11, Function1 r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = AnonymousClass1.INSTANCE;
    L5:
        this(r10, r11, r12);
    }

    public static final /* synthetic */ ClassId access$getCLONEABLE_CLASS_ID$cp() {
        return CLONEABLE_CLASS_ID;
    }

    public static final /* synthetic */ Name access$getCLONEABLE_NAME$cp() {
        return CLONEABLE_NAME;
    }

    public static final /* synthetic */ Function1 access$getComputeContainingDeclaration$p(JvmBuiltInClassDescriptorFactory r10) {
        return r10.computeContainingDeclaration;
    }

    public static final /* synthetic */ FqName access$getKOTLIN_FQ_NAME$cp() {
        return KOTLIN_FQ_NAME;
    }

    public static final /* synthetic */ ModuleDescriptor access$getModuleDescriptor$p(JvmBuiltInClassDescriptorFactory r10) {
        return r10.moduleDescriptor;
    }

    private final ClassDescriptorImpl getCloneable() {
        return (ClassDescriptorImpl) StorageKt.getValue(this.cloneable$delegate, this, $$delegatedProperties[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public ClassDescriptor createClass(ClassId r10) {
        Intrinsics.checkNotNullParameter(r10, "classId");
        if (Intrinsics.areEqual(r10, CLONEABLE_CLASS_ID) == true) goto L7;
        return null;
    L7:
        return getCloneable();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public Collection<ClassDescriptor> getAllContributedClassesIfPossible(FqName r10) {
        Intrinsics.checkNotNullParameter(r10, "packageFqName");
        if (Intrinsics.areEqual(r10, KOTLIN_FQ_NAME) == false) goto L6;
        return SetsKt.setOf(getCloneable());
    L6:
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public boolean shouldCreateClass(FqName r10, Name r11) {
        Intrinsics.checkNotNullParameter(r10, "packageFqName");
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        if (Intrinsics.areEqual(r11, CLONEABLE_NAME) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r10, KOTLIN_FQ_NAME) == false) goto L7;
        return true;
    }
}
