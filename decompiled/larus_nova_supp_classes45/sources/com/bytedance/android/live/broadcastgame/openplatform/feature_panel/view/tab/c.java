package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.tab;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.widget.CompoundButtonCompat;
import com.bytedance.android.live.broadcastgame.api.model.n0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.dux.popover.menu.PopoverMenuLinearLayout;
import com.bytedance.dux.radio.DuxRadio;
import com.bytedance.dux.text.DuxTextView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ TabSelectorView a;

    public c(TabSelectorView r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout, com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.tab.TabPopoverFilterMenuView, com.bytedance.dux.popover.menu.DuxPopoverMenuView, java.lang.Object] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r17) {
        final TabSelectorView r3 = this.a;
        if (r3.c == false) goto L5;
        r3.c();
        return;
    L5:
        r3.c = true;
        r3.b.setRotation(180.0f);
        Activity r2 = em4.a.getActivity(r3.getContext());
        if (r2 == null) goto L70;
        final n0 r4 = r3.d;
        if (r4 == null) goto L71;
        xl4.a.a r5 = new xl4.a.a(r2);
        boolean r6 = false;
        r5.j = false;
        r5.d = s1.h(2131109391);
        r5.A = true;
        r5.i = Long.MIN_VALUE;
        final TabPopoverFilterMenuView.a r7 = new TabPopoverFilterMenuView.a(r3.getContext());
        List<String> r8 = r4.categoryKeyList;
        if (r8 == null) goto L17;
        Iterator<T> r9 = r8.iterator();
    L15:
        if (r9.hasNext() == false) goto L17;
        final String r11 = (String) r9.next();
        Function1<Integer, Unit> r12 = new TabSelectorView$showSelectorPopup$$inlined$apply$lambda$1(r11, r7, r3, r4);
        r7.a.add(new TabPopoverFilterMenuView.b(r11, TextUtils.equals(r11, r4.a), r12, null));
    L17:
        Unit r13 = Unit.INSTANCE;
        ?? r14 = new TabPopoverFilterMenuView(r7.b, null, 0, 14);
        r14.j = r7.a;
        r14.setPressedWithArrow(false);
        r14.setAdaptLargeFont(null);
        r14.setLimitLargeFontScale(false);
        r14.setOrientation(1);
        Resources r15 = Resources.getSystem();
        r14.setLayoutParams(new LinearLayout.LayoutParams(-2, MathKt.roundToInt(TypedValue.applyDimension(1, 52, WindowDisplayMetricsOverride.apply(r15, r15.getDisplayMetrics())))));
        Iterator<T> r16 = r14.j.iterator();
        int r18 = 0;
    L19:
        if (r16.hasNext() == false) goto L60;
        Object r19 = r16.next();
        int r110 = r18 + 1;
        if (r18 >= 0) goto L23;
        CollectionsKt.throwIndexOverflow();
    L23:
        TabPopoverFilterMenuView.b r111 = (TabPopoverFilterMenuView.b) r19;
        PopoverMenuLinearLayout r112 = LayoutInflater.from(r14.getContext()).inflate(2131567485, r14, r6);
        if (r112 == null) goto L59;
        PopoverMenuLinearLayout r113 = r112;
        r113.setForceLight(true);
        ViewGroup r114 = (ViewGroup) r113.findViewById(2131375718);
        DuxRadio r115 = r113.findViewById(2131382765);
        DuxTextView r116 = r113.findViewById(2131391130);
        ((ArrayList) r14.l).add(r114);
        r113.setOnClickListener(new a(r18, r14));
        if (r18 != 0) goto L29;
        r113.findViewById(2131389146).setVisibility(4);
    L29:
        if (r14.j.size() != 1) goto L31;
        r113.setIndexPos(PopoverMenuLinearLayout.Index.ONLY_ONE);
    L36:
        r14.c(r113);
        CharSequence r21 = r111.a;
        if (r21 == null) goto L39;
        r116.setText(r21);
    L39:
        Typeface r22 = r111.d;
        if (r22 == null) goto L42;
        r116.setTypeface(r22);
    L42:
        r115.setChecked(r111.b);
        r115.setOnCheckedChangeListener(new b(r111, r18));
        CompoundButtonCompat.setButtonTintList(r115, ColorStateList.valueOf(ColorProtector.parseColor("#E6FE2C55")));
        r14.k.put(Integer.valueOf(r18), r115);
        if (r14.getAdaptLargeFont() == false) goto L51;
        ViewGroup.LayoutParams r23 = r114.getLayoutParams();
        if (r23 == null) goto L57;
        ViewGroup.MarginLayoutParams r24 = (ViewGroup.MarginLayoutParams) r23;
        float r25 = 14;
        Resources r26 = Resources.getSystem();
        r24.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, r25, WindowDisplayMetricsOverride.apply(r26, r26.getDisplayMetrics())));
        Resources r27 = Resources.getSystem();
        r24.bottomMargin = MathKt.roundToInt(TypedValue.applyDimension(1, r25, WindowDisplayMetricsOverride.apply(r27, r27.getDisplayMetrics())));
        r114.setLayoutParams(r24);
        r115.setAdaptLargeFont(Boolean.TRUE);
        ViewGroup.LayoutParams r28 = r115.getLayoutParams();
        if (r28 == null) goto L55;
        r28.width = -2;
        r28.height = -2;
        r115.setLayoutParams(r28);
        goto L51
    L55:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L57:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L51:
        if (r14.getLimitLargeFontScale() == false) goto L53;
        com.bytedance.dux.largefont.a.c(r116, 15.0f);
        r115.setLimitLargeFontScale(true);
    L53:
        r14.addView(r113);
        r18 = r110;
        r6 = false;
        goto L19
    L31:
        if (r18 != 0) goto L34;
        r113.setIndexPos(PopoverMenuLinearLayout.Index.FIRST);
        goto L36
    L34:
        if (r18 != (r14.j.size() - 1)) goto L36;
        r113.setIndexPos(PopoverMenuLinearLayout.Index.LAST);
        goto L36
    L59:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.dux.popover.menu.PopoverMenuLinearLayout");
    L60:
        r14.setElevation(100.0f);
        Unit r29 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r14, "view");
        r5.k = r14;
        int r31 = xl4.a.I;
        r5.b = xl4.a.b.a(80);
        xl4.a r32 = new xl4.a(r5);
        r32.setOnDismissListener(new d(r3));
        r32.setFocusable(true);
        r32.setOutsideTouchable(true);
        r3.e = r32;
        xl4.b.c(xl4.b.a, r32, r3, 80, true, 0, s1.f(10.0f), 176);
        return;
    L71:
        return;
    }
}
