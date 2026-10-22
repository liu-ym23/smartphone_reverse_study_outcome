package androidx.dynamicanimation.animation;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import androidx.collection.SimpleArrayMap;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

        AnimationCallbackDispatcher(AnimationHandler r1) {
            this.this$0 = r1;
        }

        void dispatchAnimationFrame() {
            AnimationHandler r0 = this.this$0;
            r0.mCurrentFrameTime = SystemClock.uptimeMillis();
            AnimationHandler r1 = this.this$0;
            r1.doAnimationFrame(r1.mCurrentFrameTime);
            if (this.this$0.mAnimationCallbacks.size() <= 0) goto L6;
            this.this$0.getProvider().postFrameCallback();
            return;
        }
    }

    interface AnimationFrameCallback {
        boolean doAnimationFrame(long r1);
    }

    static abstract class AnimationFrameCallbackProvider {
        final AnimationCallbackDispatcher mDispatcher;

        AnimationFrameCallbackProvider(AnimationCallbackDispatcher r1) {
            this.mDispatcher = r1;
        }

        abstract void postFrameCallback();
    }

    private static class FrameCallbackProvider14 extends AnimationFrameCallbackProvider {
        private final Handler mHandler;
        long mLastFrameTime;
        private final Runnable mRunnable;

        FrameCallbackProvider14(AnimationCallbackDispatcher r3) {
            super(r3);
            this.mLastFrameTime = -1;
            this.mRunnable = new AnonymousClass1(this);
            this.mHandler = new Handler(Looper.myLooper());
        }

        @Override // androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallbackProvider
        void postFrameCallback() {
            long r0 = Math.max(10 - (SystemClock.uptimeMillis() - this.mLastFrameTime), 0);
            this.mHandler.postDelayed(this.mRunnable, r0);
        }
    }

    private static class FrameCallbackProvider16 extends AnimationFrameCallbackProvider {
        private final Choreographer mChoreographer;
        private final Choreographer.FrameCallback mChoreographerCallback;

        FrameCallbackProvider16(AnimationCallbackDispatcher r1) {
            super(r1);
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
        int r0 = this.mAnimationCallbacks.size() - 1;
    L5:
        if (r0 < 0) goto L10;
        if (this.mAnimationCallbacks.get(r0) != null) goto L9;
        this.mAnimationCallbacks.remove(r0);
    L9:
        r0 = r0 - 1;
        goto L5
    L10:
        this.mListDirty = false;
        return;
    }

    public static long getFrameTime() {
        ThreadLocal<AnimationHandler> r0 = sAnimatorHandler;
        if (r0.get() != null) goto L7;
        return 0;
    L7:
        return ((AnimationHandler) ZeusTransformUtils.preCheckCast(r0.get(), AnimationHandler.class, "com.obric.memorydata.plugin")).mCurrentFrameTime;
    }

    public static AnimationHandler getInstance() {
        ThreadLocal<AnimationHandler> r0 = sAnimatorHandler;
        if (r0.get() != null) goto L6;
        r0.set(new AnimationHandler());
    L6:
        return (AnimationHandler) ZeusTransformUtils.preCheckCast(r0.get(), AnimationHandler.class, "com.obric.memorydata.plugin");
    }

    private boolean isCallbackDue(AnimationFrameCallback r5, long r6) {
        AnimationFrameCallback r7 = (AnimationFrameCallback) ZeusTransformUtils.wrapperContextForParams(r5, AnimationFrameCallback.class, "com.obric.memorydata.plugin");
        Long r0 = (Long) ZeusTransformUtils.preCheckCast(this.mDelayedCallbackStartTime.get(r7), Long.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        return true;
    L6:
        if (r0.longValue() >= r6) goto L9;
        this.mDelayedCallbackStartTime.remove(r7);
        return true;
    L9:
        return false;
    }

    public void addAnimationFrameCallback(AnimationFrameCallback r3, long r4) {
        AnimationFrameCallback r5 = (AnimationFrameCallback) ZeusTransformUtils.wrapperContextForParams(r3, AnimationFrameCallback.class, "com.obric.memorydata.plugin");
        if (this.mAnimationCallbacks.size() != 0) goto L6;
        getProvider().postFrameCallback();
    L6:
        if (this.mAnimationCallbacks.contains(r5) == true) goto L9;
        this.mAnimationCallbacks.add(r5);
    L9:
        if (r4 <= 0) goto L12;
        this.mDelayedCallbackStartTime.put(r5, Long.valueOf(SystemClock.uptimeMillis() + r4));
        return;
    }

    void doAnimationFrame(long r7) {
        long r0 = SystemClock.uptimeMillis();
        int r2 = 0;
    L4:
        if (r2 >= this.mAnimationCallbacks.size()) goto L12;
        AnimationFrameCallback r3 = (AnimationFrameCallback) ZeusTransformUtils.preCheckCast(this.mAnimationCallbacks.get(r2), AnimationFrameCallback.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L11;
        if (isCallbackDue(r3, r0) == false) goto L11;
        r3.doAnimationFrame(r7);
    L11:
        r2 = r2 + 1;
        goto L4
    L12:
        cleanUpList();
    }

    AnimationFrameCallbackProvider getProvider() {
        if (this.mProvider != null) goto L10;
        if (Build.VERSION.SDK_INT < 16) goto L7;
        AnimationFrameCallbackProvider r0 = new FrameCallbackProvider16(this.mCallbackDispatcher);
    L8:
        this.mProvider = r0;
        goto L10
    L7:
        r0 = new FrameCallbackProvider14(this.mCallbackDispatcher);
    L10:
        return this.mProvider;
    }

    public void removeCallback(AnimationFrameCallback r3) {
        AnimationFrameCallback r4 = (AnimationFrameCallback) ZeusTransformUtils.wrapperContextForParams(r3, AnimationFrameCallback.class, "com.obric.memorydata.plugin");
        this.mDelayedCallbackStartTime.remove(r4);
        int r5 = this.mAnimationCallbacks.indexOf(r4);
        if (r5 < 0) goto L6;
        this.mAnimationCallbacks.set(r5, null);
        this.mListDirty = true;
        return;
    }

    public void setProvider(AnimationFrameCallbackProvider r1) {
        this.mProvider = r1;
    }
}
