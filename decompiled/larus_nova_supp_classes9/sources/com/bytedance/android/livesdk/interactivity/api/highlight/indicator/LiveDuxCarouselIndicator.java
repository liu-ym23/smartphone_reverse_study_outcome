package com.bytedance.android.livesdk.interactivity.api.highlight.indicator;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001aB'\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000b¢\u0006\u0004\b\u0018\u0010\u0019R*\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b8\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/highlight/indicator/LiveDuxCarouselIndicator;", "Lcom/bytedance/android/livesdk/interactivity/api/highlight/indicator/DuxBaseIndicator;", BuildConfig.FLAVOR, "value", "k", "F", "getDotsWidthFactor", "()F", "setDotsWidthFactor", "(F)V", "dotsWidthFactor", BuildConfig.FLAVOR, "l", "I", "getSelectedDotColor", "()I", "setSelectedDotColor", "(I)V", "selectedDotColor", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveDuxCarouselIndicator extends DuxBaseIndicator {
    public LinearLayout j;
    public float k;
    public int l;
    public final ArgbEvaluator m;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ LiveDuxCarouselIndicator a;
        public final /* synthetic */ int b;
        public final /* synthetic */ DuxBaseIndicator.a c;

        public b(LiveDuxCarouselIndicator r1, int r2, DuxBaseIndicator.a r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            if (this.a.getDotsClickable() == true) goto L5;
            return;
        L5:
            if (this.b >= this.c.getCount()) goto L9;
            this.c.a(this.b);
            return;
        }
    }

    static {
    }

    public LiveDuxCarouselIndicator(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LiveDuxCarouselIndicator(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.highlight.indicator.DuxBaseIndicator
    public final q32.b b() {
        return new q32.b(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.highlight.indicator.DuxBaseIndicator
    public final void g() {
        LinearLayout r0 = this.j;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
    L5:
        LinearLayout r2 = this.j;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
    L8:
        r0.removeViewAt(r2.getChildCount() - 1);
        ArrayList<View> r1 = this.a;
        ListProtector.remove(r1, r1.size() - 1);
    }

    public final float getDotsWidthFactor() {
        return this.k;
    }

    public final int getSelectedDotColor() {
        return this.l;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.android.livesdk.interactivity.api.highlight.indicator.DuxBaseIndicator
    public final void a(int r7) {
        DuxBaseIndicator.a r0 = getPager();
        if (r0 != null) goto L5;
        return;
    L5:
        ImageView r1 = new ImageView(getContext());
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams((int) getDotsSize(), (int) getDotsSize());
        r2.setMargins((int) getDotsSpacing(), 0, (int) getDotsSpacing(), 0);
        Unit r3 = Unit.INSTANCE;
        r1.setLayoutParams(r2);
        GradientDrawable r4 = new GradientDrawable();
        r4.setCornerRadius(getDotsCornerRadius());
        if (isInEditMode() == false) goto L12;
        if (r7 != 0) goto L9;
        int r5 = this.l;
    L10:
        r4.setColor(r5);
    L16:
        r4.setStroke((int) getDotsStrokeWidth(), getDotsStrokeColor());
        r1.setBackground(r4);
        r1.setOnClickListener(new b(this, r7, r0));
        this.a.add(r1);
        LinearLayout r8 = this.j;
        if (r8 != 0) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
    L19:
        r8.addView(r1);
        return;
    L9:
        r5 = getDotsColor();
        goto L10
    L12:
        if (r0.getCurrentItem() != r7) goto L14;
        int r6 = this.l;
    L15:
        r4.setColor(r6);
        goto L16
    L14:
        r6 = getDotsColor();
        goto L15
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.highlight.indicator.DuxBaseIndicator
    public final void c(int r4) {
        View r0 = (View) ListProtector.get(this.a, r4);
        Drawable r1 = r0.getBackground();
        if ((r1 instanceof GradientDrawable) == true) goto L5;
        r1 = null;
    L5:
        GradientDrawable r2 = (GradientDrawable) r1;
        if (r2 == null) goto L13;
        DuxBaseIndicator.a r3 = getPager();
        if (r3 != null) goto L10;
    L12:
        r2.setColor(getDotsColor());
        goto L13
    L10:
        if (r4 != r3.getCurrentItem()) goto L12;
        r2.setColor(this.l);
    L13:
        if (r2 == null) goto L15;
        r2.setCornerRadius(getDotsCornerRadius());
    L15:
        if (r2 == null) goto L17;
        r2.setStroke((int) getDotsStrokeWidth(), getDotsStrokeColor());
    L17:
        r0.setBackground(r2);
        r0.invalidate();
    }

    public final void setDotsWidthFactor(float r2) {
        if (this.k != r2) goto L5;
        return;
    L5:
        if (r2 >= 1.0f) goto L7;
        r2 = 2.7f;
    L7:
        this.k = r2;
    }

    public final void setSelectedDotColor(int r2) {
        if (this.l == r2) goto L6;
        this.l = r2;
        e();
        return;
    }

    public LiveDuxCarouselIndicator(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.k = 2.7f;
        this.l = -1;
        this.m = new ArgbEvaluator();
        LinearLayout r5 = new LinearLayout(getContext());
        this.j = r5;
        int r6 = 0;
        r5.setOrientation(0);
        LinearLayout r7 = this.j;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
    L5:
        addView(r7, -2, -2);
        if (isInEditMode() == true) goto L8;
        return;
    L8:
        if (r6 >= 5) goto L10;
        a(r6);
        r6 = r6 + 1;
        goto L8
    L10:
        d();
    }

    public /* synthetic */ LiveDuxCarouselIndicator(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
