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
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010#\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006H\u0016J\u0012\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\tH\u0016J\u0012\u0010\u000b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\tH\u0016J\u0012\u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\rH\u0016J\u001c\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u001e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u00182\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00110\u0018H\u0016J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00110\u0018H\u0016J\u0014\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u0014\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J&\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00110$H\u0016J\u001e\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010(\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u0018\u0010)\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0011H\u0016J\u0012\u0010+\u001a\f\u0012\u0006\b\u0001\u0012\u00020-\u0018\u00010,H\u0016J\b\u0010.\u001a\u00020\u0016H\u0016J \u0010/\u001a\u001a\u0012\u0006\b\u0001\u0012\u00020\u0007\u0012\u0006\b\u0001\u0012\u00020\n\u0012\u0006\b\u0001\u0012\u00020\u000e00H\u0016J\u001a\u00101\u001a\u0004\u0018\u0001022\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/obric/memorydata/database/index/DecoratedEntityIndex;", "Lcom/obric/memorydata/database/index/BaseEntityIndex;", "delegate", "<init>", "(Lcom/obric/memorydata/database/index/BaseEntityIndex;)V", "getRawDao", "Lcom/obric/memorydata/database/dao/IAppEntityRawDbDao;", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "getTextCopilotDao", "Lcom/obric/memorydata/database/dao/IAppEntityVectorCopilotDao;", "Lcom/obric/memorydata/database/entity/AbstractVectorCopilotEntity;", "getImageCopilotDao", "getContentTimeDao", "Lcom/obric/memorydata/database/dao/IAppEntityContentTimeDao;", "Lcom/obric/memorydata/database/entity/AbstractContentTimeEntity;", "buildKeywordIndexMap", "", "", "entity", "getKeywordSchema", "Lcom/obric/search/api/schema/impl/FullTextSearchSchema;", "hasKeywordSchema", "", "getNeedUpdateColumns", "", "oldRawEntity", "newRawEntity", "getAllColumns", "getPendingTaskColumns", "getKeywordColumnMap", "getContentTimeColumns", "assignmentAssociateField", "", "oldEntity", "newEntity", "changeColumns", "", "generateIndexPendingTask", "", "Lcom/obric/memorydata/database/entity/IndexPendingEntity;", "columnName", "executeIndexPendingTask", "updateField", "getHistoryEntityDao", "Lcom/obric/memorydata/database/dao/IHistoryEntityDao;", "Lcom/obric/memorydata/database/entity/AbstractHistoryEntity;", "isBuildMetaInfoFullContent", "getEntityIndexHelperInstance", "Lcom/obric/memorydata/database/index/EntityIndexHelper;", "getValueByColumn", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class p implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f9431a;

    public p(e r3) {
        e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "delegate");
        this.f9431a = r4;
    }

    @Override // com.obric.memorydata.database.index.e
    public void assignmentAssociateField(com.obric.memorydata.database.entity.d r3, com.obric.memorydata.database.entity.d r4, Set<String> r5) {
        Set<String> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "oldEntity");
        Intrinsics.checkNotNullParameter(r4, "newEntity");
        Intrinsics.checkNotNullParameter(r6, "changeColumns");
        this.f9431a.assignmentAssociateField(r3, r4, r6);
    }

    @Override // com.obric.memorydata.database.index.e
    public Map<String, String> buildKeywordIndexMap(com.obric.memorydata.database.entity.d r2) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        return this.f9431a.buildKeywordIndexMap(r2);
    }

    @Override // com.obric.memorydata.database.index.e
    public boolean executeIndexPendingTask(com.obric.memorydata.database.entity.d r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        Intrinsics.checkNotNullParameter(r3, "updateField");
        return this.f9431a.executeIndexPendingTask(r2, r3);
    }

    @Override // com.obric.memorydata.database.index.e
    public List<cd> generateIndexPendingTask(String r2, com.obric.memorydata.database.entity.d r3) {
        Intrinsics.checkNotNullParameter(r2, "columnName");
        Intrinsics.checkNotNullParameter(r3, "entity");
        return this.f9431a.generateIndexPendingTask(r2, r3);
    }

    @Override // com.obric.memorydata.database.index.e
    public Set<String> getAllColumns() {
        return this.f9431a.getAllColumns();
    }

    @Override // com.obric.memorydata.database.index.e
    public Map<String, String> getContentTimeColumns() {
        return this.f9431a.getContentTimeColumns();
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityContentTimeDao<? extends com.obric.memorydata.database.entity.b> getContentTimeDao() {
        return this.f9431a.getContentTimeDao();
    }

    @Override // com.obric.memorydata.database.index.e
    public t<? extends com.obric.memorydata.database.entity.d, ? extends com.obric.memorydata.database.entity.i, ? extends com.obric.memorydata.database.entity.b> getEntityIndexHelperInstance() {
        return this.f9431a.getEntityIndexHelperInstance();
    }

    @Override // com.obric.memorydata.database.index.e
    public IHistoryEntityDao<? extends com.obric.memorydata.database.entity.c> getHistoryEntityDao() {
        return this.f9431a.getHistoryEntityDao();
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityVectorCopilotDao<? extends com.obric.memorydata.database.entity.i> getImageCopilotDao() {
        return this.f9431a.getImageCopilotDao();
    }

    @Override // com.obric.memorydata.database.index.e
    public Map<String, String> getKeywordColumnMap() {
        return this.f9431a.getKeywordColumnMap();
    }

    @Override // com.obric.memorydata.database.index.e
    public FullTextSearchSchema getKeywordSchema() {
        return this.f9431a.getKeywordSchema();
    }

    @Override // com.obric.memorydata.database.index.e
    public Set<String> getNeedUpdateColumns(com.obric.memorydata.database.entity.d r2, com.obric.memorydata.database.entity.d r3) {
        Intrinsics.checkNotNullParameter(r2, "oldRawEntity");
        Intrinsics.checkNotNullParameter(r3, "newRawEntity");
        return this.f9431a.getNeedUpdateColumns(r2, r3);
    }

    @Override // com.obric.memorydata.database.index.e
    public Set<String> getPendingTaskColumns() {
        return this.f9431a.getPendingTaskColumns();
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityRawDbDao<? extends com.obric.memorydata.database.entity.d> getRawDao() {
        return this.f9431a.getRawDao();
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityVectorCopilotDao<? extends com.obric.memorydata.database.entity.i> getTextCopilotDao() {
        return this.f9431a.getTextCopilotDao();
    }

    @Override // com.obric.memorydata.database.index.e
    public Object getValueByColumn(com.obric.memorydata.database.entity.d r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        Intrinsics.checkNotNullParameter(r3, "columnName");
        return this.f9431a.getValueByColumn(r2, r3);
    }

    @Override // com.obric.memorydata.database.index.e
    public boolean hasKeywordSchema() {
        return this.f9431a.hasKeywordSchema();
    }

    @Override // com.obric.memorydata.database.index.e
    public boolean isBuildMetaInfoFullContent() {
        return this.f9431a.isBuildMetaInfoFullContent();
    }
}
