package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.AssistantChatMessageEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H'J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/database/dao/AssistantChatMessageDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/AssistantChatMessageEntity;", "insertIgnore", "", "entity", "getTableName", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface AssistantChatMessageDao extends BaseDao<AssistantChatMessageEntity> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(AssistantChatMessageDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((AssistantChatMessageDao) ZeusTransformUtils.wrapperContextForParams(r2, AssistantChatMessageDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(AssistantChatMessageDao r2) {
            AssistantChatMessageDao r3 = (AssistantChatMessageDao) ZeusTransformUtils.wrapperContextForParams(r2, AssistantChatMessageDao.class, "com.obric.memorydata.plugin");
            return "AssistantChatMessageEntity";
        }

        public static List<AssistantChatMessageEntity> queryAll(AssistantChatMessageDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((AssistantChatMessageDao) ZeusTransformUtils.wrapperContextForParams(r2, AssistantChatMessageDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(AssistantChatMessageDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((AssistantChatMessageDao) ZeusTransformUtils.wrapperContextForParams(r2, AssistantChatMessageDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static AssistantChatMessageEntity queryById(AssistantChatMessageDao r2, long r3) {
            return (AssistantChatMessageEntity) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((AssistantChatMessageDao) ZeusTransformUtils.wrapperContextForParams(r2, AssistantChatMessageDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), AssistantChatMessageEntity.class, "com.obric.memorydata.plugin");
        }

        public static List<AssistantChatMessageEntity> queryByIds(AssistantChatMessageDao r2, List<Long> r3) {
            AssistantChatMessageDao r4 = (AssistantChatMessageDao) ZeusTransformUtils.wrapperContextForParams(r2, AssistantChatMessageDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static AssistantChatMessageEntity queryByUUID(AssistantChatMessageDao r2, String r3) {
            AssistantChatMessageDao r4 = (AssistantChatMessageDao) ZeusTransformUtils.wrapperContextForParams(r2, AssistantChatMessageDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (AssistantChatMessageEntity) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), AssistantChatMessageEntity.class, "com.obric.memorydata.plugin");
        }

        public static AssistantChatMessageEntity queryOne(AssistantChatMessageDao r2) {
            return (AssistantChatMessageEntity) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((AssistantChatMessageDao) ZeusTransformUtils.wrapperContextForParams(r2, AssistantChatMessageDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), AssistantChatMessageEntity.class, "com.obric.memorydata.plugin");
        }

        public static List<AssistantChatMessageEntity> queryWithLimitAndOffset(AssistantChatMessageDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((AssistantChatMessageDao) ZeusTransformUtils.wrapperContextForParams(r2, AssistantChatMessageDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    long insertIgnore(AssistantChatMessageEntity r1);
}
