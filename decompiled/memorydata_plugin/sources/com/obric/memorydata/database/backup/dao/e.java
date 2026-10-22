package com.obric.memorydata.database.backup.dao;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.dao.BaseDao;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J&\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u001b\u0010\u000b\u001a\u00020\f2\u0011\u0010\r\u001a\r\u0012\t\u0012\u00078\u0000¢\u0006\u0002\b\u000e0\bH'¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/database/backup/dao/BackupUserScopedDao;", ExifInterface.LONGITUDE_EAST, "Lcom/obric/memorydata/database/dao/BaseDao;", "deleteByBackupUserId", "", "userId", "", "queryByBackupUserId", "", "limit", TypedValues.CycleType.S_WAVE_OFFSET, "bulkInsert", "", "entities", "Lkotlin/jvm/JvmSuppressWildcards;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface e<E> extends BaseDao<E> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static <E> int a(e<E> r5, String r6) {
            e r7 = (e) ZeusTransformUtils.wrapperContextForParams(r5, e.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "userId");
            return r7.rawQueryForInt((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("DELETE FROM " + r7.getTableName() + " WHERE backupUserId = ?", new String[]{r6}), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static <E> E a(e<E> r2, long r3) {
            return (E) BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static <E> List<E> a(e<E> r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static <E> List<E> a(e<E> r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static <E> List<E> a(e<E> r5, String r6, int r7, int r8) {
            e r9 = (e) ZeusTransformUtils.wrapperContextForParams(r5, e.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "userId");
            return r9.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM " + r9.getTableName() + " WHERE backupUserId = ? LIMIT ? OFFSET ?", new Object[]{r6, Integer.valueOf(r7), Integer.valueOf(r8)}), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static <E> List<E> a(e<E> r2, List<Long> r3) {
            e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static <E> int b(e<E> r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static <E> List<E> b(e<E> r5, String r6) {
            e r7 = (e) ZeusTransformUtils.wrapperContextForParams(r5, e.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "userId");
            return r7.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM " + r7.getTableName() + " WHERE backupUserId = ?", new String[]{r6}), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static <E> int c(e<E> r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static <E> E c(e<E> r2, String r3) {
            e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (E) BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static <E> E d(e<E> r2) {
            return (E) BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }
    }

    int deleteByBackupUserId(String r1);

    List<E> queryByBackupUserId(String r1, int r2, int r3);
}
