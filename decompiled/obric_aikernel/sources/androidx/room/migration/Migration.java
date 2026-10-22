package androidx.room.migration;

import androidx.annotation.NonNull;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes.dex */
public abstract class Migration {
    public final int endVersion;
    public final int startVersion;

    public Migration(int r10, int r11) {
        this.startVersion = r10;
        this.endVersion = r11;
    }

    public abstract void migrate(@NonNull SupportSQLiteDatabase r10);
}
