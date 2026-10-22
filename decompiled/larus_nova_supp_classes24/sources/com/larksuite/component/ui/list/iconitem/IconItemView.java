package com.larksuite.component.ui.list.iconitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import c08.a;
import c08.b;
import c08.c;
import c08.d;
import com.larksuite.component.ui.list.LarkListItemView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class IconItemView extends LarkListItemView {
    public ImageView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public LinearLayout f;

    @Override // com.larksuite.component.ui.list.LarkListItemView
    public final void b() {
        registerModelBinder(b.class, IconItemView.class, new a());
        registerModelBinder(d.class, IconItemView.class, new c());
    }

    public IconItemView(Context r1) {
        super(r1);
    }

    @Override // com.larksuite.component.ui.list.LarkListItemView
    public final View a(ViewGroup r11) {
        Context r12 = r11.getContext();
        int r0 = (int) j08.b.a(r12, 12.0f);
        LinearLayout r1 = new LinearLayout(r12);
        r1.setOrientation(0);
        r1.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.b = new ImageView(r12);
        LinearLayout.LayoutParams r3 = new LinearLayout.LayoutParams(-2, -2);
        r3.gravity = 16;
        r3.setMarginStart((int) j08.b.a(r12, 20.0f));
        r1.addView(this.b, r3);
        LinearLayout r4 = new LinearLayout(r12);
        this.f = r4;
        r4.setOrientation(1);
        this.f.setPaddingRelative(0, r0, 0, r0);
        LinearLayout.LayoutParams r5 = new LinearLayout.LayoutParams(0, -2);
        r5.gravity = 16;
        r5.weight = 1.0f;
        r5.setMarginStart(r0);
        r5.setMarginEnd(r0);
        this.f.setLayoutParams(r5);
        TextView r2 = new TextView(r12);
        this.c = r2;
        r2.setTextColor(ContextCompat.getColor(r12, 2131106622));
        this.c.setTextSize(16.0f);
        this.c.setEllipsize(TextUtils.TruncateAt.END);
        this.c.setSingleLine(true);
        LinearLayout.LayoutParams r6 = new LinearLayout.LayoutParams(-2, -2);
        this.c.setLayoutParams(r6);
        TextView r7 = new TextView(r12);
        this.e = r7;
        r7.setTextColor(ContextCompat.getColor(r12, 2131106620));
        this.e.setTextSize(14.0f);
        this.e.setEllipsize(TextUtils.TruncateAt.END);
        this.e.setMaxLines(2);
        this.e.setPaddingRelative(0, (int) j08.b.a(r12, 2.0f), 0, 0);
        LinearLayout.LayoutParams r8 = new LinearLayout.LayoutParams(-2, -2);
        this.e.setLayoutParams(r8);
        this.f.addView(this.c);
        this.f.addView(this.e);
        r1.addView(this.f, r5);
        TextView r9 = new TextView(r12);
        this.d = r9;
        r9.setTextColor(ContextCompat.getColor(r12, 2131102420));
        this.d.setCompoundDrawablePadding((int) j08.b.a(r12, 5.0f));
        this.d.setSingleLine(true);
        this.d.setEllipsize(TextUtils.TruncateAt.START);
        this.d.setTextSize(14.0f);
        LinearLayout.LayoutParams r10 = new LinearLayout.LayoutParams(-2, -2);
        r10.setMarginEnd((int) j08.b.a(r12, 20.0f));
        r10.gravity = 16;
        r1.addView(this.d, r10);
        return r1;
    }

    public final void c(int r8) {
        TypedArray r9 = getContext().obtainStyledAttributes(r8, new int[]{2130970307, 2130970308, 2130974332, 2130974471, 2130974595});
        int r0 = r9.getDimensionPixelSize(0, (int) j08.b.a(getContext(), 20.0f));
        int r1 = r9.getDimensionPixelSize(1, (int) j08.b.a(getContext(), 20.0f));
        int r3 = r9.getDimensionPixelSize(4, j08.b.e(getContext(), 16.0f));
        int r4 = r9.getDimensionPixelSize(2, j08.b.e(getContext(), 14.0f));
        int r5 = r9.getDimensionPixelSize(3, j08.b.e(getContext(), 14.0f));
        r9.recycle();
        ((LinearLayout.LayoutParams) this.b.getLayoutParams()).setMarginStart(r0);
        this.b.getLayoutParams().width = r1;
        this.b.getLayoutParams().height = r1;
        this.c.setTextSize(0, r3);
        this.e.setTextSize(0, r4);
        this.d.setTextSize(0, r5);
        requestLayout();
    }

    public IconItemView(Context r1, AttributeSet r2) {
        super(r1, r2);
        if (r2 == null) goto L6;
        c(r2.getStyleAttribute());
        return;
    }

    public IconItemView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        if (r2 == null) goto L6;
        c(r2.getStyleAttribute());
        return;
    }
}
