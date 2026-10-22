package com.larus.profile.impl.creation;

import android.content.Context;
import android.graphics.Bitmap;
import com.larus.uaigc.service.IUgcAIGCService;
import com.tencent.open.log.TraceLevel;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.creation.CreationImageEditAbility$downloadByUrl$2$1$1$1", f = "CreationImageEditAbility.kt", i = {}, l = {382}, m = "invokeSuspend", n = {}, s = {})
final class CreationImageEditAbility$downloadByUrl$2$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ Context $context;
    final /* synthetic */ kotlinx.coroutines.i<File> $continuation;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public CreationImageEditAbility$downloadByUrl$2$1$1$1(Context r1, Bitmap r2, kotlinx.coroutines.i<? super File> r3, Continuation<? super CreationImageEditAbility$downloadByUrl$2$1$1$1> r4) {
        this.$context = r1;
        this.$bitmap = r2;
        this.$continuation = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CreationImageEditAbility$downloadByUrl$2$1$1$1(this.$context, this.$bitmap, this.$continuation, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        File r6 = (File) r5;
        if (this.$continuation.isActive() == false) goto L15;
        this.$continuation.resumeWith(Result.constructor-impl(r6));
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        IUgcAIGCService.Companion r7 = IUgcAIGCService.a;
        Context r2 = this.$context;
        Bitmap r3 = this.$bitmap;
        this.label = 1;
        r5 = r7.m(r2, r3, "image_selector_default_image.jpeg", this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
