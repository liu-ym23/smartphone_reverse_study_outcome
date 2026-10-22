package androidx.room;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class o implements Function {
    public /* synthetic */ o() {
    }

    public final Object apply(Object r1) {
        return Boolean.valueOf(((SupportSQLiteDatabase) r1).yieldIfContendedSafely());
    }
}
