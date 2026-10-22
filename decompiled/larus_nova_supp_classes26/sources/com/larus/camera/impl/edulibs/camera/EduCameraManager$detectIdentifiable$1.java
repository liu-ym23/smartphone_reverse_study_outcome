package com.larus.camera.impl.edulibs.camera;

import com.larus.camera.impl.edulibs.cameraapi.IdentifyDetectionResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.edulibs.camera.EduCameraManager", f = "EduCameraManager.kt", i = {}, l = {87}, m = "detectIdentifiable", n = {}, s = {})
final class EduCameraManager$detectIdentifiable$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    public EduCameraManager$detectIdentifiable$1(a r1, Continuation<? super EduCameraManager$detectIdentifiable$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r6) {
        this.result = r6;
        this.label |= Integer.MIN_VALUE;
        a r7 = this.this$0;
        r7.getClass();
        int r1 = this.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r1 - Integer.MIN_VALUE;
        EduCameraManager$detectIdentifiable$1 r0 = this;
    L6:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L12;
        if (r3 != 1) goto L11;
        ResultKt.throwOnFailure(r8);
    L17:
        IdentifyDetectionResult r9 = (IdentifyDetectionResult) r8;
        if (r9 == null) goto L26;
        if (r9.a == true) goto L26;
        r4 = false;
    L26:
        return Boxing.boxBoolean(r4);
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r8);
        if (StringsKt.isBlank(null) == false) goto L25;
        CoroutineDispatcher r5 = Dispatchers.getIO();
        EduCameraManager$detectIdentifiable$result$1 r10 = new EduCameraManager$detectIdentifiable$result$1(null, null, null);
        r0.label = 1;
        r8 = BuildersKt.withContext(r5, r10, r0);
        if (r8 != r2) goto L17;
        return r2;
    L25:
        return Boxing.boxBoolean(true);
    L5:
        r0 = new EduCameraManager$detectIdentifiable$1(r7, this);
        goto L6
    }
}
