package com.obric.flow.cardlistpage.data;

import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import cn.nubia.neopush.commons.Constant;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends RoomOpenHelper.Delegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CardDatabase_Impl f11482a;

    public i(CardDatabase_Impl r5) {
        this.f11482a = r5;
        super(2);
    }

    @Override // androidx.room.RoomOpenHelper.Delegate
    public final void createAllTables(SupportSQLiteDatabase r5) {
        r5.execSQL("CREATE TABLE IF NOT EXISTS `cards` (`id` TEXT NOT NULL, `originalId` TEXT NOT NULL, `type` TEXT NOT NULL, `title` TEXT NOT NULL, `description` TEXT NOT NULL, `spanX` INTEGER NOT NULL, `spanY` INTEGER NOT NULL, `isVisible` INTEGER NOT NULL, `sortIndex` INTEGER, `createTime` INTEGER, `modifyTime` INTEGER, `instanceId` INTEGER, `appletId` TEXT, `widgetId` TEXT, `definitionId` TEXT, `config` TEXT, `extras` TEXT, `data` TEXT, PRIMARY KEY(`id`))");
        r5.execSQL("CREATE TABLE IF NOT EXISTS `id_sequence` (`name` TEXT NOT NULL, `nextValue` INTEGER NOT NULL, PRIMARY KEY(`name`))");
        r5.execSQL(RoomMasterTable.CREATE_QUERY);
        r5.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'e46b5dadaa2d321229f1fdcef7b733be')");
    }

    @Override // androidx.room.RoomOpenHelper.Delegate
    public final void dropAllTables(SupportSQLiteDatabase r5) {
        r5.execSQL("DROP TABLE IF EXISTS `cards`");
        r5.execSQL("DROP TABLE IF EXISTS `id_sequence`");
        CardDatabase_Impl r10 = this.f11482a;
        if (CardDatabase_Impl.b(r10) == null) goto L7;
        int r11 = CardDatabase_Impl.c(r10).size();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L9;
        ((RoomDatabase.Callback) CardDatabase_Impl.e(r10).get(r12)).onDestructiveMigration(r5);
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    }

    @Override // androidx.room.RoomOpenHelper.Delegate
    public final void onCreate(SupportSQLiteDatabase r5) {
        CardDatabase_Impl r10 = this.f11482a;
        if (CardDatabase_Impl.f(r10) == null) goto L7;
        int r11 = CardDatabase_Impl.g(r10).size();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L9;
        ((RoomDatabase.Callback) CardDatabase_Impl.h(r10).get(r12)).onCreate(r5);
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    }

    @Override // androidx.room.RoomOpenHelper.Delegate
    public final void onOpen(SupportSQLiteDatabase r5) {
        CardDatabase_Impl r10 = this.f11482a;
        CardDatabase_Impl.i(r10, r5);
        r10.internalInitInvalidationTracker(r5);
        if (CardDatabase_Impl.j(r10) == null) goto L7;
        int r11 = CardDatabase_Impl.k(r10).size();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L9;
        ((RoomDatabase.Callback) CardDatabase_Impl.d(r10).get(r12)).onOpen(r5);
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    }

    @Override // androidx.room.RoomOpenHelper.Delegate
    public final void onPostMigrate(SupportSQLiteDatabase r5) {
    }

    @Override // androidx.room.RoomOpenHelper.Delegate
    public final void onPreMigrate(SupportSQLiteDatabase r5) {
        DBUtil.dropFtsSyncTriggers(r5);
    }

    @Override // androidx.room.RoomOpenHelper.Delegate
    public final RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase r12) {
        HashMap r11 = new HashMap(18);
        r11.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, 1));
        r11.put("originalId", new TableInfo.Column("originalId", "TEXT", true, 0, null, 1));
        r11.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, 1));
        r11.put(Constant.TITLE, new TableInfo.Column(Constant.TITLE, "TEXT", true, 0, null, 1));
        r11.put(Constant.DESCRIPTION, new TableInfo.Column(Constant.DESCRIPTION, "TEXT", true, 0, null, 1));
        r11.put("spanX", new TableInfo.Column("spanX", "INTEGER", true, 0, null, 1));
        r11.put("spanY", new TableInfo.Column("spanY", "INTEGER", true, 0, null, 1));
        r11.put("isVisible", new TableInfo.Column("isVisible", "INTEGER", true, 0, null, 1));
        r11.put("sortIndex", new TableInfo.Column("sortIndex", "INTEGER", false, 0, null, 1));
        r11.put("createTime", new TableInfo.Column("createTime", "INTEGER", false, 0, null, 1));
        r11.put("modifyTime", new TableInfo.Column("modifyTime", "INTEGER", false, 0, null, 1));
        r11.put("instanceId", new TableInfo.Column("instanceId", "INTEGER", false, 0, null, 1));
        r11.put("appletId", new TableInfo.Column("appletId", "TEXT", false, 0, null, 1));
        r11.put("widgetId", new TableInfo.Column("widgetId", "TEXT", false, 0, null, 1));
        r11.put("definitionId", new TableInfo.Column("definitionId", "TEXT", false, 0, null, 1));
        r11.put("config", new TableInfo.Column("config", "TEXT", false, 0, null, 1));
        r11.put("extras", new TableInfo.Column("extras", "TEXT", false, 0, null, 1));
        r11.put("data", new TableInfo.Column("data", "TEXT", false, 0, null, 1));
        TableInfo r5 = new TableInfo("cards", r11, new HashSet(0), new HashSet(0));
        TableInfo r13 = TableInfo.read(r12, "cards");
        if (r5.equals(r13) == false) goto L5;
        HashMap r14 = new HashMap(2);
        r14.put("name", new TableInfo.Column("name", "TEXT", true, 1, null, 1));
        r14.put("nextValue", new TableInfo.Column("nextValue", "INTEGER", true, 0, null, 1));
        TableInfo r10 = new TableInfo("id_sequence", r14, new HashSet(0), new HashSet(0));
        TableInfo r15 = TableInfo.read(r12, "id_sequence");
        if (r10.equals(r15) == true) goto L11;
        return new RoomOpenHelper.ValidationResult(false, "id_sequence(com.obric.flow.cardlistpage.data.IdSequenceEntity).\n Expected:\n" + r10 + "\n Found:\n" + r15);
    L11:
        return new RoomOpenHelper.ValidationResult(true, null);
    L5:
        return new RoomOpenHelper.ValidationResult(false, "cards(com.obric.flow.cardlistpage.data.CardEntity).\n Expected:\n" + r5 + "\n Found:\n" + r13);
    }
}
