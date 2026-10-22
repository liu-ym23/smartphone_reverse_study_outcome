package com.bytedance.ai.bridge.method.login;

import com.bytedance.ai.applet.login.j;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.postMcpLogin.AbsPostLoginResultMethodIDL;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.behavior.ui.utils.e;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b\t\u0010\nJ-\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ai/bridge/method/login/PostLoginResultMethod;", "Lcom/bytedance/ai/bridge/postMcpLogin/AbsPostLoginResultMethodIDL;", "<init>", "()V", "", "appletId", "code", "versionTag", "", "postLoginCodeToOpenPlat", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/postMcpLogin/AbsPostLoginResultMethodIDL$PostLoginResultRequestModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/postMcpLogin/AbsPostLoginResultMethodIDL$EmptyMessageModel;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/postMcpLogin/AbsPostLoginResultMethodIDL$PostLoginResultRequestModel;Lo1/f;)V", "Companion", "com/bytedance/ai/bridge/method/login/d", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PostLoginResultMethod extends AbsPostLoginResultMethodIDL {
    public static final d Companion = null;
    public static final String TAG = "PostLoginResultMethod";

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.login.PostLoginResultMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.login.PostLoginResultMethod$handle$1", f = "PostLoginResultMethod.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1851a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PostLoginResultMethod f1852b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f1853c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ f f;

        public AnonymousClass1(PostLoginResultMethod r5, String r10, String r11, String r12, f r13, Continuation r14) {
            this.f1852b = r5;
            this.f1853c = r10;
            this.d = r11;
            this.e = r12;
            this.f = r13;
            super(2, r14);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object r10, Continuation r11) {
            return new AnonymousClass1(this.f1852b, this.f1853c, this.d, this.e, this.f, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((AnonymousClass1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.f1851a;
            if (r11 == 0) goto L11;
            if (r11 != 1) goto L10;
            ResultKt.throwOnFailure(r10);     // Catch: Exception -> L7
        L15:
            ((Boolean) r10).getClass();     // Catch: Exception -> L7
            LinkedHashMap r12 = j.f1750a;     // Catch: Exception -> L7
            j.f(this.f1853c);     // Catch: Exception -> L7
            f r13 = this.f;     // Catch: Exception -> L7
            Intrinsics.checkNotNullParameter(AbsPostLoginResultMethodIDL.EmptyMessageModel.class, "<this>");     // Catch: Exception -> L7
            r13.b((ResultModel) e.c(AbsPostLoginResultMethodIDL.EmptyMessageModel.class), "");     // Catch: Exception -> L7
        L22:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r10);
            PostLoginResultMethod r14 = this.f1852b;     // Catch: Exception -> L7
            String r15 = this.f1853c;     // Catch: Exception -> L7
            String r16 = this.d;     // Catch: Exception -> L7
            String r17 = this.e;     // Catch: Exception -> L7
            this.f1851a = 1;     // Catch: Exception -> L7
            r10 = PostLoginResultMethod.access$postLoginCodeToOpenPlat(r14, r15, r16, r17, this);     // Catch: Exception -> L7
            if (r10 != r5) goto L15;
            return r5;
        L7:
            e = move-exception;
            StringBuilder r18 = new StringBuilder("postLoginCode failed, appletId: ");
            r18.append(this.f1853c);
            r18.append(", code: ");
            String r19 = androidx.room.jarjarred.org.antlr.runtime.a.v(r18, this.d, PostLoginResultMethod.TAG, "tag");
            t0.d r20 = com.bytedance.ai.utils.c.f2846a;
            if (r20 == null) goto L20;
            r20.e(PostLoginResultMethod.TAG, r19, e);
        L20:
            LinkedHashMap r21 = j.f1750a;
            j.e(this.f1853c);
            this.f.a("Error: postLoginCode failed, " + e.getMessage());
            goto L22
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.login.PostLoginResultMethod$postLoginCodeToOpenPlat$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.login.PostLoginResultMethod", f = "PostLoginResultMethod.kt", i = {}, l = {70}, m = "postLoginCodeToOpenPlat", n = {}, s = {})
    public static final class C01541 extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f1854a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PostLoginResultMethod f1855b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1856c;

        public C01541(PostLoginResultMethod r5, Continuation r10) {
            this.f1855b = r5;
            super(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            this.f1854a = r5;
            this.f1856c |= Integer.MIN_VALUE;
            return PostLoginResultMethod.access$postLoginCodeToOpenPlat(this.f1855b, null, null, null, this);
        }
    }

    static {
        Companion = new d();
    }

    public PostLoginResultMethod() {
    }

    public static final /* synthetic */ Object access$postLoginCodeToOpenPlat(PostLoginResultMethod r5, String r10, String r11, String r12, Continuation r13) {
        return r5.postLoginCodeToOpenPlat(r10, r11, r12, r13);
    }

    private final Object postLoginCodeToOpenPlat(String r5, String r10, String r11, Continuation<? super Boolean> r12) {
        if ((r12 instanceof C01541) == false) goto L7;
        C01541 r13 = (C01541) r12;
        int r14 = r13.f1856c;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.f1856c = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.f1854a;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.f1856c;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        ResultKt.throwOnFailure(r15);
        Object r18 = ((Result) r15).m133unboximpl();
    L18:
        if (Result.m130isFailureimpl(r18) == false) goto L20;
        Object r19 = null;
    L21:
        Boolean r20 = (Boolean) r19;
        if (r20 != null) goto L24;
        Throwable r21 = Result.m127exceptionOrNullimpl(r18);
        if (r21 == null) goto L28;
        throw r21;
    L28:
        throw new Exception("loginCode is null, but no error message");
    L24:
        return Boxing.boxBoolean(r20.booleanValue());
    L20:
        r19 = r18;
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        com.bytedance.ai.bridge.remote.b r22 = com.bytedance.ai.bridge.remote.b.f2069a;
        r13.f1856c = 1;
        r18 = r22.b(r5, r10, r11, r13);
        if (r18 != r16) goto L18;
        return r16;
    L7:
        r13 = new C01541(this, r12);
        goto L8
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(n1.c r5, ParamModel r10, f r11) {
        handle(r5, (AbsPostLoginResultMethodIDL.PostLoginResultRequestModel) r10, r11);
    }

    public void handle(n1.c r14, AbsPostLoginResultMethodIDL.PostLoginResultRequestModel r15, f r16) {
        Intrinsics.checkNotNullParameter(r14, "bridgeContext");
        Intrinsics.checkNotNullParameter(r15, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r16, "callback");
        n1.a r5 = (n1.a) r14;
        m1.j r10 = (m1.j) r5.b(m1.j.class);
        String r11 = null;
        if (r10 == null) goto L5;
        String r12 = r10.a();
    L6:
        m1.j r13 = (m1.j) r5.b(m1.j.class);
        if (r13 == null) goto L10;
        r11 = r13.b();
    L10:
        if (r11 != null) goto L12;
    L43:
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r17 = com.bytedance.ai.utils.c.f2846a;
        if (r17 == null) goto L46;
        r17.e(TAG, "appletId is null or empty");
    L46:
        r16.a("Error: appletId is null or empty");
        return;
    L12:
        if (r11.length() == 0) goto L43;
        StringBuilder r18 = com.lynx.tasm.base.a.e("handle app: ", r12, ", applet: ", r11, " postLoginResult: result=");
        r18.append(r15.getResult());
        r18.append(", code=");
        r18.append(r15.getCode());
        String r19 = r18.toString();
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r20 = com.bytedance.ai.utils.c.f2846a;
        if (r20 == null) goto L18;
        r20.i(TAG, r19);
    L18:
        if (r15.getResult() == true) goto L24;
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r21 = com.bytedance.ai.utils.c.f2846a;
        if (r21 == null) goto L22;
        r21.e(TAG, "login result is false");
    L22:
        j.e(r11);
        Intrinsics.checkNotNullParameter(AbsPostLoginResultMethodIDL.EmptyMessageModel.class, "<this>");
        r16.b((ResultModel) e.c(AbsPostLoginResultMethodIDL.EmptyMessageModel.class), "");
        return;
    L24:
        String r22 = r15.getCode();
        if (r22 != null) goto L27;
    L38:
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r23 = com.bytedance.ai.utils.c.f2846a;
        if (r23 == null) goto L41;
        r23.e(TAG, "login code is null or empty");
    L41:
        j.e(r11);
        r16.a("Error: login code is null or empty");
        return;
    L27:
        if (r22.length() == 0) goto L38;
        com.bytedance.ai.applet.login.a r24 = j.a(r11);
        if (r24 == null) goto L35;
        String r25 = r24.f1733a.d();
        if (r25 == null) goto L35;
    L36:
        BuildersKt.launch$default(h0.a(Dispatchers.getIO()), null, null, new AnonymousClass1(this, r11, r22, r25, r16, null), 3, null);
        return;
    L35:
        r25 = "null";
        goto L36
    L5:
        r12 = null;
        goto L6
    }
}
