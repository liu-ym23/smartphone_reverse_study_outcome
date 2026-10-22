package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializationComponentsForJava;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;

/* JADX INFO: loaded from: classes3.dex */
public final class RuntimeModuleData {
    public static final Companion Companion = null;
    private final DeserializationComponents deserialization;
    private final PackagePartScopeCache packagePartScopeCache;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final RuntimeModuleData create(ClassLoader r10) {
            Intrinsics.checkNotNullParameter(r10, "classLoader");
            ReflectKotlinClassFinder r11 = new ReflectKotlinClassFinder(r10);
            DeserializationComponentsForJava.Companion r12 = DeserializationComponentsForJava.Companion;
            ClassLoader r13 = Unit.class.getClassLoader();
            Intrinsics.checkNotNullExpressionValue(r13, "Unit::class.java.classLoader");
            DeserializationComponentsForJava.Companion.ModuleData r14 = r12.createModuleData(r11, new ReflectKotlinClassFinder(r13), new ReflectJavaClassFinder(r10), "runtime module for " + r10, RuntimeErrorReporter.INSTANCE, RuntimeSourceElementFactory.INSTANCE);
            return new RuntimeModuleData(r14.getDeserializationComponentsForJava().getComponents(), new PackagePartScopeCache(r14.getDeserializedDescriptorResolver(), r11), null);
        }
    }

    static {
        Companion = new Companion(null);
    }

    private RuntimeModuleData(DeserializationComponents r10, PackagePartScopeCache r11) {
        this.deserialization = r10;
        this.packagePartScopeCache = r11;
    }

    public /* synthetic */ RuntimeModuleData(DeserializationComponents r10, PackagePartScopeCache r11, DefaultConstructorMarker r12) {
        this(r10, r11);
    }

    public final DeserializationComponents getDeserialization() {
        return this.deserialization;
    }

    public final ModuleDescriptor getModule() {
        return this.deserialization.getModuleDescriptor();
    }

    public final PackagePartScopeCache getPackagePartScopeCache() {
        return this.packagePartScopeCache;
    }
}
