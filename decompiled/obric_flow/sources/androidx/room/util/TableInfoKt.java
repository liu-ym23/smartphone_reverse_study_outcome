package androidx.room.util;

import android.database.Cursor;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.util.ArrayList;
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
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0002\u001a\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0002\u001a\"\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0002\u001a \u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0002\u001a\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0000¨\u0006\u0017"}, d2 = {"readColumns", "", "", "Landroidx/room/util/TableInfo$Column;", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "tableName", "readForeignKeyFieldMappings", "", "Landroidx/room/util/TableInfo$ForeignKeyWithSequence;", "cursor", "Landroid/database/Cursor;", "readForeignKeys", "", "Landroidx/room/util/TableInfo$ForeignKey;", "readIndex", "Landroidx/room/util/TableInfo$Index;", "name", "unique", "", "readIndices", "readTableInfo", "Landroidx/room/util/TableInfo;", "room-runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class TableInfoKt {
    private static final Map<String, TableInfo.Column> readColumns(SupportSQLiteDatabase r17, String r18) {
        Cursor r5 = r17.query("PRAGMA table_info(`" + r18 + "`)");
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);
        throw th;
    L4:
        if (r5.getColumnCount() > 0) goto L10;
        Map<String, TableInfo.Column> r10 = MapsKt.emptyMap();     // Catch: Throwable -> L8
        CloseableKt.closeFinally(r5, null);
        return r10;
    L10:
        int r11 = r5.getColumnIndex("name");     // Catch: Throwable -> L8
        int r12 = r5.getColumnIndex("type");     // Catch: Throwable -> L8
        int r13 = r5.getColumnIndex("notnull");     // Catch: Throwable -> L8
        int r14 = r5.getColumnIndex("pk");     // Catch: Throwable -> L8
        int r15 = r5.getColumnIndex("dflt_value");     // Catch: Throwable -> L8
        Map r16 = MapsKt.createMapBuilder();     // Catch: Throwable -> L8
    L12:
        if (r5.moveToNext() == false) goto L19;
        String r19 = r5.getString(r11);     // Catch: Throwable -> L8
        String r110 = r5.getString(r12);     // Catch: Throwable -> L8
        if (r5.getInt(r13) == 0) goto L17;
        boolean r20 = true;
    L18:
        r16.put(r19, new TableInfo.Column(r19, r110, r20, r5.getInt(r14), r5.getString(r15), 2));     // Catch: Throwable -> L8
        goto L12
    L17:
        r20 = false;
        goto L18
    L19:
        Map<String, TableInfo.Column> r21 = MapsKt.build(r16);     // Catch: Throwable -> L8
        CloseableKt.closeFinally(r5, null);
        return r21;
    }

    private static final List<TableInfo.ForeignKeyWithSequence> readForeignKeyFieldMappings(Cursor r10) {
        int r5 = r10.getColumnIndex("id");
        int r11 = r10.getColumnIndex("seq");
        int r12 = r10.getColumnIndex("from");
        int r13 = r10.getColumnIndex("to");
        List r14 = CollectionsKt.createListBuilder();
    L4:
        if (r10.moveToNext() == false) goto L7;
        r14.add(new TableInfo.ForeignKeyWithSequence(r10.getInt(r5), r10.getInt(r11), r10.getString(r12), r10.getString(r13)));
        goto L4
    L7:
        return CollectionsKt.sorted(CollectionsKt.build(r14));
    }

    private static final Set<TableInfo.ForeignKey> readForeignKeys(SupportSQLiteDatabase r13, String r14) {
        Cursor r15 = r13.query("PRAGMA foreign_key_list(`" + r14 + "`)");
        int r16 = r15.getColumnIndex("id");     // Catch: Throwable -> L15
        int r5 = r15.getColumnIndex("seq");     // Catch: Throwable -> L15
        int r10 = r15.getColumnIndex("table");     // Catch: Throwable -> L15
        int r11 = r15.getColumnIndex("on_delete");     // Catch: Throwable -> L15
        int r12 = r15.getColumnIndex("on_update");     // Catch: Throwable -> L15
        List<TableInfo.ForeignKeyWithSequence> r17 = readForeignKeyFieldMappings(r15);     // Catch: Throwable -> L15
        r15.moveToPosition(-1);     // Catch: Throwable -> L15
        Set r18 = SetsKt.createSetBuilder();     // Catch: Throwable -> L15
    L5:
        if (r15.moveToNext() == false) goto L22;
        if (r15.getInt(r5) != 0) goto L5;
        int r19 = r15.getInt(r16);     // Catch: Throwable -> L15
        ArrayList r110 = new ArrayList();     // Catch: Throwable -> L15
        ArrayList r111 = new ArrayList();     // Catch: Throwable -> L15
        ArrayList r20 = new ArrayList();     // Catch: Throwable -> L15
        Iterator<T> r21 = r17.iterator();     // Catch: Throwable -> L15
    L11:
        if (r21.hasNext() == false) goto L17;
        Object r22 = r21.next();     // Catch: Throwable -> L15
        if (((TableInfo.ForeignKeyWithSequence) r22).getId() != r19) goto L11;
        r20.add(r22);     // Catch: Throwable -> L15
        goto L11
    L17:
        Iterator r23 = r20.iterator();     // Catch: Throwable -> L15
    L19:
        if (r23.hasNext() == false) goto L21;
        TableInfo.ForeignKeyWithSequence r24 = (TableInfo.ForeignKeyWithSequence) r23.next();     // Catch: Throwable -> L15
        r110.add(r24.getFrom());     // Catch: Throwable -> L15
        r111.add(r24.getTo());     // Catch: Throwable -> L15
        goto L19
    L21:
        r18.add(new TableInfo.ForeignKey(r15.getString(r10), r15.getString(r11), r15.getString(r12), r110, r111));     // Catch: Throwable -> L15
        goto L5
    L22:
        Set<TableInfo.ForeignKey> r112 = SetsKt.build(r18);     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r15, null);
        return r112;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        CloseableKt.closeFinally(r15, th);
        throw th;
    }

    private static final TableInfo.Index readIndex(SupportSQLiteDatabase r11, String r12, boolean r13) {
        Cursor r14 = r11.query("PRAGMA index_xinfo(`" + r12 + "`)");
        int r5 = r14.getColumnIndex("seqno");     // Catch: Throwable -> L18
        int r10 = r14.getColumnIndex("cid");     // Catch: Throwable -> L18
        int r15 = r14.getColumnIndex("name");     // Catch: Throwable -> L18
        int r16 = r14.getColumnIndex("desc");     // Catch: Throwable -> L18
        if (r5 == (-1)) goto L25;
        if (r10 == (-1)) goto L25;
        if (r15 == (-1)) goto L25;
        if (r16 == (-1)) goto L25;
        TreeMap r17 = new TreeMap();     // Catch: Throwable -> L18
        TreeMap r18 = new TreeMap();     // Catch: Throwable -> L18
    L11:
        if (r14.moveToNext() == false) goto L22;
        if (r14.getInt(r10) < 0) goto L11;
        int r19 = r14.getInt(r5);     // Catch: Throwable -> L18
        String r20 = r14.getString(r15);     // Catch: Throwable -> L18
        if (r14.getInt(r16) <= 0) goto L20;
        String r21 = "DESC";
    L21:
        r17.put(Integer.valueOf(r19), r20);     // Catch: Throwable -> L18
        r18.put(Integer.valueOf(r19), r21);     // Catch: Throwable -> L18
        goto L11
    L20:
        r21 = "ASC";
        goto L21
    L22:
        TableInfo.Index r22 = new TableInfo.Index(r12, r13, CollectionsKt.toList(r17.values()), CollectionsKt.toList(r18.values()));     // Catch: Throwable -> L18
        CloseableKt.closeFinally(r14, null);
        return r22;
    L25:
        CloseableKt.closeFinally(r14, null);
        return null;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);
        throw th;
    }

    private static final Set<TableInfo.Index> readIndices(SupportSQLiteDatabase r10, String r11) {
        Cursor r12 = r10.query("PRAGMA index_list(`" + r11 + "`)");
        int r5 = r12.getColumnIndex("name");     // Catch: Throwable -> L23
        int r13 = r12.getColumnIndex("origin");     // Catch: Throwable -> L23
        int r14 = r12.getColumnIndex("unique");     // Catch: Throwable -> L23
        if (r5 == (-1)) goto L28;
        if (r13 == (-1)) goto L28;
        if (r14 == (-1)) goto L28;
        Set r15 = SetsKt.createSetBuilder();     // Catch: Throwable -> L23
    L10:
        if (r12.moveToNext() == false) goto L25;
        if (Intrinsics.areEqual("c", r12.getString(r13)) == false) goto L10;
        String r16 = r12.getString(r5);     // Catch: Throwable -> L23
        boolean r17 = true;
        if (r12.getInt(r14) == 1) goto L18;
        r17 = false;
    L18:
        TableInfo.Index r18 = readIndex(r10, r16, r17);     // Catch: Throwable -> L23
        if (r18 == null) goto L20;
        r15.add(r18);     // Catch: Throwable -> L23
        goto L10
    L20:
        CloseableKt.closeFinally(r12, null);
        return null;
    L25:
        Set<TableInfo.Index> r19 = SetsKt.build(r15);     // Catch: Throwable -> L23
        CloseableKt.closeFinally(r12, null);
        return r19;
    L28:
        CloseableKt.closeFinally(r12, null);
        return null;
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);
        throw th;
    }

    public static final TableInfo readTableInfo(SupportSQLiteDatabase r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "database");
        Intrinsics.checkNotNullParameter(r10, "tableName");
        return new TableInfo(r10, readColumns(r5, r10), readForeignKeys(r5, r10), readIndices(r5, r10));
    }
}
