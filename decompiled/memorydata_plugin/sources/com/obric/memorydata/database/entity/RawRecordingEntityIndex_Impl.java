package com.obric.memorydata.database.entity;

import com.bytedance.crash.tracker.ActivityLifecycle;
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
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005H\u0016J\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u00172\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u0017H\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u0017H\u0016J\u0014\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000eH\u0016J\u0014\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000eH\u0016J&\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00102\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0#H\u0016J\u001e\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010'\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010(\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\fH\u0016J\u001a\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\fH\u0016J\b\u0010,\u001a\u00020\u0014H\u0016R#\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/obric/memorydata/database/entity/RawRecordingEntityIndex_Impl;", "Lcom/obric/memorydata/database/entity/RawRecordingEntityIndex;", "<init>", "()V", "entityIndexHelper", "Lcom/obric/memorydata/database/index/EntityIndexHelper;", "Lcom/obric/memorydata/database/entity/RawRecordingEntity;", "Lcom/obric/memorydata/database/entity/RecordingEntityTextVectorCopilotEntity;", "Lcom/obric/memorydata/database/entity/AbstractContentTimeEntity;", "getEntityIndexHelper", "()Lcom/obric/memorydata/database/index/EntityIndexHelper;", "TAG", "", "buildKeywordIndexMap", "", "entity", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "getKeywordSchema", "Lcom/obric/search/api/schema/impl/FullTextSearchSchema;", "hasKeywordSchema", "", "getEntityIndexHelperInstance", "getNeedUpdateColumns", "", "oldRawEntity", "newRawEntity", "getAllColumns", "getPendingTaskColumns", "getKeywordColumnMap", "getContentTimeColumns", "assignmentAssociateField", "", "oldEntity", "newEntity", "changeColumns", "", "generateIndexPendingTask", "", "Lcom/obric/memorydata/database/entity/IndexPendingEntity;", "columnName", "executeIndexPendingTask", "updateField", "getValueByColumn", "", "isBuildMetaInfoFullContent", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class RawRecordingEntityIndex_Impl implements hi {
    private final String TAG;
    private final com.obric.memorydata.database.index.t<hh, hv, com.obric.memorydata.database.entity.b> entityIndexHelper;

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

    public RawRecordingEntityIndex_Impl() {
        com.obric.memorydata.database.index.t<hh, hv, com.obric.memorydata.database.entity.b> r0 = new com.obric.memorydata.database.index.t();
        this.entityIndexHelper = r0;
        this.TAG = "RawRecordingEntityIndex_Impl";
        IAppEntityRawDbDao<? extends d> r1 = getRawDao();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.memorydata.database.dao.IAppEntityRawDbDao<com.obric.memorydata.database.entity.RawRecordingEntity>");
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
        if (ZeusTransformUtils.instanceOf(r2, hh.class) == false) goto L10;
        if (ZeusTransformUtils.instanceOf(r3, hh.class) == false) goto L8;
        return;
    L8:
        throw new IllegalStateException("Check failed.".toString());
    L10:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public Map<String, String> buildKeywordIndexMap(d r4) {
        Intrinsics.checkNotNullParameter(r4, "entity");
        if (ZeusTransformUtils.instanceOf(r4, hh.class) == false) goto L12;
        Map<String, String> r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        r3.put("common1", ((hh) ZeusTransformUtils.preCheckCast(r4, hh.class, "com.obric.memorydata.plugin")).c());
        String r0 = ((hh) ZeusTransformUtils.preCheckCast(r4, hh.class, "com.obric.memorydata.plugin")).k();
        if (r0 == null) goto L7;
        r3.put("common2", r0);
    L7:
        String r5 = ((hh) ZeusTransformUtils.preCheckCast(r4, hh.class, "com.obric.memorydata.plugin")).n();
        if (r5 == null) goto L10;
        r3.put("common4", r5);
    L10:
        return r3;
    L12:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public boolean executeIndexPendingTask(d r24, String r25) {
        Intrinsics.checkNotNullParameter(r24, "entity");
        Intrinsics.checkNotNullParameter(r25, "updateField");
        if (ZeusTransformUtils.instanceOf(r24, hh.class) == false) goto L84;
        long r4 = System.currentTimeMillis();
        EntityIndexRecordInfo r2 = com.obric.memorydata.database.util.b.f9624a.a(r24);
        if (Intrinsics.areEqual(r25, "insert_keyword_task") == false) goto L7;
        boolean r6 = this.entityIndexHelper.b(((hh) ZeusTransformUtils.preCheckCast(r24, hh.class, "com.obric.memorydata.plugin")).getId(), buildKeywordIndexMap(r24));
    L9:
        if (Intrinsics.areEqual(r25, "insert_content_time_task") == false) goto L51;
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(((hh) ZeusTransformUtils.preCheckCast(r24, hh.class, "com.obric.memorydata.plugin")).g(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L13;
    L16:
        boolean r10 = true;
    L17:
        if (r10 == true) goto L51;
        com.obric.memorydata.database.index.t<hh, hv, com.obric.memorydata.database.entity.b> r11 = this.entityIndexHelper;
        String r12 = ((hh) ZeusTransformUtils.preCheckCast(r24, hh.class, "com.obric.memorydata.plugin")).g();
        if (r12 != null) goto L21;
        r12 = "";
    L21:
        String r13 = r11.a(r24, r12, "summary", (String) ZeusTransformUtils.preCheckCast(getContentTimeColumns().get("summary"), String.class, "com.obric.memorydata.plugin"));
        if (r13 != null) goto L25;
        boolean r14 = false;
    L53:
        if (Intrinsics.areEqual(r25, "meta_full_content") == false) goto L55;
        boolean r15 = com.obric.memorydata.database.index.t.f9438a.a(r24);
    L57:
        if (Intrinsics.areEqual(r25, "transcript") == false) goto L61;
        String r16 = ((hh) ZeusTransformUtils.preCheckCast(r24, hh.class, "com.obric.memorydata.plugin")).f();
        if (r16 == null) goto L61;
        boolean r17 = this.entityIndexHelper.a((e) ZeusTransformUtils.preCheckCast(r24, e.class, "com.obric.memorydata.plugin"), r16, true, -309, "txt", new String[0]);
    L63:
        if (Intrinsics.areEqual(r25, "summary") == false) goto L67;
        String r18 = ((hh) ZeusTransformUtils.preCheckCast(r24, hh.class, "com.obric.memorydata.plugin")).g();
        if (r18 == null) goto L67;
        boolean r7 = this.entityIndexHelper.b(r24, "summary", r18, "DEFAULT");
    L69:
        if (Intrinsics.areEqual(r25, "fullContent") == false) goto L71;
        boolean r19 = this.entityIndexHelper.c(r24, "fullContent", ((hh) ZeusTransformUtils.preCheckCast(r24, hh.class, "com.obric.memorydata.plugin")).m(), "DEFAULT");
    L72:
        if (r2 == null) goto L74;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", com.obric.memorydata.utils.u.a(r2), false, 4, null);
        com.obric.memorydata.database.util.b.f9624a.a("entityIndexTaskCost", String.valueOf(((hh) ZeusTransformUtils.preCheckCast(r24, hh.class, "com.obric.memorydata.plugin")).getType()), r25, System.currentTimeMillis() - r4);
    L74:
        if (r19 == false) goto L82;
        if (r7 == false) goto L82;
        if (r17 == false) goto L82;
        if (r6 == false) goto L82;
        if (r14 == false) goto L82;
        if (r15 == false) goto L82;
        return true;
    L82:
        return false;
    L71:
        r19 = true;
    L67:
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
        String r111 = ((hh) ZeusTransformUtils.preCheckCast(r24, hh.class, "com.obric.memorydata.plugin")).h();
        CharSequence r112 = (CharSequence) ZeusTransformUtils.preCheckCast(r111, CharSequence.class, "com.obric.memorydata.plugin");
        if (r112 != null) goto L32;
    L35:
        boolean r113 = true;
    L36:
        if (r113 == false) goto L38;
    L37:
        ((hh) ZeusTransformUtils.preCheckCast(r24, hh.class, "com.obric.memorydata.plugin")).b(r13);
    L50:
        IAppEntityRawDbDao<? extends d> r20 = getRawDao();
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type com.obric.memorydata.database.dao.IAppEntityRawDbDao<com.obric.memorydata.database.entity.RawRecordingEntity>");
        r20.update(r24);
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
        ((hh) ZeusTransformUtils.preCheckCast(r24, hh.class, "com.obric.memorydata.plugin")).b(com.obric.memorydata.utils.u.a(r114));
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
    L84:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public List<cd> generateIndexPendingTask(String r34, d r35) {
        Intrinsics.checkNotNullParameter(r34, "columnName");
        Intrinsics.checkNotNullParameter(r35, "entity");
        if (ZeusTransformUtils.instanceOf(r35, hh.class) == false) goto L52;
        switch(r34.hashCode()) {
            case -1937787423: goto L45;
            case -1857640538: goto L34;
            case -1729759306: goto L27;
            case -1536949565: goto L22;
            case -193103126: goto L13;
            case 1805045611: goto L8;
            default: goto L50;
        };
    L8:
        if (r34.equals("insert_content_time_task") == false) goto L50;
        return CollectionsKt.listOf(new cd(0, ((hh) ZeusTransformUtils.preCheckCast(r35, hh.class, "com.obric.memorydata.plugin")).getId(), ((hh) ZeusTransformUtils.preCheckCast(r35, hh.class, "com.obric.memorydata.plugin")).getType(), ((hh) ZeusTransformUtils.preCheckCast(r35, hh.class, "com.obric.memorydata.plugin")).getTimestamp(), ((hh) ZeusTransformUtils.preCheckCast(r35, hh.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, "insert_content_time_task", "content_time", 0, 0, null, false, 0, 0, 32353, null));
    L13:
        if (r34.equals("fullContent") == false) goto L50;
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L20;
        return CollectionsKt.listOf(new cd(0, ((hh) ZeusTransformUtils.preCheckCast(r35, hh.class, "com.obric.memorydata.plugin")).getId(), ((hh) ZeusTransformUtils.preCheckCast(r35, hh.class, "com.obric.memorydata.plugin")).getType(), ((hh) ZeusTransformUtils.preCheckCast(r35, hh.class, "com.obric.memorydata.plugin")).getTimestamp(), ((hh) ZeusTransformUtils.preCheckCast(r35, hh.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, r34, "full_content", 0, 0, null, false, 0, 0, 32353, null));
    L20:
        return CollectionsKt.emptyList();
    L22:
        if (r34.equals("meta_full_content") == false) goto L50;
        return CollectionsKt.listOf(new cd(0, ((hh) ZeusTransformUtils.preCheckCast(r35, hh.class, "com.obric.memorydata.plugin")).getId(), ((hh) ZeusTransformUtils.preCheckCast(r35, hh.class, "com.obric.memorydata.plugin")).getType(), ((hh) ZeusTransformUtils.preCheckCast(r35, hh.class, "com.obric.memorydata.plugin")).getTimestamp(), ((hh) ZeusTransformUtils.preCheckCast(r35, hh.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, "meta_full_content", "meta_full_content", 0, 0, null, false, 0, 0, 32353, null));
    L27:
        if (r34.equals("transcript") == false) goto L50;
        if (((hh) ZeusTransformUtils.preCheckCast(r35, hh.class, "com.obric.memorydata.plugin")).f() == null) goto L50;
        return CollectionsKt.listOf(new cd(0, ((hh) ZeusTransformUtils.preCheckCast(r35, hh.class, "com.obric.memorydata.plugin")).getId(), ((hh) ZeusTransformUtils.preCheckCast(r35, hh.class, "com.obric.memorydata.plugin")).getType(), ((hh) ZeusTransformUtils.preCheckCast(r35, hh.class, "com.obric.memorydata.plugin")).getTimestamp(), ((hh) ZeusTransformUtils.preCheckCast(r35, hh.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, r34, "file_text", 0, 0, null, false, 0, 0, 32353, null));
    L34:
        if (r34.equals("summary") == false) goto L50;
        if (((hh) ZeusTransformUtils.preCheckCast(r35, hh.class, "com.obric.memorydata.plugin")).g() == null) goto L50;
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L43;
        return this.entityIndexHelper.a(r35, r34, ((hh) ZeusTransformUtils.preCheckCast(r35, hh.class, "com.obric.memorydata.plugin")).g().toString());
    L43:
        return CollectionsKt.emptyList();
    L45:
        if (r34.equals("insert_keyword_task") == false) goto L50;
        return CollectionsKt.listOf(new cd(0, ((hh) ZeusTransformUtils.preCheckCast(r35, hh.class, "com.obric.memorydata.plugin")).getId(), ((hh) ZeusTransformUtils.preCheckCast(r35, hh.class, "com.obric.memorydata.plugin")).getType(), ((hh) ZeusTransformUtils.preCheckCast(r35, hh.class, "com.obric.memorydata.plugin")).getTimestamp(), ((hh) ZeusTransformUtils.preCheckCast(r35, hh.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, "insert_keyword_task", "keyword", 0, 0, null, false, 0, 0, 32353, null));
    L50:
        return CollectionsKt.emptyList();
    L52:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public Set<String> getAllColumns() {
        Set<String> r2 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        r2.add(ActivityLifecycle.NAME);
        r2.add("transcript");
        r2.add("summary");
        r2.add("sourceAppName");
        r2.add("fullContent");
        r2.add("sourceDevice");
        r2.add("meta_full_content");
        return r2;
    }

    @Override // com.obric.memorydata.database.index.e
    public Map<String, String> getContentTimeColumns() {
        Map<String, String> r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        r2.put("summary", "{\"chunkType\":\"DEFAULT\",\"targetColumn\":\"contentWithTime\"}");
        return r2;
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityContentTimeDao<? extends com.obric.memorydata.database.entity.b> getContentTimeDao() {
        return hi.a.d(this);
    }

    public final com.obric.memorydata.database.index.t<hh, hv, com.obric.memorydata.database.entity.b> getEntityIndexHelper() {
        return this.entityIndexHelper;
    }

    @Override // com.obric.memorydata.database.index.e
    public com.obric.memorydata.database.index.t<hh, hv, com.obric.memorydata.database.entity.b> getEntityIndexHelperInstance() {
        return this.entityIndexHelper;
    }

    @Override // com.obric.memorydata.database.index.e
    public IHistoryEntityDao<? extends c> getHistoryEntityDao() {
        return hi.a.e(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityVectorCopilotDao<? extends i> getImageCopilotDao() {
        return hi.a.c(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public Map<String, String> getKeywordColumnMap() {
        Map<String, String> r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        r2.put(ActivityLifecycle.NAME, "common1");
        r2.put("sourceAppName", "common2");
        r2.put("sourceDevice", "common4");
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
        if (ZeusTransformUtils.instanceOf(r9, hh.class) == false) goto L29;
        if (ZeusTransformUtils.instanceOf(r10, hh.class) == false) goto L27;
        Set<String> r8 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        if (gd.f9146a.a(((hh) ZeusTransformUtils.preCheckCast(r9, hh.class, "com.obric.memorydata.plugin")).c(), ((hh) ZeusTransformUtils.preCheckCast(r10, hh.class, "com.obric.memorydata.plugin")).c(), null, null, false) == true) goto L10;
        r8.add(ActivityLifecycle.NAME);
    L10:
        if (gd.f9146a.a(((hh) ZeusTransformUtils.preCheckCast(r9, hh.class, "com.obric.memorydata.plugin")).g(), ((hh) ZeusTransformUtils.preCheckCast(r10, hh.class, "com.obric.memorydata.plugin")).g(), Type.TEXT, null, false) == true) goto L13;
        r8.add("summary");
    L13:
        if (gd.f9146a.a(((hh) ZeusTransformUtils.preCheckCast(r9, hh.class, "com.obric.memorydata.plugin")).k(), ((hh) ZeusTransformUtils.preCheckCast(r10, hh.class, "com.obric.memorydata.plugin")).k(), null, null, false) == true) goto L16;
        r8.add("sourceAppName");
    L16:
        if (gd.f9146a.a(((hh) ZeusTransformUtils.preCheckCast(r9, hh.class, "com.obric.memorydata.plugin")).m(), ((hh) ZeusTransformUtils.preCheckCast(r10, hh.class, "com.obric.memorydata.plugin")).m(), Type.FULL_CONTENT, null, false) == true) goto L19;
        r8.add("fullContent");
    L19:
        if (gd.f9146a.a(((hh) ZeusTransformUtils.preCheckCast(r9, hh.class, "com.obric.memorydata.plugin")).n(), ((hh) ZeusTransformUtils.preCheckCast(r10, hh.class, "com.obric.memorydata.plugin")).n(), null, null, false) == true) goto L22;
        r8.add("sourceDevice");
    L22:
        if (gd.f9146a.a(((hh) ZeusTransformUtils.preCheckCast(r9, hh.class, "com.obric.memorydata.plugin")).f(), ((hh) ZeusTransformUtils.preCheckCast(r10, hh.class, "com.obric.memorydata.plugin")).f(), null, null, false) == true) goto L24;
        r8.add("transcript");
    L24:
        r8.add("meta_full_content");
        return r8;
    L27:
        throw new IllegalStateException("Check failed.".toString());
    L29:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public Set<String> getPendingTaskColumns() {
        Set<String> r2 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        r2.add("insert_keyword_task");
        r2.add("insert_content_time_task");
        r2.add("meta_full_content");
        r2.add("summary");
        r2.add("fullContent");
        return r2;
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityRawDbDao<? extends d> getRawDao() {
        return hi.a.a(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityVectorCopilotDao<? extends i> getTextCopilotDao() {
        return hi.a.b(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public Object getValueByColumn(d r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        Intrinsics.checkNotNullParameter(r3, "columnName");
        if (ZeusTransformUtils.instanceOf(r2, hh.class) == false) goto L13;
        if (Intrinsics.areEqual(r3, "summary") == false) goto L8;
        return ((hh) ZeusTransformUtils.preCheckCast(r2, hh.class, "com.obric.memorydata.plugin")).g();
    L8:
        if (Intrinsics.areEqual(r3, "fullContent") == true) goto L15;
        return null;
    L15:
        return ((hh) ZeusTransformUtils.preCheckCast(r2, hh.class, "com.obric.memorydata.plugin")).m();
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
