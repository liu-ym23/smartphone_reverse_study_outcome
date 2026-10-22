package com.larus.avlink.gallery.database;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d implements com.larus.avlink.gallery.database.b {
    public final RoomDatabase a;
    public final com.larus.avlink.gallery.database.e b;
    public final com.larus.avlink.gallery.database.f c;
    public final com.larus.avlink.gallery.database.g d;
    public final com.larus.avlink.gallery.database.h e;

    public class a implements Callable<List<com.larus.avlink.gallery.database.a>> {
        public final /* synthetic */ RoomSQLiteQuery a;
        public final /* synthetic */ d b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public List<com.larus.avlink.gallery.database.a> call2() throws Exception {
            Cursor r2 = DBUtil.query(this.b.a, this.a, false, null);
            int r0 = CursorUtil.getColumnIndexOrThrow(r2, "id");     // Catch: Throwable -> L71
            int r3 = CursorUtil.getColumnIndexOrThrow(r2, "media_id");     // Catch: Throwable -> L71
            int r5 = CursorUtil.getColumnIndexOrThrow(r2, "system_gallery_id");     // Catch: Throwable -> L71
            int r6 = CursorUtil.getColumnIndexOrThrow(r2, "file_name");     // Catch: Throwable -> L71
            int r7 = CursorUtil.getColumnIndexOrThrow(r2, "file_size");     // Catch: Throwable -> L71
            int r8 = CursorUtil.getColumnIndexOrThrow(r2, "media_type");     // Catch: Throwable -> L71
            int r9 = CursorUtil.getColumnIndexOrThrow(r2, "width");     // Catch: Throwable -> L71
            int r10 = CursorUtil.getColumnIndexOrThrow(r2, "height");     // Catch: Throwable -> L71
            int r11 = CursorUtil.getColumnIndexOrThrow(r2, "duration");     // Catch: Throwable -> L71
            int r12 = CursorUtil.getColumnIndexOrThrow(r2, "out_video_width");     // Catch: Throwable -> L71
            int r13 = CursorUtil.getColumnIndexOrThrow(r2, "out_video_height");     // Catch: Throwable -> L71
            int r14 = CursorUtil.getColumnIndexOrThrow(r2, "output_video_crop");     // Catch: Throwable -> L71
            int r15 = CursorUtil.getColumnIndexOrThrow(r2, "create_time");     // Catch: Throwable -> L71
            int r4 = CursorUtil.getColumnIndexOrThrow(r2, "geo_location_info");     // Catch: Throwable -> L71
            int r16 = CursorUtil.getColumnIndexOrThrow(r2, "algorithm_type");     // Catch: Throwable -> L69
            int r17 = CursorUtil.getColumnIndexOrThrow(r2, "lifecycle_state");     // Catch: Throwable -> L69
            int r18 = CursorUtil.getColumnIndexOrThrow(r2, "failure_stage");     // Catch: Throwable -> L69
            int r19 = CursorUtil.getColumnIndexOrThrow(r2, "failure_reason");     // Catch: Throwable -> L69
            int r20 = CursorUtil.getColumnIndexOrThrow(r2, "download_file_path");     // Catch: Throwable -> L69
            int r21 = CursorUtil.getColumnIndexOrThrow(r2, "temp_file_path");     // Catch: Throwable -> L69
            int r22 = CursorUtil.getColumnIndexOrThrow(r2, "unpack_dir_path");     // Catch: Throwable -> L69
            int r23 = CursorUtil.getColumnIndexOrThrow(r2, "processed_file_path");     // Catch: Throwable -> L69
            int r24 = CursorUtil.getColumnIndexOrThrow(r2, "final_file_path");     // Catch: Throwable -> L69
            int r25 = CursorUtil.getColumnIndexOrThrow(r2, "active_mask");     // Catch: Throwable -> L69
            int r26 = r4;
            ArrayList r1 = new ArrayList(r2.getCount());     // Catch: Throwable -> L69
        L5:
            if (r2.moveToNext() == false) goto L67;
            if (r2.isNull(r0) == false) goto L10;
            String r28 = null;
        L11:
            long r29 = r2.getLong(r3);     // Catch: Throwable -> L69
            if (r2.isNull(r5) == false) goto L14;
            Long r31 = null;
        L16:
            if (r2.isNull(r6) == false) goto L18;
            String r32 = null;
        L20:
            if (r2.isNull(r7) == false) goto L22;
            Long r33 = null;
        L24:
            if (r2.isNull(r8) == false) goto L26;
            String r34 = null;
        L27:
            int r35 = r2.getInt(r9);     // Catch: Throwable -> L69
            int r36 = r2.getInt(r10);     // Catch: Throwable -> L69
            long r37 = r2.getLong(r11);     // Catch: Throwable -> L69
            int r39 = r2.getInt(r12);     // Catch: Throwable -> L69
            int r40 = r2.getInt(r13);     // Catch: Throwable -> L69
            double r41 = r2.getDouble(r14);     // Catch: Throwable -> L69
            long r43 = r2.getLong(r15);     // Catch: Throwable -> L69
            int r27 = r26;
            if (r2.isNull(r27) == false) goto L31;
            String r45 = null;
        L30:
            int r56 = r16;
            int r110 = r0;
            if (r2.isNull(r56) == false) goto L36;
            String r46 = null;
        L35:
            int r57 = r17;
            int r47 = r2.getInt(r57);     // Catch: Throwable -> L69
            r18 = r18;
            if (r2.isNull(r18) == false) goto L40;
            Integer r48 = null;
        L42:
            if (r2.isNull(r19) == false) goto L44;
            String r49 = null;
        L46:
            if (r2.isNull(r20) == false) goto L48;
            String r50 = null;
        L50:
            if (r2.isNull(r21) == false) goto L52;
            String r51 = null;
        L54:
            if (r2.isNull(r22) == false) goto L56;
            String r52 = null;
        L58:
            if (r2.isNull(r23) == false) goto L60;
            String r53 = null;
        L62:
            if (r2.isNull(r24) == false) goto L64;
            String r54 = null;
        L65:
            int r55 = r2.getInt(r25);     // Catch: Throwable -> L69
            r25 = r25;
            r1.add(new com.larus.avlink.gallery.database.a(r28, r29, r31, r32, r33, r34, r35, r36, r37, r39, r40, r41, r43, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55));     // Catch: Throwable -> L69
            r0 = r110;
            r16 = r56;
            r17 = r57;
            r26 = r27;
            goto L5
        L64:
            r54 = r2.getString(r24);     // Catch: Throwable -> L69
            goto L65
        L60:
            r53 = r2.getString(r23);     // Catch: Throwable -> L69
            goto L62
        L56:
            r52 = r2.getString(r22);     // Catch: Throwable -> L69
            goto L58
        L52:
            r51 = r2.getString(r21);     // Catch: Throwable -> L69
            goto L54
        L48:
            r50 = r2.getString(r20);     // Catch: Throwable -> L69
            goto L50
        L44:
            r49 = r2.getString(r19);     // Catch: Throwable -> L69
            goto L46
        L40:
            r48 = Integer.valueOf(r2.getInt(r18));     // Catch: Throwable -> L69
            goto L42
        L36:
            r46 = r2.getString(r56);     // Catch: Throwable -> L69
            goto L35
        L31:
            r45 = r2.getString(r27);     // Catch: Throwable -> L69
            goto L30
        L26:
            r34 = r2.getString(r8);     // Catch: Throwable -> L69
            goto L27
        L22:
            r33 = Long.valueOf(r2.getLong(r7));     // Catch: Throwable -> L69
            goto L24
        L18:
            r32 = r2.getString(r6);     // Catch: Throwable -> L69
            goto L20
        L14:
            r31 = Long.valueOf(r2.getLong(r5));     // Catch: Throwable -> L69
            goto L16
        L10:
            r28 = r2.getString(r0);     // Catch: Throwable -> L69
            goto L11
        L67:
            r2.close();
            this.a.release();
            return r1;
        L69:
            th = th;
            a r30 = this;
        L73:
            r2.close();
            r30.a.release();
            throw th;
        L71:
            th = th;
            r30 = this;
            goto L73
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<com.larus.avlink.gallery.database.a> call() throws Exception {
            return call2();
        }

        public a(d r1, RoomSQLiteQuery r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class b implements Callable<List<com.larus.avlink.gallery.database.a>> {
        public final /* synthetic */ RoomSQLiteQuery a;
        public final /* synthetic */ d b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public List<com.larus.avlink.gallery.database.a> call2() throws Exception {
            Cursor r2 = DBUtil.query(this.b.a, this.a, false, null);
            int r0 = CursorUtil.getColumnIndexOrThrow(r2, "id");     // Catch: Throwable -> L71
            int r3 = CursorUtil.getColumnIndexOrThrow(r2, "media_id");     // Catch: Throwable -> L71
            int r5 = CursorUtil.getColumnIndexOrThrow(r2, "system_gallery_id");     // Catch: Throwable -> L71
            int r6 = CursorUtil.getColumnIndexOrThrow(r2, "file_name");     // Catch: Throwable -> L71
            int r7 = CursorUtil.getColumnIndexOrThrow(r2, "file_size");     // Catch: Throwable -> L71
            int r8 = CursorUtil.getColumnIndexOrThrow(r2, "media_type");     // Catch: Throwable -> L71
            int r9 = CursorUtil.getColumnIndexOrThrow(r2, "width");     // Catch: Throwable -> L71
            int r10 = CursorUtil.getColumnIndexOrThrow(r2, "height");     // Catch: Throwable -> L71
            int r11 = CursorUtil.getColumnIndexOrThrow(r2, "duration");     // Catch: Throwable -> L71
            int r12 = CursorUtil.getColumnIndexOrThrow(r2, "out_video_width");     // Catch: Throwable -> L71
            int r13 = CursorUtil.getColumnIndexOrThrow(r2, "out_video_height");     // Catch: Throwable -> L71
            int r14 = CursorUtil.getColumnIndexOrThrow(r2, "output_video_crop");     // Catch: Throwable -> L71
            int r15 = CursorUtil.getColumnIndexOrThrow(r2, "create_time");     // Catch: Throwable -> L71
            int r4 = CursorUtil.getColumnIndexOrThrow(r2, "geo_location_info");     // Catch: Throwable -> L71
            int r16 = CursorUtil.getColumnIndexOrThrow(r2, "algorithm_type");     // Catch: Throwable -> L69
            int r17 = CursorUtil.getColumnIndexOrThrow(r2, "lifecycle_state");     // Catch: Throwable -> L69
            int r18 = CursorUtil.getColumnIndexOrThrow(r2, "failure_stage");     // Catch: Throwable -> L69
            int r19 = CursorUtil.getColumnIndexOrThrow(r2, "failure_reason");     // Catch: Throwable -> L69
            int r20 = CursorUtil.getColumnIndexOrThrow(r2, "download_file_path");     // Catch: Throwable -> L69
            int r21 = CursorUtil.getColumnIndexOrThrow(r2, "temp_file_path");     // Catch: Throwable -> L69
            int r22 = CursorUtil.getColumnIndexOrThrow(r2, "unpack_dir_path");     // Catch: Throwable -> L69
            int r23 = CursorUtil.getColumnIndexOrThrow(r2, "processed_file_path");     // Catch: Throwable -> L69
            int r24 = CursorUtil.getColumnIndexOrThrow(r2, "final_file_path");     // Catch: Throwable -> L69
            int r25 = CursorUtil.getColumnIndexOrThrow(r2, "active_mask");     // Catch: Throwable -> L69
            int r26 = r4;
            ArrayList r1 = new ArrayList(r2.getCount());     // Catch: Throwable -> L69
        L5:
            if (r2.moveToNext() == false) goto L67;
            if (r2.isNull(r0) == false) goto L10;
            String r28 = null;
        L11:
            long r29 = r2.getLong(r3);     // Catch: Throwable -> L69
            if (r2.isNull(r5) == false) goto L14;
            Long r31 = null;
        L16:
            if (r2.isNull(r6) == false) goto L18;
            String r32 = null;
        L20:
            if (r2.isNull(r7) == false) goto L22;
            Long r33 = null;
        L24:
            if (r2.isNull(r8) == false) goto L26;
            String r34 = null;
        L27:
            int r35 = r2.getInt(r9);     // Catch: Throwable -> L69
            int r36 = r2.getInt(r10);     // Catch: Throwable -> L69
            long r37 = r2.getLong(r11);     // Catch: Throwable -> L69
            int r39 = r2.getInt(r12);     // Catch: Throwable -> L69
            int r40 = r2.getInt(r13);     // Catch: Throwable -> L69
            double r41 = r2.getDouble(r14);     // Catch: Throwable -> L69
            long r43 = r2.getLong(r15);     // Catch: Throwable -> L69
            int r27 = r26;
            if (r2.isNull(r27) == false) goto L31;
            String r45 = null;
        L30:
            int r56 = r16;
            int r110 = r0;
            if (r2.isNull(r56) == false) goto L36;
            String r46 = null;
        L35:
            int r57 = r17;
            int r47 = r2.getInt(r57);     // Catch: Throwable -> L69
            r18 = r18;
            if (r2.isNull(r18) == false) goto L40;
            Integer r48 = null;
        L42:
            if (r2.isNull(r19) == false) goto L44;
            String r49 = null;
        L46:
            if (r2.isNull(r20) == false) goto L48;
            String r50 = null;
        L50:
            if (r2.isNull(r21) == false) goto L52;
            String r51 = null;
        L54:
            if (r2.isNull(r22) == false) goto L56;
            String r52 = null;
        L58:
            if (r2.isNull(r23) == false) goto L60;
            String r53 = null;
        L62:
            if (r2.isNull(r24) == false) goto L64;
            String r54 = null;
        L65:
            int r55 = r2.getInt(r25);     // Catch: Throwable -> L69
            r25 = r25;
            r1.add(new com.larus.avlink.gallery.database.a(r28, r29, r31, r32, r33, r34, r35, r36, r37, r39, r40, r41, r43, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55));     // Catch: Throwable -> L69
            r0 = r110;
            r16 = r56;
            r17 = r57;
            r26 = r27;
            goto L5
        L64:
            r54 = r2.getString(r24);     // Catch: Throwable -> L69
            goto L65
        L60:
            r53 = r2.getString(r23);     // Catch: Throwable -> L69
            goto L62
        L56:
            r52 = r2.getString(r22);     // Catch: Throwable -> L69
            goto L58
        L52:
            r51 = r2.getString(r21);     // Catch: Throwable -> L69
            goto L54
        L48:
            r50 = r2.getString(r20);     // Catch: Throwable -> L69
            goto L50
        L44:
            r49 = r2.getString(r19);     // Catch: Throwable -> L69
            goto L46
        L40:
            r48 = Integer.valueOf(r2.getInt(r18));     // Catch: Throwable -> L69
            goto L42
        L36:
            r46 = r2.getString(r56);     // Catch: Throwable -> L69
            goto L35
        L31:
            r45 = r2.getString(r27);     // Catch: Throwable -> L69
            goto L30
        L26:
            r34 = r2.getString(r8);     // Catch: Throwable -> L69
            goto L27
        L22:
            r33 = Long.valueOf(r2.getLong(r7));     // Catch: Throwable -> L69
            goto L24
        L18:
            r32 = r2.getString(r6);     // Catch: Throwable -> L69
            goto L20
        L14:
            r31 = Long.valueOf(r2.getLong(r5));     // Catch: Throwable -> L69
            goto L16
        L10:
            r28 = r2.getString(r0);     // Catch: Throwable -> L69
            goto L11
        L67:
            r2.close();
            this.a.release();
            return r1;
        L69:
            th = th;
            b r30 = this;
        L73:
            r2.close();
            r30.a.release();
            throw th;
        L71:
            th = th;
            r30 = this;
            goto L73
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<com.larus.avlink.gallery.database.a> call() throws Exception {
            return call2();
        }

        public b(d r1, RoomSQLiteQuery r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class c implements Callable<List<com.larus.avlink.gallery.database.a>> {
        public final /* synthetic */ RoomSQLiteQuery a;
        public final /* synthetic */ d b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public List<com.larus.avlink.gallery.database.a> call2() throws Exception {
            Cursor r2 = DBUtil.query(this.b.a, this.a, false, null);
            int r0 = CursorUtil.getColumnIndexOrThrow(r2, "id");     // Catch: Throwable -> L71
            int r3 = CursorUtil.getColumnIndexOrThrow(r2, "media_id");     // Catch: Throwable -> L71
            int r5 = CursorUtil.getColumnIndexOrThrow(r2, "system_gallery_id");     // Catch: Throwable -> L71
            int r6 = CursorUtil.getColumnIndexOrThrow(r2, "file_name");     // Catch: Throwable -> L71
            int r7 = CursorUtil.getColumnIndexOrThrow(r2, "file_size");     // Catch: Throwable -> L71
            int r8 = CursorUtil.getColumnIndexOrThrow(r2, "media_type");     // Catch: Throwable -> L71
            int r9 = CursorUtil.getColumnIndexOrThrow(r2, "width");     // Catch: Throwable -> L71
            int r10 = CursorUtil.getColumnIndexOrThrow(r2, "height");     // Catch: Throwable -> L71
            int r11 = CursorUtil.getColumnIndexOrThrow(r2, "duration");     // Catch: Throwable -> L71
            int r12 = CursorUtil.getColumnIndexOrThrow(r2, "out_video_width");     // Catch: Throwable -> L71
            int r13 = CursorUtil.getColumnIndexOrThrow(r2, "out_video_height");     // Catch: Throwable -> L71
            int r14 = CursorUtil.getColumnIndexOrThrow(r2, "output_video_crop");     // Catch: Throwable -> L71
            int r15 = CursorUtil.getColumnIndexOrThrow(r2, "create_time");     // Catch: Throwable -> L71
            int r4 = CursorUtil.getColumnIndexOrThrow(r2, "geo_location_info");     // Catch: Throwable -> L71
            int r16 = CursorUtil.getColumnIndexOrThrow(r2, "algorithm_type");     // Catch: Throwable -> L69
            int r17 = CursorUtil.getColumnIndexOrThrow(r2, "lifecycle_state");     // Catch: Throwable -> L69
            int r18 = CursorUtil.getColumnIndexOrThrow(r2, "failure_stage");     // Catch: Throwable -> L69
            int r19 = CursorUtil.getColumnIndexOrThrow(r2, "failure_reason");     // Catch: Throwable -> L69
            int r20 = CursorUtil.getColumnIndexOrThrow(r2, "download_file_path");     // Catch: Throwable -> L69
            int r21 = CursorUtil.getColumnIndexOrThrow(r2, "temp_file_path");     // Catch: Throwable -> L69
            int r22 = CursorUtil.getColumnIndexOrThrow(r2, "unpack_dir_path");     // Catch: Throwable -> L69
            int r23 = CursorUtil.getColumnIndexOrThrow(r2, "processed_file_path");     // Catch: Throwable -> L69
            int r24 = CursorUtil.getColumnIndexOrThrow(r2, "final_file_path");     // Catch: Throwable -> L69
            int r25 = CursorUtil.getColumnIndexOrThrow(r2, "active_mask");     // Catch: Throwable -> L69
            int r26 = r4;
            ArrayList r1 = new ArrayList(r2.getCount());     // Catch: Throwable -> L69
        L5:
            if (r2.moveToNext() == false) goto L67;
            if (r2.isNull(r0) == false) goto L10;
            String r28 = null;
        L11:
            long r29 = r2.getLong(r3);     // Catch: Throwable -> L69
            if (r2.isNull(r5) == false) goto L14;
            Long r31 = null;
        L16:
            if (r2.isNull(r6) == false) goto L18;
            String r32 = null;
        L20:
            if (r2.isNull(r7) == false) goto L22;
            Long r33 = null;
        L24:
            if (r2.isNull(r8) == false) goto L26;
            String r34 = null;
        L27:
            int r35 = r2.getInt(r9);     // Catch: Throwable -> L69
            int r36 = r2.getInt(r10);     // Catch: Throwable -> L69
            long r37 = r2.getLong(r11);     // Catch: Throwable -> L69
            int r39 = r2.getInt(r12);     // Catch: Throwable -> L69
            int r40 = r2.getInt(r13);     // Catch: Throwable -> L69
            double r41 = r2.getDouble(r14);     // Catch: Throwable -> L69
            long r43 = r2.getLong(r15);     // Catch: Throwable -> L69
            int r27 = r26;
            if (r2.isNull(r27) == false) goto L31;
            String r45 = null;
        L30:
            int r56 = r16;
            int r110 = r0;
            if (r2.isNull(r56) == false) goto L36;
            String r46 = null;
        L35:
            int r57 = r17;
            int r47 = r2.getInt(r57);     // Catch: Throwable -> L69
            r18 = r18;
            if (r2.isNull(r18) == false) goto L40;
            Integer r48 = null;
        L42:
            if (r2.isNull(r19) == false) goto L44;
            String r49 = null;
        L46:
            if (r2.isNull(r20) == false) goto L48;
            String r50 = null;
        L50:
            if (r2.isNull(r21) == false) goto L52;
            String r51 = null;
        L54:
            if (r2.isNull(r22) == false) goto L56;
            String r52 = null;
        L58:
            if (r2.isNull(r23) == false) goto L60;
            String r53 = null;
        L62:
            if (r2.isNull(r24) == false) goto L64;
            String r54 = null;
        L65:
            int r55 = r2.getInt(r25);     // Catch: Throwable -> L69
            r25 = r25;
            r1.add(new com.larus.avlink.gallery.database.a(r28, r29, r31, r32, r33, r34, r35, r36, r37, r39, r40, r41, r43, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55));     // Catch: Throwable -> L69
            r0 = r110;
            r16 = r56;
            r17 = r57;
            r26 = r27;
            goto L5
        L64:
            r54 = r2.getString(r24);     // Catch: Throwable -> L69
            goto L65
        L60:
            r53 = r2.getString(r23);     // Catch: Throwable -> L69
            goto L62
        L56:
            r52 = r2.getString(r22);     // Catch: Throwable -> L69
            goto L58
        L52:
            r51 = r2.getString(r21);     // Catch: Throwable -> L69
            goto L54
        L48:
            r50 = r2.getString(r20);     // Catch: Throwable -> L69
            goto L50
        L44:
            r49 = r2.getString(r19);     // Catch: Throwable -> L69
            goto L46
        L40:
            r48 = Integer.valueOf(r2.getInt(r18));     // Catch: Throwable -> L69
            goto L42
        L36:
            r46 = r2.getString(r56);     // Catch: Throwable -> L69
            goto L35
        L31:
            r45 = r2.getString(r27);     // Catch: Throwable -> L69
            goto L30
        L26:
            r34 = r2.getString(r8);     // Catch: Throwable -> L69
            goto L27
        L22:
            r33 = Long.valueOf(r2.getLong(r7));     // Catch: Throwable -> L69
            goto L24
        L18:
            r32 = r2.getString(r6);     // Catch: Throwable -> L69
            goto L20
        L14:
            r31 = Long.valueOf(r2.getLong(r5));     // Catch: Throwable -> L69
            goto L16
        L10:
            r28 = r2.getString(r0);     // Catch: Throwable -> L69
            goto L11
        L67:
            r2.close();
            this.a.release();
            return r1;
        L69:
            th = th;
            c r30 = this;
        L73:
            r2.close();
            r30.a.release();
            throw th;
        L71:
            th = th;
            r30 = this;
            goto L73
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<com.larus.avlink.gallery.database.a> call() throws Exception {
            return call2();
        }

        public c(d r1, RoomSQLiteQuery r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.gallery.database.d$d, reason: collision with other inner class name */
    public class CallableC0007d implements Callable<List<com.larus.avlink.gallery.database.a>> {
        public final /* synthetic */ RoomSQLiteQuery a;
        public final /* synthetic */ d b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public List<com.larus.avlink.gallery.database.a> call2() throws Exception {
            Cursor r2 = DBUtil.query(this.b.a, this.a, false, null);
            int r0 = CursorUtil.getColumnIndexOrThrow(r2, "id");     // Catch: Throwable -> L71
            int r3 = CursorUtil.getColumnIndexOrThrow(r2, "media_id");     // Catch: Throwable -> L71
            int r5 = CursorUtil.getColumnIndexOrThrow(r2, "system_gallery_id");     // Catch: Throwable -> L71
            int r6 = CursorUtil.getColumnIndexOrThrow(r2, "file_name");     // Catch: Throwable -> L71
            int r7 = CursorUtil.getColumnIndexOrThrow(r2, "file_size");     // Catch: Throwable -> L71
            int r8 = CursorUtil.getColumnIndexOrThrow(r2, "media_type");     // Catch: Throwable -> L71
            int r9 = CursorUtil.getColumnIndexOrThrow(r2, "width");     // Catch: Throwable -> L71
            int r10 = CursorUtil.getColumnIndexOrThrow(r2, "height");     // Catch: Throwable -> L71
            int r11 = CursorUtil.getColumnIndexOrThrow(r2, "duration");     // Catch: Throwable -> L71
            int r12 = CursorUtil.getColumnIndexOrThrow(r2, "out_video_width");     // Catch: Throwable -> L71
            int r13 = CursorUtil.getColumnIndexOrThrow(r2, "out_video_height");     // Catch: Throwable -> L71
            int r14 = CursorUtil.getColumnIndexOrThrow(r2, "output_video_crop");     // Catch: Throwable -> L71
            int r15 = CursorUtil.getColumnIndexOrThrow(r2, "create_time");     // Catch: Throwable -> L71
            int r4 = CursorUtil.getColumnIndexOrThrow(r2, "geo_location_info");     // Catch: Throwable -> L71
            int r16 = CursorUtil.getColumnIndexOrThrow(r2, "algorithm_type");     // Catch: Throwable -> L69
            int r17 = CursorUtil.getColumnIndexOrThrow(r2, "lifecycle_state");     // Catch: Throwable -> L69
            int r18 = CursorUtil.getColumnIndexOrThrow(r2, "failure_stage");     // Catch: Throwable -> L69
            int r19 = CursorUtil.getColumnIndexOrThrow(r2, "failure_reason");     // Catch: Throwable -> L69
            int r20 = CursorUtil.getColumnIndexOrThrow(r2, "download_file_path");     // Catch: Throwable -> L69
            int r21 = CursorUtil.getColumnIndexOrThrow(r2, "temp_file_path");     // Catch: Throwable -> L69
            int r22 = CursorUtil.getColumnIndexOrThrow(r2, "unpack_dir_path");     // Catch: Throwable -> L69
            int r23 = CursorUtil.getColumnIndexOrThrow(r2, "processed_file_path");     // Catch: Throwable -> L69
            int r24 = CursorUtil.getColumnIndexOrThrow(r2, "final_file_path");     // Catch: Throwable -> L69
            int r25 = CursorUtil.getColumnIndexOrThrow(r2, "active_mask");     // Catch: Throwable -> L69
            int r26 = r4;
            ArrayList r1 = new ArrayList(r2.getCount());     // Catch: Throwable -> L69
        L5:
            if (r2.moveToNext() == false) goto L67;
            if (r2.isNull(r0) == false) goto L10;
            String r28 = null;
        L11:
            long r29 = r2.getLong(r3);     // Catch: Throwable -> L69
            if (r2.isNull(r5) == false) goto L14;
            Long r31 = null;
        L16:
            if (r2.isNull(r6) == false) goto L18;
            String r32 = null;
        L20:
            if (r2.isNull(r7) == false) goto L22;
            Long r33 = null;
        L24:
            if (r2.isNull(r8) == false) goto L26;
            String r34 = null;
        L27:
            int r35 = r2.getInt(r9);     // Catch: Throwable -> L69
            int r36 = r2.getInt(r10);     // Catch: Throwable -> L69
            long r37 = r2.getLong(r11);     // Catch: Throwable -> L69
            int r39 = r2.getInt(r12);     // Catch: Throwable -> L69
            int r40 = r2.getInt(r13);     // Catch: Throwable -> L69
            double r41 = r2.getDouble(r14);     // Catch: Throwable -> L69
            long r43 = r2.getLong(r15);     // Catch: Throwable -> L69
            int r27 = r26;
            if (r2.isNull(r27) == false) goto L31;
            String r45 = null;
        L30:
            int r56 = r16;
            int r110 = r0;
            if (r2.isNull(r56) == false) goto L36;
            String r46 = null;
        L35:
            int r57 = r17;
            int r47 = r2.getInt(r57);     // Catch: Throwable -> L69
            r18 = r18;
            if (r2.isNull(r18) == false) goto L40;
            Integer r48 = null;
        L42:
            if (r2.isNull(r19) == false) goto L44;
            String r49 = null;
        L46:
            if (r2.isNull(r20) == false) goto L48;
            String r50 = null;
        L50:
            if (r2.isNull(r21) == false) goto L52;
            String r51 = null;
        L54:
            if (r2.isNull(r22) == false) goto L56;
            String r52 = null;
        L58:
            if (r2.isNull(r23) == false) goto L60;
            String r53 = null;
        L62:
            if (r2.isNull(r24) == false) goto L64;
            String r54 = null;
        L65:
            int r55 = r2.getInt(r25);     // Catch: Throwable -> L69
            r25 = r25;
            r1.add(new com.larus.avlink.gallery.database.a(r28, r29, r31, r32, r33, r34, r35, r36, r37, r39, r40, r41, r43, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55));     // Catch: Throwable -> L69
            r0 = r110;
            r16 = r56;
            r17 = r57;
            r26 = r27;
            goto L5
        L64:
            r54 = r2.getString(r24);     // Catch: Throwable -> L69
            goto L65
        L60:
            r53 = r2.getString(r23);     // Catch: Throwable -> L69
            goto L62
        L56:
            r52 = r2.getString(r22);     // Catch: Throwable -> L69
            goto L58
        L52:
            r51 = r2.getString(r21);     // Catch: Throwable -> L69
            goto L54
        L48:
            r50 = r2.getString(r20);     // Catch: Throwable -> L69
            goto L50
        L44:
            r49 = r2.getString(r19);     // Catch: Throwable -> L69
            goto L46
        L40:
            r48 = Integer.valueOf(r2.getInt(r18));     // Catch: Throwable -> L69
            goto L42
        L36:
            r46 = r2.getString(r56);     // Catch: Throwable -> L69
            goto L35
        L31:
            r45 = r2.getString(r27);     // Catch: Throwable -> L69
            goto L30
        L26:
            r34 = r2.getString(r8);     // Catch: Throwable -> L69
            goto L27
        L22:
            r33 = Long.valueOf(r2.getLong(r7));     // Catch: Throwable -> L69
            goto L24
        L18:
            r32 = r2.getString(r6);     // Catch: Throwable -> L69
            goto L20
        L14:
            r31 = Long.valueOf(r2.getLong(r5));     // Catch: Throwable -> L69
            goto L16
        L10:
            r28 = r2.getString(r0);     // Catch: Throwable -> L69
            goto L11
        L67:
            r2.close();
            this.a.release();
            return r1;
        L69:
            th = th;
            CallableC0007d r30 = this;
        L73:
            r2.close();
            r30.a.release();
            throw th;
        L71:
            th = th;
            r30 = this;
            goto L73
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<com.larus.avlink.gallery.database.a> call() throws Exception {
            return call2();
        }

        public CallableC0007d(d r1, RoomSQLiteQuery r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class e implements Callable<List<com.larus.avlink.gallery.database.a>> {
        public final /* synthetic */ RoomSQLiteQuery a;
        public final /* synthetic */ d b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public List<com.larus.avlink.gallery.database.a> call2() throws Exception {
            Cursor r2 = DBUtil.query(this.b.a, this.a, false, null);
            int r0 = CursorUtil.getColumnIndexOrThrow(r2, "id");     // Catch: Throwable -> L71
            int r3 = CursorUtil.getColumnIndexOrThrow(r2, "media_id");     // Catch: Throwable -> L71
            int r5 = CursorUtil.getColumnIndexOrThrow(r2, "system_gallery_id");     // Catch: Throwable -> L71
            int r6 = CursorUtil.getColumnIndexOrThrow(r2, "file_name");     // Catch: Throwable -> L71
            int r7 = CursorUtil.getColumnIndexOrThrow(r2, "file_size");     // Catch: Throwable -> L71
            int r8 = CursorUtil.getColumnIndexOrThrow(r2, "media_type");     // Catch: Throwable -> L71
            int r9 = CursorUtil.getColumnIndexOrThrow(r2, "width");     // Catch: Throwable -> L71
            int r10 = CursorUtil.getColumnIndexOrThrow(r2, "height");     // Catch: Throwable -> L71
            int r11 = CursorUtil.getColumnIndexOrThrow(r2, "duration");     // Catch: Throwable -> L71
            int r12 = CursorUtil.getColumnIndexOrThrow(r2, "out_video_width");     // Catch: Throwable -> L71
            int r13 = CursorUtil.getColumnIndexOrThrow(r2, "out_video_height");     // Catch: Throwable -> L71
            int r14 = CursorUtil.getColumnIndexOrThrow(r2, "output_video_crop");     // Catch: Throwable -> L71
            int r15 = CursorUtil.getColumnIndexOrThrow(r2, "create_time");     // Catch: Throwable -> L71
            int r4 = CursorUtil.getColumnIndexOrThrow(r2, "geo_location_info");     // Catch: Throwable -> L71
            int r16 = CursorUtil.getColumnIndexOrThrow(r2, "algorithm_type");     // Catch: Throwable -> L69
            int r17 = CursorUtil.getColumnIndexOrThrow(r2, "lifecycle_state");     // Catch: Throwable -> L69
            int r18 = CursorUtil.getColumnIndexOrThrow(r2, "failure_stage");     // Catch: Throwable -> L69
            int r19 = CursorUtil.getColumnIndexOrThrow(r2, "failure_reason");     // Catch: Throwable -> L69
            int r20 = CursorUtil.getColumnIndexOrThrow(r2, "download_file_path");     // Catch: Throwable -> L69
            int r21 = CursorUtil.getColumnIndexOrThrow(r2, "temp_file_path");     // Catch: Throwable -> L69
            int r22 = CursorUtil.getColumnIndexOrThrow(r2, "unpack_dir_path");     // Catch: Throwable -> L69
            int r23 = CursorUtil.getColumnIndexOrThrow(r2, "processed_file_path");     // Catch: Throwable -> L69
            int r24 = CursorUtil.getColumnIndexOrThrow(r2, "final_file_path");     // Catch: Throwable -> L69
            int r25 = CursorUtil.getColumnIndexOrThrow(r2, "active_mask");     // Catch: Throwable -> L69
            int r26 = r4;
            ArrayList r1 = new ArrayList(r2.getCount());     // Catch: Throwable -> L69
        L5:
            if (r2.moveToNext() == false) goto L67;
            if (r2.isNull(r0) == false) goto L10;
            String r28 = null;
        L11:
            long r29 = r2.getLong(r3);     // Catch: Throwable -> L69
            if (r2.isNull(r5) == false) goto L14;
            Long r31 = null;
        L16:
            if (r2.isNull(r6) == false) goto L18;
            String r32 = null;
        L20:
            if (r2.isNull(r7) == false) goto L22;
            Long r33 = null;
        L24:
            if (r2.isNull(r8) == false) goto L26;
            String r34 = null;
        L27:
            int r35 = r2.getInt(r9);     // Catch: Throwable -> L69
            int r36 = r2.getInt(r10);     // Catch: Throwable -> L69
            long r37 = r2.getLong(r11);     // Catch: Throwable -> L69
            int r39 = r2.getInt(r12);     // Catch: Throwable -> L69
            int r40 = r2.getInt(r13);     // Catch: Throwable -> L69
            double r41 = r2.getDouble(r14);     // Catch: Throwable -> L69
            long r43 = r2.getLong(r15);     // Catch: Throwable -> L69
            int r27 = r26;
            if (r2.isNull(r27) == false) goto L31;
            String r45 = null;
        L30:
            int r56 = r16;
            int r110 = r0;
            if (r2.isNull(r56) == false) goto L36;
            String r46 = null;
        L35:
            int r57 = r17;
            int r47 = r2.getInt(r57);     // Catch: Throwable -> L69
            r18 = r18;
            if (r2.isNull(r18) == false) goto L40;
            Integer r48 = null;
        L42:
            if (r2.isNull(r19) == false) goto L44;
            String r49 = null;
        L46:
            if (r2.isNull(r20) == false) goto L48;
            String r50 = null;
        L50:
            if (r2.isNull(r21) == false) goto L52;
            String r51 = null;
        L54:
            if (r2.isNull(r22) == false) goto L56;
            String r52 = null;
        L58:
            if (r2.isNull(r23) == false) goto L60;
            String r53 = null;
        L62:
            if (r2.isNull(r24) == false) goto L64;
            String r54 = null;
        L65:
            int r55 = r2.getInt(r25);     // Catch: Throwable -> L69
            r25 = r25;
            r1.add(new com.larus.avlink.gallery.database.a(r28, r29, r31, r32, r33, r34, r35, r36, r37, r39, r40, r41, r43, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55));     // Catch: Throwable -> L69
            r0 = r110;
            r16 = r56;
            r17 = r57;
            r26 = r27;
            goto L5
        L64:
            r54 = r2.getString(r24);     // Catch: Throwable -> L69
            goto L65
        L60:
            r53 = r2.getString(r23);     // Catch: Throwable -> L69
            goto L62
        L56:
            r52 = r2.getString(r22);     // Catch: Throwable -> L69
            goto L58
        L52:
            r51 = r2.getString(r21);     // Catch: Throwable -> L69
            goto L54
        L48:
            r50 = r2.getString(r20);     // Catch: Throwable -> L69
            goto L50
        L44:
            r49 = r2.getString(r19);     // Catch: Throwable -> L69
            goto L46
        L40:
            r48 = Integer.valueOf(r2.getInt(r18));     // Catch: Throwable -> L69
            goto L42
        L36:
            r46 = r2.getString(r56);     // Catch: Throwable -> L69
            goto L35
        L31:
            r45 = r2.getString(r27);     // Catch: Throwable -> L69
            goto L30
        L26:
            r34 = r2.getString(r8);     // Catch: Throwable -> L69
            goto L27
        L22:
            r33 = Long.valueOf(r2.getLong(r7));     // Catch: Throwable -> L69
            goto L24
        L18:
            r32 = r2.getString(r6);     // Catch: Throwable -> L69
            goto L20
        L14:
            r31 = Long.valueOf(r2.getLong(r5));     // Catch: Throwable -> L69
            goto L16
        L10:
            r28 = r2.getString(r0);     // Catch: Throwable -> L69
            goto L11
        L67:
            r2.close();
            this.a.release();
            return r1;
        L69:
            th = th;
            e r30 = this;
        L73:
            r2.close();
            r30.a.release();
            throw th;
        L71:
            th = th;
            r30 = this;
            goto L73
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<com.larus.avlink.gallery.database.a> call() throws Exception {
            return call2();
        }

        public e(d r1, RoomSQLiteQuery r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class f implements Callable<com.larus.avlink.gallery.database.a> {
        public final /* synthetic */ RoomSQLiteQuery a;
        public final /* synthetic */ d b;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.larus.avlink.gallery.database.a call() throws Exception {
            f r1 = this;
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
            com.larus.avlink.gallery.database.a r26 = null;
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
            r26 = new com.larus.avlink.gallery.database.a(r27, r28, r29, r30, r31, r32, r33, r34, r35, r37, r38, r39, r41, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r2.getInt(r25));     // Catch: Throwable -> L67
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
        public /* bridge */ /* synthetic */ com.larus.avlink.gallery.database.a call() throws Exception {
            return call();
        }

        public f(d r1, RoomSQLiteQuery r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class g implements Callable<Integer> {
        public final /* synthetic */ List a;
        public final /* synthetic */ d b;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            StringBuilder r0 = StringUtil.newStringBuilder();
            r0.append("DELETE FROM 'media_metadata_table' WHERE id IN (");
            StringUtil.appendPlaceholders(r0, this.a.size());
            r0.append(")");
            String r1 = r0.toString();
            SupportSQLiteStatement r2 = this.b.a.compileStatement(r1);
            Iterator r3 = this.a.iterator();
            int r4 = 1;
        L4:
            if (r3.hasNext() == false) goto L10;
            String r5 = (String) r3.next();
            if (r5 != null) goto L8;
            r2.bindNull(r4);
        L9:
            r4 = r4 + 1;
            goto L4
        L8:
            r2.bindString(r4, r5);
            goto L9
        L10:
            this.b.a.beginTransaction();
            Integer r6 = Integer.valueOf(r2.executeUpdateDelete());     // Catch: Throwable -> L14
            this.b.a.setTransactionSuccessful();     // Catch: Throwable -> L14
            this.b.a.endTransaction();
            return r6;
        L14:
            th = move-exception;
            this.b.a.endTransaction();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Integer call() throws Exception {
            return call();
        }

        public g(d r1, List r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class h implements Callable<Long> {
        public final /* synthetic */ com.larus.avlink.gallery.database.a a;
        public final /* synthetic */ d b;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Long call() throws Exception {
            this.b.a.beginTransaction();
            long r0 = this.b.b.insertAndReturnId(this.a);     // Catch: Throwable -> L6
            this.b.a.setTransactionSuccessful();     // Catch: Throwable -> L6
            Long r1 = Long.valueOf(r0);     // Catch: Throwable -> L6
            this.b.a.endTransaction();
            return r1;
        L6:
            th = move-exception;
            this.b.a.endTransaction();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Long call() throws Exception {
            return call();
        }

        public h(d r1, com.larus.avlink.gallery.database.a r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class i implements Callable<List<Long>> {
        public final /* synthetic */ List a;
        public final /* synthetic */ d b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public List<Long> call2() throws Exception {
            this.b.a.beginTransaction();
            List<Long> r0 = this.b.c.insertAndReturnIdsList(this.a);     // Catch: Throwable -> L6
            this.b.a.setTransactionSuccessful();     // Catch: Throwable -> L6
            this.b.a.endTransaction();
            return r0;
        L6:
            th = move-exception;
            this.b.a.endTransaction();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<Long> call() throws Exception {
            return call2();
        }

        public i(d r1, List r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class j implements Callable<Integer> {
        public final /* synthetic */ String a;
        public final /* synthetic */ d b;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            SupportSQLiteStatement r0 = this.b.e.acquire();
            String r1 = this.a;
            if (r1 != null) goto L5;
            r0.bindNull(1);
        L6:
            this.b.a.beginTransaction();
            Integer r2 = Integer.valueOf(r0.executeUpdateDelete());     // Catch: Throwable -> L10
            this.b.a.setTransactionSuccessful();     // Catch: Throwable -> L10
            this.b.a.endTransaction();
            this.b.e.release(r0);
            return r2;
        L10:
            th = move-exception;
            this.b.a.endTransaction();
            this.b.e.release(r0);
            throw th;
        L5:
            r0.bindString(1, r1);
            goto L6
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Integer call() throws Exception {
            return call();
        }

        public j(d r1, String r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class k implements Callable<List<com.larus.avlink.gallery.database.a>> {
        public final /* synthetic */ RoomSQLiteQuery a;
        public final /* synthetic */ d b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public List<com.larus.avlink.gallery.database.a> call2() throws Exception {
            Cursor r2 = DBUtil.query(this.b.a, this.a, false, null);
            int r0 = CursorUtil.getColumnIndexOrThrow(r2, "id");     // Catch: Throwable -> L71
            int r3 = CursorUtil.getColumnIndexOrThrow(r2, "media_id");     // Catch: Throwable -> L71
            int r5 = CursorUtil.getColumnIndexOrThrow(r2, "system_gallery_id");     // Catch: Throwable -> L71
            int r6 = CursorUtil.getColumnIndexOrThrow(r2, "file_name");     // Catch: Throwable -> L71
            int r7 = CursorUtil.getColumnIndexOrThrow(r2, "file_size");     // Catch: Throwable -> L71
            int r8 = CursorUtil.getColumnIndexOrThrow(r2, "media_type");     // Catch: Throwable -> L71
            int r9 = CursorUtil.getColumnIndexOrThrow(r2, "width");     // Catch: Throwable -> L71
            int r10 = CursorUtil.getColumnIndexOrThrow(r2, "height");     // Catch: Throwable -> L71
            int r11 = CursorUtil.getColumnIndexOrThrow(r2, "duration");     // Catch: Throwable -> L71
            int r12 = CursorUtil.getColumnIndexOrThrow(r2, "out_video_width");     // Catch: Throwable -> L71
            int r13 = CursorUtil.getColumnIndexOrThrow(r2, "out_video_height");     // Catch: Throwable -> L71
            int r14 = CursorUtil.getColumnIndexOrThrow(r2, "output_video_crop");     // Catch: Throwable -> L71
            int r15 = CursorUtil.getColumnIndexOrThrow(r2, "create_time");     // Catch: Throwable -> L71
            int r4 = CursorUtil.getColumnIndexOrThrow(r2, "geo_location_info");     // Catch: Throwable -> L71
            int r16 = CursorUtil.getColumnIndexOrThrow(r2, "algorithm_type");     // Catch: Throwable -> L69
            int r17 = CursorUtil.getColumnIndexOrThrow(r2, "lifecycle_state");     // Catch: Throwable -> L69
            int r18 = CursorUtil.getColumnIndexOrThrow(r2, "failure_stage");     // Catch: Throwable -> L69
            int r19 = CursorUtil.getColumnIndexOrThrow(r2, "failure_reason");     // Catch: Throwable -> L69
            int r20 = CursorUtil.getColumnIndexOrThrow(r2, "download_file_path");     // Catch: Throwable -> L69
            int r21 = CursorUtil.getColumnIndexOrThrow(r2, "temp_file_path");     // Catch: Throwable -> L69
            int r22 = CursorUtil.getColumnIndexOrThrow(r2, "unpack_dir_path");     // Catch: Throwable -> L69
            int r23 = CursorUtil.getColumnIndexOrThrow(r2, "processed_file_path");     // Catch: Throwable -> L69
            int r24 = CursorUtil.getColumnIndexOrThrow(r2, "final_file_path");     // Catch: Throwable -> L69
            int r25 = CursorUtil.getColumnIndexOrThrow(r2, "active_mask");     // Catch: Throwable -> L69
            int r26 = r4;
            ArrayList r1 = new ArrayList(r2.getCount());     // Catch: Throwable -> L69
        L5:
            if (r2.moveToNext() == false) goto L67;
            if (r2.isNull(r0) == false) goto L10;
            String r28 = null;
        L11:
            long r29 = r2.getLong(r3);     // Catch: Throwable -> L69
            if (r2.isNull(r5) == false) goto L14;
            Long r31 = null;
        L16:
            if (r2.isNull(r6) == false) goto L18;
            String r32 = null;
        L20:
            if (r2.isNull(r7) == false) goto L22;
            Long r33 = null;
        L24:
            if (r2.isNull(r8) == false) goto L26;
            String r34 = null;
        L27:
            int r35 = r2.getInt(r9);     // Catch: Throwable -> L69
            int r36 = r2.getInt(r10);     // Catch: Throwable -> L69
            long r37 = r2.getLong(r11);     // Catch: Throwable -> L69
            int r39 = r2.getInt(r12);     // Catch: Throwable -> L69
            int r40 = r2.getInt(r13);     // Catch: Throwable -> L69
            double r41 = r2.getDouble(r14);     // Catch: Throwable -> L69
            long r43 = r2.getLong(r15);     // Catch: Throwable -> L69
            int r27 = r26;
            if (r2.isNull(r27) == false) goto L31;
            String r45 = null;
        L30:
            int r56 = r16;
            int r110 = r0;
            if (r2.isNull(r56) == false) goto L36;
            String r46 = null;
        L35:
            int r57 = r17;
            int r47 = r2.getInt(r57);     // Catch: Throwable -> L69
            r18 = r18;
            if (r2.isNull(r18) == false) goto L40;
            Integer r48 = null;
        L42:
            if (r2.isNull(r19) == false) goto L44;
            String r49 = null;
        L46:
            if (r2.isNull(r20) == false) goto L48;
            String r50 = null;
        L50:
            if (r2.isNull(r21) == false) goto L52;
            String r51 = null;
        L54:
            if (r2.isNull(r22) == false) goto L56;
            String r52 = null;
        L58:
            if (r2.isNull(r23) == false) goto L60;
            String r53 = null;
        L62:
            if (r2.isNull(r24) == false) goto L64;
            String r54 = null;
        L65:
            int r55 = r2.getInt(r25);     // Catch: Throwable -> L69
            r25 = r25;
            r1.add(new com.larus.avlink.gallery.database.a(r28, r29, r31, r32, r33, r34, r35, r36, r37, r39, r40, r41, r43, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55));     // Catch: Throwable -> L69
            r0 = r110;
            r16 = r56;
            r17 = r57;
            r26 = r27;
            goto L5
        L64:
            r54 = r2.getString(r24);     // Catch: Throwable -> L69
            goto L65
        L60:
            r53 = r2.getString(r23);     // Catch: Throwable -> L69
            goto L62
        L56:
            r52 = r2.getString(r22);     // Catch: Throwable -> L69
            goto L58
        L52:
            r51 = r2.getString(r21);     // Catch: Throwable -> L69
            goto L54
        L48:
            r50 = r2.getString(r20);     // Catch: Throwable -> L69
            goto L50
        L44:
            r49 = r2.getString(r19);     // Catch: Throwable -> L69
            goto L46
        L40:
            r48 = Integer.valueOf(r2.getInt(r18));     // Catch: Throwable -> L69
            goto L42
        L36:
            r46 = r2.getString(r56);     // Catch: Throwable -> L69
            goto L35
        L31:
            r45 = r2.getString(r27);     // Catch: Throwable -> L69
            goto L30
        L26:
            r34 = r2.getString(r8);     // Catch: Throwable -> L69
            goto L27
        L22:
            r33 = Long.valueOf(r2.getLong(r7));     // Catch: Throwable -> L69
            goto L24
        L18:
            r32 = r2.getString(r6);     // Catch: Throwable -> L69
            goto L20
        L14:
            r31 = Long.valueOf(r2.getLong(r5));     // Catch: Throwable -> L69
            goto L16
        L10:
            r28 = r2.getString(r0);     // Catch: Throwable -> L69
            goto L11
        L67:
            r2.close();
            this.a.release();
            return r1;
        L69:
            th = th;
            k r30 = this;
        L73:
            r2.close();
            r30.a.release();
            throw th;
        L71:
            th = th;
            r30 = this;
            goto L73
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<com.larus.avlink.gallery.database.a> call() throws Exception {
            return call2();
        }

        public k(d r1, RoomSQLiteQuery r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class l implements Callable<Integer> {
        public final /* synthetic */ RoomSQLiteQuery a;
        public final /* synthetic */ d b;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            Cursor r0 = DBUtil.query(this.b.a, this.a, false, null);
        L9:
            th = move-exception;
            r0.close();
            this.a.release();
            throw th;
        L4:
            if (r0.moveToFirst() == false) goto L6;
            int r1 = Integer.valueOf(r0.getInt(0));     // Catch: Throwable -> L9
        L7:
            r0.close();
            this.a.release();
            return r1;
        L6:
            r1 = 0;     // Catch: Throwable -> L9
            goto L7
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Integer call() throws Exception {
            return call();
        }

        public l(d r1, RoomSQLiteQuery r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public d(AlbumDatabase r2) {
        this.a = r2;
        this.b = new com.larus.avlink.gallery.database.e(r2);
        this.c = new com.larus.avlink.gallery.database.f(r2);
        this.d = new com.larus.avlink.gallery.database.g(r2);
        this.e = new com.larus.avlink.gallery.database.h(r2);
    }

    @Override // com.larus.avlink.gallery.database.b
    public final int a(com.larus.avlink.gallery.database.a r2) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        int r3 = this.d.handle(r2) + 0;     // Catch: Throwable -> L6
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.a.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.a.endTransaction();
        throw th;
    }

    @Override // com.larus.avlink.gallery.database.b
    public final Object f(Continuation<? super Integer> r6) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM 'media_metadata_table'", 0);
        CancellationSignal r2 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.a, false, r2, new l(this, r0), r6);
    }

    @Override // com.larus.avlink.gallery.database.b
    public final Object h(Continuation<? super List<com.larus.avlink.gallery.database.a>> r6) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM 'media_metadata_table' ORDER BY create_time DESC", 0);
        CancellationSignal r2 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.a, false, r2, new k(this, r0), r6);
    }

    @Override // com.larus.avlink.gallery.database.b
    public final Object b(com.larus.avlink.gallery.database.a r3, Continuation<? super Long> r4) {
        return CoroutinesRoom.execute(this.a, true, new h(this, r3), r4);
    }

    @Override // com.larus.avlink.gallery.database.b
    public final Object c(List<String> r3, Continuation<? super Integer> r4) {
        return CoroutinesRoom.execute(this.a, true, new g(this, r3), r4);
    }

    @Override // com.larus.avlink.gallery.database.b
    public final Object e(List<Long> r7, Continuation<? super List<com.larus.avlink.gallery.database.a>> r8) {
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT * FROM 'media_metadata_table' WHERE system_gallery_id IN (");
        int r1 = r7.size();
        StringUtil.appendPlaceholders(r0, r1);
        r0.append(")");
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire(r0.toString(), r1 + 0);
        Iterator<Long> r9 = r7.iterator();
        int r3 = 1;
    L4:
        if (r9.hasNext() == false) goto L6;
        r2.bindLong(r3, r9.next().longValue());
        r3 = r3 + 1;
        goto L4
    L6:
        CancellationSignal r10 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.a, false, r10, new e(this, r2), r8);
    }

    @Override // com.larus.avlink.gallery.database.b
    public final Object g(List<com.larus.avlink.gallery.database.a> r3, Continuation<? super List<Long>> r4) {
        return CoroutinesRoom.execute(this.a, true, new i(this, r3), r4);
    }

    @Override // com.larus.avlink.gallery.database.b
    public final Object i(int r5, Continuation<? super List<com.larus.avlink.gallery.database.a>> r6) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM 'media_metadata_table' WHERE lifecycle_state = ?", 1);
        r0.bindLong(1, r5);
        return CoroutinesRoom.execute(this.a, false, DBUtil.createCancellationSignal(), new b(this, r0), r6);
    }

    @Override // com.larus.avlink.gallery.database.b
    public final Object j(String r4, Continuation<? super com.larus.avlink.gallery.database.a> r5) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("\n        SELECT *\n        FROM 'media_metadata_table'\n        WHERE download_file_path = ?\n        OR temp_file_path = ?\n        OR unpack_dir_path = ?\n        OR processed_file_path = ?\n        OR final_file_path = ?\n        ORDER BY create_time DESC\n        LIMIT 1\n    ", 5);
        if (r4 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r4 != null) goto L9;
        r0.bindNull(2);
    L11:
        if (r4 != null) goto L13;
        r0.bindNull(3);
    L15:
        if (r4 != null) goto L17;
        r0.bindNull(4);
    L18:
        if (r4 != null) goto L20;
        r0.bindNull(5);
    L21:
        CancellationSignal r6 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.a, false, r6, new f(this, r0), r5);
    L20:
        r0.bindString(5, r4);
        goto L21
    L17:
        r0.bindString(4, r4);
        goto L18
    L13:
        r0.bindString(3, r4);
        goto L15
    L9:
        r0.bindString(2, r4);
        goto L11
    L5:
        r0.bindString(1, r4);
        goto L7
    }

    @Override // com.larus.avlink.gallery.database.b
    public final Object k(String r4, ContinuationImpl r5) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM 'media_metadata_table' WHERE id = ?", 1);
        if (r4 != null) goto L5;
        r0.bindNull(1);
    L6:
        CancellationSignal r6 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.a, false, r6, new com.larus.avlink.gallery.database.c(this, r0), r5);
    L5:
        r0.bindString(1, r4);
        goto L6
    }

    @Override // com.larus.avlink.gallery.database.b
    public final Object l(List<Integer> r7, Continuation<? super List<com.larus.avlink.gallery.database.a>> r8) {
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT * FROM 'media_metadata_table' WHERE lifecycle_state IN (");
        ArrayList r9 = (ArrayList) r7;
        int r1 = r9.size();
        StringUtil.appendPlaceholders(r0, r1);
        r0.append(")");
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire(r0.toString(), r1 + 0);
        Iterator r10 = r9.iterator();
        int r3 = 1;
    L4:
        if (r10.hasNext() == false) goto L7;
        r2.bindLong(r3, ((Integer) r10.next()).intValue());
        r3 = r3 + 1;
        goto L4
    L7:
        return CoroutinesRoom.execute(this.a, false, DBUtil.createCancellationSignal(), new c(this, r2), r8);
    }

    @Override // com.larus.avlink.gallery.database.b
    public final Object m(String r3, Continuation<? super Integer> r4) {
        return CoroutinesRoom.execute(this.a, true, new j(this, r3), r4);
    }

    @Override // com.larus.avlink.gallery.database.b
    public final Object n(int r5, Continuation<? super List<com.larus.avlink.gallery.database.a>> r6) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM 'media_metadata_table' WHERE lifecycle_state < ?", 1);
        r0.bindLong(1, r5);
        return CoroutinesRoom.execute(this.a, false, DBUtil.createCancellationSignal(), new CallableC0007d(this, r0), r6);
    }

    @Override // com.larus.avlink.gallery.database.b
    public final Object d(int r6, int r7, Continuation<? super List<com.larus.avlink.gallery.database.a>> r8) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM 'media_metadata_table' ORDER BY create_time DESC LIMIT ? OFFSET ?", 2);
        r0.bindLong(1, r7);
        r0.bindLong(2, r6);
        return CoroutinesRoom.execute(this.a, false, DBUtil.createCancellationSignal(), new a(this, r0), r8);
    }
}
