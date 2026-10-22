package androidx.dynamicanimation.animation;

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

    public class AnimationCallbackDispatcher {
        final /* synthetic */ AnimationHandler this$0;

        public AnimationCallbackDispatcher(AnimationHandler r5) {
            this.this$0 = r5;
        }

        public void dispatchAnimationFrame() {
            AnimationHandler r5 = this.this$0;
            r5.mCurrentFrameTime = SystemClock.uptimeMillis();
            AnimationHandler r10 = this.this$0;
            r10.doAnimationFrame(r10.mCurrentFrameTime);
            if (this.this$0.mAnimationCallbacks.size() <= 0) goto L6;
            this.this$0.getProvider().postFrameCallback();
            return;
        }
    }

    public interface AnimationFrameCallback {
        boolean doAnimationFrame(long r5);
    }

    public static abstract class AnimationFrameCallbackProvider {
        final AnimationCallbackDispatcher mDispatcher;

        public AnimationFrameCallbackProvider(AnimationCallbackDispatcher r5) {
            this.mDispatcher = r5;
        }

        public abstract void postFrameCallback();
    }

    public static class FrameCallbackProvider14 extends AnimationFrameCallbackProvider {
        private final Handler mHandler;
        long mLastFrameTime;
        private final Runnable mRunnable;

        public FrameCallbackProvider14(AnimationCallbackDispatcher r5) {
            super(r5);
            this.mLastFrameTime = -1;
            this.mRunnable = new AnonymousClass1(this);
            this.mHandler = new Handler(Looper.myLooper());
        }

        @Override // androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallbackProvider
        public void postFrameCallback() {
            long r5 = Math.max(AnimationHandler.FRAME_DELAY_MS - (SystemClock.uptimeMillis() - this.mLastFrameTime), 0);
            this.mHandler.postDelayed(this.mRunnable, r5);
        }
    }

    @RequiresApi(16)
    public static class FrameCallbackProvider16 extends AnimationFrameCallbackProvider {
        private final Choreographer mChoreographer;
        private final Choreographer.FrameCallback mChoreographerCallback;

        public FrameCallbackProvider16(AnimationCallbackDispatcher r5) {
            super(r5);
            this.mChoreographer = Choreographer.getInstance();
            this.mChoreographerCallback = new AnonymousClass1(this);
        }

        @Override // androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallbackProvider
        public void postFrameCallback() {
            this.mChoreographer.postFrameCallback(this.mChoreographerCallback);
        }
    }

    static {
        sAnimatorHandler = new ThreadLocal();
    }

    public AnimationHandler() {
        this.mDelayedCallbackStartTime = new SimpleArrayMap();
        this.mAnimationCallbacks = new ArrayList();
        this.mCallbackDispatcher = new AnimationCallbackDispatcher(this);
        this.mCurrentFrameTime = 0;
        this.mListDirty = false;
    }

    private void cleanUpList() {
        if (this.mListDirty == false) goto L15;
        int r5 = this.mAnimationCallbacks.size() - 1;
    L5:
        if (r5 < 0) goto L10;
        if (this.mAnimationCallbacks.get(r5) != null) goto L9;
        this.mAnimationCallbacks.remove(r5);
    L9:
        r5 = r5 - 1;
        goto L5
    L10:
        this.mListDirty = false;
        return;
    }

    public static long getFrameTime() {
        ThreadLocal<AnimationHandler> r5 = sAnimatorHandler;
        if (r5.get() != null) goto L7;
        return 0;
    L7:
        return r5.get().mCurrentFrameTime;
    }

    public static AnimationHandler getInstance() {
        ThreadLocal<AnimationHandler> r5 = sAnimatorHandler;
        if (r5.get() != null) goto L6;
        r5.set(new AnimationHandler());
    L6:
        return r5.get();
    }

    private boolean isCallbackDue(AnimationFrameCallback r5, long r10) {
        Long r11 = this.mDelayedCallbackStartTime.get(r5);
        if (r11 != null) goto L6;
        return true;
    L6:
        if (r11.longValue() >= r10) goto L9;
        this.mDelayedCallbackStartTime.remove(r5);
        return true;
    L9:
        return false;
    }

    public void addAnimationFrameCallback(AnimationFrameCallback r5, long r10) {
        if (this.mAnimationCallbacks.size() != 0) goto L6;
        getProvider().postFrameCallback();
    L6:
        if (this.mAnimationCallbacks.contains(r5) == true) goto L9;
        this.mAnimationCallbacks.add(r5);
    L9:
        if (r10 <= 0) goto L12;
        this.mDelayedCallbackStartTime.put(r5, Long.valueOf(SystemClock.uptimeMillis() + r10));
        return;
    }

    public void doAnimationFrame(long r10) {
        long r5 = SystemClock.uptimeMillis();
        int r11 = 0;
    L4:
        if (r11 >= this.mAnimationCallbacks.size()) goto L12;
        AnimationFrameCallback r12 = this.mAnimationCallbacks.get(r11);
        if (r12 == null) goto L11;
        if (isCallbackDue(r12, r5) == false) goto L11;
        r12.doAnimationFrame(r10);
    L11:
        r11 = r11 + 1;
        goto L4
    L12:
        cleanUpList();
    }

    public AnimationFrameCallbackProvider getProvider() {
        if (this.mProvider != null) goto L6;
        this.mProvider = new FrameCallbackProvider16(this.mCallbackDispatcher);
    L6:
        return this.mProvider;
    }

    public void removeCallback(AnimationFrameCallback r5) {
        this.mDelayedCallbackStartTime.remove(r5);
        int r10 = this.mAnimationCallbacks.indexOf(r5);
        if (r10 < 0) goto L6;
        this.mAnimationCallbacks.set(r10, null);
        this.mListDirty = true;
        return;
    }

    public void setProvider(AnimationFrameCallbackProvider r5) {
        this.mProvider = r5;
    }
}
