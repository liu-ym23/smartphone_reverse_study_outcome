package kotlin.reflect.jvm.internal.impl.builtins.functions;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionInterfacePackageFragment;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class BuiltInFictitiousFunctionClassFactory implements ClassDescriptorFactory {
    private final ModuleDescriptor module;
    private final StorageManager storageManager;

    public BuiltInFictitiousFunctionClassFactory(StorageManager r10, ModuleDescriptor r11) {
        Intrinsics.checkNotNullParameter(r10, "storageManager");
        Intrinsics.checkNotNullParameter(r11, "module");
        this.storageManager = r10;
        this.module = r11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public ClassDescriptor createClass(ClassId r10) {
        Intrinsics.checkNotNullParameter(r10, "classId");
        if (r10.isLocal() == false) goto L5;
    L31:
        return null;
    L5:
        if (r10.isNestedClass() == true) goto L31;
        String r11 = r10.getRelativeClassName().asString();
        Intrinsics.checkNotNullExpressionValue(r11, "classId.relativeClassName.asString()");
        if (StringsKt.contains$default(r11, "Function", false, 2, null) == true) goto L10;
        return null;
    L10:
        FqName r12 = r10.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(r12, "classId.packageFqName");
        FunctionClassKind.Companion.KindWithArity r13 = FunctionClassKind.Companion.parseClassName(r11, r12);
        if (r13 != null) goto L13;
        return null;
    L13:
        FunctionClassKind r14 = r13.component1();
        int r15 = r13.component2();
        List<PackageFragmentDescriptor> r16 = this.module.getPackage(r12).getFragments();
        ArrayList r17 = new ArrayList();
        Iterator<T> r18 = r16.iterator();
    L15:
        if (r18.hasNext() == false) goto L19;
        Object r19 = r18.next();
        if ((r19 instanceof BuiltInsPackageFragment) == false) goto L15;
        r17.add(r19);
        goto L15
    L19:
        ArrayList r20 = new ArrayList();
        Iterator r21 = r17.iterator();
    L21:
        if (r21.hasNext() == false) goto L25;
        Object r22 = r21.next();
        if ((r22 instanceof FunctionInterfacePackageFragment) == false) goto L21;
        r20.add(r22);
        goto L21
    L25:
        PackageFragmentDescriptor r23 = (FunctionInterfacePackageFragment) CollectionsKt.firstOrNull(r20);
        if (r23 != null) goto L30;
        r23 = (BuiltInsPackageFragment) CollectionsKt.first(r17);
    L30:
        return new FunctionClassDescriptor(this.storageManager, r23, r14, r15);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public Collection<ClassDescriptor> getAllContributedClassesIfPossible(FqName r10) {
        Intrinsics.checkNotNullParameter(r10, "packageFqName");
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public boolean shouldCreateClass(FqName r10, Name r11) {
        Intrinsics.checkNotNullParameter(r10, "packageFqName");
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        String r12 = r11.asString();
        Intrinsics.checkNotNullExpressionValue(r12, "name.asString()");
        if (StringsKt.startsWith$default(r12, "Function", false, 2, null) == true) goto L11;
        if (StringsKt.startsWith$default(r12, "KFunction", false, 2, null) == true) goto L11;
        if (StringsKt.startsWith$default(r12, "SuspendFunction", false, 2, null) == true) goto L11;
        if (StringsKt.startsWith$default(r12, "KSuspendFunction", false, 2, null) == true) goto L11;
        return false;
    L11:
        if (FunctionClassKind.Companion.parseClassName(r12, r10) == null) goto L15;
        return true;
    L15:
        return false;
    }
}
