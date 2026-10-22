package com.bytedance.android.live.network.impl;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.base.model.NameValuePair;
import com.bytedance.android.live.initialize.LiveWTO;
import com.bytedance.android.live.network.api.IMiddlewareNetworkService;
import com.bytedance.android.live.network.api.INetworkService;
import com.bytedance.android.live.network.impl.interceptor.y;
import com.bytedance.android.live.network.impl.utils.NetworkGson;
import com.bytedance.android.live.network.impl.utils.RetrofitProvider;
import com.bytedance.android.live.network.impl.utils.UplinkGson;
import com.bytedance.android.livehostapi.LiveSdkInitHelper;
import com.bytedance.android.livehostapi.foundation.IHostNetwork;
import com.bytedance.android.livehostapi.foundation.IHostNetworkForSaas;
import com.bytedance.android.livehostapi.foundation.depend.LiveCall;
import com.bytedance.android.livehostapi.foundation.depend.LiveCallback;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdk.config.zk0;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdkapi.init.LiveInitAssistant;
import com.bytedance.android.livesdkapi.listener.UploadProgressListener;
import com.bytedance.android.livesdkapi.model.HttpResponse;
import com.bytedance.android.livesdkapi.network.ILiveRetrofitWrapper;
import com.bytedance.android.livesdkapi.ws.LiveWsBridge;
import com.bytedance.android.livesdkapi.ws.OnLiveWsMessageReceiveListener;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import vh7.f;
import vh7.g;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class NetWorkService implements INetworkService {
    private Runnable ensureProtoDecodersInjectedRunnable;
    private Runnable feedProtoInjectedRunnable;
    private com.bytedance.android.live.network.b mCommonParamsInterceptor;
    private IHostNetwork mIHostNetwork;
    private final Map<Class, am3.c> protoDecoderMap;

    public class a implements g {
        public final void error(String r1) {
        }

        public a() {
        }
    }

    public class b implements vh7.d {
        public final /* synthetic */ NetWorkService a;

        public b(NetWorkService r1) {
            this.a = r1;
        }

        public final <T> am3.c<T> a(Class<T> r3) {
            return NetWorkService.access$000(this.a, r3, true);
        }
    }

    public static class c<T> implements am3.c<T> {
        public final Class<T> a;

        public c(Class<T> r1) {
            this.a = r1;
        }

        public final T decode(am3.g r2) {
            return (T) f.a(r2, this.a);
        }
    }

    public static class d<T> implements am3.c<T> {
        public final Constructor<T> a;

        public d(Constructor<T> r1) {
            this.a = r1;
        }

        public final T decode(am3.g r4) throws Exception {
            return this.a.newInstance(new Object[]{r4});
        }
    }

    public static class e<T> implements am3.c<T> {
        public final Class<T> a;

        public e(Class<T> r1) {
            this.a = r1;
        }

        public final T decode(am3.g r2) {
            return (T) f.a(r2, this.a);
        }
    }

    private void initModelX() {
        LocalTestManager.a(new Class[]{wy.a.class});
        f.b = new a();
        int r0 = ao0.f.a;
        b r1 = new b(this);
        Intrinsics.checkNotNullParameter(r1, "javaDecoderFinder");
        f.a = r1;
    }

    public InputStream doPost(String r1, String r2, Map<String, String> r3, Map<String, Object> r4) {
        return null;
    }

    public final /* synthetic */ List getBdTicketParams(String r1, String r2) {
        return IHostNetworkForSaas.-CC.$default$getBdTicketParams(this, r1, r2);
    }

    @Override // com.bytedance.android.live.network.api.IMiddlewareNetworkService
    public Map<String, String> getCommonParams() {
        Map<String, String> r0 = this.mIHostNetwork.getCommonParams();
        com.bytedance.android.live.network.b r1 = this.mCommonParamsInterceptor;
        if (r1 == null) goto L5;
        ((com.bytedance.android.live.network.impl.interceptor.c) r1).b(r0);
    L5:
        return r0;
    }

    public String getHostDomain() {
        return this.mIHostNetwork.getHostDomain();
    }

    public ILiveRetrofitWrapper getRetrofitInstanceV2() {
        return this.mIHostNetwork.getRetrofitInstanceV2();
    }

    @Override // com.bytedance.android.live.network.api.IMiddlewareNetworkService
    public Gson provideUploadLinkGson() {
        return (Gson) UplinkGson.a.getValue();
    }

    @Override // com.bytedance.android.live.network.api.IMiddlewareNetworkService
    public Gson provideNetworkGson() {
        return NetworkGson.a();
    }

    public NetWorkService(IHostNetwork r3) {
        this.protoDecoderMap = new ConcurrentHashMap();
        LiveInitAssistant r0 = LiveInitAssistant.INSTANCE;
        if (r0.getInitConfigInner().isLiveInitArcOpt() == false) goto L6;
        initNetWork(r3);
        return;
    L6:
        if (r0.optimizeConfig().getPreInitLiveOptV2() == false) goto L10;
        if (k.b(INetworkService.class) != null) goto L10;
    L11:
        initNetWork(r3);
        return;
    L10:
        if (k.f(INetworkService.class) == null) goto L11;
    }

    private void initNetWork(IHostNetwork r2) {
        com.bytedance.android.live.network.c.e = new RetrofitProvider();
        this.mIHostNetwork = r2;
        this.mCommonParamsInterceptor = new com.bytedance.android.live.network.impl.interceptor.c();
        initModelX();
        k.l(IHostNetwork.class, this);
        k.l(INetworkService.class, this);
        k.l(IMiddlewareNetworkService.class, this);
    }

    private <T> e<T> loadModelXDecoderV2(Class<T> r3) {
        e<T> r0 = new e(r3);
        this.protoDecoderMap.put(r3, r0);
        return r0;
    }

    private <T> c<T> tryLoadFlexModelDecoder(Class<T> r3) {
        if (vh7.c.class.isAssignableFrom(r3) == true) goto L6;
        return null;
    L6:
        c<T> r0 = new c(r3);
        this.protoDecoderMap.put(r3, r0);
        return r0;
    }

    private <T> d<T> tryLoadModelXProtobufConstructor(Class<T> r5) {
        if (h.class.isAssignableFrom(r5) == true) goto L10;
        return null;
    L10:
        d<T> r3 = new d(r5.getConstructor(new Class[]{am3.g.class}));     // Catch: NoSuchMethodException -> L7
        this.protoDecoderMap.put(r5, r3);     // Catch: NoSuchMethodException -> L7
        return r3;
    L7:
        LocalTestManager.a(new Class[]{wy.a.class});
        return null;
    }

    @Override // com.bytedance.android.live.network.api.INetworkService
    public void ensureFeedProtoInjected(Runnable r1) {
        this.feedProtoInjectedRunnable = r1;
    }

    @Override // com.bytedance.android.live.network.api.IMiddlewareNetworkService
    public <T> am3.c<T> getProtoDecoder(Class<T> r3) {
        am3.c<T> r4 = getProtoDecoder(r3, false);
        if (r4 == null) goto L5;
        return r4;
    L5:
        LocalTestManager.a(new Class[]{wy.a.class});
        return null;
    }

    @Override // com.bytedance.android.live.network.api.INetworkService, com.bytedance.android.live.network.api.IMiddlewareNetworkService
    public void injectProtoDecoders(Map<Class, am3.c> r2) {
        this.protoDecoderMap.putAll(r2);
    }

    @Override // com.bytedance.android.live.network.api.INetworkService
    public void putCommonParams(Map<String, String> r2) {
        new com.bytedance.android.live.network.impl.interceptor.c().b(r2);
    }

    @Override // com.bytedance.android.live.network.api.INetworkService
    public void setEnsureProtoDecodersInjected(Runnable r1) {
        this.ensureProtoDecodersInjectedRunnable = r1;
    }

    private <T> am3.c<T> getProtoDecoder(Class<T> r6, boolean r7) {
        LiveWTO r0 = LiveWTO.INSTANCE;
        r0.ensureTaskReady(29);
        r0.ensureTaskReady(7);
        if (LiveSdkInitHelper.isEnableLauncherOpt() == false) goto L33;
        if (LiveInitAssistant.INSTANCE.getInitConfigInner().isLiveInitArcOpt() == true) goto L26;
        x50.b r1 = x50.b.a.a;
        if (r1.g == true) goto L26;
        monitor-enter(r1);
    L23:
        th = move-exception;
        throw th;
    L10:
        if (r1.g == false) goto L14;
        monitor-exit(r1);     // Catch: Throwable -> L23
        goto L26
    L14:
        if (r1.e != null) goto L16;
        r1.e = r1.a();     // Catch: Throwable -> L23
    L16:
        r1.e();     // Catch: Throwable -> L23
        if (r1.g == false) goto L20;
        monitor-exit(r1);     // Catch: Throwable -> L23
        goto L26
    L20:
        r1.d();     // Catch: Throwable -> L23
        monitor-exit(r1);     // Catch: Throwable -> L23
    L26:
        Runnable r2 = this.ensureProtoDecodersInjectedRunnable;
        if (LiveSdkInitHelper.isInjectWithServiceInit() == false) goto L29;
    L30:
        if (r2 == null) goto L33;
        r2.run();
        this.ensureProtoDecodersInjectedRunnable = null;
        goto L33
    L29:
        if (((Boolean) zk0.a.getValue()).booleanValue() == true) goto L30;
    L33:
        if (LiveSdkInitHelper.isEnableFeedOpt() == false) goto L37;
        Runnable r3 = this.feedProtoInjectedRunnable;
        if (r3 == null) goto L37;
        b0.o().getClass();
        com.bytedance.android.live.core.log.g.a("ttlive_init", "feedProtoInjectedRunnable: run");
        r3.run();
        this.feedProtoInjectedRunnable = null;
    L37:
        if (r6 != null) goto L39;
        return null;
    L39:
        am3.c<T> r4 = this.protoDecoderMap.get(r6);
        if (r4 == null) goto L45;
        if (r7 == true) goto L43;
    L44:
        return r4;
    L43:
        if ((r4 instanceof c) == false) goto L44;
    L45:
        d<T> r5 = tryLoadModelXProtobufConstructor(r6);
        if (r5 == null) goto L48;
        return r5;
    L48:
        if (r7 == false) goto L50;
        return null;
    L50:
        return tryLoadFlexModelDecoder(r6);
    }

    public LiveCall<HttpResponse> get(String r5, List<NameValuePair> r6) throws IOException {
        com.bytedance.android.live.network.b r0 = this.mCommonParamsInterceptor;
        if (r0 == null) goto L7;
        String r7 = ((com.bytedance.android.live.network.impl.interceptor.b) r0).a(true, r5, "", null);
        com.bytedance.android.live.network.b r1 = this.mCommonParamsInterceptor;
        com.bytedance.android.live.network.b.a r2 = new com.bytedance.android.live.network.b.a(r7, r6);
        ((com.bytedance.android.live.network.impl.interceptor.c) r1).c(r2);
        return this.mIHostNetwork.get(r2.a, r2.b);
    L7:
        return this.mIHostNetwork.get(r5, r6);
    }

    public static /* synthetic */ am3.c access$000(NetWorkService r0, Class r1, boolean r2) {
        return r0.getProtoDecoder(r1, r2);
    }

    public void asyncGet(String r1, List<NameValuePair> r2, LiveCallback<HttpResponse> r3) throws IOException {
        throw new IOException("no async get method！");
    }

    public LiveCall<HttpResponse> get(String r2, List<NameValuePair> r3, Boolean r4) throws IOException {
        if (r4.booleanValue() == false) goto L7;
        return get(r2, r3);
    L7:
        return this.mIHostNetwork.get(r2, r3, r4);
    }

    @Override // com.bytedance.android.live.network.api.INetworkService, com.bytedance.android.live.network.api.IMiddlewareNetworkService
    public void loadNinePatchDrawable(py.k r3, View r4, boolean r5, Runnable r6) {
        int r0 = com.bytedance.android.live.network.impl.utils.h.a;
        Intrinsics.checkNotNullParameter(r3, "imageModel");
        Intrinsics.checkNotNullParameter(r4, "view");
        if (Lists.isEmpty(r3.getUrls()) == true) goto L11;
        List r7 = r3.getUrls();
        if (r7 == null) goto L8;
        String r8 = (String) ListProtector.get(r7, 0);
    L9:
        Observable.just(0).subscribeOn(Schedulers.io()).map(new com.bytedance.android.live.network.impl.utils.e(r8)).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.network.impl.utils.f(r5, r4, r6), com.bytedance.android.live.network.impl.utils.g.a);
        return;
    L8:
        r8 = null;
        goto L9
    }

    public LiveCall<HttpResponse> post(String r3, List<NameValuePair> r4, String r5, byte[] r6) throws IOException {
        com.bytedance.android.live.network.b r0 = this.mCommonParamsInterceptor;
        if (r0 == null) goto L7;
        String r7 = ((com.bytedance.android.live.network.impl.interceptor.b) r0).a(false, r3, r5, r6);
        com.bytedance.android.live.network.b r1 = this.mCommonParamsInterceptor;
        com.bytedance.android.live.network.b.a r2 = new com.bytedance.android.live.network.b.a(r7, r4);
        ((com.bytedance.android.live.network.impl.interceptor.c) r1).c(r2);
        return this.mIHostNetwork.post(r2.a, r2.b, r5, r6);
    L7:
        return this.mIHostNetwork.post(r3, r4, r5, r6);
    }

    public void asyncPost(String r1, List<NameValuePair> r2, String r3, byte[] r4, LiveCallback<HttpResponse> r5) throws IOException {
        throw new IOException("no async post method！");
    }

    public LiveCall<HttpResponse> downloadFile(boolean r9, int r10, String r11, List<NameValuePair> r12, Object r13) throws IOException {
        com.bytedance.android.live.network.b r0 = this.mCommonParamsInterceptor;
        if (r0 == null) goto L7;
        com.bytedance.android.live.network.b.a r1 = new com.bytedance.android.live.network.b.a(r11, r12);
        ((com.bytedance.android.live.network.impl.interceptor.c) r0).c(r1);
        return this.mIHostNetwork.downloadFile(r9, r10, r1.a, r1.b, r13);
    L7:
        return this.mIHostNetwork.downloadFile(r9, r10, r11, r12, r13);
    }

    public LiveCall<HttpResponse> downloadFileStreaming(boolean r9, int r10, String r11, List<NameValuePair> r12, Object r13) throws IOException {
        if (((Boolean) LiveConfigSettingKeys.ALLOW_NO_COMMON_PARAM_FOR_DOWNLOAD.getValue()).booleanValue() == false) goto L6;
        if (r9 == true) goto L6;
    L11:
        return this.mIHostNetwork.downloadFileStreaming(r9, r10, r11, r12, r13);
    L6:
        com.bytedance.android.live.network.b r0 = this.mCommonParamsInterceptor;
        if (r0 == null) goto L11;
        com.bytedance.android.live.network.b.a r1 = new com.bytedance.android.live.network.b.a(r11, r12);
        ((com.bytedance.android.live.network.impl.interceptor.c) r0).c(r1);
        return this.mIHostNetwork.downloadFileStreaming(r9, r10, r1.a, r1.b, r13);
    }

    @Override // com.bytedance.android.live.network.api.IMiddlewareNetworkService
    public void interceptResponseBody(String r9, Object r10, String r11, String r12, String r13) throws Exception {
        if (y.a() == null) goto L6;
        y.a().e(r9, r10, r11, r12, r13, null);
        return;
    }

    public LiveCall<HttpResponse> post(String r7, List<NameValuePair> r8, String r9, byte[] r10, Boolean r11) throws IOException {
        if (r11.booleanValue() == false) goto L7;
        return post(r7, r8, r9, r10);
    L7:
        return this.mIHostNetwork.post(r7, r8, r9, r10, r11);
    }

    public LiveCall<HttpResponse> uploadLargeFile(int r9, String r10, List<NameValuePair> r11, File r12, UploadProgressListener r13) throws IOException {
        com.bytedance.android.live.network.b r0 = this.mCommonParamsInterceptor;
        if (r0 == null) goto L7;
        com.bytedance.android.live.network.b.a r1 = new com.bytedance.android.live.network.b.a(r10, r11);
        ((com.bytedance.android.live.network.impl.interceptor.c) r0).c(r1);
        return this.mIHostNetwork.uploadLargeFile(r9, r1.a, r1.b, r12, r13);
    L7:
        return this.mIHostNetwork.uploadLargeFile(r9, r10, r11, r12, r13);
    }

    public LiveWsBridge registerWsChannel(Context r9, String r10, Map<String, String> r11, Map<String, String> r12, OnLiveWsMessageReceiveListener r13, int r14, String r15) {
        return this.mIHostNetwork.registerWsChannel(r9, r10, r11, r12, r13, r14, r15);
    }

    public LiveCall<HttpResponse> uploadFile(int r13, String r14, List<NameValuePair> r15, String r16, byte[] r17, long r18, String r20) throws IOException {
        com.bytedance.android.live.network.b r1 = this.mCommonParamsInterceptor;
        if (r1 == null) goto L7;
        com.bytedance.android.live.network.b.a r2 = new com.bytedance.android.live.network.b.a(r14, r15);
        ((com.bytedance.android.live.network.impl.interceptor.c) r1).c(r2);
        return this.mIHostNetwork.uploadFile(r13, r2.a, r2.b, r16, r17, r18, r20);
    L7:
        return this.mIHostNetwork.uploadFile(r13, r14, r15, r16, r17, r18, r20);
    }
}
