package com.obric.memorydata.personalcontext.api;

import android.net.Uri;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.VideoFrame;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.personalcontext.util.EmbeddingState;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u001e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0096\u0001J\u0011\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u0017\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0096\u0001J\t\u0010\u0010\u001a\u00020\fH\u0096\u0001J+\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u0013H\u0096\u0001J\u0019\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0096\u0001J\u001e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0096A¢\u0006\u0002\u0010\u001fJ\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130\u000eH\u0096\u0001J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00130\u000eH\u0096\u0001J\t\u0010\"\u001a\u00020#H\u0096\u0001J)\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\fH\u0096\u0001J\u0011\u0010)\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013H\u0096\u0001J\t\u0010*\u001a\u00020\u0005H\u0096\u0001J\t\u0010+\u001a\u00020\u0013H\u0096\u0001J\t\u0010,\u001a\u00020\u0005H\u0096\u0001J;\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u000f2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000e2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\n0\u000eH\u0096\u0001J\u0011\u00102\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0096\u0001J\u0011\u00103\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0096\u0001J#\u00104\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u001a2\b\u00106\u001a\u0004\u0018\u00010\nH\u0096\u0001J+\u00107\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u000f2\u0006\u00108\u001a\u00020\u00132\u0006\u00105\u001a\u00020\u001a2\b\u00106\u001a\u0004\u0018\u00010\nH\u0096\u0001J=\u00109\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u000f2\u0006\u00108\u001a\u00020\u00132\u0006\u00105\u001a\u00020\u001a2\b\u00106\u001a\u0004\u0018\u00010\n2\u0006\u0010:\u001a\u00020\f2\b\u0010;\u001a\u0004\u0018\u00010\nH\u0096\u0001J#\u0010<\u001a\u0004\u0018\u00010'2\u0006\u0010=\u001a\u00020\u00132\u0006\u0010>\u001a\u00020\u00132\u0006\u0010?\u001a\u00020\fH\u0096\u0001J\t\u0010@\u001a\u00020\u0005H\u0096\u0001J!\u0010A\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\f2\u0006\u0010C\u001a\u00020\f2\u0006\u0010D\u001a\u00020\fH\u0096\u0001¨\u0006E"}, d2 = {"Lcom/obric/memorydata/personalcontext/api/PersonalContextAPI;", "Lcom/obric/memorydata/personalcontext/api/IPersonalContextAPI;", "<init>", "()V", "addForceIndexStateChangeListener", "", "listener", "Lkotlin/Function0;", "addLocation2MetaLocationManager", "locationEntity", "", "allowDonateByLocalSearch", "", "types", "", "", "canUseVlmEmbedding", "deepSearch", ChatMessage.TYPE_QUERY, "", ObricMemoryConstants.KEY_PACKAGE_NAME, "searchType", "businessName", "deleteVectorCopilotItem", "table", OaidModel.KEY_ID, "", "extractSingleFile", "Lcom/obric/capabilitykit/entity/app/VideoFrame;", "uri", "Landroid/net/Uri;", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDbBackupFileList", "getDbBlackList", "getEmbeddingState", "Lcom/obric/memorydata/personalcontext/util/EmbeddingState;", "insertVectorCopilotItem", "tableName", "vectorArray", "", "useVLM", "memorySearchForProactiveUserProfile", "migrateMetaFullContentUidIfNeeded", "migratePersonalVectorDbFilesIfNeededBlocking", "notifyForceIndexStateChange", "onBulkEntityDelete", "entityType", "rawIds", "rawAppEntityIds", "rawAppEntities", "onPackageTaskFinish", "onPackageTaskStart", "onRawEntityDelete", "rawId", "rawAppEntity", "onRawEntityInsert", "entityId", "onRawEntityUpdate", "isInvalidateIndex", "oldRawAppEntity", "queryVector", "vectorDbName", "key", "useVlm", "reDonateVdbEntity", "triggerEntityConsistencyCheckTask", "isFastMode", "isSyncAfterEnableApp", "isSyncDonateApp", "personal_context_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PersonalContextAPI implements IPersonalContextAPI {
    public static final PersonalContextAPI INSTANCE = null;
    private final /* synthetic */ IPersonalContextAPI $$delegate_0;

    static {
        INSTANCE = new PersonalContextAPI();
    }

    private PersonalContextAPI() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IPersonalContextAPI.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IPersonalContextAPI) ZeusTransformUtils.preCheckCast(r0, IPersonalContextAPI.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public void addForceIndexStateChangeListener(Function0<Unit> r3) {
        Function0<Unit> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.$$delegate_0.addForceIndexStateChangeListener(r4);
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public void addLocation2MetaLocationManager(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "locationEntity");
        this.$$delegate_0.addLocation2MetaLocationManager(r2);
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public boolean allowDonateByLocalSearch(List<Integer> r3) {
        List<Integer> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "types");
        return this.$$delegate_0.allowDonateByLocalSearch(r4);
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public boolean canUseVlmEmbedding() {
        return this.$$delegate_0.canUseVlmEmbedding();
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public Object deepSearch(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, ChatMessage.TYPE_QUERY);
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r5, "businessName");
        return this.$$delegate_0.deepSearch(r2, r3, r4, r5);
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public boolean deleteVectorCopilotItem(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "table");
        return this.$$delegate_0.deleteVectorCopilotItem(r2, r3);
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public Object extractSingleFile(Uri r3, Continuation<? super List<VideoFrame>> r4) {
        Continuation<? super List<VideoFrame>> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return this.$$delegate_0.extractSingleFile(r3, r5);
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public List<String> getDbBackupFileList() {
        return this.$$delegate_0.getDbBackupFileList();
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public List<String> getDbBlackList() {
        return this.$$delegate_0.getDbBlackList();
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public EmbeddingState getEmbeddingState() {
        return this.$$delegate_0.getEmbeddingState();
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public boolean insertVectorCopilotItem(String r8, long r9, float[] r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r8, "tableName");
        Intrinsics.checkNotNullParameter(r11, "vectorArray");
        return this.$$delegate_0.insertVectorCopilotItem(r8, r9, r11, r12);
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public String memorySearchForProactiveUserProfile(String r2) {
        Intrinsics.checkNotNullParameter(r2, ChatMessage.TYPE_QUERY);
        return this.$$delegate_0.memorySearchForProactiveUserProfile(r2);
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public void migrateMetaFullContentUidIfNeeded() {
        this.$$delegate_0.migrateMetaFullContentUidIfNeeded();
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public String migratePersonalVectorDbFilesIfNeededBlocking() {
        return this.$$delegate_0.migratePersonalVectorDbFilesIfNeededBlocking();
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public void notifyForceIndexStateChange() {
        this.$$delegate_0.notifyForceIndexStateChange();
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public void onBulkEntityDelete(int r3, List<Long> r4, List<String> r5, List<? extends Object> r6) {
        List<Long> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        List<? extends Object> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "rawIds");
        Intrinsics.checkNotNullParameter(r8, "rawAppEntityIds");
        Intrinsics.checkNotNullParameter(r9, "rawAppEntities");
        this.$$delegate_0.onBulkEntityDelete(r3, r7, r8, r9);
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public void onPackageTaskFinish(String r2) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        this.$$delegate_0.onPackageTaskFinish(r2);
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public void onPackageTaskStart(String r2) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        this.$$delegate_0.onPackageTaskStart(r2);
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public void onRawEntityDelete(int r1, long r2, Object r4) {
        this.$$delegate_0.onRawEntityDelete(r1, r2, r4);
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public void onRawEntityInsert(int r8, String r9, long r10, Object r12) {
        Intrinsics.checkNotNullParameter(r9, "entityId");
        this.$$delegate_0.onRawEntityInsert(r8, r9, r10, r12);
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public void onRawEntityUpdate(int r10, String r11, long r12, Object r14, boolean r15, Object r16) {
        Intrinsics.checkNotNullParameter(r11, "entityId");
        this.$$delegate_0.onRawEntityUpdate(r10, r11, r12, r14, r15, r16);
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public float[] queryVector(String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "vectorDbName");
        Intrinsics.checkNotNullParameter(r3, "key");
        return this.$$delegate_0.queryVector(r2, r3, r4);
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public void reDonateVdbEntity() {
        this.$$delegate_0.reDonateVdbEntity();
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public void triggerEntityConsistencyCheckTask(boolean r1, boolean r2, boolean r3) {
        this.$$delegate_0.triggerEntityConsistencyCheckTask(r1, r2, r3);
    }
}
