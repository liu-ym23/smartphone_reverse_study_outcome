package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nPackagePartScopeCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PackagePartScopeCache.kt\norg/jetbrains/kotlin/descriptors/runtime/components/PackagePartScopeCache\n+ 2 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,42:1\n73#2,2:43\n1603#3,9:45\n1855#3:54\n1856#3:56\n1612#3:57\n1603#3,9:58\n1855#3:67\n1856#3:69\n1612#3:70\n1#4:55\n1#4:68\n1#4:71\n*S KotlinDebug\n*F\n+ 1 PackagePartScopeCache.kt\norg/jetbrains/kotlin/descriptors/runtime/components/PackagePartScopeCache\n*L\n22#1:43,2\n27#1:45,9\n27#1:54\n27#1:56\n27#1:57\n35#1:58,9\n35#1:67\n35#1:69\n35#1:70\n27#1:55\n35#1:68\n22#1:71\n*E\n"})
public final class PackagePartScopeCache {
    private final ConcurrentHashMap<ClassId, MemberScope> cache;
    private final ReflectKotlinClassFinder kotlinClassFinder;
    private final DeserializedDescriptorResolver resolver;

    public PackagePartScopeCache(DeserializedDescriptorResolver r5, ReflectKotlinClassFinder r10) {
        Intrinsics.checkNotNullParameter(r5, "resolver");
        Intrinsics.checkNotNullParameter(r10, "kotlinClassFinder");
        this.resolver = r5;
        this.kotlinClassFinder = r10;
        this.cache = new ConcurrentHashMap();
    }

    public final MemberScope getPackagePartScope(ReflectKotlinClass r10) {
        Intrinsics.checkNotNullParameter(r10, "fileClass");
        ConcurrentHashMap<ClassId, MemberScope> r5 = this.cache;
        ClassId r11 = r10.getClassId();
        MemberScope r12 = r5.get(r11);
        if (r12 != null) goto L24;
        FqName r13 = r10.getClassId().getPackageFqName();
        if (r10.getClassHeader().getKind() != KotlinClassHeader.Kind.MULTIFILE_CLASS) goto L12;
        List<String> r14 = r10.getClassHeader().getMultifilePartNames();
        Collection r15 = new ArrayList();
        Iterator<T> r16 = r14.iterator();
    L8:
        if (r16.hasNext() == false) goto L13;
        KotlinJvmBinaryClass r17 = KotlinClassFinderKt.findKotlinClass(this.kotlinClassFinder, ClassId.topLevel(JvmClassName.byInternalName((String) r16.next()).getFqNameForTopLevelClassMaybeWithDollars()), DeserializationHelpersKt.jvmMetadataVersionOrDefault(this.resolver.getComponents().getConfiguration()));
        if (r17 == null) goto L8;
        r15.add(r17);
    L13:
        EmptyPackageFragmentDescriptor r18 = new EmptyPackageFragmentDescriptor(this.resolver.getComponents().getModuleDescriptor(), r13);
        ArrayList r19 = new ArrayList();
        Iterator r20 = r15.iterator();
    L15:
        if (r20.hasNext() == false) goto L19;
        MemberScope r21 = this.resolver.createKotlinPackagePartScope(r18, (KotlinJvmBinaryClass) r20.next());
        if (r21 == null) goto L15;
        r19.add(r21);
        goto L15
    L19:
        List r22 = CollectionsKt.toList(r19);
        MemberScope r23 = ChainedMemberScope.Companion.create("package " + r13 + " (" + r10 + ')', r22);
        MemberScope r24 = r5.putIfAbsent(r11, r23);
        if (r24 != null) goto L22;
        r12 = r23;
        goto L24
    L22:
        r12 = r24;
        goto L24
    L12:
        r15 = CollectionsKt.listOf(r10);
    L24:
        return r12;
    }
}
