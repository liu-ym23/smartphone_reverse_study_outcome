package androidx.room.processor;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"SQLITE_VALUE_CONSTANTS", "", "", "getSQLITE_VALUE_CONSTANTS", "()Ljava/util/List;", "room-compiler"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class FieldProcessorKt {
    private static final List<String> SQLITE_VALUE_CONSTANTS = null;

    static {
        SQLITE_VALUE_CONSTANTS = CollectionsKt.listOf(new String[]{"null", "current_time", "current_date", "current_timestamp", "true", "false"});
    }

    public static final List<String> getSQLITE_VALUE_CONSTANTS() {
        return SQLITE_VALUE_CONSTANTS;
    }
}
