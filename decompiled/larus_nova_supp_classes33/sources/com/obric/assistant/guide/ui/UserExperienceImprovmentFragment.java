package com.obric.assistant.guide.ui;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.obric.assistant.impl.databinding.ObricGuideForExperienceImproveBinding;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0011H\u0002J\b\u0010\u0016\u001a\u00020\u0011H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/guide/ui/UserExperienceImprovmentFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/obric/assistant/impl/databinding/ObricGuideForExperienceImproveBinding;", "isObricOS", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "bindDescription", "bindTitleBar", "goToNextView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserExperienceImprovmentFragment extends Fragment {
    public static final /* synthetic */ int f = 0;
    public ObricGuideForExperienceImproveBinding d;
    public final boolean e;

    public static final class a {
    }

    static {
    }

    public final void onDestroyView() {
        this.d = null;
        super.onDestroyView();
    }

    public UserExperienceImprovmentFragment() {
        this.e = t9a.b.a().b();
    }

    /* JADX WARN: Type inference failed for: r9v2, types: [com.obric.assistant.guide.ui.c0] */
    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super.onViewCreated(r9, r10);
        ObricGuideForExperienceImproveBinding r11 = this.d;
        if (r11 == null) goto L7;
        TextView r12 = r11.b;
        if (r12 == null) goto L7;
        r12.setText(com.obric.assistant.settings.experience.a.a(r12.getContext(), 2131912682, 2131103863));
        r12.setMovementMethod(LinkMovementMethod.getInstance());
        r12.setHighlightColor(0);
    L7:
        final ?? r13 = new c0(this);
        if (this.e == false) goto L19;
        ObricGuideForExperienceImproveBinding r14 = this.d;
        if (r14 == null) goto L14;
        OFloatingTitleBar r15 = r14.e;
        if (r15 == null) goto L14;
        OFloatingTitleBar.k(r15, new d0(r13), 2);
    L14:
        ObricGuideForExperienceImproveBinding r16 = this.d;
        if (r16 == null) goto L33;
        OFloatingTitleBar r17 = r16.e;
        if (r17 == null) goto L33;
        View.OnClickListener r18 = new e0(this);
        Token$Bounce r0 = OFloatingTitleBar.H0;
        r17.h(2131244127, -1, r18);
    L33:
        ObricGuideForExperienceImproveBinding r19 = this.d;
        if (r19 == null) goto L38;
        OButton r20 = r19.c;
        if (r20 == null) goto L38;
        r20.setOnClickListener(new a0(this));
    L38:
        ObricGuideForExperienceImproveBinding r21 = this.d;
        if (r21 == null) goto L44;
        OButton r22 = r21.d;
        if (r22 == null) goto L45;
        r22.setOnClickListener(new b0(this));
        return;
    L45:
        return;
    L44:
        return;
    L19:
        int r110 = rda.a.a;
        ObricGuideForExperienceImproveBinding r111 = this.d;
        if (r111 == null) goto L22;
        OFloatingTitleBar r112 = r111.e;
    L23:
        NovaTitleBarEx.b6(rda.a.b(r112), 2131241477, false, null, null, new f0(r13), 14);
        int r23 = getResources().getDimensionPixelSize(v19.c.b(2130971208, null, 2131166786));
        ObricGuideForExperienceImproveBinding r113 = this.d;
        if (r113 == null) goto L28;
        OButton r114 = r113.c;
        if (r114 == null) goto L28;
        r114.setBackgroundResource(2131244295);
        r114.setRadius(r23);
        r114.setTextColor(ContextCompat.getColor(r114.getContext(), v19.c.b(2130970529, r114.getContext(), 2131102529)));
    L28:
        ObricGuideForExperienceImproveBinding r115 = this.d;
        if (r115 == null) goto L33;
        OButton r116 = r115.d;
        if (r116 == null) goto L33;
        r116.setRadius(r23);
        goto L33
    L22:
        r112 = null;
        goto L23
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        ConstraintLayout r11 = r8.inflate(2131564015, r9, false);
        int r12 = 2131371915;
        if (((ImageView) ViewBindings.findChildViewById(r11, 2131371915)) == null) goto L31;
        r12 = 2131371917;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r11, 2131371917);
        if (r2 == null) goto L31;
        r12 = 2131371919;
        if (ViewBindings.findChildViewById(r11, 2131371919) == null) goto L31;
        r12 = 2131371920;
        if (ViewBindings.findChildViewById(r11, 2131371920) == null) goto L31;
        r12 = 2131371921;
        if (((LinearLayout) ViewBindings.findChildViewById(r11, 2131371921)) == null) goto L31;
        r12 = 2131371922;
        if (((ImageView) ViewBindings.findChildViewById(r11, 2131371922)) == null) goto L31;
        r12 = 2131371923;
        if (ViewBindings.findChildViewById(r11, 2131371923) == null) goto L31;
        r12 = 2131371924;
        OButton r3 = (OButton) ViewBindings.findChildViewById(r11, 2131371924);
        if (r3 == null) goto L31;
        r12 = 2131371925;
        OButton r4 = (OButton) ViewBindings.findChildViewById(r11, 2131371925);
        if (r4 == null) goto L31;
        r12 = 2131371927;
        if (((TextView) ViewBindings.findChildViewById(r11, 2131371927)) == null) goto L31;
        r12 = 2131371929;
        if (((TextView) ViewBindings.findChildViewById(r11, 2131371929)) == null) goto L31;
        r12 = 2131371930;
        OFloatingTitleBar r5 = ViewBindings.findChildViewById(r11, 2131371930);
        if (r5 == null) goto L31;
        r12 = 2131371931;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r11, 2131371931);
        if (r6 == null) goto L31;
        ConstraintLayout r13 = r11;
        this.d = new ObricGuideForExperienceImproveBinding(r13, r2, r3, r4, r5, r6);
        return r13;
    L31:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}
