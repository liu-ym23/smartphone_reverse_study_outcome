package com.ss.android.lark.passport.flow.verify.viewmodel;

import androidx.lifecycle.ViewModelKt;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.flow.core.router.FlowStep;
import com.ss.android.lark.passport.flow.mfa.j;
import com.ss.android.lark.passport.flow.verify.entity.ButtonBean;
import com.ss.android.lark.passport.flow.verify.entity.VerifyBean;
import com.ss.android.lark.passport.signinsdk_api.base.NetworkErrorResult;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u001b2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0004\u001b\u001c\u001d\u001eB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u001a\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyPwdViewModel;", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyBaseViewModel;", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyPwdViewModel$ViewState;", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyPwdViewModel$ActionState;", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyPwdViewModel$UIEvent;", "verifyCommonViewModel", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyCommonViewModel;", "<init>", "(Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyCommonViewModel;)V", "repo", "Lcom/ss/android/lark/passport/flow/verify/model/StepInfoRepository;", "getRepo", "()Lcom/ss/android/lark/passport/flow/verify/model/StepInfoRepository;", "init", "", "reduce", "action", "resetPwd", "verifyPwd", "pwd", "", "handleFlowResult", "result", "Lcom/ss/android/lark/passport/flow/mfa/FlowMfaFlowUiResult;", "clearPwd", "", "initStateFLow", "Companion", "ViewState", "ActionState", "UIEvent", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class VerifyPwdViewModel extends VerifyBaseViewModel<d, a, c> {
    public static final b Companion = null;
    private static final String TAG = "VerifyPwdViewModel";
    private final VerifyCommonViewModel verifyCommonViewModel;

    public static abstract class a extends VerifyBaseViewModel.a {

        /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.verify.viewmodel.VerifyPwdViewModel$a$a, reason: collision with other inner class name */
        public static final class C0093a extends a {
            public static final C0093a a = null;

            static {
                a = new C0093a();
            }

            public C0093a() {
            }
        }

        public static final class b extends a {
            public final String a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof b) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "VerifyPwdClicked(pwd=" + this.a + ')';
            }

            public b(String r2) {
                Intrinsics.checkNotNullParameter(r2, "pwd");
                this.a = r2;
            }
        }

        public a() {
        }
    }

    public static final class b {
        public b() {
        }
    }

    public static abstract class c extends VerifyBaseViewModel.b {

        public static final class a extends c {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        public static final class b extends c {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }
        }

        /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.verify.viewmodel.VerifyPwdViewModel$c$c, reason: collision with other inner class name */
        public static final class C0094c extends c {
            public static final C0094c a = null;

            static {
                a = new C0094c();
            }

            public C0094c() {
            }
        }

        public static final class d extends c {
            public final NetworkErrorResult a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof d) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((d) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "NeedHandleError(err=" + this.a + ')';
            }

            public d(NetworkErrorResult r2) {
                Intrinsics.checkNotNullParameter(r2, "err");
                this.a = r2;
            }
        }

        public static final class e extends c {
            public final FlowStep a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof e) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((e) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "RouteToNext(stepData=" + this.a + ')';
            }

            public e(FlowStep r2) {
                Intrinsics.checkNotNullParameter(r2, "stepData");
                this.a = r2;
            }
        }

        public static final class f extends c {
            public final String a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof f) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((f) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "ShowErrToast(errMsg=" + this.a + ')';
            }

            public f(String r2) {
                Intrinsics.checkNotNullParameter(r2, "errMsg");
                this.a = r2;
            }
        }

        public static final class g extends c {
            public static final g a = null;

            static {
                a = new g();
            }

            public g() {
            }
        }

        public c() {
        }
    }

    public static abstract class d extends VerifyBaseViewModel.c {

        public static final class a extends d {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        public static final class b extends d {
            public final VerifyBean a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof b) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "VerifyInfo(info=" + this.a + ')';
            }

            public b(VerifyBean r2) {
                Intrinsics.checkNotNullParameter(r2, "info");
                this.a = r2;
            }
        }

        public d() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.verify.viewmodel.VerifyPwdViewModel$resetPwd$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.passport.flow.verify.viewmodel.VerifyPwdViewModel$resetPwd$1", f = "VerifyPwdViewModel.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ VerifyPwdViewModel this$0;

        public AnonymousClass1(VerifyPwdViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            VerifyPwdViewModel r2 = (VerifyPwdViewModel) this.L$0;
            ResultKt.throwOnFailure(r5);
        L16:
            VerifyPwdViewModel.access$handleFlowResult(r2, (j) r5, false);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            VerifyPwdViewModel r6 = this.this$0;
            int r3 = com.ss.android.lark.passport.flow.verify.viewmodel.a.a;
            VerifyCommonViewModel r4 = VerifyPwdViewModel.access$getVerifyCommonViewModel$p(r6);
            ButtonBean r7 = VerifyPwdViewModel.access$getRepo(this.this$0).e.getRetrieveButton();
            if (r7 == null) goto L11;
            FlowStep r8 = r7.getNext();
        L12:
            this.L$0 = r6;
            this.label = 1;
            j r9 = com.ss.android.lark.passport.flow.verify.viewmodel.a.a(r4, r8);
            if (r9 != r0) goto L15;
            return r0;
        L15:
            r2 = r6;
            r5 = r9;
            goto L16
        L11:
            r8 = null;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.verify.viewmodel.VerifyPwdViewModel$verifyPwd$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.passport.flow.verify.viewmodel.VerifyPwdViewModel$verifyPwd$1", f = "VerifyPwdViewModel.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03151 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $pwd;
        Object L$0;
        int label;
        final /* synthetic */ VerifyPwdViewModel this$0;

        public C03151(VerifyPwdViewModel r1, String r2, Continuation<? super C03151> r3) {
            this.this$0 = r1;
            this.$pwd = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03151(this.this$0, this.$pwd, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            VerifyPwdViewModel r2 = (VerifyPwdViewModel) this.L$0;
            ResultKt.throwOnFailure(r6);
        L12:
            VerifyPwdViewModel.handleFlowResult$default(r2, (j) r6, false, 2, null);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            VerifyPwdViewModel r7 = this.this$0;
            int r3 = com.ss.android.lark.passport.flow.verify.viewmodel.a.a;
            VerifyCommonViewModel r4 = VerifyPwdViewModel.access$getVerifyCommonViewModel$p(r7);
            String r5 = this.$pwd;
            this.L$0 = r7;
            this.label = 1;
            Object r8 = com.ss.android.lark.passport.flow.verify.viewmodel.a.d(r4, new VerifyFlowMfaBridge$submitFactor$2(r5, null), this);
            if (r8 != r0) goto L11;
            return r0;
        L11:
            r2 = r7;
            r6 = r8;
            goto L12
        }
    }

    static {
        Companion = new b();
    }

    private final xyb.a getRepo() {
        return (xyb.a) this.verifyCommonViewModel.getRepo().getValue();
    }

    private final void resetPwd() {
        PassportLog.d(TAG, "begin reset password");
        emitEvent(c.g.a);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }

    public final void init() {
        getViewStateFlow().setValue(new d.b(getRepo().e));
        PassportLog.d(TAG, "init() emit ClearPwd");
        emitEvent(c.a.a);
    }

    @Override // com.ss.android.lark.passport.flow.verify.viewmodel.VerifyBaseViewModel
    public /* bridge */ /* synthetic */ VerifyBaseViewModel.c initStateFLow() {
        return initStateFLow();
    }

    @Override // com.ss.android.lark.passport.flow.verify.viewmodel.VerifyBaseViewModel
    public d initStateFLow() {
        return d.a.a;
    }

    public VerifyPwdViewModel(VerifyCommonViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "verifyCommonViewModel");
        this.verifyCommonViewModel = r2;
    }

    public static final /* synthetic */ xyb.a access$getRepo(VerifyPwdViewModel r0) {
        return r0.getRepo();
    }

    public static final /* synthetic */ VerifyCommonViewModel access$getVerifyCommonViewModel$p(VerifyPwdViewModel r0) {
        return r0.verifyCommonViewModel;
    }

    private final void verifyPwd(String r8) {
        emitEvent(c.g.a);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03151(this, r8, null), 3, null);
    }

    public void reduce(a r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        if ((r2 instanceof a.b) == false) goto L6;
        verifyPwd(((a.b) r2).a);
        return;
    L6:
        if ((r2 instanceof a.C0093a) == false) goto L10;
        resetPwd();
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.ss.android.lark.passport.flow.verify.viewmodel.VerifyBaseViewModel
    public /* bridge */ /* synthetic */ void reduce(VerifyBaseViewModel.a r1) {
        reduce((a) r1);
    }

    private final void handleFlowResult(j r4, boolean r5) {
        if ((r4 instanceof j.d) == false) goto L6;
        StringBuilder r6 = new StringBuilder("route next step: ");
        j.d r7 = (j.d) r4;
        r6.append(r7.a.getNextStep());
        PassportLog.d(TAG, r6.toString());
        emitEvent(new c.e(r7.a));
        return;
    L6:
        if ((r4 instanceof j.c) == false) goto L17;
        int r0 = com.ss.android.lark.passport.flow.verify.viewmodel.a.a;
        NetworkErrorResult r8 = com.ss.android.lark.passport.flow.verify.viewmodel.a.c(((j.c) r4).a);
        PassportLog.b(TAG, "password flow failed: " + r8);
        emitEvent(c.b.a);
        if (r8.getErrorCode() != 4203) goto L10;
    L13:
        emitEvent(new c.f(r8.getErrorMessage()));
        if (r5 == false) goto L27;
        emitEvent(c.a.a);
        return;
    L27:
        return;
    L10:
        if (r8.getErrorCode() == 2001) goto L13;
        emitEvent(new c.d(r8));
        return;
    L17:
        if (Intrinsics.areEqual(r4, j.b.a) == false) goto L20;
        emitEvent(c.b.a);
        emitEvent(c.C0094c.a);
        return;
    L20:
        if ((r4 instanceof j.a) == false) goto L24;
        emitEvent(c.b.a);
        return;
    L24:
        throw new NoWhenBranchMatchedException();
    }

    public static final /* synthetic */ void access$handleFlowResult(VerifyPwdViewModel r0, j r1, boolean r2) {
        r0.handleFlowResult(r1, r2);
    }

    public static /* synthetic */ void handleFlowResult$default(VerifyPwdViewModel r0, j r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        r0.handleFlowResult(r1, r2);
    }
}
