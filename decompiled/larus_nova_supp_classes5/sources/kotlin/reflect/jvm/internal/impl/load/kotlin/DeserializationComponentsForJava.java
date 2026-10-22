package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.CompositePackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.SingleModuleClassResolver;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JavaDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolverImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.JvmEnumEntriesDeserializationSupport;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.extensions.TypeAttributeTranslators;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class DeserializationComponentsForJava {
    public static final Companion Companion = null;
    private final DeserializationComponents components;

    public static final class Companion {

        public static final class ModuleData {
            private final DeserializationComponentsForJava deserializationComponentsForJava;
            private final DeserializedDescriptorResolver deserializedDescriptorResolver;

            public final DeserializationComponentsForJava getDeserializationComponentsForJava() {
                return this.deserializationComponentsForJava;
            }

            public final DeserializedDescriptorResolver getDeserializedDescriptorResolver() {
                return this.deserializedDescriptorResolver;
            }

            public ModuleData(DeserializationComponentsForJava r2, DeserializedDescriptorResolver r3) {
                Intrinsics.checkNotNullParameter(r2, "deserializationComponentsForJava");
                Intrinsics.checkNotNullParameter(r3, "deserializedDescriptorResolver");
                this.deserializationComponentsForJava = r2;
                this.deserializedDescriptorResolver = r3;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final ModuleData createModuleData(KotlinClassFinder r26, KotlinClassFinder r27, JavaClassFinder r28, String r29, ErrorReporter r30, JavaSourceElementFactory r31) {
            Intrinsics.checkNotNullParameter(r26, "kotlinClassFinder");
            Intrinsics.checkNotNullParameter(r27, "jvmBuiltInsKotlinClassFinder");
            Intrinsics.checkNotNullParameter(r28, "javaClassFinder");
            Intrinsics.checkNotNullParameter(r29, "moduleName");
            Intrinsics.checkNotNullParameter(r30, "errorReporter");
            Intrinsics.checkNotNullParameter(r31, "javaSourceElementFactory");
            LockBasedStorageManager r1 = new LockBasedStorageManager("DeserializationComponentsForJava.ModuleData");
            JvmBuiltIns r12 = new JvmBuiltIns(r1, JvmBuiltIns.Kind.FROM_DEPENDENCIES);
            ModuleDescriptorImpl r11 = new ModuleDescriptorImpl(Name.special("<" + r29 + '>'), r1, r12, null, null, null, 56, null);
            r12.setBuiltInsModule(r11);
            r12.initialize(r11, true);
            DeserializedDescriptorResolver r10 = new DeserializedDescriptorResolver();
            SingleModuleClassResolver r8 = new SingleModuleClassResolver();
            NotFoundClasses r7 = new NotFoundClasses(r1, r11);
            LazyJavaPackageFragmentProvider r13 = DeserializationComponentsForJavaKt.makeLazyJavaPackageFragmentProvider$default(r28, r11, r1, r7, r26, r10, r30, r31, r8, null, 512, null);
            DeserializationComponentsForJava r14 = DeserializationComponentsForJavaKt.makeDeserializationComponentsForJava(r11, r1, r7, r13, r26, r10, r30, JvmMetadataVersion.INSTANCE);
            r10.setComponents(r14);
            JavaDescriptorResolver r15 = new JavaDescriptorResolver(r13, JavaResolverCache.EMPTY);
            r8.setResolver(r15);
            JvmBuiltInsPackageFragmentProvider r17 = new JvmBuiltInsPackageFragmentProvider(r1, r27, r11, r7, r12.getCustomizer(), r12.getCustomizer(), DeserializationConfiguration.Default.INSTANCE, NewKotlinTypeChecker.Companion.getDefault(), new SamConversionResolverImpl(r1, CollectionsKt.emptyList()));
            r11.setDependencies(new ModuleDescriptorImpl[]{r11});
            r11.initialize(new CompositePackageFragmentProvider(CollectionsKt.listOf(new PackageFragmentProviderOptimized[]{r15.getPackageFragmentProvider(), r17}), "CompositeProvider@RuntimeModuleData for " + r11));
            return new ModuleData(r14, r10);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final DeserializationComponents getComponents() {
        return this.components;
    }

    public DeserializationComponentsForJava(StorageManager r25, ModuleDescriptor r26, DeserializationConfiguration r27, JavaClassDataFinder r28, BinaryClassAnnotationAndConstantLoaderImpl r29, LazyJavaPackageFragmentProvider r30, NotFoundClasses r31, ErrorReporter r32, LookupTracker r33, ContractDeserializer r34, NewKotlinTypeChecker r35, TypeAttributeTranslators r36) {
        Intrinsics.checkNotNullParameter(r25, "storageManager");
        Intrinsics.checkNotNullParameter(r26, "moduleDescriptor");
        Intrinsics.checkNotNullParameter(r27, "configuration");
        Intrinsics.checkNotNullParameter(r28, "classDataFinder");
        Intrinsics.checkNotNullParameter(r29, "annotationAndConstantLoader");
        Intrinsics.checkNotNullParameter(r30, "packageFragmentProvider");
        Intrinsics.checkNotNullParameter(r31, "notFoundClasses");
        Intrinsics.checkNotNullParameter(r32, "errorReporter");
        Intrinsics.checkNotNullParameter(r33, "lookupTracker");
        Intrinsics.checkNotNullParameter(r34, "contractDeserializer");
        Intrinsics.checkNotNullParameter(r35, "kotlinTypeChecker");
        Intrinsics.checkNotNullParameter(r36, "typeAttributeTranslators");
        KotlinBuiltIns r0 = r26.getBuiltIns();
        if ((r0 instanceof JvmBuiltIns) == false) goto L5;
        JvmBuiltIns r1 = (JvmBuiltIns) r0;
    L6:
        LocalClassifierTypeSettings.Default r10 = LocalClassifierTypeSettings.Default.INSTANCE;
        JavaFlexibleTypeDeserializer r11 = JavaFlexibleTypeDeserializer.INSTANCE;
        List r17 = CollectionsKt.emptyList();
        if (r1 == null) goto L11;
        JvmBuiltInsCustomizer r16 = r1.getCustomizer();
        if (r16 == null) goto L11;
    L12:
        JvmBuiltInsCustomizer r21 = r16;
        if (r1 == null) goto L17;
        JvmBuiltInsCustomizer r2 = r1.getCustomizer();
        if (r2 == null) goto L17;
    L18:
        this.components = new DeserializationComponents(r25, r26, r27, r28, r29, r30, r10, r32, r33, r11, r17, r31, r34, r21, r2, JvmProtoBufUtil.INSTANCE.getEXTENSION_REGISTRY(), r35, new SamConversionResolverImpl(r25, CollectionsKt.emptyList()), r36.getTranslators(), JvmEnumEntriesDeserializationSupport.INSTANCE);
        return;
    L17:
        r2 = PlatformDependentDeclarationFilter.NoPlatformDependent.INSTANCE;
    L11:
        r16 = AdditionalClassPartsProvider.None.INSTANCE;
        goto L12
    L5:
        r1 = null;
        goto L6
    }
}
