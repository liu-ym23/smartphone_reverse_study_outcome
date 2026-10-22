package androidx.room;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class AutoClosingRoomOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {
    private final AutoCloser autoCloser;
    private final SupportSQLiteOpenHelper.Factory delegate;

    public AutoClosingRoomOpenHelperFactory(SupportSQLiteOpenHelper.Factory r10, AutoCloser r11) {
        Intrinsics.checkNotNullParameter(r10, "delegate");
        Intrinsics.checkNotNullParameter(r11, "autoCloser");
        this.delegate = r10;
        this.autoCloser = r11;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public AutoClosingRoomOpenHelper create(SupportSQLiteOpenHelper.Configuration r10) {
        Intrinsics.checkNotNullParameter(r10, "configuration");
        return new AutoClosingRoomOpenHelper(this.delegate.create(r10), this.autoCloser);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public /* bridge */ /* synthetic */ SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration r10) {
        return create(r10);
    }
}
