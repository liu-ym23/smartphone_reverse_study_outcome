package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInSerializerProtocol;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsResourceLoader;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ReflectKotlinClassFinder implements KotlinClassFinder {
    private final BuiltInsResourceLoader builtInsResourceLoader;
    private final ClassLoader classLoader;

    public ReflectKotlinClassFinder(ClassLoader r2) {
        Intrinsics.checkNotNullParameter(r2, "classLoader");
        this.classLoader = r2;
        this.builtInsResourceLoader = new BuiltInsResourceLoader();
    }

    private final KotlinClassFinder.Result findKotlinClass(String r4) {
        Class<?> r5 = ReflectJavaClassFinderKt.tryLoadClass(this.classLoader, r4);
        if (r5 == null) goto L8;
        ReflectKotlinClass r6 = ReflectKotlinClass.Factory.create(r5);
        if (r6 != null) goto L7;
        return null;
    L7:
        return new KotlinClassFinder.Result.KotlinClass(r6, null, 2, null);
    L8:
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.KotlinMetadataFinder
    public InputStream findBuiltInsData(FqName r3) {
        Intrinsics.checkNotNullParameter(r3, "packageFqName");
        if (r3.startsWith(StandardNames.BUILT_INS_PACKAGE_NAME) == true) goto L7;
        return null;
    L7:
        return this.builtInsResourceLoader.loadResource(BuiltInSerializerProtocol.INSTANCE.getBuiltInsFilePath(r3));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder
    public KotlinClassFinder.Result findKotlinClassOrContent(JavaClass r2, JvmMetadataVersion r3) {
        Intrinsics.checkNotNullParameter(r2, "javaClass");
        Intrinsics.checkNotNullParameter(r3, "jvmMetadataVersion");
        FqName r4 = r2.getFqName();
        if (r4 == null) goto L9;
        String r5 = r4.asString();
        if (r5 != null) goto L8;
        return null;
    L8:
        return findKotlinClass(r5);
    L9:
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder
    public KotlinClassFinder.Result findKotlinClassOrContent(ClassId r2, JvmMetadataVersion r3) {
        Intrinsics.checkNotNullParameter(r2, "classId");
        Intrinsics.checkNotNullParameter(r3, "jvmMetadataVersion");
        return findKotlinClass(ReflectKotlinClassFinderKt.access$toRuntimeFqName(r2));
    }
}
