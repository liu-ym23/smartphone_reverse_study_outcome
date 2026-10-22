package com.larus.community.impl.detail.loading;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/community/impl/detail/loading/CreationLoadingState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.detail.loading.CreationDetailLoadingComponent$observer$1", f = "CreationDetailLoadingComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CreationDetailLoadingComponent$observer$1 extends SuspendLambda implements Function2<CreationLoadingState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CreationDetailLoadingComponent this$0;

    public CreationDetailLoadingComponent$observer$1(CreationDetailLoadingComponent r1, Continuation<? super CreationDetailLoadingComponent$observer$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        CreationDetailLoadingComponent$observer$1 r0 = new CreationDetailLoadingComponent$observer$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(CreationLoadingState r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CreationLoadingState) r1, (Continuation) r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L54;
        ResultKt.throwOnFailure(r7);
        CreationLoadingState r8 = (CreationLoadingState) this.L$0;
        int r0 = r8.getState();
        CreationDetailLoadingView r2 = null;
        e29.g r3 = null;
        if (r0 == 1) goto L46;
        boolean r4 = false;
        if (r0 != 2) goto L9;
        View r1 = this.this$0.F2();
        if ((r1 instanceof CreationDetailLoadingView) == false) goto L25;
        CreationDetailLoadingView r5 = (CreationDetailLoadingView) r1;
    L26:
        if (r5 == null) goto L28;
        e1.o(r5.a.a);
    L28:
        UserCreation r9 = r8.getUserCreation();
        if (r9 == null) goto L52;
        CreationDetailLoadingComponent r6 = this.this$0;
        j29.c r10 = (j29.c) r6.p.getValue();
        if (r10 == null) goto L35;
        UserCreation r11 = r10.a;
        if (r11 == null) goto L35;
        UserCreationTrackParams r12 = r11.n;
    L36:
        r9.n = r12;
        Intrinsics.checkNotNullParameter(r6, "<this>");
        e29.g r13 = com.larus.ui.arch.component.internal.attach.a.b(r6, r6).getParentFragment();
        if ((r13 instanceof e29.g) == false) goto L39;
        r3 = r13;
    L39:
        if (r3 != null) goto L41;
    L43:
        r6.n.setValue(r9);
        if (r4 == true) goto L52;
        r6.h3(r9, true);
        goto L52
    L41:
        if (r3.g40(r9) != true) goto L43;
        r4 = true;
    L35:
        r12 = null;
    L52:
        return Unit.INSTANCE;
    L25:
        r5 = null;
        goto L26
    L9:
        if (r0 != 3) goto L11;
        View r14 = this.this$0.F2();
        if ((r14 instanceof CreationDetailLoadingView) == false) goto L19;
        CreationDetailLoadingView r15 = (CreationDetailLoadingView) r14;
    L20:
        if (r15 == null) goto L52;
        CreationDetailLoadingComponent r16 = this.this$0;
        e1.o(r15.a.c);
        e1.x(r15.a.b);
        r16.h3(null, false);
        goto L52
    L19:
        r15 = null;
        goto L20
    L11:
        if (r0 != 4) goto L52;
        s.a.g(AppHost.a.getApplication(), 2131908197, false);
        FragmentActivity r17 = s1a.a.c(this.this$0).getActivity();
        if (r17 == null) goto L52;
        r17.finish();
        goto L52
    L46:
        View r18 = this.this$0.F2();
        if ((r18 instanceof CreationDetailLoadingView) == false) goto L49;
        r2 = (CreationDetailLoadingView) r18;
    L49:
        if (r2 == null) goto L52;
        e1.x(r2.a.c);
        e1.o(r2.a.b);
        goto L52
    L54:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
