package com.larus.common_ui.dialog;

import android.os.Bundle;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0016J\u001e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00142\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\u001bH\u0014J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u001d\u001a\u00020\u0012H\u0002J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0004R\u0014\u0010\u0004\u001a\u00020\u00058UX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058UX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\r8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/larus/common_ui/dialog/RoundedBottomSheetDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "roundedBottomSheetThemeRes", "", "getRoundedBottomSheetThemeRes", "()I", "roundedBottomSheetBackgroundRes", "getRoundedBottomSheetBackgroundRes", "roundedBottomSheetTopCornerRadius", "getRoundedBottomSheetTopCornerRadius", "shouldApplyRoundedBackgroundToContentView", "", "getShouldApplyRoundedBackgroundToContentView", "()Z", "getTheme", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onRoundedBottomSheetReady", "bottomSheet", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "setupRoundedContentView", "setupRoundedBottomSheet", "clipViewTopCornerRadius", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class RoundedBottomSheetDialogFragment extends BottomSheetDialogFragment {
    public int S90() {
        return 2131239551;
    }

    public int T90() {
        return 2131954363;
    }

    public void V90(View r2, BottomSheetBehavior<View> r3) {
        Intrinsics.checkNotNullParameter(r2, "bottomSheet");
        Intrinsics.checkNotNullParameter(r3, "behavior");
    }

    public int U90() {
        return i5.q();
    }

    public final int getTheme() {
        return T90();
    }

    public void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        BottomSheetDialog r0 = getDialog();
        if ((r0 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r1 = r0;
    L6:
        if (r1 == null) goto L11;
        View r2 = r1.findViewById(2131368870);
        if (r2 == null) goto L12;
        ViewCompat.setBackgroundTintList(r2, null);
        r2.setBackgroundResource(S90());
        Intrinsics.checkNotNullParameter(r2, "view");
        r2.setOutlineProvider(new d1(U90()));
        r2.setClipToOutline(true);
        V90(r2, BottomSheetBehavior.from(r2));
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public RoundedBottomSheetDialogFragment() {
    }

    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r2, r3);
        r2.setBackgroundResource(S90());
        Intrinsics.checkNotNullParameter(r2, "view");
        r2.setOutlineProvider(new d1(U90()));
        r2.setClipToOutline(true);
    }
}
