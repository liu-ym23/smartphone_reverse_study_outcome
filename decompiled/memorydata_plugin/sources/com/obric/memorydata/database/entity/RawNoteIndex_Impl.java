package com.obric.memorydata.database.entity;

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
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
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
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005H\u0016J\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u00172\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u0017H\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u0017H\u0016J\u0014\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000eH\u0016J\u0014\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000eH\u0016J&\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00102\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0#H\u0016J\u001e\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010'\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010(\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\fH\u0016J\u001a\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\fH\u0016J\b\u0010,\u001a\u00020\u0014H\u0016R#\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/obric/memorydata/database/entity/RawNoteIndex_Impl;", "Lcom/obric/memorydata/database/entity/RawNoteIndex;", "<init>", "()V", "entityIndexHelper", "Lcom/obric/memorydata/database/index/EntityIndexHelper;", "Lcom/obric/memorydata/database/entity/RawNoteEntity;", "Lcom/obric/memorydata/database/entity/NoteEntityTextVectorCopilotEntity;", "Lcom/obric/memorydata/database/entity/AbstractContentTimeEntity;", "getEntityIndexHelper", "()Lcom/obric/memorydata/database/index/EntityIndexHelper;", "TAG", "", "buildKeywordIndexMap", "", "entity", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "getKeywordSchema", "Lcom/obric/search/api/schema/impl/FullTextSearchSchema;", "hasKeywordSchema", "", "getEntityIndexHelperInstance", "getNeedUpdateColumns", "", "oldRawEntity", "newRawEntity", "getAllColumns", "getPendingTaskColumns", "getKeywordColumnMap", "getContentTimeColumns", "assignmentAssociateField", "", "oldEntity", "newEntity", "changeColumns", "", "generateIndexPendingTask", "", "Lcom/obric/memorydata/database/entity/IndexPendingEntity;", "columnName", "executeIndexPendingTask", "updateField", "getValueByColumn", "", "isBuildMetaInfoFullContent", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class RawNoteIndex_Impl implements gv {
    private final String TAG;
    private final com.obric.memorydata.database.index.t<gu, dv, com.obric.memorydata.database.entity.b> entityIndexHelper;

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

    public RawNoteIndex_Impl() {
        com.obric.memorydata.database.index.t<gu, dv, com.obric.memorydata.database.entity.b> r0 = new com.obric.memorydata.database.index.t();
        this.entityIndexHelper = r0;
        this.TAG = "RawNoteIndex_Impl";
        IAppEntityRawDbDao<? extends com.obric.memorydata.database.entity.d> r1 = getRawDao();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.memorydata.database.dao.IAppEntityRawDbDao<com.obric.memorydata.database.entity.RawNoteEntity>");
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
        if (ZeusTransformUtils.instanceOf(r2, gu.class) == false) goto L10;
        if (ZeusTransformUtils.instanceOf(r3, gu.class) == false) goto L8;
        return;
    L8:
        throw new IllegalStateException("Check failed.".toString());
    L10:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public Map<String, String> buildKeywordIndexMap(com.obric.memorydata.database.entity.d r4) {
        Intrinsics.checkNotNullParameter(r4, "entity");
        if (ZeusTransformUtils.instanceOf(r4, gu.class) == false) goto L12;
        Map<String, String> r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        r3.put("common1", ((gu) ZeusTransformUtils.preCheckCast(r4, gu.class, "com.obric.memorydata.plugin")).a());
        r3.put("common2", ((gu) ZeusTransformUtils.preCheckCast(r4, gu.class, "com.obric.memorydata.plugin")).b());
        String r0 = ((gu) ZeusTransformUtils.preCheckCast(r4, gu.class, "com.obric.memorydata.plugin")).d();
        if (r0 == null) goto L7;
        r3.put("common3", r0);
    L7:
        String r5 = ((gu) ZeusTransformUtils.preCheckCast(r4, gu.class, "com.obric.memorydata.plugin")).e();
        if (r5 == null) goto L10;
        r3.put("common4", r5);
    L10:
        return r3;
    L12:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public boolean executeIndexPendingTask(com.obric.memorydata.database.entity.d r23, String r24) {
        Intrinsics.checkNotNullParameter(r23, "entity");
        Intrinsics.checkNotNullParameter(r24, "updateField");
        if (ZeusTransformUtils.instanceOf(r23, gu.class) == false) goto L128;
        long r4 = System.currentTimeMillis();
        EntityIndexRecordInfo r2 = com.obric.memorydata.database.util.b.f9624a.a(r23);
        if (Intrinsics.areEqual(r24, "insert_keyword_task") == false) goto L7;
        boolean r6 = this.entityIndexHelper.b(((gu) ZeusTransformUtils.preCheckCast(r23, gu.class, "com.obric.memorydata.plugin")).getId(), buildKeywordIndexMap(r23));
    L9:
        if (Intrinsics.areEqual(r24, "insert_content_time_task") == false) goto L99;
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(((gu) ZeusTransformUtils.preCheckCast(r23, gu.class, "com.obric.memorydata.plugin")).a(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L13;
    L16:
        boolean r10 = true;
    L17:
        String r14 = "";
        if (r10 == true) goto L53;
        com.obric.memorydata.database.index.t<gu, dv, com.obric.memorydata.database.entity.b> r11 = this.entityIndexHelper;
        String r15 = ((gu) ZeusTransformUtils.preCheckCast(r23, gu.class, "com.obric.memorydata.plugin")).a();
        if (r15 != null) goto L22;
        r15 = "";
    L22:
        String r7 = r11.a(r23, r15, "title", (String) ZeusTransformUtils.preCheckCast(getContentTimeColumns().get("title"), String.class, "com.obric.memorydata.plugin"));
        if (r7 != null) goto L26;
        boolean r8 = false;
    L54:
        CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(((gu) ZeusTransformUtils.preCheckCast(r23, gu.class, "com.obric.memorydata.plugin")).b(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L57;
    L60:
        boolean r13 = true;
    L61:
        if (r13 == true) goto L97;
        com.obric.memorydata.database.index.t<gu, dv, com.obric.memorydata.database.entity.b> r16 = this.entityIndexHelper;
        String r17 = ((gu) ZeusTransformUtils.preCheckCast(r23, gu.class, "com.obric.memorydata.plugin")).b();
        if (r17 == null) goto L66;
        r14 = r17;
    L66:
        String r18 = r16.a(r23, r14, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, (String) ZeusTransformUtils.preCheckCast(getContentTimeColumns().get(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT), String.class, "com.obric.memorydata.plugin"));
        if (r18 != null) goto L70;
        boolean r19 = false;
    L101:
        if (Intrinsics.areEqual(r24, "meta_full_content") == false) goto L103;
        boolean r20 = com.obric.memorydata.database.index.t.f9438a.a(r23);
    L105:
        if (Intrinsics.areEqual(r24, "title") == false) goto L107;
        boolean r110 = this.entityIndexHelper.b(r23, "title", ((gu) ZeusTransformUtils.preCheckCast(r23, gu.class, "com.obric.memorydata.plugin")).a(), "DEFAULT");
    L109:
        if (Intrinsics.areEqual(r24, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT) == false) goto L111;
        boolean r111 = this.entityIndexHelper.b(r23, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, ((gu) ZeusTransformUtils.preCheckCast(r23, gu.class, "com.obric.memorydata.plugin")).b(), "DEFAULT");
    L113:
        if (Intrinsics.areEqual(r24, "fullContent") == false) goto L115;
        boolean r112 = this.entityIndexHelper.c(r23, "fullContent", ((gu) ZeusTransformUtils.preCheckCast(r23, gu.class, "com.obric.memorydata.plugin")).h(), "DEFAULT");
    L116:
        if (r2 == null) goto L118;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", com.obric.memorydata.utils.u.a(r2), false, 4, null);
        com.obric.memorydata.database.util.b.f9624a.a("entityIndexTaskCost", String.valueOf(((gu) ZeusTransformUtils.preCheckCast(r23, gu.class, "com.obric.memorydata.plugin")).getType()), r24, System.currentTimeMillis() - r4);
    L118:
        if (r110 == false) goto L125;
        if (r112 == false) goto L125;
        if (r111 == false) goto L125;
        if (r6 == false) goto L125;
        if (r19 == false) goto L125;
        if (r20 == false) goto L125;
        return true;
    L125:
        return false;
    L115:
        r112 = true;
        goto L116
    L111:
        r111 = true;
        goto L113
    L107:
        r110 = true;
        goto L109
    L103:
        r20 = true;
        goto L105
    L70:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L72;
        boolean r113 = true;
    L73:
        if (r113 == false) goto L97;
        String r114 = ((gu) ZeusTransformUtils.preCheckCast(r23, gu.class, "com.obric.memorydata.plugin")).i();
        CharSequence r115 = (CharSequence) ZeusTransformUtils.preCheckCast(r114, CharSequence.class, "com.obric.memorydata.plugin");
        if (r115 != null) goto L77;
    L80:
        boolean r116 = true;
    L81:
        if (r116 == false) goto L83;
    L82:
        ((gu) ZeusTransformUtils.preCheckCast(r23, gu.class, "com.obric.memorydata.plugin")).a(r18);
        boolean r117 = r8;
    L96:
        IAppEntityRawDbDao<? extends com.obric.memorydata.database.entity.d> r21 = getRawDao();
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type com.obric.memorydata.database.dao.IAppEntityRawDbDao<com.obric.memorydata.database.entity.RawNoteEntity>");
        r21.update(r23);
    L98:
        r19 = r117;
        goto L101
    L83:
        Map r118 = MapsKt.toMutableMap((Map) ZeusTransformUtils.preCheckCast(GsonUtil.INSTANCE.getGSON().fromJson(r114, new c().getType()), Map.class, "com.obric.memorydata.plugin"));
        if (r118.isEmpty() == true) goto L82;
        Map r22 = (Map) ZeusTransformUtils.preCheckCast(GsonUtil.INSTANCE.getGSON().fromJson(r18, new d().getType()), Map.class, "com.obric.memorydata.plugin");
        if (r22 == null) goto L95;
        Iterator r25 = r22.entrySet().iterator();
    L90:
        if (r25.hasNext() == false) goto L95;
        Map.Entry r119 = (Map.Entry) ZeusTransformUtils.preCheckCast(r25.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        boolean r120 = r8;
        String r26 = (String) ZeusTransformUtils.preCheckCast(r119.getKey(), String.class, "com.obric.memorydata.plugin");
        ExtractTimeDescPair r121 = (ExtractTimeDescPair) ZeusTransformUtils.preCheckCast(r119.getValue(), ExtractTimeDescPair.class, "com.obric.memorydata.plugin");
        if (r118.containsKey(r26) == true) goto L94;
        r118.put(r26, r121);
    L94:
        r8 = r120;
    L95:
        r117 = r8;
        ((gu) ZeusTransformUtils.preCheckCast(r23, gu.class, "com.obric.memorydata.plugin")).a(com.obric.memorydata.utils.u.a(r118));
        goto L96
    L77:
        if (r115.length() == 0) goto L80;
        r116 = false;
        goto L81
    L72:
        r113 = false;
    L97:
        r117 = r8;
        goto L98
    L57:
        if (r12.length() == 0) goto L60;
        r13 = false;
        goto L61
    L26:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L28;
        boolean r27 = true;
    L29:
        if (r27 == false) goto L53;
        String r28 = ((gu) ZeusTransformUtils.preCheckCast(r23, gu.class, "com.obric.memorydata.plugin")).i();
        CharSequence r122 = (CharSequence) ZeusTransformUtils.preCheckCast(r28, CharSequence.class, "com.obric.memorydata.plugin");
        if (r122 != null) goto L33;
    L36:
        boolean r123 = true;
    L37:
        if (r123 == false) goto L39;
    L38:
        ((gu) ZeusTransformUtils.preCheckCast(r23, gu.class, "com.obric.memorydata.plugin")).a(r7);
    L52:
        IAppEntityRawDbDao<? extends com.obric.memorydata.database.entity.d> r29 = getRawDao();
        Intrinsics.checkNotNull(r29, "null cannot be cast to non-null type com.obric.memorydata.database.dao.IAppEntityRawDbDao<com.obric.memorydata.database.entity.RawNoteEntity>");
        r29.update(r23);
        goto L53
    L39:
        Map r30 = MapsKt.toMutableMap((Map) ZeusTransformUtils.preCheckCast(GsonUtil.INSTANCE.getGSON().fromJson(r28, new a().getType()), Map.class, "com.obric.memorydata.plugin"));
        if (r30.isEmpty() == true) goto L38;
        Map r31 = (Map) ZeusTransformUtils.preCheckCast(GsonUtil.INSTANCE.getGSON().fromJson(r7, new b().getType()), Map.class, "com.obric.memorydata.plugin");
        if (r31 == null) goto L51;
        Iterator r32 = r31.entrySet().iterator();
    L46:
        if (r32.hasNext() == false) goto L51;
        Map.Entry r124 = (Map.Entry) ZeusTransformUtils.preCheckCast(r32.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Iterator r125 = r32;
        String r33 = (String) ZeusTransformUtils.preCheckCast(r124.getKey(), String.class, "com.obric.memorydata.plugin");
        ExtractTimeDescPair r126 = (ExtractTimeDescPair) ZeusTransformUtils.preCheckCast(r124.getValue(), ExtractTimeDescPair.class, "com.obric.memorydata.plugin");
        if (r30.containsKey(r33) == true) goto L50;
        r30.put(r33, r126);
    L50:
        r32 = r125;
    L51:
        ((gu) ZeusTransformUtils.preCheckCast(r23, gu.class, "com.obric.memorydata.plugin")).a(com.obric.memorydata.utils.u.a(r30));
        goto L52
    L33:
        if (r122.length() == 0) goto L36;
        r123 = false;
        goto L37
    L28:
        r27 = false;
    L53:
        r8 = true;
        goto L54
    L13:
        if (r9.length() == 0) goto L16;
        r10 = false;
        goto L17
    L99:
        r19 = true;
        goto L101
    L7:
        r6 = true;
        goto L9
    L128:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public List<cd> generateIndexPendingTask(String r34, com.obric.memorydata.database.entity.d r35) {
        Intrinsics.checkNotNullParameter(r34, "columnName");
        Intrinsics.checkNotNullParameter(r35, "entity");
        if (ZeusTransformUtils.instanceOf(r35, gu.class) == false) goto L52;
        switch(r34.hashCode()) {
            case -1937787423: goto L45;
            case -1536949565: goto L40;
            case -193103126: goto L31;
            case 3556653: goto L22;
            case 110371416: goto L13;
            case 1805045611: goto L8;
            default: goto L50;
        };
    L8:
        if (r34.equals("insert_content_time_task") == false) goto L50;
        return CollectionsKt.listOf(new cd(0, ((gu) ZeusTransformUtils.preCheckCast(r35, gu.class, "com.obric.memorydata.plugin")).getId(), ((gu) ZeusTransformUtils.preCheckCast(r35, gu.class, "com.obric.memorydata.plugin")).getType(), ((gu) ZeusTransformUtils.preCheckCast(r35, gu.class, "com.obric.memorydata.plugin")).getTimestamp(), ((gu) ZeusTransformUtils.preCheckCast(r35, gu.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, "insert_content_time_task", "content_time", 0, 0, null, false, 0, 0, 32353, null));
    L13:
        if (r34.equals("title") == false) goto L50;
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L20;
        return this.entityIndexHelper.a(r35, r34, ((gu) ZeusTransformUtils.preCheckCast(r35, gu.class, "com.obric.memorydata.plugin")).a().toString());
    L20:
        return CollectionsKt.emptyList();
    L22:
        if (r34.equals(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT) == false) goto L50;
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L29;
        return this.entityIndexHelper.a(r35, r34, ((gu) ZeusTransformUtils.preCheckCast(r35, gu.class, "com.obric.memorydata.plugin")).b().toString());
    L29:
        return CollectionsKt.emptyList();
    L31:
        if (r34.equals("fullContent") == false) goto L50;
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L38;
        return CollectionsKt.listOf(new cd(0, ((gu) ZeusTransformUtils.preCheckCast(r35, gu.class, "com.obric.memorydata.plugin")).getId(), ((gu) ZeusTransformUtils.preCheckCast(r35, gu.class, "com.obric.memorydata.plugin")).getType(), ((gu) ZeusTransformUtils.preCheckCast(r35, gu.class, "com.obric.memorydata.plugin")).getTimestamp(), ((gu) ZeusTransformUtils.preCheckCast(r35, gu.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, r34, "full_content", 0, 0, null, false, 0, 0, 32353, null));
    L38:
        return CollectionsKt.emptyList();
    L40:
        if (r34.equals("meta_full_content") == false) goto L50;
        return CollectionsKt.listOf(new cd(0, ((gu) ZeusTransformUtils.preCheckCast(r35, gu.class, "com.obric.memorydata.plugin")).getId(), ((gu) ZeusTransformUtils.preCheckCast(r35, gu.class, "com.obric.memorydata.plugin")).getType(), ((gu) ZeusTransformUtils.preCheckCast(r35, gu.class, "com.obric.memorydata.plugin")).getTimestamp(), ((gu) ZeusTransformUtils.preCheckCast(r35, gu.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, "meta_full_content", "meta_full_content", 0, 0, null, false, 0, 0, 32353, null));
    L45:
        if (r34.equals("insert_keyword_task") == false) goto L50;
        return CollectionsKt.listOf(new cd(0, ((gu) ZeusTransformUtils.preCheckCast(r35, gu.class, "com.obric.memorydata.plugin")).getId(), ((gu) ZeusTransformUtils.preCheckCast(r35, gu.class, "com.obric.memorydata.plugin")).getType(), ((gu) ZeusTransformUtils.preCheckCast(r35, gu.class, "com.obric.memorydata.plugin")).getTimestamp(), ((gu) ZeusTransformUtils.preCheckCast(r35, gu.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, "insert_keyword_task", "keyword", 0, 0, null, false, 0, 0, 32353, null));
    L50:
        return CollectionsKt.emptyList();
    L52:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public Set<String> getAllColumns() {
        Set<String> r2 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        r2.add("title");
        r2.add(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        r2.add("formatMode");
        r2.add("noteFolder");
        r2.add("fullContent");
        r2.add("meta_full_content");
        return r2;
    }

    @Override // com.obric.memorydata.database.index.e
    public Map<String, String> getContentTimeColumns() {
        Map<String, String> r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        r2.put("title", "{\"chunkType\":\"DEFAULT\",\"targetColumn\":\"contentWithTime\"}");
        r2.put(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "{\"chunkType\":\"DEFAULT\",\"targetColumn\":\"contentWithTime\"}");
        return r2;
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityContentTimeDao<? extends com.obric.memorydata.database.entity.b> getContentTimeDao() {
        return gv.a.d(this);
    }

    public final com.obric.memorydata.database.index.t<gu, dv, com.obric.memorydata.database.entity.b> getEntityIndexHelper() {
        return this.entityIndexHelper;
    }

    @Override // com.obric.memorydata.database.index.e
    public com.obric.memorydata.database.index.t<gu, dv, com.obric.memorydata.database.entity.b> getEntityIndexHelperInstance() {
        return this.entityIndexHelper;
    }

    @Override // com.obric.memorydata.database.index.e
    public IHistoryEntityDao<? extends com.obric.memorydata.database.entity.c> getHistoryEntityDao() {
        return gv.a.e(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityVectorCopilotDao<? extends i> getImageCopilotDao() {
        return gv.a.c(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public Map<String, String> getKeywordColumnMap() {
        Map<String, String> r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        r2.put("title", "common1");
        r2.put(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "common2");
        r2.put("formatMode", "common3");
        r2.put("noteFolder", "common4");
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
        if (ZeusTransformUtils.instanceOf(r9, gu.class) == false) goto L26;
        if (ZeusTransformUtils.instanceOf(r10, gu.class) == false) goto L24;
        Set<String> r8 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        if (gd.f9146a.a(((gu) ZeusTransformUtils.preCheckCast(r9, gu.class, "com.obric.memorydata.plugin")).a(), ((gu) ZeusTransformUtils.preCheckCast(r10, gu.class, "com.obric.memorydata.plugin")).a(), Type.TEXT, null, false) == true) goto L10;
        r8.add("title");
    L10:
        if (gd.f9146a.a(((gu) ZeusTransformUtils.preCheckCast(r9, gu.class, "com.obric.memorydata.plugin")).b(), ((gu) ZeusTransformUtils.preCheckCast(r10, gu.class, "com.obric.memorydata.plugin")).b(), Type.TEXT, null, false) == true) goto L13;
        r8.add(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
    L13:
        if (gd.f9146a.a(((gu) ZeusTransformUtils.preCheckCast(r9, gu.class, "com.obric.memorydata.plugin")).d(), ((gu) ZeusTransformUtils.preCheckCast(r10, gu.class, "com.obric.memorydata.plugin")).d(), null, null, false) == true) goto L16;
        r8.add("formatMode");
    L16:
        if (gd.f9146a.a(((gu) ZeusTransformUtils.preCheckCast(r9, gu.class, "com.obric.memorydata.plugin")).e(), ((gu) ZeusTransformUtils.preCheckCast(r10, gu.class, "com.obric.memorydata.plugin")).e(), null, null, false) == true) goto L19;
        r8.add("noteFolder");
    L19:
        if (gd.f9146a.a(((gu) ZeusTransformUtils.preCheckCast(r9, gu.class, "com.obric.memorydata.plugin")).h(), ((gu) ZeusTransformUtils.preCheckCast(r10, gu.class, "com.obric.memorydata.plugin")).h(), Type.FULL_CONTENT, null, false) == true) goto L21;
        r8.add("fullContent");
    L21:
        r8.add("meta_full_content");
        return r8;
    L24:
        throw new IllegalStateException("Check failed.".toString());
    L26:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public Set<String> getPendingTaskColumns() {
        Set<String> r2 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        r2.add("insert_keyword_task");
        r2.add("insert_content_time_task");
        r2.add("meta_full_content");
        r2.add("title");
        r2.add(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        r2.add("fullContent");
        return r2;
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityRawDbDao<? extends com.obric.memorydata.database.entity.d> getRawDao() {
        return gv.a.a(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityVectorCopilotDao<? extends i> getTextCopilotDao() {
        return gv.a.b(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public Object getValueByColumn(com.obric.memorydata.database.entity.d r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "entity");
        Intrinsics.checkNotNullParameter(r4, "columnName");
        if (ZeusTransformUtils.instanceOf(r3, gu.class) == false) goto L24;
        int r2 = r4.hashCode();
        if (r2 == (-193103126)) goto L19;
        if (r2 == 3556653) goto L15;
        if (r2 == 110371416) goto L12;
    L20:
        return null;
    L12:
        if (r4.equals("title") == false) goto L20;
        return ((gu) ZeusTransformUtils.preCheckCast(r3, gu.class, "com.obric.memorydata.plugin")).a();
    L15:
        if (r4.equals(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT) == false) goto L20;
        return ((gu) ZeusTransformUtils.preCheckCast(r3, gu.class, "com.obric.memorydata.plugin")).b();
    L19:
        if (r4.equals("fullContent") == false) goto L20;
        return ((gu) ZeusTransformUtils.preCheckCast(r3, gu.class, "com.obric.memorydata.plugin")).h();
    L24:
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
