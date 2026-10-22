package kotlin.reflect.jvm.internal.impl.builtins.functions;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class BuiltInFictitiousFunctionClassFactory implements ClassDescriptorFactory {
    private final ModuleDescriptor module;
    private final StorageManager storageManager;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public ClassDescriptor createClass(ClassId r7) {
        Intrinsics.checkNotNullParameter(r7, "classId");
        if (r7.isLocal() == false) goto L5;
    L31:
        return null;
    L5:
        if (r7.isNestedClass() == true) goto L31;
        String r0 = r7.getRelativeClassName().asString();
        if (StringsKt.contains$default(r0, "Function", false, 2, null) == true) goto L10;
        return null;
    L10:
        FqName r8 = r7.getPackageFqName();
        FunctionTypeKindExtractor.KindWithArity r1 = FunctionTypeKindExtractor.Companion.getDefault().getFunctionalClassKindWithArity(r8, r0);
        if (r1 != null) goto L13;
        return null;
    L13:
        FunctionTypeKind r2 = r1.component1();
        int r3 = r1.component2();
        List<PackageFragmentDescriptor> r9 = this.module.getPackage(r8).getFragments();
        ArrayList r4 = new ArrayList();
        Iterator<T> r10 = r9.iterator();
    L15:
        if (r10.hasNext() == false) goto L19;
        Object r5 = r10.next();
        if ((r5 instanceof BuiltInsPackageFragment) == false) goto L15;
        r4.add(r5);
        goto L15
    L19:
        ArrayList r11 = new ArrayList();
        Iterator r6 = r4.iterator();
    L21:
        if (r6.hasNext() == false) goto L25;
        Object r12 = r6.next();
        if ((r12 instanceof FunctionInterfacePackageFragment) == false) goto L21;
        r11.add(r12);
        goto L21
    L25:
        BuiltInsPackageFragment r13 = (FunctionInterfacePackageFragment) CollectionsKt.firstOrNull(r11);
        if (r13 != null) goto L30;
        r13 = (BuiltInsPackageFragment) CollectionsKt.first(r4);
    L30:
        return new FunctionClassDescriptor(this.storageManager, r13, r2, r3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public Collection<ClassDescriptor> getAllContributedClassesIfPossible(FqName r2) {
        Intrinsics.checkNotNullParameter(r2, "packageFqName");
        return SetsKt.emptySet();
    }

    public BuiltInFictitiousFunctionClassFactory(StorageManager r2, ModuleDescriptor r3) {
        Intrinsics.checkNotNullParameter(r2, "storageManager");
        Intrinsics.checkNotNullParameter(r3, "module");
        this.storageManager = r2;
        this.module = r3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public boolean shouldCreateClass(FqName r5, Name r6) {
        Intrinsics.checkNotNullParameter(r5, "packageFqName");
        Intrinsics.checkNotNullParameter(r6, DBDefinition.NAME);
        String r7 = r6.asString();
        if (StringsKt.startsWith$default(r7, "Function", false, 2, null) == true) goto L11;
        if (StringsKt.startsWith$default(r7, "KFunction", false, 2, null) == true) goto L11;
        if (StringsKt.startsWith$default(r7, "SuspendFunction", false, 2, null) == true) goto L11;
        if (StringsKt.startsWith$default(r7, "KSuspendFunction", false, 2, null) == true) goto L11;
        return false;
    L11:
        if (FunctionTypeKindExtractor.Companion.getDefault().getFunctionalClassKindWithArity(r5, r7) == null) goto L15;
        return true;
    L15:
        return false;
    }
}
