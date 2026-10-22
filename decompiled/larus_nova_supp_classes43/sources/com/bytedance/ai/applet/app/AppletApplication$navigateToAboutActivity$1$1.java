package com.bytedance.ai.applet.app;

import android.content.Intent;
import com.bytedance.ai.applet.app.view.AppletThemeMode;
import com.bytedance.ai.bridge.remote.model.Agreements;
import com.bytedance.ai.bridge.remote.model.AppMeta;
import com.bytedance.ai.model.objects.Icons;
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
@DebugMetadata(c = "com.bytedance.ai.applet.app.AppletApplication$navigateToAboutActivity$1$1", f = "AppletApplication.kt", i = {}, l = {529}, m = "invokeSuspend", n = {}, s = {})
final class AppletApplication$navigateToAboutActivity$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppletAppActivity $activity;
    int label;
    final /* synthetic */ AppletApplication this$0;

    public AppletApplication$navigateToAboutActivity$1$1(AppletApplication r1, AppletAppActivity r10, Continuation<? super AppletApplication$navigateToAboutActivity$1$1> r11) {
        this.this$0 = r1;
        this.$activity = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AppletApplication$navigateToAboutActivity$1$1(this.this$0, this.$activity, r11);
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
        ResultKt.throwOnFailure(r10);
    L11:
        AppMeta r11 = (AppMeta) r10;
        if (r11 == null) goto L15;
        String r12 = r11.getIconUrl();
        if (r12 == null) goto L15;
    L29:
        if (r11 == null) goto L32;
        String r13 = r11.getAppName();
        if (r13 == null) goto L32;
    L33:
        if (r11 == null) goto L36;
        String r14 = r11.getDescription();
        if (r14 == null) goto L36;
    L37:
        String r15 = "";
        if (r11 == null) goto L43;
        Agreements r16 = r11.getAgreements();
        if (r16 == null) goto L43;
        String r17 = r16.getTermsOfServiceUrl();
        if (r17 == null) goto L43;
    L44:
        if (r11 == null) goto L51;
        Agreements r18 = r11.getAgreements();
        if (r18 == null) goto L51;
        String r19 = r18.getPrivacyPolicyUrl();
        if (r19 == null) goto L51;
        r15 = r19;
    L51:
        Intent r20 = new Intent(this.$activity, AppletAboutActivity.class);
        AppletApplication r21 = this.this$0;
        r20.putExtra("extra_app_name", r13);
        r20.putExtra("extra_app_desc", r14);
        r20.putExtra("extra_app_icon", r12);
        r20.putExtra("extra_user_agreement_url", r17);
        r20.putExtra("extra_privacy_policy_url", r15);
        if (r21.j().X == false) goto L54;
        AppletThemeMode r22 = AppletThemeMode.FOLLOW_SYSTEM;
    L55:
        Intrinsics.checkNotNullParameter(r20, "<this>");
        if (r22 != null) goto L58;
        r20.removeExtra("launch_applet_theme_mode");
    L59:
        this.$activity.startActivity(r20);
        return Unit.INSTANCE;
    L58:
        Intrinsics.checkNotNull(r20.putExtra("launch_applet_theme_mode", r22.name()));
        goto L59
    L54:
        r22 = AppletThemeMode.LIGHT;
    L43:
        r17 = "";
    L36:
        r14 = this.this$0.j().f;
    L32:
        r13 = this.this$0.j().a;
    L15:
        Icons r23 = this.this$0.j().g;
        if (r23 == null) goto L18;
        r12 = r23.get3x();
    L19:
        if (r12 != null) goto L29;
        Icons r24 = this.this$0.j().g;
        if (r24 == null) goto L23;
        r12 = r24.get2x();
    L24:
        if (r12 != null) goto L29;
        Icons r25 = this.this$0.j().g;
        if (r25 == null) goto L28;
        r12 = r25.get1x();
        goto L29
    L28:
        r12 = null;
        goto L29
    L23:
        r12 = null;
        goto L24
    L18:
        r12 = null;
        goto L19
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        AppletApplication r26 = this.this$0;
        this.label = 1;
        r10 = r26.k(this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
