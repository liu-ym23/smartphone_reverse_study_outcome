package com.bytedance.android.live.network;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.retrofit2.CallAdapter;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.rxjava2.adapter.RxJava2CallAdapterFactory;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class PbAnnotationCallAdapterFactoryV2 extends CallAdapter.Factory {
    public final CallAdapter.Factory a;

    public PbAnnotationCallAdapterFactoryV2(RxJava2CallAdapterFactory r2) {
        Intrinsics.checkNotNullParameter(r2, "originFactory");
        this.a = r2;
    }

    public final CallAdapter<?, ?> get(Type r5, Annotation[] r6, Retrofit r7) {
        Intrinsics.checkNotNullParameter(r5, "returnType");
        Intrinsics.checkNotNullParameter(r6, "annotations");
        Intrinsics.checkNotNullParameter(r7, "retrofit");
        if ((r5 instanceof ParameterizedType) == false) goto L5;
        Sequence r0 = SequencesKt.filter(ArraysKt.asSequence(r6), PbAnnotationCallAdapterFactoryV2$get$$inlined$filterIsInstance$1.INSTANCE);
        if (r0 == null) goto L33;
        PbRequest r1 = (PbRequest) SequencesKt.firstOrNull(r0);
        if (r1 == null) goto L11;
        String r2 = r1.value();
    L12:
        if (r2 != null) goto L28;
        Type r3 = ((ParameterizedType) r5).getActualTypeArguments()[0];
        if ((r3 instanceof ParameterizedType) == false) goto L23;
        Type r4 = ((ParameterizedType) r3).getRawType();
        if (r4 == null) goto L21;
        if (ExtraResponse.class.isAssignableFrom((Class) r4) == false) goto L23;
    L24:
        CallAdapter r8 = this.a.get(r5, r6, r7);
        if (r8 != null) goto L35;
        return null;
    L35:
        return new PbRequestCallAdapterV2(r8, "_global_switch");
    L21:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
    L23:
        if (Intrinsics.areEqual(r3, com.bytedance.android.live.network.response.a.class) == true) goto L24;
        return this.a.get(r5, r6, r7);
    L28:
        CallAdapter r9 = this.a.get(r5, r6, r7);
        if (r9 != null) goto L31;
        return null;
    L31:
        return new PbRequestCallAdapterV2(r9, r2);
    L11:
        r2 = null;
        goto L12
    L33:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
    L5:
        return this.a.get(r5, r6, r7);
    }
}
