package com.obric.memorydata.middleware.database;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u00126\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/middleware/database/DowngradeBackupOpenHelperFactory;", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;", "dbName", "", "delegate", "backupAction", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "oldVersion", "newVersion", "", "<init>", "(Ljava/lang/String;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;Lkotlin/jvm/functions/Function2;)V", "create", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "configuration", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration;", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DowngradeBackupOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {
    private final Function2<Integer, Integer, Unit> backupAction;
    private final String dbName;
    private final SupportSQLiteOpenHelper.Factory delegate;

    public DowngradeBackupOpenHelperFactory(String r3, SupportSQLiteOpenHelper.Factory r4, Function2<? super Integer, ? super Integer, Unit> r5) {
        SupportSQLiteOpenHelper.Factory r6 = (SupportSQLiteOpenHelper.Factory) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteOpenHelper.Factory.class, "com.obric.memorydata.plugin");
        Function2<Integer, Integer, Unit> r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "dbName");
        Intrinsics.checkNotNullParameter(r6, "delegate");
        Intrinsics.checkNotNullParameter(r7, "backupAction");
        this.dbName = r3;
        this.delegate = r6;
        this.backupAction = r7;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration r11) {
        Intrinsics.checkNotNullParameter(r11, "configuration");
        DowngradeBackupCallback r0 = new DowngradeBackupCallback(this.dbName, r11.callback, this.backupAction);
        SupportSQLiteOpenHelper.Configuration r1 = new SupportSQLiteOpenHelper.Configuration(r11.context, r11.name, (SupportSQLiteOpenHelper.Callback) ZeusTransformUtils.preCheckCast(r0, SupportSQLiteOpenHelper.Callback.class, "com.obric.memorydata.plugin"), r11.useNoBackupDirectory, r11.allowDataLossOnRecovery);
        return this.delegate.create(r1);
    }
}
