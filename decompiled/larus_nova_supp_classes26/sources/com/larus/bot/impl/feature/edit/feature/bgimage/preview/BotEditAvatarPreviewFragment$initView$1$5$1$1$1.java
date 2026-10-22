package com.larus.bot.impl.feature.edit.feature.bgimage.preview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.activity.result.ActivityResultLauncher;
import com.yalantis.ucrop.UCropActivity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.preview.BotEditAvatarPreviewFragment$initView$1$5$1$1$1", f = "BotEditAvatarPreviewFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class BotEditAvatarPreviewFragment$initView$1$5$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Uri $desUri;
    final /* synthetic */ Uri $uri;
    int label;
    final /* synthetic */ BotEditAvatarPreviewFragment this$0;

    public BotEditAvatarPreviewFragment$initView$1$5$1$1$1(BotEditAvatarPreviewFragment r1, Uri r2, Uri r3, Continuation<? super BotEditAvatarPreviewFragment$initView$1$5$1$1$1> r4) {
        this.this$0 = r1;
        this.$uri = r2;
        this.$desUri = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new BotEditAvatarPreviewFragment$initView$1$5$1$1$1(this.this$0, this.$uri, this.$desUri, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r7);
        BotEditAvatarPreviewFragment r8 = this.this$0;
        ActivityResultLauncher<Intent> r0 = r8.i;
        if (r0 == null) goto L8;
        Uri r1 = this.$uri;
        Uri r2 = this.$desUri;
        Intent r3 = new Intent();
        Bundle r4 = new Bundle();
        r4.putParcelable("com.yalantis.ucrop.InputUri", r1);
        r4.putParcelable("com.yalantis.ucrop.OutputUri", r2);
        r4.putFloat("com.yalantis.ucrop.AspectRatioX", 9.0f);
        r4.putFloat("com.yalantis.ucrop.AspectRatioY", 16.0f);
        r3.setClass(r8.requireActivity(), UCropActivity.class);
        r3.putExtras(r4);
        r0.launch(r3);
        r8.n = true;
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
