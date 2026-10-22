package com.bytedance.ai.bridge.method.login;

import com.bytedance.ai.applet.login.LoginProcessor;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.privacySetting.AbsGetPrivacySettingMethodIDL;
import com.bytedance.ai.bridge.remote.UserAuthService;
import d3.a0;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/bridge/method/login/GetPrivacySettingMethod;", "Lcom/bytedance/ai/bridge/privacySetting/AbsGetPrivacySettingMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/privacySetting/AbsGetPrivacySettingMethodIDL$EmptyMessageModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/privacySetting/AbsGetPrivacySettingMethodIDL$PrivacySettingResultModel;", "checkPrivacy", "", "appletId", "", "versionTag", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetPrivacySettingMethod extends AbsGetPrivacySettingMethodIDL {

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.login.GetPrivacySettingMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.login.GetPrivacySettingMethod$handle$1", f = "GetPrivacySettingMethod.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $appletId;
        final /* synthetic */ f3.h<AbsGetPrivacySettingMethodIDL.b> $callback;
        final /* synthetic */ String $versionTag;
        int label;
        final /* synthetic */ GetPrivacySettingMethod this$0;

        public AnonymousClass1(GetPrivacySettingMethod r1, String r10, String r11, f3.h<AbsGetPrivacySettingMethodIDL.b> r12, Continuation<? super AnonymousClass1> r13) {
            this.this$0 = r1;
            this.$appletId = r10;
            this.$versionTag = r11;
            this.$callback = r12;
            super(2, r13);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.this$0, this.$appletId, this.$versionTag, this.$callback, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
            return invoke((CoroutineScope) r1, (Continuation) r10);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
            return create(r1, r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            boolean r12 = true;
            if (r11 == 0) goto L9;
            if (r11 != 1) goto L8;
            ResultKt.throwOnFailure(r10);     // Catch: Exception -> L23
        L13:
            boolean r13 = ((Boolean) r10).booleanValue();     // Catch: Exception -> L23
            com.bytedance.ai.utils.g r14 = com.bytedance.ai.utils.g.a;     // Catch: Exception -> L23
            StringBuilder r15 = new StringBuilder("call success, needAuthorization=");     // Catch: Exception -> L23
            if (r13 == true) goto L16;
            boolean r16 = true;
        L17:
            r15.append(r16);     // Catch: Exception -> L23
            r14.i("AISDK_JSB_GetPrivacySettingMethod", r15.toString());     // Catch: Exception -> L23
            f3.h<AbsGetPrivacySettingMethodIDL.b> r17 = this.$callback;     // Catch: Exception -> L23
            Intrinsics.checkNotNullParameter(AbsGetPrivacySettingMethodIDL.b.class, "<this>");     // Catch: Exception -> L23
            BaseModel r18 = k3.c.a(AbsGetPrivacySettingMethodIDL.b.class);     // Catch: Exception -> L23
            AbsGetPrivacySettingMethodIDL.b r19 = (AbsGetPrivacySettingMethodIDL.b) r18;     // Catch: Exception -> L23
            if (r13 == false) goto L21;
            r12 = false;
        L21:
            r19.setNeedAuthorization(r12);     // Catch: Exception -> L23
            f3.h.a.b(r17, (ResultModel) r18);     // Catch: Exception -> L23
        L26:
            return Unit.INSTANCE;
        L16:
            r16 = false;
            goto L17
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r10);
            GetPrivacySettingMethod r20 = this.this$0;     // Catch: Exception -> L23
            String r21 = this.$appletId;     // Catch: Exception -> L23
            String r22 = this.$versionTag;     // Catch: Exception -> L23
            this.label = 1;     // Catch: Exception -> L23
            r10 = GetPrivacySettingMethod.b(r20, r21, r22, this);     // Catch: Exception -> L23
            if (r10 != r1) goto L13;
            return r1;
        L23:
            e = move-exception;
            com.bytedance.ai.utils.g r0 = com.bytedance.ai.utils.g.a;
            StringBuilder r23 = new StringBuilder("call failed, errNo=");
            f3.a r24 = f3.a.f;
            r23.append(r24.a);
            r23.append(", msg=check privacy error");
            r0.e("AISDK_JSB_GetPrivacySettingMethod", r23.toString(), e);
            f3.h.a.a(this.$callback, "Error: " + e.getMessage(), r24, null, 10);
            goto L26
        }
    }

    static {
    }

    public GetPrivacySettingMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r12, ParamModel r13, f3.h r14) {
        Intrinsics.checkNotNullParameter(r12, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsGetPrivacySettingMethodIDL.a) r13, "params");
        Intrinsics.checkNotNullParameter(r14, "callback");
        a0 r15 = r12.getContainerContext();
        if (r15 == null) goto L5;
        String r16 = r15.getAppId();
    L6:
        a0 r17 = r12.getContainerContext();
        if (r17 == null) goto L9;
        String r10 = r17.getAppletId();
    L10:
        com.bytedance.ai.utils.g r18 = com.bytedance.ai.utils.g.a;
        r18.i("AISDK_JSB_GetPrivacySettingMethod", "call start, appId=" + r16 + ", appletId=" + r10);
        if (r10 != null) goto L13;
    L16:
        boolean r19 = true;
    L17:
        if (r19 == false) goto L19;
        StringBuilder r110 = new StringBuilder("call failed, errNo=");
        f3.a r11 = f3.a.f;
        r110.append(r11.a);
        r110.append(", msg=Error: appletId is null or empty");
        r18.e("AISDK_JSB_GetPrivacySettingMethod", r110.toString());
        f3.h.a.a(r14, "Error: appletId is null or empty", r11, null, 10);
        return;
    L19:
        LoginProcessor.a.getClass();
        com.bytedance.ai.applet.login.j r111 = LoginProcessor.h(r10);
        if (r111 == null) goto L25;
        u2.c r112 = r111.a;
        if (r112 == null) goto L25;
        String r113 = r112.d;
        if (r113 == null) goto L25;
    L26:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(this, r10, r113, r14, null), 3, null);
        return;
    L25:
        r113 = "null";
        goto L26
    L13:
        if (r10.length() == 0) goto L16;
        r19 = false;
        goto L17
    L9:
        r10 = null;
        goto L10
    L5:
        r16 = null;
        goto L6
    }

    public static final Object b(GetPrivacySettingMethod r10, String r11, String r12, Continuation r13) {
        r10.getClass();
        if ((r13 instanceof GetPrivacySettingMethod$checkPrivacy$1) == false) goto L7;
        GetPrivacySettingMethod$checkPrivacy$1 r0 = (GetPrivacySettingMethod$checkPrivacy$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r0.label;
        if (r16 == 0) goto L15;
        if (r16 != 1) goto L14;
        ResultKt.throwOnFailure(r14);     // Catch: Exception -> L30
        Object r17 = ((Result) r14).unbox-impl();     // Catch: Exception -> L30
    L20:
        if (Result.isFailure-impl(r17) == false) goto L22;
        Object r18 = null;
    L23:
        Boolean r19 = (Boolean) r18;     // Catch: Exception -> L30
        if (r19 == null) goto L26;
        boolean r20 = r19.booleanValue();     // Catch: Exception -> L30
    L33:
        return Boxing.boxBoolean(r20);
    L26:
        Throwable r21 = Result.exceptionOrNull-impl(r17);     // Catch: Exception -> L30
        if (r21 == null) goto L29;
        throw r21;     // Catch: Exception -> L30
    L29:
        throw new Exception("check result is null, but no error message");     // Catch: Exception -> L30
    L22:
        r18 = r17;
        goto L23
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r14);
        UserAuthService r22 = UserAuthService.a;     // Catch: Exception -> L30
        r0.label = 1;     // Catch: Exception -> L30
        r17 = r22.d(r11, r12, r0);     // Catch: Exception -> L30
        if (r17 != r15) goto L20;
        return r15;
    L30:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("AISDK_JSB_GetPrivacySettingMethod", "checkPrivacy failed " + e.getMessage());
        r20 = false;
    L7:
        r0 = new GetPrivacySettingMethod$checkPrivacy$1(r10, r13);
        goto L8
    }
}
