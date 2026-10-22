package xh8;

import android.database.sqlite.SQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h extends g implements SupportSQLiteStatement {
    public final SQLiteStatement b;

    public final void execute() {
        this.b.execute();
    }

    public final long executeInsert() {
        return this.b.executeInsert();
    }

    public final int executeUpdateDelete() {
        return this.b.executeUpdateDelete();
    }

    public final long simpleQueryForLong() {
        return this.b.simpleQueryForLong();
    }

    public final String simpleQueryForString() {
        return this.b.simpleQueryForString();
    }

    public h(SQLiteStatement r1) {
        super(r1);
        this.b = r1;
    }
}
