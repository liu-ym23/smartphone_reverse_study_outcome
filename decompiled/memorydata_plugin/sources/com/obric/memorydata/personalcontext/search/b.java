package com.obric.memorydata.personalcontext.search;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.database.dao.AutoMemoryProDao;
import com.obric.memorydata.database.dao.EpisodicMemoryDao;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.dao.MemoryEntityRawDbDao;
import com.obric.memorydata.database.dao.SemanticMemoryDao;
import com.obric.memorydata.database.entity.AutoMemoryProEntity;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.obric.memorydata.database.entity.ip;
import com.obric.memorydata.database.index.s;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.database.model.EntitySearchRecordInfo;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.datausage.plugin.action.manager.k;
import com.obric.memorydata.personalcontext.q;
import com.obric.memorydata.personalcontext.search.entity.CallMode;
import com.obric.memorydata.personalcontext.search.entity.SearchAction;
import com.obric.memorydata.personalcontext.search.entity.SearchParamsAssistant;
import com.obric.memorydata.personalcontext.search.entity.SearchRequest;
import com.obric.memorydata.personalcontext.search.entity.SearchType;
import com.obric.memorydata.sdk.entity.search.AssistantQuResult;
import com.obric.memorydata.sdk.entity.search.ParamItem;
import com.obric.memorydata.sdk.entity.search.QuAction;
import com.obric.memorydata.sdk.entity.search.SearchResponse;
import com.obric.memorydata.sdk.entity.search.SearchResult;
import com.obric.memorydata.utils.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\fJT\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0082@¢\u0006\u0002\u0010\u0016J\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002J(\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00182\u001a\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00180\u001eJ\u001e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00182\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020!R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/EntityAssistantSearch;", "", "<init>", "()V", "TAG", "", "cloudSearch", "Lcom/obric/memorydata/sdk/entity/search/SearchResponse;", "quResult", "queryId", "inputType", "isAppFunc", "", "executeSearch", "", ChatMessage.TYPE_QUERY, "queryUnderStanding", ChatMessage.TYPE_RESPONSE, "entitySearchRecordInfo", "Lcom/obric/memorydata/database/model/EntitySearchRecordInfo;", "startTime", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/obric/memorydata/sdk/entity/search/SearchResponse;Ljava/lang/String;Lcom/obric/memorydata/database/model/EntitySearchRecordInfo;JLjava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "filterSwitchStatusOffDomain", "", "Lcom/obric/memorydata/sdk/entity/search/QuAction;", "actions", "getAppEntityListByEntityTypeAndEntityIdList", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "entityMap", "", "getAppEntityByEntityType", "entityType", "", "limit", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f12278a = null;

    static {
        f12278a = new b();
    }

    private b() {
    }

    public static /* synthetic */ SearchResponse a(b r0, String r1, String r2, String r3, boolean r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r4 = false;
    L6:
        return r0.a(r1, r2, r3, r4);
    }

    public static final /* synthetic */ Object a(b r12, String r13, String r14, SearchResponse r15, String r16, EntitySearchRecordInfo r17, long r18, String r20, boolean r21, Continuation r22) {
        return r12.a(r13, r14, r15, r16, r17, r18, r20, r21, (Continuation) ZeusTransformUtils.wrapperContextForParams(r22, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object a(String r24, String r25, SearchResponse r26, String r27, EntitySearchRecordInfo r28, long r29, String r31, boolean r32, Continuation<? super Unit> r33) {
        SearchResponse r10 = r26;
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r33, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, EntityAssistantSearch$executeSearch$1.class) == false) goto L7;
        EntityAssistantSearch$executeSearch$1 r4 = (EntityAssistantSearch$executeSearch$1) ZeusTransformUtils.preCheckCast(r0, EntityAssistantSearch$executeSearch$1.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        EntityAssistantSearch$executeSearch$1 r9 = r4;
        Object r1 = r9.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r9.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        AssistantQuResult r2 = (AssistantQuResult) ZeusTransformUtils.preCheckCast(r9.L$1, AssistantQuResult.class, "com.obric.memorydata.plugin");
        SearchResponse r3 = (SearchResponse) ZeusTransformUtils.preCheckCast(r9.L$0, SearchResponse.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r1);
        r10 = r3;
    L75:
        r10.setData(new SearchResult((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), r2));
    L18:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L19;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityAssistantSearch", "QueryId: " + r27 + " user has not agree privacy", false, 4, null);
        r10.setCode(0);
        goto L18
    L19:
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r25, CharSequence.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L22;
    L25:
        boolean r7 = true;
    L27:
        if (r7 == true) goto L76;
        Object r15 = null;
        if (StringsKt.startsWith$default(r25, "{", false, 2, null) == false) goto L76;
        r28.setQueryUnderstandingCost(System.currentTimeMillis() - r29);
        r15 = u.a().fromJson(r25, AssistantQuResult.class);     // Catch: Exception -> L34
    L36:
        AssistantQuResult r8 = (AssistantQuResult) ZeusTransformUtils.preCheckCast(r15, AssistantQuResult.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L41;
        r10.setCode(1003);
        StringBuilder r11 = new StringBuilder();
    L39:
        r10.setMessage(r11.append("QueryUnderStanding: ").append(r25).toString());
    L40:
        com.obric.memorydata.personalcontext.log.a.f12229a.a(r10);
        goto L18
    L41:
        List<QuAction> r13 = r8.getActions();
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin");
        if (r14 != null) goto L44;
    L47:
        boolean r16 = true;
    L48:
        if (r16 == false) goto L50;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityAssistantSearch", "QueryId: " + r27 + " actions result is empty", null, 4, null);
        r10.setCode(1003);
        r11 = new StringBuilder();
        goto L39
    L50:
        List<QuAction> r17 = a(r13);
        if (r17.isEmpty() == false) goto L54;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityAssistantSearch", "all search domain switch status off", false, 4, null);
        r10.setData(new SearchResult(CollectionsKt.emptyList(), r8));
        goto L40
    L54:
        if (AppContext.INSTANCE.isSsFlavor() == false) goto L64;
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin");
        Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r20 = r18.iterator();
    L57:
        if (r20.hasNext() == false) goto L61;
        Object r21 = r20.next();
        if (ArraysKt.contains(k.f12093a.a(), ((QuAction) ZeusTransformUtils.preCheckCast(r21, QuAction.class, "com.obric.memorydata.plugin")).getActionName()) == false) goto L57;
        r19.add(r21);
        goto L57
    L61:
        r17 = (List) ZeusTransformUtils.preCheckCast(r19, List.class, "com.obric.memorydata.plugin");
        if (r17.isEmpty() == false) goto L64;
        r10.setCode(1003);
        r11 = new StringBuilder();
    L64:
        r28.setStageQueryUnderstandingCost(System.currentTimeMillis() - r29);
        g r22 = g.INSTANCE;
        SearchType r110 = SearchType.ASSISTANT;
        Iterable r23 = (Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin");
        Collection r30 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r34 = r23.iterator();
    L66:
        if (r34.hasNext() == false) goto L71;
        QuAction r35 = (QuAction) ZeusTransformUtils.preCheckCast(r34.next(), QuAction.class, "com.obric.memorydata.plugin");
        String r36 = r35.getActionName();
        Map<String, ParamItem> r37 = r35.getInputParams();
        if (r37 != null) goto L70;
        r37 = MapsKt.emptyMap();
    L70:
        r30.add(new SearchAction(r36, r37, r35.getActionId()));
        goto L66
    L71:
        SearchRequest r38 = new SearchRequest(r110, new SearchParamsAssistant((List) ZeusTransformUtils.preCheckCast(r30, List.class, "com.obric.memorydata.plugin")), null, 4, null);
        CallMode r39 = CallMode.SLM;
        r9.L$0 = r10;
        r9.L$1 = r8;
        r9.label = 1;
        Object r40 = r22.sendSearchRequest(r38, r8, r26, r28, r39, r31, r32, r9);
        if (r40 != r12) goto L74;
        return r12;
    L74:
        r2 = r8;
        r1 = r40;
        goto L75
    L44:
        if (r14.isEmpty() == true) goto L47;
        r16 = false;
    L34:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GsonExt", "convert content: " + r25 + " toObj error : " + e, null, 4, null);
    L76:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityAssistantSearch", "QueryId: " + r27 + " queryUnderStanding failed: " + r25, null, 4, null);
        r10.setCode(1003);
        r10.setMessage("QueryUnderStanding: " + r25);
        goto L18
    L22:
        if (r6.length() == 0) goto L25;
        r7 = false;
    L7:
        r4 = new EntityAssistantSearch$executeSearch$1(this, r0);
        goto L8
    }

    private final List<QuAction> a(List<QuAction> r8) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Set<String> r9 = a.f12274a.a();
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L16;
        Object r2 = r11.next();
        String r3 = ((QuAction) ZeusTransformUtils.preCheckCast(r2, QuAction.class, "com.obric.memorydata.plugin")).getActionName();
        boolean r5 = false;
        if (q.f12255a.i().contains(r3) == false) goto L8;
    L7:
        r5 = true;
    L13:
        if (r5 == false) goto L4;
        r1.add(r2);
        goto L4
    L8:
        String r4 = (String) ZeusTransformUtils.preCheckCast(q.f12255a.k().get(r3), String.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L13;
        if (r9.contains(r4) == true) goto L13;
    L16:
        return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
    }

    public final SearchResponse a(String r77, String r78, String r79, boolean r80) {
        Intrinsics.checkNotNullParameter(r78, "queryId");
        Intrinsics.checkNotNullParameter(r79, "inputType");
        SearchResponse r11 = new SearchResponse(0, "success", null, 4, null);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityAssistantSearch", "QueryId: " + r78 + " , start cloud entity assistant search.", false, 4, null);
        RunLog.INSTANCE.debug("EntityAssistantSearch", "quResult: " + r77);
        i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new EntityAssistantSearch$cloudSearch$1(r77, r11, r78, new EntitySearchRecordInfo(null, AppInfo.OAssistant.getPackageName(), null, 0, "cloud", 0, 0, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, false, null, -19, null), System.currentTimeMillis(), r79, r80, null), Function2.class, "com.obric.memorydata.plugin"), 1, null);
        RunLog.INSTANCE.debug("EntityAssistantSearch", "QueryId: " + r78 + " cloud search return " + r11);
        return r11;
    }

    public final List<AppEntity> a(int r9, int r10) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityAssistantSearch", "getAppEntityByEntityType type: " + r9 + ", limit: " + r10, false, 4, null);
        List<AppEntity> r8 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (r9 == 20001) goto L5;
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r2 = s.a().getRawDaoByEntityType(r9);
    L7:
        if (r2 == null) goto L20;
        if (r10 != 1) goto L14;
        com.obric.memorydata.database.entity.d r11 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r2.queryOne(), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L78;
        AppEntity r12 = com.obric.memorydata.personalcontext.poison.g.f12254a.a(r11, r2);
        if (r12 == null) goto L78;
    L27:
        r8.add(r12);
    L78:
        return r8;
    L14:
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r2.queryWithLimitAndOffset(r10, 0), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L16:
        if (r13.hasNext() == false) goto L78;
        AppEntity r14 = com.obric.memorydata.personalcontext.poison.g.f12254a.a((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r13.next(), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin"), r2);
        if (r14 == null) goto L16;
        r8.add(r14);
        goto L16
    L20:
        if (r9 != 20001) goto L48;
        EpisodicMemoryDao r15 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao();
        AutoMemoryProDao r0 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getAutoMemoryProDao();
        if (r10 != 1) goto L33;
        EpisodicMemoryEntity r16 = (EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r15.queryOne(), EpisodicMemoryEntity.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L28;
        r12 = com.obric.memorydata.personalcontext.poison.g.f12254a.a((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r16, com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin"), (IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r15, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        if (r12 == null) goto L78;
    L28:
        AutoMemoryProEntity r17 = (AutoMemoryProEntity) ZeusTransformUtils.preCheckCast(r0.queryOne(), AutoMemoryProEntity.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L78;
        r12 = com.obric.memorydata.personalcontext.poison.g.f12254a.a((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r17, com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin"), (IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r0, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        if (r12 == null) goto L78;
    L33:
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r15.queryWithLimitAndOffset(r10, 0), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L35:
        if (r3.hasNext() == false) goto L39;
        AppEntity r4 = com.obric.memorydata.personalcontext.poison.g.f12254a.a((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r3.next(), EpisodicMemoryEntity.class, "com.obric.memorydata.plugin"), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin"), (IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r15, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        if (r4 == null) goto L35;
        r8.add(r4);
        goto L35
    L39:
        int r18 = r10 - r8.size();
        if (r18 <= 0) goto L78;
        Iterator r19 = ((Iterable) ZeusTransformUtils.preCheckCast(r0.queryWithLimitAndOffset(r18, 0), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L43:
        if (r19.hasNext() == false) goto L78;
        AppEntity r110 = com.obric.memorydata.personalcontext.poison.g.f12254a.a((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast((AutoMemoryProEntity) ZeusTransformUtils.preCheckCast(r19.next(), AutoMemoryProEntity.class, "com.obric.memorydata.plugin"), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin"), (IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r0, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        if (r110 == null) goto L43;
        r8.add(r110);
        goto L43
    L48:
        if (r9 != 10105) goto L63;
        SemanticMemoryDao r20 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao();
        if (r10 != 1) goto L56;
        ip r111 = (ip) ZeusTransformUtils.preCheckCast(r20.queryOne(), ip.class, "com.obric.memorydata.plugin");
        if (r111 == null) goto L78;
        r12 = com.obric.memorydata.personalcontext.poison.g.f12254a.a((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r111, com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin"), (IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r20, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        if (r12 == null) goto L78;
    L56:
        Iterator r112 = ((Iterable) ZeusTransformUtils.preCheckCast(r20.queryWithLimitAndOffset(r10, 0), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L58:
        if (r112.hasNext() == false) goto L78;
        AppEntity r1 = com.obric.memorydata.personalcontext.poison.g.f12254a.a((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast((ip) ZeusTransformUtils.preCheckCast(r112.next(), ip.class, "com.obric.memorydata.plugin"), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin"), (IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r20, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        if (r1 == null) goto L58;
        r8.add(r1);
        goto L58
    L63:
        if (q.f12255a.a().contains(Integer.valueOf(r9)) == false) goto L77;
        MemoryEntityRawDbDao r21 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawMemoryEntityDao();
        if (r10 != 1) goto L71;
        RawMemoryEntity r113 = (RawMemoryEntity) ZeusTransformUtils.preCheckCast(r21.queryOne(), RawMemoryEntity.class, "com.obric.memorydata.plugin");
        if (r113 == null) goto L78;
        r12 = com.obric.memorydata.personalcontext.poison.g.f12254a.a((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r113, com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin"), (IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r21, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        if (r12 == null) goto L78;
    L71:
        Iterator r114 = ((Iterable) ZeusTransformUtils.preCheckCast(r21.queryWithLimitAndOffset(r10, 0), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L73:
        if (r114.hasNext() == false) goto L78;
        AppEntity r5 = com.obric.memorydata.personalcontext.poison.g.f12254a.a((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r114.next(), RawMemoryEntity.class, "com.obric.memorydata.plugin"), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin"), (IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r21, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        if (r5 == null) goto L73;
        r8.add(r5);
        goto L73
    L77:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityAssistantSearch", "getAppEntityByEntityType no dbDao, type:" + r9, null, 4, null);
        goto L78
    L5:
        r2 = null;
        goto L7
    }

    public final List<AppEntity> a(Map<String, ? extends List<String>> r15) {
        Map r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "entityMap");
        List<AppEntity> r16 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r17 = r14.entrySet().iterator();
    L4:
        if (r17.hasNext() == false) goto L89;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r17.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin");
        List<String> r3 = (List) ZeusTransformUtils.preCheckCast(r1.getValue(), List.class, "com.obric.memorydata.plugin");
        List r4 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"&"}, false, 0, 6, null);
        if (r4.size() != 2) goto L7;
        boolean r5 = false;
        Integer r6 = StringsKt.toIntOrNull((String) ZeusTransformUtils.preCheckCast(r4.get(0), String.class, "com.obric.memorydata.plugin"));
        String r7 = (String) ZeusTransformUtils.preCheckCast(r4.get(1), String.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L88;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L13;
        boolean r8 = true;
    L14:
        if (r8 == true) goto L88;
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L18;
    L19:
        r5 = true;
    L20:
        if (r5 == true) goto L88;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityAssistantSearch", "getAppEntityListByEntityTypeAndEntityIdList type: " + r6 + ", packageName: " + r7 + ", entityIdList: " + r3, false, 4, null);
        if (r6.intValue() != 20001) goto L25;
    L29:
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r10 = null;
    L30:
        if (r10 != null) goto L31;
        if (r6.intValue() == 20001) goto L39;
        if (r6.intValue() == 10105) goto L65;
        if (r6.intValue() == 10401) goto L73;
        if (q.f12255a.a().contains(r6) == true) goto L81;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityAssistantSearch", "getAppEntityListByEntityTypeAndEntityIdList no dbDao, type:" + r6, null, 4, null);
        goto L4
    L81:
        MemoryEntityRawDbDao r11 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawMemoryEntityDao();
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r11.queryByEntityIdListAndPackageName(r3, r7), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L83:
        if (r12.hasNext() == false) goto L4;
        AppEntity r13 = com.obric.memorydata.personalcontext.poison.g.f12254a.a((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r12.next(), RawMemoryEntity.class, "com.obric.memorydata.plugin"), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin"), (IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r11, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        if (r13 == null) goto L83;
        r16.add(r13);
        goto L83
    L73:
        EpisodicMemoryDao r18 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao();
        Iterator r19 = ((Iterable) ZeusTransformUtils.preCheckCast(r18.queryByEntityIdListAndPackageName(r3, r7), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L75:
        if (r19.hasNext() == false) goto L4;
        AppEntity r20 = com.obric.memorydata.personalcontext.poison.g.f12254a.a((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r19.next(), EpisodicMemoryEntity.class, "com.obric.memorydata.plugin"), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin"), (IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r18, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        if (r20 == null) goto L75;
        r16.add(r20);
        goto L75
    L65:
        SemanticMemoryDao r21 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao();
        Iterator r22 = ((Iterable) ZeusTransformUtils.preCheckCast(r21.queryByEntityIdListAndPackageName(r3, r7), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L67:
        if (r22.hasNext() == false) goto L4;
        AppEntity r23 = com.obric.memorydata.personalcontext.poison.g.f12254a.a((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast((ip) ZeusTransformUtils.preCheckCast(r22.next(), ip.class, "com.obric.memorydata.plugin"), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin"), (IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r21, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        if (r23 == null) goto L67;
        r16.add(r23);
        goto L67
    L39:
        EpisodicMemoryDao r24 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao();
        Map r25 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r26 = ((Iterable) ZeusTransformUtils.preCheckCast(r24.queryByEntityIdListAndPackageName(r3, r7), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L41:
        if (r26.hasNext() == false) goto L46;
        EpisodicMemoryEntity r27 = (EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r26.next(), EpisodicMemoryEntity.class, "com.obric.memorydata.plugin");
        AppEntity r28 = com.obric.memorydata.personalcontext.poison.g.f12254a.a((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r27, com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin"), (IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r24, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        if (r28 == null) goto L41;
        r25.put(r27.getEntityId(), r28);
        goto L41
    L46:
        if (r25.size() == r3.size()) goto L53;
        AutoMemoryProDao r29 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getAutoMemoryProDao();
        Map r30 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r31 = ((Iterable) ZeusTransformUtils.preCheckCast(r29.queryByEntityIdListAndPackageName(r3, r7), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L49:
        if (r31.hasNext() == false) goto L54;
        AutoMemoryProEntity r32 = (AutoMemoryProEntity) ZeusTransformUtils.preCheckCast(r31.next(), AutoMemoryProEntity.class, "com.obric.memorydata.plugin");
        AppEntity r33 = com.obric.memorydata.personalcontext.poison.g.f12254a.a((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r32, com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin"), (IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r29, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        if (r33 == null) goto L49;
        r30.put(r32.getEntityId(), r33);
    L54:
        Iterator r34 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L56:
        if (r34.hasNext() == false) goto L4;
        String r35 = (String) ZeusTransformUtils.preCheckCast(r34.next(), String.class, "com.obric.memorydata.plugin");
        AppEntity r36 = (AppEntity) ZeusTransformUtils.preCheckCast(r30.get(r35), AppEntity.class, "com.obric.memorydata.plugin");
        if (r36 != null) goto L59;
        AppEntity r37 = (AppEntity) ZeusTransformUtils.preCheckCast(r25.get(r35), AppEntity.class, "com.obric.memorydata.plugin");
        if (r37 == null) goto L56;
        r16.add(r37);
        goto L56
    L59:
        r16.add(r36);
        goto L56
    L53:
        r30 = MapsKt.emptyMap();
        goto L54
    L31:
        Iterator r38 = ((Iterable) ZeusTransformUtils.preCheckCast(r10.queryByEntityIdListAndPackageName(r3, r7), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L33:
        if (r38.hasNext() == false) goto L4;
        AppEntity r39 = com.obric.memorydata.personalcontext.poison.g.f12254a.a((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r38.next(), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin"), r10);
        if (r39 == null) goto L33;
        r16.add(r39);
        goto L33
    L25:
        if (r6.intValue() == 10105) goto L29;
        if (r6.intValue() == 10401) goto L29;
        r10 = s.a().getRawDaoByEntityType(r6.intValue());
        goto L30
    L18:
        if (r9.isEmpty() == false) goto L20;
    L13:
        r8 = false;
    L88:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityAssistantSearch", "getAppEntityListByEntityTypeAndEntityIdList invalid params. type: " + r6 + ", packageName: " + r7 + ", entityIdList: " + r3, null, 4, null);
        goto L4
    L7:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityAssistantSearch", "getAppEntityListByEntityTypeAndEntityIdList key error, key: " + r2, null, 4, null);
        goto L4
    L89:
        RunLog.INSTANCE.debug("EntityAssistantSearch", "getAppEntityListByEntityTypeAndEntityIdList result " + r16);
        return r16;
    }
}
