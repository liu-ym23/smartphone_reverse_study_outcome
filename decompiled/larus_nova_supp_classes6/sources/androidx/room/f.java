package androidx.room;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class f implements Function {
    public final /* synthetic */ int a;

    public /* synthetic */ f(int r1) {
        this.a = r1;
    }

    public final Object apply(Object r2) {
        return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.n(this.a, (SupportSQLiteDatabase) r2);
    }
}
