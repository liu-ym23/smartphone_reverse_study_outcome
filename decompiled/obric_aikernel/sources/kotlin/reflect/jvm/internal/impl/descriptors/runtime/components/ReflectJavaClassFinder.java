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

    public ReflectJavaClassFinder(ClassLoader r10) {
        Intrinsics.checkNotNullParameter(r10, "classLoader");
        this.classLoader = r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder
    public JavaClass findClass(JavaClassFinder.Request r10) {
        Intrinsics.checkNotNullParameter(r10, "request");
        ClassId r11 = r10.getClassId();
        FqName r12 = r11.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(r12, "classId.packageFqName");
        String r13 = r11.getRelativeClassName().asString();
        Intrinsics.checkNotNullExpressionValue(r13, "classId.relativeClassName.asString()");
        String r14 = StringsKt.replace$default(r13, '.', Typography.dollar, false, 4, null);
        if (r12.isRoot() == true) goto L6;
        r14 = r12.asString() + '.' + r14;
    L6:
        Class<?> r15 = ReflectJavaClassFinderKt.tryLoadClass(this.classLoader, r14);
        if (r15 != null) goto L11;
        return null;
    L11:
        return new ReflectJavaClass(r15);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder
    public JavaPackage findPackage(FqName r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "fqName");
        return new ReflectJavaPackage(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder
    public Set<String> knownClassNamesInPackage(FqName r10) {
        Intrinsics.checkNotNullParameter(r10, "packageFqName");
        return null;
    }
}
