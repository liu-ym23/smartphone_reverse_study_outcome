package com.bytedance.retrofit2;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u0003H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a+\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0003H\u0087@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0004\u001a+\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u0003H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a\u001a\u0010\b\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\tH\u0086\b¢\u0006\u0002\u0010\n\u001a\u0019\u0010\u000b\u001a\u00020\f*\u00060\rj\u0002`\u000eH\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"await", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/bytedance/retrofit2/Call;", "(Lcom/bytedance/retrofit2/Call;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitNullable", "awaitResponse", "Lcom/bytedance/retrofit2/SsResponse;", "create", "Lcom/bytedance/retrofit2/Retrofit;", "(Lcom/bytedance/retrofit2/Retrofit;)Ljava/lang/Object;", "suspendAndThrow", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/Exception;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ss-retrofit2_release"}, k = 2, mv = {1, 4, 0})
public final class KotlinExtensions {
    public static final <T> Object await(Call<T> r5, Continuation<? super T> r6) {
        final Call r7 = (Call) ZeusTransformUtils.wrapperContextForParams(r5, Call.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        o r0 = new o(IntrinsicsKt.intercepted(r8), 1);
        r0.e();
        final n r2 = (n) ZeusTransformUtils.preCheckCast(r0, n.class, "com.obric.memorydata.plugin");
        r2.a((Function1) ZeusTransformUtils.preCheckCast(new KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$1(r7), Function1.class, "com.obric.memorydata.plugin"));
        r7.enqueue((Callback) ZeusTransformUtils.preCheckCast(new KotlinExtensions$await$2$2(r2), Callback.class, "com.obric.memorydata.plugin"));
        Object r9 = r0.h();
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r8);
    L5:
        return r9;
    }

    public static final <T> Object awaitNullable(Call<T> r5, Continuation<? super T> r6) {
        final Call r7 = (Call) ZeusTransformUtils.wrapperContextForParams(r5, Call.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        o r0 = new o(IntrinsicsKt.intercepted(r8), 1);
        r0.e();
        final n r2 = (n) ZeusTransformUtils.preCheckCast(r0, n.class, "com.obric.memorydata.plugin");
        r2.a((Function1) ZeusTransformUtils.preCheckCast(new KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2(r7), Function1.class, "com.obric.memorydata.plugin"));
        r7.enqueue((Callback) ZeusTransformUtils.preCheckCast(new KotlinExtensions$await$4$2(r2), Callback.class, "com.obric.memorydata.plugin"));
        Object r9 = r0.h();
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r8);
    L5:
        return r9;
    }

    public static final <T> Object awaitResponse(Call<T> r5, Continuation<? super SsResponse<T>> r6) {
        final Call r7 = (Call) ZeusTransformUtils.wrapperContextForParams(r5, Call.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        o r0 = new o(IntrinsicsKt.intercepted(r8), 1);
        r0.e();
        final n r2 = (n) ZeusTransformUtils.preCheckCast(r0, n.class, "com.obric.memorydata.plugin");
        r2.a((Function1) ZeusTransformUtils.preCheckCast(new KotlinExtensions$awaitResponse$$inlined$suspendCancellableCoroutine$lambda$1(r7), Function1.class, "com.obric.memorydata.plugin"));
        r7.enqueue((Callback) ZeusTransformUtils.preCheckCast(new KotlinExtensions$awaitResponse$2$2(r2), Callback.class, "com.obric.memorydata.plugin"));
        Object r9 = r0.h();
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r8);
    L5:
        return r9;
    }

    public static final /* synthetic */ <T> T create(Retrofit r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$create");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) r2.create(Object.class);
    }

    public static final Object suspendAndThrow(final Exception r4, Continuation<?> r5) {
        final Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        ba.a().dispatch(r6.getContext(), (Runnable) ZeusTransformUtils.preCheckCast(new KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1(r6, r4), Runnable.class, "com.obric.memorydata.plugin"));
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        DebugProbesKt.probeCoroutineSuspended(r6);
    L6:
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        return r7;
    L9:
        return Unit.INSTANCE;
    }
}
