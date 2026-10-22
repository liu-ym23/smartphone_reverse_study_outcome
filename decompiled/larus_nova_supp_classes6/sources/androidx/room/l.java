package androidx.room;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class l implements Function {
    public final /* synthetic */ boolean a;

    public /* synthetic */ l(boolean r1) {
        this.a = r1;
    }

    public final Object apply(Object r2) {
        return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.b(this.a, (SupportSQLiteDatabase) r2);
    }
}
