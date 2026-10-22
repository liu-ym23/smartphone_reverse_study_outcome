package com.obric.memorydata.personalcontext.api;

import com.bytedance.news.common.service.manager.IService;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H&J\u0016\u0010\f\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH&J=\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003H'¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0007H&J\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH&J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u000fH'J\u0018\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH&J\b\u0010\u001d\u001a\u00020\u0013H&J\u0018\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH&J\"\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000fH&J \u0010\"\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000fH&J&\u0010#\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH&J\u0018\u0010$\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010%\u001a\u00020&H&J \u0010'\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020&H&J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0013H&J\b\u0010)\u001a\u00020\u0003H&¨\u0006*"}, d2 = {"Lcom/obric/memorydata/personalcontext/api/IEntityManager;", "Lcom/bytedance/news/common/service/manager/IService;", "index", "", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "indexAllContactCallSmsEntity", "", "reindexAllData", "finishRunnable", "Ljava/lang/Runnable;", "noNeedDelete", "reIndexCertainApps", "packageList", "", "", "bulkDelete", "entityIds", "entityType", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "isBackUp", "(Ljava/util/List;ILjava/lang/String;Ljava/lang/Boolean;)Ljava/util/List;", "launchIndexTask", "bulkIndex", "entities", "deleteAll", "deleteByTypeAndPackageName", "type", "getEntityDonatedVersion", "isLazyIndexEntity", "getLazyIndexHistoryEntity", "", "entityId", "deleteLazyIndexHistoryEntity", "deleteLazyIndexHistoryEntityList", "removeLazyIndexHistoryEntity", "dbId", "", "resumeLazyIndexPendingTask", "deleteAllByEntityType", "isAllEntityDonated", "personal_context_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IEntityManager extends IService {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static /* synthetic */ List a(IEntityManager r2, List r3, int r4, String r5, Boolean r6, int r7, Object r8) {
            IEntityManager r9 = (IEntityManager) ZeusTransformUtils.wrapperContextForParams(r2, IEntityManager.class, "com.obric.memorydata.plugin");
            List<String> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            if (r8 != null) goto L10;
            if ((r7 & 8) == 0) goto L8;
            r6 = null;
        L8:
            return r9.bulkDelete(r10, r4, r5, r6);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bulkDelete");
        }
    }

    List<String> bulkDelete(List<String> r1, int r2, String r3, Boolean r4);

    List<String> bulkIndex(List<? extends AppEntity> r1);

    void deleteAll(String r1);

    boolean deleteAllByEntityType(int r1);

    void deleteByTypeAndPackageName(int r1, String r2);

    void deleteLazyIndexHistoryEntity(int r1, String r2, String r3);

    void deleteLazyIndexHistoryEntityList(int r1, String r2, List<String> r3);

    int getEntityDonatedVersion();

    Object getLazyIndexHistoryEntity(int r1, String r2, String r3);

    boolean index(AppEntity r1);

    void indexAllContactCallSmsEntity();

    boolean isAllEntityDonated();

    boolean isLazyIndexEntity(int r1, String r2);

    void launchIndexTask();

    void reIndexCertainApps(List<String> r1);

    void reindexAllData(Runnable r1, boolean r2);

    void removeLazyIndexHistoryEntity(int r1, long r2);

    void resumeLazyIndexPendingTask(int r1, String r2, long r3);
}
