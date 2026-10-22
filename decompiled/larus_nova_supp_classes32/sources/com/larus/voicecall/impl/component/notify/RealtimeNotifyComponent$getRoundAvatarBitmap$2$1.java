package com.larus.voicecall.impl.component.notify;

import android.graphics.Bitmap;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.voicecall.impl.utils.j;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.component.notify.RealtimeNotifyComponent$getRoundAvatarBitmap$2$1", f = "RealtimeNotifyComponent.kt", i = {}, l = {222}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeNotifyComponent$getRoundAvatarBitmap$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    int label;
    final /* synthetic */ RealtimeNotifyComponent this$0;

    public RealtimeNotifyComponent$getRoundAvatarBitmap$2$1(RealtimeNotifyComponent r1, Continuation<? super RealtimeNotifyComponent$getRoundAvatarBitmap$2$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new RealtimeNotifyComponent$getRoundAvatarBitmap$2$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Bitmap> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L19:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        int r11 = j.a;
        RealtimeNotifyComponent r12 = this.this$0;
        int r3 = RealtimeNotifyComponent.w;
        String r4 = ((h88.a) ((e3a.a) r12.n.getValue())).e;
        Bitmap.Config r5 = Bitmap.Config.ARGB_8888;
        this.label = 1;
        if (r4 != null) goto L11;
    L14:
        if (r2 == false) goto L16;
        r10 = null;
    L17:
        if (r10 != r0) goto L19;
        return r0;
    L16:
        r10 = ImageLoaderKt.n(r4, "realtime_call_avatar_utils", r5, null, this, 92);
        goto L17
    L11:
        if (StringsKt.isBlank(r4) == true) goto L14;
        r2 = false;
        goto L14
    }
}
