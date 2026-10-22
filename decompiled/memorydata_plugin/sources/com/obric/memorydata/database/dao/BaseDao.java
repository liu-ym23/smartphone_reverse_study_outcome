package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.entity.ChatMessage;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H'¢\u0006\u0002\u0010\bJ!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0011\u0010\u000b\u001a\r\u0012\t\u0012\u00078\u0000¢\u0006\u0002\b\f0\nH'J\u0015\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00028\u0000H'¢\u0006\u0002\u0010\u000fJ\u001b\u0010\u0010\u001a\u00020\u00112\u0011\u0010\u000b\u001a\r\u0012\t\u0012\u00078\u0000¢\u0006\u0002\b\f0\nH'J\u001b\u0010\u0012\u001a\u00020\u00112\u0011\u0010\u000b\u001a\r\u0012\t\u0012\u00078\u0000¢\u0006\u0002\b\f0\nH'J\u0015\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00028\u0000H'¢\u0006\u0002\u0010\u000fJ\u001b\u0010\u0014\u001a\u00020\u00112\u0011\u0010\u000b\u001a\r\u0012\t\u0012\u00078\u0000¢\u0006\u0002\b\f0\nH'J\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u0017\u0010\u0018\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0019\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\u001aJ\u0017\u0010\u001b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u001c\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\u001dJ\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016J\b\u0010\u001f\u001a\u00020\u000eH\u0016J\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010!\u001a\u00020\"H'J\u0010\u0010#\u001a\u00020$2\u0006\u0010!\u001a\u00020\"H'J\u0010\u0010%\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\"H'J\u0010\u0010&\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\"H'J\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0016J\b\u0010)\u001a\u00020\u000eH\u0016J\u000f\u0010*\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010+¨\u0006,"}, d2 = {"Lcom/obric/memorydata/database/dao/BaseDao;", ExifInterface.GPS_DIRECTION_TRUE, "", "getTableName", "", "insert", "", "entity", "(Ljava/lang/Object;)J", "insertAll", "", "entities", "Lkotlin/jvm/JvmSuppressWildcards;", "delete", "", "(Ljava/lang/Object;)I", "bulkInsert", "", "bulkDelete", BuildConfig.CHANNEL, "updateAll", "queryWithLimitAndOffset", "limit", TypedValues.CycleType.S_WAVE_OFFSET, "queryById", OaidModel.KEY_ID, "(J)Ljava/lang/Object;", "queryByUUID", Api.KEY_UUID, "(Ljava/lang/String;)Ljava/lang/Object;", "queryAll", "queryAllCount", "rawQuery", ChatMessage.TYPE_QUERY, "Landroidx/sqlite/db/SupportSQLiteQuery;", "rawQueryForCursor", "Landroid/database/Cursor;", "rawQueryForInt", "rawQueryForLong", "queryByIds", "ids", "deleteAll", "queryOne", "()Ljava/lang/Object;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface BaseDao<T> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <T> int deleteAll(BaseDao<T> r4) {
            BaseDao r5 = (BaseDao) ZeusTransformUtils.wrapperContextForParams(r4, BaseDao.class, "com.obric.memorydata.plugin");
            return r5.rawQueryForInt((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("DELETE FROM " + r5.getTableName()), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static <T> List<T> queryAll(BaseDao<T> r4) {
            BaseDao r5 = (BaseDao) ZeusTransformUtils.wrapperContextForParams(r4, BaseDao.class, "com.obric.memorydata.plugin");
            return r5.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM " + r5.getTableName()), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static <T> int queryAllCount(BaseDao<T> r4) {
            BaseDao r5 = (BaseDao) ZeusTransformUtils.wrapperContextForParams(r4, BaseDao.class, "com.obric.memorydata.plugin");
            return r5.rawQueryForInt((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT COUNT(*) FROM " + r5.getTableName()), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static <T> T queryById(BaseDao<T> r4, long r5) {
            BaseDao r6 = (BaseDao) ZeusTransformUtils.wrapperContextForParams(r4, BaseDao.class, "com.obric.memorydata.plugin");
            return (T) CollectionsKt.firstOrNull(r6.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM " + r6.getTableName() + " WHERE id = ? LIMIT 1", new Long[]{Long.valueOf(r5)}), SupportSQLiteQuery.class, "com.obric.memorydata.plugin")));
        }

        public static <T> List<T> queryByIds(BaseDao<T> r12, List<Long> r13) {
            BaseDao r14 = (BaseDao) ZeusTransformUtils.wrapperContextForParams(r12, BaseDao.class, "com.obric.memorydata.plugin");
            List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r15, "ids");
            return r14.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM " + r14.getTableName() + " WHERE id IN (" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null) + ')'), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static <T> T queryByUUID(BaseDao<T> r5, String r6) {
            BaseDao r7 = (BaseDao) ZeusTransformUtils.wrapperContextForParams(r5, BaseDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, Api.KEY_UUID);
            return (T) CollectionsKt.firstOrNull(r7.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM " + r7.getTableName() + " WHERE uuid = ? LIMIT 1", new String[]{r6}), SupportSQLiteQuery.class, "com.obric.memorydata.plugin")));
        }

        public static <T> T queryOne(BaseDao<T> r4) {
            BaseDao r5 = (BaseDao) ZeusTransformUtils.wrapperContextForParams(r4, BaseDao.class, "com.obric.memorydata.plugin");
            return (T) CollectionsKt.firstOrNull(r5.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM " + r5.getTableName() + " LIMIT 1"), SupportSQLiteQuery.class, "com.obric.memorydata.plugin")));
        }

        public static <T> List<T> queryWithLimitAndOffset(BaseDao<T> r4, int r5, int r6) {
            BaseDao r7 = (BaseDao) ZeusTransformUtils.wrapperContextForParams(r4, BaseDao.class, "com.obric.memorydata.plugin");
            return r7.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM " + r7.getTableName() + " LIMIT " + r5 + " OFFSET " + r6), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }
    }

    void bulkDelete(List<T> r1);

    void bulkInsert(List<T> r1);

    int delete(T r1);

    int deleteAll();

    String getTableName();

    long insert(T r1);

    List<Long> insertAll(List<T> r1);

    List<T> queryAll();

    int queryAllCount();

    T queryById(long r1);

    List<T> queryByIds(List<Long> r1);

    T queryByUUID(String r1);

    T queryOne();

    List<T> queryWithLimitAndOffset(int r1, int r2);

    List<T> rawQuery(SupportSQLiteQuery r1);

    Cursor rawQueryForCursor(SupportSQLiteQuery r1);

    int rawQueryForInt(SupportSQLiteQuery r1);

    long rawQueryForLong(SupportSQLiteQuery r1);

    int update(T r1);

    void updateAll(List<T> r1);
}
