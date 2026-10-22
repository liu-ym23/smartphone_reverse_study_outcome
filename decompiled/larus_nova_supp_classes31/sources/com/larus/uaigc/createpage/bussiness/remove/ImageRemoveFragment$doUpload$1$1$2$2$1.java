package com.larus.uaigc.createpage.bussiness.remove;

import android.content.Context;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.uaigc.service.ICreationResourceAccessServiceKt;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
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
@DebugMetadata(c = "com.larus.uaigc.createpage.bussiness.remove.ImageRemoveFragment$doUpload$1$1$2$2$1", f = "ImageRemoveFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ImageRemoveFragment$doUpload$1$1$2$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ResourceUploadError $err;
    int label;
    final /* synthetic */ ImageRemoveFragment this$0;

    public ImageRemoveFragment$doUpload$1$1$2$2$1(ResourceUploadError r1, ImageRemoveFragment r2, Continuation<? super ImageRemoveFragment$doUpload$1$1$2$2$1> r3) {
        this.$err = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ImageRemoveFragment$doUpload$1$1$2$2$1(this.$err, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r2);
        if (ICreationResourceAccessServiceKt.f(this.$err) == false) goto L7;
        ImageRemoveFragment r3 = this.this$0;
        int r0 = ImageRemoveFragment.v;
        r3.ba0();
    L9:
        return Unit.INSTANCE;
    L7:
        ImageRemoveFragment r4 = this.this$0;
        int r1 = ImageRemoveFragment.v;
        r4.ia0();
        t19.s r5 = t19.s.a;
        Context r6 = this.this$0.getContext();
        r5.getClass();
        t19.s.s(r6, 2131907666);
        goto L9
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
