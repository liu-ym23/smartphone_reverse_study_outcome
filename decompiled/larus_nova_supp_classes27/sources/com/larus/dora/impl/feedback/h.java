package com.larus.dora.impl.feedback;

import androidx.lifecycle.ViewModelKt;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h {
    public final DoraGFeedbackViewModel a;
    public final StateFlowImpl b;
    public final StateFlowImpl c;
    public final b1 d;

    public final List<g> a() {
        return (List) this.b.getValue();
    }

    public h(DoraGFeedbackViewModel r11) {
        Intrinsics.checkNotNullParameter(r11, "viewModel");
        this.a = r11;
        this.b = j1.a(CollectionsKt.emptyList());
        StateFlowImpl r0 = j1.a(Boolean.TRUE);
        this.c = r0;
        this.d = kotlinx.coroutines.flow.e.b(r0);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0, new DoraFeedbackImageGroup$setupStateLogging$1(this, null)), ViewModelKt.getViewModelScope(r11));
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(r11), null, null, new DoraFeedbackImageGroup$trackAllImagesReadyState$1(this, null), 3, null);
    }
}
