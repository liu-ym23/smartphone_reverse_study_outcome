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

    public AppCompatSeekBar(@NonNull Context r10) {
        this(r10, null);
    }

    public AppCompatSeekBar(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R.attr.seekBarStyle);
    }

    public AppCompatSeekBar(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatSeekBarHelper r13 = new AppCompatSeekBarHelper(this);
        this.mAppCompatSeekBarHelper = r13;
        r13.loadFromAttributes(r11, r12);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.mAppCompatSeekBarHelper.drawableStateChanged();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.mAppCompatSeekBarHelper.jumpDrawablesToCurrentState();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas r10) {
        monitor-enter(this);
        super.onDraw(r10);     // Catch: Throwable -> L6
        this.mAppCompatSeekBarHelper.drawTickMarks(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
