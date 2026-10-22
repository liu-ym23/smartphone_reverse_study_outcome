package com.obric.miniapp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.obric.miniapp.databinding.MiniAppFragmentAboutBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/miniapp/view/MiniAppAboutFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/obric/miniapp/databinding/MiniAppFragmentAboutBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onResume", "initView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MiniAppAboutFragment extends Fragment {
    public MiniAppFragmentAboutBinding d;

    public static final class a {
    }

    static {
    }

    public final void onResume() {
        super.onResume();
        MiniAppBaseActivity r0 = getActivity();
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r0 instanceof MiniAppBaseActivity) == false) goto L9;
        r0.W1(true, true);
        return;
    }

    public MiniAppAboutFragment() {
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
    }

    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super.onViewCreated(r7, r8);
        Bundle r9 = getArguments();
        if (r9 == null) goto L5;
        String r10 = r9.getString("appletId");
    L7:
        if (r10 != null) goto L9;
    L12:
        boolean r1 = true;
    L13:
        if (r1 == false) goto L19;
        t19.s.a.g(getContext(), 2131911807, false);
        FragmentActivity r11 = getActivity();
        if (r11 == null) goto L21;
        FragmentManager r12 = r11.getSupportFragmentManager();
        if (r12 == null) goto L22;
        r12.popBackStackImmediate();
        return;
    L22:
        return;
    L21:
        return;
    L19:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new MiniAppAboutFragment$initView$1(r10, this, null), 2, null);
        return;
    L9:
        if (r10.length() == 0) goto L12;
        r1 = false;
        goto L13
    L5:
        r10 = null;
        goto L7
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        View r11 = r8.inflate(2131563654, r9, false);
        int r12 = 2131364679;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(r11, 2131364679);
        if (r2 == null) goto L19;
        r12 = 2131375991;
        ImageView r3 = (ImageView) ViewBindings.findChildViewById(r11, 2131375991);
        if (r3 == null) goto L19;
        r12 = 2131378608;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r11, 2131378608);
        if (r4 == null) goto L19;
        r12 = 2131388807;
        if (ViewBindings.findChildViewById(r11, 2131388807) == null) goto L19;
        r12 = 2131390156;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r11, 2131390156);
        if (r5 == null) goto L19;
        r12 = 2131390158;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r11, 2131390158);
        if (r6 == null) goto L19;
        r12 = 2131391606;
        if (((TextView) ViewBindings.findChildViewById(r11, 2131391606)) == null) goto L19;
        LinearLayout r13 = (LinearLayout) r11;
        this.d = new MiniAppFragmentAboutBinding(r13, r2, r3, r4, r5, r6);
        return r13;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}
