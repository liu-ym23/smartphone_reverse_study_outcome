package com.larus.avlink.gallery.database;

import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n extends SharedSQLiteStatement {
    public final String createQuery() {
        return "DELETE FROM thumbnail_metadata_table WHERE image_uuid = ? AND sn = ?";
    }

    public n(AlbumDatabase r1) {
        super(r1);
    }
}
