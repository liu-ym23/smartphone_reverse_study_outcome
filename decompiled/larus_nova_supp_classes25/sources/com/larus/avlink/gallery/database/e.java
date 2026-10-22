package com.larus.avlink.gallery.database;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e extends EntityInsertionAdapter<a> {
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `media_metadata_table` (`id`,`media_id`,`system_gallery_id`,`file_name`,`file_size`,`media_type`,`width`,`height`,`duration`,`out_video_width`,`out_video_height`,`output_video_crop`,`create_time`,`geo_location_info`,`algorithm_type`,`lifecycle_state`,`failure_stage`,`failure_reason`,`download_file_path`,`temp_file_path`,`unpack_dir_path`,`processed_file_path`,`final_file_path`,`active_mask`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public e(AlbumDatabase r1) {
        super(r1);
    }

    public final void bind(SupportSQLiteStatement r5, Object r6) {
        a r7 = (a) r6;
        String r0 = r7.a;
        if (r0 != null) goto L5;
        r5.bindNull(1);
    L6:
        r5.bindLong(2, r7.b);
        Long r1 = r7.c;
        if (r1 != null) goto L9;
        r5.bindNull(3);
    L10:
        String r2 = r7.d;
        if (r2 != null) goto L13;
        r5.bindNull(4);
    L14:
        Long r3 = r7.e;
        if (r3 != null) goto L17;
        r5.bindNull(5);
    L18:
        String r4 = r7.f;
        if (r4 != null) goto L21;
        r5.bindNull(6);
    L22:
        r5.bindLong(7, r7.g);
        r5.bindLong(8, r7.h);
        r5.bindLong(9, r7.i);
        r5.bindLong(10, r7.j);
        r5.bindLong(11, r7.k);
        r5.bindDouble(12, r7.l);
        r5.bindLong(13, r7.m);
        String r8 = r7.n;
        if (r8 != null) goto L25;
        r5.bindNull(14);
    L26:
        String r9 = r7.o;
        if (r9 != null) goto L29;
        r5.bindNull(15);
    L30:
        r5.bindLong(16, r7.p);
        Integer r10 = r7.q;
        if (r10 != null) goto L33;
        r5.bindNull(17);
    L34:
        String r11 = r7.r;
        if (r11 != null) goto L37;
        r5.bindNull(18);
    L38:
        String r12 = r7.s;
        if (r12 != null) goto L41;
        r5.bindNull(19);
    L42:
        String r13 = r7.t;
        if (r13 != null) goto L45;
        r5.bindNull(20);
    L46:
        String r14 = r7.u;
        if (r14 != null) goto L49;
        r5.bindNull(21);
    L50:
        String r15 = r7.v;
        if (r15 != null) goto L53;
        r5.bindNull(22);
    L54:
        String r16 = r7.w;
        if (r16 != null) goto L57;
        r5.bindNull(23);
    L58:
        r5.bindLong(24, r7.x);
        return;
    L57:
        r5.bindString(23, r16);
        goto L58
    L53:
        r5.bindString(22, r15);
        goto L54
    L49:
        r5.bindString(21, r14);
        goto L50
    L45:
        r5.bindString(20, r13);
        goto L46
    L41:
        r5.bindString(19, r12);
        goto L42
    L37:
        r5.bindString(18, r11);
        goto L38
    L33:
        r5.bindLong(17, r10.intValue());
        goto L34
    L29:
        r5.bindString(15, r9);
        goto L30
    L25:
        r5.bindString(14, r8);
        goto L26
    L21:
        r5.bindString(6, r4);
        goto L22
    L17:
        r5.bindLong(5, r3.longValue());
        goto L18
    L13:
        r5.bindString(4, r2);
        goto L14
    L9:
        r5.bindLong(3, r1.longValue());
        goto L10
    L5:
        r5.bindString(1, r0);
        goto L6
    }
}
