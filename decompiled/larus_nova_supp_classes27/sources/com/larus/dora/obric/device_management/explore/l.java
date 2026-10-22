package com.larus.dora.obric.device_management.explore;

import android.R;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.TextViewCompat;
import com.bytedance.dora.device.DoraDevice;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.lisitem.OUICardConstraintLayout;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.text.OTextView;
import java.util.Iterator;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class l<T> implements FlowCollector {
    public final /* synthetic */ DoraObricExploreFragment a;

    public l(DoraObricExploreFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r21, Continuation r22) {
        p r0 = (p) r21;
        final DoraObricExploreFragment r2 = this.a;
        LinearLayout r3 = r2.i;
        if (r3 == null) goto L97;
        r3.removeAllViews();
        if (r0.a == true) goto L97;
        Iterator<T> r1 = r0.b.iterator();
        int r4 = 0;
        int r5 = 0;
    L10:
        if (r1.hasNext() == false) goto L90;
        T r6 = r1.next();
        int r7 = r5 + 1;
        if (r5 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        final o r8 = (o) r6;
        if (r5 <= 0) goto L17;
        View r9 = new View(r2.requireContext());
        r9.setLayoutParams(new LinearLayout.LayoutParams(-1, r2.Y90(16)));
        r3.addView(r9);
    L17:
        c59.t r10 = r8.b;
        if (r10 == null) goto L20;
        String r11 = c59.p.b(r10);
    L22:
        if (r11 != null) goto L25;
        r11 = "";
    L25:
        if (StringsKt.isBlank(r11) == false) goto L27;
        r11 = r8.c;
    L27:
        OSectionTitleBar r12 = new OSectionTitleBar(r2.requireContext(), null, 6, r4);
        r12.setTitleText(r11);
        r12.setTitleStyle(2131953404);
        LinearLayout r13 = (LinearLayout) r12.findViewById(2131367728);
        if (r13 == null) goto L30;
        r13.setPadding(r2.Y90(12), r2.Y90(8), r2.Y90(12), r2.Y90(8));
    L30:
        r12.setLayoutParams(new LinearLayout.LayoutParams(-1, r2.Y90(40)));
        r3.addView(r12);
        Iterator<T> r14 = r8.e.iterator();
        final int r15 = 0;
    L32:
        if (r14.hasNext() == false) goto L89;
        T r16 = r14.next();
        int r17 = r15 + 1;
        if (r15 >= 0) goto L36;
        CollectionsKt.throwIndexOverflow();
    L36:
        n r18 = (n) r16;
        View.OnClickListener r110 = new k(r2, r8, r15);
        FrameLayout r111 = new FrameLayout(r2.requireContext());
        r111.setClipChildren(true);
        r111.setClipToPadding(true);
        r111.setClipToOutline(true);
        GradientDrawable r112 = new GradientDrawable();
        r112.setShape(r4);
        r112.setCornerRadius(r2.Y90(20));
        r112.setColor(r2.X90(R.color.transparent));
        r111.setBackground(r112);
        r111.setLayoutParams(new LinearLayout.LayoutParams(-1, r2.Y90(168)));
        SimpleDraweeView r20 = new SimpleDraweeView(r2.requireContext());
        int r23 = l59.a.a;
        z49.b r24 = r8.d;
        if (r24 == null) goto L39;
        DoraDevice r25 = r24.a;
    L40:
        String r26 = l59.a.d(r25);
        Iterator<T> r113 = r1;
        r20.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        c59.p.e(r20, r18.c(), MapsKt.mapOf(TuplesKt.to("product", r26)), null, 4);
        r20.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r111.addView(r20);
        View r27 = new View(r2.requireContext());
        r27.setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{r2.X90(2131103044), r2.X90(2131103045)}));
        r27.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r111.addView(r27);
        if (r18.f() == false) goto L47;
        OTextView r28 = new OTextView(r2.requireContext(), null, 0, 14);
        r28.setText(r2.getString(2131902566));
        r28.setGravity(17);
        r28.setIncludeFontPadding(false);
        r28.setTextColor(r2.X90(2131103298));
        r28.setTextSize(2, 10.0f);
        Resources r30 = r2.getResources();
        TextViewCompat.setLineHeight(r28, (int) ((WindowDisplayMetricsOverride.apply(r30, r30.getDisplayMetrics()).scaledDensity * 12.0f) + 0.5f));
        r28.setPadding(r2.Y90(3), 0, r2.Y90(3), 0);
        Typeface r31 = Typeface.create("sans-serif", 0);
        if (Build.VERSION.SDK_INT < 28) goto L45;
        r31 = Typeface.create(r31, 500, false);
    L45:
        r28.setTypeface(r31);
        GradientDrawable r32 = new GradientDrawable();
        r32.setShape(0);
        r32.setCornerRadius(r2.Y90(4));
        r32.setColor(ContextCompat.getColor(r2.requireContext(), 2131104979));
        r28.setBackground(r32);
        FrameLayout.LayoutParams r33 = new FrameLayout.LayoutParams(-2, r2.Y90(16), 8388659);
        r33.setMarginStart(r2.Y90(16));
        r33.topMargin = r2.Y90(16);
        r28.setLayoutParams(r33);
        r111.addView(r28);
    L47:
        OCardListItem r34 = new OCardListItem(r2.requireContext(), null, 6, 0);
        r34.setCardType(0);
        OCardListItem.h(r34, 0);
        r34.setShowCardBg(false);
        r34.p(false);
        c59.t r35 = r18.g();
        if (r35 == null) goto L50;
        String r36 = c59.p.b(r35);
    L51:
        if (r36 != null) goto L53;
        r36 = "";
    L53:
        r34.setTitle(r36);
        r34.s(true);
        c59.t r37 = r18.e();
        if (r37 == null) goto L56;
        String r38 = c59.p.b(r37);
    L57:
        if (r38 != null) goto L59;
        r38 = "";
    L59:
        r34.setSubTitle(r38);
        r34.q(true);
        r34.l(r2.X90(2131105312), r2.X90(2131105320));
        r34.getTitleView().setMaxLines(2);
        r34.getSubTitleView().setMaxLines(2);
        r34.m(false);
        r34.r(false);
        r34.o(false);
        r2.aa0(r34);
        r34.getCardContainer().setPadding(0, 0, 0, 0);
        LinearLayout r40 = (LinearLayout) r34.findViewById(2131388843);
        if (r40 == null) goto L62;
        r40.setPadding(r2.Y90(16), r2.Y90(10), r2.Y90(8), r2.Y90(16));
    L62:
        View r41 = r34.findViewById(2131365192);
        r41.setClickable(false);
        r41.setFocusable(false);
        OUICardConstraintLayout r42 = r34.getContentContainer();
        r42.setClickable(false);
        r42.setFocusable(false);
        r34.setLayoutParams(new FrameLayout.LayoutParams(-1, -2, 8388691));
        r111.addView(r34);
        OCardListItem r43 = new OCardListItem(r2.requireContext(), null, 6, 0);
        r43.setLayoutParams(new LinearLayout.LayoutParams(-1, r2.Y90(168)));
        n r44 = (n) CollectionsKt.getOrNull(r8.e, r15);
        if (r44 == null) goto L67;
        c59.b r45 = r44.a();
        if (r45 == null) goto L67;
        String r46 = r45.e();
    L68:
        if (r46 != null) goto L70;
        r46 = "";
    L70:
        StringBuilder r47 = new StringBuilder();
        z49.b r114 = r8.d;
        if (r114 == null) goto L73;
        Integer r115 = r114.f();
    L74:
        r47.append(r115);
        r47.append(':');
        r47.append(r15);
        r47.append(':');
        r47.append(r46);
        r43.setTag(r47.toString());
        r43.setCardType(2);
        OCardListItem.h(r43, 0);
        r43.setShowCardBg(true);
        r43.setCustomStartView(r111);
        r43.n(true);
        r43.m(false);
        r43.r(false);
        r43.setOnContentClickListener(r110);
        r2.aa0(r43);
        r43.getCardContainer().setPadding(0, 0, 0, 0);
        r43.getContentContainer().setPadding(0, 0, 0, 0);
        r43.o(false);
        Iterator<T> r48 = CollectionsKt.listOf(new Drawable[]{r43.getCardContainer().getBackground(), r43.getContentContainer().getBackground()}).iterator();
    L76:
        if (r48.hasNext() == false) goto L84;
        Drawable r116 = (Drawable) r48.next();
        if ((r116 instanceof GradientDrawable) == false) goto L80;
        GradientDrawable r117 = (GradientDrawable) r116;
    L81:
        if (r117 == null) goto L76;
        r117.setCornerRadius(r2.Y90(20));
        goto L76
    L80:
        r117 = null;
        goto L81
    L84:
        r3.addView(r43);
        if (r15 == CollectionsKt.getLastIndex(r8.e)) goto L88;
        View r50 = new View(r2.requireContext());
        r50.setLayoutParams(new LinearLayout.LayoutParams(-1, r2.Y90(16)));
        r3.addView(r50);
    L88:
        r15 = r17;
        r1 = r113;
        r14 = r14;
        r4 = 0;
        goto L32
    L73:
        r115 = null;
    L67:
        r46 = null;
        goto L68
    L56:
        r38 = null;
        goto L57
    L50:
        r36 = null;
        goto L51
    L39:
        r25 = null;
        goto L40
    L89:
        r5 = r7;
        goto L10
    L20:
        r11 = null;
        goto L22
    L90:
        ONestedScrollView r51 = r2.h;
        if (r51 == null) goto L93;
        r51.setOnScrollChangeListener(new h(r2));
    L93:
        NestedScrollView r52 = r2.h;
        if (r52 == null) goto L97;
        r52.post(new i(r2));
    L97:
        return Unit.INSTANCE;
    }
}
