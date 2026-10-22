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
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final RuntimeModuleData create(ClassLoader r10) {
            Intrinsics.checkNotNullParameter(r10, "classLoader");
            ReflectKotlinClassFinder r11 = new ReflectKotlinClassFinder(r10);
            DeserializationComponentsForJava.Companion.ModuleData r12 = DeserializationComponentsForJava.Companion.createModuleData(r11, new ReflectKotlinClassFinder(Unit.class.getClassLoader()), new ReflectJavaClassFinder(r10), "runtime module for " + r10, RuntimeErrorReporter.INSTANCE, RuntimeSourceElementFactory.INSTANCE);
            return new RuntimeModuleData(r12.getDeserializationComponentsForJava().getComponents(), new PackagePartScopeCache(r12.getDeserializedDescriptorResolver(), r11), null);
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ RuntimeModuleData(DeserializationComponents r5, PackagePartScopeCache r10, DefaultConstructorMarker r11) {
        this(r5, r10);
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

    private RuntimeModuleData(DeserializationComponents r5, PackagePartScopeCache r10) {
        this.deserialization = r5;
        this.packagePartScopeCache = r10;
    }
}
