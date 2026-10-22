package com.ss.android.lark.passport.flow.auth_type.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.flow.auth_type.AuthTypeStepInfo;
import com.ss.android.lark.passport.flow.core.model.ButtonInfo;
import com.ss.android.lark.passport.flow.core.model.ButtonType;
import com.ss.android.lark.passport.flow.core.router.FlowStep;
import com.ss.android.lark.passport.flow.mfa.FlowVerifyFactor;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.ArrayList;
import java.util.Iterator;
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
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0004\"#$%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018J\u001a\u0010\u0019\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0002J\f\u0010!\u001a\u00020\u0015*\u00020\u0015H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006&"}, d2 = {"Lcom/ss/android/lark/passport/flow/auth_type/viewmodel/AuthTypeViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "viewStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/ss/android/lark/passport/flow/auth_type/viewmodel/AuthTypeViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "eventStateFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/ss/android/lark/passport/flow/auth_type/viewmodel/AuthTypeViewModel$UIEvent;", "eventState", "Lkotlinx/coroutines/flow/SharedFlow;", "getEventState", "()Lkotlinx/coroutines/flow/SharedFlow;", "init", "", "stepInfo", "Lcom/ss/android/lark/passport/flow/auth_type/AuthTypeStepInfo;", "reduce", "action", "Lcom/ss/android/lark/passport/flow/auth_type/viewmodel/AuthTypeViewModel$ActionState;", "route", "nextStep", "Lcom/ss/android/lark/passport/flow/core/router/FlowStep;", "showLoading", "", "shouldShowLoading", "buttonType", "Lcom/ss/android/lark/passport/flow/core/model/ButtonType;", "filterSupportedAuthTypes", "ViewState", "ActionState", "UIEvent", "Companion", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class AuthTypeViewModel extends ViewModel {
    private static final b Companion = null;
    private static final String TAG = "AuthTypeViewModel";
    private final d1<c> eventState;
    private final MutableSharedFlow<c> eventStateFlow;
    private final i1<d> viewState;
    private final z0<d> viewStateFlow;

    public static abstract class a {

        /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.auth_type.viewmodel.AuthTypeViewModel$a$a, reason: collision with other inner class name */
        public static final class C0084a extends a {
            public final FlowStep a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof C0084a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((C0084a) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                FlowStep r0 = this.a;
                if (r0 != null) goto L6;
                return 0;
            L6:
                return r0.hashCode();
            }

            public final String toString() {
                return "ClickBottomButton(nextStep=" + this.a + ')';
            }

            public C0084a(FlowStep r1) {
                this.a = r1;
            }
        }

        public static final class b extends a {
            public final FlowStep a;
            public final ButtonType b;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof b) == true) goto L8;
                return false;
            L8:
                b r6 = (b) r5;
                if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
                return false;
            L12:
                if (this.b == r6.b) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                FlowStep r0 = this.a;
                if (r0 != null) goto L5;
                int r1 = 0;
            L7:
                return (r1 * 31) + this.b.hashCode();
            L5:
                r1 = r0.hashCode();
                goto L7
            }

            public final String toString() {
                return "ClickVerifyItem(nextStep=" + this.a + ", buttonType=" + this.b + ')';
            }

            public b(FlowStep r2, ButtonType r3) {
                Intrinsics.checkNotNullParameter(r3, "buttonType");
                this.a = r2;
                this.b = r3;
            }
        }

        public a() {
        }
    }

    public static final class b {
        public b() {
        }
    }

    public static abstract class c {

        public static final class a extends c {
            public final FlowStep a;
            public final boolean b;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof a) == true) goto L8;
                return false;
            L8:
                a r6 = (a) r5;
                if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
                return false;
            L12:
                if (this.b == r6.b) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                int r0 = this.a.hashCode() * 31;
                if (this.b == false) goto L5;
                int r1 = 1231;
            L7:
                return r0 + r1;
            L5:
                r1 = 1237;
                goto L7
            }

            public final String toString() {
                return "RouteToNext(step=" + this.a + ", showLoading=" + this.b + ')';
            }

            public a(FlowStep r2, boolean r3) {
                Intrinsics.checkNotNullParameter(r2, "step");
                this.a = r2;
                this.b = r3;
            }
        }

        public c() {
        }
    }

    public static abstract class d {

        public static final class a extends d {
            public final AuthTypeStepInfo a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "AuthTypes(stepInfo=" + this.a + ')';
            }

            public a(AuthTypeStepInfo r2) {
                Intrinsics.checkNotNullParameter(r2, "stepInfo");
                this.a = r2;
            }
        }

        public static final class b extends d {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }
        }

        public d() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.auth_type.viewmodel.AuthTypeViewModel$route$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.passport.flow.auth_type.viewmodel.AuthTypeViewModel$route$1", f = "AuthTypeViewModel.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FlowStep $nextStep;
        final /* synthetic */ boolean $showLoading;
        int label;
        final /* synthetic */ AuthTypeViewModel this$0;

        public AnonymousClass1(AuthTypeViewModel r1, FlowStep r2, boolean r3, Continuation<? super AnonymousClass1> r4) {
            this.this$0 = r1;
            this.$nextStep = r2;
            this.$showLoading = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.this$0, this.$nextStep, this.$showLoading, r5);
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
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            MutableSharedFlow r7 = AuthTypeViewModel.access$getEventStateFlow$p(this.this$0);
            c.a r2 = new c.a(this.$nextStep, this.$showLoading);
            this.label = 1;
            if (r7.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new b();
    }

    public AuthTypeViewModel() {
        StateFlowImpl r0 = j1.a(d.b.a);
        this.viewStateFlow = r0;
        this.viewState = e.b(r0);
        MutableSharedFlow<c> r1 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.eventStateFlow = r1;
        this.eventState = e.a(r1);
    }

    public final d1<c> getEventState() {
        return this.eventState;
    }

    public final i1<d> getViewState() {
        return this.viewState;
    }

    public static final /* synthetic */ MutableSharedFlow access$getEventStateFlow$p(AuthTypeViewModel r0) {
        return r0.eventStateFlow;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final AuthTypeStepInfo filterSupportedAuthTypes(AuthTypeStepInfo r7) {
        AuthTypeStepInfo r0 = new AuthTypeStepInfo();
        r0.title = r7.title;
        r0.subTitle = r7.subTitle;
        r0.targetTenantIcon = r7.targetTenantIcon;
        ArrayList<ButtonInfo> r1 = r7.authTypeList;
        if (r1 == null) goto L10;
        ArrayList<ButtonInfo> r2 = new ArrayList();
        Iterator<T> r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L11;
        Object r4 = r3.next();
        FlowVerifyFactor.a r5 = FlowVerifyFactor.Companion;
        int r6 = ((ButtonInfo) r4).actionType;
        r5.getClass();
        if (FlowVerifyFactor.a.b(r6) == false) goto L6;
        r2.add(r4);
    L11:
        r0.authTypeList = r2;
        r0.bottomButton = r7.bottomButton;
        return r0;
    L10:
        r2 = 0;
        goto L11
    }

    private final boolean shouldShowLoading(ButtonType r2) {
        if (r2 != ButtonType.VERIFY_PHONE) goto L5;
    L7:
        return false;
    L5:
        if (r2 == ButtonType.VERIFY_EMAIL) goto L7;
        return true;
    }

    public final void init(AuthTypeStepInfo r3) {
        if (r3 != null) goto L5;
    L19:
        PassportLog.b(TAG, "init auth type but stepInfo is invalid");
        this.viewStateFlow.setValue(d.b.a);
        return;
    L5:
        if (r3.authTypeList == null) goto L19;
        AuthTypeStepInfo r4 = filterSupportedAuthTypes(r3);
        ArrayList<ButtonInfo> r1 = r4.authTypeList;
        if (r1 != null) goto L10;
    L13:
        boolean r2 = true;
    L14:
        if (r2 == false) goto L17;
        PassportLog.b(TAG, "init auth type but no supported factor");
        this.viewStateFlow.setValue(d.b.a);
        return;
    L17:
        this.viewStateFlow.setValue(new d.a(r4));
        return;
    L10:
        if (r1.isEmpty() == true) goto L13;
        r2 = false;
        goto L14
    }

    public final void reduce(a r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        if ((r2 instanceof a.b) == false) goto L6;
        a.b r3 = (a.b) r2;
        route(r3.a, shouldShowLoading(r3.b));
        return;
    L6:
        if ((r2 instanceof a.C0084a) == false) goto L10;
        route(((a.C0084a) r2).a, false);
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    private final void route(FlowStep r7, boolean r8) {
        if (r7 != null) goto L5;
        PassportLog.b(TAG, "route auth type but nextStep is null");
        return;
    L5:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r7, r8, null), 3, null);
    }
}
