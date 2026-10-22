package androidx.dynamicanimation.animation;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import androidx.annotation.RequiresApi;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class AnimationHandler {
    private static final long FRAME_DELAY_MS = 10;
    public static final ThreadLocal<AnimationHandler> sAnimatorHandler = null;
    final ArrayList<AnimationFrameCallback> mAnimationCallbacks;
    private final AnimationCallbackDispatcher mCallbackDispatcher;
    long mCurrentFrameTime;
    private final SimpleArrayMap<AnimationFrameCallback, Long> mDelayedCallbackStartTime;
    private boolean mListDirty;
    private AnimationFrameCallbackProvider mProvider;

    class AnimationCallbackDispatcher {
        final /* synthetic */ AnimationHandler this$0;

        AnimationCallbackDispatcher(AnimationHandler r10) {
            this.this$0 = r10;
        }

        void dispatchAnimationFrame() {
            AnimationHandler r10 = this.this$0;
            r10.mCurrentFrameTime = SystemClock.uptimeMillis();
            AnimationHandler r11 = this.this$0;
            r11.doAnimationFrame(r11.mCurrentFrameTime);
            if (this.this$0.mAnimationCallbacks.size() <= 0) goto L6;
            this.this$0.getProvider().postFrameCallback();
            return;
        }
    }

    interface AnimationFrameCallback {
        boolean doAnimationFrame(long r10);
    }

    static abstract class AnimationFrameCallbackProvider {
        final AnimationCallbackDispatcher mDispatcher;

        AnimationFrameCallbackProvider(AnimationCallbackDispatcher r10) {
            this.mDispatcher = r10;
        }

        abstract void postFrameCallback();
    }

    private static class FrameCallbackProvider14 extends AnimationFrameCallbackProvider {
        private final Handler mHandler;
        long mLastFrameTime;
        private final Runnable mRunnable;

        FrameCallbackProvider14(AnimationCallbackDispatcher r10) {
            super(r10);
            this.mLastFrameTime = -1;
            this.mRunnable = new AnonymousClass1(this);
            this.mHandler = new Handler(Looper.myLooper());
        }

        @Override // androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallbackProvider
        void postFrameCallback() {
            long r10 = Math.max(10 - (SystemClock.uptimeMillis() - this.mLastFrameTime), 0);
            this.mHandler.postDelayed(this.mRunnable, r10);
        }
    }

    @RequiresApi(16)
    private static class FrameCallbackProvider16 extends AnimationFrameCallbackProvider {
        private final Choreographer mChoreographer;
        private final Choreographer.FrameCallback mChoreographerCallback;

        FrameCallbackProvider16(AnimationCallbackDispatcher r10) {
            super(r10);
            this.mChoreographer = Choreographer.getInstance();
            this.mChoreographerCallback = new AnonymousClass1(this);
        }

        @Override // androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallbackProvider
        void postFrameCallback() {
            this.mChoreographer.postFrameCallback(this.mChoreographerCallback);
        }
    }

    static {
        sAnimatorHandler = new ThreadLocal();
    }

    AnimationHandler() {
        this.mDelayedCallbackStartTime = new SimpleArrayMap();
        this.mAnimationCallbacks = new ArrayList();
        this.mCallbackDispatcher = new AnimationCallbackDispatcher(this);
        this.mCurrentFrameTime = 0;
        this.mListDirty = false;
    }

    private void cleanUpList() {
        if (this.mListDirty == false) goto L15;
        int r10 = this.mAnimationCallbacks.size() - 1;
    L5:
        if (r10 < 0) goto L10;
        if (this.mAnimationCallbacks.get(r10) != null) goto L9;
        this.mAnimationCallbacks.remove(r10);
    L9:
        r10 = r10 - 1;
        goto L5
    L10:
        this.mListDirty = false;
        return;
    }

    public static long getFrameTime() {
        ThreadLocal<AnimationHandler> r10 = sAnimatorHandler;
        if (r10.get() != null) goto L7;
        return 0;
    L7:
        return r10.get().mCurrentFrameTime;
    }

    public static AnimationHandler getInstance() {
        ThreadLocal<AnimationHandler> r10 = sAnimatorHandler;
        if (r10.get() != null) goto L6;
        r10.set(new AnimationHandler());
    L6:
        return r10.get();
    }

    private boolean isCallbackDue(AnimationFrameCallback r10, long r11) {
        Long r12 = this.mDelayedCallbackStartTime.get(r10);
        if (r12 != null) goto L6;
        return true;
    L6:
        if (r12.longValue() >= r11) goto L9;
        this.mDelayedCallbackStartTime.remove(r10);
        return true;
    L9:
        return false;
    }

    public void addAnimationFrameCallback(AnimationFrameCallback r10, long r11) {
        if (this.mAnimationCallbacks.size() != 0) goto L6;
        getProvider().postFrameCallback();
    L6:
        if (this.mAnimationCallbacks.contains(r10) == true) goto L9;
        this.mAnimationCallbacks.add(r10);
    L9:
        if (r11 <= 0) goto L12;
        this.mDelayedCallbackStartTime.put(r10, Long.valueOf(SystemClock.uptimeMillis() + r11));
        return;
    }

    void doAnimationFrame(long r10) {
        long r11 = SystemClock.uptimeMillis();
        int r12 = 0;
    L4:
        if (r12 >= this.mAnimationCallbacks.size()) goto L12;
        AnimationFrameCallback r13 = this.mAnimationCallbacks.get(r12);
        if (r13 == null) goto L11;
        if (isCallbackDue(r13, r11) == false) goto L11;
        r13.doAnimationFrame(r10);
    L11:
        r12 = r12 + 1;
        goto L4
    L12:
        cleanUpList();
    }

    AnimationFrameCallbackProvider getProvider() {
        if (this.mProvider != null) goto L10;
        if (Build.VERSION.SDK_INT < 16) goto L7;
        AnimationFrameCallbackProvider r10 = new FrameCallbackProvider16(this.mCallbackDispatcher);
    L8:
        this.mProvider = r10;
        goto L10
    L7:
        r10 = new FrameCallbackProvider14(this.mCallbackDispatcher);
    L10:
        return this.mProvider;
    }

    public void removeCallback(AnimationFrameCallback r10) {
        this.mDelayedCallbackStartTime.remove(r10);
        int r11 = this.mAnimationCallbacks.indexOf(r10);
        if (r11 < 0) goto L6;
        this.mAnimationCallbacks.set(r11, null);
        this.mListDirty = true;
        return;
    }

    public void setProvider(AnimationFrameCallbackProvider r10) {
        this.mProvider = r10;
    }
}
