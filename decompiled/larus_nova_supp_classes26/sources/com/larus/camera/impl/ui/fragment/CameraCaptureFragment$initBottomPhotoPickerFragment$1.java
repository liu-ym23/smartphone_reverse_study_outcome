package com.larus.camera.impl.ui.fragment;

import androidx.lifecycle.Lifecycle;
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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.fragment.CameraCaptureFragment$initBottomPhotoPickerFragment$1", f = "CameraCaptureFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CameraCaptureFragment$initBottomPhotoPickerFragment$1 extends SuspendLambda implements Function2<Long, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CameraCaptureFragment this$0;

    public CameraCaptureFragment$initBottomPhotoPickerFragment$1(CameraCaptureFragment r1, Continuation<? super CameraCaptureFragment$initBottomPhotoPickerFragment$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CameraCaptureFragment$initBottomPhotoPickerFragment$1(this.this$0, r3);
    }

    public final Object invoke(long r1, Continuation<? super Unit> r3) {
        return create(Long.valueOf(r1), r3).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4) {
        return invoke(((Number) r3).longValue(), (Continuation) r4);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r3);
        FLogger.a.i("CameraCaptureFragment", "initBottomPhotoPickerFragment onLatestPhotoChanged showPage lifeState=" + this.this$0.getLifecycle().getCurrentState() + " hashCode=" + this.this$0.hashCode());
        if (this.this$0.getLifecycle().getCurrentState() != Lifecycle.State.RESUMED) goto L8;
        CameraCaptureFragment r4 = this.this$0;
        int r0 = CameraCaptureFragment.h;
        r4.V90();
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
