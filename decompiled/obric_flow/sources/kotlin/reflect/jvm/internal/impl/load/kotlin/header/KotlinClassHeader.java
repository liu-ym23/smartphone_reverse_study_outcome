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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nKotlinClassHeader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KotlinClassHeader.kt\norg/jetbrains/kotlin/load/kotlin/header/KotlinClassHeader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,78:1\n1#2:79\n*E\n"})
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

    @SourceDebugExtension({"SMAP\nKotlinClassHeader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KotlinClassHeader.kt\norg/jetbrains/kotlin/load/kotlin/header/KotlinClassHeader$Kind\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,78:1\n8811#2,2:79\n9071#2,4:81\n*S KotlinDebug\n*F\n+ 1 KotlinClassHeader.kt\norg/jetbrains/kotlin/load/kotlin/header/KotlinClassHeader$Kind\n*L\n34#1:79,2\n34#1:81,4\n*E\n"})
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

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final int f18752id;

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r5) {
                this();
            }

            @JvmStatic
            public final Kind getById(int r5) {
                Kind r10 = (Kind) Kind.access$getEntryById$cp().get(Integer.valueOf(r5));
                if (r10 == null) goto L5;
                return r10;
            L5:
                return Kind.UNKNOWN;
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ Kind[] $values() {
            return new Kind[]{UNKNOWN, CLASS, FILE_FACADE, SYNTHETIC_CLASS, MULTIFILE_CLASS, MULTIFILE_CLASS_PART};
        }

        static {
            int r5 = 0;
            UNKNOWN = new Kind("UNKNOWN", 0, 0);
            CLASS = new Kind("CLASS", 1, 1);
            FILE_FACADE = new Kind("FILE_FACADE", 2, 2);
            SYNTHETIC_CLASS = new Kind("SYNTHETIC_CLASS", 3, 3);
            MULTIFILE_CLASS = new Kind("MULTIFILE_CLASS", 4, 4);
            MULTIFILE_CLASS_PART = new Kind("MULTIFILE_CLASS_PART", 5, 5);
            $VALUES = $values();
            Companion = new Companion(null);
            Kind[] r10 = values();
            LinkedHashMap r11 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r10.length), 16));
            int r12 = r10.length;
        L3:
            if (r5 >= r12) goto L5;
            Kind r13 = r10[r5];
            r11.put(Integer.valueOf(r13.f18752id), r13);
            r5 = r5 + 1;
            goto L3
        L5:
            entryById = r11;
        }

        private Kind(String r5, int r10, int r11) {
            super(r5, r10);
            this.f18752id = r11;
        }

        public static final /* synthetic */ Map access$getEntryById$cp() {
            return entryById;
        }

        @JvmStatic
        public static final Kind getById(int r5) {
            return Companion.getById(r5);
        }

        public static Kind valueOf(String r5) {
            return (Kind) Enum.valueOf(Kind.class, r5);
        }

        public static Kind[] values() {
            return (Kind[]) $VALUES.clone();
        }
    }

    public KotlinClassHeader(Kind r5, JvmMetadataVersion r10, String[] r11, String[] r12, String[] r13, String r14, int r15, String r16, byte[] r17) {
        Intrinsics.checkNotNullParameter(r5, "kind");
        Intrinsics.checkNotNullParameter(r10, "metadataVersion");
        this.kind = r5;
        this.metadataVersion = r10;
        this.data = r11;
        this.incompatibleData = r12;
        this.strings = r13;
        this.extraString = r14;
        this.extraInt = r15;
        this.packageName = r16;
        this.serializedIr = r17;
    }

    private final boolean has(int r5, int r10) {
        if ((r5 & r10) == 0) goto L5;
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
        String r5 = this.extraString;
        if (this.kind == Kind.MULTIFILE_CLASS_PART) goto L7;
        return null;
    L7:
        return r5;
    }

    public final List<String> getMultifilePartNames() {
        String[] r5 = this.data;
        List<String> r10 = null;
        if (this.kind == Kind.MULTIFILE_CLASS) goto L6;
        r5 = null;
    L6:
        if (r5 == null) goto L8;
        r10 = ArraysKt.asList(r5);
    L8:
        if (r10 == null) goto L10;
        return r10;
    L10:
        return CollectionsKt.emptyList();
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
