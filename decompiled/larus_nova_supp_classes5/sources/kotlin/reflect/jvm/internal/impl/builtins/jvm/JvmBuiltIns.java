package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
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
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class JvmBuiltIns extends KotlinBuiltIns {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private final NotNullLazyValue customizer$delegate;
    private final Kind kind;
    private Function0<Settings> settingsComputation;

    public static final enum Kind extends Enum<Kind> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
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
            Kind[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }

        public static Kind[] values() {
            return (Kind[]) $VALUES.clone();
        }

        public static Kind valueOf(String r1) {
            return (Kind) a.a(Kind.class, r1);
        }

        private Kind(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class Settings {
        private final boolean isAdditionalBuiltInsFeatureSupported;
        private final ModuleDescriptor ownerModuleDescriptor;

        public final ModuleDescriptor getOwnerModuleDescriptor() {
            return this.ownerModuleDescriptor;
        }

        public final boolean isAdditionalBuiltInsFeatureSupported() {
            return this.isAdditionalBuiltInsFeatureSupported;
        }

        public Settings(ModuleDescriptor r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "ownerModuleDescriptor");
            this.ownerModuleDescriptor = r2;
            this.isAdditionalBuiltInsFeatureSupported = r3;
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[Kind.values().length];
            r0[Kind.FROM_DEPENDENCIES.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[Kind.FROM_CLASS_LOADER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[Kind.FALLBACK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmBuiltIns.class), "customizer", "getCustomizer()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer;"))};
    }

    public static /* synthetic */ JvmBuiltInsCustomizer accessor$JvmBuiltIns$lambda0(JvmBuiltIns r0, StorageManager r1) {
        return customizer_delegate$lambda$5(r0, r1);
    }

    public static /* synthetic */ Settings accessor$JvmBuiltIns$lambda1(ModuleDescriptor r0, boolean r1) {
        return initialize$lambda$1(r0, r1);
    }

    public static /* synthetic */ Settings accessor$JvmBuiltIns$lambda2(JvmBuiltIns r0) {
        return customizer_delegate$lambda$5$lambda$4(r0);
    }

    public final JvmBuiltInsCustomizer getCustomizer() {
        return (JvmBuiltInsCustomizer) StorageKt.getValue(this.customizer$delegate, this, $$delegatedProperties[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns
    public AdditionalClassPartsProvider getAdditionalClassPartsProvider() {
        return getCustomizer();
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns
    public List<ClassDescriptorFactory> getClassDescriptorFactories() {
        return CollectionsKt.plus(super.getClassDescriptorFactories(), new JvmBuiltInClassDescriptorFactory(getStorageManager(), getBuiltInsModule(), null, 4, null));
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns
    public PlatformDependentDeclarationFilter getPlatformDependentDeclarationFilter() {
        return getCustomizer();
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns
    public /* bridge */ /* synthetic */ Iterable getClassDescriptorFactories() {
        return getClassDescriptorFactories();
    }

    private static final Settings customizer_delegate$lambda$5$lambda$4(JvmBuiltIns r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Function0<Settings> r0 = r2.settingsComputation;
        if (r0 == null) goto L7;
        Settings r1 = (Settings) r0.invoke();
        r2.settingsComputation = null;
        return r1;
    L7:
        throw new AssertionError("JvmBuiltins instance has not been initialized properly");
    }

    public final void setPostponedSettingsComputation(Function0<Settings> r2) {
        Intrinsics.checkNotNullParameter(r2, "computation");
        this.settingsComputation = r2;
    }

    public JvmBuiltIns(final StorageManager r2, Kind r3) {
        Intrinsics.checkNotNullParameter(r2, "storageManager");
        Intrinsics.checkNotNullParameter(r3, "kind");
        super(r2);
        this.kind = r3;
        this.customizer$delegate = r2.createLazyValue(new JvmBuiltIns$$Lambda$0(this, r2));
        int r4 = WhenMappings.$EnumSwitchMapping$0[r3.ordinal()];
        if (r4 != 1) goto L5;
        return;
    L5:
        if (r4 != 2) goto L7;
        createBuiltInsModule(false);
        return;
    L7:
        if (r4 != 3) goto L10;
        createBuiltInsModule(true);
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    private static final JvmBuiltInsCustomizer customizer_delegate$lambda$5(final JvmBuiltIns r3, StorageManager r4) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        Intrinsics.checkNotNullParameter(r4, "$storageManager");
        return new JvmBuiltInsCustomizer(r3.getBuiltInsModule(), r4, new JvmBuiltIns$$Lambda$2(r3));
    }

    private static final Settings initialize$lambda$1(ModuleDescriptor r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "$moduleDescriptor");
        return new Settings(r1, r2);
    }

    public final void initialize(final ModuleDescriptor r2, final boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "moduleDescriptor");
        setPostponedSettingsComputation(new JvmBuiltIns$$Lambda$1(r2, r3));
    }
}
