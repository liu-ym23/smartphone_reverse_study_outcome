package com.larus.bot.impl.feature.edit.feature.bgimage.preview;

import android.net.Uri;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.preview.BotEditAvatarPreviewFragment$initView$1$5$1", f = "BotEditAvatarPreviewFragment.kt", i = {}, l = {300, 307}, m = "invokeSuspend", n = {}, s = {})
final class BotEditAvatarPreviewFragment$initView$1$5$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BotEditAvatarPreviewFragment this$0;

    public BotEditAvatarPreviewFragment$initView$1$5$1(BotEditAvatarPreviewFragment r1, Continuation<? super BotEditAvatarPreviewFragment$initView$1$5$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new BotEditAvatarPreviewFragment$initView$1$5$1(this.this$0, r3);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r9);
    L19:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r9);
    L13:
        Uri r10 = (Uri) r9;
        if (r10 == null) goto L19;
        BotEditAvatarPreviewFragment r2 = this.this$0;
        Uri r4 = Uri.fromFile(new PolarisFileWrapper(r2.requireActivity().getCacheDir(), "bot_edit_bg_cropped.jpg"));
        FLogger.a.i("BotEditAvatarPreviewFragment", "bgImage origin uri is " + r10 + " desUri is " + r4);
        MainCoroutineDispatcher r5 = Dispatchers.getMain();
        BotEditAvatarPreviewFragment$initView$1$5$1$1$1 r6 = new BotEditAvatarPreviewFragment$initView$1$5$1$1$1(r2, r10, r4, null);
        this.label = 2;
        if (BuildersKt.withContext(r5, r6, this) != r0) goto L19;
        return r0;
    L10:
        ResultKt.throwOnFailure(r9);
        BotEditAvatarPreviewFragment r11 = this.this$0;
        this.label = 1;
        int r3 = BotEditAvatarPreviewFragment.p;
        r11.getClass();
        r9 = BuildersKt.withContext(Dispatchers.getIO(), new BotEditAvatarPreviewFragment$getBgBitmapUri$2(r11, null), this);
        if (r9 != r0) goto L13;
        return r0;
    }
}
