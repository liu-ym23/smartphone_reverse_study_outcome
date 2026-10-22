package com.larus.camera.impl.edulibs.camera.internal;

import android.graphics.Bitmap;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.larus.camera.impl.edulibs.camera.internal.idl.DetectionType;
import com.larus.camera.impl.edulibs.cameraapi.IdentifyDetectionResult;
import com.larus.camera.impl.edulibs.cameraapi.SceneType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/camera/impl/edulibs/camera/internal/entity/EduClipQuestionResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.edulibs.camera.internal.EduQuestionSearchLogic$requestServer$1$resp$1$1", f = "EduQuestionSearchLogic.kt", i = {}, l = {128}, m = "invokeSuspend", n = {}, s = {})
public final class EduQuestionSearchLogic$requestServer$1$resp$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super kx8.c>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ DetectionType $detectionType;
    final /* synthetic */ boolean $enableCrop;
    final /* synthetic */ IdentifyDetectionResult $identifyDetectionResult;
    int label;
    final /* synthetic */ EduQuestionSearchLogic this$0;

    public EduQuestionSearchLogic$requestServer$1$resp$1$1(Bitmap r1, boolean r2, DetectionType r3, IdentifyDetectionResult r4, EduQuestionSearchLogic r5, Continuation<? super EduQuestionSearchLogic$requestServer$1$resp$1$1> r6) {
        this.$bitmap = r1;
        this.$enableCrop = r2;
        this.$detectionType = r3;
        this.$identifyDetectionResult = r4;
        this.this$0 = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new EduQuestionSearchLogic$requestServer$1$resp$1$1(this.$bitmap, this.$enableCrop, this.$detectionType, this.$identifyDetectionResult, this.this$0, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super kx8.c> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L17:
        return r14;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        b r15 = b.a;
        Bitmap r4 = this.$bitmap;
        boolean r7 = this.$enableCrop;
        DetectionType r8 = this.$detectionType;
        Integer r9 = Boxing.boxInt(0);
        IdentifyDetectionResult r2 = this.$identifyDetectionResult;
        if (r2 == null) goto L11;
        Long r3 = Boxing.boxLong(r2.c);
    L12:
        Long r10 = r3;
        EduQuestionSearchLogic r5 = this.this$0;
        SceneType r12 = r5.e;
        boolean r6 = r5.c;
        this.label = 1;
        r15.getClass();
        j r16 = new j(IntrinsicsKt.intercepted(this), 1);
        r16.C();
        int r11 = com.larus.camera.impl.edulibs.camera.a.b.b();
        com.larus.camera.impl.edulibs.camera.a.c.d("EduImageHelper", "start clip question: w=" + r4.getWidth() + ", h=" + r4.getHeight() + ", q=" + r11);
        TTExecutors.getIOThreadPool().execute(new a(r4, r6, r16, r7, r8, r9, r10, r11, r12));
        r14 = r16.B();
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        DebugProbesKt.probeCoroutineSuspended(this);
    L15:
        if (r14 != r0) goto L17;
        return r0;
    L11:
        r3 = null;
        goto L12
    }
}
