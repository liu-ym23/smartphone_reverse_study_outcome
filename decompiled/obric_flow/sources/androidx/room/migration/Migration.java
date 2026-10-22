package androidx.room.migration;

import androidx.annotation.NonNull;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes.dex */
public abstract class Migration {
    public final int endVersion;
    public final int startVersion;

    public Migration(int r5, int r10) {
        this.startVersion = r5;
        this.endVersion = r10;
    }

    public abstract void migrate(@NonNull SupportSQLiteDatabase r5);
}
