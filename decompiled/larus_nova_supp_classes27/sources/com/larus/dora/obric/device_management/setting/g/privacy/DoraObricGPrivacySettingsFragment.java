package com.larus.dora.obric.device_management.setting.g.privacy;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import c79.b;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.util.b0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.titlebar.OFloatingTitleBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0002J\b\u0010\u0019\u001a\u00020\u0007H\u0002J\b\u0010\u001a\u001a\u00020\u0007H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0012H\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\f\u0010 \u001a\u00020\u001f*\u00020\u001fH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/larus/dora/obric/device_management/setting/g/privacy/DoraObricGPrivacySettingsFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "enhancedLocationSwitch", "Lcom/obric/oui/oswitch/OSwitch;", "pageMaskView", "Landroid/view/View;", "enhancedLocationCheckedChangeListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "getCurrentPageName", "", "getPageMaskView", "buildContentView", "buildTitleBar", "buildScrollContent", "buildEnhancedLocationCard", "Lcom/obric/oui/lisitem/OCardListItem;", "bindEnhancedLocationSwitch", "resolveBackgroundColor", "", "dp", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricGPrivacySettingsFragment extends DoraBaseFragment {
    public static final /* synthetic */ int i = 0;
    public OSwitch f;
    public View g;
    public final c79.a h;

    public static final class a {
    }

    static {
    }

    public final String k() {
        return "privacy_setting";
    }

    public final void onDestroyView() {
        this.f = null;
        this.g = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [c79.a] */
    public DoraObricGPrivacySettingsFragment() {
        this.h = new c79.a();
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        return this.g;
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r2, r3);
        OSwitch r4 = this.f;
        if (r4 == null) goto L5;
        r4.setOnCheckedChangeListener(null);
    L5:
        OSwitch r5 = this.f;
        if (r5 == null) goto L8;
        b0.a.getClass();
        r5.setChecked(b0.s());
    L8:
        OSwitch r6 = this.f;
        if (r6 == null) goto L12;
        r6.setOnCheckedChangeListener(this.h);
        return;
    }

    public final View onCreateView(LayoutInflater r13, ViewGroup r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r13, "inflater");
        Context r16 = requireContext();
        OFloatingTitleBar r17 = new OFloatingTitleBar(requireContext(), null, 6, 0);
        r17.setBackgroundColor(c.a(2130970531, requireContext(), 2131102535));
        r17.setCenterTitle(getString(2131903929));
        r17.R(false);
        OFloatingTitleBar.k(r17, null, 6).setOnClickListener(new c79.c(this));
        Context r18 = requireContext();
        LinearLayout r5 = new LinearLayout(r18);
        r5.setOrientation(1);
        r5.setClipChildren(false);
        r5.setClipToPadding(false);
        Resources r8 = getResources();
        int r7 = (int) ((16 * WindowDisplayMetricsOverride.apply(r8, r8.getDisplayMetrics()).density) + 0.5f);
        Resources r10 = getResources();
        r5.setPadding(0, r7, 0, (int) ((24 * WindowDisplayMetricsOverride.apply(r10, r10.getDisplayMetrics()).density) + 0.5f));
        OCardListItem r9 = new OCardListItem(requireContext(), null, 6, 0);
        r9.setCardType(0);
        OCardListItem.h(r9, 0);
        r9.setShowCardBg(true);
        r9.p(false);
        r9.setTitle(getString(2131902510));
        r9.s(true);
        r9.setSubTitle(getString(2131902511));
        r9.getSubTitleView().setMaxLines(5);
        r9.q(true);
        r9.setDefaultCustomEndView(1);
        r9.m(true);
        r9.r(false);
        this.f = r9.getEndSwitch();
        r5.addView(r9);
        NestedScrollView r0 = new NestedScrollView(r18);
        r0.setClipChildren(true);
        r0.setClipToPadding(false);
        r0.setOverScrollMode(2);
        r0.setFillViewport(true);
        r0.addView(r5, new ViewGroup.LayoutParams(-1, -2));
        return com.larus.dora.obric.utils.c.c(r16, r17, r0, c.a(2130970531, requireContext(), 2131102535), new b(this));
    }
}
