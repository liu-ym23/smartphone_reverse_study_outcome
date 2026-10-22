package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentTypeTransformer;
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
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.extensions.TypeAttributeTranslators;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public final class DeserializationComponentsForJava {
    public static final Companion Companion = null;
    private final DeserializationComponents components;

    public static final class Companion {

        public static final class ModuleData {
            private final DeserializationComponentsForJava deserializationComponentsForJava;
            private final DeserializedDescriptorResolver deserializedDescriptorResolver;

            public ModuleData(DeserializationComponentsForJava r5, DeserializedDescriptorResolver r10) {
                Intrinsics.checkNotNullParameter(r5, "deserializationComponentsForJava");
                Intrinsics.checkNotNullParameter(r10, "deserializedDescriptorResolver");
                this.deserializationComponentsForJava = r5;
                this.deserializedDescriptorResolver = r10;
            }

            public final DeserializationComponentsForJava getDeserializationComponentsForJava() {
                return this.deserializationComponentsForJava;
            }

            public final DeserializedDescriptorResolver getDeserializedDescriptorResolver() {
                return this.deserializedDescriptorResolver;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final ModuleData createModuleData(KotlinClassFinder r26, KotlinClassFinder r27, JavaClassFinder r28, String r29, ErrorReporter r30, JavaSourceElementFactory r31) {
            Intrinsics.checkNotNullParameter(r26, "kotlinClassFinder");
            Intrinsics.checkNotNullParameter(r27, "jvmBuiltInsKotlinClassFinder");
            Intrinsics.checkNotNullParameter(r28, "javaClassFinder");
            Intrinsics.checkNotNullParameter(r29, "moduleName");
            Intrinsics.checkNotNullParameter(r30, "errorReporter");
            Intrinsics.checkNotNullParameter(r31, "javaSourceElementFactory");
            LockBasedStorageManager r5 = new LockBasedStorageManager("DeserializationComponentsForJava.ModuleData");
            JvmBuiltIns r12 = new JvmBuiltIns(r5, JvmBuiltIns.Kind.FROM_DEPENDENCIES);
            ModuleDescriptorImpl r11 = new ModuleDescriptorImpl(Name.special("<" + r29 + Typography.greater), r5, r12, null, null, null, 56, null);
            r12.setBuiltInsModule(r11);
            r12.initialize(r11, true);
            DeserializedDescriptorResolver r10 = new DeserializedDescriptorResolver();
            SingleModuleClassResolver r13 = new SingleModuleClassResolver();
            NotFoundClasses r14 = new NotFoundClasses(r5, r11);
            LazyJavaPackageFragmentProvider r15 = DeserializationComponentsForJavaKt.makeLazyJavaPackageFragmentProvider$default(r28, r11, r5, r14, r26, r10, r30, r31, r13, null, 512, null);
            DeserializationComponentsForJava r16 = DeserializationComponentsForJavaKt.makeDeserializationComponentsForJava(r11, r5, r14, r15, r26, r10, r30, JvmMetadataVersion.INSTANCE);
            r10.setComponents(r16);
            JavaDescriptorResolver r17 = new JavaDescriptorResolver(r15, JavaResolverCache.EMPTY);
            r13.setResolver(r17);
            JvmBuiltInsPackageFragmentProvider r18 = new JvmBuiltInsPackageFragmentProvider(r5, r27, r11, r14, r12.getCustomizer(), r12.getCustomizer(), DeserializationConfiguration.Default.INSTANCE, NewKotlinTypeChecker.Companion.getDefault(), new SamConversionResolverImpl(r5, CollectionsKt.emptyList()));
            r11.setDependencies(new ModuleDescriptorImpl[]{r11});
            r11.initialize(new CompositePackageFragmentProvider(CollectionsKt.listOf(new PackageFragmentProviderOptimized[]{r17.getPackageFragmentProvider(), r18}), "CompositeProvider@RuntimeModuleData for " + r11));
            return new ModuleData(r16, r10);
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public DeserializationComponentsForJava(StorageManager r27, ModuleDescriptor r28, DeserializationConfiguration r29, JavaClassDataFinder r30, BinaryClassAnnotationAndConstantLoaderImpl r31, LazyJavaPackageFragmentProvider r32, NotFoundClasses r33, ErrorReporter r34, LookupTracker r35, ContractDeserializer r36, NewKotlinTypeChecker r37, TypeAttributeTranslators r38) {
        Intrinsics.checkNotNullParameter(r27, "storageManager");
        Intrinsics.checkNotNullParameter(r28, "moduleDescriptor");
        Intrinsics.checkNotNullParameter(r29, "configuration");
        Intrinsics.checkNotNullParameter(r30, "classDataFinder");
        Intrinsics.checkNotNullParameter(r31, "annotationAndConstantLoader");
        Intrinsics.checkNotNullParameter(r32, "packageFragmentProvider");
        Intrinsics.checkNotNullParameter(r33, "notFoundClasses");
        Intrinsics.checkNotNullParameter(r34, "errorReporter");
        Intrinsics.checkNotNullParameter(r35, "lookupTracker");
        Intrinsics.checkNotNullParameter(r36, "contractDeserializer");
        Intrinsics.checkNotNullParameter(r37, "kotlinTypeChecker");
        Intrinsics.checkNotNullParameter(r38, "typeAttributeTranslators");
        KotlinBuiltIns r5 = r28.getBuiltIns();
        if ((r5 instanceof JvmBuiltIns) == false) goto L5;
        JvmBuiltIns r10 = (JvmBuiltIns) r5;
    L6:
        LocalClassifierTypeSettings.Default r11 = LocalClassifierTypeSettings.Default.INSTANCE;
        JavaFlexibleTypeDeserializer r12 = JavaFlexibleTypeDeserializer.INSTANCE;
        List r17 = CollectionsKt.emptyList();
        if (r10 == null) goto L11;
        AdditionalClassPartsProvider r16 = r10.getCustomizer();
        if (r16 == null) goto L11;
    L10:
        AdditionalClassPartsProvider r23 = r16;
        if (r10 == null) goto L16;
        PlatformDependentDeclarationFilter r13 = r10.getCustomizer();
        if (r13 == null) goto L16;
    L15:
        PlatformDependentDeclarationFilter r24 = r13;
        PlatformDependentTypeTransformer r19 = null;
        this.components = new DeserializationComponents(r27, r28, r29, r30, r31, r32, r11, r34, r35, r12, r17, r33, r36, r23, r24, JvmProtoBufUtil.INSTANCE.getEXTENSION_REGISTRY(), r37, new SamConversionResolverImpl(r27, CollectionsKt.emptyList()), r19, r38.getTranslators(), 262144, null);
        return;
    L16:
        r13 = PlatformDependentDeclarationFilter.NoPlatformDependent.INSTANCE;
    L11:
        r16 = AdditionalClassPartsProvider.None.INSTANCE;
        goto L10
    L5:
        r10 = null;
        goto L6
    }

    public final DeserializationComponents getComponents() {
        return this.components;
    }
}
