package com.larus.camera.impl.ui.component.capture;

import com.larus.camera.impl.ui.viewmodel.ChangeState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "changeState", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.capture.CaptureSurfaceComponent$initZoomRatioViewsAttachToAlbumThumbList$1", f = "CaptureSurfaceComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CaptureSurfaceComponent$initZoomRatioViewsAttachToAlbumThumbList$1 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ CaptureSurfaceComponent this$0;

    public CaptureSurfaceComponent$initZoomRatioViewsAttachToAlbumThumbList$1(CaptureSurfaceComponent r1, Continuation<? super CaptureSurfaceComponent$initZoomRatioViewsAttachToAlbumThumbList$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        CaptureSurfaceComponent$initZoomRatioViewsAttachToAlbumThumbList$1 r0 = new CaptureSurfaceComponent$initZoomRatioViewsAttachToAlbumThumbList$1(this.this$0, r4);
        r0.I$0 = ((Number) r3).intValue();
        return r0;
    }

    public final Object invoke(int r1, Continuation<? super Unit> r2) {
        return create(Integer.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Number) r1).intValue(), (Continuation) r2);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r2);
        int r3 = this.I$0;
        if (r3 != ChangeState.HIDE.getState()) goto L8;
        CaptureSurfaceComponent r4 = this.this$0;
        int r0 = CaptureSurfaceComponent.T;
        com.larus.utils.e1.x(r4.A());
    L12:
        return Unit.INSTANCE;
    L8:
        if (r3 != ChangeState.SHOW.getState()) goto L10;
        CaptureSurfaceComponent r5 = this.this$0;
        int r1 = CaptureSurfaceComponent.T;
        com.larus.utils.e1.o(r5.A());
        goto L12
    L10:
        ChangeState.DEFAULT.getState();
        goto L12
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
