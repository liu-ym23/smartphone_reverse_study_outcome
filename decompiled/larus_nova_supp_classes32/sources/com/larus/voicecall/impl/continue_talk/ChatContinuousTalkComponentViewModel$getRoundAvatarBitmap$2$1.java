package com.larus.voicecall.impl.continue_talk;

import android.graphics.Bitmap;
import com.larus.image.loader.ImageLoaderKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.continue_talk.ChatContinuousTalkComponentViewModel$getRoundAvatarBitmap$2$1", f = "ChatContinuousTalkComponentViewModel.kt", i = {}, l = {649}, m = "invokeSuspend", n = {}, s = {})
public final class ChatContinuousTalkComponentViewModel$getRoundAvatarBitmap$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ String $botAvatar;
    int label;

    public ChatContinuousTalkComponentViewModel$getRoundAvatarBitmap$2$1(String r1, Continuation<? super ChatContinuousTalkComponentViewModel$getRoundAvatarBitmap$2$1> r2) {
        this.$botAvatar = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ChatContinuousTalkComponentViewModel$getRoundAvatarBitmap$2$1(this.$botAvatar, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Bitmap> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L23:
        return r7;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        int r8 = com.larus.voicecall.impl.utils.j.a;
        String r9 = this.$botAvatar;
        this.label = 1;
        if (r9 != null) goto L11;
    L14:
        boolean r2 = true;
    L16:
        if (r2 == false) goto L18;
        r7 = null;
    L21:
        if (r7 != r0) goto L23;
        return r0;
    L18:
        kotlinx.coroutines.j r3 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
        r3.C();
        ImageLoaderKt.l(r9, "realtime_call_avatar_utils", new com.larus.voicecall.impl.utils.h(r3), null, 52);
        r7 = r3.B();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L21;
        DebugProbesKt.probeCoroutineSuspended(this);
        goto L21
    L11:
        if (StringsKt.isBlank(r9) == true) goto L14;
        r2 = false;
        goto L16
    }
}
