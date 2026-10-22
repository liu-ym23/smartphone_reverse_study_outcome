package com.larus.avlink.gallery.database;

import android.database.Cursor;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o implements Callable<i> {
    public final /* synthetic */ RoomSQLiteQuery a;
    public final /* synthetic */ k b;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public i call() throws Exception {
        o r1 = this;
        Cursor r2 = DBUtil.query(r1.b.a, r1.a, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, "id");     // Catch: Throwable -> L45
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "file_path");     // Catch: Throwable -> L45
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "file_name");     // Catch: Throwable -> L45
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "file_size");     // Catch: Throwable -> L45
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "sn");     // Catch: Throwable -> L45
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "image_uuid");     // Catch: Throwable -> L45
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "media_type");     // Catch: Throwable -> L45
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "width");     // Catch: Throwable -> L45
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, "height");     // Catch: Throwable -> L45
        int r13 = CursorUtil.getColumnIndexOrThrow(r2, "duration");     // Catch: Throwable -> L45
        int r14 = CursorUtil.getColumnIndexOrThrow(r2, "create_time");     // Catch: Throwable -> L45
        int r15 = CursorUtil.getColumnIndexOrThrow(r2, "modify_time");     // Catch: Throwable -> L45
        int r3 = CursorUtil.getColumnIndexOrThrow(r2, "download_time");     // Catch: Throwable -> L45
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "geo_location_info");     // Catch: Throwable -> L45
        int r16 = CursorUtil.getColumnIndexOrThrow(r2, "source_type");     // Catch: Throwable -> L43
        int r17 = CursorUtil.getColumnIndexOrThrow(r2, "processing_status");     // Catch: Throwable -> L43
        int r18 = CursorUtil.getColumnIndexOrThrow(r2, "is_synced");     // Catch: Throwable -> L43
        if (r2.moveToFirst() == true) goto L7;
        i r19 = null;
    L41:
        r2.close();
        this.a.release();
        return r19;
    L7:
        if (r2.isNull(r0) == false) goto L9;
        String r110 = null;
    L11:
        if (r2.isNull(r5) == false) goto L13;
        String r20 = null;
    L15:
        if (r2.isNull(r6) == false) goto L17;
        String r21 = null;
    L18:
        long r22 = r2.getLong(r7);     // Catch: Throwable -> L43
        if (r2.isNull(r8) == false) goto L21;
        String r24 = null;
    L22:
        long r25 = r2.getLong(r9);     // Catch: Throwable -> L43
        if (r2.isNull(r10) == false) goto L25;
        String r27 = null;
    L26:
        int r28 = r2.getInt(r11);     // Catch: Throwable -> L43
        int r29 = r2.getInt(r12);     // Catch: Throwable -> L43
        long r30 = r2.getLong(r13);     // Catch: Throwable -> L43
        long r32 = r2.getLong(r14);     // Catch: Throwable -> L43
        long r34 = r2.getLong(r15);     // Catch: Throwable -> L43
        long r36 = r2.getLong(r3);     // Catch: Throwable -> L43
        if (r2.isNull(r4) == false) goto L29;
        String r38 = null;
    L31:
        if (r2.isNull(r16) == false) goto L33;
        String r39 = null;
    L34:
        int r40 = r2.getInt(r17);     // Catch: Throwable -> L43
        if (r2.getInt(r18) == 0) goto L37;
        boolean r41 = true;
    L38:
        r19 = new i(r110, r20, r21, r22, r24, r25, r27, r28, r29, r30, r32, r34, r36, r38, r39, r40, r41);     // Catch: Throwable -> L43
        goto L41
    L37:
        r41 = false;
        goto L38
    L33:
        r39 = r2.getString(r16);     // Catch: Throwable -> L43
        goto L34
    L29:
        r38 = r2.getString(r4);     // Catch: Throwable -> L43
        goto L31
    L25:
        r27 = r2.getString(r10);     // Catch: Throwable -> L43
        goto L26
    L21:
        r24 = r2.getString(r8);     // Catch: Throwable -> L43
        goto L22
    L17:
        r21 = r2.getString(r6);     // Catch: Throwable -> L43
        goto L18
    L13:
        r20 = r2.getString(r5);     // Catch: Throwable -> L43
        goto L15
    L9:
        r110 = r2.getString(r0);     // Catch: Throwable -> L43
    L43:
        th = th;
        r1 = this;
    L46:
        r2.close();
        r1.a.release();
        throw th;
    L45:
        th = th;
        goto L46
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ i call() throws Exception {
        return call();
    }

    public o(k r1, RoomSQLiteQuery r2) {
        this.b = r1;
        this.a = r2;
    }
}
