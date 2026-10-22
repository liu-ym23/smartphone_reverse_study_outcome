package androidx.activity;

import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.core.os.BuildCompat;
import androidx.core.util.Consumer;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class OnBackPressedDispatcher {
    private boolean mBackInvokedCallbackRegistered;
    private Consumer<Boolean> mEnabledConsumer;
    private final Runnable mFallbackOnBackPressed;
    private OnBackInvokedDispatcher mInvokedDispatcher;
    private OnBackInvokedCallback mOnBackInvokedCallback;
    final ArrayDeque<OnBackPressedCallback> mOnBackPressedCallbacks;

    static class Api33Impl {
        private Api33Impl() {
        }

        static OnBackInvokedCallback createOnBackInvokedCallback(Runnable r2) {
            final Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin");
            Objects.requireNonNull(r3);
            return new $$Lambda$4ezOK7vdu_oWZDLTTMzgHr1uNF4(r3);
        }

        static void registerOnBackInvokedCallback(Object r2, int r3, Object r4) {
            ((OnBackInvokedDispatcher) ZeusTransformUtils.preCheckCast(r2, OnBackInvokedDispatcher.class, "com.obric.memorydata.plugin")).registerOnBackInvokedCallback(r3, (OnBackInvokedCallback) ZeusTransformUtils.preCheckCast(r4, OnBackInvokedCallback.class, "com.obric.memorydata.plugin"));
        }

        static void unregisterOnBackInvokedCallback(Object r2, Object r3) {
            ((OnBackInvokedDispatcher) ZeusTransformUtils.preCheckCast(r2, OnBackInvokedDispatcher.class, "com.obric.memorydata.plugin")).unregisterOnBackInvokedCallback((OnBackInvokedCallback) ZeusTransformUtils.preCheckCast(r3, OnBackInvokedCallback.class, "com.obric.memorydata.plugin"));
        }
    }

    private class LifecycleOnBackPressedCancellable implements Cancellable, LifecycleEventObserver {
        private Cancellable mCurrentCancellable;
        private final Lifecycle mLifecycle;
        private final OnBackPressedCallback mOnBackPressedCallback;
        final /* synthetic */ OnBackPressedDispatcher this$0;

        LifecycleOnBackPressedCancellable(OnBackPressedDispatcher r1, Lifecycle r2, OnBackPressedCallback r3) {
            this.this$0 = r1;
            this.mLifecycle = r2;
            this.mOnBackPressedCallback = r3;
            r2.addObserver(this);
        }

        @Override // androidx.activity.Cancellable
        public void cancel() {
            this.mLifecycle.removeObserver(this);
            this.mOnBackPressedCallback.removeCancellable(this);
            Cancellable r0 = this.mCurrentCancellable;
            if (r0 == null) goto L6;
            r0.cancel();
            this.mCurrentCancellable = null;
            return;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner r3, Lifecycle.Event r4) {
            LifecycleOwner r5 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r3, LifecycleOwner.class, "com.obric.memorydata.plugin");
            if (r4 != Lifecycle.Event.ON_START) goto L6;
            this.mCurrentCancellable = this.this$0.addCancellableCallback(this.mOnBackPressedCallback);
            return;
        L6:
            if (r4 != Lifecycle.Event.ON_STOP) goto L11;
            Cancellable r2 = this.mCurrentCancellable;
            if (r2 == null) goto L15;
            r2.cancel();
            return;
        L15:
            return;
        L11:
            if (r4 != Lifecycle.Event.ON_DESTROY) goto L17;
            cancel();
            return;
        }
    }

    private class OnBackPressedCancellable implements Cancellable {
        private final OnBackPressedCallback mOnBackPressedCallback;
        final /* synthetic */ OnBackPressedDispatcher this$0;

        OnBackPressedCancellable(OnBackPressedDispatcher r1, OnBackPressedCallback r2) {
            this.this$0 = r1;
            this.mOnBackPressedCallback = r2;
        }

        @Override // androidx.activity.Cancellable
        public void cancel() {
            this.this$0.mOnBackPressedCallbacks.remove(this.mOnBackPressedCallback);
            this.mOnBackPressedCallback.removeCancellable(this);
            if (BuildCompat.isAtLeastT() == false) goto L6;
            this.mOnBackPressedCallback.setIsEnabledConsumer(null);
            this.this$0.updateBackInvokedCallbackState();
            return;
        }
    }

    public OnBackPressedDispatcher() {
        this(null);
    }

    public OnBackPressedDispatcher(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        this.mOnBackPressedCallbacks = new ArrayDeque();
        this.mBackInvokedCallbackRegistered = false;
        this.mFallbackOnBackPressed = r4;
        if (BuildCompat.isAtLeastT() == false) goto L6;
        this.mEnabledConsumer = new $$Lambda$OnBackPressedDispatcher$_OyTAhjGr9tgm4CqoN01pHmhslA(this);
        this.mOnBackInvokedCallback = Api33Impl.createOnBackInvokedCallback(new $$Lambda$BB2RXixjbUYkuwBrUd1f7jRqsko(this));
        return;
    }

    public void addCallback(OnBackPressedCallback r1) {
        addCancellableCallback(r1);
    }

    public void addCallback(LifecycleOwner r3, OnBackPressedCallback r4) {
        Lifecycle r5 = ((LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r3, LifecycleOwner.class, "com.obric.memorydata.plugin")).getLifecycle();
        if (r5.getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        r4.addCancellable(new LifecycleOnBackPressedCancellable(this, r5, r4));
        if (BuildCompat.isAtLeastT() == false) goto L9;
        updateBackInvokedCallbackState();
        r4.setIsEnabledConsumer(this.mEnabledConsumer);
        return;
    }

    Cancellable addCancellableCallback(OnBackPressedCallback r3) {
        this.mOnBackPressedCallbacks.add(r3);
        OnBackPressedCancellable r0 = new OnBackPressedCancellable(this, r3);
        r3.addCancellable(r0);
        if (BuildCompat.isAtLeastT() == false) goto L5;
        updateBackInvokedCallbackState();
        r3.setIsEnabledConsumer(this.mEnabledConsumer);
    L5:
        return r0;
    }

    public boolean hasEnabledCallbacks() {
        Iterator<OnBackPressedCallback> r3 = this.mOnBackPressedCallbacks.descendingIterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (((OnBackPressedCallback) ZeusTransformUtils.preCheckCast(r3.next(), OnBackPressedCallback.class, "com.obric.memorydata.plugin")).isEnabled() == false) goto L4;
        return true;
    L9:
        return false;
    }

    public /* synthetic */ void lambda$new$0$OnBackPressedDispatcher(Boolean r1) {
        if (BuildCompat.isAtLeastT() == false) goto L6;
        updateBackInvokedCallbackState();
        return;
    }

    public void onBackPressed() {
        Iterator<OnBackPressedCallback> r0 = this.mOnBackPressedCallbacks.descendingIterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        OnBackPressedCallback r1 = (OnBackPressedCallback) ZeusTransformUtils.preCheckCast(r0.next(), OnBackPressedCallback.class, "com.obric.memorydata.plugin");
        if (r1.isEnabled() == false) goto L4;
        r1.handleOnBackPressed();
        return;
    L9:
        Runnable r4 = this.mFallbackOnBackPressed;
        if (r4 == null) goto L16;
        r4.run();
        return;
    }

    public void setOnBackInvokedDispatcher(OnBackInvokedDispatcher r3) {
        this.mInvokedDispatcher = (OnBackInvokedDispatcher) ZeusTransformUtils.wrapperContextForParams(r3, OnBackInvokedDispatcher.class, "com.obric.memorydata.plugin");
        updateBackInvokedCallbackState();
    }

    void updateBackInvokedCallbackState() {
        boolean r0 = hasEnabledCallbacks();
        OnBackInvokedDispatcher r1 = this.mInvokedDispatcher;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r0 == true) goto L7;
    L9:
        if (r0 == false) goto L11;
        return;
    L11:
        if (this.mBackInvokedCallbackRegistered == false) goto L17;
        Api33Impl.unregisterOnBackInvokedCallback(r1, this.mOnBackInvokedCallback);
        this.mBackInvokedCallbackRegistered = false;
        return;
    L17:
        return;
    L7:
        if (this.mBackInvokedCallbackRegistered == true) goto L9;
        Api33Impl.registerOnBackInvokedCallback(r1, 0, this.mOnBackInvokedCallback);
        this.mBackInvokedCallbackRegistered = true;
    }
}
