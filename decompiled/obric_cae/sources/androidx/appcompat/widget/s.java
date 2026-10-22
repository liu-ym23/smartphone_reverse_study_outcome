package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import com.obric.cae.R;

/* JADX INFO: loaded from: classes.dex */
public final class s extends RatingBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f1259a;

    public s(Context r8, AttributeSet r10) {
        super(r8, r10, R.attr.ratingBarStyle);
        q0.a(this, getContext());
        q r11 = new q(this);
        this.f1259a = r11;
        r11.a(r10, R.attr.ratingBarStyle);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onMeasure(int r8, int r10) {
        monitor-enter(this);
        super.onMeasure(r8, r10);     // Catch: Throwable -> L8
        Bitmap r11 = this.f1259a.f1247b;     // Catch: Throwable -> L8
        if (r11 == null) goto L6;
        setMeasuredDimension(View.resolveSizeAndState(r11.getWidth() * getNumStars(), r8, 0), getMeasuredHeight());     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
