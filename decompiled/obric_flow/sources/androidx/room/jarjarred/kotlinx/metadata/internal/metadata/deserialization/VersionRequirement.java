package androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization;

import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.ProtoBuf;
import androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0018\u001a\u00020\u000bH\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/deserialization/VersionRequirement;", "", "version", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/deserialization/VersionRequirement$Version;", "kind", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$VersionRequirement$VersionKind;", "level", "Lkotlin/DeprecationLevel;", "errorCode", "", "message", "", "(Lorg/jetbrains/kotlin/metadata/deserialization/VersionRequirement$Version;Lorg/jetbrains/kotlin/metadata/ProtoBuf$VersionRequirement$VersionKind;Lkotlin/DeprecationLevel;Ljava/lang/Integer;Ljava/lang/String;)V", "getErrorCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getKind", "()Lorg/jetbrains/kotlin/metadata/ProtoBuf$VersionRequirement$VersionKind;", "getLevel", "()Lkotlin/DeprecationLevel;", "getMessage", "()Ljava/lang/String;", "getVersion", "()Lorg/jetbrains/kotlin/metadata/deserialization/VersionRequirement$Version;", "toString", "Companion", "Version", "metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class VersionRequirement {
    public static final Companion Companion = null;
    private final Integer errorCode;
    private final ProtoBuf.VersionRequirement.VersionKind kind;
    private final DeprecationLevel level;
    private final String message;
    private final Version version;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000e"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/deserialization/VersionRequirement$Companion;", "", "()V", "create", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/deserialization/VersionRequirement;", "id", "", "nameResolver", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/deserialization/NameResolver;", "table", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/deserialization/VersionRequirementTable;", "", "proto", "Landroidx/room/jarjarred/kotlinx/metadata/internal/protobuf/MessageLite;", "metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r5 = new int[ProtoBuf.VersionRequirement.Level.values().length];
                r5[ProtoBuf.VersionRequirement.Level.WARNING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r5[ProtoBuf.VersionRequirement.Level.ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r5[ProtoBuf.VersionRequirement.Level.HIDDEN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                $EnumSwitchMapping$0 = r5;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final List<VersionRequirement> create(MessageLite r5, NameResolver r10, VersionRequirementTable r11) {
            Intrinsics.checkNotNullParameter(r5, "proto");
            Intrinsics.checkNotNullParameter(r10, "nameResolver");
            Intrinsics.checkNotNullParameter(r11, "table");
            if ((r5 instanceof ProtoBuf.Class) == false) goto L6;
            List<Integer> r12 = ((ProtoBuf.Class) r5).getVersionRequirementList();
        L17:
            ArrayList r13 = new ArrayList();
            Iterator<T> r14 = r12.iterator();
        L19:
            if (r14.hasNext() == false) goto L23;
            VersionRequirement r15 = VersionRequirement.Companion.create(((Integer) r14.next()).intValue(), r10, r11);
            if (r15 == null) goto L19;
            r13.add(r15);
            goto L19
        L23:
            return r13;
        L6:
            if ((r5 instanceof ProtoBuf.Constructor) == false) goto L9;
            r12 = ((ProtoBuf.Constructor) r5).getVersionRequirementList();
            goto L17
        L9:
            if ((r5 instanceof ProtoBuf.Function) == false) goto L12;
            r12 = ((ProtoBuf.Function) r5).getVersionRequirementList();
            goto L17
        L12:
            if ((r5 instanceof ProtoBuf.Property) == false) goto L15;
            r12 = ((ProtoBuf.Property) r5).getVersionRequirementList();
            goto L17
        L15:
            if ((r5 instanceof ProtoBuf.TypeAlias) == false) goto L25;
            r12 = ((ProtoBuf.TypeAlias) r5).getVersionRequirementList();
            goto L17
        L25:
            throw new IllegalStateException("Unexpected declaration: " + r5.getClass());
        }

        private Companion() {
        }

        public final VersionRequirement create(int r10, NameResolver r11, VersionRequirementTable r12) {
            Intrinsics.checkNotNullParameter(r11, "nameResolver");
            Intrinsics.checkNotNullParameter(r12, "table");
            ProtoBuf.VersionRequirement r13 = r12.get(r10);
            String r14 = null;
            if (r13 != null) goto L5;
            return null;
        L5:
            Version.Companion r15 = Version.Companion;
            if (r13.hasVersion() == false) goto L8;
            Integer r5 = Integer.valueOf(r13.getVersion());
        L10:
            if (r13.hasVersionFull() == false) goto L12;
            Integer r16 = Integer.valueOf(r13.getVersionFull());
        L13:
            Version r17 = r15.decode(r5, r16);
            ProtoBuf.VersionRequirement.Level r18 = r13.getLevel();
            Intrinsics.checkNotNull(r18);
            int r19 = WhenMappings.$EnumSwitchMapping$0[r18.ordinal()];
            if (r19 != 1) goto L16;
            DeprecationLevel r110 = DeprecationLevel.WARNING;
        L20:
            DeprecationLevel r20 = r110;
            if (r13.hasErrorCode() == false) goto L28;
            Integer r21 = Integer.valueOf(r13.getErrorCode());
        L30:
            if (r13.hasMessage() == false) goto L33;
            r14 = r11.getString(r13.getMessage());
        L33:
            return new VersionRequirement(r17, r13.getVersionKind(), r20, r21, r14);
        L28:
            r21 = null;
            goto L30
        L16:
            if (r19 != 2) goto L18;
            r110 = DeprecationLevel.ERROR;
            goto L20
        L18:
            if (r19 != 3) goto L22;
            r110 = DeprecationLevel.HIDDEN;
            goto L20
        L22:
            throw new NoWhenBranchMatchedException();
        L12:
            r16 = null;
            goto L13
        L8:
            r5 = null;
            goto L10
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J.\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00120\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00120\u0014J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\b\u0010\u001a\u001a\u00020\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u001c"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/deserialization/VersionRequirement$Version;", "", "major", "", "minor", "patch", "(III)V", "getMajor", "()I", "getMinor", "getPatch", "asString", "", "component1", "component2", "component3", "copy", "encode", "", "writeVersion", "Lkotlin/Function1;", "writeVersionFull", "equals", "", "other", "hashCode", "toString", "Companion", "metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Version {
        public static final Companion Companion = null;

        @JvmField
        public static final Version INFINITY = null;
        private static final int MAJOR_BITS = 3;
        private static final int MAJOR_MASK = 7;
        private static final int MINOR_BITS = 4;
        private static final int MINOR_MASK = 15;
        private static final int PATCH_BITS = 7;
        private static final int PATCH_MASK = 127;
        private final int major;
        private final int minor;
        private final int patch;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000fR\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/deserialization/VersionRequirement$Version$Companion;", "", "()V", "INFINITY", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/deserialization/VersionRequirement$Version;", "MAJOR_BITS", "", "MAJOR_MASK", "MINOR_BITS", "MINOR_MASK", "PATCH_BITS", "PATCH_MASK", "decode", "version", "versionFull", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lorg/jetbrains/kotlin/metadata/deserialization/VersionRequirement$Version;", "metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r5) {
                this();
            }

            public final Version decode(Integer r5, Integer r10) {
                if (r10 != null) goto L8;
                if (r5 == null) goto L7;
                return new Version(r5.intValue() & 7, (r5.intValue() >> 3) & 15, (r5.intValue() >> 7) & 127);
            L7:
                return Version.INFINITY;
            L8:
                return new Version(r10.intValue() & 255, (r10.intValue() >> 8) & 255, (r10.intValue() >> 16) & 255);
            }

            private Companion() {
            }
        }

        static {
            Companion = new Companion(null);
            INFINITY = new Version(256, 256, 256);
        }

        public Version(int r5, int r10, int r11) {
            this.major = r5;
            this.minor = r10;
            this.patch = r11;
        }

        public static /* synthetic */ Version copy$default(Version r5, int r10, int r11, int r12, int r13, Object r14) {
            if ((r13 & 1) == 0) goto L6;
            r10 = r5.major;
        L6:
            if ((r13 & 2) == 0) goto L9;
            r11 = r5.minor;
        L9:
            if ((r13 & 4) == 0) goto L12;
            r12 = r5.patch;
        L12:
            return r5.copy(r10, r11, r12);
        }

        public final String asString() {
            if (this.patch != 0) goto L6;
            StringBuilder r5 = new StringBuilder();
            r5.append(this.major);
            r5.append('.');
            int r10 = this.minor;
        L5:
            r5.append(r10);
            return r5.toString();
        L6:
            r5 = new StringBuilder();
            r5.append(this.major);
            r5.append('.');
            r5.append(this.minor);
            r5.append('.');
            r10 = this.patch;
            goto L5
        }

        public final int component1() {
            return this.major;
        }

        public final int component2() {
            return this.minor;
        }

        public final int component3() {
            return this.patch;
        }

        public final Version copy(int r5, int r10, int r11) {
            return new Version(r5, r10, r11);
        }

        public final void encode(Function1<? super Integer, Unit> r10, Function1<? super Integer, Unit> r11) {
            Intrinsics.checkNotNullParameter(r10, "writeVersion");
            Intrinsics.checkNotNullParameter(r11, "writeVersionFull");
            if (Intrinsics.areEqual(this, INFINITY) == true) goto L14;
            int r5 = this.major;
            if (r5 > 7) goto L12;
            int r12 = this.minor;
            if (r12 > 15) goto L12;
            int r13 = this.patch;
            if (r13 > 127) goto L12;
            r10.invoke(Integer.valueOf(((r12 << 3) | r5) | (r13 << 7)));
            return;
        L12:
            int r14 = (this.minor << 8) | r5;
            r11.invoke(Integer.valueOf((this.patch << 16) | r14));
            return;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Version) == true) goto L8;
            return false;
        L8:
            Version r10 = (Version) r5;
            if (this.major == r10.major) goto L12;
            return false;
        L12:
            if (this.minor == r10.minor) goto L15;
            return false;
        L15:
            if (this.patch == r10.patch) goto L17;
            return false;
        L17:
            return true;
        }

        public final int getMajor() {
            return this.major;
        }

        public final int getMinor() {
            return this.minor;
        }

        public final int getPatch() {
            return this.patch;
        }

        public int hashCode() {
            return (((this.major * 31) + this.minor) * 31) + this.patch;
        }

        public String toString() {
            return asString();
        }

        public /* synthetic */ Version(int r5, int r10, int r11, int r12, DefaultConstructorMarker r13) {
            if ((r12 & 4) == 0) goto L5;
            r11 = 0;
        L5:
            this(r5, r10, r11);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public VersionRequirement(Version r5, ProtoBuf.VersionRequirement.VersionKind r10, DeprecationLevel r11, Integer r12, String r13) {
        Intrinsics.checkNotNullParameter(r5, "version");
        Intrinsics.checkNotNullParameter(r10, "kind");
        Intrinsics.checkNotNullParameter(r11, "level");
        this.version = r5;
        this.kind = r10;
        this.level = r11;
        this.errorCode = r12;
        this.message = r13;
    }

    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public final ProtoBuf.VersionRequirement.VersionKind getKind() {
        return this.kind;
    }

    public final DeprecationLevel getLevel() {
        return this.level;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Version getVersion() {
        return this.version;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("since ");
        r5.append(this.version);
        r5.append(' ');
        r5.append(this.level);
        String r10 = "";
        if (this.errorCode == null) goto L5;
        String r11 = " error " + this.errorCode;
    L6:
        r5.append(r11);
        if (this.message == null) goto L9;
        r10 = ": " + this.message;
    L9:
        r5.append(r10);
        return r5.toString();
    L5:
        r11 = "";
        goto L6
    }
}
