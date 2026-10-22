package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class JvmMetadataVersion extends BinaryVersion {
    public static final Companion Companion = null;
    public static final JvmMetadataVersion INSTANCE = null;
    public static final JvmMetadataVersion INSTANCE_NEXT = null;
    public static final JvmMetadataVersion INVALID_VERSION = null;
    private final boolean isStrictSemantics;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        JvmMetadataVersion r0 = new JvmMetadataVersion(new int[]{2, 0, 0});
        INSTANCE = r0;
        INSTANCE_NEXT = r0.next();
        INVALID_VERSION = new JvmMetadataVersion(new int[0]);
    }

    public final JvmMetadataVersion next() {
        if (getMajor() != 1) goto L8;
        if (getMinor() != 9) goto L8;
        return new JvmMetadataVersion(new int[]{2, 0, 0});
    L8:
        return new JvmMetadataVersion(new int[]{getMajor(), getMinor() + 1, 0});
    }

    public final boolean isStrictSemantics() {
        return this.isStrictSemantics;
    }

    public JvmMetadataVersion(int... r2) {
        Intrinsics.checkNotNullParameter(r2, "numbers");
        this(r2, false);
    }

    private final boolean isCompatibleInternal(JvmMetadataVersion r4) {
        if (getMajor() != 1) goto L8;
        if (getMinor() != 0) goto L8;
        return false;
    L8:
        if (getMajor() != 0) goto L11;
        return false;
    L11:
        return !newerThan(r4);
    }

    private final boolean newerThan(JvmMetadataVersion r5) {
        if (getMajor() <= r5.getMajor()) goto L6;
        return true;
    L6:
        if (getMajor() >= r5.getMajor()) goto L9;
    L7:
        return false;
    L9:
        if (getMinor() <= r5.getMinor()) goto L7;
        return true;
    }

    public final boolean isCompatible(JvmMetadataVersion r4) {
        Intrinsics.checkNotNullParameter(r4, "metadataVersionFromLanguageVersion");
        if (getMajor() != 2) goto L12;
        if (getMinor() != 0) goto L12;
        JvmMetadataVersion r0 = INSTANCE;
        if (r0.getMajor() != 1) goto L12;
        if (r0.getMinor() != 8) goto L12;
        return true;
    L12:
        return isCompatibleInternal(r4.lastSupportedVersionWithThisLanguageVersion(this.isStrictSemantics));
    }

    public final JvmMetadataVersion lastSupportedVersionWithThisLanguageVersion(boolean r2) {
        if (r2 == false) goto L4;
        JvmMetadataVersion r3 = INSTANCE;
    L6:
        if (r3.newerThan(this) == false) goto L9;
        return r3;
    L9:
        return this;
    L4:
        r3 = INSTANCE_NEXT;
        goto L6
    }

    public JvmMetadataVersion(int[] r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "versionArray");
        super(Arrays.copyOf(r2, r2.length));
        this.isStrictSemantics = r3;
    }
}
