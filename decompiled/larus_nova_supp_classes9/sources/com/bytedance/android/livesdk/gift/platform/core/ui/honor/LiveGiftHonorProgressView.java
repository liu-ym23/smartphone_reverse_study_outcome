package com.bytedance.android.livesdk.gift.platform.core.ui.honor;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class LiveGiftHonorProgressView extends View {
    public GradientDrawable a;
    public GradientDrawable b;
    public GradientDrawable c;
    public ClipDrawable d;

    public interface a {
    }

    public void setHonorProgressCallBack(a r1) {
    }

    public final void a() {
        GradientDrawable r0 = new GradientDrawable();
        this.a = r0;
        r0.setShape(0);
        if (getContext() != null) goto L5;
    L11:
        this.a.setColor(s1.h(2131107744));
    L12:
        GradientDrawable r1 = new GradientDrawable();
        this.c = r1;
        r1.setShape(0);
        this.c.setColor(ColorProtector.parseColor("#55ffffff"));
        Drawable r2 = s1.m(2131249231);
        if ((r2 instanceof ClipDrawable) == false) goto L15;
        this.d = (ClipDrawable) r2;
    L15:
        Drawable r3 = s1.m(2131249236);
        if ((r3 instanceof GradientDrawable) == false) goto L18;
        this.b = (GradientDrawable) r3;
        return;
    L18:
        GradientDrawable r4 = new GradientDrawable();
        this.b = r4;
        r4.setColor(ColorProtector.parseColor("#face15"));
        this.b.setShape(0);
        return;
    L5:
        if (getContext().getResources() == null) goto L11;
        if (getContext().getResources().getConfiguration() == null) goto L11;
        if (getContext().getResources().getConfiguration().orientation != 2) goto L11;
        this.a.setColor(ColorProtector.parseColor("#161823"));
        goto L12
    }

    private int getHighlightHeight() {
        return s1.j(2131168723);
    }

    private int getHighlightMargin() {
        return s1.j(2131168724);
    }

    private int getHighlightWidth() {
        return getWidth() - (s1.j(2131168724) * 2);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public LiveGiftHonorProgressView(Context r1) {
        super(r1);
        new ArrayList();
        a();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r9) {
        super.onDraw(r9);
        this.a.setCornerRadius(getHeight() / 2);
        this.a.setBounds(0, 0, getWidth(), getHeight());
        this.b.setBounds(getHighlightMargin(), getHighlightMargin(), ((int) (getHighlightWidth() * 0.0f)) + getHighlightMargin(), getHighlightMargin() + getHighlightHeight());
        this.b.setCornerRadius(getHighlightHeight() / 2);
        this.c.setBounds(0, 0, (int) (getWidth() * 0.0f), getHeight());
        this.c.setCornerRadius(getHeight() / 2);
        ClipDrawable r0 = this.d;
        if (r0 == null) goto L5;
        r0.setBounds(getHighlightMargin(), getHighlightMargin(), getHighlightWidth() + getHighlightMargin(), getHighlightMargin() + getHighlightHeight());
        this.d.setLevel((int) 0.0f);
    L5:
        this.a.draw(r9);
        this.b.draw(r9);
    }

    public LiveGiftHonorProgressView(Context r1, AttributeSet r2) {
        super(r1, r2);
        new ArrayList();
        a();
    }

    public LiveGiftHonorProgressView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        new ArrayList();
        a();
    }
}
