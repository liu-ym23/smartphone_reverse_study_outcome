package androidx.room;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class a implements Function {
    public /* synthetic */ a() {
    }

    public final Object apply(Object r1) {
        return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.k((SupportSQLiteDatabase) r1);
    }
}
