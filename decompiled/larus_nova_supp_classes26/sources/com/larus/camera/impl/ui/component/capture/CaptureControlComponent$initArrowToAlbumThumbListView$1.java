package com.larus.camera.impl.ui.component.capture;

import android.content.Context;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.camera.impl.utils.album.FastPhotoPickerInCameraManager;
import com.larus.platform.model.camera.ICameraEventExt;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.capture.CaptureControlComponent$initArrowToAlbumThumbListView$1", f = "CaptureControlComponent.kt", i = {}, l = {345}, m = "invokeSuspend", n = {}, s = {})
final class CaptureControlComponent$initArrowToAlbumThumbListView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $conversationId;
    final /* synthetic */ CameraCaptureViewModel $viewModel;
    int label;
    final /* synthetic */ CaptureControlComponent this$0;

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.component.capture.CaptureControlComponent$initArrowToAlbumThumbListView$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "changeState", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.component.capture.CaptureControlComponent$initArrowToAlbumThumbListView$1$1", f = "CaptureControlComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
        /* synthetic */ int I$0;
        int label;
        final /* synthetic */ CaptureControlComponent this$0;

        public AnonymousClass1(CaptureControlComponent r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
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
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            int r3 = this.I$0;
            CaptureControlComponent.s(this.this$0, r3);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.component.capture.CaptureControlComponent$initArrowToAlbumThumbListView$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.component.capture.CaptureControlComponent$initArrowToAlbumThumbListView$1$2", f = "CaptureControlComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
        final /* synthetic */ CameraCaptureViewModel $viewModel;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ CaptureControlComponent this$0;

        public AnonymousClass2(CaptureControlComponent r1, CameraCaptureViewModel r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$viewModel = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass2 r0 = new AnonymousClass2(this.this$0, this.$viewModel, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((String) r1, (Continuation) r2);
        }

        public final Object invoke(String r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r2);
            String r3 = (String) this.L$0;
            List<String> r0 = fx8.a.a;
            if (fx8.a.a.contains(r3) == false) goto L7;
            CaptureControlComponent.s(this.this$0, ((Number) this.$viewModel.getAlbumThumbListStateChanged().getValue()).intValue());
        L9:
            return Unit.INSTANCE;
        L7:
            CaptureControlComponent r4 = this.this$0;
            int r1 = CaptureControlComponent.u;
            r4.A(false);
            goto L9
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public CaptureControlComponent$initArrowToAlbumThumbListView$1(CameraCaptureViewModel r1, CaptureControlComponent r2, String r3, Continuation<? super CaptureControlComponent$initArrowToAlbumThumbListView$1> r4) {
        this.$viewModel = r1;
        this.this$0 = r2;
        this.$conversationId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CaptureControlComponent$initArrowToAlbumThumbListView$1(this.$viewModel, this.this$0, this.$conversationId, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L16:
        if (((Boolean) r7).booleanValue() == false) goto L18;
        CaptureControlComponent.s(this.this$0, ((Number) this.$viewModel.getAlbumThumbListStateChanged().getValue()).intValue());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(this.$viewModel.getAlbumThumbListStateChanged(), new AnonymousClass1(this.this$0, null)), this.this$0.k());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(this.$viewModel.getCaptureModeStatus(), new AnonymousClass2(this.this$0, this.$viewModel, null)), this.this$0.k());
    L20:
        return Unit.INSTANCE;
    L18:
        CaptureControlComponent r8 = this.this$0;
        int r2 = CaptureControlComponent.u;
        r8.A(false);
        goto L20
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        ICameraEventExt r9 = this.$viewModel.getCameraData().getEventExt();
        if (r9 == null) goto L11;
        String r10 = r9.getClickFrom();
    L12:
        FastPhotoPickerInCameraManager r3 = FastPhotoPickerInCameraManager.a;
        CaptureControlComponent r4 = this.this$0;
        int r5 = CaptureControlComponent.u;
        Context r6 = r4.getContext();
        String r11 = this.$conversationId;
        this.label = 1;
        r7 = r3.b(r6, r11, r10, this);
        if (r7 != r0) goto L16;
        return r0;
    L11:
        r10 = null;
        goto L12
    }
}
