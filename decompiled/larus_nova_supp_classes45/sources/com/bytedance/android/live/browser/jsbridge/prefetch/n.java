package com.bytedance.android.live.browser.jsbridge.prefetch;

import com.bytedance.android.live.network.api.INetworkService;
import com.bytedance.android.livesdkapi.model.HttpResponse;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n<V> implements Callable {
    public final /* synthetic */ PrefetchNetworkExecutorImpl a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Map c;
    public final /* synthetic */ Map d;
    public final /* synthetic */ com.bytedance.android.live.browser.jsbridge.protobuf.a e;
    public final /* synthetic */ JSONObject f;

    public n(PrefetchNetworkExecutorImpl r1, String r2, Map r3, Map r4, com.bytedance.android.live.browser.jsbridge.protobuf.a r5, JSONObject r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    @Override // java.util.concurrent.Callable
    public final com.bytedance.ies.tools.prefetch.i.b call() {
        PrefetchNetworkExecutorImpl r0 = this.a;
        INetworkService r1 = jc1.k.n(INetworkService.class);
        String r2 = this.b;
        PrefetchNetworkExecutorImpl r3 = this.a;
        Map r4 = this.c;
        Map r5 = this.d;
        if (this.e != null) goto L5;
        boolean r6 = true;
    L6:
        LinkedList r7 = PrefetchNetworkExecutorImpl.d(r3, PrefetchNetworkExecutorImpl.c(r3, r4, r5, r6));
        if (Intrinsics.areEqual((String) this.c.get("Content-Type"), "application/json") == false) goto L13;
        String r8 = this.f.toString();
        Charset r9 = Charsets.UTF_8;
        if (r8 == null) goto L12;
        byte[] r11 = r8.getBytes(r9);
    L30:
        return PrefetchNetworkExecutorImpl.e(r0, (HttpResponse) r1.post(r2, r7, "application/x-www-form-urlencoded; charset=UTF-8", r11).execute(), this.b, this.d, this.e);
    L12:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L13:
        ByteArrayOutputStream r12 = new ByteArrayOutputStream();
        Iterator<String> r13 = this.f.keys();
    L15:
        if (r13.hasNext() == false) goto L28;
        String r14 = r13.next();
        String r15 = JSONObjectProtectorUtils.getString(this.f, r14);
        if (r12.size() <= 0) goto L19;
        r12.write(38);
    L19:
        String r16 = URLEncoder.encode(r14, "UTF-8");
        Charset r17 = Charsets.UTF_8;
        if (r16 == null) goto L27;
        r12.write(r16.getBytes(r17));
        r12.write(61);
        String r18 = URLEncoder.encode(r15, "UTF-8");
        if (r18 == null) goto L25;
        r12.write(r18.getBytes(r17));
        goto L15
    L25:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L27:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L28:
        Unit r19 = Unit.INSTANCE;
        r11 = r12.toByteArray();
        goto L30
    L5:
        r6 = false;
        goto L6
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
