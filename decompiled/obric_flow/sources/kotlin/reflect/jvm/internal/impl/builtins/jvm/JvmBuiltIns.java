package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nJvmBuiltIns.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JvmBuiltIns.kt\norg/jetbrains/kotlin/builtins/jvm/JvmBuiltIns\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,103:1\n1#2:104\n*E\n"})
public final class JvmBuiltIns extends KotlinBuiltIns {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private final NotNullLazyValue customizer$delegate;
    private final Kind kind;
    private Function0<Settings> settingsComputation;

    public static final enum Kind extends Enum<Kind> {
        private static final /* synthetic */ Kind[] $VALUES = null;
        public static final Kind FALLBACK = null;
        public static final Kind FROM_CLASS_LOADER = null;
        public static final Kind FROM_DEPENDENCIES = null;

        private static final /* synthetic */ Kind[] $values() {
            return new Kind[]{FROM_DEPENDENCIES, FROM_CLASS_LOADER, FALLBACK};
        }

        static {
            FROM_DEPENDENCIES = new Kind("FROM_DEPENDENCIES", 0);
            FROM_CLASS_LOADER = new Kind("FROM_CLASS_LOADER", 1);
            FALLBACK = new Kind("FALLBACK", 2);
            $VALUES = $values();
        }

        private Kind(String r5, int r10) {
            super(r5, r10);
        }

        public static Kind valueOf(String r5) {
            return (Kind) Enum.valueOf(Kind.class, r5);
        }

        public static Kind[] values() {
            return (Kind[]) $VALUES.clone();
        }
    }

    public static final class Settings {
        private final boolean isAdditionalBuiltInsFeatureSupported;
        private final ModuleDescriptor ownerModuleDescriptor;

        public Settings(ModuleDescriptor r5, boolean r10) {
            Intrinsics.checkNotNullParameter(r5, "ownerModuleDescriptor");
            this.ownerModuleDescriptor = r5;
            this.isAdditionalBuiltInsFeatureSupported = r10;
        }

        public final ModuleDescriptor getOwnerModuleDescriptor() {
            return this.ownerModuleDescriptor;
        }

        public final boolean isAdditionalBuiltInsFeatureSupported() {
            return this.isAdditionalBuiltInsFeatureSupported;
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[Kind.values().length];
            r5[Kind.FROM_DEPENDENCIES.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r5[Kind.FROM_CLASS_LOADER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r5[Kind.FALLBACK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r5;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmBuiltIns.class), "customizer", "getCustomizer()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer;"))};
    }

    public JvmBuiltIns(final StorageManager r5, Kind r10) {
        Intrinsics.checkNotNullParameter(r5, "storageManager");
        Intrinsics.checkNotNullParameter(r10, "kind");
        super(r5);
        this.kind = r10;
        this.customizer$delegate = r5.createLazyValue(new JvmBuiltIns$customizer$2(this, r5));
        int r11 = WhenMappings.$EnumSwitchMapping$0[r10.ordinal()];
        if (r11 != 2) goto L5;
        createBuiltInsModule(false);
        return;
    L5:
        if (r11 != 3) goto L11;
        createBuiltInsModule(true);
        return;
    }

    public static final /* synthetic */ Function0 access$getSettingsComputation$p(JvmBuiltIns r5) {
        return r5.settingsComputation;
    }

    public static final /* synthetic */ void access$setSettingsComputation$p(JvmBuiltIns r5, Function0 r10) {
        r5.settingsComputation = r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns
    public AdditionalClassPartsProvider getAdditionalClassPartsProvider() {
        return getCustomizer();
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns
    public /* bridge */ /* synthetic */ Iterable getClassDescriptorFactories() {
        return getClassDescriptorFactories();
    }

    public final JvmBuiltInsCustomizer getCustomizer() {
        return (JvmBuiltInsCustomizer) StorageKt.getValue(this.customizer$delegate, this, $$delegatedProperties[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns
    public PlatformDependentDeclarationFilter getPlatformDependentDeclarationFilter() {
        return getCustomizer();
    }

    public final void initialize(final ModuleDescriptor r5, final boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "moduleDescriptor");
        setPostponedSettingsComputation(new AnonymousClass1(r5, r10));
    }

    public final void setPostponedSettingsComputation(Function0<Settings> r5) {
        Intrinsics.checkNotNullParameter(r5, "computation");
        this.settingsComputation = r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns
    public List<ClassDescriptorFactory> getClassDescriptorFactories() {
        return CollectionsKt.plus(super.getClassDescriptorFactories(), new JvmBuiltInClassDescriptorFactory(getStorageManager(), getBuiltInsModule(), null, 4, null));
    }
}
