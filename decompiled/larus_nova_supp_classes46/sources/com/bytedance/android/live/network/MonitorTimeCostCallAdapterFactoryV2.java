package com.bytedance.android.live.network;

import com.bytedance.android.live.network.annotation.MonitorTimeCost;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.CallAdapter;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.client.Request;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MonitorTimeCostCallAdapterFactoryV2 extends CallAdapter.Factory {
    public static final Map<String, String> b = null;
    public final CallAdapter.Factory a;

    public static final class a<R, T> implements CallAdapter<R, T> {
        public final CallAdapter<R, T> a;
        public final String b;

        public final Type responseType() {
            return this.a.responseType();
        }

        public final T adapt(Call<R> r5) {
            Intrinsics.checkNotNullParameter(r5, "call");
            Map<String, String> r0 = MonitorTimeCostCallAdapterFactoryV2.b;
            Map<String, String> r1 = MonitorTimeCostCallAdapterFactoryV2.b;
            Request r2 = r5.request();
            ((ConcurrentHashMap) r0).put(r2.getUrl() + ", " + r2.getMethod(), this.b);
            return (T) this.a.adapt(r5);
        }

        public a(CallAdapter<R, T> r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "originalAdapter");
            Intrinsics.checkNotNullParameter(r3, "key");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b {
    }

    static {
        b = new ConcurrentHashMap();
    }

    public MonitorTimeCostCallAdapterFactoryV2(PbAnnotationCallAdapterFactoryV2 r2) {
        Intrinsics.checkNotNullParameter(r2, "originalFactory");
        this.a = r2;
    }

    public final CallAdapter<?, ?> get(Type r3, Annotation[] r4, Retrofit r5) {
        Intrinsics.checkNotNullParameter(r3, "returnType");
        Intrinsics.checkNotNullParameter(r4, "annotations");
        Intrinsics.checkNotNullParameter(r5, "retrofit");
        Sequence r0 = SequencesKt.filter(ArraysKt.asSequence(r4), MonitorTimeCostCallAdapterFactoryV2$get$$inlined$filterIsInstance$1.INSTANCE);
        if (r0 == null) goto L14;
        MonitorTimeCost r1 = (MonitorTimeCost) SequencesKt.firstOrNull(r0);
        if (r1 == null) goto L7;
        CallAdapter r6 = this.a.get(r3, r4, r5);
        if (r6 != null) goto L15;
        return null;
    L15:
        return new a(r6, r1.key());
    L7:
        return this.a.get(r3, r4, r5);
    L14:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
    }
}
