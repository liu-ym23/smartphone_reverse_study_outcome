package com.larus.camera.impl.ui.component.result.inputtable;

import android.view.View;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "showInput", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.inputtable.ResultInputControlBinder$bind$1", f = "ResultInputControlBinder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ResultInputControlBinder$bind$1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ ResultInputControlBinder this$0;

    public ResultInputControlBinder$bind$1(ResultInputControlBinder r1, Continuation<? super ResultInputControlBinder$bind$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ResultInputControlBinder$bind$1 r0 = new ResultInputControlBinder$bind$1(this.this$0, r4);
        r0.Z$0 = ((Boolean) r3).booleanValue();
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
    }

    public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
        return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r4);
        boolean r5 = this.Z$0;
        FLogger.a.i("ResultInputtableControlComponent", "[bind] showInput:" + r5);
        CameraResultViewModel r0 = (CameraResultViewModel) this.this$0.c.invoke();
        if (r0 == null) goto L7;
        if (r5 == false) goto L15;
        View r1 = this.this$0.d;
        if (r1 == null) goto L13;
        e1.x(r1);
    L13:
        if (this.this$0.g == true) goto L18;
        r0.showCameraItemMobOnResult("input_icon");
        this.this$0.g = true;
    L18:
        r0.enableFreeInputMode(r5);
        return Unit.INSTANCE;
    L15:
        View r2 = this.this$0.d;
        if (r2 == null) goto L18;
        e1.o(r2);
        goto L18
    L7:
        return Unit.INSTANCE;
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
