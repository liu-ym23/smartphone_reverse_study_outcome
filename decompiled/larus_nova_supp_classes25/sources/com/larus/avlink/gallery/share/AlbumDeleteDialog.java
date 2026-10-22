package com.larus.avlink.gallery.share;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.viewbinding.ViewBindings;
import com.bytedance.crash.d;
import com.larus.avlink.impl.databinding.LarusFragmentAlbumDeleteDialogBinding;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;
import v98.b;
import v98.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/larus/avlink/gallery/share/AlbumDeleteDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/larus/avlink/impl/databinding/LarusFragmentAlbumDeleteDialogBinding;", "albumDeleteClickListener", "Lcom/larus/avlink/gallery/share/AlbumDeleteDialog$AlbumDeleteClickListener;", "getAlbumDeleteClickListener", "()Lcom/larus/avlink/gallery/share/AlbumDeleteDialog$AlbumDeleteClickListener;", "setAlbumDeleteClickListener", "(Lcom/larus/avlink/gallery/share/AlbumDeleteDialog$AlbumDeleteClickListener;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onStart", "AlbumDeleteClickListener", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class AlbumDeleteDialog extends DialogFragment {
    public LarusFragmentAlbumDeleteDialogBinding d;
    public a e;

    public interface a {
        void a();

        void b();

        void onCancelClick();
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L8;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L9;
        r1.setBackgroundDrawable(null);
        r1.setLayout(c7.b(313), -2);
        return;
    L9:
        return;
    }

    public AlbumDeleteDialog() {
    }

    public static void S90(AlbumDeleteDialog r1) {
        r1.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r2, r3);
        LarusFragmentAlbumDeleteDialogBinding r4 = this.d;
        if (r4 == null) goto L7;
        TextView r5 = r4.c;
        if (r5 == null) goto L7;
        r5.setOnClickListener(new v98.a(this));
    L7:
        LarusFragmentAlbumDeleteDialogBinding r6 = this.d;
        if (r6 == null) goto L12;
        TextView r7 = r6.b;
        if (r7 == null) goto L12;
        r7.setOnClickListener(new b(this));
    L12:
        LarusFragmentAlbumDeleteDialogBinding r8 = this.d;
        if (r8 == null) goto L18;
        TextView r9 = r8.d;
        if (r9 == null) goto L19;
        r9.setOnClickListener(new c(this));
        return;
    L19:
        return;
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        View r7 = r4.inflate(2131562349, r5, false);
        int r8 = 2131362453;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r7, 2131362453);
        if (r9 == null) goto L15;
        r8 = 2131362454;
        TextView r0 = (TextView) ViewBindings.findChildViewById(r7, 2131362454);
        if (r0 == null) goto L15;
        r8 = 2131362455;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r7, 2131362455);
        if (r1 == null) goto L15;
        r8 = 2131362456;
        if (((TextView) ViewBindings.findChildViewById(r7, 2131362456)) == null) goto L15;
        r8 = 2131362457;
        if (((TextView) ViewBindings.findChildViewById(r7, 2131362457)) == null) goto L15;
        LinearLayout r10 = (LinearLayout) r7;
        this.d = new LarusFragmentAlbumDeleteDialogBinding(r10, r9, r0, r1);
        return r10;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r7.getResources().getResourceName(r8)));
    }
}
