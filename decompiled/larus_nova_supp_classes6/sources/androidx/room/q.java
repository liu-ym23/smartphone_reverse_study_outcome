package androidx.room;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class q implements Function {
    public /* synthetic */ q() {
    }

    public final Object apply(Object r1) {
        return Integer.valueOf(((SupportSQLiteDatabase) r1).getVersion());
    }
}
