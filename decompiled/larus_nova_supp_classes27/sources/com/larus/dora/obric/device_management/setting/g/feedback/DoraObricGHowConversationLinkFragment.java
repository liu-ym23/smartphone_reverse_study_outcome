package com.larus.dora.obric.device_management.setting.g.feedback;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.TextViewCompat;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\u0012\u0010\u0011\u001a\u00020\u00052\b\b\u0001\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010\u0014\u001a\u00020\u00052\b\b\u0001\u0010\u0015\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0013H\u0002J\f\u0010\u0018\u001a\u00020\u0019*\u00020\u001aH\u0002J\f\u0010\u001b\u001a\u00020\u0013*\u00020\u0013H\u0002J\f\u0010\u001c\u001a\u00020\u0013*\u00020\u001dH\u0002¨\u0006\u001f"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/g/feedback/DoraObricGHowConversationLinkFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "getCurrentPageName", "", "buildContentView", "buildTitleBar", "buildScrollContent", "buildGuideTitle", "titleRes", "", "buildGuideImage", "imageRes", "resolveBackgroundColor", "resolvePrimaryTextColor", "applyTitleBarTextStyle", "", "Landroid/widget/TextView;", "dp", "sp", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricGHowConversationLinkFragment extends DoraBaseFragment {
    public static final /* synthetic */ int f = 0;

    public static final class a {
    }

    static {
    }

    public final String k() {
        return "how_to_get_conversation_link";
    }

    public DoraObricGHowConversationLinkFragment() {
    }

    public final View W90(int r3) {
        ImageView r0 = new ImageView(requireContext());
        r0.setImageResource(r3);
        r0.setAdjustViewBounds(true);
        r0.setMaxWidth(Y90(390));
        r0.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r0.setContentDescription(null);
        return r0;
    }

    public final OTextView X90(int r6) {
        OTextView r0 = new OTextView(requireContext(), null, 0, 14);
        r0.setText(getString(r6));
        r0.setGravity(8388611);
        r0.setTextColor(v19.c.a(2130972079, requireContext(), 2131103136));
        r0.setTextSize(2, 16.0f);
        r0.setIncludeFontPadding(false);
        Resources r7 = getResources();
        TextViewCompat.setLineHeight(r0, (int) TypedValue.applyDimension(2, 22.0f, WindowDisplayMetricsOverride.apply(r7, r7.getDisplayMetrics())));
        r0.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 500, false));
        LinearLayout.LayoutParams r8 = new LinearLayout.LayoutParams(-1, -2);
        r8.setMarginStart(Y90(2));
        r8.setMarginEnd(Y90(2));
        r0.setLayoutParams(r8);
        return r0;
    }

    public final int Y90(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public final View onCreateView(LayoutInflater r17, ViewGroup r18, Bundle r110) {
        Intrinsics.checkNotNullParameter(r17, "inflater");
        Context r1 = requireContext();
        OFloatingTitleBar r2 = new OFloatingTitleBar(requireContext(), null, 6, 0);
        r2.setClipChildren(false);
        r2.setClipToPadding(false);
        r2.setBackgroundColor(v19.c.a(2130970531, requireContext(), 2131102535));
        r2.setCenterTitle(getString(2131902721));
        r2.setCenterTitleColor(v19.c.a(2130972079, requireContext(), 2131103136));
        TextView r3 = (TextView) r2.findViewById(2131365427);
        if (r3 == null) goto L5;
        r3.setTextSize(2, 16.0f);
        Resources r10 = getResources();
        TextViewCompat.setLineHeight(r3, (int) TypedValue.applyDimension(2, 22.0f, WindowDisplayMetricsOverride.apply(r10, r10.getDisplayMetrics())));
        r3.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 600, false));
    L5:
        r2.R(false);
        OFloatingTitleBar.k(r2, null, 6).setOnClickListener(new z(this));
        Context r4 = requireContext();
        LinearLayout r5 = new LinearLayout(r4);
        r5.setOrientation(1);
        r5.setGravity(1);
        r5.setPadding(Y90(12), Y90(16), Y90(12), Y90(48));
        r5.addView(X90(2131902720));
        View r12 = W90(2131233924);
        LinearLayout.LayoutParams r13 = new LinearLayout.LayoutParams(-1, -2);
        r13.topMargin = Y90(8);
        r13.bottomMargin = Y90(12);
        Unit r7 = Unit.INSTANCE;
        r5.addView(r12, r13);
        r5.addView(X90(2131902719));
        View r8 = W90(2131233925);
        LinearLayout.LayoutParams r11 = new LinearLayout.LayoutParams(-1, -2);
        r11.topMargin = Y90(8);
        r5.addView(r8, r11);
        NestedScrollView r6 = new NestedScrollView(r4);
        r6.setClipChildren(true);
        r6.setClipToPadding(false);
        r6.setOverScrollMode(2);
        r6.setFillViewport(true);
        r6.addView(r5, new ViewGroup.LayoutParams(-1, -2));
        return com.larus.dora.obric.utils.c.c(r1, r2, r6, v19.c.a(2130970531, requireContext(), 2131102535), null);
    }
}
