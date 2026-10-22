package com.ttnet.org.chromium.base.supplier;

import androidx.annotation.NonNull;
import com.ttnet.org.chromium.base.Callback;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class OneShotCallback<E> {
    private final Callback<E> mCallback;
    private final Callback<E> mCallbackWrapper;
    private final WeakReference<ObservableSupplier<E>> mWeakSupplier;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.base.supplier.OneShotCallback$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class CallbackWrapper implements Callback<E> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final /* synthetic */ OneShotCallback this$0;

        static {
        }

        private CallbackWrapper(OneShotCallback r10) {
            this.this$0 = r10;
        }

        /* synthetic */ CallbackWrapper(OneShotCallback r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // com.ttnet.org.chromium.base.Callback
        public void onResult(E r10) {
            OneShotCallback.access$100(this.this$0).onResult(r10);
            ((ObservableSupplier) OneShotCallback.access$200(this.this$0).get()).removeObserver(OneShotCallback.access$300(this.this$0));
        }
    }

    public OneShotCallback(@NonNull ObservableSupplier<E> r10, @NonNull Callback<E> r11) {
        CallbackWrapper r12 = new CallbackWrapper(this, null);
        this.mCallbackWrapper = r12;
        this.mWeakSupplier = new WeakReference(r10);
        this.mCallback = r11;
        r10.addObserver(r12);
    }

    static /* synthetic */ Callback access$100(OneShotCallback r10) {
        return r10.mCallback;
    }

    static /* synthetic */ WeakReference access$200(OneShotCallback r10) {
        return r10.mWeakSupplier;
    }

    static /* synthetic */ Callback access$300(OneShotCallback r10) {
        return r10.mCallbackWrapper;
    }
}
