package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaPackage;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ReflectJavaClassFinder implements JavaClassFinder {
    private final ClassLoader classLoader;

    @Override // kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder
    public Set<String> knownClassNamesInPackage(FqName r2) {
        Intrinsics.checkNotNullParameter(r2, "packageFqName");
        return null;
    }

    public ReflectJavaClassFinder(ClassLoader r2) {
        Intrinsics.checkNotNullParameter(r2, "classLoader");
        this.classLoader = r2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder
    public JavaClass findClass(JavaClassFinder.Request r8) {
        Intrinsics.checkNotNullParameter(r8, "request");
        ClassId r9 = r8.getClassId();
        FqName r0 = r9.getPackageFqName();
        String r10 = StringsKt.replace$default(r9.getRelativeClassName().asString(), '.', '$', false, 4, null);
        if (r0.isRoot() == true) goto L6;
        r10 = r0.asString() + '.' + r10;
    L6:
        Class<?> r11 = ReflectJavaClassFinderKt.tryLoadClass(this.classLoader, r10);
        if (r11 != null) goto L11;
        return null;
    L11:
        return new ReflectJavaClass(r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder
    public JavaPackage findPackage(FqName r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "fqName");
        return new ReflectJavaPackage(r1);
    }
}
