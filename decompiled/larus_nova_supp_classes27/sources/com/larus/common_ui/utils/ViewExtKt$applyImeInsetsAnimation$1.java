package com.larus.common_ui.utils;

import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rH\u0016¨\u0006\u000e"}, d2 = {"com/larus/common_ui/utils/ViewExtKt$applyImeInsetsAnimation$1", "Landroidx/core/view/WindowInsetsAnimationCompat$Callback;", "onPrepare", "", "animation", "Landroidx/core/view/WindowInsetsAnimationCompat;", "onStart", "Landroidx/core/view/WindowInsetsAnimationCompat$BoundsCompat;", "bounds", "onProgress", "Landroidx/core/view/WindowInsetsCompat;", "insets", "runningAnimations", "", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ViewExtKt$applyImeInsetsAnimation$1 extends WindowInsetsAnimationCompat.Callback {
    public final /* synthetic */ Function1<Insets, Unit> a;

    public final void onPrepare(WindowInsetsAnimationCompat r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    public final WindowInsetsAnimationCompat.BoundsCompat onStart(WindowInsetsAnimationCompat r2, WindowInsetsAnimationCompat.BoundsCompat r3) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        Intrinsics.checkNotNullParameter(r3, "bounds");
        return r3;
    }

    public ViewExtKt$applyImeInsetsAnimation$1(Function1<? super Insets, Unit> r1) {
        this.a = r1;
        super(1);
    }

    public final WindowInsetsCompat onProgress(WindowInsetsCompat r2, List<WindowInsetsAnimationCompat> r3) {
        Intrinsics.checkNotNullParameter(r2, "insets");
        Intrinsics.checkNotNullParameter(r3, "runningAnimations");
        Function1<Insets, Unit> r4 = this.a;
        if (r4 == null) goto L5;
        r4.invoke(r2.getInsets(WindowInsetsCompat.Type.ime()));
    L5:
        return r2;
    }
}
