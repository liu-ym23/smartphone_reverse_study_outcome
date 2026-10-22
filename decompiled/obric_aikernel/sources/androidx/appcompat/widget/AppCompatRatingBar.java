package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatRatingBar extends RatingBar {
    private final AppCompatProgressBarHelper mAppCompatProgressBarHelper;

    public AppCompatRatingBar(@NonNull Context r10) {
        this(r10, null);
    }

    public AppCompatRatingBar(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R.attr.ratingBarStyle);
    }

    public AppCompatRatingBar(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatProgressBarHelper r13 = new AppCompatProgressBarHelper(this);
        this.mAppCompatProgressBarHelper = r13;
        r13.loadFromAttributes(r11, r12);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int r10, int r11) {
        monitor-enter(this);
        super.onMeasure(r10, r11);     // Catch: Throwable -> L8
        Bitmap r12 = this.mAppCompatProgressBarHelper.getSampleTile();     // Catch: Throwable -> L8
        if (r12 == null) goto L6;
        setMeasuredDimension(View.resolveSizeAndState(r12.getWidth() * getNumStars(), r10, 0), getMeasuredHeight());     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
