package com.ss.android.lark.chatwindow.view.tip;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class NewMessageTipView extends FrameLayout {
    public static final int n = 0;
    public TextView a;
    public ImageView b;
    public ProgressBar c;
    public ImageView d;
    public View e;
    public ViewGroup f;
    public FrameLayout g;
    public View h;
    public ImageView i;
    public View j;
    public ImageView k;
    public TextView l;
    public boolean m;

    static {
        n = UIHelper.dp2px(268.0f) - UIHelper.dp2px(92.0f);
    }

    @Override // android.view.View
    public ViewGroup.LayoutParams getLayoutParams() {
        ViewGroup.LayoutParams r0 = super.getLayoutParams();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public NewMessageTipView(Context r2) {
        this(r2, null);
    }

    public void setArrowDirection(boolean r5) {
        this.m = r5;
        ImageView r6 = this.b;
        Context r0 = getContext();
        if (this.m == false) goto L5;
        int r1 = 2131256087;
    L6:
        r6.setImageDrawable(UDIconUtils.getIconDrawable(r0, r1, UDColorUtils.getColor(getContext(), 2131105548)));
        return;
    L5:
        r1 = 2131254259;
        goto L6
    }

    public void setLoadingState(boolean r3) {
        if (r3 == false) goto L5;
        this.b.setVisibility(8);
        this.c.setVisibility(0);
        return;
    L5:
        this.b.setVisibility(0);
        this.c.setVisibility(8);
    }

    public NewMessageTipView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public NewMessageTipView(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        PathInterpolatorCompat.create(0.32f, 0.94f, 0.6f, 1.0f);
        LayoutInflater.from(getContext()).inflate(2131563368, this, true);
        UDShadowLayout r5 = findViewById(2131380749);
        this.e = findViewById(2131380747);
        TextView r6 = (TextView) findViewById(2131388367);
        this.a = r6;
        r6.setMaxWidth(n);
        this.b = (ImageView) findViewById(2131387252);
        this.c = (ProgressBar) findViewById(2131378977);
        this.d = (ImageView) findViewById(2131374931);
        this.f = (ViewGroup) findViewById(2131380748);
        this.g = (FrameLayout) findViewById(2131387259);
        this.h = findViewById(2131363792);
        this.i = (ImageView) findViewById(2131363791);
        this.j = findViewById(2131380554);
        this.k = (ImageView) findViewById(2131374703);
        this.l = (TextView) findViewById(2131390974);
        if ((this.i.getDrawable() instanceof LayerDrawable) == false) goto L7;
        Drawable r7 = ((LayerDrawable) this.i.getDrawable()).findDrawableByLayerId(2131370105);
        if (r7 == null) goto L7;
        r7.setTint(UDColorUtils.getColor(getContext(), 2131102418));
    L7:
        zz7.a.a(this.d, 20);
        TextView r8 = this.a;
        LarkFont r9 = LarkFont.HEADLINE;
        zz7.a.d(r8, r9);
        zz7.a.d(this.l, r9);
        zz7.a.a(this.b, 12);
        zz7.a.a(this.c, 12);
        zz7.a.a(this.k, 14);
    }
}
