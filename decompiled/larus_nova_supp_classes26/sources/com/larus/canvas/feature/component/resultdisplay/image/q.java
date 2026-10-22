package com.larus.canvas.feature.component.resultdisplay.image;

import com.larus.bmhome.view.ChatConstraintLayout$b;
import com.larus.canvas.feature.component.logic.loading.CanvasProgressState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class q {
    public final int a;
    public final int b;
    public final Function1<ChatConstraintLayout$b, Unit> c;
    public final Function0<CanvasProgressState> d;

    /* JADX WARN: Multi-variable type inference failed */
    public q(int r2, int r3, Function1<? super ChatConstraintLayout$b, Unit> r4, Function0<CanvasProgressState> r5) {
        Intrinsics.checkNotNullParameter(r4, "addBottomInsetUpdateListener");
        Intrinsics.checkNotNullParameter(r5, "canvasProgressStateGetter");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
