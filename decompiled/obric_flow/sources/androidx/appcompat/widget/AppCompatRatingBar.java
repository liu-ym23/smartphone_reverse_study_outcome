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

    public AppCompatRatingBar(@NonNull Context r5) {
        this(r5, null);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int r5, int r10) {
        monitor-enter(this);
        super.onMeasure(r5, r10);     // Catch: Throwable -> L7
        Bitmap r11 = this.mAppCompatProgressBarHelper.getSampleTile();     // Catch: Throwable -> L7
        if (r11 == null) goto L9;
        setMeasuredDimension(View.resolveSizeAndState(r11.getWidth() * getNumStars(), r5, 0), getMeasuredHeight());     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public AppCompatRatingBar(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, R.attr.ratingBarStyle);
    }

    public AppCompatRatingBar(@NonNull Context r5, @Nullable AttributeSet r10, int r11) {
        super(r5, r10, r11);
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatProgressBarHelper r12 = new AppCompatProgressBarHelper(this);
        this.mAppCompatProgressBarHelper = r12;
        r12.loadFromAttributes(r10, r11);
    }
}
