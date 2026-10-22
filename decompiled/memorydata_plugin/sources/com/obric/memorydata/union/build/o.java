package com.obric.memorydata.union.build;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.google.gson.reflect.TypeToken;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.database.dao.SemanticMemoryDao;
import com.obric.memorydata.database.entity.ab;
import com.obric.memorydata.database.entity.fa;
import com.obric.memorydata.database.entity.ip;
import com.obric.memorydata.database.entity.iq;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.api.MemoryBuildApi;
import com.obric.memorydata.memory.api.MemoryBuildService;
import com.obric.memorydata.memory.api.MemoryIslandService;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.EntityManager;
import com.obric.memorydata.sdk.memory.State;
import com.obric.memorydata.utils.GsonUtil;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J/\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\u0004\u0018\u00010\u0003*\u00020\fH\u0002J\f\u0010\u0017\u001a\u00020\u0012*\u00020\fH\u0002J&\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001cH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/union/build/UnionSemanticHandlerV2;", "", "data", "", "<init>", "(Ljava/lang/String;)V", "handle", "processItemWithResult", "Lcom/obric/memorydata/union/build/SemanticBuildResultItemV2;", "index", "", "item", "Lcom/obric/memorydata/union/build/UnionSemanticDataV2;", "insertProactiveSemanticRelevantData", "", "entity", "Lcom/obric/memorydata/database/entity/UnionSemanticMemoryEntity;", "isNewEntity", "", "previousConfidenceScore", "", "(Lcom/obric/memorydata/union/build/UnionSemanticDataV2;Lcom/obric/memorydata/database/entity/UnionSemanticMemoryEntity;ZLjava/lang/Float;)V", "sourceScreenshotJson", "hasInlineRelevantSourceInfo", "extractRuleIdList", "", "", "relevantData", "", "Companion", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13103a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f13104b;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH\u0002J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/union/build/UnionSemanticHandlerV2$Companion;", "", "<init>", "()V", "TAG", "", "mergeJsonArray", "existingJson", "incoming", "", "resolvedSourceRawRefIds", "item", "Lcom/obric/memorydata/union/build/UnionSemanticDataV2;", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: com.obric.memorydata.union.build.o$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonUtil$fromJsonArray$2$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0717a extends TypeToken<List<? extends String>> {
            public C0717a() {
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public static final /* synthetic */ String a(a r2, String r3, List r4) {
            return r2.a(r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"));
        }

        private final String a(String r4, List<String> r5) {
            List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            GsonUtil r1 = GsonUtil.INSTANCE;
            List r2 = null;
            if (r4 != null) goto L5;
        L13:
            if (r2 != null) goto L15;
            r2 = CollectionsKt.emptyList();
        L15:
            a(r6, r2);
            a(r6, r3);
            return GsonUtil.INSTANCE.toJson(r6);
        L5:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L7;
            boolean r7 = true;
        L8:
            if (r7 == true) goto L11;
            r4 = null;
        L11:
            if (r4 == null) goto L13;
            r2 = (List) ZeusTransformUtils.preCheckCast(GsonUtil.INSTANCE.getGSON().fromJson(r4, new C0717a().getType()), List.class, "com.obric.memorydata.plugin");
            goto L13
        L7:
            r7 = false;
            goto L8
        }

        private final List<String> a(UnionSemanticDataV2 r5) {
            List<String> r4 = r5.getSourceRawRefIds();
            if (r4 != null) goto L5;
            r4 = CollectionsKt.emptyList();
        L5:
            Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
            Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r8 = r6.iterator();
        L7:
            if (r8.hasNext() == false) goto L12;
            Object r1 = r8.next();
            if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L7;
            r7.add(r1);
            goto L7
        L12:
            return (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");
        }

        public static final /* synthetic */ List a(a r0, UnionSemanticDataV2 r1) {
            return r0.a(r1);
        }

        private static final void a(List<String> r3, List<String> r4) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            if (r6 != null) goto L5;
            r6 = CollectionsKt.emptyList();
        L5:
            Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L7:
            if (r7.hasNext() == false) goto L16;
            String r0 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).toString();
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L11;
            boolean r2 = true;
        L12:
            if (r2 == false) goto L7;
            if (r5.contains(r0) == true) goto L7;
            r5.add(r0);
            goto L7
        L11:
            r2 = false;
            goto L12
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonUtil$fromJsonArray$2$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends TypeToken<List<? extends UnionSemanticDataV2>> {
        public b() {
        }
    }

    static {
        f13103a = new a(null);
    }

    public o(String r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.f13104b = r2;
    }

    private final SemanticBuildResultItemV2 a(int r60, UnionSemanticDataV2 r61) {
        if (r61 == null) goto L5;
        RunLog.INSTANCE.debug("UnionSemanticHandlerV2", "process item, index=" + r60);
        if (com.obric.memorydata.utils.b.a(r61.getSemanticType()) == false) goto L9;
    L245:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UnionSemanticHandlerV2", "item data is invalid, index=" + r60, null, 4, null);
        return new SemanticBuildResultItemV2("400", "data invalid", null, null, 12, null);
    L9:
        if (com.obric.memorydata.utils.b.a(r61.getTagPath()) == true) goto L245;
        if (com.obric.memorydata.utils.b.a(r61.getKeyPhrase()) == true) goto L245;
        if (com.obric.memorydata.utils.b.a(r61.getDescription()) == true) goto L245;
        long r6 = System.currentTimeMillis();
        SemanticMemoryDao r8 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao();
        List<String> r3 = r61.getEntityIdList();
        if (r3 != null) goto L18;
        r3 = CollectionsKt.emptyList();
    L18:
        ip r4 = SemanticMemoryDao.DefaultImpls.queryDuplicateCandidate$default(r8, r3, r61.getKeyPhrase(), false, 4, null);
        if (r4 == null) goto L21;
        RunLog.INSTANCE.debug("UnionSemanticHandlerV2", "duplicate candidate found, index=" + r60);
    L21:
        RunLog r9 = RunLog.INSTANCE;
        StringBuilder r10 = new StringBuilder().append("semantic time payload, action=").append(r61.getAction()).append(", hasOldEntity=");
        if (r4 == null) goto L24;
        boolean r12 = true;
    L25:
        r9.debug("UnionSemanticHandlerV2", r10.append(r12).toString());
        a r11 = f13103a;
        if (r4 == null) goto L28;
        String r13 = r4.p();
    L29:
        String r14 = a.a(r11, r13, r61.getSceneIds());
        if (r4 == null) goto L32;
        String r15 = r4.n();
    L33:
        String r16 = a.a(r11, r15, r61.getImportantRawRefIds());
        if (r4 == null) goto L36;
        String r17 = r4.o();
    L37:
        String r18 = a.a(r11, r17, a.a(r11, r61));
        if (r4 == null) goto L40;
        String r19 = r4.q();
    L41:
        String r20 = a.a(r11, r19, r61.getSourcePackageName());
        if (r4 == null) goto L44;
        String r110 = r4.u();
    L45:
        String r111 = a.a(r11, r110, r61.getEvidenceIds());
        if (r4 == null) goto L48;
        String r112 = r4.v();
    L49:
        String r113 = a.a(r11, r112, r61.getConflictEntityIds());
        long r114 = r6;
        Integer r7 = (Integer) ZeusTransformUtils.preCheckCast(e.f13072a.a().get(r61.getBusinessType()), Integer.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L52;
        int r21 = r7.intValue();
    L53:
        f r22 = f.f13087a;
        String r115 = r61.getBusinessType();
        if (r4 == null) goto L56;
        Integer r0 = Integer.valueOf(r4.i());
    L57:
        f.a r1 = r22.b(r115, r0, r21);
        int r23 = r1.a();
        if (r4 == null) goto L60;
        Integer r116 = Integer.valueOf(r4.i());
    L61:
        int r2 = i.a(r116, Integer.valueOf(r21), r1.b());
        if (r4 == null) goto L65;
        String r24 = r4.getEntityId();
        if (r24 == null) goto L65;
    L66:
        IRunLog r117 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r25 = new StringBuilder().append("[LOGID_TRACE][ANDROID_SEMANTIC_PROVENANCE] action=").append(r61.getAction()).append(" businessType=").append(r61.getBusinessType()).append(" logId=").append(r61.getLogId()).append(" sceneCount=");
        List<String> r118 = r61.getSceneIds();
        if (r118 == null) goto L69;
        int r119 = r118.size();
    L70:
        StringBuilder r26 = r25.append(r119).append(" importantCount=");
        List<String> r120 = r61.getImportantRawRefIds();
        if (r120 == null) goto L73;
        int r121 = r120.size();
    L74:
        StringBuilder r27 = r26.append(r121).append(" sourceCount=").append(a.a(r11, r61).size()).append(" sourcePackageCount=");
        List<String> r28 = r61.getSourcePackageName();
        if (r28 == null) goto L77;
        int r29 = r28.size();
    L78:
        IRunLog.a.a(r117, "UnionSemanticHandlerV2", r27.append(r29).toString(), false, 4, null);
        String r30 = j.a(r61.getSemanticType(), r61.getTagPath());
        if (r4 != null) goto L81;
    L87:
        boolean r31 = false;
    L88:
        if (r4 == null) goto L90;
        Float r122 = Float.valueOf(r4.l());
    L91:
        float r123 = 4.0f;
        Float r124 = r122;
        if (r4 == null) goto L132;
        Long r210 = r61.getModifyTime();
        if (r210 == null) goto L96;
        r114 = r210.longValue();
    L96:
        r4.a(r114);
        r4.a(r61.getSemanticType());
        r4.b(r30);
        r4.c(r61.getKeyPhrase());
        r4.d(r61.getDescription());
        r4.e(r61.getKeyPhrase() + ',' + r61.getDescription());
        String r5 = r61.getSources();
        if (r5 != null) goto L99;
        r5 = "";
    L99:
        r4.f(r5);
        Integer r32 = r61.getEvidenceCount();
        if (r32 == null) goto L102;
        int r33 = r32.intValue();
    L103:
        r4.a(r33);
        if (r31 == false) goto L107;
        r4.b(false);
        r4.c(false);
    L107:
        if (Intrinsics.areEqual(r61.getBusinessType(), "semantic_memory_update") == false) goto L112;
        Boolean r34 = r61.getUserEdit();
        if (r34 != null) goto L117;
        boolean r35 = r4.g();
    L119:
        r4.a(r35);
        r4.g(r61.getLogId());
        if (Intrinsics.areEqual(r61.getBusinessType(), "proactive") == true) goto L126;
        Float r36 = r61.getConfidence();
        if (r36 == null) goto L125;
        r123 = r36.floatValue();
        goto L126
    L125:
        r123 = r4.l();
    L126:
        r4.a(r123);
        if (Intrinsics.areEqual(r61.getBusinessType(), "proactive") == true) goto L129;
    L131:
        r4.h(r16);
        r4.i(r18);
        r4.j(r14);
        r4.k(r20);
        r4.m(r111);
        r4.n(r113);
        ip r37 = r4;
        Float r38 = r124;
    L178:
        if (Intrinsics.areEqual(r61.getBusinessType(), "proactive") == false) goto L180;
    L181:
        g.f13090a.a((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r37, com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin"), r61.getPoisonLabel(), r61.getPoisonLabelVersion(), g.f13090a.b(r37.b(), r37.c()));
    L182:
        RunLog.INSTANCE.debug("UnionSemanticHandlerV2", "commit semantic entity, index=" + r60 + ", productType=" + r2);
        com.obric.memorydata.union.build.storage.h r39 = com.obric.memorydata.union.build.storage.h.f13122a;
        List<String> r40 = r61.getEntityIdList();
        if (r40 != null) goto L185;
        r40 = CollectionsKt.emptyList();
    L185:
        List<String> r41 = r61.getHotWords();
        if (r41 != null) goto L189;
        r41 = CollectionsKt.emptyList();
    L189:
        if (r39.a(r37, r40, r41) == false) goto L244;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UnionSemanticHandlerV2", "semantic commit success, index=" + r60, false, 4, null);
        if (r23 != 1003) goto L207;
        if (b(r61) == false) goto L199;
        if (r4 != null) goto L196;
        boolean r125 = true;
    L197:
        a(r61, r37, r125, r38);
    L198:
        Unit r42 = Unit.INSTANCE;
    L226:
        EntityManager.INSTANCE.launchIndexTask();
        if (r60 == 0) goto L229;
    L239:
        if (r4 != null) goto L242;
        return new SemanticBuildResultItemV2(BDLocationException.SUCCESS, "insert success", r24, null, 8, null);
    L242:
        return new SemanticBuildResultItemV2(BDLocationException.SUCCESS, "update success", r24, r61.getEntityIdList());
    L229:
        if (Intrinsics.areEqual(r61.getBusinessType(), "oauto") == false) goto L239;
        if (r4 == null) goto L233;
        if (r31 == false) goto L239;
    L233:
        if (h.f13091a.a(r61.getSessionId(), r61.getSourceRawRefIds()) == false) goto L239;
        MemoryIslandService r43 = MemoryIslandService.INSTANCE;
        String r44 = r37.getEntityId();
        int r45 = State.SUCCESS_NEW.ordinal();
        MemoryEntity r126 = iq.a(r37);
        if (r4 == null) goto L237;
        MemoryEntity r127 = iq.a(r4);
    L238:
        r43.showMemory(r44, r45, false, r126, r127);
        goto L239
    L237:
        r127 = null;
        goto L238
    L196:
        r125 = false;
        goto L197
    L199:
        String r128 = r61.getSessionId();
        if (r128 == null) goto L226;
        MemoryBuildService r46 = MemoryBuildService.INSTANCE;
        String r211 = r37.getEntityId();
        String r212 = r37.getUuid();
        long r213 = r37.getCreateTime();
        long r214 = r37.getModifyTime();
        String r215 = r37.a();
        String r310 = r37.b();
        String r216 = r61.getContentFrom();
        if (r4 != null) goto L204;
        boolean r217 = true;
    L205:
        r46.insertProactiveSemanticRelevantData(new MemoryBuildApi.b(r128, r211, r212, r213, r214, r215, r216, r217, Float.valueOf(r37.l()), r38, r310));
        Unit r47 = Unit.INSTANCE;
        goto L198
    L204:
        r217 = false;
        goto L205
    L207:
        if (Intrinsics.areEqual(r61.getBusinessType(), "autoMemory") == false) goto L226;
        List<Long> r48 = a(r61.getRelevantData());
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r48, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L226;
        long r49 = System.currentTimeMillis();
        Iterator r50 = ((Iterable) ZeusTransformUtils.preCheckCast(r48, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L212:
        if (r50.hasNext() == false) goto L226;
        long r129 = ((Number) ZeusTransformUtils.preCheckCast(r50.next(), Number.class, "com.obric.memorydata.plugin")).longValue();
        Result.Companion r51 = Result.Companion;     // Catch: Throwable -> L220
        long r218 = r129;
        Object r52 = Result.m1421constructorimpl(Boolean.valueOf(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getAutoMemorySemanticRelevantDataDao().insertIfAbsent(new ab(0, r37.getId(), r218, r49, null, 17, null))));     // Catch: Throwable -> L218
    L223:
        Throwable r53 = Result.m1424exceptionOrNullimpl(r52);
        if (r53 == null) goto L212;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UnionSemanticHandlerV2", "insert AutoMemorySemanticRelevantData failed, memoryId=" + r37.getId() + ", ruleId=" + r218 + ", err=" + r53.getMessage(), null, 4, null);
    L218:
        th = th;
    L222:
        Result.Companion r130 = Result.Companion;
        r52 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L220:
        th = th;
        r218 = r129;
        goto L222
    L244:
        return new SemanticBuildResultItemV2("400", "index error", null, null, 12, null);
    L180:
        if (g.f13090a.a(r61.getPoisonLabel(), r61.getPoisonLabelVersion()) == false) goto L182;
    L129:
        if (Intrinsics.areEqual(r4.s(), "pending") == false) goto L131;
        r4.l("confirmed");
    L117:
        r35 = r34.booleanValue();
        goto L119
    L112:
        r4.b(r2);
        if (Intrinsics.areEqual(r61.getBusinessType(), "proactive") == false) goto L115;
        r35 = true;
        goto L119
    L115:
        r34 = r61.getUserEdit();
        if (r34 != null) goto L117;
        r35 = false;
        goto L119
    L102:
        r33 = 1;
        goto L103
    L132:
        Long r219 = r61.getCreateTime();
        if (r219 == null) goto L135;
        long r220 = r219.longValue();
    L136:
        Long r221 = r61.getModifyTime();
        if (r221 == null) goto L139;
        r114 = r221.longValue();
    L139:
        long r222 = r114;
        String r131 = r61.getPackageName();
        if (r131 != null) goto L142;
        r131 = AppContext.INSTANCE.getPackageName();
    L142:
        String r311 = r131;
        String r312 = r61.getSemanticType();
        String r313 = r61.getKeyPhrase();
        String r132 = r61.getDescription();
        if (r132 != null) goto L145;
        String r314 = "";
    L147:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r61.getDescription(), CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L149;
        boolean r54 = true;
    L150:
        if (r54 == false) goto L152;
        String r55 = r61.getKeyPhrase();
    L153:
        String r133 = r61.getSources();
        if (r133 != null) goto L156;
        String r315 = "";
    L158:
        if (Intrinsics.areEqual(r61.getBusinessType(), "proactive") == false) goto L160;
        boolean r316 = true;
    L164:
        Integer r134 = r61.getEvidenceCount();
        if (r134 == null) goto L167;
        int r317 = r134.intValue();
    L169:
        if (Intrinsics.areEqual(r61.getBusinessType(), "proactive") == false) goto L171;
        float r410 = 4.0f;
    L176:
        r38 = r124;
        r37 = new ip(0, r24, r220, r222, NetError.ERR_CACHE_READ_FAILURE, 0, r311, 0, null, r312, r30, r313, r314, r55, r315, r316, r317, r2, false, false, r410, r61.getLogId(), r16, r18, r14, r20, 0, null, 0, r111, r113, 0, -1676934879, null);
        goto L178
    L171:
        Float r135 = r61.getConfidence();
        if (r135 == null) goto L174;
        float r136 = r135.floatValue();
    L175:
        r410 = r136;
        goto L176
    L174:
        r136 = 0.0f;
        goto L175
    L167:
        r317 = 1;
        goto L169
    L160:
        Boolean r137 = r61.getUserEdit();
        if (r137 == null) goto L163;
        r316 = r137.booleanValue();
        goto L164
    L163:
        r316 = false;
        goto L164
    L156:
        r315 = r133;
        goto L158
    L152:
        r55 = r61.getKeyPhrase() + ',' + r61.getDescription();
        goto L153
    L149:
        r54 = false;
        goto L150
    L145:
        r314 = r132;
        goto L147
    L135:
        r220 = r114;
        goto L136
    L90:
        r122 = null;
        goto L91
    L81:
        if (Intrinsics.areEqual(r61.getSemanticType(), r4.a()) == true) goto L83;
    L86:
        r31 = true;
        goto L88
    L83:
        if (Intrinsics.areEqual(r61.getKeyPhrase(), r4.c()) == false) goto L86;
        if (Intrinsics.areEqual(r30, r4.b()) == true) goto L87;
    L77:
        r29 = 0;
        goto L78
    L73:
        r121 = 0;
        goto L74
    L69:
        r119 = 0;
    L65:
        r24 = com.obric.memorydata.union.build.a.f13066a.a(String.valueOf(r2));
        goto L66
    L60:
        r116 = null;
        goto L61
    L56:
        r0 = null;
        goto L57
    L52:
        r21 = 0;
        goto L53
    L48:
        r112 = null;
        goto L49
    L44:
        r110 = null;
        goto L45
    L40:
        r19 = null;
        goto L41
    L36:
        r17 = null;
        goto L37
    L32:
        r15 = null;
        goto L33
    L28:
        r13 = null;
        goto L29
    L24:
        r12 = false;
        goto L25
    L5:
        return new SemanticBuildResultItemV2("400", "data empty", null, null, 12, null);
    }

    private final String a(UnionSemanticDataV2 r2) {
        m.a r1 = m.f13098a.a(r2.getSourceInfo());
        String r3 = m.f13098a.b(r1.c());
        if (r3 != null) goto L6;
        return null;
    L6:
        if (MemoryDbEngine.INSTANCE.getPersonalDbEngine().getProactiveSemanticRelevantDataDao().queryFirstBySourceScreenshot(r3) == null) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L11;
        return r3;
    L11:
        return null;
    L8:
        r0 = false;
        goto L9
    }

    private final List<Long> a(Map<String, ? extends Object> r7) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L35;
        Object r8 = r6.get("rule_id_list");
        if (r8 == null) goto L35;
        if (ZeusTransformUtils.instanceOf(r8, List.class) == false) goto L10;
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r9.iterator();
    L13:
        if (r11.hasNext() == false) goto L23;
        Object r1 = r11.next();
        if (ZeusTransformUtils.instanceOf(r1, Number.class) == false) goto L18;
        Long r2 = Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).longValue());
    L21:
        if (r2 == null) goto L13;
        r10.add(r2);
        goto L13
    L18:
        if (ZeusTransformUtils.instanceOf(r1, String.class) == false) goto L20;
        r2 = StringsKt.toLongOrNull((String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin"));
        goto L21
    L20:
        r2 = null;
        goto L21
    L23:
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r12.iterator();
    L25:
        if (r14.hasNext() == false) goto L33;
        Object r3 = r14.next();
        if (((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L29;
        boolean r4 = true;
    L30:
        if (r4 == false) goto L25;
        r13.add(r3);
        goto L25
    L29:
        r4 = false;
        goto L30
    L33:
        return CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    L10:
        return CollectionsKt.emptyList();
    L35:
        return CollectionsKt.emptyList();
    }

    private final void a(UnionSemanticDataV2 r29, ip r30, boolean r31, Float r32) {
        m.a r0 = m.f13098a.a(r29.getSourceInfo());
        fa r1 = new fa(0, r30.getEntityId(), r0.a(), r0.b(), a(r29), r0.e(), r0.d(), 0, r0.h(), 1, null);
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getProactiveSemanticRelevantDataDao().insert(r1);
        com.obric.memorydata.database.c.f.f8859a.a(r1);
        MemoryBuildService r15 = MemoryBuildService.INSTANCE;
        d r2 = d.f13071a;
        Map<String, ? extends Object> r3 = r29.getSourceInfo();
        String r4 = r30.getUuid();
        String r5 = iq.b(r30.a());
        String r9 = r30.b();
        r15.trackNewProactiveMemory(MemoryBuildApi.d.a(r2.a(r3, r4, r5, r30.getCreateTime(), r30.getModifyTime(), r31, r9), null, 0, null, 0, null, 0, 0, false, false, Float.valueOf(r30.l()), r32, null, 2559, null));
    }

    private final boolean b(UnionSemanticDataV2 r3) {
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r3.getSessionId(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == true) goto L12;
        return false;
    L12:
        return m.f13098a.b(r3.getSourceInfo());
    L5:
        if (r2.length() == 0) goto L8;
        r4 = false;
        goto L9
    }

    public final String a() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UnionSemanticHandlerV2", "start handle data length: " + this.f13104b.length(), false, 4, null);
        GsonUtil r0 = GsonUtil.INSTANCE;
        String r1 = this.f13104b;
        boolean r2 = true;
        int r3 = 0;
        if (r1 != null) goto L5;
    L13:
        List r4 = null;
    L14:
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L17;
    L20:
        if (r2 == false) goto L23;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UnionSemanticHandlerV2", "handle error, items is null or empty", null, 4, null);
        return null;
    L23:
        List r6 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L25:
        if (r7.hasNext() == false) goto L34;
        Object r8 = r7.next();
        int r9 = r3 + 1;
        if (r3 >= 0) goto L29;
        CollectionsKt.throwIndexOverflow();
    L29:
        SemanticBuildResultItemV2 r10 = a(r3, (UnionSemanticDataV2) ZeusTransformUtils.preCheckCast(r8, UnionSemanticDataV2.class, "com.obric.memorydata.plugin"));
        if (r10 == null) goto L32;
        r6.add(r10);
    L32:
        r3 = r9;
        goto L25
    L34:
        return GsonUtil.INSTANCE.toJson(r6);
    L17:
        if (r5.isEmpty() == true) goto L20;
        r2 = false;
        goto L20
    L5:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L7;
        boolean r11 = true;
    L8:
        if (r11 == true) goto L11;
        r1 = null;
    L11:
        if (r1 == null) goto L13;
        r4 = (List) ZeusTransformUtils.preCheckCast(GsonUtil.INSTANCE.getGSON().fromJson(r1, new b().getType()), List.class, "com.obric.memorydata.plugin");
        goto L14
    L7:
        r11 = false;
        goto L8
    }
}
