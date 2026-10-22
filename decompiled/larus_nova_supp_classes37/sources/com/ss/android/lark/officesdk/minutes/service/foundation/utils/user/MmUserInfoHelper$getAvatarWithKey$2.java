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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.utils.user.MmUserInfoHelper$getAvatarWithKey$2", f = "MmUserInfoHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmUserInfoHelper$getAvatarWithKey$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ String $avatarPath;
    final /* synthetic */ b $config;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmUserInfoHelper this$0;

    public MmUserInfoHelper$getAvatarWithKey$2(String r1, b r2, MmUserInfoHelper r3, Continuation<? super MmUserInfoHelper$getAvatarWithKey$2> r4) {
        this.$avatarPath = r1;
        this.$config = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        MmUserInfoHelper$getAvatarWithKey$2 r0 = new MmUserInfoHelper$getAvatarWithKey$2(this.$avatarPath, this.$config, this.this$0, r6);
        r0.L$0 = r5;
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
        String r8 = this.$avatarPath;
        b r0 = this.$config;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
        RequestBuilder r9 = Glide.with(LarkContext.getApplication()).asBitmap().load(r8).centerCrop();     // Catch: Throwable -> L13
        int r2 = r0.f;     // Catch: Throwable -> L13
        if (r2 == 0) goto L8;
        r9 = (RequestBuilder) r9.error(r2);     // Catch: Throwable -> L13
    L8:
        int r3 = r0.e;     // Catch: Throwable -> L13
        if (r3 == 0) goto L11;
        r9 = (RequestBuilder) r9.placeholder(r3);     // Catch: Throwable -> L13
    L11:
        Object r10 = Result.constructor-impl((Bitmap) r9.submit(r0.c, r0.d).get());     // Catch: Throwable -> L13
    L15:
        MmUserInfoHelper r4 = this.this$0;
        b r5 = this.$config;
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L19;
        lvb.a.b(r4.b, "entityId:" + r5.b + ", avatarKey: " + r5.a + ", exception: " + r11);
    L19:
        if (Result.isFailure-impl(r10) == false) goto L26;
        return null;
    L26:
        return r10;
    L13:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
