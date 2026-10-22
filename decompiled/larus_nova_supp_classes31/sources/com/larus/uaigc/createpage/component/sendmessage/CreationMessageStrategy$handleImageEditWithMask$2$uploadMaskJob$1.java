package com.larus.uaigc.createpage.component.sendmessage;

import android.content.Context;
import android.net.Uri;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.uaigc.bean.remove.ImageEditDataWithMask;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/platform/model/upload/ResourceUploadResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.sendmessage.CreationMessageStrategy$handleImageEditWithMask$2$uploadMaskJob$1", f = "CreationMessageStrategy.kt", i = {}, l = {280}, m = "invokeSuspend", n = {}, s = {})
public final class CreationMessageStrategy$handleImageEditWithMask$2$uploadMaskJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super mr9.l>, Object> {
    final /* synthetic */ ImageEditDataWithMask $imageEditDataWithMask;
    int label;
    final /* synthetic */ CreationMessageStrategy this$0;

    public CreationMessageStrategy$handleImageEditWithMask$2$uploadMaskJob$1(ImageEditDataWithMask r1, CreationMessageStrategy r2, Continuation<? super CreationMessageStrategy$handleImageEditWithMask$2$uploadMaskJob$1> r3) {
        this.$imageEditDataWithMask = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CreationMessageStrategy$handleImageEditWithMask$2$uploadMaskJob$1(this.$imageEditDataWithMask, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super mr9.l> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L14:
        return r5;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        Context r6 = AppHost.a.getApplication().getApplicationContext();
        String r3 = this.$imageEditDataWithMask.getMaskImgFilePath();
        if (r3 != null) goto L11;
        r3 = "";
    L11:
        String r7 = vqc.d.d(r6, Uri.fromFile(new PolarisFileWrapper(r3)));
        CreationMessageStrategy r2 = this.this$0;
        Intrinsics.checkNotNull(r7);
        this.label = 1;
        r5 = CreationMessageStrategy.b(r2, r7, this);
        if (r5 != r0) goto L14;
        return r0;
    }
}
