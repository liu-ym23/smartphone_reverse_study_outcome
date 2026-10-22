package com.obric.memorydata.database.entity;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.reflect.TypeToken;
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
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005H\u0016J\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u00172\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u0017H\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u0017H\u0016J\u0014\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000eH\u0016J\u0014\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000eH\u0016J&\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00102\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0#H\u0016J\u001e\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010'\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010(\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\fH\u0016J\u001a\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\fH\u0016J\b\u0010,\u001a\u00020\u0014H\u0016R#\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/obric/memorydata/database/entity/RawCallHistoryIndex_Impl;", "Lcom/obric/memorydata/database/entity/RawCallHistoryIndex;", "<init>", "()V", "entityIndexHelper", "Lcom/obric/memorydata/database/index/EntityIndexHelper;", "Lcom/obric/memorydata/database/entity/RawCallHistoryEntity;", "Lcom/obric/memorydata/database/entity/CallHistoryEntityTextVectorCopilotEntity;", "Lcom/obric/memorydata/database/entity/AbstractContentTimeEntity;", "getEntityIndexHelper", "()Lcom/obric/memorydata/database/index/EntityIndexHelper;", "TAG", "", "buildKeywordIndexMap", "", "entity", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "getKeywordSchema", "Lcom/obric/search/api/schema/impl/FullTextSearchSchema;", "hasKeywordSchema", "", "getEntityIndexHelperInstance", "getNeedUpdateColumns", "", "oldRawEntity", "newRawEntity", "getAllColumns", "getPendingTaskColumns", "getKeywordColumnMap", "getContentTimeColumns", "assignmentAssociateField", "", "oldEntity", "newEntity", "changeColumns", "", "generateIndexPendingTask", "", "Lcom/obric/memorydata/database/entity/IndexPendingEntity;", "columnName", "executeIndexPendingTask", "updateField", "getValueByColumn", "", "isBuildMetaInfoFullContent", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class RawCallHistoryIndex_Impl implements fr {
    private final String TAG;
    private final com.obric.memorydata.database.index.t<fq, ai, com.obric.memorydata.database.entity.b> entityIndexHelper;

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

    public RawCallHistoryIndex_Impl() {
        com.obric.memorydata.database.index.t<fq, ai, com.obric.memorydata.database.entity.b> r0 = new com.obric.memorydata.database.index.t();
        this.entityIndexHelper = r0;
        this.TAG = "RawCallHistoryIndex_Impl";
        IAppEntityRawDbDao<? extends d> r1 = getRawDao();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.memorydata.database.dao.IAppEntityRawDbDao<com.obric.memorydata.database.entity.RawCallHistoryEntity>");
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
        r0.a(r1, r2, r3, r4, true);
    }

    @Override // com.obric.memorydata.database.index.e
    public void assignmentAssociateField(d r2, d r3, Set<String> r4) {
        Set r1 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "oldEntity");
        Intrinsics.checkNotNullParameter(r3, "newEntity");
        Intrinsics.checkNotNullParameter(r1, "changeColumns");
        if (ZeusTransformUtils.instanceOf(r2, fq.class) == false) goto L10;
        if (ZeusTransformUtils.instanceOf(r3, fq.class) == false) goto L8;
        return;
    L8:
        throw new IllegalStateException("Check failed.".toString());
    L10:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public Map<String, String> buildKeywordIndexMap(d r4) {
        Intrinsics.checkNotNullParameter(r4, "entity");
        if (ZeusTransformUtils.instanceOf(r4, fq.class) == false) goto L15;
        Map<String, String> r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        String r0 = ((fq) ZeusTransformUtils.preCheckCast(r4, fq.class, "com.obric.memorydata.plugin")).e();
        if (r0 == null) goto L7;
        r3.put("common1", r0);
    L7:
        String r1 = ((fq) ZeusTransformUtils.preCheckCast(r4, fq.class, "com.obric.memorydata.plugin")).h();
        if (r1 == null) goto L10;
        r3.put("common2", r1);
    L10:
        String r5 = ((fq) ZeusTransformUtils.preCheckCast(r4, fq.class, "com.obric.memorydata.plugin")).n();
        if (r5 == null) goto L13;
        r3.put("common3", r5);
    L13:
        return r3;
    L15:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public boolean executeIndexPendingTask(d r23, String r24) {
        Intrinsics.checkNotNullParameter(r23, "entity");
        Intrinsics.checkNotNullParameter(r24, "updateField");
        if (ZeusTransformUtils.instanceOf(r23, fq.class) == false) goto L86;
        long r4 = System.currentTimeMillis();
        EntityIndexRecordInfo r2 = com.obric.memorydata.database.util.b.f9624a.a(r23);
        if (Intrinsics.areEqual(r24, "insert_keyword_task") == false) goto L7;
        boolean r6 = this.entityIndexHelper.b(((fq) ZeusTransformUtils.preCheckCast(r23, fq.class, "com.obric.memorydata.plugin")).getId(), buildKeywordIndexMap(r23));
    L9:
        if (Intrinsics.areEqual(r24, "insert_content_time_task") == false) goto L51;
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(((fq) ZeusTransformUtils.preCheckCast(r23, fq.class, "com.obric.memorydata.plugin")).h(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L13;
    L16:
        boolean r10 = true;
    L17:
        if (r10 == true) goto L51;
        com.obric.memorydata.database.index.t<fq, ai, com.obric.memorydata.database.entity.b> r11 = this.entityIndexHelper;
        String r12 = ((fq) ZeusTransformUtils.preCheckCast(r23, fq.class, "com.obric.memorydata.plugin")).h();
        if (r12 != null) goto L21;
        r12 = "";
    L21:
        String r13 = r11.a(r23, r12, "transcript", (String) ZeusTransformUtils.preCheckCast(getContentTimeColumns().get("transcript"), String.class, "com.obric.memorydata.plugin"));
        if (r13 != null) goto L25;
        boolean r14 = false;
    L53:
        if (Intrinsics.areEqual(r24, "meta_full_content") == false) goto L55;
        boolean r15 = com.obric.memorydata.database.index.t.f9438a.a(r23);
    L57:
        if (Intrinsics.areEqual(r24, "transcript") == false) goto L61;
        String r16 = ((fq) ZeusTransformUtils.preCheckCast(r23, fq.class, "com.obric.memorydata.plugin")).h();
        if (r16 == null) goto L61;
        boolean r17 = this.entityIndexHelper.b(r23, "transcript", r16, "DEFAULT");
    L63:
        if (Intrinsics.areEqual(r24, "fullContent") == false) goto L65;
        boolean r7 = this.entityIndexHelper.c(r23, "fullContent", ((fq) ZeusTransformUtils.preCheckCast(r23, fq.class, "com.obric.memorydata.plugin")).k(), "DEFAULT");
    L67:
        if (Intrinsics.areEqual(r24, "transcriptTitle") == false) goto L73;
        String r18 = ((fq) ZeusTransformUtils.preCheckCast(r23, fq.class, "com.obric.memorydata.plugin")).n();
        if (r18 == null) goto L71;
        boolean r0 = this.entityIndexHelper.b(r23, "transcriptTitle", r18, "DEFAULT");
    L72:
        boolean r19 = r0;
    L74:
        if (r2 == null) goto L76;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", com.obric.memorydata.utils.u.a(r2), false, 4, null);
        com.obric.memorydata.database.util.b.f9624a.a("entityIndexTaskCost", String.valueOf(((fq) ZeusTransformUtils.preCheckCast(r23, fq.class, "com.obric.memorydata.plugin")).getType()), r24, System.currentTimeMillis() - r4);
    L76:
        if (r7 == false) goto L84;
        if (r19 == false) goto L84;
        if (r17 == false) goto L84;
        if (r6 == false) goto L84;
        if (r14 == false) goto L84;
        if (r15 == false) goto L84;
        return true;
    L84:
        return false;
    L71:
        r0 = true;
        goto L72
    L73:
        r19 = true;
        goto L74
    L65:
        r7 = true;
    L61:
        r17 = true;
        goto L63
    L55:
        r15 = true;
        goto L57
    L25:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L27;
        boolean r110 = true;
    L28:
        if (r110 == false) goto L51;
        String r111 = ((fq) ZeusTransformUtils.preCheckCast(r23, fq.class, "com.obric.memorydata.plugin")).i();
        CharSequence r112 = (CharSequence) ZeusTransformUtils.preCheckCast(r111, CharSequence.class, "com.obric.memorydata.plugin");
        if (r112 != null) goto L32;
    L35:
        boolean r113 = true;
    L36:
        if (r113 == false) goto L38;
    L37:
        ((fq) ZeusTransformUtils.preCheckCast(r23, fq.class, "com.obric.memorydata.plugin")).a(r13);
    L50:
        IAppEntityRawDbDao<? extends d> r20 = getRawDao();
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type com.obric.memorydata.database.dao.IAppEntityRawDbDao<com.obric.memorydata.database.entity.RawCallHistoryEntity>");
        r20.update(r23);
        goto L51
    L38:
        Map r114 = MapsKt.toMutableMap((Map) ZeusTransformUtils.preCheckCast(GsonUtil.INSTANCE.getGSON().fromJson(r111, new a().getType()), Map.class, "com.obric.memorydata.plugin"));
        if (r114.isEmpty() == true) goto L37;
        Map r21 = (Map) ZeusTransformUtils.preCheckCast(GsonUtil.INSTANCE.getGSON().fromJson(r13, new b().getType()), Map.class, "com.obric.memorydata.plugin");
        if (r21 == null) goto L49;
        Iterator r22 = r21.entrySet().iterator();
    L45:
        if (r22.hasNext() == false) goto L49;
        Map.Entry r115 = (Map.Entry) ZeusTransformUtils.preCheckCast(r22.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r116 = (String) ZeusTransformUtils.preCheckCast(r115.getKey(), String.class, "com.obric.memorydata.plugin");
        ExtractTimeDescPair r117 = (ExtractTimeDescPair) ZeusTransformUtils.preCheckCast(r115.getValue(), ExtractTimeDescPair.class, "com.obric.memorydata.plugin");
        if (r114.containsKey(r116) == true) goto L45;
        r114.put(r116, r117);
    L49:
        ((fq) ZeusTransformUtils.preCheckCast(r23, fq.class, "com.obric.memorydata.plugin")).a(com.obric.memorydata.utils.u.a(r114));
        goto L50
    L32:
        if (r112.length() == 0) goto L35;
        r113 = false;
        goto L36
    L27:
        r110 = false;
        goto L28
    L13:
        if (r9.length() == 0) goto L16;
        r10 = false;
    L51:
        r14 = true;
        goto L53
    L7:
        r6 = true;
        goto L9
    L86:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public List<cd> generateIndexPendingTask(String r34, d r35) {
        Intrinsics.checkNotNullParameter(r34, "columnName");
        Intrinsics.checkNotNullParameter(r35, "entity");
        if (ZeusTransformUtils.instanceOf(r35, fq.class) == false) goto L56;
        switch(r34.hashCode()) {
            case -1937787423: goto L49;
            case -1729759306: goto L38;
            case -1536949565: goto L33;
            case -425747390: goto L22;
            case -193103126: goto L13;
            case 1805045611: goto L8;
            default: goto L54;
        };
    L8:
        if (r34.equals("insert_content_time_task") == false) goto L54;
        return CollectionsKt.listOf(new cd(0, ((fq) ZeusTransformUtils.preCheckCast(r35, fq.class, "com.obric.memorydata.plugin")).getId(), ((fq) ZeusTransformUtils.preCheckCast(r35, fq.class, "com.obric.memorydata.plugin")).getType(), ((fq) ZeusTransformUtils.preCheckCast(r35, fq.class, "com.obric.memorydata.plugin")).getTimestamp(), ((fq) ZeusTransformUtils.preCheckCast(r35, fq.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, "insert_content_time_task", "content_time", 0, 0, null, false, 0, 0, 32353, null));
    L13:
        if (r34.equals("fullContent") == false) goto L54;
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L20;
        return CollectionsKt.listOf(new cd(0, ((fq) ZeusTransformUtils.preCheckCast(r35, fq.class, "com.obric.memorydata.plugin")).getId(), ((fq) ZeusTransformUtils.preCheckCast(r35, fq.class, "com.obric.memorydata.plugin")).getType(), ((fq) ZeusTransformUtils.preCheckCast(r35, fq.class, "com.obric.memorydata.plugin")).getTimestamp(), ((fq) ZeusTransformUtils.preCheckCast(r35, fq.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, r34, "full_content", 0, 0, null, false, 0, 0, 32353, null));
    L20:
        return CollectionsKt.emptyList();
    L22:
        if (r34.equals("transcriptTitle") == false) goto L54;
        if (((fq) ZeusTransformUtils.preCheckCast(r35, fq.class, "com.obric.memorydata.plugin")).n() == null) goto L54;
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L31;
        return this.entityIndexHelper.a(r35, r34, String.valueOf(((fq) ZeusTransformUtils.preCheckCast(r35, fq.class, "com.obric.memorydata.plugin")).n()));
    L31:
        return CollectionsKt.emptyList();
    L33:
        if (r34.equals("meta_full_content") == false) goto L54;
        return CollectionsKt.listOf(new cd(0, ((fq) ZeusTransformUtils.preCheckCast(r35, fq.class, "com.obric.memorydata.plugin")).getId(), ((fq) ZeusTransformUtils.preCheckCast(r35, fq.class, "com.obric.memorydata.plugin")).getType(), ((fq) ZeusTransformUtils.preCheckCast(r35, fq.class, "com.obric.memorydata.plugin")).getTimestamp(), ((fq) ZeusTransformUtils.preCheckCast(r35, fq.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, "meta_full_content", "meta_full_content", 0, 0, null, false, 0, 0, 32353, null));
    L38:
        if (r34.equals("transcript") == false) goto L54;
        if (((fq) ZeusTransformUtils.preCheckCast(r35, fq.class, "com.obric.memorydata.plugin")).h() == null) goto L54;
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L47;
        return this.entityIndexHelper.a(r35, r34, ((fq) ZeusTransformUtils.preCheckCast(r35, fq.class, "com.obric.memorydata.plugin")).h().toString());
    L47:
        return CollectionsKt.emptyList();
    L49:
        if (r34.equals("insert_keyword_task") == false) goto L54;
        return CollectionsKt.listOf(new cd(0, ((fq) ZeusTransformUtils.preCheckCast(r35, fq.class, "com.obric.memorydata.plugin")).getId(), ((fq) ZeusTransformUtils.preCheckCast(r35, fq.class, "com.obric.memorydata.plugin")).getType(), ((fq) ZeusTransformUtils.preCheckCast(r35, fq.class, "com.obric.memorydata.plugin")).getTimestamp(), ((fq) ZeusTransformUtils.preCheckCast(r35, fq.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, "insert_keyword_task", "keyword", 0, 0, null, false, 0, 0, 32353, null));
    L54:
        return CollectionsKt.emptyList();
    L56:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public Set<String> getAllColumns() {
        Set<String> r2 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        r2.add(LocationMonitorConst.TAG);
        r2.add("transcript");
        r2.add("fullContent");
        r2.add("transcriptTitle");
        r2.add("meta_full_content");
        return r2;
    }

    @Override // com.obric.memorydata.database.index.e
    public Map<String, String> getContentTimeColumns() {
        Map<String, String> r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        r2.put("transcript", "{\"chunkType\":\"DEFAULT\",\"targetColumn\":\"contentWithTime\"}");
        return r2;
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityContentTimeDao<? extends com.obric.memorydata.database.entity.b> getContentTimeDao() {
        return fr.a.d(this);
    }

    public final com.obric.memorydata.database.index.t<fq, ai, com.obric.memorydata.database.entity.b> getEntityIndexHelper() {
        return this.entityIndexHelper;
    }

    @Override // com.obric.memorydata.database.index.e
    public com.obric.memorydata.database.index.t<fq, ai, com.obric.memorydata.database.entity.b> getEntityIndexHelperInstance() {
        return this.entityIndexHelper;
    }

    @Override // com.obric.memorydata.database.index.e
    public IHistoryEntityDao<? extends c> getHistoryEntityDao() {
        return fr.a.e(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityVectorCopilotDao<? extends i> getImageCopilotDao() {
        return fr.a.c(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public Map<String, String> getKeywordColumnMap() {
        Map<String, String> r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        r2.put(LocationMonitorConst.TAG, "common1");
        r2.put("transcript", "common2");
        r2.put("transcriptTitle", "common3");
        return r2;
    }

    @Override // com.obric.memorydata.database.index.e
    public FullTextSearchSchema getKeywordSchema() {
        return this.entityIndexHelper.a();
    }

    @Override // com.obric.memorydata.database.index.e
    public Set<String> getNeedUpdateColumns(d r9, d r10) {
        Intrinsics.checkNotNullParameter(r9, "oldRawEntity");
        Intrinsics.checkNotNullParameter(r10, "newRawEntity");
        if (ZeusTransformUtils.instanceOf(r9, fq.class) == false) goto L23;
        if (ZeusTransformUtils.instanceOf(r10, fq.class) == false) goto L21;
        Set<String> r8 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        if (gd.f9146a.a(((fq) ZeusTransformUtils.preCheckCast(r9, fq.class, "com.obric.memorydata.plugin")).e(), ((fq) ZeusTransformUtils.preCheckCast(r10, fq.class, "com.obric.memorydata.plugin")).e(), null, null, false) == true) goto L10;
        r8.add(LocationMonitorConst.TAG);
    L10:
        if (gd.f9146a.a(((fq) ZeusTransformUtils.preCheckCast(r9, fq.class, "com.obric.memorydata.plugin")).h(), ((fq) ZeusTransformUtils.preCheckCast(r10, fq.class, "com.obric.memorydata.plugin")).h(), Type.TEXT, null, false) == true) goto L13;
        r8.add("transcript");
    L13:
        if (gd.f9146a.a(((fq) ZeusTransformUtils.preCheckCast(r9, fq.class, "com.obric.memorydata.plugin")).k(), ((fq) ZeusTransformUtils.preCheckCast(r10, fq.class, "com.obric.memorydata.plugin")).k(), Type.FULL_CONTENT, null, false) == true) goto L16;
        r8.add("fullContent");
    L16:
        if (gd.f9146a.a(((fq) ZeusTransformUtils.preCheckCast(r9, fq.class, "com.obric.memorydata.plugin")).n(), ((fq) ZeusTransformUtils.preCheckCast(r10, fq.class, "com.obric.memorydata.plugin")).n(), Type.TEXT, null, false) == true) goto L18;
        r8.add("transcriptTitle");
    L18:
        r8.add("meta_full_content");
        return r8;
    L21:
        throw new IllegalStateException("Check failed.".toString());
    L23:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public Set<String> getPendingTaskColumns() {
        Set<String> r2 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        r2.add("insert_keyword_task");
        r2.add("insert_content_time_task");
        r2.add("meta_full_content");
        r2.add("transcript");
        r2.add("fullContent");
        r2.add("transcriptTitle");
        return r2;
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityRawDbDao<? extends d> getRawDao() {
        return fr.a.a(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityVectorCopilotDao<? extends i> getTextCopilotDao() {
        return fr.a.b(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public Object getValueByColumn(d r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "entity");
        Intrinsics.checkNotNullParameter(r4, "columnName");
        if (ZeusTransformUtils.instanceOf(r3, fq.class) == false) goto L25;
        int r2 = r4.hashCode();
        if (r2 == (-1729759306)) goto L20;
        if (r2 == (-425747390)) goto L16;
        if (r2 == (-193103126)) goto L12;
    L21:
        return null;
    L12:
        if (r4.equals("fullContent") == false) goto L21;
        return ((fq) ZeusTransformUtils.preCheckCast(r3, fq.class, "com.obric.memorydata.plugin")).k();
    L16:
        if (r4.equals("transcriptTitle") == false) goto L21;
        return ((fq) ZeusTransformUtils.preCheckCast(r3, fq.class, "com.obric.memorydata.plugin")).n();
    L20:
        if (r4.equals("transcript") == false) goto L21;
        return ((fq) ZeusTransformUtils.preCheckCast(r3, fq.class, "com.obric.memorydata.plugin")).h();
    L25:
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
