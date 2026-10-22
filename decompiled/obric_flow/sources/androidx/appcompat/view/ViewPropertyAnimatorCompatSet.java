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
        Iterator<ViewPropertyAnimatorCompat> r5 = this.mAnimators.iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        r5.next().cancel();
        goto L7
    L9:
        this.mIsStarted = false;
    }

    public void onAnimationsEnded() {
        this.mIsStarted = false;
    }

    public ViewPropertyAnimatorCompatSet play(ViewPropertyAnimatorCompat r5) {
        if (this.mIsStarted == true) goto L5;
        this.mAnimators.add(r5);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompatSet playSequentially(ViewPropertyAnimatorCompat r5, ViewPropertyAnimatorCompat r10) {
        this.mAnimators.add(r5);
        r10.setStartDelay(r5.getDuration());
        this.mAnimators.add(r10);
        return this;
    }

    public ViewPropertyAnimatorCompatSet setDuration(long r5) {
        if (this.mIsStarted == true) goto L5;
        this.mDuration = r5;
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompatSet setInterpolator(Interpolator r5) {
        if (this.mIsStarted == true) goto L5;
        this.mInterpolator = r5;
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompatSet setListener(ViewPropertyAnimatorListener r5) {
        if (this.mIsStarted == true) goto L5;
        this.mListener = r5;
    L5:
        return this;
    }

    public void start() {
        if (this.mIsStarted == false) goto L5;
        return;
    L5:
        Iterator<ViewPropertyAnimatorCompat> r5 = this.mAnimators.iterator();
    L7:
        if (r5.hasNext() == false) goto L18;
        ViewPropertyAnimatorCompat r10 = r5.next();
        long r11 = this.mDuration;
        if (r11 < 0) goto L11;
        r10.setDuration(r11);
    L11:
        Interpolator r12 = this.mInterpolator;
        if (r12 == null) goto L15;
        r10.setInterpolator(r12);
    L15:
        if (this.mListener == null) goto L17;
        r10.setListener(this.mProxyListener);
    L17:
        r10.start();
        goto L7
    L18:
        this.mIsStarted = true;
    }
}
