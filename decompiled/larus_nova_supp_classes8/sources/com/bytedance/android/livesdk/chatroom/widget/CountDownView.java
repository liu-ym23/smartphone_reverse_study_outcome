package com.bytedance.android.livesdk.chatroom.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.r3;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.UIUtils;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class CountDownView extends FrameLayout {
    public static final /* synthetic */ int h = 0;
    public Animation a;
    public TextView b;
    public TextView c;
    public b d;
    public int e;
    public boolean f;
    public Disposable g;

    public class a implements Observer<Long> {
        public final /* synthetic */ long a;
        public final /* synthetic */ CountDownView b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Long d;
        public final /* synthetic */ CountDownView e;

        public final void onComplete() {
            CountDownView.a(this.e);
            if (this.c == false) goto L6;
            CountDownView r0 = this.e;
            String r1 = String.valueOf(System.currentTimeMillis() - this.d.longValue());
            r0.getClass();
            HashMap r2 = new HashMap();
            r2.put("duration", r1);
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_room_countdown_duration", r2, new Object[0]);
            return;
        }

        public final void onError(Throwable r1) {
            CountDownView.a(this.e);
        }

        public final void onNext(Object r5) {
            Long r6 = (Long) r5;
            Logger.d("LiveCountDownView start", r6.toString());
            this.e.b.setText(String.valueOf(r6));
            if (this.e.f == false) goto L10;
            if (r6.equals(Long.valueOf(this.a)) == false) goto L7;
            CharSequence r0 = "倒计时" + this.e.b.getText();
        L8:
            this.b.setContentDescription(r0);
            this.e.b.setContentDescription(r0);
            r3.g(this.b, r0);
            goto L10
        L7:
            r0 = this.e.b.getText();
        L10:
            if (r6.longValue() >= 2) goto L12;
            this.e.a.setAnimationListener(new q(this));
        L12:
            this.e.a.reset();
            CountDownView r7 = this.e;
            r7.b.startAnimation(r7.a);
        }

        public final void onSubscribe(Disposable r2) {
            this.e.g = r2;
        }

        public a(CountDownView r1, long r2, CountDownView r4, boolean r5, Long r6) {
            this.e = r1;
            this.a = r2;
            this.b = r4;
            this.c = r5;
            this.d = r6;
        }
    }

    public interface b {
        void a();
    }

    public CountDownView(Context r2) {
        super(r2);
        this.f = false;
        this.g = null;
        b(null, 0);
    }

    public static void a(final CountDownView r1) {
        r1.getClass();
        r1.post(new p(r1));
        b r0 = r1.d;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        Disposable r2 = r1.g;
        if (r2 == null) goto L9;
        r2.dispose();
        r1.g = null;
        return;
    }

    public final void c(boolean r10) {
        Long r8 = Long.valueOf(System.currentTimeMillis());
        setFocusableInTouchMode(true);
        r3.p(this);
        final long r4 = ((long) this.e) / 1000;
        Observable.interval(0, 1000, TimeUnit.MILLISECONDS).take(r4 - 1).map(new o(r4)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this, r4, this, r10, r8));
        if (r10 == false) goto L6;
        String r11 = String.valueOf(System.currentTimeMillis() - ((Long) com.bytedance.android.livesdk.sharedpref.b.j.getValue()).longValue());
        HashMap r0 = new HashMap();
        r0.put("duration", r11);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_room_countdown_loading_duration", r0, new Object[0]);
        return;
    }

    public void setCountDownListener(b r1) {
        this.d = r1;
    }

    public void setNeedAccessibility(boolean r1) {
        this.f = r1;
    }

    public void setSubText(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return;
    L6:
        if (this.c != null) goto L8;
        TextView r0 = new TextView(getContext());
        this.c = r0;
        r0.setTextColor(getResources().getColor(2131107181));
        this.c.setTextSize(1, 15.0f);
        this.c.setGravity(17);
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-2, -2);
        r1.gravity = 81;
        r1.bottomMargin = (int) UIUtils.dip2Px(getContext(), 20.0f);
        addView(this.c, r1);
    L8:
        this.c.setVisibility(0);
        this.c.setText(r4);
    }

    public CountDownView(Context r2, AttributeSet r3) {
        super(r2, r3);
        this.f = false;
        this.g = null;
        b(r3, 0);
    }

    public final void b(AttributeSet r6, int r7) {
        TypedArray r8 = getContext().obtainStyledAttributes(r6, new int[]{2130969649}, r7, 0);
        this.e = r8.getInteger(0, 4000);
        r8.recycle();
        Context r9 = getContext();
        TextView r10 = new TextView(getContext());
        this.b = r10;
        r10.setTextColor(getResources().getColor(2131107181));
        this.b.setTextSize(1, 60.0f);
        this.b.setGravity(17);
        FrameLayout.LayoutParams r11 = new FrameLayout.LayoutParams(-2, -2);
        r11.gravity = 17;
        addView(this.b, r11);
        setFocusable(true);
        setClickable(true);
        this.a = AnimationUtils.loadAnimation(r9, 2130772683);
    }

    public CountDownView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.f = false;
        this.g = null;
        b(r2, r3);
    }
}
