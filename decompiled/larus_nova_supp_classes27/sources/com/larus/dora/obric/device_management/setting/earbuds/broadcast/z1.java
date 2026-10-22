package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import com.larus.dora.api.entity.NotificationRule;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.checkbox.OCheckBoxLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.text.OTextView;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class z1<T> implements FlowCollector {
    public final /* synthetic */ DoraObricEarbudsCustomBroadcastRulesFragment a;

    public z1(DoraObricEarbudsCustomBroadcastRulesFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r14, Continuation r15) {
        List r16 = (List) r14;
        if (r16 == null) goto L55;
        final DoraObricEarbudsCustomBroadcastRulesFragment r17 = this.a;
        LinearLayout r0 = r17.h;
        int r1 = 8;
        if (r0 == null) goto L35;
        r0.removeAllViews();
        Iterator<T> r3 = r16.iterator();
        int r4 = 0;
    L10:
        if (r3.hasNext() == false) goto L35;
        T r5 = r3.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        final NotificationRule r7 = (NotificationRule) r5;
        int r8 = r16.size();
        if (r8 > 1) goto L17;
        int r9 = 0;
    L23:
        ViewGroup.MarginLayoutParams r12 = null;
        final OCardListItem r10 = new OCardListItem(r17.requireContext(), null, 6, 0);
        r10.setCardType(0);
        OCardListItem.h(r10, r9);
        r10.setShowCardBg(true);
        r10.p(false);
        String r11 = r7.getRuleDesc();
        if (r11 != null) goto L26;
        r11 = "";
    L26:
        r10.setTitle(r11);
        r10.s(true);
        r10.q(false);
        r10.setDefaultCustomEndView(0);
        r10.m(true);
        OCheckBoxLayout r13 = r10.getEndCheckBox();
        if (r13 == null) goto L29;
        r13.setOnCheckedChangeListener(null);
        r13.setChecked(Intrinsics.areEqual(r7.getStatus(), Boolean.TRUE));
        r13.setPrimaryColor(ContextCompat.getColor(r17.requireContext(), 2131103056));
        r13.setClickable(true);
        r13.setFocusable(true);
        r13.setBackground(null);
        r13.setOnClickListener(new q1(r17, r10, r7));
        OCheckBox r18 = r13.getCheckBox();
        r18.setClickable(true);
        r18.setFocusable(true);
        r18.setBackground(null);
        r18.setOnClickListener(new r1(r17, r10, r7));
    L29:
        r10.r(false);
        r10.o(false);
        ViewGroup.LayoutParams r20 = r10.getCardContainer().getLayoutParams();
        if ((r20 instanceof ViewGroup.MarginLayoutParams) == false) goto L32;
        r12 = (ViewGroup.MarginLayoutParams) r20;
    L32:
        if (r12 == null) goto L34;
        r12.setMarginStart(0);
        r12.setMarginEnd(0);
        r12.leftMargin = 0;
        r12.rightMargin = 0;
        r10.getCardContainer().setLayoutParams(r12);
    L34:
        r10.getContentContainer().setPadding(0, 0, r17.X90(4), 0);
        r10.getTitleContainer().setGravity(16);
        r10.getTitleContainer().setPadding(r17.X90(12), r17.X90(8), r17.X90(8), r17.X90(8));
        OTextView r21 = r10.getTitleView();
        r21.setGravity(8388611);
        r21.setMaxLines(2);
        r21.setTextColor(v19.c.a(2130972079, r21.getContext(), 2131103136));
        r21.setTextSize(2, 16.0f);
        Resources r22 = r17.getResources();
        TextViewCompat.setLineHeight(r21, (int) TypedValue.applyDimension(2, 22.0f, WindowDisplayMetricsOverride.apply(r22, r22.getDisplayMetrics())));
        r21.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 400, false));
        r10.o(false);
        r10.setOnContentClickListener(new s1(r17, r10, r7));
        r10.setOnContentLongClickListener(new t1(r17, r7));
        r0.addView(r10);
        r4 = r6;
        goto L10
    L17:
        if (r4 != 0) goto L20;
        r9 = 1;
        goto L23
    L20:
        if (r4 != (r8 - 1)) goto L22;
        r9 = 3;
        goto L23
    L22:
        r9 = 2;
    L35:
        boolean r110 = r16.isEmpty();
        OPageStatus r111 = this.a.i;
        if (r111 == null) goto L41;
        if (r110 == false) goto L39;
        int r2 = 0;
    L40:
        r111.setVisibility(r2);
        goto L41
    L39:
        r2 = 8;
    L41:
        LinearLayout r112 = this.a.h;
        if (r112 == null) goto L47;
        if (r110 == true) goto L46;
        r1 = 0;
    L46:
        r112.setVisibility(r1);
    L47:
        OSectionSupportiveText r113 = this.a.j;
        if (r113 == null) goto L51;
        r113.setVisibility(0);
    L51:
        return Unit.INSTANCE;
    L55:
        return Unit.INSTANCE;
    }
}
