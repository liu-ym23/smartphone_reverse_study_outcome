package com.ss.android.lark.passport.flow.verify.viewmodel;

import androidx.lifecycle.ViewModelKt;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.flow.core.model.ButtonType;
import com.ss.android.lark.passport.flow.core.router.FlowStep;
import com.ss.android.lark.passport.flow.mfa.j;
import com.ss.android.lark.passport.flow.verify.entity.ButtonBean;
import com.ss.android.lark.passport.flow.verify.entity.VerifyBean;
import com.ss.android.lark.passport.signinsdk_api.base.NetworkErrorResult;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 02\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u00040123B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u001f\u001a\u00020\u00182\b\b\u0002\u0010 \u001a\u00020\u000fJ\b\u0010!\u001a\u00020\u0018H\u0002J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010&\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010'\u001a\u00020\u0018H\u0002J\u001a\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,H\u0002J\u0010\u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u0003H\u0016J\b\u0010/\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u0012\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u00064"}, d2 = {"Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyCodeViewModel;", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyBaseViewModel;", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyCodeViewModel$ViewState;", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyCodeViewModel$ActionState;", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyCodeViewModel$UIEvent;", "verifyCommonViewModel", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyCommonViewModel;", "<init>", "(Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyCommonViewModel;)V", "repo", "Lcom/ss/android/lark/passport/flow/verify/model/StepInfoRepository;", "getRepo", "()Lcom/ss/android/lark/passport/flow/verify/model/StepInfoRepository;", "_countDownTimePhone", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_countDownTimeSpare", "_countDownTimeEmail", "countDownTime", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Triple;", "getCountDownTime", "()Lkotlinx/coroutines/flow/Flow;", "init", "", "countDownMap", "", "Lkotlinx/coroutines/Job;", "curTime", "getCurTime", "()I", "startCountDown", "second", "applyCode", "verifyCode", "code", "", "verifyOtp", "submitCode", "recoverAccount", "handleSubmitResult", "result", "Lcom/ss/android/lark/passport/flow/mfa/FlowMfaFlowUiResult;", "clearCode", "", "reduce", "action", "initStateFLow", "Companion", "ViewState", "ActionState", "UIEvent", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class VerifyCodeViewModel extends VerifyBaseViewModel<d, a, c> {
    public static final b Companion = null;
    private static final int DEFAULT_COUNTDOWN_SECONDS = 59;
    private static final String TAG = "VerifyCodeViewModel";
    private final z0<Integer> _countDownTimeEmail;
    private final z0<Integer> _countDownTimePhone;
    private final z0<Integer> _countDownTimeSpare;
    private final Map<Integer, Job> countDownMap;
    private final Flow<Triple<Integer, Integer, Integer>> countDownTime;
    private final VerifyCommonViewModel verifyCommonViewModel;

    public static abstract class a extends VerifyBaseViewModel.a {

        /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.verify.viewmodel.VerifyCodeViewModel$a$a, reason: collision with other inner class name */
        public static final class C0087a extends a {
            public static final C0087a a = null;

            static {
                a = new C0087a();
            }

            public C0087a() {
            }
        }

        public static final class b extends a {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }
        }

        public static final class c extends a {
            public final int a;
            public final String b;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof c) == true) goto L8;
                return false;
            L8:
                c r6 = (c) r5;
                if (this.a == r6.a) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.a * 31) + this.b.hashCode();
            }

            public final String toString() {
                return "VerifyCodeAction(actionType=" + this.a + ", code=" + this.b + ')';
            }

            public c(int r2, String r3) {
                Intrinsics.checkNotNullParameter(r3, "code");
                this.a = r2;
                this.b = r3;
            }
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.verify.viewmodel.VerifyCodeViewModel$applyCode$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.passport.flow.verify.viewmodel.VerifyCodeViewModel$applyCode$1", f = "VerifyCodeViewModel.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ VerifyCodeViewModel this$0;

        public AnonymousClass1(VerifyCodeViewModel r1, Continuation<? super AnonymousClass1> r2) {
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
            boolean r2 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            j r6 = (j) r5;
            if ((r6 instanceof j.a) == false) goto L28;
            PassportLog.d(VerifyCodeViewModel.TAG, "apply code success");
            j.a r7 = (j.a) r6;
            com.ss.android.lark.passport.flow.mfa.b r3 = r7.a;
            String r4 = r3.b;
            if (r3.c == false) goto L22;
            if (r4 != null) goto L17;
        L20:
            if (r2 == true) goto L22;
            this.this$0.emitEvent(new c.h(r4));
            goto L22
        L17:
            if (StringsKt.isBlank(r4) == true) goto L20;
            r2 = false;
        L22:
            VerifyCodeViewModel r8 = this.this$0;
            Integer r9 = r7.a.a;
            if (r9 == null) goto L25;
            int r10 = r9.intValue();
        L26:
            r8.startCountDown(r10);
            this.this$0.emitEvent(c.b.a);
            this.this$0.emitEvent(c.d.a);
        L37:
            return Unit.INSTANCE;
        L25:
            r10 = VerifyCodeViewModel.DEFAULT_COUNTDOWN_SECONDS;
            goto L26
        L28:
            if ((r6 instanceof j.c) == false) goto L31;
            int r11 = com.ss.android.lark.passport.flow.verify.viewmodel.a.a;
            NetworkErrorResult r12 = com.ss.android.lark.passport.flow.verify.viewmodel.a.c(((j.c) r6).a);
            PassportLog.b(VerifyCodeViewModel.TAG, "apply code failed, " + r12.getDebugErrorMessage());
            this.this$0.emitEvent(c.b.a);
            this.this$0.emitEvent(c.C0088c.a);
            this.this$0.emitEvent(new c.f(r12));
            goto L37
        L31:
            if ((r6 instanceof j.d) == false) goto L34;
            this.this$0.emitEvent(new c.g(((j.d) r6).a));
            goto L37
        L34:
            if (Intrinsics.areEqual(r6, j.b.a) == false) goto L39;
            this.this$0.emitEvent(c.b.a);
            this.this$0.emitEvent(c.e.a);
            goto L37
        L39:
            throw new NoWhenBranchMatchedException();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            int r13 = com.ss.android.lark.passport.flow.verify.viewmodel.a.a;
            VerifyCommonViewModel r14 = VerifyCodeViewModel.access$getVerifyCommonViewModel$p(this.this$0);
            this.label = 1;
            r5 = com.ss.android.lark.passport.flow.verify.viewmodel.a.d(r14, new VerifyFlowMfaBridge$applyCode$2(null), this);
            if (r5 != r0) goto L11;
            return r0;
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

        /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.verify.viewmodel.VerifyCodeViewModel$c$c, reason: collision with other inner class name */
        public static final class C0088c extends c {
            public static final C0088c a = null;

            static {
                a = new C0088c();
            }

            public C0088c() {
            }
        }

        public static final class d extends c {
            public static final d a = null;

            static {
                a = new d();
            }

            public d() {
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

        public static final class f extends c {
            public final NetworkErrorResult a;

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
                return "NeedHandleError(err=" + this.a + ')';
            }

            public f(NetworkErrorResult r2) {
                Intrinsics.checkNotNullParameter(r2, "err");
                this.a = r2;
            }
        }

        public static final class g extends c {
            public final FlowStep a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof g) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((g) r4).a) == true) goto L11;
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

            public g(FlowStep r2) {
                Intrinsics.checkNotNullParameter(r2, "stepData");
                this.a = r2;
            }
        }

        public static final class h extends c {
            public final String a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof h) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((h) r4).a) == true) goto L11;
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

            public h(String r2) {
                Intrinsics.checkNotNullParameter(r2, "errMsg");
                this.a = r2;
            }
        }

        public static final class i extends c {
            public static final i a = null;

            static {
                a = new i();
            }

            public i() {
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

    /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.verify.viewmodel.VerifyCodeViewModel$recoverAccount$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.passport.flow.verify.viewmodel.VerifyCodeViewModel$recoverAccount$1", f = "VerifyCodeViewModel.kt", i = {}, l = {140}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03121 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ VerifyCodeViewModel this$0;

        public C03121(VerifyCodeViewModel r1, Continuation<? super C03121> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03121(this.this$0, r3);
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
            VerifyCodeViewModel r2 = (VerifyCodeViewModel) this.L$0;
            ResultKt.throwOnFailure(r5);
        L16:
            VerifyCodeViewModel.access$handleSubmitResult(r2, (j) r5, false);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            VerifyCodeViewModel r6 = this.this$0;
            int r3 = com.ss.android.lark.passport.flow.verify.viewmodel.a.a;
            VerifyCommonViewModel r4 = VerifyCodeViewModel.access$getVerifyCommonViewModel$p(r6);
            ButtonBean r7 = VerifyCodeViewModel.access$getRepo(this.this$0).e.getRetrieveButton();
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

    /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.verify.viewmodel.VerifyCodeViewModel$startCountDown$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.passport.flow.verify.viewmodel.VerifyCodeViewModel$startCountDown$1", f = "VerifyCodeViewModel.kt", i = {0}, l = {64}, m = "invokeSuspend", n = {"i"}, s = {"I$0"})
    public static final class C03131 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $second;
        int I$0;
        int label;
        final /* synthetic */ VerifyCodeViewModel this$0;

        public C03131(int r1, VerifyCodeViewModel r2, Continuation<? super C03131> r3) {
            this.$second = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03131(this.$second, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x003b -> B:13:0x003e). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            int r2 = this.I$0;
            ResultKt.throwOnFailure(r7);
            C03131 r8 = this;
        L13:
            r2 = r2 - 1;
        L9:
            if ((-1) >= r2) goto L14;
            VerifyCodeViewModel.access$get_countDownTimePhone$p(r8.this$0).setValue(Boxing.boxInt(r2));
            r8.I$0 = r2;
            r8.label = 1;
            if (DelayKt.delay(1000, r8) != r0) goto L13;
            return r0;
        L14:
            r8.this$0.emitEvent(c.C0088c.a);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            r2 = this.$second;
            r8 = this;
            goto L9
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.verify.viewmodel.VerifyCodeViewModel$startCountDown$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.passport.flow.verify.viewmodel.VerifyCodeViewModel$startCountDown$2", f = "VerifyCodeViewModel.kt", i = {0}, l = {71}, m = "invokeSuspend", n = {"i"}, s = {"I$0"})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $second;
        int I$0;
        int label;
        final /* synthetic */ VerifyCodeViewModel this$0;

        public AnonymousClass2(int r1, VerifyCodeViewModel r2, Continuation<? super AnonymousClass2> r3) {
            this.$second = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.$second, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x003b -> B:13:0x003e). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            int r2 = this.I$0;
            ResultKt.throwOnFailure(r7);
            AnonymousClass2 r8 = this;
        L13:
            r2 = r2 - 1;
        L9:
            if ((-1) >= r2) goto L14;
            VerifyCodeViewModel.access$get_countDownTimeSpare$p(r8.this$0).setValue(Boxing.boxInt(r2));
            r8.I$0 = r2;
            r8.label = 1;
            if (DelayKt.delay(1000, r8) != r0) goto L13;
            return r0;
        L14:
            r8.this$0.emitEvent(c.C0088c.a);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            r2 = this.$second;
            r8 = this;
            goto L9
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.verify.viewmodel.VerifyCodeViewModel$startCountDown$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.passport.flow.verify.viewmodel.VerifyCodeViewModel$startCountDown$3", f = "VerifyCodeViewModel.kt", i = {0}, l = {78}, m = "invokeSuspend", n = {"i"}, s = {"I$0"})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $second;
        int I$0;
        int label;
        final /* synthetic */ VerifyCodeViewModel this$0;

        public AnonymousClass3(int r1, VerifyCodeViewModel r2, Continuation<? super AnonymousClass3> r3) {
            this.$second = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass3(this.$second, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x003b -> B:13:0x003e). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            int r2 = this.I$0;
            ResultKt.throwOnFailure(r7);
            AnonymousClass3 r8 = this;
        L13:
            r2 = r2 - 1;
        L9:
            if ((-1) >= r2) goto L14;
            VerifyCodeViewModel.access$get_countDownTimeEmail$p(r8.this$0).setValue(Boxing.boxInt(r2));
            r8.I$0 = r2;
            r8.label = 1;
            if (DelayKt.delay(1000, r8) != r0) goto L13;
            return r0;
        L14:
            r8.this$0.emitEvent(c.C0088c.a);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            r2 = this.$second;
            r8 = this;
            goto L9
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.verify.viewmodel.VerifyCodeViewModel$submitCode$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.passport.flow.verify.viewmodel.VerifyCodeViewModel$submitCode$1", f = "VerifyCodeViewModel.kt", i = {}, l = {131}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $code;
        Object L$0;
        int label;
        final /* synthetic */ VerifyCodeViewModel this$0;

        public C03141(VerifyCodeViewModel r1, String r2, Continuation<? super C03141> r3) {
            this.this$0 = r1;
            this.$code = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03141(this.this$0, this.$code, r4);
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
            VerifyCodeViewModel r2 = (VerifyCodeViewModel) this.L$0;
            ResultKt.throwOnFailure(r6);
        L12:
            VerifyCodeViewModel.handleSubmitResult$default(r2, (j) r6, false, 2, null);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            VerifyCodeViewModel r7 = this.this$0;
            int r3 = com.ss.android.lark.passport.flow.verify.viewmodel.a.a;
            VerifyCommonViewModel r4 = VerifyCodeViewModel.access$getVerifyCommonViewModel$p(r7);
            String r5 = this.$code;
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

    private final void applyCode() {
        Job r0 = this.countDownMap.get(Integer.valueOf(getRepo().a));
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L9;
        return;
    L9:
        PassportLog.d(TAG, "begin applyCode");
        emitEvent(c.i.a);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
        return;
    L5:
        if (r0.isActive() != true) goto L7;
        r1 = true;
        goto L7
    }

    private final xyb.a getRepo() {
        return (xyb.a) this.verifyCommonViewModel.getRepo().getValue();
    }

    private final void recoverAccount() {
        PassportLog.d(TAG, "begin recover account");
        emitEvent(c.i.a);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03121(this, null), 3, null);
    }

    public final int getCurTime() {
        int r0 = getRepo().a;
        if (r0 != ButtonType.VERIFY_PHONE.getValue()) goto L6;
        return ((Number) this._countDownTimePhone.getValue()).intValue();
    L6:
        if (r0 != ButtonType.VERIFY_SPARE.getValue()) goto L9;
        return ((Number) this._countDownTimeSpare.getValue()).intValue();
    L9:
        if (r0 == ButtonType.VERIFY_EMAIL.getValue()) goto L15;
        return 60;
    L15:
        return ((Number) this._countDownTimeEmail.getValue()).intValue();
    }

    public final void init() {
        getViewStateFlow().setValue(new d.b(getRepo().e));
        PassportLog.d(TAG, "cur Auth: " + getViewStateFlow().getValue());
        emitEvent(c.a.a);
    }

    @Override // com.ss.android.lark.passport.flow.verify.viewmodel.VerifyBaseViewModel
    public /* bridge */ /* synthetic */ VerifyBaseViewModel.c initStateFLow() {
        return initStateFLow();
    }

    public final Flow<Triple<Integer, Integer, Integer>> getCountDownTime() {
        return this.countDownTime;
    }

    @Override // com.ss.android.lark.passport.flow.verify.viewmodel.VerifyBaseViewModel
    public d initStateFLow() {
        return d.a.a;
    }

    public VerifyCodeViewModel(VerifyCommonViewModel r5) {
        Intrinsics.checkNotNullParameter(r5, "verifyCommonViewModel");
        this.verifyCommonViewModel = r5;
        StateFlowImpl r0 = j1.a(60);
        this._countDownTimePhone = r0;
        StateFlowImpl r1 = j1.a(60);
        this._countDownTimeSpare = r1;
        StateFlowImpl r6 = j1.a(60);
        this._countDownTimeEmail = r6;
        this.countDownTime = e.j(r0, r1, r6, new VerifyCodeViewModel$countDownTime$1(null));
        this.countDownMap = new LinkedHashMap();
    }

    public static final /* synthetic */ xyb.a access$getRepo(VerifyCodeViewModel r0) {
        return r0.getRepo();
    }

    public static final /* synthetic */ VerifyCommonViewModel access$getVerifyCommonViewModel$p(VerifyCodeViewModel r0) {
        return r0.verifyCommonViewModel;
    }

    public static final /* synthetic */ z0 access$get_countDownTimeEmail$p(VerifyCodeViewModel r0) {
        return r0._countDownTimeEmail;
    }

    public static final /* synthetic */ z0 access$get_countDownTimePhone$p(VerifyCodeViewModel r0) {
        return r0._countDownTimePhone;
    }

    public static final /* synthetic */ z0 access$get_countDownTimeSpare$p(VerifyCodeViewModel r0) {
        return r0._countDownTimeSpare;
    }

    private final void submitCode(String r8) {
        emitEvent(c.i.a);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03141(this, r8, null), 3, null);
    }

    private final void verifyCode(String r1) {
        submitCode(r1);
    }

    private final void verifyOtp(String r1) {
        submitCode(r1);
    }

    public void reduce(a r3) {
        Intrinsics.checkNotNullParameter(r3, "action");
        if ((r3 instanceof a.C0087a) == false) goto L6;
        applyCode();
        return;
    L6:
        if ((r3 instanceof a.c) == false) goto L12;
        a.c r4 = (a.c) r3;
        if (r4.a != ButtonType.VERIFY_OTP.getValue()) goto L10;
        verifyOtp(r4.b);
        return;
    L10:
        verifyCode(r4.b);
        return;
    L12:
        if ((r3 instanceof a.b) == false) goto L16;
        recoverAccount();
        return;
    L16:
        throw new NoWhenBranchMatchedException();
    }

    public final void startCountDown(int r12) {
        int r0 = getRepo().a;
        Job r1 = this.countDownMap.get(Integer.valueOf(r0));
        boolean r2 = false;
        if (r1 != null) goto L5;
    L7:
        if (r2 == false) goto L9;
        return;
    L9:
        Map<Integer, Job> r3 = this.countDownMap;
        Integer r4 = Integer.valueOf(r0);
        Job r5 = null;
        if (r0 != ButtonType.VERIFY_PHONE.getValue()) goto L13;
        r5 = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03131(r12, this, null), 3, null);
    L18:
        r3.put(r4, r5);
        return;
    L13:
        if (r0 != ButtonType.VERIFY_SPARE.getValue()) goto L16;
        r5 = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(r12, this, null), 3, null);
        goto L18
    L16:
        if (r0 != ButtonType.VERIFY_EMAIL.getValue()) goto L18;
        r5 = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass3(r12, this, null), 3, null);
        goto L18
    L5:
        if (r1.isActive() != true) goto L7;
        r2 = true;
        goto L7
    }

    @Override // com.ss.android.lark.passport.flow.verify.viewmodel.VerifyBaseViewModel
    public /* bridge */ /* synthetic */ void reduce(VerifyBaseViewModel.a r1) {
        reduce((a) r1);
    }

    private final void handleSubmitResult(j r4, boolean r5) {
        if ((r4 instanceof j.d) == false) goto L9;
        StringBuilder r0 = new StringBuilder("route next step: ");
        j.d r6 = (j.d) r4;
        r0.append(r6.a.getNextStep());
        PassportLog.d(TAG, r0.toString());
        if (r5 == false) goto L7;
        emitEvent(c.a.a);
    L7:
        emitEvent(new c.g(r6.a));
        return;
    L9:
        if ((r4 instanceof j.c) == false) goto L18;
        int r1 = com.ss.android.lark.passport.flow.verify.viewmodel.a.a;
        NetworkErrorResult r7 = com.ss.android.lark.passport.flow.verify.viewmodel.a.c(((j.c) r4).a);
        PassportLog.b(TAG, "submit code failed, " + r7.getDebugErrorMessage());
        emitEvent(c.b.a);
        if (r5 == false) goto L14;
        emitEvent(c.a.a);
    L14:
        if (4202 != r7.getErrorCode()) goto L16;
        emitEvent(new c.h(r7.getErrorMessage()));
        return;
    L16:
        emitEvent(new c.f(r7));
        return;
    L18:
        if (Intrinsics.areEqual(r4, j.b.a) == false) goto L24;
        emitEvent(c.b.a);
        if (r5 == false) goto L22;
        emitEvent(c.a.a);
    L22:
        emitEvent(c.e.a);
        return;
    L24:
        if ((r4 instanceof j.a) == false) goto L28;
        emitEvent(c.b.a);
        return;
    L28:
        throw new NoWhenBranchMatchedException();
    }

    public static final /* synthetic */ void access$handleSubmitResult(VerifyCodeViewModel r0, j r1, boolean r2) {
        r0.handleSubmitResult(r1, r2);
    }

    public static /* synthetic */ void startCountDown$default(VerifyCodeViewModel r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = DEFAULT_COUNTDOWN_SECONDS;
    L5:
        r0.startCountDown(r1);
    }

    public static /* synthetic */ void handleSubmitResult$default(VerifyCodeViewModel r0, j r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        r0.handleSubmitResult(r1, r2);
    }
}
