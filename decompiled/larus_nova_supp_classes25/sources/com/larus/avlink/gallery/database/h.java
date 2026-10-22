package com.larus.avlink.gallery.database;

import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h extends SharedSQLiteStatement {
    public final String createQuery() {
        return "DELETE FROM 'media_metadata_table' WHERE id = ?";
    }

    public h(AlbumDatabase r1) {
        super(r1);
    }
}
