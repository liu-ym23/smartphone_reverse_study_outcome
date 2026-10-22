package com.obric.memorydata.database.entity;

import com.obric.memorydata.database.dao.IAppEntityContentTimeDao;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.dao.IAppEntityVectorCopilotDao;
import com.obric.memorydata.database.dao.IHistoryEntityDao;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003H\u0016J\u0010\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006H\u0016J\u0010\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006H\u0016J\u0012\u0010\t\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000b\u0018\u00010\nH\u0016J\u0012\u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/database/entity/RawPhotoIndex;", "Lcom/obric/memorydata/database/index/BaseEntityIndex;", "getRawDao", "Lcom/obric/memorydata/database/dao/IAppEntityRawDbDao;", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "getTextCopilotDao", "Lcom/obric/memorydata/database/dao/IAppEntityVectorCopilotDao;", "Lcom/obric/memorydata/database/entity/AbstractVectorCopilotEntity;", "getImageCopilotDao", "getHistoryEntityDao", "Lcom/obric/memorydata/database/dao/IHistoryEntityDao;", "Lcom/obric/memorydata/database/entity/AbstractHistoryEntity;", "getContentTimeDao", "Lcom/obric/memorydata/database/dao/IAppEntityContentTimeDao;", "Lcom/obric/memorydata/database/entity/AbstractContentTimeEntity;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface hf extends com.obric.memorydata.database.index.e {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static IAppEntityRawDbDao<? extends d> a(hf r2) {
            hf r3 = (hf) ZeusTransformUtils.wrapperContextForParams(r2, hf.class, "com.obric.memorydata.plugin");
            return (IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getPhotoRawDbDao(), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
        }

        public static IAppEntityVectorCopilotDao<? extends i> b(hf r2) {
            hf r3 = (hf) ZeusTransformUtils.wrapperContextForParams(r2, hf.class, "com.obric.memorydata.plugin");
            return (IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getPhotoTextVectorCopilotDao(), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin");
        }

        public static IAppEntityVectorCopilotDao<? extends i> c(hf r2) {
            hf r3 = (hf) ZeusTransformUtils.wrapperContextForParams(r2, hf.class, "com.obric.memorydata.plugin");
            return (IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getPhotoImageVectorCopilotDao(), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin");
        }

        public static IHistoryEntityDao<? extends c> d(hf r2) {
            hf r3 = (hf) ZeusTransformUtils.wrapperContextForParams(r2, hf.class, "com.obric.memorydata.plugin");
            return (IHistoryEntityDao) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawPhotoHistoryEntityDao(), IHistoryEntityDao.class, "com.obric.memorydata.plugin");
        }

        public static IAppEntityContentTimeDao<? extends b> e(hf r2) {
            hf r3 = (hf) ZeusTransformUtils.wrapperContextForParams(r2, hf.class, "com.obric.memorydata.plugin");
            return (IAppEntityContentTimeDao) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawPhotoContentTimeDao(), IAppEntityContentTimeDao.class, "com.obric.memorydata.plugin");
        }
    }
}
