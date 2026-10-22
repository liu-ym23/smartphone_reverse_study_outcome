package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.entity.fs;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0007\u001a\u00020\u0004H'J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H'J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH'J\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0006H'J>\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H'J6\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H'J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0004H'¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/database/dao/RawChatAppChatDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/RawChatEntity;", "getTableName", "", "queryNeedUploadChatNames", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "queryNeedUploadWithChatName", "chatName", "updateAsUploaded", "", OaidModel.KEY_ID, "", "ids", "queryChatMsgWithAccurateTime", "timestamp", "msgPerson", "msgType", "", "msgContent", "queryChatMsg", "getNeedUploadCount", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface RawChatAppChatDao extends BaseDao<fs> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(RawChatAppChatDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((RawChatAppChatDao) ZeusTransformUtils.wrapperContextForParams(r2, RawChatAppChatDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(RawChatAppChatDao r2) {
            RawChatAppChatDao r3 = (RawChatAppChatDao) ZeusTransformUtils.wrapperContextForParams(r2, RawChatAppChatDao.class, "com.obric.memorydata.plugin");
            return "RawWxChat";
        }

        public static List<fs> queryAll(RawChatAppChatDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((RawChatAppChatDao) ZeusTransformUtils.wrapperContextForParams(r2, RawChatAppChatDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(RawChatAppChatDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((RawChatAppChatDao) ZeusTransformUtils.wrapperContextForParams(r2, RawChatAppChatDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static fs queryById(RawChatAppChatDao r2, long r3) {
            return (fs) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((RawChatAppChatDao) ZeusTransformUtils.wrapperContextForParams(r2, RawChatAppChatDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), fs.class, "com.obric.memorydata.plugin");
        }

        public static List<fs> queryByIds(RawChatAppChatDao r2, List<Long> r3) {
            RawChatAppChatDao r4 = (RawChatAppChatDao) ZeusTransformUtils.wrapperContextForParams(r2, RawChatAppChatDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static fs queryByUUID(RawChatAppChatDao r2, String r3) {
            RawChatAppChatDao r4 = (RawChatAppChatDao) ZeusTransformUtils.wrapperContextForParams(r2, RawChatAppChatDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (fs) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), fs.class, "com.obric.memorydata.plugin");
        }

        public static fs queryOne(RawChatAppChatDao r2) {
            return (fs) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((RawChatAppChatDao) ZeusTransformUtils.wrapperContextForParams(r2, RawChatAppChatDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), fs.class, "com.obric.memorydata.plugin");
        }

        public static List<fs> queryWithLimitAndOffset(RawChatAppChatDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((RawChatAppChatDao) ZeusTransformUtils.wrapperContextForParams(r2, RawChatAppChatDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    long getNeedUploadCount(String r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    List<fs> queryChatMsg(String r1, String r2, int r3, String r4, String r5);

    List<fs> queryChatMsgWithAccurateTime(long r1, String r3, String r4, int r5, String r6, String r7);

    List<String> queryNeedUploadChatNames(String r1);

    List<fs> queryNeedUploadWithChatName(String r1);

    void updateAsUploaded(long r1);

    void updateAsUploaded(List<Long> r1);
}
