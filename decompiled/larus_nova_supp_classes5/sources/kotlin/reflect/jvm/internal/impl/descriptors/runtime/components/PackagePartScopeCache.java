package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ChainedMemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.utils.DeserializationHelpersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class PackagePartScopeCache {
    private final ConcurrentHashMap<ClassId, MemberScope> cache;
    private final ReflectKotlinClassFinder kotlinClassFinder;
    private final DeserializedDescriptorResolver resolver;

    public final MemberScope getPackagePartScope(ReflectKotlinClass r9) {
        Intrinsics.checkNotNullParameter(r9, "fileClass");
        ConcurrentHashMap<ClassId, MemberScope> r0 = this.cache;
        ClassId r1 = r9.getClassId();
        MemberScope r2 = r0.get(r1);
        if (r2 != null) goto L24;
        FqName r3 = r9.getClassId().getPackageFqName();
        if (r9.getClassHeader().getKind() != KotlinClassHeader.Kind.MULTIFILE_CLASS) goto L12;
        List<String> r4 = r9.getClassHeader().getMultifilePartNames();
        Collection r5 = new ArrayList();
        Iterator<T> r6 = r4.iterator();
    L8:
        if (r6.hasNext() == false) goto L13;
        KotlinJvmBinaryClass r7 = KotlinClassFinderKt.findKotlinClass(this.kotlinClassFinder, ClassId.Companion.topLevel(JvmClassName.byInternalName((String) r6.next()).getFqNameForTopLevelClassMaybeWithDollars()), DeserializationHelpersKt.jvmMetadataVersionOrDefault(this.resolver.getComponents().getConfiguration()));
        if (r7 == null) goto L8;
        r5.add(r7);
    L13:
        PackageFragmentDescriptor r8 = new EmptyPackageFragmentDescriptor(this.resolver.getComponents().getModuleDescriptor(), r3);
        ArrayList r10 = new ArrayList();
        Iterator r11 = r5.iterator();
    L15:
        if (r11.hasNext() == false) goto L19;
        MemberScope r12 = this.resolver.createKotlinPackagePartScope(r8, (KotlinJvmBinaryClass) r11.next());
        if (r12 == null) goto L15;
        r10.add(r12);
        goto L15
    L19:
        List r13 = CollectionsKt.toList(r10);
        MemberScope r14 = ChainedMemberScope.Companion.create("package " + r3 + " (" + r9 + ')', r13);
        MemberScope r15 = r0.putIfAbsent(r1, r14);
        if (r15 != null) goto L22;
        r2 = r14;
        goto L24
    L22:
        r2 = r15;
        goto L24
    L12:
        r5 = CollectionsKt.listOf(r9);
    L24:
        return r2;
    }

    public PackagePartScopeCache(DeserializedDescriptorResolver r2, ReflectKotlinClassFinder r3) {
        Intrinsics.checkNotNullParameter(r2, "resolver");
        Intrinsics.checkNotNullParameter(r3, "kotlinClassFinder");
        this.resolver = r2;
        this.kotlinClassFinder = r3;
        this.cache = new ConcurrentHashMap();
    }
}
