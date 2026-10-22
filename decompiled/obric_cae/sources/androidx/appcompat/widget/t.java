package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.obric.cae.R;

/* JADX INFO: loaded from: classes.dex */
public class t extends SeekBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f1261a;

    public t(Context r8, AttributeSet r10) {
        this(r8, r10, R.attr.seekBarStyle);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        u r8 = this.f1261a;
        Drawable r10 = r8.f1267e;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isStateful() == false) goto L11;
        SeekBar r11 = r8.f1266d;
        if (r10.setState(r11.getDrawableState()) == false) goto L12;
        r11.invalidateDrawable(r10);
        return;
    L12:
        return;
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable r8 = this.f1261a.f1267e;
        if (r8 == null) goto L6;
        r8.jumpToCurrentState();
        return;
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas r8) {
        monitor-enter(this);
        super.onDraw(r8);     // Catch: Throwable -> L6
        this.f1261a.d(r8);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public t(Context r8, AttributeSet r10, int r11) {
        super(r8, r10, r11);
        q0.a(this, getContext());
        u r12 = new u(this);
        this.f1261a = r12;
        r12.a(r10, r11);
    }
}
