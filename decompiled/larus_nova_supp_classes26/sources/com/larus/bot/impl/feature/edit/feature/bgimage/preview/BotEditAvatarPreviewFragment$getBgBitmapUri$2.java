package com.larus.bot.impl.feature.edit.feature.bgimage.preview;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/net/Uri;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.preview.BotEditAvatarPreviewFragment$getBgBitmapUri$2", f = "BotEditAvatarPreviewFragment.kt", i = {}, l = {402, 413}, m = "invokeSuspend", n = {}, s = {})
final class BotEditAvatarPreviewFragment$getBgBitmapUri$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Uri>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BotEditAvatarPreviewFragment this$0;

    public BotEditAvatarPreviewFragment$getBgBitmapUri$2(BotEditAvatarPreviewFragment r1, Continuation<? super BotEditAvatarPreviewFragment$getBgBitmapUri$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        BotEditAvatarPreviewFragment$getBgBitmapUri$2 r0 = new BotEditAvatarPreviewFragment$getBgBitmapUri$2(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Uri> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r3 = true;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r7);
    L41:
        return r7;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
    L42:
        return (Uri) r7;
    L10:
        ResultKt.throwOnFailure(r7);
        CoroutineScope r8 = (CoroutineScope) this.L$0;
        r7 = this.this$0.g;
        if (r7 != null) goto L41;
        BotEditAvatarPreviewFragment r9 = this.this$0;
        y r2 = (y) r9.X90().getUiState().getValue();
        String r4 = r2.i;
        if (o0.d(r4) == false) goto L27;
        FLogger.a.i("BotEditAvatarPreviewFragment", "originalImgUri is " + r4);
        Uri r5 = UriProtector.parse(r4);
        if (r5 == null) goto L37;
        if (BotEditAvatarPreviewFragment.Y90(r5) == false) goto L19;
        r9.g = r5;
        goto L37
    L19:
        if (r4 == null) goto L24;
        this.label = 1;
        r7 = BotEditAvatarPreviewFragment.V90(r9, r4, this);
        if (r7 != r0) goto L42;
        return r0;
    L24:
        return null;
    L37:
        return r9.g;
    L27:
        if (r2.f == true) goto L38;
        Uri r6 = r2.c.a;
        if (r6 != null) goto L31;
    L33:
        r3 = false;
    L34:
        if (r3 == false) goto L38;
        r9.g = r2.c.a;
        goto L37
    L31:
        if (BotEditAvatarPreviewFragment.Y90(r6) != true) goto L33;
    L38:
        String r10 = String.valueOf(r2.c.a);
        this.label = 2;
        r7 = BotEditAvatarPreviewFragment.V90(r9, r10, this);
        if (r7 != r0) goto L41;
        return r0;
    }
}
