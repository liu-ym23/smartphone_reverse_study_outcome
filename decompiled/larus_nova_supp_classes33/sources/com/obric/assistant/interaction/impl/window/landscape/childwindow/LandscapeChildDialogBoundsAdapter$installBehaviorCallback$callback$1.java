package com.obric.assistant.interaction.impl.window.landscape.childwindow;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$installBehaviorCallback$callback$1", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$BottomSheetCallback;", "onStateChanged", "", "bottomSheet", "Landroid/view/View;", "newState", "", "onSlide", "slideOffset", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LandscapeChildDialogBoundsAdapter$installBehaviorCallback$callback$1 extends BottomSheetBehavior.BottomSheetCallback {
    final /* synthetic */ LandscapeChildDialogBoundsAdapter.BoundsState $state;

    public static /* synthetic */ void a(LandscapeChildDialogBoundsAdapter.BoundsState r0, int r1) {
        onStateChanged$lambda$0(r0, r1);
    }

    public static /* synthetic */ void b(LandscapeChildDialogBoundsAdapter.BoundsState r0) {
        onSlide$lambda$1(r0);
    }

    public LandscapeChildDialogBoundsAdapter$installBehaviorCallback$callback$1(LandscapeChildDialogBoundsAdapter.BoundsState r1) {
        this.$state = r1;
    }

    private static final void onSlide$lambda$1(LandscapeChildDialogBoundsAdapter.BoundsState r2) {
        LandscapeChildDialogBoundsAdapter.access$restoreStableBounds(LandscapeChildDialogBoundsAdapter.INSTANCE, r2, "slide");
    }

    private static final void onStateChanged$lambda$0(LandscapeChildDialogBoundsAdapter.BoundsState r3, int r4) {
        LandscapeChildDialogBoundsAdapter.access$restoreStableBounds(LandscapeChildDialogBoundsAdapter.INSTANCE, r3, "state:" + r4);
    }

    public void onSlide(View r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "bottomSheet");
        if (this.$state.isHidden() == false) goto L5;
        return;
    L5:
        final LandscapeChildDialogBoundsAdapter.BoundsState r4 = this.$state;
        r2.post(new k(r4));
    }

    public void onStateChanged(View r3, final int r4) {
        Intrinsics.checkNotNullParameter(r3, "bottomSheet");
        this.$state.setCurrentBehaviorState(Integer.valueOf(r4));
        if (r4 != 5) goto L6;
        this.$state.setHidden(true);
        return;
    L6:
        this.$state.setHidden(false);
        final LandscapeChildDialogBoundsAdapter.BoundsState r0 = this.$state;
        r3.post(new j(r0, r4));
    }
}
