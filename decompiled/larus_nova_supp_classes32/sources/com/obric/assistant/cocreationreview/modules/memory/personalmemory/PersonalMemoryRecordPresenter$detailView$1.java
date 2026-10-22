package com.obric.assistant.cocreationreview.modules.memory.personalmemory;

import hda.e1;
import hda.j0;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class PersonalMemoryRecordPresenter$detailView$1 extends FunctionReferenceImpl implements Function1<e1, List<? extends j0>> {
    public PersonalMemoryRecordPresenter$detailView$1(Object r8) {
        super(1, r8, e.class, "personalMemoryBasicInfo", "personalMemoryBasicInfo(Lcom/obric/assistant/cocreationreview/modules/memory/MemoryReviewUiModel;)Ljava/util/List;", 0);
    }

    public final List<j0> invoke(e1 r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        e r0 = (e) ((CallableReference) this).receiver;
        e r1 = e.b;
        r0.getClass();
        return e.m(r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((e1) r1);
    }
}
