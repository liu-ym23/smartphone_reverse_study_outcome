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
import com.obric.assistant.impl.databinding.ObricGuideForFingerprintBinding;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.oui.button.OButton;
import com.obric.oui.checkbox.OCheckBoxLayout;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0015H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/assistant/guide/ui/FingerPrintFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/obric/assistant/impl/databinding/ObricGuideForFingerprintBinding;", "service", "Lcom/obric/assistant/guide/IObricUserGuide;", "drawable", "Landroid/graphics/drawable/Drawable;", "isObricOS", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setNextView", "updateViews", "showHintDialog", "context", "Landroid/content/Context;", "checkAndGoToFingerPrint", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FingerPrintFragment extends Fragment {
    public static final /* synthetic */ int h = 0;
    public ObricGuideForFingerprintBinding d;
    public final IObricUserGuide e;
    public Drawable f;
    public final boolean g;

    public static final class a {
    }

    static {
    }

    public FingerPrintFragment() {
        this.e = (IObricUserGuide) ServiceManager.get().getService(IObricUserGuide.class);
        this.g = t9a.b.a().b();
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
        FLogger.a.i("FingerPrintFragment", "setNextView, currentPage=" + r5 + ", totalPage=" + r4);
        if (r4 != (r5 + 1)) goto L15;
        r1.S1("finger_print_next_last_page");
        r1.finish();
        return;
    L15:
        r2.setCurrentItem(2, true);
        return;
    L11:
        r4 = 0;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r14v17, types: [com.obric.assistant.guide.ui.j] */
    public final void onViewCreated(View r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r14, "view");
        super.onViewCreated(r14, r15);
        IObricUserGuide r16 = this.e;
        boolean r1 = false;
        if (r16 != null) goto L5;
    L7:
        boolean r17 = false;
    L8:
        IObricUserGuide r3 = this.e;
        if (r3 != null) goto L11;
    L13:
        boolean r4 = false;
    L14:
        FLogger r5 = FLogger.a;
        StringBuilder r6 = new StringBuilder("onViewCreated, savedInstanceState=");
        if (r15 == null) goto L17;
        boolean r18 = true;
    L18:
        r6.append(r18);
        r6.append(", isObricOS=");
        r6.append(this.g);
        r6.append(", serviceAvailable=");
        if (this.e == null) goto L21;
        boolean r19 = true;
    L22:
        r6.append(r19);
        r6.append(", useSystemDrawable=");
        r6.append(r17);
        r6.append(", isFingerPrintExist=");
        r6.append(r4);
        r5.i("FingerPrintFragment", r6.toString());
        if (this.g == true) goto L25;
        this.f = requireContext().getDrawable(2131244435);
    L33:
        FLogger r110 = FLogger.a;
        StringBuilder r111 = new StringBuilder("onViewCreated drawable loaded, drawableAvailable=");
        if (this.f == null) goto L36;
        r1 = true;
    L36:
        r111.append(r1);
        r110.i("FingerPrintFragment", r111.toString());
        ObricGuideForFingerprintBinding r112 = this.d;
        if (r112 == null) goto L41;
        ImageView r113 = r112.i;
        if (r113 == null) goto L41;
        r113.setImageDrawable(this.f);
    L41:
        ObricGuideForFingerprintBinding r114 = this.d;
        if (r114 == null) goto L46;
        TextView r115 = r114.h;
        if (r115 == null) goto L46;
        r115.setOnClickListener(new e(this));
    L46:
        ObricGuideForFingerprintBinding r116 = this.d;
        if (r116 == null) goto L51;
        OButton r117 = r116.k;
        if (r117 == null) goto L51;
        r117.setOnClickListener(new h(this));
    L51:
        ObricGuideForFingerprintBinding r118 = this.d;
        if (r118 == null) goto L56;
        OButton r119 = r118.l;
        if (r119 == null) goto L56;
        r119.setOnClickListener(new i(this));
    L56:
        final ?? r120 = new j(this);
        if (this.g == false) goto L68;
        ObricGuideForFingerprintBinding r121 = this.d;
        if (r121 == null) goto L63;
        OFloatingTitleBar r122 = r121.m;
        if (r122 == null) goto L63;
        OFloatingTitleBar.k(r122, new k(r120), 2);
    L63:
        ObricGuideForFingerprintBinding r123 = this.d;
        if (r123 == null) goto L107;
        OFloatingTitleBar r124 = r123.m;
        if (r124 == null) goto L107;
        View.OnClickListener r125 = new l(this);
        Token$Bounce r0 = OFloatingTitleBar.H0;
        r124.h(2131244127, -1, r125);
    L107:
        ObricGuideForFingerprintBinding r126 = this.d;
        if (r126 == null) goto L116;
        OButton r127 = r126.f;
        if (r127 == null) goto L117;
        r127.setOnClickListener(new n(this));
        return;
    L117:
        return;
    L116:
        return;
    L68:
        int r128 = rda.a.a;
        ObricGuideForFingerprintBinding r129 = this.d;
        if (r129 == null) goto L71;
        OFloatingTitleBar r130 = r129.m;
    L72:
        NovaTitleBarEx.b6(rda.a.b(r130), 2131241477, false, null, null, new m(r120), 14);
        int r131 = getResources().getDimensionPixelSize(v19.c.b(2130971208, null, 2131166786));
        ObricGuideForFingerprintBinding r132 = this.d;
        if (r132 == null) goto L77;
        OButton r133 = r132.f;
        if (r133 == null) goto L77;
        r133.setBackgroundResource(2131244295);
    L77:
        ObricGuideForFingerprintBinding r134 = this.d;
        if (r134 == null) goto L82;
        OButton r135 = r134.f;
        if (r135 == null) goto L82;
        r135.setRadius(r131);
    L82:
        ObricGuideForFingerprintBinding r136 = this.d;
        if (r136 == null) goto L87;
        OButton r137 = r136.f;
        if (r137 == null) goto L87;
        r137.setTextColor(ContextCompat.getColor(requireContext(), 2131102529));
    L87:
        ObricGuideForFingerprintBinding r138 = this.d;
        if (r138 == null) goto L92;
        OButton r139 = r138.l;
        if (r139 == null) goto L92;
        r139.setRadius(r131);
    L92:
        ObricGuideForFingerprintBinding r140 = this.d;
        if (r140 == null) goto L97;
        OButton r141 = r140.k;
        if (r141 == null) goto L97;
        r141.setBackgroundResource(2131244295);
    L97:
        ObricGuideForFingerprintBinding r142 = this.d;
        if (r142 == null) goto L102;
        OButton r143 = r142.k;
        if (r143 == null) goto L102;
        r143.setRadius(r131);
    L102:
        ObricGuideForFingerprintBinding r144 = this.d;
        if (r144 == null) goto L107;
        OButton r145 = r144.k;
        if (r145 == null) goto L107;
        r145.setTextColor(ContextCompat.getColor(requireContext(), 2131102529));
        goto L107
    L71:
        r130 = null;
        goto L72
    L25:
        if (r17 == true) goto L114;
        this.f = requireContext().getDrawable(2131244436);
        goto L33
    L114:
        Context r146 = requireContext().createPackageContext("com.android.settings", 2);     // Catch: Exception -> L113
        int r147 = r146.getResources().getIdentifier("obric_guide_fingerprint_n1", "drawable", "com.android.settings");     // Catch: Exception -> L113
        if (r147 == 0) goto L30;
        Configuration r2 = new Configuration(r146.getResources().getConfiguration());     // Catch: Exception -> L113
        r2.uiMode = requireContext().getResources().getConfiguration().uiMode;     // Catch: Exception -> L113
        Context r148 = r146.createConfigurationContext(r2);     // Catch: Exception -> L113
        NewMiraResourcesManager.getInstance().install(r148);     // Catch: Exception -> L113
        Drawable r149 = r148.getDrawable(r147);     // Catch: Exception -> L113
    L31:
        this.f = r149;
    L30:
        r149 = null;
        goto L31
    L21:
        r19 = false;
        goto L22
    L17:
        r18 = false;
        goto L18
    L11:
        if (r3.b() != true) goto L13;
        r4 = true;
        goto L14
    L5:
        if (r16.h() != true) goto L7;
        r17 = true;
        goto L8
    }

    public final View onCreateView(LayoutInflater r18, ViewGroup r19, Bundle r20) {
        Intrinsics.checkNotNullParameter(r18, "inflater");
        ConstraintLayout r0 = r18.inflate(2131564016, r19, false);
        int r1 = 2131362543;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r0, 2131362543);
        if (r5 == null) goto L35;
        r1 = 2131365646;
        OCheckBoxLayout r6 = (OCheckBoxLayout) ViewBindings.findChildViewById(r0, 2131365646);
        if (r6 == null) goto L35;
        r1 = 2131372556;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r0, 2131372556);
        if (r7 == null) goto L35;
        r1 = 2131372557;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r0, 2131372557);
        if (r8 == null) goto L35;
        r1 = 2131372559;
        OButton r9 = (OButton) ViewBindings.findChildViewById(r0, 2131372559);
        if (r9 == null) goto L35;
        r1 = 2131372562;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r0, 2131372562);
        if (r10 == null) goto L35;
        r1 = 2131372563;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r0, 2131372563);
        if (r11 == null) goto L35;
        r1 = 2131372565;
        ImageView r12 = (ImageView) ViewBindings.findChildViewById(r0, 2131372565);
        if (r12 == null) goto L35;
        r1 = 2131373138;
        if (ViewBindings.findChildViewById(r0, 2131373138) == null) goto L35;
        r1 = 2131374360;
        ConstraintLayout r13 = ViewBindings.findChildViewById(r0, 2131374360);
        if (r13 == null) goto L35;
        r1 = 2131380090;
        if (ViewBindings.findChildViewById(r0, 2131380090) == null) goto L35;
        r1 = 2131380894;
        OButton r14 = (OButton) ViewBindings.findChildViewById(r0, 2131380894);
        if (r14 == null) goto L35;
        r1 = 2131386025;
        OButton r15 = (OButton) ViewBindings.findChildViewById(r0, 2131386025);
        if (r15 == null) goto L35;
        r1 = 2131388807;
        OFloatingTitleBar r16 = ViewBindings.findChildViewById(r0, 2131388807);
        if (r16 == null) goto L35;
        r1 = 2131389245;
        if (ViewBindings.findChildViewById(r0, 2131389245) == null) goto L35;
        ConstraintLayout r2 = r0;
        this.d = new ObricGuideForFingerprintBinding(r2, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
        return r2;
    L35:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }
}
