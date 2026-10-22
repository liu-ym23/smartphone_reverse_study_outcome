package com.larus.bot.impl.feature.edit.feature.bgimage.preview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.yalantis.ucrop.UCropActivity;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.preview.BotEditAvatarPreviewFragment$handlePhotoPickerResult$1", f = "BotEditAvatarPreviewFragment.kt", i = {0, 0}, l = {236}, m = "invokeSuspend", n = {"activity", "originTmpUri"}, s = {"L$1", "L$2"})
final class BotEditAvatarPreviewFragment$handlePhotoPickerResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Uri $uri;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ BotEditAvatarPreviewFragment this$0;

    public BotEditAvatarPreviewFragment$handlePhotoPickerResult$1(BotEditAvatarPreviewFragment r1, Uri r2, Continuation<? super BotEditAvatarPreviewFragment$handlePhotoPickerResult$1> r3) {
        this.this$0 = r1;
        this.$uri = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new BotEditAvatarPreviewFragment$handlePhotoPickerResult$1(this.this$0, this.$uri, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        Unit r2 = null;
        if (r1 == 0) goto L12;
        if (r1 != 1) goto L11;
        Uri r3 = (Uri) this.L$2;
        FragmentActivity r4 = (FragmentActivity) this.L$1;
        BotEditAvatarPreviewFragment r5 = (BotEditAvatarPreviewFragment) this.L$0;
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L8
    L20:
        ActivityResultLauncher<Intent> r10 = r5.l;     // Catch: Throwable -> L8
        if (r10 == null) goto L23;
        Uri r6 = Uri.fromFile(new PolarisFileWrapper(r4.getCacheDir(), "preview_crop_image_cache.jpg"));     // Catch: Throwable -> L8
        Intent r7 = new Intent();     // Catch: Throwable -> L8
        Bundle r8 = new Bundle();     // Catch: Throwable -> L8
        r8.putParcelable("com.yalantis.ucrop.InputUri", r3);     // Catch: Throwable -> L8
        r8.putParcelable("com.yalantis.ucrop.OutputUri", r6);     // Catch: Throwable -> L8
        r8.putFloat("com.yalantis.ucrop.AspectRatioX", 1.0f);     // Catch: Throwable -> L8
        r8.putFloat("com.yalantis.ucrop.AspectRatioY", 1.0f);     // Catch: Throwable -> L8
        r7.setClass(r4, UCropActivity.class);     // Catch: Throwable -> L8
        r7.putExtras(r8);     // Catch: Throwable -> L8
        r10.launch(r7);     // Catch: Throwable -> L8
        r2 = Unit.INSTANCE;     // Catch: Throwable -> L8
    L23:
        Result.constructor-impl(r2);     // Catch: Throwable -> L8
    L27:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r9);
        r4 = this.this$0.getActivity();
        if (r4 == null) goto L27;
        Uri r11 = this.$uri;
        BotEditAvatarPreviewFragment r12 = this.this$0;
        if (r11 == null) goto L27;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L8
        Uri r14 = Uri.fromFile(new PolarisFileWrapper(r4.getCacheDir(), "preview_crop_origin_image_reopen_cache"));     // Catch: Throwable -> L8
        CoroutineDispatcher r15 = Dispatchers.getIO();     // Catch: Throwable -> L8
        BotEditAvatarPreviewFragment$handlePhotoPickerResult$1$1$1$1$1 r16 = new BotEditAvatarPreviewFragment$handlePhotoPickerResult$1$1$1$1$1(r4, r11, r14, null);     // Catch: Throwable -> L8
        this.L$0 = r12;     // Catch: Throwable -> L8
        this.L$1 = r4;     // Catch: Throwable -> L8
        this.L$2 = r14;     // Catch: Throwable -> L8
        this.label = 1;     // Catch: Throwable -> L8
        if (BuildersKt.withContext(r15, r16, this) != r0) goto L19;
        return r0;
    L19:
        r5 = r12;
        r3 = r14;
    L8:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    }
}
