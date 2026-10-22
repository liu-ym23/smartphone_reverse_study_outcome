package com.larus.avlink.gallery.database;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l extends EntityInsertionAdapter<i> {
    public final String createQuery() {
        return "INSERT OR IGNORE INTO `thumbnail_metadata_table` (`id`,`file_path`,`file_name`,`file_size`,`sn`,`image_uuid`,`media_type`,`width`,`height`,`duration`,`create_time`,`modify_time`,`download_time`,`geo_location_info`,`source_type`,`processing_status`,`is_synced`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public l(AlbumDatabase r1) {
        super(r1);
    }

    public final void bind(SupportSQLiteStatement r4, Object r5) {
        i r6 = (i) r5;
        String r0 = r6.a;
        if (r0 != null) goto L5;
        r4.bindNull(1);
    L6:
        String r1 = r6.b;
        if (r1 != null) goto L9;
        r4.bindNull(2);
    L10:
        String r2 = r6.c;
        if (r2 != null) goto L13;
        r4.bindNull(3);
    L14:
        r4.bindLong(4, r6.d);
        String r3 = r6.e;
        if (r3 != null) goto L17;
        r4.bindNull(5);
    L18:
        r4.bindLong(6, r6.f);
        String r7 = r6.g;
        if (r7 != null) goto L21;
        r4.bindNull(7);
    L22:
        r4.bindLong(8, r6.h);
        r4.bindLong(9, r6.i);
        r4.bindLong(10, r6.j);
        r4.bindLong(11, r6.k);
        r4.bindLong(12, r6.l);
        r4.bindLong(13, r6.m);
        String r8 = r6.n;
        if (r8 != null) goto L25;
        r4.bindNull(14);
    L26:
        String r9 = r6.o;
        if (r9 != null) goto L29;
        r4.bindNull(15);
    L30:
        r4.bindLong(16, r6.p);
        r4.bindLong(17, r6.q ? 1 : 0);
        return;
    L29:
        r4.bindString(15, r9);
        goto L30
    L25:
        r4.bindString(14, r8);
        goto L26
    L21:
        r4.bindString(7, r7);
        goto L22
    L17:
        r4.bindString(5, r3);
        goto L18
    L13:
        r4.bindString(3, r2);
        goto L14
    L9:
        r4.bindString(2, r1);
        goto L10
    L5:
        r4.bindString(1, r0);
        goto L6
    }
}
