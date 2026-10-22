package androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization;

import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization.Flags;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u000fR\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0019\u0010\n\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007¨\u0006\u0013"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/deserialization/JvmFlags;", "", "()V", "IS_COMPILED_IN_COMPATIBILITY_MODE", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/deserialization/Flags$BooleanFlagField;", "kotlin.jvm.PlatformType", "getIS_COMPILED_IN_COMPATIBILITY_MODE", "()Lorg/jetbrains/kotlin/metadata/deserialization/Flags$BooleanFlagField;", "IS_COMPILED_IN_JVM_DEFAULT_MODE", "getIS_COMPILED_IN_JVM_DEFAULT_MODE", "IS_MOVED_FROM_INTERFACE_COMPANION", "getIS_MOVED_FROM_INTERFACE_COMPANION", "getClassFlags", "", "isAllInterfaceBodiesInside", "", "isCompatibilityMode", "getPropertyFlags", "isMovedFromInterfaceCompanion", "metadata.jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JvmFlags {
    public static final JvmFlags INSTANCE = null;
    private static final Flags.BooleanFlagField IS_COMPILED_IN_COMPATIBILITY_MODE = null;
    private static final Flags.BooleanFlagField IS_COMPILED_IN_JVM_DEFAULT_MODE = null;
    private static final Flags.BooleanFlagField IS_MOVED_FROM_INTERFACE_COMPANION = null;

    static {
        INSTANCE = new JvmFlags();
        IS_MOVED_FROM_INTERFACE_COMPANION = Flags.FlagField.booleanFirst();
        Flags.BooleanFlagField r5 = Flags.FlagField.booleanFirst();
        IS_COMPILED_IN_JVM_DEFAULT_MODE = r5;
        IS_COMPILED_IN_COMPATIBILITY_MODE = Flags.FlagField.booleanAfter(r5);
    }

    private JvmFlags() {
    }

    public final int getClassFlags(boolean r5, boolean r10) {
        return IS_COMPILED_IN_JVM_DEFAULT_MODE.toFlags2(Boolean.valueOf(r5)) | IS_COMPILED_IN_COMPATIBILITY_MODE.toFlags2(Boolean.valueOf(r10));
    }

    public final Flags.BooleanFlagField getIS_COMPILED_IN_COMPATIBILITY_MODE() {
        return IS_COMPILED_IN_COMPATIBILITY_MODE;
    }

    public final Flags.BooleanFlagField getIS_COMPILED_IN_JVM_DEFAULT_MODE() {
        return IS_COMPILED_IN_JVM_DEFAULT_MODE;
    }

    public final Flags.BooleanFlagField getIS_MOVED_FROM_INTERFACE_COMPANION() {
        return IS_MOVED_FROM_INTERFACE_COMPANION;
    }

    public final int getPropertyFlags(boolean r5) {
        return IS_MOVED_FROM_INTERFACE_COMPANION.toFlags2(Boolean.valueOf(r5));
    }
}
