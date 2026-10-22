package com.larus.dora.obric.device_management.device_list;

import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.TextViewCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bytedance.dora.annotation.ProductNameType;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.resource.DoraDrawableDensity;
import com.larus.dora.impl.resource.DoraResourceDeviceType;
import com.larus.dora.impl.resource.j0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.image.OImage;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.lisitem.OUICardConstraintLayout;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import g49.d;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0007\u0018\u0000 <2\u00020\u0001:\u0002;<B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\nH\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\nH\u0002J\b\u0010\u001b\u001a\u00020\u0012H\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0016H\u0002J\u0010\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020\u0016H\u0002J\u0010\u0010'\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)H\u0002J\b\u0010+\u001a\u00020\u0016H\u0002J\u001c\u0010,\u001a\u00020\n2\b\b\u0001\u0010-\u001a\u00020)2\b\b\u0001\u0010.\u001a\u00020)H\u0002J\b\u0010/\u001a\u00020)H\u0002J\b\u00100\u001a\u00020)H\u0002J\b\u00101\u001a\u00020)H\u0002J\b\u00102\u001a\u00020)H\u0002J\u001c\u00103\u001a\u00020)2\b\b\u0001\u00104\u001a\u00020)2\b\b\u0001\u00105\u001a\u00020)H\u0002J\f\u00106\u001a\u00020)*\u000207H\u0002J\u0014\u00108\u001a\u00020\u0012*\u0002092\u0006\u0010:\u001a\u00020)H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006="}, d2 = {"Lcom/larus/dora/obric/device_management/device_list/DoraObricDeviceFoundListFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "contentContainer", "Lcom/obric/oui/layout/OUILinearLayout;", "broadcastReceiver", "com/larus/dora/obric/device_management/device_list/DoraObricDeviceFoundListFragment$broadcastReceiver$1", "Lcom/larus/dora/obric/device_management/device_list/DoraObricDeviceFoundListFragment$broadcastReceiver$1;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "getCurrentPageName", "", "buildContentView", "buildTitleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "buildScrollView", "renderDeviceCards", "buildDeviceCard", "Lcom/obric/oui/lisitem/OUICardConstraintLayout;", "item", "Lcom/larus/dora/obric/device_management/device_list/DoraObricDeviceFoundListFragment$DeviceListItem;", "buildProductImage", "Lcom/obric/oui/image/OImage;", "buildTitleText", "Lcom/obric/oui/text/OTextView;", "title", "buildSubtitleText", "subtitle", "openBindPage", "resolveBindProductId", "", "cardProductId", "previousPage", "buildSpacer", "heightAttrResId", "heightResId", "resolveBackgroundColor", "resolveCardColor", "resolveText1Color", "resolveText3Color", "dimensionPixelSize", "attrResId", "defaultResId", "sp", "", "setSansSerifFontWeight", "Landroid/widget/TextView;", "weight", "DeviceListItem", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricDeviceFoundListFragment extends DoraBaseFragment {
    public static final List<b> h = null;
    public OUILinearLayout f;
    public final DoraObricDeviceFoundListFragment$broadcastReceiver$1 g;

    public static final class a {
    }

    public static final class b {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final String e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31;
            String r1 = this.e;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "DeviceListItem(titleResId=" + this.a + ", subtitleResId=" + this.b + ", productId=" + this.c + ", imageResId=" + this.d + ", imageResourceName=" + this.e + ')';
        }

        public /* synthetic */ b(int r7, int r8, int r9, int r10) {
            this(r7, r8, r9, r10, null);
        }

        public b(int r1, int r2, int r3, int r4, String r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public final String k() {
        return "obric_device_list";
    }

    static {
        h = CollectionsKt.listOf(new b[]{new b(2131903392, 2131903391, ProductNameType.DORA_G.id, 0, "larus_dora_obric_device_list_img_glasses"), new b(2131903390, 2131903389, ProductNameType.DORA_LITE.id, 2131240586), new b(2131903394, 2131903393, -1, 2131240587)});
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.dora.obric.device_management.device_list.DoraObricDeviceFoundListFragment$broadcastReceiver$1] */
    public DoraObricDeviceFoundListFragment() {
        this.g = new DoraObricDeviceFoundListFragment$broadcastReceiver$1(this);
    }

    public final void onDestroyView() {
        Context r0 = getContext();
        if (r0 == null) goto L5;
        LocalBroadcastManager.getInstance(r0).unregisterReceiver(this.g);
    L5:
        this.f = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public final int W90(int r3, int r4) {
        Context r0 = requireContext();
        return r0.getResources().getDimensionPixelSize(c.b(r3, r0, r4));
    }

    public final void X90(TextView r5, int r6) {
        Typeface r0 = Typeface.create("sans-serif", 0);
        if (Build.VERSION.SDK_INT < 28) goto L5;
        r0 = Typeface.create(r0, r6, false);
    L5:
        r5.setTypeface(r0);
    }

    public final void onViewCreated(View r22, Bundle r23) {
        Intrinsics.checkNotNullParameter(r22, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r22, r23);
        OUILinearLayout r1 = this.f;
        if (r1 == null) goto L30;
        r1.removeAllViews();
        Iterator<T> r2 = h.iterator();
        int r4 = 0;
    L7:
        if (r2.hasNext() == false) goto L24;
        Object r5 = r2.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        final b r7 = (b) r5;
        if (r4 <= 0) goto L14;
        OUIFrameLayout r8 = new OUIFrameLayout(requireContext(), null, 0, 14);
        r8.setLayoutParams(new LinearLayout.LayoutParams(-1, W90(2130971208, 2131166786)));
        r1.addView(r8);
    L14:
        String r9 = getString(r7.a);
        String r12 = getString(r7.b);
        OImage r13 = LayoutInflater.from(requireContext()).inflate(2131562232, null, false);
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.obric.oui.image.OImage");
        OImage r14 = r13;
        r14.setId(View.generateViewId());
        String r15 = r7.e;
        if (r15 == null) goto L17;
        Drawable r16 = j0.f(j0.a, requireContext(), DoraResourceDeviceType.G2, r15, DoraDrawableDensity.XXHDPI, 8);
    L18:
        if (r16 == null) goto L20;
        r14.setImageDrawable(r16);
    L23:
        r14.setContentDescription(getString(r7.a));
        OTextView r17 = new OTextView(requireContext(), null, 0, 14);
        r17.setId(View.generateViewId());
        r17.setText(r9);
        r17.setGravity(17);
        r17.setIncludeFontPadding(false);
        r17.setMaxLines(1);
        r17.setEllipsize(TextUtils.TruncateAt.END);
        r17.setTextColor(ContextCompat.getColor(requireContext(), 2131104350));
        r17.setTextSize(2, 16.0f);
        Resources r10 = getResources();
        TextViewCompat.setLineHeight(r17, (int) ((20.0f * WindowDisplayMetricsOverride.apply(r10, r10.getDisplayMetrics()).scaledDensity) + 0.5f));
        X90(r17, 500);
        OTextView r11 = new OTextView(requireContext(), null, 0, 14);
        r11.setId(View.generateViewId());
        r11.setText(r12);
        r11.setGravity(17);
        r11.setIncludeFontPadding(false);
        r11.setMaxLines(1);
        r11.setEllipsize(TextUtils.TruncateAt.END);
        r11.setTextColor(ContextCompat.getColor(requireContext(), 2131104359));
        r11.setTextSize(2, 12.0f);
        Resources r18 = getResources();
        TextViewCompat.setLineHeight(r11, (int) ((WindowDisplayMetricsOverride.apply(r18, r18.getDisplayMetrics()).scaledDensity * 16.0f) + 0.5f));
        X90(r11, 400);
        OUICardConstraintLayout r20 = new OUICardConstraintLayout(requireContext(), null, 0, 14);
        LinearLayout.LayoutParams r21 = new LinearLayout.LayoutParams(-1, -2);
        r21.gravity = 1;
        r20.setLayoutParams(r21);
        r20.setOuterNormalColor(c.a(2130970532, requireContext(), 2131102539));
        r20.setRadius(W90(2130971255, 2131166880));
        GradientDrawable r24 = new GradientDrawable();
        r24.setShape(0);
        r24.setCornerRadius(W90(2130971255, 2131166880));
        r24.setColor(c.a(2130970532, requireContext(), 2131102539));
        r20.setBackground(r24);
        r20.setClipChildren(true);
        r20.setClipToPadding(true);
        r20.setClipToOutline(true);
        r20.setClickable(true);
        r20.setFocusable(true);
        r20.setContentDescription(r9);
        r20.setOnClickListener(new z69.a(r7, this));
        ConstraintLayout.LayoutParams r25 = new ConstraintLayout.LayoutParams(0, 0);
        r25.G = "3.1:1";
        r25.i = 0;
        r25.t = 0;
        r25.v = 0;
        r25.setMarginStart(W90(2130971208, 2131166786));
        r25.setMarginEnd(W90(2130971208, 2131166786));
        ((ViewGroup.MarginLayoutParams) r25).topMargin = W90(2130971208, 2131166786);
        Unit r26 = Unit.INSTANCE;
        r20.addView(r14, r25);
        ConstraintLayout.LayoutParams r27 = new ConstraintLayout.LayoutParams(-1, -2);
        r27.j = r14.getId();
        r27.t = 0;
        r27.v = 0;
        ((ViewGroup.MarginLayoutParams) r27).topMargin = W90(2130971163, 2131166696);
        r27.setMarginStart(W90(2130971208, 2131166786));
        r27.setMarginEnd(W90(2130971208, 2131166786));
        r20.addView(r17, r27);
        ConstraintLayout.LayoutParams r28 = new ConstraintLayout.LayoutParams(-1, -2);
        r28.j = r17.getId();
        r28.t = 0;
        r28.v = 0;
        r28.l = 0;
        ((ViewGroup.MarginLayoutParams) r28).topMargin = W90(2130971480, 2131167331);
        ((ViewGroup.MarginLayoutParams) r28).bottomMargin = W90(2130971208, 2131166786);
        r28.setMarginStart(W90(2130971208, 2131166786));
        r28.setMarginEnd(W90(2130971208, 2131166786));
        r20.addView(r11, r28);
        r1.addView(r20);
        r4 = r6;
        goto L7
    L20:
        int r110 = r7.d;
        if (r110 == 0) goto L23;
        r14.setImageResource(r110);
        goto L23
    L17:
        r16 = null;
        goto L18
    L24:
        d.d("DoraObricDeviceFoundListFragment", "render native device list, count=" + h.size());
        return;
    }

    public final View onCreateView(LayoutInflater r11, ViewGroup r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r11, "inflater");
        Context r14 = requireContext();
        IntentFilter r15 = new IntentFilter("action.ONBOARDING_ACTIVITY_DESTROY");
        r15.addAction("action.ONBOARDING_ACTIVITY_CREATE");
        LocalBroadcastManager.getInstance(r14).registerReceiver(this.g, r15);
        Context r16 = requireContext();
        AttributeSet r0 = null;
        int r1 = 6;
        int r2 = 0;
        OFloatingTitleBar r17 = new OFloatingTitleBar(requireContext(), null, 6, 0);
        r17.setClipChildren(false);
        r17.setClipToPadding(false);
        r17.setBackgroundColor(c.a(2130970531, requireContext(), 2131102535));
        r17.setCenterTitle(getString(2131903445));
        r17.setCenterTitleColor(ContextCompat.getColor(requireContext(), 2131104350));
        TextView r18 = (TextView) r17.findViewById(2131365427);
        if (r18 == null) goto L5;
        X90(r18, 600);
    L5:
        r17.R(false);
        View r110 = OFloatingTitleBar.k(r17, null, 6);
        r110.setOnClickListener(new z69.b(this));
        Intrinsics.checkNotNullParameter(r17, "<this>");
        Intrinsics.checkNotNullParameter(r110, "action");
        r17.post(new com.larus.dora.obric.utils.b(r17, r110));
        NestedScrollView r111 = new ONestedScrollView(requireContext(), r0, r1, r2);
        r111.setFillViewport(true);
        r111.setOverScrollMode(2);
        r111.setClipChildren(false);
        r111.setClipToPadding(false);
        r111.setPadding(W90(2130971163, 2131166696), W90(2130971208, 2131166786), W90(2130971163, 2131166696), W90(2130971390, 2131167150));
        OUILinearLayout r5 = new OUILinearLayout(r111.getContext(), null, 0, 14);
        r5.setOrientation(1);
        r5.setClipChildren(false);
        r5.setClipToPadding(false);
        this.f = r5;
        r111.addView(r5, new ViewGroup.LayoutParams(-1, -2));
        return com.larus.dora.obric.utils.c.c(r16, r17, r111, c.a(2130970531, requireContext(), 2131102535), null);
    }
}
