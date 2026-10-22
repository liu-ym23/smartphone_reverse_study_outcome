package com.ss.android.lark.passport.flow.verify.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.ss.android.lark.passport.flow.verify.viewmodel.VerifyBaseViewModel.a;
import com.ss.android.lark.passport.flow.verify.viewmodel.VerifyBaseViewModel.b;
import com.ss.android.lark.passport.flow.verify.viewmodel.VerifyBaseViewModel.c;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
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
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u0004*\b\b\u0002\u0010\u0005*\u00020\u00062\u00020\u0007:\u0003#$%B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0002H\u0004¢\u0006\u0002\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00028\u0001H&¢\u0006\u0002\u0010 J\r\u0010!\u001a\u00028\u0000H&¢\u0006\u0002\u0010\"R!\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006&"}, d2 = {"Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyBaseViewModel;", "VIEW", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyBaseViewModel$ViewState;", "ACTION", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyBaseViewModel$ActionState;", "UIEVENT", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyBaseViewModel$UIEvent;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "viewStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "getViewStateFlow", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "viewStateFlow$delegate", "Lkotlin/Lazy;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "_eventState", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "eventState", "Lkotlinx/coroutines/flow/SharedFlow;", "getEventState", "()Lkotlinx/coroutines/flow/SharedFlow;", "emitEvent", "", "event", "(Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyBaseViewModel$UIEvent;)V", "reduce", "action", "(Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyBaseViewModel$ActionState;)V", "initStateFLow", "()Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyBaseViewModel$ViewState;", "ViewState", "ActionState", "UIEvent", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public abstract class VerifyBaseViewModel<VIEW extends c, ACTION extends a, UIEVENT extends b> extends ViewModel {
    private final MutableSharedFlow<UIEVENT> _eventState;
    private final d1<UIEVENT> eventState;
    private final i1<VIEW> viewState;
    private final Lazy viewStateFlow$delegate;

    public static abstract class a {
        public a() {
        }
    }

    public static abstract class b {
        public b() {
        }
    }

    public static abstract class c {
        public c() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.verify.viewmodel.VerifyBaseViewModel$emitEvent$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.passport.flow.verify.viewmodel.VerifyBaseViewModel$emitEvent$1", f = "VerifyBaseViewModel.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ UIEVENT $event;
        int label;
        final /* synthetic */ VerifyBaseViewModel<VIEW, ACTION, UIEVENT> this$0;

        public AnonymousClass1(VerifyBaseViewModel<VIEW, ACTION, UIEVENT> r1, UIEVENT r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$event = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$event, r4);
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
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            MutableSharedFlow r5 = VerifyBaseViewModel.access$get_eventState$p(this.this$0);
            UIEVENT r2 = this.$event;
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public abstract VIEW initStateFLow();

    public abstract void reduce(ACTION r1);

    public final z0<VIEW> getViewStateFlow() {
        return (z0) this.viewStateFlow$delegate.getValue();
    }

    public VerifyBaseViewModel() {
        this.viewStateFlow$delegate = LazyKt.lazy(new VerifyBaseViewModel$viewStateFlow$2(this));
        this.viewState = e.b(getViewStateFlow());
        MutableSharedFlow<UIEVENT> r0 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._eventState = r0;
        this.eventState = e.a(r0);
    }

    public final d1<UIEVENT> getEventState() {
        return this.eventState;
    }

    public final i1<VIEW> getViewState() {
        return this.viewState;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_eventState$p(VerifyBaseViewModel r0) {
        return r0._eventState;
    }

    public final void emitEvent(UIEVENT r8) {
        Intrinsics.checkNotNullParameter(r8, "event");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r8, null), 3, null);
    }
}
