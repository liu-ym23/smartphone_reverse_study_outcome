package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.Arrays;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;

/* JADX INFO: loaded from: classes3.dex */
public final class JvmMetadataVersion extends BinaryVersion {
    public static final Companion Companion = null;

    @JvmField
    public static final JvmMetadataVersion INSTANCE = null;

    @JvmField
    public static final JvmMetadataVersion INVALID_VERSION = null;
    private final boolean isStrictSemantics;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        INSTANCE = new JvmMetadataVersion(new int[]{1, 7, 1});
        INVALID_VERSION = new JvmMetadataVersion(new int[0]);
    }

    public JvmMetadataVersion(int... r10) {
        Intrinsics.checkNotNullParameter(r10, "numbers");
        this(r10, false);
    }

    public JvmMetadataVersion(int[] r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "versionArray");
        super(Arrays.copyOf(r10, r10.length));
        this.isStrictSemantics = r11;
    }

    public boolean isCompatible() {
        if (getMajor() != 1) goto L7;
        if (getMinor() != 0) goto L7;
        return false;
    L7:
        if (this.isStrictSemantics == false) goto L9;
        boolean r10 = isCompatibleTo(INSTANCE);
    L15:
        if (r10 == true) goto L17;
        return false;
    L17:
        return true;
    L9:
        int r11 = getMajor();
        JvmMetadataVersion r12 = INSTANCE;
        if (r11 == r12.getMajor()) goto L12;
    L14:
        r10 = false;
        goto L15
    L12:
        if (getMinor() > (r12.getMinor() + 1)) goto L14;
        r10 = true;
        goto L15
    }
}
