package androidx.appcompat.view;

import android.view.animation.Interpolator;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ViewPropertyAnimatorCompatSet {
    final ArrayList<ViewPropertyAnimatorCompat> mAnimators;
    private long mDuration;
    private Interpolator mInterpolator;
    private boolean mIsStarted;
    ViewPropertyAnimatorListener mListener;
    private final ViewPropertyAnimatorListenerAdapter mProxyListener;

    public ViewPropertyAnimatorCompatSet() {
        this.mDuration = -1;
        this.mProxyListener = new AnonymousClass1(this);
        this.mAnimators = new ArrayList();
    }

    public void cancel() {
        if (this.mIsStarted == true) goto L5;
        return;
    L5:
        Iterator<ViewPropertyAnimatorCompat> r10 = this.mAnimators.iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        r10.next().cancel();
        goto L7
    L9:
        this.mIsStarted = false;
    }

    void onAnimationsEnded() {
        this.mIsStarted = false;
    }

    public ViewPropertyAnimatorCompatSet play(ViewPropertyAnimatorCompat r10) {
        if (this.mIsStarted == true) goto L5;
        this.mAnimators.add(r10);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompatSet playSequentially(ViewPropertyAnimatorCompat r10, ViewPropertyAnimatorCompat r11) {
        this.mAnimators.add(r10);
        r11.setStartDelay(r10.getDuration());
        this.mAnimators.add(r11);
        return this;
    }

    public ViewPropertyAnimatorCompatSet setDuration(long r10) {
        if (this.mIsStarted == true) goto L5;
        this.mDuration = r10;
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompatSet setInterpolator(Interpolator r10) {
        if (this.mIsStarted == true) goto L5;
        this.mInterpolator = r10;
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompatSet setListener(ViewPropertyAnimatorListener r10) {
        if (this.mIsStarted == true) goto L5;
        this.mListener = r10;
    L5:
        return this;
    }

    public void start() {
        if (this.mIsStarted == false) goto L5;
        return;
    L5:
        Iterator<ViewPropertyAnimatorCompat> r10 = this.mAnimators.iterator();
    L7:
        if (r10.hasNext() == false) goto L18;
        ViewPropertyAnimatorCompat r11 = r10.next();
        long r12 = this.mDuration;
        if (r12 < 0) goto L11;
        r11.setDuration(r12);
    L11:
        Interpolator r13 = this.mInterpolator;
        if (r13 == null) goto L15;
        r11.setInterpolator(r13);
    L15:
        if (this.mListener == null) goto L17;
        r11.setListener(this.mProxyListener);
    L17:
        r11.start();
        goto L7
    L18:
        this.mIsStarted = true;
    }
}
