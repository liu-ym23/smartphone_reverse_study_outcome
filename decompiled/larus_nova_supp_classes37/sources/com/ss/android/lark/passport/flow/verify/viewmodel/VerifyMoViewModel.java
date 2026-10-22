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
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u00132\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0004\u0013\u0014\u0015\u0016B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyMoViewModel;", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyBaseViewModel;", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyMoViewModel$ViewState;", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyMoViewModel$ActionState;", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyMoViewModel$UIEvent;", "verifyCommonViewModel", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyCommonViewModel;", "<init>", "(Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyCommonViewModel;)V", "repo", "Lcom/ss/android/lark/passport/flow/verify/model/StepInfoRepository;", "getRepo", "()Lcom/ss/android/lark/passport/flow/verify/model/StepInfoRepository;", "init", "", "reduce", "action", "sendMoTextCheck", "initStateFLow", "Companion", "ViewState", "ActionState", "UIEvent", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class VerifyMoViewModel extends VerifyBaseViewModel<d, a, c> {
    public static final b Companion = null;
    private static final String TAG = "VerifyMoViewModel";
    private final VerifyCommonViewModel verifyCommonViewModel;

    public static abstract class a extends VerifyBaseViewModel.a {

        /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.verify.viewmodel.VerifyMoViewModel$a$a, reason: collision with other inner class name */
        public static final class C0091a extends a {
            public static final C0091a a = null;

            static {
                a = new C0091a();
            }

            public C0091a() {
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

        /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.verify.viewmodel.VerifyMoViewModel$c$c, reason: collision with other inner class name */
        public static final class C0092c extends c {
            public final NetworkErrorResult a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof C0092c) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((C0092c) r4).a) == true) goto L11;
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

            public C0092c(NetworkErrorResult r2) {
                Intrinsics.checkNotNullParameter(r2, "err");
                this.a = r2;
            }
        }

        public static final class d extends c {
            public final FlowStep a;

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
                return "RouteToNext(stepData=" + this.a + ')';
            }

            public d(FlowStep r2) {
                Intrinsics.checkNotNullParameter(r2, "stepData");
                this.a = r2;
            }
        }

        public static final class e extends c {
            public static final e a = null;

            static {
                a = new e();
            }

            public e() {
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

    /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.verify.viewmodel.VerifyMoViewModel$sendMoTextCheck$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.passport.flow.verify.viewmodel.VerifyMoViewModel$sendMoTextCheck$1", f = "VerifyMoViewModel.kt", i = {}, l = {ItemViewType.ITEM_VIEW_TYPE_CALENDAR_INFO}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ VerifyMoViewModel this$0;

        public AnonymousClass1(VerifyMoViewModel r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L15:
            j r5 = (j) r4;
            if ((r5 instanceof j.d) == false) goto L19;
            StringBuilder r2 = new StringBuilder("route next step: ");
            j.d r6 = (j.d) r5;
            r2.append(r6.a.getNextStep());
            PassportLog.d(VerifyMoViewModel.TAG, r2.toString());
            this.this$0.emitEvent(new c.d(r6.a));
        L28:
            return Unit.INSTANCE;
        L19:
            if ((r5 instanceof j.c) == false) goto L22;
            int r3 = com.ss.android.lark.passport.flow.verify.viewmodel.a.a;
            NetworkErrorResult r7 = com.ss.android.lark.passport.flow.verify.viewmodel.a.c(((j.c) r5).a);
            PassportLog.b(VerifyMoViewModel.TAG, "sendMoTextCheck failed: " + r7);
            this.this$0.emitEvent(c.a.a);
            this.this$0.emitEvent(new c.C0092c(r7));
            goto L28
        L22:
            if (Intrinsics.areEqual(r5, j.b.a) == false) goto L25;
            this.this$0.emitEvent(c.a.a);
            this.this$0.emitEvent(c.b.a);
            goto L28
        L25:
            if ((r5 instanceof j.a) == false) goto L30;
            this.this$0.emitEvent(c.a.a);
            goto L28
        L30:
            throw new NoWhenBranchMatchedException();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            int r8 = com.ss.android.lark.passport.flow.verify.viewmodel.a.a;
            VerifyCommonViewModel r9 = VerifyMoViewModel.access$getVerifyCommonViewModel$p(this.this$0);
            ButtonBean r10 = this.this$0.getRepo().e.getNextButton();
            if (r10 == null) goto L11;
            FlowStep r11 = r10.getNext();
        L12:
            this.label = 1;
            r4 = com.ss.android.lark.passport.flow.verify.viewmodel.a.a(r9, r11);
            if (r4 != r0) goto L15;
            return r0;
        L11:
            r11 = null;
            goto L12
        }
    }

    static {
        Companion = new b();
    }

    private final void sendMoTextCheck() {
        PassportLog.d(TAG, "sendMoTextCheck start");
        emitEvent(c.e.a);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }

    public final xyb.a getRepo() {
        return (xyb.a) this.verifyCommonViewModel.getRepo().getValue();
    }

    public final void init() {
        getViewStateFlow().setValue(new d.b(getRepo().e));
    }

    @Override // com.ss.android.lark.passport.flow.verify.viewmodel.VerifyBaseViewModel
    public /* bridge */ /* synthetic */ VerifyBaseViewModel.c initStateFLow() {
        return initStateFLow();
    }

    @Override // com.ss.android.lark.passport.flow.verify.viewmodel.VerifyBaseViewModel
    public d initStateFLow() {
        return d.a.a;
    }

    public VerifyMoViewModel(VerifyCommonViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "verifyCommonViewModel");
        this.verifyCommonViewModel = r2;
    }

    public static final /* synthetic */ VerifyCommonViewModel access$getVerifyCommonViewModel$p(VerifyMoViewModel r0) {
        return r0.verifyCommonViewModel;
    }

    public void reduce(a r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        if ((r2 instanceof a.C0091a) == false) goto L7;
        sendMoTextCheck();
        return;
    L7:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.ss.android.lark.passport.flow.verify.viewmodel.VerifyBaseViewModel
    public /* bridge */ /* synthetic */ void reduce(VerifyBaseViewModel.a r1) {
        reduce((a) r1);
    }
}
