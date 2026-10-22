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
import kotlin.reflect.jvm.internal.impl.descriptors.impl.CompositePackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.SingleModuleClassResolver;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory;
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

            public ModuleData(DeserializationComponentsForJava r10, DeserializedDescriptorResolver r11) {
                Intrinsics.checkNotNullParameter(r10, "deserializationComponentsForJava");
                Intrinsics.checkNotNullParameter(r11, "deserializedDescriptorResolver");
                this.deserializationComponentsForJava = r10;
                this.deserializedDescriptorResolver = r11;
            }

            public final DeserializationComponentsForJava getDeserializationComponentsForJava() {
                return this.deserializationComponentsForJava;
            }

            public final DeserializedDescriptorResolver getDeserializedDescriptorResolver() {
                return this.deserializedDescriptorResolver;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final ModuleData createModuleData(KotlinClassFinder r26, KotlinClassFinder r27, JavaClassFinder r28, String r29, ErrorReporter r30, JavaSourceElementFactory r31) {
            Intrinsics.checkNotNullParameter(r26, "kotlinClassFinder");
            Intrinsics.checkNotNullParameter(r27, "jvmBuiltInsKotlinClassFinder");
            Intrinsics.checkNotNullParameter(r28, "javaClassFinder");
            Intrinsics.checkNotNullParameter(r29, "moduleName");
            Intrinsics.checkNotNullParameter(r30, "errorReporter");
            Intrinsics.checkNotNullParameter(r31, "javaSourceElementFactory");
            LockBasedStorageManager r10 = new LockBasedStorageManager("DeserializationComponentsForJava.ModuleData");
            JvmBuiltIns r12 = new JvmBuiltIns(r10, JvmBuiltIns.Kind.FROM_DEPENDENCIES);
            Name r11 = Name.special(Typography.less + r29 + Typography.greater);
            Intrinsics.checkNotNullExpressionValue(r11, "special(\"<$moduleName>\")");
            ModuleDescriptorImpl r13 = new ModuleDescriptorImpl(r11, r10, r12, null, null, null, 56, null);
            r12.setBuiltInsModule(r13);
            r12.initialize(r13, true);
            DeserializedDescriptorResolver r14 = new DeserializedDescriptorResolver();
            SingleModuleClassResolver r15 = new SingleModuleClassResolver();
            NotFoundClasses r16 = new NotFoundClasses(r10, r13);
            LazyJavaPackageFragmentProvider r17 = DeserializationComponentsForJavaKt.makeLazyJavaPackageFragmentProvider$default(r28, r13, r10, r16, r26, r14, r30, r31, r15, null, 512, null);
            DeserializationComponentsForJava r18 = DeserializationComponentsForJavaKt.makeDeserializationComponentsForJava(r13, r10, r16, r17, r26, r14, r30);
            r14.setComponents(r18);
            JavaResolverCache r19 = JavaResolverCache.EMPTY;
            Intrinsics.checkNotNullExpressionValue(r19, "EMPTY");
            JavaDescriptorResolver r110 = new JavaDescriptorResolver(r17, r19);
            r15.setResolver(r110);
            JvmBuiltInsPackageFragmentProvider r111 = new JvmBuiltInsPackageFragmentProvider(r10, r27, r13, r16, r12.getCustomizer(), r12.getCustomizer(), DeserializationConfiguration.Default.INSTANCE, NewKotlinTypeChecker.Companion.getDefault(), new SamConversionResolverImpl(r10, CollectionsKt.emptyList()));
            r13.setDependencies(new ModuleDescriptorImpl[]{r13});
            r13.initialize(new CompositePackageFragmentProvider(CollectionsKt.listOf(new PackageFragmentProviderOptimized[]{r110.getPackageFragmentProvider(), r111}), "CompositeProvider@RuntimeModuleData for " + r13));
            return new ModuleData(r18, r14);
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
        KotlinBuiltIns r10 = r28.getBuiltIns();
        if ((r10 instanceof JvmBuiltIns) == false) goto L5;
        JvmBuiltIns r11 = (JvmBuiltIns) r10;
    L6:
        LocalClassifierTypeSettings.Default r12 = LocalClassifierTypeSettings.Default.INSTANCE;
        JavaFlexibleTypeDeserializer r13 = JavaFlexibleTypeDeserializer.INSTANCE;
        List r17 = CollectionsKt.emptyList();
        if (r11 == null) goto L11;
        AdditionalClassPartsProvider r16 = r11.getCustomizer();
        if (r16 == null) goto L11;
    L12:
        AdditionalClassPartsProvider r23 = r16;
        if (r11 == null) goto L17;
        PlatformDependentDeclarationFilter r14 = r11.getCustomizer();
        if (r14 == null) goto L17;
    L18:
        this.components = new DeserializationComponents(r27, r28, r29, r30, r31, r32, r12, r34, r35, r13, r17, r33, r36, r23, r14, JvmProtoBufUtil.INSTANCE.getEXTENSION_REGISTRY(), r37, new SamConversionResolverImpl(r27, CollectionsKt.emptyList()), null, r38.getTranslators(), 262144, null);
        return;
    L17:
        r14 = PlatformDependentDeclarationFilter.NoPlatformDependent.INSTANCE;
    L11:
        r16 = AdditionalClassPartsProvider.None.INSTANCE;
        goto L12
    L5:
        r11 = null;
        goto L6
    }

    public final DeserializationComponents getComponents() {
        return this.components;
    }
}
