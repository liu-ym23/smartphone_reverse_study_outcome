package com.obric.assistant.privacy.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.obric.assistant.privacy.impl.databinding.ObricFragmentStopAssistantServiceBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/assistant/privacy/activity/StopAssistantServiceFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/obric/assistant/privacy/impl/databinding/ObricFragmentStopAssistantServiceBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onViewCreated", "view", "setupTitle", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StopAssistantServiceFragment extends Fragment {
    public static final /* synthetic */ int e = 0;
    public ObricFragmentStopAssistantServiceBinding d;

    public final void onDestroyView() {
        super.onDestroyView();
        this.d = null;
    }

    public StopAssistantServiceFragment() {
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        ObricFragmentStopAssistantServiceBinding r10 = this.d;
        if (r10 == null) goto L5;
        NovaTitleBarEx r0 = r10.c;
        NovaTitleBarEx.Y5(r0, r0.getContext().getResources().getString(2131914186), null, null, 6);
        NovaTitleBarEx.b6(r0, 2131241477, false, null, null, new k(this), 14);
    L5:
        ObricFragmentStopAssistantServiceBinding r11 = this.d;
        if (r11 == null) goto L9;
        Intrinsics.checkNotNull(r11);
        r11.b.setOnClickListener(new j());
        return;
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        ConstraintLayout r7 = r4.inflate(2131564009, r5, false);
        int r8 = 2131368861;
        if (((TextView) ViewBindings.findChildViewById(r7, 2131368861)) == null) goto L24;
        r8 = 2131368862;
        if (((TextView) ViewBindings.findChildViewById(r7, 2131368862)) == null) goto L24;
        r8 = 2131368863;
        if (((TextView) ViewBindings.findChildViewById(r7, 2131368863)) == null) goto L24;
        r8 = 2131368864;
        if (((TextView) ViewBindings.findChildViewById(r7, 2131368864)) == null) goto L24;
        r8 = 2131368865;
        if (((TextView) ViewBindings.findChildViewById(r7, 2131368865)) == null) goto L24;
        ConstraintLayout r9 = r7;
        RoundConstraintLayout r0 = ViewBindings.findChildViewById(r7, 2131387367);
        if (r0 == null) goto L22;
        NovaTitleBarEx r1 = ViewBindings.findChildViewById(r7, 2131388772);
        if (r1 != null) goto L17;
        r8 = 2131388772;
        goto L24
    L17:
        if (((TextView) ViewBindings.findChildViewById(r7, 2131388918)) == null) goto L20;
        this.d = new ObricFragmentStopAssistantServiceBinding(r9, r0, r1);
        return r9;
    L20:
        r8 = 2131388918;
        goto L24
    L22:
        r8 = 2131387367;
    L24:
        throw new NullPointerException("Missing required view with ID: ".concat(r7.getResources().getResourceName(r8)));
    }
}
