package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.PersonAudioProfileEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H'J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0004H'¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/database/dao/PersonAudioProfileDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/PersonAudioProfileEntity;", "getTableName", "", "queryAll", "", "queryByProfileId", "profileId", "deleteByProfileId", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface PersonAudioProfileDao extends BaseDao<PersonAudioProfileEntity> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(PersonAudioProfileDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((PersonAudioProfileDao) ZeusTransformUtils.wrapperContextForParams(r2, PersonAudioProfileDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(PersonAudioProfileDao r2) {
            PersonAudioProfileDao r3 = (PersonAudioProfileDao) ZeusTransformUtils.wrapperContextForParams(r2, PersonAudioProfileDao.class, "com.obric.memorydata.plugin");
            return "PersonAudioProfile";
        }

        public static int queryAllCount(PersonAudioProfileDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((PersonAudioProfileDao) ZeusTransformUtils.wrapperContextForParams(r2, PersonAudioProfileDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static PersonAudioProfileEntity queryById(PersonAudioProfileDao r2, long r3) {
            return (PersonAudioProfileEntity) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((PersonAudioProfileDao) ZeusTransformUtils.wrapperContextForParams(r2, PersonAudioProfileDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), PersonAudioProfileEntity.class, "com.obric.memorydata.plugin");
        }

        public static List<PersonAudioProfileEntity> queryByIds(PersonAudioProfileDao r2, List<Long> r3) {
            PersonAudioProfileDao r4 = (PersonAudioProfileDao) ZeusTransformUtils.wrapperContextForParams(r2, PersonAudioProfileDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static PersonAudioProfileEntity queryByUUID(PersonAudioProfileDao r2, String r3) {
            PersonAudioProfileDao r4 = (PersonAudioProfileDao) ZeusTransformUtils.wrapperContextForParams(r2, PersonAudioProfileDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (PersonAudioProfileEntity) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), PersonAudioProfileEntity.class, "com.obric.memorydata.plugin");
        }

        public static PersonAudioProfileEntity queryOne(PersonAudioProfileDao r2) {
            return (PersonAudioProfileEntity) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((PersonAudioProfileDao) ZeusTransformUtils.wrapperContextForParams(r2, PersonAudioProfileDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), PersonAudioProfileEntity.class, "com.obric.memorydata.plugin");
        }

        public static List<PersonAudioProfileEntity> queryWithLimitAndOffset(PersonAudioProfileDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((PersonAudioProfileDao) ZeusTransformUtils.wrapperContextForParams(r2, PersonAudioProfileDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    int deleteByProfileId(String r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    @Override // com.obric.memorydata.database.dao.BaseDao
    List<PersonAudioProfileEntity> queryAll();

    List<PersonAudioProfileEntity> queryByProfileId(String r1);
}
