package com.obric.assistant.cocreationreview.modules.memory.automemorypro;

import hda.e1;
import hda.j0;
import hda.t1;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class AutoMemoryProRecordPresenter$detailView$1 extends FunctionReferenceImpl implements Function1<e1, List<? extends j0>> {
    public AutoMemoryProRecordPresenter$detailView$1(Object r8) {
        super(1, r8, f.class, "autoMemoryProBasicInfo", "autoMemoryProBasicInfo(Lcom/obric/assistant/cocreationreview/modules/memory/MemoryReviewUiModel;)Ljava/util/List;", 0);
    }

    public final List<j0> invoke(e1 r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        f r0 = (f) ((CallableReference) this).receiver;
        f r1 = f.b;
        r0.getClass();
        return t1.a(r3.g, null);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((e1) r1);
    }
}
