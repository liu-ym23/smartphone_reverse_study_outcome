package com.bytedance.ai.bridge.method.login;

import ai.j0;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.privacySetting.AbsGetPrivacySettingMethodIDL;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.behavior.ui.utils.e;
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
import m1.j;
import o1.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b\b\u0010\tJ-\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ai/bridge/method/login/GetPrivacySettingMethod;", "Lcom/bytedance/ai/bridge/privacySetting/AbsGetPrivacySettingMethodIDL;", "<init>", "()V", "", "appletId", "versionTag", "", "checkPrivacy", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/privacySetting/AbsGetPrivacySettingMethodIDL$EmptyMessageModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/privacySetting/AbsGetPrivacySettingMethodIDL$PrivacySettingResultModel;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/privacySetting/AbsGetPrivacySettingMethodIDL$EmptyMessageModel;Lo1/f;)V", "Companion", "com/bytedance/ai/bridge/method/login/b", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GetPrivacySettingMethod extends AbsGetPrivacySettingMethodIDL {
    public static final b Companion = null;
    public static final String TAG = "GetPrivacySettingMethod";

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.login.GetPrivacySettingMethod$checkPrivacy$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.login.GetPrivacySettingMethod", f = "GetPrivacySettingMethod.kt", i = {}, l = {54}, m = "checkPrivacy", n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f1837a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ GetPrivacySettingMethod f1838b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1839c;

        public AnonymousClass1(GetPrivacySettingMethod r5, Continuation r10) {
            this.f1838b = r5;
            super(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            this.f1837a = r5;
            this.f1839c |= Integer.MIN_VALUE;
            return GetPrivacySettingMethod.access$checkPrivacy(this.f1838b, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.login.GetPrivacySettingMethod$handle$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.login.GetPrivacySettingMethod$handle$1", f = "GetPrivacySettingMethod.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01531 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1840a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ GetPrivacySettingMethod f1841b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f1842c;
        public final /* synthetic */ String d;
        public final /* synthetic */ f e;

        public C01531(GetPrivacySettingMethod r5, String r10, String r11, f r12, Continuation r13) {
            this.f1841b = r5;
            this.f1842c = r10;
            this.d = r11;
            this.e = r12;
            super(2, r13);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object r10, Continuation r11) {
            return new C01531(this.f1841b, this.f1842c, this.d, this.e, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((C01531) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.f1840a;
            if (r11 == 0) goto L11;
            if (r11 != 1) goto L10;
            ResultKt.throwOnFailure(r5);     // Catch: Exception -> L7
        L15:
            boolean r12 = ((Boolean) r5).booleanValue();     // Catch: Exception -> L7
            f r13 = this.e;     // Catch: Exception -> L7
            Intrinsics.checkNotNullParameter(AbsGetPrivacySettingMethodIDL.PrivacySettingResultModel.class, "<this>");     // Catch: Exception -> L7
            BaseModel r14 = e.c(AbsGetPrivacySettingMethodIDL.PrivacySettingResultModel.class);     // Catch: Exception -> L7
            ((AbsGetPrivacySettingMethodIDL.PrivacySettingResultModel) r14).setNeedAuthorization(!r12);     // Catch: Exception -> L7
            r13.b((ResultModel) r14, "");     // Catch: Exception -> L7
        L22:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r5);
            GetPrivacySettingMethod r15 = this.f1841b;     // Catch: Exception -> L7
            String r16 = this.f1842c;     // Catch: Exception -> L7
            String r17 = this.d;     // Catch: Exception -> L7
            this.f1840a = 1;     // Catch: Exception -> L7
            r5 = GetPrivacySettingMethod.access$checkPrivacy(r15, r16, r17, this);     // Catch: Exception -> L7
            if (r5 != r10) goto L15;
            return r10;
        L7:
            e = move-exception;
            Intrinsics.checkNotNullParameter(GetPrivacySettingMethod.TAG, "tag");
            t0.d r18 = com.bytedance.ai.utils.c.f2846a;
            if (r18 == null) goto L20;
            r18.e(GetPrivacySettingMethod.TAG, "check privacy error", e);
        L20:
            this.e.a("Error: " + e.getMessage());
            goto L22
        }
    }

    static {
        Companion = new b();
    }

    public GetPrivacySettingMethod() {
    }

    public static final /* synthetic */ Object access$checkPrivacy(GetPrivacySettingMethod r5, String r10, String r11, Continuation r12) {
        return r5.checkPrivacy(r10, r11, r12);
    }

    private final Object checkPrivacy(String r5, String r10, Continuation<? super Boolean> r11) {
        if ((r11 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r12 = (AnonymousClass1) r11;
        int r13 = r12.f1839c;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.f1839c = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.f1837a;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.f1839c;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        ResultKt.throwOnFailure(r14);
        Object r17 = ((Result) r14).m133unboximpl();
    L18:
        if (Result.m130isFailureimpl(r17) == false) goto L20;
        Object r18 = null;
    L21:
        Boolean r19 = (Boolean) r18;
        if (r19 != null) goto L24;
        Throwable r20 = Result.m127exceptionOrNullimpl(r17);
        if (r20 == null) goto L28;
        throw r20;
    L28:
        throw new Exception("check result is null, but no error message");
    L24:
        return Boxing.boxBoolean(r19.booleanValue());
    L20:
        r18 = r17;
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        com.bytedance.ai.bridge.remote.b r21 = com.bytedance.ai.bridge.remote.b.f2069a;
        r12.f1839c = 1;
        r17 = r21.c(r5, r10, r12);
        if (r17 != r15) goto L18;
        return r15;
    L7:
        r12 = new AnonymousClass1(this, r11);
        goto L8
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(n1.c r5, ParamModel r10, f r11) {
        handle(r5, (AbsGetPrivacySettingMethodIDL.EmptyMessageModel) r10, r11);
    }

    public void handle(n1.c r13, AbsGetPrivacySettingMethodIDL.EmptyMessageModel r14, f r15) {
        Intrinsics.checkNotNullParameter(r13, "bridgeContext");
        Intrinsics.checkNotNullParameter(r14, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r15, "callback");
        n1.a r16 = (n1.a) r13;
        j r5 = (j) r16.b(j.class);
        String r10 = null;
        if (r5 == null) goto L5;
        String r11 = r5.a();
    L6:
        j r17 = (j) r16.b(j.class);
        if (r17 == null) goto L9;
        r10 = r17.b();
    L9:
        String r12 = r10;
        if (r12 != null) goto L12;
    L26:
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r18 = com.bytedance.ai.utils.c.f2846a;
        if (r18 == null) goto L29;
        r18.e(TAG, "appletId is null or empty");
    L29:
        r15.a("Error: appletId is null or empty");
        return;
    L12:
        if (r12.length() == 0) goto L26;
        String r19 = j0.l("handle app: ", r11, ", applet: ", r12, " check privacy");
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r110 = com.bytedance.ai.utils.c.f2846a;
        if (r110 == null) goto L17;
        r110.i(TAG, r19);
    L17:
        com.bytedance.ai.applet.login.a r111 = com.bytedance.ai.applet.login.j.a(r12);
        if (r111 == null) goto L23;
        String r112 = r111.f1733a.d();
        if (r112 == null) goto L23;
    L24:
        BuildersKt.launch$default(h0.a(Dispatchers.getIO()), null, null, new C01531(this, r12, r112, r15, null), 3, null);
        return;
    L23:
        r112 = "null";
        goto L24
    L5:
        r11 = null;
        goto L6
    }
}
