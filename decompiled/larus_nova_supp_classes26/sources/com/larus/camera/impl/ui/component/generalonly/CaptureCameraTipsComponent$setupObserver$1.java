package com.larus.camera.impl.ui.component.generalonly;

import com.larus.camera.impl.widget.CaptureFocusFrame;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/camera/impl/entity/RecordControlUIState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.generalonly.CaptureCameraTipsComponent$setupObserver$1", f = "CaptureCameraTipsComponent.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
final class CaptureCameraTipsComponent$setupObserver$1 extends SuspendLambda implements Function2<px8.d, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ q this$0;

    public CaptureCameraTipsComponent$setupObserver$1(q r1, Continuation<? super CaptureCameraTipsComponent$setupObserver$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        CaptureCameraTipsComponent$setupObserver$1 r0 = new CaptureCameraTipsComponent$setupObserver$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((px8.d) r1, (Continuation) r2);
    }

    public final Object invoke(px8.d r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L24:
        q r5 = this.this$0;
        int r2 = q.t;
        r5.q().setVisibility(this.this$0.r);
        q r6 = this.this$0;
        CaptureFocusFrame r3 = r6.q;
        if (r3 == null) goto L28;
        r3.setVisibility(r6.s);
    L28:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        px8.d r7 = (px8.d) this.L$0;
        if ((r7 instanceof px8.d.a) == false) goto L20;
        if (((px8.d.a) r7).a == false) goto L20;
        q r8 = this.this$0;
        int r9 = q.t;
        r8.r = r8.q().getVisibility();
        q r10 = this.this$0;
        CaptureFocusFrame r11 = r10.q;
        if (r11 == null) goto L15;
        int r12 = r11.getVisibility();
    L16:
        r10.s = r12;
        e1.o(this.this$0.q());
        CaptureFocusFrame r13 = this.this$0.q;
        if (r13 == null) goto L28;
        e1.o(r13);
        goto L28
    L15:
        r12 = 8;
    L20:
        if ((r7 instanceof px8.d.f) == false) goto L28;
        this.label = 1;
        if (DelayKt.delay(1000, this) != r0) goto L24;
        return r0;
    }
}
