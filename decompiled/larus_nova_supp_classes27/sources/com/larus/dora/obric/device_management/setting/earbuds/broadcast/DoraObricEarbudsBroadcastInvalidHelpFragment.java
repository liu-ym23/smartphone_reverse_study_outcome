package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.text.OTextView;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0002J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\f\u0010\u001a\u001a\u00020\u000f*\u00020\u0015H\u0002J\f\u0010\u001b\u001a\u00020\u000f*\u00020\u0015H\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\b\u0010\u001d\u001a\u00020\u0019H\u0002J\f\u0010\u001e\u001a\u00020\u0019*\u00020\u0019H\u0002J\f\u0010\u001f\u001a\u00020\u0019*\u00020 H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/larus/dora/obric/device_management/setting/earbuds/broadcast/DoraObricEarbudsBroadcastInvalidHelpFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "page", "Lcom/larus/dora/obric/device_management/setting/earbuds/ui/DoraObricEarbudsOuiPage;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "getCurrentPageName", "", "getPageMaskView", "buildHelpCard", "buildHelpItem", "Lcom/obric/oui/lisitem/OCardListItem;", "title", "desc", "position", "", "applyCardStyle", "resetCardContainerMargins", "resolvePrimaryTextColor", "resolveSecondaryTextColor", "dp", "sp", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricEarbudsBroadcastInvalidHelpFragment extends DoraBaseFragment {
    public static final /* synthetic */ int g = 0;
    public b79.d f;

    public static final class a {
    }

    static {
    }

    public final String k() {
        return "dora_broadcast_invalid_help";
    }

    public final void onDestroyView() {
        this.f = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        b79.d r0 = this.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e;
    }

    public DoraObricEarbudsBroadcastInvalidHelpFragment() {
    }

    public final int W90(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public final View onCreateView(LayoutInflater r110, ViewGroup r20, Bundle r21) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        Context r2 = requireContext();
        int r3 = com.larus.utils.j0.a;
        b79.d r1 = new b79.d(r2, com.larus.utils.j0.d(2131902330), new z(this));
        this.f = r1;
        Context r4 = requireContext();
        int r10 = 4;
        List r5 = CollectionsKt.listOf(new Pair[]{TuplesKt.to(2131902323, 2131902322), TuplesKt.to(2131902318, 2131902317), TuplesKt.to(2131902329, 2131902328), TuplesKt.to(2131902334, 2131902333), TuplesKt.to(2131902327, 2131902326), TuplesKt.to(2131902332, 2131902331), TuplesKt.to(2131902316, 2131902315), TuplesKt.to(2131902325, 2131902324)});
        LinearLayout r6 = new LinearLayout(r4);
        r6.setOrientation(1);
        r6.setClipChildren(false);
        r6.setClipToPadding(false);
        Iterator r7 = r5.iterator();
        int r12 = 0;
    L4:
        if (r7.hasNext() == false) goto L21;
        Object r13 = r7.next();
        int r16 = r12 + 1;
        if (r12 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        Pair r14 = (Pair) r13;
        int r15 = ((Number) r14.component1()).intValue();
        int r17 = ((Number) r14.component2()).intValue();
        if (r12 != 0) goto L12;
        int r18 = 1;
    L15:
        String r111 = getString(r15);
        String r112 = getString(r17);
        ViewGroup.MarginLayoutParams r8 = null;
        OCardListItem r113 = new OCardListItem(requireContext(), null, 6, 0);
        r113.setCardType(0);
        OCardListItem.h(r113, r18);
        r113.setShowCardBg(true);
        r113.p(false);
        r113.setTitle(r111);
        r113.s(true);
        r113.setSubTitle(r112);
        r113.q(true);
        r113.getSubTitleView().setMaxLines(Integer.MAX_VALUE);
        r113.m(false);
        r113.r(false);
        ViewGroup.LayoutParams r9 = r113.getCardContainer().getLayoutParams();
        if ((r9 instanceof ViewGroup.MarginLayoutParams) == false) goto L18;
        r8 = (ViewGroup.MarginLayoutParams) r9;
    L18:
        if (r8 == null) goto L20;
        r8.setMarginStart(0);
        r8.setMarginEnd(0);
        r8.leftMargin = 0;
        r8.rightMargin = 0;
        r113.getCardContainer().setLayoutParams(r8);
    L20:
        r113.getContentContainer().setPadding(0, 0, W90(r10), 0);
        r113.getTitleContainer().setGravity(16);
        r113.getTitleContainer().setPadding(W90(12), W90(10), W90(8), W90(10));
        OTextView r11 = r113.getTitleView();
        r11.setGravity(8388611);
        r11.setMaxLines(1);
        r11.setTextColor(v19.c.a(2130972079, requireContext(), 2131103136));
        r11.setTextSize(2, 16.0f);
        Resources r22 = getResources();
        TextViewCompat.setLineHeight(r11, (int) ((WindowDisplayMetricsOverride.apply(r22, r22.getDisplayMetrics()).scaledDensity * 22.0f) + 0.5f));
        r11.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 400, false));
        OTextView r23 = r113.getSubTitleView();
        r23.setTextColor(v19.c.a(2130972081, requireContext(), 2131103143));
        r23.setTextSize(2, 12.0f);
        r23.setMaxLines(Integer.MAX_VALUE);
        r113.o(false);
        r6.addView(r113);
        r12 = r16;
        r10 = 4;
        goto L4
    L12:
        if (r12 != CollectionsKt.getLastIndex(r5)) goto L14;
        r18 = 3;
        goto L15
    L14:
        r18 = 2;
        goto L15
    L21:
        r1.a(r6, 0);
        String r24 = getString(2131902321);
        Intrinsics.checkNotNullParameter(r24, "text");
        TextView r25 = new TextView(r1.a);
        r25.setText(r24);
        r25.setTextColor(v19.c.a(2130972081, r25.getContext(), 2131103143));
        r25.setTextSize(2, 13.0f);
        LinearLayout.LayoutParams r26 = new LinearLayout.LayoutParams(-1, -2);
        r26.setMarginStart(r1.b(16));
        r26.setMarginEnd(r1.b(16));
        r26.topMargin = r1.b(8);
        r25.setLayoutParams(r26);
        r1.c.addView(r25);
        return r1.f;
    }
}
