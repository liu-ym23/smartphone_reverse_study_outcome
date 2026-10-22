package androidx.room.migration;

import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface AutoMigrationSpec {
    void onPostMigrate(SupportSQLiteDatabase r1);
}
