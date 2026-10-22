package kotlin.reflect.jvm.internal.impl.resolve.scopes;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DescriptorKindExclude {

    public static final class NonExtensions extends DescriptorKindExclude {
        public static final NonExtensions INSTANCE = null;
        private static final int fullyExcludedDescriptorKinds = 0;

        static {
            INSTANCE = new NonExtensions();
            DescriptorKindFilter.Companion r5 = DescriptorKindFilter.Companion;
            int r10 = r5.getALL_KINDS_MASK();
            int r11 = r5.getFUNCTIONS_MASK();
            fullyExcludedDescriptorKinds = (~(r5.getVARIABLES_MASK() | r11)) & r10;
        }

        private NonExtensions() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindExclude
        public int getFullyExcludedDescriptorKinds() {
            return fullyExcludedDescriptorKinds;
        }
    }

    public static final class TopLevelPackages extends DescriptorKindExclude {
        public static final TopLevelPackages INSTANCE = null;

        static {
            INSTANCE = new TopLevelPackages();
        }

        private TopLevelPackages() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindExclude
        public int getFullyExcludedDescriptorKinds() {
            return 0;
        }
    }

    public DescriptorKindExclude() {
    }

    public abstract int getFullyExcludedDescriptorKinds();

    public String toString() {
        return getClass().getSimpleName();
    }
}
