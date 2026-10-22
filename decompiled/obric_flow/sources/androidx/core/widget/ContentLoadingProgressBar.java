package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;

/* JADX INFO: loaded from: classes.dex */
public class ContentLoadingProgressBar extends ProgressBar {
    private static final int MIN_DELAY_MS = 500;
    private static final int MIN_SHOW_TIME_MS = 500;
    private final Runnable mDelayedHide;
    private final Runnable mDelayedShow;
    boolean mDismissed;
    boolean mPostedHide;
    boolean mPostedShow;
    long mStartTime;

    public ContentLoadingProgressBar(@NonNull Context r5) {
        this(r5, null);
    }

    public static /* synthetic */ void a(ContentLoadingProgressBar r5) {
        r5.showOnUiThread();
    }

    public static /* synthetic */ void b(ContentLoadingProgressBar r5) {
        r5.hideOnUiThread();
    }

    public static /* synthetic */ void c(ContentLoadingProgressBar r5) {
        r5.lambda$new$1();
    }

    public static /* synthetic */ void d(ContentLoadingProgressBar r5) {
        r5.lambda$new$0();
    }

    @UiThread
    private void hideOnUiThread() {
        this.mDismissed = true;
        removeCallbacks(this.mDelayedShow);
        this.mPostedShow = false;
        long r5 = System.currentTimeMillis();
        long r10 = this.mStartTime;
        long r11 = r5 - r10;
        if (r11 < 500) goto L5;
    L10:
        setVisibility(8);
        return;
    L5:
        if (r10 == (-1)) goto L10;
        if (this.mPostedHide == true) goto L12;
        postDelayed(this.mDelayedHide, 500 - r11);
        this.mPostedHide = true;
        return;
    }

    private /* synthetic */ void lambda$new$0() {
        this.mPostedHide = false;
        this.mStartTime = -1;
        setVisibility(8);
    }

    private /* synthetic */ void lambda$new$1() {
        this.mPostedShow = false;
        if (this.mDismissed == true) goto L6;
        this.mStartTime = System.currentTimeMillis();
        setVisibility(0);
        return;
    }

    private void removeCallbacks() {
        removeCallbacks(this.mDelayedHide);
        removeCallbacks(this.mDelayedShow);
    }

    @UiThread
    private void showOnUiThread() {
        this.mStartTime = -1;
        this.mDismissed = false;
        removeCallbacks(this.mDelayedHide);
        this.mPostedHide = false;
        if (this.mPostedShow == true) goto L6;
        postDelayed(this.mDelayedShow, 500);
        this.mPostedShow = true;
        return;
    }

    public void hide() {
        post(new a(this, 3));
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        removeCallbacks();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks();
    }

    public void show() {
        post(new a(this, 2));
    }

    public ContentLoadingProgressBar(@NonNull Context r5, @Nullable AttributeSet r10) {
        super(r5, r10, 0);
        this.mStartTime = -1;
        this.mPostedHide = false;
        this.mPostedShow = false;
        this.mDismissed = false;
        this.mDelayedHide = new a(this, 0);
        this.mDelayedShow = new a(this, 1);
    }
}
