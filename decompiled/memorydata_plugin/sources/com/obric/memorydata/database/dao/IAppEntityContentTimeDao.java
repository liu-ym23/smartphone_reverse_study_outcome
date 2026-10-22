package com.obric.memorydata.database.dao;

import androidx.exifinterface.media.ExifInterface;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0016J\u0016\u0010\u0010\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0016J\u0016\u0010\u0013\u001a\u00020\u000f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/database/dao/IAppEntityContentTimeDao;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/obric/memorydata/database/entity/AbstractContentTimeEntity;", "Lcom/obric/memorydata/database/dao/BaseDao;", "delete", "", ChatMessage.TYPE_QUERY, "Landroidx/sqlite/db/SupportSQLiteQuery;", "deleteByRawDbId", "rawDbId", "", "deleteByRawDbIdAndColumns", "", "columnSet", "", "", "deleteByRawDbIds", "rawDbIds", "", "buildColumnGroup", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IAppEntityContentTimeDao<T extends b> extends BaseDao<T> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <T extends b> String buildColumnGroup(IAppEntityContentTimeDao<T> r4, Set<String> r5) {
            IAppEntityContentTimeDao r6 = (IAppEntityContentTimeDao) ZeusTransformUtils.wrapperContextForParams(r4, IAppEntityContentTimeDao.class, "com.obric.memorydata.plugin");
            Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, "columnSet");
            StringBuilder r8 = new StringBuilder();
            r8.append('(');
            Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
            boolean r0 = false;
        L4:
            if (r9.hasNext() == false) goto L9;
            String r2 = (String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.memorydata.plugin");
            if (r0 == false) goto L8;
            r8.append(',');
        L8:
            r8.append('\'');
            r8.append(r2);
            r8.append('\'');
            r0 = true;
            goto L4
        L9:
            r8.append(')');
            String r10 = r8.toString();
            Intrinsics.checkNotNullExpressionValue(r10, "toString(...)");
            return r10;
        }

        public static <T extends b> int deleteAll(IAppEntityContentTimeDao<T> r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((IAppEntityContentTimeDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityContentTimeDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static <T extends b> int deleteByRawDbId(IAppEntityContentTimeDao<T> r3, long r4) {
            IAppEntityContentTimeDao r5 = (IAppEntityContentTimeDao) ZeusTransformUtils.wrapperContextForParams(r3, IAppEntityContentTimeDao.class, "com.obric.memorydata.plugin");
            return r5.delete((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("DELETE FROM " + r5.getTableName() + " WHERE rawDbId = ?", new Object[]{Long.valueOf(r4)}), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static <T extends b> void deleteByRawDbIdAndColumns(IAppEntityContentTimeDao<T> r3, long r4, Set<String> r6) {
            IAppEntityContentTimeDao r5 = (IAppEntityContentTimeDao) ZeusTransformUtils.wrapperContextForParams(r3, IAppEntityContentTimeDao.class, "com.obric.memorydata.plugin");
            Set<String> r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
            if (r7 != null) goto L7;
            r5.deleteByRawDbId(r4);
            return;
        L7:
            if (r7.isEmpty() == false) goto L9;
            return;
        L9:
            r5.delete((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("DELETE FROM " + r5.getTableName() + " WHERE rawDbId = ? AND rawDbColumn in " + r5.buildColumnGroup(r7), new Long[]{Long.valueOf(r4)}), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static <T extends b> int deleteByRawDbIds(IAppEntityContentTimeDao<T> r11, List<Long> r12) {
            IAppEntityContentTimeDao r13 = (IAppEntityContentTimeDao) ZeusTransformUtils.wrapperContextForParams(r11, IAppEntityContentTimeDao.class, "com.obric.memorydata.plugin");
            List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r14, "rawDbIds");
            if (r14.isEmpty() == false) goto L7;
            return 0;
        L7:
            return r13.delete((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("DELETE FROM " + r13.getTableName() + " WHERE rawDbId in (" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null) + ')'), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static <T extends b> List<T> queryAll(IAppEntityContentTimeDao<T> r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((IAppEntityContentTimeDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityContentTimeDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static <T extends b> int queryAllCount(IAppEntityContentTimeDao<T> r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((IAppEntityContentTimeDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityContentTimeDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static <T extends b> T queryById(IAppEntityContentTimeDao<T> r2, long r3) {
            return (T) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((IAppEntityContentTimeDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityContentTimeDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), b.class, "com.obric.memorydata.plugin");
        }

        public static <T extends b> List<T> queryByIds(IAppEntityContentTimeDao<T> r2, List<Long> r3) {
            IAppEntityContentTimeDao r4 = (IAppEntityContentTimeDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityContentTimeDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static <T extends b> T queryByUUID(IAppEntityContentTimeDao<T> r2, String r3) {
            IAppEntityContentTimeDao r4 = (IAppEntityContentTimeDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityContentTimeDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (T) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), b.class, "com.obric.memorydata.plugin");
        }

        public static <T extends b> T queryOne(IAppEntityContentTimeDao<T> r2) {
            return (T) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((IAppEntityContentTimeDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityContentTimeDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), b.class, "com.obric.memorydata.plugin");
        }

        public static <T extends b> List<T> queryWithLimitAndOffset(IAppEntityContentTimeDao<T> r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((IAppEntityContentTimeDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityContentTimeDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    String buildColumnGroup(Set<String> r1);

    int delete(SupportSQLiteQuery r1);

    int deleteByRawDbId(long r1);

    void deleteByRawDbIdAndColumns(long r1, Set<String> r3);

    int deleteByRawDbIds(List<Long> r1);
}
