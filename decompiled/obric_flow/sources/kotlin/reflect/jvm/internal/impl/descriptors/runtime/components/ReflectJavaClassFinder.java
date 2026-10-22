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
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaClassFinder implements JavaClassFinder {
    private final ClassLoader classLoader;

    public ReflectJavaClassFinder(ClassLoader r5) {
        Intrinsics.checkNotNullParameter(r5, "classLoader");
        this.classLoader = r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder
    public JavaClass findClass(JavaClassFinder.Request r5) {
        Intrinsics.checkNotNullParameter(r5, "request");
        ClassId r10 = r5.getClassId();
        FqName r11 = r10.getPackageFqName();
        String r12 = StringsKt.E(r10.getRelativeClassName().asString(), '.', Typography.dollar);
        if (r11.isRoot() == true) goto L6;
        r12 = r11.asString() + '.' + r12;
    L6:
        Class<?> r13 = ReflectJavaClassFinderKt.tryLoadClass(this.classLoader, r12);
        if (r13 != null) goto L11;
        return null;
    L11:
        return new ReflectJavaClass(r13);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder
    public JavaPackage findPackage(FqName r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "fqName");
        return new ReflectJavaPackage(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder
    public Set<String> knownClassNamesInPackage(FqName r5) {
        Intrinsics.checkNotNullParameter(r5, "packageFqName");
        return null;
    }
}
