package androidx.room;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class b implements Function {
    public /* synthetic */ b() {
    }

    public final Object apply(Object r1) {
        return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.m((SupportSQLiteDatabase) r1);
    }
}
