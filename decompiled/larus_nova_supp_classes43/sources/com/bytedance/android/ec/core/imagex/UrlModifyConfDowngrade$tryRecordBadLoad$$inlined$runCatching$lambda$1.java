package com.bytedance.android.ec.core.imagex;

import android.content.Context;
import android.widget.Toast;
import com.facebook.imagepipeline.request.ImageRequest;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/bytedance/android/ec/core/imagex/UrlModifyConfDowngrade$tryRecordBadLoad$1$3$1", "com/bytedance/android/ec/core/imagex/UrlModifyConfDowngrade$$special$$inlined$let$lambda$1"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.core.imagex.UrlModifyConfDowngrade$tryRecordBadLoad$1$3$1", f = "UrlModifyConfDowngrade.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class UrlModifyConfDowngrade$tryRecordBadLoad$$inlined$runCatching$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ u $context$inlined;
    final /* synthetic */ String $editUrl$inlined;
    final /* synthetic */ ImageRequest $imageRequest$inlined;
    final /* synthetic */ Context $it;
    final /* synthetic */ UrlModifyConfDowngrade $this_runCatching$inlined;
    int label;

    public UrlModifyConfDowngrade$tryRecordBadLoad$$inlined$runCatching$lambda$1(Context r1, Continuation r10, UrlModifyConfDowngrade r11, u r12, ImageRequest r13, String r14) {
        this.$it = r1;
        this.$this_runCatching$inlined = r11;
        this.$context$inlined = r12;
        this.$imageRequest$inlined = r13;
        this.$editUrl$inlined = r14;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Intrinsics.checkNotNullParameter(r11, "completion");
        return new UrlModifyConfDowngrade$tryRecordBadLoad$$inlined$runCatching$lambda$1(this.$it, r11, this.$this_runCatching$inlined, this.$context$inlined, this.$imageRequest$inlined, this.$editUrl$inlined);
    }

    public final Object invoke(Object r1, Object r10) {
        return create(r1, (Continuation) r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r10);
        Toast.makeText(this.$it, "图片url可能被错误修改,请检查，url：" + this.$editUrl$inlined, 0).show();
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
