package com.bytedance.ai.bridge.method.sqlite;

import android.app.Application;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.sqliteop.AbsExecuteSqliteActionMethodIDL;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.ArrayList;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f2004a = null;

    static {
        f2004a = new ConcurrentHashMap();
    }

    public static void a(Application r19, String r20, AbsExecuteSqliteActionMethodIDL.ExecuteSqliteActionParamsModel r21, final o1.f r22) {
        Intrinsics.checkNotNullParameter(r19, "context");
        Intrinsics.checkNotNullParameter(r20, "parentFolder");
        Intrinsics.checkNotNullParameter(r21, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r22, "callback");
        SqliteActionManager$ActionType[] r10 = SqliteActionManager$ActionType.values();     // Catch: IllegalArgumentException -> L144
        int r11 = r10.length;     // Catch: IllegalArgumentException -> L144
        int r12 = 0;
    L4:
        if (r12 >= r11) goto L143;
        SqliteActionManager$ActionType r13 = r10[r12];     // Catch: IllegalArgumentException -> L144
        if (Intrinsics.areEqual(r13.f1982a, r21.getAction()) == true) goto L7;
        r12 = r12 + 1;
        goto L4
    L7:
        String r14 = androidx.constraintlayout.motion.widget.a.m(r20, '-', r21.getDbName());
        int r15 = r13.ordinal();
        ConcurrentHashMap r16 = f2004a;
        String r5 = null;
        switch(r15) {
            case 0: goto L135;
            case 1: goto L129;
            case 2: goto L123;
            case 3: goto L98;
            case 4: goto L68;
            case 5: goto L38;
            case 6: goto L29;
            case 7: goto L20;
            case 8: goto L11;
            default: goto L10;
        };
    L11:
        final d r17 = (d) r16.get(r14);
        if (r17 != null) goto L18;
        String r18 = androidx.room.jarjarred.org.antlr.runtime.a.r("Database(", r14, ") is not open yet.", "ExecuteSqliteActionMethod", "tag");
        t0.d r23 = com.bytedance.ai.utils.c.f2846a;
        if (r23 == null) goto L16;
        r23.e("ExecuteSqliteActionMethod", r18);
    L16:
        r22.a(r18);
        return;
    L18:
        Intrinsics.checkNotNullParameter(r22, "callback");
        final int r24 = 1;
        r17.d(r22, new a(r17, r22, r24));
        return;
    L20:
        final d r25 = (d) r16.get(r14);
        if (r25 != null) goto L27;
        String r26 = androidx.room.jarjarred.org.antlr.runtime.a.r("Database(", r14, ") is not open yet.", "ExecuteSqliteActionMethod", "tag");
        t0.d r27 = com.bytedance.ai.utils.c.f2846a;
        if (r27 == null) goto L25;
        r27.e("ExecuteSqliteActionMethod", r26);
    L25:
        r22.a(r26);
        return;
    L27:
        Intrinsics.checkNotNullParameter(r22, "callback");
        final int r28 = 2;
        r25.d(r22, new a(r25, r22, r28));
        return;
    L29:
        final d r29 = (d) r16.get(r14);
        if (r29 != null) goto L36;
        String r30 = androidx.room.jarjarred.org.antlr.runtime.a.r("Database(", r14, ") is not open yet.", "ExecuteSqliteActionMethod", "tag");
        t0.d r31 = com.bytedance.ai.utils.c.f2846a;
        if (r31 == null) goto L34;
        r31.e("ExecuteSqliteActionMethod", r30);
    L34:
        r22.a(r30);
        return;
    L36:
        Intrinsics.checkNotNullParameter(r22, "callback");
        final int r32 = 0;
        r29.d(r22, new a(r29, r22, r32));
        return;
    L38:
        final d r33 = (d) r16.get(r14);
        if (r33 != null) goto L45;
        String r34 = androidx.room.jarjarred.org.antlr.runtime.a.r("Database(", r14, ") is not open yet.", "ExecuteSqliteActionMethod", "tag");
        t0.d r35 = com.bytedance.ai.utils.c.f2846a;
        if (r35 == null) goto L43;
        r35.e("ExecuteSqliteActionMethod", r34);
    L43:
        r22.a(r34);
        return;
    L45:
        Map<String, Object> r36 = r21.getActionParams();
        if (r36 == null) goto L63;
        Object r37 = r36.get("sql");
        if ((r37 instanceof String) == false) goto L50;
        final String r38 = (String) r37;
    L51:
        if (r38 == null) goto L58;
        Object r39 = r36.get("args");
        if ((r39 instanceof ArrayList) == false) goto L55;
        final ArrayList r40 = (ArrayList) r39;
    L56:
        Intrinsics.checkNotNullParameter(r38, "sql");
        Intrinsics.checkNotNullParameter(r22, "callback");
        final int r41 = 0;
        r33.d(r22, new c(r33, r38, r22, r40, r41));
        return;
    L55:
        r40 = null;
        goto L56
    L58:
        String r42 = com.lynx.tasm.behavior.utils.d.c("invalid sql: ", r14, "ExecuteSqliteActionMethod");
        t0.d r43 = com.bytedance.ai.utils.c.f2846a;
        if (r43 == null) goto L61;
        r43.e("ExecuteSqliteActionMethod", r42);
    L61:
        r22.a(r42);
        return;
    L50:
        r38 = null;
        goto L51
    L63:
        String r44 = com.lynx.tasm.behavior.utils.d.c("action params is null: ", r14, "ExecuteSqliteActionMethod");
        t0.d r45 = com.bytedance.ai.utils.c.f2846a;
        if (r45 == null) goto L66;
        r45.e("ExecuteSqliteActionMethod", r44);
    L66:
        r22.a(r44);
        return;
    L68:
        final d r46 = (d) r16.get(r14);
        if (r46 != null) goto L75;
        String r47 = androidx.room.jarjarred.org.antlr.runtime.a.r("Database(", r14, ") is not open yet.", "ExecuteSqliteActionMethod", "tag");
        t0.d r48 = com.bytedance.ai.utils.c.f2846a;
        if (r48 == null) goto L73;
        r48.e("ExecuteSqliteActionMethod", r47);
    L73:
        r22.a(r47);
        return;
    L75:
        Map<String, Object> r49 = r21.getActionParams();
        if (r49 == null) goto L93;
        Object r50 = r49.get("sql");
        if ((r50 instanceof String) == false) goto L80;
        final String r51 = (String) r50;
    L81:
        if (r51 == null) goto L88;
        Object r52 = r49.get("args");
        if ((r52 instanceof ArrayList) == false) goto L85;
        final ArrayList r53 = (ArrayList) r52;
    L86:
        Intrinsics.checkNotNullParameter(r51, "sql");
        Intrinsics.checkNotNullParameter(r22, "callback");
        final int r54 = 1;
        r46.d(r22, new c(r46, r51, r22, r53, r54));
        return;
    L85:
        r53 = null;
        goto L86
    L88:
        String r55 = com.lynx.tasm.behavior.utils.d.c("invalid sql: ", r14, "ExecuteSqliteActionMethod");
        t0.d r56 = com.bytedance.ai.utils.c.f2846a;
        if (r56 == null) goto L91;
        r56.e("ExecuteSqliteActionMethod", r55);
    L91:
        r22.a(r55);
        return;
    L80:
        r51 = null;
        goto L81
    L93:
        String r57 = com.lynx.tasm.behavior.utils.d.c("action params is null: ", r14, "ExecuteSqliteActionMethod");
        t0.d r58 = com.bytedance.ai.utils.c.f2846a;
        if (r58 == null) goto L96;
        r58.e("ExecuteSqliteActionMethod", r57);
    L96:
        r22.a(r57);
        return;
    L98:
        d r59 = (d) r16.get(r14);
        if (r59 != null) goto L105;
        String r60 = androidx.room.jarjarred.org.antlr.runtime.a.r("Database(", r14, ") is not open yet.", "ExecuteSqliteActionMethod", "tag");
        t0.d r61 = com.bytedance.ai.utils.c.f2846a;
        if (r61 == null) goto L103;
        r61.e("ExecuteSqliteActionMethod", r60);
    L103:
        r22.a(r60);
        return;
    L105:
        Map<String, Object> r62 = r21.getActionParams();
        if (r62 == null) goto L118;
        Object r63 = r62.get("sql");
        if ((r63 instanceof String) == false) goto L110;
        r5 = (String) r63;
    L110:
        if (r5 == null) goto L113;
        Intrinsics.checkNotNullParameter(r5, "rawSql");
        Intrinsics.checkNotNullParameter(r22, "callback");
        r59.d(r22, new b(r5, 0, r22, r59));
        return;
    L113:
        String r64 = com.lynx.tasm.behavior.utils.d.c("invalid sql: ", r14, "ExecuteSqliteActionMethod");
        t0.d r65 = com.bytedance.ai.utils.c.f2846a;
        if (r65 == null) goto L116;
        r65.e("ExecuteSqliteActionMethod", r64);
    L116:
        r22.a(r64);
        return;
    L118:
        String r66 = com.lynx.tasm.behavior.utils.d.c("action params is null: ", r14, "ExecuteSqliteActionMethod");
        t0.d r67 = com.bytedance.ai.utils.c.f2846a;
        if (r67 == null) goto L121;
        r67.e("ExecuteSqliteActionMethod", r66);
    L121:
        r22.a(r66);
        return;
    L123:
        d r68 = new d(r19, r21.getDbName());
        d r69 = (d) r16.putIfAbsent(r14, r68);
        if (r69 == null) goto L127;
        g r70 = new g(r22, r14);
        Intrinsics.checkNotNullParameter(r20, "parentFolder");
        Intrinsics.checkNotNullParameter(r70, "callback");
        BuildersKt.launch$default((CoroutineScope) r69.e.getValue(), null, null, new DBOperation$deleteDatabase$1(r69, r20, r70, null), 3, null);
        return;
    L127:
        h r71 = new h(r22, r14);
        Intrinsics.checkNotNullParameter(r20, "parentFolder");
        Intrinsics.checkNotNullParameter(r71, "callback");
        BuildersKt.launch$default((CoroutineScope) r68.e.getValue(), null, null, new DBOperation$deleteDatabase$1(r68, r20, r71, null), 3, null);
        return;
    L129:
        d r72 = (d) r16.get(r14);
        if (r72 != null) goto L133;
        Intrinsics.checkNotNullParameter(AbsExecuteSqliteActionMethodIDL.ExecuteSqliteActionResultModel.class, "<this>");
        r22.b((ResultModel) com.lynx.tasm.behavior.ui.utils.e.c(AbsExecuteSqliteActionMethodIDL.ExecuteSqliteActionResultModel.class), "");
        return;
    L133:
        f r73 = new f(r22, r14);
        Intrinsics.checkNotNullParameter(r73, "callback");
        BuildersKt.launch$default((CoroutineScope) r72.e.getValue(), null, null, new DBOperation$closeDatabase$1(r72, r73, null), 3, null);
        return;
    L135:
        d r110 = new d(r19, r21.getDbName());
        if (((d) r16.putIfAbsent(r14, r110)) == null) goto L139;
        Intrinsics.checkNotNullParameter(AbsExecuteSqliteActionMethodIDL.ExecuteSqliteActionResultModel.class, "<this>");
        r22.b((ResultModel) com.lynx.tasm.behavior.ui.utils.e.c(AbsExecuteSqliteActionMethodIDL.ExecuteSqliteActionResultModel.class), "");
        return;
    L139:
        Intrinsics.checkNotNullParameter(r20, "parentFolder");
        Intrinsics.checkNotNullParameter(r22, "callback");
        BuildersKt.launch$default((CoroutineScope) r110.e.getValue(), null, null, new DBOperation$openDatabase$1(r110, r22, r20, null), 3, null);
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    L143:
        throw new NoSuchElementException("Array contains no element matching the predicate.");     // Catch: IllegalArgumentException -> L144
    L144:
        String r74 = "invalid action: " + r21.getAction();
        Intrinsics.checkNotNullParameter("ExecuteSqliteActionMethod", "tag");
        t0.d r75 = com.bytedance.ai.utils.c.f2846a;
        if (r75 == null) goto L147;
        r75.e("ExecuteSqliteActionMethod", r74);
    L147:
        r22.a(r74);
    }
}
