package com.ss.android.lark.officesdk.minutes.service.foundation.utils.user;

import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.LarkContext;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.utils.user.MmUserInfoHelper$getAvatarWithUrl$2", f = "MmUserInfoHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmUserInfoHelper$getAvatarWithUrl$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ c $config;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmUserInfoHelper this$0;

    public MmUserInfoHelper$getAvatarWithUrl$2(c r1, MmUserInfoHelper r2, Continuation<? super MmUserInfoHelper$getAvatarWithUrl$2> r3) {
        this.$config = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        MmUserInfoHelper$getAvatarWithUrl$2 r0 = new MmUserInfoHelper$getAvatarWithUrl$2(this.$config, this.this$0, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Bitmap> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L23;
        ResultKt.throwOnFailure(r6);
        CoroutineScope r7 = (CoroutineScope) this.L$0;
        c r8 = this.$config;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L13
        RequestBuilder r1 = Glide.with(LarkContext.getApplication()).asBitmap().load(r8.a).centerCrop();     // Catch: Throwable -> L13
        int r2 = r8.e;     // Catch: Throwable -> L13
        if (r2 == 0) goto L8;
        r1 = (RequestBuilder) r1.error(r2);     // Catch: Throwable -> L13
    L8:
        int r3 = r8.d;     // Catch: Throwable -> L13
        if (r3 == 0) goto L11;
        r1 = (RequestBuilder) r1.placeholder(r3);     // Catch: Throwable -> L13
    L11:
        Object r9 = Result.constructor-impl((Bitmap) r1.submit(r8.b, r8.c).get());     // Catch: Throwable -> L13
    L15:
        MmUserInfoHelper r4 = this.this$0;
        c r5 = this.$config;
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L19;
        lvb.a.b(r4.b, "getAvatarWithUrl failed, url=" + lvb.a.f(r5.a) + ", exception=" + r10);
    L19:
        if (Result.isFailure-impl(r9) == false) goto L26;
        return null;
    L26:
        return r9;
    L13:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
