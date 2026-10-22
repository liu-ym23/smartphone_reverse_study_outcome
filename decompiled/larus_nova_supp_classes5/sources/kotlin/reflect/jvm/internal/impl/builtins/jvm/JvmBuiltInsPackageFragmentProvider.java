package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.io.InputStream;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.functions.BuiltInFictitiousFunctionClassFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AbstractDeserializedPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoaderImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedClassDataFinder;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.JvmEnumEntriesDeserializationSupport;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInSerializerProtocol;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsPackageFragmentImpl;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class JvmBuiltInsPackageFragmentProvider extends AbstractDeserializedPackageFragmentProvider {
    public static final Companion Companion = null;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AbstractDeserializedPackageFragmentProvider
    public DeserializedPackageFragment findPackage(FqName r8) {
        Intrinsics.checkNotNullParameter(r8, "fqName");
        InputStream r5 = getFinder().findBuiltInsData(r8);
        if (r5 != null) goto L7;
        return null;
    L7:
        return BuiltInsPackageFragmentImpl.Companion.create(r8, getStorageManager(), getModuleDescriptor(), r5, false);
    }

    public JvmBuiltInsPackageFragmentProvider(StorageManager r27, KotlinClassFinder r28, ModuleDescriptor r29, NotFoundClasses r30, AdditionalClassPartsProvider r31, PlatformDependentDeclarationFilter r32, DeserializationConfiguration r33, NewKotlinTypeChecker r34, SamConversionResolver r35) {
        Intrinsics.checkNotNullParameter(r27, "storageManager");
        Intrinsics.checkNotNullParameter(r28, "finder");
        Intrinsics.checkNotNullParameter(r29, "moduleDescriptor");
        Intrinsics.checkNotNullParameter(r30, "notFoundClasses");
        Intrinsics.checkNotNullParameter(r31, "additionalClassPartsProvider");
        Intrinsics.checkNotNullParameter(r32, "platformDependentDeclarationFilter");
        Intrinsics.checkNotNullParameter(r33, "deserializationConfiguration");
        Intrinsics.checkNotNullParameter(r34, "kotlinTypeChecker");
        Intrinsics.checkNotNullParameter(r35, "samConversionResolver");
        super(r27, r28, r29);
        DeserializedClassDataFinder r5 = new DeserializedClassDataFinder(this);
        BuiltInSerializerProtocol r0 = BuiltInSerializerProtocol.INSTANCE;
        setComponents(new DeserializationComponents(r27, r29, r33, r5, new AnnotationAndConstantLoaderImpl(r29, r30, r0), this, LocalClassifierTypeSettings.Default.INSTANCE, ErrorReporter.DO_NOTHING, LookupTracker.DO_NOTHING.INSTANCE, FlexibleTypeDeserializer.ThrowException.INSTANCE, CollectionsKt.listOf(new ClassDescriptorFactory[]{new BuiltInFictitiousFunctionClassFactory(r27, r29), new JvmBuiltInClassDescriptorFactory(r27, r29, null, 4, null)}), r30, ContractDeserializer.Companion.getDEFAULT(), r31, r32, r0.getExtensionRegistry(), r34, r35, null, JvmEnumEntriesDeserializationSupport.INSTANCE, 262144, null));
    }
}
