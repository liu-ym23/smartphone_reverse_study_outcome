package com.bytedance.android.live.revenue.common.utils;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.view.View;
import com.bytedance.android.live.revenue.core.util.e;
import com.bytedance.android.livesdk.revenue.service.performance.d;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class LiveDegradeFpsAnimator extends ValueAnimator {
    private long mFpsConfig;
    private ValueAnimator.AnimatorUpdateListener mMainUpdateListener;
    private ArrayList<ValueAnimator.AnimatorUpdateListener> mUpdateListeners;

    public @interface Method {
    }

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public long a;
        public final /* synthetic */ LiveDegradeFpsAnimator b;

        public a(LiveDegradeFpsAnimator r3) {
            this.b = r3;
            this.a = 0;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r6) {
            if ((this.a % LiveDegradeFpsAnimator.access$000(this.b)) == 0) goto L5;
        L9:
            this.a++;
            return;
        L5:
            if (LiveDegradeFpsAnimator.access$100(this.b) == null) goto L9;
            int r0 = LiveDegradeFpsAnimator.access$100(this.b).size();
            int r1 = 0;
        L7:
            if (r1 >= r0) goto L9;
            ((ValueAnimator.AnimatorUpdateListener) ListProtector.get(LiveDegradeFpsAnimator.access$100(this.b), r1)).onAnimationUpdate(r6);
            r1 = r1 + 1;
            goto L7
        }
    }

    public static /* synthetic */ void a(View r0, String r1, ValueAnimator r2) {
        lambda$ofFloat$0(r0, r1, r2);
    }

    public LiveDegradeFpsAnimator() {
        this.mFpsConfig = 1;
        this.mUpdateListeners = null;
        this.mMainUpdateListener = new a(this);
        long r0 = e.a(d.class).lg();
        if (r0 <= 0) goto L6;
        this.mFpsConfig = r0;
        return;
    }

    @Override // android.animation.ValueAnimator
    public void removeAllUpdateListeners() {
        super.removeAllUpdateListeners();
        ArrayList<ValueAnimator.AnimatorUpdateListener> r0 = this.mUpdateListeners;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.clear();
        this.mUpdateListeners = null;
    }

    public static /* synthetic */ long access$000(LiveDegradeFpsAnimator r2) {
        return r2.mFpsConfig;
    }

    public static /* synthetic */ ArrayList access$100(LiveDegradeFpsAnimator r0) {
        return r0.mUpdateListeners;
    }

    public static LiveDegradeFpsAnimator ofFloat(float... r1) {
        LiveDegradeFpsAnimator r0 = new LiveDegradeFpsAnimator();
        r0.setFloatValues(r1);
        return r0;
    }

    @Override // android.animation.ValueAnimator
    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener r2) {
        if (this.mUpdateListeners != null) goto L5;
        this.mUpdateListeners = new ArrayList();
        super.addUpdateListener(this.mMainUpdateListener);
    L5:
        this.mUpdateListeners.add(r2);
    }

    @Override // android.animation.ValueAnimator
    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener r2) {
        ArrayList<ValueAnimator.AnimatorUpdateListener> r0 = this.mUpdateListeners;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.remove(r2);
        if (this.mUpdateListeners.size() != 0) goto L9;
        super.removeUpdateListener(this.mMainUpdateListener);
        this.mUpdateListeners = null;
        return;
    }

    public LiveDegradeFpsAnimator setFpsConfig(int r3) {
        if (r3 <= 0) goto L4;
        this.mFpsConfig = r3;
    L4:
        return this;
    }

    public static LiveDegradeFpsAnimator ofObject(TypeEvaluator r1, Object... r2) {
        LiveDegradeFpsAnimator r0 = new LiveDegradeFpsAnimator();
        r0.setObjectValues(r2);
        r0.setEvaluator(r1);
        return r0;
    }

    private static void callMethod(View r2, String r3, float r4) {
        if (r2 != null) goto L4;
        return;
    L4:
        r3.getClass();
        byte r1 = -1;
        switch(r3.hashCode()) {
            case -1225497657: goto L24;
            case -1225497656: goto L20;
            case -908189618: goto L16;
            case -908189617: goto L12;
            case 92909918: goto L8;
            default: goto L27;
        };
    L27:
        switch(r1) {
            case 0: goto L33;
            case 1: goto L32;
            case 2: goto L31;
            case 3: goto L30;
            case 4: goto L29;
            default: goto L39;
        };
    L29:
        r2.setAlpha(r4);
        return;
    L30:
        r2.setScaleY(r4);
        return;
    L31:
        r2.setScaleX(r4);
        return;
    L32:
        r2.setTranslationY(r4);
        return;
    L33:
        r2.setTranslationX(r4);
        return;
    L39:
        return;
    L8:
        if (r3.equals("alpha") == false) goto L27;
        r1 = 4;
        goto L27
    L12:
        if (r3.equals("scaleY") == false) goto L27;
        r1 = 3;
        goto L27
    L16:
        if (r3.equals("scaleX") == false) goto L27;
        r1 = 2;
        goto L27
    L20:
        if (r3.equals("translationY") == false) goto L27;
        r1 = 1;
        goto L27
    L24:
        if (r3.equals("translationX") == false) goto L27;
        r1 = 0;
        goto L27
    }

    private static /* synthetic */ void lambda$ofFloat$0(View r0, String r1, ValueAnimator r2) {
        callMethod(r0, r1, ((Float) r2.getAnimatedValue()).floatValue());
    }

    public static LiveDegradeFpsAnimator ofFloat(final View r1, final String r2, float... r3) {
        LiveDegradeFpsAnimator r0 = new LiveDegradeFpsAnimator();
        r0.setFloatValues(r3);
        r0.addUpdateListener(new by0.a(r1, r2));
        return r0;
    }
}
