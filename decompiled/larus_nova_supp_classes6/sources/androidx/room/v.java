package androidx.room;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class v implements Function {
    public final /* synthetic */ Locale a;

    public /* synthetic */ v(Locale r1) {
        this.a = r1;
    }

    public final Object apply(Object r2) {
        return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.c(this.a, (SupportSQLiteDatabase) r2);
    }
}
