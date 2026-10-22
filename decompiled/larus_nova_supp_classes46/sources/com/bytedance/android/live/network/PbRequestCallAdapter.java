package com.bytedance.android.live.network;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.CallAdapter;
import com.bytedance.retrofit2.client.Request;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class PbRequestCallAdapter<R, T> implements CallAdapter<R, T> {
    public static d c;
    public static final Map<String, String> d = null;
    public static final Lazy e = null;
    public static final a f = null;
    public final CallAdapter<R, T> a;
    public final String b;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static String a(Request r2) {
            return r2.getUrl() + ", " + r2.getMethod();
        }
    }

    static {
        f = new a();
        c = new d();
        d = new ConcurrentHashMap();
        e = LazyKt.lazy(PbRequestCallAdapter$Companion$switches$2.INSTANCE);
    }

    public final Type responseType() {
        return this.a.responseType();
    }

    public final T adapt(Call<R> r4) {
        Intrinsics.checkNotNullParameter(r4, "call");
        Request r0 = r4.request();
        Map<String, String> r1 = d;
        f.getClass();
        ConcurrentHashMap r2 = (ConcurrentHashMap) r1;
        r2.put(a.a(r0), this.b);
        return (T) this.a.adapt(r4);
    }

    public PbRequestCallAdapter(CallAdapter<R, T> r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "originAdapter");
        Intrinsics.checkNotNullParameter(r3, "switchType");
        this.a = r2;
        this.b = r3;
    }
}
