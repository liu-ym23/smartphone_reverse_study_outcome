package com.larus.camera.impl.vlm;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.larus.utils.logger.FLogger;
import ix8.b;
import ix8.c;
import ix8.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/camera/impl/vlm/VLMIntentDetectRepository$BuildHttpRequestResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.vlm.VLMIntentDetectRepository$requestDetectInternal$httpRequest$1", f = "VLMIntentDetectRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VLMIntentDetectRepository$requestDetectInternal$httpRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super VLMIntentDetectRepository.b>, Object> {
    final /* synthetic */ c $request;
    int label;

    public VLMIntentDetectRepository$requestDetectInternal$httpRequest$1(c r1, Continuation<? super VLMIntentDetectRepository$requestDetectInternal$httpRequest$1> r2) {
        this.$request = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new VLMIntentDetectRepository$requestDetectInternal$httpRequest$1(this.$request, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super VLMIntentDetectRepository.b> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r23) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L75;
        ResultKt.throwOnFailure(r23);
        VLMIntentDetectRepository r0 = VLMIntentDetectRepository.a;
        c r2 = this.$request;
        long r3 = System.currentTimeMillis();
        List<b> r1 = r2.a;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r7 = r1.iterator();
    L6:
        if (r7.hasNext() == false) goto L48;
        b r9 = (b) r7.next();
        VLMIntentDetectRepository r4 = VLMIntentDetectRepository.a;
        ix8.a r10 = r2.c;
        Bitmap r15 = r9.a;
        float r6 = r10.b;
        int r11 = Math.min(r15.getWidth(), r15.getHeight());
        if (r6 <= 0.0f) goto L32;
        float r12 = r11;
        if (r12 <= r6) goto L32;
        float r8 = r6 / r12;
        Matrix r14 = new Matrix();
        r14.postScale(r8, r8);
        FLogger.a.i("VLMIntentDetectRepository", "[scaleBitmap] resizeBitmap scaleFactor " + r8 + " shortSide " + r11);
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L19
        Bitmap r19 = r15;
        Object r16 = Result.constructor-impl(Bitmap.createBitmap(r15, 0, 0, r15.getWidth(), r15.getHeight(), r14, true));     // Catch: Throwable -> L17
    L22:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L26;
        FLogger.a.e("VLMIntentDetectRepository", "[scaleBitmap] error", r17);
    L26:
        if (Result.isFailure-impl(r16) == false) goto L28;
        Object r18 = null;
    L29:
        Bitmap r110 = (Bitmap) r18;
        if (r110 != null) goto L76;
    L33:
        r110 = r19;
    L76:
        VLMIntentDetectRepository.c r20 = VLMIntentDetectRepository.a(r110, r10.c);     // Catch: Throwable -> L41
        VLMIntentDetectRepository.a r21 = new VLMIntentDetectRepository.a(new VLMIntentDetectRepository.e(r20.a, Integer.valueOf(r9.getType().getValue())), r110.getWidth(), r110.getHeight(), r9.a.getAllocationByteCount(), r20.b);     // Catch: Throwable -> L41
        if (r110 == r9.a) goto L40;
        if (r110.isRecycled() == true) goto L40;
        r110.recycle();
    L40:
        r5.add(r21);
    L41:
        th = move-exception;
        if (r110 != r9.a) goto L45;
    L47:
        throw th;
    L45:
        if (r110.isRecycled() == true) goto L47;
        r110.recycle();
        goto L47
    L28:
        r18 = r16;
    L17:
        th = th;
    L21:
        Result.Companion r111 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
    L19:
        th = th;
        r19 = r15;
    L32:
        r19 = r15;
        goto L33
    L48:
        ArrayList r22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r24 = r5.iterator();
    L50:
        if (r24.hasNext() == false) goto L52;
        r22.add(((VLMIntentDetectRepository.a) r24.next()).a);
        goto L50
    L52:
        int r25 = r2.b.getValue();
        ix8.a r26 = r2.c;
        Map<String, Object> r27 = r2.d;
        boolean r28 = r26.d;
        boolean r112 = r26.e;
        Object r29 = r27.get("eduSceneType");
        if ((r29 instanceof Number) == false) goto L55;
        Long r30 = Long.valueOf(((Number) r29).longValue());
    L56:
        VLMIntentDetectRepository.f r31 = new VLMIntentDetectRepository.f(r22, r25, new VLMIntentDetectRepository.d(r28, r112, r30, r26.f));
        VLMIntentDetectRepository.a r32 = (VLMIntentDetectRepository.a) CollectionsKt.firstOrNull(r5);
        int r33 = 0;
        if (r32 == null) goto L59;
        int r34 = r32.b;
    L60:
        VLMIntentDetectRepository.a r35 = (VLMIntentDetectRepository.a) CollectionsKt.firstOrNull(r5);
        if (r35 == null) goto L63;
        int r36 = r35.c;
    L64:
        long r37 = System.currentTimeMillis() - r3;
        Iterator r38 = r5.iterator();
        int r39 = 0;
    L66:
        if (r38.hasNext() == false) goto L68;
        r39 = r39 + ((VLMIntentDetectRepository.a) r38.next()).d;
        goto L66
    L68:
        Iterator r40 = r5.iterator();
    L70:
        if (r40.hasNext() == false) goto L73;
        r33 = r33 + ((VLMIntentDetectRepository.a) r40.next()).e;
        goto L70
    L73:
        return new VLMIntentDetectRepository.b(r31, r34, r36, new g(r37, r39, r33));
    L63:
        r36 = 0;
        goto L64
    L59:
        r34 = 0;
        goto L60
    L55:
        r30 = null;
        goto L56
    L75:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
