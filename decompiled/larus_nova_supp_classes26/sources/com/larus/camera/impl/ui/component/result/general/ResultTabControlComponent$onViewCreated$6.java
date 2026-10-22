package com.larus.camera.impl.ui.component.result.general;

import android.view.View;
import com.larus.camera.impl.ui.component.result.inputtable.ResultInputControlBinder;
import com.larus.utils.logger.FLogger;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "displayState", "Lcom/larus/camera/impl/ui/component/result/general/ResultTabControlComponent$DisplayState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultTabControlComponent$onViewCreated$6", f = "ResultTabControlComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ResultTabControlComponent$onViewCreated$6 extends SuspendLambda implements Function2<ResultTabControlComponent.DisplayState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ResultTabControlComponent this$0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ResultTabControlComponent.DisplayState.values().length];
            r0[ResultTabControlComponent.DisplayState.CONFIRM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ResultTabControlComponent.DisplayState.INPUT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ResultTabControlComponent.DisplayState.HIDDEN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public ResultTabControlComponent$onViewCreated$6(ResultTabControlComponent r1, Continuation<? super ResultTabControlComponent$onViewCreated$6> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ResultTabControlComponent$onViewCreated$6 r0 = new ResultTabControlComponent$onViewCreated$6(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(ResultTabControlComponent.DisplayState r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((ResultTabControlComponent.DisplayState) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L35;
        ResultKt.throwOnFailure(r4);
        ResultTabControlComponent.DisplayState r5 = (ResultTabControlComponent.DisplayState) this.L$0;
        FLogger.a.i("ResultTabControlComponent", "[displayState] " + r5);
        int r6 = a.a[r5.ordinal()];
        View r2 = null;
        View r3 = null;
        ResultInputControlBinder r7 = null;
        if (r6 != 1) goto L7;
        View r8 = this.this$0.n;
        if (r8 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("confirmView");
    L31:
        com.larus.utils.e1.x(r2);
    L33:
        return Unit.INSTANCE;
    L30:
        r2 = r8;
        goto L31
    L7:
        if (r6 != 2) goto L9;
        View r9 = this.this$0.n;
        if (r9 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("confirmView");
        r9 = null;
    L20:
        com.larus.utils.e1.o(r9);
        ResultInputControlBinder r10 = this.this$0.o;
        if (r10 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("inputBinder");
    L24:
        op8.i r11 = (op8.i) r7.h.getValue();
        if (r11 == null) goto L33;
        r11.o8();
        goto L33
    L23:
        r7 = r10;
        goto L24
    L9:
        if (r6 != 3) goto L16;
        View r12 = this.this$0.n;
        if (r12 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("confirmView");
    L14:
        com.larus.utils.e1.o(r3);
        goto L33
    L13:
        r3 = r12;
        goto L14
    L16:
        throw new NoWhenBranchMatchedException();
    L35:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
