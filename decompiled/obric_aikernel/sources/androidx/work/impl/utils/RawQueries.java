package androidx.work.impl.utils;

import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.WorkInfo;
import androidx.work.WorkQuery;
import androidx.work.impl.model.WorkTypeConverters;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@JvmName(name = "RawQueries")
public final class RawQueries {
    private static final void bindings(StringBuilder r10, int r11) {
        if (r11 > 0) goto L4;
        return;
    L4:
        ArrayList r12 = new ArrayList(r11);
        int r13 = 0;
    L5:
        if (r13 >= r11) goto L7;
        r12.add("?");
        r13 = r13 + 1;
        goto L5
    L7:
        r10.append(CollectionsKt.joinToString$default(r12, ",", null, null, 0, null, null, 62, null));
    }

    public static final SupportSQLiteQuery toRawQuery(WorkQuery r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ArrayList r11 = new ArrayList();
        StringBuilder r12 = new StringBuilder("SELECT * FROM workspec");
        List<WorkInfo.State> r13 = r10.getStates();
        Intrinsics.checkNotNullExpressionValue(r13, "states");
        String r14 = " AND";
        String r15 = " WHERE";
        if ((!r13.isEmpty()) == false) goto L9;
        List<WorkInfo.State> r16 = r10.getStates();
        Intrinsics.checkNotNullExpressionValue(r16, "states");
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator<T> r18 = r16.iterator();
    L6:
        if (r18.hasNext() == false) goto L8;
        WorkInfo.State r19 = (WorkInfo.State) r18.next();
        Intrinsics.checkNotNull(r19);
        r17.add(Integer.valueOf(WorkTypeConverters.stateToInt(r19)));
        goto L6
    L8:
        r12.append(" WHERE state IN (");
        bindings(r12, r17.size());
        r12.append(")");
        r11.addAll(r17);
        r15 = " AND";
    L9:
        List<UUID> r20 = r10.getIds();
        Intrinsics.checkNotNullExpressionValue(r20, "ids");
        if ((!r20.isEmpty()) == false) goto L16;
        List<UUID> r21 = r10.getIds();
        Intrinsics.checkNotNullExpressionValue(r21, "ids");
        ArrayList r22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r21, 10));
        Iterator<T> r23 = r21.iterator();
    L13:
        if (r23.hasNext() == false) goto L15;
        r22.add(((UUID) r23.next()).toString());
        goto L13
    L15:
        r12.append(r15 + " id IN (");
        bindings(r12, r10.getIds().size());
        r12.append(")");
        r11.addAll(r22);
        r15 = " AND";
    L16:
        List<String> r24 = r10.getTags();
        Intrinsics.checkNotNullExpressionValue(r24, "tags");
        if ((!r24.isEmpty()) == false) goto L19;
        r12.append(r15 + " id IN (SELECT work_spec_id FROM worktag WHERE tag IN (");
        bindings(r12, r10.getTags().size());
        r12.append("))");
        List<String> r25 = r10.getTags();
        Intrinsics.checkNotNullExpressionValue(r25, "tags");
        r11.addAll(r25);
    L20:
        List<String> r26 = r10.getUniqueWorkNames();
        Intrinsics.checkNotNullExpressionValue(r26, "uniqueWorkNames");
        if ((!r26.isEmpty()) == false) goto L23;
        r12.append(r14 + " id IN (SELECT work_spec_id FROM workname WHERE name IN (");
        bindings(r12, r10.getUniqueWorkNames().size());
        r12.append("))");
        List<String> r27 = r10.getUniqueWorkNames();
        Intrinsics.checkNotNullExpressionValue(r27, "uniqueWorkNames");
        r11.addAll(r27);
    L23:
        r12.append(";");
        String r28 = r12.toString();
        Intrinsics.checkNotNullExpressionValue(r28, "builder.toString()");
        return new SimpleSQLiteQuery(r28, r11.toArray(new Object[0]));
    L19:
        r14 = r15;
        goto L20
    }
}
