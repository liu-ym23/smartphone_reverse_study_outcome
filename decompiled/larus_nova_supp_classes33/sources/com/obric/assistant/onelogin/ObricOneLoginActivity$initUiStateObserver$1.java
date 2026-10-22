package com.obric.assistant.onelogin;

import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.obric.assistant.onelogin.impl.databinding.ActivityObricOneLoginBinding;
import com.obric.capabilitykit.common.ErrorCode;
import com.obric.oui.status.OPageStatus;
import kotlin.KotlinNothingValueException;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.onelogin.ObricOneLoginActivity$initUiStateObserver$1", f = "ObricOneLoginActivity.kt", i = {}, l = {ErrorCode.PARAMETER_ERROR}, m = "invokeSuspend", n = {}, s = {})
final class ObricOneLoginActivity$initUiStateObserver$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ObricOneLoginActivity this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ ObricOneLoginActivity a;

        /* JADX INFO: renamed from: com.obric.assistant.onelogin.ObricOneLoginActivity$initUiStateObserver$1$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0012a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[ObricOneLoginActivity.LoginViewState.values().length];
                r0[ObricOneLoginActivity.LoginViewState.LOADING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[ObricOneLoginActivity.LoginViewState.RETRY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[ObricOneLoginActivity.LoginViewState.RELOGIN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        public a(ObricOneLoginActivity r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r7v12, types: [android.app.Activity, com.obric.assistant.onelogin.ObricOneLoginActivity] */
        /* JADX WARN: Type inference failed for: r7v9, types: [android.app.Activity, com.obric.assistant.onelogin.ObricOneLoginActivity] */
        public final Object emit(Object r6, Continuation r7) {
            int r8 = C0012a.a[((ObricOneLoginActivity.LoginViewState) r6).ordinal()];
            ActivityObricOneLoginBinding r9 = null;
            if (r8 != 1) goto L5;
            ActivityObricOneLoginBinding r10 = this.a.g;
            if (r10 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        L24:
            OPageStatus r11 = r9.c;
            FlowCommonAppCompatActivity r12 = this.a;
            r11.setType(1);
            r11.setLoadingResult(r12.getString(2131912306));
            r11.b(true);
        L26:
            return Unit.INSTANCE;
        L23:
            r9 = r10;
            goto L24
        L5:
            if (r8 != 2) goto L7;
            ActivityObricOneLoginBinding r13 = this.a.g;
            if (r13 != null) goto L18;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        L19:
            OPageStatus r14 = r9.c;
            final ?? r15 = this.a;
            r14.setType(0);
            r14.setTitle("");
            r14.setMessage(r15.getString(2131912307));
            r14.getButton().setText(r15.getString(2131912308));
            r14.getButton().setOnClickListener(new h(r15));
            r14.a(true);
            goto L26
        L18:
            r9 = r13;
            goto L19
        L7:
            if (r8 != 3) goto L14;
            ActivityObricOneLoginBinding r16 = this.a.g;
            if (r16 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        L12:
            OPageStatus r17 = r9.c;
            final ?? r18 = this.a;
            r17.setType(0);
            r17.setTitle("");
            r17.setMessage(r18.getString(2131912305));
            r17.getButton().setText(r18.getString(2131912304));
            r17.getButton().setOnClickListener(new i(r18));
            r17.a(true);
            goto L26
        L11:
            r9 = r16;
            goto L12
        L14:
            throw new NoWhenBranchMatchedException();
        }
    }

    public ObricOneLoginActivity$initUiStateObserver$1(ObricOneLoginActivity r1, Continuation<? super ObricOneLoginActivity$initUiStateObserver$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricOneLoginActivity$initUiStateObserver$1(this.this$0, r3);
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
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        ObricOneLoginActivity r6 = this.this$0;
        StateFlowImpl r2 = r6.j;
        a r3 = new a(r6);
        this.label = 1;
        if (r2.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
