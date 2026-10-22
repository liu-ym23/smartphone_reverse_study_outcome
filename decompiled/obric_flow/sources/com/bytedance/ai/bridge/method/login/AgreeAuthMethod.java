package com.bytedance.ai.bridge.method.login;

import ai.j0;
import com.bytedance.ai.applet.login.DialogAction;
import com.bytedance.ai.applet.login.OperationType;
import com.bytedance.ai.applet.login.j;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.privacySetting.AbsAgreePrivacyAuthorizationMethodIDL;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.behavior.ui.utils.e;
import java.util.LinkedHashMap;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.h0;
import o1.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ai/bridge/method/login/AgreeAuthMethod;", "Lcom/bytedance/ai/bridge/privacySetting/AbsAgreePrivacyAuthorizationMethodIDL;", "<init>", "()V", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/privacySetting/AbsAgreePrivacyAuthorizationMethodIDL$EmptyMessageModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/privacySetting/AbsAgreePrivacyAuthorizationMethodIDL$AgreePrivacyResultModel;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/privacySetting/AbsAgreePrivacyAuthorizationMethodIDL$EmptyMessageModel;Lo1/f;)V", "Companion", "com/bytedance/ai/bridge/method/login/a", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AgreeAuthMethod extends AbsAgreePrivacyAuthorizationMethodIDL {
    public static final a Companion = null;
    public static final String TAG = "AgreeAuthMethod";

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.login.AgreeAuthMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.login.AgreeAuthMethod$handle$1", f = "AgreeAuthMethod.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1834a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f1835b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ f f1836c;

        public AnonymousClass1(String r5, f r10, Continuation r11) {
            this.f1835b = r5;
            this.f1836c = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object r5, Continuation r10) {
            return new AnonymousClass1(this.f1835b, this.f1836c, r10);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            String r11 = this.f1835b;
            f r12 = this.f1836c;
            return new AnonymousClass1(r11, r12, r10).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.f1834a;
            if (r11 == 0) goto L11;
            if (r11 != 1) goto L10;
            ResultKt.throwOnFailure(r10);     // Catch: Exception -> L7
            ((Result) r10).m133unboximpl();     // Catch: Exception -> L7
        L15:
            LinkedHashMap r12 = j.f1750a;     // Catch: Exception -> L7
            j.b(this.f1835b, DialogAction.f1721a, OperationType.f1730a);     // Catch: Exception -> L7
            Intrinsics.checkNotNullParameter(AgreeAuthMethod.TAG, "tag");     // Catch: Exception -> L7
            t0.d r13 = com.bytedance.ai.utils.c.f2846a;     // Catch: Exception -> L7
            if (r13 == null) goto L18;
            r13.d(AgreeAuthMethod.TAG, "privacy authorization agreed");     // Catch: Exception -> L7
        L18:
            f r14 = this.f1836c;     // Catch: Exception -> L7
            Intrinsics.checkNotNullParameter(AbsAgreePrivacyAuthorizationMethodIDL.AgreePrivacyResultModel.class, "<this>");     // Catch: Exception -> L7
            BaseModel r15 = e.c(AbsAgreePrivacyAuthorizationMethodIDL.AgreePrivacyResultModel.class);     // Catch: Exception -> L7
            ((AbsAgreePrivacyAuthorizationMethodIDL.AgreePrivacyResultModel) r15).setResult(true);     // Catch: Exception -> L7
            r14.b((ResultModel) r15, "");     // Catch: Exception -> L7
        L25:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r10);
            com.bytedance.ai.bridge.remote.b r16 = com.bytedance.ai.bridge.remote.b.f2069a;     // Catch: Exception -> L7
            String r17 = this.f1835b;     // Catch: Exception -> L7
            this.f1834a = 1;     // Catch: Exception -> L7
            if (r16.d(r17, this) != r5) goto L15;
            return r5;
        L7:
            e = move-exception;
            Intrinsics.checkNotNullParameter(AgreeAuthMethod.TAG, "tag");
            t0.d r18 = com.bytedance.ai.utils.c.f2846a;
            if (r18 == null) goto L23;
            r18.e(AgreeAuthMethod.TAG, "agree privacy authorization failed", e);
        L23:
            this.f1836c.a("Error: " + e.getMessage());
            goto L25
        }
    }

    static {
        Companion = new a();
    }

    public AgreeAuthMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(n1.c r5, ParamModel r10, f r11) {
        handle(r5, (AbsAgreePrivacyAuthorizationMethodIDL.EmptyMessageModel) r10, r11);
    }

    public void handle(n1.c r10, AbsAgreePrivacyAuthorizationMethodIDL.EmptyMessageModel r11, f r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r12, "callback");
        n1.a r13 = (n1.a) r10;
        m1.j r14 = (m1.j) r13.b(m1.j.class);
        if (r14 == null) goto L5;
        String r15 = r14.a();
    L6:
        m1.j r16 = (m1.j) r13.b(m1.j.class);
        if (r16 == null) goto L9;
        String r17 = r16.b();
    L11:
        if (r17 != null) goto L13;
    L20:
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r18 = com.bytedance.ai.utils.c.f2846a;
        if (r18 == null) goto L23;
        r18.e(TAG, "appletId is null or empty");
    L23:
        r12.a("Error: appletId is null or empty");
        return;
    L13:
        if (r17.length() == 0) goto L20;
        String r19 = j0.l("handle app: ", r15, ", applet: ", r17, " agreePrivacyAuthorization");
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r20 = com.bytedance.ai.utils.c.f2846a;
        if (r20 == null) goto L18;
        r20.i(TAG, r19);
    L18:
        BuildersKt.launch$default(h0.a(Dispatchers.getIO()), null, null, new AnonymousClass1(r17, r12, null), 3, null);
        return;
    L9:
        r17 = null;
        goto L11
    L5:
        r15 = null;
        goto L6
    }
}
