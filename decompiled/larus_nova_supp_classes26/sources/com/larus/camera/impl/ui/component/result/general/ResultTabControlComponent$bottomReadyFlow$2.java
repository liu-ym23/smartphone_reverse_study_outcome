package com.larus.camera.impl.ui.component.result.general;

import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "status", "Lcom/larus/camera/impl/ui/component/result/general/ResultDetectStatus;", "tabState", "Lcom/larus/camera/impl/entity/EduResultTabState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultTabControlComponent$bottomReadyFlow$2", f = "ResultTabControlComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ResultTabControlComponent$bottomReadyFlow$2 extends SuspendLambda implements Function3<n, px8.b, Continuation<? super Boolean>, Object> {
    final /* synthetic */ CameraResultViewModel $viewModel;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public ResultTabControlComponent$bottomReadyFlow$2(CameraResultViewModel r1, Continuation<? super ResultTabControlComponent$bottomReadyFlow$2> r2) {
        this.$viewModel = r1;
        super(3, r2);
    }

    public final Object invoke(n r3, px8.b r4, Continuation<? super Boolean> r5) {
        ResultTabControlComponent$bottomReadyFlow$2 r0 = new ResultTabControlComponent$bottomReadyFlow$2(this.$viewModel, r5);
        r0.L$0 = r3;
        r0.L$1 = r4;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((n) r1, (px8.b) r2, (Continuation) r3);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L27;
        ResultKt.throwOnFailure(r4);
        n r5 = (n) this.L$0;
        px8.b r0 = (px8.b) this.L$1;
        boolean r2 = true;
        if (this.$viewModel.enableResultDetect() == false) goto L23;
        if ((r5 instanceof n.a) == false) goto L10;
        n.a r6 = (n.a) r5;
    L12:
        if (r6 == null) goto L25;
        ix8.d r7 = r6.a;
        if (r7 == null) goto L25;
        if ((r7 instanceof ix8.d.b) == false) goto L23;
        if (r0.a.contains(r0.b) == true) goto L23;
        r2 = false;
    L25:
        return Boxing.boxBoolean(false);
    L10:
        r6 = null;
    L23:
        return Boxing.boxBoolean(r2);
    L27:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
