package androidx.sqlite.db.framework;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements SQLiteDatabase.CursorFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f698b;

    public /* synthetic */ a(Object r5, int r10) {
        this.f697a = r10;
        this.f698b = r5;
    }

    @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
    public final Cursor newCursor(SQLiteDatabase r5, SQLiteCursorDriver r10, String r11, SQLiteQuery r12) {
        int r13 = this.f697a;
        Object r14 = this.f698b;
        switch(r13) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return FrameworkSQLiteDatabase.d((Function4) r14, r5, r10, r11, r12);
    L7:
        return FrameworkSQLiteDatabase.b((SupportSQLiteQuery) r14, r5, r10, r11, r12);
    }
}
