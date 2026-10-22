package com.larus.dora.impl.feedback;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.dora.impl.databinding.DoraHowConversationLinkFragmentBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/larus/dora/impl/feedback/DoraGHowConversationLinkFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "_binding", "Lcom/larus/dora/impl/databinding/DoraHowConversationLinkFragmentBinding;", "binding", "getBinding", "()Lcom/larus/dora/impl/databinding/DoraHowConversationLinkFragmentBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "getCurrentPageName", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraGHowConversationLinkFragment extends DoraBaseFragment {
    public static final /* synthetic */ int g = 0;
    public DoraHowConversationLinkFragmentBinding f;

    public static final class a {
    }

    static {
    }

    public final String k() {
        return "how_to_get_conversation_link";
    }

    public DoraGHowConversationLinkFragment() {
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        DoraHowConversationLinkFragmentBinding r10 = this.f;
        Intrinsics.checkNotNull(r10);
        NovaTitleBarEx r0 = r10.c;
        int r11 = com.larus.utils.j0.a;
        NovaTitleBarEx.Y5(r0, com.larus.utils.j0.d(2131902721), null, null, 6);
        NovaTitleBarEx.b6(r0, 2131240517, false, null, null, new n0(this), 14);
        DoraHowConversationLinkFragmentBinding r12 = this.f;
        Intrinsics.checkNotNull(r12);
        r12.e.setText(com.larus.utils.j0.d(2131902750));
        DoraHowConversationLinkFragmentBinding r13 = this.f;
        Intrinsics.checkNotNull(r13);
        r13.d.setText(com.larus.utils.j0.d(2131902751));
        DoraHowConversationLinkFragmentBinding r14 = this.f;
        Intrinsics.checkNotNull(r14);
        e1.d(r14.b, new o0(this));
    }

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        ConstraintLayout r10 = r7.inflate(2131560135, r8, false);
        int r11 = 2131364401;
        if (((LinearLayout) ViewBindings.findChildViewById(r10, 2131364401)) == null) goto L17;
        r11 = 2131364736;
        DoraTextView r2 = (DoraTextView) ViewBindings.findChildViewById(r10, 2131364736);
        if (r2 == null) goto L17;
        r11 = 2131385238;
        if (((ScrollView) ViewBindings.findChildViewById(r10, 2131385238)) == null) goto L17;
        r11 = 2131388772;
        NovaTitleBarEx r3 = ViewBindings.findChildViewById(r10, 2131388772);
        if (r3 == null) goto L17;
        r11 = 2131390406;
        DoraTextView r4 = (DoraTextView) ViewBindings.findChildViewById(r10, 2131390406);
        if (r4 == null) goto L17;
        r11 = 2131391416;
        DoraTextView r5 = (DoraTextView) ViewBindings.findChildViewById(r10, 2131391416);
        if (r5 == null) goto L17;
        ConstraintLayout r12 = r10;
        DoraHowConversationLinkFragmentBinding r13 = new DoraHowConversationLinkFragmentBinding(r12, r2, r3, r4, r5);
        this.f = r13;
        Intrinsics.checkNotNull(r13);
        return r12;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }
}
