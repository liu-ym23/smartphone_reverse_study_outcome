package com.larus.common_ui.dialog;

import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/larus/common_ui/dialog/CommonLoadDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "dim", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "show", "activity", "Landroidx/fragment/app/FragmentActivity;", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonLoadDialogFragment extends DialogFragment {
    public static final /* synthetic */ int e = 0;
    public float d;

    public static final class a {
        public a() {
        }
    }

    static {
        new a();
    }

    public CommonLoadDialogFragment() {
        this.d = 0.2f;
    }

    public final void S90(FragmentActivity r3) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        FragmentManager r4 = r3.getSupportFragmentManager();
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, "CommonLoadDialogFragment", r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r4, this, r0) == true) goto L11;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        show(r4, "CommonLoadDialogFragment");
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        Bundle r3 = getArguments();
        if (r3 == null) goto L5;
        float r4 = r3.getFloat("key_dim");
    L6:
        this.d = r4;
        return;
    L5:
        r4 = 0.2f;
        goto L6
    }

    public final Dialog onCreateDialog(Bundle r5) {
        return new l0(requireActivity(), this.d, false, 4);
    }
}
