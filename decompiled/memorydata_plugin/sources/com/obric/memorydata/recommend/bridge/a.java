package com.obric.memorydata.recommend.bridge;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.entity.AutoMemoryProEntity;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.gd;
import com.obric.memorydata.database.entity.ip;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0002\u001a*\u0010\b\u001a\u00020\t*\u00020\u00012\u0006\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0002\u001a/\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\f0\u0010H\u0002¢\u0006\u0002\u0010\u0011\u001a\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\u0006\u0010\n\u001a\u00020\u0002H\u0002\u001a\u0012\u0010\u0013\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0002\u001a\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e*\u0004\u0018\u00010\u0004H\u0002\u001a\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e*\u0004\u0018\u00010\u0004H\u0002\u001a\u001e\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0000\u001a&\u0010\u001c\u001a\u00020\u001d*\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0000\u001a\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\u0010 \u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\u0010!\u001a\u0019\u0010\"\u001a\u0004\u0018\u00010\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\u0010#\u001a/\u0010$\u001a\u0004\u0018\u00010\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u00062\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u001d0&H\u0000¢\u0006\u0002\u0010'¨\u0006("}, d2 = {"toAutoMemoryProEntity", "Lcom/obric/memorydata/database/entity/AutoMemoryProEntity;", "Lcom/obric/memorydata/recommend/bridge/AutoMemoryProBridgeImpl$AutoMemoryProData;", "packageNames", "", "now", "", "entityId", "applyAutoMemoryProData", "", SlardarSettingsConstants.PERF_KEY_MEMORY, "withSnapshotRawObservationIds", ExifInterface.GPS_DIRECTION_TRUE, "rawObservationIds", "", "block", "Lkotlin/Function0;", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "resolveAutoMemoryProSnapshotRawObservationIds", "toRawObservationIdsJson", "toEntityIdList", "toRawObservationIdList", "toEpisodicMemoryEntity", "Lcom/obric/memorydata/database/entity/EpisodicMemoryEntity;", "Lcom/obric/memorydata/recommend/bridge/AutoMemoryProBridgeImpl$AutoMemoryProV2EpisodicData;", "upsertOperation", "", "Lorg/json/JSONObject;", "toUnionSemanticMemoryEntity", "Lcom/obric/memorydata/database/entity/UnionSemanticMemoryEntity;", "Lcom/obric/memorydata/recommend/bridge/AutoMemoryProBridgeImpl$AutoMemoryProV2SemanticData;", "resolveEpisodicEntityId", "memoryId", "(Ljava/lang/Long;)Ljava/lang/String;", "resolveSemanticEntity", "(Ljava/lang/Long;)Lcom/obric/memorydata/database/entity/UnionSemanticMemoryEntity;", "resolveOwnedSemanticEntity", "queryById", "Lkotlin/Function1;", "(Ljava/lang/Long;Lkotlin/jvm/functions/Function1;)Lcom/obric/memorydata/database/entity/UnionSemanticMemoryEntity;", "recommend_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class a {
    private static final AutoMemoryProEntity a(AutoMemoryProBridgeImpl.AutoMemoryProData r30, String r31, long r32, String r34) {
        long r12 = r30.getRuleId();
        long r4 = r30.getTimestamp();
        long r6 = r30.getTimestamp();
        String r16 = r30.getTitle();
        String r0 = r30.getSubtitle();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r17 = r30.getContent();
        return new AutoMemoryProEntity(0, r34, r4, r6, 0, null, 0, null, r12, r32, r16, r17, r0, r30.getReason(), r30.getLogId(), 0, r31, r30.getEpisodicIds(), r30.getSemanticIds(), null, null, 1605873, null);
    }

    static /* synthetic */ AutoMemoryProEntity a(AutoMemoryProBridgeImpl.AutoMemoryProData r0, String r1, long r2, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = "";
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = System.currentTimeMillis();
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = gd.f9146a.a();
    L12:
        return a(r0, r1, r2, r4);
    }

    public static final EpisodicMemoryEntity a(AutoMemoryProBridgeImpl.AutoMemoryProV2EpisodicData r57, List<JSONObject> r58) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r58, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r57, "<this>");
        String r2 = a(r57.getMemoryId());
        if (r2 != null) goto L5;
        String r32 = gd.f9146a.a();
    L7:
        if (r2 == null) goto L9;
        boolean r56 = true;
    L10:
        Long r5 = r57.getMemoryId();
        if (r5 == null) goto L13;
        long r8 = r5.longValue();
    L15:
        if (r8 <= 0) goto L18;
        if (r2 != null) goto L18;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AutoMemoryProBridgeImpl", "episodic memory_id unresolved, fallback to add, memoryId=" + r57.getMemoryId(), null, 4, null);
    L18:
        long r9 = r57.getCreateTimestamp();
        String r12 = r57.getTitle();
        String r13 = r57.getContent();
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r57.getTitle(), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L21;
        String r1 = r57.getContent();
    L22:
        String r15 = r1;
        String r16 = r57.getObservation();
        AutoMemoryProBridgeImpl.AutoMemoryProV2EpisodicExtraData r3 = r57.getExtra();
        if (r3 == null) goto L26;
        String r4 = r3.getLocation();
        if (r4 == null) goto L26;
    L27:
        String r17 = r4;
        int r6 = r57.getCategory();
        String r23 = r57.getLogId();
        boolean r7 = r57.getUseLocation();
        EpisodicMemoryEntity r10 = new EpisodicMemoryEntity(0, r9, 0, r12, r13, null, r15, r16, r17, "", Integer.valueOf(r6), null, null, null, r23, false, Boolean.valueOf(r7), false, r57.getStartTimestamp(), r57.getEndTimestamp(), false, r32, r57.getCreateTimestamp(), r57.getModifyTimestamp(), -306, System.currentTimeMillis(), BuildConfig.LIBRARY_PACKAGE_NAME, 0, null, null, 1004, null, null, null, null, null, null, null, null, -1342046207, 127, null);
        if (r0 == null) goto L34;
        JSONObject r11 = new JSONObject();
        if (r56 == false) goto L32;
        String r14 = BuildConfig.CHANNEL;
    L33:
        r11.put("op", r14);
        r11.put("entity", r10.toJsonObjectForEvaluation());
        r0.add(r11);
        goto L34
    L32:
        r14 = "add";
    L34:
        return r10;
    L26:
        r4 = "";
        goto L27
    L21:
        r1 = r57.getTitle() + '\n' + r57.getContent();
        goto L22
    L13:
        r8 = 0;
        goto L15
    L9:
        r56 = false;
        goto L10
    L5:
        r32 = r2;
        goto L7
    }

    private static final ip a(long r1) {
        return (ip) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao().queryById(r1), ip.class, "com.obric.memorydata.plugin");
    }

    public static final ip a(AutoMemoryProBridgeImpl.AutoMemoryProV2SemanticData r48, long r49, List<JSONObject> r51) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r51, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r48, "<this>");
        Long r2 = r48.getCreateTime();
        if (r2 == null) goto L5;
        long r10 = r2.longValue();
    L6:
        Long r3 = r48.getModifyTime();
        if (r3 == null) goto L9;
        long r12 = r3.longValue();
    L10:
        ip r4 = b(r48.getMemoryId());
        if (r4 == null) goto L14;
        String r5 = r4.getEntityId();
        if (r5 == null) goto L14;
    L15:
        String r9 = r5;
        int r6 = 1;
        boolean r7 = false;
        if (r4 == null) goto L18;
        boolean r47 = true;
    L19:
        Long r8 = r48.getMemoryId();
        if (r8 == null) goto L22;
        long r14 = r8.longValue();
    L24:
        if (r14 <= 0) goto L27;
        if (r4 != null) goto L27;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AutoMemoryProBridgeImpl", "semantic memory_id unresolved, fallback to add, memoryId=" + r48.getMemoryId(), null, 4, null);
    L27:
        String r20 = r48.getType();
        String r21 = r48.getTagPath();
        String r22 = r48.getKeyPhrase();
        String r23 = r48.getDescription();
        String r24 = r48.getKeyPhrase();
        String r11 = r48.getSources();
        if (r11 != null) goto L30;
        r11 = "";
    L30:
        String r25 = r11;
        if (r4 == null) goto L33;
        r7 = r4.g();
    L33:
        boolean r26 = r7;
        Integer r13 = r48.getEvidenceCount();
        if (r13 == null) goto L36;
        r6 = r13.intValue();
    L36:
        int r27 = r6;
        if (r4 == null) goto L39;
        int r15 = r4.i();
    L40:
        ip r1 = new ip(0, r9, r10, r12, NetError.ERR_CACHE_READ_FAILURE, r49, BuildConfig.LIBRARY_PACKAGE_NAME, 0, null, r20, r21, r22, r23, r24, r25, r26, r27, r15, false, false, 0.0f, r48.getLogId(), null, null, null, null, 0, null, 0, null, null, 0, -2359039, null);
        if (r0 == null) goto L47;
        JSONObject r16 = new JSONObject();
        if (r47 == false) goto L45;
        String r17 = BuildConfig.CHANNEL;
    L46:
        r16.put("op", r17);
        r16.put("entity", r1.x());
        r0.add(r16);
        goto L47
    L45:
        r17 = "add";
    L47:
        return r1;
    L39:
        r15 = 1004;
        goto L40
    L22:
        r14 = 0;
        goto L24
    L18:
        r47 = false;
    L14:
        r5 = gd.f9146a.a();
        goto L15
    L9:
        r12 = r49;
        goto L10
    L5:
        r10 = r49;
        goto L6
    }

    public static final ip a(Long r6, Function1<? super Long, ip> r7) {
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "queryById");
        if (r6 == null) goto L16;
        long r2 = r6.longValue();
        if (r2 > 0) goto L7;
        return null;
    L7:
        ip r9 = (ip) ZeusTransformUtils.preCheckCast(r8.invoke(Long.valueOf(r2)), ip.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L10;
        return null;
    L10:
        if (r9.i() != 1004) goto L12;
        boolean r10 = true;
    L13:
        if (r10 == true) goto L15;
        return null;
    L15:
        return r9;
    L12:
        r10 = false;
        goto L13
    L16:
        return null;
    }

    public static final /* synthetic */ Object a(List r2, Function0 r3) {
        return b((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin"));
    }

    private static final String a(Long r12) {
        Object r1 = null;
        if (r12 == null) goto L24;
        long r2 = r12.longValue();
        if (r2 > 0) goto L25;
        return null;
    L25:
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L13
        EpisodicMemoryEntity r14 = (EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().queryById(r2), EpisodicMemoryEntity.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        if (r14 == null) goto L10;
        String r15 = r14.getEntityId();     // Catch: Throwable -> L13
    L11:
        Object r16 = Result.m1421constructorimpl(r15);     // Catch: Throwable -> L13
    L15:
        Throwable r4 = Result.m1424exceptionOrNullimpl(r16);
        if (r4 == null) goto L19;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AutoMemoryProBridgeImpl", "resolve episodic entityId failed, memoryId=" + r2 + ", e=" + r4, null, 4, null);
    L19:
        if (Result.m1427isFailureimpl(r16) == true) goto L23;
        r1 = r16;
    L23:
        return (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin");
    L10:
        r15 = null;
    L13:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r16 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L15
    L24:
        return null;
    }

    private static final String a(List<Long> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        JSONArray r0 = new JSONArray();
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L11;
        Object r3 = r11.next();
        if (((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L4;
        r2.add(r3);
        goto L4
    L8:
        r4 = false;
        goto L9
    L11:
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L13:
        if (r12.hasNext() == false) goto L15;
        r0.put(((Number) ZeusTransformUtils.preCheckCast(r12.next(), Number.class, "com.obric.memorydata.plugin")).longValue());
        goto L13
    L15:
        String r13 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r13, "toString(...)");
        return r13;
    }

    public static final /* synthetic */ List a(AutoMemoryProBridgeImpl.AutoMemoryProData r0) {
        return b(r0);
    }

    private static final List<String> a(String r9) {
        if (r9 == null) goto L26;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L7;
        r9 = null;
    L7:
        String r3 = r9;
        if (r3 == null) goto L26;
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.replace$default(r3, 65292, ',', false, 4, null), CharSequence.class, "com.obric.memorydata.plugin"), new char[]{','}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r10.iterator();
    L12:
        if (r11.hasNext() == false) goto L14;
        r4.add(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).toString());
        goto L12
    L14:
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r12.iterator();
    L16:
        if (r13.hasNext() == false) goto L24;
        Object r6 = r13.next();
        if (((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L20;
        boolean r7 = true;
    L21:
        if (r7 == false) goto L16;
        r5.add(r6);
        goto L16
    L20:
        r7 = false;
        goto L21
    L24:
        return CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    L26:
        return CollectionsKt.emptyList();
    }

    public static final /* synthetic */ void a(AutoMemoryProEntity r0, AutoMemoryProBridgeImpl.AutoMemoryProData r1, String r2, long r3) {
        b(r0, r1, r2, r3);
    }

    static /* synthetic */ void a(AutoMemoryProEntity r0, AutoMemoryProBridgeImpl.AutoMemoryProData r1, String r2, long r3, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r3 = System.currentTimeMillis();
    L8:
        b(r0, r1, r2, r3);
    }

    private static final ip b(Long r10) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.m1421constructorimpl(a(r10, $$Lambda$a$QAppGNnSIWAQvMvh7ARph44iDOs.INSTANCE));     // Catch: Throwable -> L4
    L6:
        Throwable r2 = Result.m1424exceptionOrNullimpl(r1);
        if (r2 == null) goto L10;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AutoMemoryProBridgeImpl", "resolve semantic entity failed, memoryId=" + r10 + ", errorType=" + r2.getClass().getSimpleName(), null, 4, null);
    L10:
        if (Result.m1427isFailureimpl(r1) == false) goto L13;
        r1 = null;
    L13:
        return (ip) ZeusTransformUtils.preCheckCast(r1, ip.class, "com.obric.memorydata.plugin");
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    private static final <T> T b(List<Long> r2, Function0<? extends T> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Function0<? extends T> r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        return (T) com.obric.memorydata.database.c.a.f8848a.a(a(r4), r5);
    }

    private static final List<Long> b(AutoMemoryProBridgeImpl.AutoMemoryProData r9) {
        List r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        List<String> r1 = a(r9.getEpisodicIds());
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L8;
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().queryByEntityIds(r1), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(b(((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r2.next(), EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getSourceRawRefIds()), Collection.class, "com.obric.memorydata.plugin"));
    L8:
        List<String> r10 = a(r9.getSemanticIds());
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L14;
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao().queryByEntityIds(r10), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L12:
        if (r11.hasNext() == false) goto L14;
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(b(((ip) ZeusTransformUtils.preCheckCast(r11.next(), ip.class, "com.obric.memorydata.plugin")).o()), Collection.class, "com.obric.memorydata.plugin"));
    L14:
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r12.iterator();
    L16:
        if (r13.hasNext() == false) goto L24;
        Object r4 = r13.next();
        if (((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L20;
        boolean r5 = true;
    L21:
        if (r5 == false) goto L16;
        r3.add(r4);
        goto L16
    L20:
        r5 = false;
        goto L21
    L24:
        return CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    }

    private static final List<Long> b(String r6) {
        if (r6 == null) goto L31;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L7;
        r6 = null;
    L7:
        if (r6 == null) goto L31;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L23
        JSONArray r1 = new JSONArray(r6);     // Catch: Throwable -> L23
        List r7 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        int r2 = 0;
        int r3 = r1.length();     // Catch: Throwable -> L23
    L10:
        if (r2 >= r3) goto L21;
        Object r4 = r1.opt(r2);     // Catch: Throwable -> L23
        if (ZeusTransformUtils.instanceOf(r4, Number.class) == false) goto L16;
        Long r5 = Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).longValue());     // Catch: Throwable -> L23
    L14:
        r7.add(r5);     // Catch: Throwable -> L23
    L20:
        r2 = r2 + 1;     // Catch: Throwable -> L23
        goto L10
    L16:
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L20;
        Long r8 = StringsKt.toLongOrNull((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L23
        if (r8 == null) goto L20;
        r5 = Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).longValue());     // Catch: Throwable -> L23
        goto L14
    L21:
        Object r9 = Result.m1421constructorimpl(r7);     // Catch: Throwable -> L23
    L25:
        List r10 = CollectionsKt.emptyList();
        if (Result.m1427isFailureimpl(r9) == false) goto L29;
        r9 = r10;
    L29:
        return (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin");
    L23:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L31:
        return CollectionsKt.emptyList();
    }

    private static final void b(AutoMemoryProEntity r1, AutoMemoryProBridgeImpl.AutoMemoryProData r2, String r3, long r4) {
        r1.setLogId(r2.getLogId());
        r1.setReason(r2.getReason());
        r1.setTitle(r2.getTitle());
        String r0 = r2.getSubtitle();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        r1.setSubtitle(r0);
        r1.setContent(r2.getContent());
        if (r3 == null) goto L8;
        r1.setPackageNames(r3);
    L8:
        r1.setEpisodicIds(r2.getEpisodicIds());
        r1.setSemanticIds(r2.getSemanticIds());
        r1.setModifyTime(r2.getTimestamp());
        r1.setTimestamp(r4);
    }

    public static /* synthetic */ ip lambda$QAppGNnSIWAQvMvh7ARph44iDOs(long r0) {
        return a(r0);
    }
}
