package com.bytedance.ai.bridge.method.phoneNum;

import com.bytedance.ai.applet.granting.GrantingAction;
import com.bytedance.ai.applet.login.LoginProcessor;
import com.bytedance.ai.applet.login.OperationType;
import com.bytedance.ai.applet.moa.k;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.phoneNum.AbsGetPhoneNumberMethodIDL;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor;
import com.bytedance.ai.utils.g;
import com.bytedance.ai.utils.l;
import d3.a0;
import e3.d;
import f3.h;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010\u0012J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ai/bridge/method/phoneNum/GetPhoneNumFlow;", "Lcom/bytedance/ai/bridge/phoneNum/AbsGetPhoneNumberMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/phoneNum/AbsGetPhoneNumberMethodIDL$EmptyMessageModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/phoneNum/AbsGetPhoneNumberMethodIDL$GetPhoneNumberResultModel;", "getPhoneNumberFlow", "", "(Lcom/bytedance/ai/bridge/context/IAIBridgeContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchPhoneMask", "versionTag", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showGrantingDialogAndWait", "Lcom/bytedance/ai/applet/granting/GrantingAction;", "phoneMask", "appletId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postPhoneNumUsed", "fetchPhoneCode", "Companion", "GetPhoneNumException", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetPhoneNumFlow extends AbsGetPhoneNumberMethodIDL {
    public static final /* synthetic */ int b = 0;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ai/bridge/method/phoneNum/GetPhoneNumFlow$GetPhoneNumException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", com.bytedance.android.ec.core.event.a.KEY_MSG, "", "code", "", "<init>", "(Ljava/lang/String;I)V", "getCode", "()I", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class GetPhoneNumException extends Exception {
        private final int code;

        public final int getCode() {
            return this.code;
        }

        public GetPhoneNumException(String r10, int r11) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_MSG);
            super(r10);
            this.code = r11;
        }
    }

    public static final class a {
    }

    public static final class b implements Function1<GrantingAction, Unit> {
        public final /* synthetic */ i<GrantingAction> a;

        public b(j r1) {
            this.a = r1;
        }

        public final Object invoke(Object r10) {
            GrantingAction r11 = (GrantingAction) r10;
            Intrinsics.checkNotNullParameter(r11, "userAction");
            if (this.a.isActive() == false) goto L6;
            this.a.resumeWith(Result.constructor-impl(r11));
        L6:
            return Unit.INSTANCE;
        }
    }

    public static final class c implements Function1<Throwable, Unit> {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object r1) {
            Throwable r10 = (Throwable) r1;
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.phoneNum.GetPhoneNumFlow$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.phoneNum.GetPhoneNumFlow$handle$1", f = "GetPhoneNumFlow.kt", i = {}, l = {102}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ d $bridgeContext;
        final /* synthetic */ h<AbsGetPhoneNumberMethodIDL.b> $callback;
        int label;
        final /* synthetic */ GetPhoneNumFlow this$0;

        public AnonymousClass1(GetPhoneNumFlow r1, d r10, h<AbsGetPhoneNumberMethodIDL.b> r11, Continuation<? super AnonymousClass1> r12) {
            this.this$0 = r1;
            this.$bridgeContext = r10;
            this.$callback = r11;
            super(2, r12);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.this$0, this.$bridgeContext, this.$callback, r11);
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
            ResultKt.throwOnFailure(r10);     // Catch: Exception -> L15 GetPhoneNumException -> L17
        L13:
            h<AbsGetPhoneNumberMethodIDL.b> r11 = this.$callback;     // Catch: Exception -> L15 GetPhoneNumException -> L17
            Intrinsics.checkNotNullParameter(AbsGetPhoneNumberMethodIDL.b.class, "<this>");     // Catch: Exception -> L15 GetPhoneNumException -> L17
            BaseModel r12 = k3.c.a(AbsGetPhoneNumberMethodIDL.b.class);     // Catch: Exception -> L15 GetPhoneNumException -> L17
            AbsGetPhoneNumberMethodIDL.b r13 = (AbsGetPhoneNumberMethodIDL.b) r12;     // Catch: Exception -> L15 GetPhoneNumException -> L17
            r13.setCode((String) r10);     // Catch: Exception -> L15 GetPhoneNumException -> L17
            r13.setMessage("success");     // Catch: Exception -> L15 GetPhoneNumException -> L17
            h.a.b(r11, (ResultModel) r12);     // Catch: Exception -> L15 GetPhoneNumException -> L17
        L25:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r10);
            GetPhoneNumFlow r14 = this.this$0;     // Catch: Exception -> L15 GetPhoneNumException -> L17
            d r15 = this.$bridgeContext;     // Catch: Exception -> L15 GetPhoneNumException -> L17
            this.label = 1;     // Catch: Exception -> L15 GetPhoneNumException -> L17
            r10 = GetPhoneNumFlow.b(r14, r15, this);     // Catch: Exception -> L15 GetPhoneNumException -> L17
            if (r10 != r0) goto L13;
            return r0;
        L17:
            e = move-exception;
            g.a.w("GetPhoneNumMethod", "Get phone number failed: " + e.getMessage());
            h<AbsGetPhoneNumberMethodIDL.b> r16 = this.$callback;
            String r17 = e.getMessage();
            if (r17 != null) goto L23;
            r17 = "Unknown error occurred";
        L23:
            h.a.a(r16, r17, null, null, 12);
        L15:
            e = move-exception;
            g.a.e("GetPhoneNumMethod", "Unexpected error occurred during get phone number", e);
            h.a.a(this.$callback, "Error: " + e.getMessage(), null, null, 12);
            goto L25
        }
    }

    static {
    }

    public GetPhoneNumFlow() {
    }

    public static Object d(String r10, Continuation r11) {
        return BuildersKt.withContext(Dispatchers.getIO(), new GetPhoneNumFlow$fetchPhoneCode$2(r10, null), r11);
    }

    public static final Object b(GetPhoneNumFlow r18, d r19, Continuation r20) {
        r18.getClass();
        if ((r20 instanceof GetPhoneNumFlow$getPhoneNumberFlow$1) == false) goto L7;
        GetPhoneNumFlow$getPhoneNumberFlow$1 r10 = (GetPhoneNumFlow$getPhoneNumberFlow$1) r20;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r1 = r10.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r10.label) {
            case 0: goto L22;
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L14;
            case 9: goto L13;
            case 10: goto L12;
            default: goto L11;
        };
    L12:
        String r0 = (String) r10.L$1;
        com.bytedance.ai.applet.login.j r13 = (com.bytedance.ai.applet.login.j) r10.L$0;
        ResultKt.throwOnFailure(r1);
        r12 = r0;
    L95:
        if (r13 == null) goto L122;
        r13.d = true;
    L122:
        return r12;
    L13:
        com.bytedance.ai.applet.login.j r14 = (com.bytedance.ai.applet.login.j) r10.L$1;
        String r15 = (String) r10.L$0;
        ResultKt.throwOnFailure(r1);
    L90:
        String r16 = (String) r1;
    L91:
        CoroutineDispatcher r17 = Dispatchers.getDefault();
        GetPhoneNumFlow$getPhoneNumberFlow$3 r21 = new GetPhoneNumFlow$getPhoneNumberFlow$3(r14, r18, r15, null);
        r10.L$0 = r14;
        r10.L$1 = r16;
        r10.label = 10;
        if (BuildersKt.withContext(r17, r21, r10) == r12) goto L122;
        r12 = r16;
        r13 = r14;
        goto L95
    L14:
        r14 = (com.bytedance.ai.applet.login.j) r10.L$1;
        r15 = (String) r10.L$0;
        ResultKt.throwOnFailure(r1);
    L85:
        r16 = (String) r1;
        if (r16 != null) goto L91;
    L87:
        r10.L$0 = r15;
        r10.L$1 = r14;
        r10.L$2 = null;
        r10.label = 9;
        r1 = d(r15, r10);
        if (r1 != r12) goto L90;
    L15:
        r14 = (com.bytedance.ai.applet.login.j) r10.L$1;
        r15 = (String) r10.L$0;
        ResultKt.throwOnFailure(r1);
    L75:
        GrantingAction r22 = (GrantingAction) r1;
    L77:
        if (r22 != GrantingAction.AGREED) goto L97;
        LoginProcessor r23 = LoginProcessor.a;
        GrantingAction r24 = GrantingAction.AGREED;
        OperationType r25 = OperationType.PHONE_NUM;
        r23.getClass();
        LoginProcessor.i(r15, r24, r25);
        if (r14 == null) goto L87;
        AppletAuthTaskMonitor.Session r26 = r14.h;
        if (r26 == null) goto L87;
        GetPhoneNumFlow$getPhoneNumberFlow$phoneCode$2 r27 = new GetPhoneNumFlow$getPhoneNumberFlow$phoneCode$2(r18, r15, null);
        r10.L$0 = r15;
        r10.L$1 = r14;
        r10.L$2 = null;
        r10.label = 8;
        r1 = r26.f(r27, r10);
        if (r1 != r12) goto L85;
    L97:
        if (r14 == null) goto L99;
        r14.i = new AppletAuthTaskMonitor.a("user_refused", null, "get_phone_number", AppletAuthTaskMonitor.ErrorCode.USER_REFUSED, null, null, null, null, 498);
    L99:
        LoginProcessor r28 = LoginProcessor.a;
        GrantingAction r29 = GrantingAction.REJECTED;
        OperationType r30 = OperationType.PHONE_NUM;
        r28.getClass();
        LoginProcessor.i(r15, r29, r30);
        throw new GetPhoneNumException("Permission denied by user", -4);
    L16:
        String r31 = (String) r10.L$2;
        com.bytedance.ai.applet.login.j r32 = (com.bytedance.ai.applet.login.j) r10.L$1;
        String r33 = (String) r10.L$0;
        ResultKt.throwOnFailure(r1);
    L67:
        r22 = (GrantingAction) r1;
        if (r22 == null) goto L71;
        r14 = r32;
        r15 = r33;
    L71:
        r10.L$0 = r33;
        r10.L$1 = r32;
        r10.L$2 = null;
        r10.label = 7;
        r1 = e(r31, r33, r10);
        if (r1 == r12) goto L122;
        r14 = r32;
        r15 = r33;
        goto L75
    L17:
        com.bytedance.ai.applet.login.j r34 = (com.bytedance.ai.applet.login.j) r10.L$1;
        String r35 = (String) r10.L$0;
        ResultKt.throwOnFailure(r1);
    L60:
        String r36 = (String) r1;
        r33 = r35;
        r32 = r34;
    L55:
        r31 = r36;
        if (r32 == null) goto L71;
        AppletAuthTaskMonitor.Session r37 = r32.h;
        if (r37 == null) goto L71;
        GetPhoneNumFlow$getPhoneNumberFlow$userAction$1 r38 = new GetPhoneNumFlow$getPhoneNumberFlow$userAction$1(r18, r31, r33, null);
        r10.L$0 = r33;
        r10.L$1 = r32;
        r10.L$2 = r31;
        r10.label = 6;
        r1 = r37.g(r38, r10);
        if (r1 != r12) goto L67;
    L18:
        String r39 = (String) r10.L$2;
        r32 = (com.bytedance.ai.applet.login.j) r10.L$1;
        r33 = (String) r10.L$0;
        ResultKt.throwOnFailure(r1);
    L52:
        r36 = (String) r1;
        if (r36 != null) goto L55;
    L56:
        r10.L$0 = r33;
        r10.L$1 = r32;
        r10.L$2 = null;
        r10.label = 5;
        r1 = BuildersKt.withContext(Dispatchers.getIO(), new GetPhoneNumFlow$fetchPhoneMask$2(r39, null), r10);
        if (r1 == r12) goto L122;
        r34 = r32;
        r35 = r33;
        goto L60
    L19:
        String r40 = (String) r10.L$1;
        com.bytedance.ai.applet.login.j r41 = (com.bytedance.ai.applet.login.j) r10.L$0;
        ResultKt.throwOnFailure(r1);
        r12 = r40;
    L120:
        if (r41 == null) goto L122;
        r41.d = true;
        goto L122
    L20:
        com.bytedance.ai.applet.login.j r42 = (com.bytedance.ai.applet.login.j) r10.L$1;
        String r43 = (String) r10.L$0;
        ResultKt.throwOnFailure(r1);
    L115:
        String r44 = (String) r1;
    L116:
        CoroutineDispatcher r45 = Dispatchers.getDefault();
        GetPhoneNumFlow$getPhoneNumberFlow$2 r46 = new GetPhoneNumFlow$getPhoneNumberFlow$2(r42, r18, r43, null);
        r10.L$0 = r42;
        r10.L$1 = r44;
        r10.label = 3;
        if (BuildersKt.withContext(r45, r46, r10) == r12) goto L122;
        r12 = r44;
        r41 = r42;
        goto L120
    L21:
        r42 = (com.bytedance.ai.applet.login.j) r10.L$1;
        r43 = (String) r10.L$0;
        ResultKt.throwOnFailure(r1);
    L108:
        r44 = (String) r1;
        if (r44 != null) goto L116;
    L112:
        r10.L$0 = r43;
        r10.L$1 = r42;
        r10.label = 2;
        r1 = d(r43, r10);
        if (r1 != r12) goto L115;
    L22:
        ResultKt.throwOnFailure(r1);
        a0 r47 = r19.getContainerContext();
        if (r47 == null) goto L124;
        r33 = r47.getAppletId();
        if (r33 == null) goto L124;
        LoginProcessor.a.getClass();
        r32 = LoginProcessor.h(r33);
        String r48 = "";
        if (r32 == null) goto L32;
        u2.c r49 = r32.a;
        if (r49 == null) goto L32;
        r39 = r49.d;
        if (r39 == null) goto L32;
    L33:
        if (r32 == null) goto L38;
        String r50 = r32.f;
        if (r50 == null) goto L38;
        r48 = r50;
    L38:
        a0 r51 = r19.getContainerContext();
        if (r51 == null) goto L41;
        String r52 = r51.getAppId();
    L42:
        boolean r53 = Intrinsics.areEqual(r52, "mcp-privacy-login-card");
        g.a.i("GetPhoneNumMethod", "handle applet: " + r33 + " get phone number from: " + r48);
        if (Intrinsics.areEqual(r48, "chat") == true) goto L101;
        if (r53 == true) goto L101;
        if (r32 == null) goto L56;
        AppletAuthTaskMonitor.Session r54 = r32.h;
        if (r54 == null) goto L56;
        GetPhoneNumFlow$getPhoneNumberFlow$phoneMask$1 r55 = new GetPhoneNumFlow$getPhoneNumberFlow$phoneMask$1(r18, r39, null);
        r10.L$0 = r33;
        r10.L$1 = r32;
        r10.L$2 = r39;
        r10.label = 4;
        r1 = r54.f(r55, r10);
        if (r1 != r12) goto L52;
    L101:
        if (r32 == null) goto L111;
        AppletAuthTaskMonitor.Session r56 = r32.h;
        if (r56 == null) goto L111;
        GetPhoneNumFlow$getPhoneNumberFlow$phoneCode$1 r57 = new GetPhoneNumFlow$getPhoneNumberFlow$phoneCode$1(r18, r33, null);
        r10.L$0 = r33;
        r10.L$1 = r32;
        r10.label = 1;
        r1 = r56.f(r57, r10);
        if (r1 == r12) goto L122;
        r42 = r32;
        r43 = r33;
    L111:
        r42 = r32;
        r43 = r33;
        goto L112
    L41:
        r52 = null;
    L32:
        r39 = "";
    L124:
        throw new GetPhoneNumException("Error: appletId is null or empty", -1);
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r10 = new GetPhoneNumFlow$getPhoneNumberFlow$1(r18, r20);
        goto L8
    }

    public static final Object c(GetPhoneNumFlow r10, String r11, Continuation r12) {
        r10.getClass();
        if ((r12 instanceof GetPhoneNumFlow$postPhoneNumUsed$1) == false) goto L7;
        GetPhoneNumFlow$postPhoneNumUsed$1 r0 = (GetPhoneNumFlow$postPhoneNumUsed$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r0.label;
        if (r15 == 0) goto L15;
        if (r15 != 1) goto L14;
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L19
    L23:
    L22:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r13);
        g.a.i("GetPhoneNumMethod", "postPhoneNumUsed " + r11);
        CoroutineDispatcher r16 = Dispatchers.getIO();     // Catch: Exception -> L19
        GetPhoneNumFlow$postPhoneNumUsed$2 r17 = new GetPhoneNumFlow$postPhoneNumUsed$2(r11, null);     // Catch: Exception -> L19
        r0.label = 1;     // Catch: Exception -> L19
        if (BuildersKt.withContext(r16, r17, r0) != r14) goto L23;
        return r14;
    L19:
        e = move-exception;
        g.a.e("GetPhoneNumMethod", "postPhoneNumUsed failed: " + e.getMessage(), e);
    L7:
        r0 = new GetPhoneNumFlow$postPhoneNumUsed$1(r10, r12);
        goto L8
    }

    public static Object e(String r13, String r14, Continuation r15) {
        j r0 = new j(IntrinsicsKt.intercepted(r15), 1);
        r0.C();
        LoginProcessor.a.getClass();
        com.bytedance.ai.applet.login.j r1 = LoginProcessor.h(r14);
        String r10 = null;
        if (r1 == null) goto L5;
        u2.c r11 = r1.a;
    L6:
        if (r11 == null) goto L11;
        String r12 = r11.b;
        if (r12 == null) goto L11;
        String r16 = r12;
    L12:
        if (r11 == null) goto L14;
        r10 = r11.c;
    L14:
        String r17 = r10;
        l r18 = l.a;
        String r19 = l.e(r18, "larus_appEntry_bottomSheet_Title_phoneNo_cn");
        if (r19 != null) goto L17;
        r19 = "申请获取并验证你的手机号";
    L17:
        String r20 = r19;
        String r21 = l.e(r18, "larus_appEntry_bottomSheet_optionDesc_linkedNo_cn");
        if (r21 != null) goto L20;
        r21 = "豆包绑定号码";
    L20:
        String r110 = r21;
        String r111 = l.e(r18, "larus_cc_call_access_mic_popup_button_not_now");
        if (r111 != null) goto L23;
        r111 = "不允许";
    L23:
        u2.i r112 = new u2.i(Boxing.boxInt(0), r17, r16, r20, "用于登录或注册" + r16 + "账户", r13, r110, r111);
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r113 = AppletRuntimeManager.d;
        if (r113 == null) goto L26;
        r113.F(r112, new b(r0));
    L26:
        r0.i(c.a);
        Object r114 = r0.B();
        if (r114 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L29;
        DebugProbesKt.probeCoroutineSuspended(r15);
    L29:
        return r114;
    L11:
        r16 = r14;
        goto L12
    L5:
        r11 = null;
        goto L6
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r11, ParamModel r12, final h r13) {
        Intrinsics.checkNotNullParameter(r11, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsGetPhoneNumberMethodIDL.a) r12, "params");
        Intrinsics.checkNotNullParameter(r13, "callback");
        a0 r14 = r11.getContainerContext();
        if (r14 == null) goto L5;
        final String r1 = r14.getAppletId();
    L7:
        if (r1 != null) goto L9;
    L12:
        boolean r10 = true;
    L14:
        if (r10 == false) goto L16;
        g.a.e("GetPhoneNumMethod", "call failed, msg=appletId is null or empty");
        h.a.a(r13, "Error: appletId is null or empty", null, null, 12);
        return;
    L16:
        k r15 = k.a;
        if (r14 == null) goto L19;
        String r16 = r14.getConversationId();
    L20:
        if (r14 == null) goto L22;
        String r17 = r14.getUrl();
    L23:
        Function1 r18 = new com.bytedance.ai.bridge.method.phoneNum.a(r1, r13, this);
        Function0 r19 = new com.bytedance.ai.bridge.method.phoneNum.b(r13);
        r15.getClass();
        if (k.d(r16, r17, r1, "get-phone callback", r18, r19) == false) goto L26;
        g.a.i("GetPhoneNumMethod", "MOA consumed callback, skip normal get-phone-number flow: applet=".concat(r1));
        return;
    L26:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null))), null, null, new AnonymousClass1(this, r11, r13, null), 3, null);
        return;
    L22:
        r17 = null;
        goto L23
    L19:
        r16 = null;
        goto L20
    L9:
        if (r1.length() == 0) goto L12;
        r10 = false;
        goto L14
    L5:
        r1 = null;
        goto L7
    }
}
