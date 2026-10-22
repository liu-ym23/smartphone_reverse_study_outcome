package com.obric.memorydata.database.entity;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.database.backup.appentity.AbstractFakeAppEntity;
import com.obric.memorydata.database.dao.IAppEntityContentTimeDao;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.dao.IAppEntityVectorCopilotDao;
import com.obric.memorydata.database.index.EntityIndexEngine;
import com.obric.memorydata.database.index.EntityIndexRecordInfo;
import com.obric.memorydata.database.index.ExtractTime;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.bridge.AppEntityIndexBridgeAPI;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.personalcontext.api.EntityManager;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.personalcontext.api.PersonalContextAPI;
import com.obric.search.api.schema.impl.FullTextSearchSchema;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 i2\u00020\u0001:\u0001iB{\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010-\u001a\u0004\u0018\u00010.J\n\u0010/\u001a\u0004\u0018\u00010.H$J\n\u00100\u001a\u0004\u0018\u000101H\u0016J\n\u00102\u001a\u0004\u0018\u000103H\u0016J\u001a\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u0005H&J\u001a\u00108\u001a\u0004\u0018\u0001092\u0006\u00106\u001a\u00020\u00052\u0006\u0010:\u001a\u00020;H\u0016J\u0012\u0010<\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u00020\u0005H&J&\u0010=\u001a\u00020>2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00050@2\u0006\u0010A\u001a\u00020\u00002\u0006\u0010B\u001a\u00020\u0000H\u0014J\u0010\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020DH\u0016J\u000e\u0010F\u001a\u00020>2\u0006\u0010A\u001a\u00020\u0000J\b\u0010G\u001a\u00020DH\u0016J\u0016\u0010H\u001a\u00020D2\u0006\u0010I\u001a\u00020\u00032\u0006\u00106\u001a\u00020\u0005J\u0016\u0010J\u001a\u00020>2\u0006\u0010I\u001a\u00020\u00032\u0006\u00106\u001a\u00020\u0005J\u0010\u0010K\u001a\u00020D2\u0006\u0010L\u001a\u00020\u0005H\u0014J\b\u0010M\u001a\u00020>H\u0014J\u0010\u0010N\u001a\u00020>2\u0006\u0010O\u001a\u00020PH\u0002J\u0014\u0010Q\u001a\u00020D2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00050SJ\u0016\u0010T\u001a\u00020D2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00050SH\u0002J\u001e\u0010Q\u001a\u00020D2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00050S2\u0006\u0010U\u001a\u00020VH\u0002J\u001c\u0010W\u001a\b\u0012\u0004\u0012\u00020P0X2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00050SH\u0002J\b\u0010Y\u001a\u00020\u0003H\u0002J\b\u0010Z\u001a\u00020VH\u0002J\u0010\u0010[\u001a\u00020D2\u0006\u0010\\\u001a\u00020\u0000H\u0002J \u0010]\u001a\u00020D2\u0006\u0010\\\u001a\u00020\u00002\u000e\u0010^\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010SH\u0002J\u0010\u0010_\u001a\u00020D2\u0006\u0010\\\u001a\u00020\u0000H\u0002J\"\u0010`\u001a\u00020>2\u0006\u0010a\u001a\u00020\u00002\u0010\b\u0002\u0010^\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010SH\u0002J\u0010\u0010b\u001a\n\u0012\u0004\u0012\u000209\u0018\u00010cH\u0002J\u0010\u0010d\u001a\n\u0012\u0004\u0012\u000205\u0018\u00010eH\u0002J\u0010\u0010f\u001a\n\u0012\u0004\u0012\u000205\u0018\u00010eH\u0002J\u000e\u0010g\u001a\b\u0012\u0004\u0012\u00020\u00000hH\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0014\u0010\u0007\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\n\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R\u0014\u0010\u000b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0014\u0010\f\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010#R\"\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0018\"\u0004\b,\u0010#¨\u0006j"}, d2 = {"Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "Lcom/obric/memorydata/database/IAppEntityRawDbData;", OaidModel.KEY_ID, "", "entityId", "", "createTime", "modifyTime", "type", "", "timestamp", ObricMemoryConstants.KEY_PACKAGE_NAME, "hashCodeValue", Api.KEY_UUID, "poisonLabel", "poisonLabelVersion", "contentHash", "<init>", "(JLjava/lang/String;JJIJLjava/lang/String;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getId", "()J", "setId", "(J)V", "getEntityId", "()Ljava/lang/String;", "getCreateTime", "getModifyTime", "getType", "()I", "getTimestamp", "setTimestamp", "getPackageName", "getHashCodeValue", "getUuid", "setUuid", "(Ljava/lang/String;)V", "getPoisonLabel", "()Ljava/lang/Integer;", "setPoisonLabel", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPoisonLabelVersion", "setPoisonLabelVersion", "getContentHash", "setContentHash", "convertToAppEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "convertToAppEntityInternal", "convertToFakeAppEntity", "Lcom/obric/memorydata/database/backup/appentity/AbstractFakeAppEntity;", "convertToRawHistoryEntity", "Lcom/obric/memorydata/database/entity/AbstractHistoryEntity;", "convertToTextVectorCopilotEntity", "Lcom/obric/memorydata/database/entity/AbstractVectorCopilotEntity;", "column", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "convertToContentTimeEntity", "Lcom/obric/memorydata/database/entity/AbstractContentTimeEntity;", "extractTime", "Lcom/obric/memorydata/database/index/ExtractTime;", "convertToImageVectorCopilotEntity", "onUpdate", "", "updateColumns", "", "oldEntity", "newEntity", "index", "", "isForceLazy", "preparePoisonSnapshotForUpsert", "delete", "insertInvalidatePendingColumn", "rawDbId", "removePendingColumn", "isValidateValue", "columnsName", "onFirstIndex", "fillInvalidateParams", "pendingEntity", "Lcom/obric/memorydata/database/entity/IndexPendingEntity;", "insertPendingColumns", "columns", "", "insertNewEntityPendingColumns", "startEvidence", "Lcom/obric/memorydata/database/index/StartEvidence;", "buildPendingEntities", "", "indexSourceStartedAtMs", "updateStartEvidence", "deleteKeywordIndex", "rawDbEntity", "deleteSemanticIndex", "needDeleteColumn", "deleteContentTimeIndex", "deleteOldIndex", "old", "getContentTimeDao", "Lcom/obric/memorydata/database/dao/IAppEntityContentTimeDao;", "getTextVectorCopilotDao", "Lcom/obric/memorydata/database/dao/IAppEntityVectorCopilotDao;", "getImageVectorCopilotDao", "getRawEntityDao", "Lcom/obric/memorydata/database/dao/IAppEntityRawDbDao;", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class d implements com.obric.memorydata.database.a {
    public static final a Companion = null;
    public static final String FAST_INDEX_TASK_NAME = "fast_entity_index";
    private static final long FRESH_SOURCE_FIRST_EFFECTIVE_WINDOW_MS = 600000;
    public static final String INVALIDATE_VALUE = "invalidate_value";
    public static final String SLOW_INDEX_TASK_NAME = "slow_entity_index";
    public static final String TAG = "AbstractRawDbEntity";
    private String contentHash;
    private final long createTime;
    private final String entityId;
    private final int hashCodeValue;
    private long id;
    private final long modifyTime;
    private final String packageName;
    private Integer poisonLabel;
    private Integer poisonLabelVersion;
    private long timestamp;
    private final int type;
    private String uuid;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/database/entity/AbstractRawDbEntity$Companion;", "", "<init>", "()V", "TAG", "", "FAST_INDEX_TASK_NAME", "SLOW_INDEX_TASK_NAME", "INVALIDATE_VALUE", "FRESH_SOURCE_FIRST_EFFECTIVE_WINDOW_MS", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public d(long r6, String r8, long r9, long r11, int r13, long r14, String r16, int r17, String r18, Integer r19, Integer r20, String r21) {
        Intrinsics.checkNotNullParameter(r8, "entityId");
        Intrinsics.checkNotNullParameter(r16, ObricMemoryConstants.KEY_PACKAGE_NAME);
        this.id = r6;
        this.entityId = r8;
        this.createTime = r9;
        this.modifyTime = r11;
        this.type = r13;
        this.timestamp = r14;
        this.packageName = r16;
        this.hashCodeValue = r17;
        this.uuid = r18;
        this.poisonLabel = r19;
        this.poisonLabelVersion = r20;
        this.contentHash = r21;
    }

    public /* synthetic */ d(long r21, String r23, long r24, long r26, int r28, long r29, String r31, int r32, String r33, Integer r34, Integer r35, String r36, int r37, DefaultConstructorMarker r38) {
        if ((r37 & 1) == 0) goto L5;
        long r4 = 0;
    L7:
        if ((r37 & 32) == 0) goto L9;
        long r12 = System.currentTimeMillis();
    L11:
        if ((r37 & 256) == 0) goto L13;
        String r16 = null;
    L15:
        if ((r37 & 512) == 0) goto L17;
        Integer r17 = null;
    L19:
        if ((r37 & 1024) == 0) goto L21;
        Integer r18 = null;
    L23:
        if ((r37 & 2048) == 0) goto L25;
        String r19 = null;
    L26:
        this(r4, r23, r24, r26, r28, r12, r31, r32, r16, r17, r18, r19);
        return;
    L25:
        r19 = r36;
        goto L26
    L21:
        r18 = r35;
        goto L23
    L17:
        r17 = r34;
        goto L19
    L13:
        r16 = r33;
        goto L15
    L9:
        r12 = r29;
        goto L11
    L5:
        r4 = r21;
        goto L7
    }

    private final List<cd> buildPendingEntities(Set<String> r31) {
        Set<String> r1 = (Set) ZeusTransformUtils.wrapperContextForParams(r31, Set.class, "com.obric.memorydata.plugin");
        List<cd> r3 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(com.obric.memorydata.database.index.s.a().getEntityIndexPendingList(this, r1), Collection.class, "com.obric.memorydata.plugin"));
        Set r4 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        cd r6 = (cd) ZeusTransformUtils.preCheckCast(r5.next(), cd.class, "com.obric.memorydata.plugin");
        fillInvalidateParams(r6);
        r4.add(r6.h());
        goto L4
    L6:
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r2.hasNext() == false) goto L16;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        if (r4.contains(r7) == true) goto L8;
        if (isValidateValue(r7) == true) goto L8;
        String r19 = INVALIDATE_VALUE;
        cd r14 = new cd(0, getId(), getType(), getTimestamp(), getCreateTime(), 0, 0, r7, r19, 0, 0, null, false, 0, 0, 32353, null);
        r14.a(INVALIDATE_VALUE);
        r3.add(r14);
        goto L8
    L16:
        return r3;
    }

    private final boolean deleteContentTimeIndex(d r3) {
        IAppEntityContentTimeDao<b> r2 = getContentTimeDao();
        if (r2 == null) goto L7;
        r2.deleteByRawDbId(r3.getId());
        return true;
    L7:
        return true;
    }

    private final boolean deleteKeywordIndex(d r5) {
        EntityIndexEngine r0 = com.obric.memorydata.database.index.s.a();
        if (r0.hasKeywordIndex(getType()) == true) goto L6;
        return true;
    L6:
        FullTextSearchSchema r4 = r0.getKeywordSchema(getType());
        if (r4 != null) goto L10;
        return false;
    L10:
        Map<String, String> r1 = com.obric.memorydata.database.index.s.a().getKeywordIndexMap(r5);
        if (r1 != null) goto L14;
        r1 = MapsKt.emptyMap();
    L14:
        return com.obric.memorydata.database.index.t.f9438a.a(r4, r5.getId(), r1);
    }

    private final void deleteOldIndex(d r11, Set<String> r12) {
        Set<String> r13 = (Set) ZeusTransformUtils.wrapperContextForParams(r12, Set.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "deleteOldIndex called, id: " + r11.getId() + ", type: " + r11.getType() + ", needDeleteColumn: " + r13, false, 4, null);
        if (r13 != null) goto L5;
    L8:
        deleteKeywordIndex(r11);
    L9:
        if (r13 == null) goto L11;
    L13:
        if (r13 != null) goto L15;
    L18:
        deleteContentTimeIndex(r11);
    L20:
        if (deleteSemanticIndex(r11, r13) == true) goto L23;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "deleteSemanticIndex error, id: " + r11.getId() + ", type: " + r11.getType(), null, 4, null);
        return;
    L23:
        return;
    L15:
        if (r13.contains("insert_content_time_task") == true) goto L18;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "deleteOldIndex called, id: " + r11.getId() + ", type: " + r11.getType() + ", but No need to delete ContentTime", false, 4, null);
        goto L20
    L11:
        if (com.obric.memorydata.database.index.s.a().isBuildMetaInfoFullContent(getType()) == false) goto L13;
        AppEntityIndexBridgeAPI.INSTANCE.deleteMetaFullContentKeyword(getType(), CollectionsKt.listOf(Long.valueOf(r11.getId())));
        goto L13
    L5:
        if (r13.contains("insert_keyword_task") == true) goto L8;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "deleteOldIndex called, id: " + r11.getId() + ", type: " + r11.getType() + ", but No need to delete Keyword", false, 4, null);
        goto L9
    }

    static /* synthetic */ void deleteOldIndex$default(d r2, d r3, Set r4, int r5, Object r6) {
        Set<String> r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L10;
        if ((r5 & 2) == 0) goto L7;
        r7 = null;
    L7:
        r2.deleteOldIndex(r3, r7);
        return;
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteOldIndex");
    }

    private final boolean deleteSemanticIndex(d r9, Set<String> r10) {
        Set<String> r11 = (Set) ZeusTransformUtils.wrapperContextForParams(r10, Set.class, "com.obric.memorydata.plugin");
        IAppEntityVectorCopilotDao<i> r0 = getTextVectorCopilotDao();
        IAppEntityVectorCopilotDao<i> r8 = getImageVectorCopilotDao();
        if (r0 == null) goto L9;
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r0.queryByRawDbIdAndColumns(r9.getId(), r11), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        i r3 = (i) ZeusTransformUtils.preCheckCast(r2.next(), i.class, "com.obric.memorydata.plugin");
        PersonalContextAPI.INSTANCE.deleteVectorCopilotItem(r0.getTableName(), r3.a());
        goto L6
    L8:
        r0.deleteByRawDbIdAndColumns(r9.getId(), r11);
    L9:
        if (r8 == null) goto L19;
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r8.queryByRawDbIdAndColumns(r9.getId(), r11), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L12:
        if (r1.hasNext() == false) goto L14;
        i r4 = (i) ZeusTransformUtils.preCheckCast(r1.next(), i.class, "com.obric.memorydata.plugin");
        PersonalContextAPI.INSTANCE.deleteVectorCopilotItem(r8.getTableName(), r4.a());
        goto L12
    L14:
        r8.deleteByRawDbIdAndColumns(r9.getId(), r11);
        return true;
    L19:
        return true;
    }

    private final void fillInvalidateParams(cd r2) {
        if (isValidateValue(r2.h()) == true) goto L5;
        r2.a(INVALIDATE_VALUE);
        return;
    L5:
        if (Intrinsics.areEqual(r2.l(), INVALIDATE_VALUE) == false) goto L9;
        r2.a("");
        return;
    }

    private final IAppEntityContentTimeDao<b> getContentTimeDao() {
        return com.obric.memorydata.database.index.s.a().getContentTimeDao(getType());
    }

    private final IAppEntityVectorCopilotDao<i> getImageVectorCopilotDao() {
        return com.obric.memorydata.database.index.s.a().getImageVectorCopilotDao(getType());
    }

    private final IAppEntityRawDbDao<d> getRawEntityDao() {
        IAppEntityRawDbDao<d> r0 = com.obric.memorydata.database.index.s.a().getRawDaoByEntityType(getType());
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("getRawEntityDao is null entityType: " + getType());
    }

    private final IAppEntityVectorCopilotDao<i> getTextVectorCopilotDao() {
        return com.obric.memorydata.database.index.s.a().getTextVectorCopilotDao(getType());
    }

    private static final Unit index$lambda$2(IAppEntityRawDbDao r15, d r16, boolean r17, boolean r18, Ref.BooleanRef r19, Ref.ObjectRef r20) {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(((IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r15, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin")).queryByEntityId(r16.getEntityId(), r16.getPackageName()), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L5;
    L7:
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L6;
        if (((d) ZeusTransformUtils.preCheckCast(r1.next(), d.class, "com.obric.memorydata.plugin")).getId() != r16.getId()) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == false) goto L9;
        boolean r3 = false;
    L16:
        if (r3 == false) goto L20;
        return Unit.INSTANCE;
    L20:
        if (r17 == false) goto L22;
        r16.deleteOldIndex(r16, null);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "isForceLazy, deleteOldIndex on first index, entityId: " + r16.getEntityId() + ", type: " + r16.getType() + ", id: " + r16.getId(), false, 4, null);
    L22:
        Set<String> r4 = com.obric.memorydata.database.index.s.a().getAllColumns(r16);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.intersect((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(com.obric.memorydata.database.index.s.a().getKeywordColumnMap(r16).keySet(), Iterable.class, "com.obric.memorydata.plugin")), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L26;
        r4.add("insert_keyword_task");
    L26:
        if ((true ^ ((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.intersect((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(com.obric.memorydata.database.index.s.a().getContentTimeColumns(r16).keySet(), Iterable.class, "com.obric.memorydata.plugin")), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L28;
        r4.add("insert_content_time_task");
    L28:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "index entityId: " + r16.getEntityId() + ", entityType: " + r16.getType() + ", allColumns: " + r4 + " id: " + r16.getId(), false, 4, null);
        if (r18 == false) goto L31;
        boolean r5 = r16.insertNewEntityPendingColumns(r4);
    L32:
        if (r5 == true) goto L34;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "insert in PendingDb error, entityId: " + r16.getEntityId() + ", type: " + r16.getType(), null, 4, null);
        r19.element = false;
    L36:
        if (r20.element == 0) goto L39;
        EntityManager.INSTANCE.removeLazyIndexHistoryEntity(r16.getType(), ((Number) ZeusTransformUtils.preCheckCast(r20.element, Number.class, "com.obric.memorydata.plugin")).longValue());
    L39:
        return Unit.INSTANCE;
    L34:
        PersonalContextAPI.INSTANCE.onRawEntityInsert(r16.getType(), r16.getEntityId(), r16.getId(), r16);
        goto L36
    L31:
        r5 = r16.insertPendingColumns(r4);
        goto L32
    L13:
        r2 = false;
    L6:
        r3 = true;
        goto L16
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L6
    }

    private static final Unit index$lambda$8(IAppEntityRawDbDao r35, d r36, Set r37, List r38, boolean r39, Ref.BooleanRef r40, Ref.ObjectRef r41) {
        IAppEntityRawDbDao r1 = (IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r35, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
        Set<String> r2 = (Set) ZeusTransformUtils.wrapperContextForParams(r37, Set.class, "com.obric.memorydata.plugin");
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r38, List.class, "com.obric.memorydata.plugin");
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r1.queryByEntityId(r36.getEntityId(), r36.getPackageName()), Iterable.class, "com.obric.memorydata.plugin");
        boolean r5 = true;
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L5;
    L7:
        Iterator r6 = r4.iterator();
    L9:
        if (r6.hasNext() == false) goto L6;
        if (((d) ZeusTransformUtils.preCheckCast(r6.next(), d.class, "com.obric.memorydata.plugin")).getId() != r36.getId()) goto L13;
        boolean r7 = true;
    L14:
        if (r7 == false) goto L9;
        boolean r8 = false;
    L16:
        if (r8 == true) goto L18;
        List<cd> r9 = com.obric.memorydata.database.manager.c.f9561a.b(r36.getType()).queryWithRawDb(r36.getId(), r36.getType());
        com.obric.memorydata.database.index.ax.d r10 = new com.obric.memorydata.database.index.ax.d(r9);
        List r11 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L21:
        if (r12.hasNext() == false) goto L31;
        cd r13 = (cd) ZeusTransformUtils.preCheckCast(r12.next(), cd.class, "com.obric.memorydata.plugin");
        if (r2.contains(r13.h()) == true) goto L21;
        if (Intrinsics.areEqual(r13.i(), "lazy_index_task") == true) goto L21;
        r13.a(r36.getTimestamp());
        r36.fillInvalidateParams(r13);
        if (Intrinsics.areEqual(r13.i(), INVALIDATE_VALUE) == false) goto L30;
        if (Intrinsics.areEqual(r13.l(), INVALIDATE_VALUE) == false) goto L21;
    L30:
        r11.add(cd.a(r13, 0, 0, 0, 0, 0, 0, 0, null, null, 0, 0, null, false, 0, 0, 32766, null));
        goto L21
    L31:
        List r14 = CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r36.buildPendingEntities(r2), Iterable.class, "com.obric.memorydata.plugin"));
        List r15 = (List) ZeusTransformUtils.preCheckCast(com.obric.memorydata.database.index.ao.a(com.obric.memorydata.database.index.ao.f9372a, com.obric.memorydata.database.manager.c.f9561a.a(r36.getType()), CollectionsKt.listOf(r10), r14, r36.updateStartEvidence(), null, 16, null).a(), List.class, "com.obric.memorydata.plugin");
        if (r15.size() != r14.size()) goto L50;
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r16, Collection.class) == true) goto L36;
    L38:
        Iterator r17 = r16.iterator();
    L40:
        if (r17.hasNext() == false) goto L37;
        if (((Number) ZeusTransformUtils.preCheckCast(r17.next(), Number.class, "com.obric.memorydata.plugin")).longValue() >= 0) goto L44;
        boolean r18 = true;
    L45:
        if (r18 == false) goto L40;
        boolean r19 = false;
    L47:
        if (r19 == false) goto L50;
        r36.deleteOldIndex((d) ZeusTransformUtils.preCheckCast(r3.get(0), d.class, "com.obric.memorydata.plugin"), r2);
        goto L50
    L44:
        r18 = false;
    L37:
        r19 = true;
        goto L47
    L36:
        if (((Collection) ZeusTransformUtils.preCheckCast(r16, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L38;
    L50:
        if (r14.isEmpty() == false) goto L53;
        com.obric.memorydata.database.index.ao.f9372a.a(com.obric.memorydata.database.manager.c.f9561a.a(r36.getType()), r36.getId(), r36.getType(), r36.getTimestamp(), r36.updateStartEvidence());
    L53:
        if (r15.size() != r14.size()) goto L68;
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L57;
    L59:
        Iterator r20 = r0.iterator();
    L61:
        if (r20.hasNext() == false) goto L58;
        if (((Number) ZeusTransformUtils.preCheckCast(r20.next(), Number.class, "com.obric.memorydata.plugin")).longValue() >= 0) goto L65;
        boolean r21 = true;
    L66:
        if (r21 == false) goto L61;
    L67:
        if (r5 == true) goto L68;
    L69:
        PersonalContextAPI.INSTANCE.onRawEntityUpdate(r36.getType(), r36.getEntityId(), r36.getId(), r36, r39, r3.get(0));
        if (r40.element == false) goto L73;
        EntityManager.INSTANCE.resumeLazyIndexPendingTask(r36.getType(), r36.getPackageName(), r36.getId());
    L73:
        if (r41.element == 0) goto L76;
        EntityManager.INSTANCE.removeLazyIndexHistoryEntity(r36.getType(), ((Number) ZeusTransformUtils.preCheckCast(r41.element, Number.class, "com.obric.memorydata.plugin")).longValue());
    L76:
        return Unit.INSTANCE;
    L65:
        r21 = false;
    L58:
        r5 = false;
        goto L67
    L57:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L59;
    L68:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "insert in PendingDb, insert pending data error, id: " + r36.getId() + ", type: " + r36.getType(), null, 4, null);
        goto L69
    L18:
        return Unit.INSTANCE;
    L13:
        r7 = false;
    L6:
        r8 = true;
        goto L16
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L6
    }

    private final long indexSourceStartedAtMs() {
        return com.obric.memorydata.database.index.aq.a(com.obric.memorydata.database.index.aq.f9375a, getTimestamp(), 0, System.currentTimeMillis(), 2, null);
    }

    private final boolean insertNewEntityPendingColumns(Set<String> r5) {
        return insertPendingColumns((Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin"), (com.obric.memorydata.database.index.bc) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.database.index.bc.c(indexSourceStartedAtMs()), com.obric.memorydata.database.index.bc.class, "com.obric.memorydata.plugin"));
    }

    private final boolean insertPendingColumns(Set<String> r12, com.obric.memorydata.database.index.bc r13) {
        Set<String> r14 = (Set) ZeusTransformUtils.wrapperContextForParams(r12, Set.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.database.index.bc r15 = (com.obric.memorydata.database.index.bc) ZeusTransformUtils.wrapperContextForParams(r13, com.obric.memorydata.database.index.bc.class, "com.obric.memorydata.plugin");
        if (r14.isEmpty() == false) goto L7;
        com.obric.memorydata.database.index.ao r2 = com.obric.memorydata.database.index.ao.f9372a;
    L5:
        r2.a(com.obric.memorydata.database.manager.c.f9561a.a(getType()), getId(), getType(), getTimestamp(), r15);
        return true;
    L7:
        List<cd> r16 = buildPendingEntities(r14);
        boolean r0 = r16.isEmpty();
        r2 = com.obric.memorydata.database.index.ao.f9372a;
        if (r0 == true) goto L5;
        List r11 = (List) ZeusTransformUtils.preCheckCast(com.obric.memorydata.database.index.ao.a(r2, com.obric.memorydata.database.manager.c.f9561a.a(getType()), r16, r15, null, 8, null).a(), List.class, "com.obric.memorydata.plugin");
        if (r11.size() != r16.size()) goto L29;
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r17, Collection.class) == true) goto L15;
    L17:
        Iterator r18 = r17.iterator();
    L19:
        if (r18.hasNext() == false) goto L16;
        if (((Number) ZeusTransformUtils.preCheckCast(r18.next(), Number.class, "com.obric.memorydata.plugin")).longValue() < 0) goto L23;
        boolean r19 = true;
    L24:
        if (r19 == true) goto L19;
        boolean r110 = false;
    L26:
        if (r110 == false) goto L29;
        return true;
    L23:
        r19 = false;
    L16:
        r110 = true;
        goto L26
    L15:
        if (((Collection) ZeusTransformUtils.preCheckCast(r17, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L17;
    L29:
        return false;
    }

    public static /* synthetic */ Unit lambda$UEWEVCamZl_xrTRbxUb1dNs48vQ(IAppEntityRawDbDao r0, d r1, boolean r2, boolean r3, Ref.BooleanRef r4, Ref.ObjectRef r5) {
        return index$lambda$2(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Unit lambda$crgc1EE31cwa3uN0oC2dLhXKZG4(IAppEntityRawDbDao r0, d r1, Set r2, List r3, boolean r4, Ref.BooleanRef r5, Ref.ObjectRef r6) {
        return index$lambda$8(r0, r1, r2, r3, r4, r5, r6);
    }

    private final com.obric.memorydata.database.index.bc updateStartEvidence() {
        long r0 = System.currentTimeMillis();
        long r2 = indexSourceStartedAtMs();
        boolean r4 = false;
        if (1 > r2) goto L8;
        if (r2 > r0) goto L8;
        r4 = true;
    L8:
        if (r4 == true) goto L10;
    L12:
        Object r8 = ZeusTransformUtils.preCheckCast(new com.obric.memorydata.database.index.bc.a(r0), com.obric.memorydata.database.index.bc.class, "com.obric.memorydata.plugin");
    L14:
        return (com.obric.memorydata.database.index.bc) r8;
    L10:
        if ((r0 - r2) > 600000) goto L12;
        r8 = ZeusTransformUtils.preCheckCast(new com.obric.memorydata.database.index.bc.c(r2), com.obric.memorydata.database.index.bc.class, "com.obric.memorydata.plugin");
        goto L14
    }

    public final AppEntity convertToAppEntity() {
        AppEntity r0 = convertToAppEntityInternal();
        if (r0 == null) goto L5;
        r0.setPoisonLabel(getPoisonLabel());
        r0.setPoisonLabelVersion(getPoisonLabelVersion());
        r0.setContentHash(getContentHash());
        return r0;
    L5:
        return null;
    }

    public abstract AppEntity convertToAppEntityInternal();

    public b convertToContentTimeEntity(String r1, ExtractTime r2) {
        Intrinsics.checkNotNullParameter(r1, "column");
        Intrinsics.checkNotNullParameter(r2, "extractTime");
        return null;
    }

    public AbstractFakeAppEntity convertToFakeAppEntity() {
        return null;
    }

    public abstract i convertToImageVectorCopilotEntity(String r1);

    public c convertToRawHistoryEntity() {
        return null;
    }

    public abstract i convertToTextVectorCopilotEntity(String r1, String r2);

    @Override // com.obric.memorydata.database.a
    public boolean delete() {
        if (IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getBoolean("is_on_avoid_data_import_switch_on", false) == false) goto L5;
        return true;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "delete called, id: " + getId() + ", type: " + getType(), false, 4, null);
        EntityManager.INSTANCE.deleteLazyIndexHistoryEntity(getType(), getPackageName(), getEntityId());
        com.obric.memorydata.database.util.b.f9624a.a(getPackageName(), String.valueOf(getType()), getEntityId());
        getRawEntityDao().delete(this);
        deleteOldIndex$default(this, this, null, 2, null);
        com.obric.memorydata.database.index.ao.a(com.obric.memorydata.database.index.ao.f9372a, com.obric.memorydata.database.manager.c.f9561a.a(getType()), CollectionsKt.listOf(Long.valueOf(getId())), SetsKt.setOf(Integer.valueOf(getType())), null, 8, null);
        PersonalContextAPI.INSTANCE.onRawEntityDelete(getType(), getId(), this);
        return true;
    }

    public String getContentHash() {
        return this.contentHash;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getEntityId() {
        return this.entityId;
    }

    public int getHashCodeValue() {
        return this.hashCodeValue;
    }

    public long getId() {
        return this.id;
    }

    public long getModifyTime() {
        return this.modifyTime;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public Integer getPoisonLabel() {
        return this.poisonLabel;
    }

    public Integer getPoisonLabelVersion() {
        return this.poisonLabelVersion;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public int getType() {
        return this.type;
    }

    public String getUuid() {
        return this.uuid;
    }

    /* JADX WARN: Type inference failed for: r5v5, types: [T, java.lang.Long] */
    @Override // com.obric.memorydata.database.a
    public boolean index(final boolean r26) {
        Long r6 = null;
        if (IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getBoolean("is_on_avoid_data_import_switch_on", false) == false) goto L5;
        return true;
    L5:
        com.obric.memorydata.database.index.aq r9 = com.obric.memorydata.database.index.aq.f9375a;
        Long r1 = com.obric.memorydata.database.index.aq.f9375a.a(getType(), getPackageName(), getEntityId());
        if (r1 == null) goto L8;
        long r10 = r1.longValue();
    L9:
        setTimestamp(com.obric.memorydata.database.index.aq.a(r9, r10, 0, System.currentTimeMillis(), 2, null));
        final IAppEntityRawDbDao<d> r2 = getRawEntityDao();
        final Ref.ObjectRef r11 = new Ref.ObjectRef();
        final Ref.BooleanRef r12 = new Ref.BooleanRef();
        if (r26 == false) goto L12;
    L16:
        r12.element = true;
        Object r3 = EntityManager.INSTANCE.getLazyIndexHistoryEntity(getType(), getPackageName(), getEntityId());
        if (ZeusTransformUtils.instanceOf(r3, c.class) == false) goto L19;
        c r4 = (c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.memorydata.plugin");
    L20:
        if (r4 == null) goto L22;
        r11.element = Long.valueOf(r4.getHistoryDbId());
        List r5 = CollectionsKt.listOf(r4.getRawDbEntity());
    L15:
        final List r7 = r5;
        if (r7.isEmpty() == false) goto L50;
        EntityIndexRecordInfo r8 = new EntityIndexRecordInfo(getEntityId(), String.valueOf(getType()), getPackageName(), null, null, null, null, 0, null, TypedValues.PositionType.TYPE_PERCENT_HEIGHT, null);
        onFirstIndex();
        r8.setInitIndexTaskTimeStamp();
        if (r12.element == false) goto L30;
        d r0 = (d) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r2.queryByEntityId(getEntityId(), getPackageName())), d.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L30;
        r6 = Long.valueOf(r0.getId());
    L30:
        if (r6 != null) goto L32;
        boolean r13 = true;
    L34:
        if (r13 == false) goto L36;
        setId(r2.insert(this));
    L40:
        if (getId() <= 0) goto L47;
        final Ref.BooleanRef r14 = new Ref.BooleanRef();
        r14.element = true;
        final boolean r15 = r13;
        id.f9213a.a(new $$Lambda$d$UEWEVCamZl_xrTRbxUb1dNs48vQ(r2, this, r26, r15, r14, r11));
        if (r14.element == true) goto L45;
        return false;
    L45:
        com.obric.memorydata.database.util.b.f9624a.a(r8);
        return true;
    L47:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "insert in RawDb error, entityId: " + getEntityId() + ", type: " + getType(), null, 4, null);
        return false;
    L36:
        setId(r6.longValue());
        r2.update(this);
        if (getId() <= 0) goto L40;
        EntityManager.INSTANCE.resumeLazyIndexPendingTask(getType(), getPackageName(), getId());
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "resumeLazyIndexPendingTask on first index, entityId: " + getEntityId() + ", type: " + getType() + ", id: " + getId(), false, 4, null);
        goto L40
    L32:
        r13 = false;
        goto L34
    L50:
        if (r7.size() != 1) goto L67;
        setId(((d) ZeusTransformUtils.preCheckCast(r7.get(0), d.class, "com.obric.memorydata.plugin")).getId());
        preparePoisonSnapshotForUpsert((d) ZeusTransformUtils.preCheckCast(r7.get(0), d.class, "com.obric.memorydata.plugin"));
        String r16 = ((d) ZeusTransformUtils.preCheckCast(r7.get(0), d.class, "com.obric.memorydata.plugin")).getUuid();
        if (r16 == null) goto L54;
        setUuid(r16);
    L54:
        final Set<String> r17 = com.obric.memorydata.database.index.s.a().getNeedUpdateColumns((d) ZeusTransformUtils.preCheckCast(r7.get(0), d.class, "com.obric.memorydata.plugin"), this);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.intersect((Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(com.obric.memorydata.database.index.s.a().getKeywordColumnMap(this).keySet(), Iterable.class, "com.obric.memorydata.plugin")), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L58;
        r17.add("insert_keyword_task");
    L58:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.intersect((Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(com.obric.memorydata.database.index.s.a().getContentTimeColumns(this).keySet(), Iterable.class, "com.obric.memorydata.plugin")), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L60;
        r17.add("insert_content_time_task");
    L60:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "reindex entityId: " + getEntityId() + ", entityType: " + getType() + ", updateColumns: " + r17, false, 4, null);
        final boolean r18 = com.obric.memorydata.database.index.t.f9438a.a((d) ZeusTransformUtils.preCheckCast(r7.get(0), d.class, "com.obric.memorydata.plugin"), this, true);
        com.obric.memorydata.database.index.s.a().assignmentAssociateField((d) ZeusTransformUtils.preCheckCast(r7.get(0), d.class, "com.obric.memorydata.plugin"), this, r17);
        onUpdate(r17, (d) ZeusTransformUtils.preCheckCast(r7.get(0), d.class, "com.obric.memorydata.plugin"), this);
        if (r2.update(this) > 0) goto L65;
        IRunLog r19 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r20 = new StringBuilder().append("update RawDb error, id: ").append(getId());
    L63:
        IRunLog.a.b(r19, TAG, r20.append(", type: ").append(getType()).toString(), null, 4, null);
        return false;
    L65:
        id.f9213a.a(new $$Lambda$d$crgc1EE31cwa3uN0oC2dLhXKZG4(r2, this, r17, r7, r18, r12, r11));
        return true;
    L67:
        r19 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r20 = new StringBuilder().append("more than one entityId in messageRawDb, entityId: ").append(getEntityId());
        goto L63
    L22:
        r5 = CollectionsKt.emptyList();
        goto L15
    L19:
        r4 = null;
        goto L20
    L12:
        if (EntityManager.INSTANCE.isLazyIndexEntity(getType(), getPackageName()) == true) goto L16;
        r5 = r2.queryByEntityId(getEntityId(), getPackageName());
        goto L15
    L8:
        r10 = getTimestamp();
        goto L9
    }

    public final boolean insertInvalidatePendingColumn(long r25, String r27) {
        Intrinsics.checkNotNullParameter(r27, "column");
        int r16 = 0;
        cd r14 = new cd(0, r25, getType(), getTimestamp(), getCreateTime(), 0, 0, r27, INVALIDATE_VALUE, r16, r16, null, false, 0, 0, 32353, null);
        r14.a(INVALIDATE_VALUE);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "insertInvalidatePendingColumn, rawDbId: " + r25 + " column: " + r27 + ' ', false, 4, null);
        Long r0 = (Long) ZeusTransformUtils.preCheckCast(com.obric.memorydata.database.index.ao.f9372a.a(com.obric.memorydata.database.manager.c.f9561a.a(getType()), r14, (com.obric.memorydata.database.index.bc) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.database.index.bc.a(System.currentTimeMillis()), com.obric.memorydata.database.index.bc.class, "com.obric.memorydata.plugin")).a(), Long.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L11;
        if (((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).longValue() < 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 != true) goto L11;
        return true;
    L7:
        r1 = false;
    L11:
        return false;
    }

    public final boolean insertPendingColumns(Set<String> r3) {
        Set<String> r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "columns");
        return insertPendingColumns(r4, updateStartEvidence());
    }

    public boolean isValidateValue(String r1) {
        Intrinsics.checkNotNullParameter(r1, "columnsName");
        return true;
    }

    public void onFirstIndex() {
    }

    public void onUpdate(Set<String> r2, d r3, d r4) {
        Intrinsics.checkNotNullParameter((Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin"), "updateColumns");
        Intrinsics.checkNotNullParameter(r3, "oldEntity");
        Intrinsics.checkNotNullParameter(r4, "newEntity");
    }

    public final void preparePoisonSnapshotForUpsert(d r3) {
        Intrinsics.checkNotNullParameter(r3, "oldEntity");
        if (getPoisonLabel() == null) goto L6;
        return;
    L6:
        if (getContentHash() != null) goto L8;
    L10:
        Integer r4 = null;
        setPoisonLabel(null);
    L11:
        setPoisonLabelVersion(r4);
        return;
    L8:
        if (Intrinsics.areEqual(getContentHash(), r3.getContentHash()) == false) goto L10;
        setPoisonLabel(r3.getPoisonLabel());
        r4 = r3.getPoisonLabelVersion();
        goto L11
    }

    public final void removePendingColumn(long r8, String r10) {
        Intrinsics.checkNotNullParameter(r10, "column");
        com.obric.memorydata.database.index.ao.a(com.obric.memorydata.database.index.ao.f9372a, com.obric.memorydata.database.manager.c.f9561a.a(getType()), CollectionsKt.listOf(new com.obric.memorydata.database.index.ax.b(r8, getType(), r10)), null, 4, null);
    }

    public void setContentHash(String r1) {
        this.contentHash = r1;
    }

    public void setId(long r1) {
        this.id = r1;
    }

    public void setPoisonLabel(Integer r1) {
        this.poisonLabel = r1;
    }

    public void setPoisonLabelVersion(Integer r1) {
        this.poisonLabelVersion = r1;
    }

    public void setTimestamp(long r1) {
        this.timestamp = r1;
    }

    public void setUuid(String r1) {
        this.uuid = r1;
    }
}
