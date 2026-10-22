package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.PersonImageProfileEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H'¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/database/dao/PersonImageProfileDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/PersonImageProfileEntity;", "getTableName", "", "queryByProfileId", "", "profileId", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface PersonImageProfileDao extends BaseDao<PersonImageProfileEntity> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(PersonImageProfileDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((PersonImageProfileDao) ZeusTransformUtils.wrapperContextForParams(r2, PersonImageProfileDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(PersonImageProfileDao r2) {
            PersonImageProfileDao r3 = (PersonImageProfileDao) ZeusTransformUtils.wrapperContextForParams(r2, PersonImageProfileDao.class, "com.obric.memorydata.plugin");
            return "PersonImageProfile";
        }

        public static List<PersonImageProfileEntity> queryAll(PersonImageProfileDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((PersonImageProfileDao) ZeusTransformUtils.wrapperContextForParams(r2, PersonImageProfileDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(PersonImageProfileDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((PersonImageProfileDao) ZeusTransformUtils.wrapperContextForParams(r2, PersonImageProfileDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static PersonImageProfileEntity queryById(PersonImageProfileDao r2, long r3) {
            return (PersonImageProfileEntity) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((PersonImageProfileDao) ZeusTransformUtils.wrapperContextForParams(r2, PersonImageProfileDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), PersonImageProfileEntity.class, "com.obric.memorydata.plugin");
        }

        public static List<PersonImageProfileEntity> queryByIds(PersonImageProfileDao r2, List<Long> r3) {
            PersonImageProfileDao r4 = (PersonImageProfileDao) ZeusTransformUtils.wrapperContextForParams(r2, PersonImageProfileDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static PersonImageProfileEntity queryByUUID(PersonImageProfileDao r2, String r3) {
            PersonImageProfileDao r4 = (PersonImageProfileDao) ZeusTransformUtils.wrapperContextForParams(r2, PersonImageProfileDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (PersonImageProfileEntity) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), PersonImageProfileEntity.class, "com.obric.memorydata.plugin");
        }

        public static PersonImageProfileEntity queryOne(PersonImageProfileDao r2) {
            return (PersonImageProfileEntity) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((PersonImageProfileDao) ZeusTransformUtils.wrapperContextForParams(r2, PersonImageProfileDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), PersonImageProfileEntity.class, "com.obric.memorydata.plugin");
        }

        public static List<PersonImageProfileEntity> queryWithLimitAndOffset(PersonImageProfileDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((PersonImageProfileDao) ZeusTransformUtils.wrapperContextForParams(r2, PersonImageProfileDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    List<PersonImageProfileEntity> queryByProfileId(String r1);
}
