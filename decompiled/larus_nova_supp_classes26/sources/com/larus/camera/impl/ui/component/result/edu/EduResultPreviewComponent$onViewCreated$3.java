package com.larus.camera.impl.ui.component.result.edu;

import android.content.Context;
import android.graphics.Bitmap;
import com.larus.camera.api.params.OutputParam;
import com.larus.camera.impl.monitor.CameraEvent;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import com.larus.camera.impl.ui.viewmodel.o0;
import com.larus.camera.impl.utils.c0;
import com.larus.camera.impl.widget.EduCaptureTipView;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import nx8.m;
import org.json.JSONObject;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.edu.EduResultPreviewComponent$onViewCreated$3", f = "EduResultPreviewComponent.kt", i = {}, l = {186}, m = "invokeSuspend", n = {}, s = {})
public final class EduResultPreviewComponent$onViewCreated$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $albumPath;
    final /* synthetic */ int $orientation;
    final /* synthetic */ CameraResultViewModel $viewModel;
    int label;
    final /* synthetic */ EduResultPreviewComponent this$0;

    public EduResultPreviewComponent$onViewCreated$3(CameraResultViewModel r1, EduResultPreviewComponent r2, String r3, int r4, Continuation<? super EduResultPreviewComponent$onViewCreated$3> r5) {
        this.$viewModel = r1;
        this.this$0 = r2;
        this.$albumPath = r3;
        this.$orientation = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new EduResultPreviewComponent$onViewCreated$3(this.$viewModel, this.this$0, this.$albumPath, this.$orientation, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L11:
        Bitmap r13 = ((o0) r12).a;
        boolean r2 = false;
        if (r13 != null) goto L15;
        this.$viewModel.closePage();
        s r14 = s.a;
        EduResultPreviewComponent r3 = this.this$0;
        int r4 = EduResultPreviewComponent.q;
        Context r5 = r3.getContext();
        r14.getClass();
        s.b(r5, 2131898469, false);
        return Unit.INSTANCE;
    L15:
        String r6 = this.$albumPath;
        if (r6.length() <= 0) goto L18;
        r2 = true;
    L18:
        String r7 = null;
        if (r2 == true) goto L22;
        r6 = null;
    L22:
        if (r6 != null) goto L26;
        OutputParam r8 = this.$viewModel.getCurrentDisplayOutputParam();
        if (r8 == null) goto L27;
        r7 = r8.getPath();
    L27:
        if (r7 == null) goto L38;
        if (this.$viewModel.isFromAlbum() == true) goto L31;
        qx8.a.b.a.a(CameraEvent.CAPTURE_DURATION, new JSONObject());
    L31:
        this.$viewModel.updateCurrentBitmap(r13, "EduResultPreviewComponent");
        int r9 = c0.d;
        int r10 = (int) c0.a.a(this.$orientation, true);
        int r11 = EduCaptureTipView.l;
        EduResultPreviewComponent r15 = this.this$0;
        int r16 = EduResultPreviewComponent.q;
        Pair r17 = EduCaptureTipView.a.a(r15.getContext(), r10);
        int r18 = ((Number) r17.component1()).intValue();
        int r19 = ((Number) r17.component2()).intValue();
        m r20 = this.this$0.m;
        if (r20 == null) goto L34;
        r20.f(r18, r19);
    L34:
        m r21 = this.this$0.m;
        if (r21 == null) goto L38;
        r21.o(r13, r7, r10, true);
    L38:
        return Unit.INSTANCE;
    L26:
        r7 = r6;
        goto L27
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        CameraResultViewModel r22 = this.$viewModel;
        EduResultPreviewComponent r110 = this.this$0;
        int r23 = EduResultPreviewComponent.q;
        Context r24 = r110.getContext();
        String r25 = this.$albumPath;
        this.label = 1;
        r12 = CameraResultViewModel.getPreviewBitmap$default(r22, r24, r25, 0, null, this, 12, null);
        if (r12 != r0) goto L11;
        return r0;
    }
}
