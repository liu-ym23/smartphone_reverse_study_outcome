package com.larus.camera.impl.ui.component.result.general;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.camera.api.params.OutputParam;
import com.larus.camera.impl.databinding.LarusLayoutViewPreviewComponentBinding;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ResultPreviewComponent$previewThumbListAdapter$2$1 extends FunctionReferenceImpl implements Function2<OutputParam, Integer, Unit> {
    public ResultPreviewComponent$previewThumbListAdapter$2$1(Object r8) {
        super(2, r8, ResultPreviewComponent.class, "onPreviewThumbItemClick", "onPreviewThumbItemClick(Lcom/larus/camera/api/params/OutputParam;I)V", 0);
    }

    public final void invoke(OutputParam r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "p0");
        ResultPreviewComponent r0 = (ResultPreviewComponent) ((CallableReference) this).receiver;
        int r1 = ResultPreviewComponent.z;
        CameraResultViewModel r2 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) r0.e.getValue()).a();
        if (r2 == null) goto L25;
        LinearLayoutManager r3 = null;
        r0.p(r9, r10, null, null);
        LarusLayoutViewPreviewComponentBinding r11 = r0.m;
        if (r11 == null) goto L10;
        RecyclerView r12 = r11.c;
        if (r12 == null) goto L10;
        RecyclerView.LayoutManager r13 = r12.getLayoutManager();
    L12:
        if ((r13 instanceof LinearLayoutManager) == false) goto L14;
        r3 = (LinearLayoutManager) r13;
    L14:
        if (r3 == null) goto L23;
        int r14 = r3.findFirstCompletelyVisibleItemPosition();
        int r4 = r3.findLastCompletelyVisibleItemPosition();
        if (r10 < r14) goto L18;
        if (r10 <= r4) goto L23;
    L18:
        LarusLayoutViewPreviewComponentBinding r15 = r0.m;
        if (r15 == null) goto L23;
        RecyclerView r16 = r15.c;
        if (r16 == null) goto L23;
        r16.smoothScrollToPosition(r10);
    L23:
        CameraResultViewModel.clickButton$default(r2, "other_tn", "camera_confirm", null, 4, null);
        return;
    L10:
        r13 = null;
        goto L12
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((OutputParam) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }
}
