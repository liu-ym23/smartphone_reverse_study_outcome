package com.bytedance.ai.applet.login;

import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor;
import java.util.LinkedHashMap;
import java.util.Map;
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
@DebugMetadata(c = "com.bytedance.ai.applet.login.LoginProcessor$startPrivacyFlow$1", f = "LoginProcessor.kt", i = {}, l = {329}, m = "invokeSuspend", n = {}, s = {})
final class LoginProcessor$startPrivacyFlow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appletId;
    int label;

    public LoginProcessor$startPrivacyFlow$1(String r1, Continuation<? super LoginProcessor$startPrivacyFlow$1> r10) {
        this.$appletId = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new LoginProcessor$startPrivacyFlow$1(this.$appletId, r11);
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
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r15);     // Catch: Exception -> L24
    L14:
        if (((Boolean) r15).booleanValue() == false) goto L26;
        com.bytedance.ai.utils.g.a.e("LoginProcessor", "startPrivacyFlow: privacy has been agreed");     // Catch: Exception -> L24
        Map<String, j> r16 = LoginProcessor.c;     // Catch: Exception -> L24
        j r10 = (j) ((LinkedHashMap) r16).get(this.$appletId);     // Catch: Exception -> L24
        if (r10 == null) goto L47;
        AppletAuthTaskMonitor.Session r11 = r10.h;     // Catch: Exception -> L24
        if (r11 == null) goto L47;
        LoginProcessor r12 = LoginProcessor.a;     // Catch: Exception -> L24
        j r17 = (j) ((LinkedHashMap) r16).get(this.$appletId);     // Catch: Exception -> L24
        if (r17 == null) goto L22;
        AppletAuthTaskMonitor.Session r18 = r17.h;     // Catch: Exception -> L24
    L23:
        r12.getClass();     // Catch: Exception -> L24
        r11.d(new AppletAuthTaskMonitor.a("success", LoginProcessor.k(r18), null, null, null, null, null, null, 508));     // Catch: Exception -> L24
        goto L47
    L22:
        r18 = null;
    L47:
        return Unit.INSTANCE;
    L26:
        LoginProcessor r19 = LoginProcessor.a;     // Catch: Exception -> L24
        String r13 = this.$appletId;     // Catch: Exception -> L24
        h.d r14 = h.d.a;     // Catch: Exception -> L24
        r19.getClass();     // Catch: Exception -> L24
        LoginProcessor.l(r13, r14);     // Catch: Exception -> L24
        goto L47
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r15);
        LoginProcessor r110 = LoginProcessor.a;     // Catch: Exception -> L24
        String r20 = this.$appletId;     // Catch: Exception -> L24
        this.label = 1;     // Catch: Exception -> L24
        r15 = LoginProcessor.a(r110, r20, this);     // Catch: Exception -> L24
        if (r15 != r0) goto L14;
        return r0;
    L24:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("LoginProcessor", "Error during startLoginFlow checkPrivacy", e);
        LinkedHashMap r21 = (LinkedHashMap) LoginProcessor.c;
        j r22 = (j) r21.get(this.$appletId);
        if (r22 == null) goto L35;
        LoginProcessor r23 = LoginProcessor.a;
        j r24 = (j) r21.get(this.$appletId);
        if (r24 == null) goto L33;
        AppletAuthTaskMonitor.Session r25 = r24.h;
    L34:
        r23.getClass();
        r22.i = new AppletAuthTaskMonitor.a(MessageIndication.STATUS_FAILED, LoginProcessor.k(r25), "privacy_check", AppletAuthTaskMonitor.ErrorCode.API_FAILED, e.getMessage(), null, null, null, 480);
        goto L35
    L33:
        r25 = null;
    L35:
        j r111 = (j) r21.get(this.$appletId);
        if (r111 == null) goto L45;
        AppletAuthTaskMonitor.Session r112 = r111.h;
        if (r112 == null) goto L45;
        j r26 = (j) r21.get(this.$appletId);
        if (r26 == null) goto L43;
        AppletAuthTaskMonitor.a r27 = r26.i;
        if (r27 == null) goto L43;
    L44:
        r112.d(r27);
    L43:
        r27 = new AppletAuthTaskMonitor.a(MessageIndication.STATUS_FAILED, null, null, null, null, null, null, null, 510);
    L45:
        LoginProcessor.a.getClass();
        LoginProcessor.d = null;
        goto L47
    }
}
