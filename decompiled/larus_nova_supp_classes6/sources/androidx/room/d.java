package androidx.room;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class d implements Function {
    public /* synthetic */ d() {
    }

    public final Object apply(Object r3) {
        return Long.valueOf(((SupportSQLiteDatabase) r3).getMaximumSize());
    }
}
