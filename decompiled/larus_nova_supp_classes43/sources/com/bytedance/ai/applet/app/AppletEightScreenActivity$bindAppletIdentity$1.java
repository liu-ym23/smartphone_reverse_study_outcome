package com.bytedance.ai.applet.app;

import com.bytedance.ai.bridge.remote.model.AppMeta;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.app.AppletEightScreenActivity$bindAppletIdentity$1", f = "AppletEightScreenActivity.kt", i = {}, l = {289}, m = "invokeSuspend", n = {}, s = {})
final class AppletEightScreenActivity$bindAppletIdentity$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppletApplication $app;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AppletEightScreenActivity this$0;

    public AppletEightScreenActivity$bindAppletIdentity$1(AppletEightScreenActivity r1, AppletApplication r10, Continuation<? super AppletEightScreenActivity$bindAppletIdentity$1> r11) {
        this.this$0 = r1;
        this.$app = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        AppletEightScreenActivity$bindAppletIdentity$1 r0 = new AppletEightScreenActivity$bindAppletIdentity$1(this.this$0, this.$app, r11);
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
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L15
    L13:
        Object r11 = Result.constructor-impl((AppMeta) r10);     // Catch: Throwable -> L15
    L17:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L20;
        com.bytedance.ai.utils.g.a.e("AppletEightScreenActivity", "Failed to load applet meta info", r12);
    L20:
        String r13 = null;
        if (Result.isFailure-impl(r11) == false) goto L23;
        r11 = null;
    L23:
        AppMeta r14 = (AppMeta) r11;
        if (this.this$0.isFinishing() == true) goto L49;
        if (this.this$0.isDestroyed() == true) goto L49;
        AppletEightScreenActivity r15 = this.this$0;
        if (r14 == null) goto L37;
        String r16 = r14.getAppName();
        if (r16 == null) goto L37;
        if ((!StringsKt.isBlank(r16)) == true) goto L36;
        r16 = null;
    L36:
        if (r16 == null) goto L37;
    L38:
        if (r14 == null) goto L45;
        String r17 = r14.getIconUrl();
        if (r17 == null) goto L45;
        if ((true ^ StringsKt.isBlank(r17)) == false) goto L44;
        r13 = r17;
    L44:
        if (r13 == null) goto L45;
    L46:
        r15.g2(r16, r13);
        return Unit.INSTANCE;
    L45:
        r13 = this.$app.j().b();
    L37:
        r16 = this.$app.j().a;
    L49:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
        CoroutineScope r18 = (CoroutineScope) this.L$0;
        AppletApplication r19 = this.$app;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r10 = r19.k(this);     // Catch: Throwable -> L15
        if (r10 != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }
}
