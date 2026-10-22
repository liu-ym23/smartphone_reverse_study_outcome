package com.bytedance.android.live.service;

import com.bytedance.android.live.openplatform.api.model.datacontext.MiniAppDataContext;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.profile.api.service.ILiveProfileProxyService;
import com.bytedance.android.livesdk.test.network.TestHttpClient;
import com.bytedance.android.livesdkapi.business.IHsLiveAdMocService;
import com.bytedance.android.livesdkapi.model.PlayerExtraRenderInfo;
import com.bytedance.android.livesdkapi.model.RenderDescInfo;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerExtraRenderController;
import com.bytedance.retrofit2.Retrofit;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mv0.b0;
import mv0.c;
import mv0.c0;
import mv0.e0;
import mv0.g;
import mv0.h;
import mv0.i;
import mv0.k;
import mv0.l;
import mv0.n;
import mv0.o;
import mv0.s;
import mv0.t;
import mv0.u;
import qs0.d;
import qs0.e;
import qs0.f;
import qs0.j;
import qs0.m;
import qs0.q;
import qs0.r;
import qs0.v;
import qs0.w;
import qs0.x;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bH\u0010IJ)\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010!\u001a\u00020 H\u0016J\n\u0010#\u001a\u0004\u0018\u00010\"H\u0016J8\u0010+\u001a\u00020*2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020\"2\u0016\u0010)\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\"\u0012\u0006\u0012\u0004\u0018\u00010\"0(H\u0016J\b\u0010-\u001a\u00020,H\u0016J\b\u0010/\u001a\u00020.H\u0016J\b\u00101\u001a\u000200H\u0016J\b\u00103\u001a\u000202H\u0016J\b\u00105\u001a\u000204H\u0016J\b\u00107\u001a\u000206H\u0016J\b\u00109\u001a\u000208H\u0016J\u0016\u0010=\u001a\u00020<2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020*0:H\u0016J\b\u0010>\u001a\u00020$H\u0016J\b\u0010@\u001a\u00020?H\u0016J\n\u0010B\u001a\u0004\u0018\u00010AH\u0016R\u001d\u0010G\u001a\u0004\u0018\u00010A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F¨\u0006J"}, d2 = {"Lcom/bytedance/android/live/service/LiveProfileProxyService;", "Lcom/bytedance/android/live/profile/api/service/ILiveProfileProxyService;", "", "T", "Ljava/lang/Class;", "clz", "getTestHttpClientService", "(Ljava/lang/Class;)Ljava/lang/Object;", "Lqs0/u;", "getIPkAudienceLinkOutServiceProxy", "Lqs0/i;", "getIInteractService", "Lqs0/v;", "getRoomServiceProxy", "Lqs0/o;", "getLiveSdkLogUtil", "Lqs0/s;", "getIMicRoomService", "Lqs0/x;", "getVrUtils", "Lqs0/k;", "getLinkPlayerState", "Lqs0/n;", "getLiveRoomEventParamUtils", "Lqs0/q;", "getILiveVideoFloatWindowService", "Lqs0/m;", "getILiveOntologyInfoManager", "Lqs0/r;", "getIMediaLinkOutService", "Lqs0/d;", "getIBroadcastService", "Lqs0/l;", "getLiveCommonConstants", "", "getPlayerUgcRoomUser", "", "isV1", "event", "label", "", "extra", "", "hsLiveAdMocServiceLogEvent", "Lqs0/b;", "getAudienceGameContext", "Lqs0/f;", "getIHostGameCP", "Lqs0/h;", "getInteractLogUtils", "Lqs0/c;", "getBackToRoomDataUtils", "Lqs0/j;", "getIKtvService", "Lqs0/e;", "getIHostCommerceServiceLive", "Lqs0/g;", "getIHostLiveLocalLife", "Lkotlin/Function0;", "action", "Lio/reactivex/disposables/Disposable;", "registerLiveEventEnd", "isShelfInfoNotNull", "Lqs0/t;", "getMultiAnchorOutService", "Lqs0/w;", "getSaaSAdapterService", "saaSAdapterServiceCache$delegate", "Lkotlin/Lazy;", "getSaaSAdapterServiceCache", "()Lqs0/w;", "saaSAdapterServiceCache", "<init>", "()V", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveProfileProxyService implements ILiveProfileProxyService {
    private final Lazy saaSAdapterServiceCache$delegate;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ Function0 a;

        public a(Function0 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            if (((h1) r2).a != 7) goto L6;
            this.a.invoke();
            return;
        }
    }

    private final w getSaaSAdapterServiceCache() {
        return (w) this.saaSAdapterServiceCache$delegate.getValue();
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public qs0.b getAudienceGameContext() {
        return new mv0.a();
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public d getIBroadcastService() {
        return new c();
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public e getIHostCommerceServiceLive() {
        return new g();
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public f getIHostGameCP() {
        return new h();
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public qs0.g getIHostLiveLocalLife() {
        return new i();
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public qs0.i getIInteractService() {
        return new k();
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public j getIKtvService() {
        return new l();
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public m getILiveOntologyInfoManager() {
        return new o();
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public q getILiveVideoFloatWindowService() {
        return new s();
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public r getIMediaLinkOutService() {
        return new t();
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public qs0.s getIMicRoomService() {
        return new u();
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public qs0.u getIPkAudienceLinkOutServiceProxy() {
        return new b0();
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public qs0.k getLinkPlayerState() {
        return new mv0.m();
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public qs0.o getLiveSdkLogUtil() {
        return new mv0.r();
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public qs0.t getMultiAnchorOutService() {
        return new mv0.w();
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public v getRoomServiceProxy() {
        return new c0();
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public x getVrUtils() {
        return new e0();
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public boolean isShelfInfoNotNull() {
        MiniAppDataContext.Companion.getClass();
        if (MiniAppDataContext.a.b() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public LiveProfileProxyService() {
        this.saaSAdapterServiceCache$delegate = LazyKt.lazy(LiveProfileProxyService$saaSAdapterServiceCache$2.INSTANCE);
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public String getPlayerUgcRoomUser() {
        as0.a r0 = LivePlatformPlayerManager.b();
        if (r0 == null) goto L13;
        ILivePlayerClient r1 = r0.player();
        if (r1 == null) goto L13;
        ILivePlayerExtraRenderController r2 = r1.extraRenderController();
        if (r2 == null) goto L13;
        PlayerExtraRenderInfo r3 = r2.renderInfo();
        if (r3 == null) goto L13;
        RenderDescInfo r4 = r3.getDescInfo();
        if (r4 == null) goto L13;
        return r4.getUserId();
    L13:
        return null;
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public w getSaaSAdapterService() {
        return getSaaSAdapterServiceCache();
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public qs0.c getBackToRoomDataUtils() {
        return mv0.b.a;
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public qs0.h getInteractLogUtils() {
        return mv0.j.a;
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public qs0.l getLiveCommonConstants() {
        return n.a;
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public qs0.n getLiveRoomEventParamUtils() {
        return mv0.q.a;
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public <T> T getTestHttpClientService(Class<T> r4) {
        Intrinsics.checkNotNullParameter(r4, "clz");
        Lazy r1 = TestHttpClient.a;
        Intrinsics.checkNotNullParameter(r4, "clz");
        Lazy r0 = TestHttpClient.a;
        if (((ConcurrentHashMap) r0.getValue()).contains(r4) == true) goto L9;
        Retrofit r2 = (Retrofit) TestHttpClient.c.getValue();
        if (r2 == null) goto L9;
        Object r3 = r2.create(r4);
        if (r3 == null) goto L9;
        ((ConcurrentHashMap) r0.getValue()).putIfAbsent(r4, r3);
    L9:
        T r5 = (T) ((ConcurrentHashMap) r0.getValue()).get(r4);
        if ((r5 instanceof Object) == true) goto L12;
        r5 = null;
    L12:
        if (r5 == null) goto L14;
        return r5;
    L14:
        return (T) com.bytedance.android.live.network.c.b().e(r4);
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public Disposable registerLiveEventEnd(Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "action");
        return xs2.b.a().b(h1.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(r3));
    }

    @Override // com.bytedance.android.live.profile.api.service.ILiveProfileProxyService
    public void hsLiveAdMocServiceLogEvent(boolean r4, String r5, String r6, Map<String, String> r7) {
        Intrinsics.checkNotNullParameter(r5, "event");
        Intrinsics.checkNotNullParameter(r6, "label");
        Intrinsics.checkNotNullParameter(r7, "extra");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r8 = r7.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L9;
        Map.Entry<String, String> r1 = r8.next();
        String r2 = r1.getKey();
        String r3 = r1.getValue();
        if (r2 == null) goto L4;
        if (r3 == null) goto L4;
        r0.put(r2, r3);
        goto L4
    L9:
        jc1.k.n(IHsLiveAdMocService.class).logEvent(r4, r5, r6, r0);
    }
}
