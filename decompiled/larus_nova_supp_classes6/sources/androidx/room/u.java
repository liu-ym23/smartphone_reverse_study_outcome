package androidx.room;

import android.content.ContentValues;
import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class u implements Function {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;
    public final /* synthetic */ ContentValues c;
    public final /* synthetic */ String d;
    public final /* synthetic */ Object[] e;

    public /* synthetic */ u(String r1, int r2, ContentValues r3, String r4, Object[] r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final Object apply(Object r7) {
        return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.d(this.a, this.b, this.c, this.d, this.e, (SupportSQLiteDatabase) r7);
    }
}
