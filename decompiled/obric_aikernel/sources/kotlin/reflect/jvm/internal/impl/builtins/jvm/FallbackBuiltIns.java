package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;

/* JADX INFO: loaded from: classes3.dex */
final class FallbackBuiltIns extends KotlinBuiltIns {
    public static final Companion Companion = null;
    private static final KotlinBuiltIns Instance = null;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final KotlinBuiltIns getInstance() {
            return FallbackBuiltIns.access$getInstance$cp();
        }
    }

    static {
        Companion = new Companion(null);
        Instance = new FallbackBuiltIns();
    }

    private FallbackBuiltIns() {
        super(new LockBasedStorageManager("FallbackBuiltIns"));
        createBuiltInsModule(true);
    }

    public static final /* synthetic */ KotlinBuiltIns access$getInstance$cp() {
        return Instance;
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns
    protected PlatformDependentDeclarationFilter.All getPlatformDependentDeclarationFilter() {
        return PlatformDependentDeclarationFilter.All.INSTANCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns
    public /* bridge */ /* synthetic */ PlatformDependentDeclarationFilter getPlatformDependentDeclarationFilter() {
        return getPlatformDependentDeclarationFilter();
    }
}
