package com.bytedance.ai.applet.app;

import android.app.ActivityManager;
import android.graphics.Bitmap;
import java.util.concurrent.atomic.AtomicInteger;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.app.AppletFullScreenActivity$updateTaskDescription$1", f = "AppletFullScreenActivity.kt", i = {0}, l = {606}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class AppletFullScreenActivity$updateTaskDescription$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $iconUrl;
    final /* synthetic */ String $title;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AppletFullScreenActivity this$0;

    public AppletFullScreenActivity$updateTaskDescription$1(AppletFullScreenActivity r1, String r10, String r11, Continuation<? super AppletFullScreenActivity$updateTaskDescription$1> r12) {
        this.this$0 = r1;
        this.$iconUrl = r10;
        this.$title = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        AppletFullScreenActivity$updateTaskDescription$1 r0 = new AppletFullScreenActivity$updateTaskDescription$1(this.this$0, this.$iconUrl, this.$title, r11);
        r0.L$0 = r10;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r10);
    L15:
        Bitmap r12 = (Bitmap) r10;
        if (r12 == null) goto L18;
        this.this$0.setTaskDescription(new ActivityManager.TaskDescription(this.$title, r12));
    L20:
        return Unit.INSTANCE;
    L18:
        AppletFullScreenActivity r13 = this.this$0;
        String r14 = this.$iconUrl;
        AtomicInteger r15 = com.bytedance.ai.applet.base.log.d.d;
        r13.c.a("Failed to load bitmap from URL: " + r14, null);
        goto L20
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        CoroutineScope r16 = (CoroutineScope) this.L$0;
        g2.b r17 = this.this$0.d;
        if (r17 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("abilities");
        r17 = null;
    L12:
        String r18 = this.$iconUrl;
        this.L$0 = r16;
        this.label = 1;
        r10 = r17.J(r18, this);
        if (r10 != r0) goto L15;
        return r0;
    }
}
