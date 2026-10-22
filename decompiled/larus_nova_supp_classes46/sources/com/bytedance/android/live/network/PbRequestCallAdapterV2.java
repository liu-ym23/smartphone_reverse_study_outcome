package com.bytedance.android.live.network;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.CallAdapter;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class PbRequestCallAdapterV2<R, T> implements CallAdapter<R, T> {
    public static d c;
    public static final Map<String, String> d = null;
    public static final Lazy e = null;
    public static final a f = null;
    public final CallAdapter<R, T> a;
    public final String b;

    public static final class a {
        public a() {
        }
    }

    static {
        f = new a();
        c = new d();
        d = new ConcurrentHashMap();
        e = LazyKt.lazy(PbRequestCallAdapterV2$Companion$switches$2.INSTANCE);
    }

    public final Type responseType() {
        return this.a.responseType();
    }

    @JvmStatic
    public static final boolean a(Request r2) {
        f.getClass();
        Intrinsics.checkNotNullParameter(r2, "request");
        Header r3 = r2.getFirstHeader("live_monitor_cost_call_adapter_key");
        if (r3 == null) goto L7;
        String r4 = r3.getValue();
        if (r4 == null) goto L7;
    L8:
        String r5 = (String) ((ConcurrentHashMap) d).remove(r4);
        if (r5 != null) goto L12;
        return false;
    L12:
        return ((JSONObject) e.getValue()).optBoolean(r5, Intrinsics.areEqual(r5, "_global_switch"));
    L7:
        r4 = "";
        goto L8
    }

    public final T adapt(Call<R> r5) {
        Intrinsics.checkNotNullParameter(r5, "call");
        Request r0 = r5.request();
        Map<String, String> r1 = d;
        f.getClass();
        ((ConcurrentHashMap) r1).put(r0.getUrl() + ", " + r0.getMethod(), this.b);
        return (T) this.a.adapt(r5);
    }

    public PbRequestCallAdapterV2(CallAdapter<R, T> r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "originAdapter");
        Intrinsics.checkNotNullParameter(r3, "switchType");
        this.a = r2;
        this.b = r3;
    }
}
