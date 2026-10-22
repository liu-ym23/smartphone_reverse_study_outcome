package com.obric.oui.privacy;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.Size;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import com.bytedance.ies.xelement.overlay.f;
import com.bytedance.salamander.anniex.b0;
import com.lynx.tasm.utils.j;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$string;
import com.obric.common.oui.R$style;
import com.obric.flow.cardlistpage.ui.view.g;
import com.obric.oui.button.OButton;
import com.obric.oui.image.OImageAppIcon;
import com.obric.oui.orecyclerview.widget.s;
import com.obric.oui.privacy.recyclerview.PrivacyTopDownAlphaMaskRecyclerView;
import com.obric.oui.sheet.v2.OSheet$HeightMode;
import com.obric.oui.sheet.v2.m;
import com.obric.oui.text.OTextView;
import com.obric.oui.window.permission.PrivacyStatementActivity;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import ym.k;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PrivacyStatementActivity f14181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f14182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.obric.oui.sheet.v2.b f14183c;
    public PrivacyTopDownAlphaMaskRecyclerView d;
    public com.obric.oui.window.permission.c e;

    public b(PrivacyStatementActivity r5, c r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "config");
        this.f14181a = r5;
        this.f14182b = r10;
    }

    public static void a(int r5, LinearLayout r10, Size r11, int r12) {
        if (r5 <= 650) goto L5;
        r10.setPadding(0, (int) (r11.getHeight() * 0.135f), 0, (int) ((r11.getHeight() * 0.10375f) - r12));
        return;
    L5:
        r10.setPadding(0, com.lynx.tasm.utils.a.B(20, r10), 0, com.lynx.tasm.utils.a.B(12, r10));
    }

    public final void b() {
        PrivacyStatementActivity r5 = this.f14181a;
        Intrinsics.checkNotNullParameter(r5, "context");
        com.obric.oui.sheet.v2.b r10 = new com.obric.oui.sheet.v2.b(r5);
        r10.f14487h = true;
        r10.f14488i = true;
        r10.f14490k = OSheet$HeightMode.WRAP_HEIGHT;
        int r11 = 0;
        r10.f14491l = false;
        r10.f14492m = true;
        r10.f14494o = true;
        r10.f14495p = 0;
        r10.f14496q = new Size(0, 0);
        r10.f14500v = true;
        r10.f14503y = new com.bytedance.ies.bullet.service.preload.a(r10, 2);
        r10.f14504z = -1;
        Window r12 = r10.getWindow();
        if (r12 == null) goto L6;
        r12.requestFeature(1);
    L6:
        Intrinsics.checkNotNullParameter(r10, "this");
        if (r10.f14491l == false) goto L9;
        int r13 = R$layout.o_sheet_container_overlay;
    L10:
        r10.setContentView(r13);
        Intrinsics.checkNotNullParameter(r5, "context");
        com.obric.oui.sheet.v2.d.g(r10, r5);
        r10.g();
        OSheet$HeightMode r14 = OSheet$HeightMode.FULL_HEIGHT;
        Intrinsics.checkNotNullParameter(r10, "this");
        Intrinsics.checkNotNullParameter(r14, "height");
        r10.setHeightStyle(r14);
        m r15 = r10.getScaffoldController();
        r15.getClass();
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r15.f14515j = r14;
        r10.getScaffoldController().e();
        r10.setCanceledOnTouchOutside(false);
        r10.setCancelable(false);
        com.obric.oui.sheet.v2.d.f(r10, ContextCompat.getColor(r10.getContext(), R$color.oui_bg_base_2));
        c r16 = this.f14182b;
        AttributeSet r17 = null;
        String r18 = r16.f14186c;
        if (r18 != null) goto L13;
    L20:
        OTextView r19 = null;
    L21:
        LinearLayout r110 = new LinearLayout(r5);
        r110.setOrientation(1);
        r110.setGravity(1);
        r110.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        OImageAppIcon r111 = new OImageAppIcon(r5, r17, 6, r11);
        int r112 = r111.getContext().getResources().getDimensionPixelSize(R$dimen.oui_image_size_xl);
        r111.setLayoutParams(new LinearLayout.LayoutParams(r112, r112));
        String r113 = r16.f14184a;
        if (r113 != null) goto L24;
    L27:
        r110.addView(r111);
        LinearLayout r114 = new LinearLayout(r5);
        r114.setOrientation(1);
        r114.setGravity(1);
        LinearLayout.LayoutParams r115 = new LinearLayout.LayoutParams(-1, -2);
        r115.leftMargin = com.lynx.tasm.utils.a.p(32, r114.getContext());
        r115.rightMargin = com.lynx.tasm.utils.a.p(32, r114.getContext());
        r115.topMargin = com.lynx.tasm.utils.a.p(20, r114.getContext());
        r114.setLayoutParams(r115);
        OTextView r116 = new OTextView(new ContextThemeWrapper(r5, R$style.Title_4_Bold), null, 0, 14);
        r116.setIncludeFontPadding(true);
        r116.setTextColor(ContextCompat.getColor(r116.getContext(), R$color.oui_basic_text_1));
        r116.setText(r16.f14185b);
        r116.setGravity(17);
        r116.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        r114.addView(r116);
        if (r19 == null) goto L30;
        r114.addView(r19);
    L30:
        r110.addView(r114);
        Size r20 = j.n(r110.getContext());
        int r117 = com.lynx.tasm.utils.a.y(r10.getContext(), r20.getHeight());
        if (r19 != null) goto L33;
        int r118 = 0;
    L34:
        a(r117, r110, r20, r118);
        com.obric.oui.sheet.v2.d.e(r10, r110);
        int r21 = com.lynx.tasm.utils.a.y(r5, j.n(r5).getHeight());
        FrameLayout r119 = new FrameLayout(r5);
        FrameLayout.LayoutParams r120 = new FrameLayout.LayoutParams(-1, -1);
        r120.bottomMargin = com.lynx.tasm.utils.a.p(8, r119.getContext());
        r119.setLayoutParams(r120);
        PrivacyTopDownAlphaMaskRecyclerView r22 = new PrivacyTopDownAlphaMaskRecyclerView(r5, r17, 6, r11);
        r22.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (r21 <= 650) goto L37;
        r22.setPadding(0, com.lynx.tasm.utils.a.p(16, r22.getContext()), 0, com.lynx.tasm.utils.a.p(16, r22.getContext()));
    L38:
        r22.setFadeEdgeLength(com.lynx.tasm.utils.a.r(75, r22.getContext()));
        r22.setFadeTop(true);
        r22.setFadeBottom(true);
        r22.setDynamicFade(true);
        r22.setBackgroundColor(0);
        r22.setClipToPadding(false);
        r22.getContext();
        r22.setLayoutManager(new s());
        r22.setAdapter(new com.obric.oui.privacy.adapter.b(r16.d));
        r22.h(new a(this, r22));
        this.d = r22;
        r119.addView(r22);
        com.obric.oui.sheet.v2.d.d(r10, r119);
        LinearLayout r23 = new LinearLayout(r5);
        r23.setOrientation(1);
        r23.setGravity(1);
        r23.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r23.setPadding(com.lynx.tasm.utils.a.p(20, r23.getContext()), com.lynx.tasm.utils.a.p(16, r23.getContext()), com.lynx.tasm.utils.a.p(20, r23.getContext()), com.lynx.tasm.utils.a.p(8, r23.getContext()));
        int r24 = 4;
        String r121 = r16.e;
        if (r121 == null) goto L53;
        OTextView r122 = new OTextView(new ContextThemeWrapper(r5, R$style.Button_1_Regular), null, 0, 14);
        r122.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r122.setTextColor(ContextCompat.getColor(r122.getContext(), R$color.oui_basic_text_1));
        r122.setGravity(GravityCompat.START);
        List r25 = r16.f;
        if (r25.isEmpty() == true) goto L51;
        SpannableString r123 = new SpannableString(r121);
        Iterator r26 = r25.iterator();
    L44:
        if (r26.hasNext() == false) goto L50;
        String r124 = (String) r26.next();
        int r27 = r11;
    L46:
        int r28 = StringsKt.r(r124, r27, r24, r121);
        if (r28 < 0) goto L44;
        int r29 = r124.length() + r28;
        r123.setSpan(new g(this, r124, r122, 1), r28, r29, 33);
        r27 = r29;
        r26 = r26;
        r11 = 0;
        r24 = 4;
        goto L46
    L50:
        r122.setText(r123);
        r122.setMovementMethod(LinkMovementMethod.getInstance());
        r122.setHighlightColor(0);
    L52:
        r23.addView(r122);
        goto L53
    L51:
        r122.setText(r121);
    L53:
        LinearLayout r30 = new LinearLayout(r5);
        r30.setOrientation(1);
        r30.setGravity(1);
        LinearLayout.LayoutParams r31 = new LinearLayout.LayoutParams(-1, -2);
        r31.topMargin = com.lynx.tasm.utils.a.p(14, r30.getContext());
        r30.setLayoutParams(r31);
        r30.setPadding(com.lynx.tasm.utils.a.p(4, r30.getContext()), 0, com.lynx.tasm.utils.a.p(4, r30.getContext()), 0);
        final String r32 = r16.g;
        if (r32 != null) goto L56;
        r32 = r5.getString(R$string.oui_agree);
    L56:
        int r33 = R$style.OStyleV2_OButton_L_Standard_Primary;
        final Function1<View, Unit> r34 = new OPrivacySheet$buildFooterView$agreeButton$1(this);
        r30.addView((OButton) k.d(r5, r33, new OPrivacySheet$createSingleButton$1(r32, r34)));
        final String r35 = r16.f14187h;
        if (r35 != null) goto L59;
        r35 = r5.getString(R$string.oui_exit);
    L59:
        int r36 = R$style.OStyleV2_OButton_L_Trans_Neutral;
        final Function1<View, Unit> r37 = new OPrivacySheet$buildFooterView$exitButton$1(this);
        View r38 = (OButton) k.d(r5, r36, new OPrivacySheet$createSingleButton$1(r35, r37));
        LinearLayout.LayoutParams r39 = new LinearLayout.LayoutParams(-1, -2);
        r39.topMargin = com.lynx.tasm.utils.a.p(12, r38.getContext());
        r38.setLayoutParams(r39);
        r30.addView(r38);
        r23.addView(r30);
        Intrinsics.checkNotNullParameter(r10, "this");
        m.c(r23, r10.getScaffoldController().e);
        r10.g = !r16.f14188i;
        r10.setOnDismissListener(new com.obric.flow.cardlistpage.ui.d(this, 1));
        if (r16.f14189j == false) goto L62;
        r10.setOnKeyListener(new f(this, 1));
    L62:
        r10.s = new b0(this, r110, r118);
        this.f14183c = r10;
        r10.f14488i = r16.f14190k;
        r10.show();
        return;
    L37:
        r22.setPadding(0, 0, 0, 0);
        goto L38
    L33:
        r19.measure(View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtLeast(r20.getWidth() - (com.lynx.tasm.utils.a.p(32, r5) * 2), 0), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        r118 = r19.getLineHeight() * (RangesKt.coerceAtLeast(r19.getLineCount(), 1) - 1);
        goto L34
    L24:
        if (StringsKt.isBlank(r113) == true) goto L27;
        r111.setImagePackageName(r113);
        goto L27
    L13:
        if (StringsKt.isBlank(r18) == true) goto L20;
        r19 = new OTextView(new ContextThemeWrapper(r5, R$style.Body_1_Regular), null, 0, 14);
        r19.setIncludeFontPadding(true);
        r19.setTextColor(ContextCompat.getColor(r19.getContext(), R$color.oui_basic_text_3));
        r19.setText(r18);
        if (Intrinsics.areEqual(Locale.getDefault().getLanguage(), Locale.ENGLISH.getLanguage()) == false) goto L18;
        int r125 = 17;
    L19:
        r19.setGravity(r125);
        r19.setMaxLines(3);
        r19.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams r126 = new LinearLayout.LayoutParams(-2, -2);
        r126.topMargin = com.lynx.tasm.utils.a.p(8, r19.getContext());
        r19.setLayoutParams(r126);
        goto L21
    L18:
        r125 = GravityCompat.START;
        goto L19
    L9:
        r13 = R$layout.o_sheet_container;
        goto L10
    }
}
