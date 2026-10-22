package com.bytedance.ai.bridge.method.phoneNum;

import ai.j0;
import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.ai.applet.login.DialogAction;
import com.bytedance.ai.applet.login.OperationType;
import com.bytedance.ai.applet.login.j;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.phoneNum.AbsGetPhoneNumberMethodIDL;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.behavior.ui.utils.e;
import com.obric.launcher.widget.R$id;
import com.obric.launcher.widget.R$layout;
import com.obric.launcher.widget.R$string;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.l;
import o1.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001b\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b\u000f\u0010\u000eJ-\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ai/bridge/method/phoneNum/GetPhoneNumMethod;", "Lcom/bytedance/ai/bridge/phoneNum/AbsGetPhoneNumberMethodIDL;", "<init>", "()V", "Landroid/app/Activity;", "activity", "", "phoneMask", "appletId", "Lcom/bytedance/ai/bridge/method/phoneNum/GetPhoneNumMethod$UserAction;", "showDialogAndAwaitAction", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "versionTag", "fetchPhoneMask", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchPhoneCode", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/phoneNum/AbsGetPhoneNumberMethodIDL$EmptyMessageModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/phoneNum/AbsGetPhoneNumberMethodIDL$GetPhoneNumberResultModel;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/phoneNum/AbsGetPhoneNumberMethodIDL$EmptyMessageModel;Lo1/f;)V", "Companion", "com/bytedance/ai/bridge/method/phoneNum/a", "UserAction", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGetPhoneNumMethod.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GetPhoneNumMethod.kt\ncom/bytedance/ai/bridge/method/phoneNum/GetPhoneNumMethod\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 3 Uri.kt\nandroidx/core/net/UriKt\n*L\n1#1,241:1\n318#2,9:242\n327#2,2:252\n29#3:251\n*S KotlinDebug\n*F\n+ 1 GetPhoneNumMethod.kt\ncom/bytedance/ai/bridge/method/phoneNum/GetPhoneNumMethod\n*L\n129#1:242,9\n129#1:252,2\n139#1:251\n*E\n"})
public final class GetPhoneNumMethod extends AbsGetPhoneNumberMethodIDL {
    public static final a Companion = null;
    public static final String TAG = "GetPhoneNumMethod";

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/bridge/method/phoneNum/GetPhoneNumMethod$UserAction;", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum UserAction extends Enum<UserAction> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final UserAction f1885a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final UserAction f1886b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ UserAction[] f1887c = null;

        static {
            UserAction r5 = new UserAction("Accept", 0);
            f1885a = r5;
            UserAction r10 = new UserAction("Reject", 1);
            f1886b = r10;
            UserAction[] r11 = {r5, r10};
            f1887c = r11;
            EnumEntriesKt.enumEntries(r11);
        }

        public UserAction(String r5, int r10) {
            super(r5, r10);
        }

        public static UserAction valueOf(String r5) {
            return (UserAction) Enum.valueOf(UserAction.class, r5);
        }

