package com.larus.app.settings.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.app.settings.api.AppSettingsHostServiceDelegate;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.common_ui.view.ChatSettingScrollView;
import com.larus.platform.service.z2;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import hq9.h3;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 =2\u00020\u0001:\u0001=B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u000bH\u0016J\b\u0010 \u001a\u00020\u0015H\u0016J\b\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020&2\u0006\u0010\u001b\u001a\u00020\"H\u0002J\u0010\u0010'\u001a\u00020&2\u0006\u0010\u001b\u001a\u00020\"H\u0002J\u0010\u0010(\u001a\u00020&2\u0006\u0010\u001b\u001a\u00020\"H\u0002J\u0010\u0010)\u001a\u00020&2\u0006\u0010\u001b\u001a\u00020\"H\u0002J4\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u00020\u00152\b\b\u0002\u00101\u001a\u000202H\u0002J4\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u000b2\b\b\u0002\u00100\u001a\u00020\u00152\b\b\u0002\u00101\u001a\u000202H\u0002J\u0010\u00104\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u000bH\u0002J*\u00105\u001a\u00020&2\u0006\u0010\u001b\u001a\u00020\"2\u0006\u00103\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020,2\b\b\u0002\u00106\u001a\u00020\u0015H\u0002J\u0010\u00107\u001a\u00020&2\u0006\u0010\u001b\u001a\u00020\"H\u0002J\b\u00108\u001a\u000209H\u0002J\b\u0010:\u001a\u000209H\u0002J\u0010\u0010;\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u000bH\u0002J\u0010\u0010<\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u000bH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016¨\u0006>"}, d2 = {"Lcom/larus/app/settings/impl/AboutAppFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "displayConfig", "Lcom/larus/platform/model/AboutAppDisplayConfig;", "getDisplayConfig", "()Lcom/larus/platform/model/AboutAppDisplayConfig;", "displayConfig$delegate", "Lkotlin/Lazy;", "appDisplayName", "", "getAppDisplayName", "()Ljava/lang/String;", "appDisplayName$delegate", "hostConfig", "Lcom/larus/app/settings/api/AboutAppHostConfig;", "getHostConfig", "()Lcom/larus/app/settings/api/AboutAppHostConfig;", "hostConfig$delegate", "isOversea", "", "()Z", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "getCurrentPageName", "autoLogEnterPage", "createContent", "Landroid/widget/LinearLayout;", "createBody", "Landroid/widget/FrameLayout;", "addDoubaoSection", "", "addEcommerceSection", "addLocalLifeSection", "addOtherSection", "addLinkItem", "group", "Lcom/larus/bmhome/view/item/ItemGroup;", "semanticId", "titleRes", "", "visible", "clickMode", "Lcom/larus/app/settings/impl/ItemClickMode;", "title", "resolveItemLink", "addSection", "showHeader", "addModelDetail", "createModelDetailText", "Landroid/widget/TextView;", "createHotlineText", "isSectionAllowed", "isItemAllowed", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class AboutAppFragment extends TraceFragment {
    public static final /* synthetic */ int h = 0;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;

    public static final class a {
    }

    static {
    }

    public final boolean S90() {
        return true;
    }

    public final String k() {
        return "about_app";
    }

    public final hq9.c Y90() {
        return (hq9.c) this.e.getValue();
    }

    public final boolean aa0() {
        return ((t48.a) this.g.getValue()).a;
    }

    public AboutAppFragment() {
        this.e = LazyKt.lazy(new com.larus.app.settings.impl.a());
        this.f = LazyKt.lazy(new b(this));
        this.g = LazyKt.lazy(new c());
    }

    public final boolean Z90(String r2) {
        if (Y90().a == true) goto L5;
    L8:
        return true;
    L5:
        if (Y90().c.contains(r2) == true) goto L8;
        return false;
    }

    public final boolean ba0(String r2) {
        if (Y90().a == true) goto L5;
    L8:
        return true;
    L5:
        if (Y90().b.contains(r2) == true) goto L8;
        return false;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.larus.app.settings.impl.d, java.lang.Object] */
    public final View onCreateView(LayoutInflater r24, ViewGroup r25, Bundle r26) {
        Intrinsics.checkNotNullParameter(r24, "inflater");
        LinearLayout r8 = new LinearLayout(requireContext());
        r8.setOrientation(1);
        r8.setBackgroundResource(v19.c.b(2130970531, r8.getContext(), 2131102535));
        Context r0 = r8.getContext();
        String r1 = getString(2131909247, new Object[]{(String) this.f.getValue()});
        final ?? r2 = new d(this);
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r1, "title");
        Intrinsics.checkNotNullParameter(r2, "onBack");
        NovaTitleBarEx r3 = new NovaTitleBarEx(r0);
        Context r4 = r3.getContext();
        Intrinsics.checkNotNullParameter(r4, "<this>");
        r3.setLayoutParams(new LinearLayout.LayoutParams(-1, k.c(r4, 2130971518, 2131167405)));
        NovaTitleBarEx.Y5(r3, r1, null, null, 6);
        NovaTitleBarEx.b6(r3, v19.c.b(2130971749, r3.getContext(), 2131241477), false, null, null, new g(r2), 14);
        r8.addView(r3);
        FrameLayout r13 = new FrameLayout(requireContext());
        r13.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        ChatSettingScrollView r14 = new ChatSettingScrollView(r13.getContext());
        r14.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r14.setVerticalScrollBarEnabled(false);
        int r5 = k.b(r14.getContext());
        Context r6 = r14.getContext();
        Intrinsics.checkNotNullParameter(r6, "<this>");
        int r7 = k.c(r6, 2130971546, 2131167462);
        int r9 = k.b(r14.getContext());
        Context r10 = r14.getContext();
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r14.setPadding(r5, r7, r9, k.c(r10, 2130971457, 2131167284));
        LinearLayout r15 = new LinearLayout(r14.getContext());
        r15.setOrientation(1);
        if (ba0("about.section.doubao") == false) goto L13;
        ItemGroup r11 = new ItemGroup(requireContext());
        W90(this, r11, "about.item.user_agreement", 2131910461, false, null, 24);
        boolean r12 = !aa0();
        ItemClickMode r16 = ItemClickMode.DEBOUNCE;
        U90(r11, "about.item.privacy_policy_summary", 2131908516, r12, r16);
        W90(this, r11, "about.item.privacy_policy", 2131908512, false, null, 24);
        W90(this, r11, "about.item.app_permissions", 2131909316, !aa0(), null, 16);
        W90(this, r11, "about.item.usage_guidelines", 2131900906, false, null, 24);
        W90(this, r11, "about.item.ip_complaint_guide", 2131906761, !aa0(), null, 16);
        W90(this, r11, "about.item.trust_center", 2131909242, aa0(), null, 16);
        W90(this, r11, "about.item.bug_report", 2131910026, aa0(), null, 16);
        U90(r11, "about.item.business_license", 2131898643, !aa0(), r16);
        U90(r11, "about.item.icp_record", 2131898644, !aa0(), r16);
        V90(r11, "about.item.doubao_model", getString(2131909247, new Object[]{getString(2131909746)}), !aa0(), ItemClickMode.DIRECT);
        U90(r11, "about.item.network_culture_license", 2131911146, !aa0(), r16);
        U90(r11, "about.item.value_added_telecom_license", 2131906306, !aa0(), r16);
        if (Z90("about.item.check_update") == true) goto L8;
    L10:
        ItemGroup r17 = r11;
    L11:
        X90(r15, (String) this.f.getValue(), r17, !aa0());
        goto L13
    L8:
        if (AppSettingsHostServiceDelegate.a.c() == false) goto L10;
        r17 = r11;
        k.a(r17, getString(2131909270), ItemClickMode.STICKY_DEBOUNCE_1S, new e(this));
    L13:
        if (aa0() == true) goto L19;
        if (ba0("about.section.douyin_ecommerce") == false) goto L19;
        ItemGroup r19 = new ItemGroup(requireContext());
        W90(this, r19, "about.item.ecommerce_qualification", 2131897450, false, ItemClickMode.DEBOUNCE, 8);
        X90(r15, getString(2131897449), r19, true);
    L19:
        if (aa0() == true) goto L25;
        if (ba0("about.section.douyin_local_life") == false) goto L25;
        ItemGroup r110 = new ItemGroup(requireContext());
        ItemClickMode r111 = ItemClickMode.DEBOUNCE;
        W90(this, r110, "about.item.local_life_qualification", 2131897453, false, r111, 8);
        W90(this, r110, "about.item.local_life_user_agreement", 2131897455, false, r111, 8);
        W90(this, r110, "about.item.local_life_privacy_policy", 2131897452, false, r111, 8);
        W90(this, r110, "about.item.local_life_rule_center", 2131897454, false, r111, 8);
        X90(r15, getString(2131897451), r110, true);
    L25:
        if (aa0() == true) goto L31;
        if (ba0("about.section.other") == false) goto L31;
        ItemGroup r112 = new ItemGroup(requireContext());
        W90(this, r112, "about.item.shopping_payment_faq", 2131897457, false, ItemClickMode.DEBOUNCE, 8);
        X90(r15, getString(2131897456), r112, true);
    L31:
        if (aa0() == false) goto L33;
    L44:
        int r20 = -1;
    L45:
        r14.addView(r15);
        r13.addView(r14);
        if (aa0() == false) goto L48;
    L50:
        r8.addView(r13);
        return r8;
    L48:
        if (Z90("about.item.customer_hotline") == false) goto L50;
        TextView r21 = new TextView(requireContext());
        r21.setLayoutParams(new FrameLayout.LayoutParams(r20, -2, 80));
        r21.setGravity(17);
        Context r22 = r21.getContext();
        Intrinsics.checkNotNullParameter(r22, "<this>");
        Resources r23 = r22.getResources();
        int r27 = (int) (WindowDisplayMetricsOverride.apply(r23, r23.getDisplayMetrics()).density * 16);
        r21.setPadding(r27, r27, r27, r27);
        r21.setText(getString(2131906288));
        r21.setTextSize(0, k.b(r21.getContext()));
        r21.setTextColor(r21.getContext().getColor(v19.c.b(2130972081, r21.getContext(), 2131103143)));
        r13.addView(r21);
        goto L50
    L33:
        if (Z90("about.item.model_detail") == false) goto L44;
        h3 r29 = z2.a.getModelFilingInfoConfig();
        String r30 = Build.MANUFACTURER;
        String r31 = "";
        if (r30 != null) goto L37;
        r30 = "";
    L37:
        String r32 = Build.BRAND;
        if (r32 == null) goto L42;
        r31 = r32;
    L42:
        if (r29.a(r30, r31) == false) goto L44;
        TextView r33 = new TextView(requireContext());
        r20 = -1;
        LinearLayout.LayoutParams r34 = new LinearLayout.LayoutParams(-1, -2);
        Context r35 = requireContext();
        Intrinsics.checkNotNullParameter(r35, "<this>");
        r34.topMargin = k.c(r35, 2130971208, 2131166786);
        r33.setLayoutParams(r34);
        r33.setGravity(17);
        r33.setText(getString(2131909257));
        r33.setTextSize(0, k.b(r33.getContext()));
        r33.setTextColor(r33.getContext().getColor(v19.c.b(2130972081, r33.getContext(), 2131103143)));
        r15.addView(r33);
        goto L45
    }

    public final void X90(LinearLayout r10, String r11, ItemGroup r12, boolean r13) {
        if (r12.getChildCount() != 0) goto L5;
        return;
    L5:
        LinearLayout r0 = new LinearLayout(requireContext());
        boolean r1 = true;
        r0.setOrientation(1);
        if (r10.getChildCount() <= 0) goto L8;
        LinearLayout.LayoutParams r2 = new LinearLayout.LayoutParams(-1, -2);
        Context r8 = requireContext();
        Intrinsics.checkNotNullParameter(r8, "<this>");
        r2.topMargin = k.c(r8, 2130971208, 2131166786);
        r0.setLayoutParams(r2);
    L8:
        if (r13 == false) goto L19;
        Context r14 = r0.getContext();
        Intrinsics.checkNotNullParameter(r14, "<this>");
        Intrinsics.checkNotNullParameter(r11, "text");
        TextView r3 = new TextView(r14);
        LinearLayout.LayoutParams r9 = new LinearLayout.LayoutParams(-1, -2);
        Context r6 = r3.getContext();
        Intrinsics.checkNotNullParameter(r6, "<this>");
        r9.setMarginStart(k.c(r6, 2130971208, 2131166786));
        Context r4 = r3.getContext();
        Intrinsics.checkNotNullParameter(r4, "<this>");
        r9.bottomMargin = k.c(r4, 2130971546, 2131167462);
        r3.setLayoutParams(r9);
        r3.setText(r11);
        r3.setTextColor(r14.getColor(v19.c.b(2130972081, r3.getContext(), 2131103143)));
        Context r15 = r3.getContext();
        Intrinsics.checkNotNullParameter(r15, "<this>");
        r3.setTextSize(0, k.c(r15, 2130971174, 2131166718));
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (Build.VERSION.SDK_INT < 28) goto L18;
        Typeface r16 = r3.getTypeface();
        Typeface r5 = r3.getTypeface();
        if (r5 != null) goto L14;
    L16:
        r1 = false;
    L17:
        r3.setTypeface(Typeface.create(r16, 500, r1));
        goto L18
    L14:
        if (r5.isItalic() != true) goto L16;
    L18:
        r0.addView(r3);
    L19:
        r0.addView(r12);
        r12.c();
        r10.addView(r0);
    }

    public final void U90(ItemGroup r7, String r8, int r9, boolean r10, ItemClickMode r11) {
        V90(r7, r8, getString(r9), r10, r11);
    }

    public final void V90(ItemGroup r5, final String r6, String r7, boolean r8, ItemClickMode r9) {
        if (r8 == true) goto L4;
        return;
    L4:
        if (Z90(r6) == false) goto L33;
        boolean r0 = false;
        if (Intrinsics.areEqual(r6, "about.item.doubao_model") == false) goto L17;
        final String r10 = z2.a.B0().b();
        if (r10 != null) goto L11;
    L14:
        boolean r2 = true;
    L15:
        if (r2 == true) goto L17;
    L27:
        final boolean r1 = !((t48.a) this.g.getValue()).c.contains(r6);
        ItemTextArrow r11 = k.a(r5, r7, r9, new f(r1, r10, r6, this));
        if (r1 == true) goto L32;
        e1.o(r11.getArrowView());
        return;
    L32:
        return;
    L11:
        if (r10.length() == 0) goto L14;
        r2 = false;
    L17:
        r10 = (String) Y90().d.get(r6);
        if (r10 != null) goto L21;
        r10 = "";
    L21:
        if (r10.length() != 0) goto L23;
        r0 = true;
    L23:
        if (r0 == false) goto L27;
        r10 = ((t48.a) this.g.getValue()).b.get(r6);
        if (r10 != null) goto L27;
        r10 = "";
        goto L27
    }

    public static /* synthetic */ void W90(AboutAppFragment r6, ItemGroup r7, String r8, int r9, boolean r10, ItemClickMode r11, int r12) {
        if ((r12 & 8) == 0) goto L5;
        boolean r4 = true;
    L7:
        if ((r12 & 16) == 0) goto L9;
        r11 = ItemClickMode.DIRECT;
    L9:
        r6.U90(r7, r8, r9, r4, r11);
        return;
    L5:
        r4 = r10;
        goto L7
    }
}
