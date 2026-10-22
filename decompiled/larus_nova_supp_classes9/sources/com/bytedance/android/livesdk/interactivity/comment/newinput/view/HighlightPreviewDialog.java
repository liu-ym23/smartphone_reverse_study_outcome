package com.bytedance.android.livesdk.interactivity.comment.newinput.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.chatroom.backtrack.HighlightVideoPreviewView;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.MarkHighlightController;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import hd0.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zf1.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/newinput/view/HighlightPreviewDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HighlightPreviewDialog extends DialogFragment {
    public static final /* synthetic */ int h = 0;
    public RelativeLayout d;
    public HighlightVideoPreviewView e;
    public h f;
    public MarkHighlightController.a g;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ HighlightPreviewDialog a;

        public b(HighlightPreviewDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    static {
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        MarkHighlightController.a r0 = this.g;
        if (r0 == null) goto L6;
        r0.onShow();
        return;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L8;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L9;
        r1.setLayout(-1, -1);
        return;
    L9:
        return;
    }

    public HighlightPreviewDialog() {
    }

    public final void onCreate(Bundle r3) {
        setStyle(1, 2131954685);
        super.onCreate(r3);
    }

    public final Dialog onCreateDialog(Bundle r3) {
        Dialog r4 = super.onCreateDialog(r3);
        Window r0 = r4.getWindow();
        if (r0 == null) goto L5;
        r0.setLayout(-1, -1);
    L5:
        return r4;
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L7
        super.onDismiss(r2);     // Catch: Throwable -> L7
        MarkHighlightController.a r3 = this.g;     // Catch: Throwable -> L7
        if (r3 == null) goto L5;
        r3.onDismiss();     // Catch: Throwable -> L7
    L5:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L7:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = LayoutInflater.from(getContext()).inflate(2131566157, r3, false);
        ImageView r6 = null;
        if ((r5 instanceof RelativeLayout) == true) goto L5;
        r5 = null;
    L5:
        this.d = (RelativeLayout) r5;
        MarkHighlightController.a r7 = this.g;
        if (r7 == null) goto L9;
        r7.onShow();
    L9:
        if (c.f().h() == false) goto L11;
        f2.b(2131917351, 0);
    L11:
        RelativeLayout r8 = this.d;
        if (r8 == null) goto L14;
        HighlightVideoPreviewView r9 = (HighlightVideoPreviewView) r8.findViewById(2131382986);
    L15:
        this.e = r9;
        RelativeLayout r10 = this.d;
        if (r10 == null) goto L18;
        r6 = (ImageView) r10.findViewById(2131376031);
    L18:
        if (r6 == null) goto L20;
        r6.setOnClickListener(new b(this));
    L20:
        h r11 = this.f;
        if (r11 == null) goto L26;
        HighlightVideoPreviewView r13 = this.e;
        if (r13 == null) goto L26;
        r13.setPreviewData(r11);
    L26:
        return this.d;
    L14:
        r9 = null;
        goto L15
    }
}
