package com.bytedance.ai.applet.moa;

import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.app.OnlineAppletApplication;
import com.bytedance.ai.applet.app.base.ApplicationRouter;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.remote.UserAuthService;
import com.bytedance.ai.bridge.remote.model.CheckType;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class MoaLoginGrantingStep implements n, q {
    public static final /* synthetic */ int m = 0;
    public final u2.f a;
    public final u2.j b;
    public final Type c;
    public final CoroutineScope d;
    public final MoaLoginPanelPresenter e;
    public State f;
    public o g;
    public kotlinx.coroutines.i<? super MoaStepResult> h;
    public boolean i;
    public OnlineAppletApplication j;
    public boolean k;
    public final MoaLoginGrantingStep$loginAppLifecycleObserver$1 l;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/applet/moa/MoaLoginGrantingStep$State;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "CHECKING_PRIVACY", "WAITING_PRIVACY", "ACCEPTING_PRIVACY", "WAITING_LOGIN", "FETCHING_LOGIN_CODE", "OPENING_LOGIN_PAGE", "WAITING_LOGIN_RESULT", "EXCHANGING_CODE", "DISMISSING", "DONE", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum State extends Enum<State> {
        public static final State ACCEPTING_PRIVACY = null;
        public static final State CHECKING_PRIVACY = null;
        public static final State DISMISSING = null;
        public static final State DONE = null;
        public static final State EXCHANGING_CODE = null;
        public static final State FETCHING_LOGIN_CODE = null;
        public static final State IDLE = null;
        public static final State OPENING_LOGIN_PAGE = null;
        public static final State WAITING_LOGIN = null;
        public static final State WAITING_LOGIN_RESULT = null;
        public static final State WAITING_PRIVACY = null;
        public static final /* synthetic */ State[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<State> getEntries() {
            return b;
        }

        static {
            State r0 = new State("IDLE", 0);
            IDLE = r0;
            State r1 = new State("CHECKING_PRIVACY", 1);
            CHECKING_PRIVACY = r1;
            State r10 = new State("WAITING_PRIVACY", 2);
            WAITING_PRIVACY = r10;
            State r11 = new State("ACCEPTING_PRIVACY", 3);
            ACCEPTING_PRIVACY = r11;
            State r12 = new State("WAITING_LOGIN", 4);
            WAITING_LOGIN = r12;
            State r13 = new State("FETCHING_LOGIN_CODE", 5);
            FETCHING_LOGIN_CODE = r13;
            State r14 = new State("OPENING_LOGIN_PAGE", 6);
            OPENING_LOGIN_PAGE = r14;
            State r15 = new State("WAITING_LOGIN_RESULT", 7);
            WAITING_LOGIN_RESULT = r15;
            State r16 = new State("EXCHANGING_CODE", 8);
            EXCHANGING_CODE = r16;
            State r17 = new State("DISMISSING", 9);
            DISMISSING = r17;
            State r18 = new State("DONE", 10);
            DONE = r18;
            State[] r19 = {r0, r1, r10, r11, r12, r13, r14, r15, r16, r17, r18};
            a = r19;
            b = EnumEntriesKt.enumEntries(r19);
        }

        public static State[] values() {
            return (State[]) a.clone();
        }

        public static State valueOf(String r1) {
            return (State) r27.a.a(State.class, r1);
        }

        public State(String r1, int r10) {
            super(r1, r10);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/applet/moa/MoaLoginGrantingStep$Type;", "", "<init>", "(Ljava/lang/String;I)V", "PRIVACY", "LOGIN", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Type extends Enum<Type> {
        public static final Type LOGIN = null;
        public static final Type PRIVACY = null;
        public static final /* synthetic */ Type[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Type> getEntries() {
            return b;
        }

        static {
            Type r0 = new Type("PRIVACY", 0);
            PRIVACY = r0;
            Type r1 = new Type("LOGIN", 1);
            LOGIN = r1;
            Type[] r10 = {r0, r1};
            a = r10;
            b = EnumEntriesKt.enumEntries(r10);
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public Type(String r1, int r10) {
            super(r1, r10);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[Type.values().length];
            r0[Type.PRIVACY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[Type.LOGIN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L6:
            a = r0;
            int[] r1 = new int[MoaLoginPanelType.values().length];
            r1[MoaLoginPanelType.PRIVACY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            r1[MoaLoginPanelType.LOGIN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L9:
            b = r1;
        }
    }

    public static final class c implements Function1<Throwable, Unit> {
        public final /* synthetic */ MoaLoginGrantingStep a;
        public final /* synthetic */ kotlinx.coroutines.i<MoaStepResult> b;

        public c(MoaLoginGrantingStep r1, kotlinx.coroutines.j r10) {
            this.a = r1;
            this.b = r10;
        }

        public final Object invoke(Object r10) {
            Throwable r11 = (Throwable) r10;
            MoaLoginGrantingStep r12 = this.a;
            BuildersKt.launch$default(r12.d, null, null, new MoaLoginGrantingStep$requestConfirmation$2$1$1(r12, this.b, null), 3, null);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public static IllegalStateException l() {
        return new IllegalStateException("MOA login flow is no longer waiting for this callback");
    }

    public final void q() {
        OnlineAppletApplication r0 = this.j;
        if (r0 == null) goto L7;
        LifecycleRegistry r1 = ((AppletApplication) r0).a;
        if (r1 == null) goto L7;
        r1.removeObserver(this.l);
    L7:
        this.j = null;
        this.k = false;
    }

    @Override // com.bytedance.ai.applet.moa.n
    public final void a(o r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this.f = State.DONE;
        this.h = null;
        this.e.b();
        q();
        CoroutineScopeKt.cancel$default(this.d, null, 1, null);
        this.g = null;
    }

    @Override // com.bytedance.ai.applet.moa.q
    public final void b(com.bytedance.ai.bridge.method.login.c r10) {
        Intrinsics.checkNotNullParameter(r10, "completion");
        if (this.f == State.WAITING_PRIVACY) goto L5;
    L9:
        Result.Companion r0 = Result.Companion;
        r10.invoke(Result.box-impl(Result.constructor-impl(ResultKt.createFailure(l()))));
        return;
    L5:
        if (this.h == null) goto L9;
        this.f = State.ACCEPTING_PRIVACY;
        BuildersKt.launch$default(this.d, null, null, new MoaLoginGrantingStep$handlePrivacyAgreement$1(this, r10, null), 3, null);
    }

    @Override // com.bytedance.ai.applet.moa.q
    public final void h(com.bytedance.ai.bridge.method.phoneNum.c r10) {
        Intrinsics.checkNotNullParameter(r10, "completion");
        if (this.f == State.WAITING_LOGIN) goto L5;
    L9:
        Result.Companion r0 = Result.Companion;
        r10.invoke(Result.box-impl(Result.constructor-impl(ResultKt.createFailure(l()))));
        return;
    L5:
        if (this.h == null) goto L9;
        BuildersKt.launch$default(this.d, null, null, new MoaLoginGrantingStep$handleGetPhoneNumber$1(this, r10, null), 3, null);
    }

    @Override // com.bytedance.ai.applet.moa.q
    public final boolean i(MoaLoginPanelType r10) {
        Intrinsics.checkNotNullParameter(r10, "type");
        int r11 = b.b[r10.ordinal()];
        if (r11 == 1) goto L14;
        if (r11 != 2) goto L12;
        State r12 = this.f;
        if (r12 != State.WAITING_LOGIN) goto L9;
    L15:
        boolean r13 = true;
    L17:
        if (r13 == true) goto L19;
    L23:
        return false;
    L19:
        if (this.h == null) goto L23;
        this.f = State.DISMISSING;
        BuildersKt.launch$default(this.d, null, null, new MoaLoginGrantingStep$handleClosePanel$1(this, null), 3, null);
        return true;
    L9:
        if (r12 == State.WAITING_LOGIN_RESULT) goto L15;
    L16:
        r13 = false;
        goto L17
    L12:
        throw new NoWhenBranchMatchedException();
    L14:
        if (this.f != State.WAITING_PRIVACY) goto L16;
        goto L15
    }

    public final void k(MoaStepResult r10) {
        kotlinx.coroutines.i<? super MoaStepResult> r0 = this.h;
        if (r0 != null) goto L5;
        return;
    L5:
        this.h = null;
        this.f = State.IDLE;
        this.i = false;
        this.e.b();
        q();
        if (r0.isActive() == false) goto L9;
        r0.resumeWith(Result.constructor-impl(r10));
        return;
    }

    public final Object n(Continuation<? super Unit> r10) {
        if ((r10 instanceof MoaLoginGrantingStep$routeToLogin$1) == false) goto L7;
        MoaLoginGrantingStep$routeToLogin$1 r0 = (MoaLoginGrantingStep$routeToLogin$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r0.label;
        if (r13 == 0) goto L16;
        if (r13 == 1) goto L15;
        if (r13 != 2) goto L14;
        ResultKt.throwOnFailure(r11);
    L38:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r11);
        Object r14 = ((Result) r11).unbox-impl();
    L28:
        if (Result.isFailure-impl(r14) == false) goto L33;
        if (this.h == null) goto L33;
        com.bytedance.ai.utils.g.a.e("MoaLoginGrantingStep", "Failed to open default MOA login page", Result.exceptionOrNull-impl(r14));
        k(MoaStepResult.FAILED);
    L33:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r11);
        String r15 = this.b.c();
        if (r15 != null) goto L19;
    L22:
        boolean r16 = true;
    L23:
        if (r16 == false) goto L34;
        r0.label = 1;
        r14 = m("mcp-login-page", r0);
        if (r14 != r12) goto L28;
        return r12;
    L34:
        r0.label = 2;
        if (o(r0) != r12) goto L38;
        return r12;
    L19:
        if (StringsKt.isBlank(r15) == true) goto L22;
        r16 = false;
    L7:
        r0 = new MoaLoginGrantingStep$routeToLogin$1(this, r10);
        goto L8
    }

    public final Object o(Continuation<? super Unit> r10) {
        if ((r10 instanceof MoaLoginGrantingStep$showLoginPanel$1) == false) goto L7;
        MoaLoginGrantingStep$showLoginPanel$1 r0 = (MoaLoginGrantingStep$showLoginPanel$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        MoaLoginGrantingStep$showLoginPanel$1 r11 = r0;
        Object r12 = r11.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r11.label;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        ResultKt.throwOnFailure(r12);
        Object r15 = ((Result) r12).unbox-impl();
    L22:
        if (Result.isFailure-impl(r15) == false) goto L29;
        if (this.f != State.WAITING_LOGIN) goto L29;
        if (this.h == null) goto L29;
        com.bytedance.ai.utils.g.a.e("MoaLoginGrantingStep", "Failed to show MOA login panel", Result.exceptionOrNull-impl(r15));
        k(MoaStepResult.FAILED);
    L29:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        o r16 = this.g;
        if (r16 != null) goto L18;
        k(MoaStepResult.FAILED);
        return Unit.INSTANCE;
    L18:
        this.f = State.WAITING_LOGIN;
        MoaLoginPanelPresenter r17 = this.e;
        u2.j r18 = this.b;
        MoaLoginPanelType r19 = MoaLoginPanelType.LOGIN;
        Function0<Unit> r20 = new r(this);
        r11.label = 1;
        r15 = r17.c(r16, r18, r19, r20, r11);
        if (r15 != r13) goto L22;
        return r13;
    L7:
        r0 = new MoaLoginGrantingStep$showLoginPanel$1(this, r10);
        goto L8
    }

    public final Object p(Continuation<? super Unit> r10) {
        if ((r10 instanceof MoaLoginGrantingStep$showPrivacyPanel$1) == false) goto L7;
        MoaLoginGrantingStep$showPrivacyPanel$1 r0 = (MoaLoginGrantingStep$showPrivacyPanel$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        MoaLoginGrantingStep$showPrivacyPanel$1 r11 = r0;
        Object r12 = r11.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r11.label;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        ResultKt.throwOnFailure(r12);
        Object r15 = ((Result) r12).unbox-impl();
    L22:
        if (Result.isFailure-impl(r15) == false) goto L29;
        if (this.f != State.WAITING_PRIVACY) goto L29;
        if (this.h == null) goto L29;
        com.bytedance.ai.utils.g.a.e("MoaLoginGrantingStep", "Failed to show MOA privacy panel", Result.exceptionOrNull-impl(r15));
        k(MoaStepResult.FAILED);
    L29:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        o r16 = this.g;
        if (r16 != null) goto L18;
        k(MoaStepResult.FAILED);
        return Unit.INSTANCE;
    L18:
        this.f = State.WAITING_PRIVACY;
        MoaLoginPanelPresenter r17 = this.e;
        u2.j r18 = this.b;
        MoaLoginPanelType r19 = MoaLoginPanelType.PRIVACY;
        Function0<Unit> r20 = new s(this);
        r11.label = 1;
        r15 = r17.c(r16, r18, r19, r20, r11);
        if (r15 != r13) goto L22;
        return r13;
    L7:
        r0 = new MoaLoginGrantingStep$showPrivacyPanel$1(this, r10);
        goto L8
    }

    public static final Object j(MoaLoginGrantingStep r10, Continuation r11) {
        r10.getClass();
        if ((r11 instanceof MoaLoginGrantingStep$prepareLogin$1) == false) goto L7;
        MoaLoginGrantingStep$prepareLogin$1 r0 = (MoaLoginGrantingStep$prepareLogin$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r0.label;
        if (r14 == 0) goto L18;
        if (r14 == 1) goto L17;
        if (r14 == 2) goto L16;
        if (r14 == 3) goto L16;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r12);
    L51:
        return Unit.INSTANCE;
    L17:
        ResultKt.throwOnFailure(r12);
        Object r15 = ((Result) r12).unbox-impl();
    L32:
        if (r10.f != State.CHECKING_PRIVACY) goto L49;
        if (r10.h == null) goto L49;
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L39;
        com.bytedance.ai.utils.g.a.e("MoaLoginGrantingStep", "Failed to query privacy before MOA login", r16);
        r10.k(MoaStepResult.FAILED);
        goto L51
    L39:
        if (((Boolean) r15).booleanValue() == false) goto L43;
        r0.label = 2;
        if (r10.n(r0) != r13) goto L51;
        return r13;
    L43:
        r0.label = 3;
        if (r10.p(r0) != r13) goto L51;
        return r13;
    L49:
        return Unit.INSTANCE;
    L18:
        ResultKt.throwOnFailure(r12);
        o r17 = r10.g;
        if (r17 != null) goto L21;
        r10.k(MoaStepResult.FAILED);
        return Unit.INSTANCE;
    L21:
        r10.f = State.CHECKING_PRIVACY;
        String r18 = r17.a.d();
        String r19 = "";
        if (r18 != null) goto L24;
        r18 = "";
    L24:
        String r20 = r17.a.g();
        if (r20 == null) goto L28;
        r19 = r20;
    L28:
        UserAuthService r21 = UserAuthService.a;
        r0.label = 1;
        r15 = r21.d(r18, r19, r0);
        if (r15 != r13) goto L32;
        return r13;
    L7:
        r0 = new MoaLoginGrantingStep$prepareLogin$1(r10, r11);
        goto L8
    }

    @Override // com.bytedance.ai.applet.moa.n
    public final Object c(o r10, Continuation<? super MoaStepResult> r11) {
        if (this.h == null) goto L6;
        com.bytedance.ai.utils.g.a.e("MoaLoginGrantingStep", "A MOA login confirmation is already active");
        return MoaStepResult.FAILED;
    L6:
        this.g = r10;
        this.f = State.IDLE;
        kotlinx.coroutines.j r12 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r11), 1);
        r12.C();
        this.h = r12;
        r12.i(new c(this, r12));
        BuildersKt.launch$default(this.d, null, null, new MoaLoginGrantingStep$requestConfirmation$2$2(this, null), 3, null);
        Object r13 = r12.B();
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        DebugProbesKt.probeCoroutineSuspended(r11);
    L9:
        return r13;
    }

    @Override // com.bytedance.ai.applet.moa.q
    public final void e(Long r10, com.bytedance.ai.bridge.method.login.i r11) {
        Intrinsics.checkNotNullParameter(r11, "completion");
        if (this.f == State.WAITING_LOGIN) goto L5;
    L9:
        Result.Companion r12 = Result.Companion;
        r11.invoke(Result.box-impl(Result.constructor-impl(ResultKt.createFailure(l()))));
        return;
    L5:
        if (this.h == null) goto L9;
        this.f = State.FETCHING_LOGIN_CODE;
        BuildersKt.launch$default(this.d, null, null, new MoaLoginGrantingStep$handleLogin$1(this, r11, r10, null), 3, null);
    }

    @Override // com.bytedance.ai.applet.moa.q
    public final void f(String r10, com.bytedance.ai.bridge.method.login.l r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "completion");
        if (this.f == State.WAITING_LOGIN) goto L5;
    L9:
        Result.Companion r12 = Result.Companion;
        r11.invoke(Result.box-impl(Result.constructor-impl(ResultKt.createFailure(l()))));
        return;
    L5:
        if (this.h == null) goto L9;
        this.f = State.OPENING_LOGIN_PAGE;
        BuildersKt.launch$default(this.d, null, null, new MoaLoginGrantingStep$handleOpenLoginPage$1(this, r10, r11, null), 3, null);
    }

    public final Object m(String r10, Continuation<? super Result<Unit>> r11) {
        if ((r11 instanceof MoaLoginGrantingStep$openLoginPage$1) == false) goto L7;
        MoaLoginGrantingStep$openLoginPage$1 r0 = (MoaLoginGrantingStep$openLoginPage$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r0.label;
        if (r14 == 0) goto L16;
        if (r14 == 1) goto L15;
        if (r14 != 2) goto L14;
        OnlineAppletApplication r15 = (OnlineAppletApplication) r0.L$0;
        ResultKt.throwOnFailure(r12);
        Object r16 = ((Result) r12).unbox-impl();
    L47:
        if (Result.isSuccess-impl(r16) == true) goto L49;
    L55:
        return r16;
    L49:
        if (this.f != State.OPENING_LOGIN_PAGE) goto L55;
        if (this.h == null) goto L55;
        this.i = true;
        this.f = State.WAITING_LOGIN_RESULT;
        if (this.j == r15) goto L55;
        q();
        this.j = r15;
        this.k = r15.m();
        ((AppletApplication) r15).a.addObserver(this.l);
        goto L55
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r17 = (String) r0.L$2;
        o r18 = (o) r0.L$1;
        String r19 = (String) r0.L$0;
        ResultKt.throwOnFailure(r12);
        String r20 = r19;
    L28:
        if ((r12 instanceof OnlineAppletApplication) == false) goto L30;
        OnlineAppletApplication r110 = (OnlineAppletApplication) r12;
    L31:
        if (r110 != null) goto L56;
        Result.Companion r111 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("Online app " + r17 + " is unavailable")));
    L56:
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L36
        Object r113 = Result.constructor-impl(UriProtector.parse(r20).buildUpon().appendQueryParameter("__moa_attempt_id", r18.c).build().toString());     // Catch: Throwable -> L36
    L38:
        Object r21 = r20;
        if (Result.isFailure-impl(r113) == true) goto L42;
        r21 = r113;
    L42:
        ApplicationRouter r114 = r110.h().d();
        r0.L$0 = r110;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 2;
        Object r115 = r114.i((String) r21, null, r0);
        if (r115 != r13) goto L45;
        return r13;
    L45:
        OnlineAppletApplication r22 = r110;
        r16 = r115;
        r15 = r22;
    L36:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r113 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L38
    L30:
        r110 = null;
        goto L31
    L16:
        ResultKt.throwOnFailure(r12);
        r18 = this.g;
        if (r18 != null) goto L20;
        Result.Companion r116 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(l()));
    L20:
        String r117 = r18.a.d();
        if (r117 != null) goto L23;
        r117 = "";
    L23:
        this.f = State.OPENING_LOGIN_PAGE;
        this.e.b();
        AppletAppManagerService r24 = AppletAppManagerService.INSTANCE;
        r0.L$0 = r10;
        r0.L$1 = r18;
        r0.L$2 = r117;
        r0.label = 1;
        Object r25 = r24.d(r117, r0);
        if (r25 != r13) goto L26;
        return r13;
    L26:
        r20 = r10;
        r17 = r117;
        r12 = r25;
    L7:
        r0 = new MoaLoginGrantingStep$openLoginPage$1(this, r11);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r1v7, types: [com.bytedance.ai.applet.moa.MoaLoginGrantingStep$loginAppLifecycleObserver$1] */
    public MoaLoginGrantingStep(u2.f r1, u2.j r10, Type r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.e = new MoaLoginPanelPresenter();
        this.f = State.IDLE;
        this.l = new MoaLoginGrantingStep$loginAppLifecycleObserver$1(this);
    }

    @Override // com.bytedance.ai.applet.moa.q
    public final void d(boolean r10, String r11, com.bytedance.ai.bridge.method.login.o r12) {
        Intrinsics.checkNotNullParameter(r12, "completion");
        State r0 = this.f;
        if (r0 != State.WAITING_PRIVACY) goto L12;
        if (this.h == null) goto L12;
        if (r10 == false) goto L9;
        Result.Companion r13 = Result.Companion;
        r12.invoke(Result.box-impl(Result.constructor-impl(ResultKt.createFailure(new IllegalArgumentException("Unexpected successful privacy callback")))));
        return;
    L9:
        Result.Companion r14 = Result.Companion;
        r12.invoke(Result.box-impl(Result.constructor-impl(Unit.INSTANCE)));
        k(MoaStepResult.REFUSED);
        return;
    L12:
        if (r0 == State.WAITING_LOGIN) goto L16;
        if (r0 == State.WAITING_LOGIN_RESULT) goto L16;
    L17:
        Result.Companion r15 = Result.Companion;
        r12.invoke(Result.box-impl(Result.constructor-impl(ResultKt.createFailure(l()))));
        return;
    L16:
        if (this.h == null) goto L17;
        if (r10 == true) goto L22;
        Result.Companion r16 = Result.Companion;
        r12.invoke(Result.box-impl(Result.constructor-impl(Unit.INSTANCE)));
        k(MoaStepResult.FAILED);
        return;
    L22:
        if (r11 != null) goto L24;
    L27:
        boolean r17 = true;
    L28:
        if (r17 == false) goto L31;
        IllegalArgumentException r18 = new IllegalArgumentException("Login code is missing");
        Result.Companion r19 = Result.Companion;
        r12.invoke(Result.box-impl(Result.constructor-impl(ResultKt.createFailure(r18))));
        k(MoaStepResult.FAILED);
        return;
    L31:
        this.f = State.EXCHANGING_CODE;
        BuildersKt.launch$default(this.d, null, null, new MoaLoginGrantingStep$handlePostLoginResult$1(this, r11, r12, null), 3, null);
        return;
    L24:
        if (StringsKt.isBlank(r11) == true) goto L27;
        r17 = false;
        goto L28
    }

    @Override // com.bytedance.ai.applet.moa.n
    public final Object g(o r10, boolean r11, Continuation<? super MoaStepResult> r12) {
        if ((r12 instanceof MoaLoginGrantingStep$handleAction$1) == false) goto L7;
        MoaLoginGrantingStep$handleAction$1 r0 = (MoaLoginGrantingStep$handleAction$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r0.label;
        if (r15 == 0) goto L16;
        if (r15 == 1) goto L15;
        if (r15 != 2) goto L14;
        r11 = r0.Z$0;
        ResultKt.throwOnFailure(r13);
        Object r16 = ((Result) r13).unbox-impl();
    L30:
        if (Result.isSuccess-impl(r16) == false) goto L32;
        r16 = Boxing.boxBoolean(((p4.i) r16).c);
    L32:
        Object r17 = Result.constructor-impl(r16);
    L38:
        Throwable r18 = Result.exceptionOrNull-impl(r17);
        if (r18 == null) goto L41;
        com.bytedance.ai.utils.g.a.e("MoaLoginGrantingStep", "Failed to query " + this.c.name().toLowerCase(Locale.ROOT) + " status", r18);
        return MoaStepResult.FAILED;
    L41:
        if (((Boolean) r17).booleanValue() == true) goto L52;
        if (r11 == false) goto L45;
    L47:
        if (r11 == true) goto L55;
        return MoaStepResult.CONTINUE;
    L55:
        return MoaStepResult.REQUIRES_CONFIRMATION;
    L45:
        if (this.a.f() == false) goto L47;
        return MoaStepResult.REFUSED;
    L52:
        return MoaStepResult.CONTINUE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r11 = r0.Z$0;
        ResultKt.throwOnFailure(r13);
        r17 = ((Result) r13).unbox-impl();
        goto L38
    L16:
        ResultKt.throwOnFailure(r13);
        String r19 = r10.a.d();
        String r20 = "";
        if (r19 != null) goto L19;
        r19 = "";
    L19:
        String r21 = r10.a.g();
        if (r21 == null) goto L23;
        r20 = r21;
    L23:
        int r22 = b.a[this.c.ordinal()];
        if (r22 == 1) goto L35;
        if (r22 != 2) goto L34;
        UserAuthService r23 = UserAuthService.a;
        CheckType r24 = CheckType.CHECK_TYPE_LOGIN_STATUS;
        r0.Z$0 = r11;
        r0.label = 2;
        r16 = r23.e(r19, r20, r24, r0);
        if (r16 != r14) goto L30;
        return r14;
    L34:
        throw new NoWhenBranchMatchedException();
    L35:
        UserAuthService r25 = UserAuthService.a;
        r0.Z$0 = r11;
        r0.label = 1;
        r17 = r25.d(r19, r20, r0);
        if (r17 != r14) goto L38;
        return r14;
    L7:
        r0 = new MoaLoginGrantingStep$handleAction$1(this, r12);
        goto L8
    }
}
