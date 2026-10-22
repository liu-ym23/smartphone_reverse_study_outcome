package androidx.room;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/room/AutoClosingRoomOpenHelperFactory;", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;", "delegate", "autoCloser", "Landroidx/room/AutoCloser;", "(Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;Landroidx/room/AutoCloser;)V", "create", "Landroidx/room/AutoClosingRoomOpenHelper;", "configuration", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration;", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AutoClosingRoomOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {
    private final AutoCloser autoCloser;
    private final SupportSQLiteOpenHelper.Factory delegate;

    public AutoClosingRoomOpenHelperFactory(SupportSQLiteOpenHelper.Factory r3, AutoCloser r4) {
        SupportSQLiteOpenHelper.Factory r5 = (SupportSQLiteOpenHelper.Factory) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteOpenHelper.Factory.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "delegate");
        Intrinsics.checkNotNullParameter(r4, "autoCloser");
        this.delegate = r5;
        this.autoCloser = r4;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public AutoClosingRoomOpenHelper create(SupportSQLiteOpenHelper.Configuration r3) {
        Intrinsics.checkNotNullParameter(r3, "configuration");
        return new AutoClosingRoomOpenHelper(this.delegate.create(r3), this.autoCloser);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public /* synthetic */ SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration r2) {
        return (SupportSQLiteOpenHelper) ZeusTransformUtils.preCheckCast(create(r2), SupportSQLiteOpenHelper.class, "com.obric.memorydata.plugin");
    }
}
