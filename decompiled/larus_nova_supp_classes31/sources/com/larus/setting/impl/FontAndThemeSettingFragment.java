package com.larus.setting.impl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.font.FontLevel;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.roundlayout.RoundTextView;
import com.larus.platform.api.IFlowThemeConfigProvider;
import com.larus.platform.api.ThemeColorKey;
import com.larus.platform.api.ThemeConfigScene;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.setting.impl.databinding.LarusPageSettingFontAndThemeBinding;
import com.larus.setting.impl.view.FontSizeSettingView;
import com.larus.settings.value.e10;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 W2\u00020\u0001:\u0001WB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010'\u001a\u00020%H\u0002J\b\u0010(\u001a\u00020%H\u0016J\n\u0010)\u001a\u0004\u0018\u00010*H\u0002J\b\u0010+\u001a\u00020%H\u0002J\b\u0010,\u001a\u00020%H\u0002J\b\u0010-\u001a\u00020%H\u0002J\n\u0010.\u001a\u0004\u0018\u00010/H\u0002J\u000f\u00100\u001a\u0004\u0018\u00010%H\u0002¢\u0006\u0002\u00101J\u0010\u00102\u001a\u00020\r2\u0006\u00103\u001a\u00020\rH\u0002J\u0010\u00104\u001a\u00020\r2\u0006\u00105\u001a\u00020\rH\u0002J\u0018\u00106\u001a\u00020%2\u0006\u00107\u001a\u00020\r2\u0006\u00108\u001a\u00020\rH\u0002J\u0017\u00109\u001a\u0004\u0018\u00010%2\u0006\u0010:\u001a\u00020\rH\u0002¢\u0006\u0002\u0010;J\u0012\u0010<\u001a\u0004\u0018\u00010/2\u0006\u0010=\u001a\u00020\u0011H\u0002J\u000f\u0010>\u001a\u0004\u0018\u00010%H\u0002¢\u0006\u0002\u00101J\u000f\u0010?\u001a\u0004\u0018\u00010%H\u0002¢\u0006\u0002\u00101J\u0017\u0010@\u001a\u0004\u0018\u00010%2\u0006\u0010A\u001a\u00020\rH\u0002¢\u0006\u0002\u0010;JL\u0010B\u001a\u00020%2\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u00112\b\u0010H\u001a\u0004\u0018\u00010I2\b\u0010J\u001a\u0004\u0018\u00010I2\u0006\u0010K\u001a\u00020\r2\u0006\u0010L\u001a\u00020\rH\u0002J\b\u0010M\u001a\u00020%H\u0002J\u0010\u0010N\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010O\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u001dH\u0002J\u000f\u0010P\u001a\u0004\u0018\u00010%H\u0002¢\u0006\u0002\u00101J\u000f\u0010Q\u001a\u0004\u0018\u00010%H\u0002¢\u0006\u0002\u00101J\u0010\u0010R\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\rH\u0002J\r\u0010S\u001a\u00020\rH\u0000¢\u0006\u0002\bTJ\r\u0010U\u001a\u00020\rH\u0000¢\u0006\u0002\bVR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"Lcom/larus/setting/impl/FontAndThemeSettingFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/larus/setting/impl/databinding/LarusPageSettingFontAndThemeBinding;", "currentPage", "", "getCurrentPage", "()Ljava/lang/String;", "currentPage$delegate", "Lkotlin/Lazy;", "curDarkMode", "", "preFontLevel", "curFontLevel", "hasStabilizedFirstDraw", "", "pendingScrollY", "Ljava/lang/Integer;", "firstTimeAutoScroll", "isThemeStackLayout", "allowUserFontSize14", "allowUserFontSize26", "fontLevelMin", "fontLevelMax", "allowedFontLevels", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "stabilizeFirstDraw", "onDestroyView", "initTitle", "Landroidx/activity/OnBackPressedCallback;", "clickCancelBtn", "clickSaveBtn", "restartApp", "initFont", "Lcom/larus/setting/impl/view/FontSizeSettingView;", "updateFontPreviewIcons", "()Lkotlin/Unit;", "positionToFontLevel", "position", "fontLevelToPosition", "level", "scaleTextViews", "current", "pre", "updateFontResetVisibility", "fontLevel", "(I)Lkotlin/Unit;", "setFontSettingViewAccessibility", "announce", "freezeFontContainerHeight", "initTheme", "selectTheme", "mode", "updateThemeItem", "icon", "Landroid/widget/ImageView;", "label", "Landroid/widget/TextView;", "selected", "bgDefault", "Landroid/graphics/drawable/Drawable;", "bgSelected", "colorDefault", "colorSelected", "updateThemeLayout", "isAnyThemeLabelEllipsized", "isTextEllipsized", "applyThemeHorizontalLayout", "applyThemeStackLayout", "getDarkModeToStatus", "getCurFontLevel", "getCurFontLevel$impl_mainlandRelease", "getCurDarkMode", "getCurDarkMode$impl_mainlandRelease", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class FontAndThemeSettingFragment extends Fragment {
    public static final /* synthetic */ int o = 0;
    public LarusPageSettingFontAndThemeBinding d;
    public final Lazy e;
    public int f;
    public int g;
    public int h;
    public boolean i;
    public Integer j;
    public boolean k;
    public boolean l;
    public final int m;
    public final List<Integer> n;

    public static final class a {
    }

    static {
    }

    public final String getCurrentPage() {
        return (String) this.e.getValue();
    }

    public FontAndThemeSettingFragment() {
        this.e = LazyKt.lazy(new h0(this));
        Lazy r0 = we8.j.a;
        this.f = we8.j.c;
        Lazy r1 = we8.e.a;
        int r2 = we8.e.d;
        this.g = r2;
        this.h = r2;
        this.k = true;
        e10 r3 = e10.a;
        boolean r4 = e10.q().a();
        boolean r5 = e10.q().b();
        if (r4 == false) goto L5;
        FontLevel r6 = FontLevel.EXTRA_SMALL;
    L6:
        int r7 = r6.getValue();
        if (r5 == false) goto L9;
        FontLevel r8 = FontLevel.SUPER_EXTRA_LARGE;
    L10:
        int r9 = r8.getValue();
        this.m = r9;
        this.n = CollectionsKt.toList(new IntRange(r7, r9));
        return;
    L9:
        r8 = FontLevel.EXTRA_LARGE;
        goto L10
    L5:
        r6 = FontLevel.SMALL;
        goto L6
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d = null;
    }

    public static boolean T90(View r1) {
        if ((r1 instanceof TextView) == false) goto L5;
        TextView r2 = (TextView) r1;
    L7:
        if (r2 != null) goto L9;
        return false;
    L9:
        Layout r3 = r2.getLayout();
        if (r3 != null) goto L13;
        return false;
    L13:
        if (r3.getEllipsisCount(0) <= 0) goto L16;
        return true;
    L16:
        return false;
    L5:
        r2 = null;
        goto L7
    }

    public final int S90(int r3) {
        int r4 = RangesKt.coerceIn(r3, ((Number) CollectionsKt.first(this.n)).intValue(), ((Number) CollectionsKt.last(this.n)).intValue());
        int r5 = this.n.indexOf(Integer.valueOf(r4));
        if (r5 >= 0) goto L7;
        return 0;
    L7:
        return r5;
    }

    public final int U90(int r4) {
        if (this.n.isEmpty() == true) goto L5;
        List<Integer> r0 = this.n;
        return ((Number) ListProtector.get(r0, RangesKt.coerceIn(r4, 0, CollectionsKt.getLastIndex(r0)))).intValue();
    L5:
        return FontLevel.STANDARD.getValue();
    }

    public final void W90(int r15) {
        LarusPageSettingFontAndThemeBinding r0 = this.d;
        if (r0 == null) goto L22;
        Context r1 = getContext();
        if (r1 != null) goto L7;
        r1 = AppHost.a.getApplication();
    L7:
        int r2 = v19.c.a(2130972082, r1, 2131103146);
        Context r3 = getContext();
        if (r3 != null) goto L10;
        r3 = AppHost.a.getApplication();
    L10:
        int r4 = v19.c.a(2130972123, r3, 2131103203);
        Drawable r5 = ContextCompat.getDrawable(r0.a.getContext(), 2131239225);
        Drawable r12 = ContextCompat.getDrawable(r0.a.getContext(), 2131239226);
        Z90(r0.r, r0.j, r0.C, false, r5, r12, r2, r4);
        Z90(r0.t, r0.l, r0.E, false, r5, r12, r2, r4);
        Z90(r0.p, r0.h, r0.A, false, r5, r12, r2, r4);
        Z90(r0.s, r0.k, r0.D, false, r5, r12, r2, r4);
        Z90(r0.u, r0.m, r0.F, false, r5, r12, r2, r4);
        Z90(r0.q, r0.i, r0.B, false, r5, r12, r2, r4);
        if (r15 != (-1)) goto L13;
        Z90(r0.r, r0.j, r0.C, true, r5, r12, r2, r4);
        Z90(r0.s, r0.k, r0.D, true, r5, r12, r2, r4);
    L20:
        Unit r16 = Unit.INSTANCE;
        return;
    L13:
        if (r15 != 1) goto L15;
        Z90(r0.t, r0.l, r0.E, true, r5, r12, r2, r4);
        Z90(r0.u, r0.m, r0.F, true, r5, r12, r2, r4);
        goto L20
    L15:
        if (r15 != 2) goto L20;
        Z90(r0.p, r0.h, r0.A, true, r5, r12, r2, r4);
        Z90(r0.q, r0.i, r0.B, true, r5, r12, r2, r4);
        goto L20
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.widget.TextView, com.larus.setting.impl.view.FontSizeSettingView] */
    public final FontSizeSettingView X90(boolean r4) {
        LarusPageSettingFontAndThemeBinding r0 = this.d;
        if (r0 == null) goto L10;
        ?? r1 = r0.b;
        if (r1 == 0) goto L10;
        String r2 = getString(2131899220) + (S90(this.h) + 1);
        if (r4 == false) goto L9;
        r1.announceForAccessibility(r2);
    L9:
        r1.setContentDescription(r2);
        return r1;
    L10:
        return null;
    }

    public final Unit Y90(int r4) {
        LarusPageSettingFontAndThemeBinding r0 = this.d;
        if (r0 == null) goto L11;
        int r2 = 0;
        if (r4 != FontLevel.STANDARD.getValue()) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == false) goto L10;
        r2 = 8;
    L10:
        r0.f.setVisibility(r2);
        r0.z.setVisibility(r2);
        return Unit.INSTANCE;
    L7:
        r5 = false;
        goto L8
    L11:
        return null;
    }

    public final void V90(int r4, int r5) {
        float r6 = c7.c(Integer.valueOf(we8.e.c(r4, r5)));
        LarusPageSettingFontAndThemeBinding r7 = this.d;
        if (r7 == null) goto L7;
        RoundTextView r8 = r7.y;
        if (r8 == null) goto L7;
        Intrinsics.checkNotNullParameter(r8, "<this>");
        r8.setTextSize(0, r8.getTextSize() + r6);
    L7:
        LarusPageSettingFontAndThemeBinding r9 = this.d;
        if (r9 == null) goto L12;
        RoundTextView r10 = r9.x;
        if (r10 == null) goto L12;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.setTextSize(0, r10.getTextSize() + r6);
    L12:
        this.g = this.h;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.larus.setting.impl.i0] */
    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        Integer r0 = null;
        if (r5 != null) goto L5;
    L9:
        Bundle r6 = getArguments();
        if (r6 != null) goto L12;
    L14:
        Integer r7 = null;
    L15:
        this.j = r7;
        LarusPageSettingFontAndThemeBinding r8 = this.d;
        if (r8 == null) goto L18;
        NovaTitleBarEx r9 = r8.w;
        NovaTitleBarEx.Y5(r9, getString(2131909253), null, null, 6);
        r9.setRightTextEnable(true);
        NovaTitleBarEx.o6(r9, getString(2131899222), new n0(this));
        r9.c6(getString(2131899221), null, new o0(this));
        com.larus.utils.v.a(this, new p0(this));
    L18:
        final LarusPageSettingFontAndThemeBinding r10 = this.d;
        if (r10 == null) goto L38;
        boolean r11 = AppHost.a.isOversea();
        AppCompatImageView r1 = r10.g;
        if (r11 == false) goto L23;
        int r2 = 2131241372;
    L24:
        r1.setImageResource(r2);
        AppCompatImageView r3 = r10.e;
        if (r11 == false) goto L27;
        int r12 = 2131241369;
    L28:
        r3.setImageResource(r12);
        com.larus.utils.e1.d(r10.g, new l0(this, r10));
        com.larus.utils.e1.d(r10.e, new m0(this, r10));
        Unit r13 = Unit.INSTANCE;
        Bundle r14 = getArguments();
        if (r14 != null) goto L31;
    L33:
        Integer r15 = null;
    L34:
        if (r15 == null) goto L36;
        int r16 = r15.intValue();
    L37:
        this.h = r16;
        int r17 = U90(S90(r16));
        this.h = r17;
        FontLevel r18 = FontLevel.STANDARD;
        V90(r17, r18.getValue());
        Y90(this.h);
        final int r19 = r18.getValue();
        final int r20 = S90(r19);
        final ?? r21 = new i0(r10, r20, this, r19);
        com.larus.utils.e1.d(r10.f, new j0(r21));
        com.larus.utils.e1.d(r10.z, new k0(r21));
        FontSizeSettingView r22 = r10.b;
        r22.setPointCount(this.n.size());
        r22.setDefaultPosition(S90(this.h));
        X90(false);
        r22.setChangeCallbackListener(new z0(this));
        goto L38
    L36:
        r16 = this.g;
        goto L37
    L31:
        if (r14.containsKey("key_cur_font_level") == false) goto L33;
        r15 = Integer.valueOf(r14.getInt("key_cur_font_level"));
        goto L34
    L27:
        r12 = 2131241368;
        goto L28
    L23:
        r2 = 2131241371;
    L38:
        LarusPageSettingFontAndThemeBinding r23 = this.d;
        if (r23 == null) goto L49;
        Bundle r24 = getArguments();
        if (r24 != null) goto L43;
    L45:
        if (r0 == null) goto L47;
        int r25 = r0.intValue();
    L48:
        this.f = r25;
        W90(r25);
        com.larus.utils.e1.d(r23.r, new q0(this));
        com.larus.utils.e1.d(r23.t, new r0(this));
        com.larus.utils.e1.d(r23.p, new s0(this));
        com.larus.utils.e1.d(r23.s, new t0(this));
        com.larus.utils.e1.d(r23.u, new u0(this));
        com.larus.utils.e1.d(r23.q, new v0(this));
        Unit r26 = Unit.INSTANCE;
        goto L49
    L47:
        r25 = this.f;
        goto L48
    L43:
        if (r24.containsKey("key_cur_dark_mode") == false) goto L45;
        r0 = Integer.valueOf(r24.getInt("key_cur_dark_mode"));
    L49:
        LarusPageSettingFontAndThemeBinding r27 = this.d;
        if (r27 == null) goto L54;
        ConstraintLayout r28 = r27.a;
        r28.getViewTreeObserver().addOnPreDrawListener(new a1(this, r27, r28));
        return;
    L54:
        return;
    L12:
        if (r6.containsKey("key_scroll_y") == false) goto L14;
        r7 = Integer.valueOf(r6.getInt("key_scroll_y"));
        goto L15
    L5:
        if (r5.containsKey("key_scroll_y") == false) goto L7;
        r7 = Integer.valueOf(r5.getInt("key_scroll_y"));
    L8:
        if (r7 != null) goto L15;
    L7:
        r7 = null;
        goto L8
    }

    public final View onCreateView(LayoutInflater r38, ViewGroup r39, Bundle r40) {
        Intrinsics.checkNotNullParameter(r38, "inflater");
        ConstraintLayout r1 = r38.inflate(2131563069, r39, false);
        int r2 = 2131373134;
        FontSizeSettingView r6 = (FontSizeSettingView) ViewBindings.findChildViewById(r1, 2131373134);
        if (r6 == null) goto L98;
        r2 = 2131374012;
        ConstraintLayout r7 = ViewBindings.findChildViewById(r1, 2131374012);
        if (r7 == null) goto L98;
        r2 = 2131374013;
        ConstraintLayout r8 = ViewBindings.findChildViewById(r1, 2131374013);
        if (r8 == null) goto L98;
        r2 = 2131376257;
        AppCompatImageView r9 = ViewBindings.findChildViewById(r1, 2131376257);
        if (r9 == null) goto L98;
        r2 = 2131376259;
        AppCompatImageView r10 = ViewBindings.findChildViewById(r1, 2131376259);
        if (r10 == null) goto L98;
        r2 = 2131376260;
        AppCompatImageView r11 = ViewBindings.findChildViewById(r1, 2131376260);
        if (r11 == null) goto L98;
        r2 = 2131376665;
        AppCompatImageView r12 = ViewBindings.findChildViewById(r1, 2131376665);
        if (r12 == null) goto L98;
        r2 = 2131376666;
        AppCompatImageView r13 = ViewBindings.findChildViewById(r1, 2131376666);
        if (r13 == null) goto L98;
        r2 = 2131376667;
        AppCompatImageView r14 = ViewBindings.findChildViewById(r1, 2131376667);
        if (r14 == null) goto L98;
        r2 = 2131376668;
        AppCompatImageView r15 = ViewBindings.findChildViewById(r1, 2131376668);
        if (r15 == null) goto L98;
        r2 = 2131376669;
        AppCompatImageView r16 = ViewBindings.findChildViewById(r1, 2131376669);
        if (r16 == null) goto L98;
        r2 = 2131376670;
        AppCompatImageView r17 = ViewBindings.findChildViewById(r1, 2131376670);
        if (r17 == null) goto L98;
        r2 = 2131377507;
        ConstraintLayout r18 = ViewBindings.findChildViewById(r1, 2131377507);
        if (r18 == null) goto L98;
        r2 = 2131377508;
        LinearLayout r19 = (LinearLayout) ViewBindings.findChildViewById(r1, 2131377508);
        if (r19 == null) goto L98;
        r2 = 2131377650;
        if (ViewBindings.findChildViewById(r1, 2131377650) == null) goto L98;
        r2 = 2131377651;
        LinearLayout r20 = (LinearLayout) ViewBindings.findChildViewById(r1, 2131377651);
        if (r20 == null) goto L98;
        r2 = 2131377652;
        LinearLayout r21 = (LinearLayout) ViewBindings.findChildViewById(r1, 2131377652);
        if (r21 == null) goto L98;
        r2 = 2131377653;
        LinearLayout r22 = (LinearLayout) ViewBindings.findChildViewById(r1, 2131377653);
        if (r22 == null) goto L98;
        r2 = 2131377654;
        LinearLayout r23 = (LinearLayout) ViewBindings.findChildViewById(r1, 2131377654);
        if (r23 == null) goto L98;
        r2 = 2131377655;
        LinearLayout r24 = (LinearLayout) ViewBindings.findChildViewById(r1, 2131377655);
        if (r24 == null) goto L98;
        r2 = 2131377656;
        LinearLayout r25 = (LinearLayout) ViewBindings.findChildViewById(r1, 2131377656);
        if (r25 == null) goto L98;
        r2 = 2131385238;
        NestedScrollView r26 = ViewBindings.findChildViewById(r1, 2131385238);
        if (r26 == null) goto L98;
        r2 = 2131388772;
        NovaTitleBarEx r27 = ViewBindings.findChildViewById(r1, 2131388772);
        if (r27 == null) goto L98;
        r2 = 2131390654;
        RoundTextView r28 = ViewBindings.findChildViewById(r1, 2131390654);
        if (r28 == null) goto L98;
        r2 = 2131390655;
        RoundTextView r29 = ViewBindings.findChildViewById(r1, 2131390655);
        if (r29 == null) goto L98;
        r2 = 2131390657;
        TextView r30 = (TextView) ViewBindings.findChildViewById(r1, 2131390657);
        if (r30 == null) goto L98;
        r2 = 2131390659;
        if (((TextView) ViewBindings.findChildViewById(r1, 2131390659)) == null) goto L98;
        r2 = 2131391579;
        TextView r31 = (TextView) ViewBindings.findChildViewById(r1, 2131391579);
        if (r31 == null) goto L98;
        r2 = 2131391580;
        TextView r32 = (TextView) ViewBindings.findChildViewById(r1, 2131391580);
        if (r32 == null) goto L98;
        r2 = 2131391581;
        TextView r33 = (TextView) ViewBindings.findChildViewById(r1, 2131391581);
        if (r33 == null) goto L98;
        r2 = 2131391582;
        TextView r34 = (TextView) ViewBindings.findChildViewById(r1, 2131391582);
        if (r34 == null) goto L98;
        r2 = 2131391583;
        TextView r35 = (TextView) ViewBindings.findChildViewById(r1, 2131391583);
        if (r35 == null) goto L98;
        r2 = 2131391584;
        TextView r36 = (TextView) ViewBindings.findChildViewById(r1, 2131391584);
        if (r36 == null) goto L98;
        r2 = 2131391585;
        if (((TextView) ViewBindings.findChildViewById(r1, 2131391585)) == null) goto L98;
        this.d = new LarusPageSettingFontAndThemeBinding(r1, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36);
        IFlowThemeConfigProvider r3 = (IFlowThemeConfigProvider) ServiceManager.get().getService(IFlowThemeConfigProvider.class);
        if (r3 == null) goto L77;
        LarusPageSettingFontAndThemeBinding r4 = this.d;
        if (r4 == null) goto L75;
        RoundTextView r5 = r4.y;
    L76:
        r3.d(r5, ThemeColorKey.MESSAGE_SEND_TEXT_COLOR, ThemeConfigScene.CHAT, AdaptThemeFeatureKey.SEND_MESSAGE_TEXT_AT_FONT_AND_THEME_SETTING_PAGE);
        goto L77
    L75:
        r5 = null;
    L77:
        Context r37 = getContext();
        if (r37 == null) goto L93;
        IFlowThemeConfigProvider r41 = (IFlowThemeConfigProvider) ServiceManager.get().getService(IFlowThemeConfigProvider.class);
        if (r41 == null) goto L86;
        int r42 = Integer.valueOf(r41.a(v19.c.a(2130972123, r37, 2131103203), ThemeColorKey.MESSAGE_BUBBLE_COLOR, ThemeConfigScene.CHAT, AdaptThemeFeatureKey.SEND_MESSAGE_BUBBLE_AT_FONT_AND_THEME_SETTING_PAGE)).intValue();
        LarusPageSettingFontAndThemeBinding r43 = this.d;
        if (r43 == null) goto L86;
        RoundTextView r44 = r43.y;
        if (r44 == null) goto L86;
        r44.setBackgroundColor(r42);
    L86:
        IFlowThemeConfigProvider r45 = (IFlowThemeConfigProvider) ServiceManager.get().getService(IFlowThemeConfigProvider.class);
        if (r45 == null) goto L93;
        int r46 = Integer.valueOf(r45.a(v19.c.a(2130970535, r37, 2131102548), ThemeColorKey.MESSAGE_RECEIVE_BUBBLE_COLOR, ThemeConfigScene.CHAT, AdaptThemeFeatureKey.RECEIVE_MESSAGE_BUBBLE_AT_FONT_AND_THEME_SETTING_PAGE)).intValue();
        LarusPageSettingFontAndThemeBinding r47 = this.d;
        if (r47 == null) goto L93;
        RoundTextView r48 = r47.x;
        if (r48 == null) goto L93;
        r48.setBackgroundColor(r46);
    L93:
        LarusPageSettingFontAndThemeBinding r49 = this.d;
        if (r49 != null) goto L96;
        return null;
    L96:
        return r49.a;
    L98:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r2)));
    }

    public static void Z90(View r0, AppCompatImageView r1, TextView r2, boolean r3, Drawable r4, Drawable r5, int r6, int r7) {
        if (r3 == false) goto L4;
        r4 = r5;
    L4:
        r0.setBackground(r4);
        if (r3 == false) goto L7;
        int r8 = r7;
    L8:
        r1.setColorFilter(r8);
        if (r3 == false) goto L11;
        r6 = r7;
    L11:
        r2.setTextColor(r6);
        return;
    L7:
        r8 = r6;
        goto L8
    }
}
