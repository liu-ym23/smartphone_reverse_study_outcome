package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
@SourceDebugExtension({"SMAP\nBuiltInFictitiousFunctionClassFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BuiltInFictitiousFunctionClassFactory.kt\norg/jetbrains/kotlin/builtins/functions/BuiltInFictitiousFunctionClassFactory\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,68:1\n800#2,11:69\n800#2,11:80\n*S KotlinDebug\n*F\n+ 1 BuiltInFictitiousFunctionClassFactory.kt\norg/jetbrains/kotlin/builtins/functions/BuiltInFictitiousFunctionClassFactory\n*L\n53#1:69,11\n57#1:80,11\n*E\n"})
public final class BuiltInFictitiousFunctionClassFactory implements ClassDescriptorFactory {
    private final ModuleDescriptor module;
    private final StorageManager storageManager;

    public BuiltInFictitiousFunctionClassFactory(StorageManager r5, ModuleDescriptor r10) {
        Intrinsics.checkNotNullParameter(r5, "storageManager");
        Intrinsics.checkNotNullParameter(r10, "module");
        this.storageManager = r5;
        this.module = r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public ClassDescriptor createClass(ClassId r10) {
        Intrinsics.checkNotNullParameter(r10, "classId");
        if (r10.isLocal() == false) goto L5;
    L31:
        return null;
    L5:
        if (r10.isNestedClass() == true) goto L31;
        String r5 = r10.getRelativeClassName().asString();
        if (StringsKt.g(r5, "Function") == true) goto L10;
        return null;
    L10:
        FqName r11 = r10.getPackageFqName();
        FunctionClassKind.Companion.KindWithArity r12 = FunctionClassKind.Companion.parseClassName(r5, r11);
        if (r12 != null) goto L13;
        return null;
    L13:
        FunctionClassKind r13 = r12.component1();
        int r14 = r12.component2();
        List<PackageFragmentDescriptor> r15 = this.module.getPackage(r11).getFragments();
        ArrayList r16 = new ArrayList();
        Iterator<T> r17 = r15.iterator();
    L15:
        if (r17.hasNext() == false) goto L19;
        Object r18 = r17.next();
        if ((r18 instanceof BuiltInsPackageFragment) == false) goto L15;
        r16.add(r18);
        goto L15
    L19:
        ArrayList r19 = new ArrayList();
        Iterator r20 = r16.iterator();
    L21:
        if (r20.hasNext() == false) goto L25;
        Object r21 = r20.next();
        if ((r21 instanceof FunctionInterfacePackageFragment) == false) goto L21;
        r19.add(r21);
        goto L21
    L25:
        PackageFragmentDescriptor r22 = (FunctionInterfacePackageFragment) CollectionsKt.firstOrNull(r19);
        if (r22 != null) goto L30;
        r22 = (BuiltInsPackageFragment) CollectionsKt.first(r16);
    L30:
        return new FunctionClassDescriptor(this.storageManager, r22, r13, r14);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public Collection<ClassDescriptor> getAllContributedClassesIfPossible(FqName r5) {
        Intrinsics.checkNotNullParameter(r5, "packageFqName");
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public boolean shouldCreateClass(FqName r5, Name r10) {
        Intrinsics.checkNotNullParameter(r5, "packageFqName");
        Intrinsics.checkNotNullParameter(r10, "name");
        String r11 = r10.asString();
        if (StringsKt.P(r11, "Function") == true) goto L11;
        if (StringsKt.P(r11, "KFunction") == true) goto L11;
        if (StringsKt.P(r11, "SuspendFunction") == true) goto L11;
        if (StringsKt.P(r11, "KSuspendFunction") == true) goto L11;
    L13:
        return false;
    L11:
        if (FunctionClassKind.Companion.parseClassName(r11, r5) == null) goto L13;
        return true;
    }
}
