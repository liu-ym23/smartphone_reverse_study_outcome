package kotlin.reflect.jvm.internal.impl.descriptors.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;

/* JADX INFO: loaded from: classes3.dex */
public final class JavaVisibilities {
    public static final JavaVisibilities INSTANCE = null;

    public static final class PackageVisibility extends Visibility {
        public static final PackageVisibility INSTANCE = null;

        static {
            INSTANCE = new PackageVisibility();
        }

        private PackageVisibility() {
            super("package", false);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public Integer compareTo(Visibility r10) {
            Intrinsics.checkNotNullParameter(r10, "visibility");
            if (this != r10) goto L8;
            int r11 = 0;
        L6:
            return Integer.valueOf(r11);
        L8:
            if (Visibilities.INSTANCE.isPrivate(r10) == false) goto L10;
            r11 = 1;
            goto L6
        L10:
            r11 = -1;
            goto L6
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public String getInternalDisplayName() {
            return "public/*package*/";
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public Visibility normalize() {
            return Visibilities.Protected.INSTANCE;
        }
    }

    public static final class ProtectedAndPackage extends Visibility {
        public static final ProtectedAndPackage INSTANCE = null;

        static {
            INSTANCE = new ProtectedAndPackage();
        }

        private ProtectedAndPackage() {
            super("protected_and_package", true);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public Integer compareTo(Visibility r10) {
            Intrinsics.checkNotNullParameter(r10, "visibility");
            if (Intrinsics.areEqual(this, r10) == false) goto L7;
            return 0;
        L7:
            if (r10 != Visibilities.Internal.INSTANCE) goto L11;
            return null;
        L11:
            if (Visibilities.INSTANCE.isPrivate(r10) == false) goto L13;
            int r11 = 1;
        L15:
            return Integer.valueOf(r11);
        L13:
            r11 = -1;
            goto L15
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public String getInternalDisplayName() {
            return "protected/*protected and package*/";
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public Visibility normalize() {
            return Visibilities.Protected.INSTANCE;
        }
    }

    public static final class ProtectedStaticVisibility extends Visibility {
        public static final ProtectedStaticVisibility INSTANCE = null;

        static {
            INSTANCE = new ProtectedStaticVisibility();
        }

        private ProtectedStaticVisibility() {
            super("protected_static", true);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public String getInternalDisplayName() {
            return "protected/*protected static*/";
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public Visibility normalize() {
            return Visibilities.Protected.INSTANCE;
        }
    }

    static {
        INSTANCE = new JavaVisibilities();
    }

    private JavaVisibilities() {
    }
}
