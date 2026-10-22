package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: classes3.dex */
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

        private Kind(String r10, int r11) {
            super(r10, r11);
        }

        public static Kind valueOf(String r10) {
            return (Kind) Enum.valueOf(Kind.class, r10);
        }

        public static Kind[] values() {
            return (Kind[]) $VALUES.clone();
        }
    }

    public static final class Settings {
        private final boolean isAdditionalBuiltInsFeatureSupported;
        private final ModuleDescriptor ownerModuleDescriptor;

        public Settings(ModuleDescriptor r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r10, "ownerModuleDescriptor");
            this.ownerModuleDescriptor = r10;
            this.isAdditionalBuiltInsFeatureSupported = r11;
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
            int[] r10 = new int[Kind.values().length];
            r10[Kind.FROM_DEPENDENCIES.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r10[Kind.FROM_CLASS_LOADER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r10[Kind.FALLBACK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r10;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmBuiltIns.class), "customizer", "getCustomizer()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer;"))};
    }

    public JvmBuiltIns(final StorageManager r10, Kind r11) {
        Intrinsics.checkNotNullParameter(r10, "storageManager");
        Intrinsics.checkNotNullParameter(r11, "kind");
        super(r10);
        this.kind = r11;
        this.customizer$delegate = r10.createLazyValue(new JvmBuiltIns$customizer$2(this, r10));
        int r12 = WhenMappings.$EnumSwitchMapping$0[r11.ordinal()];
        if (r12 != 2) goto L5;
        boolean r13 = false;
    L9:
        createBuiltInsModule(r13);
        return;
    L5:
        if (r12 != 3) goto L11;
        r13 = true;
        goto L9
    }

    public static final /* synthetic */ Function0 access$getSettingsComputation$p(JvmBuiltIns r10) {
        return r10.settingsComputation;
    }

    public static final /* synthetic */ void access$setSettingsComputation$p(JvmBuiltIns r10, Function0 r11) {
        r10.settingsComputation = r11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns
    protected AdditionalClassPartsProvider getAdditionalClassPartsProvider() {
        return getCustomizer();
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns
    public /* bridge */ /* synthetic */ Iterable getClassDescriptorFactories() {
        return getClassDescriptorFactories();
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns
    protected List<ClassDescriptorFactory> getClassDescriptorFactories() {
        Iterable<ClassDescriptorFactory> r10 = super.getClassDescriptorFactories();
        Intrinsics.checkNotNullExpressionValue(r10, "super.getClassDescriptorFactories()");
        StorageManager r11 = getStorageManager();
        Intrinsics.checkNotNullExpressionValue(r11, "storageManager");
        ModuleDescriptorImpl r12 = getBuiltInsModule();
        Intrinsics.checkNotNullExpressionValue(r12, "builtInsModule");
        return CollectionsKt.plus(r10, new JvmBuiltInClassDescriptorFactory(r11, r12, null, 4, null));
    }

    public final JvmBuiltInsCustomizer getCustomizer() {
        return (JvmBuiltInsCustomizer) StorageKt.getValue(this.customizer$delegate, this, $$delegatedProperties[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns
    protected PlatformDependentDeclarationFilter getPlatformDependentDeclarationFilter() {
        return getCustomizer();
    }

    public final void initialize(final ModuleDescriptor r10, final boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "moduleDescriptor");
        setPostponedSettingsComputation(new AnonymousClass1(r10, r11));
    }

    public final void setPostponedSettingsComputation(Function0<Settings> r10) {
        Intrinsics.checkNotNullParameter(r10, "computation");
        this.settingsComputation = r10;
    }
}
