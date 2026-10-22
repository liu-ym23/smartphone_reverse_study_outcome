package com.obric.memorydata.personalcontext.api;

import android.net.Uri;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.news.common.service.manager.IService;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.VideoFrame;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.personalcontext.util.EmbeddingState;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\bf\u0018\u0000 C2\u00020\u0001:\u0001CJ(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J,\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&JB\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0014H&J$\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J:\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u001b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00140\u001bH&J\b\u0010\u001e\u001a\u00020\u000eH&J\b\u0010\u001f\u001a\u00020\u0005H&J\b\u0010 \u001a\u00020\u000eH&J\u0016\u0010!\u001a\u00020\u000e2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0#H&J\b\u0010$\u001a\u00020\u000eH&J*\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010\u00052\u0006\u0010)\u001a\u00020\u0005H&J\u0010\u0010*\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0005H&J\u0010\u0010+\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u0005H&J\u0010\u0010,\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u0005H&J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00050\u001bH&J\u000e\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00050\u001bH&J\u001e\u0010/\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010\u001b2\u0006\u00101\u001a\u000202H¦@¢\u0006\u0002\u00103J\u0010\u00104\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u0014H&J\b\u00106\u001a\u000207H&J\"\u00108\u001a\u0004\u0018\u00010\t2\u0006\u00109\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u0003H&J\b\u0010<\u001a\u00020\u0003H&J \u0010=\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u00032\u0006\u0010@\u001a\u00020\u0003H&J\u0016\u0010A\u001a\u00020\u00032\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00100\u001bH&¨\u0006D"}, d2 = {"Lcom/obric/memorydata/personalcontext/api/IPersonalContextAPI;", "Lcom/bytedance/news/common/service/manager/IService;", "insertVectorCopilotItem", "", "tableName", "", OaidModel.KEY_ID, "", "vectorArray", "", "useVLM", "deleteVectorCopilotItem", "table", "onRawEntityInsert", "", "entityType", "", "entityId", "rawId", "rawAppEntity", "", "onRawEntityUpdate", "isInvalidateIndex", "oldRawAppEntity", "onRawEntityDelete", "onBulkEntityDelete", "rawIds", "", "rawAppEntityIds", "rawAppEntities", "reDonateVdbEntity", "migratePersonalVectorDbFilesIfNeededBlocking", "migrateMetaFullContentUidIfNeeded", "addForceIndexStateChangeListener", "listener", "Lkotlin/Function0;", "notifyForceIndexStateChange", "deepSearch", ChatMessage.TYPE_QUERY, ObricMemoryConstants.KEY_PACKAGE_NAME, "searchType", "businessName", "memorySearchForProactiveUserProfile", "onPackageTaskStart", "onPackageTaskFinish", "getDbBackupFileList", "getDbBlackList", "extractSingleFile", "Lcom/obric/capabilitykit/entity/app/VideoFrame;", "uri", "Landroid/net/Uri;", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addLocation2MetaLocationManager", "locationEntity", "getEmbeddingState", "Lcom/obric/memorydata/personalcontext/util/EmbeddingState;", "queryVector", "vectorDbName", "key", "useVlm", "canUseVlmEmbedding", "triggerEntityConsistencyCheckTask", "isFastMode", "isSyncAfterEnableApp", "isSyncDonateApp", "allowDonateByLocalSearch", "types", "Companion", "personal_context_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IPersonalContextAPI extends IService {
    public static final a Companion = null;
    public static final String DEEP_SEARCH_CONTENT_TYPE_TEXT = "text";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/personalcontext/api/IPersonalContextAPI$Companion;", "", "<init>", "()V", "DEEP_SEARCH_CONTENT_TYPE_TEXT", "", "personal_context_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f12033a = null;

        static {
            f12033a = new a();
        }

        private a() {
        }
    }

    static {
        Companion = a.f12033a;
    }

    void addForceIndexStateChangeListener(Function0<Unit> r1);

    void addLocation2MetaLocationManager(Object r1);

    boolean allowDonateByLocalSearch(List<Integer> r1);

    boolean canUseVlmEmbedding();

    Object deepSearch(String r1, String r2, String r3, String r4);

    boolean deleteVectorCopilotItem(String r1, long r2);

    Object extractSingleFile(Uri r1, Continuation<? super List<VideoFrame>> r2);

    List<String> getDbBackupFileList();

    List<String> getDbBlackList();

    EmbeddingState getEmbeddingState();

    boolean insertVectorCopilotItem(String r1, long r2, float[] r4, boolean r5);

    String memorySearchForProactiveUserProfile(String r1);

    void migrateMetaFullContentUidIfNeeded();

    String migratePersonalVectorDbFilesIfNeededBlocking();

    void notifyForceIndexStateChange();

    void onBulkEntityDelete(int r1, List<Long> r2, List<String> r3, List<? extends Object> r4);

    void onPackageTaskFinish(String r1);

    void onPackageTaskStart(String r1);

    void onRawEntityDelete(int r1, long r2, Object r4);

    void onRawEntityInsert(int r1, String r2, long r3, Object r5);

    void onRawEntityUpdate(int r1, String r2, long r3, Object r5, boolean r6, Object r7);

    float[] queryVector(String r1, String r2, boolean r3);

    void reDonateVdbEntity();

    void triggerEntityConsistencyCheckTask(boolean r1, boolean r2, boolean r3);
}
