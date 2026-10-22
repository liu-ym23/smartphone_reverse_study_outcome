package com.larus.doc.impl.download;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.crash.d;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.doc.biz.impl.databinding.LarusBottomChooseDownloadTypeDialogBinding;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import k39.b;
import k39.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J&\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/doc/impl/download/DownloadTypeChooseDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/doc/biz/impl/databinding/LarusBottomChooseDownloadTypeDialogBinding;", "getTheme", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DownloadTypeChooseDialog extends BottomSheetDialogFragment {
    public static final /* synthetic */ int e = 0;
    public LarusBottomChooseDownloadTypeDialogBinding d;

    public static final class a {
    }

    static {
    }

    public final int getTheme() {
        return 2131954335;
    }

    public DownloadTypeChooseDialog() {
    }

    public static void S90(DownloadTypeChooseDialog r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r2, r3);
        Bundle r4 = getArguments();
        boolean r5 = true;
        if (r4 == null) goto L5;
        r5 = r4.getBoolean("arg_has_audio", true);
    L5:
        LarusBottomChooseDownloadTypeDialogBinding r6 = this.d;
        if (r6 == null) goto L12;
        if (r5 == false) goto L9;
        r6.c.setVisibility(0);
    L10:
        e1.d(r6.d, new k39.a(this));
        e1.d(r6.e, new b(this));
        e1.d(r6.c, new c(this));
        e1.d(r6.b, new k39.d(this));
        return;
    L9:
        r6.c.setVisibility(8);
        goto L10
    }

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        View r10 = r7.inflate(2131561850, r8, false);
        int r11 = 2131364431;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r10, 2131364431);
        if (r2 == null) goto L13;
        r11 = 2131383994;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r10, 2131383994);
        if (r3 == null) goto L13;
        r11 = 2131383995;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r10, 2131383995);
        if (r4 == null) goto L13;
        r11 = 2131383996;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r10, 2131383996);
        if (r5 == null) goto L13;
        LinearLayout r12 = (LinearLayout) r10;
        this.d = new LarusBottomChooseDownloadTypeDialogBinding(r12, r2, r3, r4, r5);
        return r12;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }
}
