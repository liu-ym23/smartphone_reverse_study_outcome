package com.larus.bot.impl.feature.edit.feature.main;

import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.utils.x1;
import com.larus.bot.impl.databinding.LarusPageBotEditBinding;
import com.larus.common_ui.dialog.l0;
import com.larus.trace.tracknode.TraceFragment;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final LarusPageBotEditBinding a;
    public final c b;
    public final l0 c;
    public final x1 d;
    public final LifecycleCoroutineScope e;

    public final void a() {
        c r0 = this.b;
        if (r0 == null) goto L8;
        d1<e> r1 = r0.getUiEvent();
        if (r1 == null) goto L9;
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r1, new BotMainEditView$bindObservers$1(this, null)), this.e);
        return;
    L9:
        return;
    }

    public a(TraceFragment r2, LarusPageBotEditBinding r3, c r4, l0 r5, x1 r6) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "binding");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = LifecycleOwnerKt.getLifecycleScope(r2.getViewLifecycleOwner());
    }
}
