package com.bytedance.android.annie.service.prefetch;

import android.util.Pair;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.service.network.IAnnieNetworkService;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class x<V> implements Callable {
    public final /* synthetic */ PrefetchNetworkExecutorImpl a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Map<String, String> c;
    public final /* synthetic */ Map<String, String> d;
    public final /* synthetic */ t9.b e;
    public final /* synthetic */ JSONObject f;

    public x(PrefetchNetworkExecutorImpl r1, String r10, Map<String, String> r11, Map<String, String> r12, t9.b r13, JSONObject r14) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
    }

    @Override // java.util.concurrent.Callable
    public final com.bytedance.ies.tools.prefetch.i.b call() {
        PrefetchNetworkExecutorImpl r0 = this.a;
        IAnnieNetworkService r1 = (IAnnieNetworkService) Annie.getService$default(IAnnieNetworkService.class, null, 2, null);
        String r10 = this.b;
        PrefetchNetworkExecutorImpl r11 = this.a;
        Map<String, String> r12 = this.c;
        Map<String, String> r13 = this.d;
        if (this.e != null) goto L5;
        boolean r14 = true;
    L6:
        List<Pair<String, String>> r15 = PrefetchNetworkExecutorImpl.d(r11, PrefetchNetworkExecutorImpl.c(r11, r12, r13, r14));
        if (Intrinsics.areEqual(this.c.get("Content-Type"), "application/json") == false) goto L9;
        byte[] r16 = this.f.toString().getBytes(Charsets.UTF_8);
    L26:
        return PrefetchNetworkExecutorImpl.e(r0, r1.post(r10, r15, "application/x-www-form-urlencoded; charset=UTF-8", r16).execute(), this.b, this.d, this.e);
    L9:
        ByteArrayOutputStream r17 = new ByteArrayOutputStream();
        JSONObject r18 = this.f;
        Iterator<String> r19 = r18.keys();
    L11:
        if (r19.hasNext() == false) goto L24;
        String r20 = r19.next();
        String r21 = JSONObjectProtectorUtils.getString(r18, r20);
        if (r17.size() <= 0) goto L15;
        r17.write(38);
    L15:
        String r22 = URLEncoder.encode(r20, "UTF-8");
        Charset r110 = Charsets.UTF_8;
        if (r22 == null) goto L23;
        r17.write(r22.getBytes(r110));
        r17.write(61);
        String r23 = URLEncoder.encode(r21, "UTF-8");
        if (r23 == null) goto L21;
        r17.write(r23.getBytes(r110));
        goto L11
    L21:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L23:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L24:
        Unit r24 = Unit.INSTANCE;
        r16 = r17.toByteArray();
        goto L26
    L5:
        r14 = false;
        goto L6
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
