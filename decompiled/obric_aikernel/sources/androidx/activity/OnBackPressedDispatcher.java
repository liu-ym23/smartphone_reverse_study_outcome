package androidx.activity;

import android.annotation.SuppressLint;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.DoNotInline;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.core.os.BuildCompat;
import androidx.core.util.Consumer;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class OnBackPressedDispatcher {
    private boolean mBackInvokedCallbackRegistered;
    private Consumer<Boolean> mEnabledConsumer;

    @Nullable
    private final Runnable mFallbackOnBackPressed;
    private OnBackInvokedDispatcher mInvokedDispatcher;
    private OnBackInvokedCallback mOnBackInvokedCallback;
    final ArrayDeque<OnBackPressedCallback> mOnBackPressedCallbacks;

    @RequiresApi(33)
    static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        static OnBackInvokedCallback createOnBackInvokedCallback(Runnable r10) {
            Objects.requireNonNull(r10);
            return new g(r10);
        }

        @DoNotInline
        static void registerOnBackInvokedCallback(Object r10, int r11, Object r12) {
            ((OnBackInvokedDispatcher) r10).registerOnBackInvokedCallback(r11, (OnBackInvokedCallback) r12);
        }

        @DoNotInline
        static void unregisterOnBackInvokedCallback(Object r10, Object r11) {
            ((OnBackInvokedDispatcher) r10).unregisterOnBackInvokedCallback((OnBackInvokedCallback) r11);
        }
    }

    private class LifecycleOnBackPressedCancellable implements LifecycleEventObserver, Cancellable {

        @Nullable
        private Cancellable mCurrentCancellable;
        private final Lifecycle mLifecycle;
        private final OnBackPressedCallback mOnBackPressedCallback;
        final /* synthetic */ OnBackPressedDispatcher this$0;

        LifecycleOnBackPressedCancellable(@NonNull OnBackPressedDispatcher r10, @NonNull Lifecycle r11, OnBackPressedCallback r12) {
            this.this$0 = r10;
            this.mLifecycle = r11;
            this.mOnBackPressedCallback = r12;
            r11.addObserver(this);
        }

        @Override // androidx.activity.Cancellable
        public void cancel() {
            this.mLifecycle.removeObserver(this);
            this.mOnBackPressedCallback.removeCancellable(this);
            Cancellable r10 = this.mCurrentCancellable;
            if (r10 == null) goto L6;
            r10.cancel();
            this.mCurrentCancellable = null;
            return;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(@NonNull LifecycleOwner r10, @NonNull Lifecycle.Event r11) {
            if (r11 != Lifecycle.Event.ON_START) goto L6;
            this.mCurrentCancellable = this.this$0.addCancellableCallback(this.mOnBackPressedCallback);
            return;
        L6:
            if (r11 != Lifecycle.Event.ON_STOP) goto L11;
            Cancellable r12 = this.mCurrentCancellable;
            if (r12 == null) goto L15;
            r12.cancel();
            return;
        L15:
            return;
        L11:
            if (r11 != Lifecycle.Event.ON_DESTROY) goto L17;
            cancel();
            return;
        }
    }

    private class OnBackPressedCancellable implements Cancellable {
        private final OnBackPressedCallback mOnBackPressedCallback;
        final /* synthetic */ OnBackPressedDispatcher this$0;

        OnBackPressedCancellable(OnBackPressedDispatcher r10, OnBackPressedCallback r11) {
            this.this$0 = r10;
            this.mOnBackPressedCallback = r11;
        }

        @Override // androidx.activity.Cancellable
        @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
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

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public OnBackPressedDispatcher(@Nullable Runnable r10) {
        this.mOnBackPressedCallbacks = new ArrayDeque();
        this.mBackInvokedCallbackRegistered = false;
        this.mFallbackOnBackPressed = r10;
        if (BuildCompat.isAtLeastT() == false) goto L6;
        this.mEnabledConsumer = new e(this);
        this.mOnBackInvokedCallback = Api33Impl.createOnBackInvokedCallback(new f(this));
        return;
    }

    public static /* synthetic */ void a(OnBackPressedDispatcher r10, Boolean r11) {
        r10.lambda$new$0(r11);
    }

    private /* synthetic */ void lambda$new$0(Boolean r10) {
        if (BuildCompat.isAtLeastT() == false) goto L6;
        updateBackInvokedCallbackState();
        return;
    }

    @MainThread
    public void addCallback(@NonNull OnBackPressedCallback r10) {
        addCancellableCallback(r10);
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @SuppressLint({"LambdaLast"})
    @MainThread
    public void addCallback(@NonNull LifecycleOwner r10, @NonNull OnBackPressedCallback r11) {
        Lifecycle r12 = r10.getLifecycle();
        if (r12.getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        r11.addCancellable(new LifecycleOnBackPressedCancellable(this, r12, r11));
        if (BuildCompat.isAtLeastT() == false) goto L9;
        updateBackInvokedCallbackState();
        r11.setIsEnabledConsumer(this.mEnabledConsumer);
        return;
    }

    @NonNull
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @MainThread
    Cancellable addCancellableCallback(@NonNull OnBackPressedCallback r10) {
        this.mOnBackPressedCallbacks.add(r10);
        OnBackPressedCancellable r11 = new OnBackPressedCancellable(this, r10);
        r10.addCancellable(r11);
        if (BuildCompat.isAtLeastT() == false) goto L5;
        updateBackInvokedCallbackState();
        r10.setIsEnabledConsumer(this.mEnabledConsumer);
    L5:
        return r11;
    }

    @MainThread
    public boolean hasEnabledCallbacks() {
        Iterator<OnBackPressedCallback> r10 = this.mOnBackPressedCallbacks.descendingIterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        if (r10.next().isEnabled() == false) goto L4;
        return true;
    L9:
        return false;
    }

    @MainThread
    public void onBackPressed() {
        Iterator<OnBackPressedCallback> r10 = this.mOnBackPressedCallbacks.descendingIterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        OnBackPressedCallback r11 = r10.next();
        if (r11.isEnabled() == false) goto L4;
        r11.handleOnBackPressed();
        return;
    L9:
        Runnable r12 = this.mFallbackOnBackPressed;
        if (r12 == null) goto L16;
        r12.run();
        return;
    }

    @RequiresApi(33)
    public void setOnBackInvokedDispatcher(@NonNull OnBackInvokedDispatcher r10) {
        this.mInvokedDispatcher = r10;
        updateBackInvokedCallbackState();
    }

    @RequiresApi(33)
    void updateBackInvokedCallbackState() {
        boolean r10 = hasEnabledCallbacks();
        OnBackInvokedDispatcher r11 = this.mInvokedDispatcher;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r10 == true) goto L7;
    L9:
        if (r10 == false) goto L11;
        return;
    L11:
        if (this.mBackInvokedCallbackRegistered == false) goto L17;
        Api33Impl.unregisterOnBackInvokedCallback(r11, this.mOnBackInvokedCallback);
        this.mBackInvokedCallbackRegistered = false;
        return;
    L17:
        return;
    L7:
        if (this.mBackInvokedCallbackRegistered == true) goto L9;
        Api33Impl.registerOnBackInvokedCallback(r11, 0, this.mOnBackInvokedCallback);
        this.mBackInvokedCallbackRegistered = true;
    }
}
