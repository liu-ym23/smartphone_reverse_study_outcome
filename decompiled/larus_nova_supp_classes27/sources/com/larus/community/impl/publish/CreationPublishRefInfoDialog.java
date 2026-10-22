package com.larus.community.impl.publish;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.community.impl.databinding.LarusCommunityDialogPublishRefInfoBinding;
import com.larus.utils.e1;
import com.larus.utils.w0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J&\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0011H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/larus/community/impl/publish/CreationPublishRefInfoDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/community/impl/databinding/LarusCommunityDialogPublishRefInfoBinding;", "getTheme", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initView", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationPublishRefInfoDialog extends BottomSheetDialogFragment {
    public static final /* synthetic */ int e = 0;
    public LarusCommunityDialogPublishRefInfoBinding d;

    public static final class a {
    }

    static {
    }

    public final int getTheme() {
        return 2131954335;
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        this.d = null;
    }

    public CreationPublishRefInfoDialog() {
    }

    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r5, r6);
        LarusCommunityDialogPublishRefInfoBinding r7 = this.d;
        if (r7 == null) goto L10;
        e1.d(r7.b, new m(this));
        int r8 = w0.a;
        Context r9 = getContext();
        if (r9 == null) goto L7;
        Integer r10 = Integer.valueOf(ContextCompat.getColor(r9, v19.c.b(2130972123, r9, 2131103203)));
    L8:
        r7.c.setBackground(w0.b(r10, Float.valueOf(i5.q()), 0.0f, null, 4));
        e1.d(r7.c, new n(this));
        r7.f.setText(2131899480);
        r7.d.setText(2131899479);
        return;
    L7:
        r10 = null;
        goto L8
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        View r11 = r8.inflate(2131561969, r9, false);
        int r12 = 2131366984;
        AppCompatImageView r2 = ViewBindings.findChildViewById(r11, 2131366984);
        if (r2 == null) goto L18;
        r12 = 2131367655;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r11, 2131367655);
        if (r3 == null) goto L18;
        r12 = 2131367754;
        if (ViewBindings.findChildViewById(r11, 2131367754) == null) goto L18;
        r12 = 2131367862;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r11, 2131367862);
        if (r4 == null) goto L18;
        r12 = 2131374808;
        if (ViewBindings.findChildViewById(r11, 2131374808) == null) goto L18;
        FrameLayout r13 = (FrameLayout) r11;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r11, 2131388924);
        if (r6 == null) goto L16;
        this.d = new LarusCommunityDialogPublishRefInfoBinding(r13, r2, r3, r4, r13, r6);
        return r13;
    L16:
        r12 = 2131388924;
    L18:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}
