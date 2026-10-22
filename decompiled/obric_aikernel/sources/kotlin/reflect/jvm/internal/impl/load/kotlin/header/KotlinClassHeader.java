package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;

/* JADX INFO: loaded from: classes3.dex */
public final class KotlinClassHeader {
    private final String[] data;
    private final int extraInt;
    private final String extraString;
    private final String[] incompatibleData;
    private final Kind kind;
    private final JvmMetadataVersion metadataVersion;
    private final String packageName;
    private final byte[] serializedIr;
    private final String[] strings;

    public static final enum Kind extends Enum<Kind> {
        private static final /* synthetic */ Kind[] $VALUES = null;
        public static final Kind CLASS = null;
        public static final Companion Companion = null;
        public static final Kind FILE_FACADE = null;
        public static final Kind MULTIFILE_CLASS = null;
        public static final Kind MULTIFILE_CLASS_PART = null;
        public static final Kind SYNTHETIC_CLASS = null;
        public static final Kind UNKNOWN = null;
        private static final Map<Integer, Kind> entryById = null;
        private final int id;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r10) {
                this();
            }

            @JvmStatic
            public final Kind getById(int r10) {
                Kind r11 = (Kind) Kind.access$getEntryById$cp().get(Integer.valueOf(r10));
                if (r11 == null) goto L5;
                return r11;
            L5:
                return Kind.UNKNOWN;
            }
        }

        private static final /* synthetic */ Kind[] $values() {
            return new Kind[]{UNKNOWN, CLASS, FILE_FACADE, SYNTHETIC_CLASS, MULTIFILE_CLASS, MULTIFILE_CLASS_PART};
        }

        static {
            int r10 = 0;
            UNKNOWN = new Kind("UNKNOWN", 0, 0);
            CLASS = new Kind("CLASS", 1, 1);
            FILE_FACADE = new Kind("FILE_FACADE", 2, 2);
            SYNTHETIC_CLASS = new Kind("SYNTHETIC_CLASS", 3, 3);
            MULTIFILE_CLASS = new Kind("MULTIFILE_CLASS", 4, 4);
            MULTIFILE_CLASS_PART = new Kind("MULTIFILE_CLASS_PART", 5, 5);
            $VALUES = $values();
            Companion = new Companion(null);
            Kind[] r11 = values();
            LinkedHashMap r12 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r11.length), 16));
            int r13 = r11.length;
        L3:
            if (r10 >= r13) goto L5;
            Kind r14 = r11[r10];
            r12.put(Integer.valueOf(r14.id), r14);
            r10 = r10 + 1;
            goto L3
        L5:
            entryById = r12;
        }

        private Kind(String r10, int r11, int r12) {
            super(r10, r11);
            this.id = r12;
        }

        public static final /* synthetic */ Map access$getEntryById$cp() {
            return entryById;
        }

        @JvmStatic
        public static final Kind getById(int r10) {
            return Companion.getById(r10);
        }

        public static Kind valueOf(String r10) {
            return (Kind) Enum.valueOf(Kind.class, r10);
        }

        public static Kind[] values() {
            return (Kind[]) $VALUES.clone();
        }
    }

    public KotlinClassHeader(Kind r10, JvmMetadataVersion r11, String[] r12, String[] r13, String[] r14, String r15, int r16, String r17, byte[] r18) {
        Intrinsics.checkNotNullParameter(r10, "kind");
        Intrinsics.checkNotNullParameter(r11, "metadataVersion");
        this.kind = r10;
        this.metadataVersion = r11;
        this.data = r12;
        this.incompatibleData = r13;
        this.strings = r14;
        this.extraString = r15;
        this.extraInt = r16;
        this.packageName = r17;
        this.serializedIr = r18;
    }

    private final boolean has(int r10, int r11) {
        if ((r10 & r11) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final String[] getData() {
        return this.data;
    }

    public final String[] getIncompatibleData() {
        return this.incompatibleData;
    }

    public final Kind getKind() {
        return this.kind;
    }

    public final JvmMetadataVersion getMetadataVersion() {
        return this.metadataVersion;
    }

    public final String getMultifileClassName() {
        String r10 = this.extraString;
        if (this.kind != Kind.MULTIFILE_CLASS_PART) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == true) goto L10;
        return null;
    L10:
        return r10;
    L5:
        r11 = false;
        goto L6
    }

    public final List<String> getMultifilePartNames() {
        String[] r10 = this.data;
        if (this.kind != Kind.MULTIFILE_CLASS) goto L5;
        boolean r11 = true;
    L6:
        List<String> r12 = null;
        if (r11 == true) goto L10;
        r10 = null;
    L10:
        if (r10 == null) goto L12;
        r12 = ArraysKt.asList(r10);
    L12:
        if (r12 == null) goto L14;
        return r12;
    L14:
        return CollectionsKt.emptyList();
    L5:
        r11 = false;
        goto L6
    }

    public final String[] getStrings() {
        return this.strings;
    }

    public final boolean isPreRelease() {
        return has(this.extraInt, 2);
    }

    public final boolean isUnstableFirBinary() {
        if (has(this.extraInt, 64) == true) goto L5;
    L7:
        return false;
    L5:
        if (has(this.extraInt, 32) == true) goto L7;
        return true;
    }

    public final boolean isUnstableJvmIrBinary() {
        if (has(this.extraInt, 16) == true) goto L5;
    L7:
        return false;
    L5:
        if (has(this.extraInt, 32) == true) goto L7;
        return true;
    }

    public String toString() {
        return this.kind + " version=" + this.metadataVersion;
    }
}
