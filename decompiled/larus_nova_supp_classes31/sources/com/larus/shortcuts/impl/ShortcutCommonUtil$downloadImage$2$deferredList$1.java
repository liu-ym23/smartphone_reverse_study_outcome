package com.larus.shortcuts.impl;

import android.graphics.Bitmap;
import com.tencent.open.log.TraceLevel;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.shortcuts.impl.ShortcutCommonUtil$downloadImage$2$deferredList$1", f = "ShortcutCommonUtil.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
public final class ShortcutCommonUtil$downloadImage$2$deferredList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ tw9.a $shortcutInfo;
    Object L$0;
    int label;

    public ShortcutCommonUtil$downloadImage$2$deferredList$1(tw9.a r1, Continuation<? super ShortcutCommonUtil$downloadImage$2$deferredList$1> r2) {
        this.$shortcutInfo = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ShortcutCommonUtil$downloadImage$2$deferredList$1(this.$shortcutInfo, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        tw9.a r2 = (tw9.a) this.L$0;
        ResultKt.throwOnFailure(r5);
    L14:
        tw9.a r3 = r2;
        Bitmap r4 = (Bitmap) r5;
        tw9.a r6 = r3;
    L16:
        r6.a = r4;
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        r6 = this.$shortcutInfo;
        if (r6.a() == null) goto L15;
        int r7 = ShortcutCommonUtil.a;
        String r8 = this.$shortcutInfo.a();
        Intrinsics.checkNotNull(r8);
        this.L$0 = r6;
        this.label = 1;
        Object r9 = ShortcutCommonUtil.a(r8, this);
        if (r9 != r0) goto L13;
        return r0;
    L13:
        r2 = r6;
        r5 = r9;
        goto L14
    L15:
        r4 = null;
        goto L16
    }
}
