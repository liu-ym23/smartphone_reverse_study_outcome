package com.obric.memorydata.personalcontext.search.bridge.impl;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import androidx.core.content.ContextCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.Ensure;
import com.bytedance.crash.entity.EventBody;
import com.obric.aikernel.sdk.autotest.AutoTestConstant;
import com.obric.capabilitykit.entity.search.InAppSearchEntityParam;
import com.obric.capabilitykit.entity.search.SearchScoreParam;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bridge.IEntitySearchBridgeApi;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.personalcontext.search.bridge.e;
import com.obric.memorydata.personalcontext.search.bridge.f;
import com.obric.memorydata.personalcontext.search.bridge.g;
import com.obric.memorydata.personalcontext.search.bridge.h;
import com.obric.memorydata.personalcontext.search.entity.SearchResultEntry;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.i;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\u0000H\u0007J,\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\u0005H\u0016J*\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u00062\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\u0005J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J*\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0018\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\u00050\u0017H\u0016J\u001e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00172\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\nH\u0016J \u0010\u001a\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0016J\u0018\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\nH\u0016J\u0018\u0010\u001f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\nH\u0016J \u0010!\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\nH\u0016J \u0010$\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\n2\u0006\u0010%\u001a\u00020\u0006H\u0016J$\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u00062\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J \u0010)\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\nH\u0016J\b\u0010*\u001a\u00020\u0006H\u0016J\b\u0010+\u001a\u00020\u0006H\u0016J\b\u0010,\u001a\u00020-H\u0016J\u000e\u0010.\u001a\b\u0012\u0004\u0012\u00020\n0\u0017H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/bridge/impl/EntitySearchBridgeApiImpl;", "Lcom/obric/memorydata/middleware/api/bridge/IEntitySearchBridgeApi;", "<init>", "()V", "bridgeMap", "", "", "Lcom/obric/memorydata/personalcontext/search/bridge/ISearchBridge;", "getInst", "invokeSearchMethod", "", "searchTaskId", "methodName", TrackerImpl.PARAMS, "", "invokeSearchMethodByParamsResult", "Lcom/obric/memorydata/personalcontext/search/bridge/EntitySearchFuncResult;", "searchOption", "Lcom/obric/memorydata/personalcontext/search/bridge/EntitySearchOption;", "clearParamsData", "", "runParallelTask", "methods", "", "awaitParallelTaskResult", "parallelTaskId", "notifySortedSearchResult", "resultListJson", "paginationResultParams", "getResultData", "resultId", "getDataLength", "dataId", "intersection", "firstDataId", "secondDataId", "extractData", "field", "addFieldPrefix", "taskId", "prefixMap", "union", "getEmbeddingTypeForQuery", "getAssistantSearchSwitchStatus", "isPartialPhotoAccess", "", "getPartialAccessPhotoEntityIds", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EntitySearchBridgeApiImpl implements IEntitySearchBridgeApi {
    public static final EntitySearchBridgeApiImpl INSTANCE = null;
    private static final Map<String, g> bridgeMap = null;

    /* JADX INFO: renamed from: com.obric.memorydata.personalcontext.search.bridge.impl.EntitySearchBridgeApiImpl$awaitParallelTaskResult$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.personalcontext.search.bridge.impl.EntitySearchBridgeApiImpl$awaitParallelTaskResult$1", f = "EntitySearchBridgeApiImpl.kt", i = {}, l = {118}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super List<? extends Long>>, Object> {
        final /* synthetic */ long $parallelTaskId;
        final /* synthetic */ String $searchTaskId;
        int label;

        AnonymousClass1(String r3, long r4, Continuation<? super AnonymousClass1> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.$searchTaskId = r3;
            this.$parallelTaskId = r4;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$searchTaskId, this.$parallelTaskId, r7), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super List<? extends Long>> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super List<Long>> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L11:
            return r7;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            com.obric.memorydata.personalcontext.search.bridge.a.b r8 = com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a(this.$searchTaskId).b();
            long r3 = this.$parallelTaskId;
            Continuation<? super List<Long>> r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r7 = r8.a(r3, r2);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        INSTANCE = new EntitySearchBridgeApiImpl();
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(SetsKt.setOf(new g[]{a.f12300a, d.f12304a, c.f12303a, b.f12302a}), Iterable.class, "com.obric.memorydata.plugin");
        Map<String, g> r1 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Object r3 = r2.next();
        r1.put(((g) ZeusTransformUtils.preCheckCast(r3, g.class, "com.obric.memorydata.plugin")).a(), r3);
        goto L4
    L6:
        bridgeMap = r1;
    }

    private EntitySearchBridgeApiImpl() {
    }

    @JvmStatic
    public static final EntitySearchBridgeApiImpl getInst() {
        return INSTANCE;
    }

    private static final Long getResultData$lambda$8(Map r4, Ref.LongRef r5, String r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L6;
        return null;
    L6:
        if (r7.containsKey(r6) == false) goto L8;
        Object r8 = r7.get(r6);
        Intrinsics.checkNotNull(r8);
        return (Long) ZeusTransformUtils.preCheckCast(r8, Long.class, "com.obric.memorydata.plugin");
    L8:
        r5.element++;
        r7.put(r6, Long.valueOf(r5.element));
        return Long.valueOf(r5.element);
    }

    public static /* synthetic */ Object lambda$BMqkhbAgWqXPVwkTmMwpsH6LXBs(com.obric.memorydata.personalcontext.search.bridge.a.d r0, Map r1, JSONArray r2, String r3) {
        return notifySortedSearchResult$lambda$3(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$USrSyri0xCl8WPxjiBShSuHh-10, reason: not valid java name */
    public static /* synthetic */ Long m1092lambda$USrSyri0xCl8WPxjiBShSuHh10(Map r0, Ref.LongRef r1, String r2) {
        return getResultData$lambda$8(r0, r1, r2);
    }

    private static final Object notifySortedSearchResult$lambda$3(com.obric.memorydata.personalcontext.search.bridge.a.d r11, Map r12, JSONArray r13, String r14) {
        Map r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "paramsArray");
        Intrinsics.checkNotNullParameter(r14, "result_key");
        int r0 = r13.length();
        Set r2 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L39;
        JSONObject r5 = r13.optJSONObject(r4);
        if (r5 == null) goto L37;
        if (r5.has(OaidModel.KEY_ID) == false) goto L37;
        if (r5.has("type") == false) goto L37;
        if (r5.has("index") == false) goto L37;
        int r7 = r5.optInt("type", 0);
        long r9 = r5.optLong(OaidModel.KEY_ID, 0);
        int r6 = r5.optInt("index", 0);
        List<h> r8 = r11.a(r7, r9);
        if (r8 == null) goto L17;
        h r10 = (h) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r8, r6), h.class, "com.obric.memorydata.plugin");
    L18:
        boolean r16 = true;
        if (r10 != null) goto L21;
    L23:
        boolean r17 = false;
    L24:
        if (r17 == true) goto L37;
        if (r10 == null) goto L37;
        InAppSearchEntityParam r18 = r10.a();
        if (r18 == null) goto L37;
        String r19 = r18.getValue();
        if (r19 == null) goto L37;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L35;
        r16 = false;
    L35:
        if (r16 == false) goto L37;
        r2.add(r19);
        goto L37
    L21:
        if (r10.b() != true) goto L23;
        r17 = true;
        goto L24
    L17:
        r10 = null;
    L37:
        r4 = r4 + 1;
        goto L3
    L39:
        return r15.put(r14, CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")));
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IEntitySearchBridgeApi
    public void addFieldPrefix(String r11, Map<String, String> r12) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "taskId");
        Intrinsics.checkNotNullParameter(r10, "prefixMap");
        com.obric.memorydata.personalcontext.search.bridge.a.a r13 = com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a(r11);
        if (r13.f() == false) goto L5;
        return;
    L5:
        Iterator r14 = ((Map) ZeusTransformUtils.preCheckCast(r13.a().a(), Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L7:
        if (r14.hasNext() == false) goto L24;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r2 = r13.a().a((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin"));
        if (r10.containsKey(r2) == false) goto L7;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r10.get(r2), String.class, "com.obric.memorydata.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L13;
    L16:
        boolean r5 = true;
    L17:
        if (r5 == true) goto L7;
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r1.getValue(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L20:
        if (r6.hasNext() == false) goto L7;
        h r7 = (h) ZeusTransformUtils.preCheckCast(r6.next(), h.class, "com.obric.memorydata.plugin");
        if (StringsKt.startsWith$default(r7.a().getField(), r3 + '_', false, 2, null) == true) goto L20;
        r7.a().setField(r3 + '_' + r7.a().getField());
        goto L20
    L13:
        if (r4.length() == 0) goto L16;
        r5 = false;
        goto L17
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IEntitySearchBridgeApi
    public List<Long> awaitParallelTaskResult(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "searchTaskId");
        if (com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a(r2).f() == false) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return (List) ZeusTransformUtils.preCheckCast(i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r2, r3, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), List.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IEntitySearchBridgeApi
    public void clearParamsData(String r1) {
        Intrinsics.checkNotNullParameter(r1, "searchTaskId");
        if (com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a(r1).f() == false) goto L5;
        return;
    L5:
        com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a(r1).a().b();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IEntitySearchBridgeApi
    public long extractData(String r3, long r4, String r6) {
        Intrinsics.checkNotNullParameter(r3, "searchTaskId");
        Intrinsics.checkNotNullParameter(r6, "field");
        List<Object> r2 = com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a(r3).d().a(r4);
        List<? extends Object> r5 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L13;
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r7.hasNext() == false) goto L13;
        Object r8 = r7.next();
        if (ZeusTransformUtils.instanceOf(r8, f.class) == false) goto L6;
        Object r9 = ((f) ZeusTransformUtils.preCheckCast(r8, f.class, "com.obric.memorydata.plugin")).a(r6);
        if (r9 == null) goto L6;
        r5.add(r9);
    L13:
        return com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a(r3).d().a(r5);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IEntitySearchBridgeApi
    public String getAssistantSearchSwitchStatus() {
        String r1 = com.obric.memorydata.personalcontext.search.g.INSTANCE.getEntitySwitchStatus().toString();
        Intrinsics.checkNotNullExpressionValue(r1, "toString(...)");
        return r1;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IEntitySearchBridgeApi
    public long getDataLength(String r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "searchTaskId");
        List<Object> r0 = com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a(r1).d().a(r2);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IEntitySearchBridgeApi
    public String getEmbeddingTypeForQuery() {
        return com.obric.memorydata.personalcontext.util.c.f12363a.c();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IEntitySearchBridgeApi
    public List<Long> getPartialAccessPhotoEntityIds() {
        if (Build.VERSION.SDK_INT < 34) goto L5;
        ContentResolver r15 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver();
        Uri r7 = MediaStore.Images.Media.getContentUri("external");
        String[] r9 = {"_id"};
        ArrayList r10 = new ArrayList(5000);
        long r12 = 0;
    L7:
        Bundle r4 = new Bundle();
        r4.putString("android:query-arg-sql-selection", "_id > ? AND width > 0 AND height > 0 AND _size > 0");
        r4.putStringArray("android:query-arg-sql-selection-args", new String[]{String.valueOf(r12)});
        r4.putStringArray("android:query-arg-sort-columns", new String[]{"_id"});
        r4.putInt("android:query-arg-sort-direction", 0);
        r4.putInt("android:query-arg-limit", 5000);
        Cursor r1 = ZeusProviderTransform.query(r15, r7, r9, r4, null, "com.obric.memorydata.plugin");
        if (r1 == null) goto L19;
        Closeable r2 = (Closeable) ZeusTransformUtils.preCheckCast(r1, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r3 = (Cursor) ZeusTransformUtils.preCheckCast(r2, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        int r5 = 0;
    L13:
        if (r3.moveToNext() == false) goto L15;
        r12 = r3.getLong(0);     // Catch: Throwable -> L20
        r10.add(Long.valueOf(r12));     // Catch: Throwable -> L20
        r5 = r5 + 1;     // Catch: Throwable -> L20
        goto L13
    L15:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L20
        CloseableKt.closeFinally(r2, null);
        if (r5 >= 5000) goto L7;
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);
        throw th;
    L19:
        return (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin");
    L5:
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IEntitySearchBridgeApi
    public String getResultData(String r19, long r20) {
        Intrinsics.checkNotNullParameter(r19, "searchTaskId");
        if (com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a(r19).f() == false) goto L6;
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L6:
        final Ref.LongRef r1 = new Ref.LongRef();
        r1.element = -1;
        final Map r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Function1 r3 = new $$Lambda$EntitySearchBridgeApiImpl$USrSyri0xCl8WPxjiBShSuHh10(r2, r1);
        JSONArray r4 = new JSONArray();
        List<Object> r5 = com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a(r19).d().a(r20);
        if (r5 == null) goto L40;
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r6.iterator();
    L10:
        if (r8.hasNext() == false) goto L39;
        Object r9 = r8.next();
        if (ZeusTransformUtils.instanceOf(r9, com.obric.memorydata.personalcontext.search.bridge.d.class) == false) goto L38;
        List<h> r10 = com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a(r19).a().a(((com.obric.memorydata.personalcontext.search.bridge.d) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.personalcontext.search.bridge.d.class, "com.obric.memorydata.plugin")).getType(), ((com.obric.memorydata.personalcontext.search.bridge.d) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.personalcontext.search.bridge.d.class, "com.obric.memorydata.plugin")).a());
        JSONObject r11 = new JSONObject();
        r11.put("type", ((com.obric.memorydata.personalcontext.search.bridge.d) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.personalcontext.search.bridge.d.class, "com.obric.memorydata.plugin")).getType());
        r11.put(OaidModel.KEY_ID, ((com.obric.memorydata.personalcontext.search.bridge.d) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.personalcontext.search.bridge.d.class, "com.obric.memorydata.plugin")).a());
        JSONArray r12 = null;
        if (r10 == null) goto L35;
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r14 = 0;
    L17:
        if (r13.hasNext() == false) goto L35;
        Object r15 = r13.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L21;
        CollectionsKt.throwIndexOverflow();
    L21:
        h r17 = (h) ZeusTransformUtils.preCheckCast(r15, h.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L24;
        r12 = new JSONArray();
    L24:
        JSONObject r18 = new JSONObject();
        InAppSearchEntityParam r110 = r17.a();
        r18.put("field", r110.getField());
        r18.put("index", r14);
        Long r21 = (Long) ZeusTransformUtils.preCheckCast(r3.invoke(r110.getValue()), Long.class, "com.obric.memorydata.plugin");
        if (r21 == null) goto L27;
        r18.put(EventBody.KEY_VALUE, ((Number) ZeusTransformUtils.preCheckCast(r21, Number.class, "com.obric.memorydata.plugin")).longValue());
    L27:
        SearchScoreParam r22 = r110.getScore();
        if (r22 == null) goto L32;
        StringCompanionObject r111 = StringCompanionObject.INSTANCE;
        String r112 = String.format("%.5f", Arrays.copyOf(new Object[]{Double.valueOf(r22.getValue())}, 1));
        Intrinsics.checkNotNullExpressionValue(r112, "format(...)");
        r18.put("score", StringsKt.trimEnd(StringsKt.trimEnd(r112, new char[]{'0'}), new char[]{'.'}));
        r18.put("scoreType", r22.getType());
    L32:
        if (r17.b() == false) goto L34;
        r18.put("wideRecall", true);
    L34:
        r12.put(r18);
        r14 = r16;
    L35:
        if (r12 == null) goto L37;
        r11.put(AutoTestConstant.PARAM, r12);
    L37:
        r4.put(r11);
    L38:
        r7.add(Unit.INSTANCE);
        goto L10
    L39:
        List r0 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");
    L40:
        String r23 = r4.toString();
        Intrinsics.checkNotNullExpressionValue(r23, "toString(...)");
        return r23;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IEntitySearchBridgeApi
    public long intersection(String r2, long r3, long r5) {
        Intrinsics.checkNotNullParameter(r2, "searchTaskId");
        if (com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a(r2).f() == false) goto L5;
        return r3;
    L5:
        List<Object> r1 = com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a(r2).d().a(r3);
        List<Object> r4 = com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a(r2).d().a(r5);
        List<? extends Object> r6 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L8;
        Set r7 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin"));
    L9:
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L12;
    L15:
        boolean r9 = true;
    L16:
        if (r9 == true) goto L25;
        if (r1 == null) goto L25;
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L20:
        if (r10.hasNext() == false) goto L25;
        Object r11 = r10.next();
        if (r4.contains(r11) == false) goto L20;
        r6.add(r11);
    L25:
        return com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a(r2).d().a(r6);
    L12:
        if (r8.isEmpty() == true) goto L15;
        r9 = false;
        goto L16
    L8:
        r7 = null;
        goto L9
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IEntitySearchBridgeApi
    public long invokeSearchMethod(String r10, String r11, Map<String, ? extends Object> r12) {
        Map<String, ? extends Object> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "searchTaskId");
        Intrinsics.checkNotNullParameter(r11, "methodName");
        Intrinsics.checkNotNullParameter(r9, TrackerImpl.PARAMS);
        if (com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a(r10).f() == false) goto L6;
        return 0;
    L6:
        Object r13 = r9.get("foreground_caller_pkg");
        if (ZeusTransformUtils.instanceOf(r13, String.class) == false) goto L9;
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13, String.class, "com.obric.memorydata.plugin");
    L10:
        String r6 = r14;
        g r15 = (g) ZeusTransformUtils.preCheckCast(bridgeMap.get(r11), g.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L17;
        com.obric.memorydata.personalcontext.search.bridge.c r16 = r15.a(new e(r10, false, true, false, r6, 8, null), r9);
        if (r16 == null) goto L17;
        return r16.a();
    L17:
        throw new IllegalArgumentException("method not found");
    L9:
        r14 = null;
        goto L10
    }

    public final com.obric.memorydata.personalcontext.search.bridge.c invokeSearchMethodByParamsResult(e r3, String r4, Map<String, ? extends Object> r5) {
        Map<String, ? extends Object> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "searchOption");
        Intrinsics.checkNotNullParameter(r4, "methodName");
        Intrinsics.checkNotNullParameter(r2, TrackerImpl.PARAMS);
        if (com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a(r3.a()).f() == true) goto L5;
        g r6 = (g) ZeusTransformUtils.preCheckCast(bridgeMap.get(r4), g.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L16;
        com.obric.memorydata.personalcontext.search.bridge.c r7 = r6.a(r3, r2);
        if (r7 == null) goto L16;
        return r7;
    L16:
        throw new IllegalArgumentException("method not found, methodName: " + r4);
    L5:
        if (r3.b() == false) goto L7;
        Map r8 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    L9:
        return new com.obric.memorydata.personalcontext.search.bridge.c(0, r8);
    L7:
        r8 = null;
        goto L9
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IEntitySearchBridgeApi
    public boolean isPartialPhotoAccess() {
        if (Build.VERSION.SDK_INT < 34) goto L21;
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (ContextCompat.checkSelfPermission(r5, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED") != 0) goto L7;
        boolean r1 = true;
    L9:
        if (ContextCompat.checkSelfPermission(r5, "android.permission.READ_MEDIA_IMAGES") != 0) goto L11;
        boolean r3 = true;
    L13:
        if (ContextCompat.checkSelfPermission(r5, "android.permission.READ_MEDIA_VIDEO") != 0) goto L15;
        boolean r6 = true;
    L16:
        if (r1 == false) goto L22;
        if (r3 == false) goto L20;
        if (r6 == false) goto L20;
        return false;
    L20:
        return true;
    L22:
        return false;
    L15:
        r6 = false;
        goto L16
    L11:
        r3 = false;
        goto L13
    L7:
        r1 = false;
        goto L9
    L21:
        return false;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IEntitySearchBridgeApi
    public void notifySortedSearchResult(String r21, String r22, String r23) {
        Intrinsics.checkNotNullParameter(r21, "searchTaskId");
        Intrinsics.checkNotNullParameter(r22, "resultListJson");
        Intrinsics.checkNotNullParameter(r23, "paginationResultParams");
        if (com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a(r21).f() == false) goto L5;
        return;
    L5:
        final Map<String, ? extends Object> r4 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        boolean r7 = true;
        int r8 = 0;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r23, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == false) goto L30;
        JSONObject r6 = new JSONObject(r23);
        int r2 = r6.optInt("page_index", 0);
        if (r2 != 0) goto L24;
        r4.put("resultCount", Integer.valueOf(r6.optInt("total_result_count", 0)));
        final com.obric.memorydata.personalcontext.search.bridge.a.d r9 = com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a(r21).a();
        Function2 r10 = new $$Lambda$EntitySearchBridgeApiImpl$BMqkhbAgWqXPVwkTmMwpsH6LXBs(r9, r4);
        JSONArray r11 = r6.optJSONArray("locality_param_list");
        if (r11 == null) goto L15;
        r10.invoke(r11, "locality");
    L15:
        JSONArray r12 = r6.optJSONArray("country_param_list");
        if (r12 == null) goto L18;
        r10.invoke(r12, "country");
    L18:
        JSONArray r13 = r6.optJSONArray("tag_param_list");
        if (r13 == null) goto L21;
        r10.invoke(r13, LocationMonitorConst.TAG);
    L21:
        JSONArray r14 = r6.optJSONArray("album_param_list");
        if (r14 == null) goto L24;
        r10.invoke(r14, "album");
    L24:
        r4.put("isPagingEnabled", true);
        r4.put("pageIndex", Integer.valueOf(r2));
        if (r2 != (r6.optInt("total_page_size", 0) - 1)) goto L27;
        boolean r3 = true;
    L28:
        r4.put("isLastPage", Boolean.valueOf(r3));
        goto L30
    L27:
        r3 = false;
    L30:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r22, CharSequence.class, "com.obric.memorydata.plugin")).length() == 0) goto L33;
        r7 = false;
    L33:
        if (r7 == false) goto L73;
        com.obric.memorydata.personalcontext.search.g.INSTANCE.onReceiveSearchOptResult(r21, CollectionsKt.emptyList(), r4);
        return;
    L73:
        JSONArray r15 = new JSONArray(r22);     // Catch: Exception -> L70
        List<SearchResultEntry> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        int r16 = r15.length();
        if (r16 != 0) goto L41;
        RunLog.INSTANCE.debug("NativeEntitySearch", "notifySortedSearchResult resultList is empty");
        com.obric.memorydata.personalcontext.search.g.INSTANCE.onReceiveSearchOptResult(r21, CollectionsKt.emptyList(), r4);
        return;
    L41:
        int r17 = 0;
    L42:
        if (r17 >= r16) goto L68;
        JSONObject r18 = r15.getJSONObject(r17);
        if (r18.has("type") == true) goto L46;
    L66:
        JSONArray r24 = r15;
        int r25 = r16;
    L67:
        r17 = r17 + 1;
        r16 = r25;
        r15 = r24;
        r8 = 0;
        goto L42
    L46:
        if (r18.has(OaidModel.KEY_ID) == false) goto L66;
        int r19 = r18.optInt("type", r8);
        long r110 = r18.optLong(OaidModel.KEY_ID, 0);
        List<h> r20 = com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a(r21).a().a(r19, r110);
        List r111 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        JSONArray r26 = r18.optJSONArray(AutoTestConstant.PARAM);
        if (r26 == null) goto L65;
        int r112 = r26.length();
        int r113 = r8;
    L51:
        if (r113 >= r112) goto L65;
        JSONObject r27 = r26.optJSONObject(r113);
        JSONArray r28 = r15;
        if (r27 != null) goto L55;
        int r29 = r16;
    L64:
        r113 = r113 + 1;
        r16 = r29;
        r15 = r28;
        goto L51
    L55:
        r29 = r16;
        int r30 = r27.optInt("index", -1);
        if (r30 < 0) goto L64;
        if (r20 == null) goto L59;
        h r31 = (h) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r20, r30), h.class, "com.obric.memorydata.plugin");
    L60:
        if (r31 == null) goto L64;
        if (r31.b() == true) goto L64;
        r111.add(r31.a());
        goto L64
    L59:
        r31 = null;
    L65:
        r24 = r15;
        r25 = r16;
        r0.add(new SearchResultEntry(r19, r110, r111, 0, 8, null));
        goto L67
    L68:
        com.obric.memorydata.personalcontext.search.g.INSTANCE.onReceiveSearchOptResult(r21, r0, r4);
        return;
    L70:
        e = move-exception;
        Ensure.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"), "notifySortedSearchResult parse JsonError");
        RunLog.INSTANCE.error("NativeEntitySearch", "notifySortedSearchResult parse JsonError", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        com.obric.memorydata.personalcontext.search.g.INSTANCE.onReceiveSearchOptResult(r21, CollectionsKt.emptyList(), r4);
        return;
    L8:
        r5 = false;
        goto L9
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IEntitySearchBridgeApi
    public long runParallelTask(String r13, List<? extends Map<String, ? extends Object>> r14) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "searchTaskId");
        Intrinsics.checkNotNullParameter(r12, "methods");
        if (com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a(r13).f() == false) goto L6;
        return 0;
    L6:
        long r1 = com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a(r13).b().a();
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r17 = r15.iterator();
    L8:
        if (r17.hasNext() == false) goto L10;
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(r17.next(), Map.class, "com.obric.memorydata.plugin");
        r16.add(i.b(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new EntitySearchBridgeApiImpl$runParallelTask$deferredList$1$1(r13, r3, null), Function2.class, "com.obric.memorydata.plugin"), 3, null));
        goto L8
    L10:
        List r18 = (List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin");
        ar<? extends List<Long>> r19 = i.b(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new EntitySearchBridgeApiImpl$runParallelTask$sumDeferred$1(r18, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a(r13).b().a(r1, r19);
        return r1;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IEntitySearchBridgeApi
    public long union(String r3, long r4, long r6) {
        Intrinsics.checkNotNullParameter(r3, "searchTaskId");
        if (com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a(r3).f() == false) goto L5;
        return r4;
    L5:
        List<Object> r2 = com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a(r3).d().a(r4);
        List<Object> r5 = com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a(r3).d().a(r6);
        List<? extends Object> r7 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Set r8 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L13;
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L9:
        if (r9.hasNext() == false) goto L13;
        Object r0 = r9.next();
        if (r8.contains(r0) == true) goto L9;
        r7.add(r0);
        r8.add(r0);
    L13:
        if (r5 == null) goto L21;
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L16:
        if (r10.hasNext() == false) goto L21;
        Object r11 = r10.next();
        if (r8.contains(r11) == true) goto L16;
        r7.add(r11);
        r8.add(r11);
    L21:
        return com.obric.memorydata.personalcontext.search.bridge.a.a.f12280a.a(r3).d().a(r7);
    }
}
