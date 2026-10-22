package com.larus.camera.impl.edulibs.camera.internal;

import android.graphics.Bitmap;
import android.os.SystemClock;
import com.larus.camera.impl.edulibs.camera.internal.idl.DetectionType;
import com.larus.camera.impl.edulibs.cameraapi.IdentifyDetectionResult;
import com.larus.camera.impl.edulibs.cameraapi.SceneType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.k1;
import nx8.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.edulibs.camera.internal.EduQuestionSearchLogic$requestServer$1", f = "EduQuestionSearchLogic.kt", i = {0}, l = {127, 147}, m = "invokeSuspend", n = {"startTime"}, s = {"J$0"})
public final class EduQuestionSearchLogic$requestServer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ IdentifyDetectionResult $identifyDetectionResult;
    final /* synthetic */ boolean $isFromLiveTutor;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ EduQuestionSearchLogic this$0;

    /* JADX INFO: renamed from: com.larus.camera.impl.edulibs.camera.internal.EduQuestionSearchLogic$requestServer$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.edulibs.camera.internal.EduQuestionSearchLogic$requestServer$1$1", f = "EduQuestionSearchLogic.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ kx8.c $resp;
        int label;
        final /* synthetic */ EduQuestionSearchLogic this$0;

        public AnonymousClass1(EduQuestionSearchLogic r1, kx8.c r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$resp = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$resp, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            this.this$0.g.setValue(new e.a(this.$resp));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public EduQuestionSearchLogic$requestServer$1(EduQuestionSearchLogic r1, boolean r2, Bitmap r3, IdentifyDetectionResult r4, Continuation<? super EduQuestionSearchLogic$requestServer$1> r5) {
        this.this$0 = r1;
        this.$isFromLiveTutor = r2;
        this.$bitmap = r3;
        this.$identifyDetectionResult = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        EduQuestionSearchLogic$requestServer$1 r6 = new EduQuestionSearchLogic$requestServer$1(this.this$0, this.$isFromLiveTutor, this.$bitmap, this.$identifyDetectionResult, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L14;
        if (r0 == 1) goto L9;
        if (r0 != 2) goto L8;
        ResultKt.throwOnFailure(r17);
    L73:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        long r6 = this.J$0;
        ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L12
        Object r1 = r17;
    L57:
        Object r3 = Result.constructor-impl((kx8.c) r1);     // Catch: Throwable -> L12
    L63:
        if (Result.isFailure-impl(r3) == false) goto L65;
        r3 = null;
    L65:
        kx8.c r4 = (kx8.c) r3;
        long r5 = SystemClock.elapsedRealtime() - r6;
        if (r4 != null) goto L68;
        EduQuestionSearchLogic.a(this.this$0, r5, false, "timeout");
    L69:
        this.this$0.h = r4;
        com.larus.camera.impl.edulibs.camera.a.c.d("EduQuestionSearchLogic", "requestServer: " + r4);
        k1 r7 = k1.a;
        AnonymousClass1 r8 = new AnonymousClass1(this.this$0, r4, null);
        this.label = 2;
        if (BuildersKt.withContext(r7, r8, this) != r2) goto L73;
        return r2;
    L68:
        EduQuestionSearchLogic.a(this.this$0, r5, r4.i, r4.j);
    L12:
        th = th;
        long r9 = r6;
    L61:
        Result.Companion r10 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        r6 = r9;
        goto L63
    L14:
        ResultKt.throwOnFailure(r17);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        this.this$0.g.setValue(e.c.a);
        r9 = SystemClock.elapsedRealtime();
        EduQuestionSearchLogic r12 = this.this$0;
        if (r12.e(r12.a) != DetectionType.SingleQuestion) goto L17;
        DetectionType r13 = DetectionType.MultiQuestion;
    L18:
        DetectionType r14 = r13;
        EduQuestionSearchLogic r15 = this.this$0;
        i r16 = r15.a;
        if (Intrinsics.areEqual(r16, i.d.d) == false) goto L22;
        SceneType r18 = SceneType.Doubao_Education_Camera_Mental_Calculations;
    L37:
        r15.e = r18;
        EduQuestionSearchLogic r19 = this.this$0;
        Bitmap r110 = this.$bitmap;
        IdentifyDetectionResult r111 = this.$identifyDetectionResult;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L60
        if (Intrinsics.areEqual(r19.a, i.f.d) == false) goto L41;
    L48:
        boolean r21 = true;
    L49:
        long r22 = com.larus.camera.impl.edulibs.camera.a.b.a();     // Catch: Throwable -> L60
        if (r21 == false) goto L52;
        boolean r112 = true;
    L53:
        EduQuestionSearchLogic$requestServer$1$resp$1$1 r113 = new EduQuestionSearchLogic$requestServer$1$resp$1$1(r110, r112, r14, r111, r19, null);     // Catch: Throwable -> L60
        this.J$0 = r9;     // Catch: Throwable -> L60
        this.label = 1;     // Catch: Throwable -> L60
        r1 = TimeoutKt.c(r22, r113, this);     // Catch: Throwable -> L60
        if (r1 != r2) goto L56;
        return r2;
    L56:
        r6 = r9;
        goto L57
    L52:
        r112 = false;
        goto L53
    L41:
        if (Intrinsics.areEqual(r19.a, i.e.d) == true) goto L48;
        if (Intrinsics.areEqual(r19.a, i.c.d) == true) goto L45;
    L47:
        r21 = false;
        goto L49
    L45:
        if (r19.b == false) goto L47;
    L60:
        th = th;
        goto L61
    L22:
        if (Intrinsics.areEqual(r16, i.f.d) == true) goto L34;
        if (Intrinsics.areEqual(r16, i.e.d) == true) goto L34;
        if (Intrinsics.areEqual(r16, i.b.d) == false) goto L30;
        r18 = SceneType.Doubao_Education_Camera_Essay_Correction;
        goto L37
    L30:
        if (Intrinsics.areEqual(r16, i.c.d) == false) goto L32;
        r18 = SceneType.Doubao_Education_Camera_Homework_Correction;
        goto L37
    L32:
        r18 = null;
    L34:
        if (this.$isFromLiveTutor == false) goto L36;
        r18 = SceneType.Doubao_Live_Tutor;
        goto L37
    L36:
        r18 = SceneType.Doubao_Education_Camera_Qa;
        goto L37
    L17:
        EduQuestionSearchLogic r23 = this.this$0;
        r13 = r23.e(r23.a);
        goto L18
    }
}
