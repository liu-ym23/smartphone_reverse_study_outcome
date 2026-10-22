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
    public static final JvmMetadataVersion INSTANCE_NEXT = null;

    @JvmField
    public static final JvmMetadataVersion INVALID_VERSION = null;
    private final boolean isStrictSemantics;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        JvmMetadataVersion r5 = new JvmMetadataVersion(new int[]{1, 8, 0});
        INSTANCE = r5;
        INSTANCE_NEXT = r5.next();
        INVALID_VERSION = new JvmMetadataVersion(new int[0]);
    }

    public JvmMetadataVersion(int[] r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "versionArray");
        super(Arrays.copyOf(r5, r5.length));
        this.isStrictSemantics = r10;
    }

    private final boolean isCompatibleInternal(JvmMetadataVersion r5) {
        if (getMajor() != 1) goto L8;
        if (getMinor() != 0) goto L8;
        return false;
    L8:
        if (getMajor() != 0) goto L11;
        return false;
    L11:
        return !newerThan(r5);
    }

    private final boolean newerThan(JvmMetadataVersion r5) {
        if (getMajor() <= r5.getMajor()) goto L6;
        return true;
    L6:
        if (getMajor() >= r5.getMajor()) goto L9;
    L10:
        return false;
    L9:
        if (getMinor() <= r5.getMinor()) goto L10;
        return true;
    }

    public final boolean isCompatible(JvmMetadataVersion r5) {
        Intrinsics.checkNotNullParameter(r5, "metadataVersionFromLanguageVersion");
        if (getMajor() != 2) goto L12;
        if (getMinor() != 0) goto L12;
        JvmMetadataVersion r10 = INSTANCE;
        if (r10.getMajor() != 1) goto L12;
        if (r10.getMinor() != 8) goto L12;
        return true;
    L12:
        return isCompatibleInternal(r5.lastSupportedVersionWithThisLanguageVersion(this.isStrictSemantics));
    }

    public final boolean isStrictSemantics() {
        return this.isStrictSemantics;
    }

    public final JvmMetadataVersion lastSupportedVersionWithThisLanguageVersion(boolean r5) {
        if (r5 == false) goto L4;
        JvmMetadataVersion r10 = INSTANCE;
    L6:
        if (r10.newerThan(this) == true) goto L8;
        return this;
    L8:
        return r10;
    L4:
        r10 = INSTANCE_NEXT;
        goto L6
    }

    public final JvmMetadataVersion next() {
        if (getMajor() != 1) goto L8;
        if (getMinor() != 9) goto L8;
        return new JvmMetadataVersion(new int[]{2, 0, 0});
    L8:
        return new JvmMetadataVersion(new int[]{getMajor(), getMinor() + 1, 0});
    }

    public JvmMetadataVersion(int... r5) {
        Intrinsics.checkNotNullParameter(r5, "numbers");
        this(r5, false);
    }
}
