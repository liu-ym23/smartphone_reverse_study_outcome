package com.obric.memorydata.memory.tracker;

import com.obric.aiproactive.api.DoubaoGlassesConnectionState;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.RawObservationEntity;
import com.obric.memorydata.database.entity.ip;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.database.manager.PersonalMemoryFrameDb;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.logging.k;
import com.obric.memorydata.middleware.api.logging.o;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J>\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fJ\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0011J\u000f\u0010\u0012\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/memory/tracker/GlassesMemoryDeviceSource;", "", "<init>", "()V", "find", "", TrackerImpl.PARAMS, "Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$BaseMemoryParams;", "currentProductId", "Lkotlin/Function0;", "", "rawObservations", "Lkotlin/Function1;", "", "Lcom/obric/memorydata/database/entity/RawObservationEntity;", "fromProductId", "productId", "(Ljava/lang/Integer;)Ljava/lang/String;", "connectedProductId", "()Ljava/lang/Integer;", "readRawObservations", "fromRawObservations", "observations", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10530a = null;

    static {
        f10530a = new a();
    }

    private a() {
    }

    private final Integer a() {
    L7:
        ((o) ZeusTransformUtils.preCheckCast(k.f11624a, o.class, "com.obric.memorydata.plugin")).a("glasses_product_id_unavailable", "connected glasses product id unavailable", new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null), new com.obric.memorydata.middleware.api.logging.g().a());
        return null;
    L4:
        if (DoubaoGlassesConnectionState.INSTANCE.isConnected() == false) goto L11;
        return Integer.valueOf(IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getInt("glasses_product_id", 0));
    L11:
        return null;
    }

    public static final /* synthetic */ Integer a(a r0) {
        return r0.a();
    }

    public static /* synthetic */ String a(a r1, MemoryEventTracker.BaseMemoryParams r2, Function0 r3, Function1 r4, int r5, Object r6) {
        Function0<Integer> r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Function1<? super MemoryEventTracker.BaseMemoryParams, ? extends List<RawObservationEntity>> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r7 = (Function0) ZeusTransformUtils.preCheckCast(new GlassesMemoryDeviceSource$find$1(r1), Function0.class, "com.obric.memorydata.plugin");
    L6:
        if ((r5 & 4) == 0) goto L9;
        r8 = (Function1) ZeusTransformUtils.preCheckCast(new GlassesMemoryDeviceSource$find$2(r1), Function1.class, "com.obric.memorydata.plugin");
    L9:
        return r1.a(r2, r7, r8);
    }

    private final List<RawObservationEntity> a(MemoryEventTracker.BaseMemoryParams r9) {
        String r8 = r9.getMemoryId();
        if (r8 == null) goto L50;
        String r3 = null;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L8;
        r8 = null;
    L8:
        if (r8 == null) goto L50;
        PersonalMemoryFrameDb r0 = MemoryDbEngine.INSTANCE.getPersonalDbEngine();     // Catch: RuntimeException -> L45 JSONException -> L46
        Integer r10 = r9.getType();     // Catch: RuntimeException -> L45 JSONException -> L46
        if (r10 != null) goto L14;
    L18:
        EpisodicMemoryEntity r11 = (EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r0.getEpisodicMemoryDao().queryByUUID(r8), EpisodicMemoryEntity.class, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L45 JSONException -> L46
        if (r11 == null) goto L21;
        r3 = r11.getSourceRawRefIds();     // Catch: RuntimeException -> L45 JSONException -> L46
    L21:
        if (r3 == null) goto L23;
        JSONArray r12 = new JSONArray(r3);     // Catch: RuntimeException -> L45 JSONException -> L46
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r12.length()), Iterable.class, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L45 JSONException -> L46
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L45 JSONException -> L46
        Iterator r14 = r13.iterator();     // Catch: RuntimeException -> L45 JSONException -> L46
    L26:
        if (r14.hasNext() == false) goto L30;
        String r5 = r12.optString(((IntIterator) ZeusTransformUtils.preCheckCast(r14, IntIterator.class, "com.obric.memorydata.plugin")).nextInt());     // Catch: RuntimeException -> L45 JSONException -> L46
        Intrinsics.checkNotNullExpressionValue(r5, "optString(...)");     // Catch: RuntimeException -> L45 JSONException -> L46
        Long r6 = StringsKt.toLongOrNull(r5);     // Catch: RuntimeException -> L45 JSONException -> L46
        if (r6 == null) goto L26;
        r4.add(r6);     // Catch: RuntimeException -> L45 JSONException -> L46
        goto L26
    L30:
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L45 JSONException -> L46
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L45 JSONException -> L46
        Iterator r17 = r15.iterator();     // Catch: RuntimeException -> L45 JSONException -> L46
    L32:
        if (r17.hasNext() == false) goto L39;
        Object r7 = r17.next();     // Catch: RuntimeException -> L45 JSONException -> L46
        if (((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L36;
        boolean r18 = true;
    L37:
        if (r18 == false) goto L32;
        r16.add(r7);     // Catch: RuntimeException -> L45 JSONException -> L46
        goto L32
    L36:
        r18 = false;
        goto L37
    L39:
        List<Long> r19 = CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));     // Catch: RuntimeException -> L45 JSONException -> L46
        if (r19.isEmpty() == false) goto L62;
        return CollectionsKt.emptyList();
    L62:
        return MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawObservationDao().queryByIds(r19);
    L23:
        return CollectionsKt.emptyList();
    L14:
        if (r10.intValue() != 10105) goto L18;
        ip r20 = (ip) ZeusTransformUtils.preCheckCast(r0.getSemanticMemoryDao().queryByUUID(r8), ip.class, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L45 JSONException -> L46
        if (r20 == null) goto L21;
        r3 = r20.o();     // Catch: RuntimeException -> L45 JSONException -> L46
    L45:
        o r21 = (o) ZeusTransformUtils.preCheckCast(k.f11624a, o.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.middleware.api.logging.e r22 = new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null);
        com.obric.memorydata.middleware.api.logging.f r1 = new com.obric.memorydata.middleware.api.logging.g().a();
        String r2 = "glasses_device_source_lookup_failed";
        String r23 = "glasses device source lookup failed";
    L47:
        r21.a(r2, r23, r22, r1);
        return CollectionsKt.emptyList();
    L46:
        r21 = (o) ZeusTransformUtils.preCheckCast(k.f11624a, o.class, "com.obric.memorydata.plugin");
        r22 = new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null);
        r1 = new com.obric.memorydata.middleware.api.logging.g().a();
        r2 = "glasses_device_source_invalid_refs";
        r23 = "glasses device source references are invalid";
    L50:
        return CollectionsKt.emptyList();
    }

    public static final /* synthetic */ List a(a r0, MemoryEventTracker.BaseMemoryParams r1) {
        return r0.a(r1);
    }

    public final String a(MemoryEventTracker.BaseMemoryParams r4, Function0<Integer> r5, Function1<? super MemoryEventTracker.BaseMemoryParams, ? extends List<RawObservationEntity>> r6) {
        Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, TrackerImpl.PARAMS);
        Intrinsics.checkNotNullParameter(r7, "currentProductId");
        Intrinsics.checkNotNullParameter(r8, "rawObservations");
        String r0 = r4.getSource();
        if (Intrinsics.areEqual(r0, MemoryEventTracker.MemorySource.GLASSES_ACTIVE_MEMORY.getValue()) == false) goto L6;
        return a((Integer) ZeusTransformUtils.preCheckCast(r7.invoke(), Integer.class, "com.obric.memorydata.plugin"));
    L6:
        if (Intrinsics.areEqual(r0, MemoryEventTracker.MemorySource.ENVIRONMENT_MEMORY.getValue()) == true) goto L11;
        return null;
    L11:
        return a((List) ZeusTransformUtils.preCheckCast(r8.invoke(r4), List.class, "com.obric.memorydata.plugin"));
    }

    public final String a(Integer r2) {
        if (r2 == null) goto L8;
        if (r2.intValue() != 16) goto L8;
        return "dora_g1";
    L8:
        if (r2 != null) goto L11;
    L13:
        return null;
    L11:
        if (r2.intValue() != 17) goto L13;
        return "dora_g2";
    }

    public final String a(List<RawObservationEntity> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "observations");
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Object r2 = r10.next();
        if (Intrinsics.areEqual(((RawObservationEntity) ZeusTransformUtils.preCheckCast(r2, RawObservationEntity.class, "com.obric.memorydata.plugin")).getSource(), "glasses") == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r11.iterator();
    L10:
        if (r12.hasNext() == false) goto L20;
        Integer r3 = null;
        boolean r5 = false;
        Integer r4 = Integer.valueOf(new JSONObject(((RawObservationEntity) ZeusTransformUtils.preCheckCast(r12.next(), RawObservationEntity.class, "com.obric.memorydata.plugin")).getPayload()).optInt("glasses_product_id", 0));     // Catch: JSONException -> L21
        if (((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L15;
        r5 = true;
    L15:
        if (r5 == false) goto L17;
        r3 = r4;
    L17:
        if (r3 == null) goto L10;
        r1.add(r3);
        goto L10
    L20:
        return a((Integer) ZeusTransformUtils.preCheckCast(CollectionsKt.singleOrNull(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"))), Integer.class, "com.obric.memorydata.plugin"));
    }
}
