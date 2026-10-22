package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaPropertyInitializerEvaluator;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ModuleClassResolver;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolverImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.DefaultTypeAttributeTranslator;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.extensions.TypeAttributeTranslators;

/* JADX INFO: loaded from: classes3.dex */
public final class DeserializationComponentsForJavaKt {
    public static final DeserializationComponentsForJava makeDeserializationComponentsForJava(ModuleDescriptor r15, StorageManager r16, NotFoundClasses r17, LazyJavaPackageFragmentProvider r18, KotlinClassFinder r19, DeserializedDescriptorResolver r20, ErrorReporter r21, JvmMetadataVersion r22) {
        Intrinsics.checkNotNullParameter(r15, "module");
        Intrinsics.checkNotNullParameter(r16, "storageManager");
        Intrinsics.checkNotNullParameter(r17, "notFoundClasses");
        Intrinsics.checkNotNullParameter(r18, "lazyJavaPackageFragmentProvider");
        Intrinsics.checkNotNullParameter(r19, "reflectKotlinClassFinder");
        Intrinsics.checkNotNullParameter(r20, "deserializedDescriptorResolver");
        Intrinsics.checkNotNullParameter(r21, "errorReporter");
        Intrinsics.checkNotNullParameter(r22, "jvmMetadataVersion");
        JavaClassDataFinder r5 = new JavaClassDataFinder(r19, r20);
        BinaryClassAnnotationAndConstantLoaderImpl r10 = BinaryClassAnnotationAndConstantLoaderImplKt.createBinaryClassAnnotationAndConstantLoader(r15, r17, r16, r19, r22);
        return new DeserializationComponentsForJava(r16, r15, DeserializationConfiguration.Default.INSTANCE, r5, r10, r18, r17, r21, LookupTracker.DO_NOTHING.INSTANCE, ContractDeserializer.Companion.getDEFAULT(), NewKotlinTypeChecker.Companion.getDefault(), new TypeAttributeTranslators(CollectionsKt.listOf(DefaultTypeAttributeTranslator.INSTANCE)));
    }

    public static final LazyJavaPackageFragmentProvider makeLazyJavaPackageFragmentProvider(JavaClassFinder r31, ModuleDescriptor r32, StorageManager r33, NotFoundClasses r34, KotlinClassFinder r35, DeserializedDescriptorResolver r36, ErrorReporter r37, JavaSourceElementFactory r38, ModuleClassResolver r39, PackagePartProvider r40) {
        Intrinsics.checkNotNullParameter(r31, "javaClassFinder");
        Intrinsics.checkNotNullParameter(r32, "module");
        Intrinsics.checkNotNullParameter(r33, "storageManager");
        Intrinsics.checkNotNullParameter(r34, "notFoundClasses");
        Intrinsics.checkNotNullParameter(r35, "reflectKotlinClassFinder");
        Intrinsics.checkNotNullParameter(r36, "deserializedDescriptorResolver");
        Intrinsics.checkNotNullParameter(r37, "errorReporter");
        Intrinsics.checkNotNullParameter(r38, "javaSourceElementFactory");
        Intrinsics.checkNotNullParameter(r39, "singleModuleClassResolver");
        Intrinsics.checkNotNullParameter(r40, "packagePartProvider");
        SignaturePropagator r5 = SignaturePropagator.DO_NOTHING;
        JavaResolverCache r10 = JavaResolverCache.EMPTY;
        JavaPropertyInitializerEvaluator.DoNothing r16 = JavaPropertyInitializerEvaluator.DoNothing.INSTANCE;
        SamConversionResolverImpl r14 = new SamConversionResolverImpl(r33, CollectionsKt.emptyList());
        SupertypeLoopChecker.EMPTY r13 = SupertypeLoopChecker.EMPTY.INSTANCE;
        LookupTracker.DO_NOTHING r15 = LookupTracker.DO_NOTHING.INSTANCE;
        ReflectionTypes r11 = new ReflectionTypes(r32, r34);
        JavaTypeEnhancementState.Companion r12 = JavaTypeEnhancementState.Companion;
        AnnotationTypeQualifierResolver r17 = new AnnotationTypeQualifierResolver(r12.getDEFAULT());
        JavaResolverSettings.Default r18 = JavaResolverSettings.Default.INSTANCE;
        return new LazyJavaPackageFragmentProvider(new JavaResolverComponents(r33, r31, r35, r36, r5, r37, r10, r16, r14, r38, r39, r40, r13, r15, r32, r11, r17, new SignatureEnhancement(new JavaTypeEnhancement(r18)), JavaClassesTracker.Default.INSTANCE, r18, NewKotlinTypeChecker.Companion.getDefault(), r12.getDEFAULT(), new DeserializationComponentsForJavaKt$makeLazyJavaPackageFragmentProvider$javaResolverComponents$1(), null, 8388608, null));
    }

    public static /* synthetic */ LazyJavaPackageFragmentProvider makeLazyJavaPackageFragmentProvider$default(JavaClassFinder r11, ModuleDescriptor r12, StorageManager r13, NotFoundClasses r14, KotlinClassFinder r15, DeserializedDescriptorResolver r16, ErrorReporter r17, JavaSourceElementFactory r18, ModuleClassResolver r19, PackagePartProvider r20, int r21, Object r22) {
        if ((r21 & 512) == 0) goto L5;
        PackagePartProvider r10 = PackagePartProvider.Empty.INSTANCE;
    L7:
        return makeLazyJavaPackageFragmentProvider(r11, r12, r13, r14, r15, r16, r17, r18, r19, r10);
    L5:
        r10 = r20;
        goto L7
    }
}
