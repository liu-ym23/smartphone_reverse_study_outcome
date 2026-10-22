package com.larus.bot.impl.feature.edit.feature.bgimage.preview;

import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
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
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.preview.BotEditAvatarPreviewFragment$initLauncher$2$1", f = "BotEditAvatarPreviewFragment.kt", i = {0}, l = {173}, m = "invokeSuspend", n = {"destinationUri"}, s = {"L$2"})
final class BotEditAvatarPreviewFragment$initLauncher$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Uri $imageFileUri;
    final /* synthetic */ Uri $originalImageUri;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ BotEditAvatarPreviewFragment this$0;

    public BotEditAvatarPreviewFragment$initLauncher$2$1(BotEditAvatarPreviewFragment r1, Uri r2, Uri r3, Continuation<? super BotEditAvatarPreviewFragment$initLauncher$2$1> r4) {
        this.this$0 = r1;
        this.$imageFileUri = r2;
        this.$originalImageUri = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new BotEditAvatarPreviewFragment$initLauncher$2$1(this.this$0, this.$imageFileUri, this.$originalImageUri, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 != 1) goto L11;
        Uri r2 = (Uri) this.L$2;
        Uri r3 = (Uri) this.L$1;
        BotEditAvatarPreviewFragment r4 = (BotEditAvatarPreviewFragment) this.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L8
    L20:
        int r11 = BotEditAvatarPreviewFragment.p;     // Catch: Throwable -> L8
        r4.X90().dispatchUIAction(new w.e(true, r2, String.valueOf(r3)));     // Catch: Throwable -> L8
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L24:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r10);
        FragmentActivity r12 = this.this$0.getActivity();
        if (r12 == null) goto L24;
        Uri r5 = this.$imageFileUri;
        r4 = this.this$0;
        Uri r6 = this.$originalImageUri;
        if (r5 == null) goto L24;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L8
        Uri r8 = Uri.fromFile(new PolarisFileWrapper(r12.getCacheDir(), "preview_crop_image_reopen_cache"));     // Catch: Throwable -> L8
        CoroutineDispatcher r9 = Dispatchers.getIO();     // Catch: Throwable -> L8
        BotEditAvatarPreviewFragment$initLauncher$2$1$1$1$1$1 r13 = new BotEditAvatarPreviewFragment$initLauncher$2$1$1$1$1$1(r12, r5, r8, null);     // Catch: Throwable -> L8
        this.L$0 = r4;     // Catch: Throwable -> L8
        this.L$1 = r6;     // Catch: Throwable -> L8
        this.L$2 = r8;     // Catch: Throwable -> L8
        this.label = 1;     // Catch: Throwable -> L8
        if (BuildersKt.withContext(r9, r13, this) != r0) goto L19;
        return r0;
    L19:
        r3 = r6;
        r2 = r8;
    L8:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    }
}
