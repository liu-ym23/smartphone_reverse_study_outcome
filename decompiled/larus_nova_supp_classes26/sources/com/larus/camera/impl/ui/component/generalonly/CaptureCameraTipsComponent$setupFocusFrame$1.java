package com.larus.camera.impl.ui.component.generalonly;

import android.view.ViewParent;
import android.widget.FrameLayout;
import com.larus.camera.impl.widget.CaptureFocusFrame;
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
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.generalonly.CaptureCameraTipsComponent$setupFocusFrame$1", f = "CaptureCameraTipsComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CaptureCameraTipsComponent$setupFocusFrame$1 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ q this$0;

    public CaptureCameraTipsComponent$setupFocusFrame$1(q r1, Continuation<? super CaptureCameraTipsComponent$setupFocusFrame$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        CaptureCameraTipsComponent$setupFocusFrame$1 r0 = new CaptureCameraTipsComponent$setupFocusFrame$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((String) r1, (Continuation) r2);
    }

    public final Object invoke(String r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r4);
        String r5 = (String) this.L$0;
        FLogger.a.i("CaptureCameraTipsComponent", "[setupOverlay] current mode:" + r5);
        if (Intrinsics.areEqual(r5, "CAPTURE_MODE_PHOTO") == false) goto L15;
        CaptureFocusFrame r6 = this.this$0.q;
        if (r6 == null) goto L9;
        ViewParent r7 = r6.getParent();
    L10:
        if (r7 != null) goto L12;
        ((FrameLayout) this.this$0.h(2131388740)).addView(this.this$0.q, -1, -1);
    L12:
        CaptureFocusFrame r8 = this.this$0.q;
        if (r8 == null) goto L19;
        e1.x(r8);
    L19:
        return Unit.INSTANCE;
    L9:
        r7 = null;
        goto L10
    L15:
        CaptureFocusFrame r9 = this.this$0.q;
        if (r9 == null) goto L19;
        e1.o(r9);
        goto L19
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
