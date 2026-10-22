package androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization;

import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization.BinaryVersion;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0013\b\u0016\u0012\n\u0010\u0002\u001a\u00020\u0003\"\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0015\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u000b\u001a\u00020\bH\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\n¨\u0006\r"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/deserialization/JvmMetadataVersion;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/deserialization/BinaryVersion;", "numbers", "", "", "([I)V", "versionArray", "isStrictSemantics", "", "([IZ)V", "()Z", "isCompatible", "Companion", "metadata.jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JvmMetadataVersion extends BinaryVersion {
    public static final Companion Companion = null;

    @JvmField
    public static final JvmMetadataVersion INSTANCE = null;

    @JvmField
    public static final JvmMetadataVersion INVALID_VERSION = null;
    private final boolean isStrictSemantics;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/deserialization/JvmMetadataVersion$Companion;", "", "()V", "INSTANCE", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/deserialization/JvmMetadataVersion;", "INVALID_VERSION", "metadata.jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        INSTANCE = new JvmMetadataVersion(new int[]{1, 7, 1});
        INVALID_VERSION = new JvmMetadataVersion(new int[0]);
    }

    public JvmMetadataVersion(int[] r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "versionArray");
        super(Arrays.copyOf(r5, r5.length));
        this.isStrictSemantics = r10;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization.BinaryVersion
    public boolean isCompatible() {
        if (getMajor() != 1) goto L7;
        if (getMinor() != 0) goto L7;
        return false;
    L7:
        if (this.isStrictSemantics == false) goto L9;
        boolean r5 = isCompatibleTo(INSTANCE);
    L15:
        if (r5 == true) goto L17;
        return false;
    L17:
        return true;
    L9:
        int r10 = getMajor();
        JvmMetadataVersion r11 = INSTANCE;
        if (r10 == r11.getMajor()) goto L12;
    L14:
        r5 = false;
        goto L15
    L12:
        if (getMinor() > (r11.getMinor() + 1)) goto L14;
        r5 = true;
        goto L15
    }

    public final boolean isStrictSemantics() {
        return this.isStrictSemantics;
    }

    public JvmMetadataVersion(int... r5) {
        Intrinsics.checkNotNullParameter(r5, "numbers");
        this(r5, false);
    }
}
