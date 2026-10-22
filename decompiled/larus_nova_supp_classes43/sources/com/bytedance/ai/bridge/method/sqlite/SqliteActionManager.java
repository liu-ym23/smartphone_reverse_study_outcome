package com.bytedance.ai.bridge.method.sqlite;

import android.content.Context;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.sqliteop.AbsExecuteSqliteActionMethodIDL;
import java.util.ArrayList;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class SqliteActionManager {
    public static final SqliteActionManager a = null;
    public static final ConcurrentHashMap<String, DBOperation> b = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ai/bridge/method/sqlite/SqliteActionManager$ActionType;", "", "operation", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getOperation", "()Ljava/lang/String;", "OPEN", "CLOSE", "DELETE", "EXEC", "RUN", "QUERY", "TRANSACTION_BEGIN", "TRANSACTION_END", "TRANSACTION_ROLLBACK", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ActionType extends Enum<ActionType> {
        public static final ActionType CLOSE = null;
        public static final ActionType DELETE = null;
        public static final ActionType EXEC = null;
        public static final ActionType OPEN = null;
        public static final ActionType QUERY = null;
        public static final ActionType RUN = null;
        public static final ActionType TRANSACTION_BEGIN = null;
        public static final ActionType TRANSACTION_END = null;
        public static final ActionType TRANSACTION_ROLLBACK = null;
        public static final /* synthetic */ ActionType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String operation;

        public static EnumEntries<ActionType> getEntries() {
            return b;
        }

        static {
            ActionType r0 = new ActionType("OPEN", 0, "openDb");
            OPEN = r0;
            ActionType r1 = new ActionType("CLOSE", 1, "closeDb");
            CLOSE = r1;
            ActionType r10 = new ActionType("DELETE", 2, "deleteDb");
            DELETE = r10;
            ActionType r11 = new ActionType("EXEC", 3, "execSQL");
            EXEC = r11;
            ActionType r12 = new ActionType("RUN", 4, "runSQL");
            RUN = r12;
            ActionType r13 = new ActionType("QUERY", 5, "query");
            QUERY = r13;
            ActionType r14 = new ActionType("TRANSACTION_BEGIN", 6, "beginTransaction");
            TRANSACTION_BEGIN = r14;
            ActionType r15 = new ActionType("TRANSACTION_END", 7, "endTransaction");
            TRANSACTION_END = r15;
            ActionType r16 = new ActionType("TRANSACTION_ROLLBACK", 8, "rollbackInTransaction");
            TRANSACTION_ROLLBACK = r16;
            ActionType[] r17 = {r0, r1, r10, r11, r12, r13, r14, r15, r16};
            a = r17;
            b = EnumEntriesKt.enumEntries(r17);
        }

        public static ActionType[] values() {
            return (ActionType[]) a.clone();
        }

        public final String getOperation() {
            return this.operation;
        }

        public static ActionType valueOf(String r1) {
            return (ActionType) r27.a.a(ActionType.class, r1);
        }

        public ActionType(String r1, int r10, String r11) {
            super(r1, r10);
            this.operation = r11;
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ActionType.values().length];
            r0[ActionType.OPEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r0[ActionType.CLOSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L39:
            r0[ActionType.DELETE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L29:
            r0[ActionType.EXEC.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L31:
            r0[ActionType.RUN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L23:
            r0[ActionType.QUERY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L33:
            r0[ActionType.TRANSACTION_BEGIN.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L35:
            r0[ActionType.TRANSACTION_END.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L27:
            r0[ActionType.TRANSACTION_ROLLBACK.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L12:
            a = r0;
        }
    }

    public SqliteActionManager() {
    }

    static {
        a = new SqliteActionManager();
        b = new ConcurrentHashMap();
    }

    public static void a(Context r16, String r17, AbsExecuteSqliteActionMethodIDL.a r18, final f3.h r19) {
        Intrinsics.checkNotNullParameter(r16, "context");
        Intrinsics.checkNotNullParameter(r17, "parentFolder");
        Intrinsics.checkNotNullParameter(r18, "params");
        Intrinsics.checkNotNullParameter(r19, "callback");
        ActionType[] r10 = ActionType.values();     // Catch: IllegalArgumentException -> L86
        int r11 = r10.length;     // Catch: IllegalArgumentException -> L86
        int r12 = 0;
    L4:
        if (r12 >= r11) goto L85;
        ActionType r13 = r10[r12];     // Catch: IllegalArgumentException -> L86
        if (Intrinsics.areEqual(r13.getOperation(), r18.getAction()) == true) goto L7;
        r12 = r12 + 1;
        goto L4
    L7:
        String r14 = r17 + '-' + r18.getDbName();
        switch(a.a[r13.ordinal()]) {
            case 1: goto L78;
            case 2: goto L74;
            case 3: goto L70;
            case 4: goto L57;
            case 5: goto L40;
            case 6: goto L23;
            case 7: goto L19;
            case 8: goto L15;
            case 9: goto L11;
            default: goto L10;
        };
    L11:
        final DBOperation r0 = b.get(r14);
        if (r0 != null) goto L14;
        String r1 = "Database(" + r14 + ") is not open yet.";
        com.bytedance.ai.utils.g.a.e("ExecuteSqliteActionMethod", r1);
        f3.h.a.a(r19, r1, null, null, 14);
        return;
    L14:
        Intrinsics.checkNotNullParameter(r19, "callback");
        r0.e(r19, new f(r0, r19));
        return;
    L15:
        final DBOperation r15 = b.get(r14);
        if (r15 != null) goto L18;
        String r20 = "Database(" + r14 + ") is not open yet.";
        com.bytedance.ai.utils.g.a.e("ExecuteSqliteActionMethod", r20);
        f3.h.a.a(r19, r20, null, null, 14);
        return;
    L18:
        Intrinsics.checkNotNullParameter(r19, "callback");
        r15.e(r19, new c(r15, r19));
        return;
    L19:
        final DBOperation r21 = b.get(r14);
        if (r21 != null) goto L22;
        String r22 = "Database(" + r14 + ") is not open yet.";
        com.bytedance.ai.utils.g.a.e("ExecuteSqliteActionMethod", r22);
        f3.h.a.a(r19, r22, null, null, 14);
        return;
    L22:
        Intrinsics.checkNotNullParameter(r19, "callback");
        r21.e(r19, new b(r21, r19));
        return;
    L23:
        final DBOperation r23 = b.get(r14);
        if (r23 != null) goto L26;
        String r24 = "Database(" + r14 + ") is not open yet.";
        com.bytedance.ai.utils.g.a.e("ExecuteSqliteActionMethod", r24);
        f3.h.a.a(r19, r24, null, null, 14);
        return;
    L26:
        Map<String, Object> r25 = r18.getActionParams();
        if (r25 == null) goto L39;
        Object r26 = r25.get("sql");
        if ((r26 instanceof String) == false) goto L31;
        final String r27 = (String) r26;
    L32:
        if (r27 == null) goto L38;
        Object r28 = r25.get("args");
        if ((r28 instanceof ArrayList) == false) goto L36;
        final ArrayList r29 = (ArrayList) r28;
    L37:
        Intrinsics.checkNotNullParameter(r27, "sql");
        Intrinsics.checkNotNullParameter(r19, "callback");
        r23.e(r19, new e(r23, r27, r19, r29));
        return;
    L36:
        r29 = null;
        goto L37
    L38:
        String r30 = "invalid sql: " + r14;
        com.bytedance.ai.utils.g.a.e("ExecuteSqliteActionMethod", r30);
        f3.h.a.a(r19, r30, null, null, 14);
        return;
    L31:
        r27 = null;
        goto L32
    L39:
        String r31 = "action params is null: " + r14;
        com.bytedance.ai.utils.g.a.e("ExecuteSqliteActionMethod", r31);
        f3.h.a.a(r19, r31, null, null, 14);
        return;
    L40:
        final DBOperation r32 = b.get(r14);
        if (r32 != null) goto L43;
        String r33 = "Database(" + r14 + ") is not open yet.";
        com.bytedance.ai.utils.g.a.e("ExecuteSqliteActionMethod", r33);
        f3.h.a.a(r19, r33, null, null, 14);
        return;
    L43:
        Map<String, Object> r34 = r18.getActionParams();
        if (r34 == null) goto L56;
        Object r35 = r34.get("sql");
        if ((r35 instanceof String) == false) goto L48;
        final String r36 = (String) r35;
    L49:
        if (r36 == null) goto L55;
        Object r37 = r34.get("args");
        if ((r37 instanceof ArrayList) == false) goto L53;
        final ArrayList r38 = (ArrayList) r37;
    L54:
        Intrinsics.checkNotNullParameter(r36, "sql");
        Intrinsics.checkNotNullParameter(r19, "callback");
        r32.e(r19, new g(r32, r36, r19, r38));
        return;
    L53:
        r38 = null;
        goto L54
    L55:
        String r39 = "invalid sql: " + r14;
        com.bytedance.ai.utils.g.a.e("ExecuteSqliteActionMethod", r39);
        f3.h.a.a(r19, r39, null, null, 14);
        return;
    L48:
        r36 = null;
        goto L49
    L56:
        String r40 = "action params is null: " + r14;
        com.bytedance.ai.utils.g.a.e("ExecuteSqliteActionMethod", r40);
        f3.h.a.a(r19, r40, null, null, 14);
        return;
    L57:
        final DBOperation r41 = b.get(r14);
        if (r41 != null) goto L60;
        String r42 = "Database(" + r14 + ") is not open yet.";
        com.bytedance.ai.utils.g.a.e("ExecuteSqliteActionMethod", r42);
        f3.h.a.a(r19, r42, null, null, 14);
        return;
    L60:
        Map<String, Object> r43 = r18.getActionParams();
        if (r43 == null) goto L69;
        Object r44 = r43.get("sql");
        if ((r44 instanceof String) == false) goto L65;
        final String r45 = (String) r44;
    L66:
        if (r45 == null) goto L68;
        Intrinsics.checkNotNullParameter(r45, "rawSql");
        Intrinsics.checkNotNullParameter(r19, "callback");
        r41.e(r19, new com.bytedance.ai.bridge.method.sqlite.a(r45, r19, r41));
        return;
    L68:
        String r46 = "invalid sql: " + r14;
        com.bytedance.ai.utils.g.a.e("ExecuteSqliteActionMethod", r46);
        f3.h.a.a(r19, r46, null, null, 14);
        return;
    L65:
        r45 = null;
        goto L66
    L69:
        String r47 = "action params is null: " + r14;
        com.bytedance.ai.utils.g.a.e("ExecuteSqliteActionMethod", r47);
        f3.h.a.a(r19, r47, null, null, 14);
        return;
    L70:
        DBOperation r48 = new DBOperation(r16, r18.getDbName());
        DBOperation r49 = b.putIfAbsent(r14, r48);
        if (r49 == null) goto L73;
        j r50 = new j(r19, r14);
        Intrinsics.checkNotNullParameter(r17, "parentFolder");
        Intrinsics.checkNotNullParameter(r50, "callback");
        BuildersKt.launch$default((CoroutineScope) r49.e.getValue(), null, null, new DBOperation$deleteDatabase$1(r49, r17, r50, null), 3, null);
        return;
    L73:
        k r51 = new k(r19, r14);
        Intrinsics.checkNotNullParameter(r17, "parentFolder");
        Intrinsics.checkNotNullParameter(r51, "callback");
        BuildersKt.launch$default((CoroutineScope) r48.e.getValue(), null, null, new DBOperation$deleteDatabase$1(r48, r17, r51, null), 3, null);
        return;
    L74:
        DBOperation r52 = b.get(r14);
        if (r52 != null) goto L77;
        Intrinsics.checkNotNullParameter(AbsExecuteSqliteActionMethodIDL.b.class, "<this>");
        r19.b((ResultModel) k3.c.a(AbsExecuteSqliteActionMethodIDL.b.class), "");
        return;
    L77:
        i r53 = new i(r19, r14);
        Intrinsics.checkNotNullParameter(r53, "callback");
        BuildersKt.launch$default((CoroutineScope) r52.e.getValue(), null, null, new DBOperation$closeDatabase$1(r52, r53, null), 3, null);
        return;
    L78:
        DBOperation r54 = new DBOperation(r16, r18.getDbName());
        if (b.putIfAbsent(r14, r54) == null) goto L81;
        Intrinsics.checkNotNullParameter(AbsExecuteSqliteActionMethodIDL.b.class, "<this>");
        r19.b((ResultModel) k3.c.a(AbsExecuteSqliteActionMethodIDL.b.class), "");
        return;
    L81:
        Intrinsics.checkNotNullParameter(r17, "parentFolder");
        Intrinsics.checkNotNullParameter(r19, "callback");
        BuildersKt.launch$default((CoroutineScope) r54.e.getValue(), null, null, new DBOperation$openDatabase$1(r54, r19, r17, null), 3, null);
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    L85:
        throw new NoSuchElementException("Array contains no element matching the predicate.");     // Catch: IllegalArgumentException -> L86
    L86:
        String r55 = "invalid action: " + r18.getAction();
        com.bytedance.ai.utils.g.a.e("ExecuteSqliteActionMethod", r55);
        f3.h.a.a(r19, r55, null, null, 14);
    }
}
