package com.bytedance.android.live.network.impl.utils;

import am2.v;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.NameValuePair;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.network.MonitorTimeCostCallAdapterFactory;
import com.bytedance.android.live.network.MonitorTimeCostCallAdapterFactoryV2;
import com.bytedance.android.live.network.MonitorTimeCostRequestConverterFactory;
import com.bytedance.android.live.network.NetworkSettingKeys;
import com.bytedance.android.live.network.PbAnnotationCallAdapterFactory;
import com.bytedance.android.live.network.PbAnnotationCallAdapterFactoryV2;
import com.bytedance.android.live.network.PbRequestCallAdapter;
import com.bytedance.android.live.network.PbRequestCallAdapterV2;
import com.bytedance.android.live.network.api.INetworkService;
import com.bytedance.android.live.network.impl.factory.MultiTypeRequestConverterFactory;
import com.bytedance.android.live.network.impl.interceptor.FuseRequestAdaptorInterceptor;
import com.bytedance.android.live.network.impl.interceptor.p;
import com.bytedance.android.live.network.impl.interceptor.r;
import com.bytedance.android.live.network.impl.interceptor.w;
import com.bytedance.android.live.network.impl.interceptor.y;
import com.bytedance.android.live.network.impl.interceptor.z;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livehostapi.foundation.IHostNetwork;
import com.bytedance.android.livehostapi.foundation.depend.LiveCall;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdk.config.LiveInitSettingKeys;
import com.bytedance.android.livesdk.config.a21;
import com.bytedance.android.livesdk.config.ge;
import com.bytedance.android.livesdk.config.link.LinkRequestMonitorConfig;
import com.bytedance.android.livesdk.config.mc0;
import com.bytedance.android.livesdk.config.n71;
import com.bytedance.android.livesdk.config.pc0;
import com.bytedance.android.livesdk.config.z11;
import com.bytedance.android.livesdk.config.z7;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.model.NetworkApmSetting;
import com.bytedance.android.livesdk.projectmode.ILiveSdkProjectModeService;
import com.bytedance.android.livesdkapi.model.HttpResponse;
import com.bytedance.android.livesdkapi.network.ILiveRetrofitWrapper;
import com.bytedance.android.openlive.realtime.IUserRealtimeSignalFeature;
import com.bytedance.frameworks.baselib.network.http.retrofit.SsHttpExecutor;
import com.bytedance.retrofit2.CallAdapter;
import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.client.Client;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.rxjava2.adapter.RxJava2CallAdapterFactory;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class RetrofitProvider implements com.bytedance.android.live.a {
    private static final String TAG = "RetrofitProvider";

    public class a extends com.bytedance.android.live.network.impl.utils.a {
        public LiveCall a;
        public final /* synthetic */ Request b;
        public final /* synthetic */ IHostNetwork c;

        /* JADX INFO: renamed from: com.bytedance.android.live.network.impl.utils.RetrofitProvider$a$a, reason: collision with other inner class name */
        public class C0137a implements TypedInput {
            public final /* synthetic */ HttpResponse a;

            public final InputStream in() throws IOException {
                InputStream r0 = this.a.getStream();
                if (r0 == null) goto L5;
                return r0;
            L5:
                byte[] r1 = this.a.getBody();
                if (r1 != null) goto L10;
                return null;
            L10:
                return new ByteArrayInputStream(r1);
            }

            public final long length() throws IOException {
                InputStream r0 = this.a.getStream();
                if (r0 != null) goto L5;
                byte[] r1 = this.a.getBody();
                if (r1 != null) goto L10;
                return 0;
            L10:
                return r1.length;
            L5:
                return r0.available();
            }

            public final String mimeType() {
                return this.a.getMimeType();
            }

            public C0137a(HttpResponse r1) {
                this.a = r1;
            }
        }

        public final void cancel() {
            LiveCall r0 = this.a;
            if (r0 == null) goto L11;
            r0.cancel();     // Catch: IOException -> L6
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
            return;
        }

        public final Response execute() throws IOException {
            long r1 = System.currentTimeMillis();
            String r3 = this.b.getMethod();
            a21 r6 = null;
            boolean r7 = true;
            if ("GET".equals(r3) == false) goto L5;
        L8:
            Request r5 = this.b;
            MonitorTimeCostCallAdapterFactory.c.getClass();
            Intrinsics.checkNotNullParameter(r5, "request");
            String r8 = (String) ((ConcurrentHashMap) MonitorTimeCostCallAdapterFactory.b).remove(MonitorTimeCostCallAdapterFactory.b.a(r5));
            if (r8 != null) goto L11;
        L13:
            boolean r9 = false;
        L14:
            ArrayList r13 = new ArrayList();
            List r10 = this.b.getHeaders();
            if (r10 == null) goto L26;
            Iterator r11 = r10.iterator();
        L18:
            if (r11.hasNext() == false) goto L26;
            Header r12 = (Header) r11.next();
            if (((Boolean) NetworkSettingKeys.ENABLE_PB_REQUESTS.getValue()).booleanValue() == false) goto L23;
            if (r9 == true) goto L23;
        L25:
            r13.add(new NameValuePair(r12.getName(), r12.getValue()));
        L23:
            if (TextUtils.equals(r12.getName(), "response-format") == false) goto L25;
        L26:
            r13.add(new NameValuePair("W-Ab-Cut-Group", String.valueOf(NetworkSettingKeys.LIVE_NETWORK_AB_CUT_GROUP.getValue())));
            HashMap r14 = new HashMap();
            if (bo0.a.a() == false) goto L70;
            String r15 = this.b.getPath();
            if (r15.endsWith("/") == false) goto L31;
            r15 = r15.substring(0, r15.length() - 1);
        L31:
            Intrinsics.checkNotNullParameter(r15, "path");
            z11 r16 = bo0.a.b;
            Map r17 = r16.a();
            if (r17 != null) goto L34;
        L37:
            if (r7 == true) goto L43;
            Map r18 = r16.a();
            if (r18 == null) goto L43;
            r6 = (a21) r18.get(r15);
        L43:
            if (TextUtils.equals("GET", r3) == false) goto L54;
            if (r6 == null) goto L53;
            r14.put("path", this.b.getPath());
            if (r6.b() == false) goto L52;
            r14.put("meet_uplink", "1");
            com.ss.ugc.live.sdk.platform.a.f.getClass();
            if (r6.a() == true) goto L51;
            r14.put("actual_channel", "1");
            goto L53
        L51:
            throw new IOException("byte link only!");
        L52:
            r14.put("meet_uplink", "0");
        L53:
            this.a = this.c.get(this.b.getUrl(), r13);
            Object r19 = "1";
            Object r20 = "0";
        L80:
            long r4 = System.currentTimeMillis();
            bo0.a.a();
            HttpResponse r110 = (HttpResponse) this.a.execute();
            if (bo0.a.a() == true) goto L83;
        L89:
            if (r8 == null) goto L91;
            long r2 = System.currentTimeMillis() - r4;
            HashMap r21 = new HashMap(4);
            r21.put("scene", r8);
            r21.put("duration", String.valueOf(r2));
            u.l().sendLog("network_request_receiving_time_cost", r21, new Object[0]);
        L91:
            ArrayList r111 = new ArrayList();
            if (r110.getHeaders() == null) goto L103;
            Iterator r22 = r110.getHeaders().iterator();
            long r112 = 0;
            long r113 = 0;
        L95:
            if (r22.hasNext() == false) goto L105;
            NameValuePair r23 = (NameValuePair) r22.next();
            r111.add(new Header(r23.getName(), r23.getValue()));
            if ("Webcast-Ntp-T2".equalsIgnoreCase(r23.getName()) == false) goto L100;
            r113 = d.a(r23.getValue());
            goto L95
        L100:
            if ("Webcast-Ntp-T3".equalsIgnoreCase(r23.getName()) == false) goto L95;
            r112 = d.a(r23.getValue());
        L105:
            if (r113 <= 0) goto L110;
            if (r112 <= 0) goto L110;
            int r24 = com.bytedance.android.livesdk.utils.ntp.a.b;
            long r114 = r113 - r4;
            long r25 = 2;
            com.bytedance.android.livesdk.utils.ntp.a.a = (r114 - (System.currentTimeMillis() - r112)) / r25;
            long r26 = System.currentTimeMillis();
            int r27 = com.ss.ugc.live.sdk.msg.utils.f.b;
            com.ss.ugc.live.sdk.msg.utils.f.a = (r114 - (r26 - r112)) / r25;
        L110:
            if (this.b.isResponseStreaming() == false) goto L112;
            C0137a r28 = new C0137a(r110);
        L113:
            Response r29 = new Response(r110.getUrl(), r110.getStatusCode(), r110.getReason(), r111, r28);
            r29.setExtraInfo(r110.getExtraInfo());
            return r29;
        L112:
            r28 = new TypedByteArray(r110.getMimeType(), r110.getBody(), new String[0]);
            goto L113
        L103:
            r112 = 0;
            r113 = 0;
            goto L105
        L83:
            if (r14.isEmpty() == true) goto L89;
            if (r110.getStatusCode() != 200) goto L87;
            Object r115 = r19;
        L88:
            r14.put("success", r115);
            r14.put("duration", String.valueOf(System.currentTimeMillis() - r1));
            u.l().sendLog("livesdk_api_uplink_agent_quality", r14, new Object[0]);
            goto L89
        L87:
            r115 = r20;
            goto L88
        L54:
            if (r6 == null) goto L63;
            r14.put("path", this.b.getPath());
            if (r6.b() == false) goto L62;
            r14.put("meet_uplink", "1");
            com.ss.ugc.live.sdk.platform.a.f.getClass();
            if (r6.a() == true) goto L61;
            r14.put("actual_channel", "1");
            goto L63
        L61:
            throw new IOException("byte link only!");
        L62:
            r14.put("meet_uplink", "0");
        L63:
            ByteArrayOutputStream r30 = new ByteArrayOutputStream();
            if (this.b.getBody() == null) goto L67;
            this.b.getBody().writeTo(r30);
        L67:
            if ((this.b.getBody() instanceof MultipartTypedOutput) == false) goto L69;
            r19 = "1";
            r20 = "0";
            this.a = this.c.uploadFile(this.b.getMaxLength(), this.b.getUrl(), r13, this.b.getBody().mimeType(), r30.toByteArray(), this.b.getBody().length(), this.b.getBody().md5Stub());
            goto L80
        L69:
            r19 = "1";
            r20 = "0";
            this.a = this.c.post(this.b.getUrl(), r13, this.b.getBody().mimeType(), r30.toByteArray());
            goto L80
        L34:
            if (r17.isEmpty() == true) goto L37;
            r7 = false;
            goto L37
        L70:
            r19 = "1";
            r20 = "0";
            if (TextUtils.equals("GET", r3) == false) goto L73;
            this.a = this.c.get(this.b.getUrl(), r13);
            goto L80
        L73:
            ByteArrayOutputStream r31 = new ByteArrayOutputStream();
            if (this.b.getBody() == null) goto L77;
            this.b.getBody().writeTo(r31);
        L77:
            if ((this.b.getBody() instanceof MultipartTypedOutput) == false) goto L79;
            this.a = this.c.uploadFile(this.b.getMaxLength(), this.b.getUrl(), r13, this.b.getBody().mimeType(), r31.toByteArray(), this.b.getBody().length(), this.b.getBody().md5Stub());
            goto L80
        L79:
            this.a = this.c.post(this.b.getUrl(), r13, this.b.getBody().mimeType(), r31.toByteArray());
            goto L80
        L11:
            if (((Boolean) pc0.a.getValue()).booleanValue() == false) goto L13;
            r9 = true;
            goto L14
        L5:
            if ("POST".equals(r3) == true) goto L8;
            LocalTestManager.a(new Class[]{wy.a.class});
            ALogger.e(RetrofitProvider.TAG, "REQUEST NOT GET OR POST");
            return null;
        }

        public final Request getRequest() {
            return this.b;
        }

        public a(Request r1, IHostNetwork r2) {
            this.b = r1;
            this.c = r2;
        }
    }

    public RetrofitProvider() {
    }

    public static /* synthetic */ Client a(Client r0) {
        return lambda$getRetrofitInstance$1(r0);
    }

    public static /* synthetic */ SsCall b(RetrofitProvider r0, IHostNetwork r1, Request r2) {
        return r0.lambda$getRetrofitInstance$0(r1, r2);
    }

    private static /* synthetic */ Client lambda$getRetrofitInstance$1(Client r0) {
        return r0;
    }

    public List<Interceptor> getCustomInterceptors() {
        return null;
    }

    public static List<CallAdapter.Factory> getLiveCallAdapters() {
        ArrayList r0 = new ArrayList();
        r0.add(new MonitorTimeCostCallAdapterFactoryV2(new PbAnnotationCallAdapterFactoryV2(RxJava2CallAdapterFactory.createAsync())));
        return r0;
    }

    public static List<Converter.Factory> getLiveConverters() {
        ArrayList r0 = new ArrayList();
        r0.add(new MonitorTimeCostRequestConverterFactory(new MultiTypeRequestConverterFactory(new rx5.a(NetworkGson.a()))));
        r0.add(new com.bytedance.android.live.network.f());
        return r0;
    }

    public static List<Interceptor> getLiveInterceptors() {
        ArrayList r0 = new ArrayList();
        if (com.bytedance.android.live.network.impl.interceptor.a.b == null) goto L5;
    L14:
        r0.add(com.bytedance.android.live.network.impl.interceptor.a.b);
        r0.add(y.a());
        v r1 = LiveInitSettingKeys.get_LIVE_LOGSDK_CONFIG();
        if (r1.c() == false) goto L18;
        r0.add(new w(r1.d()));
    L18:
        if (((NetworkApmSetting) mc0.a.getValue()).a() == false) goto L21;
        r0.add(z.a.a);
    L21:
        if (((LinkRequestMonitorConfig) z7.a.getValue()).getEnable() == false) goto L24;
        r0.add(new r());
    L24:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L28;
        ILiveSdkProjectModeService r2 = jc1.k.f(ILiveSdkProjectModeService.class);
        if (r2 == null) goto L28;
        r0.addAll(r2.getInterceptors());
    L28:
        String r3 = at2.c.a;
        r0.add(at2.a.a);
        List<Interceptor> r4 = new RetrofitProvider().getCustomInterceptors();
        if (r4 == null) goto L36;
        Iterator r5 = new ArrayList(r4).iterator();
    L32:
        if (r5.hasNext() == false) goto L36;
        Interceptor r6 = (Interceptor) r5.next();
        if (r6 == null) goto L32;
        r0.add(r6);
    L36:
        r0.add(new p());
        return r0;
    L5:
        monitor-enter(com.bytedance.android.live.network.impl.interceptor.a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (com.bytedance.android.live.network.impl.interceptor.a.b != null) goto L9;
        com.bytedance.android.live.network.impl.interceptor.a.b = new com.bytedance.android.live.network.impl.interceptor.a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(com.bytedance.android.live.network.impl.interceptor.a.class);     // Catch: Throwable -> L11
        goto L14
    }

    public Retrofit getRetrofitInstance() {
        return getRetrofitInstance("https://" + ((INetworkService) jc1.k.f(INetworkService.class)).getHostDomain());
    }

    public ILiveRetrofitWrapper getRetrofitInstanceV2() {
        PbRequestCallAdapterV2.a r0 = PbRequestCallAdapterV2.f;
        com.bytedance.android.live.network.d r1 = new com.bytedance.android.live.network.d((String) NetworkSettingKeys.PB_REQUEST_SWITCHES.getValue(), 2, ((Boolean) NetworkSettingKeys.PB_REQUEST_STRATEGY.getValue()).booleanValue());
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        PbRequestCallAdapterV2.c = r1;
        return jc1.k.f(IHostNetwork.class).getRetrofitInstanceV2();
    }

    private void appendRealtimeSignalInterceptor(Retrofit.Builder r4) {
        SettingKey r0 = LiveConfigSettingKeys.LIVE_REAL_TIME_SIGNAL_CONFIG_SETTING_KEY;
        if (((n71) r0.getValue()).f() == false) goto L10;
        IUserRealtimeSignalFeature r1 = jc1.k.f(IUserRealtimeSignalFeature.class);
        if (r1 == null) goto L11;
        r4.addInterceptor(r1.getFeedApiInterceptor());
        if (((n71) r0.getValue()).e() == false) goto L12;
        r4.addInterceptor(r1.getDislikeInterceptor());
        return;
    L12:
        return;
    L11:
        return;
    }

    public Retrofit getRetrofitInstance(String r2) {
        return getRetrofitInstance(r2, true);
    }

    private /* synthetic */ SsCall lambda$getRetrofitInstance$0(IHostNetwork r2, Request r3) throws IOException {
        return new a(r3, r2);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.bytedance.android.live.network.impl.utils.j] */
    public Retrofit getRetrofitInstance(String r7, boolean r8) {
        final IHostNetwork r0 = jc1.k.f(INetworkService.class);
        final ?? r1 = new j(this, r0);
        PbRequestCallAdapter.a r2 = PbRequestCallAdapter.f;
        com.bytedance.android.live.network.d r3 = new com.bytedance.android.live.network.d((String) NetworkSettingKeys.PB_REQUEST_SWITCHES.getValue(), 2, ((Boolean) NetworkSettingKeys.PB_REQUEST_STRATEGY.getValue()).booleanValue());
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        PbRequestCallAdapter.c = r3;
        Retrofit.Builder r9 = new Retrofit.Builder().setEndpoint(r7).client(new k(r1)).addCallAdapterFactory(new MonitorTimeCostCallAdapterFactory(new PbAnnotationCallAdapterFactory(RxJava2CallAdapterFactory.createAsync()))).addConverterFactory(new com.bytedance.android.live.network.f()).addConverterFactory(new MonitorTimeCostRequestConverterFactory(new zn0.c(new MultiTypeRequestConverterFactory(new rx5.a(NetworkGson.a())))));
        if (r8 == true) goto L5;
    L17:
        r9.addInterceptor(y.a()).httpExecutor(new SsHttpExecutor());
        r9.addInterceptor(FuseRequestAdaptorInterceptor.j);
        v r10 = LiveInitSettingKeys.get_LIVE_LOGSDK_CONFIG();
        if (r10.c() == false) goto L21;
        r9.addInterceptor(new w(r10.d()));
    L21:
        if (((NetworkApmSetting) mc0.a.getValue()).a() == false) goto L23;
        r9.addInterceptor(z.a.a);
    L23:
        int r11 = c.a;
        if (((com.bytedance.android.livesdk.model.i) ge.a.getValue()).a() == false) goto L26;
        r9.addInterceptor(com.bytedance.android.live.network.impl.interceptor.d.a);
    L26:
        r9.addInterceptor(new zn0.d());
        if (((LinkRequestMonitorConfig) z7.a.getValue()).getEnable() == false) goto L30;
        r9.addInterceptor(new r());
    L30:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L34;
        ILiveSdkProjectModeService r12 = jc1.k.f(ILiveSdkProjectModeService.class);
        if (r12 == null) goto L34;
        r12.addLocalTestInterceptor(r9);
    L34:
        IHostContext r13 = jc1.k.f(IHostContext.class);
        if (r13 != null) goto L37;
    L41:
        appendRealtimeSignalInterceptor(r9);
        List<Interceptor> r14 = getCustomInterceptors();
        if (r14 == null) goto L50;
        Iterator r15 = new ArrayList(r14).iterator();
    L45:
        if (r15.hasNext() == false) goto L50;
        Interceptor r4 = (Interceptor) r15.next();
        if (r4 == null) goto L45;
        r9.addInterceptor(r4);
    L50:
        return r9.build();
    L37:
        if (r13.hasSandboxRecord() == false) goto L41;
        Interceptor r16 = r13.getSandboxInterceptor();
        if (r16 == null) goto L41;
        r9.addInterceptor(r16);
        goto L41
    L5:
        if (com.bytedance.android.live.network.impl.interceptor.a.b == null) goto L7;
    L16:
        r9.addInterceptor(com.bytedance.android.live.network.impl.interceptor.a.b);
        goto L17
    L7:
        monitor-enter(com.bytedance.android.live.network.impl.interceptor.a.class);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (com.bytedance.android.live.network.impl.interceptor.a.b != null) goto L11;
        com.bytedance.android.live.network.impl.interceptor.a.b = new com.bytedance.android.live.network.impl.interceptor.a();     // Catch: Throwable -> L13
    L11:
        monitor-exit(com.bytedance.android.live.network.impl.interceptor.a.class);     // Catch: Throwable -> L13
        goto L16
    }
}
