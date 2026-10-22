package androidx.room;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class h implements Function {
    public final /* synthetic */ long a;

    public /* synthetic */ h(long r1) {
        this.a = r1;
    }

    public final Object apply(Object r3) {
        return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.h(this.a, (SupportSQLiteDatabase) r3);
    }
}
