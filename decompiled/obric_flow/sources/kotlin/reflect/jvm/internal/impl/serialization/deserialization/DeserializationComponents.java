package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentTypeTransformer;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.DefaultTypeAttributeTranslator;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributeTranslator;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;

/* JADX INFO: loaded from: classes3.dex */
public final class DeserializationComponents {
    private final AdditionalClassPartsProvider additionalClassPartsProvider;
    private final AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> annotationAndConstantLoader;
    private final ClassDataFinder classDataFinder;
    private final ClassDeserializer classDeserializer;
    private final DeserializationConfiguration configuration;
    private final ContractDeserializer contractDeserializer;
    private final ErrorReporter errorReporter;
    private final ExtensionRegistryLite extensionRegistryLite;
    private final Iterable<ClassDescriptorFactory> fictitiousClassDescriptorFactories;
    private final FlexibleTypeDeserializer flexibleTypeDeserializer;
    private final NewKotlinTypeChecker kotlinTypeChecker;
    private final LocalClassifierTypeSettings localClassifierTypeSettings;
    private final LookupTracker lookupTracker;
    private final ModuleDescriptor moduleDescriptor;
    private final NotFoundClasses notFoundClasses;
    private final PackageFragmentProvider packageFragmentProvider;
    private final PlatformDependentDeclarationFilter platformDependentDeclarationFilter;
    private final PlatformDependentTypeTransformer platformDependentTypeTransformer;
    private final SamConversionResolver samConversionResolver;
    private final StorageManager storageManager;
    private final List<TypeAttributeTranslator> typeAttributeTranslators;

    /* JADX WARN: Multi-variable type inference failed */
    public DeserializationComponents(StorageManager r17, ModuleDescriptor r18, DeserializationConfiguration r19, ClassDataFinder r20, AnnotationAndConstantLoader<? extends AnnotationDescriptor, ? extends ConstantValue<?>> r21, PackageFragmentProvider r22, LocalClassifierTypeSettings r23, ErrorReporter r24, LookupTracker r25, FlexibleTypeDeserializer r26, Iterable<? extends ClassDescriptorFactory> r27, NotFoundClasses r28, ContractDeserializer r29, AdditionalClassPartsProvider r30, PlatformDependentDeclarationFilter r31, ExtensionRegistryLite r32, NewKotlinTypeChecker r33, SamConversionResolver r34, PlatformDependentTypeTransformer r35, List<? extends TypeAttributeTranslator> r36) {
        Intrinsics.checkNotNullParameter(r17, "storageManager");
        Intrinsics.checkNotNullParameter(r18, "moduleDescriptor");
        Intrinsics.checkNotNullParameter(r19, "configuration");
        Intrinsics.checkNotNullParameter(r20, "classDataFinder");
        Intrinsics.checkNotNullParameter(r21, "annotationAndConstantLoader");
        Intrinsics.checkNotNullParameter(r22, "packageFragmentProvider");
        Intrinsics.checkNotNullParameter(r23, "localClassifierTypeSettings");
        Intrinsics.checkNotNullParameter(r24, "errorReporter");
        Intrinsics.checkNotNullParameter(r25, "lookupTracker");
        Intrinsics.checkNotNullParameter(r26, "flexibleTypeDeserializer");
        Intrinsics.checkNotNullParameter(r27, "fictitiousClassDescriptorFactories");
        Intrinsics.checkNotNullParameter(r28, "notFoundClasses");
        Intrinsics.checkNotNullParameter(r29, "contractDeserializer");
        Intrinsics.checkNotNullParameter(r30, "additionalClassPartsProvider");
        Intrinsics.checkNotNullParameter(r31, "platformDependentDeclarationFilter");
        Intrinsics.checkNotNullParameter(r32, "extensionRegistryLite");
        Intrinsics.checkNotNullParameter(r33, "kotlinTypeChecker");
        Intrinsics.checkNotNullParameter(r34, "samConversionResolver");
        Intrinsics.checkNotNullParameter(r35, "platformDependentTypeTransformer");
        Intrinsics.checkNotNullParameter(r36, "typeAttributeTranslators");
        this.storageManager = r17;
        this.moduleDescriptor = r18;
        this.configuration = r19;
        this.classDataFinder = r20;
        this.annotationAndConstantLoader = r21;
        this.packageFragmentProvider = r22;
        this.localClassifierTypeSettings = r23;
        this.errorReporter = r24;
        this.lookupTracker = r25;
        this.flexibleTypeDeserializer = r26;
        this.fictitiousClassDescriptorFactories = r27;
        this.notFoundClasses = r28;
        this.contractDeserializer = r29;
        this.additionalClassPartsProvider = r30;
        this.platformDependentDeclarationFilter = r31;
        this.extensionRegistryLite = r32;
        this.kotlinTypeChecker = r33;
        this.samConversionResolver = r34;
        this.platformDependentTypeTransformer = r35;
        this.typeAttributeTranslators = r36;
        this.classDeserializer = new ClassDeserializer(this);
    }

