package v0;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: classes.dex */
class a extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile int f13156c;

    a(Context r10, String r11) {
        super(r10, r11, null, Integer.MAX_VALUE);
        this.f13156c = Integer.MAX_VALUE;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase r10) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase r10, int r11, int r12) {
        this.f13156c = r11;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase r10) {
        super.onOpen(r10);
        r10.setVersion(this.f13156c);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase r10, int r11, int r12) {
        this.f13156c = r11;
    }
}
