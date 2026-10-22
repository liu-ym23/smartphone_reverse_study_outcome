package androidx.room;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class g implements Function {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Object[] c;

    public /* synthetic */ g(String r1, String r2, Object[] r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object apply(Object r4) {
        return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.e(this.a, this.b, this.c, (SupportSQLiteDatabase) r4);
    }
}
