package com.larus.dora.impl.noti_v3.invalid_help.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.dora.impl.databinding.LarusDoraPageNotiV3InvalidHelpBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.view.DoraNovaTitleBarEx;
import com.larus.utils.j0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/dora/impl/noti_v3/invalid_help/ui/NotificationBroadcastV3InvalidHelpFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageNotiV3InvalidHelpBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "getCurrentPageName", "", "getPageMaskView", "setupTitle", "Lcom/larus/dora/impl/view/DoraNovaTitleBarEx;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NotificationBroadcastV3InvalidHelpFragment extends DoraBaseFragment {
    public static final /* synthetic */ int g = 0;
    public LarusDoraPageNotiV3InvalidHelpBinding f;

    public static final class a {
    }

    static {
    }

    public final String k() {
        return "dora_broadcast_invalid_help";
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        LarusDoraPageNotiV3InvalidHelpBinding r0 = this.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b;
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.f = null;
    }

    public NotificationBroadcastV3InvalidHelpFragment() {
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r2, r3);
        LarusDoraPageNotiV3InvalidHelpBinding r4 = this.f;
        if (r4 == null) goto L6;
        DoraNovaTitleBarEx r5 = r4.c;
        int r6 = j0.a;
        DoraNovaTitleBarEx.S5(r5, j0.d(2131902330));
        DoraNovaTitleBarEx.T5(r5, new r59.a(this));
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        ConstraintLayout r5 = r2.inflate(2131562276, r3, false);
        int r6 = 2131369962;
        View r7 = ViewBindings.findChildViewById(r5, 2131369962);
        if (r7 == null) goto L11;
        r6 = 2131385238;
        if (((ScrollView) ViewBindings.findChildViewById(r5, 2131385238)) == null) goto L11;
        r6 = 2131388772;
        DoraNovaTitleBarEx r0 = (DoraNovaTitleBarEx) ViewBindings.findChildViewById(r5, 2131388772);
        if (r0 == null) goto L11;
        ConstraintLayout r8 = r5;
        this.f = new LarusDoraPageNotiV3InvalidHelpBinding(r8, r7, r0);
        return r8;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
