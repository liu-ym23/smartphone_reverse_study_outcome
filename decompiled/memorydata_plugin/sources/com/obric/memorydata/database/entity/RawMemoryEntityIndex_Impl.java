package com.obric.memorydata.database.entity;

import com.google.gson.reflect.TypeToken;
import com.obric.memorydata.annotation.Type;
import com.obric.memorydata.database.dao.IAppEntityContentTimeDao;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.dao.IAppEntityVectorCopilotDao;
import com.obric.memorydata.database.dao.IHistoryEntityDao;
import com.obric.memorydata.database.index.EntityIndexRecordInfo;
import com.obric.memorydata.database.index.ExtractTimeDescPair;
import com.obric.memorydata.memory.ui.list.MemoryListActivity;
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
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005H\u0016J\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u00172\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u0017H\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u0017H\u0016J\u0014\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000eH\u0016J\u0014\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000eH\u0016J&\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00102\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0#H\u0016J\u001e\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010'\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010(\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\fH\u0016J\u001a\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\fH\u0016J\b\u0010,\u001a\u00020\u0014H\u0016R#\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/obric/memorydata/database/entity/RawMemoryEntityIndex_Impl;", "Lcom/obric/memorydata/database/entity/RawMemoryEntityIndex;", "<init>", "()V", "entityIndexHelper", "Lcom/obric/memorydata/database/index/EntityIndexHelper;", "Lcom/obric/memorydata/database/entity/RawMemoryEntity;", "Lcom/obric/memorydata/database/entity/MemoryEntityTextVectorCopilotEntity;", "Lcom/obric/memorydata/database/entity/AbstractContentTimeEntity;", "getEntityIndexHelper", "()Lcom/obric/memorydata/database/index/EntityIndexHelper;", "TAG", "", "buildKeywordIndexMap", "", "entity", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "getKeywordSchema", "Lcom/obric/search/api/schema/impl/FullTextSearchSchema;", "hasKeywordSchema", "", "getEntityIndexHelperInstance", "getNeedUpdateColumns", "", "oldRawEntity", "newRawEntity", "getAllColumns", "getPendingTaskColumns", "getKeywordColumnMap", "getContentTimeColumns", "assignmentAssociateField", "", "oldEntity", "newEntity", "changeColumns", "", "generateIndexPendingTask", "", "Lcom/obric/memorydata/database/entity/IndexPendingEntity;", "columnName", "executeIndexPendingTask", "updateField", "getValueByColumn", "", "isBuildMetaInfoFullContent", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class RawMemoryEntityIndex_Impl implements gk {
    private final String TAG;
    private final com.obric.memorydata.database.index.t<RawMemoryEntity, cq, com.obric.memorydata.database.entity.b> entityIndexHelper;

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

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonUtil$fromJsonByType$1", "Lcom/google/gson/reflect/TypeToken;", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends TypeToken<Map<String, ? extends ExtractTimeDescPair>> {
        public c() {
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonUtil$fromJsonByType$1", "Lcom/google/gson/reflect/TypeToken;", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d extends TypeToken<Map<String, ? extends ExtractTimeDescPair>> {
        public d() {
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonUtil$fromJsonByType$1", "Lcom/google/gson/reflect/TypeToken;", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e extends TypeToken<Map<String, ? extends ExtractTimeDescPair>> {
        public e() {
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonUtil$fromJsonByType$1", "Lcom/google/gson/reflect/TypeToken;", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class f extends TypeToken<Map<String, ? extends ExtractTimeDescPair>> {
        public f() {
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonUtil$fromJsonByType$1", "Lcom/google/gson/reflect/TypeToken;", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class g extends TypeToken<Map<String, ? extends ExtractTimeDescPair>> {
        public g() {
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonUtil$fromJsonByType$1", "Lcom/google/gson/reflect/TypeToken;", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class h extends TypeToken<Map<String, ? extends ExtractTimeDescPair>> {
        public h() {
        }
    }

    public RawMemoryEntityIndex_Impl() {
        com.obric.memorydata.database.index.t<RawMemoryEntity, cq, com.obric.memorydata.database.entity.b> r0 = new com.obric.memorydata.database.index.t();
        this.entityIndexHelper = r0;
        this.TAG = "RawMemoryEntityIndex_Impl";
        IAppEntityRawDbDao<? extends com.obric.memorydata.database.entity.d> r1 = getRawDao();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.memorydata.database.dao.IAppEntityRawDbDao<com.obric.memorydata.database.entity.RawMemoryEntity>");
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
    public void assignmentAssociateField(com.obric.memorydata.database.entity.d r2, com.obric.memorydata.database.entity.d r3, Set<String> r4) {
        Set r1 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "oldEntity");
        Intrinsics.checkNotNullParameter(r3, "newEntity");
        Intrinsics.checkNotNullParameter(r1, "changeColumns");
        if (ZeusTransformUtils.instanceOf(r2, RawMemoryEntity.class) == false) goto L10;
        if (ZeusTransformUtils.instanceOf(r3, RawMemoryEntity.class) == false) goto L8;
        return;
    L8:
        throw new IllegalStateException("Check failed.".toString());
    L10:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public Map<String, String> buildKeywordIndexMap(com.obric.memorydata.database.entity.d r4) {
        Intrinsics.checkNotNullParameter(r4, "entity");
        if (ZeusTransformUtils.instanceOf(r4, RawMemoryEntity.class) == false) goto L30;
        Map<String, String> r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        String r0 = ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r4, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKeyword1();
        if (r0 == null) goto L7;
        r3.put("common1", r0);
    L7:
        String r1 = ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r4, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKeyword2();
        if (r1 == null) goto L10;
        r3.put("common2", r1);
    L10:
        String r2 = ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r4, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKeyword3();
        if (r2 == null) goto L13;
        r3.put("common3", r2);
    L13:
        String r5 = ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r4, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKeyword4();
        if (r5 == null) goto L16;
        r3.put("common4", r5);
    L16:
        String r6 = ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r4, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKeyword5();
        if (r6 == null) goto L19;
        r3.put("common5", r6);
    L19:
        String r7 = ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r4, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKeyword6();
        if (r7 == null) goto L22;
        r3.put("common6", r7);
    L22:
        String r8 = ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r4, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKeywordAndSemantic1();
        if (r8 == null) goto L25;
        r3.put("common16", r8);
    L25:
        String r9 = ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r4, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKeywordAndSemantic2();
        if (r9 == null) goto L28;
        r3.put("common17", r9);
    L28:
        return r3;
    L30:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public boolean executeIndexPendingTask(com.obric.memorydata.database.entity.d r26, String r27) {
        Intrinsics.checkNotNullParameter(r26, "entity");
        Intrinsics.checkNotNullParameter(r27, "updateField");
        if (ZeusTransformUtils.instanceOf(r26, RawMemoryEntity.class) == false) goto L237;
        long r4 = System.currentTimeMillis();
        EntityIndexRecordInfo r2 = com.obric.memorydata.database.util.b.f9624a.a(r26);
        if (Intrinsics.areEqual(r27, "insert_keyword_task") == false) goto L7;
        boolean r6 = this.entityIndexHelper.b(((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r26, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getId(), buildKeywordIndexMap(r26));
    L9:
        if (Intrinsics.areEqual(r27, "insert_content_time_task") == false) goto L181;
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r26, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKey1(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L13;
    L16:
        boolean r10 = true;
    L17:
        String r13 = "";
        if (r10 == true) goto L52;
        com.obric.memorydata.database.index.t<RawMemoryEntity, cq, com.obric.memorydata.database.entity.b> r11 = this.entityIndexHelper;
        String r14 = ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r26, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKey1();
        if (r14 != null) goto L22;
        r14 = "";
    L22:
        String r7 = r11.a(r26, r14, "key1", (String) ZeusTransformUtils.preCheckCast(getContentTimeColumns().get("key1"), String.class, "com.obric.memorydata.plugin"));
        if (r7 != null) goto L26;
        boolean r8 = false;
    L53:
        CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r26, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKey2(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L56;
    L59:
        boolean r15 = true;
    L60:
        if (r15 == true) goto L94;
        com.obric.memorydata.database.index.t<RawMemoryEntity, cq, com.obric.memorydata.database.entity.b> r16 = this.entityIndexHelper;
        String r17 = ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r26, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKey2();
        if (r17 != null) goto L64;
        r17 = "";
    L64:
        boolean r18 = r8;
        String r19 = r16.a(r26, r17, "key2", (String) ZeusTransformUtils.preCheckCast(getContentTimeColumns().get("key2"), String.class, "com.obric.memorydata.plugin"));
        if (r19 != null) goto L68;
        boolean r20 = false;
    L96:
        CharSequence r21 = (CharSequence) ZeusTransformUtils.preCheckCast(((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r26, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKey3(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r21 != null) goto L99;
    L102:
        boolean r22 = true;
    L103:
        if (r22 == true) goto L137;
        com.obric.memorydata.database.index.t<RawMemoryEntity, cq, com.obric.memorydata.database.entity.b> r23 = this.entityIndexHelper;
        String r110 = ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r26, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKey3();
        if (r110 != null) goto L107;
        r110 = "";
    L107:
        boolean r111 = r20;
        String r24 = r23.a(r26, r110, "key3", (String) ZeusTransformUtils.preCheckCast(getContentTimeColumns().get("key3"), String.class, "com.obric.memorydata.plugin"));
        if (r24 != null) goto L111;
        boolean r25 = false;
    L139:
        CharSequence r28 = (CharSequence) ZeusTransformUtils.preCheckCast(((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r26, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getDetail(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r28 != null) goto L142;
    L145:
        boolean r29 = true;
    L146:
        if (r29 == true) goto L183;
        com.obric.memorydata.database.index.t<RawMemoryEntity, cq, com.obric.memorydata.database.entity.b> r30 = this.entityIndexHelper;
        String r112 = ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r26, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getDetail();
        if (r112 == null) goto L151;
        r13 = r112;
    L151:
        String r31 = r30.a(r26, r13, MemoryListActivity.JUMP_FROM_DETAIL, (String) ZeusTransformUtils.preCheckCast(getContentTimeColumns().get(MemoryListActivity.JUMP_FROM_DETAIL), String.class, "com.obric.memorydata.plugin"));
        if (r31 != null) goto L155;
        r25 = false;
        goto L183
    L155:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r31, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L157;
        boolean r113 = true;
    L158:
        if (r113 == false) goto L183;
        String r114 = ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r26, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getContentWithTime();
        CharSequence r115 = (CharSequence) ZeusTransformUtils.preCheckCast(r114, CharSequence.class, "com.obric.memorydata.plugin");
        if (r115 != null) goto L162;
    L165:
        boolean r116 = true;
    L166:
        if (r116 == false) goto L168;
    L167:
        ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r26, RawMemoryEntity.class, "com.obric.memorydata.plugin")).setContentWithTime(r31);
    L180:
        IAppEntityRawDbDao<? extends com.obric.memorydata.database.entity.d> r32 = getRawDao();
        Intrinsics.checkNotNull(r32, "null cannot be cast to non-null type com.obric.memorydata.database.dao.IAppEntityRawDbDao<com.obric.memorydata.database.entity.RawMemoryEntity>");
        r32.update(r26);
        goto L183
    L168:
        Map r117 = MapsKt.toMutableMap((Map) ZeusTransformUtils.preCheckCast(GsonUtil.INSTANCE.getGSON().fromJson(r114, new g().getType()), Map.class, "com.obric.memorydata.plugin"));
        if (r117.isEmpty() == true) goto L167;
        Map r33 = (Map) ZeusTransformUtils.preCheckCast(GsonUtil.INSTANCE.getGSON().fromJson(r31, new h().getType()), Map.class, "com.obric.memorydata.plugin");
        if (r33 == null) goto L179;
        Iterator r34 = r33.entrySet().iterator();
    L175:
        if (r34.hasNext() == false) goto L179;
        Map.Entry r118 = (Map.Entry) ZeusTransformUtils.preCheckCast(r34.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r119 = (String) ZeusTransformUtils.preCheckCast(r118.getKey(), String.class, "com.obric.memorydata.plugin");
        ExtractTimeDescPair r120 = (ExtractTimeDescPair) ZeusTransformUtils.preCheckCast(r118.getValue(), ExtractTimeDescPair.class, "com.obric.memorydata.plugin");
        if (r117.containsKey(r119) == true) goto L175;
        r117.put(r119, r120);
    L179:
        ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r26, RawMemoryEntity.class, "com.obric.memorydata.plugin")).setContentWithTime(com.obric.memorydata.utils.u.a(r117));
        goto L180
    L162:
        if (r115.length() == 0) goto L165;
        r116 = false;
        goto L166
    L157:
        r113 = false;
    L183:
        if (Intrinsics.areEqual(r27, "meta_full_content") == false) goto L185;
        boolean r35 = com.obric.memorydata.database.index.t.f9438a.a(r26);
    L187:
        if (Intrinsics.areEqual(r27, "fullContent") == false) goto L189;
        boolean r121 = this.entityIndexHelper.c(r26, "fullContent", ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r26, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getFullContent(), "DEFAULT");
    L191:
        if (Intrinsics.areEqual(r27, "semantic1") == false) goto L195;
        String r122 = ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r26, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getSemantic1();
        if (r122 == null) goto L195;
        boolean r123 = this.entityIndexHelper.b(r26, "semantic1", r122, "DEFAULT");
    L197:
        if (Intrinsics.areEqual(r27, "semantic2") == false) goto L201;
        String r124 = ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r26, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getSemantic2();
        if (r124 == null) goto L201;
        boolean r36 = this.entityIndexHelper.b(r26, "semantic2", r124, "DEFAULT");
    L203:
        if (Intrinsics.areEqual(r27, "keywordAndSemantic1") == false) goto L207;
        String r125 = ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r26, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKeywordAndSemantic1();
        if (r125 == null) goto L207;
        boolean r37 = this.entityIndexHelper.b(r26, "keywordAndSemantic1", r125, "DEFAULT");
    L209:
        if (Intrinsics.areEqual(r27, "keywordAndSemantic2") == false) goto L213;
        String r126 = ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r26, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKeywordAndSemantic2();
        if (r126 == null) goto L213;
        boolean r38 = this.entityIndexHelper.b(r26, "keywordAndSemantic2", r126, "DEFAULT");
    L215:
        if (Intrinsics.areEqual(r27, MemoryListActivity.JUMP_FROM_DETAIL) == false) goto L221;
        String r127 = ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r26, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getDetail();
        if (r127 == null) goto L219;
        boolean r0 = this.entityIndexHelper.b(r26, MemoryListActivity.JUMP_FROM_DETAIL, r127, "DEFAULT");
    L220:
        boolean r128 = r0;
    L222:
        if (r2 == null) goto L224;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", com.obric.memorydata.utils.u.a(r2), false, 4, null);
        com.obric.memorydata.database.util.b.f9624a.a("entityIndexTaskCost", String.valueOf(((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r26, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getType()), r27, System.currentTimeMillis() - r4);
    L224:
        if (r36 == false) goto L234;
        if (r121 == false) goto L234;
        if (r128 == false) goto L234;
        if (r123 == false) goto L234;
        if (r37 == false) goto L234;
        if (r38 == false) goto L234;
        if (r6 == false) goto L234;
        if (r25 == false) goto L234;
        if (r35 == false) goto L234;
        return true;
    L234:
        return false;
    L219:
        r0 = true;
        goto L220
    L221:
        r128 = true;
    L213:
        r38 = true;
    L207:
        r37 = true;
    L201:
        r36 = true;
    L195:
        r123 = true;
        goto L197
    L189:
        r121 = true;
        goto L191
    L185:
        r35 = true;
        goto L187
    L142:
        if (r28.length() == 0) goto L145;
        r29 = false;
        goto L146
    L111:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r24, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L113;
        boolean r39 = true;
    L114:
        if (r39 == false) goto L138;
        String r40 = ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r26, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getContentWithTime();
        CharSequence r129 = (CharSequence) ZeusTransformUtils.preCheckCast(r40, CharSequence.class, "com.obric.memorydata.plugin");
        if (r129 != null) goto L118;
    L121:
        boolean r130 = true;
    L122:
        if (r130 == false) goto L124;
    L123:
        ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r26, RawMemoryEntity.class, "com.obric.memorydata.plugin")).setContentWithTime(r24);
    L136:
        IAppEntityRawDbDao<? extends com.obric.memorydata.database.entity.d> r41 = getRawDao();
        Intrinsics.checkNotNull(r41, "null cannot be cast to non-null type com.obric.memorydata.database.dao.IAppEntityRawDbDao<com.obric.memorydata.database.entity.RawMemoryEntity>");
        r41.update(r26);
        goto L138
    L124:
        Map r42 = MapsKt.toMutableMap((Map) ZeusTransformUtils.preCheckCast(GsonUtil.INSTANCE.getGSON().fromJson(r40, new e().getType()), Map.class, "com.obric.memorydata.plugin"));
        if (r42.isEmpty() == true) goto L123;
        Map r43 = (Map) ZeusTransformUtils.preCheckCast(GsonUtil.INSTANCE.getGSON().fromJson(r24, new f().getType()), Map.class, "com.obric.memorydata.plugin");
        if (r43 == null) goto L135;
        Iterator r44 = r43.entrySet().iterator();
    L131:
        if (r44.hasNext() == false) goto L135;
        Map.Entry r131 = (Map.Entry) ZeusTransformUtils.preCheckCast(r44.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r132 = (String) ZeusTransformUtils.preCheckCast(r131.getKey(), String.class, "com.obric.memorydata.plugin");
        ExtractTimeDescPair r133 = (ExtractTimeDescPair) ZeusTransformUtils.preCheckCast(r131.getValue(), ExtractTimeDescPair.class, "com.obric.memorydata.plugin");
        if (r42.containsKey(r132) == true) goto L131;
        r42.put(r132, r133);
    L135:
        ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r26, RawMemoryEntity.class, "com.obric.memorydata.plugin")).setContentWithTime(com.obric.memorydata.utils.u.a(r42));
        goto L136
    L118:
        if (r129.length() == 0) goto L121;
        r130 = false;
    L138:
        r25 = r111;
        goto L139
    L113:
        r39 = false;
        goto L114
    L137:
        r111 = r20;
        goto L138
    L99:
        if (r21.length() == 0) goto L102;
        r22 = false;
        goto L103
    L68:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L70;
        boolean r45 = true;
    L71:
        if (r45 == false) goto L95;
        String r46 = ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r26, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getContentWithTime();
        CharSequence r134 = (CharSequence) ZeusTransformUtils.preCheckCast(r46, CharSequence.class, "com.obric.memorydata.plugin");
        if (r134 != null) goto L75;
    L78:
        boolean r135 = true;
    L79:
        if (r135 == false) goto L81;
    L80:
        ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r26, RawMemoryEntity.class, "com.obric.memorydata.plugin")).setContentWithTime(r19);
    L93:
        IAppEntityRawDbDao<? extends com.obric.memorydata.database.entity.d> r47 = getRawDao();
        Intrinsics.checkNotNull(r47, "null cannot be cast to non-null type com.obric.memorydata.database.dao.IAppEntityRawDbDao<com.obric.memorydata.database.entity.RawMemoryEntity>");
        r47.update(r26);
        goto L95
    L81:
        Map r48 = MapsKt.toMutableMap((Map) ZeusTransformUtils.preCheckCast(GsonUtil.INSTANCE.getGSON().fromJson(r46, new c().getType()), Map.class, "com.obric.memorydata.plugin"));
        if (r48.isEmpty() == true) goto L80;
        Map r49 = (Map) ZeusTransformUtils.preCheckCast(GsonUtil.INSTANCE.getGSON().fromJson(r19, new d().getType()), Map.class, "com.obric.memorydata.plugin");
        if (r49 == null) goto L92;
        Iterator r50 = r49.entrySet().iterator();
    L88:
        if (r50.hasNext() == false) goto L92;
        Map.Entry r136 = (Map.Entry) ZeusTransformUtils.preCheckCast(r50.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r137 = (String) ZeusTransformUtils.preCheckCast(r136.getKey(), String.class, "com.obric.memorydata.plugin");
        ExtractTimeDescPair r138 = (ExtractTimeDescPair) ZeusTransformUtils.preCheckCast(r136.getValue(), ExtractTimeDescPair.class, "com.obric.memorydata.plugin");
        if (r48.containsKey(r137) == true) goto L88;
        r48.put(r137, r138);
    L92:
        ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r26, RawMemoryEntity.class, "com.obric.memorydata.plugin")).setContentWithTime(com.obric.memorydata.utils.u.a(r48));
        goto L93
    L75:
        if (r134.length() == 0) goto L78;
        r135 = false;
    L95:
        r20 = r18;
        goto L96
    L70:
        r45 = false;
        goto L71
    L94:
        r18 = r8;
        goto L95
    L56:
        if (r12.length() == 0) goto L59;
        r15 = false;
        goto L60
    L26:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L28;
        boolean r51 = true;
    L29:
        if (r51 == false) goto L52;
        String r52 = ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r26, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getContentWithTime();
        CharSequence r139 = (CharSequence) ZeusTransformUtils.preCheckCast(r52, CharSequence.class, "com.obric.memorydata.plugin");
        if (r139 != null) goto L33;
    L36:
        boolean r140 = true;
    L37:
        if (r140 == false) goto L39;
    L38:
        ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r26, RawMemoryEntity.class, "com.obric.memorydata.plugin")).setContentWithTime(r7);
    L51:
        IAppEntityRawDbDao<? extends com.obric.memorydata.database.entity.d> r53 = getRawDao();
        Intrinsics.checkNotNull(r53, "null cannot be cast to non-null type com.obric.memorydata.database.dao.IAppEntityRawDbDao<com.obric.memorydata.database.entity.RawMemoryEntity>");
        r53.update(r26);
        goto L52
    L39:
        Map r54 = MapsKt.toMutableMap((Map) ZeusTransformUtils.preCheckCast(GsonUtil.INSTANCE.getGSON().fromJson(r52, new a().getType()), Map.class, "com.obric.memorydata.plugin"));
        if (r54.isEmpty() == true) goto L38;
        Map r55 = (Map) ZeusTransformUtils.preCheckCast(GsonUtil.INSTANCE.getGSON().fromJson(r7, new b().getType()), Map.class, "com.obric.memorydata.plugin");
        if (r55 == null) goto L50;
        Iterator r56 = r55.entrySet().iterator();
    L46:
        if (r56.hasNext() == false) goto L50;
        Map.Entry r141 = (Map.Entry) ZeusTransformUtils.preCheckCast(r56.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r142 = (String) ZeusTransformUtils.preCheckCast(r141.getKey(), String.class, "com.obric.memorydata.plugin");
        ExtractTimeDescPair r143 = (ExtractTimeDescPair) ZeusTransformUtils.preCheckCast(r141.getValue(), ExtractTimeDescPair.class, "com.obric.memorydata.plugin");
        if (r54.containsKey(r142) == true) goto L46;
        r54.put(r142, r143);
    L50:
        ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r26, RawMemoryEntity.class, "com.obric.memorydata.plugin")).setContentWithTime(com.obric.memorydata.utils.u.a(r54));
        goto L51
    L33:
        if (r139.length() == 0) goto L36;
        r140 = false;
        goto L37
    L28:
        r51 = false;
    L52:
        r8 = true;
        goto L53
    L13:
        if (r9.length() == 0) goto L16;
        r10 = false;
        goto L17
    L181:
        r25 = true;
        goto L183
    L7:
        r6 = true;
        goto L9
    L237:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public List<cd> generateIndexPendingTask(String r34, com.obric.memorydata.database.entity.d r35) {
        Intrinsics.checkNotNullParameter(r34, "columnName");
        Intrinsics.checkNotNullParameter(r35, "entity");
        if (ZeusTransformUtils.instanceOf(r35, RawMemoryEntity.class) == false) goto L89;
        switch(r34.hashCode()) {
            case -1937787423: goto L82;
            case -1536949565: goto L77;
            case -1335224239: goto L66;
            case -932820181: goto L55;
            case -932820180: goto L44;
            case -807735395: goto L33;
            case -807735394: goto L22;
            case -193103126: goto L13;
            case 1805045611: goto L8;
            default: goto L87;
        };
    L8:
        if (r34.equals("insert_content_time_task") == false) goto L87;
        return CollectionsKt.listOf(new cd(0, ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r35, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getId(), ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r35, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getType(), ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r35, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getTimestamp(), ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r35, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, "insert_content_time_task", "content_time", 0, 0, null, false, 0, 0, 32353, null));
    L13:
        if (r34.equals("fullContent") == false) goto L87;
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L20;
        return CollectionsKt.listOf(new cd(0, ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r35, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getId(), ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r35, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getType(), ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r35, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getTimestamp(), ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r35, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, r34, "full_content", 0, 0, null, false, 0, 0, 32353, null));
    L20:
        return CollectionsKt.emptyList();
    L22:
        if (r34.equals("keywordAndSemantic2") == false) goto L87;
        if (((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r35, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKeywordAndSemantic2() == null) goto L87;
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L31;
        return this.entityIndexHelper.a(r35, r34, String.valueOf(((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r35, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKeywordAndSemantic2()));
    L31:
        return CollectionsKt.emptyList();
    L33:
        if (r34.equals("keywordAndSemantic1") == false) goto L87;
        if (((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r35, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKeywordAndSemantic1() == null) goto L87;
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L42;
        return this.entityIndexHelper.a(r35, r34, String.valueOf(((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r35, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKeywordAndSemantic1()));
    L42:
        return CollectionsKt.emptyList();
    L44:
        if (r34.equals("semantic2") == false) goto L87;
        if (((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r35, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getSemantic2() == null) goto L87;
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L53;
        return this.entityIndexHelper.a(r35, r34, String.valueOf(((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r35, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getSemantic2()));
    L53:
        return CollectionsKt.emptyList();
    L55:
        if (r34.equals("semantic1") == false) goto L87;
        if (((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r35, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getSemantic1() == null) goto L87;
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L64;
        return this.entityIndexHelper.a(r35, r34, String.valueOf(((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r35, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getSemantic1()));
    L64:
        return CollectionsKt.emptyList();
    L66:
        if (r34.equals(MemoryListActivity.JUMP_FROM_DETAIL) == false) goto L87;
        if (((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r35, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getDetail() == null) goto L87;
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L75;
        return this.entityIndexHelper.a(r35, r34, String.valueOf(((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r35, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getDetail()));
    L75:
        return CollectionsKt.emptyList();
    L77:
        if (r34.equals("meta_full_content") == false) goto L87;
        return CollectionsKt.listOf(new cd(0, ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r35, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getId(), ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r35, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getType(), ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r35, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getTimestamp(), ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r35, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, "meta_full_content", "meta_full_content", 0, 0, null, false, 0, 0, 32353, null));
    L82:
        if (r34.equals("insert_keyword_task") == false) goto L87;
        return CollectionsKt.listOf(new cd(0, ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r35, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getId(), ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r35, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getType(), ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r35, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getTimestamp(), ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r35, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, "insert_keyword_task", "keyword", 0, 0, null, false, 0, 0, 32353, null));
    L87:
        return CollectionsKt.emptyList();
    L89:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public Set<String> getAllColumns() {
        Set<String> r2 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        r2.add("fullContent");
        r2.add("key1");
        r2.add("key2");
        r2.add("key3");
        r2.add("keyword1");
        r2.add("keyword2");
        r2.add("keyword3");
        r2.add("keyword4");
        r2.add("keyword5");
        r2.add("keyword6");
        r2.add("semantic1");
        r2.add("semantic2");
        r2.add("keywordAndSemantic1");
        r2.add("keywordAndSemantic2");
        r2.add(MemoryListActivity.JUMP_FROM_DETAIL);
        r2.add("meta_full_content");
        return r2;
    }

    @Override // com.obric.memorydata.database.index.e
    public Map<String, String> getContentTimeColumns() {
        Map<String, String> r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        r2.put("key1", "{\"chunkType\":\"DEFAULT\",\"targetColumn\":\"contentWithTime\"}");
        r2.put("key2", "{\"chunkType\":\"DEFAULT\",\"targetColumn\":\"contentWithTime\"}");
        r2.put("key3", "{\"chunkType\":\"DEFAULT\",\"targetColumn\":\"contentWithTime\"}");
        r2.put(MemoryListActivity.JUMP_FROM_DETAIL, "{\"chunkType\":\"DEFAULT\",\"targetColumn\":\"contentWithTime\"}");
        return r2;
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityContentTimeDao<? extends com.obric.memorydata.database.entity.b> getContentTimeDao() {
        return gk.a.e(this);
    }

    public final com.obric.memorydata.database.index.t<RawMemoryEntity, cq, com.obric.memorydata.database.entity.b> getEntityIndexHelper() {
        return this.entityIndexHelper;
    }

    @Override // com.obric.memorydata.database.index.e
    public com.obric.memorydata.database.index.t<RawMemoryEntity, cq, com.obric.memorydata.database.entity.b> getEntityIndexHelperInstance() {
        return this.entityIndexHelper;
    }

    @Override // com.obric.memorydata.database.index.e
    public IHistoryEntityDao<? extends com.obric.memorydata.database.entity.c> getHistoryEntityDao() {
        return gk.a.c(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityVectorCopilotDao<? extends i> getImageCopilotDao() {
        return gk.a.d(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public Map<String, String> getKeywordColumnMap() {
        Map<String, String> r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        r2.put("keyword1", "common1");
        r2.put("keyword2", "common2");
        r2.put("keyword3", "common3");
        r2.put("keyword4", "common4");
        r2.put("keyword5", "common5");
        r2.put("keyword6", "common6");
        r2.put("keywordAndSemantic1", "common16");
        r2.put("keywordAndSemantic2", "common17");
        return r2;
    }

    @Override // com.obric.memorydata.database.index.e
    public FullTextSearchSchema getKeywordSchema() {
        return this.entityIndexHelper.a();
    }

    @Override // com.obric.memorydata.database.index.e
    public Set<String> getNeedUpdateColumns(com.obric.memorydata.database.entity.d r9, com.obric.memorydata.database.entity.d r10) {
        Intrinsics.checkNotNullParameter(r9, "oldRawEntity");
        Intrinsics.checkNotNullParameter(r10, "newRawEntity");
        if (ZeusTransformUtils.instanceOf(r9, RawMemoryEntity.class) == false) goto L56;
        if (ZeusTransformUtils.instanceOf(r10, RawMemoryEntity.class) == false) goto L54;
        Set<String> r8 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        if (gd.f9146a.a(((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r9, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getFullContent(), ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r10, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getFullContent(), Type.FULL_CONTENT, null, false) == true) goto L10;
        r8.add("fullContent");
    L10:
        if (gd.f9146a.a(((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r9, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKey1(), ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r10, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKey1(), null, null, false) == true) goto L13;
        r8.add("key1");
    L13:
        if (gd.f9146a.a(((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r9, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKey2(), ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r10, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKey2(), null, null, false) == true) goto L16;
        r8.add("key2");
    L16:
        if (gd.f9146a.a(((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r9, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKey3(), ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r10, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKey3(), null, null, false) == true) goto L19;
        r8.add("key3");
    L19:
        if (gd.f9146a.a(((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r9, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKeyword1(), ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r10, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKeyword1(), null, null, false) == true) goto L22;
        r8.add("keyword1");
    L22:
        if (gd.f9146a.a(((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r9, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKeyword2(), ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r10, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKeyword2(), null, null, false) == true) goto L25;
        r8.add("keyword2");
    L25:
        if (gd.f9146a.a(((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r9, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKeyword3(), ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r10, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKeyword3(), null, null, false) == true) goto L28;
        r8.add("keyword3");
    L28:
        if (gd.f9146a.a(((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r9, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKeyword4(), ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r10, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKeyword4(), null, null, false) == true) goto L31;
        r8.add("keyword4");
    L31:
        if (gd.f9146a.a(((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r9, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKeyword5(), ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r10, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKeyword5(), null, null, false) == true) goto L34;
        r8.add("keyword5");
    L34:
        if (gd.f9146a.a(((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r9, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKeyword6(), ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r10, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKeyword6(), null, null, false) == true) goto L37;
        r8.add("keyword6");
    L37:
        if (gd.f9146a.a(((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r9, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getSemantic1(), ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r10, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getSemantic1(), Type.TEXT, null, false) == true) goto L40;
        r8.add("semantic1");
    L40:
        if (gd.f9146a.a(((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r9, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getSemantic2(), ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r10, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getSemantic2(), Type.TEXT, null, false) == true) goto L43;
        r8.add("semantic2");
    L43:
        if (gd.f9146a.a(((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r9, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKeywordAndSemantic1(), ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r10, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKeywordAndSemantic1(), Type.TEXT, null, false) == true) goto L46;
        r8.add("keywordAndSemantic1");
    L46:
        if (gd.f9146a.a(((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r9, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKeywordAndSemantic2(), ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r10, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKeywordAndSemantic2(), Type.TEXT, null, false) == true) goto L49;
        r8.add("keywordAndSemantic2");
    L49:
        if (gd.f9146a.a(((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r9, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getDetail(), ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r10, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getDetail(), Type.TEXT, null, false) == true) goto L51;
        r8.add(MemoryListActivity.JUMP_FROM_DETAIL);
    L51:
        r8.add("meta_full_content");
        return r8;
    L54:
        throw new IllegalStateException("Check failed.".toString());
    L56:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public Set<String> getPendingTaskColumns() {
        Set<String> r2 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        r2.add("insert_keyword_task");
        r2.add("insert_content_time_task");
        r2.add("meta_full_content");
        r2.add("fullContent");
        r2.add("semantic1");
        r2.add("semantic2");
        r2.add("keywordAndSemantic1");
        r2.add("keywordAndSemantic2");
        r2.add(MemoryListActivity.JUMP_FROM_DETAIL);
        return r2;
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityRawDbDao<? extends com.obric.memorydata.database.entity.d> getRawDao() {
        return gk.a.a(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityVectorCopilotDao<? extends i> getTextCopilotDao() {
        return gk.a.b(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public Object getValueByColumn(com.obric.memorydata.database.entity.d r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        Intrinsics.checkNotNullParameter(r3, "columnName");
        if (ZeusTransformUtils.instanceOf(r2, RawMemoryEntity.class) == false) goto L34;
        switch(r3.hashCode()) {
            case -1335224239: goto L28;
            case -932820181: goto L24;
            case -932820180: goto L20;
            case -807735395: goto L16;
            case -807735394: goto L12;
            case -193103126: goto L8;
            default: goto L31;
        };
    L31:
        return null;
    L8:
        if (r3.equals("fullContent") == false) goto L31;
        return ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r2, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getFullContent();
    L12:
        if (r3.equals("keywordAndSemantic2") == false) goto L31;
        return ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r2, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKeywordAndSemantic2();
    L16:
        if (r3.equals("keywordAndSemantic1") == false) goto L31;
        return ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r2, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getKeywordAndSemantic1();
    L20:
        if (r3.equals("semantic2") == false) goto L31;
        return ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r2, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getSemantic2();
    L24:
        if (r3.equals("semantic1") == false) goto L31;
        return ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r2, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getSemantic1();
    L28:
        if (r3.equals(MemoryListActivity.JUMP_FROM_DETAIL) == false) goto L31;
        return ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r2, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getDetail();
    L34:
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
