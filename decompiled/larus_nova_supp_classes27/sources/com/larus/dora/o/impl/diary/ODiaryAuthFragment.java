package com.larus.dora.o.impl.diary;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBindings;
import com.larus.dora.o.impl.databinding.DoraOFragmentDiaryAuthBinding;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0002\u0016\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u000fH\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/dora/o/impl/diary/ODiaryAuthFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/larus/dora/o/impl/databinding/DoraOFragmentDiaryAuthBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "openEnvAuth", "mac", "", "applyTopInset", "onDestroyView", "ObricOnboardingArgs", "Companion", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ODiaryAuthFragment extends Fragment {
    public static final /* synthetic */ int e = 0;
    public DoraOFragmentDiaryAuthBinding d;

    public static final class a {
    }

    static {
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d = null;
    }

    public ODiaryAuthFragment() {
    }

    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super.onViewCreated(r6, r7);
        ImageView[] r8 = new ImageView[4];
        DoraOFragmentDiaryAuthBinding r9 = this.d;
        ImageView r0 = null;
        if (r9 == null) goto L5;
        ImageView r1 = r9.d;
    L6:
        boolean r2 = false;
        r8[0] = r1;
        if (r9 == null) goto L9;
        ImageView r3 = r9.e;
    L10:
        r8[1] = r3;
        if (r9 == null) goto L13;
        ImageView r4 = r9.f;
    L14:
        r8[2] = r4;
        if (r9 == null) goto L17;
        r0 = r9.g;
    L17:
        r8[3] = r0;
        Iterator r10 = CollectionsKt.listOf(r8).iterator();
    L19:
        if (r10.hasNext() == false) goto L23;
        ImageView r11 = (ImageView) r10.next();
        if (r11 == null) goto L19;
        r11.setClipToOutline(true);
        goto L19
    L23:
        Bundle r12 = getArguments();
        if (r12 != null) goto L26;
    L28:
        DoraOFragmentDiaryAuthBinding r13 = this.d;
        if (r13 == null) goto L35;
        OFloatingTitleBar r14 = r13.h;
        if (r14 == null) goto L35;
        if (r2 == false) goto L34;
        OFloatingTitleBar.k(r14, new com.larus.dora.o.impl.diary.a(this), 2);
        goto L35
    L34:
        r14.setVisibility(8);
    L35:
        DoraOFragmentDiaryAuthBinding r15 = this.d;
        if (r15 == null) goto L44;
        final LinearLayout r16 = r15.c;
        if (r16 == null) goto L44;
        ConstraintLayout r17 = r15.a;
        if (r17 == null) goto L44;
        Resources r5 = getResources();
        final int r18 = (int) ((56 * WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics()).density) + 0.5f);
        ViewCompat.setOnApplyWindowInsetsListener(r17, new c(r16, r18));
        ViewCompat.requestApplyInsets(r17);
    L44:
        DoraOFragmentDiaryAuthBinding r20 = this.d;
        if (r20 == null) goto L55;
        OButton r21 = r20.b;
        if (r21 == null) goto L56;
        r21.setOnClickListener(new b(this));
        return;
    L56:
        return;
    L55:
        return;
    L26:
        if (r12.getBoolean("dora_o_diary_show_back") != true) goto L28;
        r2 = true;
        goto L28
    L13:
        r4 = null;
        goto L14
    L9:
        r3 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        ConstraintLayout r13 = r10.inflate(2131560142, r11, false);
        int r14 = 2131363540;
        OButton r2 = ViewBindings.findChildViewById(r13, 2131363540);
        if (r2 == null) goto L25;
        r14 = 2131363543;
        if (((ImageView) ViewBindings.findChildViewById(r13, 2131363543)) == null) goto L25;
        r14 = 2131363550;
        LinearLayout r3 = (LinearLayout) ViewBindings.findChildViewById(r13, 2131363550);
        if (r3 == null) goto L25;
        r14 = 2131363554;
        if (((TextView) ViewBindings.findChildViewById(r13, 2131363554)) == null) goto L25;
        r14 = 2131363563;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r13, 2131363563);
        if (r4 == null) goto L25;
        r14 = 2131363564;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r13, 2131363564);
        if (r5 == null) goto L25;
        r14 = 2131363565;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r13, 2131363565);
        if (r6 == null) goto L25;
        r14 = 2131363566;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r13, 2131363566);
        if (r7 == null) goto L25;
        r14 = 2131363570;
        if (((TextView) ViewBindings.findChildViewById(r13, 2131363570)) == null) goto L25;
        r14 = 2131363571;
        OFloatingTitleBar r8 = ViewBindings.findChildViewById(r13, 2131363571);
        if (r8 == null) goto L25;
        ConstraintLayout r15 = r13;
        this.d = new DoraOFragmentDiaryAuthBinding(r15, r2, r3, r4, r5, r6, r7, r8);
        return r15;
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r14)));
    }
}
