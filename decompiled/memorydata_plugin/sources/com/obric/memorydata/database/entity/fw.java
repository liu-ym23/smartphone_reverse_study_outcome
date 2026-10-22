package com.obric.memorydata.database.entity;

import com.obric.memorydata.database.dao.IAppEntityContentTimeDao;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.dao.IAppEntityVectorCopilotDao;
import com.obric.memorydata.database.dao.IHistoryEntityDao;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003H\u0016J\u0010\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006H\u0016J\u0010\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006H\u0016J\u0012\u0010\t\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000b\u0018\u00010\nH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/database/entity/RawCommonVideoFrameIndex;", "Lcom/obric/memorydata/database/index/BaseEntityIndex;", "getRawDao", "Lcom/obric/memorydata/database/dao/IAppEntityRawDbDao;", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "getTextCopilotDao", "Lcom/obric/memorydata/database/dao/IAppEntityVectorCopilotDao;", "Lcom/obric/memorydata/database/entity/AbstractVectorCopilotEntity;", "getImageCopilotDao", "getContentTimeDao", "Lcom/obric/memorydata/database/dao/IAppEntityContentTimeDao;", "Lcom/obric/memorydata/database/entity/AbstractContentTimeEntity;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface fw extends com.obric.memorydata.database.index.e {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static IAppEntityRawDbDao<? extends d> a(fw r2) {
            fw r3 = (fw) ZeusTransformUtils.wrapperContextForParams(r2, fw.class, "com.obric.memorydata.plugin");
            return (IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getCommonVideoFrameRawDbDao(), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
        }

        public static IAppEntityVectorCopilotDao<? extends i> b(fw r2) {
            fw r3 = (fw) ZeusTransformUtils.wrapperContextForParams(r2, fw.class, "com.obric.memorydata.plugin");
            return (IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getCommonVideoFrameTextVectorCopilotDao(), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin");
        }

        public static IAppEntityVectorCopilotDao<? extends i> c(fw r2) {
            fw r3 = (fw) ZeusTransformUtils.wrapperContextForParams(r2, fw.class, "com.obric.memorydata.plugin");
            return (IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getCommonVideoFrameImageVectorCopilotDao(), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin");
        }

        public static IAppEntityContentTimeDao<? extends b> d(fw r2) {
            fw r3 = (fw) ZeusTransformUtils.wrapperContextForParams(r2, fw.class, "com.obric.memorydata.plugin");
            return null;
        }

        public static IHistoryEntityDao<? extends c> e(fw r2) {
            return com.obric.memorydata.database.index.e.a.a((com.obric.memorydata.database.index.e) ZeusTransformUtils.preCheckCast((fw) ZeusTransformUtils.wrapperContextForParams(r2, fw.class, "com.obric.memorydata.plugin"), com.obric.memorydata.database.index.e.class, "com.obric.memorydata.plugin"));
        }
    }
}
