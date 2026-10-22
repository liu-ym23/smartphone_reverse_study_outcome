package com.obric.memorydata.database.index;

import com.obric.memorydata.database.dao.IAppEntityContentTimeDao;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.dao.IAppEntityVectorCopilotDao;
import com.obric.memorydata.database.dao.IHistoryEntityDao;
import com.obric.memorydata.database.entity.cd;
import com.obric.search.api.schema.impl.FullTextSearchSchema;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010#\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003H&J\u0012\u0010\u0005\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u0006H&J\u0012\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u0006H&J\u0012\u0010\t\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000b\u0018\u00010\nH&J\u001c\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0004H&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\b\u0010\u0012\u001a\u00020\u0013H&J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H&J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015H&J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015H&J\u0014\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rH&J\u0014\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rH&J&\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0!H&J\u001e\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H&J\u0018\u0010&\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u000eH&J\u0012\u0010(\u001a\f\u0012\u0006\b\u0001\u0012\u00020*\u0018\u00010)H\u0016J\u001a\u0010+\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u000eH&J\b\u0010,\u001a\u00020\u0013H&J \u0010-\u001a\u001a\u0012\u0006\b\u0001\u0012\u00020\u0004\u0012\u0006\b\u0001\u0012\u00020\u0007\u0012\u0006\b\u0001\u0012\u00020\u000b0.H&¨\u0006/"}, d2 = {"Lcom/obric/memorydata/database/index/BaseEntityIndex;", "", "getRawDao", "Lcom/obric/memorydata/database/dao/IAppEntityRawDbDao;", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "getTextCopilotDao", "Lcom/obric/memorydata/database/dao/IAppEntityVectorCopilotDao;", "Lcom/obric/memorydata/database/entity/AbstractVectorCopilotEntity;", "getImageCopilotDao", "getContentTimeDao", "Lcom/obric/memorydata/database/dao/IAppEntityContentTimeDao;", "Lcom/obric/memorydata/database/entity/AbstractContentTimeEntity;", "buildKeywordIndexMap", "", "", "entity", "getKeywordSchema", "Lcom/obric/search/api/schema/impl/FullTextSearchSchema;", "hasKeywordSchema", "", "getNeedUpdateColumns", "", "oldRawEntity", "newRawEntity", "getAllColumns", "getPendingTaskColumns", "getKeywordColumnMap", "getContentTimeColumns", "assignmentAssociateField", "", "oldEntity", "newEntity", "changeColumns", "", "generateIndexPendingTask", "", "Lcom/obric/memorydata/database/entity/IndexPendingEntity;", "columnName", "executeIndexPendingTask", "updateField", "getHistoryEntityDao", "Lcom/obric/memorydata/database/dao/IHistoryEntityDao;", "Lcom/obric/memorydata/database/entity/AbstractHistoryEntity;", "getValueByColumn", "isBuildMetaInfoFullContent", "getEntityIndexHelperInstance", "Lcom/obric/memorydata/database/index/EntityIndexHelper;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface e {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static IHistoryEntityDao<? extends com.obric.memorydata.database.entity.c> a(e r2) {
            e r3 = (e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.memorydata.plugin");
            return null;
        }
    }

    void assignmentAssociateField(com.obric.memorydata.database.entity.d r1, com.obric.memorydata.database.entity.d r2, Set<String> r3);

    Map<String, String> buildKeywordIndexMap(com.obric.memorydata.database.entity.d r1);

    boolean executeIndexPendingTask(com.obric.memorydata.database.entity.d r1, String r2);

    List<cd> generateIndexPendingTask(String r1, com.obric.memorydata.database.entity.d r2);

    Set<String> getAllColumns();

    Map<String, String> getContentTimeColumns();

    IAppEntityContentTimeDao<? extends com.obric.memorydata.database.entity.b> getContentTimeDao();

    t<? extends com.obric.memorydata.database.entity.d, ? extends com.obric.memorydata.database.entity.i, ? extends com.obric.memorydata.database.entity.b> getEntityIndexHelperInstance();

    IHistoryEntityDao<? extends com.obric.memorydata.database.entity.c> getHistoryEntityDao();

    IAppEntityVectorCopilotDao<? extends com.obric.memorydata.database.entity.i> getImageCopilotDao();

    Map<String, String> getKeywordColumnMap();

    FullTextSearchSchema getKeywordSchema();

    Set<String> getNeedUpdateColumns(com.obric.memorydata.database.entity.d r1, com.obric.memorydata.database.entity.d r2);

    Set<String> getPendingTaskColumns();

    IAppEntityRawDbDao<? extends com.obric.memorydata.database.entity.d> getRawDao();

    IAppEntityVectorCopilotDao<? extends com.obric.memorydata.database.entity.i> getTextCopilotDao();

    Object getValueByColumn(com.obric.memorydata.database.entity.d r1, String r2);

    boolean hasKeywordSchema();

    boolean isBuildMetaInfoFullContent();
}
