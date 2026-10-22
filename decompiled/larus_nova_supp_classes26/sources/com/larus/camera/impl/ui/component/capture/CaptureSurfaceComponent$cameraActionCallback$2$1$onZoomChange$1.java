package com.larus.camera.impl.ui.component.capture;

import android.widget.TextView;
import com.larus.utils.logger.FLogger;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.capture.CaptureSurfaceComponent$cameraActionCallback$2$1$onZoomChange$1", f = "CaptureSurfaceComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CaptureSurfaceComponent$cameraActionCallback$2$1$onZoomChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $cameraType;
    final /* synthetic */ float $zoomValue;
    int label;
    final /* synthetic */ CaptureSurfaceComponent this$0;

    public CaptureSurfaceComponent$cameraActionCallback$2$1$onZoomChange$1(CaptureSurfaceComponent r1, float r2, int r3, Continuation<? super CaptureSurfaceComponent$cameraActionCallback$2$1$onZoomChange$1> r4) {
        this.this$0 = r1;
        this.$zoomValue = r2;
        this.$cameraType = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CaptureSurfaceComponent$cameraActionCallback$2$1$onZoomChange$1(this.this$0, this.$zoomValue, this.$cameraType, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L45;
        ResultKt.throwOnFailure(r11);
        CaptureSurfaceComponent r12 = this.this$0;     // Catch: Exception -> L40
        int r2 = CaptureSurfaceComponent.T;     // Catch: Exception -> L40
        xx8.c r13 = r12.M();     // Catch: Exception -> L40
        if (r13 == null) goto L39;
        float r14 = r13.c(this.$zoomValue);     // Catch: Exception -> L40
        this.this$0.B().a(r14);     // Catch: Exception -> L40
        double r3 = r14;
        boolean r6 = true;
        if (((float) Math.floor(r3)) != ((float) Math.ceil(r3))) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L13;
        String r5 = "%.0fx";
    L14:
        StringCompanionObject r7 = StringCompanionObject.INSTANCE;     // Catch: Exception -> L40
        String r8 = String.format(r5, Arrays.copyOf(new Object[]{Boxing.boxFloat(r14)}, 1));     // Catch: Exception -> L40
        xx8.c r9 = this.this$0.M();     // Catch: Exception -> L40
        if (r9 != null) goto L17;
    L19:
        boolean r10 = false;
    L20:
        if (r10 == false) goto L29;
        this.this$0.x().setText(r8);     // Catch: Exception -> L40
        if (((float) Math.floor(r3)) != ((float) Math.ceil(r3))) goto L24;
        boolean r15 = true;
    L25:
        if (r15 == false) goto L27;
        String r16 = "%.0f";
    L28:
        String r17 = String.format(r16, Arrays.copyOf(new Object[]{Boxing.boxFloat(r14)}, 1));     // Catch: Exception -> L40
        TextView r18 = this.this$0.x();     // Catch: Exception -> L40
        int r19 = com.larus.utils.j0.a;     // Catch: Exception -> L40
        r18.setContentDescription(String.format(com.larus.utils.j0.d(2131898786), Arrays.copyOf(new Object[]{r17}, 1)));     // Catch: Exception -> L40
    L37:
        FLogger.a.i("CaptureSurfaceComponent", "cameraActionCallback onZoomChange cameraTyp=" + this.$cameraType + " zoomValue=" + this.$zoomValue + " zoomRatio=" + r14 + " zoomRatioStr=" + r8);     // Catch: Exception -> L40
    L43:
        return Unit.INSTANCE;
    L27:
        r16 = "%.1f";
        goto L28
    L24:
        r15 = false;
        goto L25
    L29:
        xx8.c r20 = this.this$0.M();     // Catch: Exception -> L40
        if (r20 != null) goto L32;
    L34:
        r6 = false;
    L35:
        if (r6 == false) goto L37;
        this.this$0.L(r8);     // Catch: Exception -> L40
        goto L37
    L32:
        if (r20.h() != true) goto L34;
    L17:
        if (r9.d() != true) goto L19;
        r10 = true;
        goto L20
    L13:
        r5 = "%.1fx";
        goto L14
    L10:
        r4 = false;
        goto L11
    L39:
        return Unit.INSTANCE;
    L40:
        e = move-exception;
        FLogger.a.e("CaptureSurfaceComponent", "surfaceCreated e=" + e.getMessage());
        com.larus.platform.service.g.a.ensureNotReachHere(e);
        goto L43
    L45:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