        public static UserAction[] values() {
            return (UserAction[]) f1887c.clone();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.phoneNum.GetPhoneNumMethod$fetchPhoneCode$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.phoneNum.GetPhoneNumMethod", f = "GetPhoneNumMethod.kt", i = {}, l = {190}, m = "fetchPhoneCode", n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f1888a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ GetPhoneNumMethod f1889b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1890c;

        public AnonymousClass1(GetPhoneNumMethod r5, Continuation r10) {
            this.f1889b = r5;
            super(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            this.f1888a = r5;
            this.f1890c |= Integer.MIN_VALUE;
            return GetPhoneNumMethod.access$fetchPhoneCode(this.f1889b, null, this);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.phoneNum.GetPhoneNumMethod$fetchPhoneMask$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.phoneNum.GetPhoneNumMethod", f = "GetPhoneNumMethod.kt", i = {}, l = {180}, m = "fetchPhoneMask", n = {}, s = {})
    public static final class C01551 extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f1891a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ GetPhoneNumMethod f1892b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1893c;

        public C01551(GetPhoneNumMethod r5, Continuation r10) {
            this.f1892b = r5;
            super(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            this.f1891a = r5;
            this.f1893c |= Integer.MIN_VALUE;
            return GetPhoneNumMethod.access$fetchPhoneMask(this.f1892b, null, this);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.phoneNum.GetPhoneNumMethod$handle$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.phoneNum.GetPhoneNumMethod$handle$1", f = "GetPhoneNumMethod.kt", i = {}, l = {76, 79, 86}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1894a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ GetPhoneNumMethod f1895b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f1896c;
        public final /* synthetic */ Activity d;
        public final /* synthetic */ String e;
        public final /* synthetic */ f f;

        public C01561(GetPhoneNumMethod r5, String r10, Activity r11, String r12, f r13, Continuation r14) {
            this.f1895b = r5;
            this.f1896c = r10;
            this.d = r11;
            this.e = r12;
            this.f = r13;
            super(2, r14);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object r10, Continuation r11) {
            return new C01561(this.f1895b, this.f1896c, this.d, this.e, this.f, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((C01561) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.f1894a;
            if (r11 == 0) goto L16;
            if (r11 == 1) goto L14;
            if (r11 == 2) goto L13;
            if (r11 != 3) goto L12;
            ResultKt.throwOnFailure(r10);     // Catch: Exception -> L9
        L32:
            LinkedHashMap r12 = j.f1750a;     // Catch: Exception -> L9
            j.b(this.e, DialogAction.f1721a, OperationType.f1732c);     // Catch: Exception -> L9
            f r13 = this.f;     // Catch: Exception -> L9
            Intrinsics.checkNotNullParameter(AbsGetPhoneNumberMethodIDL.GetPhoneNumberResultModel.class, "<this>");     // Catch: Exception -> L9
            BaseModel r14 = e.c(AbsGetPhoneNumberMethodIDL.GetPhoneNumberResultModel.class);     // Catch: Exception -> L9
            AbsGetPhoneNumberMethodIDL.GetPhoneNumberResultModel r15 = (AbsGetPhoneNumberMethodIDL.GetPhoneNumberResultModel) r14;     // Catch: Exception -> L9
            r15.setCode((String) r10);     // Catch: Exception -> L9
            r15.setMessage("success");     // Catch: Exception -> L9
            r13.b((ResultModel) r14, "");     // Catch: Exception -> L9
        L39:
            return Unit.INSTANCE;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            ResultKt.throwOnFailure(r10);     // Catch: Exception -> L9
        L23:
            int r16 = ((UserAction) r10).ordinal();     // Catch: Exception -> L9
            if (r16 == 0) goto L29;
            if (r16 != 1) goto L28;
            LinkedHashMap r17 = j.f1750a;     // Catch: Exception -> L9
            j.b(this.e, DialogAction.f1722b, OperationType.f1732c);     // Catch: Exception -> L9
            this.f.a(-1, "Permission denied");     // Catch: Exception -> L9
            goto L39
        L28:
            throw new NoWhenBranchMatchedException();     // Catch: Exception -> L9
        L29:
            GetPhoneNumMethod r18 = this.f1895b;     // Catch: Exception -> L9
            String r19 = this.e;     // Catch: Exception -> L9
            this.f1894a = 3;     // Catch: Exception -> L9
            r10 = GetPhoneNumMethod.access$fetchPhoneCode(r18, r19, this);     // Catch: Exception -> L9
            if (r10 != r5) goto L32;
        L31:
            return r5;
        L14:
            ResultKt.throwOnFailure(r10);     // Catch: Exception -> L9
        L20:
            GetPhoneNumMethod r20 = this.f1895b;     // Catch: Exception -> L9
            Activity r21 = this.d;     // Catch: Exception -> L9
            String r22 = this.e;     // Catch: Exception -> L9
            this.f1894a = 2;     // Catch: Exception -> L9
            r10 = GetPhoneNumMethod.access$showDialogAndAwaitAction(r20, r21, (String) r10, r22, this);     // Catch: Exception -> L9
            if (r10 != r5) goto L23;
        L16:
            ResultKt.throwOnFailure(r10);
            GetPhoneNumMethod r23 = this.f1895b;     // Catch: Exception -> L9
            String r24 = this.f1896c;     // Catch: Exception -> L9
            this.f1894a = 1;     // Catch: Exception -> L9
            r10 = GetPhoneNumMethod.access$fetchPhoneMask(r23, r24, this);     // Catch: Exception -> L9
            if (r10 != r5) goto L20;
        L9:
            e = move-exception;
            Intrinsics.checkNotNullParameter(GetPhoneNumMethod.TAG, "tag");
            t0.d r25 = com.bytedance.ai.utils.c.f2846a;
            if (r25 == null) goto L37;
            r25.e(GetPhoneNumMethod.TAG, "Process failed", e);
        L37:
            this.f.a(0, "Error: " + e.getMessage());
            goto L39
        }
    }

    static {
        Companion = new a();
    }

    public GetPhoneNumMethod() {
    }

    public static final /* synthetic */ Object access$fetchPhoneCode(GetPhoneNumMethod r5, String r10, Continuation r11) {
        return r5.fetchPhoneCode(r10, r11);
    }

    public static final /* synthetic */ Object access$fetchPhoneMask(GetPhoneNumMethod r5, String r10, Continuation r11) {
        return r5.fetchPhoneMask(r10, r11);
    }

    public static final /* synthetic */ Object access$showDialogAndAwaitAction(GetPhoneNumMethod r5, Activity r10, String r11, String r12, Continuation r13) {
        return r5.showDialogAndAwaitAction(r10, r11, r12, r13);
    }

    public static final /* synthetic */ void access$showDialogAndAwaitAction$lambda$2$safeResume(AtomicBoolean r5, kotlinx.coroutines.j r10, UserAction r11) {
        showDialogAndAwaitAction$lambda$2$safeResume(r5, r10, r11);
    }

    private final Object fetchPhoneCode(String r5, Continuation<? super String> r10) {
        if ((r10 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r11 = (AnonymousClass1) r10;
        int r12 = r11.f1890c;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.f1890c = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.f1888a;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.f1890c;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        ResultKt.throwOnFailure(r13);
        Object r16 = ((Result) r13).m133unboximpl();
    L18:
        if (Result.m130isFailureimpl(r16) == false) goto L20;
        Object r17 = null;
    L21:
        String r18 = (String) r17;
        if (r18 != null) goto L27;
        Throwable r19 = Result.m127exceptionOrNullimpl(r16);
        if (r19 == null) goto L26;
        throw r19;
    L26:
        throw new Exception("phoneCode is null, but no error message");
    L27:
        return r18;
    L20:
        r17 = r16;
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        com.bytedance.ai.bridge.remote.b r20 = com.bytedance.ai.bridge.remote.b.f2069a;
        r11.f1890c = 1;
        r16 = r20.f(r5, r11);
        if (r16 != r14) goto L18;
        return r14;
    L7:
        r11 = new AnonymousClass1(this, r10);
        goto L8
    }

    private final Object fetchPhoneMask(String r5, Continuation<? super String> r10) {
        if ((r10 instanceof C01551) == false) goto L7;
        C01551 r11 = (C01551) r10;
        int r12 = r11.f1893c;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.f1893c = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.f1891a;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.f1893c;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        ResultKt.throwOnFailure(r13);
        Object r16 = ((Result) r13).m133unboximpl();
    L18:
        if (Result.m130isFailureimpl(r16) == false) goto L20;
        Object r17 = null;
    L21:
        String r18 = (String) r17;
        if (r18 != null) goto L27;
        Throwable r19 = Result.m127exceptionOrNullimpl(r16);
        if (r19 == null) goto L26;
        throw r19;
    L26:
        throw new Exception("phoneMask is null, but no error message");
    L27:
        return r18;
    L20:
        r17 = r16;
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        com.bytedance.ai.bridge.remote.b r20 = com.bytedance.ai.bridge.remote.b.f2069a;
        r11.f1893c = 1;
        r16 = r20.g(r5, r11);
        if (r16 != r14) goto L18;
        return r14;
    L7:
        r11 = new C01551(this, r10);
        goto L8
    }

    private final Object showDialogAndAwaitAction(Activity r10, String r11, String r12, Continuation<? super UserAction> r13) {
        l r14 = new l(1, IntrinsicsKt.intercepted(r13));
        r14.w();
        AtomicBoolean r5 = new AtomicBoolean(false);
        com.bytedance.ai.applet.login.a r15 = j.a(r12);
        if (r15 == null) goto L5;
        com.bytedance.ai.applet.login.d r16 = r15.f1733a;
    L6:
        com.bytedance.ai.applet.login.c r17 = new com.bytedance.ai.applet.login.c(r10);
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "phoneMask");
        GetPhoneNumberDialog r18 = new GetPhoneNumberDialog(r10);
        LayoutInflater.from(r18.getContext()).inflate(R$layout.get_phone_num_layout, r18, true);
        ((Button) r18.findViewById(R$id.applet_btn_accept)).setText(r11);
        if (r16 == null) goto L9;
        ((SimpleDraweeView) r18.findViewById(R$id.applet_app_icon)).setImageURI(Uri.parse(r16.b()));
        ((TextView) r18.findViewById(R$id.applet_app_title)).setText(r16.c());
    L13:
        b r19 = new b(r17, r5, r14);
        Intrinsics.checkNotNullParameter(r19, "listener");
        ((Button) r18.findViewById(R$id.applet_btn_reject)).setOnClickListener(new ar.a(r19, 6));
        c r110 = new c(r17, r5, r14);
        Intrinsics.checkNotNullParameter(r110, "listener");
        ((Button) r18.findViewById(R$id.applet_btn_accept)).setOnClickListener(new ar.a(r110, 7));
        r14.y(new d(0, r17, r5));
        if (r18.getParent() == null) goto L19;
        Intrinsics.checkNotNullParameter("DrawerWidgetContainer", "tag");
        t0.d r20 = com.bytedance.ai.utils.c.f2846a;
        if (r20 == null) goto L18;
        r20.d("DrawerWidgetContainer", "addNativeView: removing from parent first");
    L18:
        ViewParent r21 = r18.getParent();
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r21).removeView(r18);
    L19:
        FrameLayout r22 = r17.f1738c;
        if (r22 == null) goto L22;
        r22.addView(r18, -1, -2);
    L22:
        r17.b(r10);
        r17.c();
        Object r23 = r14.v();
        if (r23 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L25;
        DebugProbesKt.probeCoroutineSuspended(r13);
    L25:
        return r23;
    L9:
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r24 = com.bytedance.ai.utils.c.f2846a;
        if (r24 == null) goto L12;
        r24.w(TAG, "Login data is null, using fallback default values.");
    L12:
        ((TextView) r18.findViewById(R$id.applet_app_title)).setText(R$string.unknown_app_name);
        goto L13
    L5:
        r16 = null;
        goto L6
    }

    private static final void showDialogAndAwaitAction$lambda$2$safeResume(AtomicBoolean r5, kotlinx.coroutines.j r10, UserAction r11) {
        if (r5.compareAndSet(false, true) == false) goto L6;
        r10.e(r11, null);
        return;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(n1.c r5, ParamModel r10, f r11) {
        handle(r5, (AbsGetPhoneNumberMethodIDL.EmptyMessageModel) r10, r11);
    }

    public void handle(n1.c r12, AbsGetPhoneNumberMethodIDL.EmptyMessageModel r13, f r14) {
        Intrinsics.checkNotNullParameter(r12, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r14, "callback");
        n1.a r5 = (n1.a) r12;
        m1.j r10 = (m1.j) r5.b(m1.j.class);
        if (r10 == null) goto L5;
        String r11 = r10.a();
    L6:
        m1.j r15 = (m1.j) r5.b(m1.j.class);
        if (r15 == null) goto L9;
        String r16 = r15.b();
    L11:
        if (r16 != null) goto L13;
    L34:
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r17 = com.bytedance.ai.utils.c.f2846a;
        if (r17 == null) goto L37;
        r17.e(TAG, "appletId is null or empty");
    L37:
        r14.a("Error: appletId is null or empty");
        return;
    L13:
        if (r16.length() == 0) goto L34;
        String r18 = j0.l("handle app: ", r11, ", applet: ", r16, " get phone number");
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r19 = com.bytedance.ai.utils.c.f2846a;
        if (r19 == null) goto L18;
        r19.i(TAG, r18);
    L18:
        Activity r20 = r5.d();
        if (r20 != null) goto L21;
        r20 = s0.c.b();
    L21:
        Activity r21 = r20;
        if (r21 != null) goto L25;
        r14.a("Activity is null");
        return;
    L25:
        com.bytedance.ai.applet.login.a r22 = j.a(r16);
        if (r22 == null) goto L31;
        String r23 = r22.f1733a.d();
        if (r23 == null) goto L31;
    L32:
        BuildersKt.launch$default(h0.a(Dispatchers.getMain().plus(kotlinx.coroutines.j0.b())), null, null, new C01561(this, r23, r21, r16, r14, null), 3, null);
        return;
    L31:
        r23 = "null";
        goto L32
    L9:
        r16 = null;
        goto L11
    L5:
        r11 = null;
        goto L6
    }
}
