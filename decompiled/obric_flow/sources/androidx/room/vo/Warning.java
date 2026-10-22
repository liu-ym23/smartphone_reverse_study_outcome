package androidx.room.vo;

import androidx.room.RoomWarnings;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\b\u0086\u0001\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001d¨\u0006\u001f"}, d2 = {"Landroidx/room/vo/Warning;", "", "publicKey", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getPublicKey", "()Ljava/lang/String;", "ALL", "CURSOR_MISMATCH", "DOES_NOT_IMPLEMENT_EQUALS_HASHCODE", "MISSING_JAVA_TMP_DIR", "CANNOT_CREATE_VERIFICATION_DATABASE", "PRIMARY_KEY_FROM_EMBEDDED_IS_DROPPED", "INDEX_FROM_EMBEDDED_FIELD_IS_DROPPED", "INDEX_FROM_EMBEDDED_ENTITY_IS_DROPPED", "INDEX_FROM_PARENT_IS_DROPPED", "INDEX_FROM_PARENT_FIELD_IS_DROPPED", "RELATION_TYPE_MISMATCH", "MISSING_SCHEMA_LOCATION", "MISSING_INDEX_ON_FOREIGN_KEY_CHILD", "RELATION_QUERY_WITHOUT_TRANSACTION", "DEFAULT_CONSTRUCTOR", "MISSING_COPY_ANNOTATIONS", RoomWarnings.MISSING_INDEX_ON_JUNCTION, "JDK_VERSION_HAS_BUG", "MISMATCHED_GETTER_TYPE", "MISMATCHED_SETTER_TYPE", "EXPAND_PROJECTION_WITH_REMOVE_UNUSED_COLUMNS", "JVM_NAME_ON_OVERRIDDEN_METHOD", "AMBIGUOUS_COLUMN_IN_RESULT", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum Warning extends Enum<Warning> {
    private static final /* synthetic */ Warning[] $VALUES = null;
    public static final Warning ALL = null;
    public static final Warning AMBIGUOUS_COLUMN_IN_RESULT = null;
    public static final Warning CANNOT_CREATE_VERIFICATION_DATABASE = null;
    public static final Warning CURSOR_MISMATCH = null;
    public static final Companion Companion = null;
    public static final Warning DEFAULT_CONSTRUCTOR = null;
    public static final Warning DOES_NOT_IMPLEMENT_EQUALS_HASHCODE = null;
    public static final Warning EXPAND_PROJECTION_WITH_REMOVE_UNUSED_COLUMNS = null;
    public static final Warning INDEX_FROM_EMBEDDED_ENTITY_IS_DROPPED = null;
    public static final Warning INDEX_FROM_EMBEDDED_FIELD_IS_DROPPED = null;
    public static final Warning INDEX_FROM_PARENT_FIELD_IS_DROPPED = null;
    public static final Warning INDEX_FROM_PARENT_IS_DROPPED = null;
    public static final Warning JDK_VERSION_HAS_BUG = null;
    public static final Warning JVM_NAME_ON_OVERRIDDEN_METHOD = null;
    public static final Warning MISMATCHED_GETTER_TYPE = null;
    public static final Warning MISMATCHED_SETTER_TYPE = null;
    public static final Warning MISSING_COPY_ANNOTATIONS = null;
    public static final Warning MISSING_INDEX_ON_FOREIGN_KEY_CHILD = null;
    public static final Warning MISSING_INDEX_ON_JUNCTION = null;
    public static final Warning MISSING_JAVA_TMP_DIR = null;
    public static final Warning MISSING_SCHEMA_LOCATION = null;
    public static final Warning PRIMARY_KEY_FROM_EMBEDDED_IS_DROPPED = null;
    private static final Map<String, Warning> PUBLIC_KEY_MAP = null;
    public static final Warning RELATION_QUERY_WITHOUT_TRANSACTION = null;
    public static final Warning RELATION_TYPE_MISMATCH = null;
    private final String publicKey;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u0005R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Landroidx/room/vo/Warning$Companion;", "", "()V", "PUBLIC_KEY_MAP", "", "", "Landroidx/room/vo/Warning;", "getPUBLIC_KEY_MAP", "()Ljava/util/Map;", "fromPublicKey", "publicKey", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final Warning fromPublicKey(String r5) {
            Intrinsics.checkNotNullParameter(r5, "publicKey");
            return getPUBLIC_KEY_MAP().get(r5.toUpperCase(Locale.US));
        }

        public final Map<String, Warning> getPUBLIC_KEY_MAP() {
            return Warning.access$getPUBLIC_KEY_MAP$cp();
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ Warning[] $values() {
        return new Warning[]{ALL, CURSOR_MISMATCH, DOES_NOT_IMPLEMENT_EQUALS_HASHCODE, MISSING_JAVA_TMP_DIR, CANNOT_CREATE_VERIFICATION_DATABASE, PRIMARY_KEY_FROM_EMBEDDED_IS_DROPPED, INDEX_FROM_EMBEDDED_FIELD_IS_DROPPED, INDEX_FROM_EMBEDDED_ENTITY_IS_DROPPED, INDEX_FROM_PARENT_IS_DROPPED, INDEX_FROM_PARENT_FIELD_IS_DROPPED, RELATION_TYPE_MISMATCH, MISSING_SCHEMA_LOCATION, MISSING_INDEX_ON_FOREIGN_KEY_CHILD, RELATION_QUERY_WITHOUT_TRANSACTION, DEFAULT_CONSTRUCTOR, MISSING_COPY_ANNOTATIONS, MISSING_INDEX_ON_JUNCTION, JDK_VERSION_HAS_BUG, MISMATCHED_GETTER_TYPE, MISMATCHED_SETTER_TYPE, EXPAND_PROJECTION_WITH_REMOVE_UNUSED_COLUMNS, JVM_NAME_ON_OVERRIDDEN_METHOD, AMBIGUOUS_COLUMN_IN_RESULT};
    }

    static {
        int r5 = 0;
        ALL = new Warning("ALL", 0, "ALL");
        CURSOR_MISMATCH = new Warning("CURSOR_MISMATCH", 1, RoomWarnings.CURSOR_MISMATCH);
        DOES_NOT_IMPLEMENT_EQUALS_HASHCODE = new Warning("DOES_NOT_IMPLEMENT_EQUALS_HASHCODE", 2, RoomWarnings.DOES_NOT_IMPLEMENT_EQUALS_HASHCODE);
        MISSING_JAVA_TMP_DIR = new Warning("MISSING_JAVA_TMP_DIR", 3, RoomWarnings.MISSING_JAVA_TMP_DIR);
        CANNOT_CREATE_VERIFICATION_DATABASE = new Warning("CANNOT_CREATE_VERIFICATION_DATABASE", 4, RoomWarnings.CANNOT_CREATE_VERIFICATION_DATABASE);
        PRIMARY_KEY_FROM_EMBEDDED_IS_DROPPED = new Warning("PRIMARY_KEY_FROM_EMBEDDED_IS_DROPPED", 5, RoomWarnings.PRIMARY_KEY_FROM_EMBEDDED_IS_DROPPED);
        INDEX_FROM_EMBEDDED_FIELD_IS_DROPPED = new Warning("INDEX_FROM_EMBEDDED_FIELD_IS_DROPPED", 6, RoomWarnings.INDEX_FROM_EMBEDDED_FIELD_IS_DROPPED);
        INDEX_FROM_EMBEDDED_ENTITY_IS_DROPPED = new Warning("INDEX_FROM_EMBEDDED_ENTITY_IS_DROPPED", 7, RoomWarnings.INDEX_FROM_EMBEDDED_ENTITY_IS_DROPPED);
        INDEX_FROM_PARENT_IS_DROPPED = new Warning("INDEX_FROM_PARENT_IS_DROPPED", 8, RoomWarnings.INDEX_FROM_PARENT_IS_DROPPED);
        INDEX_FROM_PARENT_FIELD_IS_DROPPED = new Warning("INDEX_FROM_PARENT_FIELD_IS_DROPPED", 9, RoomWarnings.INDEX_FROM_PARENT_FIELD_IS_DROPPED);
        RELATION_TYPE_MISMATCH = new Warning("RELATION_TYPE_MISMATCH", 10, RoomWarnings.RELATION_TYPE_MISMATCH);
        MISSING_SCHEMA_LOCATION = new Warning("MISSING_SCHEMA_LOCATION", 11, RoomWarnings.MISSING_SCHEMA_LOCATION);
        MISSING_INDEX_ON_FOREIGN_KEY_CHILD = new Warning("MISSING_INDEX_ON_FOREIGN_KEY_CHILD", 12, RoomWarnings.MISSING_INDEX_ON_FOREIGN_KEY_CHILD);
        RELATION_QUERY_WITHOUT_TRANSACTION = new Warning("RELATION_QUERY_WITHOUT_TRANSACTION", 13, RoomWarnings.RELATION_QUERY_WITHOUT_TRANSACTION);
        DEFAULT_CONSTRUCTOR = new Warning("DEFAULT_CONSTRUCTOR", 14, RoomWarnings.DEFAULT_CONSTRUCTOR);
        MISSING_COPY_ANNOTATIONS = new Warning("MISSING_COPY_ANNOTATIONS", 15, "MISSING_COPY_ANNOTATIONS");
        MISSING_INDEX_ON_JUNCTION = new Warning(RoomWarnings.MISSING_INDEX_ON_JUNCTION, 16, RoomWarnings.MISSING_INDEX_ON_JUNCTION);
        JDK_VERSION_HAS_BUG = new Warning("JDK_VERSION_HAS_BUG", 17, "JDK_VERSION_HAS_BUG");
        MISMATCHED_GETTER_TYPE = new Warning("MISMATCHED_GETTER_TYPE", 18, RoomWarnings.MISMATCHED_GETTER);
        MISMATCHED_SETTER_TYPE = new Warning("MISMATCHED_SETTER_TYPE", 19, RoomWarnings.MISMATCHED_SETTER);
        EXPAND_PROJECTION_WITH_REMOVE_UNUSED_COLUMNS = new Warning("EXPAND_PROJECTION_WITH_REMOVE_UNUSED_COLUMNS", 20, "ROOM_EXPAND_PROJECTION_WITH_UNUSED_COLUMNS");
        JVM_NAME_ON_OVERRIDDEN_METHOD = new Warning("JVM_NAME_ON_OVERRIDDEN_METHOD", 21, "ROOM_JVM_NAME_IN_OVERRIDDEN_METHOD");
        AMBIGUOUS_COLUMN_IN_RESULT = new Warning("AMBIGUOUS_COLUMN_IN_RESULT", 22, RoomWarnings.AMBIGUOUS_COLUMN_IN_RESULT);
        $VALUES = $values();
        Companion = new Companion(null);
        Warning[] r10 = values();
        LinkedHashMap r11 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r10.length), 16));
        int r12 = r10.length;
    L3:
        if (r5 >= r12) goto L5;
        Warning r13 = r10[r5];
        r11.put(r13.publicKey, r13);
        r5 = r5 + 1;
        goto L3
    L5:
        PUBLIC_KEY_MAP = r11;
    }

    private Warning(String r5, int r10, String r11) {
        super(r5, r10);
        this.publicKey = r11;
    }

    public static final /* synthetic */ Map access$getPUBLIC_KEY_MAP$cp() {
        return PUBLIC_KEY_MAP;
    }

    public static Warning valueOf(String r5) {
        return (Warning) Enum.valueOf(Warning.class, r5);
    }

    public static Warning[] values() {
        return (Warning[]) $VALUES.clone();
    }

    public final String getPublicKey() {
        return this.publicKey;
    }
}
