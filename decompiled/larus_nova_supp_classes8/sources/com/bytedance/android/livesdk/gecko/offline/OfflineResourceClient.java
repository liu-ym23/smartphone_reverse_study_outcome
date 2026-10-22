package com.bytedance.android.livesdk.gecko.offline;

import android.app.Application;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.android.live.base.model.NameValuePair;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostNetwork;
import com.bytedance.android.livesdkapi.model.HttpResponse;
import com.bytedance.geckox.net.INetWork;
import com.bytedance.ies.bullet.kit.resourceloader.i;
import com.bytedance.ies.bullet.service.base.d1;
import com.bytedance.ies.bullet.service.base.resourceloader.config.GeckoConfig;
import com.bytedance.ies.bullet.service.base.resourceloader.config.LoaderType;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import v26.j;
import v26.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class OfflineResourceClient {
    public static boolean a;
    public static final String b = null;
    public static final OfflineResourceClient c = null;

    public static final class NetWorkImpl implements INetWork {
        public final Lazy a;

        public NetWorkImpl() {
            this.a = LazyKt.lazy(OfflineResourceClient$NetWorkImpl$hostNetwork$2.INSTANCE);
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
            return b((HttpResponse) ((IMiddlewareHostNetwork) this.a.getValue()).get(r3, CollectionsKt.emptyList()).execute());
        }

        public final wy5.e doPost(String r9, List<Pair<String, String>> r10) {
            IMiddlewareHostNetwork r0 = (IMiddlewareHostNetwork) this.a.getValue();
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
            IMiddlewareHostNetwork r0 = (IMiddlewareHostNetwork) this.a.getValue();
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
            InputStream r10 = ((HttpResponse) ((IMiddlewareHostNetwork) this.a.getValue()).downloadFileStreaming(false, (int) r9, r8, CollectionsKt.emptyList(), null).execute()).getStream();
            if (r10 != null) goto L18;
            ALogger.e("ResourceLoaderService", "null stream!");
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

    public interface a {
        void onError(Throwable r1);

        void onSuccess(String r1);
    }

    public interface b {
        void a(d1 r1);

        void onError(Throwable r1);
    }

    public static final class c implements b {
        public final /* synthetic */ a a;

        public c(a r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.gecko.offline.OfflineResourceClient.b
        public final void a(d1 r2) {
            a r0 = this.a;
            if (r2 == null) goto L5;
            String r3 = r2.b;
        L6:
            r0.onSuccess(r3);
            return;
        L5:
            r3 = null;
            goto L6
        }

        @Override // com.bytedance.android.livesdk.gecko.offline.OfflineResourceClient.b
        public final void onError(Throwable r2) {
            this.a.onError(r2);
        }
    }

    public OfflineResourceClient() {
    }

    static {
        c = new OfflineResourceClient();
        b = g.a();
    }

    public static d1 e(String r5) {
        Intrinsics.checkNotNullParameter(r5, "url");
        l r0 = new l();
        v26.a r1 = new v26.a(false);
        r1.a(CollectionsKt.mutableListOf(new LoaderType[]{LoaderType.GECKO}));
        Unit r2 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r0.b = r1;
        return d(r5, r0);
    }

    public final synchronized void a(Application r18) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r18, "context");     // Catch: Throwable -> L28
        if (a == true) goto L26;
        ConcurrentHashMap r2 = i.a;     // Catch: Throwable -> L28
        boolean r3 = v.a();     // Catch: Throwable -> L28
        Intrinsics.checkNotNullParameter(r18, "application");     // Catch: Throwable -> L28
        y16.c.a("init ResourceLoader");     // Catch: Throwable -> L28
        i.b = r18;     // Catch: Throwable -> L28
        i.c = r3;     // Catch: Throwable -> L28
        GeckoConfig r0 = new GeckoConfig(b, g.b(), new com.bytedance.ies.bullet.kit.resourceloader.f(), false, false, 16, null);     // Catch: Throwable -> L28
        ALogger.i("OfflineResourceClient", "dir = " + g.b());     // Catch: Throwable -> L28
        IMiddleWareHostContext r4 = k.f(IMiddleWareHostContext.class);     // Catch: Throwable -> L28
        String r5 = null;
        if (r4 == null) goto L9;
        String r6 = String.valueOf(r4.appId());     // Catch: Throwable -> L28
    L10:
        String r8 = String.valueOf(r6);     // Catch: Throwable -> L28
        IMiddleWareHostContext r7 = k.f(IMiddleWareHostContext.class);     // Catch: Throwable -> L28
        if (r7 == null) goto L13;
        String r9 = r7.appName();     // Catch: Throwable -> L28
    L15:
        if (TextUtils.isEmpty(r9) == false) goto L17;
        r9 = "-1";
    L18:
        String r10 = r9;
        List r11 = CollectionsKt.mutableListOf(new String[]{"/obj/byte-gurd-source/10181/gecko/resource", "/obj/gecko-internal/10180/gecko/resource"});     // Catch: Throwable -> L28
        IMiddleWareHostContext r12 = k.f(IMiddleWareHostContext.class);     // Catch: Throwable -> L28
        if (r12 == null) goto L22;
        r5 = r12.getServerDeviceId();     // Catch: Throwable -> L28
    L22:
        if (TextUtils.isEmpty(r5) == false) goto L24;
        String r13 = "0";
    L25:
        Intrinsics.checkNotNull(r13);     // Catch: Throwable -> L28
        j r1 = new j("gecko.zijieapi.com", "CN", r11, r8, r10, r13, r0, null, new com.bytedance.ies.bullet.kit.resourceloader.c(), new NetWorkImpl(), new NetWorkImpl(), 2176);     // Catch: Throwable -> L28
        r1.n = true;     // Catch: Throwable -> L28
        r1.o = true;     // Catch: Throwable -> L28
        r1.m = 300000;     // Catch: Throwable -> L28
        i.a("live", r1);     // Catch: Throwable -> L28
        a = true;     // Catch: Throwable -> L28
        goto L26
    L24:
        r13 = r5;
        goto L25
    L17:
        Intrinsics.checkNotNull(r9);     // Catch: Throwable -> L28
        goto L18
    L13:
        r9 = null;
        goto L15
    L9:
        r6 = null;
    L26:
        monitor-exit(this);
        return;
    L28:
        th = move-exception;
        throw th;
    }

    public static void c(String r5, a r6) {
        Intrinsics.checkNotNullParameter(r5, "url");
        Intrinsics.checkNotNullParameter(r6, "callback");
        l r0 = new l();
        v26.a r1 = new v26.a(false);
        r1.a(CollectionsKt.mutableListOf(new LoaderType[]{LoaderType.GECKO, LoaderType.CDN}));
        Unit r2 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r0.b = r1;
        b(r5, r0, new c(r6));
    }

    public static d1 d(String r2, l r3) {
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r3, "config");
        String r0 = g.a();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r3.a = r0;
        d1 r4 = i.b("live", 2).h(r2, r3);
        StringBuilder r1 = new StringBuilder("url= ");
        r1.append(r2);
        r1.append(", resourceInfo = ");
        if (r4 == null) goto L5;
        String r5 = r4.toString();
    L6:
        r1.append(r5);
        ALogger.i("OfflineResourceClient", r1.toString());
        return r4;
    L5:
        r5 = null;
        goto L6
    }

    public static void b(String r3, l r4, final b r5) {
        Intrinsics.checkNotNullParameter(r3, "url");
        Intrinsics.checkNotNullParameter(r4, "config");
        Intrinsics.checkNotNullParameter(r5, "callback");
        String r0 = g.a();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r4.a = r0;
        i.b("live", 2).g(r3, r4, new OfflineResourceClient$loadAsync$1(r5), new OfflineResourceClient$loadAsync$2(r5));
    }
}
