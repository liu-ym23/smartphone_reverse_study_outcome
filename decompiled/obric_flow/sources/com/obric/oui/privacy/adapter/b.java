package com.obric.oui.privacy.adapter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$style;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.a0;
import com.obric.oui.orecyclerview.widget.x0;
import com.obric.oui.privacy.d;
import com.obric.oui.text.OTextView;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f14179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f14180c;
    public final Lazy d;

    public b(List r5) {
        Intrinsics.checkNotNullParameter(r5, "items");
        this.f14179b = r5;
        this.f14180c = LazyKt.lazy(new PrivacySheetAdapter$switchItemCount$2(this));
        this.d = LazyKt.lazy(new PrivacySheetAdapter$switchStartIndex$2(this));
    }

    @Override // com.obric.oui.orecyclerview.widget.a0
    public final int getItemCount() {
        return this.f14179b.size();
    }

    @Override // com.obric.oui.orecyclerview.widget.a0
    public final int getItemViewType(int r5) {
        if ((((d) this.f14179b.get(r5)) instanceof d) == false) goto L7;
        return 1;
    L7:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.obric.oui.orecyclerview.widget.a0
    public final void onBindViewHolder(x0 r14, int r15) {
        Intrinsics.checkNotNullParameter(r14, "holder");
        boolean r5 = r14 instanceof c;
        List r10 = this.f14179b;
        if (r5 == true) goto L12;
        if ((r14 instanceof a) == false) goto L10;
        d r13 = (d) r10.get(r15);
        a r16 = (a) r14;
        r16.getClass();
        Intrinsics.checkNotNullParameter(r13, "item");
        Context r17 = r16.g.getContext();
        LinearLayout r18 = r16.f14178h;
        r18.removeAllViews();
        OTextView r11 = new OTextView(new ContextThemeWrapper(r17, R$style.Body_1_Regular), null, 0, 14);
        r11.setIncludeFontPadding(true);
        r11.setTextColor(ContextCompat.getColor(r17, R$color.oui_basic_text_1));
        r11.setText(r13.f14191a);
        LinearLayout.LayoutParams r12 = new LinearLayout.LayoutParams(-1, -2);
        r12.setMargins(com.lynx.tasm.utils.a.p(12, r17), com.lynx.tasm.utils.a.p(8, r17), com.lynx.tasm.utils.a.p(12, r17), com.lynx.tasm.utils.a.p(8, r17));
        r11.setLayoutParams(r12);
        r18.addView(r11);
        Iterator r19 = r13.f14192b.iterator();
    L8:
        if (r19.hasNext() == false) goto L18;
        String r20 = (String) r19.next();
        LinearLayout r21 = new LinearLayout(r17);
        r21.setOrientation(0);
        r21.setGravity(48);
        r21.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        LinearLayout r22 = new LinearLayout(r17);
        r22.setPadding(com.lynx.tasm.utils.a.B(4, r22), com.lynx.tasm.utils.a.B(4, r22), 0, 0);
        r22.setGravity(17);
        r22.setLayoutParams(new LinearLayout.LayoutParams(com.lynx.tasm.utils.a.B(24, r22), com.lynx.tasm.utils.a.B(20, r22)));
        View r110 = new View(r17);
        int r111 = com.lynx.tasm.utils.a.C(r110, 3.43d);
        r110.setLayoutParams(new LinearLayout.LayoutParams(r111, r111));
        GradientDrawable r112 = new GradientDrawable();
        r112.setShape(1);
        r112.setColor(ContextCompat.getColor(r17, R$color.oui_basic_text_3b));
        r110.setBackground(r112);
        r22.addView(r110);
        r21.addView(r22);
        OTextView r23 = new OTextView(new ContextThemeWrapper(r17, R$style.Subtitle_2_Regular), null, 0, 14);
        r23.setIncludeFontPadding(true);
        r23.setTextColor(ContextCompat.getColor(r17, R$color.oui_basic_text_3));
        r23.setText(r20);
        r23.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        r23.setPadding(0, com.lynx.tasm.utils.a.B(4, r23), 0, com.lynx.tasm.utils.a.B(4, r23));
        r21.addView(r23);
        r18.addView(r21);
        goto L8
    L18:
        return;
    L10:
        return;
    L12:
        if (r10.get(r15) != null) goto L16;
        ((Number) this.f14180c.getValue()).intValue();
        ((Number) this.d.getValue()).intValue();
        ((c) r14).getClass();
        Intrinsics.checkNotNullParameter(null, "item");
        throw null;
    L16:
        throw new ClassCastException();
    }

    @Override // com.obric.oui.orecyclerview.widget.a0
    public final x0 onCreateViewHolder(ViewGroup r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        int r12 = a.f14177i;
        Context r13 = r10.getContext();
        Intrinsics.checkNotNullParameter(r13, "context");
        OCardListItem r14 = new OCardListItem(r13, null, 6, 0);
        r14.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r14.f13547k.setVisibility(8);
        r14.f();
        r14.k(false);
        r14.j(false);
        return new a(r14);
    L7:
        throw new IllegalArgumentException(Intrinsics.stringPlus("Unknown viewType: ", Integer.valueOf(r11)));
    L8:
        int r15 = c.g;
        Context r16 = r10.getContext();
        Intrinsics.checkNotNullParameter(r16, "context");
        OCardListItem r17 = new OCardListItem(r16, null, 6, 0);
        r17.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r17.setDefaultCustomEndView(1);
        r17.j(true);
        r17.f13547k.setVisibility(8);
        r17.f();
        r17.k(false);
        Intrinsics.checkNotNullParameter(r17, "cardListItem");
        return new c(r17);
    }
}
