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

    public ContentLoadingProgressBar(@NonNull Context r10) {
        this(r10, null);
    }

    public ContentLoadingProgressBar(@NonNull Context r10, @Nullable AttributeSet r11) {
        super(r10, r11, 0);
        this.mStartTime = -1;
        this.mPostedHide = false;
        this.mPostedShow = false;
        this.mDismissed = false;
        this.mDelayedHide = new a(this);
        this.mDelayedShow = new c(this);
    }

    public static /* synthetic */ void a(ContentLoadingProgressBar r10) {
        r10.lambda$new$0();
    }

    public static /* synthetic */ void b(ContentLoadingProgressBar r10) {
        r10.hideOnUiThread();
    }

    public static /* synthetic */ void c(ContentLoadingProgressBar r10) {
        r10.lambda$new$1();
    }

    public static /* synthetic */ void d(ContentLoadingProgressBar r10) {
        r10.showOnUiThread();
    }

    @UiThread
    private void hideOnUiThread() {
        this.mDismissed = true;
        removeCallbacks(this.mDelayedShow);
        this.mPostedShow = false;
        long r10 = System.currentTimeMillis();
        long r11 = this.mStartTime;
        long r12 = r10 - r11;
        if (r12 < 500) goto L5;
    L10:
        setVisibility(8);
        return;
    L5:
        if (r11 == (-1)) goto L10;
        if (this.mPostedHide == true) goto L12;
        postDelayed(this.mDelayedHide, 500 - r12);
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
        post(new b(this));
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
        post(new d(this));
    }
}
