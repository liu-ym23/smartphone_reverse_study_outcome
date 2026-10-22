package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInSerializerProtocol;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsResourceLoader;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nReflectKotlinClassFinder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReflectKotlinClassFinder.kt\norg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClassFinder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,62:1\n1#2:63\n*E\n"})
public final class ReflectKotlinClassFinder implements KotlinClassFinder {
    private final BuiltInsResourceLoader builtInsResourceLoader;
    private final ClassLoader classLoader;

    public ReflectKotlinClassFinder(ClassLoader r5) {
        Intrinsics.checkNotNullParameter(r5, "classLoader");
        this.classLoader = r5;
        this.builtInsResourceLoader = new BuiltInsResourceLoader();
    }

    private final KotlinClassFinder.Result findKotlinClass(String r5) {
        Class<?> r10 = ReflectJavaClassFinderKt.tryLoadClass(this.classLoader, r5);
        if (r10 == null) goto L8;
        ReflectKotlinClass r11 = ReflectKotlinClass.Factory.create(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return new KotlinClassFinder.Result.KotlinClass(r11, null, 2, null);
    L8:
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.KotlinMetadataFinder
    public InputStream findBuiltInsData(FqName r5) {
        Intrinsics.checkNotNullParameter(r5, "packageFqName");
        if (r5.startsWith(StandardNames.BUILT_INS_PACKAGE_NAME) == true) goto L7;
        return null;
    L7:
        return this.builtInsResourceLoader.loadResource(BuiltInSerializerProtocol.INSTANCE.getBuiltInsFilePath(r5));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder
    public KotlinClassFinder.Result findKotlinClassOrContent(ClassId r5, JvmMetadataVersion r10) {
        Intrinsics.checkNotNullParameter(r5, "classId");
        Intrinsics.checkNotNullParameter(r10, "jvmMetadataVersion");
        return findKotlinClass(ReflectKotlinClassFinderKt.access$toRuntimeFqName(r5));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder
    public KotlinClassFinder.Result findKotlinClassOrContent(JavaClass r5, JvmMetadataVersion r10) {
        Intrinsics.checkNotNullParameter(r5, "javaClass");
        Intrinsics.checkNotNullParameter(r10, "jvmMetadataVersion");
        FqName r11 = r5.getFqName();
        if (r11 == null) goto L9;
        String r12 = r11.asString();
        if (r12 != null) goto L8;
        return null;
    L8:
        return findKotlinClass(r12);
    L9:
        return null;
    }
}
