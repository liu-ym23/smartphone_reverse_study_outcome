package no1;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.animation.Animation;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a extends AppCompatImageView {
    public Animation.AnimationListener a;

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAnimationEnd() {
        super/*android.widget.ImageView*/.onAnimationEnd();
        Animation.AnimationListener r0 = this.a;
        if (r0 == null) goto L6;
        r0.onAnimationEnd(getAnimation());
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAnimationStart() {
        super/*android.widget.ImageView*/.onAnimationStart();
        Animation.AnimationListener r0 = this.a;
        if (r0 == null) goto L6;
        r0.onAnimationStart(getAnimation());
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Context r3) {
        super(r3);
        Resources r4 = getContext().getResources();
        float r5 = WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()).density;
        ShapeDrawable r0 = new ShapeDrawable(new OvalShape());
        ViewCompat.setElevation(this, r5 * 4.0f);
        r0.getPaint().setColor(-328966);
        ViewCompat.setBackground(this, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void draw(Canvas r1) {
        super/*android.widget.ImageView*/.draw(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setBackgroundColor(int r2) {
        if ((getBackground() instanceof ShapeDrawable) == false) goto L6;
        ((ShapeDrawable) getBackground()).getPaint().setColor(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r1, int r2) {
        super/*android.widget.ImageView*/.onMeasure(r1, r2);
    }
}
