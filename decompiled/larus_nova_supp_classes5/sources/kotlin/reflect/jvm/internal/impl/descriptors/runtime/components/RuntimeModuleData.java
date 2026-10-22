package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializationComponentsForJava;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class RuntimeModuleData {
    public static final Companion Companion = null;
    private final DeserializationComponents deserialization;
    private final PackagePartScopeCache packagePartScopeCache;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final RuntimeModuleData create(ClassLoader r9) {
            Intrinsics.checkNotNullParameter(r9, "classLoader");
            ReflectKotlinClassFinder r0 = new ReflectKotlinClassFinder(r9);
            DeserializationComponentsForJava.Companion.ModuleData r10 = DeserializationComponentsForJava.Companion.createModuleData(r0, new ReflectKotlinClassFinder(Unit.class.getClassLoader()), new ReflectJavaClassFinder(r9), "runtime module for " + r9, RuntimeErrorReporter.INSTANCE, RuntimeSourceElementFactory.INSTANCE);
            return new RuntimeModuleData(r10.getDeserializationComponentsForJava().getComponents(), new PackagePartScopeCache(r10.getDeserializedDescriptorResolver(), r0), null);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ RuntimeModuleData(DeserializationComponents r1, PackagePartScopeCache r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    public final ModuleDescriptor getModule() {
        return this.deserialization.getModuleDescriptor();
    }

    public final DeserializationComponents getDeserialization() {
        return this.deserialization;
    }

    public final PackagePartScopeCache getPackagePartScopeCache() {
        return this.packagePartScopeCache;
    }

    private RuntimeModuleData(DeserializationComponents r1, PackagePartScopeCache r2) {
        this.deserialization = r1;
        this.packagePartScopeCache = r2;
    }
}
