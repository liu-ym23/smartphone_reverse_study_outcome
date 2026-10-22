package com.obric.assistant.guide.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.guide.IObricUserGuide;
import com.obric.assistant.impl.databinding.ObricGuideForVoiceEnrollBinding;
import com.obric.oui.button.OButton;
import com.obric.oui.checkbox.OCheckBoxLayout;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\tH\u0002J\b\u0010\u0018\u001a\u00020\u0013H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/assistant/guide/ui/VoiceEnrollFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/obric/assistant/impl/databinding/ObricGuideForVoiceEnrollBinding;", "drawable", "Landroid/graphics/drawable/Drawable;", "isObricOS", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "updateViews", "updateRecordButtonEnabled", "enabled", "goToNextView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceEnrollFragment extends Fragment {
    public static final /* synthetic */ int g = 0;
    public ObricGuideForVoiceEnrollBinding d;
    public Drawable e;
    public final boolean f;

    public static final class a {
    }

    static {
    }

    public VoiceEnrollFragment() {
        this.f = t9a.b.a().b();
    }

    public final void S90() {
        UserGuideActivity r0 = getActivity();
        if ((r0 instanceof UserGuideActivity) == false) goto L5;
        UserGuideActivity r1 = r0;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        ViewPager2 r2 = r1.Q1();
        RecyclerView.Adapter r3 = r2.getAdapter();
        if (r3 == null) goto L11;
        int r4 = r3.getItemCount();
    L12:
        int r5 = r2.getCurrentItem();
        FLogger.a.i("VoiceEnrollFragment", "goToNextView, currentPage=" + r5 + ", totalPage=" + r4);
        int r6 = r5 + 1;
        if (r4 != r6) goto L15;
        r1.S1("voice_enroll_next_last_page");
        r1.finish();
        return;
    L15:
        r2.setCurrentItem(r6, true);
        return;
    L11:
        r4 = 0;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r14v24, types: [com.obric.assistant.guide.ui.o0] */
    public final void onViewCreated(View r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r14, "view");
        super.onViewCreated(r14, r15);
        IObricUserGuide r16 = (IObricUserGuide) ServiceManager.get().getService(IObricUserGuide.class);
        if (r16 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r16 != null) goto L10;
    L12:
        boolean r4 = false;
    L13:
        FLogger r5 = FLogger.a;
        StringBuilder r6 = new StringBuilder("onViewCreated, savedInstanceState=");
        if (r15 == null) goto L16;
        boolean r17 = true;
    L17:
        r6.append(r17);
        r6.append(", isObricOS=");
        r6.append(this.f);
        r6.append(", serviceAvailable=");
        if (r16 == null) goto L20;
        boolean r18 = true;
    L21:
        r6.append(r18);
        r6.append(", useSystemDrawable=");
        r6.append(r3);
        r6.append(", isVoicePrintExist=");
        r6.append(r4);
        r5.i("VoiceEnrollFragment", r6.toString());
        if (this.f == true) goto L24;
        this.e = requireContext().getDrawable(2131244435);
    L32:
        FLogger r19 = FLogger.a;
        StringBuilder r0 = new StringBuilder("onViewCreated drawable loaded, drawableAvailable=");
        if (this.e == null) goto L35;
        boolean r7 = true;
    L36:
        r0.append(r7);
        r19.i("VoiceEnrollFragment", r0.toString());
        ObricGuideForVoiceEnrollBinding r110 = this.d;
        if (r110 == null) goto L41;
        ImageView r111 = r110.i;
        if (r111 == null) goto L41;
        r111.setImageDrawable(this.e);
    L41:
        ObricGuideForVoiceEnrollBinding r112 = this.d;
        if (r112 == null) goto L46;
        TextView r113 = r112.k;
        if (r113 == null) goto L46;
        r113.setOnClickListener(new j0(this));
    L46:
        ObricGuideForVoiceEnrollBinding r114 = this.d;
        if (r114 == null) goto L51;
        OButton r115 = r114.e;
        if (r115 == null) goto L51;
        r115.setOnClickListener(new m0(this));
    L51:
        ObricGuideForVoiceEnrollBinding r116 = this.d;
        if (r116 == null) goto L56;
        OButton r117 = r116.d;
        if (r117 == null) goto L56;
        r117.setOnClickListener(new n0(this));
    L56:
        final ?? r118 = new o0(this);
        if (this.f == false) goto L68;
        ObricGuideForVoiceEnrollBinding r119 = this.d;
        if (r119 == null) goto L63;
        OFloatingTitleBar r120 = r119.f;
        if (r120 == null) goto L63;
        OFloatingTitleBar.k(r120, new p0(r118), 2);
    L63:
        ObricGuideForVoiceEnrollBinding r121 = this.d;
        if (r121 == null) goto L107;
        OFloatingTitleBar r122 = r121.f;
        if (r122 == null) goto L107;
        r122.h(2131244127, -1, new q0(this));
    L107:
        ObricGuideForVoiceEnrollBinding r123 = this.d;
        if (r123 == null) goto L112;
        OCheckBoxLayout r124 = r123.c;
        if (r124 == null) goto L112;
        r124.setChecked(false);
    L112:
        ObricGuideForVoiceEnrollBinding r125 = this.d;
        if (r125 == null) goto L117;
        OButton r126 = r125.j;
        if (r126 == null) goto L117;
        r126.setEnabled(true);
        r126.setAlpha(0.3f);
    L117:
        ObricGuideForVoiceEnrollBinding r127 = this.d;
        if (r127 == null) goto L122;
        OCheckBoxLayout r128 = r127.c;
        if (r128 == null) goto L122;
        r128.setOnCheckedChangeListener(new s0(this));
    L122:
        ObricGuideForVoiceEnrollBinding r129 = this.d;
        if (r129 == null) goto L131;
        OButton r130 = r129.j;
        if (r130 == null) goto L132;
        r130.setOnClickListener(new t0(this));
        return;
    L132:
        return;
    L131:
        return;
    L68:
        int r131 = rda.a.a;
        ObricGuideForVoiceEnrollBinding r132 = this.d;
        if (r132 == null) goto L71;
        OFloatingTitleBar r133 = r132.f;
    L72:
        NovaTitleBarEx.b6(rda.a.b(r133), 2131241477, false, null, null, new r0(r118), 14);
        int r134 = getResources().getDimensionPixelSize(v19.c.b(2130971208, null, 2131166786));
        ObricGuideForVoiceEnrollBinding r135 = this.d;
        if (r135 == null) goto L77;
        OButton r136 = r135.j;
        if (r136 == null) goto L77;
        r136.setBackgroundResource(2131244295);
    L77:
        ObricGuideForVoiceEnrollBinding r137 = this.d;
        if (r137 == null) goto L82;
        OButton r138 = r137.j;
        if (r138 == null) goto L82;
        r138.setRadius(r134);
    L82:
        ObricGuideForVoiceEnrollBinding r139 = this.d;
        if (r139 == null) goto L87;
        OButton r140 = r139.j;
        if (r140 == null) goto L87;
        r140.setTextColor(ContextCompat.getColor(requireContext(), 2131102529));
    L87:
        ObricGuideForVoiceEnrollBinding r141 = this.d;
        if (r141 == null) goto L92;
        OButton r142 = r141.e;
        if (r142 == null) goto L92;
        r142.setRadius(r134);
    L92:
        ObricGuideForVoiceEnrollBinding r143 = this.d;
        if (r143 == null) goto L97;
        OButton r144 = r143.d;
        if (r144 == null) goto L97;
        r144.setBackgroundResource(2131244295);
    L97:
        ObricGuideForVoiceEnrollBinding r145 = this.d;
        if (r145 == null) goto L102;
        OButton r146 = r145.d;
        if (r146 == null) goto L102;
        r146.setRadius(r134);
    L102:
        ObricGuideForVoiceEnrollBinding r147 = this.d;
        if (r147 == null) goto L107;
        OButton r148 = r147.d;
        if (r148 == null) goto L107;
        r148.setTextColor(ContextCompat.getColor(requireContext(), 2131102529));
        goto L107
    L71:
        r133 = null;
        goto L72
    L35:
        r7 = false;
        goto L36
    L24:
        if (r3 == true) goto L129;
        this.e = requireContext().getDrawable(2131244436);
        goto L32
    L129:
        Context r149 = requireContext().createPackageContext("com.android.settings", 2);     // Catch: Exception -> L128
        int r1 = r149.getResources().getIdentifier("obric_guide_voice_enroll_n1", "drawable", "com.android.settings");     // Catch: Exception -> L128
        if (r1 == 0) goto L29;
        Configuration r8 = new Configuration(r149.getResources().getConfiguration());     // Catch: Exception -> L128
        r8.uiMode = requireContext().getResources().getConfiguration().uiMode;     // Catch: Exception -> L128
        Context r150 = r149.createConfigurationContext(r8);     // Catch: Exception -> L128
        NewMiraResourcesManager.getInstance().install(r150);     // Catch: Exception -> L128
        Drawable r151 = r150.getDrawable(r1);     // Catch: Exception -> L128
    L30:
        this.e = r151;
    L29:
        r151 = null;
        goto L30
    L20:
        r18 = false;
        goto L21
    L16:
        r17 = false;
        goto L17
    L10:
        if (r16.j() != true) goto L12;
        r4 = true;
        goto L13
    L5:
        if (r16.h() != true) goto L7;
        r3 = true;
        goto L8
    }

    public final View onCreateView(LayoutInflater r13, ViewGroup r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r13, "inflater");
        ConstraintLayout r16 = r13.inflate(2131564018, r14, false);
        int r17 = 2131362543;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r16, 2131362543);
        if (r2 == null) goto L35;
        r17 = 2131365658;
        OCheckBoxLayout r3 = (OCheckBoxLayout) ViewBindings.findChildViewById(r16, 2131365658);
        if (r3 == null) goto L35;
        r17 = 2131373138;
        if (ViewBindings.findChildViewById(r16, 2131373138) == null) goto L35;
        r17 = 2131374360;
        if (ViewBindings.findChildViewById(r16, 2131374360) == null) goto L35;
        r17 = 2131380090;
        if (ViewBindings.findChildViewById(r16, 2131380090) == null) goto L35;
        r17 = 2131380894;
        OButton r4 = (OButton) ViewBindings.findChildViewById(r16, 2131380894);
        if (r4 == null) goto L35;
        r17 = 2131386025;
        OButton r5 = (OButton) ViewBindings.findChildViewById(r16, 2131386025);
        if (r5 == null) goto L35;
        r17 = 2131388807;
        OFloatingTitleBar r6 = ViewBindings.findChildViewById(r16, 2131388807);
        if (r6 == null) goto L35;
        r17 = 2131389245;
        if (ViewBindings.findChildViewById(r16, 2131389245) == null) goto L35;
        r17 = 2131392716;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r16, 2131392716);
        if (r7 == null) goto L35;
        r17 = 2131392717;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r16, 2131392717);
        if (r8 == null) goto L35;
        r17 = 2131392718;
        ImageView r9 = (ImageView) ViewBindings.findChildViewById(r16, 2131392718);
        if (r9 == null) goto L35;
        r17 = 2131392719;
        OButton r10 = (OButton) ViewBindings.findChildViewById(r16, 2131392719);
        if (r10 == null) goto L35;
        r17 = 2131392775;
        if (((TextView) ViewBindings.findChildViewById(r16, 2131392775)) == null) goto L35;
        r17 = 2131392776;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r16, 2131392776);
        if (r11 == null) goto L35;
        ConstraintLayout r18 = r16;
        this.d = new ObricGuideForVoiceEnrollBinding(r18, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
        return r18;
    L35:
        throw new NullPointerException("Missing required view with ID: ".concat(r16.getResources().getResourceName(r17)));
    }
}
