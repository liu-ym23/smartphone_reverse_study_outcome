package androidx.room.util;

import android.database.Cursor;
import android.os.Build;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0002\u001a\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0002\u001a\"\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0002\u001a \u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0002\u001a\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0000¨\u0006\u0017"}, d2 = {"readColumns", "", "", "Landroidx/room/util/TableInfo$Column;", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "tableName", "readForeignKeyFieldMappings", "", "Landroidx/room/util/TableInfo$ForeignKeyWithSequence;", "cursor", "Landroid/database/Cursor;", "readForeignKeys", "", "Landroidx/room/util/TableInfo$ForeignKey;", "readIndex", "Landroidx/room/util/TableInfo$Index;", ActivityLifecycle.NAME, "unique", "", "readIndices", "readTableInfo", "Landroidx/room/util/TableInfo;", "room-runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class TableInfoKt {
    private static final Map<String, TableInfo.Column> readColumns(SupportSQLiteDatabase r21, String r22) {
        Cursor r2 = ((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r21, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin")).query("PRAGMA table_info(`" + r22 + "`)");
        if (Build.VERSION.SDK_INT <= 15) goto L49;
        Closeable r3 = (Closeable) ZeusTransformUtils.preCheckCast(r2, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r1 = (Cursor) ZeusTransformUtils.preCheckCast(r3, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        if (r1.getColumnCount() > 0) goto L10;
        Map<String, TableInfo.Column> r4 = MapsKt.emptyMap();     // Catch: Throwable -> L21
        CloseableKt.closeFinally(r3, null);
        return r4;
    L10:
        int r10 = r1.getColumnIndex(ActivityLifecycle.NAME);     // Catch: Throwable -> L21
        int r11 = r1.getColumnIndex("type");     // Catch: Throwable -> L21
        int r7 = r1.getColumnIndex("notnull");     // Catch: Throwable -> L21
        int r6 = r1.getColumnIndex("pk");     // Catch: Throwable -> L21
        int r5 = r1.getColumnIndex("dflt_value");     // Catch: Throwable -> L21
        Map r12 = MapsKt.createMapBuilder();     // Catch: Throwable -> L21
    L12:
        if (r1.moveToNext() == false) goto L18;
        String r13 = r1.getString(r10);     // Catch: Throwable -> L21
        String r15 = r1.getString(r11);     // Catch: Throwable -> L21
        if (r1.getInt(r7) == 0) goto L16;
        boolean r17 = true;
    L17:
        int r18 = r1.getInt(r6);     // Catch: Throwable -> L21
        String r19 = r1.getString(r5);     // Catch: Throwable -> L21
        Intrinsics.checkNotNullExpressionValue(r13, ActivityLifecycle.NAME);     // Catch: Throwable -> L21
        Intrinsics.checkNotNullExpressionValue(r15, "type");     // Catch: Throwable -> L21
        r12.put(r13, new TableInfo.Column(r13, r15, r17, r18, r19, 2));     // Catch: Throwable -> L21
        goto L12
    L16:
        r17 = false;
        goto L17
    L18:
        Map<String, TableInfo.Column> r8 = MapsKt.build(r12);     // Catch: Throwable -> L21
        CloseableKt.closeFinally(r3, null);
        return r8;
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);
        throw th;
    L49:
    L43:
        th = move-exception;
        r2.close();
        throw th;
    L28:
        if (r2.getColumnCount() > 0) goto L32;
        Map<String, TableInfo.Column> r0 = MapsKt.emptyMap();     // Catch: Throwable -> L43
        r2.close();
        return r0;
    L32:
        int r9 = r2.getColumnIndex(ActivityLifecycle.NAME);     // Catch: Throwable -> L43
        int r14 = r2.getColumnIndex("type");     // Catch: Throwable -> L43
        int r16 = r2.getColumnIndex("notnull");     // Catch: Throwable -> L43
        int r20 = r2.getColumnIndex("pk");     // Catch: Throwable -> L43
        int r23 = r2.getColumnIndex("dflt_value");     // Catch: Throwable -> L43
        Map r110 = MapsKt.createMapBuilder();     // Catch: Throwable -> L43
    L34:
        if (r2.moveToNext() == false) goto L40;
        String r111 = r2.getString(r9);     // Catch: Throwable -> L43
        String r112 = r2.getString(r14);     // Catch: Throwable -> L43
        if (r2.getInt(r16) == 0) goto L38;
        boolean r113 = true;
    L39:
        int r114 = r2.getInt(r20);     // Catch: Throwable -> L43
        String r115 = r2.getString(r23);     // Catch: Throwable -> L43
        Intrinsics.checkNotNullExpressionValue(r111, ActivityLifecycle.NAME);     // Catch: Throwable -> L43
        Intrinsics.checkNotNullExpressionValue(r112, "type");     // Catch: Throwable -> L43
        r110.put(r111, new TableInfo.Column(r111, r112, r113, r114, r115, 2));     // Catch: Throwable -> L43
        goto L34
    L38:
        r113 = false;
        goto L39
    L40:
        Map<String, TableInfo.Column> r24 = MapsKt.build(r110);     // Catch: Throwable -> L43
        r2.close();
        return r24;
    }

    private static final List<TableInfo.ForeignKeyWithSequence> readForeignKeyFieldMappings(Cursor r12) {
        Cursor r13 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r12, Cursor.class, "com.obric.memorydata.plugin");
        int r0 = r13.getColumnIndex(OaidModel.KEY_ID);
        int r2 = r13.getColumnIndex("seq");
        int r3 = r13.getColumnIndex("from");
        int r4 = r13.getColumnIndex(TypedValues.TransitionType.S_TO);
        List r5 = CollectionsKt.createListBuilder();
    L4:
        if (r13.moveToNext() == false) goto L7;
        int r7 = r13.getInt(r0);
        int r8 = r13.getInt(r2);
        String r9 = r13.getString(r3);
        Intrinsics.checkNotNullExpressionValue(r9, "cursor.getString(fromColumnIndex)");
        String r10 = r13.getString(r4);
        Intrinsics.checkNotNullExpressionValue(r10, "cursor.getString(toColumnIndex)");
        r5.add(new TableInfo.ForeignKeyWithSequence(r7, r8, r9, r10));
        goto L4
    L7:
        return CollectionsKt.sorted((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.build(r5), Iterable.class, "com.obric.memorydata.plugin"));
    }

    private static final Set<TableInfo.ForeignKey> readForeignKeys(SupportSQLiteDatabase r26, String r27) {
        Cursor r2 = ((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r26, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin")).query("PRAGMA foreign_key_list(`" + r27 + "`)");
        if (Build.VERSION.SDK_INT <= 15) goto L62;
        Closeable r3 = (Closeable) ZeusTransformUtils.preCheckCast(r2, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r14 = (Cursor) ZeusTransformUtils.preCheckCast(r3, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        int r13 = r14.getColumnIndex(OaidModel.KEY_ID);     // Catch: Throwable -> L29
        int r12 = r14.getColumnIndex("seq");     // Catch: Throwable -> L29
        int r11 = r14.getColumnIndex("table");     // Catch: Throwable -> L29
        int r10 = r14.getColumnIndex("on_delete");     // Catch: Throwable -> L29
        int r9 = r14.getColumnIndex("on_update");     // Catch: Throwable -> L29
        List<TableInfo.ForeignKeyWithSequence> r15 = readForeignKeyFieldMappings(r14);     // Catch: Throwable -> L29
        r14.moveToPosition(-1);     // Catch: Throwable -> L29
        Set r8 = SetsKt.createSetBuilder();     // Catch: Throwable -> L29
    L7:
        if (r14.moveToNext() == false) goto L26;
        if (r14.getInt(r12) != 0) goto L7;
        int r6 = r14.getInt(r13);     // Catch: Throwable -> L29
        List r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        int r23 = r12;
        List r7 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        int r24 = r13;
        List<TableInfo.ForeignKeyWithSequence> r25 = r15;
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        Iterator r18 = r16.iterator();     // Catch: Throwable -> L29
    L13:
        if (r18.hasNext() == false) goto L21;
        Object r19 = r18.next();     // Catch: Throwable -> L29
        Iterator r110 = r18;
        if (((TableInfo.ForeignKeyWithSequence) ZeusTransformUtils.preCheckCast(r19, TableInfo.ForeignKeyWithSequence.class, "com.obric.memorydata.plugin")).getId() != r6) goto L17;
        boolean r111 = true;
    L18:
        if (r111 == false) goto L20;
        r17.add(r19);     // Catch: Throwable -> L29
    L20:
        r18 = r110;
        goto L13
    L17:
        r111 = false;
        goto L18
    L21:
        Iterator r20 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L29
    L23:
        if (r20.hasNext() == false) goto L25;
        TableInfo.ForeignKeyWithSequence r112 = (TableInfo.ForeignKeyWithSequence) ZeusTransformUtils.preCheckCast(r20.next(), TableInfo.ForeignKeyWithSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        r0.add(r112.getFrom());     // Catch: Throwable -> L29
        r7.add(r112.getTo());     // Catch: Throwable -> L29
        goto L23
    L25:
        String r113 = r14.getString(r11);     // Catch: Throwable -> L29
        Intrinsics.checkNotNullExpressionValue(r113, "cursor.getString(tableColumnIndex)");     // Catch: Throwable -> L29
        String r114 = r14.getString(r10);     // Catch: Throwable -> L29
        Intrinsics.checkNotNullExpressionValue(r114, "cursor.getString(onDeleteColumnIndex)");     // Catch: Throwable -> L29
        String r115 = r14.getString(r9);     // Catch: Throwable -> L29
        Intrinsics.checkNotNullExpressionValue(r115, "cursor.getString(onUpdateColumnIndex)");     // Catch: Throwable -> L29
        r8.add(new TableInfo.ForeignKey(r113, r114, r115, r0, r7));     // Catch: Throwable -> L29
        r12 = r23;
        r13 = r24;
        r15 = r25;
        goto L7
    L26:
        Set<TableInfo.ForeignKey> r1 = SetsKt.build(r8);     // Catch: Throwable -> L29
        CloseableKt.closeFinally(r3, null);
        return r1;
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);
        throw th;
    L62:
        int r4 = r2.getColumnIndex(OaidModel.KEY_ID);     // Catch: Throwable -> L59
        int r21 = r2.getColumnIndex("seq");     // Catch: Throwable -> L59
        int r22 = r2.getColumnIndex("table");     // Catch: Throwable -> L59
        int r116 = r2.getColumnIndex("on_delete");     // Catch: Throwable -> L59
        int r28 = r2.getColumnIndex("on_update");     // Catch: Throwable -> L59
        List<TableInfo.ForeignKeyWithSequence> r117 = readForeignKeyFieldMappings(r2);     // Catch: Throwable -> L59
        r2.moveToPosition(-1);     // Catch: Throwable -> L59
        Set r29 = SetsKt.createSetBuilder();     // Catch: Throwable -> L59
    L37:
        if (r2.moveToNext() == false) goto L56;
        if (r2.getInt(r21) != 0) goto L37;
        int r118 = r2.getInt(r4);     // Catch: Throwable -> L59
        List r119 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L59
        List r120 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L59
        Iterable r121 = (Iterable) ZeusTransformUtils.preCheckCast(r117, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L59
        int r210 = r4;
        int r211 = r21;
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L59
        Iterator r30 = r121.iterator();     // Catch: Throwable -> L59
    L43:
        if (r30.hasNext() == false) goto L51;
        Object r122 = r30.next();     // Catch: Throwable -> L59
        Iterator r123 = r30;
        if (((TableInfo.ForeignKeyWithSequence) ZeusTransformUtils.preCheckCast(r122, TableInfo.ForeignKeyWithSequence.class, "com.obric.memorydata.plugin")).getId() != r118) goto L47;
        boolean r31 = true;
    L48:
        if (r31 == false) goto L50;
        r5.add(r122);     // Catch: Throwable -> L59
    L50:
        r30 = r123;
        goto L43
    L47:
        r31 = false;
        goto L48
    L51:
        Iterator r32 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L59
    L53:
        if (r32.hasNext() == false) goto L55;
        TableInfo.ForeignKeyWithSequence r33 = (TableInfo.ForeignKeyWithSequence) ZeusTransformUtils.preCheckCast(r32.next(), TableInfo.ForeignKeyWithSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L59
        r119.add(r33.getFrom());     // Catch: Throwable -> L59
        r120.add(r33.getTo());     // Catch: Throwable -> L59
        goto L53
    L55:
        String r34 = r2.getString(r22);     // Catch: Throwable -> L59
        Intrinsics.checkNotNullExpressionValue(r34, "cursor.getString(tableColumnIndex)");     // Catch: Throwable -> L59
        String r124 = r2.getString(r116);     // Catch: Throwable -> L59
        Intrinsics.checkNotNullExpressionValue(r124, "cursor.getString(onDeleteColumnIndex)");     // Catch: Throwable -> L59
        String r125 = r2.getString(r28);     // Catch: Throwable -> L59
        Intrinsics.checkNotNullExpressionValue(r125, "cursor.getString(onUpdateColumnIndex)");     // Catch: Throwable -> L59
        r29.add(new TableInfo.ForeignKey(r34, r124, r125, r119, r120));     // Catch: Throwable -> L59
        r4 = r210;
        r21 = r211;
        goto L37
    L56:
        Set<TableInfo.ForeignKey> r35 = SetsKt.build(r29);     // Catch: Throwable -> L59
        r2.close();
        return r35;
    L59:
        th = move-exception;
        r2.close();
        throw th;
    }

    private static final TableInfo.Index readIndex(SupportSQLiteDatabase r21, String r22, boolean r23) {
        Cursor r2 = ((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r21, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin")).query("PRAGMA index_xinfo(`" + r22 + "`)");
        String r7 = "DESC";
        String r8 = "ASC";
        if (Build.VERSION.SDK_INT <= 15) goto L58;
        Closeable r3 = (Closeable) ZeusTransformUtils.preCheckCast(r2, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r4 = (Cursor) ZeusTransformUtils.preCheckCast(r3, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        int r13 = r4.getColumnIndex("seqno");     // Catch: Throwable -> L26
        int r12 = r4.getColumnIndex("cid");     // Catch: Throwable -> L26
        int r11 = r4.getColumnIndex(ActivityLifecycle.NAME);     // Catch: Throwable -> L26
        int r10 = r4.getColumnIndex("desc");     // Catch: Throwable -> L26
        if (r13 == (-1)) goto L24;
        if (r12 == (-1)) goto L24;
        if (r11 == (-1)) goto L24;
        if (r10 == (-1)) goto L24;
        TreeMap r14 = new TreeMap();     // Catch: Throwable -> L26
        TreeMap r15 = new TreeMap();     // Catch: Throwable -> L26
    L13:
        if (r4.moveToNext() == false) goto L22;
        if (r4.getInt(r12) < 0) goto L13;
        int r16 = r4.getInt(r13);     // Catch: Throwable -> L26
        String r17 = r7;
        String r9 = r4.getString(r11);     // Catch: Throwable -> L26
        if (r4.getInt(r10) <= 0) goto L20;
        String r19 = r8;
        String r5 = r17;
    L21:
        Integer r18 = Integer.valueOf(r16);     // Catch: Throwable -> L26
        int r20 = r10;
        Map r110 = (Map) ZeusTransformUtils.preCheckCast(r14, Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        Intrinsics.checkNotNullExpressionValue(r9, "columnName");     // Catch: Throwable -> L26
        r110.put(r18, r9);     // Catch: Throwable -> L26
        ((Map) ZeusTransformUtils.preCheckCast(r15, Map.class, "com.obric.memorydata.plugin")).put(Integer.valueOf(r16), r5);     // Catch: Throwable -> L26
        r7 = r17;
        r4 = r4;
        r8 = r19;
        r10 = r20;
        goto L13
    L20:
        r5 = r8;
        r19 = r5;
        goto L21
    L22:
        Collection r6 = r14.values();     // Catch: Throwable -> L26
        Intrinsics.checkNotNullExpressionValue(r6, "columnsMap.values");     // Catch: Throwable -> L26
        List r24 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L26
        Collection r25 = r15.values();     // Catch: Throwable -> L26
        Intrinsics.checkNotNullExpressionValue(r25, "ordersMap.values");     // Catch: Throwable -> L26
        TableInfo.Index r26 = new TableInfo.Index(r22, r23, r24, CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r25, Iterable.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L26
        CloseableKt.closeFinally(r3, null);
    L52:
        return r26;
    L24:
        CloseableKt.closeFinally(r3, null);
        return null;
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);
        throw th;
    L58:
        int r27 = r2.getColumnIndex("seqno");     // Catch: Throwable -> L55
        int r28 = r2.getColumnIndex("cid");     // Catch: Throwable -> L55
        int r29 = r2.getColumnIndex(ActivityLifecycle.NAME);     // Catch: Throwable -> L55
        int r111 = r2.getColumnIndex("desc");     // Catch: Throwable -> L55
        if (r27 == (-1)) goto L53;
        if (r28 == (-1)) goto L53;
        if (r29 == (-1)) goto L53;
        if (r111 == (-1)) goto L53;
        TreeMap r112 = new TreeMap();     // Catch: Throwable -> L55
        TreeMap r113 = new TreeMap();     // Catch: Throwable -> L55
    L41:
        if (r2.moveToNext() == false) goto L50;
        if (r2.getInt(r28) < 0) goto L41;
        int r114 = r2.getInt(r27);     // Catch: Throwable -> L55
        String r115 = r2.getString(r29);     // Catch: Throwable -> L55
        int r116 = r27;
        if (r2.getInt(r111) <= 0) goto L48;
        Object r117 = "DESC";
    L49:
        Integer r30 = Integer.valueOf(r114);     // Catch: Throwable -> L55
        int r118 = r28;
        Map r31 = (Map) ZeusTransformUtils.preCheckCast(r112, Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L55
        Intrinsics.checkNotNullExpressionValue(r115, "columnName");     // Catch: Throwable -> L55
        r31.put(r30, r115);     // Catch: Throwable -> L55
        ((Map) ZeusTransformUtils.preCheckCast(r113, Map.class, "com.obric.memorydata.plugin")).put(Integer.valueOf(r114), r117);     // Catch: Throwable -> L55
        r27 = r116;
        r28 = r118;
        goto L41
    L48:
        r117 = "ASC";
        goto L49
    L50:
        Collection r32 = r112.values();     // Catch: Throwable -> L55
        Intrinsics.checkNotNullExpressionValue(r32, "columnsMap.values");     // Catch: Throwable -> L55
        List r33 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r32, Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L55
        Collection r34 = r113.values();     // Catch: Throwable -> L55
        Intrinsics.checkNotNullExpressionValue(r34, "ordersMap.values");     // Catch: Throwable -> L55
        r26 = new TableInfo.Index(r22, r23, r33, CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r34, Iterable.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L55
        r2.close();
    L53:
        r2.close();
        return null;
    L55:
        th = move-exception;
        r2.close();
        throw th;
    }

    private static final Set<TableInfo.Index> readIndices(SupportSQLiteDatabase r12, String r13) {
        SupportSQLiteDatabase r14 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r12, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Cursor r15 = r14.query("PRAGMA index_list(`" + r13 + "`)");
        if (Build.VERSION.SDK_INT <= 15) goto L63;
        Closeable r16 = (Closeable) ZeusTransformUtils.preCheckCast(r15, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r0 = (Cursor) ZeusTransformUtils.preCheckCast(r16, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
        int r1 = r0.getColumnIndex(ActivityLifecycle.NAME);     // Catch: Throwable -> L30
        int r5 = r0.getColumnIndex("origin");     // Catch: Throwable -> L30
        int r4 = r0.getColumnIndex("unique");     // Catch: Throwable -> L30
        if (r1 == (-1)) goto L28;
        if (r5 == (-1)) goto L28;
        if (r4 == (-1)) goto L28;
        Set r9 = SetsKt.createSetBuilder();     // Catch: Throwable -> L30
    L12:
        if (r0.moveToNext() == false) goto L25;
        if (Intrinsics.areEqual("c", r0.getString(r5)) == false) goto L12;
        String r10 = r0.getString(r1);     // Catch: Throwable -> L30
        if (r0.getInt(r4) != 1) goto L19;
        boolean r11 = true;
    L20:
        Intrinsics.checkNotNullExpressionValue(r10, ActivityLifecycle.NAME);     // Catch: Throwable -> L30
        TableInfo.Index r17 = readIndex(r14, r10, r11);     // Catch: Throwable -> L30
        if (r17 == null) goto L22;
        r9.add(r17);     // Catch: Throwable -> L30
        goto L12
    L22:
        CloseableKt.closeFinally(r16, null);
        return null;
    L19:
        r11 = false;
        goto L20
    L25:
        Set<TableInfo.Index> r18 = SetsKt.build(r9);     // Catch: Throwable -> L30
        CloseableKt.closeFinally(r16, null);
        return r18;
    L28:
        CloseableKt.closeFinally(r16, null);
        return null;
    L30:
        th = move-exception;
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        CloseableKt.closeFinally(r16, th);
        throw th;
    L63:
        int r2 = r15.getColumnIndex(ActivityLifecycle.NAME);     // Catch: Throwable -> L60
        int r3 = r15.getColumnIndex("origin");     // Catch: Throwable -> L60
        int r6 = r15.getColumnIndex("unique");     // Catch: Throwable -> L60
        if (r2 == (-1)) goto L58;
        if (r3 == (-1)) goto L58;
        if (r6 == (-1)) goto L58;
        Set r7 = SetsKt.createSetBuilder();     // Catch: Throwable -> L60
    L42:
        if (r15.moveToNext() == false) goto L55;
        if (Intrinsics.areEqual("c", r15.getString(r3)) == false) goto L42;
        String r19 = r15.getString(r2);     // Catch: Throwable -> L60
        if (r15.getInt(r6) != 1) goto L49;
        boolean r110 = true;
    L50:
        Intrinsics.checkNotNullExpressionValue(r19, ActivityLifecycle.NAME);     // Catch: Throwable -> L60
        TableInfo.Index r20 = readIndex(r14, r19, r110);     // Catch: Throwable -> L60
        if (r20 == null) goto L52;
        r7.add(r20);     // Catch: Throwable -> L60
        goto L42
    L52:
        r15.close();
        return null;
    L49:
        r110 = false;
        goto L50
    L55:
        Set<TableInfo.Index> r111 = SetsKt.build(r7);     // Catch: Throwable -> L60
        r15.close();
        return r111;
    L58:
        r15.close();
        return null;
    L60:
        th = move-exception;
        r15.close();
        throw th;
    }

    public static final TableInfo readTableInfo(SupportSQLiteDatabase r3, String r4) {
        SupportSQLiteDatabase r5 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "database");
        Intrinsics.checkNotNullParameter(r4, "tableName");
        return new TableInfo(r4, readColumns(r5, r4), readForeignKeys(r5, r4), readIndices(r5, r4));
    }
}
