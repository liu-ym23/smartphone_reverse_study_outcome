package com.larus.avlink.gallery.database;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m extends EntityDeletionOrUpdateAdapter<i> {
    public final String createQuery() {
        return "UPDATE OR ABORT `thumbnail_metadata_table` SET `id` = ?,`file_path` = ?,`file_name` = ?,`file_size` = ?,`sn` = ?,`image_uuid` = ?,`media_type` = ?,`width` = ?,`height` = ?,`duration` = ?,`create_time` = ?,`modify_time` = ?,`download_time` = ?,`geo_location_info` = ?,`source_type` = ?,`processing_status` = ?,`is_synced` = ? WHERE `id` = ?";
    }

    public m(AlbumDatabase r1) {
        super(r1);
    }

    public final void bind(SupportSQLiteStatement r5, Object r6) {
        i r7 = (i) r6;
        String r0 = r7.a;
        if (r0 != null) goto L5;
        r5.bindNull(1);
    L6:
        String r1 = r7.b;
        if (r1 != null) goto L9;
        r5.bindNull(2);
    L10:
        String r2 = r7.c;
        if (r2 != null) goto L13;
        r5.bindNull(3);
    L14:
        r5.bindLong(4, r7.d);
        String r3 = r7.e;
        if (r3 != null) goto L17;
        r5.bindNull(5);
    L18:
        r5.bindLong(6, r7.f);
        String r4 = r7.g;
        if (r4 != null) goto L21;
        r5.bindNull(7);
    L22:
        r5.bindLong(8, r7.h);
        r5.bindLong(9, r7.i);
        r5.bindLong(10, r7.j);
        r5.bindLong(11, r7.k);
        r5.bindLong(12, r7.l);
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
        r5.bindLong(17, r7.q ? 1 : 0);
        String r10 = r7.a;
        if (r10 != null) goto L33;
        r5.bindNull(18);
        return;
    L33:
        r5.bindString(18, r10);
        return;
    L29:
        r5.bindString(15, r9);
        goto L30
    L25:
        r5.bindString(14, r8);
        goto L26
    L21:
        r5.bindString(7, r4);
        goto L22
    L17:
        r5.bindString(5, r3);
        goto L18
    L13:
        r5.bindString(3, r2);
        goto L14
    L9:
        r5.bindString(2, r1);
        goto L10
    L5:
        r5.bindString(1, r0);
        goto L6
    }
}
