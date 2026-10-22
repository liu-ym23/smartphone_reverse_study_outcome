package androidx.room.jarjarred.kotlinx.metadata.jvm;

import androidx.room.jarjarred.kotlinx.metadata.Flag;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization.Flags;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization.JvmFlags;
import kotlin.Metadata;
import kotlin.jvm.JvmField;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\t"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmFlag;", "", "()V", "booleanFlag", "Landroidx/room/jarjarred/kotlinx/metadata/Flag;", "f", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/deserialization/Flags$BooleanFlagField;", "Class", "Property", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JvmFlag {
    public static final JvmFlag INSTANCE = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmFlag$Class;", "", "()V", "HAS_METHOD_BODIES_IN_INTERFACE", "Landroidx/room/jarjarred/kotlinx/metadata/Flag;", "IS_COMPILED_IN_COMPATIBILITY_MODE", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Class {

        @JvmField
        public static final Flag HAS_METHOD_BODIES_IN_INTERFACE = null;
        public static final Class INSTANCE = null;

        @JvmField
        public static final Flag IS_COMPILED_IN_COMPATIBILITY_MODE = null;

        static {
            INSTANCE = new Class();
            JvmFlag r5 = JvmFlag.INSTANCE;
            JvmFlags r10 = JvmFlags.INSTANCE;
            HAS_METHOD_BODIES_IN_INTERFACE = JvmFlag.access$booleanFlag(r5, r10.getIS_COMPILED_IN_JVM_DEFAULT_MODE());
            IS_COMPILED_IN_COMPATIBILITY_MODE = JvmFlag.access$booleanFlag(r5, r10.getIS_COMPILED_IN_COMPATIBILITY_MODE());
        }

        private Class() {
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmFlag$Property;", "", "()V", "IS_MOVED_FROM_INTERFACE_COMPANION", "Landroidx/room/jarjarred/kotlinx/metadata/Flag;", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Property {
        public static final Property INSTANCE = null;

        @JvmField
        public static final Flag IS_MOVED_FROM_INTERFACE_COMPANION = null;

        static {
            INSTANCE = new Property();
            IS_MOVED_FROM_INTERFACE_COMPANION = JvmFlag.access$booleanFlag(JvmFlag.INSTANCE, JvmFlags.INSTANCE.getIS_MOVED_FROM_INTERFACE_COMPANION());
        }

        private Property() {
        }
    }

    static {
        INSTANCE = new JvmFlag();
    }

    private JvmFlag() {
    }

    public static final /* synthetic */ Flag access$booleanFlag(JvmFlag r5, Flags.BooleanFlagField r10) {
        return r5.booleanFlag(r10);
    }

    private final Flag booleanFlag(Flags.BooleanFlagField r5) {
        return new Flag(r5.offset, r5.bitWidth, 1);
    }
}
