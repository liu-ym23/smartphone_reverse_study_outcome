package com.bytedance.android.livesdk.gecko;

import android.content.Context;
import android.net.Uri;
import android.util.Pair;
import android.webkit.WebResourceResponse;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.NameValuePair;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livehostapi.foundation.IHostNetwork;
import com.bytedance.android.livesdk.config.od0;
import com.bytedance.android.livesdk.gecko.offline.OfflineResourceClient;
import com.bytedance.android.livesdkapi.config.TTLiveWebOfflineConfig;
import com.bytedance.android.livesdkapi.model.HttpResponse;
import com.bytedance.geckox.GeckoClient;
import com.bytedance.geckox.GeckoConfig;
import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.model.UpdatePackage;
import com.bytedance.geckox.net.INetWork;
import com.bytedance.geckox.utils.ResLoadUtils;
import com.bytedance.ies.bullet.service.base.d1;
import com.bytedance.iesgurd.core.GlobalManager;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class LiveGeckoClientImpl implements j {
    public static final Lazy f = null;
    public static final a g = null;
    public final GeckoClient a;
    public final nv5.e b;
    public final qv5.b c;
    public final PolarisFileWrapper d;
    public final Map<String, nv5.e> e;

    public static final class NetWorkImpl implements INetWork {
        public final Lazy a;

        public NetWorkImpl() {
            this.a = LazyKt.lazy(LiveGeckoClientImpl$NetWorkImpl$hostNetwork$2.INSTANCE);
        }

        public final wy5.e b(HttpResponse r5) {
            HashMap r0 = new HashMap();
            Iterator r1 = r5.getHeaders().iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            NameValuePair r2 = (NameValuePair) r1.next();
            r0.put(r2.getName(), r2.getValue());
            goto L4
        L6:
            Unit r3 = Unit.INSTANCE;
            return new wy5.e(r0, new String(r5.getBody(), Charsets.UTF_8), r5.getStatusCode(), r5.getReason());
        }

        public final wy5.e doGet(String r3) {
            return b((HttpResponse) ((IHostNetwork) this.a.getValue()).get(r3, CollectionsKt.emptyList()).execute());
        }

        public final wy5.e doPost(String r9, List<Pair<String, String>> r10) {
            IHostNetwork r0 = (IHostNetwork) this.a.getValue();
            List r1 = CollectionsKt.emptyList();
            ByteArrayOutputStream r2 = new ByteArrayOutputStream();
            if (r10 == null) goto L22;
            Iterator<T> r11 = r10.iterator();
        L6:
            if (r11.hasNext() == false) goto L22;
            Pair r3 = (Pair) r11.next();
            if (r2.size() <= 0) goto L10;
            r2.write(38);
        L10:
            String r4 = URLEncoder.encode((String) r3.first, "UTF-8");
            String r5 = (String) r3.second;
            if (r5 != null) goto L13;
            r5 = "";
        L13:
            String r6 = URLEncoder.encode(r5, "UTF-8");
            Charset r7 = Charset.forName("UTF-8");
            if (r4 == null) goto L21;
            r2.write(r4.getBytes(r7));
            r2.write(61);
            Charset r8 = Charset.forName("UTF-8");
            if (r6 == null) goto L19;
            r2.write(r6.getBytes(r8));
            goto L6
        L19:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        L21:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        L22:
            Unit r12 = Unit.INSTANCE;
            return b((HttpResponse) r0.post(r9, r1, "application/x-www-form-urlencoded; charset=UTF-8", r2.toByteArray()).execute());
        }

        public final wy5.e doPost(String r4, String r5) {
            IHostNetwork r0 = (IHostNetwork) this.a.getValue();
            List r1 = CollectionsKt.emptyList();
            if (r5 == null) goto L6;
            byte[] r6 = r5.getBytes(Charsets.UTF_8);
            if (r6 == null) goto L6;
        L8:
            return b((HttpResponse) r0.post(r4, r1, "application/json; charset=UTF-8", r6).execute());
        L6:
            r6 = new byte[0];
            goto L8
        }

        public final void downloadFile(String r8, long r9, py5.b r11) {
            if (r11 != null) goto L4;
            return;
        L4:
            InputStream r10 = ((HttpResponse) ((IHostNetwork) this.a.getValue()).downloadFileStreaming(false, (int) r9, r8, CollectionsKt.emptyList(), null).execute()).getStream();
            if (r10 != null) goto L18;
            ALogger.e("LiveGeckoClientImpl", "null stream!");
            return;
        L18:
            ByteStreamsKt.copyTo(r10, r11, 2048);     // Catch: Throwable -> L9
            CloseableKt.closeFinally(r10, null);
            return;
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            CloseableKt.closeFinally(r10, th);
            throw th;
        }
    }

    public static final class a {
        public static final /* synthetic */ Context a() {
            return LiveGeckoClientImpl.g.getContext();
        }

        public static final String b() {
            Lazy r0 = LiveGeckoClientImpl.f;
            String r1 = jc1.k.n(IHostContext.class).getServerDeviceId();
            if (r1 != null) goto L5;
        L8:
            boolean r2 = true;
        L9:
            if (r2 == false) goto L12;
            return "test";
        L12:
            return r1;
        L5:
            if (StringsKt.isBlank(r1) == true) goto L8;
            r2 = false;
            goto L9
        }

        public static String c() {
            if (jc1.k.f(IHostBusiness.class) == null) goto L5;
            boolean r0 = jc1.k.f(IHostBusiness.class).isHotsoonR();
        L6:
            if (r0 == false) goto L10;
            return "hotsoon";
        L10:
            if (tb1.c.a == false) goto L13;
            return "aweme";
        L13:
            if (tb1.c.c == false) goto L15;
            return "awemelite";
        L15:
            return "default";
        L5:
            r0 = false;
            goto L6
        }

        private final Context getContext() {
            return jc1.k.n(IHostContext.class).context();
        }

        public a() {
        }
    }

    public static final class b implements Executor {

        public static final class a<T> implements Consumer {
            public final /* synthetic */ Runnable a;

            public a(Runnable r1) {
                this.a = r1;
            }

            public final void accept(Object r1) {
                Runnable r2 = (Runnable) r1;
                Runnable r3 = this.a;
                if (r3 == null) goto L6;
                r3.run();
                return;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.gecko.LiveGeckoClientImpl$b$b, reason: collision with other inner class name */
        public static final class C0366b<T> implements Consumer {
            public static final C0366b a = null;

            static {
                a = new C0366b();
            }

            public C0366b() {
            }

            public final /* bridge */ /* synthetic */ void accept(Object r1) {
                Throwable r2 = (Throwable) r1;
            }
        }

        public b() {
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable r3) {
            Single.just(r3).subscribeOn(Schedulers.io()).subscribe(new a(r3), C0366b.a);
        }
    }

    public static final class c implements xo2.c.a {
        public c() {
        }

        public final void a(UpdatePackage r1, long r2, long r4) {
            GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), r1);
            throw null;
        }
    }

    public static final class d extends GeckoUpdateListener {
        public d() {
        }

        public final void onUpdateFinish() {
            throw null;
        }

        public final void onActivateSuccess(UpdatePackage r2) {
            GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), r2);
            throw null;
        }

        public final void onClean(String r1) {
            throw null;
        }

        public final void onDownloadSuccess(UpdatePackage r2) {
            GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), r2);
            throw null;
        }

        public final void onUpdateStart(UpdatePackage r2) {
            GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), r2);
            throw null;
        }

        public final void onUpdating(String r1) {
            throw null;
        }

        public final void onActivateFail(UpdatePackage r1, Throwable r2) {
            throw null;
        }

        public final void onCheckServerVersionFail(Map<String, ? extends List<? extends Pair<String, Long>>> r1, Throwable r2) {
            throw null;
        }

        public final void onCheckServerVersionSuccess(Map<String, ? extends List<? extends Pair<String, Long>>> r1, Map<String, ? extends List<UpdatePackage>> r2) {
            GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), r2);
            throw null;
        }

        public final void onDownloadFail(UpdatePackage r1, Throwable r2) {
            throw null;
        }
    }

    static {
        g = new a();
        f = LazyKt.lazy(LiveGeckoClientImpl$Companion$instance$2.INSTANCE);
    }

    @Override // com.bytedance.android.livesdk.gecko.j
    public final String a() {
        if (jc1.k.n(IHostContext.class).isBoe() == false) goto L6;
        return "68f927652a5370ec9f4ae1dbaf56fd85";
    L6:
        if (v.a() == false) goto L8;
        return "36723dc3e85a23e701d1697d57de07ed";
    L8:
        return "5fb33cde3ebff01c8433ddc22aac0816";
    }

    @Override // com.bytedance.android.livesdk.gecko.j
    public final List<String> b() {
        List r0 = ResLoadUtils.getAllLocalChannels(this.d, LiveGeckoConfig.b());
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add((String) ((Pair) r2.next()).first);
        goto L4
    L6:
        return r1;
    }

    @Override // com.bytedance.android.livesdk.gecko.j
    public final Long c() {
        Intrinsics.checkNotNullParameter("social_linkmic_dynamic_lynx_saas", "channel");
        String r0 = n.b.b();
        com.bytedance.geckox.b r2 = com.bytedance.geckox.b.a.a;
        String r3 = (String) ((ConcurrentHashMap) GlobalManager.d).get(r0);
        if (r3 != null) goto L7;
        return null;
    L7:
        return ResLoadUtils.getLatestChannelVersion(new PolarisFileWrapper(r3), r0, "social_linkmic_dynamic_lynx_saas");
    }

    public LiveGeckoClientImpl() {
        PolarisFileWrapper r0 = new PolarisFileWrapper(LiveGeckoConfig.c());
        this.d = r0;
        ALogger.i("LiveGeckoClientImpl", "LiveGeckoClientImpl init start");
        com.bytedance.geckox.b r2 = com.bytedance.geckox.b.a.a;
        com.bytedance.geckox.b.e(new LiveGeckoRegister());
        String r3 = LiveGeckoConfig.b();
        GeckoConfig.Builder r4 = new GeckoConfig.Builder(a.a());
        r4.accessKey(new String[]{r3});
        r4.allLocalAccessKeys(new String[]{r3});
        r4.appVersion(jc1.k.n(IHostContext.class).getVersionName());
        r4.appId(jc1.k.n(IHostContext.class).appId());
        r4.host("gecko.zijieapi.com");
        r4.deviceId(a.b());
        r4.resRootDir(r0);
        r4.netStack(new NetWorkImpl());
        b r5 = new b();
        r4.checkUpdateExecutor(r5);
        r4.updateExecutor(r5);
        r4.statisticMonitor(new m());
        Unit r6 = Unit.INSTANCE;
        this.a = GeckoClient.create(r4.build());
        if (LocalTestManager.c(new Class[]{wy.a.class}) == false) goto L5;
        GeckoLogger.enable();
    L5:
        this.b = e();
        this.c = new qv5.b(a.a(), r3, r0);
        if (v.a() == false) goto L8;
        ov5.b.a = true;
    L8:
        LinkedHashMap r1 = new LinkedHashMap();
        ALogger.i("LiveGeckoClientImpl", "Normal: 直播gecko分组下载方式，渠道为空");
        r1.put(r3, CollectionsKt.emptyList());
        OfflineResourceClient.c.a(jc1.a.b());
        ALogger.i("LiveGeckoClientImpl", "LiveGeckoClientImpl init end");
        this.e = new HashMap();
    }

    public final nv5.e e() {
        String r0 = LiveGeckoConfig.b();
        ArrayList r1 = new ArrayList();
        r1.addAll(TTLiveWebOfflineConfig.getGroupTypePattern());
        nv5.f.a r2 = new nv5.f.a(a.a());
        r2.b = r0;
        r2.f = r1;
        r2.g = CollectionsKt.mutableListOf(new Uri[]{Uri.fromFile(this.d)});
        r2.i = "gecko.zijieapi.com";
        r2.h = a.b();
        r2.j = "CN";
        return new nv5.e(new nv5.f(r2));
    }

    @Override // com.bytedance.android.livesdk.gecko.j
    public final boolean d(String r3) {
        Intrinsics.checkNotNullParameter(r3, "relativePath");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r4 = Result.constructor-impl(Boolean.valueOf(this.c.a.a(r3)));     // Catch: Throwable -> L5
    L7:
        Boolean r1 = Boolean.FALSE;
        if (Result.isFailure-impl(r4) == false) goto L11;
        r4 = r1;
    L11:
        return ((Boolean) r4).booleanValue();
    L5:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final WebResourceResponse f(String r4) {
        if (jc1.k.n(IBrowserService.class).enableDynamicWebOffline(a.a()) == false) goto L17;
        if (r4 != null) goto L6;
    L9:
        boolean r0 = true;
    L10:
        if (r0 == false) goto L12;
        return null;
    L12:
        nv5.e r1 = (nv5.e) ((HashMap) this.e).get(r4);
        if (r1 != null) goto L15;
        r1 = e();
        ((HashMap) this.e).put(r4, r1);
    L15:
        r1.a(null, r4);
        return r1.a(null, r4);
    L6:
        if (r4.length() == 0) goto L9;
        r0 = false;
        goto L10
    L17:
        nv5.e r2 = this.b;
        if (r2 != null) goto L20;
        return null;
    L20:
        return r2.a(null, r4);
    }

    @Override // com.bytedance.android.livesdk.gecko.j
    public final Long getChannelVersion(String r2) {
        Intrinsics.checkNotNullParameter(r2, "channel");
        return (Long) ((HashMap) this.c.b()).get(r2);
    }

    @Override // com.bytedance.android.livesdk.gecko.j
    public final InputStream getInputStream(String r4) {
        Intrinsics.checkNotNullParameter(r4, "relativePath");
        Intrinsics.checkNotNullParameter("live_im_push_compress_zstd_dict", "channel");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r5 = Result.constructor-impl(this.c.getInputStream("live_im_push_compress_zstd_dict/".concat(r4)));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r5) == false) goto L11;
        r5 = null;
    L11:
        return (InputStream) r5;
    L5:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    @Override // com.bytedance.android.livesdk.gecko.j
    public final WebResourceResponse interceptRequest(String r6) {
        if (od0.a.getValue().booleanValue() == false) goto L7;
        return i.a(r6);
    L7:
        if (com.bytedance.android.livesdk.gecko.offline.h.a(r6) == false) goto L17;
        WebResourceResponse r0 = null;
        if (r6 == null) goto L16;
        boolean r3 = OfflineResourceClient.a;
        d1 r4 = OfflineResourceClient.e(r6);
        if (r4 == null) goto L13;
        r0 = r4.y;
    L13:
        if (r0 != null) goto L15;
        r0 = f(r6);
    L15:
        ALogger.i("LiveGeckoClientImpl", "LiveGeckoClientImpl->XResource interceptRequest, url=" + r6 + ", response = " + r0);
    L16:
        return r0;
    L17:
        WebResourceResponse r1 = f(r6);
        ALogger.i("LiveGeckoClientImpl", "LiveGeckoClientImpl->Falcon interceptRequest, url=" + r6 + ", response = " + r1);
        return r1;
    }

    @Override // com.bytedance.android.livesdk.gecko.j
    public void update(e r8) {
        Intrinsics.checkNotNullParameter(r8, "geckoUpdateListenerWrapper");
        if (v.a() == true) goto L5;
        return;
    L5:
        xo2.c r0 = (xo2.c) com.bytedance.android.livesdk.service.l.d().b().a(xo2.c.class);
        d r5 = new d();
        String r9 = LiveGeckoConfig.b();
        ALogger.i("LiveGeckoClientImpl", "Normal: 直播gecko分组下载方式，渠道为空");
        Map r4 = MapsKt.mapOf(TuplesKt.to(r9, CollectionsKt.emptyList()));
        if (r0 == null) goto L8;
        r0.a(this.a, a.c(), null, r4, r5, new c());
        return;
    L8:
        this.a.checkUpdateMulti(a.c(), r5, r4);
    }
}
