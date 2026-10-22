package com.bytedance.ai.applet.login;

import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor;
import com.bytedance.android.ec.core.utils.FontWeight;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.login.LoginProcessor$startLoginFlow$1", f = "LoginProcessor.kt", i = {}, l = {297, FontWeight.WEIGHT_300}, m = "invokeSuspend", n = {}, s = {})
final class LoginProcessor$startLoginFlow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appletId;
    int label;

    public LoginProcessor$startLoginFlow$1(String r1, Continuation<? super LoginProcessor$startLoginFlow$1> r10) {
        this.$appletId = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new LoginProcessor$startLoginFlow$1(this.$appletId, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L9;
        ResultKt.throwOnFailure(r15);     // Catch: Exception -> L23
    L43:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r15);     // Catch: Exception -> L23
    L17:
        if (((Boolean) r15).booleanValue() == false) goto L21;
        LoginProcessor r16 = LoginProcessor.a;     // Catch: Exception -> L23
        String r10 = this.$appletId;     // Catch: Exception -> L23
        this.label = 2;     // Catch: Exception -> L23
        if (LoginProcessor.b(r16, r10, this) != r0) goto L43;
        return r0;
    L21:
        LoginProcessor r17 = LoginProcessor.a;     // Catch: Exception -> L23
        String r11 = this.$appletId;     // Catch: Exception -> L23
        h.d r12 = h.d.a;     // Catch: Exception -> L23
        r17.getClass();     // Catch: Exception -> L23
        LoginProcessor.l(r11, r12);     // Catch: Exception -> L23
        goto L43
    L12:
        ResultKt.throwOnFailure(r15);
        LoginProcessor r18 = LoginProcessor.a;     // Catch: Exception -> L23
        String r13 = this.$appletId;     // Catch: Exception -> L23
        this.label = 1;     // Catch: Exception -> L23
        r15 = LoginProcessor.a(r18, r13, this);     // Catch: Exception -> L23
        if (r15 != r0) goto L17;
        return r0;
    L23:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("LoginProcessor", "Error during startLoginFlow checkPrivacy", e);
        LinkedHashMap r14 = (LinkedHashMap) LoginProcessor.c;
        j r19 = (j) r14.get(this.$appletId);
        if (r19 == null) goto L31;
        LoginProcessor r20 = LoginProcessor.a;
        j r21 = (j) r14.get(this.$appletId);
        if (r21 == null) goto L29;
        AppletAuthTaskMonitor.Session r22 = r21.h;
    L30:
        r20.getClass();
        r19.i = new AppletAuthTaskMonitor.a(MessageIndication.STATUS_FAILED, LoginProcessor.k(r22), "privacy_check", AppletAuthTaskMonitor.ErrorCode.API_FAILED, e.getMessage(), null, null, null, 480);
        goto L31
    L29:
        r22 = null;
    L31:
        j r110 = (j) r14.get(this.$appletId);
        if (r110 == null) goto L41;
        AppletAuthTaskMonitor.Session r111 = r110.h;
        if (r111 == null) goto L41;
        j r23 = (j) r14.get(this.$appletId);
        if (r23 == null) goto L39;
        AppletAuthTaskMonitor.a r24 = r23.i;
        if (r24 == null) goto L39;
    L40:
        r111.d(r24);
    L39:
        r24 = new AppletAuthTaskMonitor.a(MessageIndication.STATUS_FAILED, null, null, null, null, null, null, null, 510);
    L41:
        LoginProcessor.a.getClass();
        LoginProcessor.d = null;
        goto L43
    }
}
