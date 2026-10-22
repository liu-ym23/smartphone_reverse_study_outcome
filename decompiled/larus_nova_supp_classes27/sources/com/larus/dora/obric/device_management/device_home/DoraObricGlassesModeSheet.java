package com.larus.dora.obric.device_management.device_home;

import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.os.BundleKt;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.DialogFragment;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.lisitem.OUICardConstraintLayout;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.sheet.v2.OSheetBase;
import com.obric.oui.text.OTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0000\u0018\u0000 02\u00020\u0001:\u0002/0B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\nH\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u000e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u0007J\b\u0010!\u001a\u00020\u001cH\u0002J\u0010\u0010\"\u001a\u00020#2\u0006\u0010 \u001a\u00020\u0007H\u0002J\f\u0010$\u001a\u00020\u001c*\u00020\nH\u0002J\f\u0010%\u001a\u00020\u001c*\u00020\nH\u0002J\f\u0010&\u001a\u00020\u001c*\u00020\nH\u0002J\u0012\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020\u0019H\u0002J\f\u0010*\u001a\u00020\u0007*\u00020+H\u0002J\f\u0010,\u001a\u00020\u0019*\u00020\u0019H\u0002J\f\u0010-\u001a\u00020\u0019*\u00020.H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricGlassesModeSheet;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "state", "Lcom/larus/dora/obric/device_management/device_home/DoraObricGlassesModeSheetState;", "pendingSelectedMode", "Lcom/larus/dora/obric/device_management/device_home/DoraObricGlassesMode;", "optionCards", "Ljava/util/LinkedHashMap;", "Lcom/obric/oui/lisitem/OCardListItem;", "Lkotlin/collections/LinkedHashMap;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "buildBody", "Landroid/view/View;", "buildSectionTitle", "Lcom/obric/oui/sectiontitlebar/OSectionTitleBar;", "buildModeCard", "buildModeOption", "option", "Lcom/larus/dora/obric/device_management/device_home/DoraObricGlassesModeSheetOption;", "position", "", "buildShutdownCard", "onEvent", "", "event", "Lcom/larus/dora/obric/device_management/device_home/DoraObricGlassesModeSheetEvent;", "updateSelectedMode", "mode", "renderSelection", "contentFor", "Lcom/larus/dora/obric/device_management/device_home/DoraObricGlassesModeSheet$DoraObricGlassesModeSheetContent;", "applyCardStyle", "resetCardContainerMargins", "applyShutdownStyle", "matchWrapParams", "Landroid/widget/LinearLayout$LayoutParams;", "topMargin", "toGlassesMode", "", "dp", "sp", "", "DoraObricGlassesModeSheetContent", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricGlassesModeSheet extends DialogFragment {
    public static final /* synthetic */ int g = 0;
    public f3 d;
    public DoraObricGlassesMode e;
    public final LinkedHashMap<DoraObricGlassesMode, OCardListItem> f;

    public static final class a {
    }

    public static final class b {
        public final int a;
        public final int b;

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
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b;
        }

        public final String toString() {
            return "DoraObricGlassesModeSheetContent(titleRes=" + this.a + ", subtitleRes=" + this.b + ')';
        }

        public b(int r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DoraObricGlassesMode.values().length];
            r0[DoraObricGlassesMode.HEADPHONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[DoraObricGlassesMode.ASSISTANT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[DoraObricGlassesMode.UNKNOWN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public final void V90() {
        Iterator<Map.Entry<DoraObricGlassesMode, OCardListItem>> r0 = this.f.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        Map.Entry<DoraObricGlassesMode, OCardListItem> r1 = r0.next();
        DoraObricGlassesMode r2 = r1.getKey();
        OCardListItem r3 = r1.getValue();
        f3 r4 = this.d;
        if (r4 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("state");
        r4 = null;
    L9:
        if (r2 != r4.a) goto L11;
        boolean r5 = true;
    L12:
        r3.m(r5);
        goto L4
    L11:
        r5 = false;
        goto L12
    }

    public DoraObricGlassesModeSheet() {
        this.f = new LinkedHashMap();
    }

    public final void S90(OCardListItem r8) {
        ViewGroup.LayoutParams r0 = r8.getCardContainer().getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
    L7:
        if (r1 == null) goto L9;
        int r2 = T90(0);
        r1.setMarginStart(r2);
        r1.setMarginEnd(r2);
        r1.leftMargin = r2;
        r1.rightMargin = r2;
        r8.getCardContainer().setLayoutParams(r1);
    L9:
        r8.getContentContainer().setPadding(T90(12), 0, T90(4), 0);
        r8.getTitleContainer().setGravity(16);
        r8.getTitleContainer().setPadding(0, T90(10), T90(8), T90(10));
        OTextView r3 = r8.getTitleView();
        r3.setGravity(8388611);
        r3.setMaxLines(1);
        r3.setTextColor(v19.c.a(2130972079, r3.getContext(), 2131103136));
        r3.setTextSize(2, 16.0f);
        Resources r4 = getResources();
        TextViewCompat.setLineHeight(r3, (int) TypedValue.applyDimension(2, 22.0f, WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics())));
        r3.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 400, false));
        OTextView r5 = r8.getSubTitleView();
        r5.setTextColor(v19.c.a(2130972081, r5.getContext(), 2131103143));
        r5.setTextSize(2, 12.0f);
        Resources r6 = getResources();
        TextViewCompat.setLineHeight(r5, (int) TypedValue.applyDimension(2, 16.0f, WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics())));
        r8.o(false);
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final int T90(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public final void U90(z2 r8) {
        int r0 = c3.a;
        f3 r1 = this.d;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("state");
        r1 = null;
    L5:
        d3 r9 = c3.a(r1, r8);
        this.d = r9.a;
        V90();
        y2 r10 = r9.b;
        if ((r10 instanceof y2.a) == false) goto L9;
        getParentFragmentManager().setFragmentResult("request_key_obric_glasses_mode_sheet", BundleKt.bundleOf(new Pair[]{TuplesKt.to("bundle_key_action", "change_mode"), TuplesKt.to("bundle_key_mode", ((y2.a) r10).a.name())}));
        return;
    L9:
        if (Intrinsics.areEqual(r10, y2.b.a) == false) goto L11;
        getParentFragmentManager().setFragmentResult("request_key_obric_glasses_mode_sheet", BundleKt.bundleOf(new Pair[]{TuplesKt.to("bundle_key_action", "shutdown")}));
        return;
    L11:
        if (r10 != null) goto L14;
        return;
    L14:
        throw new NoWhenBranchMatchedException();
    }

    public final Dialog onCreateDialog(Bundle r18) {
        DoraObricGlassesMode r2 = this.e;
        if (r2 != null) goto L22;
        Bundle r3 = getArguments();
        if (r3 == null) goto L19;
        String r4 = r3.getString("arg_selected_mode");
        if (r4 == null) goto L19;
        Iterator r5 = DoraObricGlassesMode.getEntries().iterator();
    L10:
        if (r5.hasNext() == false) goto L14;
        Object r6 = r5.next();
        if (Intrinsics.areEqual(((DoraObricGlassesMode) r6).name(), r4) == false) goto L10;
    L15:
        DoraObricGlassesMode r7 = (DoraObricGlassesMode) r6;
        if (r7 != null) goto L18;
        r7 = DoraObricGlassesMode.UNKNOWN;
    L18:
        r2 = r7;
    L20:
        if (r2 != null) goto L22;
        r2 = DoraObricGlassesMode.UNKNOWN;
        goto L22
    L14:
        r6 = null;
    L19:
        r2 = null;
    L22:
        this.d = new f3(r2);
        OSheet r1 = new OSheet(requireContext(), 0, false, 30);
        OSheetBase.DefaultImpls.q(r1, OSheet.HeightMode.WRAP_HEIGHT);
        OSheet.Header r8 = OSheet.Header.MODAL;
        Bundle r9 = getArguments();
        if (r9 == null) goto L25;
        String r10 = r9.getString("arg_device_name");
    L26:
        if (r10 != null) goto L28;
        r10 = "";
    L28:
        OSheetBase.DefaultImpls.o(r1, r8, null, r10, null, false, null, new t2(this), 16166);
        LinearLayout r11 = new LinearLayout(requireContext());
        r11.setOrientation(1);
        r11.setPadding(T90(12), 0, T90(12), T90(6));
        OSectionTitleBar r12 = new OSectionTitleBar(requireContext(), null, 6, 0);
        LinearLayout r13 = (LinearLayout) r12.findViewById(2131367728);
        if (r13 == null) goto L31;
        r13.setPadding(T90(20), T90(0), T90(12), T90(0));
    L31:
        r12.setTitleText(getString(2131903614));
        r12.setTitleStyle(2131953405);
        r12.setLayoutParams(new LinearLayout.LayoutParams(-1, T90(32)));
        r11.addView(r12);
        LinearLayout r14 = new LinearLayout(requireContext());
        r14.setOrientation(1);
        r14.setPadding(0, T90(0), 0, T90(0));
        f3 r15 = this.d;
        if (r15 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("state");
        r15 = null;
    L34:
        r15.getClass();
        int r16 = 2;
        List r17 = CollectionsKt.listOf(new DoraObricGlassesMode[]{DoraObricGlassesMode.HEADPHONE, DoraObricGlassesMode.ASSISTANT});
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator r111 = r17.iterator();
    L36:
        if (r111.hasNext() == false) goto L42;
        DoraObricGlassesMode r112 = (DoraObricGlassesMode) r111.next();
        if (r112 != r15.a) goto L40;
        boolean r113 = true;
    L41:
        r110.add(new a3(r112, r113));
        goto L36
    L40:
        r113 = false;
        goto L41
    L42:
        Iterator r20 = r110.iterator();
        int r114 = 0;
    L44:
        if (r20.hasNext() == false) goto L67;
        Object r115 = r20.next();
        int r116 = r114 + 1;
        if (r114 >= 0) goto L48;
        CollectionsKt.throwIndexOverflow();
    L48:
        final a3 r117 = (a3) r115;
        if (r114 != 0) goto L51;
        int r21 = 1;
    L52:
        int r118 = c.a[r117.a.ordinal()];
        if (r118 == 1) goto L61;
        if (r118 != r16) goto L55;
        b r119 = new b(2131903610, 2131903611);
    L62:
        View r22 = new OCardListItem(requireContext(), null, 6, 0);
        r22.setCardType(0);
        OCardListItem.h(r22, r21);
        r22.setShowCardBg(true);
        r22.p(false);
        r22.setTitle(getString(r119.a));
        r22.s(true);
        r22.setSubTitle(getString(r119.b));
        r22.q(true);
        r22.setDefaultCustomEndView(2);
        r22.m(r117.b);
        r22.r(false);
        S90(r22);
        r22.setOnContentClickListener(new w2(this, r117));
        this.f.put(r117.a, r22);
        if (r114 != 0) goto L65;
        int r23 = 0;
    L66:
        LinearLayout.LayoutParams r120 = new LinearLayout.LayoutParams(-1, -2);
        r120.topMargin = r23;
        r14.addView(r22, r120);
        r114 = r116;
        r16 = 2;
        goto L44
    L65:
        r23 = T90(0);
        goto L66
    L55:
        if (r118 == 3) goto L59;
        throw new NoWhenBranchMatchedException();
    L59:
        throw new IllegalStateException("Unknown mode is not a selectable option".toString());
    L61:
        r119 = new b(2131903612, 2131903613);
        goto L62
    L51:
        r21 = 3;
        goto L52
    L67:
        LinearLayout.LayoutParams r24 = new LinearLayout.LayoutParams(-1, -2);
        r24.topMargin = 0;
        r11.addView(r14, r24);
        OCardListItem r25 = new OCardListItem(requireContext(), null, 6, 0);
        r25.setCardType(0);
        OCardListItem.h(r25, 0);
        r25.setShowCardBg(true);
        r25.p(false);
        r25.s(false);
        r25.q(false);
        r25.m(false);
        r25.r(false);
        S90(r25);
        OUICardConstraintLayout r26 = r25.getContentContainer();
        ViewGroup.LayoutParams r27 = r26.getLayoutParams();
        r27.height = T90(48);
        r26.setLayoutParams(r27);
        r26.setPadding(0, 0, 0, 0);
        OTextView r28 = new OTextView(r25.getContext(), null, 0, 14);
        r28.setText(getString(2131903618));
        r28.setGravity(17);
        r28.setIncludeFontPadding(false);
        r28.setTextColor(v19.c.a(2130970996, r28.getContext(), 2131102650));
        r28.setTextSize(2, 16.0f);
        Resources r30 = getResources();
        TextViewCompat.setLineHeight(r28, (int) TypedValue.applyDimension(2, 22.0f, WindowDisplayMetricsOverride.apply(r30, r30.getDisplayMetrics())));
        r28.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 400, false));
        ViewGroup.LayoutParams r31 = new ConstraintLayout.LayoutParams(0, 0);
        ((ConstraintLayout.LayoutParams) r31).t = 0;
        ((ConstraintLayout.LayoutParams) r31).v = 0;
        ((ConstraintLayout.LayoutParams) r31).i = 0;
        ((ConstraintLayout.LayoutParams) r31).l = 0;
        Unit r32 = Unit.INSTANCE;
        r26.addView(r28, r31);
        r25.setOnContentClickListener(new v2(this));
        int r33 = T90(16);
        LinearLayout.LayoutParams r34 = new LinearLayout.LayoutParams(-1, -2);
        r34.topMargin = r33;
        r11.addView(r25, r34);
        NestedScrollView r35 = new NestedScrollView(requireContext());
        r35.setClipChildren(false);
        r35.setClipToPadding(false);
        r35.setOverScrollMode(2);
        r35.setFillViewport(true);
        LinearLayout.LayoutParams r36 = new LinearLayout.LayoutParams(-1, -2);
        r36.topMargin = 0;
        r35.addView(r11, r36);
        OSheetBase.DefaultImpls.j(r1, r35);
        r1.setOnDismissListener(new u2(this));
        return r1;
    L25:
        r10 = null;
        goto L26
    }
}
