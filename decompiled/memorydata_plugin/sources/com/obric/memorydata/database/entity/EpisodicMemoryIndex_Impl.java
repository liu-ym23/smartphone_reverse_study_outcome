package com.obric.memorydata.database.entity;

import com.google.gson.reflect.TypeToken;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.annotation.Type;
import com.obric.memorydata.database.dao.IAppEntityContentTimeDao;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.dao.IAppEntityVectorCopilotDao;
import com.obric.memorydata.database.dao.IHistoryEntityDao;
import com.obric.memorydata.database.index.EntityIndexRecordInfo;
import com.obric.memorydata.database.index.ExtractTimeDescPair;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.GsonUtil;
import com.obric.search.api.schema.impl.FullTextSearchSchema;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005H\u0016J\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u00172\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u0017H\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u0017H\u0016J\u0014\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000eH\u0016J\u0014\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000eH\u0016J&\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00102\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0#H\u0016J\u001e\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010'\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010(\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\fH\u0016J\u001a\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\fH\u0016J\b\u0010,\u001a\u00020\u0014H\u0016R#\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/obric/memorydata/database/entity/EpisodicMemoryIndex_Impl;", "Lcom/obric/memorydata/database/entity/EpisodicMemoryIndex;", "<init>", "()V", "entityIndexHelper", "Lcom/obric/memorydata/database/index/EntityIndexHelper;", "Lcom/obric/memorydata/database/entity/EpisodicMemoryEntity;", "Lcom/obric/memorydata/database/entity/EpisodicMemoryTextVectorCopilotEntity;", "Lcom/obric/memorydata/database/entity/AbstractContentTimeEntity;", "getEntityIndexHelper", "()Lcom/obric/memorydata/database/index/EntityIndexHelper;", "TAG", "", "buildKeywordIndexMap", "", "entity", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "getKeywordSchema", "Lcom/obric/search/api/schema/impl/FullTextSearchSchema;", "hasKeywordSchema", "", "getEntityIndexHelperInstance", "getNeedUpdateColumns", "", "oldRawEntity", "newRawEntity", "getAllColumns", "getPendingTaskColumns", "getKeywordColumnMap", "getContentTimeColumns", "assignmentAssociateField", "", "oldEntity", "newEntity", "changeColumns", "", "generateIndexPendingTask", "", "Lcom/obric/memorydata/database/entity/IndexPendingEntity;", "columnName", "executeIndexPendingTask", "updateField", "getValueByColumn", "", "isBuildMetaInfoFullContent", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class EpisodicMemoryIndex_Impl implements bk {
    private final String TAG;
    private final com.obric.memorydata.database.index.t<EpisodicMemoryEntity, bn, com.obric.memorydata.database.entity.b> entityIndexHelper;

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonUtil$fromJsonByType$1", "Lcom/google/gson/reflect/TypeToken;", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends TypeToken<Map<String, ? extends ExtractTimeDescPair>> {
        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonUtil$fromJsonByType$1", "Lcom/google/gson/reflect/TypeToken;", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends TypeToken<Map<String, ? extends ExtractTimeDescPair>> {
        public b() {
        }
    }

    public EpisodicMemoryIndex_Impl() {
        com.obric.memorydata.database.index.t<EpisodicMemoryEntity, bn, com.obric.memorydata.database.entity.b> r0 = new com.obric.memorydata.database.index.t();
        this.entityIndexHelper = r0;
        this.TAG = "EpisodicMemoryIndex_Impl";
        IAppEntityRawDbDao<? extends d> r1 = getRawDao();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.memorydata.database.dao.IAppEntityRawDbDao<com.obric.memorydata.database.entity.EpisodicMemoryEntity>");
        IAppEntityVectorCopilotDao<? extends i> r2 = getTextCopilotDao();
        IAppEntityContentTimeDao<? extends com.obric.memorydata.database.entity.b> r4 = null;
        if (ZeusTransformUtils.instanceOf(r2, IAppEntityVectorCopilotDao.class) == true) goto L6;
        r2 = null;
    L6:
        IAppEntityVectorCopilotDao<? extends i> r3 = getImageCopilotDao();
        if (ZeusTransformUtils.instanceOf(r3, IAppEntityVectorCopilotDao.class) == true) goto L10;
        r3 = null;
    L10:
        IAppEntityContentTimeDao<? extends com.obric.memorydata.database.entity.b> r6 = getContentTimeDao();
        if (ZeusTransformUtils.instanceOf(r6, IAppEntityContentTimeDao.class) == false) goto L13;
        r4 = r6;
    L13:
        r0.a(r1, r2, r3, r4, false);
    }

    @Override // com.obric.memorydata.database.index.e
    public void assignmentAssociateField(d r2, d r3, Set<String> r4) {
        Set r1 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "oldEntity");
        Intrinsics.checkNotNullParameter(r3, "newEntity");
        Intrinsics.checkNotNullParameter(r1, "changeColumns");
        if (ZeusTransformUtils.instanceOf(r2, EpisodicMemoryEntity.class) == false) goto L10;
        if (ZeusTransformUtils.instanceOf(r3, EpisodicMemoryEntity.class) == false) goto L8;
        return;
    L8:
        throw new IllegalStateException("Check failed.".toString());
    L10:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public Map<String, String> buildKeywordIndexMap(d r2) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        if (ZeusTransformUtils.instanceOf(r2, EpisodicMemoryEntity.class) == false) goto L7;
        return (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    L7:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public boolean executeIndexPendingTask(d r20, String r21) {
        Intrinsics.checkNotNullParameter(r20, "entity");
        Intrinsics.checkNotNullParameter(r21, "updateField");
        if (ZeusTransformUtils.instanceOf(r20, EpisodicMemoryEntity.class) == false) goto L69;
        long r4 = System.currentTimeMillis();
        EntityIndexRecordInfo r2 = com.obric.memorydata.database.util.b.f9624a.a(r20);
        if (Intrinsics.areEqual(r21, "insert_content_time_task") == false) goto L47;
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r20, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getContent(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L9;
    L12:
        boolean r7 = true;
    L13:
        if (r7 == true) goto L47;
        com.obric.memorydata.database.index.t<EpisodicMemoryEntity, bn, com.obric.memorydata.database.entity.b> r8 = this.entityIndexHelper;
        String r11 = ((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r20, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getContent();
        if (r11 != null) goto L17;
        r11 = "";
    L17:
        String r9 = r8.a(r20, r11, Params.CONTENT, (String) ZeusTransformUtils.preCheckCast(getContentTimeColumns().get(Params.CONTENT), String.class, "com.obric.memorydata.plugin"));
        if (r9 != null) goto L21;
        boolean r10 = false;
    L49:
        if (Intrinsics.areEqual(r21, "meta_full_content") == false) goto L51;
        boolean r12 = com.obric.memorydata.database.index.t.f9438a.a(r20);
    L53:
        if (Intrinsics.areEqual(r21, Params.CONTENT) == false) goto L55;
        boolean r13 = this.entityIndexHelper.b(r20, Params.CONTENT, ((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r20, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getContent(), "DEFAULT");
    L57:
        if (Intrinsics.areEqual(r21, "fullContent") == false) goto L59;
        boolean r14 = this.entityIndexHelper.c(r20, "fullContent", ((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r20, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getFullContent(), "DEFAULT");
    L60:
        if (r2 == null) goto L62;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", com.obric.memorydata.utils.u.a(r2), false, 4, null);
        com.obric.memorydata.database.util.b.f9624a.a("entityIndexTaskCost", String.valueOf(((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r20, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getType()), r21, System.currentTimeMillis() - r4);
    L62:
        if (r13 == false) goto L75;
        if (r14 == false) goto L76;
        if (r10 == false) goto L77;
        if (r12 == true) goto L67;
        return false;
    L67:
        return true;
    L77:
        return false;
    L76:
        return false;
    L75:
        return false;
    L59:
        r14 = true;
        goto L60
    L55:
        r13 = true;
        goto L57
    L51:
        r12 = true;
        goto L53
    L21:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L23;
        boolean r15 = true;
    L24:
        if (r15 == false) goto L47;
        String r16 = ((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r20, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getContentWithTime();
        CharSequence r17 = (CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.memorydata.plugin");
        if (r17 != null) goto L28;
    L31:
        boolean r18 = true;
    L32:
        if (r18 == false) goto L34;
    L33:
        ((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r20, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).setContentWithTime(r9);
    L46:
        IAppEntityRawDbDao<? extends d> r19 = getRawDao();
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type com.obric.memorydata.database.dao.IAppEntityRawDbDao<com.obric.memorydata.database.entity.EpisodicMemoryEntity>");
        r19.update(r20);
        goto L47
    L34:
        Map r110 = MapsKt.toMutableMap((Map) ZeusTransformUtils.preCheckCast(GsonUtil.INSTANCE.getGSON().fromJson(r16, new a().getType()), Map.class, "com.obric.memorydata.plugin"));
        if (r110.isEmpty() == true) goto L33;
        Map r22 = (Map) ZeusTransformUtils.preCheckCast(GsonUtil.INSTANCE.getGSON().fromJson(r9, new b().getType()), Map.class, "com.obric.memorydata.plugin");
        if (r22 == null) goto L45;
        Iterator r23 = r22.entrySet().iterator();
    L41:
        if (r23.hasNext() == false) goto L45;
        Map.Entry r111 = (Map.Entry) ZeusTransformUtils.preCheckCast(r23.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r112 = (String) ZeusTransformUtils.preCheckCast(r111.getKey(), String.class, "com.obric.memorydata.plugin");
        ExtractTimeDescPair r113 = (ExtractTimeDescPair) ZeusTransformUtils.preCheckCast(r111.getValue(), ExtractTimeDescPair.class, "com.obric.memorydata.plugin");
        if (r110.containsKey(r112) == true) goto L41;
        r110.put(r112, r113);
    L45:
        ((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r20, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).setContentWithTime(com.obric.memorydata.utils.u.a(r110));
        goto L46
    L28:
        if (r17.length() == 0) goto L31;
        r18 = false;
        goto L32
    L23:
        r15 = false;
        goto L24
    L9:
        if (r6.length() == 0) goto L12;
        r7 = false;
    L47:
        r10 = true;
        goto L49
    L69:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public List<cd> generateIndexPendingTask(String r34, d r35) {
        Intrinsics.checkNotNullParameter(r34, "columnName");
        Intrinsics.checkNotNullParameter(r35, "entity");
        if (ZeusTransformUtils.instanceOf(r35, EpisodicMemoryEntity.class) == false) goto L43;
        switch(r34.hashCode()) {
            case -1937787423: goto L36;
            case -1536949565: goto L31;
            case -193103126: goto L22;
            case 951530617: goto L13;
            case 1805045611: goto L8;
            default: goto L41;
        };
    L8:
        if (r34.equals("insert_content_time_task") == false) goto L41;
        return CollectionsKt.listOf(new cd(0, ((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r35, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getId(), ((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r35, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getType(), ((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r35, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getTimestamp(), ((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r35, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, "insert_content_time_task", "content_time", 0, 0, null, false, 0, 0, 32353, null));
    L13:
        if (r34.equals(Params.CONTENT) == false) goto L41;
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L20;
        return this.entityIndexHelper.a(r35, r34, ((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r35, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getContent().toString());
    L20:
        return CollectionsKt.emptyList();
    L22:
        if (r34.equals("fullContent") == false) goto L41;
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L29;
        return CollectionsKt.listOf(new cd(0, ((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r35, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getId(), ((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r35, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getType(), ((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r35, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getTimestamp(), ((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r35, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, r34, "full_content", 0, 0, null, false, 0, 0, 32353, null));
    L29:
        return CollectionsKt.emptyList();
    L31:
        if (r34.equals("meta_full_content") == false) goto L41;
        return CollectionsKt.listOf(new cd(0, ((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r35, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getId(), ((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r35, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getType(), ((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r35, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getTimestamp(), ((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r35, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, "meta_full_content", "meta_full_content", 0, 0, null, false, 0, 0, 32353, null));
    L36:
        if (r34.equals("insert_keyword_task") == false) goto L41;
        return CollectionsKt.listOf(new cd(0, ((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r35, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getId(), ((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r35, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getType(), ((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r35, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getTimestamp(), ((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r35, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, "insert_keyword_task", "keyword", 0, 0, null, false, 0, 0, 32353, null));
    L41:
        return CollectionsKt.emptyList();
    L43:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public Set<String> getAllColumns() {
        Set<String> r2 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        r2.add(Params.CONTENT);
        r2.add("fullContent");
        r2.add("meta_full_content");
        return r2;
    }

    @Override // com.obric.memorydata.database.index.e
    public Map<String, String> getContentTimeColumns() {
        Map<String, String> r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        r2.put(Params.CONTENT, "{\"chunkType\":\"PROACTIVE_MEMORY\",\"targetColumn\":\"contentWithTime\"}");
        return r2;
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityContentTimeDao<? extends com.obric.memorydata.database.entity.b> getContentTimeDao() {
        return bk.a.d(this);
    }

    public final com.obric.memorydata.database.index.t<EpisodicMemoryEntity, bn, com.obric.memorydata.database.entity.b> getEntityIndexHelper() {
        return this.entityIndexHelper;
    }

    @Override // com.obric.memorydata.database.index.e
    public com.obric.memorydata.database.index.t<EpisodicMemoryEntity, bn, com.obric.memorydata.database.entity.b> getEntityIndexHelperInstance() {
        return this.entityIndexHelper;
    }

    @Override // com.obric.memorydata.database.index.e
    public IHistoryEntityDao<? extends c> getHistoryEntityDao() {
        return bk.a.e(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityVectorCopilotDao<? extends i> getImageCopilotDao() {
        return bk.a.c(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public Map<String, String> getKeywordColumnMap() {
        return (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.index.e
    public FullTextSearchSchema getKeywordSchema() {
        return this.entityIndexHelper.a();
    }

    @Override // com.obric.memorydata.database.index.e
    public Set<String> getNeedUpdateColumns(d r9, d r10) {
        Intrinsics.checkNotNullParameter(r9, "oldRawEntity");
        Intrinsics.checkNotNullParameter(r10, "newRawEntity");
        if (ZeusTransformUtils.instanceOf(r9, EpisodicMemoryEntity.class) == false) goto L17;
        if (ZeusTransformUtils.instanceOf(r10, EpisodicMemoryEntity.class) == false) goto L15;
        Set<String> r8 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        if (gd.f9146a.a(((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r9, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getContent(), ((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r10, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getContent(), Type.TEXT, null, false) == true) goto L10;
        r8.add(Params.CONTENT);
    L10:
        if (gd.f9146a.a(((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r9, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getFullContent(), ((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r10, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getFullContent(), Type.FULL_CONTENT, null, false) == true) goto L12;
        r8.add("fullContent");
    L12:
        r8.add("meta_full_content");
        return r8;
    L15:
        throw new IllegalStateException("Check failed.".toString());
    L17:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public Set<String> getPendingTaskColumns() {
        Set<String> r2 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        r2.add("insert_content_time_task");
        r2.add("meta_full_content");
        r2.add(Params.CONTENT);
        r2.add("fullContent");
        return r2;
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityRawDbDao<? extends d> getRawDao() {
        return bk.a.a(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityVectorCopilotDao<? extends i> getTextCopilotDao() {
        return bk.a.b(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public Object getValueByColumn(d r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        Intrinsics.checkNotNullParameter(r3, "columnName");
        if (ZeusTransformUtils.instanceOf(r2, EpisodicMemoryEntity.class) == false) goto L13;
        if (Intrinsics.areEqual(r3, Params.CONTENT) == false) goto L8;
        return ((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r2, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getContent();
    L8:
        if (Intrinsics.areEqual(r3, "fullContent") == true) goto L15;
        return null;
    L15:
        return ((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r2, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getFullContent();
    L13:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public boolean hasKeywordSchema() {
        return this.entityIndexHelper.b();
    }

    @Override // com.obric.memorydata.database.index.e
    public boolean isBuildMetaInfoFullContent() {
        return true;
    }
}
