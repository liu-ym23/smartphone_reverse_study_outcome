package com.bytedance.android.annie.resource;

import android.net.Uri;
import android.util.Pair;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.service.network.IAnnieNetworkService;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.geckox.GeckoClient;
import com.bytedance.geckox.GeckoConfig;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.net.INetWork;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AnnieGeckoClient {
    public final g a;
    public final PolarisFileWrapper b;
    public final GeckoClient c;
    public final nv5.e d;
    public final qv5.b e;
    public final String f;
    public final String g;
    public final String h;

    public static final class NetWorkImpl implements INetWork {
        public final Lazy a;

        public NetWorkImpl() {
            this.a = LazyKt.lazy(AnnieGeckoClient$NetWorkImpl$hostNetwork$2.INSTANCE);
        }

        public static wy5.e b(com.bytedance.android.annie.service.network.d r10) {
            LinkedHashMap r0 = new LinkedHashMap();
            Iterator<T> r1 = r10.b.iterator();
        L4:
            if (r1.hasNext() == false) goto L7;
            Pair r11 = (Pair) r1.next();
            r0.put(r11.first, r11.second);
            goto L4
        L7:
            return new wy5.e(r0, new String(r10.c, Charsets.UTF_8), r10.a, r10.e);
        }

        public final wy5.e doGet(String r10) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
            return b(((IAnnieNetworkService) this.a.getValue()).get(r10, CollectionsKt.emptyList()).execute());
        }

        public final wy5.e doPost(String r10, List<Pair<String, String>> r11) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
            IAnnieNetworkService r0 = (IAnnieNetworkService) this.a.getValue();
            List<Pair<String, String>> r1 = CollectionsKt.emptyList();
            ByteArrayOutputStream r12 = new ByteArrayOutputStream();
            if (r11 == null) goto L14;
            Iterator<T> r13 = r11.iterator();
        L6:
            if (r13.hasNext() == false) goto L14;
            Pair r14 = (Pair) r13.next();
            if (r12.size() <= 0) goto L10;
            r12.write(38);
        L10:
            String r15 = URLEncoder.encode((String) r14.first, "UTF-8");
            String r16 = (String) r14.second;
            if (r16 != null) goto L13;
            r16 = "";
        L13:
            String r17 = URLEncoder.encode(r16, "UTF-8");
            r12.write(r15.getBytes(Charset.forName("UTF-8")));
            r12.write(61);
            r12.write(r17.getBytes(Charset.forName("UTF-8")));
        L14:
            Unit r18 = Unit.INSTANCE;
            return b(r0.post(r10, r1, "application/x-www-form-urlencoded; charset=UTF-8", r12.toByteArray()).execute());
        }

        public final wy5.e doPost(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
            IAnnieNetworkService r0 = (IAnnieNetworkService) this.a.getValue();
            List<Pair<String, String>> r1 = CollectionsKt.emptyList();
            if (r11 == null) goto L6;
            byte[] r12 = r11.getBytes(Charsets.UTF_8);
            if (r12 == null) goto L6;
        L8:
            return b(r0.post(r10, r1, "application/json; charset=UTF-8", r12).execute());
        L6:
            r12 = new byte[0];
            goto L8
        }

        public final void downloadFile(String r10, long r11, py5.b r12) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
            if (r12 != null) goto L5;
            return;
        L5:
            InputStream r13 = ((IAnnieNetworkService) this.a.getValue()).downloadFileStreaming(false, (int) r11, r10, CollectionsKt.emptyList(), null).execute().d;
            if (r13 != null) goto L17;
            x8.a.b("AnnieGeckoClientImpl", "null stream!", false);
            return;
        L17:
            ByteStreamsKt.copyTo(r13, r12, 2048);     // Catch: Throwable -> L10
            CloseableKt.closeFinally(r13, null);
            return;
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            CloseableKt.closeFinally(r13, th);
            throw th;
        }
    }

    public static final class a {
    }

    public static final class b implements Executor {

        public static final class a<T> implements Consumer {
            public final /* synthetic */ Runnable a;

            public a(Runnable r1) {
                this.a = r1;
            }

            public final void accept(Object r1) {
                Runnable r10 = (Runnable) r1;
                Runnable r11 = this.a;
                if (r11 == null) goto L6;
                r11.run();
                return;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.annie.resource.AnnieGeckoClient$b$b, reason: collision with other inner class name */
        public static final class C0078b<T> implements Consumer {
            public static final C0078b<T> a = null;

            static {
                a = new C0078b();
            }

            public C0078b() {
            }

            public final /* bridge */ /* synthetic */ void accept(Object r1) {
                Throwable r10 = (Throwable) r1;
            }
        }

        public b() {
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable r10) {
            Single.just(r10).subscribeOn(Schedulers.io()).subscribe(new a(r10), C0078b.a);
        }
    }

    static {
    }

    public AnnieGeckoClient(g r10) {
        Intrinsics.checkNotNullParameter(r10, "mGeckoConfig");
        this.a = r10;
        x8.a.d("AnnieGeckoClientImpl", "init start", false);
        String r1 = m.b();
        this.f = r1;
        String r11 = m.c();
        this.h = r11;
        PolarisFileWrapper r12 = new PolarisFileWrapper(r11);
        this.b = r12;
        String r13 = m.a(r10);
        this.g = r13;
        if (com.bytedance.android.annie.ng.g.b().a.a == false) goto L5;
        GeckoLogger.enable();
    L5:
        GeckoConfig.Builder r14 = new GeckoConfig.Builder(com.bytedance.android.annie.ng.g.a());
        r14.accessKey(new String[]{r13});
        r14.allLocalAccessKeys(new String[]{r13});
        com.bytedance.android.annie.ng.g.b().getClass();
        o8.a r15 = com.bytedance.android.annie.ng.e.a;
        r14.appVersion(r15.d);
        com.bytedance.android.annie.ng.g.b().getClass();
        r14.appId(r15.a);
        r14.host("gecko.zijieapi.com");
        r14.deviceId(r1);
        r14.resRootDir(r12);
        r14.netStack(new NetWorkImpl());
        b r16 = new b();
        r14.checkUpdateExecutor(r16);
        r14.updateExecutor(r16);
        this.c = GeckoClient.create(r14.build());
        ArrayList r17 = new ArrayList();
        Iterator<T> r18 = AnnieConfigSettingKeys.LIVE_OFFLINE_PATTERNS.a().iterator();
    L7:
        if (r18.hasNext() == false) goto L9;
        r17.add(PatternProtector.compile((String) r18.next()));
        goto L7
    L9:
        nv5.f.a r19 = new nv5.f.a(com.bytedance.android.annie.ng.g.a());
        r19.b = this.g;
        r19.f = r17;
        r19.g = CollectionsKt.mutableListOf(new Uri[]{Uri.fromFile(this.b)});
        r19.i = "gecko.zijieapi.com";
        r19.h = this.f;
        r19.j = "cn";
        this.d = new nv5.e(new nv5.f(r19));
        this.e = new qv5.b(com.bytedance.android.annie.ng.g.a(), this.g, this.b);
        if (this.a.d == false) goto L23;
        LinkedHashMap r20 = new LinkedHashMap();
        r20.put(this.g, CollectionsKt.emptyList());
        Map<String, ? extends Object> r21 = this.a.c;
        if (r21 == null) goto L18;
        LinkedHashMap r22 = new LinkedHashMap();
        LinkedHashMap r23 = new LinkedHashMap();
        Iterator<Map.Entry<String, ? extends Object>> r24 = r21.entrySet().iterator();
    L15:
        if (r24.hasNext() == false) goto L17;
        Map.Entry<String, ? extends Object> r25 = r24.next();
        r23.put(r25.getKey(), r25.getValue());
        goto L15
    L17:
        Map r26 = (Map) r22.put(this.g, r23);
    L19:
        g r27 = this.a;
        if (r27.b == false) goto L22;
        OptionCheckUpdateParams r28 = new OptionCheckUpdateParams().setCustomParam(r22).setEnableThrottle(false);
        GeckoClient r29 = this.c;
        String r30 = this.a.a;
        LinkedHashMap r31 = new LinkedHashMap();
        r31.put(this.g, CollectionsKt.emptyList());
        Unit r32 = Unit.INSTANCE;
        r29.checkUpdateMulti(r30, r31, r28);
        goto L23
    L22:
        this.c.checkUpdateMulti(r27.a, r20);
        goto L23
    L18:
        r22 = null;
    L23:
        f9.b r33 = (f9.b) Annie.getService$default(f9.b.class, null, 2, null);
        ArrayList r34 = new ArrayList();
        Iterator<T> r35 = AnnieConfigSettingKeys.LIVE_GURD_PATTERNS.a().iterator();
    L25:
        if (r35.hasNext() == false) goto L27;
        r34.add(PatternProtector.compile((String) r35.next()));
        goto L25
    L27:
        r33.setCachePrefix(r34);
        x8.a.d("AnnieGeckoClientImpl", "init end", false);
    }
}
