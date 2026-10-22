package com.obric.assistant.guide.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.guide.IObricUserGuide;
import com.obric.assistant.impl.databinding.ObricGuideForAiKeyBinding;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.oui.button.OButton;
import com.obric.oui.checkbox.OCheckBoxLayout;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0017J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\tH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/guide/ui/AiKeyFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/obric/assistant/impl/databinding/ObricGuideForAiKeyBinding;", "drawable", "Landroid/graphics/drawable/Drawable;", "isObricOS", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "updateNextStepText", "isEnableAssistChecked", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AiKeyFragment extends Fragment {
    public static final /* synthetic */ int g = 0;
    public ObricGuideForAiKeyBinding d;
    public Drawable e;
    public final boolean f;

    public static final class a {
    }

    static {
    }

    public AiKeyFragment() {
        this.f = t9a.b.a().b();
    }

    public final void S90(boolean r3) {
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        ObricGuideForAiKeyBinding r1 = this.d;
        if (r1 == null) goto L14;
        OButton r2 = r1.h;
        if (r2 == null) goto L15;
        if (r3 == false) goto L11;
        int r4 = 2131912051;
    L12:
        r2.setText(r0.getString(r4));
        return;
    L11:
        r4 = 2131912074;
        goto L12
    L15:
        return;
    }

    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super.onViewCreated(r9, r10);
        IObricUserGuide r11 = (IObricUserGuide) ServiceManager.get().getService(IObricUserGuide.class);
        boolean r1 = true;
        if (r11 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        FLogger r4 = FLogger.a;
        StringBuilder r5 = new StringBuilder("onViewCreated, savedInstanceState=");
        if (r10 == null) goto L11;
        boolean r12 = true;
    L12:
        r5.append(r12);
        r5.append(", isObricOS=");
        r5.append(this.f);
        r5.append(", serviceAvailable=");
        if (r11 == null) goto L15;
        boolean r13 = true;
    L16:
        r5.append(r13);
        r5.append(", useSystemDrawable=");
        r5.append(r3);
        r4.i("AiKeyFragment", r5.toString());
        if (this.f == true) goto L34;
        ObricGuideForAiKeyBinding r14 = this.d;
        if (r14 == null) goto L23;
        TextView r15 = r14.c;
        if (r15 == null) goto L23;
        r15.setText(2131912608);
    L23:
        ObricGuideForAiKeyBinding r16 = this.d;
        if (r16 == null) goto L28;
        TextView r17 = r16.e;
        if (r17 == null) goto L28;
        r17.setText(2131912085);
    L28:
        ObricGuideForAiKeyBinding r18 = this.d;
        if (r18 == null) goto L33;
        TextView r19 = r18.g;
        if (r19 == null) goto L33;
        r19.setVisibility(8);
    L33:
        this.e = requireContext().getDrawable(2131244430);
    L42:
        FLogger r20 = FLogger.a;
        StringBuilder r0 = new StringBuilder("onViewCreated drawable loaded, drawableAvailable=");
        if (this.e == null) goto L45;
        boolean r6 = true;
    L46:
        r0.append(r6);
        r20.i("AiKeyFragment", r0.toString());
        ObricGuideForAiKeyBinding r21 = this.d;
        if (r21 == null) goto L52;
        ImageView r22 = r21.b;
        if (r22 == null) goto L52;
        r22.setImageDrawable(this.e);
    L52:
        if (Build.VERSION.SDK_INT < 30) goto L58;
        com.obric.assistant.common.utils.m.a.getClass();
        if (com.obric.assistant.common.utils.m.a() == false) goto L58;
        if (com.obric.assistant.utils.j.c(requireContext()) == true) goto L58;
        final boolean r23 = true;
    L59:
        if (r23 == false) goto L93;
        ObricGuideForAiKeyBinding r110 = this.d;
        if (r110 == null) goto L65;
        TextView r111 = r110.g;
        if (r111 == null) goto L65;
        r111.setVisibility(8);
    L65:
        ObricGuideForAiKeyBinding r112 = this.d;
        if (r112 == null) goto L70;
        ConstraintLayout r113 = r112.i;
        if (r113 == null) goto L70;
        r113.setVisibility(0);
    L70:
        ObricGuideForAiKeyBinding r114 = this.d;
        if (r114 == null) goto L75;
        TextView r115 = r114.f;
        if (r115 == null) goto L75;
        r115.setText(getString(2131912086));
    L75:
        ObricGuideForAiKeyBinding r116 = this.d;
        if (r116 == null) goto L80;
        OCheckBoxLayout r117 = r116.d;
        if (r117 == null) goto L80;
        r117.setChecked(true);
    L80:
        ObricGuideForAiKeyBinding r118 = this.d;
        if (r118 == null) goto L87;
        OCheckBoxLayout r119 = r118.d;
        if (r119 == null) goto L87;
        if (r119.isChecked() != true) goto L87;
    L88:
        S90(r1);
        ObricGuideForAiKeyBinding r120 = this.d;
        if (r120 == null) goto L93;
        OCheckBoxLayout r121 = r120.d;
        if (r121 == null) goto L93;
        r121.setOnCheckedChangeListener(new com.obric.assistant.guide.ui.a(this));
    L87:
        r1 = false;
    L93:
        ObricGuideForAiKeyBinding r122 = this.d;
        if (r122 == null) goto L99;
        OButton r123 = r122.h;
        if (r123 == null) goto L99;
        r123.setOnClickListener(new b(this, r23));
    L99:
        if (this.f == false) goto L105;
        ObricGuideForAiKeyBinding r24 = this.d;
        if (r24 == null) goto L124;
        OFloatingTitleBar r25 = r24.j;
        if (r25 == null) goto L125;
        View.OnClickListener r124 = new c(this);
        Token$Bounce r2 = OFloatingTitleBar.H0;
        r25.h(2131244127, -1, r124);
        return;
    L125:
        return;
    L124:
        return;
    L105:
        int r26 = getResources().getDimensionPixelSize(v19.c.b(2130971208, null, 2131166786));
        ObricGuideForAiKeyBinding r125 = this.d;
        if (r125 == null) goto L110;
        OButton r126 = r125.h;
        if (r126 == null) goto L110;
        r126.setBackgroundResource(2131244295);
    L110:
        ObricGuideForAiKeyBinding r127 = this.d;
        if (r127 == null) goto L115;
        OButton r128 = r127.h;
        if (r128 == null) goto L115;
        r128.setRadius(r26);
    L115:
        ObricGuideForAiKeyBinding r27 = this.d;
        if (r27 == null) goto L127;
        OButton r28 = r27.h;
        if (r28 == null) goto L128;
        r28.setTextColor(ContextCompat.getColor(requireContext(), 2131102529));
        return;
    L128:
        return;
    L127:
        return;
    L58:
        r23 = false;
        goto L59
    L45:
        r6 = false;
        goto L46
    L34:
        if (r3 == true) goto L122;
        this.e = requireContext().getDrawable(2131244431);
        goto L42
    L122:
        Context r29 = requireContext().createPackageContext("com.android.settings", 2);     // Catch: Exception -> L121
        int r7 = r29.getResources().getIdentifier("obric_guide_ai_key_n1", "drawable", "com.android.settings");     // Catch: Exception -> L121
        if (r7 == 0) goto L39;
        Configuration r8 = new Configuration(r29.getResources().getConfiguration());     // Catch: Exception -> L121
        r8.uiMode = requireContext().getResources().getConfiguration().uiMode;     // Catch: Exception -> L121
        Context r30 = r29.createConfigurationContext(r8);     // Catch: Exception -> L121
        NewMiraResourcesManager.getInstance().install(r30);     // Catch: Exception -> L121
        Drawable r31 = r30.getDrawable(r7);     // Catch: Exception -> L121
    L40:
        this.e = r31;
    L39:
        r31 = null;
        goto L40
    L15:
        r13 = false;
        goto L16
    L11:
        r12 = false;
        goto L12
    L5:
        if (r11.h() != true) goto L7;
        r3 = true;
        goto L8
    }

    public final View onCreateView(LayoutInflater r12, ViewGroup r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r12, "inflater");
        ConstraintLayout r15 = r12.inflate(2131564014, r13, false);
        int r16 = 2131362407;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(r15, 2131362407);
        if (r2 == null) goto L29;
        r16 = 2131363102;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r15, 2131363102);
        if (r3 == null) goto L29;
        r16 = 2131365643;
        OCheckBoxLayout r4 = (OCheckBoxLayout) ViewBindings.findChildViewById(r15, 2131365643);
        if (r4 == null) goto L29;
        r16 = 2131371612;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r15, 2131371612);
        if (r5 == null) goto L29;
        r16 = 2131371613;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r15, 2131371613);
        if (r6 == null) goto L29;
        r16 = 2131373138;
        if (ViewBindings.findChildViewById(r15, 2131373138) == null) goto L29;
        r16 = 2131374360;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r15, 2131374360);
        if (r7 == null) goto L29;
        r16 = 2131380090;
        if (ViewBindings.findChildViewById(r15, 2131380090) == null) goto L29;
        r16 = 2131380894;
        OButton r8 = (OButton) ViewBindings.findChildViewById(r15, 2131380894);
        if (r8 == null) goto L29;
        r16 = 2131385954;
        ConstraintLayout r9 = ViewBindings.findChildViewById(r15, 2131385954);
        if (r9 == null) goto L29;
        r16 = 2131388807;
        OFloatingTitleBar r10 = ViewBindings.findChildViewById(r15, 2131388807);
        if (r10 == null) goto L29;
        r16 = 2131389245;
        if (ViewBindings.findChildViewById(r15, 2131389245) == null) goto L29;
        ConstraintLayout r17 = r15;
        this.d = new ObricGuideForAiKeyBinding(r17, r2, r3, r4, r5, r6, r7, r8, r9, r10);
        return r17;
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r15.getResources().getResourceName(r16)));
    }
}
