package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInSerializerProtocol;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsResourceLoader;

/* JADX INFO: loaded from: classes3.dex */
public final class ReflectKotlinClassFinder implements KotlinClassFinder {
    private final BuiltInsResourceLoader builtInsResourceLoader;
    private final ClassLoader classLoader;

    public ReflectKotlinClassFinder(ClassLoader r10) {
        Intrinsics.checkNotNullParameter(r10, "classLoader");
        this.classLoader = r10;
        this.builtInsResourceLoader = new BuiltInsResourceLoader();
    }

    private final KotlinClassFinder.Result findKotlinClass(String r10) {
        Class<?> r11 = ReflectJavaClassFinderKt.tryLoadClass(this.classLoader, r10);
        if (r11 == null) goto L8;
        ReflectKotlinClass r12 = ReflectKotlinClass.Factory.create(r11);
        if (r12 != null) goto L7;
        return null;
    L7:
        return new KotlinClassFinder.Result.KotlinClass(r12, null, 2, null);
    L8:
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.KotlinMetadataFinder
    public InputStream findBuiltInsData(FqName r10) {
        Intrinsics.checkNotNullParameter(r10, "packageFqName");
        if (r10.startsWith(StandardNames.BUILT_INS_PACKAGE_NAME) == true) goto L7;
        return null;
    L7:
        return this.builtInsResourceLoader.loadResource(BuiltInSerializerProtocol.INSTANCE.getBuiltInsFilePath(r10));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder
    public KotlinClassFinder.Result findKotlinClassOrContent(JavaClass r10) {
        Intrinsics.checkNotNullParameter(r10, "javaClass");
        FqName r11 = r10.getFqName();
        if (r11 == null) goto L9;
        String r12 = r11.asString();
        if (r12 != null) goto L8;
        return null;
    L8:
        return findKotlinClass(r12);
    L9:
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder
    public KotlinClassFinder.Result findKotlinClassOrContent(ClassId r10) {
        Intrinsics.checkNotNullParameter(r10, "classId");
        return findKotlinClass(ReflectKotlinClassFinderKt.access$toRuntimeFqName(r10));
    }
}
