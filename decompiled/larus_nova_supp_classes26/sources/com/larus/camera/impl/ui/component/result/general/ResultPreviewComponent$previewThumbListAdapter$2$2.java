package com.larus.camera.impl.ui.component.result.general;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.camera.api.params.OutputParam;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ResultPreviewComponent$previewThumbListAdapter$2$2 extends FunctionReferenceImpl implements Function3<OutputParam, Integer, Integer, Unit> {
    public ResultPreviewComponent$previewThumbListAdapter$2$2(Object r8) {
        super(3, r8, ResultPreviewComponent.class, "onPreviewThumbDeleteClick", "onPreviewThumbDeleteClick(Lcom/larus/camera/api/params/OutputParam;II)V", 0);
    }

    public final void invoke(OutputParam r6, int r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "p0");
        ResultPreviewComponent r0 = (ResultPreviewComponent) ((CallableReference) this).receiver;
        int r1 = ResultPreviewComponent.z;
        r0.getClass();
        com.larus.camera.impl.ui.viewmodel.t r2 = com.larus.camera.impl.ui.viewmodel.t.a;
        List r3 = com.larus.camera.impl.ui.viewmodel.t.f();
        if ((r3 instanceof Collection) == true) goto L5;
    L7:
        Iterator r4 = r3.iterator();
    L9:
        if (r4.hasNext() == false) goto L13;
        if (((OutputParam) r4.next()).isVideo() == false) goto L9;
        boolean r5 = true;
    L14:
        com.larus.camera.impl.ui.viewmodel.t.a.delete(r6);
        if (r7 != r8) goto L21;
        int r9 = com.larus.camera.impl.ui.viewmodel.t.e() - 1;
        if (r7 <= r9) goto L19;
        r8 = r9;
    L20:
        Integer r10 = Integer.valueOf(r8);
    L33:
        r0.p((OutputParam) ListProtector.get(com.larus.camera.impl.ui.viewmodel.t.f(), r8), r8, Integer.valueOf(r7), r10);     // Catch: Exception -> L26
    L28:
        CameraResultViewModel r11 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) r0.e.getValue()).a();
        if (r11 == null) goto L38;
        r11.updatePreviewThumbListDeleteState(r5);
        return;
    L38:
        return;
    L26:
        e = move-exception;
        com.larus.platform.service.g.a.ensureNotReachHere(e);
        goto L28
    L19:
        r8 = r7;
        goto L20
    L21:
        if (r7 >= r8) goto L23;
        int r12 = r8 - 1;
        Integer r13 = Integer.valueOf(r8);
        r8 = r12;
        r10 = r13;
        goto L33
    L23:
        r10 = Integer.valueOf(r8);
    L13:
        r5 = false;
        goto L14
    L5:
        if (r3.isEmpty() == false) goto L7;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke((OutputParam) r1, ((Number) r2).intValue(), ((Number) r3).intValue());
        return Unit.INSTANCE;
    }
}
