package com.obric.aiproactive.impl.bridge;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Proxy;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Dns;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\f\u0010\u000b\u001a\u00020\u0005*\u00020\fH\u0002¨\u0006\u000e"}, d2 = {"Lcom/obric/aiproactive/impl/bridge/OkHttpRemoteArtifactTransport;", "Lcom/obric/aiproactive/impl/bridge/RemoteArtifactTransport;", "<init>", "()V", "execute", "Lcom/obric/aiproactive/impl/bridge/RemoteArtifactResponse;", "url", "Lokhttp3/HttpUrl;", "pinnedAddresses", "", "Ljava/net/InetAddress;", "toRemoteArtifactResponse", "Lokhttp3/Response;", "Companion", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class g implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6407a = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/aiproactive/impl/bridge/OkHttpRemoteArtifactTransport$Companion;", "", "<init>", "()V", "CONNECT_TIMEOUT_SECONDS", "", "READ_TIMEOUT_SECONDS", "CALL_TIMEOUT_SECONDS", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/obric/aiproactive/impl/bridge/OkHttpRemoteArtifactTransport$execute$pinnedDns$1", "Lokhttp3/Dns;", "lookup", "", "Ljava/net/InetAddress;", "hostname", "", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements Dns {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f6408a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<InetAddress> f6409b;

        b(String r3, List<? extends InetAddress> r4) {
            List<InetAddress> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            this.f6408a = r3;
            this.f6409b = r5;
        }

        @Override // okhttp3.Dns
        public List<InetAddress> lookup(String r3) {
            Intrinsics.checkNotNullParameter(r3, "hostname");
            if (StringsKt.equals(r3, this.f6408a, true) == false) goto L7;
            return this.f6409b;
        L7:
            throw new UnknownHostException("unexpected host");
        }
    }

    static {
        f6407a = new a(null);
    }

    public g() {
    }

    private final j a(Response r10) {
        ResponseBody r9 = r10.body();
        int r1 = r10.code();
        if (r9 == null) goto L7;
        MediaType r2 = r9.contentType();
        if (r2 == null) goto L7;
        String r3 = r2.toString();
    L8:
        if (r9 == null) goto L10;
        long r4 = r9.contentLength();
    L11:
        String r5 = Response.header$default(r10, "Location", null, 2, null);
        if (r9 == null) goto L14;
        InputStream r6 = r9.byteStream();
    L16:
        return new j(r1, r3, r4, r5, r6, (Function0) ZeusTransformUtils.preCheckCast(new OkHttpRemoteArtifactTransport$toRemoteArtifactResponse$1(r10), Function0.class, "com.obric.memorydata.plugin"));
    L14:
        r6 = null;
        goto L16
    L10:
        r4 = -1;
    L7:
        r3 = null;
        goto L8
    }

    @Override // com.obric.aiproactive.impl.bridge.k
    public j a(HttpUrl r6, List<? extends InetAddress> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "url");
        Intrinsics.checkNotNullParameter(r8, "pinnedAddresses");
        b r2 = new b(r6.host(), r8);
        return a(new OkHttpClient.Builder().followRedirects(false).followSslRedirects(false).proxy(Proxy.NO_PROXY).connectTimeout(10, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).callTimeout(45, TimeUnit.SECONDS).dns((Dns) ZeusTransformUtils.preCheckCast(r2, Dns.class, "com.obric.memorydata.plugin")).build().newCall(new Request.Builder().url(r6).get().build()).execute());
    }
}
