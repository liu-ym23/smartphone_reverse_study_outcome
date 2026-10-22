package com.larus.camera.impl.ui.component.result.general;

import android.view.View;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.camera.impl.databinding.LarusLayoutViewPreviewComponentBinding;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ResultPreviewComponent$onViewCreated$1$2 extends FunctionReferenceImpl implements Function0<Unit> {
    public ResultPreviewComponent$onViewCreated$1$2(Object r8) {
        super(0, r8, ResultPreviewComponent.class, "togglePreviewChrome", "togglePreviewChrome()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m109invoke() {
        ResultPreviewComponent r0 = (ResultPreviewComponent) ((CallableReference) this).receiver;
        int r1 = ResultPreviewComponent.z;
        CameraResultViewModel r2 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) r0.e.getValue()).a();
        if (r2 == null) goto L40;
        CameraContainer r3 = null;
        if (CameraResultViewModel.shouldUseUnifiedPreviewFramework$default(r2, null, 1, null) == false) goto L41;
        ViewParent r4 = r0.j().getParent();
        if ((r4 instanceof CameraContainer) == false) goto L11;
        r3 = (CameraContainer) r4;
    L11:
        if (r3 == null) goto L42;
        boolean r5 = !r0.r;
        r0.r = r5;
        if (r5 == false) goto L32;
        r0.s.clear();
        int r6 = r3.getChildCount();
        int r7 = 0;
    L17:
        if (r7 >= r6) goto L22;
        View r8 = r3.getChildAt(r7);
        if (r8 == r0.j()) goto L21;
        r0.s.put(r8, Integer.valueOf(r8.getVisibility()));
        r8.setVisibility(4);
    L21:
        r7 = r7 + 1;
        goto L17
    L22:
        LarusLayoutViewPreviewComponentBinding r9 = r0.m;
        if (r9 == null) goto L27;
        RecyclerView r10 = r9.c;
        if (r10 == null) goto L27;
        r10.setVisibility(4);
    L27:
        LarusLayoutViewPreviewComponentBinding r11 = r0.m;
        if (r11 == null) goto L37;
        View r12 = r11.f;
        if (r12 == null) goto L38;
        r12.setVisibility(4);
        return;
    L38:
        return;
    L37:
        return;
    L32:
        r0.t(r3);
        return;
    L42:
        return;
    L41:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m109invoke();
        return Unit.INSTANCE;
    }
}
