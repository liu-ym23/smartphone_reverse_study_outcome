package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatSeekBar extends SeekBar {
    private final AppCompatSeekBarHelper mAppCompatSeekBarHelper;

    public AppCompatSeekBar(@NonNull Context r5) {
        this(r5, null);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.mAppCompatSeekBarHelper.drawableStateChanged();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.mAppCompatSeekBarHelper.jumpDrawablesToCurrentState();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas r5) {
        monitor-enter(this);
        super.onDraw(r5);     // Catch: Throwable -> L6
        this.mAppCompatSeekBarHelper.drawTickMarks(r5);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public AppCompatSeekBar(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, R.attr.seekBarStyle);
    }

    public AppCompatSeekBar(@NonNull Context r5, @Nullable AttributeSet r10, int r11) {
        super(r5, r10, r11);
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatSeekBarHelper r12 = new AppCompatSeekBarHelper(this);
        this.mAppCompatSeekBarHelper = r12;
        r12.loadFromAttributes(r10, r11);
    }
}
