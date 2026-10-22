package com.bytedance.android.live.network;

import com.bytedance.android.live.base.annotation.SkipLivePBCheck;
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
public final class PbAnnotationCallAdapterFactory extends CallAdapter.Factory {
    public final CallAdapter.Factory a;

    public PbAnnotationCallAdapterFactory(RxJava2CallAdapterFactory r2) {
        Intrinsics.checkNotNullParameter(r2, "originFactory");
        this.a = r2;
    }

    public final CallAdapter<?, ?> get(Type r7, Annotation[] r8, Retrofit r9) {
        Intrinsics.checkNotNullParameter(r7, "returnType");
        Intrinsics.checkNotNullParameter(r8, "annotations");
        Intrinsics.checkNotNullParameter(r9, "retrofit");
        if ((r7 instanceof ParameterizedType) == false) goto L5;
        Sequence r0 = SequencesKt.filter(ArraysKt.asSequence(r8), PbAnnotationCallAdapterFactory$get$$inlined$filterIsInstance$1.INSTANCE);
        if (r0 == null) goto L47;
        if (((SkipLivePBCheck) SequencesKt.firstOrNull(r0)) != null) goto L11;
        Sequence r1 = SequencesKt.filter(ArraysKt.asSequence(r8), PbAnnotationCallAdapterFactory$get$$inlined$filterIsInstance$2.INSTANCE);
        if (r1 == null) goto L45;
        PbRequest r2 = (PbRequest) SequencesKt.firstOrNull(r1);
        if (r2 == null) goto L17;
        String r3 = r2.value();
    L18:
        if (r3 != null) goto L40;
        Type r4 = ((ParameterizedType) r7).getActualTypeArguments()[0];
        if ((r4 instanceof ParameterizedType) == false) goto L35;
        ParameterizedType r5 = (ParameterizedType) r4;
        Type r6 = r5.getRawType();
        if (r6 == null) goto L33;
        if (ExtraResponse.class.isAssignableFrom((Class) r6) == true) goto L36;
        Type r10 = r5.getRawType();
        if (r10 == null) goto L31;
        if (zn0.f.class.isAssignableFrom((Class) r10) == true) goto L36;
    L31:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
    L36:
        CallAdapter r11 = this.a.get(r7, r8, r9);
        if (r11 != null) goto L49;
        return null;
    L49:
        return new PbRequestCallAdapter(r11, "_global_switch");
    L33:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
    L35:
        if (Intrinsics.areEqual(r4, com.bytedance.android.live.network.response.a.class) == true) goto L36;
        return this.a.get(r7, r8, r9);
    L40:
        CallAdapter r12 = this.a.get(r7, r8, r9);
        if (r12 != null) goto L43;
        return null;
    L43:
        return new PbRequestCallAdapter(r12, r3);
    L17:
        r3 = null;
        goto L18
    L45:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
    L11:
        return this.a.get(r7, r8, r9);
    L47:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
    L5:
        return this.a.get(r7, r8, r9);
    }
}
