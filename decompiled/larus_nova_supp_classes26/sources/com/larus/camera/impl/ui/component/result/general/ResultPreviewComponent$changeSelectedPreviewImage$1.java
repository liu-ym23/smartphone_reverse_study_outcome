package com.larus.camera.impl.ui.component.result.general;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.bmhome.view.markableview.MarkableImageView;
import com.larus.camera.api.params.OutputParam;
import com.larus.camera.impl.databinding.LarusLayoutPreviewContainerBinding;
import com.larus.camera.impl.databinding.LarusLayoutViewPreviewComponentBinding;
import com.larus.camera.impl.ui.component.result.general.viewpager.PreviewContainerView;
import com.larus.camera.impl.ui.component.result.general.viewpager.ResultPreviewFragmentAdapter;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultPreviewComponent$changeSelectedPreviewImage$1", f = "ResultPreviewComponent.kt", i = {0}, l = {545}, m = "invokeSuspend", n = {"viewModel"}, s = {"L$0"})
public final class ResultPreviewComponent$changeSelectedPreviewImage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $current;
    final /* synthetic */ Integer $deletePosition;
    final /* synthetic */ Integer $newSelectedBeforeRealDelete;
    final /* synthetic */ OutputParam $outputParam;
    final /* synthetic */ int $position;
    final /* synthetic */ boolean $rejectStaleSelection;
    final /* synthetic */ long $requestId;
    Object L$0;
    int label;
    final /* synthetic */ ResultPreviewComponent this$0;

    public ResultPreviewComponent$changeSelectedPreviewImage$1(ResultPreviewComponent r1, OutputParam r2, boolean r3, long r4, int r6, Integer r7, int r8, Integer r9, Continuation<? super ResultPreviewComponent$changeSelectedPreviewImage$1> r10) {
        this.this$0 = r1;
        this.$outputParam = r2;
        this.$rejectStaleSelection = r3;
        this.$requestId = r4;
        this.$current = r6;
        this.$deletePosition = r7;
        this.$position = r8;
        this.$newSelectedBeforeRealDelete = r9;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        return new ResultPreviewComponent$changeSelectedPreviewImage$1(this.this$0, this.$outputParam, this.$rejectStaleSelection, this.$requestId, this.$current, this.$deletePosition, this.$position, this.$newSelectedBeforeRealDelete, r13);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CameraResultViewModel r3 = (CameraResultViewModel) this.L$0;
        ResultKt.throwOnFailure(r11);
    L18:
        Bitmap r4 = (Bitmap) r11;
        CameraResultViewModel r12 = r3;
    L20:
        if (this.$rejectStaleSelection == true) goto L22;
    L25:
        if (r4 == null) goto L117;
        LarusLayoutViewPreviewComponentBinding r5 = this.this$0.m;
        if (r5 == null) goto L97;
        PreviewContainerView r6 = r5.d;
        if (r6 == null) goto L97;
        int r7 = this.$current;
        Integer r8 = this.$deletePosition;
        r6.j();
        FLogger r9 = FLogger.a;
        r9.i("PreviewContainerView", "[onPreviewChangedBefore] lastPosition:" + r7 + " deletePosition:" + r8);
        if (r6.c == null) goto L47;
        r9.i("PreviewContainerView", "[onPreviewChangedBefore] viewPager change");
        ResultPreviewFragmentAdapter r10 = r6.b;
        Fragment r13 = null;
        if (r10 == null) goto L35;
        com.larus.camera.impl.ui.component.result.general.viewpager.d r14 = r10.y2(r7);
    L37:
        if ((r14 instanceof Fragment) == false) goto L39;
        r13 = (Fragment) r14;
    L39:
        if (r13 != null) goto L41;
    L43:
        r2 = false;
    L44:
        if (r2 == false) goto L46;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.larus.camera.impl.ui.component.result.general.viewpager.IMultiPreview");
        ((com.larus.camera.impl.ui.component.result.general.viewpager.d) r13).oK();
        goto L97
    L46:
        r9.w("PreviewContainerView", "[onPreviewChangedBefore] skip detached fragment position:" + r7);
        goto L97
    L41:
        if (r13.isAdded() != true) goto L43;
    L35:
        r14 = null;
        goto L37
    L47:
        r9.i("PreviewContainerView", "[onPreviewChangedBefore] image change");
        if (r8 == null) goto L56;
        r8.intValue();
        r9.i("PreviewContainerView", "[onPreviewChangedBefore] image change when delete");
        if (r7 != r8.intValue()) goto L97;
        LarusLayoutPreviewContainerBinding r15 = r6.d;
        if (r15 == null) goto L97;
        MarkableImageView r16 = r15.b;
        if (r16 == null) goto L97;
        r16.clear();
        goto L97
    L56:
        r9.i("PreviewContainerView", "[onPreviewChangedBefore] image change when click");
        CameraResultViewModel r17 = r6.a;
        if (r17 == null) goto L63;
        kotlinx.coroutines.flow.i1<Boolean> r18 = r17.getEnableUndo();
        if (r18 == null) goto L63;
        if (((Boolean) r18.getValue()).booleanValue() != true) goto L63;
        boolean r19 = true;
    L64:
        if (r19 == false) goto L97;
        CameraResultViewModel r20 = r6.a;
        if (r20 != null) goto L68;
    L70:
        boolean r21 = false;
    L71:
        if (r21 == false) goto L80;
        CameraResultViewModel r22 = r6.a;
        if (r22 == null) goto L75;
        r22.setImageHasBeenMarked(true);
    L75:
        LarusLayoutPreviewContainerBinding r23 = r6.d;
        if (r23 == null) goto L97;
        MarkableImageView r24 = r23.b;
        if (r24 == null) goto L97;
        r24.clear();
        goto L97
    L80:
        LarusLayoutPreviewContainerBinding r25 = r6.d;
        if (r25 == null) goto L97;
        MarkableImageView r26 = r25.b;
        if (r26 == null) goto L97;
        Bitmap r27 = r26.getMarkedBitmap();
        if (r27 == null) goto L97;
        CameraResultViewModel r28 = r6.a;
        if (r28 == null) goto L89;
        r28.updateCurrentBitmap(r27, "onPreviewThumbItemClick");
    L89:
        CameraResultViewModel r29 = r6.a;
        if (r29 == null) goto L92;
        r29.setImageHasBeenMarked(true);
    L92:
        LarusLayoutPreviewContainerBinding r30 = r6.d;
        if (r30 == null) goto L97;
        MarkableImageView r31 = r30.b;
        if (r31 == null) goto L97;
        r31.clear();
        goto L97
    L68:
        if (r20.shouldDeferCurrentMarkBitmapUpdate() != true) goto L70;
        r21 = true;
    L63:
        r19 = false;
    L97:
        r12.changeCurrentBitmap(this.$outputParam, r4, "changeSelectedPreviewImage");
        LarusLayoutViewPreviewComponentBinding r110 = this.this$0.m;
        if (r110 == null) goto L117;
        final PreviewContainerView r111 = r110.d;
        if (r111 == null) goto L117;
        int r32 = this.$position;
        Integer r33 = this.$deletePosition;
        Integer r34 = this.$newSelectedBeforeRealDelete;
        FLogger.a.i("PreviewContainerView", "[onPreviewChanged] position:" + r32 + ", deletePosition:" + r33);
        if (r34 == null) goto L104;
        r32 = r34.intValue();
    L104:
        ViewPager2 r35 = r111.c;
        if (r35 != null) goto L107;
    L109:
        ResultPreviewFragmentAdapter r36 = r111.b;
        if (r36 == null) goto L114;
        com.larus.camera.impl.ui.component.result.general.viewpager.d r37 = r36.y2(r32);
        if (r37 == null) goto L114;
        r37.BI();
    L114:
        if (r33 == null) goto L117;
        final int r38 = r33.intValue();
        r111.post(new com.larus.camera.impl.ui.component.result.general.viewpager.l(r111, r38));
        goto L117
    L107:
        if (r35.getCurrentItem() == r32) goto L109;
        r111.j = Integer.valueOf(r32);
        r35.setCurrentItem(r32, false);
    L117:
        return Unit.INSTANCE;
    L22:
        if (this.$requestId == this.this$0.t) goto L25;
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        r12 = (CameraResultViewModel) com.larus.camera.impl.ui.arch.b.e(this.this$0).a();
        if (r12 == null) goto L11;
        com.larus.camera.impl.ui.viewmodel.t r39 = com.larus.camera.impl.ui.viewmodel.t.a;
        r4 = com.larus.camera.impl.ui.viewmodel.t.c(this.$outputParam);
        if (r4 != null) goto L20;
        ResultPreviewComponent r40 = this.this$0;
        int r41 = ResultPreviewComponent.z;
        Context r42 = r40.getContext();
        OutputParam r43 = this.$outputParam;
        this.L$0 = r12;
        this.label = 1;
        Object r44 = r12.getPreviewBitmapByPath(r42, r43, this);
        if (r44 != r0) goto L17;
        return r0;
    L17:
        r3 = r12;
        r11 = r44;
        goto L18
    L11:
        return Unit.INSTANCE;
    }
}
