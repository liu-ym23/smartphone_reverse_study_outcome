package com.larus.bot.impl.feature.edit.feature.bgimage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bot.impl.common.util.BitmapHelperKt;
import com.yalantis.ucrop.UCropActivity;
import java.io.File;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.BotBgImageEditView$handlePhotoPickerResult$1$1$1$1", f = "BotBgImageEditView.kt", i = {1}, l = {439, 443}, m = "invokeSuspend", n = {"targetFile"}, s = {"L$0"})
public final class BotBgImageEditView$handlePhotoPickerResult$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ ActivityResultLauncher<Intent> $cropLauncher;
    final /* synthetic */ Uri $uri;
    Object L$0;
    int label;

    public BotBgImageEditView$handlePhotoPickerResult$1$1$1$1(FragmentActivity r1, Uri r2, ActivityResultLauncher<Intent> r3, Continuation<? super BotBgImageEditView$handlePhotoPickerResult$1$1$1$1> r4) {
        this.$activity = r1;
        this.$uri = r2;
        this.$cropLauncher = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new BotBgImageEditView$handlePhotoPickerResult$1$1$1$1(this.$activity, this.$uri, this.$cropLauncher, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        File r2 = (File) this.L$0;
        ResultKt.throwOnFailure(r6);
    L24:
        if (((Boolean) r6).booleanValue() == false) goto L26;
        Uri r7 = Uri.fromFile(r2);
    L27:
        Uri r3 = Uri.fromFile(new PolarisFileWrapper(this.$activity.getCacheDir(), "crop_image_cache.jpg"));
        Intent r4 = new Intent();
        Bundle r5 = new Bundle();
        r5.putParcelable("com.yalantis.ucrop.InputUri", r7);
        r5.putParcelable("com.yalantis.ucrop.OutputUri", r3);
        r5.putFloat("com.yalantis.ucrop.AspectRatioX", 1.0f);
        r5.putFloat("com.yalantis.ucrop.AspectRatioY", 1.0f);
        ActivityResultLauncher<Intent> r8 = this.$cropLauncher;
        r4.setClass(this.$activity, UCropActivity.class);
        r4.putExtras(r5);
        r8.launch(r4);
        return Unit.INSTANCE;
    L26:
        r7 = this.$uri;
        goto L27
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
    L13:
        String r9 = (String) r6;
        if (Intrinsics.areEqual(r9, "image/heif") == false) goto L16;
    L19:
        File r10 = new PolarisFileWrapper(this.$activity.getCacheDir(), "crop_image_cache.jpg");
        FragmentActivity r11 = this.$activity;
        Uri r12 = this.$uri;
        this.L$0 = r10;
        this.label = 2;
        Object r13 = BitmapHelperKt.a(r11, r12, r10, this);
        if (r13 != r0) goto L22;
        return r0;
    L22:
        r2 = r10;
        r6 = r13;
        goto L24
    L16:
        if (Intrinsics.areEqual(r9, "image/webp") == true) goto L19;
        r7 = this.$uri;
        goto L27
    L10:
        ResultKt.throwOnFailure(r6);
        FragmentActivity r14 = this.$activity;
        Uri r15 = this.$uri;
        this.label = 1;
        r6 = BitmapHelperKt.d(r14, r15, this);
        if (r6 != r0) goto L13;
        return r0;
    }
}
