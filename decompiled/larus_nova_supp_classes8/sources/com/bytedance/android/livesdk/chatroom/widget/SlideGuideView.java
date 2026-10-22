package com.bytedance.android.livesdk.chatroom.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.uikit.rtl.AutoRTLTextView;
import com.bytedance.android.live.uikit.util.RTLUtil;
import com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenConst;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.t3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class SlideGuideView extends RelativeLayout {
    public LottieAnimationView a;
    public View b;
    public AutoRTLTextView c;
    public View d;
    public e e;
    public String f;
    public Animation g;
    public Animation h;
    public Animation i;
    public Animation j;

    public class a implements View.OnClickListener {
        public final /* synthetic */ SlideGuideView a;

        public a(SlideGuideView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            e r2 = this.a.e;
            if (r2 == null) goto L6;
            r2.onClick();
            return;
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ SlideGuideView a;

        public b(SlideGuideView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.e.onClick();
        }
    }

    public class c implements Animation.AnimationListener {
        public final /* synthetic */ SlideGuideView a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r1) {
        }

        public c(SlideGuideView r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r2) {
            this.a.d.setVisibility(8);
            this.a.b.setVisibility(8);
        }
    }

    public static /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ClearScreenConst.GuideType.values().length];
            a = r0;
            r0[ClearScreenConst.GuideType.CLEAR_MODE_CHECK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            a[ClearScreenConst.GuideType.SHOW_CLEAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public interface e {
        void onClick();
    }

    public final void b() {
        if (this.g == null) goto L5;
    L6:
        this.d.clearAnimation();
    L8:
        if (this.h == null) goto L10;
    L11:
        this.b.clearAnimation();
        return;
    L10:
        if (this.j != null) goto L11;
        return;
    L5:
        if (this.i == null) goto L8;
        goto L6
    }

    public final void e() {
        if (this.g != null) goto L6;
        AlphaAnimation r0 = new AlphaAnimation(0.0f, 1.0f);
        this.g = r0;
        r0.setDuration(160);
    L6:
        if (this.h != null) goto L8;
        AlphaAnimation r1 = new AlphaAnimation(0.0f, 1.0f);
        this.h = r1;
        r1.setDuration(320);
        this.h.setStartOffset(160);
    L8:
        this.d.clearAnimation();
        this.b.clearAnimation();
        this.d.startAnimation(this.g);
        this.b.startAnimation(this.h);
    }

    public final void f() {
        if (this.i != null) goto L6;
        AlphaAnimation r0 = new AlphaAnimation(1.0f, 0.0f);
        this.i = r0;
        r0.setDuration(160);
        this.i.setStartOffset(160);
        this.i.setAnimationListener(new c(this));
    L6:
        if (this.j != null) goto L8;
        AlphaAnimation r1 = new AlphaAnimation(1.0f, 0.0f);
        this.j = r1;
        r1.setDuration(320);
    L8:
        this.d.clearAnimation();
        this.b.clearAnimation();
        this.d.startAnimation(this.i);
        this.b.startAnimation(this.j);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        View r0 = this.d;
        int r1 = r3.a;
        if (r0 == null) goto L6;
        r0.postDelayed(new t3(r0), 100);
        return;
    }

    public SlideGuideView(Context r1) {
        super(r1);
        c(r1);
    }

    public final void a(ClearScreenConst.GuideType r3) {
        int r4 = d.a[r3.ordinal()];
        if (r4 != 1) goto L5;
        GradientDrawable.Orientation r1 = GradientDrawable.Orientation.TOP_BOTTOM;
        GradientDrawable r0 = new GradientDrawable(r1, new int[]{0, 83886080, Integer.MIN_VALUE});
        this.d.setBackground(r0);
        RelativeLayout.LayoutParams r5 = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
        r5.addRule(12);
        r5.bottomMargin = com.bytedance.android.live.core.utils.s1.f(122.0f);
        this.b.setLayoutParams(r5);
        return;
    L5:
        if (r4 != 2) goto L11;
        this.d.setBackground(getResources().getDrawable(2131106888));
        return;
    }

    public final void c(Context r3) {
        RelativeLayout.inflate(getContext(), 2131566747, this);
        this.d = findViewById(2131367743);
        this.b = findViewById(2131367782);
        this.a = findViewById(2131386881);
        this.c = findViewById(2131390479);
        if (RTLUtil.isAppRTL(r3) == false) goto L5;
        this.c.setText(2131922543);
    L6:
        r3.a(this.d, this.c.getText().toString());
        RelativeLayout.LayoutParams r4 = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
        r4.addRule(13);
        this.b.setLayoutParams(r4);
        if (this.e != null) goto L9;
        this.d.setClickable(false);
        return;
    L9:
        this.d.setOnClickListener(new a(this));
        return;
    L5:
        this.c.setText(2131922544);
        goto L6
    }

    public void setAnimResource(String r2) {
        if (this.a != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return;
    L7:
        if (r2.equals(this.f) == false) goto L9;
        return;
    L9:
        this.f = r2;
        this.a.setAnimation(r2);
        this.a.loop(true);
        this.a.playAnimation();
    }

    public void setAnimResourceGecko(String r3) {
        if (this.a != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r3) == false) goto L7;
        return;
    L7:
        if (r3.equals(this.f) == false) goto L9;
        return;
    L9:
        this.f = r3;
        String r0 = com.bytedance.android.livesdk.chatroom.utils.i2.a;
        com.bytedance.android.livesdk.chatroom.utils.i2.g(this.a, "/guideview/".concat(r3));
    }

    public void setClickListener(e r3) {
        this.d.setClickable(true);
        this.e = r3;
        this.d.setOnClickListener(new b(this));
    }

    public void setDestText(String r2) {
        AutoRTLTextView r0 = this.c;
        if (r0 == null) goto L5;
        r0.setText(r2);
    L5:
        r3.a(this.d, r2);
    }

    public void setDestTextSize(int r3) {
        AutoRTLTextView r0 = this.c;
        if (r0 == null) goto L6;
        r0.setTextSize(1, r3);
        return;
    }

    public SlideGuideView(Context r1, AttributeSet r2) {
        super(r1, r2);
        c(r1);
    }

    public void d(String r2, String r3) {
        if (this.a != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r3) == false) goto L9;
        return;
    L9:
        if (r2.equals(this.f) == false) goto L11;
        return;
    L11:
        this.f = r2;
        this.a.setAnimation(r2);
        this.a.setImageAssetsFolder(r3);
        this.a.loop(true);
        this.a.playAnimation();
    }

    public SlideGuideView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        c(r1);
    }
}
