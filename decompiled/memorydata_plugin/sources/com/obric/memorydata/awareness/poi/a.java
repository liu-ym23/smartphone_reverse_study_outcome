package com.obric.memorydata.awareness.poi;

import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.rpc.model.POIInfo;
import com.obric.memorydata.database.entity.em;
import com.obric.memorydata.database.entity.en;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.thirdparty.api.location.LocationManager;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.obric.memorydata.utils.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\u0016J.\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\u0016J,\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010\u0016J\"\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0007H\u0002J\"\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0007H\u0002J \u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u000fH\u0002J\u0016\u0010#\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/memorydata/awareness/poi/MemoryPoi;", "", "<init>", "()V", "TAG", "", "POI_CACHE_SIZE", "", "POI_SEARCH_MAX_RADIUS", "", "POI_CACHE_RADIUS_LIMIT", "manager", "Lcom/obric/memorydata/awareness/poi/PoiRequestManager;", "searchCacheList", "", "Lcom/obric/memorydata/awareness/poi/PoiRequestCache;", "getAllPoiByLocation", "", "Lcom/bytedance/rpc/model/POIInfo;", "latitude", "longitude", "radius", "(DDILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPoiByLocation", "poiEqualDelta", "requestPoi", "searchInDatabase", "Lcom/obric/memorydata/database/entity/PoiReqRecorderEntity;", "searchInCache", "saveRequestResult", "", "data", "Lcom/obric/memorydata/awareness/poi/PoiRespData;", "saveCache", "cache", "poiListToEntity", "Lcom/obric/memorydata/database/entity/PoiInfoGroupEntity;", Constants.KEY_LIST, "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8779a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final e f8780b = null;
    private static final List<d> c = null;

    static {
        f8779a = new a();
        f8780b = new e();
        c = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    }

    private a() {
    }

    private final em a(List<? extends POIInfo> r10) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        return new em(0, u.a(r9), r9.size(), 0, 8, null);
    }

    private final en a(double r11, double r13, int r15) {
        Iterator<en> r10 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getPoiReqRecorderDao().queryAll().iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        en r0 = (en) ZeusTransformUtils.preCheckCast(r10.next(), en.class, "com.obric.memorydata.plugin");
        if ((LocationManager.INSTANCE.getDistance(r0.c(), r0.b(), r13, r11) + ((double) r15)) > r0.d()) goto L4;
        return r0;
    L8:
        return null;
    }

    public static final /* synthetic */ Object a(a r7, double r8, double r10, int r12, Continuation r13) {
        return r7.c(r8, r10, r12, (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final void a(final double r11, final double r13, final g r15) {
        if (r15.b().isEmpty() == false) goto L5;
        return;
    L5:
        final List r9 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        List<? extends POIInfo> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator<POIInfo> r1 = r15.b().iterator();
    L7:
        if (r1.hasNext() == false) goto L12;
        r0.add((POIInfo) ZeusTransformUtils.preCheckCast(r1.next(), POIInfo.class, "com.obric.memorydata.plugin"));
        if (r0.size() < 100) goto L7;
        r9.add(a(r0));
        r0.clear();
        goto L7
    L12:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L14;
        r9.add(a(r0));
    L14:
        ThreadPoolContainer.Companion.getInstance().execute(new $$Lambda$a$0VH7bfd3Yq2VmPNwa4EfvAbiJzc(r11, r13, r15, r9));
    }

    private static final void a(double r16, double r18, g r20, List r21) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.memorydata.plugin");
        en r15 = new en(System.currentTimeMillis(), r16, r18, r20.a(), 0, 16, null);
        long r2 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getPoiReqRecorderDao().insert(r15);
        Iterator r4 = r0.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        ((em) ZeusTransformUtils.preCheckCast(r4.next(), em.class, "com.obric.memorydata.plugin")).a(r2);
        goto L4
    L6:
        MemoryDbEngine.INSTANCE.getGlobalDbEngine().getPoiInfoGroupDao().bulkInsert(r0);
        f8779a.a(new d(r15, r0));
    }

    private final void a(d r2) {
        List<d> r1 = c;
        r1.add(r2);
        if (r1.size() <= 3) goto L6;
        r1.remove(0);
        return;
    }

    private final d b(double r11, double r13, int r15) {
        Iterator<d> r10 = c.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r10.next(), d.class, "com.obric.memorydata.plugin");
        if ((LocationManager.INSTANCE.getDistance(r0.a().c(), r0.a().b(), r13, r11) + ((double) r15)) > r0.a().d()) goto L4;
        return r0;
    L8:
        return null;
    }

    private final Object c(double r10, double r12, int r14, Continuation<? super List<? extends POIInfo>> r15) {
        Continuation r16 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r16, MemoryPoi$requestPoi$1.class) == false) goto L7;
        MemoryPoi$requestPoi$1 r0 = (MemoryPoi$requestPoi$1) ZeusTransformUtils.preCheckCast(r16, MemoryPoi$requestPoi$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        MemoryPoi$requestPoi$1 r8 = r0;
        Object r17 = r8.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r8.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r14 = r8.I$0;
        r12 = r8.D$1;
        r10 = r8.D$0;
        a this = (a) ZeusTransformUtils.preCheckCast(r8.L$0, a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r17);
    L17:
        f r18 = (f) ZeusTransformUtils.preCheckCast(r17, f.class, "com.obric.memorydata.plugin");
        if (r18.a() == false) goto L24;
        if (r14 < 500) goto L25;
        this.a(r10, r12, new g(r14, r18.b()));
    L25:
        return r18.b();
    L24:
        return CollectionsKt.emptyList();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r17);
        e r3 = f8780b;
        r8.L$0 = this;
        r8.D$0 = r10;
        r8.D$1 = r12;
        r8.I$0 = r14;
        r8.label = 1;
        r17 = r3.a(r10, r12, r14, r8);
        if (r17 != r1) goto L17;
        return r1;
    L7:
        r0 = new MemoryPoi$requestPoi$1(this, r16);
        goto L8
    }

    public static /* synthetic */ void lambda$0VH7bfd3Yq2VmPNwa4EfvAbiJzc(double r0, double r2, g r4, List r5) {
        a(r0, r2, r4, r5);
    }

    public final Object a(double r16, double r18, int r20, Continuation<? super List<? extends POIInfo>> r21) {
        Continuation<? super List<? extends POIInfo>> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r21, Continuation.class, "com.obric.memorydata.plugin");
        double r12 = r20;
        if (r12 < 2000.0d) goto L6;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryPoi", "radius too large: " + r20, null, 4, null);
        return CollectionsKt.emptyList();
    L6:
        d r7 = b(r16, r18, r20);
        if (r7 != null) goto L9;
        en r0 = a(r16, r18, (int) r18);
        if (r0 == null) goto L15;
        d r8 = new d(r0, MemoryDbEngine.INSTANCE.getGlobalDbEngine().getPoiInfoGroupDao().queryWithRefSource(r0.e()));
        List<POIInfo> r1 = r8.a(r16, r18, r18);
        a(r8);
        return r1;
    L15:
        return c(r16, r18, r20, r6);
    L9:
        return r7.a(r16, r18, r12);
    }

    public final Object b(double r8, double r10, int r12, Continuation<? super List<? extends POIInfo>> r13) {
        return a(r8, r10, r12, (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
