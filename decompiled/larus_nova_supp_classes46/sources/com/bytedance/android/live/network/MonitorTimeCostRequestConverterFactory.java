package com.bytedance.android.live.network;

import android.os.SystemClock;
import com.bytedance.android.live.network.annotation.MonitorTimeCost;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.RequestBuilder;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import zg1.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MonitorTimeCostRequestConverterFactory extends Converter.Factory {
    public final Converter.Factory a;

    public static final class a<F, T> implements Converter {
        public final /* synthetic */ Converter a;
        public final /* synthetic */ String b;

        public a(Converter r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final /* synthetic */ Object convertWithRequestBuilder(Object r1, RequestBuilder r2) {
            return Converter.-CC.$default$convertWithRequestBuilder(this, r1, r2);
        }

        public final /* synthetic */ boolean needRequestBuilder() {
            return Converter.-CC.$default$needRequestBuilder(this);
        }

        public final Object convert(Object r13) {
            TypedInput r14 = (TypedInput) r13;
            Intrinsics.checkNotNullParameter(r14, "typedInput");
            long r4 = SystemClock.elapsedRealtime();
            Converter r9 = this.a;     // Catch: Throwable -> L13
            if (r9 == null) goto L7;
            Object r15 = r9.convert(r14);     // Catch: Throwable -> L13
        L9:
            if (Intrinsics.areEqual(this.b, "enterRoom") == false) goto L11;
            xs2.b.a().post(new z(SystemClock.elapsedRealtime() - r4));
        L11:
            u.l().sendLog("network_request_parsing_time_cost", MapsKt.mapOf(new Pair[]{TuplesKt.to("scene", this.b), TuplesKt.to("duration", String.valueOf(SystemClock.elapsedRealtime() - r4))}), new Object[0]);
            return r15;
        L7:
            r15 = null;
        L13:
            th = move-exception;
            if (Intrinsics.areEqual(this.b, "enterRoom") == false) goto L17;
            xs2.b.a().post(new z(SystemClock.elapsedRealtime() - r4));
        L17:
            u.l().sendLog("network_request_parsing_time_cost", MapsKt.mapOf(new Pair[]{TuplesKt.to("scene", this.b), TuplesKt.to("duration", String.valueOf(SystemClock.elapsedRealtime() - r4))}), new Object[0]);
            throw th;
        }
    }

    public MonitorTimeCostRequestConverterFactory(Converter.Factory r2) {
        Intrinsics.checkNotNullParameter(r2, "originalConverterFactory");
        this.a = r2;
    }

    public final Converter<?, Header> headerConverter(Type r2, Annotation[] r3, Retrofit r4) {
        return this.a.headerConverter(r2, r3, r4);
    }

    public final Converter<?, Object> objectConverter(Type r2, Annotation[] r3, Retrofit r4) {
        return this.a.objectConverter(r2, r3, r4);
    }

    public final Converter<TypedInput, ?> responseBodyConverter(Type r3, Annotation[] r4, Retrofit r5) {
        Intrinsics.checkNotNullParameter(r3, "type");
        Intrinsics.checkNotNullParameter(r4, "annotations");
        Intrinsics.checkNotNullParameter(r5, "retrofit");
        Sequence r0 = SequencesKt.filter(ArraysKt.asSequence(r4), MonitorTimeCostRequestConverterFactory$responseBodyConverter$$inlined$filterIsInstance$1.INSTANCE);
        if (r0 == null) goto L11;
        MonitorTimeCost r1 = (MonitorTimeCost) SequencesKt.firstOrNull(r0);
        if (r1 == null) goto L7;
        String r2 = r1.key();
        return new a(this.a.responseBodyConverter(r3, r4, r5), r2);
    L7:
        return this.a.responseBodyConverter(r3, r4, r5);
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
    }

    public final Converter<?, String> stringConverter(Type r2, Annotation[] r3, Retrofit r4) {
        return this.a.stringConverter(r2, r3, r4);
    }

    public final Converter<?, TypedOutput> requestBodyConverter(Type r2, Annotation[] r3, Annotation[] r4, Retrofit r5) {
        return this.a.requestBodyConverter(r2, r3, r4, r5);
    }
}
