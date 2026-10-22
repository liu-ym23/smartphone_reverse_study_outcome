package b1;

import android.database.sqlite.SQLiteStatement;
import androidx.room.o;

/* JADX INFO: loaded from: classes.dex */
public final class g extends o implements a1.f {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final SQLiteStatement f3001m;

    public g(SQLiteStatement r8) {
        super(r8);
        this.f3001m = r8;
    }

    @Override // a1.f
    public final long O() {
        return this.f3001m.executeInsert();
    }

    @Override // a1.f
    public final int g() {
        return this.f3001m.executeUpdateDelete();
    }
}
