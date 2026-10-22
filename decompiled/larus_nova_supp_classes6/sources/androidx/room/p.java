package androidx.room;

import android.content.ContentValues;
import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class p implements Function {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;
    public final /* synthetic */ ContentValues c;

    public /* synthetic */ p(String r1, int r2, ContentValues r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object apply(Object r4) {
        return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.j(this.a, this.b, this.c, (SupportSQLiteDatabase) r4);
    }
}
