package com.bytedance.ai.bridge.method.sqlite;

import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/ai/bridge/method/sqlite/SqliteActionManager$ActionType", "", "Lcom/bytedance/ai/bridge/method/sqlite/SqliteActionManager$ActionType;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum SqliteActionManager$ActionType extends Enum<SqliteActionManager$ActionType> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ SqliteActionManager$ActionType[] f1981b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1982a;

    static {
        SqliteActionManager$ActionType[] r5 = {new SqliteActionManager$ActionType("OPEN", 0, "openDb"), new SqliteActionManager$ActionType("CLOSE", 1, "closeDb"), new SqliteActionManager$ActionType("DELETE", 2, "deleteDb"), new SqliteActionManager$ActionType("EXEC", 3, "execSQL"), new SqliteActionManager$ActionType("RUN", 4, "runSQL"), new SqliteActionManager$ActionType("QUERY", 5, "query"), new SqliteActionManager$ActionType("TRANSACTION_BEGIN", 6, "beginTransaction"), new SqliteActionManager$ActionType("TRANSACTION_END", 7, "endTransaction"), new SqliteActionManager$ActionType("TRANSACTION_ROLLBACK", 8, "rollbackInTransaction")};
        f1981b = r5;
        EnumEntriesKt.enumEntries(r5);
    }

    public SqliteActionManager$ActionType(String r5, int r10, String r11) {
        super(r5, r10);
        this.f1982a = r11;
    }

    public static SqliteActionManager$ActionType valueOf(String r5) {
        return (SqliteActionManager$ActionType) Enum.valueOf(SqliteActionManager$ActionType.class, r5);
    }

    public static SqliteActionManager$ActionType[] values() {
        return (SqliteActionManager$ActionType[]) f1981b.clone();
    }
}
