package com.obric.memorydata.personalcontext.api;

import android.content.Context;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.news.common.service.manager.IService;
import com.obric.capabilitykit.EntitySupplier;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.sync.EntitySyncDataSupplier;
import com.obric.memorydata.middleware.api.IAgentServiceProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 $2\u00020\u0001:\u0001$J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH&J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH&J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\fH&J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\fH&J$\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\f2\u0006\u0010\u0013\u001a\u00020\u0014H&J\u001a\u0010\u0015\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\u0007H'J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H&J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH&J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00140\fH&J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\u0014H&J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\fH&J\b\u0010\u001e\u001a\u00020\u0003H&J\b\u0010\u001f\u001a\u00020\u0003H&J\b\u0010 \u001a\u00020\u0003H&J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#H&¨\u0006%"}, d2 = {"Lcom/obric/memorydata/personalcontext/api/IEntityCollectorService;", "Lcom/bytedance/news/common/service/manager/IService;", "initDataCollector", "", "context", "Landroid/content/Context;", "syncDataDelay", "", "hasPermission", "dataTag", "", "getAllContactAndSmsData", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "getAllContactAndCallHistoryData", "getAllCallHistoryData", "getAllSmsData", "getDataAndTriggerIndex", "noPcIds", "entityType", "", "reIndexData", "noNeedDelete", "getEntitySupplier", "Lcom/obric/capabilitykit/EntitySupplier;", "getEntitySyncDataSupplier", "Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;", "getDonateEntityTypeList", "getPackageNameByEntityType", "getNeedRequestPermissions", CommonConsts.APM_INNER_EVENT_COST_START, "stop", "syncData", "registerIAgentServiceProvider", "agentServiceProvider", "Lcom/obric/memorydata/middleware/api/IAgentServiceProvider;", "Companion", "personal_context_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IEntityCollectorService extends IService {
    public static final String ALBUM_TAG = "data_collector_album";
    public static final a Companion = null;
    public static final String FILE_TAG = "data_collector_file";
    public static final String PHOTO_TAG = "data_collector_photo";
    public static final String SCHEDULE_TAG = "data_collector_schedule";
    public static final String SMS_TAG = "data_collector_sms";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/personalcontext/api/IEntityCollectorService$Companion;", "", "<init>", "()V", "SMS_TAG", "", "FILE_TAG", "PHOTO_TAG", "ALBUM_TAG", "SCHEDULE_TAG", "personal_context_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f12032a = null;

        static {
            f12032a = new a();
        }

        private a() {
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b {
        public static /* synthetic */ void a(IEntityCollectorService r2, Context r3, boolean r4, int r5, Object r6) {
            IEntityCollectorService r7 = (IEntityCollectorService) ZeusTransformUtils.wrapperContextForParams(r2, IEntityCollectorService.class, "com.obric.memorydata.plugin");
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            if (r6 != null) goto L10;
            if ((r5 & 2) == 0) goto L7;
            r4 = true;
        L7:
            r7.initDataCollector(r8, r4);
            return;
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initDataCollector");
        }

        public static /* synthetic */ void a(IEntityCollectorService r2, String r3, boolean r4, int r5, Object r6) {
            IEntityCollectorService r7 = (IEntityCollectorService) ZeusTransformUtils.wrapperContextForParams(r2, IEntityCollectorService.class, "com.obric.memorydata.plugin");
            if (r6 != null) goto L10;
            if ((r5 & 2) == 0) goto L7;
            r4 = false;
        L7:
            r7.reIndexData(r3, r4);
            return;
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reIndexData");
        }
    }

    static {
        Companion = a.f12032a;
    }

    List<AppEntity> getAllCallHistoryData();

    List<AppEntity> getAllContactAndCallHistoryData();

    List<AppEntity> getAllContactAndSmsData();

    List<AppEntity> getAllSmsData();

    List<AppEntity> getDataAndTriggerIndex(List<String> r1, int r2);

    List<Integer> getDonateEntityTypeList();

    EntitySupplier getEntitySupplier();

    EntitySyncDataSupplier getEntitySyncDataSupplier();

    List<String> getNeedRequestPermissions();

    String getPackageNameByEntityType(int r1);

    boolean hasPermission();

    boolean hasPermission(String r1);

    void initDataCollector(Context r1, boolean r2);

    void reIndexData(String r1, boolean r2);

    void registerIAgentServiceProvider(IAgentServiceProvider r1);

    void start();

    void stop();

    void syncData();
}
