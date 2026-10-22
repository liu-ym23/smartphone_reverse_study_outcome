package com.ss.android.lark.passport.flow.auth_type;

import android.os.Looper;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.ss.android.lark.flow.passport.ui.widget.common.FlowBaseActivity;
import com.ss.android.lark.flow.passport.ui.widget.common.d;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.flow.auth_type.viewmodel.AuthTypeViewModel;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.concurrent.atomic.AtomicReference;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "event", "Lcom/ss/android/lark/passport/flow/auth_type/viewmodel/AuthTypeViewModel$UIEvent;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.passport.flow.auth_type.AuthTypeActivity$observeViewModel$2", f = "AuthTypeActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AuthTypeActivity$observeViewModel$2 extends SuspendLambda implements Function2<AuthTypeViewModel.c, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AuthTypeActivity this$0;

    public AuthTypeActivity$observeViewModel$2(AuthTypeActivity r1, Continuation<? super AuthTypeActivity$observeViewModel$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        AuthTypeActivity$observeViewModel$2 r0 = new AuthTypeActivity$observeViewModel$2(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(AuthTypeViewModel.c r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((AuthTypeViewModel.c) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r5);
        AuthTypeViewModel.c r6 = (AuthTypeViewModel.c) this.L$0;
        if ((r6 instanceof AuthTypeViewModel.c.a) == false) goto L18;
        FlowBaseActivity r0 = this.this$0;
        AuthTypeViewModel.c.a r7 = (AuthTypeViewModel.c.a) r6;
        int r1 = AuthTypeActivity.f;
        r0.getClass();
        if (r7.b == true) goto L9;
    L12:
        AtomicReference<syb.b> r2 = com.ss.android.lark.passport.flow.core.router.a.c;
        PassportLog.d("AuthTypeActivity", "route auth type step: " + r7.a.getNextStep() + ", result: " + com.ss.android.lark.passport.flow.core.router.a.C0085a.a(r0, r7.a.getNextStep(), r7.a.getStepInfo()));
        if (r7.b == false) goto L16;
        r0.y1();
    L16:
        return Unit.INSTANCE;
    L9:
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L11;
        r0.showLoading();
        goto L12
    L11:
        UICallbackExecutor.post(new d(r0));
        goto L12
    L18:
        throw new NoWhenBranchMatchedException();
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
