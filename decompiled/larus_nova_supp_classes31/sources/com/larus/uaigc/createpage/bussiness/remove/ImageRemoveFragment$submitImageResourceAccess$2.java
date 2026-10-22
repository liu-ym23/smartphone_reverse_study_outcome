package com.larus.uaigc.createpage.bussiness.remove;

import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.resource.access.b0;
import com.larus.bmhome.resource.access.d0;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.uaigc.service.ICreationResourceAccessService;
import com.larus.uaigc.service.p0;
import com.tencent.open.log.TraceLevel;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/resource/access/ResourceAccessTask;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.bussiness.remove.ImageRemoveFragment$submitImageResourceAccess$2", f = "ImageRemoveFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ImageRemoveFragment$submitImageResourceAccess$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super b0>, Object> {
    final /* synthetic */ String $localPath;
    final /* synthetic */ Function1<ResourceUploadError, Unit> $onFailed;
    final /* synthetic */ Function1<mr9.l, Unit> $onSuccess;
    int label;
    final /* synthetic */ ImageRemoveFragment this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public ImageRemoveFragment$submitImageResourceAccess$2(ImageRemoveFragment r1, String r2, Function1<? super mr9.l, Unit> r3, Function1<? super ResourceUploadError, Unit> r4, Continuation<? super ImageRemoveFragment$submitImageResourceAccess$2> r5) {
        this.this$0 = r1;
        this.$localPath = r2;
        this.$onSuccess = r3;
        this.$onFailed = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ImageRemoveFragment$submitImageResourceAccess$2(this.this$0, this.$localPath, this.$onSuccess, this.$onFailed, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super b0> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r20);
        ICreationResourceAccessService.Companion r1 = ICreationResourceAccessService.a;
        int r2 = p0.x;
        String r4 = this.this$0.h;
        CountDownLatch r8 = new CountDownLatch(1);
        d0 r16 = com.larus.uaigc.service.g.a;
        LifecycleCoroutineScope r17 = LifecycleOwnerKt.getLifecycleScope(this.this$0);
        return r1.b(p0.a.c(this.$localPath, r4, null, null, true, r8, null, null, null, null, this.$onSuccess, this.$onFailed, null, r16, r17, 773944));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
