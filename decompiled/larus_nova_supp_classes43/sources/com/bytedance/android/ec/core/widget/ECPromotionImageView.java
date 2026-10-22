package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.drawee.drawable.ScalingUtils;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class ECPromotionImageView extends RoundedFrameLayout {
    public int b;
    public ECDraweeView c;
    public ECNetImageView d;
    public TextView e;
    public LinearLayout f;
    public ECExplainingView g;
    public ECLottieAnimationView h;
    public LinearLayout i;
    public View j;
    public TextView k;
    public ECNetImageView l;
    public com.bytedance.android.ec.core.utils.w m;
    public String n;

    public int getImageRadius() {
        int r0 = this.b;
        if (r0 < 0) goto L5;
        return r0;
    L5:
        Lazy r1 = ECAppInfoService.a;
        if (ECAppInfoService.l() == false) goto L9;
        return 8;
    L9:
        return 2;
    }

    public View getExplaingingLayout() {
        return this.i;
    }

    public ECPromotionImageView(Context r10) {
        super(r10);
        this.b = -1;
        this.n = "ec_live_explain_lottie.json";
        y(r10);
    }

    public final void B(String r10) {
        com.bytedance.android.ec.core.utils.y.e(this.c, r10, -1, -1, this.m);
        this.e.setVisibility(8);
        this.f.setVisibility(8);
        this.i.setVisibility(8);
    }

    public void setAnimation(String r1) {
        this.n = r1;
    }

    public void setCallerContext(com.bytedance.android.ec.core.imagex.r r10) {
        ImageExtensionsKt.D(this.c, r10);
    }

    public void setForceRadius(int r10) {
        this.b = r10;
        setRadius(vf4.a.a(getContext(), this.b));
    }

    public void setPauseStatus(boolean r10) {
        if (ECAppInfoService.h() == true) goto L5;
        return;
    L5:
        if (this.h.getVisibility() != 0) goto L11;
        if (r10 == false) goto L8;
        this.h.pauseAnimation();
        return;
    L8:
        this.h.resumeAnimation();
        return;
    }

    public void setPromotionImageBindConfig(com.bytedance.android.ec.core.utils.w r1) {
        this.m = r1;
    }

    public final void y(Context r10) {
        View.inflate(r10, 2131560762, this);
        this.c = findViewById(2131374627);
        this.d = (ECNetImageView) findViewById(2131374626);
        this.e = (TextView) findViewById(2131391507);
        this.f = (LinearLayout) findViewById(2131378686);
        this.g = (ECExplainingView) findViewById(2131370733);
        this.i = (LinearLayout) findViewById(2131371938);
        this.h = (ECLottieAnimationView) findViewById(2131371937);
        this.j = findViewById(2131392538);
        this.l = (ECNetImageView) findViewById(2131371510);
        this.k = (TextView) findViewById(2131390596);
        this.i.setVisibility(8);
        Lazy r0 = ECAppInfoService.a;
        if (ECAppInfoService.l() == false) goto L6;
        this.f.setBackgroundResource(2131234623);
        this.j.setBackgroundResource(2131234568);
    L10:
        if (ECSettingKeys.P() == false) goto L14;
        this.j.setVisibility(8);
        ECDraweeView r1 = this.c;
        if (r1 == null) goto L14;
        r1.setBackgroundDrawable(null);
        this.c.setPlaceholderImage(2131106155, ScalingUtils.ScaleType.CENTER_INSIDE);
    L14:
        setRadius(vf4.a.a(r10, getImageRadius()));
        return;
    L6:
        if (ECAppInfoService.j() == false) goto L8;
        this.f.setVisibility(8);
        this.e.setTextSize(1, 13.0f);
        goto L10
    L8:
        this.f.setBackgroundResource(2131234622);
        this.j.setBackgroundResource(2131234567);
        goto L10
    }

    public ECPromotionImageView(Context r1, AttributeSet r10) {
        super(r1, r10);
        this.b = -1;
        this.n = "ec_live_explain_lottie.json";
        y(r1);
    }

    public ECPromotionImageView(Context r1, AttributeSet r10, int r11) {
        super(r1, r10, r11);
        this.b = -1;
        this.n = "ec_live_explain_lottie.json";
        y(r1);
    }
}
