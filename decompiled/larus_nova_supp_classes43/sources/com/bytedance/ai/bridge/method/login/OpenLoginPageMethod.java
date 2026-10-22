package com.bytedance.ai.bridge.method.login;

import com.bytedance.ai.applet.login.CustomLoginNavigator;
import com.bytedance.ai.applet.login.LoginProcessor;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.openLoginPage.AbsOpenLoginPageMethodIDL;
import d3.a0;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/login/OpenLoginPageMethod;", "Lcom/bytedance/ai/bridge/openLoginPage/AbsOpenLoginPageMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/openLoginPage/AbsOpenLoginPageMethodIDL$OpenLoginPageRequestModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/openLoginPage/AbsOpenLoginPageMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenLoginPageMethod extends AbsOpenLoginPageMethodIDL {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.login.OpenLoginPageMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.login.OpenLoginPageMethod$handle$1", f = "OpenLoginPageMethod.kt", i = {}, l = {61}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $appletId;
        final /* synthetic */ f3.h<AbsOpenLoginPageMethodIDL.a> $callback;
        final /* synthetic */ AbsOpenLoginPageMethodIDL.b $params;
        int label;

        public AnonymousClass1(String r1, AbsOpenLoginPageMethodIDL.b r10, f3.h<AbsOpenLoginPageMethodIDL.a> r11, Continuation<? super AnonymousClass1> r12) {
            this.$appletId = r1;
            this.$params = r10;
            this.$callback = r11;
            super(2, r12);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.$appletId, this.$params, this.$callback, r11);
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
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r15);
            Object r16 = ((Result) r15).unbox-impl();
        L47:
            f3.h<AbsOpenLoginPageMethodIDL.a> r10 = this.$callback;
            if (Result.isSuccess-impl(r16) == false) goto L50;
            Unit r11 = (Unit) r16;
            Intrinsics.checkNotNullParameter(AbsOpenLoginPageMethodIDL.a.class, "<this>");
            f3.h.a.b(r10, (ResultModel) k3.c.a(AbsOpenLoginPageMethodIDL.a.class));
        L50:
            f3.h<AbsOpenLoginPageMethodIDL.a> r12 = this.$callback;
            Throwable r17 = Result.exceptionOrNull-impl(r16);
            if (r17 == null) goto L57;
            com.bytedance.ai.utils.g.a.e("OpenLoginPageMethod", "openLoginPage failed: " + r17.getMessage());
            String r18 = r17.getMessage();
            if (r18 != null) goto L55;
            r18 = "openLoginPage failed";
        L55:
            f3.h.a.a(r12, r18, null, null, 14);
        L57:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r15);
            LoginProcessor r19 = LoginProcessor.a;
            String r13 = this.$appletId;
            r19.getClass();
            com.bytedance.ai.applet.login.j r110 = LoginProcessor.h(r13);
            if (r110 != null) goto L11;
            com.bytedance.ai.utils.g.a.w("OpenLoginPageMethod", "open login page without loginContext: appletId=" + this.$appletId);
        L11:
            if (r110 == null) goto L13;
            String r14 = r110.f;
        L14:
            CustomLoginNavigator r20 = CustomLoginNavigator.a;
            String r21 = this.$appletId;
            if (r110 == null) goto L21;
            u2.c r22 = r110.a;
            if (r22 == null) goto L21;
            u2.b r23 = r22.f;
            if (r23 == null) goto L21;
            String r24 = r23.a;
        L22:
            if (r110 == null) goto L28;
            u2.c r25 = r110.a;
            if (r25 == null) goto L28;
            u2.b r26 = r25.f;
            if (r26 == null) goto L28;
            String r27 = r26.d;
        L29:
            if (r110 == null) goto L35;
            u2.c r111 = r110.a;
            if (r111 == null) goto L35;
            u2.b r112 = r111.f;
            if (r112 == null) goto L35;
            String r28 = r112.e;
        L36:
            String r113 = this.$params.getUrl();
            CustomLoginNavigator.LaunchSource.Companion.getClass();
            if (Intrinsics.areEqual(r14, "chat") == false) goto L41;
            CustomLoginNavigator.LaunchSource r114 = CustomLoginNavigator.LaunchSource.CHAT;
        L39:
            CustomLoginNavigator.LaunchSource r115 = r114;
            CustomLoginNavigator.LaunchReason r116 = CustomLoginNavigator.LaunchReason.OTHER_LOGIN_METHOD;
            this.label = 1;
            r16 = r20.b(r21, r24, r27, r28, r113, r115, r116, this);
            if (r16 != r0) goto L47;
            return r0;
        L41:
            if (Intrinsics.areEqual(r14, com.bytedance.android.ec.core.event.a.VALUE_DETAIL_TAB) == false) goto L43;
            r114 = CustomLoginNavigator.LaunchSource.FULL_PAGE;
            goto L39
        L43:
            r114 = CustomLoginNavigator.LaunchSource.UNKNOWN;
        L35:
            r28 = null;
        L28:
            r27 = null;
        L21:
            r24 = null;
            goto L22
        L13:
            r14 = null;
            goto L14
        }
    }

    static {
    }

    public OpenLoginPageMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r10, ParamModel r11, final f3.h r12) {
        final AbsOpenLoginPageMethodIDL.b r13 = (AbsOpenLoginPageMethodIDL.b) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        a0 r0 = r10.getContainerContext();
        a0 r14 = r10.getContainerContext();
        if (r14 == null) goto L18;
        final String r15 = r14.getAppletId();
        if (r15 == null) goto L18;
        com.bytedance.ai.applet.moa.k r16 = com.bytedance.ai.applet.moa.k.a;
        if (r0 == null) goto L10;
        String r17 = r0.getConversationId();
    L11:
        if (r0 == null) goto L13;
        String r1 = r0.getUrl();
    L14:
        Function1 r18 = new j(r15, r13, r12);
        Function0 r19 = new k(r12);
        r16.getClass();
        if (com.bytedance.ai.applet.moa.k.d(r17, r1, r15, "open-login flow", r18, r19) == false) goto L17;
        com.bytedance.ai.utils.g.a.i("OpenLoginPageMethod", "MOA consumed callback, skip normal open-login-page flow: applet=".concat(r15));
        return;
    L17:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(r15, r13, r12, null), 3, null);
        return;
    L13:
        r1 = null;
        goto L14
    L10:
        r17 = null;
    L18:
        f3.h.a.a(r12, "appId is null", null, null, 14);
    }
}
