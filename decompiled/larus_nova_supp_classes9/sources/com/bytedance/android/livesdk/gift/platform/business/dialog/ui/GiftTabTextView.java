package com.bytedance.android.livesdk.gift.platform.business.dialog.ui;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.bytedance.android.livesdk.gift.configmodel.l;
import com.bytedance.android.livesdk.gift.platform.business.config.GiftConfigKey;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v;
import com.bytedance.android.livesdk.gift.util.b;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import io.reactivex.disposables.Disposable;
import kotlin.Pair;
import nz1.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class GiftTabTextView extends RelativeLayout {
    public static final /* synthetic */ int h = 0;
    public TextView a;
    public ViewSwitcher b;
    public View c;
    public View d;
    public View e;
    public ObjectAnimator f;
    public Disposable g;

    public final void a() {
        Disposable r0 = this.g;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        this.g.dispose();
    L7:
        this.g = null;
    }

    public String getText() {
        TextView r0 = this.a;
        if (r0 != null) goto L5;
        ViewSwitcher r1 = this.b;
        if (r1 != null) goto L9;
        return BuildConfig.FLAVOR;
    L9:
        if (r1.getChildCount() > 0) goto L11;
        return BuildConfig.FLAVOR;
    L11:
        if ((this.b.getChildAt(0) instanceof TextView) == true) goto L13;
        return BuildConfig.FLAVOR;
    L13:
        return ((TextView) this.b.getChildAt(0)).getText().toString();
    L5:
        return r0.getText().toString();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    public GiftTabTextView(Context r2) {
        this(r2, null);
    }

    @Override // android.widget.RelativeLayout
    public void setGravity(int r3) {
        TextView r0 = this.a;
        if (r0 == null) goto L5;
        r0.setGravity(r3);
        return;
    L5:
        ViewSwitcher r1 = this.b;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.getChildCount() > 0) goto L10;
        return;
    L10:
        if ((this.b.getChildAt(0) instanceof TextView) == false) goto L16;
        ((TextView) this.b.getChildAt(0)).setGravity(r3);
        return;
    }

    public void setIsNeedSort(Boolean r2) {
        if (r2.booleanValue() == false) goto L5;
        this.d.setVisibility(0);
        return;
    L5:
        this.d.setVisibility(8);
    }

    public void setIsNeedTopicLabel(Boolean r2) {
        if (this.e != null) goto L5;
        return;
    L5:
        if (r2.booleanValue() == false) goto L7;
        this.e.setVisibility(0);
        return;
    L7:
        this.e.setVisibility(8);
    }

    public void setOrderView(int r2) {
        this.d.setBackgroundResource(r2);
    }

    public void setStatus(int r2) {
        if (r2 != 0) goto L5;
        this.d.setBackgroundResource(2131250705);
        return;
    L5:
        if (r2 != 1) goto L7;
        this.d.setBackgroundResource(2131250689);
        return;
    L7:
        this.d.setBackgroundResource(2131250706);
    }

    public void setText(String r3) {
        TextView r0 = this.a;
        if (r0 == null) goto L5;
        r0.setText(r3);
        return;
    L5:
        ViewSwitcher r1 = this.b;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.getChildCount() > 0) goto L10;
        return;
    L10:
        if ((this.b.getChildAt(0) instanceof TextView) == false) goto L16;
        ((TextView) this.b.getChildAt(0)).setText(r3);
        return;
    }

    public void setTextColor(boolean r6) {
        if (getText().equals("嘉年华") == true) goto L5;
        Pair r0 = (Pair) b.a().c(GiftConfigKey.KEY_GIFT_TAB_TEXT_COLOR, new Pair(2131107552, 2131107551));
        Resources r1 = getContext().getResources();
        if (r6 == false) goto L13;
        Object r7 = r0.getFirst();
    L14:
        setTextColor(r1.getColor(((Integer) r7).intValue()));
        return;
    L13:
        r7 = r0.getSecond();
        goto L14
    L5:
        if (r6 == false) goto L7;
        int r8 = ColorProtector.parseColor(((l) a.V.getValue(null, a.a[46])).a());
    L8:
        setTextColor(r8);
        return;
    L7:
        r8 = ColorProtector.parseColor(((l) a.V.getValue(null, a.a[46])).b());
        goto L8
    }

    public void setTextSize(float r4) {
        TextView r0 = this.a;
        if (r0 == null) goto L5;
        r0.setTextSize(1, r4);
        return;
    L5:
        ViewSwitcher r1 = this.b;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.getChildCount() > 0) goto L10;
        return;
    L10:
        if ((this.b.getChildAt(0) instanceof TextView) == false) goto L16;
        ((TextView) this.b.getChildAt(0)).setTextSize(1, r4);
        return;
    }

    public void setTopicLabelBackground(int r2) {
        View r0 = this.e;
        if (r0 == null) goto L6;
        r0.setBackgroundResource(r2);
        return;
    }

    public void setTopicViewRotation(float r2) {
        View r0 = this.e;
        if (r0 == null) goto L6;
        r0.setRotation(r2);
        return;
    }

    public void setTextColor(int r3) {
        TextView r0 = this.a;
        if (r0 == null) goto L5;
        r0.setTextColor(r3);
        return;
    L5:
        ViewSwitcher r1 = this.b;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.getChildCount() > 0) goto L10;
        return;
    L10:
        if ((this.b.getChildAt(0) instanceof TextView) == false) goto L16;
        ((TextView) this.b.getChildAt(0)).setTextColor(r3);
        return;
    }

    public GiftTabTextView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public final void b(Float r4, Float r5) {
        ObjectAnimator r0 = this.f;
        if (r0 != null) goto L5;
    L7:
        View r1 = this.e;
        if (r1 != null) goto L10;
        return;
    L10:
        ObjectAnimator r6 = ObjectAnimator.ofFloat(r1, "rotation", new float[]{r4.floatValue(), r5.floatValue()});
        this.f = r6;
        r6.setDuration(250);
        this.f.start();
        return;
    L5:
        if (r0.isRunning() == false) goto L7;
        this.f.cancel();
        goto L7
    }

    public GiftTabTextView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        LayoutInflater r4 = LayoutInflater.from(r1);
        if (v.d() == false) goto L5;
        int r5 = 2131566131;
    L6:
        View r6 = r4.inflate(r5, this);
        this.a = (TextView) r6.findViewById(2131383400);
        this.b = (ViewSwitcher) r6.findViewById(2131388042);
        this.c = r6.findViewById(2131383399);
        this.d = r6.findViewById(2131386991);
        this.e = r6.findViewById(2131389259);
        ViewSwitcher r7 = this.b;
        if (r7 == null) goto L9;
        r7.setAnimateFirstView(false);
    L9:
        View r8 = this.d;
        if (r8 != null) goto L12;
        return;
    L12:
        if ((r8.getLayoutParams() instanceof RelativeLayout.LayoutParams) == false) goto L16;
        RelativeLayout.LayoutParams r9 = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
        r9.addRule(13, -1);
        this.d.setLayoutParams(r9);
        return;
    L16:
        return;
    L5:
        r5 = 2131567215;
        goto L6
    }
}
