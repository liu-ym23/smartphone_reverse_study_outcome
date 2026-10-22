package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
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

/* JADX INFO: loaded from: classes3.dex */
public final class PackagePartScopeCache {
    private final ConcurrentHashMap<ClassId, MemberScope> cache;
    private final ReflectKotlinClassFinder kotlinClassFinder;
    private final DeserializedDescriptorResolver resolver;

    public PackagePartScopeCache(DeserializedDescriptorResolver r10, ReflectKotlinClassFinder r11) {
        Intrinsics.checkNotNullParameter(r10, "resolver");
        Intrinsics.checkNotNullParameter(r11, "kotlinClassFinder");
        this.resolver = r10;
        this.kotlinClassFinder = r11;
        this.cache = new ConcurrentHashMap();
    }

    public final MemberScope getPackagePartScope(ReflectKotlinClass r10) {
        Intrinsics.checkNotNullParameter(r10, "fileClass");
        ConcurrentHashMap<ClassId, MemberScope> r11 = this.cache;
        ClassId r12 = r10.getClassId();
        MemberScope r13 = r11.get(r12);
        if (r13 != null) goto L23;
        FqName r14 = r10.getClassId().getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(r14, "fileClass.classId.packageFqName");
        if (r10.getClassHeader().getKind() != KotlinClassHeader.Kind.MULTIFILE_CLASS) goto L12;
        List<String> r15 = r10.getClassHeader().getMultifilePartNames();
        Collection r16 = new ArrayList();
        Iterator<T> r17 = r15.iterator();
    L8:
        if (r17.hasNext() == false) goto L13;
        ClassId r18 = ClassId.topLevel(JvmClassName.byInternalName((String) r17.next()).getFqNameForTopLevelClassMaybeWithDollars());
        Intrinsics.checkNotNullExpressionValue(r18, "topLevel(JvmClassName.by…velClassMaybeWithDollars)");
        KotlinJvmBinaryClass r19 = KotlinClassFinderKt.findKotlinClass(this.kotlinClassFinder, r18);
        if (r19 == null) goto L8;
        r16.add(r19);
    L13:
        EmptyPackageFragmentDescriptor r20 = new EmptyPackageFragmentDescriptor(this.resolver.getComponents().getModuleDescriptor(), r14);
        ArrayList r21 = new ArrayList();
        Iterator r22 = r16.iterator();
    L15:
        if (r22.hasNext() == false) goto L19;
        MemberScope r23 = this.resolver.createKotlinPackagePartScope(r20, (KotlinJvmBinaryClass) r22.next());
        if (r23 == null) goto L15;
        r21.add(r23);
        goto L15
    L19:
        List r24 = CollectionsKt.toList(r21);
        MemberScope r25 = ChainedMemberScope.Companion.create("package " + r14 + " (" + r10 + ')', r24);
        MemberScope r26 = r11.putIfAbsent(r12, r25);
        if (r26 != null) goto L22;
        r13 = r25;
        goto L23
    L22:
        r13 = r26;
        goto L23
    L12:
        r16 = CollectionsKt.listOf(r10);
    L23:
        Intrinsics.checkNotNullExpressionValue(r13, "cache.getOrPut(fileClass…ileClass)\", scopes)\n    }");
        return r13;
    }
}
