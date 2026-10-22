package com.larus.agents.impl.webfetch;

import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.ttnet.http.RequestContext;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.larksuite.framework.http.request.HttpHeaders;
import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f implements w {
    public volatile WebPageFetchApi a;

    public static final class a {
    }

    static {
    }

    public f() {
    }

    @Override // com.larus.agents.impl.webfetch.w
    public final g a(String r12, boolean r13, double r14) {
        Intrinsics.checkNotNullParameter(r12, "url");
        int r0 = h.e;
        h r1 = h.a.a();
        List r2 = CollectionsKt.createListBuilder();
        r2.add(new Header("x-metasec-bypass-ttnet-features", "1"));
        r2.add(new Header("x-tt-bypass-dp", "1"));
        r2.add(new Header("x-metasec-bypass-mssdk", "1"));
        if (r13 == true) goto L5;
        r2.add(new Header("x-ttnet-bypass-cookie", "0"));
    L5:
        String r3 = r1.a;
        if (StringsKt.isBlank(r3) == false) goto L8;
        r3 = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_6) AppleWebKit/537.36 (KHTML, like Gecko)  Chrome/91.0.4450.0";
    L8:
        r2.add(new Header(HttpHeaders.HEAD_KEY_USER_AGENT, r3));
        String r4 = r1.b;
        if (StringsKt.isBlank(r4) == false) goto L11;
        r4 = "text/html, application/xhtml+xml";
    L11:
        r2.add(new Header(HttpHeaders.HEAD_KEY_ACCEPT, r4));
        List<Header> r5 = CollectionsKt.build(r2);
        long r15 = RangesKt.coerceAtLeast((long) (r14 * TimeUnit.SECONDS.toMillis(1)), 1);
        RequestContext r6 = new RequestContext();
        ((BaseRequestContext) r6).followRedirectInternal = false;
        ((BaseRequestContext) r6).force_handle_response = true;
        ((BaseRequestContext) r6).isCustomizedCookie = !r13;
        ((BaseRequestContext) r6).timeout_connect = r15;
        ((BaseRequestContext) r6).timeout_read = r15;
        ((BaseRequestContext) r6).timeout_write = r15;
        WebPageFetchApi r16 = this.a;
        if (r16 != null) goto L23;
        monitor-enter(this);
        r16 = this.a;     // Catch: Throwable -> L19
        if (r16 != null) goto L17;
        URI r17 = new URI(r12);     // Catch: Throwable -> L19
        Object r19 = RetrofitUtils.createSsRetrofit(new URI(r17.getScheme(), null, r17.getHost(), r17.getPort(), "/", null, null).toASCIIString(), CollectionsKt.emptyList(), null).create(WebPageFetchApi.class);     // Catch: Throwable -> L19
        this.a = (WebPageFetchApi) r19;     // Catch: Throwable -> L19
        r16 = (WebPageFetchApi) r19;     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);
    L19:
        th = move-exception;
        throw th;
    L23:
        return new g(r16.fetch(r12, false, r5, r6));
    }
}