    public final DeserializationContext createContext(PackageFragmentDescriptor r12, NameResolver r13, TypeTable r14, VersionRequirementTable r15, BinaryVersion r16, DeserializedContainerSource r17) {
        Intrinsics.checkNotNullParameter(r12, "descriptor");
        Intrinsics.checkNotNullParameter(r13, "nameResolver");
        Intrinsics.checkNotNullParameter(r14, "typeTable");
        Intrinsics.checkNotNullParameter(r15, "versionRequirementTable");
        Intrinsics.checkNotNullParameter(r16, "metadataVersion");
        return new DeserializationContext(this, r13, r12, r14, r15, r16, r17, null, CollectionsKt.emptyList());
    }

    public final ClassDescriptor deserializeClass(ClassId r5) {
        Intrinsics.checkNotNullParameter(r5, "classId");
        return ClassDeserializer.deserializeClass$default(this.classDeserializer, r5, null, 2, null);
    }

    public final AdditionalClassPartsProvider getAdditionalClassPartsProvider() {
        return this.additionalClassPartsProvider;
    }

    public final AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> getAnnotationAndConstantLoader() {
        return this.annotationAndConstantLoader;
    }

    public final ClassDataFinder getClassDataFinder() {
        return this.classDataFinder;
    }

    public final ClassDeserializer getClassDeserializer() {
        return this.classDeserializer;
    }

    public final DeserializationConfiguration getConfiguration() {
        return this.configuration;
    }

    public final ContractDeserializer getContractDeserializer() {
        return this.contractDeserializer;
    }

    public final ErrorReporter getErrorReporter() {
        return this.errorReporter;
    }

    public final ExtensionRegistryLite getExtensionRegistryLite() {
        return this.extensionRegistryLite;
    }

    public final Iterable<ClassDescriptorFactory> getFictitiousClassDescriptorFactories() {
        return this.fictitiousClassDescriptorFactories;
    }

    public final FlexibleTypeDeserializer getFlexibleTypeDeserializer() {
        return this.flexibleTypeDeserializer;
    }

    public final NewKotlinTypeChecker getKotlinTypeChecker() {
        return this.kotlinTypeChecker;
    }

    public final LocalClassifierTypeSettings getLocalClassifierTypeSettings() {
        return this.localClassifierTypeSettings;
    }

    public final LookupTracker getLookupTracker() {
        return this.lookupTracker;
    }

    public final ModuleDescriptor getModuleDescriptor() {
        return this.moduleDescriptor;
    }

    public final NotFoundClasses getNotFoundClasses() {
        return this.notFoundClasses;
    }

    public final PackageFragmentProvider getPackageFragmentProvider() {
        return this.packageFragmentProvider;
    }

    public final PlatformDependentDeclarationFilter getPlatformDependentDeclarationFilter() {
        return this.platformDependentDeclarationFilter;
    }

    public final PlatformDependentTypeTransformer getPlatformDependentTypeTransformer() {
        return this.platformDependentTypeTransformer;
    }

    public final StorageManager getStorageManager() {
        return this.storageManager;
    }

    public final List<TypeAttributeTranslator> getTypeAttributeTranslators() {
        return this.typeAttributeTranslators;
    }

    public /* synthetic */ DeserializationComponents(StorageManager r24, ModuleDescriptor r25, DeserializationConfiguration r26, ClassDataFinder r27, AnnotationAndConstantLoader r28, PackageFragmentProvider r29, LocalClassifierTypeSettings r30, ErrorReporter r31, LookupTracker r32, FlexibleTypeDeserializer r33, Iterable r34, NotFoundClasses r35, ContractDeserializer r36, AdditionalClassPartsProvider r37, PlatformDependentDeclarationFilter r38, ExtensionRegistryLite r39, NewKotlinTypeChecker r40, SamConversionResolver r41, PlatformDependentTypeTransformer r42, List r43, int r44, DefaultConstructorMarker r45) {
        if ((r44 & 8192) == 0) goto L5;
        AdditionalClassPartsProvider r16 = AdditionalClassPartsProvider.None.INSTANCE;
    L7:
        if ((r44 & 16384) == 0) goto L9;
        PlatformDependentDeclarationFilter r17 = PlatformDependentDeclarationFilter.All.INSTANCE;
    L11:
        if ((65536 & r44) == 0) goto L13;
        NewKotlinTypeChecker r19 = NewKotlinTypeChecker.Companion.getDefault();
    L15:
        if ((262144 & r44) == 0) goto L17;
        PlatformDependentTypeTransformer r21 = PlatformDependentTypeTransformer.None.INSTANCE;
    L19:
        if ((r44 & 524288) == 0) goto L21;
        List r22 = CollectionsKt.listOf(DefaultTypeAttributeTranslator.INSTANCE);
    L22:
        this(r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r16, r17, r39, r19, r41, r21, r22);
        return;
    L21:
        r22 = r43;
        goto L22
    L17:
        r21 = r42;
        goto L19
    L13:
        r19 = r40;
        goto L15
    L9:
        r17 = r38;
        goto L11
    L5:
        r16 = r37;
        goto L7
    }
}
