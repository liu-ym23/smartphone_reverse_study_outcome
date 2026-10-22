package androidx.room;

import androidx.sqlite.db.SupportSQLiteOpenHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
final class AutoClosingRoomOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {
    private final AutoCloser mAutoCloser;
    private final SupportSQLiteOpenHelper.Factory mDelegate;

    public AutoClosingRoomOpenHelper create(SupportSQLiteOpenHelper.Configuration r3) {
        return new AutoClosingRoomOpenHelper(this.mDelegate.create(r3), this.mAutoCloser);
    }

    /* JADX INFO: renamed from: create, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ SupportSQLiteOpenHelper m3create(SupportSQLiteOpenHelper.Configuration r1) {
        return create(r1);
    }

    public AutoClosingRoomOpenHelperFactory(SupportSQLiteOpenHelper.Factory r1, AutoCloser r2) {
        this.mDelegate = r1;
        this.mAutoCloser = r2;
    }
}
