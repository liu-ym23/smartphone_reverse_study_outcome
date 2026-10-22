package com.larus.camera.impl.ui.component.result.general;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.camera.api.params.OutputParam;
import com.larus.camera.impl.databinding.LarusLayoutViewPreviewComponentBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ResultPreviewComponent$onViewCreated$1$1 extends FunctionReferenceImpl implements Function2<OutputParam, Integer, Unit> {
    public ResultPreviewComponent$onViewCreated$1$1(Object r8) {
        super(2, r8, ResultPreviewComponent.class, "onPreviewPageSwiped", "onPreviewPageSwiped(Lcom/larus/camera/api/params/OutputParam;I)V", 0);
    }

    public final void invoke(OutputParam r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        ResultPreviewComponent r0 = (ResultPreviewComponent) ((CallableReference) this).receiver;
        if (r4 == r0.o) goto L13;
        r0.p(r3, r4, null, null);
        LarusLayoutViewPreviewComponentBinding r5 = r0.m;
        if (r5 == null) goto L11;
        RecyclerView r6 = r5.c;
        if (r6 == null) goto L12;
        r6.scrollToPosition(r4);
        return;
    L12:
        return;
    L11:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((OutputParam) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }
}
