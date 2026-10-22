package com.bytedance.ai.applet.login;

import com.bytedance.ai.applet.app.OnlineAppletApplication;
import com.bytedance.ai.applet.app.base.ApplicationRouter;
import com.bytedance.ai.applet.grantingV2.LoginStrategy;
import com.bytedance.ai.applet.grantingV2.McpGrantingManager;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.login.CustomLoginNavigator$openLoginPage$2", f = "CustomLoginNavigator.kt", i = {}, l = {103, 123, 125, 137}, m = "invokeSuspend", n = {}, s = {})
public final class CustomLoginNavigator$openLoginPage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
    final /* synthetic */ String $appletId;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ String $messageId;
    final /* synthetic */ CustomLoginNavigator.LaunchReason $reason;
    final /* synthetic */ String $sectionId;
    final /* synthetic */ CustomLoginNavigator.LaunchSource $source;
    final /* synthetic */ String $url;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    public CustomLoginNavigator$openLoginPage$2(String r1, CustomLoginNavigator.LaunchSource r10, CustomLoginNavigator.LaunchReason r11, String r12, String r13, String r14, String r15, Continuation<? super CustomLoginNavigator$openLoginPage$2> r16) {
        this.$appletId = r1;
        this.$source = r10;
        this.$reason = r11;
        this.$messageId = r12;
        this.$conversationId = r13;
        this.$sectionId = r14;
        this.$url = r15;
        super(2, r16);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new CustomLoginNavigator$openLoginPage$2(this.$appletId, this.$source, this.$reason, this.$messageId, this.$conversationId, this.$sectionId, this.$url, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<Unit>> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.label;
        if (r10 == 0) goto L14;
        if (r10 == 1) goto L13;
        if (r10 == 2) goto L11;
        if (r10 == 3) goto L11;
        if (r10 != 4) goto L10;
        CustomLoginNavigator.LaunchSource r11 = (CustomLoginNavigator.LaunchSource) this.L$3;
        String r12 = (String) this.L$2;
        String r13 = (String) this.L$1;
        Object r14 = this.L$0;
        ResultKt.throwOnFailure(r18);
        com.bytedance.ai.applet.grantingV2.f r15 = null;
    L49:
        CustomLoginNavigator.LaunchSource r16 = r11;
        String r17 = r12;
        String r19 = r13;
    L52:
        if (r16 != CustomLoginNavigator.LaunchSource.CHAT) goto L86;
        McpGrantingManager.a.getClass();
        Intrinsics.checkNotNullParameter(r19, "appletId");
        if (r17 != null) goto L56;
    L59:
        boolean r20 = true;
    L61:
        if (r20 == false) goto L63;
        com.bytedance.ai.utils.g.a.w("McpGrantingManagerV2", "stopLoginCardLoading: msgID is blank for appletId=" + r19);
    L81:
        CustomLoginNavigator r21 = CustomLoginNavigator.a;
        r4.f r22 = r4.a.n;
        if (r22 != null) goto L84;
        com.bytedance.ai.utils.g.a.w("CustomLoginNavigator", "registerHostMainActivityLifecycleCallback: lifecycleDepend is null, appletId=".concat(r19));
        goto L86
    L84:
        CustomLoginNavigator.c(r19);
        d r23 = new d(r19);
        CustomLoginNavigator.c.put(r19, r23);
        r22.b(r23);
        goto L86
    L63:
        com.bytedance.ai.applet.grantingV2.f r24 = McpGrantingManager.b.get(r17);
        if (r24 != null) goto L66;
    L80:
        com.bytedance.ai.utils.g.a.w("McpGrantingManagerV2", "stopLoginCardLoading: No login granting context found for appletId=" + r19 + ", msgID=" + r17);
        goto L81
    L66:
        if (Intrinsics.areEqual(r24.c.a, r19) == true) goto L68;
    L70:
        boolean r110 = false;
    L71:
        if (r110 == true) goto L74;
        r24 = r15;
    L74:
        if (r24 == null) goto L80;
        r24.j.set(false);
        r24.k.set(0);
        com.bytedance.ai.utils.g r25 = com.bytedance.ai.utils.g.a;
        r25.i("McpGrantingManagerV2", "stopLoginCardLoading: reset action handling, appletId=" + r19 + ", msgID=" + r17);
        u2.a r26 = r24.h;
        if (r26 == null) goto L79;
        u2.a r27 = u2.a.a(r26, false, false, 511);
        r24.h = r27;
        r24.d.a(r17, r27);
        goto L81
    L79:
        r25.w("McpGrantingManagerV2", "stopLoginCardLoading: currentCardModel is null for appletId=" + r19);
        goto L81
    L68:
        if ((r24.g instanceof LoginStrategy) == false) goto L70;
        r110 = true;
        goto L71
    L56:
        if (StringsKt.isBlank(r17) == true) goto L59;
        r20 = false;
    L86:
        return Result.box-impl(r14);
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r18);
        Object r28 = ((Result) r18).unbox-impl();
    L12:
        r14 = r28;
        r19 = this.$appletId;
        r17 = this.$messageId;
        String r111 = this.$url;
        CustomLoginNavigator.LaunchSource r112 = this.$source;
        CustomLoginNavigator.LaunchReason r113 = this.$reason;
        if (Result.isSuccess-impl(r14) == false) goto L86;
        Unit r114 = (Unit) r14;
        CustomLoginNavigator.b.put(r19, new CustomLoginNavigator.a(r19, r17, r111, r112, r113));
        if (r113 != CustomLoginNavigator.LaunchReason.OTHER_LOGIN_METHOD) goto L50;
        this.L$0 = r14;
        this.L$1 = r19;
        this.L$2 = r17;
        this.L$3 = r112;
        this.label = 4;
        LoginProcessor.a.getClass();
        r15 = null;
        Object r29 = BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new LoginProcessor$dismissLoginDrawerIfNeeded$2(null), this);
        if (r29 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L46;
        r29 = Unit.INSTANCE;
    L46:
        if (r29 != r1) goto L48;
        return r1;
    L48:
        r13 = r19;
        r11 = r112;
        r12 = r17;
        goto L49
    L50:
        r15 = null;
        r16 = r112;
        goto L52
    L13:
        ResultKt.throwOnFailure(r18);
        Object r30 = r18;
    L18:
        if ((r30 instanceof OnlineAppletApplication) == false) goto L20;
        OnlineAppletApplication r31 = (OnlineAppletApplication) r30;
    L21:
        if (r31 != null) goto L25;
        IllegalStateException r32 = new IllegalStateException("Online app " + this.$appletId + " not found");
        com.bytedance.ai.utils.g.a.e("CustomLoginNavigator", r32.getMessage());
        Result.Companion r33 = Result.Companion;
        return Result.box-impl(Result.constructor-impl(ResultKt.createFailure(r32)));
    L25:
        if (this.$source != CustomLoginNavigator.LaunchSource.CHAT) goto L27;
        boolean r115 = true;
    L28:
        com.bytedance.ai.utils.g.a.i("CustomLoginNavigator", "openLoginPage: appletId=" + this.$appletId + ", source=" + this.$source.getValue() + ", reason=" + this.$reason.getValue() + ", isFromChat=" + r115);
        if (r115 == false) goto L31;
        r31.h().e().f(this.$messageId, this.$conversationId, this.$sectionId);
    L31:
        if (r115 == false) goto L35;
        ApplicationRouter r34 = r31.h().d();
        String r35 = this.$url;
        this.label = 2;
        r28 = r34.i(r35, null, this);
        if (r28 != r1) goto L12;
        return r1;
    L35:
        ApplicationRouter r36 = r31.h().d();
        String r37 = this.$url;
        this.label = 3;
        r28 = r36.e(r37, null, this);
        if (r28 != r1) goto L12;
        return r1;
    L27:
        r115 = false;
        goto L28
    L20:
        r31 = null;
        goto L21
    L14:
        ResultKt.throwOnFailure(r18);
        AppletAppManagerService r38 = AppletAppManagerService.INSTANCE;
        String r116 = this.$appletId;
        this.label = 1;
        r30 = r38.d(r116, this);
        if (r30 != r1) goto L18;
        return r1;
    }
}
