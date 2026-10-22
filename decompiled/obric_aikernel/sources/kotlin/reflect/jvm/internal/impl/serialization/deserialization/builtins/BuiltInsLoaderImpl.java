package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoader;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolverImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoaderImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedClassDataFinder;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: classes3.dex */
public final class BuiltInsLoaderImpl implements BuiltInsLoader {
    private final BuiltInsResourceLoader resourceLoader;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsLoaderImpl$createPackageFragmentProvider$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReference implements Function1<String, InputStream> {
        AnonymousClass1(Object r10) {
            super(1, r10);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "loadResource";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(BuiltInsResourceLoader.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final String getSignature() {
            return "loadResource(Ljava/lang/String;)Ljava/io/InputStream;";
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final InputStream invoke2(String r10) {
            Intrinsics.checkNotNullParameter(r10, "p0");
            return ((BuiltInsResourceLoader) this.receiver).loadResource(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ InputStream invoke(String r10) {
            return invoke2(r10);
        }
    }

    public BuiltInsLoaderImpl() {
        this.resourceLoader = new BuiltInsResourceLoader();
    }

    public static /* synthetic */ PackageFragmentProvider createBuiltInPackageFragmentProvider$default(BuiltInsLoaderImpl r10, StorageManager r11, ModuleDescriptor r12, Set r13, Iterable r14, PlatformDependentDeclarationFilter r15, AdditionalClassPartsProvider r16, boolean r17, Function1 r18, int r19, Object r20) {
        if ((r19 & 32) == 0) goto L5;
        AdditionalClassPartsProvider r21 = AdditionalClassPartsProvider.None.INSTANCE;
    L7:
        return r10.createBuiltInPackageFragmentProvider(r11, r12, r13, r14, r15, r21, r17, r18);
    L5:
        r21 = r16;
        goto L7
    }

    public final PackageFragmentProvider createBuiltInPackageFragmentProvider(StorageManager r27, ModuleDescriptor r28, Set<FqName> r29, Iterable<? extends ClassDescriptorFactory> r30, PlatformDependentDeclarationFilter r31, AdditionalClassPartsProvider r32, boolean r33, Function1<? super String, ? extends InputStream> r34) {
        Intrinsics.checkNotNullParameter(r27, "storageManager");
        Intrinsics.checkNotNullParameter(r28, "module");
        Intrinsics.checkNotNullParameter(r29, "packageFqNames");
        Intrinsics.checkNotNullParameter(r30, "classDescriptorFactories");
        Intrinsics.checkNotNullParameter(r31, "platformDependentDeclarationFilter");
        Intrinsics.checkNotNullParameter(r32, "additionalClassPartsProvider");
        Intrinsics.checkNotNullParameter(r34, "loadResource");
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r29, 10));
        Iterator<T> r11 = r29.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        FqName r12 = (FqName) r11.next();
        String r13 = BuiltInSerializerProtocol.INSTANCE.getBuiltInsFilePath(r12);
        InputStream r14 = r34.invoke(r13);
        if (r14 == null) goto L9;
        r10.add(BuiltInsPackageFragmentImpl.Companion.create(r12, r27, r28, r14, r33));
        goto L4
    L9:
        throw new IllegalStateException("Resource not found in classpath: " + r13);
    L10:
        PackageFragmentProviderImpl r15 = new PackageFragmentProviderImpl(r10);
        NotFoundClasses r16 = new NotFoundClasses(r27, r28);
        DeserializationConfiguration.Default r17 = DeserializationConfiguration.Default.INSTANCE;
        DeserializedClassDataFinder r18 = new DeserializedClassDataFinder(r15);
        BuiltInSerializerProtocol r19 = BuiltInSerializerProtocol.INSTANCE;
        AnnotationAndConstantLoaderImpl r20 = new AnnotationAndConstantLoaderImpl(r28, r16, r19);
        LocalClassifierTypeSettings.Default r21 = LocalClassifierTypeSettings.Default.INSTANCE;
        ErrorReporter r22 = ErrorReporter.DO_NOTHING;
        Intrinsics.checkNotNullExpressionValue(r22, "DO_NOTHING");
        DeserializationComponents r23 = new DeserializationComponents(r27, r28, r17, r18, r20, r15, r21, r22, LookupTracker.DO_NOTHING.INSTANCE, FlexibleTypeDeserializer.ThrowException.INSTANCE, r30, r16, ContractDeserializer.Companion.getDEFAULT(), r32, r31, r19.getExtensionRegistry(), null, new SamConversionResolverImpl(r27, CollectionsKt.emptyList()), null, null, 851968, null);
        Iterator r24 = r10.iterator();
    L12:
        if (r24.hasNext() == false) goto L14;
        ((BuiltInsPackageFragmentImpl) r24.next()).initialize(r23);
        goto L12
    L14:
        return r15;
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoader
    public PackageFragmentProvider createPackageFragmentProvider(StorageManager r11, ModuleDescriptor r12, Iterable<? extends ClassDescriptorFactory> r13, PlatformDependentDeclarationFilter r14, AdditionalClassPartsProvider r15, boolean r16) {
        Intrinsics.checkNotNullParameter(r11, "storageManager");
        Intrinsics.checkNotNullParameter(r12, "builtInsModule");
        Intrinsics.checkNotNullParameter(r13, "classDescriptorFactories");
        Intrinsics.checkNotNullParameter(r14, "platformDependentDeclarationFilter");
        Intrinsics.checkNotNullParameter(r15, "additionalClassPartsProvider");
        return createBuiltInPackageFragmentProvider(r11, r12, StandardNames.BUILT_INS_PACKAGE_FQ_NAMES, r13, r14, r15, r16, new AnonymousClass1(this.resourceLoader));
    }
}
