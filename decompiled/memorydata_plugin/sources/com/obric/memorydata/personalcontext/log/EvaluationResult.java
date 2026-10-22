package com.obric.memorydata.personalcontext.log;

import com.bytedance.common.wschannel.WsConstants;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.database.model.EntitySearchRecordInfo;
import com.obric.memorydata.personalcontext.search.entity.CallMode;
import com.obric.memorydata.personalcontext.search.entity.SearchResultEntry;
import com.obric.memorydata.sdk.entity.search.AssistantQuResult;
import com.obric.memorydata.sdk.entity.search.QuAction;
import com.obric.memorydata.sdk.entity.search.SearchResponse;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u007f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u0003J\u000e\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u0019J\u0016\u0010\u001a\u001a\u00020\u00142\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001cJ\u0016\u0010\u001d\u001a\u00020\u00142\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u001cJ\u0016\u0010\u001f\u001a\u00020\u00142\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u001cJ\u0010\u0010 \u001a\u00020\u00142\b\u0010!\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\"\u001a\u00020\u00142\b\u0010#\u001a\u0004\u0018\u00010\u0005J\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u001cJ\u0010\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\bH\u0002J\t\u0010'\u001a\u00020\u0003HÂ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÂ\u0003J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÂ\u0003J\u0011\u0010*\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÂ\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007HÂ\u0003J\u0011\u0010,\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÂ\u0003J\u0019\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0010HÂ\u0003J\u0081\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00072\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0010HÆ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u000203HÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/obric/memorydata/personalcontext/log/EvaluationResult;", "", "type", "", "quResult", "Lcom/obric/memorydata/sdk/entity/search/AssistantQuResult;", "resultEntities", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "kgResultEntities", "queryTimeCost", "Lcom/obric/memorydata/database/model/EntitySearchRecordInfo;", "resultList", "", "Lcom/obric/memorydata/personalcontext/search/entity/SearchResultEntry;", WsConstants.KEY_EXTRA, "", "<init>", "(Ljava/lang/String;Lcom/obric/memorydata/sdk/entity/search/AssistantQuResult;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/Set;Ljava/util/Map;)V", "setResponse", "", "res", "Lcom/obric/memorydata/sdk/entity/search/SearchResponse;", "setType", "setCallType", "Lcom/obric/memorydata/personalcontext/search/entity/CallMode;", "addResultList", "searchResultEntry", "", "addResultEntitiesList", "entityList", "addKGResultEntityList", "addQueryTimeCost", "cost", "setQuResult", "result", "getResultEntities", "getAppEntityKey", "appEntity", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EvaluationResult {
    private Map<String, Object> extra;
    private List<AppEntity> kgResultEntities;
    private AssistantQuResult quResult;
    private List<EntitySearchRecordInfo> queryTimeCost;
    private List<AppEntity> resultEntities;
    private Set<SearchResultEntry> resultList;
    private String type;

    public EvaluationResult() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public EvaluationResult(String r3, AssistantQuResult r4, List<AppEntity> r5, List<AppEntity> r6, List<EntitySearchRecordInfo> r7, Set<SearchResultEntry> r8, Map<String, Object> r9) {
        List<AppEntity> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        List<AppEntity> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        List<EntitySearchRecordInfo> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Set<SearchResultEntry> r13 = (Set) ZeusTransformUtils.wrapperContextForParams(r8, Set.class, "com.obric.memorydata.plugin");
        Map<String, Object> r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "type");
        this.type = r3;
        this.quResult = r4;
        this.resultEntities = r10;
        this.kgResultEntities = r11;
        this.queryTimeCost = r12;
        this.resultList = r13;
        this.extra = r14;
    }

    public /* synthetic */ EvaluationResult(String r10, AssistantQuResult r11, List r12, List r13, List r14, Set r15, Map r16, int r17, DefaultConstructorMarker r18) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r15, Set.class, "com.obric.memorydata.plugin");
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r16, Map.class, "com.obric.memorydata.plugin");
        if ((r17 & 1) == 0) goto L5;
        String r5 = "";
    L6:
        Map r7 = null;
        if ((r17 & 2) == 0) goto L9;
        AssistantQuResult r6 = null;
    L11:
        if ((r17 & 4) == 0) goto L14;
        r0 = null;
    L14:
        if ((r17 & 8) == 0) goto L17;
        r2 = null;
    L17:
        if ((r17 & 16) == 0) goto L20;
        r3 = null;
    L20:
        if ((r17 & 32) == 0) goto L23;
        r4 = null;
    L23:
        if ((r17 & 64) != 0) goto L26;
        r7 = r1;
    L26:
        this(r5, r6, r0, r2, r3, r4, r7);
        return;
    L9:
        r6 = r11;
        goto L11
    L5:
        r5 = r10;
        goto L6
    }

    private final String component1() {
        return this.type;
    }

    private final AssistantQuResult component2() {
        return this.quResult;
    }

    private final List<AppEntity> component3() {
        return this.resultEntities;
    }

    private final List<AppEntity> component4() {
        return this.kgResultEntities;
    }

    private final List<EntitySearchRecordInfo> component5() {
        return this.queryTimeCost;
    }

    private final Set<SearchResultEntry> component6() {
        return this.resultList;
    }

    private final Map<String, Object> component7() {
        return this.extra;
    }

    public static /* synthetic */ EvaluationResult copy$default(EvaluationResult r9, String r10, AssistantQuResult r11, List r12, List r13, List r14, Set r15, Map r16, int r17, Object r18) {
        List<AppEntity> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        List<AppEntity> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        List<EntitySearchRecordInfo> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        Set<SearchResultEntry> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r15, Set.class, "com.obric.memorydata.plugin");
        Map<String, Object> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r16, Map.class, "com.obric.memorydata.plugin");
        if ((r17 & 1) == 0) goto L5;
        String r6 = r9.type;
    L7:
        if ((r17 & 2) == 0) goto L9;
        AssistantQuResult r7 = r9.quResult;
    L11:
        if ((r17 & 4) == 0) goto L14;
        r1 = r9.resultEntities;
    L14:
        if ((r17 & 8) == 0) goto L17;
        r3 = r9.kgResultEntities;
    L17:
        if ((r17 & 16) == 0) goto L20;
        r4 = r9.queryTimeCost;
    L20:
        if ((r17 & 32) == 0) goto L23;
        r5 = r9.resultList;
    L23:
        if ((r17 & 64) == 0) goto L26;
        r2 = r9.extra;
    L26:
        return r9.copy(r6, r7, r1, r3, r4, r5, r2);
    L9:
        r7 = r11;
        goto L11
    L5:
        r6 = r10;
        goto L7
    }

    private final String getAppEntityKey(AppEntity r2) {
        return r2.getType() + '_' + r2.getId();
    }

    public final synchronized void addKGResultEntityList(List<? extends AppEntity> r7) {
        monitor-enter(this);
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        if (r8 != null) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.kgResultEntities != null) goto L10;
        this.kgResultEntities = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
    L10:
        List<AppEntity> r0 = this.kgResultEntities;     // Catch: Throwable -> L37
        if (r0 == null) goto L17;
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        Iterator r3 = r1.iterator();     // Catch: Throwable -> L37
    L14:
        if (r3.hasNext() == false) goto L16;
        r2.add(getAppEntityKey((AppEntity) ZeusTransformUtils.preCheckCast(r3.next(), AppEntity.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L37
        goto L14
    L16:
        Set r4 = CollectionsKt.toMutableSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L37
    L18:
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L37
    L19:
        if (r9.hasNext() == false) goto L35;
        AppEntity r5 = (AppEntity) ZeusTransformUtils.preCheckCast(r9.next(), AppEntity.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        String r6 = getAppEntityKey(r5);     // Catch: Throwable -> L37
        boolean r10 = true;
        if (r4 != null) goto L24;
    L26:
        r10 = false;
    L27:
        if (r10 == true) goto L19;
        if (r4 == null) goto L31;
        r4.add(r6);     // Catch: Throwable -> L37
    L31:
        List<AppEntity> r11 = this.kgResultEntities;     // Catch: Throwable -> L37
        if (r11 == null) goto L19;
        r11.add(r5);     // Catch: Throwable -> L37
        goto L19
    L24:
        if (r4.contains(r6) != true) goto L26;
    L35:
        monitor-exit(this);
        return;
    L17:
        r4 = null;
    L37:
        th = move-exception;
        throw th;
    }

    public final synchronized void addQueryTimeCost(EntitySearchRecordInfo r4) {
        monitor-enter(this);
        if (r4 != null) goto L17;
        monitor-exit(this);
        return;
    L17:
    L14:
        th = move-exception;
        throw th;
    L7:
        if (this.queryTimeCost != null) goto L9;
        this.queryTimeCost = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
    L9:
        List<EntitySearchRecordInfo> r0 = this.queryTimeCost;     // Catch: Throwable -> L14
        if (r0 == null) goto L12;
        r0.add(r4);     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
    }

    public final synchronized void addResultEntitiesList(List<? extends AppEntity> r7) {
        monitor-enter(this);
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        if (r8 != null) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.resultEntities != null) goto L10;
        this.resultEntities = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
    L10:
        List<AppEntity> r0 = this.resultEntities;     // Catch: Throwable -> L37
        if (r0 == null) goto L17;
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        Iterator r3 = r1.iterator();     // Catch: Throwable -> L37
    L14:
        if (r3.hasNext() == false) goto L16;
        r2.add(getAppEntityKey((AppEntity) ZeusTransformUtils.preCheckCast(r3.next(), AppEntity.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L37
        goto L14
    L16:
        Set r4 = CollectionsKt.toMutableSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L37
    L18:
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L37
    L19:
        if (r9.hasNext() == false) goto L35;
        AppEntity r5 = (AppEntity) ZeusTransformUtils.preCheckCast(r9.next(), AppEntity.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        String r6 = getAppEntityKey(r5);     // Catch: Throwable -> L37
        boolean r10 = true;
        if (r4 != null) goto L24;
    L26:
        r10 = false;
    L27:
        if (r10 == true) goto L19;
        if (r4 == null) goto L31;
        r4.add(r6);     // Catch: Throwable -> L37
    L31:
        List<AppEntity> r11 = this.resultEntities;     // Catch: Throwable -> L37
        if (r11 == null) goto L19;
        r11.add(r5);     // Catch: Throwable -> L37
        goto L19
    L24:
        if (r4.contains(r6) != true) goto L26;
    L35:
        monitor-exit(this);
        return;
    L17:
        r4 = null;
    L37:
        th = move-exception;
        throw th;
    }

    public final synchronized void addResultList(List<SearchResultEntry> r4) {
        monitor-enter(this);
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        if (r5 != null) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.resultList != null) goto L10;
        this.resultList = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
    L10:
        Set<SearchResultEntry> r0 = this.resultList;     // Catch: Throwable -> L15
        if (r0 == null) goto L13;
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public final EvaluationResult copy(String r11, AssistantQuResult r12, List<AppEntity> r13, List<AppEntity> r14, List<EntitySearchRecordInfo> r15, Set<SearchResultEntry> r16, Map<String, Object> r17) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r16, Set.class, "com.obric.memorydata.plugin");
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r17, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "type");
        return new EvaluationResult(r11, r12, r5, r6, r7, r8, r9);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, EvaluationResult.class) == true) goto L8;
        return false;
    L8:
        EvaluationResult r6 = (EvaluationResult) ZeusTransformUtils.preCheckCast(r5, EvaluationResult.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.type, r6.type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.quResult, r6.quResult) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.resultEntities, r6.resultEntities) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.kgResultEntities, r6.kgResultEntities) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.queryTimeCost, r6.queryTimeCost) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.resultList, r6.resultList) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.extra, r6.extra) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final List<AppEntity> getResultEntities() {
        List<AppEntity> r2 = this.resultEntities;
        if (r2 != null) goto L7;
        return null;
    L7:
        return CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin"));
    }

    public int hashCode() {
        int r0 = this.type.hashCode() * 31;
        AssistantQuResult r1 = this.quResult;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        List<AppEntity> r5 = this.resultEntities;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        List<AppEntity> r8 = this.kgResultEntities;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        List<EntitySearchRecordInfo> r11 = this.queryTimeCost;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        Set<SearchResultEntry> r14 = this.resultList;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        Map<String, Object> r17 = this.extra;
        if (r17 == null) goto L27;
        r2 = r17.hashCode();
    L27:
        return r16 + r2;
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final void setCallType(CallMode r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        if (this.extra != null) goto L5;
        this.extra = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    L5:
        Map<String, Object> r4 = this.extra;
        Intrinsics.checkNotNull(r4);
        Object r2 = r4.get("call_mode");
        if (r2 != null) goto L9;
        r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r4.put("call_mode", r2);
    L9:
        if (TypeIntrinsics.isMutableList(r2) == false) goto L11;
        List r6 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
    L12:
        if (r6 == null) goto L15;
        r6.add(r5.toString());
        return;
    L15:
        return;
    L11:
        r6 = null;
        goto L12
    }

    public final void setQuResult(AssistantQuResult r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        AssistantQuResult r0 = this.quResult;
        List r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L9;
        List<QuAction> r2 = r0.getActions();
        if (r2 == null) goto L9;
        r1.addAll((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin"));
    L9:
        List<QuAction> r6 = r5.getActions();
        if (r6 == null) goto L12;
        r1.addAll((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin"));
    L12:
        this.quResult = new AssistantQuResult(r1);
    }

    public final void setResponse(SearchResponse r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (this.extra != null) goto L7;
        this.extra = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    L7:
        Map<String, Object> r0 = this.extra;
        Intrinsics.checkNotNull(r0);
        r0.put("code", Integer.valueOf(r4.getCode()));
        Map<String, Object> r3 = this.extra;
        Intrinsics.checkNotNull(r3);
        r3.put("message", r4.getMessage());
    }

    public final void setType(String r3) {
        Intrinsics.checkNotNullParameter(r3, "type");
        if (Intrinsics.areEqual(this.type, "searchGlobal") == false) goto L5;
        return;
    L5:
        this.type = r3;
    }

    public String toString() {
        return "EvaluationResult(type=" + this.type + ", quResult=" + this.quResult + ", resultEntities=" + this.resultEntities + ", kgResultEntities=" + this.kgResultEntities + ", queryTimeCost=" + this.queryTimeCost + ", resultList=" + this.resultList + ", extra=" + this.extra + ')';
    }
}
