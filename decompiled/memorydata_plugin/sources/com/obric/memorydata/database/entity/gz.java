package com.obric.memorydata.database.entity;

import com.obric.memorydata.database.dao.IAppEntityContentTimeDao;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.dao.IAppEntityVectorCopilotDao;
import com.obric.memorydata.database.dao.IHistoryEntityDao;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003H\u0016J\u0012\u0010\u0005\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u0006H\u0016J\u0012\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\u0006H\u0016J\u0012\u0010\n\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/database/entity/RawNoteRecordingTextEntityIndex;", "Lcom/obric/memorydata/database/index/BaseEntityIndex;", "getRawDao", "Lcom/obric/memorydata/database/dao/IAppEntityRawDbDao;", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "getTextCopilotDao", "Lcom/obric/memorydata/database/dao/IAppEntityVectorCopilotDao;", "Lcom/obric/memorydata/database/entity/AbstractTextVectorCopilotEntity;", "getImageCopilotDao", "Lcom/obric/memorydata/database/entity/AbstractVectorCopilotEntity;", "getContentTimeDao", "Lcom/obric/memorydata/database/dao/IAppEntityContentTimeDao;", "Lcom/obric/memorydata/database/entity/AbstractContentTimeEntity;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface gz extends com.obric.memorydata.database.index.e {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static IAppEntityRawDbDao<? extends d> a(gz r2) {
            gz r3 = (gz) ZeusTransformUtils.wrapperContextForParams(r2, gz.class, "com.obric.memorydata.plugin");
            return (IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getNoteRecordingTextRawDbDao(), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
        }

        public static IAppEntityVectorCopilotDao<? extends h> b(gz r2) {
            gz r3 = (gz) ZeusTransformUtils.wrapperContextForParams(r2, gz.class, "com.obric.memorydata.plugin");
            return (IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getNoteRecordingTextTextVectorCopilotDao(), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin");
        }

        public static IAppEntityVectorCopilotDao<? extends i> c(gz r2) {
            gz r3 = (gz) ZeusTransformUtils.wrapperContextForParams(r2, gz.class, "com.obric.memorydata.plugin");
            return null;
        }

        public static IAppEntityContentTimeDao<? extends b> d(gz r2) {
            gz r3 = (gz) ZeusTransformUtils.wrapperContextForParams(r2, gz.class, "com.obric.memorydata.plugin");
            return null;
        }

        public static IHistoryEntityDao<? extends c> e(gz r2) {
            return com.obric.memorydata.database.index.e.a.a((com.obric.memorydata.database.index.e) ZeusTransformUtils.preCheckCast((gz) ZeusTransformUtils.wrapperContextForParams(r2, gz.class, "com.obric.memorydata.plugin"), com.obric.memorydata.database.index.e.class, "com.obric.memorydata.plugin"));
        }
    }
}
