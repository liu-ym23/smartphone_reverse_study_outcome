package com.larus.avlink.gallery.database;

import android.database.Cursor;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c implements Callable<a> {
    public final /* synthetic */ RoomSQLiteQuery a;
    public final /* synthetic */ d b;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public a call() throws Exception {
        c r1 = this;
        Cursor r2 = DBUtil.query(r1.b.a, r1.a, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, "id");     // Catch: Throwable -> L69
        int r3 = CursorUtil.getColumnIndexOrThrow(r2, "media_id");     // Catch: Throwable -> L69
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "system_gallery_id");     // Catch: Throwable -> L69
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "file_name");     // Catch: Throwable -> L69
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "file_size");     // Catch: Throwable -> L69
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "media_type");     // Catch: Throwable -> L69
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "width");     // Catch: Throwable -> L69
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "height");     // Catch: Throwable -> L69
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "duration");     // Catch: Throwable -> L69
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, "out_video_width");     // Catch: Throwable -> L69
        int r13 = CursorUtil.getColumnIndexOrThrow(r2, "out_video_height");     // Catch: Throwable -> L69
        int r14 = CursorUtil.getColumnIndexOrThrow(r2, "output_video_crop");     // Catch: Throwable -> L69
        int r15 = CursorUtil.getColumnIndexOrThrow(r2, "create_time");     // Catch: Throwable -> L69
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "geo_location_info");     // Catch: Throwable -> L69
        int r16 = CursorUtil.getColumnIndexOrThrow(r2, "algorithm_type");     // Catch: Throwable -> L67
        int r17 = CursorUtil.getColumnIndexOrThrow(r2, "lifecycle_state");     // Catch: Throwable -> L67
        int r18 = CursorUtil.getColumnIndexOrThrow(r2, "failure_stage");     // Catch: Throwable -> L67
        int r19 = CursorUtil.getColumnIndexOrThrow(r2, "failure_reason");     // Catch: Throwable -> L67
        int r20 = CursorUtil.getColumnIndexOrThrow(r2, "download_file_path");     // Catch: Throwable -> L67
        int r21 = CursorUtil.getColumnIndexOrThrow(r2, "temp_file_path");     // Catch: Throwable -> L67
        int r22 = CursorUtil.getColumnIndexOrThrow(r2, "unpack_dir_path");     // Catch: Throwable -> L67
        int r23 = CursorUtil.getColumnIndexOrThrow(r2, "processed_file_path");     // Catch: Throwable -> L67
        int r24 = CursorUtil.getColumnIndexOrThrow(r2, "final_file_path");     // Catch: Throwable -> L67
        int r25 = CursorUtil.getColumnIndexOrThrow(r2, "active_mask");     // Catch: Throwable -> L67
        if (r2.moveToFirst() == true) goto L7;
        a r26 = null;
    L65:
        r2.close();
        this.a.release();
        return r26;
    L7:
        if (r2.isNull(r0) == false) goto L9;
        String r27 = null;
    L10:
        long r28 = r2.getLong(r3);     // Catch: Throwable -> L67
        if (r2.isNull(r5) == false) goto L13;
        Long r29 = null;
    L15:
        if (r2.isNull(r6) == false) goto L17;
        String r30 = null;
    L19:
        if (r2.isNull(r7) == false) goto L21;
        Long r31 = null;
    L23:
        if (r2.isNull(r8) == false) goto L25;
        String r32 = null;
    L26:
        int r33 = r2.getInt(r9);     // Catch: Throwable -> L67
        int r34 = r2.getInt(r10);     // Catch: Throwable -> L67
        long r35 = r2.getLong(r11);     // Catch: Throwable -> L67
        int r37 = r2.getInt(r12);     // Catch: Throwable -> L67
        int r38 = r2.getInt(r13);     // Catch: Throwable -> L67
        double r39 = r2.getDouble(r14);     // Catch: Throwable -> L67
        long r41 = r2.getLong(r15);     // Catch: Throwable -> L67
        if (r2.isNull(r4) == false) goto L29;
        String r43 = null;
    L31:
        if (r2.isNull(r16) == false) goto L33;
        String r44 = null;
    L34:
        int r45 = r2.getInt(r17);     // Catch: Throwable -> L67
        if (r2.isNull(r18) == false) goto L37;
        Integer r46 = null;
    L39:
        if (r2.isNull(r19) == false) goto L41;
        String r47 = null;
    L43:
        if (r2.isNull(r20) == false) goto L45;
        String r48 = null;
    L47:
        if (r2.isNull(r21) == false) goto L49;
        String r49 = null;
    L51:
        if (r2.isNull(r22) == false) goto L53;
        String r50 = null;
    L55:
        if (r2.isNull(r23) == false) goto L57;
        String r51 = null;
    L59:
        if (r2.isNull(r24) == false) goto L61;
        String r52 = null;
    L62:
        r26 = new a(r27, r28, r29, r30, r31, r32, r33, r34, r35, r37, r38, r39, r41, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r2.getInt(r25));     // Catch: Throwable -> L67
        goto L65
    L61:
        r52 = r2.getString(r24);     // Catch: Throwable -> L67
        goto L62
    L57:
        r51 = r2.getString(r23);     // Catch: Throwable -> L67
        goto L59
    L53:
        r50 = r2.getString(r22);     // Catch: Throwable -> L67
        goto L55
    L49:
        r49 = r2.getString(r21);     // Catch: Throwable -> L67
        goto L51
    L45:
        r48 = r2.getString(r20);     // Catch: Throwable -> L67
        goto L47
    L41:
        r47 = r2.getString(r19);     // Catch: Throwable -> L67
        goto L43
    L37:
        r46 = Integer.valueOf(r2.getInt(r18));     // Catch: Throwable -> L67
        goto L39
    L33:
        r44 = r2.getString(r16);     // Catch: Throwable -> L67
        goto L34
    L29:
        r43 = r2.getString(r4);     // Catch: Throwable -> L67
        goto L31
    L25:
        r32 = r2.getString(r8);     // Catch: Throwable -> L67
        goto L26
    L21:
        r31 = Long.valueOf(r2.getLong(r7));     // Catch: Throwable -> L67
        goto L23
    L17:
        r30 = r2.getString(r6);     // Catch: Throwable -> L67
        goto L19
    L13:
        r29 = Long.valueOf(r2.getLong(r5));     // Catch: Throwable -> L67
        goto L15
    L9:
        r27 = r2.getString(r0);     // Catch: Throwable -> L67
    L67:
        th = th;
        r1 = this;
    L70:
        r2.close();
        r1.a.release();
        throw th;
    L69:
        th = th;
        goto L70
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ a call() throws Exception {
        return call();
    }

    public c(d r1, RoomSQLiteQuery r2) {
        this.b = r1;
        this.a = r2;
    }
}
