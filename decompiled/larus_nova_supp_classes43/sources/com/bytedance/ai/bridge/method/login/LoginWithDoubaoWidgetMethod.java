package com.bytedance.ai.bridge.method.login;

import com.bytedance.ai.applet.login.LoginProcessor;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.login.AbsLoginWithDoubaoWidgetMethodIDL;
import com.bytedance.ai.bridge.remote.model.PrivacyCard;
import com.bytedance.ai.bridge.remote.model.PrivacyInfo;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor;
import d3.a0;
import java.security.SecureRandom;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J$\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ai/bridge/method/login/LoginWithDoubaoWidgetMethod;", "Lcom/bytedance/ai/bridge/login/AbsLoginWithDoubaoWidgetMethodIDL;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/login/AbsLoginWithDoubaoWidgetMethodIDL$LoginWithWidgetRequestModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/login/AbsLoginWithDoubaoWidgetMethodIDL$LoginWithWidgetResultModel;", "convertToLocalData", "Lkotlin/Pair;", "Lcom/bytedance/ai/applet/granting/DoubaoAppsMeta;", "Lcom/bytedance/ai/applet/granting/LocalLoginData;", "card", "Lcom/bytedance/ai/bridge/remote/model/PrivacyCard;", "phoneMask", "", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LoginWithDoubaoWidgetMethod extends AbsLoginWithDoubaoWidgetMethodIDL {
    public static final /* synthetic */ int c = 0;
    public final CoroutineScope b;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.login.LoginWithDoubaoWidgetMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.login.LoginWithDoubaoWidgetMethod$handle$1", f = "LoginWithDoubaoWidgetMethod.kt", i = {3, 3}, l = {62, 83, 103, 113, 156}, m = "invokeSuspend", n = {"privacyCard", "phoneMask"}, s = {"L$0", "L$1"})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $appletId;
        final /* synthetic */ AppletAuthTaskMonitor.Session $authTaskSession;
        final /* synthetic */ f3.h<AbsLoginWithDoubaoWidgetMethodIDL.b> $callback;
        final /* synthetic */ boolean $isLoginFlow;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ LoginWithDoubaoWidgetMethod this$0;

        /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.login.LoginWithDoubaoWidgetMethod$handle$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.bytedance.ai.bridge.method.login.LoginWithDoubaoWidgetMethod$handle$1$1", f = "LoginWithDoubaoWidgetMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00261 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ f3.h<AbsLoginWithDoubaoWidgetMethodIDL.b> $callback;
            final /* synthetic */ String $errorMsg;
            int label;

            public C00261(f3.h<AbsLoginWithDoubaoWidgetMethodIDL.b> r1, String r10, Continuation<? super C00261> r11) {
                this.$callback = r1;
                this.$errorMsg = r10;
                super(2, r11);
            }

            public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
                return new C00261(this.$callback, this.$errorMsg, r11);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
                return invoke((CoroutineScope) r1, (Continuation) r10);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
                return create(r1, r10).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r10) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r10);
                f3.h.a.a(this.$callback, this.$errorMsg, f3.a.f, null, 10);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.login.LoginWithDoubaoWidgetMethod$handle$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.bytedance.ai.bridge.method.login.LoginWithDoubaoWidgetMethod$handle$1$2", f = "LoginWithDoubaoWidgetMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ f3.h<AbsLoginWithDoubaoWidgetMethodIDL.b> $callback;
            final /* synthetic */ String $errorMsg;
            int label;

            public AnonymousClass2(f3.h<AbsLoginWithDoubaoWidgetMethodIDL.b> r1, String r10, Continuation<? super AnonymousClass2> r11) {
                this.$callback = r1;
                this.$errorMsg = r10;
                super(2, r11);
            }

            public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
                return new AnonymousClass2(this.$callback, this.$errorMsg, r11);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
                return invoke((CoroutineScope) r1, (Continuation) r10);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
                return create(r1, r10).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r10) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r10);
                f3.h.a.a(this.$callback, this.$errorMsg, f3.a.m, null, 10);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.login.LoginWithDoubaoWidgetMethod$handle$1$5, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.bytedance.ai.bridge.method.login.LoginWithDoubaoWidgetMethod$handle$1$5", f = "LoginWithDoubaoWidgetMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ u2.c $appMeta;
            final /* synthetic */ AppletAuthTaskMonitor.Session $authTaskSession;
            final /* synthetic */ f3.h<AbsLoginWithDoubaoWidgetMethodIDL.b> $callback;
            final /* synthetic */ boolean $isLoginFlow;
            final /* synthetic */ u2.j $relatedData;
            int label;

            public AnonymousClass5(boolean r1, u2.c r10, u2.j r11, f3.h<AbsLoginWithDoubaoWidgetMethodIDL.b> r12, AppletAuthTaskMonitor.Session r13, Continuation<? super AnonymousClass5> r14) {
                this.$isLoginFlow = r1;
                this.$appMeta = r10;
                this.$relatedData = r11;
                this.$callback = r12;
                this.$authTaskSession = r13;
                super(2, r14);
            }

            public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
                return new AnonymousClass5(this.$isLoginFlow, this.$appMeta, this.$relatedData, this.$callback, this.$authTaskSession, r11);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
                return invoke((CoroutineScope) r1, (Continuation) r10);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
                return create(r1, r10).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r10) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L11;
                ResultKt.throwOnFailure(r10);
                if (this.$isLoginFlow == false) goto L7;
                LoginProcessor r11 = LoginProcessor.a;
                u2.c r12 = this.$appMeta;
                u2.j r13 = this.$relatedData;
                f3.h<AbsLoginWithDoubaoWidgetMethodIDL.b> r14 = this.$callback;
                AppletAuthTaskMonitor.Session r15 = this.$authTaskSession;
                r11.getClass();
                Intrinsics.checkNotNullParameter(r12, "appMeta");
                Intrinsics.checkNotNullParameter(r13, "relatedData");
                Intrinsics.checkNotNullParameter(r14, "callback");
                com.bytedance.ai.utils.g.a.i("LoginProcessor", "handleLoginFromJSB triggered for applet: " + r12.a);
                LoginProcessor.e(r12, r13, r14, com.bytedance.android.ec.core.event.a.VALUE_DETAIL_TAB, r15);
            L9:
                return Unit.INSTANCE;
            L7:
                LoginProcessor r16 = LoginProcessor.a;
                u2.c r17 = this.$appMeta;
                u2.j r18 = this.$relatedData;
                f3.h<AbsLoginWithDoubaoWidgetMethodIDL.b> r19 = this.$callback;
                AppletAuthTaskMonitor.Session r20 = this.$authTaskSession;
                r16.getClass();
                Intrinsics.checkNotNullParameter(r17, "appMeta");
                Intrinsics.checkNotNullParameter(r18, "relatedData");
                Intrinsics.checkNotNullParameter(r19, "callback");
                com.bytedance.ai.utils.g.a.i("LoginProcessor", "handlePrivacyFromJSB triggered for applet: " + r17.a);
                LoginProcessor.f(r17, r18, r19, com.bytedance.android.ec.core.event.a.VALUE_DETAIL_TAB, r20);
                goto L9
            L11:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(AppletAuthTaskMonitor.Session r1, boolean r10, LoginWithDoubaoWidgetMethod r11, String r12, f3.h<AbsLoginWithDoubaoWidgetMethodIDL.b> r13, Continuation<? super AnonymousClass1> r14) {
            this.$authTaskSession = r1;
            this.$isLoginFlow = r10;
            this.this$0 = r11;
            this.$appletId = r12;
            this.$callback = r13;
            super(2, r14);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.$authTaskSession, this.$isLoginFlow, this.this$0, this.$appletId, this.$callback, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
            return invoke((CoroutineScope) r1, (Continuation) r10);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
            return create(r1, r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r33) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r10 = this.label;
            boolean r11 = true;
            if (r10 == 0) goto L16;
            if (r10 == 1) goto L15;
            if (r10 == 2) goto L14;
            if (r10 == 3) goto L13;
            if (r10 == 4) goto L12;
            if (r10 != 5) goto L11;
            ResultKt.throwOnFailure(r33);
        L105:
            return Unit.INSTANCE;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            Ref.ObjectRef r12 = (Ref.ObjectRef) this.L$1;
            PrivacyCard r13 = (PrivacyCard) this.L$0;
            ResultKt.throwOnFailure(r33);
            PrivacyCard r14 = r13;
            Object r15 = r33;
        L50:
            Object r16 = ((Result) r15).unbox-impl();
            AppletAuthTaskMonitor.Session r17 = this.$authTaskSession;
            f3.h<AbsLoginWithDoubaoWidgetMethodIDL.b> r18 = this.$callback;
            if (Result.isSuccess-impl(r16) == false) goto L60;
            String r19 = (String) r16;
            if (r19.length() == 0) goto L56;
            r11 = false;
        L56:
            if (r11 == false) goto L59;
            com.bytedance.ai.utils.g r20 = com.bytedance.ai.utils.g.a;
            StringBuilder r21 = new StringBuilder("call failed, errNo=");
            f3.a r22 = f3.a.m;
            r21.append(r22.a);
            r21.append(", msg=Failed to get phone mask");
            r20.e("AISDK_JSB_LoginWithDoubaoWidgetMethod", r21.toString());
            r17.d(new AppletAuthTaskMonitor.a(MessageIndication.STATUS_FAILED, "AppletPageLoginManager.finishLoginTask", "get_phone_number", AppletAuthTaskMonitor.ErrorCode.INVALID_RESPONSE, "Failed to get phone mask", null, null, null, 480));
            f3.h.a.a(r18, "Failed to get phone mask", r22, null, 10);
            return Unit.INSTANCE;
        L59:
            r12.element = r19;
            com.bytedance.ai.utils.g.a.i("AISDK_JSB_LoginWithDoubaoWidgetMethod", "Successfully fetched phone mask");
        L60:
            AppletAuthTaskMonitor.Session r23 = this.$authTaskSession;
            f3.h<AbsLoginWithDoubaoWidgetMethodIDL.b> r24 = this.$callback;
            Throwable r25 = Result.exceptionOrNull-impl(r16);
            if (r25 == null) goto L64;
            String r26 = "Failed to get phone mask, Reason: " + r25.getMessage();
            com.bytedance.ai.utils.g r27 = com.bytedance.ai.utils.g.a;
            StringBuilder r28 = new StringBuilder("call failed, errNo=");
            f3.a r29 = f3.a.f;
            r28.append(r29.a);
            r28.append(", msg=");
            r28.append(r26);
            r27.e("AISDK_JSB_LoginWithDoubaoWidgetMethod", r28.toString());
            r23.d(new AppletAuthTaskMonitor.a(MessageIndication.STATUS_FAILED, "AppletPageLoginManager.finishLoginTask", "get_phone_number", AppletAuthTaskMonitor.ErrorCode.API_FAILED, r25.getMessage(), null, null, null, 480));
            f3.h.a.a(r24, r26, r29, null, 10);
            return Unit.INSTANCE;
        L64:
            PrivacyCard r31 = r14;
            Ref.ObjectRef r30 = r12;
            PrivacyCard r32 = r31;
        L65:
            LoginWithDoubaoWidgetMethod r34 = this.this$0;
            String r110 = (String) r30.element;
            int r35 = LoginWithDoubaoWidgetMethod.c;
            r34.getClass();
            String r36 = r32.getDoubaoMiniAppKey();
            if (r36 != null) goto L68;
            String r111 = "";
        L69:
            String r37 = r32.getDoubaoMiniAppName();
            if (r37 != null) goto L72;
            r37 = "未知应用";
        L72:
            String r210 = r37;
            String r38 = r32.getDoubaoMiniAppIcon();
            if (r38 != null) goto L75;
            String r211 = "";
        L76:
            String r39 = r32.getDoubaoMiniAppVersion();
            if (r39 != null) goto L79;
            String r212 = "";
        L80:
            u2.c r40 = new u2.c(r111, r210, r211, r212, null, new u2.b("", "", "", "", "", "", null));
            String r41 = r32.getDoubaoMiniAppDescription();
            if (r41 != null) goto L83;
            r41 = "申请使用你的帐号信息";
        L83:
            String r112 = r41;
            PrivacyInfo r42 = r32.getPrivacyInfo();
            if (r42 == null) goto L89;
            String r43 = r42.getPrivacyUrl();
            if (r43 == null) goto L89;
            String r113 = r43;
        L90:
            PrivacyInfo r44 = r32.getPrivacyInfo();
            if (r44 == null) goto L96;
            String r45 = r44.getTermsOfServiceUrl();
            if (r45 == null) goto L96;
            String r114 = r45;
        L97:
            PrivacyInfo r46 = r32.getPrivacyInfo();
            if (r46 == null) goto L100;
            String r115 = r46.getPrivacyContent();
        L101:
            Pair r47 = new Pair(r40, new u2.j(r113, r114, r115, r110, r112, null, null));
            u2.c r116 = (u2.c) r47.component1();
            u2.j r117 = (u2.j) r47.component2();
            MainCoroutineDispatcher r48 = Dispatchers.getMain();
            AnonymousClass5 r49 = new AnonymousClass5(this.$isLoginFlow, r116, r117, this.$callback, this.$authTaskSession, null);
            this.L$0 = null;
            this.L$1 = null;
            this.label = 5;
            if (BuildersKt.withContext(r48, r49, this) != r1) goto L105;
            return r1;
        L100:
            r115 = null;
        L96:
            r114 = "";
        L89:
            r113 = "";
            goto L90
        L79:
            r212 = r39;
            goto L80
        L75:
            r211 = r38;
            goto L76
        L68:
            r111 = r36;
            goto L69
        L13:
            ResultKt.throwOnFailure(r33);
        L40:
            return Unit.INSTANCE;
        L14:
            ResultKt.throwOnFailure(r33);
        L33:
            return Unit.INSTANCE;
        L15:
            ResultKt.throwOnFailure(r33);
            Object r50 = r33;
        L19:
            Object r51 = ((Result) r50).unbox-impl();
            if (Result.isFailure-impl(r51) == false) goto L34;
            StringBuilder r52 = new StringBuilder("Failed to checkPrivacyOrLoginStatus: ");
            Throwable r53 = Result.exceptionOrNull-impl(r51);
            if (r53 == null) goto L24;
            String r54 = r53.getMessage();
        L25:
            r52.append(r54);
            String r55 = r52.toString();
            com.bytedance.ai.utils.g.a.e("AISDK_JSB_LoginWithDoubaoWidgetMethod", "call failed, errNo=" + f3.a.f.a + ", msg=" + r55, Result.exceptionOrNull-impl(r51));
            AppletAuthTaskMonitor.Session r56 = this.$authTaskSession;
            AppletAuthTaskMonitor.ErrorCode r118 = AppletAuthTaskMonitor.ErrorCode.API_FAILED;
            Throwable r57 = Result.exceptionOrNull-impl(r51);
            if (r57 == null) goto L28;
            String r119 = r57.getMessage();
        L29:
            r56.d(new AppletAuthTaskMonitor.a(MessageIndication.STATUS_FAILED, "AppletPageLoginManager.finishLoginTask", "privacy_check", r118, r119, null, null, null, 480));
            MainCoroutineDispatcher r58 = Dispatchers.getMain();
            C00261 r59 = new C00261(this.$callback, r55, null);
            this.label = 2;
            if (BuildersKt.withContext(r58, r59, this) != r1) goto L33;
            return r1;
        L28:
            r119 = null;
            goto L29
        L24:
            r54 = null;
            goto L25
        L34:
            ResultKt.throwOnFailure(r51);
            r32 = ((p4.i) r51).b;
            if (r32 != null) goto L41;
            com.bytedance.ai.utils.g.a.e("AISDK_JSB_LoginWithDoubaoWidgetMethod", "call failed, errNo=" + f3.a.m.a + ", msg=checkPrivacyOrLoginStatus succeeded but privacyCard is null");
            this.$authTaskSession.d(new AppletAuthTaskMonitor.a(MessageIndication.STATUS_FAILED, "AppletPageLoginManager.finishLoginTask", "privacy_check", AppletAuthTaskMonitor.ErrorCode.INVALID_RESPONSE, "checkPrivacyOrLoginStatus succeeded but privacyCard is null", null, null, null, 480));
            MainCoroutineDispatcher r60 = Dispatchers.getMain();
            AnonymousClass2 r61 = new AnonymousClass2(this.$callback, "checkPrivacyOrLoginStatus succeeded but privacyCard is null", null);
            this.label = 3;
            if (BuildersKt.withContext(r60, r61, this) != r1) goto L40;
            return r1;
        L41:
            r30 = new Ref.ObjectRef();
            r30.element = "";
            if (this.$isLoginFlow == false) goto L65;
            String r62 = r32.getDoubaoMiniAppVersion();
            if (r62 != null) goto L46;
            r62 = "";
        L46:
            AppletAuthTaskMonitor.Session r120 = this.$authTaskSession;
            LoginWithDoubaoWidgetMethod$handle$1$maskResult$1 r121 = new LoginWithDoubaoWidgetMethod$handle$1$maskResult$1(r62, null);
            this.L$0 = r32;
            this.L$1 = r30;
            this.label = 4;
            r15 = r120.f(r121, this);
            if (r15 != r1) goto L49;
            return r1;
        L49:
            r14 = r32;
            r12 = r30;
            goto L50
        L16:
            ResultKt.throwOnFailure(r33);
            AppletAuthTaskMonitor.Session r63 = this.$authTaskSession;
            LoginWithDoubaoWidgetMethod$handle$1$metaResult$1 r122 = new LoginWithDoubaoWidgetMethod$handle$1$metaResult$1(this.$appletId, null);
            this.label = 1;
            r50 = r63.f(r122, this);
            if (r50 != r1) goto L19;
            return r1;
        }
    }

    static {
    }

    public LoginWithDoubaoWidgetMethod() {
        this.b = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r12, ParamModel r13, f3.h r14) {
        AbsLoginWithDoubaoWidgetMethodIDL.a r1 = (AbsLoginWithDoubaoWidgetMethodIDL.a) r13;
        Intrinsics.checkNotNullParameter(r12, "bridgeContext");
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r14, "callback");
        a0 r10 = r12.getContainerContext();
        if (r10 == null) goto L5;
        String r11 = r10.getAppletId();
    L6:
        com.bytedance.ai.utils.g r15 = com.bytedance.ai.utils.g.a;
        r15.i("AISDK_JSB_LoginWithDoubaoWidgetMethod", "call start, loginType=" + r1.getLoginType() + ", appletId=" + r11);
        if (r11 != null) goto L9;
    L12:
        boolean r16 = true;
    L13:
        if (r16 == false) goto L16;
        StringBuilder r0 = new StringBuilder("call failed, errNo=");
        f3.a r17 = f3.a.f;
        r0.append(r17.a);
        r0.append(", msg=Error: appletId is null or empty");
        r15.e("AISDK_JSB_LoginWithDoubaoWidgetMethod", r0.toString());
        f3.h.a.a(r14, "Error: appletId is null or empty", r17, null, 10);
        return;
    L16:
        if (r1.getLoginType() == 0) goto L18;
        boolean r18 = true;
    L19:
        SecureRandom r19 = AppletAuthTaskMonitor.a;
        BuildersKt.launch$default(this.b, null, null, new AnonymousClass1(AppletAuthTaskMonitor.g(AppletAuthTaskMonitor.c(r12, "jsb", "normal_login", "doubao.loginWithDoubaoWidget.call", r11)), r18, this, r11, r14, null), 3, null);
        return;
    L18:
        r18 = false;
        goto L19
    L9:
        if (r11.length() == 0) goto L12;
        r16 = false;
        goto L13
    L5:
        r11 = null;
        goto L6
    }
}
