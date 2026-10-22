package com.larus.camera.impl.ui.component.capture;

import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.platform.model.album.AlbumSelectItem;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "it", "", "Lcom/larus/platform/model/album/AlbumSelectItem;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.capture.CaptureControlComponent$onViewCreated$8", f = "CaptureControlComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CaptureControlComponent$onViewCreated$8 extends SuspendLambda implements Function2<List<? extends AlbumSelectItem>, Continuation<? super Unit>, Object> {
    final /* synthetic */ CameraCaptureViewModel $viewModel;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CaptureControlComponent this$0;

    public CaptureControlComponent$onViewCreated$8(CaptureControlComponent r1, CameraCaptureViewModel r2, Continuation<? super CaptureControlComponent$onViewCreated$8> r3) {
        this.this$0 = r1;
        this.$viewModel = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        CaptureControlComponent$onViewCreated$8 r0 = new CaptureControlComponent$onViewCreated$8(this.this$0, this.$viewModel, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((List) r1, (Continuation) r2);
    }

    public final Object invoke(List<AlbumSelectItem> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r4);
        List<AlbumSelectItem> r5 = (List) this.L$0;
        FLogger.a.i("CaptureControlComponent", "[onPictureSelected] " + r5);
        CaptureControlComponent r0 = this.this$0;
        CameraCaptureViewModel r1 = this.$viewModel;
        r0.getClass();
        if (a.C0081a.a(r0, r1) == false) goto L7;
        this.$viewModel.clickAlbumPhotoOnCapturePage();
        this.this$0.z(r5);
        return Unit.INSTANCE;
    L7:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
