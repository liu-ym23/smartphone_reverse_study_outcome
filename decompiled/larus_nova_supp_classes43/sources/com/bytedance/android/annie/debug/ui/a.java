package com.bytedance.android.annie.debug.ui;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.annie.card.AnnieCard;
import com.bytedance.android.annie.scheme.vo.refactor.CardParamVoNew;
import com.bytedance.android.annie.util.p;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class a {
    public final Context a;
    public final AnnieCard b;

    public FrameLayout.LayoutParams a() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    public View c() {
        Context r0 = this.a;
        String r1 = "A-" + this.b.hybridType().getHybridName();
        TextView r10 = new TextView(r0);
        r10.setText(r1);
        r10.setBackgroundColor(ColorProtector.parseColor("#88008800"));
        r10.setTextColor(ColorProtector.parseColor("#FFFFFF"));
        r10.setTextSize(1, 12.0f);
        r10.setGravity(17);
        r10.setMinWidth(p.a.a(36.0f));
        r10.setMaxLines(1);
        return r10;
    }

    public final void b() {
        View r0 = c();
        AnnieCard r1 = this.b;
        FrameLayout.LayoutParams r10 = a();
        CardParamVoNew r11 = this.b.getMHybridParamVoNew();
        if (r11 != null) goto L5;
    L13:
        r1.addView(r0, r10);
        return;
    L5:
        if (this.b.getHeight() < p.a.d()) goto L7;
    L12:
        r10.topMargin = p.f();
        goto L13
    L7:
        if (r11.D() == false) goto L13;
        if (r11.r() == true) goto L12;
        if (r11.i() == false) goto L13;
        goto L12
    }

    public final Context getContext() {
        return this.a;
    }

    public a(Context r10, AnnieCard r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "annieCard");
        this.a = r10;
        this.b = r11;
    }
}
