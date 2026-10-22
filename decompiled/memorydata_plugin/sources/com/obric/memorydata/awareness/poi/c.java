package com.obric.memorydata.awareness.poi;

import com.bytedance.rpc.model.GEOLocation;
import com.bytedance.rpc.model.POIInfo;
import com.bytedance.rpc.model.POISearchData;
import com.bytedance.rpc.model.POISearchReq;
import com.bytedance.rpc.model.POISearchResp;
import com.bytedance.rpc.model.Page;
import com.bytedance.rpc.model.rpc.IntentGatewayService;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 #2\u00020\u0001:\u0001#B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0018\u001a\u00020\u0019H\u0086@¢\u0006\u0002\u0010\u001aJ\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00170\u001c2\u0006\u0010\u001d\u001a\u00020\u0006H\u0002J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/memorydata/awareness/poi/PoiRequest;", "", "latitude", "", "longitude", "radius", "", "<init>", "(DDI)V", "getLatitude", "()D", "getLongitude", "totalPoi", "totalPage", "pageIndex", "state", "Lcom/obric/memorydata/awareness/poi/PoiRequestState;", "getState", "()Lcom/obric/memorydata/awareness/poi/PoiRequestState;", "setState", "(Lcom/obric/memorydata/awareness/poi/PoiRequestState;)V", "poiInfoList", "", "Lcom/bytedance/rpc/model/POIInfo;", "startRequest", "Lcom/obric/memorydata/awareness/poi/PoiResp;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestPageWithRetry", "", "retryTime", "requestPage", "updateTotal", "", "page", "Lcom/bytedance/rpc/model/Page;", "Companion", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8783a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double f8784b;
    private final double c;
    private final int d;
    private int e;
    private int f;
    private int g;
    private PoiRequestState h;
    private final List<POIInfo> i;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/awareness/poi/PoiRequest$Companion;", "", "<init>", "()V", "TAG", "", "PAGE_SIZE", "", "MAX_RETRY_TIME", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8783a = new a(null);
    }

    public c(double r1, double r3, int r5) {
        this.f8784b = r1;
        this.c = r3;
        this.d = r5;
        this.h = PoiRequestState.None;
        this.i = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    }

    private final List<POIInfo> a(int r3) {
        if (b().a() == true) goto L8;
        if (r3 > 0) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return a(r3 - 1);
    L8:
        int r0 = this.g + 1;
        this.g = r0;
        if (r0 <= this.f) goto L13;
        return this.i;
    L13:
        return a(r3);
    }

    private final void a(Page r1) {
        int r2 = r1.total;
        this.e = r2;
        this.f = ((r2 + 1000) - 1) / 1000;
    }

    private final f b() {
        GEOLocation r1 = new GEOLocation();
        r1.latitude = String.valueOf(this.f8784b);
        r1.longitude = String.valueOf(this.c);
        POISearchReq r2 = new POISearchReq();
        r2.geo = r1;
        r2.num = this.g;
        r2.size = 1000;
        r2.radius = this.d;
        Page r3 = null;
        POISearchResp r4 = IntentGatewayService.pOISearchSync(r2);     // Catch: Exception -> L5
    L6:
        if (r4 == null) goto L8;
        POISearchData r5 = r4.data;
    L9:
        if (r5 == null) goto L16;
        POISearchData r6 = r4.data;
        if (r6 == null) goto L13;
        r3 = r6.page;
    L13:
        if (r3 == null) goto L16;
        Page r7 = r4.data.page;
        Intrinsics.checkNotNullExpressionValue(r7, "page");
        a(r7);
        List<POIInfo> r9 = this.i;
        List<POIInfo> r8 = r4.data.infos;
        Intrinsics.checkNotNullExpressionValue(r8, "infos");
        r9.addAll((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin"));
        List<POIInfo> r10 = r4.data.infos;
        Intrinsics.checkNotNullExpressionValue(r10, "infos");
        return new f(true, r10);
    L16:
        return new f(false, CollectionsKt.emptyList());
    L8:
        r5 = null;
    L5:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PoiRequest", "Request pOISearchSync Error", null, 4, null);
        r4 = null;
        goto L6
    }

    public final PoiRequestState a() {
        return this.h;
    }

    public final Object a(Continuation<? super f> r10) {
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        if (this.h != PoiRequestState.Requesting) goto L6;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PoiRequest", "Request Is Running, Do Not Request Again", null, 4, null);
        return new f(false, CollectionsKt.emptyList());
    L6:
        this.g = 1;
        this.e = 0;
        this.f = 0;
        this.h = PoiRequestState.Requesting;
        List<POIInfo> r9 = a(3);
        return new f(true ^ ((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).isEmpty(), r9);
    }
}
