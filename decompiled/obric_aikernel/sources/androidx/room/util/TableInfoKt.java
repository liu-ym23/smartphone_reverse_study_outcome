package androidx.room.util;

import android.database.Cursor;
import android.os.Build;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class TableInfoKt {
    private static final Map<String, TableInfo.Column> readColumns(SupportSQLiteDatabase r20, String r21) {
        Cursor r10 = r20.query("PRAGMA table_info(`" + r21 + "`)");
        if (Build.VERSION.SDK_INT > 15) goto L46;
    L43:
        th = move-exception;
        r10.close();
        throw th;
    L28:
        if (r10.getColumnCount() > 0) goto L32;
        Map<String, TableInfo.Column> r11 = MapsKt.emptyMap();     // Catch: Throwable -> L43
        r10.close();
        return r11;
    L32:
        int r12 = r10.getColumnIndex(ActivityLifecycle.NAME);     // Catch: Throwable -> L43
        int r13 = r10.getColumnIndex(WsConstants.KEY_CONNECTION_TYPE);     // Catch: Throwable -> L43
        int r14 = r10.getColumnIndex("notnull");     // Catch: Throwable -> L43
        int r15 = r10.getColumnIndex("pk");     // Catch: Throwable -> L43
        int r16 = r10.getColumnIndex("dflt_value");     // Catch: Throwable -> L43
        Map r17 = MapsKt.createMapBuilder();     // Catch: Throwable -> L43
    L34:
        if (r10.moveToNext() == false) goto L40;
        String r18 = r10.getString(r12);     // Catch: Throwable -> L43
        String r19 = r10.getString(r13);     // Catch: Throwable -> L43
        if (r10.getInt(r14) == 0) goto L38;
        boolean r110 = true;
    L39:
        int r111 = r10.getInt(r15);     // Catch: Throwable -> L43
        String r112 = r10.getString(r16);     // Catch: Throwable -> L43
        Intrinsics.checkNotNullExpressionValue(r18, ActivityLifecycle.NAME);     // Catch: Throwable -> L43
        Intrinsics.checkNotNullExpressionValue(r19, WsConstants.KEY_CONNECTION_TYPE);     // Catch: Throwable -> L43
        r17.put(r18, new TableInfo.Column(r18, r19, r110, r111, r112, 2));     // Catch: Throwable -> L43
        goto L34
    L38:
        r110 = false;
        goto L39
    L40:
        Map<String, TableInfo.Column> r22 = MapsKt.build(r17);     // Catch: Throwable -> L43
        r10.close();
        return r22;
    L46:
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    L6:
        if (r10.getColumnCount() > 0) goto L10;
        Map<String, TableInfo.Column> r23 = MapsKt.emptyMap();     // Catch: Throwable -> L21
        CloseableKt.closeFinally(r10, null);
        return r23;
    L10:
        int r24 = r10.getColumnIndex(ActivityLifecycle.NAME);     // Catch: Throwable -> L21
        int r113 = r10.getColumnIndex(WsConstants.KEY_CONNECTION_TYPE);     // Catch: Throwable -> L21
        int r25 = r10.getColumnIndex("notnull");     // Catch: Throwable -> L21
        int r26 = r10.getColumnIndex("pk");     // Catch: Throwable -> L21
        int r27 = r10.getColumnIndex("dflt_value");     // Catch: Throwable -> L21
        Map r114 = MapsKt.createMapBuilder();     // Catch: Throwable -> L21
    L12:
        if (r10.moveToNext() == false) goto L18;
        String r115 = r10.getString(r24);     // Catch: Throwable -> L21
        String r116 = r10.getString(r113);     // Catch: Throwable -> L21
        if (r10.getInt(r25) == 0) goto L16;
        boolean r117 = true;
    L17:
        int r118 = r10.getInt(r26);     // Catch: Throwable -> L21
        String r119 = r10.getString(r27);     // Catch: Throwable -> L21
        Intrinsics.checkNotNullExpressionValue(r115, ActivityLifecycle.NAME);     // Catch: Throwable -> L21
        Intrinsics.checkNotNullExpressionValue(r116, WsConstants.KEY_CONNECTION_TYPE);     // Catch: Throwable -> L21
        r114.put(r115, new TableInfo.Column(r115, r116, r117, r118, r119, 2));     // Catch: Throwable -> L21
        goto L12
    L16:
        r117 = false;
        goto L17
    L18:
        Map<String, TableInfo.Column> r28 = MapsKt.build(r114);     // Catch: Throwable -> L21
        CloseableKt.closeFinally(r10, null);
        return r28;
    }

    private static final List<TableInfo.ForeignKeyWithSequence> readForeignKeyFieldMappings(Cursor r11) {
        int r10 = r11.getColumnIndex(OaidModel.KEY_ID);
        int r12 = r11.getColumnIndex("seq");
        int r13 = r11.getColumnIndex("from");
        int r14 = r11.getColumnIndex(TypedValues.TransitionType.S_TO);
        List r15 = CollectionsKt.createListBuilder();
    L4:
        if (r11.moveToNext() == false) goto L7;
        int r16 = r11.getInt(r10);
        int r17 = r11.getInt(r12);
        String r18 = r11.getString(r13);
        Intrinsics.checkNotNullExpressionValue(r18, "cursor.getString(fromColumnIndex)");
        String r19 = r11.getString(r14);
        Intrinsics.checkNotNullExpressionValue(r19, "cursor.getString(toColumnIndex)");
        r15.add(new TableInfo.ForeignKeyWithSequence(r16, r17, r18, r19));
        goto L4
    L7:
        return CollectionsKt.sorted(CollectionsKt.build(r15));
    }

    private static final Set<TableInfo.ForeignKey> readForeignKeys(SupportSQLiteDatabase r22, String r23) {
        Cursor r10 = r22.query("PRAGMA foreign_key_list(`" + r23 + "`)");
        if (Build.VERSION.SDK_INT > 15) goto L65;
        int r11 = r10.getColumnIndex(OaidModel.KEY_ID);     // Catch: Throwable -> L58
        int r12 = r10.getColumnIndex("seq");     // Catch: Throwable -> L58
        int r13 = r10.getColumnIndex("table");     // Catch: Throwable -> L58
        int r14 = r10.getColumnIndex("on_delete");     // Catch: Throwable -> L58
        int r15 = r10.getColumnIndex("on_update");     // Catch: Throwable -> L58
        List<TableInfo.ForeignKeyWithSequence> r16 = readForeignKeyFieldMappings(r10);     // Catch: Throwable -> L58
        r10.moveToPosition(-1);     // Catch: Throwable -> L58
        Set r17 = SetsKt.createSetBuilder();     // Catch: Throwable -> L58
    L36:
        if (r10.moveToNext() == false) goto L55;
        if (r10.getInt(r12) != 0) goto L36;
        int r18 = r10.getInt(r11);     // Catch: Throwable -> L58
        ArrayList r19 = new ArrayList();     // Catch: Throwable -> L58
        ArrayList r110 = new ArrayList();     // Catch: Throwable -> L58
        ArrayList r111 = new ArrayList();     // Catch: Throwable -> L58
        Iterator<T> r112 = r16.iterator();     // Catch: Throwable -> L58
    L42:
        if (r112.hasNext() == false) goto L50;
        int r113 = r11;
        Object r20 = r112.next();     // Catch: Throwable -> L58
        int r114 = r12;
        if (((TableInfo.ForeignKeyWithSequence) r20).getId() != r18) goto L46;
        boolean r21 = true;
    L47:
        if (r21 == false) goto L49;
        r111.add(r20);     // Catch: Throwable -> L58
    L49:
        r11 = r113;
        r12 = r114;
        goto L42
    L46:
        r21 = false;
        goto L47
    L50:
        int r115 = r11;
        int r116 = r12;
        Iterator r24 = r111.iterator();     // Catch: Throwable -> L58
    L52:
        if (r24.hasNext() == false) goto L54;
        TableInfo.ForeignKeyWithSequence r25 = (TableInfo.ForeignKeyWithSequence) r24.next();     // Catch: Throwable -> L58
        r19.add(r25.getFrom());     // Catch: Throwable -> L58
        r110.add(r25.getTo());     // Catch: Throwable -> L58
        goto L52
    L54:
        String r117 = r10.getString(r13);     // Catch: Throwable -> L58
        Intrinsics.checkNotNullExpressionValue(r117, "cursor.getString(tableColumnIndex)");     // Catch: Throwable -> L58
        String r26 = r10.getString(r14);     // Catch: Throwable -> L58
        Intrinsics.checkNotNullExpressionValue(r26, "cursor.getString(onDeleteColumnIndex)");     // Catch: Throwable -> L58
        String r118 = r10.getString(r15);     // Catch: Throwable -> L58
        Intrinsics.checkNotNullExpressionValue(r118, "cursor.getString(onUpdateColumnIndex)");     // Catch: Throwable -> L58
        r17.add(new TableInfo.ForeignKey(r117, r26, r118, r19, r110));     // Catch: Throwable -> L58
        r11 = r115;
        r12 = r116;
        goto L36
    L55:
        Set<TableInfo.ForeignKey> r27 = SetsKt.build(r17);     // Catch: Throwable -> L58
        r10.close();
        return r27;
    L58:
        th = move-exception;
        r10.close();
        throw th;
    L65:
        int r119 = r10.getColumnIndex(OaidModel.KEY_ID);     // Catch: Throwable -> L28
        int r120 = r10.getColumnIndex("seq");     // Catch: Throwable -> L28
        int r121 = r10.getColumnIndex("table");     // Catch: Throwable -> L28
        int r28 = r10.getColumnIndex("on_delete");     // Catch: Throwable -> L28
        int r29 = r10.getColumnIndex("on_update");     // Catch: Throwable -> L28
        List<TableInfo.ForeignKeyWithSequence> r122 = readForeignKeyFieldMappings(r10);     // Catch: Throwable -> L28
        r10.moveToPosition(-1);     // Catch: Throwable -> L28
        Set r30 = SetsKt.createSetBuilder();     // Catch: Throwable -> L28
    L6:
        if (r10.moveToNext() == false) goto L25;
        if (r10.getInt(r120) != 0) goto L6;
        int r123 = r10.getInt(r119);     // Catch: Throwable -> L28
        ArrayList r124 = new ArrayList();     // Catch: Throwable -> L28
        ArrayList r31 = new ArrayList();     // Catch: Throwable -> L28
        ArrayList r32 = new ArrayList();     // Catch: Throwable -> L28
        Iterator<T> r125 = r122.iterator();     // Catch: Throwable -> L28
    L12:
        if (r125.hasNext() == false) goto L20;
        Object r33 = r125.next();     // Catch: Throwable -> L28
        int r210 = r120;
        if (((TableInfo.ForeignKeyWithSequence) r33).getId() != r123) goto L16;
        boolean r126 = true;
    L17:
        if (r126 == false) goto L19;
        r32.add(r33);     // Catch: Throwable -> L28
    L19:
        r120 = r210;
        goto L12
    L16:
        r126 = false;
        goto L17
    L20:
        int r211 = r120;
        Iterator r34 = r32.iterator();     // Catch: Throwable -> L28
    L22:
        if (r34.hasNext() == false) goto L24;
        TableInfo.ForeignKeyWithSequence r35 = (TableInfo.ForeignKeyWithSequence) r34.next();     // Catch: Throwable -> L28
        r124.add(r35.getFrom());     // Catch: Throwable -> L28
        r31.add(r35.getTo());     // Catch: Throwable -> L28
        goto L22
    L24:
        String r36 = r10.getString(r121);     // Catch: Throwable -> L28
        Intrinsics.checkNotNullExpressionValue(r36, "cursor.getString(tableColumnIndex)");     // Catch: Throwable -> L28
        String r127 = r10.getString(r28);     // Catch: Throwable -> L28
        Intrinsics.checkNotNullExpressionValue(r127, "cursor.getString(onDeleteColumnIndex)");     // Catch: Throwable -> L28
        String r128 = r10.getString(r29);     // Catch: Throwable -> L28
        Intrinsics.checkNotNullExpressionValue(r128, "cursor.getString(onUpdateColumnIndex)");     // Catch: Throwable -> L28
        r30.add(new TableInfo.ForeignKey(r36, r127, r128, r124, r31));     // Catch: Throwable -> L28
        r120 = r211;
        goto L6
    L25:
        Set<TableInfo.ForeignKey> r37 = SetsKt.build(r30);     // Catch: Throwable -> L28
        CloseableKt.closeFinally(r10, null);
        return r37;
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    }

    private static final TableInfo.Index readIndex(SupportSQLiteDatabase r18, String r19, boolean r20) {
        Cursor r10 = r18.query("PRAGMA index_xinfo(`" + r19 + "`)");
        String r11 = "DESC";
        if (Build.VERSION.SDK_INT <= 15) goto L59;
        int r12 = r10.getColumnIndex("seqno");     // Catch: Throwable -> L25
        int r13 = r10.getColumnIndex("cid");     // Catch: Throwable -> L25
        int r14 = r10.getColumnIndex(ActivityLifecycle.NAME);     // Catch: Throwable -> L25
        int r15 = r10.getColumnIndex("desc");     // Catch: Throwable -> L25
        if (r12 == (-1)) goto L23;
        if (r13 == (-1)) goto L23;
        if (r14 == (-1)) goto L23;
        if (r15 == (-1)) goto L23;
        TreeMap r16 = new TreeMap();     // Catch: Throwable -> L25
        TreeMap r17 = new TreeMap();     // Catch: Throwable -> L25
    L12:
        if (r10.moveToNext() == false) goto L21;
        if (r10.getInt(r13) < 0) goto L12;
        int r110 = r10.getInt(r12);     // Catch: Throwable -> L25
        String r111 = r10.getString(r14);     // Catch: Throwable -> L25
        if (r10.getInt(r15) <= 0) goto L19;
        String r21 = r11;
        String r112 = r21;
    L20:
        Integer r22 = Integer.valueOf(r110);     // Catch: Throwable -> L25
        Intrinsics.checkNotNullExpressionValue(r111, "columnName");     // Catch: Throwable -> L25
        r16.put(r22, r111);     // Catch: Throwable -> L25
        r17.put(Integer.valueOf(r110), r21);     // Catch: Throwable -> L25
        r12 = r12;
        r11 = r112;
        goto L12
    L19:
        r112 = r11;
        r21 = "ASC";
        goto L20
    L21:
        Collection r23 = r16.values();     // Catch: Throwable -> L25
        Intrinsics.checkNotNullExpressionValue(r23, "columnsMap.values");     // Catch: Throwable -> L25
        List r24 = CollectionsKt.toList(r23);     // Catch: Throwable -> L25
        Collection r25 = r17.values();     // Catch: Throwable -> L25
        Intrinsics.checkNotNullExpressionValue(r25, "ordersMap.values");     // Catch: Throwable -> L25
        TableInfo.Index r26 = new TableInfo.Index(r19, r20, r24, CollectionsKt.toList(r25));     // Catch: Throwable -> L25
        CloseableKt.closeFinally(r10, null);
    L51:
        return r26;
    L23:
        CloseableKt.closeFinally(r10, null);
        return null;
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    L59:
        int r27 = r10.getColumnIndex("seqno");     // Catch: Throwable -> L54
        int r28 = r10.getColumnIndex("cid");     // Catch: Throwable -> L54
        int r113 = r10.getColumnIndex(ActivityLifecycle.NAME);     // Catch: Throwable -> L54
        int r29 = r10.getColumnIndex("desc");     // Catch: Throwable -> L54
        if (r27 == (-1)) goto L52;
        if (r28 == (-1)) goto L52;
        if (r113 == (-1)) goto L52;
        if (r29 == (-1)) goto L52;
        TreeMap r114 = new TreeMap();     // Catch: Throwable -> L54
        TreeMap r115 = new TreeMap();     // Catch: Throwable -> L54
    L40:
        if (r10.moveToNext() == false) goto L49;
        if (r10.getInt(r28) < 0) goto L40;
        int r116 = r10.getInt(r27);     // Catch: Throwable -> L54
        String r117 = r10.getString(r113);     // Catch: Throwable -> L54
        int r118 = r27;
        if (r10.getInt(r29) <= 0) goto L47;
        Object r119 = "DESC";
    L48:
        Integer r30 = Integer.valueOf(r116);     // Catch: Throwable -> L54
        Intrinsics.checkNotNullExpressionValue(r117, "columnName");     // Catch: Throwable -> L54
        r114.put(r30, r117);     // Catch: Throwable -> L54
        r115.put(Integer.valueOf(r116), r119);     // Catch: Throwable -> L54
        r27 = r118;
        goto L40
    L47:
        r119 = "ASC";
        goto L48
    L49:
        Collection r31 = r114.values();     // Catch: Throwable -> L54
        Intrinsics.checkNotNullExpressionValue(r31, "columnsMap.values");     // Catch: Throwable -> L54
        List r32 = CollectionsKt.toList(r31);     // Catch: Throwable -> L54
        Collection r33 = r115.values();     // Catch: Throwable -> L54
        Intrinsics.checkNotNullExpressionValue(r33, "ordersMap.values");     // Catch: Throwable -> L54
        r26 = new TableInfo.Index(r19, r20, r32, CollectionsKt.toList(r33));     // Catch: Throwable -> L54
        r10.close();
    L52:
        r10.close();
        return null;
    L54:
        th = move-exception;
        r10.close();
        throw th;
    }

    private static final Set<TableInfo.Index> readIndices(SupportSQLiteDatabase r11, String r12) {
        Cursor r13 = r11.query("PRAGMA index_list(`" + r12 + "`)");
        if (Build.VERSION.SDK_INT > 15) goto L66;
        int r10 = r13.getColumnIndex(ActivityLifecycle.NAME);     // Catch: Throwable -> L59
        int r14 = r13.getColumnIndex("origin");     // Catch: Throwable -> L59
        int r15 = r13.getColumnIndex("unique");     // Catch: Throwable -> L59
        if (r10 == (-1)) goto L57;
        if (r14 == (-1)) goto L57;
        if (r15 == (-1)) goto L57;
        Set r16 = SetsKt.createSetBuilder();     // Catch: Throwable -> L59
    L41:
        if (r13.moveToNext() == false) goto L54;
        if (Intrinsics.areEqual("c", r13.getString(r14)) == false) goto L41;
        String r17 = r13.getString(r10);     // Catch: Throwable -> L59
        if (r13.getInt(r15) != 1) goto L48;
        boolean r18 = true;
    L49:
        Intrinsics.checkNotNullExpressionValue(r17, ActivityLifecycle.NAME);     // Catch: Throwable -> L59
        TableInfo.Index r19 = readIndex(r11, r17, r18);     // Catch: Throwable -> L59
        if (r19 == null) goto L51;
        r16.add(r19);     // Catch: Throwable -> L59
        goto L41
    L51:
        r13.close();
        return null;
    L48:
        r18 = false;
        goto L49
    L54:
        Set<TableInfo.Index> r110 = SetsKt.build(r16);     // Catch: Throwable -> L59
        r13.close();
        return r110;
    L57:
        r13.close();
        return null;
    L59:
        th = move-exception;
        r13.close();
        throw th;
    L66:
        int r20 = r13.getColumnIndex(ActivityLifecycle.NAME);     // Catch: Throwable -> L29
        int r21 = r13.getColumnIndex("origin");     // Catch: Throwable -> L29
        int r22 = r13.getColumnIndex("unique");     // Catch: Throwable -> L29
        if (r20 == (-1)) goto L27;
        if (r21 == (-1)) goto L27;
        if (r22 == (-1)) goto L27;
        Set r23 = SetsKt.createSetBuilder();     // Catch: Throwable -> L29
    L11:
        if (r13.moveToNext() == false) goto L24;
        if (Intrinsics.areEqual("c", r13.getString(r21)) == false) goto L11;
        String r24 = r13.getString(r20);     // Catch: Throwable -> L29
        if (r13.getInt(r22) != 1) goto L18;
        boolean r111 = true;
    L19:
        Intrinsics.checkNotNullExpressionValue(r24, ActivityLifecycle.NAME);     // Catch: Throwable -> L29
        TableInfo.Index r25 = readIndex(r11, r24, r111);     // Catch: Throwable -> L29
        if (r25 == null) goto L21;
        r23.add(r25);     // Catch: Throwable -> L29
        goto L11
    L21:
        CloseableKt.closeFinally(r13, null);
        return null;
    L18:
        r111 = false;
        goto L19
    L24:
        Set<TableInfo.Index> r112 = SetsKt.build(r23);     // Catch: Throwable -> L29
        CloseableKt.closeFinally(r13, null);
        return r112;
    L27:
        CloseableKt.closeFinally(r13, null);
        return null;
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        CloseableKt.closeFinally(r13, th);
        throw th;
    }

    public static final TableInfo readTableInfo(SupportSQLiteDatabase r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "database");
        Intrinsics.checkNotNullParameter(r11, "tableName");
        return new TableInfo(r11, readColumns(r10, r11), readForeignKeys(r10, r11), readIndices(r10, r11));
    }
}
